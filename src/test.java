public class test {

    public static int rgbToHSL(int color) {
        double r = (color >> 16 & 0xff) / 256D;
        double g = (color >> 8 & 0xff) / 256D;
        double b = (color & 0xff) / 256D;
        double red_val1 = r;
        if (g < red_val1) {
            red_val1 = g;
        }
        if (b < red_val1) {
            red_val1 = b;
        }
        double red_val2 = r;
        if (g > red_val2) {
            red_val2 = g;
        }
        if (b > red_val2) {
            red_val2 = b;
        }
        double hueCalc = 0.0D;
        double satCalc = 0.0D;
        double lightCalc = (red_val1 + red_val2) / 2D;
        if (red_val1 != red_val2) {
            if (lightCalc < 0.5D) {
                satCalc = (red_val2 - red_val1) / (red_val2 + red_val1);
            }
            if (lightCalc >= 0.5D) {
                satCalc = (red_val2 - red_val1) / (2D - red_val2 - red_val1);
            }
            if (r == red_val2) {
                hueCalc = (g - b) / (red_val2 - red_val1);
            } else if (g == red_val2) {
                hueCalc = 2D + (b - r) / (red_val2 - red_val1);
            } else if (b == red_val2) {
                hueCalc = 4D + (r - g) / (red_val2 - red_val1);
            }
        }
        hueCalc /= 6D;
        int hue = (int) (hueCalc * 256D);
        int saturation = (int) (satCalc * 256D);
        int lightness = (int) (lightCalc * 256D);
        if (saturation < 0) {
            saturation = 0;
        } else if (saturation > 255) {
            saturation = 255;
        }
        if (lightness < 0) {
            lightness = 0;
        } else if (lightness > 255) {
            lightness = 255;
        }
        int divisor = 1;
        if (lightCalc > 0.5D) {
            divisor = (int) ((1.0D - lightCalc) * satCalc * 512D);
        } else {
            divisor = (int) (lightCalc * satCalc * 512D);
        }
        if (divisor < 1) {
            divisor = 1;
        }
        hue = (int) (hueCalc * divisor);
        int hueOffset = hue;
        int saturationOffset = saturation;
        int lightnessOffset = lightness;
        return getHSLValue(hueOffset, saturationOffset, lightnessOffset);
    }


    private static int getHSLValue(int hue, int saturation, int lightness) {
        if (lightness > 179) {
            saturation /= 2;
        }
        if (lightness > 192) {
            saturation /= 2;
        }
        if (lightness > 217) {
            saturation /= 2;
        }
        if (lightness > 243) {
            saturation /= 2;
        }
        return (hue / 4 << 10) + (saturation / 32 << 7) + lightness / 2;
    }

}
