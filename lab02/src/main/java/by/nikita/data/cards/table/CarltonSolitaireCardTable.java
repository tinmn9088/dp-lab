package by.nikita.data.cards.table;

import by.nikita.data.cards.table.actions.Action;

public interface CarltonSolitaireCardTable extends SolitaireCardTable {

    void perform(Action action);

    void undoLast();
}
