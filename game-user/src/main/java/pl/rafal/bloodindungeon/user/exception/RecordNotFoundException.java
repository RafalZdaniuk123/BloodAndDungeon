package pl.rafal.bloodindungeon.user.exception;

public class RecordNotFoundException extends DaoException {
    public RecordNotFoundException(String message) {
        super(message);
    }
}
