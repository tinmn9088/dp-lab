package by.nikita.data.cards.table.actions;

import by.nikita.data.cards.Card;
import by.nikita.data.cards.table.CarltonSolitaireCardTable;

import java.util.List;

public class TakeCardsFromResultDeckAction implements Action {

    private CarltonSolitaireCardTable carltonSolitaireCardTable;

    private int deckNumber;

    private int numberOfCardsToTake;

    private List<Card> takenCards;

    public TakeCardsFromResultDeckAction(CarltonSolitaireCardTable carltonSolitaireCardTable,
                                         int deckNumber,
                                         int numberOfCardsToTake) {
        this.carltonSolitaireCardTable = carltonSolitaireCardTable;
        this.deckNumber = deckNumber;
        this.numberOfCardsToTake = numberOfCardsToTake;
    }

    @Override
    public void perform() {
        takenCards = carltonSolitaireCardTable.takeCardsFromResultDeck(deckNumber, numberOfCardsToTake);
        System.out.println(numberOfCardsToTake + " cards taken");
    }

    @Override
    public void undo() {
        carltonSolitaireCardTable.putCardsToResultDeck(deckNumber, takenCards);
        System.out.println(numberOfCardsToTake + " cards put");
    }
}
