package Exceptions.averageCalculator.solution;

public class InvalidNumberException extends Exception {

    private static final long serialVersionUID = 1L;

    public InvalidNumberException(Exception cause) {
        super(cause);
    }

    public InvalidNumberException(Exception cause, String value) {
        super("'"+value+"' is not a number", cause);
    }

    public InvalidNumberException(String message) {
        super(message);
    }
}