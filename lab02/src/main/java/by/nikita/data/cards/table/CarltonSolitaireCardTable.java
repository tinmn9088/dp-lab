package by.nikita.data.cards.table;

import by.nikita.data.cards.Card;
import by.nikita.data.cards.table.actions.Action;

import java.util.Collection;
import java.util.List;

public interface CarltonSolitaireCardTable extends SolitaireCardTable {

    void perform(Action action);

    void undoLast();

    List<Card> takeCardsFromReserveDeck(int numberOfCardsToTake);

    List<Card> takeCardsFromDeck(int deckNumber, int numberOfCardsToTake);

    void putCardsToReserveDeck(Collection<Card> cards);

    void putCardsToDeck(int deckNumber, Collection<Card> cards);
}
