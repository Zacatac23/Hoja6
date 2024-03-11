package org.example;

public interface UserInterface {
    void addCardToCollection(String cardName);
    void showCardType(String cardName);
    void showUserCollection();
    void showSortedUserCollection();
    void showAllCards();
    void showSortedAllCards();

    void addCard(String cardName, String cardType);
}
