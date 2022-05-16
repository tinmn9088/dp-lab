package by.nikita.data.cards.table.controllers;

import by.nikita.data.cards.table.CarltonSolitaireCardTable;
import by.nikita.data.cards.table.actions.TakeCardsFromResultDeckAction;
import by.nikita.data.cards.table.controllers.filters.*;

import static java.util.Objects.requireNonNull;

public class CarltonSolitaireControllerImpl implements CarltonSolitaireController {

    private CarltonSolitaireCardTable carltonSolitaireCardTable;

    private UserInputProcessor processor;

    public CarltonSolitaireControllerImpl(CarltonSolitaireCardTable carltonSolitaireCardTable) {
        this.carltonSolitaireCardTable = requireNonNull(carltonSolitaireCardTable);

        TakeCardsActionProcessor takeCardsActionProcessor =
                new TakeCardsActionProcessor(carltonSolitaireCardTable);
        TakeCardsFromReserveActionProcessor takeCardsFromReserveActionProcessor =
                new TakeCardsFromReserveActionProcessor(carltonSolitaireCardTable);
        TakeCardsFromResultDeckActionProcessor takeCardsFromResultDeckActionProcessor =
                new TakeCardsFromResultDeckActionProcessor(carltonSolitaireCardTable);
        PutCardsActionProcessor putCardsActionProcessor =
                new PutCardsActionProcessor(carltonSolitaireCardTable);
        PutCardsToResultDeckActionProcessor putCardsToResultDeckActionProcessor =
                new PutCardsToResultDeckActionProcessor(carltonSolitaireCardTable);
        UndoProcessor undoProcessor =
                new UndoProcessor(carltonSolitaireCardTable);

        takeCardsActionProcessor.setNext(takeCardsFromReserveActionProcessor);
        takeCardsFromReserveActionProcessor.setNext(takeCardsFromResultDeckActionProcessor);
        takeCardsFromResultDeckActionProcessor.setNext(putCardsActionProcessor);
        putCardsActionProcessor.setNext(putCardsToResultDeckActionProcessor);
        putCardsToResultDeckActionProcessor.setNext(undoProcessor);

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
