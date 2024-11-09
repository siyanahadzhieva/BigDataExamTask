package com.healthbehavioranalysis;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataProcessor {

    private List<HealthData> healthDataList;

    public DataProcessor(String csvFilePath) {
        healthDataList = new ArrayList<>();
        loadCSVData(csvFilePath);
    }

    private void loadCSVData(String csvFilePath) {
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            String[] line;
            reader.readNext(); // Прескачаме заглавния ред
            while ((line = reader.readNext()) != null) {
                HealthData data = new HealthData(
                        line[0], line[1], line[2], Double.parseDouble(line[3]),
                        Double.parseDouble(line[4]), line[5], Integer.parseInt(line[6]),
                        line[7].equals("Yes"), Integer.parseInt(line[8]), Integer.parseInt(line[9]),
                        line[10].equals("Yes"), Integer.parseInt(line[11]),
                        line[12].equals("Yes"), Integer.parseInt(line[13]),
                        Integer.parseInt(line[14])
                );
                healthDataList.add(data);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }

    public List<HealthData> getHealthDataList() {
        return healthDataList;
    }
}
