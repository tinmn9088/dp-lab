package by.vsu.filters;

public class FilterException extends RuntimeException {

    public FilterException(Throwable th) {
        this(th.getMessage(), th);
    }
    
    public FilterException(String messsage, Throwable th) {
        super(messsage, th);
    }
}
