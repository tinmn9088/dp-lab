package by.vsu.services;

public class ServiceException extends RuntimeException {

    public ServiceException(String message) {
        this(message, null);
    }

    public ServiceException(Throwable th) {
        this(th.getMessage(), th);
    }
    
    public ServiceException(String messsage, Throwable th) {
        super(messsage, th);
    }
}
