package by.nikita.data.cards.table.controllers;

import by.nikita.data.cards.table.CarltonSolitaireCardTable;
import by.nikita.data.cards.table.controllers.filters.SyntaxProcessException;
import by.nikita.data.cards.table.controllers.filters.TakeCardsActionProcessor;
import by.nikita.data.cards.table.controllers.filters.TakeCardsFromReserveActionProcessor;
import by.nikita.data.cards.table.controllers.filters.UserInputProcessor;

import static java.util.Objects.requireNonNull;

public class CarltonSolitaireControllerImpl implements CarltonSolitaireController {

    private CarltonSolitaireCardTable carltonSolitaireCardTable;

    private UserInputProcessor processor;

    public CarltonSolitaireControllerImpl(CarltonSolitaireCardTable carltonSolitaireCardTable) {
        this.carltonSolitaireCardTable = requireNonNull(carltonSolitaireCardTable);

        TakeCardsActionProcessor takeCardsActionProcessor = new TakeCardsActionProcessor(carltonSolitaireCardTable);
        TakeCardsFromReserveActionProcessor takeCardsFromReserveActionProcessor = new TakeCardsFromReserveActionProcessor(carltonSolitaireCardTable);

        takeCardsActionProcessor.setNext(takeCardsFromReserveActionProcessor);

        this.processor = takeCardsActionProcessor;
    }

    @Override
    public void process(String userInput) {
        try {
            processor.process(userInput);
        } catch (SyntaxProcessException | IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            System.out.println();
        }
    }
}
