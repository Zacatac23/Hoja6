package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

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

        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("Menú:");
            System.out.println("1. Agregar una carta");
            System.out.println("2. Mostrar el tipo de una carta específica");
            System.out.println("3. Mostrar todas las cartas en la colección");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre de la carta: ");
                    String nombreCarta = scanner.next();
                    System.out.print("Ingrese el tipo de la carta: ");
                    String tipoCarta = scanner.next();
                    userInterface.addCard(nombreCarta, tipoCarta);
                    break;
                case 2:
                    // Implementa la lógica para mostrar el tipo de una carta específica
                    break;
                case 3:
                    System.out.println("Cartas en la colección:");
                    userInterface.showAllCards();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione nuevamente.");
            }
        } while (opcion != 0);

        scanner.close();
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

