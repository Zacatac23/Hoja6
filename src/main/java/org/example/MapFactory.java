package org.example;

import java.util.Scanner;

public class MapFactory {
    public static UserInterface getUserInterface() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione el tipo de mapa (1: HashMap, 2: TreeMap, 3: LinkedHashMap): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                return new CardCollection(); // HashMap
            case 2:
                return new TreeMapUserInterface(); // TreeMap
            case 3:
                return new LinkedHashMapUserInterface(); // LinkedHashMap
            default:
                throw new IllegalArgumentException("Selección no válida");
        }
    }
}


