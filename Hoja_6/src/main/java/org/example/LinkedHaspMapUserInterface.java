package org.example;
import java.util.LinkedHashMap;
import java.util.Map;
class LinkedHashMapUserInterface extends CardCollection {
    // Implementación específica para LinkedHashMap
    @Override
    public void addCardToCollection(String cardName) {
        Card card = allCards.get(cardName);
        if (card != null) {
            // Agregar la carta a la colección del usuario
            // Actualizar la cantidad si ya existe en la colección
            userCards.merge(cardName, 1, Integer::sum);
        } else {
            System.out.println("Error: La carta no se encuentra entre las cartas disponibles.");
        }
    }

    @Override
    public void showUserCollection() {
        // Mostrar el nombre, tipo y cantidad de cada carta en la colección del usuario
        for (Map.Entry<String, Integer> entry : userCards.entrySet()) {
            String cardName = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(cardName + " - Tipo: " + allCards.get(cardName).getType() + " - Cantidad: " + quantity);
        }
    }

    @Override
    public void showSortedUserCollection() {
        // Mostrar el nombre, tipo y cantidad de cada carta ordenadas por tipo
        Map<String, Integer> sortedUserCards = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : userCards.entrySet()) {
String cardName = entry.getKey();
            int quantity = entry.getValue();
            sortedUserCards.put(allCards.get(cardName).getType() + " - " + cardName, quantity);
        }
        for (Map.Entry<String, Integer> entry : sortedUserCards.entrySet()) {
            System.out.println(entry.getKey() + " - Cantidad: " + entry.getValue());
        }
    }
}