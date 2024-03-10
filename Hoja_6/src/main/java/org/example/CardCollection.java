package org.example;
import java.util.HashMap;
import java.util.Map;

public class CardCollection implements UserInterface {
    protected Map<String, Integer> userCards = new HashMap<>();
    protected Map<String, Card> allCards = new HashMap<>();

    @Override
    public void addCardToCollection(String cardName) {
        Card card = allCards.get(cardName);
        if (card != null) {
            // Agregar la carta a la colección del usuario
            // Actualizar la cantidad si ya existe en la colección
            userCards.put(cardName, userCards.getOrDefault(cardName, 0) + 1);
        } else {
            System.out.println("Error: La carta no se encuentra entre las cartas disponibles.");
        }
    }

    @Override
    public void showCardType(String cardName) {
        Card card = allCards.get(cardName);
        if (card != null) {
            System.out.println("Tipo de la carta '" + cardName + "': " + card.getType());
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
        Map<String, Integer> sortedUserCards = new HashMap<>();
        for (Map.Entry<String, Integer> entry : userCards.entrySet()) {
            String cardName = entry.getKey();
            int quantity = entry.getValue();
            sortedUserCards.put(allCards.get(cardName).getType() + " - " + cardName, quantity);
        }
        for (Map.Entry<String, Integer> entry : sortedUserCards.entrySet()) {
            System.out.println(entry.getKey() + " - Cantidad: " + entry.getValue());
        }
    }

    @Override
    public void showAllCards() {
        // Mostrar el nombre y tipo de todas las cartas existentes
        for (Card card : allCards.values()) {
            System.out.println("Nombre: " + card.getName() + " - Tipo: " + card.getType());
        }
    }

    @Override
    public void showSortedAllCards() {
        // Mostrar el nombre y tipo de todas las cartas existentes ordenadas por tipo
        Map<String, Card> sortedAllCards = new HashMap<>();
        for (Card card : allCards.values()) {
            sortedAllCards.put(card.getType() + " - " + card.getName(), card);
        }
        for (Card card : sortedAllCards.values()) {
            System.out.println("Nombre: " + card.getName() + " - Tipo: " + card.getType());
        }
    }

    // Método para agregar una carta al conjunto de todas las cartas disponibles
    public void addCard(String cardName, String cardType) {
        Card card = new Card(cardName, cardType);
        allCards.put(cardName, card);
    }
}

