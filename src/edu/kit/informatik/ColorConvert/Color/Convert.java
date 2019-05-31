package edu.kit.informatik.ColorConvert.Color;

/**
 * This class can convert a RGB color into CMYK color.
 */
public class Convert {
    private RGBColor rgbColor;
    private CMYKColor cmykColor;

    /**
     * This method is empty, because all functions are below.
     */
    public Convert() {
    }

    /**
     * This method use the given RGB color make a new CMYK color.
     * Then return the String form of this CMYK color.
     *
     * @param red   the red number of the RGB color.
     * @param green the green number of the RGB color.
     * @param blue  the blue number of the RGB color.
     * @return the String form of this CMYK color.
     */
    public String convert(String red, String green, String blue) {
        rgbColor = new RGBColor(Integer.valueOf(red),
                Integer.valueOf(green),
                Integer.valueOf(blue));
        cmykColor = rgbColor.convert();
        return cmykColor.toString();
    }

}
