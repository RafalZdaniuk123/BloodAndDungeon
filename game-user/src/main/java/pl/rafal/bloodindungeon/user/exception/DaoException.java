package pl.rafal.bloodindungeon.user.exception;

public class DaoException extends RuntimeException {
    DaoException(String message, Throwable cause) {
        super(message, cause);
    }

    DaoException(String message) {
        super(message);
    }
}
