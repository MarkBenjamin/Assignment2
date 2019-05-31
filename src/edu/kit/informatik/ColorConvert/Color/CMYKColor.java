package edu.kit.informatik.ColorConvert.Color;

import edu.kit.informatik.ColorConvert.ui.InteractionStrings;

/**
 * This class models the CMYK color, with four attributes: cyan, magenta, yellow, key.
 */
public class CMYKColor {
    private float cyan;
    private float magenta;
    private float yellow;
    private float key;

    /**
     * This method products a new CMYK color.
     *
     * @param cyan    the cyan number.
     * @param magenta the magenta number.
     * @param yellow  the yellow number.
     * @param key     the key number.
     */
    public CMYKColor(float cyan, float magenta, float yellow, float key) {
        this.cyan = cyan;
        this.magenta = magenta;
        this.yellow = yellow;
        this.key = key;
    }

    /**
     * This method can return the cyan number of the CMYK color.
     *
     * @return cyan number.
     */
    public float getCyan() {
        return cyan;
    }

    /**
     * This method can return the magenta number of the CMYK color.
     *
     * @return the magenta number.
     */
    public float getMagenta() {
        return magenta;
    };

    /**
     * This method can return the yellow number of the CMYK color.
     *
     * @return the yellow number.
     */
    public float getYellow() {
        return yellow;
    }

    /**
     * This method can return the key number of the CMYK color.
     *
     * @return the key number.
     */
    public float getKey() {
        return key;
    }

    /**
     * This method performs the CMYK color into String.
     *
     * @return the String of the CMYK color.
     */
    @Override
    public String toString() {
        return String.format("%.4f", getCyan()) + InteractionStrings.OUTPUT_SEPARATOR
                + String.format("%.4f", getYellow()) + InteractionStrings.OUTPUT_SEPARATOR
                + String.format("%.4f", getMagenta()) + InteractionStrings.OUTPUT_SEPARATOR
                + String.format("%.4f", getKey());
    }
}
