package by.nikita.data.cards.table.controllers;

import by.nikita.data.cards.table.CarltonSolitaireCardTable;
import by.nikita.data.cards.table.controllers.filters.UserInputProcessor;

import static java.util.Objects.requireNonNull;

public class CarltonSolitaireControllerImpl implements CarltonSolitaireController {

    private CarltonSolitaireCardTable carltonSolitaireCardTable;

    private UserInputProcessor processor;

    public CarltonSolitaireControllerImpl(CarltonSolitaireCardTable carltonSolitaireCardTable) {
        this.carltonSolitaireCardTable = requireNonNull(carltonSolitaireCardTable);
    }

    @Override
    public void process(String userInput) {
        processor.process(userInput);
    }
}
