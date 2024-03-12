package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Obtener la implementación del mapa seleccionada por el usuario
        Scanner scanner;
        UserInterface userInterface = MapFactory.returnType();
        // Leer las cartas desde el archivo y agregarlas al mapa
        readCardsFromFile(userInterface);

        userInterface.addCardToCollection("Carta 1");
        userInterface.showCardType("Carta 1");
        userInterface.showUserCollection();
        userInterface.showSortedUserCollection();
        userInterface.showAllCards();
        userInterface.showSortedAllCards();


        int opcion;
        do {
            scanner = new Scanner(System.in);
            System.out.println("Menú:");
            System.out.println("1. Agregar una carta a la colección");
            System.out.println("2. Mostrar tipo de carta a base de nombre.");
            System.out.println("3. Mostrar el nombre, tipo y cantidad de cada carta en la colección.");
            System.out.println("4. Mostrar el nombre, tipo y cantidad de cada carta en la colección, ordenadas por tipo.");
            System.out.println("5. Mostrar el nombre y tipo de todas las cartas existentes.");
            System.out.println("6. Mostrar el nombre y tipo de todas las cartas existentes, ordenadas por tipo.");

            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            String nombreCarta;
            String tipoCarta;


            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre de la carta: ");
                    nombreCarta = scanner.next();
                    userInterface.addCardToCollection(nombreCarta);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre de la carta: ");
                    nombreCarta = scanner.next();
                    userInterface.showCardType(nombreCarta);
                    break;
                case 3:
                    System.out.println("Cartas en la colección:");
                    userInterface.showUserCollection();
                    break;
                case 4:
                    System.out.println("Cartas en la colección ordenadas por tipo:");
                    userInterface.showSortedUserCollection();
                    break;
                case 5:
                    System.out.println("Cartas totales:");
                    userInterface.showAllCards();
                    break;
                case 6:
                    System.out.println("Cartas totales ordenadas por tipo:");
                    userInterface.showSortedAllCards();
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
                    userInterface.addCard(cardName, cardType);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

