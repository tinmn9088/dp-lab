package by.nikita.data.cards.table.actions;

import by.nikita.data.cards.table.CarltonSolitaireCardTable;

public class TakeCardsAction implements Action {

    private int deckNumber;

    private int cardNumber;

    private CarltonSolitaireCardTable carltonSolitaireCardTable;

    public TakeCardsAction(CarltonSolitaireCardTable carltonSolitaireCardTable,
                           int deckNumber,
                           int cardNumber) {
        this.carltonSolitaireCardTable = carltonSolitaireCardTable;
        this.deckNumber = deckNumber;
        this.cardNumber = cardNumber;
    }

    // TODO: implement
    @Override
    public void perform() {
    }

    // TODO: implement
    @Override
    public void undo() {
    }
}
