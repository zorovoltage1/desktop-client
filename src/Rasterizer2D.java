public class Rasterizer2D extends CacheableNode {

    public static int[] graphicsPixels;
    public static int graphicsPixelsWidth;
    public static int graphicsPixelsHeight;
    public static int topY;
    public static int bottomY;
    public static int topX;
    protected static int bottomX;

    static {
        topY = 0;
        bottomY = 0;
        topX = 0;
        bottomX = 0;
    }

    public static void setRasterBuffer(final int[] ints_0, final int int_0, final int int_1) {
        graphicsPixels = ints_0;
        graphicsPixelsWidth = int_0;
        graphicsPixelsHeight = int_1;
        setDrawRegion(0, 0, int_0, int_1);
    }

    public static void noClip() {
        topX = 0;
        topY = 0;
        bottomX = graphicsPixelsWidth;
        bottomY = graphicsPixelsHeight;
    }

    public static void transparentBox(int i, int j, int k, int l, int i1, int j1, int opac) {
        int j3 = 256 - opac;
        if (k < topX) {
            i1 -= topX - k;
            k = topX;
        }
        if (j < topY) {
            i -= topY - j;
            j = topY;
        }
        if (k + i1 > bottomX)
            i1 = bottomX - k;
        if (j + i > bottomY)
            i = bottomY - j;
        int k1 = graphicsPixelsWidth - i1;
        int l1 = k + j * graphicsPixelsWidth;
        if (j1 != 0)
            Graphics3D.Rasterizer3D_clipMidY2 = -374;
        for (int i2 = -i; i2 < 0; i2++) {
            for (int j2 = -i1; j2 < 0; j2++) {
                int i3 = graphicsPixels[l1];
                graphicsPixels[l1++] = ((l & 0xff00ff) * opac + (i3 & 0xff00ff) * j3 & 0xff00ff00) + ((l & 0xff00) * opac + (i3 & 0xff00) * j3 & 0xff0000) >> 8;
            }
            l1 += k1;
        }
    }

    public static void drawHorizontalLine(int x, int y, int width, int color) {
        if(y >= topY && y < bottomY) {
            if(x < topX) {
                width -= topX - x;
                x = topX;
            }
            if(x + width > bottomX)
                width = bottomX - x;
            int var4 = x + y * graphicsPixelsWidth;
            for(int var5 = 0; var5 < width; var5++)
                graphicsPixels[var4 + var5] = color;
        }
    }

    public static void drawVerticalLine(int x, int y, int height, int color) {
        if(x >= topX && x < bottomX) {
            if(y < topY) {
                height -= topY - y;
                y = topY;
            }
            if(y + height > bottomY)
                height = bottomY - y;
            int var4 = x + y * graphicsPixelsWidth;
            for(int var5 = 0; var5 < height; var5++)
                graphicsPixels[var4 + var5 * graphicsPixelsWidth] = color;
        }
    }

    public static void fillRect(int x, int y, int width, int height, int color, int alpha) {
        if(x < topX) {
            width -= topX - x;
            x = topX;
        }
        if(y < topY) {
            height -= topY - y;
            y = topY;
        }
        if(x + width > bottomX)
            width = bottomX - x;
        if(y + height > bottomY)
            height = bottomY - y;
        color = (((color & 0xff00ff) * alpha >> 8 & 0xff00ff) + ((color & 0xff00) * alpha >> 8 & 0xff00));
        int var6 = 256 - alpha;
        int var7 = graphicsPixelsWidth - width;
        int var8 = x + y * graphicsPixelsWidth;
        for(int var9 = 0; var9 < height; var9++) {
            for(int var10 = -width; var10 < 0; var10++) {
                int var11 = graphicsPixels[var8];
                var11 = (((var11 & 0xff00ff) * var6 >> 8 & 0xff00ff) + ((var11 & 0xff00) * var6 >> 8 & 0xff00));
                graphicsPixels[var8++] = color + var11;
            }
            var8 += var7;
        }
    }

    public static void drawRect(int x, int y, int width, int height, int color) {
        drawHorizontalLine(x, y, width, color);
        drawHorizontalLine(x, y + height - 1, width, color);
        drawVerticalLine(x, y, height, color);
        drawVerticalLine(x + width - 1, y, height, color);
    }


    public static void drawCircle(int x, int y, int radius, int colour, int initialAlpha) {
        fillCircleAlpha(x, y, radius, colour, initialAlpha);
        fillCircleAlpha(x, y, radius + 2, colour, 8);
        fillCircleAlpha(x, y, radius + 4, colour, 6);
        fillCircleAlpha(x, y, radius + 6, colour, 4);
        fillCircleAlpha(x, y, radius + 8, colour, 2);
    }

    public static void fillCircleAlpha(int posX, int posY, int radius,
                                       int colour, int alpha) {
        int dest_intensity = 256 - alpha;
        int src_red = (colour >> 16 & 0xff) * alpha;
        int src_green = (colour >> 8 & 0xff) * alpha;
        int src_blue = (colour & 0xff) * alpha;
        int i3 = posY - radius;
        if (i3 < 0)
            i3 = 0;
        int j3 = posY + radius;
        if (j3 >= graphicsPixelsHeight)
            j3 = graphicsPixelsHeight - 1;
        for (int y = i3; y <= j3; y++) {
            int l3 = y - posY;
            int i4 = (int) Math.sqrt(radius * radius - l3 * l3);
            int x = posX - i4;
            if (x < 0)
                x = 0;
            int k4 = posX + i4;
            if (k4 >= graphicsPixelsWidth)
                k4 = graphicsPixelsWidth - 1;
            int pixel_offset = x + y * graphicsPixelsWidth;
            for (int i5 = x; i5 <= k4; i5++) {
                int dest_red = (graphicsPixels[pixel_offset] >> 16 & 0xff)
                        * dest_intensity;
                int dest_green = (graphicsPixels[pixel_offset] >> 8 & 0xff)
                        * dest_intensity;
                int dest_blue = (graphicsPixels[pixel_offset] & 0xff) * dest_intensity;
                int result_rgb = ((src_red + dest_red >> 8) << 16)
                        + ((src_green + dest_green >> 8) << 8)
                        + (src_blue + dest_blue >> 8);
                graphicsPixels[pixel_offset++] = result_rgb;
            }
        }
    }


    public static void setDrawRegion(int int_0, int int_1, int int_2, int int_3) {
        if (int_0 < 0) {
            int_0 = 0;
        }

        if (int_1 < 0) {
            int_1 = 0;
        }

        if (int_2 > graphicsPixelsWidth) {
            int_2 = graphicsPixelsWidth;
        }

        if (int_3 > graphicsPixelsHeight) {
            int_3 = graphicsPixelsHeight;
        }

        topX = int_0;
        topY = int_1;
        bottomX = int_2;
        bottomY = int_3;
    }

    public static void setInnerDrawRegion(final int int_0, final int int_1, final int int_2, final int int_3) {
        if (topX < int_0) {
            topX = int_0;
        }

        if (topY < int_1) {
            topY = int_1;
        }

        if (bottomX > int_2) {
            bottomX = int_2;
        }

        if (bottomY > int_3) {
            bottomY = int_3;
        }

    }

    public static void copyDrawRegion(final int[] ints_0) {
        ints_0[0] = topX;
        ints_0[1] = topY;
        ints_0[2] = bottomX;
        ints_0[3] = bottomY;
    }

    public static void setDrawRegion(final int[] ints_0) {
        topX = ints_0[0];
        topY = ints_0[1];
        bottomX = ints_0[2];
        bottomY = ints_0[3];
    }

    public static void reset() {
        int int_0 = 0;

        int int_1;
        for (int_1 = (graphicsPixelsWidth * graphicsPixelsHeight) - 7; int_0 < int_1; graphicsPixels[int_0++] = 0) {
            graphicsPixels[int_0++] = 0;
            graphicsPixels[int_0++] = 0;
            graphicsPixels[int_0++] = 0;
            graphicsPixels[int_0++] = 0;
            graphicsPixels[int_0++] = 0;
            graphicsPixels[int_0++] = 0;
            graphicsPixels[int_0++] = 0;
        }

        for (int_1 += 7; int_0 < int_1; graphicsPixels[int_0++] = 0) {
        }

    }

    static void method5744(final int int_0, int int_1, int int_2, final int int_3) {
        if (int_2 == 0) {
            Rasterizer2D_setPixel(int_0, int_1, int_3);
        } else {
            if (int_2 < 0) {
                int_2 = -int_2;
            }

            int int_4 = int_1 - int_2;
            if (int_4 < topY) {
                int_4 = topY;
            }

            int int_5 = int_2 + int_1 + 1;
            if (int_5 > bottomY) {
                int_5 = bottomY;
            }

            int int_6 = int_4;
            final int int_7 = int_2 * int_2;
            int int_8 = 0;
            int int_9 = int_1 - int_4;
            int int_10 = int_9 * int_9;
            int int_11 = int_10 - int_9;
            if (int_1 > int_5) {
                int_1 = int_5;
            }

            int int_12;
            int int_13;
            int int_14;
            int int_15;
            while (int_6 < int_1) {
                while ((int_11 <= int_7) || (int_10 <= int_7)) {
                    int_10 = int_10 + int_8 + int_8;
                    int_11 += int_8++ + int_8;
                }

                int_12 = (int_0 - int_8) + 1;
                if (int_12 < topX) {
                    int_12 = topX;
                }

                int_13 = int_0 + int_8;
                if (int_13 > bottomX) {
                    int_13 = bottomX;
                }

                int_14 = int_12 + (int_6 * graphicsPixelsWidth);

                for (int_15 = int_12; int_15 < int_13; int_15++) {
                    graphicsPixels[int_14++] = int_3;
                }

                ++int_6;
                int_10 -= int_9-- + int_9;
                int_11 -= int_9 + int_9;
            }

            int_8 = int_2;
            int_9 = int_6 - int_1;
            int_11 = int_7 + (int_9 * int_9);
            int_10 = int_11 - int_2;

            for (int_11 -= int_9; int_6 < int_5; int_10 += int_9++ + int_9) {
                while ((int_11 > int_7) && (int_10 > int_7)) {
                    int_11 -= int_8-- + int_8;
                    int_10 -= int_8 + int_8;
                }

                int_12 = int_0 - int_8;
                if (int_12 < topX) {
                    int_12 = topX;
                }

                int_13 = int_0 + int_8;
                if (int_13 > (bottomX - 1)) {
                    int_13 = bottomX - 1;
                }

                int_14 = int_12 + (int_6 * graphicsPixelsWidth);

                for (int_15 = int_12; int_15 <= int_13; int_15++) {
                    graphicsPixels[int_14++] = int_3;
                }

                ++int_6;
                int_11 = int_11 + int_9 + int_9;
            }

        }
    }

    public static void method5784(final int int_0, int int_1, int int_2, final int int_3, final int int_4) {
        if (int_4 != 0) {
            if (int_4 == 256) {
                method5744(int_0, int_1, int_2, int_3);
            } else {
                if (int_2 < 0) {
                    int_2 = -int_2;
                }

                final int int_5 = 256 - int_4;
                final int int_6 = ((int_3 >> 16) & 0xFF) * int_4;
                final int int_7 = ((int_3 >> 8) & 0xFF) * int_4;
                final int int_8 = int_4 * (int_3 & 0xFF);
                int int_9 = int_1 - int_2;
                if (int_9 < topY) {
                    int_9 = topY;
                }

                int int_10 = int_2 + int_1 + 1;
                if (int_10 > bottomY) {
                    int_10 = bottomY;
                }

                int int_11 = int_9;
                final int int_12 = int_2 * int_2;
                int int_13 = 0;
                int int_14 = int_1 - int_9;
                int int_15 = int_14 * int_14;
                int int_16 = int_15 - int_14;
                if (int_1 > int_10) {
                    int_1 = int_10;
                }

                int int_17;
                int int_18;
                int int_19;
                int int_20;
                int int_21;
                int int_22;
                int int_23;
                int int_24;
                while (int_11 < int_1) {
                    while ((int_16 <= int_12) || (int_15 <= int_12)) {
                        int_15 = int_15 + int_13 + int_13;
                        int_16 += int_13++ + int_13;
                    }

                    int_17 = (int_0 - int_13) + 1;
                    if (int_17 < topX) {
                        int_17 = topX;
                    }

                    int_18 = int_0 + int_13;
                    if (int_18 > bottomX) {
                        int_18 = bottomX;
                    }

                    int_19 = int_17 + (int_11 * graphicsPixelsWidth);

                    for (int_20 = int_17; int_20 < int_18; int_20++) {
                        int_21 = int_5 * ((graphicsPixels[int_19] >> 16) & 0xFF);
                        int_22 = ((graphicsPixels[int_19] >> 8) & 0xFF) * int_5;
                        int_23 = int_5 * (graphicsPixels[int_19] & 0xFF);
                        int_24 = ((int_8 + int_23) >> 8) + (((int_6 + int_21) >> 8) << 16)
                                + (((int_7 + int_22) >> 8) << 8);
                        graphicsPixels[int_19++] = int_24;
                    }

                    ++int_11;
                    int_15 -= int_14-- + int_14;
                    int_16 -= int_14 + int_14;
                }

                int_13 = int_2;
                int_14 = -int_14;
                int_16 = int_12 + (int_14 * int_14);
                int_15 = int_16 - int_2;

                for (int_16 -= int_14; int_11 < int_10; int_15 += int_14++ + int_14) {
                    while ((int_16 > int_12) && (int_15 > int_12)) {
                        int_16 -= int_13-- + int_13;
                        int_15 -= int_13 + int_13;
                    }

                    int_17 = int_0 - int_13;
                    if (int_17 < topX) {
                        int_17 = topX;
                    }

                    int_18 = int_0 + int_13;
                    if (int_18 > (bottomX - 1)) {
                        int_18 = bottomX - 1;
                    }

                    int_19 = int_17 + (int_11 * graphicsPixelsWidth);

                    for (int_20 = int_17; int_20 <= int_18; int_20++) {
                        int_21 = int_5 * ((graphicsPixels[int_19] >> 16) & 0xFF);
                        int_22 = ((graphicsPixels[int_19] >> 8) & 0xFF) * int_5;
                        int_23 = int_5 * (graphicsPixels[int_19] & 0xFF);
                        int_24 = ((int_8 + int_23) >> 8) + (((int_6 + int_21) >> 8) << 16)
                                + (((int_7 + int_22) >> 8) << 8);
                        graphicsPixels[int_19++] = int_24;
                    }

                    ++int_11;
                    int_16 = int_16 + int_14 + int_14;
                }

            }
        }
    }

    public static void fillRectangle(int int_0, int int_1, int int_2, int int_3, int int_4, final int int_5) {
        if (int_0 < topX) {
            int_2 -= topX - int_0;
            int_0 = topX;
        }

        if (int_1 < topY) {
            int_3 -= topY - int_1;
            int_1 = topY;
        }

        if ((int_0 + int_2) > bottomX) {
            int_2 = bottomX - int_0;
        }

        if ((int_3 + int_1) > bottomY) {
            int_3 = bottomY - int_1;
        }

        int_4 = (((int_5 * (int_4 & 0xFF00FF)) >> 8) & 0xFF00FF) + (((int_5 * (int_4 & 0xFF00)) >> 8) & 0xFF00);
        final int int_6 = 256 - int_5;
        final int int_7 = graphicsPixelsWidth - int_2;
        int int_8 = int_0 + (graphicsPixelsWidth * int_1);

        for (int int_9 = 0; int_9 < int_3; int_9++) {
            for (int int_10 = -int_2; int_10 < 0; int_10++) {
                int int_11 = graphicsPixels[int_8];
                int_11 = ((((int_11 & 0xFF00FF) * int_6) >> 8) & 0xFF00FF)
                        + (((int_6 * (int_11 & 0xFF00)) >> 8) & 0xFF00);
                graphicsPixels[int_8++] = int_11 + int_4;
            }

            int_8 += int_7;
        }

    }

    public static void Rasterizer2D_fillRectangle(int int_0, int int_1, int int_2, int int_3, final int int_4) {
        if (int_0 < topX) {
            int_2 -= topX - int_0;
            int_0 = topX;
        }

        if (int_1 < topY) {
            int_3 -= topY - int_1;
            int_1 = topY;
        }

        if ((int_0 + int_2) > bottomX) {
            int_2 = bottomX - int_0;
        }

        if ((int_3 + int_1) > bottomY) {
            int_3 = bottomY - int_1;
        }

        final int int_5 = graphicsPixelsWidth - int_2;
        int int_6 = int_0 + (graphicsPixelsWidth * int_1);

        for (int int_7 = -int_3; int_7 < 0; int_7++) {
            for (int int_8 = -int_2; int_8 < 0; int_8++) {
                graphicsPixels[int_6++] = int_4;
            }

            int_6 += int_5;
        }

    }

    public static void method5728(int int_0, int int_1, int int_2, int int_3, final int int_4, final int int_5,
                                  final int int_6, final int int_7) {
        if ((int_2 > 0) && (int_3 > 0)) {
            int int_8 = 0;
            final int int_9 = (int_5 == int_4) && (int_7 == int_6) ? -1 : 65536 / int_3;
            int int_10 = int_6;
            int int_11 = 256 - int_6;
            int int_12 = int_4;
            if (int_0 < topX) {
                int_2 -= topX - int_0;
                int_0 = topX;
            }

            if (int_1 < topY) {
                int_8 += (topY - int_1) * int_9;
                int_3 -= topY - int_1;
                int_1 = topY;
            }

            if ((int_0 + int_2) > bottomX) {
                int_2 = bottomX - int_0;
            }

            if ((int_3 + int_1) > bottomY) {
                int_3 = bottomY - int_1;
            }

            final int int_13 = graphicsPixelsWidth - int_2;
            int int_14 = int_0 + (graphicsPixelsWidth * int_1);

            for (int int_15 = -int_3; int_15 < 0; int_15++) {
                int int_16;
                int int_17;
                for (int_16 = -int_2; int_16 < 0; int_16++) {
                    int_17 = graphicsPixels[int_14];
                    final int int_18 = int_12 + int_17;
                    final int int_19 = (int_12 & 0xFF00FF) + (int_17 & 0xFF00FF);
                    final int int_20 = (int_19 & 0x1000100) + ((int_18 - int_19) & 0x10000);
                    if (int_11 == 0) {
                        graphicsPixels[int_14++] = (int_18 - int_20) | (int_20 - (int_20 >>> 8));
                    } else {
                        final int int_21 = (int_18 - int_20) | (int_20 - (int_20 >>> 8));
                        graphicsPixels[int_14++] = ((((int_21 & 0xFF00FF) * int_10) >> 8) & 0xFF00FF)
                                + ((((int_17 & 0xFF00FF) * int_11) >> 8) & 0xFF00FF)
                                + (((int_10 * (int_21 & 0xFF00)) >> 8) & 0xFF00)
                                + (((int_11 * (int_17 & 0xFF00)) >> 8) & 0xFF00);
                    }
                }

                if (int_9 > 0) {
                    int_8 += int_9;
                    int_16 = (65536 - int_8) >> 8;
                    int_17 = int_8 >> 8;
                    if (int_7 != int_6) {
                        int_10 = (((65536 - int_8) * int_6) + (int_8 * int_7)) >> 16;
                        int_11 = 256 - int_10;
                    }

                    if (int_5 != int_4) {
                        int_12 = ((((int_17 * (int_5 & 0xFF00FF)) + (int_16 * (int_4 & 0xFF00FF))) & 0xFF00FF00)
                                + (((int_17 * (int_5 & 0xFF00)) + (int_16 * (int_4 & 0xFF00))) & 0xFF0000)) >>> 8;
                    }
                }

                int_14 += int_13;
            }

        }
    }

    public static void method5729(int int_0, int int_1, int int_2, int int_3, final int int_4, final int int_5,
                                  final int int_6, final int int_7) {
        if ((int_2 > 0) && (int_3 > 0)) {
            int int_8 = 0;
            final int int_9 = (int_5 == int_4) && (int_7 == int_6) ? -1 : 65536 / int_3;
            int int_10 = int_6;
            int int_11 = 256 - int_6;
            if (int_0 < topX) {
                int_2 -= topX - int_0;
                int_0 = topX;
            }

            if (int_1 < topY) {
                int_8 += (topY - int_1) * int_9;
                int_3 -= topY - int_1;
                int_1 = topY;
            }

            if ((int_0 + int_2) > bottomX) {
                int_2 = bottomX - int_0;
            }

            if ((int_3 + int_1) > bottomY) {
                int_3 = bottomY - int_1;
            }

            int int_12 = int_4 >> 16;
            int int_13 = (int_4 & 0xFF00) >> 8;
            int int_14 = int_4 & 0xFF;
            final int int_15 = graphicsPixelsWidth - int_2;
            int int_16 = int_0 + (graphicsPixelsWidth * int_1);

            for (int int_17 = 0; int_17 < int_3; int_17++) {
                int int_18;
                int int_19;
                int int_20;
                for (int_18 = -int_2; int_18 < 0; int_18++) {
                    int_19 = graphicsPixels[int_16];
                    int_20 = int_19 >> 16;
                    final int int_21 = (int_19 & 0xFF00) >> 8;
                    final int int_22 = int_19 & 0xFF;
                    int int_23;
                    int int_24;
                    int int_25;
                    if (int_11 == 0) {
                        int_23 = int_20 < 127 ? (int_12 * int_20) >> 7 : 255 - (((255 - int_12) * (255 - int_20)) >> 7);
                        int_24 = int_21 < 127 ? (int_13 * int_21) >> 7 : 255 - (((255 - int_13) * (255 - int_21)) >> 7);
                        int_25 = int_22 < 127 ? (int_14 * int_22) >> 7 : 255 - (((255 - int_14) * (255 - int_22)) >> 7);
                    } else {
                        int_23 = int_20 < 127 ? ((int_20 * int_11) + ((int_12 * int_20 * int_10) >> 7)) >> 8
                                : ((int_10 * (255 - (((255 - int_12) * (255 - int_20)) >> 7)))
                                + (int_20 * int_11)) >> 8;
                        int_24 = int_21 < 127 ? ((int_21 * int_11) + ((int_13 * int_21 * int_10) >> 7)) >> 8
                                : ((int_10 * (255 - (((255 - int_13) * (255 - int_21)) >> 7)))
                                + (int_21 * int_11)) >> 8;
                        int_25 = int_22 < 127 ? ((int_22 * int_11) + ((int_14 * int_22 * int_10) >> 7)) >> 8
                                : ((int_10 * (255 - (((255 - int_14) * (255 - int_22)) >> 7)))
                                + (int_22 * int_11)) >> 8;
                    }

                    graphicsPixels[int_16++] = int_25 + (int_24 << 8) + (int_23 << 16);
                }

                if (int_9 > 0) {
                    int_8 += int_9;
                    int_18 = (65536 - int_8) >> 8;
                    int_19 = int_8 >> 8;
                    if (int_7 != int_6) {
                        int_10 = (((65536 - int_8) * int_6) + (int_8 * int_7)) >> 16;
                        int_11 = 256 - int_10;
                    }

                    if (int_5 != int_4) {
                        int_20 = ((((int_19 * (int_5 & 0xFF00FF)) + (int_18 * (int_4 & 0xFF00FF))) & 0xFF00FF00)
                                + (((int_19 * (int_5 & 0xFF00)) + (int_18 * (int_4 & 0xFF00))) & 0xFF0000)) >>> 8;
                        int_12 = int_20 >> 16;
                        int_13 = (int_20 & 0xFF00) >> 8;
                        int_14 = int_20 & 0xFF;
                    }
                }

                int_16 += int_15;
            }

        }
    }

    public static void method5739(int int_0, int int_1, int int_2, int int_3, final int int_4, final int int_5,
                                  final int int_6, final int int_7) {
        if ((int_2 > 0) && (int_3 > 0)) {
            int int_8 = 0;
            final int int_9 = 65536 / int_3;
            int int_10 = int_6;
            int int_11 = 256 - int_6;
            if (int_0 < topX) {
                int_2 -= topX - int_0;
                int_0 = topX;
            }

            if (int_1 < topY) {
                int_8 += (topY - int_1) * int_9;
                int_3 -= topY - int_1;
                int_1 = topY;
            }

            if ((int_0 + int_2) > bottomX) {
                int_2 = bottomX - int_0;
            }

            if ((int_3 + int_1) > bottomY) {
                int_3 = bottomY - int_1;
            }

            int int_12 = int_4 & 0xFF0000;
            int int_13 = int_4 & 0xFF00;
            int int_14 = int_4 & 0xFF;
            int int_15 = (int_12 * int_6) >> 8;
            int int_16 = (int_13 * int_6) >> 8;
            int int_17 = (int_14 * int_6) >> 8;
            final int int_18 = graphicsPixelsWidth - int_2;
            int int_19 = int_0 + (graphicsPixelsWidth * int_1);

            for (int int_20 = 0; int_20 < int_3; int_20++) {
                int int_21;
                int int_22;
                int int_23;
                for (int_21 = -int_2; int_21 < 0; int_21++) {
                    int_22 = graphicsPixels[int_19];
                    int_23 = int_22 & 0xFF0000;
                    final int int_24 = int_23 <= int_12 ? int_23
                            : (int_11 == 0 ? int_12 : (int_15 + ((int_23 * int_11) >> 8)) & 0xFF0000);
                    final int int_25 = int_22 & 0xFF00;
                    final int int_26 = int_25 <= int_13 ? int_25
                            : (int_11 == 0 ? int_13 : (int_16 + ((int_25 * int_11) >> 8)) & 0xFF00);
                    final int int_27 = int_22 & 0xFF;
                    final int int_28 = int_27 <= int_14 ? int_27
                            : (int_11 == 0 ? int_14 : int_17 + ((int_27 * int_11) >> 8));
                    graphicsPixels[int_19++] = int_24 + int_26 + int_28;
                }

                if (int_9 > 0) {
                    int_8 += int_9;
                    int_21 = (65536 - int_8) >> 8;
                    int_22 = int_8 >> 8;
                    if (int_7 != int_6) {
                        int_10 = (((65536 - int_8) * int_6) + (int_8 * int_7)) >> 16;
                        int_11 = 256 - int_10;
                    }

                    if (int_5 != int_4) {
                        int_23 = ((((int_22 * (int_5 & 0xFF00FF)) + (int_21 * (int_4 & 0xFF00FF))) & 0xFF00FF00)
                                + (((int_22 * (int_5 & 0xFF00)) + (int_21 * (int_4 & 0xFF00))) & 0xFF0000)) >>> 8;
                        int_12 = int_23 & 0xFF0000;
                        int_13 = int_23 & 0xFF00;
                        int_14 = int_23 & 0xFF;
                        int_15 = (int_12 * int_10) >> 8;
                        int_16 = (int_13 * int_10) >> 8;
                        int_17 = (int_14 * int_10) >> 8;
                    }
                }

                int_19 += int_18;
            }

        }
    }

    public static void method5726(int int_0, int int_1, int int_2, int int_3, final int int_4, final int int_5,
                                  final int int_6, final int int_7) {
        if ((int_3 > 0) && (int_2 > 0)) {
            int int_8 = 0;
            final int int_9 = 65536 / int_3;
            int int_10 = int_6;
            int int_11 = 256 - int_6;
            if (int_0 < topX) {
                int_2 -= topX - int_0;
                int_0 = topX;
            }

            if (int_1 < topY) {
                int_8 += (topY - int_1) * int_9;
                int_3 -= topY - int_1;
                int_1 = topY;
            }

            if ((int_0 + int_2) > bottomX) {
                int_2 = bottomX - int_0;
            }

            if ((int_3 + int_1) > bottomY) {
                int_3 = bottomY - int_1;
            }

            int int_12 = int_4 & 0xFF0000;
            int int_13 = int_4 & 0xFF00;
            int int_14 = int_4 & 0xFF;
            int int_15 = (int_12 * int_6) >> 8;
            int int_16 = (int_13 * int_6) >> 8;
            int int_17 = (int_14 * int_6) >> 8;
            final int int_18 = graphicsPixelsWidth - int_2;
            int int_19 = int_0 + (graphicsPixelsWidth * int_1);

            for (int int_20 = 0; int_20 < int_3; int_20++) {
                int int_21;
                int int_22;
                int int_23;
                for (int_21 = -int_2; int_21 < 0; int_21++) {
                    int_22 = graphicsPixels[int_19];
                    int_23 = int_22 & 0xFF0000;
                    final int int_24 = int_23 >= int_12 ? int_23
                            : (int_11 == 0 ? int_12 : (int_15 + ((int_23 * int_11) >> 8)) & 0xFF0000);
                    final int int_25 = int_22 & 0xFF00;
                    final int int_26 = int_25 >= int_13 ? int_25
                            : (int_11 == 0 ? int_13 : (int_16 + ((int_25 * int_11) >> 8)) & 0xFF00);
                    final int int_27 = int_22 & 0xFF;
                    final int int_28 = int_27 >= int_14 ? int_27
                            : (int_11 == 0 ? int_14 : int_17 + ((int_27 * int_11) >> 8));
                    graphicsPixels[int_19++] = int_24 + int_26 + int_28;
                }

                if (int_9 > 0) {
                    int_8 += int_9;
                    int_21 = (65536 - int_8) >> 8;
                    int_22 = int_8 >> 8;
                    if (int_7 != int_6) {
                        int_10 = (((65536 - int_8) * int_6) + (int_8 * int_7)) >> 16;
                        int_11 = 256 - int_10;
                    }

                    if (int_5 != int_4) {
                        int_23 = ((((int_22 * (int_5 & 0xFF00FF)) + (int_21 * (int_4 & 0xFF00FF))) & 0xFF00FF00)
                                + (((int_22 * (int_5 & 0xFF00)) + (int_21 * (int_4 & 0xFF00))) & 0xFF0000)) >>> 8;
                        int_12 = int_23 & 0xFF0000;
                        int_13 = int_23 & 0xFF00;
                        int_14 = int_23 & 0xFF;
                        int_15 = (int_12 * int_10) >> 8;
                        int_16 = (int_13 * int_10) >> 8;
                        int_17 = (int_14 * int_10) >> 8;
                    }
                }

                int_19 += int_18;
            }

        }
    }

    public static void method5748(int int_0, int int_1, int int_2, int int_3, final int int_4, final int int_5) {
        if ((int_2 > 0) && (int_3 > 0)) {
            int int_6 = 0;
            final int int_7 = 65536 / int_3;
            if (int_0 < topX) {
                int_2 -= topX - int_0;
                int_0 = topX;
            }

            if (int_1 < topY) {
                int_6 += (topY - int_1) * int_7;
                int_3 -= topY - int_1;
                int_1 = topY;
            }

            if ((int_0 + int_2) > bottomX) {
                int_2 = bottomX - int_0;
            }

            if ((int_3 + int_1) > bottomY) {
                int_3 = bottomY - int_1;
            }

            final int int_8 = graphicsPixelsWidth - int_2;
            int int_9 = int_0 + (graphicsPixelsWidth * int_1);

            for (int int_10 = -int_3; int_10 < 0; int_10++) {
                final int int_11 = (65536 - int_6) >> 8;
                final int int_12 = int_6 >> 8;
                final int int_13 = ((((int_12 * (int_5 & 0xFF00FF)) + (int_11 * (int_4 & 0xFF00FF))) & 0xFF00FF00)
                        + (((int_12 * (int_5 & 0xFF00)) + (int_11 * (int_4 & 0xFF00))) & 0xFF0000)) >>> 8;

                for (int int_14 = -int_2; int_14 < 0; int_14++) {
                    graphicsPixels[int_9++] = int_13;
                }

                int_9 += int_8;
                int_6 += int_7;
            }

        }
    }

    public static void method5733(final int int_0, final int int_1, int int_2, int int_3, final int int_4,
                                  final int int_5, final byte[] bytes_0, final int int_6) {
        if (((int_0 + int_2) >= 0) && ((int_3 + int_1) >= 0)) {
            if ((int_0 < graphicsPixelsWidth) && (int_1 < graphicsPixelsHeight)) {
                int int_7 = 0;
                int int_8 = 0;
                if (int_0 < 0) {
                    int_7 -= int_0;
                    int_2 += int_0;
                }

                if (int_1 < 0) {
                    int_8 -= int_1;
                    int_3 += int_1;
                }

                if ((int_0 + int_2) > graphicsPixelsWidth) {
                    int_2 = graphicsPixelsWidth - int_0;
                }

                if ((int_3 + int_1) > graphicsPixelsHeight) {
                    int_3 = graphicsPixelsHeight - int_1;
                }

                final int int_9 = bytes_0.length / int_6;
                final int int_10 = graphicsPixelsWidth - int_2;
                final int int_11 = int_4 >>> 24;
                final int int_12 = int_5 >>> 24;
                int int_13;
                int int_14;
                int int_15;
                int int_16;
                int int_17;
                if ((int_11 == 255) && (int_12 == 255)) {
                    int_13 = int_0 + int_7 + ((int_8 + int_1) * graphicsPixelsWidth);

                    for (int_14 = int_8 + int_1; int_14 < (int_3 + int_8 + int_1); int_14++) {
                        for (int_15 = int_0 + int_7; int_15 < (int_0 + int_7 + int_2); int_15++) {
                            int_16 = (int_14 - int_1) % int_9;
                            int_17 = (int_15 - int_0) % int_6;
                            if (bytes_0[int_17 + (int_16 * int_6)] != 0) {
                                graphicsPixels[int_13++] = int_5;
                            } else {
                                graphicsPixels[int_13++] = int_4;
                            }
                        }

                        int_13 += int_10;
                    }
                } else {
                    int_13 = int_0 + int_7 + ((int_8 + int_1) * graphicsPixelsWidth);

                    for (int_14 = int_8 + int_1; int_14 < (int_3 + int_8 + int_1); int_14++) {
                        for (int_15 = int_0 + int_7; int_15 < (int_0 + int_7 + int_2); int_15++) {
                            int_16 = (int_14 - int_1) % int_9;
                            int_17 = (int_15 - int_0) % int_6;
                            int int_18 = int_4;
                            if (bytes_0[int_17 + (int_16 * int_6)] != 0) {
                                int_18 = int_5;
                            }

                            final int int_19 = int_18 >>> 24;
                            final int int_20 = 255 - int_19;
                            final int int_21 = graphicsPixels[int_13];
                            final int int_22 = (((((int_18 & 0xFF00FF) * int_19) + ((int_21 & 0xFF00FF) * int_20))
                                    & 0xFF00FF00)
                                    + (((int_19 * (int_18 & 0xFF00)) + (int_20 * (int_21 & 0xFF00))) & 0xFF0000)) >> 8;
                            graphicsPixels[int_13++] = int_22;
                        }

                        int_13 += int_10;
                    }
                }

            }
        }
    }

    public static void drawRectangle(final int int_0, final int int_1, final int int_2, final int int_3,
                                     final int int_4) {
        method5736(int_0, int_1, int_2, int_4);
        method5736(int_0, (int_3 + int_1) - 1, int_2, int_4);
        method5738(int_0, int_1, int_3, int_4);
        method5738((int_0 + int_2) - 1, int_1, int_3, int_4);
    }

    public static void Rasterizer2D_drawRectangleAlpha(final int int_0, final int int_1, final int int_2,
                                                       final int int_3, final int int_4, final int int_5) {
        Rasterizer2D_drawHorizontalLineAlpha(int_0, int_1, int_2, int_4, int_5);
        Rasterizer2D_drawHorizontalLineAlpha(int_0, (int_3 + int_1) - 1, int_2, int_4, int_5);
        if (int_3 >= 3) {
            Rasterizer2D_drawVerticalLineAlpha(int_0, int_1 + 1, int_3 - 2, int_4, int_5);
            Rasterizer2D_drawVerticalLineAlpha((int_0 + int_2) - 1, int_1 + 1, int_3 - 2, int_4, int_5);
        }

    }

    public static void method5736(int int_0, final int int_1, int int_2, final int int_3) {
        if ((int_1 >= topY) && (int_1 < bottomY)) {
            if (int_0 < topX) {
                int_2 -= topX - int_0;
                int_0 = topX;
            }

            if ((int_0 + int_2) > bottomX) {
                int_2 = bottomX - int_0;
            }

            final int int_4 = int_0 + (graphicsPixelsWidth * int_1);

            for (int int_5 = 0; int_5 < int_2; int_5++) {
                graphicsPixels[int_4 + int_5] = int_3;
            }

        }
    }

    static void Rasterizer2D_drawHorizontalLineAlpha(int int_0, final int int_1, int int_2, final int int_3,
                                                     final int int_4) {
        if ((int_1 >= topY) && (int_1 < bottomY)) {
            if (int_0 < topX) {
                int_2 -= topX - int_0;
                int_0 = topX;
            }

            if ((int_0 + int_2) > bottomX) {
                int_2 = bottomX - int_0;
            }

            final int int_5 = 256 - int_4;
            final int int_6 = ((int_3 >> 16) & 0xFF) * int_4;
            final int int_7 = ((int_3 >> 8) & 0xFF) * int_4;
            final int int_8 = int_4 * (int_3 & 0xFF);
            int int_9 = int_0 + (graphicsPixelsWidth * int_1);

            for (int int_10 = 0; int_10 < int_2; int_10++) {
                final int int_11 = int_5 * ((graphicsPixels[int_9] >> 16) & 0xFF);
                final int int_12 = ((graphicsPixels[int_9] >> 8) & 0xFF) * int_5;
                final int int_13 = int_5 * (graphicsPixels[int_9] & 0xFF);
                final int int_14 = ((int_8 + int_13) >> 8) + (((int_6 + int_11) >> 8) << 16)
                        + (((int_7 + int_12) >> 8) << 8);
                graphicsPixels[int_9++] = int_14;
            }

        }
    }

    public static void method5738(final int int_0, int int_1, int int_2, final int int_3) {
        if ((int_0 >= topX) && (int_0 < bottomX)) {
            if (int_1 < topY) {
                int_2 -= topY - int_1;
                int_1 = topY;
            }

            if ((int_2 + int_1) > bottomY) {
                int_2 = bottomY - int_1;
            }

            final int int_4 = int_0 + (graphicsPixelsWidth * int_1);

            for (int int_5 = 0; int_5 < int_2; int_5++) {
                graphicsPixels[int_4 + (int_5 * graphicsPixelsWidth)] = int_3;
            }

        }
    }

    static void Rasterizer2D_drawVerticalLineAlpha(final int int_0, int int_1, int int_2, final int int_3,
                                                   final int int_4) {
        if ((int_0 >= topX) && (int_0 < bottomX)) {
            if (int_1 < topY) {
                int_2 -= topY - int_1;
                int_1 = topY;
            }

            if ((int_2 + int_1) > bottomY) {
                int_2 = bottomY - int_1;
            }

            final int int_5 = 256 - int_4;
            final int int_6 = ((int_3 >> 16) & 0xFF) * int_4;
            final int int_7 = ((int_3 >> 8) & 0xFF) * int_4;
            final int int_8 = int_4 * (int_3 & 0xFF);
            int int_9 = int_0 + (graphicsPixelsWidth * int_1);

            for (int int_10 = 0; int_10 < int_2; int_10++) {
                final int int_11 = int_5 * ((graphicsPixels[int_9] >> 16) & 0xFF);
                final int int_12 = ((graphicsPixels[int_9] >> 8) & 0xFF) * int_5;
                final int int_13 = int_5 * (graphicsPixels[int_9] & 0xFF);
                final int int_14 = ((int_8 + int_13) >> 8) + (((int_6 + int_11) >> 8) << 16)
                        + (((int_7 + int_12) >> 8) << 8);
                graphicsPixels[int_9] = int_14;
                int_9 += graphicsPixelsWidth;
            }

        }
    }

    public static void drawLine(int int_0, int int_1, int int_2, int int_3, final int int_4) {
        int_2 -= int_0;
        int_3 -= int_1;
        if (int_3 == 0) {
            if (int_2 >= 0) {
                method5736(int_0, int_1, int_2 + 1, int_4);
            } else {
                method5736(int_0 + int_2, int_1, -int_2 + 1, int_4);
            }

        } else if (int_2 == 0) {
            if (int_3 >= 0) {
                method5738(int_0, int_1, int_3 + 1, int_4);
            } else {
                method5738(int_0, int_3 + int_1, -int_3 + 1, int_4);
            }

        } else {
            if ((int_3 + int_2) < 0) {
                int_0 += int_2;
                int_2 = -int_2;
                int_1 += int_3;
                int_3 = -int_3;
            }

            int int_5;
            int int_6;
            if (int_2 > int_3) {
                int_1 <<= 16;
                int_1 += 32768;
                int_3 <<= 16;
                int_5 = (int) Math.floor(((double) int_3 / (double) int_2) + 0.5D);
                int_2 += int_0;
                if (int_0 < topX) {
                    int_1 += int_5 * (topX - int_0);
                    int_0 = topX;
                }

                if (int_2 >= bottomX) {
                    int_2 = bottomX - 1;
                }

                while (int_0 <= int_2) {
                    int_6 = int_1 >> 16;
                    if ((int_6 >= topY) && (int_6 < bottomY)) {
                        graphicsPixels[int_0 + (int_6 * graphicsPixelsWidth)] = int_4;
                    }

                    int_1 += int_5;
                    ++int_0;
                }
            } else {
                int_0 <<= 16;
                int_0 += 32768;
                int_2 <<= 16;
                int_5 = (int) Math.floor(((double) int_2 / (double) int_3) + 0.5D);
                int_3 += int_1;
                if (int_1 < topY) {
                    int_0 += (topY - int_1) * int_5;
                    int_1 = topY;
                }

                if (int_3 >= bottomY) {
                    int_3 = bottomY - 1;
                }

                while (int_1 <= int_3) {
                    int_6 = int_0 >> 16;
                    if ((int_6 >= topX) && (int_6 < bottomX)) {
                        graphicsPixels[int_6 + (graphicsPixelsWidth * int_1)] = int_4;
                    }

                    int_0 += int_5;
                    ++int_1;
                }
            }

        }
    }

    static void Rasterizer2D_setPixel(final int int_0, final int int_1, final int int_2) {
        if ((int_0 >= topX) && (int_1 >= topY) && (int_0 < bottomX)
                && (int_1 < bottomY)) {
            graphicsPixels[int_0 + (graphicsPixelsWidth * int_1)] = int_2;
        }
    }

    public static void method5742(int int_0, int int_1, final int int_2, final int[] ints_0, final int[] ints_1) {
        int int_3 = int_0 + (graphicsPixelsWidth * int_1);

        for (int_1 = 0; int_1 < ints_0.length; int_1++) {
            int int_4 = int_3 + ints_0[int_1];

            for (int_0 = -ints_1[int_1]; int_0 < 0; int_0++) {
                graphicsPixels[int_4++] = int_2;
            }

            int_3 += graphicsPixelsWidth;
        }

    }

}
