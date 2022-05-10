package by.nikita.data.cards;

import java.util.HashSet;
import java.util.Set;

public class CardsFactory {

    public Set<Card> createDeckOfCards() {
        Set<Card> deck = new HashSet<>(52);

        for (CardSuit suit : CardSuit.values()) {
            for (CardValue value : CardValue.values()) {
                deck.add(new Card(suit, value));
            }
        }

        return deck;
    }
}
