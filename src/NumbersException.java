

public class NumbersException extends Exception {

    public enum errorCodes {
        INVALID_INPUT_FILE,
    }

    public NumbersException(String message) {
        super(message);
    }
}
