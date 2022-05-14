package by.nikita.data.cards.table.controllers.filters;

import by.nikita.data.cards.table.CarltonSolitaireCardTable;
import by.nikita.data.cards.table.actions.Action;
import by.nikita.data.cards.table.actions.TakeCardsAction;

import static java.lang.Integer.parseInt;

public class TakeCardsActionProcessor extends UserInputProcessor {

    public TakeCardsActionProcessor(CarltonSolitaireCardTable carltonSolitaireCardTable) {
        super(carltonSolitaireCardTable);
    }

    @Override
    public void process(String userInput) {
        userInput = userInput.strip();
        if (userInput.matches("take\\s+from\\s+\\d+\\s+deck\\s+\\d+\\s+cards")) {
            String[] parts = userInput.split("\\s+");
            int deckNumber = parseInt(parts[2]) - 1;
            int numberOfCards = parseInt(parts[4]);

            Action action = new TakeCardsAction(getCarltonSolitaireCardTable(), deckNumber, numberOfCards);
            getCarltonSolitaireCardTable().perform(action);
        } else {
            handleSyntaxError(userInput);
        }
    }
}
