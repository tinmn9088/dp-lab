package by.nikita.data.cards.table;

import by.nikita.data.cards.Card;
import by.nikita.data.cards.table.actions.Action;

import java.util.List;
import java.util.Optional;

public interface CarltonSolitaireCardTable extends SolitaireCardTable {

    void perform(Action action);

    void undoLast();

    void setValidated(boolean validated);

    Optional<Action> getLastActionPerformed();

    void takeCardsFromReserveDeck();

    List<Card> takeCardsFromDeck(int deckNumber, int numberOfCardsToTake);

    List<Card> takeCardsFromResultDeck(int deckNumber, int numberOfCardsToTake);

    void returnCardsToReserveDeck();

    void putCardsToDeck(int deckNumber, List<Card> cards);

    void putCardsToResultDeck(int deckNumber, List<Card> cards);
}
