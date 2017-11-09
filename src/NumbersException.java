

public class NumbersException extends Exception {

    private errorCode errorCode;

    enum errorCode{FAILURE, AMBIGUOUS}

    NumbersException(errorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(errorCode);
        builder.append(": ");
        builder.append(getMessage());
        return builder.toString();
    }

}
