package by.nikita.data.cards.table.actions;

import by.nikita.data.cards.Card;
import by.nikita.data.cards.table.CarltonSolitaireCardTable;

import java.util.List;

import static java.util.Objects.requireNonNull;

public class TakeCardsFromReserveAction implements TakeListAction {

    private CarltonSolitaireCardTable carltonSolitaireCardTable;

    private int numberOfCardsToTake;

    private List<Card> takenCards;

    /**
     * @param numberOfCardsToTake positive number
     * @throws IllegalArgumentException if number of cards to take is non-positive
     */
    public TakeCardsFromReserveAction(CarltonSolitaireCardTable carltonSolitaireCardTable, int numberOfCardsToTake) {
        this.carltonSolitaireCardTable = requireNonNull(carltonSolitaireCardTable);
        if (numberOfCardsToTake <= 0) {
            throw new IllegalArgumentException("Illegal number of cards: " + numberOfCardsToTake);
        }
        this.numberOfCardsToTake = numberOfCardsToTake;
    }

    @Override
    public void perform() {
        takenCards = carltonSolitaireCardTable.takeCardsFromReserveDeck(numberOfCardsToTake);
        System.out.println(takenCards.size() + " cards taken");
    }

    @Override
    public void undo() {
        carltonSolitaireCardTable.putCardsToReserveDeck(takenCards);
        System.out.println(takenCards.size() + " cards put");
    }

    @Override
    public List<Card> getTaken() {
        return takenCards;
    }
}
