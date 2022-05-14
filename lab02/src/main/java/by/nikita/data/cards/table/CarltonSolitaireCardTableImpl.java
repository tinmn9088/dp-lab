package by.nikita.data.cards.table;

import by.nikita.data.cards.Card;
import by.nikita.data.cards.table.actions.Action;

import java.util.*;

import static java.util.Collections.*;
import static java.util.Comparator.comparingInt;

public class CarltonSolitaireCardTableImpl implements CarltonSolitaireCardTable {

    private final static int NUMBER_OF_DECKS = 4;

    private final static String CARD_STRING_PLACEHOLDER = "          ";

    private final static String RESULT_DECK_CARD_STRING_PLACEHOLDER = "__________";

    private List<Stack<Card>> resultDecks = new ArrayList<>(NUMBER_OF_DECKS);

    private List<Stack<Card>> decks = new ArrayList<>(NUMBER_OF_DECKS);

    private Stack<Card> reserveDeck = new Stack<>();

    private Stack<Action> history = new Stack<>();

    public CarltonSolitaireCardTableImpl(Collection<Card> cards) {
        for (int i = 0; i < NUMBER_OF_DECKS; i++) {
            resultDecks.add(new Stack<>());
            decks.add(new Stack<>());
        }

        List<Card> cardsList = shuffleDeck(cards);
        int cardNumber = 0;
        int numberOfCards = NUMBER_OF_DECKS;
        for (Stack<Card> deck : decks) {
            for (int i = 0; i < numberOfCards; i++) {
                deck.add(cardsList.get(cardNumber));
                cardNumber++;
            }
            numberOfCards--;
        }

        while (cardNumber < cardsList.size()) {
            reserveDeck.add(cardsList.get(cardNumber));
            cardNumber++;
        }

        System.out.println();
    }

    @Override
    public void print() {
        System.out.print(" [Res. deck]   ");

        { // print result decks
            int resultDecksHeight = getResultDecksHeight();
            List<Iterator<Card>> resultDecksIterators = new ArrayList<>();
            for (Stack<Card> resultDeck : resultDecks) {
                resultDecksIterators.add(resultDeck.iterator());
            }
            for (int row = 0; row < resultDecksHeight; row++) {
                if (row > 0) {
                    System.out.print("               ");
                }
                for (Iterator<Card> cardIterator : resultDecksIterators) {
                    System.out.printf("%1$12s",
                            (cardIterator.hasNext())
                                    ? cardToString(cardIterator.next())
                                    : RESULT_DECK_CARD_STRING_PLACEHOLDER);
                }
                System.out.println();
            }
            System.out.println();
        }

        { // print decks
            int decksHeight = getDecksHeight();
            List<Iterator<Card>> decksIterators = new ArrayList<>();
            for (Stack<Card> deck : decks) {
                decksIterators.add(deck.iterator());
            }
            for (int row = 0; row < decksHeight; row++) {
                System.out.print("               ");
                for (Iterator<Card> cardIterator : decksIterators) {
                    System.out.printf("%1$12s",
                            (cardIterator.hasNext())
                                    ? cardToString(cardIterator.next())
                                    : CARD_STRING_PLACEHOLDER);
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    @Override
    public void perform(Action action) {
        action.perform();
        history.add(action);
    }

    @Override
    public void undoLast() {
        history.pop().undo();
    }

    private List<Card> shuffleDeck(Collection<Card> deck) {
        List<Card> shuffledDeck = list(enumeration(deck));
        shuffle(shuffledDeck);
        return shuffledDeck;
    }

    private String cardToString(Card card) {
        return String.format("[%1$1s %2$4s]", card.getCardSuit().getSymbol(), card.getCardValue().getSymbol());
    }

    private int getResultDecksHeight() {
        int height = max(resultDecks, comparingInt(Stack::size)).size();
        return (height == 0) ? 1 : height;
    }

    private int getDecksHeight() {
        int height = max(decks, comparingInt(Stack::size)).size();
        return (height == 0) ? 1 : height;
    }
}
