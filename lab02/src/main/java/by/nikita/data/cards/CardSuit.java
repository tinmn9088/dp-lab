package by.nikita.data.cards;

public enum CardSuit {
    SPADES("♠"),
    CLUBS("♣"),
    HEARTS("♥"),
    DIAMONDS("♦");

    private String symbol;

    CardSuit(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
