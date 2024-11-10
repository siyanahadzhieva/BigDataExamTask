package com.healthbehavioranalysis;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.border.Border;

public class GUI {

    private JFrame frame;
    private JComboBox<String> ageGroupFilter;
    private JComboBox<String> genderFilter;
    private JSlider peerInfluenceFilter;
    private JComboBox<String> calculationType;
    private JButton calculateButton;
    private JButton resetButton;
    private JTextArea resultArea;
    private DataProcessor dataProcessor;

    public GUI(DataProcessor dataProcessor) {
        this.dataProcessor = dataProcessor;
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Health Behavior Analysis");

        try {
            Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Logo.png"));
            frame.setIconImage(icon);
        } catch (Exception e) {
            System.out.println("Icon image not found.");
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 400); // Fixed window size
        frame.setResizable(false);
        frame.setLayout(new GridBagLayout());
        frame.getContentPane().setBackground(new Color(0x161618));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Age Group
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(new JLabel("Age Group:"), gbc);

        ageGroupFilter = new JComboBox<>(new String[]{"All", "15-19", "20-24", "25-29", "30-34"});
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        frame.add(ageGroupFilter, gbc);

        // Gender
        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.EAST;
        frame.add(new JLabel("Gender:"), gbc);


        genderFilter = new JComboBox<>(new String[]{"All", "Male", "Female", "Both"});
        gbc.gridx = 3;
        gbc.anchor = GridBagConstraints.WEST;
        frame.add(genderFilter, gbc);

        // Peer Influence Slider
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        frame.add(new JLabel("Peer Influence (1-10):"), gbc);

        peerInfluenceFilter = new JSlider(1, 10, 5);
        peerInfluenceFilter.setMajorTickSpacing(1);
        peerInfluenceFilter.setPaintTicks(true);
        peerInfluenceFilter.setPaintLabels(true);
        gbc.gridx = 1;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.WEST;
        frame.add(peerInfluenceFilter, gbc);
        gbc.gridwidth = 1;

        // Calculation Type
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        frame.add(new JLabel("Calculation Type:"), gbc);

        calculationType = new JComboBox<>(new String[]{"Average Smoking Prevalence", "Access to Counseling Percentage"});
        gbc.gridx = 1;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.WEST;
        frame.add(calculationType, gbc);

        // Calculate Button
        calculateButton = new JButton("Calculate");
        calculateButton.setBackground(new Color(0x5A4FF3));
        calculateButton.setForeground(Color.WHITE);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        frame.add(calculateButton, gbc);

        // Reset Filters Button
        resetButton = new JButton("Reset Filters");
        resetButton.setForeground(new Color(0x5A4FF3));
        resetButton.setBackground(new Color(0x333333));
        resetButton.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(0x5A4FF3), 1, true),
                BorderFactory.createEmptyBorder(2, 10, 2, 10)
        ));
        gbc.gridx = 2;
        frame.add(resetButton, gbc);

        // Result Area
        resultArea = new JTextArea(10, 40);
        resultArea.setEditable(false);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 4;
        frame.add(new JScrollPane(resultArea), gbc);

        // Add listeners for buttons
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performCalculation();
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ageGroupFilter.setSelectedIndex(0);
                genderFilter.setSelectedIndex(0);
                peerInfluenceFilter.setValue(5);
                calculationType.setSelectedIndex(0);
                resultArea.setText("");
            }
        });

        frame.setVisible(true);
    }

    // Calculation method
    private void performCalculation() {
        String selectedAgeGroup = (String) ageGroupFilter.getSelectedItem();
        String selectedGender = (String) genderFilter.getSelectedItem();
        int selectedPeerInfluence = peerInfluenceFilter.getValue();
        String selectedCalculation = (String) calculationType.getSelectedItem();

        List<HealthData> filteredData = dataProcessor.getHealthDataList().stream()
                .filter(data -> "All".equals(selectedAgeGroup) || data.getAgeGroup().equals(selectedAgeGroup))
                .filter(data -> "All".equals(selectedGender) || data.getGender().equals(selectedGender))
                .filter(data -> data.getPeerInfluence() >= selectedPeerInfluence)
                .collect(Collectors.toList());

        if (filteredData.isEmpty()) {
            resultArea.setText("No data found for the selected criteria.");
            return;
        }

        if ("Average Smoking Prevalence".equals(selectedCalculation)) {
            double average = filteredData.stream()
                    .mapToDouble(HealthData::getSmokingPrevalence)
                    .average()
                    .orElse(0.0);
            resultArea.setText("Average Smoking Prevalence: " + String.format("%.2f", average));
        } else if ("Access to Counseling Percentage".equals(selectedCalculation)) {
            long total = filteredData.size();
            long countWithAccess = filteredData.stream()
                    .filter(HealthData::isAccessToCounseling)
                    .count();
            double percentage = total > 0 ? (countWithAccess * 100.0) / total : 0.0;
            resultArea.setText("Access to Counseling Percentage: " + String.format("%.2f", percentage) + "%");
        }
    }

}

class RoundedBorder implements Border {
    private int radius;
    private Color color;

    RoundedBorder(int radius, Color color) {
        this.radius = radius;
        this.color = color;
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius + 1, this.radius + 1, this.radius + 1, this.radius + 1);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        g2.setStroke(new BasicStroke(2));
        g2.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
    }
}
