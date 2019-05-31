package edu.kit.informatik.ColorConvert.Color;

/**
 * This class models a RGB color with three numbers.
 */
public class RGBColor {
    private int red;
    private int green;
    private int blue;

    /**
     * This method product a new RGB color with the given three numbers.
     * @param red the given red number of this new RGB color.
     * @param green the given green number of the new RGB color.
     * @param blue the given blue number of the new RGB color.
     */
    public RGBColor(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    /**
     * Give the blue number of the RGB color.
     * @return the blue number.
     */
    public int getBlue() {
        return blue;
    }

    /**
     * Give the red number of the RGB color.
     * @return the red number.
     */
    public int getRed() {
        return red;
    }

    /**
     * Give the green number of the RGB color.
     * @return the green number.
     */
    public int getGreen() {
        return green;
    }

    /**
     * This method can convert a RGB color into a CMYK color.
     * @return the converted CMYK color.
     */
    public CMYKColor convert() {
        CMYKColor convertedCMYKColor = new CMYKColor((w() - Float.valueOf(red) / 255) / w(),
                1 - Float.valueOf(green) / 255 / w(),
                1 - Float.valueOf(blue) / 255 / w(),
                1 - w());

        return convertedCMYKColor;
    }

    /**
     * This method compares the largest number in red, green, and blue.
     * @return the largest number.
     */
    public float w() {
        float max = getRed();
        if (max <= getGreen()) {
            max = getGreen();
        }
        if (max <= getBlue()) {
            max = getBlue();
        }
        return max / 255;
    }
}
