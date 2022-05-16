package by.nikita.data.cards.table.actions;

import by.nikita.data.cards.Card;
import by.nikita.data.cards.table.CarltonSolitaireCardTable;

import java.util.List;

import static java.util.Collections.reverse;
import static java.util.Objects.requireNonNull;

public class TakeCardsFromReserveAction implements Action {

    private CarltonSolitaireCardTable carltonSolitaireCardTable;

    public TakeCardsFromReserveAction(CarltonSolitaireCardTable carltonSolitaireCardTable) {
        this.carltonSolitaireCardTable = requireNonNull(carltonSolitaireCardTable);
    }

    @Override
    public void perform() {
        carltonSolitaireCardTable.takeCardsFromReserveDeck();
        System.out.println("Cards from reserve deck took");
    }

    @Override
    public void undo() {
        carltonSolitaireCardTable.returnCardsToReserveDeck();
        System.out.println("Cards returned to reserve deck");
    }
}
