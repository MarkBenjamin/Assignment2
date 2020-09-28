package edu.kit.informatik.DigitalCheck;

/**
 * Encapsulates an exception which is thrown in case of invalid user input.
 *
 * @author SiyanLi
 * @version 1.0
 */
public class InputException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * The constructor of the InputException that is thrown if a user input is
     * invalid.
     *
     * @param message The error message to display to the user.
     */
    public InputException(String message) {
        super(message);
    }
}
