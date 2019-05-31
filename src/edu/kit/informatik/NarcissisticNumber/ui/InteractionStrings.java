package edu.kit.informatik.NarcissisticNumber.ui;

/**
 * Contains strings or characters used for input or output.
 *
 * @author SiyanLi
 * @version 1.0
 */
public enum InteractionStrings {
    /**
     * the given number.
     */
    NUMBER_A("\\d{1,}"),
    /**
     * the given basis.
     */
    NUMBER_BASIS("\\d{1,}"),
    /**
     * numbers separator.
     */
    NUMBER_SEPARATOR(";");

    /**
     * String representation of the output.
     */
    private String content;

    /**
     * @param content the string representation for output
     */
    InteractionStrings(final String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }


}
