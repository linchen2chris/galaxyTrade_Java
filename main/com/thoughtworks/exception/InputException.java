package main.com.thoughtworks.exception;

/**
 * Created by chris on 15-8-8.
 */
public class InputException extends Exception {
    public InputException(String message) {
        super(message);
        System.out.println(message);
    }
}

