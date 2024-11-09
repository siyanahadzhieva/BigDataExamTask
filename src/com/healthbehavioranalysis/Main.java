package com.healthbehavioranalysis;

import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Apply FlatLaf Dark theme
        FlatDarkLaf.install();

        // Set custom highlight color to #5A4FF3
        UIManager.put("Component.focusColor", new Color(0x5A4FF3));
        UIManager.put("Button.focusedBorderColor", new Color(0x5A4FF3));
        UIManager.put("ComboBox.selectionBackground", new Color(0x5A4FF3));
        UIManager.put("TextField.selectionBackground", new Color(0x5A4FF3));
        UIManager.put("Table.selectionBackground", new Color(0x5A4FF3));

        // Run the application
        SwingUtilities.invokeLater(() -> {
            DataProcessor processor = new DataProcessor("D:/23.csv"); // Path to your CSV file
            new GUI(processor);
        });
    }
}
