package com.healthbehavioranalysis;

import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        FlatDarkLaf.install();

        UIManager.put("Component.focusColor", new Color(0x5A4FF3));
        UIManager.put("Button.focusedBorderColor", new Color(0x5A4FF3));
        UIManager.put("ComboBox.selectionBackground", new Color(0x5A4FF3));
        UIManager.put("TextField.selectionBackground", new Color(0x5A4FF3));
        UIManager.put("Table.selectionBackground", new Color(0x5A4FF3));

        SwingUtilities.invokeLater(() -> {
            DataProcessor processor = new DataProcessor("D:/23.csv"); // Path to CSV file
            new GUI(processor);
        });
    }
}
