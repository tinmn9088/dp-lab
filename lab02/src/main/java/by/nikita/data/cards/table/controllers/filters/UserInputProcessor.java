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

    public CarltonSolitaireCardTable getCarltonSolitaireCardTable() {
        return carltonSolitaireCardTable;
    }

    public void setNext(UserInputProcessor next) {
        this.next = requireNonNull(next);
    }

    protected void handleSyntaxError(String userInput) throws SyntaxProcessException {
        if (getNext() != null) {
            getNext().process(userInput);
        } else {
            throw new SyntaxProcessException(String.format("Syntax error in \"%s\"", userInput));
        }
    }
}
