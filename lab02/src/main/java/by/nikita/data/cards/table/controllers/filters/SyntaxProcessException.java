package by.nikita.data.cards.table.controllers.filters;

public class SyntaxProcessException extends RuntimeException {

    public SyntaxProcessException(String message) {
        super(message);
    }

    public SyntaxProcessException(String message, Throwable th) {
        super(message, th);
    }
}
