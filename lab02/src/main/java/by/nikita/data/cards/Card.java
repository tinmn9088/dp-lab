package by.nikita.data.cards;

public class Card {

    private CardSuit cardSuit;

    private CardValue cardValue;

    public Card(CardSuit cardSuit, CardValue cardValue) {
        this.cardSuit = cardSuit;
        this.cardValue = cardValue;
    }

    public CardSuit getCardSuit() {
        return cardSuit;
    }

    public CardValue getCardValue() {
        return cardValue;
    }
}
