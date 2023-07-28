package ru.minachev.javacore.ishop.exceptions;

public class AmountException extends Exception{
    public AmountException() {
        super();
    }

    public AmountException(String message) {
        super(message);
    }

    public AmountException(String message, Throwable cause) {
        super(message, cause);
    }

    public AmountException(Throwable cause) {
        super(cause);
    }
}
