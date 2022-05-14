package by.nikita.data.cards.table.actions;

import by.nikita.data.cards.Card;
import by.nikita.data.cards.table.CarltonSolitaireCardTable;

import java.util.List;

public class TakeCardsAction implements Action {

    private CarltonSolitaireCardTable carltonSolitaireCardTable;

    private int deckNumber;

    private int numberOfCardsToTake;

    private List<Card> takenCards;

    public TakeCardsAction(CarltonSolitaireCardTable carltonSolitaireCardTable,
                           int deckNumber,
                           int numberOfCardsToTake) {
        this.carltonSolitaireCardTable = carltonSolitaireCardTable;
        this.deckNumber = deckNumber;
        this.numberOfCardsToTake = numberOfCardsToTake;
    }

    @Override
    public void perform() {
        takenCards = carltonSolitaireCardTable.takeCardsFromDeck(deckNumber, numberOfCardsToTake);
        System.out.println(numberOfCardsToTake + " cards taken");
    }

    @Override
    public void undo() {
        carltonSolitaireCardTable.putCardsToDeck(deckNumber, takenCards);
        System.out.println(numberOfCardsToTake + " cards put");
    }
}
