package by.nikita.data.cards.table.controllers.filters;

import by.nikita.data.cards.table.CarltonSolitaireCardTable;

public class UndoProcessor extends UserInputProcessor {

    public UndoProcessor(CarltonSolitaireCardTable carltonSolitaireCardTable) {
        super(carltonSolitaireCardTable);
    }

    @Override
    public void process(String userInput) {
        userInput = userInput.strip();
        if (userInput.equalsIgnoreCase("undo")) {
            getCarltonSolitaireCardTable().undoLast();
        } else {
            handleSyntaxError(userInput);
        }
    }
}
