package by.nikita.data.cards.table;

import by.nikita.data.cards.Card;
import by.nikita.data.cards.CardSuit;
import by.nikita.data.cards.CardValue;
import by.nikita.data.cards.table.actions.Action;

import java.util.*;

import static java.lang.String.format;
import static java.util.Collections.*;
import static java.util.Comparator.comparingInt;
import static java.util.Objects.requireNonNull;

public class CarltonSolitaireCardTableImpl implements CarltonSolitaireCardTable {

    private final static int NUMBER_OF_DECKS = 4;

    private final static String WHITESPACE = "        ";

    private final static String RESULT_DECK_CARD_STRING_PLACEHOLDER = "________";

    private final static String ANSI_RED = "\u001B[31m";

    private final static String ANSI_BLACK = "\u001B[30m";

    private final static String ANSI_RESET = "\u001B[0m";

    private List<Stack<Card>> resultDecks = new ArrayList<>(NUMBER_OF_DECKS);

    private List<Stack<Card>> decks = new ArrayList<>(NUMBER_OF_DECKS);

    private Stack<Card> reserveDeck = new Stack<>();

    private Stack<Action> history = new Stack<>();

    private boolean validated = false;

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
                    System.out.printf("%s  ",
                            (cardIterator.hasNext())
                                    ? cardToString(cardIterator.next())
                                    : (row == 0)
                                            ? RESULT_DECK_CARD_STRING_PLACEHOLDER
                                            : WHITESPACE);
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
                    System.out.printf("%s  ",
                            (cardIterator.hasNext())
                                    ? cardToString(cardIterator.next())
                                    : WHITESPACE);
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

    @Override
    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    @Override
    public Optional<Action> getLastActionPerformed() {
        if (history.size() < 1) {
            return Optional.empty();
        }
        return Optional.of(history.peek());
    }

    /**
     * @param numberOfCardsToTake positive number
     * @return list of cards with size <= to number of cards to take
     * @throws IllegalArgumentException if number of cards to take is non-positive
     */
    @Override
    public List<Card> takeCardsFromReserveDeck(int numberOfCardsToTake) throws IllegalArgumentException {
        if (validated) {
            validateNumberOfCards(numberOfCardsToTake);
        }

        List<Card> takenCards = new ArrayList<>(numberOfCardsToTake);
        for (int i = 0; reserveDeck.size() > 0 && i < numberOfCardsToTake; i++) {
            takenCards.add(reserveDeck.pop());
        }

        return takenCards;
    }

    @Override
    public List<Card> takeCardsFromDeck(int deckNumber, int numberOfCardsToTake) throws IllegalArgumentException {
        if (validated) {
            validateDeckNumber(deckNumber);
            validateNumberOfCards(numberOfCardsToTake);
        }

        List<Card> takenCards = new ArrayList<>(numberOfCardsToTake);
        Stack<Card> deck = decks.get(deckNumber);
        for (int i = 0; deck.size() > 0 && i < numberOfCardsToTake; i++) {
            takenCards.add(deck.pop());
        }
        return takenCards;
    }

    @Override
    public List<Card> takeCardsFromResultDeck(int deckNumber, int numberOfCardsToTake) throws IllegalArgumentException {
        if (validated) {
            validateDeckNumber(deckNumber);
            validateNumberOfCards(numberOfCardsToTake);
        }

        List<Card> takenCards = new ArrayList<>(numberOfCardsToTake);
        Stack<Card> deck = resultDecks.get(deckNumber);
        for (int i = 0; deck.size() > 0 && i < numberOfCardsToTake; i++) {
            takenCards.add(deck.pop());
        }

        return takenCards;
    }

    @Override
    public void putCardsToReserveDeck(List<Card> cards) {
        if (validated) {
            validateCardsToPut(cards);
        }
        reserveDeck.addAll(cards);
    }

    @Override
    public void putCardsToDeck(int deckNumber, List<Card> cards) throws IllegalArgumentException {
        if (validated) {
            validateDeckNumber(deckNumber);
            if (decks.get(deckNumber).size() > 0) {
                validateCardsToPut(decks.get(deckNumber).peek(), cards);
            } else {
                validateCardsToPut(cards);
            }
        }
        decks.get(deckNumber).addAll(cards);
    }

    @Override
    public void putCardsToResultDeck(int deckNumber, List<Card> cards) throws IllegalArgumentException {
        if (validated) {
            validateDeckNumber(deckNumber);
            if (resultDecks.get(deckNumber).size() > 0) {
                validateCardsToPutInResultDeck(resultDecks.get(deckNumber).peek(), cards);
            } else {
                validateCardsToPutInResultDeck(cards);
            }
        }
        resultDecks.get(deckNumber).addAll(cards);
    }

    private void validateNumberOfCards(int numberOfCards) throws IllegalArgumentException {
        if (numberOfCards <= 0) {
            throw new IllegalArgumentException("Illegal number of cards: " + numberOfCards);
        }
    }

    private void validateDeckNumber(int deckNumber) throws IllegalArgumentException {
        if (deckNumber < 0 || deckNumber > NUMBER_OF_DECKS) {
            throw new IllegalArgumentException("Illegal deck number: " + deckNumber);
        }
    }

    /**
     * Only "A" cards can be placed at the top of result deck.
     *
     * @param cards list of cards
     */
    private void validateCardsToPutInResultDeck(List<Card> cards) throws IllegalArgumentException {
        validateCardsToPutInResultDeck(null, cards);
    }

    /**
     * Checks if first card has the opposite suit color and incremented value.
     * Only "A" cards can be placed at the top of result deck.
     *
     * @param cardInDeck last card in deck or null
     * @param cards list of cards
     */
    private void validateCardsToPutInResultDeck(Card cardInDeck, List<Card> cards) throws IllegalArgumentException {
        requireNonNull(cards);
        if (cards.size() < 1) {
            return;
        }
        validateTopCard(cardInDeck, cards.get(0), CardValue.V_A);
    }

    private void validateCardsToPut(List<Card> cards) throws IllegalArgumentException {
        validateCardsToPut(null, cards);
    }

    /**
     * Checks if first card has the opposite suit color and decremented value.
     * Only "K" cards can be placed at the top of result deck.
     *
     * @param cardInDeck last card in deck or null
     * @param cards list of cards
     */
    private void validateCardsToPut(Card cardInDeck, List<Card> cards) throws IllegalArgumentException {
        requireNonNull(cards);
        if (cards.size() < 1) {
            return;
        }
        validateTopCard(cardInDeck, cards.get(0), CardValue.V_K);
    }

    /**
     * @param cardInDeck last card from deck or null
     * @param cardToPut card to put in deck
     * @param cardValue card value required at the top of deck
     */
    private void validateTopCard(Card cardInDeck, Card cardToPut, CardValue cardValue) throws IllegalArgumentException {
        if (cardInDeck == null) {
            if (cardToPut.getCardValue() != cardValue) {
                throw new IllegalArgumentException("Illegal card value: " + cardToPut.getCardValue().getSymbol());
            }
        } else {
            if (cardToPut.getCardValue().ordinal() != cardInDeck.getCardValue().ordinal() - 1) {
                throw new IllegalArgumentException("Illegal card value: " + cardToPut.getCardValue().getSymbol());
            }
            if (isRed(cardInDeck) == isRed(cardToPut)) {
                throw new IllegalArgumentException("Illegal card suit color: " + cardToString(cardToPut));
            }
        }
    }

    private List<Card> shuffleDeck(Collection<Card> deck) {
        List<Card> shuffledDeck = list(enumeration(deck));
        shuffle(shuffledDeck);
        return shuffledDeck;
    }

    private String cardToString(Card card) {
        return format("[%s%1s %4s%s]", (isRed(card)) ? ANSI_RED : ANSI_BLACK,
                card.getCardSuit().getSymbol(), card.getCardValue().getSymbol(), ANSI_RESET);
    }

    private boolean isRed(Card card) {
        return card.getCardSuit() == CardSuit.HEARTS || card.getCardSuit() == CardSuit.DIAMONDS;
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
