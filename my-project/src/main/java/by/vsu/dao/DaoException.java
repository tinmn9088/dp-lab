package by.vsu.dao;

public class DaoException extends RuntimeException {

    public DaoException(Throwable th) {
        this(th.getMessage(), th);
    }
    
    public DaoException(String messsage, Throwable th) {
        super(messsage, th);
    }
}
