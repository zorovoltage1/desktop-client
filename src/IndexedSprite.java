import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;

public final class IndexedSprite extends Rasterizer2D {

    public byte[] pixels;
    public int[] palette;
    public int width;
    public int height;
    public int offsetX;
    public int offsetY;
    public int originalWidth;
    public int originalHeight;

    public static IndexedSprite fromBytes(byte[] is) {
        ByteArrayInputStream in = null;
        try {
            in = new ByteArrayInputStream(is);
            BufferedImage image = ImageIO.read(in);

            IndexedSprite c = new IndexedSprite();
            c.originalWidth = c.width = image.getWidth();
            c.originalHeight = c.height = image.getHeight();
            c.offsetY = c.offsetY = 0;

            int[] rgbArray = new int[image.getWidth() * image.getHeight()];
            image.getRGB(0, 0, image.getWidth(), image.getHeight(), rgbArray, 0, image.getWidth());

            byte[] alpha = new byte[image.getWidth() * image.getHeight()];
            int[] palette = new int[255];

            int paletteOffset = 0;
            palette[paletteOffset++] = 1; //no clue what this does

            for(int pixel = 0; pixel < alpha.length; pixel++) {
                int rgb = rgbArray[pixel] & 16777215;
                if(rgb == 16711935) {
                    /**
                     * Transparency
                     */
                    alpha[pixel] = 0;
                } else {
                    int var7 = Arrays.binarySearch(palette, rgb);
                    if(var7 < 0) {
                        var7 = paletteOffset;
                        palette[paletteOffset++] = rgb;
                    }
                    alpha[pixel] = (byte) var7;
                }
            }

            c.palette = palette;
            c.pixels = alpha;
            return c;
        } catch(Exception e) {
            /* ignored */
            return null;
        } finally {
            if(in != null) {
                try {
                    in.close();
                } catch(IOException e) {
                    /* nothing we can do */
                }
            }
        }
    }

    public void normalize() {
        if ((width != originalWidth) || (height != originalHeight)) {
            final byte[] bytes_0 = new byte[originalWidth * originalHeight];
            int int_0 = 0;

            for (int int_1 = 0; int_1 < height; int_1++) {
                for (int int_2 = 0; int_2 < width; int_2++) {
                    bytes_0[int_2 + ((int_1 + offsetY) * originalWidth) + offsetX] = pixels[int_0++];
                }
            }

            pixels = bytes_0;
            width = originalWidth;
            height = originalHeight;
            offsetX = 0;
            offsetY = 0;
        }
    }

    public void method5822(final int int_0, final int int_1, final int int_2) {
        for (int int_3 = 0; int_3 < palette.length; int_3++) {
            int int_4 = (palette[int_3] >> 16) & 0xFF;
            int_4 += int_0;
            if (int_4 < 0) {
                int_4 = 0;
            } else if (int_4 > 255) {
                int_4 = 255;
            }

            int int_5 = (palette[int_3] >> 8) & 0xFF;
            int_5 += int_1;
            if (int_5 < 0) {
                int_5 = 0;
            } else if (int_5 > 255) {
                int_5 = 255;
            }

            int int_6 = palette[int_3] & 0xFF;
            int_6 += int_2;
            if (int_6 < 0) {
                int_6 = 0;
            } else if (int_6 > 255) {
                int_6 = 255;
            }

            palette[int_3] = int_6 + (int_5 << 8) + (int_4 << 16);
        }

    }

    public void method5829(int int_0, int int_1) {
        int_0 += offsetX;
        int_1 += offsetY;
        int int_2 = int_0 + (int_1 * Rasterizer2D.graphicsPixelsWidth);
        int int_3 = 0;
        int int_4 = height;
        int int_5 = width;
        int int_6 = Rasterizer2D.graphicsPixelsWidth - int_5;
        int int_7 = 0;
        int int_8;
        if (int_1 < Rasterizer2D.topY) {
            int_8 = Rasterizer2D.topY - int_1;
            int_4 -= int_8;
            int_1 = Rasterizer2D.topY;
            int_3 += int_8 * int_5;
            int_2 += int_8 * Rasterizer2D.graphicsPixelsWidth;
        }

        if ((int_4 + int_1) > Rasterizer2D.bottomY) {
            int_4 -= (int_4 + int_1) - Rasterizer2D.bottomY;
        }

        if (int_0 < Rasterizer2D.topX) {
            int_8 = Rasterizer2D.topX - int_0;
            int_5 -= int_8;
            int_0 = Rasterizer2D.topX;
            int_3 += int_8;
            int_2 += int_8;
            int_7 += int_8;
            int_6 += int_8;
        }

        if ((int_5 + int_0) > Rasterizer2D.bottomX) {
            int_8 = (int_5 + int_0) - Rasterizer2D.bottomX;
            int_5 -= int_8;
            int_7 += int_8;
            int_6 += int_8;
        }

        if ((int_5 > 0) && (int_4 > 0)) {
            method5823(Rasterizer2D.graphicsPixels, pixels, palette, int_3, int_2, int_5, int_4, int_6, int_7);
        }
    }

    public void method5825(int int_0, int int_1, int int_2, int int_3) {
        final int int_4 = width;
        final int int_5 = height;
        int int_6 = 0;
        int int_7 = 0;
        final int int_8 = originalWidth;
        final int int_9 = originalHeight;
        final int int_10 = (int_8 << 16) / int_2;
        final int int_11 = (int_9 << 16) / int_3;
        int int_12;
        if (offsetX > 0) {
            int_12 = ((int_10 + (offsetX << 16)) - 1) / int_10;
            int_0 += int_12;
            int_6 += (int_12 * int_10) - (offsetX << 16);
        }

        if (offsetY > 0) {
            int_12 = ((int_11 + (offsetY << 16)) - 1) / int_11;
            int_1 += int_12;
            int_7 += (int_12 * int_11) - (offsetY << 16);
        }

        if (int_4 < int_8) {
            int_2 = ((int_10 + ((int_4 << 16) - int_6)) - 1) / int_10;
        }

        if (int_5 < int_9) {
            int_3 = ((int_11 + ((int_5 << 16) - int_7)) - 1) / int_11;
        }

        int_12 = int_0 + (int_1 * Rasterizer2D.graphicsPixelsWidth);
        int int_13 = Rasterizer2D.graphicsPixelsWidth - int_2;
        if ((int_1 + int_3) > Rasterizer2D.bottomY) {
            int_3 -= (int_1 + int_3) - Rasterizer2D.bottomY;
        }

        int int_14;
        if (int_1 < Rasterizer2D.topY) {
            int_14 = Rasterizer2D.topY - int_1;
            int_3 -= int_14;
            int_12 += int_14 * Rasterizer2D.graphicsPixelsWidth;
            int_7 += int_11 * int_14;
        }

        if ((int_2 + int_0) > Rasterizer2D.bottomX) {
            int_14 = (int_2 + int_0) - Rasterizer2D.bottomX;
            int_2 -= int_14;
            int_13 += int_14;
        }

        if (int_0 < Rasterizer2D.topX) {
            int_14 = Rasterizer2D.topX - int_0;
            int_2 -= int_14;
            int_12 += int_14;
            int_6 += int_10 * int_14;
            int_13 += int_14;
        }

        method5826(Rasterizer2D.graphicsPixels, pixels, palette, int_6, int_7, int_12, int_13, int_2, int_3, int_10,
                int_11, int_4);
    }

    static void method5823(final int[] ints_0, final byte[] bytes_0, final int[] ints_1, int int_0, int int_1,
                           int int_2, final int int_3, final int int_4, final int int_5) {
        final int int_6 = -(int_2 >> 2);
        int_2 = -(int_2 & 0x3);

        for (int int_7 = -int_3; int_7 < 0; int_7++) {
            int int_8;
            byte byte_0;
            for (int_8 = int_6; int_8 < 0; int_8++) {
                byte_0 = bytes_0[int_0++];
                if (byte_0 != 0) {
                    ints_0[int_1++] = ints_1[byte_0 & 0xFF];
                } else {
                    ++int_1;
                }

                byte_0 = bytes_0[int_0++];
                if (byte_0 != 0) {
                    ints_0[int_1++] = ints_1[byte_0 & 0xFF];
                } else {
                    ++int_1;
                }

                byte_0 = bytes_0[int_0++];
                if (byte_0 != 0) {
                    ints_0[int_1++] = ints_1[byte_0 & 0xFF];
                } else {
                    ++int_1;
                }

                byte_0 = bytes_0[int_0++];
                if (byte_0 != 0) {
                    ints_0[int_1++] = ints_1[byte_0 & 0xFF];
                } else {
                    ++int_1;
                }
            }

            for (int_8 = int_2; int_8 < 0; int_8++) {
                byte_0 = bytes_0[int_0++];
                if (byte_0 != 0) {
                    ints_0[int_1++] = ints_1[byte_0 & 0xFF];
                } else {
                    ++int_1;
                }
            }

            int_1 += int_4;
            int_0 += int_5;
        }

    }

    static void method5826(final int[] ints_0, final byte[] bytes_0, final int[] ints_1, int int_0, int int_1,
                           int int_2, final int int_3, final int int_4, final int int_5, final int int_6, final int int_7,
                           final int int_8) {
        final int int_9 = int_0;

        for (int int_10 = -int_5; int_10 < 0; int_10++) {
            final int int_11 = int_8 * (int_1 >> 16);

            for (int int_12 = -int_4; int_12 < 0; int_12++) {
                final byte byte_0 = bytes_0[(int_0 >> 16) + int_11];
                if (byte_0 != 0) {
                    ints_0[int_2++] = ints_1[byte_0 & 0xFF];
                } else {
                    ++int_2;
                }

                int_0 += int_6;
            }

            int_1 += int_7;
            int_0 = int_9;
            int_2 += int_3;
        }

    }

}
