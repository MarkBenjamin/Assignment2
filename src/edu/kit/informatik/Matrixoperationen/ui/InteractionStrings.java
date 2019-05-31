package edu.kit.informatik.Matrixoperationen.ui;

/**
 * Contains strings or characters used for input or output.
 *
 * @author Siyan Li
 * @version 1.0
 */
public enum InteractionStrings {
    /**
     * matrix separator
     */
    MATRIX_SEPARATOR(","),
    /**
     * colon
     */
    //COLOＮ(":"),
    DIAGONAL_DIMENSION("\\d{1,}" + ":"),
    /**
     * all numbers in a matrix.
     */
    NUM_OF_MATRIX("(\\d{1,},){1,}\\d{1,}"),
    /**
     * The first three numbers which describe the matrix behind.
     */
    TWO_MATRIX("\\d{1,}" + ":" + "\\d{1,}" + ":" + "\\d{1,}" + ":"),
    /**
     * The first two numbers which describe the matrix behind.
     */
    ONE_MATRIX("\\d{1,}" + ":" + "\\d{1,}" + ":");
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
