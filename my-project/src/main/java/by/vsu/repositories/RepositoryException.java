package by.vsu.repositories;

public class RepositoryException extends RuntimeException {

    public RepositoryException(Throwable th) {
        this(th.getMessage(), th);
    }
    
    public RepositoryException(String messsage, Throwable th) {
        super(messsage, th);
    }
}
