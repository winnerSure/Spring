package spring.transactionxml;

public class BookShopDaoException extends RuntimeException {
    public BookShopDaoException() {
        super();
    }

    public BookShopDaoException(String message) {
        super(message);
    }

    public BookShopDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookShopDaoException(Throwable cause) {
        super(cause);
    }

    protected BookShopDaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
