package edu.kit.informatik.ColorConvert.ui;

/**
 * Contains strings or characters used for input or output.
 *
 * @author SiyanLi
 * @version 1.0
 */
public enum InteractionStrings {
    /**
     * String for a separator for input.
     */
    INPUT_SEPARATOR(";"),
    /**
     * String for the separator for output.
     */
    OUTPUT_SEPARATOR(";"),
    /**
     * Represents the pattern for a red color.
     */
    RED("\\d{1,3}"),
    /**
     * Represents the pattern for a green color.
     */
    GREEN("\\d{1,3}"),
    /**
     * Represents the pattern for a blue color.
     */
    BLUE("\\d{1,3}");
    /**
     * String representation of the output.
     */
    private String content;

    /**
     * The string representation for output.
     * @param content for the output.
     */
    InteractionStrings(final String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }


}
