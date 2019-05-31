package edu.kit.informatik.DigitalCheck.ui;

/**
 * Contains strings or characters used for input or outpur.
 */
public enum InteractionStrings {
    /**
     * Represents two letters before the numbers.
     */
    TWO_LETTERS("[A-Z]{2}"),
    /**
     * Represents the 10 digit number.
     */
    NUMBER_WITH_P("\\d{10}"),
    /**
     * Represents the 9 digits number without p1.
     */
    NUMBER_WITHOUT_P("\\d{9}");

    private String content;

    /**
     * @param content the string representation for output.
     */
    InteractionStrings(final String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }

}
