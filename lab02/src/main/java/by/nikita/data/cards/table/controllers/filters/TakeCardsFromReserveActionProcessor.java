package by.nikita.data.cards.table.controllers.filters;

import by.nikita.data.cards.table.CarltonSolitaireCardTable;
import by.nikita.data.cards.table.actions.Action;
import by.nikita.data.cards.table.actions.TakeCardsAction;
import by.nikita.data.cards.table.actions.TakeCardsFromReserveAction;

import static java.lang.Integer.parseInt;

public class TakeCardsFromReserveActionProcessor extends UserInputProcessor {

    public TakeCardsFromReserveActionProcessor(CarltonSolitaireCardTable carltonSolitaireCardTable) {
        super(carltonSolitaireCardTable);
    }

    @Override
    public void process(String userInput) {
        userInput = userInput.strip();
        if (userInput.matches("take\\s+from\\s+reserve\\s+deck")) {
            Action action = new TakeCardsFromReserveAction(getCarltonSolitaireCardTable());
            getCarltonSolitaireCardTable().perform(action);
        } else {
            handleSyntaxError(userInput);
        }
    }
}
