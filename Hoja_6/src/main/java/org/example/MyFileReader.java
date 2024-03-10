package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MyFileReader {
    private String filePath;

    public MyFileReader(String filePath) {
        this.filePath = filePath;
    }

    public void readCards(CardCollection cardCollection) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 2) {
                    String cardName = parts[0].trim();
                    String cardType = parts[1].trim();
                    cardCollection.addCard(cardName, cardType);
                } else {
                    System.err.println("Invalid data format: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

