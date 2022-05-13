package by.nikita.data.cards;

public enum CardValue {
    V_A("A"),
    V_2("2"),
    V_3("3"),
    V_4("4"),
    V_5("5"),
    V_6("6"),
    V_7("7"),
    V_8("8"),
    V_9("9"),
    V_10("10"),
    V_J("J"),
    V_Q("Q"),
    V_K("K");

    private final String symbol;

    CardValue(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
