package by.nikita.data.cards.table.actions;

import by.nikita.data.cards.Card;
import by.nikita.data.cards.table.CarltonSolitaireCardTable;

import java.util.List;

import static java.util.Objects.requireNonNull;

public class PutCardsAction implements Action {

    private CarltonSolitaireCardTable carltonSolitaireCardTable;

    private int deckNumber;

    private List<Card> takenCards;

    public PutCardsAction(CarltonSolitaireCardTable carltonSolitaireCardTable, int deckNumber,
                          List<Card> takenCards) {
        this.carltonSolitaireCardTable = carltonSolitaireCardTable;
        this.deckNumber = deckNumber;
        this.takenCards = requireNonNull(takenCards);
    }

    @Override
    public void perform() {
        carltonSolitaireCardTable.putCardsToDeck(deckNumber, takenCards);
        System.out.println("Cards put in deck " + deckNumber);
    }

    @Override
    public void undo() {
        carltonSolitaireCardTable.setValidated(false);
        carltonSolitaireCardTable.takeCardsFromDeck(deckNumber, takenCards.size());
        carltonSolitaireCardTable.setValidated(true);
        System.out.println("Cards taken from deck " + deckNumber);
    }
}
