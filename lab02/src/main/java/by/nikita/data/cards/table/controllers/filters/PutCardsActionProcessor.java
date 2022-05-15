package by.nikita.data.cards.table.controllers.filters;

import by.nikita.data.cards.Card;
import by.nikita.data.cards.table.CarltonSolitaireCardTable;
import by.nikita.data.cards.table.actions.Action;
import by.nikita.data.cards.table.actions.PutCardsAction;
import by.nikita.data.cards.table.actions.TakeListAction;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.util.Collections.reverse;

public class PutCardsActionProcessor extends UserInputProcessor {

    public PutCardsActionProcessor(CarltonSolitaireCardTable carltonSolitaireCardTable) {
        super(carltonSolitaireCardTable);
    }

    @Override
    public void process(String userInput) {
        userInput = userInput.strip();
        if (userInput.matches("put\\s+to\\s+\\d+\\s+deck")) {
            String[] parts = userInput.split("\\s+");
            int deckNumber = parseInt(parts[2]) - 1;
            List<Card> takenCards = getTakenCards();

            Action action = new PutCardsAction(getCarltonSolitaireCardTable(), deckNumber, takenCards);
            getCarltonSolitaireCardTable().perform(action);
        } else {
            handleSyntaxError(userInput);
        }
    }

    private List<Card> getTakenCards() {
        if (getCarltonSolitaireCardTable().getLastActionPerformed().isEmpty()) {
            return new ArrayList<>();
        }
        if (!(getCarltonSolitaireCardTable().getLastActionPerformed().get() instanceof TakeListAction)) {
            return new ArrayList<>();
        }

        TakeListAction lastAction = (TakeListAction) getCarltonSolitaireCardTable().getLastActionPerformed().get();
        List<Card> takenCards = lastAction.getTaken();
        reverse(takenCards);
        return takenCards;
    }
}
