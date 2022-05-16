package by.nikita.data.cards.table.actions;

import by.nikita.data.cards.Card;
import by.nikita.data.cards.table.CarltonSolitaireCardTable;

import java.util.List;

import static java.util.Collections.reverse;

public class TakeCardsAction implements TakeListAction {

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
        System.out.println(takenCards.size() + " cards taken");
    }

    @Override
    public void undo() {
        reverse(takenCards);
        carltonSolitaireCardTable.setValidated(false);
        carltonSolitaireCardTable.putCardsToDeck(deckNumber, takenCards);
        carltonSolitaireCardTable.setValidated(true);
        System.out.println(takenCards.size() + " cards put");
        takenCards.clear();
    }

    @Override
    public List<Card> getTaken() {
        return takenCards;
    }
}
