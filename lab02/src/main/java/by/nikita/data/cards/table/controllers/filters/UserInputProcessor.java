package by.nikita.data.cards.table.controllers.filters;

import by.nikita.data.cards.table.CarltonSolitaireCardTable;

import static java.util.Objects.requireNonNull;

public abstract class UserInputProcessor {

    private UserInputProcessor next;

    private CarltonSolitaireCardTable carltonSolitaireCardTable;

    public UserInputProcessor(CarltonSolitaireCardTable carltonSolitaireCardTable) {
        this.carltonSolitaireCardTable = requireNonNull(carltonSolitaireCardTable);
    }

    public abstract void process(String userInput);

    public UserInputProcessor getNext() {
        return next;
    }

    public void setNext(UserInputProcessor next) {
        this.next = requireNonNull(next);
    }
}
