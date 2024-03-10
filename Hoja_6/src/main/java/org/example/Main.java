package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        // Obtener la implementación del mapa seleccionada por el usuario
        UserInterface userInterface = new CardCollection();

        // Leer las cartas desde el archivo y agregarlas al mapa
        readCardsFromFile(userInterface);

        // Interacción con el usuario
        // ...

        // Ejemplo de uso de las operaciones de la interfaz
        userInterface.addCardToCollection("Carta 1");
        userInterface.showCardType("Carta 1");
        userInterface.showUserCollection();
        userInterface.showSortedUserCollection();
        userInterface.showAllCards();
        userInterface.showSortedAllCards();
    }

    private static void readCardsFromFile(UserInterface userInterface) {
        String fileName = "cards_desc.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 2) {
                    String cardName = parts[0].trim();
                    String cardType = parts[1].trim();
                    userInterface.addCardToCollection(cardName);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

