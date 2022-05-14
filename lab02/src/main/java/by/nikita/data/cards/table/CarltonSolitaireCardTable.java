package by.nikita.data.cards.table;

import by.nikita.data.cards.Card;
import by.nikita.data.cards.table.actions.Action;

import java.util.List;

public interface CarltonSolitaireCardTable extends SolitaireCardTable {

    void perform(Action action);

    void undoLast();

    List<Card> takeCardsFromReserveDeck(int numberOfCardsToTake);

    List<Card> takeCardsFromDeck(int deckNumber, int numberOfCardsToTake);

    List<Card> takeCardsFromResultDeck(int deckNumber, int numberOfCardsToTake);

    void putCardsToReserveDeck(List<Card> cards);

    void putCardsToDeck(int deckNumber, List<Card> cards);

    void putCardsToResultDeck(int deckNumber, List<Card> cards);
}
