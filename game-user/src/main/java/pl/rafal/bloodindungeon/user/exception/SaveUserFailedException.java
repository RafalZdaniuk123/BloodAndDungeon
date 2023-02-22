package pl.rafal.bloodindungeon.user.exception;

public class SaveUserFailedException extends DaoException {
    public SaveUserFailedException(String message) {
        super(message);
    }
}

