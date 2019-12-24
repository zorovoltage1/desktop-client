public class Graphics3D extends Rasterizer2D {

    static boolean rasterClipEnable;
    static boolean field1668;
    static boolean lowMem;
    public static boolean rasterGouraudLowRes;
    static int rasterAlpha;
    public static int Rasterizer3D_zoom;
    static int centerX;
    static int centerY;
    static int rasterClipX;
    static int Rasterizer3D_clipHeight;
    static int Rasterizer3D_clipNegativeMidX;
    static int Rasterizer3D_clipMidX2;
    static int Rasterizer3D_clipNegativeMidY;
    static int Rasterizer3D_clipMidY2;
    static int[] rasterClipY;
    public static int[] colorPalette;
    public static ITextureLoader textureLoader;
    static int[] field1690;
    static int[] field1691;
    public static int[] SINE;
    public static int[] COSINE;

    static {
        rasterClipEnable = false;
        field1668 = false;
        lowMem = false;
        rasterGouraudLowRes = true;
        rasterAlpha = 0;
        Rasterizer3D_zoom = 512;
        rasterClipY = new int[1024];
        colorPalette = new int[65536];
        field1690 = new int[512];
        field1691 = new int[2048];
        SINE = new int[2048];
        COSINE = new int[2048];

        int int_0;
        for (int_0 = 1; int_0 < 512; int_0++) {
            field1690[int_0] = 32768 / int_0;
        }

        for (int_0 = 1; int_0 < 2048; int_0++) {
            field1691[int_0] = 65536 / int_0;
        }

        for (int_0 = 0; int_0 < 2048; int_0++) {
            SINE[int_0] = (int) (65536.0D * Math.sin(int_0 * 0.0030679615D));
            COSINE[int_0] = (int) (65536.0D * Math.cos(int_0 * 0.0030679615D));
        }

    }

    public static void Rasterizer3D_method1() {
        setRasterClipping(Rasterizer2D.topX, Rasterizer2D.topY, Rasterizer2D.bottomX,
                Rasterizer2D.bottomY);
    }

    static void setRasterClipping(final int int_0, final int int_1, final int int_2, final int int_3) {
        rasterClipX = int_2 - int_0;
        Rasterizer3D_clipHeight = int_3 - int_1;
        Rasterizer3D_method3();
        if (rasterClipY.length < Rasterizer3D_clipHeight) {
            rasterClipY = new int[class146.nextPowerOfTwo(Rasterizer3D_clipHeight)];
        }

        int int_4 = int_0 + (Rasterizer2D.graphicsPixelsWidth * int_1);

        for (int int_5 = 0; int_5 < Rasterizer3D_clipHeight; int_5++) {
            rasterClipY[int_5] = int_4;
            int_4 += Rasterizer2D.graphicsPixelsWidth;
        }

    }

    public static void Rasterizer3D_method3() {
        centerX = rasterClipX / 2;
        centerY = Rasterizer3D_clipHeight / 2;
        Rasterizer3D_clipNegativeMidX = -centerX;
        Rasterizer3D_clipMidX2 = rasterClipX - centerX;
        Rasterizer3D_clipNegativeMidY = -centerY;
        Rasterizer3D_clipMidY2 = Rasterizer3D_clipHeight - centerY;
    }

    public static void method2827(final int int_0, final int int_1) {
        final int int_2 = rasterClipY[0];
        final int int_3 = int_2 / Rasterizer2D.graphicsPixelsWidth;
        final int int_4 = int_2 - (int_3 * Rasterizer2D.graphicsPixelsWidth);
        centerX = int_0 - int_4;
        centerY = int_1 - int_3;
        Rasterizer3D_clipNegativeMidX = -centerX;
        Rasterizer3D_clipMidX2 = rasterClipX - centerX;
        Rasterizer3D_clipNegativeMidY = -centerY;
        Rasterizer3D_clipMidY2 = Rasterizer3D_clipHeight - centerY;
    }

    public static void method2789(final ITextureLoader itextureloader_0) {
        textureLoader = itextureloader_0;
    }

    public static void setBrightness(final double double_0) {
        method2791(double_0, 0, 512);
    }

    static void method2791(final double double_0, final int int_0, final int int_1) {
        int int_3 = int_0 * 128;

        for (int int_4 = int_0; int_4 < int_1; int_4++) {
            final double double_1 = ((int_4 >> 3) / 64.0D) + 0.0078125D;
            final double double_2 = ((int_4 & 0x7) / 8.0D) + 0.0625D;

            for (int int_5 = 0; int_5 < 128; int_5++) {
                final double double_3 = int_5 / 128.0D;
                double double_4 = double_3;
                double double_5 = double_3;
                double double_6 = double_3;
                if (double_2 != 0.0D) {
                    double double_7;
                    if (double_3 < 0.5D) {
                        double_7 = double_3 * (1.0D + double_2);
                    } else {
                        double_7 = (double_3 + double_2) - (double_3 * double_2);
                    }

                    final double double_8 = (2.0D * double_3) - double_7;
                    double double_9 = double_1 + 0.3333333333333333D;
                    if (double_9 > 1.0D) {
                        --double_9;
                    }

                    double double_10 = double_1 - 0.3333333333333333D;
                    if (double_10 < 0.0D) {
                        ++double_10;
                    }

                    if ((6.0D * double_9) < 1.0D) {
                        double_4 = double_8 + ((double_7 - double_8) * 6.0D * double_9);
                    } else if ((2.0D * double_9) < 1.0D) {
                        double_4 = double_7;
                    } else if ((3.0D * double_9) < 2.0D) {
                        double_4 = double_8 + ((double_7 - double_8) * (0.6666666666666666D - double_9) * 6.0D);
                    } else {
                        double_4 = double_8;
                    }

                    if ((6.0D * double_1) < 1.0D) {
                        double_5 = double_8 + ((double_7 - double_8) * 6.0D * double_1);
                    } else if ((2.0D * double_1) < 1.0D) {
                        double_5 = double_7;
                    } else if ((3.0D * double_1) < 2.0D) {
                        double_5 = double_8 + ((double_7 - double_8) * (0.6666666666666666D - double_1) * 6.0D);
                    } else {
                        double_5 = double_8;
                    }

                    if ((6.0D * double_10) < 1.0D) {
                        double_6 = double_8 + ((double_7 - double_8) * 6.0D * double_10);
                    } else if ((2.0D * double_10) < 1.0D) {
                        double_6 = double_7;
                    } else if ((3.0D * double_10) < 2.0D) {
                        double_6 = double_8 + ((double_7 - double_8) * (0.6666666666666666D - double_10) * 6.0D);
                    } else {
                        double_6 = double_8;
                    }
                }

                final int int_6 = (int) (double_4 * 256.0D);
                final int int_7 = (int) (double_5 * 256.0D);
                final int int_8 = (int) (double_6 * 256.0D);
                int int_2 = int_8 + (int_7 << 8) + (int_6 << 16);
                int_2 = adjustRGB(int_2, double_0);
                if (int_2 == 0) {
                    int_2 = 1;
                }

                colorPalette[int_3++] = int_2;
            }
        }

    }

    static int adjustRGB(final int int_0, final double double_0) {
        double double_1 = (int_0 >> 16) / 256.0D;
        double double_2 = ((int_0 >> 8) & 0xFF) / 256.0D;
        double double_3 = (int_0 & 0xFF) / 256.0D;
        double_1 = Math.pow(double_1, double_0);
        double_2 = Math.pow(double_2, double_0);
        double_3 = Math.pow(double_3, double_0);
        final int int_1 = (int) (double_1 * 256.0D);
        final int int_2 = (int) (double_2 * 256.0D);
        final int int_3 = (int) (double_3 * 256.0D);
        return int_3 + (int_2 << 8) + (int_1 << 16);
    }

    public static void setRasterClippingEnabled(final int int_0, final int int_1, final int int_2) {
        rasterClipEnable = (int_0 < 0) || (int_0 > rasterClipX) || (int_1 < 0) || (int_1 > rasterClipX) || (int_2 < 0)
                || (int_2 > rasterClipX);
    }

    static void rasterGouraud(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7,
                              int int_8) {
        final int int_9 = int_4 - int_3;
        final int int_10 = int_1 - int_0;
        final int int_11 = int_5 - int_3;
        final int int_12 = int_2 - int_0;
        final int int_13 = int_7 - int_6;
        final int int_14 = int_8 - int_6;
        int int_15;
        if (int_2 != int_1) {
            int_15 = ((int_5 - int_4) << 14) / (int_2 - int_1);
        } else {
            int_15 = 0;
        }

        int int_16;
        if (int_0 != int_1) {
            int_16 = (int_9 << 14) / int_10;
        } else {
            int_16 = 0;
        }

        int int_17;
        if (int_0 != int_2) {
            int_17 = (int_11 << 14) / int_12;
        } else {
            int_17 = 0;
        }

        final int int_18 = (int_9 * int_12) - (int_11 * int_10);
        if (int_18 != 0) {
            final int int_19 = (((int_13 * int_12) - (int_14 * int_10)) << 8) / int_18;
            final int int_20 = (((int_14 * int_9) - (int_13 * int_11)) << 8) / int_18;
            if ((int_0 <= int_1) && (int_0 <= int_2)) {
                if (int_0 < Rasterizer3D_clipHeight) {
                    if (int_1 > Rasterizer3D_clipHeight) {
                        int_1 = Rasterizer3D_clipHeight;
                    }

                    if (int_2 > Rasterizer3D_clipHeight) {
                        int_2 = Rasterizer3D_clipHeight;
                    }

                    int_6 = int_19 + ((int_6 << 8) - (int_3 * int_19));
                    if (int_1 < int_2) {
                        int_5 = int_3 <<= 14;
                        if (int_0 < 0) {
                            int_5 -= int_0 * int_17;
                            int_3 -= int_0 * int_16;
                            int_6 -= int_0 * int_20;
                            int_0 = 0;
                        }

                        int_4 <<= 14;
                        if (int_1 < 0) {
                            int_4 -= int_15 * int_1;
                            int_1 = 0;
                        }

                        if (((int_0 != int_1) && (int_17 < int_16)) || ((int_0 == int_1) && (int_17 > int_15))) {
                            int_2 -= int_1;
                            int_1 -= int_0;
                            int_0 = rasterClipY[int_0];

                            while (true) {
                                --int_1;
                                if (int_1 < 0) {
                                    while (true) {
                                        --int_2;
                                        if (int_2 < 0) {
                                            return;
                                        }

                                        method2795(Rasterizer2D.graphicsPixels, int_0, 0, 0, int_5 >> 14, int_4 >> 14,
                                                int_6, int_19);
                                        int_5 += int_17;
                                        int_4 += int_15;
                                        int_6 += int_20;
                                        int_0 += Rasterizer2D.graphicsPixelsWidth;
                                    }
                                }

                                method2795(Rasterizer2D.graphicsPixels, int_0, 0, 0, int_5 >> 14, int_3 >> 14, int_6,
                                        int_19);
                                int_5 += int_17;
                                int_3 += int_16;
                                int_6 += int_20;
                                int_0 += Rasterizer2D.graphicsPixelsWidth;
                            }
                        } else {
                            int_2 -= int_1;
                            int_1 -= int_0;
                            int_0 = rasterClipY[int_0];

                            while (true) {
                                --int_1;
                                if (int_1 < 0) {
                                    while (true) {
                                        --int_2;
                                        if (int_2 < 0) {
                                            return;
                                        }

                                        method2795(Rasterizer2D.graphicsPixels, int_0, 0, 0, int_4 >> 14, int_5 >> 14,
                                                int_6, int_19);
                                        int_5 += int_17;
                                        int_4 += int_15;
                                        int_6 += int_20;
                                        int_0 += Rasterizer2D.graphicsPixelsWidth;
                                    }
                                }

                                method2795(Rasterizer2D.graphicsPixels, int_0, 0, 0, int_3 >> 14, int_5 >> 14, int_6,
                                        int_19);
                                int_5 += int_17;
                                int_3 += int_16;
                                int_6 += int_20;
                                int_0 += Rasterizer2D.graphicsPixelsWidth;
                            }
                        }
                    } else {
                        int_4 = int_3 <<= 14;
                        if (int_0 < 0) {
                            int_4 -= int_0 * int_17;
                            int_3 -= int_0 * int_16;
                            int_6 -= int_0 * int_20;
                            int_0 = 0;
                        }

                        int_5 <<= 14;
                        if (int_2 < 0) {
                            int_5 -= int_15 * int_2;
                            int_2 = 0;
                        }

                        if (((int_0 == int_2) || (int_17 >= int_16)) && ((int_0 != int_2) || (int_15 <= int_16))) {
                            int_1 -= int_2;
                            int_2 -= int_0;
                            int_0 = rasterClipY[int_0];

                            while (true) {
                                --int_2;
                                if (int_2 < 0) {
                                    while (true) {
                                        --int_1;
                                        if (int_1 < 0) {
                                            return;
                                        }

                                        method2795(Rasterizer2D.graphicsPixels, int_0, 0, 0, int_3 >> 14, int_5 >> 14,
                                                int_6, int_19);
                                        int_5 += int_15;
                                        int_3 += int_16;
                                        int_6 += int_20;
                                        int_0 += Rasterizer2D.graphicsPixelsWidth;
                                    }
                                }

                                method2795(Rasterizer2D.graphicsPixels, int_0, 0, 0, int_3 >> 14, int_4 >> 14, int_6,
                                        int_19);
                                int_4 += int_17;
                                int_3 += int_16;
                                int_6 += int_20;
                                int_0 += Rasterizer2D.graphicsPixelsWidth;
                            }
                        } else {
                            int_1 -= int_2;
                            int_2 -= int_0;
                            int_0 = rasterClipY[int_0];

                            while (true) {
                                --int_2;
                                if (int_2 < 0) {
                                    while (true) {
                                        --int_1;
                                        if (int_1 < 0) {
                                            return;
                                        }

                                        method2795(Rasterizer2D.graphicsPixels, int_0, 0, 0, int_5 >> 14, int_3 >> 14,
                                                int_6, int_19);
                                        int_5 += int_15;
                                        int_3 += int_16;
                                        int_6 += int_20;
                                        int_0 += Rasterizer2D.graphicsPixelsWidth;
                                    }
                                }

                                method2795(Rasterizer2D.graphicsPixels, int_0, 0, 0, int_4 >> 14, int_3 >> 14, int_6,
                                        int_19);
                                int_4 += int_17;
                                int_3 += int_16;
                                int_6 += int_20;
                                int_0 += Rasterizer2D.graphicsPixelsWidth;
                            }
                        }
                    }
                }
            } else if (int_1 <= int_2) {
                if (int_1 < Rasterizer3D_clipHeight) {
                    if (int_2 > Rasterizer3D_clipHeight) {
                        int_2 = Rasterizer3D_clipHeight;
                    }

                    if (int_0 > Rasterizer3D_clipHeight) {
                        int_0 = Rasterizer3D_clipHeight;
                    }

                    int_7 = int_19 + ((int_7 << 8) - (int_19 * int_4));
                    if (int_2 < int_0) {
                        int_3 = int_4 <<= 14;
                        if (int_1 < 0) {
                            int_3 -= int_16 * int_1;
                            int_4 -= int_15 * int_1;
                            int_7 -= int_20 * int_1;
                            int_1 = 0;
                        }

                        int_5 <<= 14;
                        if (int_2 < 0) {
                            int_5 -= int_17 * int_2;
                            int_2 = 0;
                        }

                        if (((int_2 != int_1) && (int_16 < int_15)) || ((int_2 == int_1) && (int_16 > int_17))) {
                            int_0 -= int_2;
                            int_2 -= int_1;
                            int_1 = rasterClipY[int_1];

                            while (true) {
                                --int_2;
                                if (int_2 < 0) {
                                    while (true) {
                                        --int_0;
                                        if (int_0 < 0) {
                                            return;
                                        }

                                        method2795(Rasterizer2D.graphicsPixels, int_1, 0, 0, int_3 >> 14, int_5 >> 14,
                                                int_7, int_19);
                                        int_3 += int_16;
                                        int_5 += int_17;
                                        int_7 += int_20;
                                        int_1 += Rasterizer2D.graphicsPixelsWidth;
                                    }
                                }

                                method2795(Rasterizer2D.graphicsPixels, int_1, 0, 0, int_3 >> 14, int_4 >> 14, int_7,
                                        int_19);
                                int_3 += int_16;
                                int_4 += int_15;
                                int_7 += int_20;
                                int_1 += Rasterizer2D.graphicsPixelsWidth;
                            }
                        } else {
                            int_0 -= int_2;
                            int_2 -= int_1;
                            int_1 = rasterClipY[int_1];

                            while (true) {
                                --int_2;
                                if (int_2 < 0) {
                                    while (true) {
                                        --int_0;
                                        if (int_0 < 0) {
                                            return;
                                        }

                                        method2795(Rasterizer2D.graphicsPixels, int_1, 0, 0, int_5 >> 14, int_3 >> 14,
                                                int_7, int_19);
                                        int_3 += int_16;
                                        int_5 += int_17;
                                        int_7 += int_20;
                                        int_1 += Rasterizer2D.graphicsPixelsWidth;
                                    }
                                }

                                method2795(Rasterizer2D.graphicsPixels, int_1, 0, 0, int_4 >> 14, int_3 >> 14, int_7,
                                        int_19);
                                int_3 += int_16;
                                int_4 += int_15;
                                int_7 += int_20;
                                int_1 += Rasterizer2D.graphicsPixelsWidth;
                            }
                        }
                    } else {
                        int_5 = int_4 <<= 14;
                        if (int_1 < 0) {
                            int_5 -= int_16 * int_1;
                            int_4 -= int_15 * int_1;
                            int_7 -= int_20 * int_1;
                            int_1 = 0;
                        }

                        int_3 <<= 14;
                        if (int_0 < 0) {
                            int_3 -= int_0 * int_17;
                            int_0 = 0;
                        }

                        if (int_16 < int_15) {
                            int_2 -= int_0;
                            int_0 -= int_1;
                            int_1 = rasterClipY[int_1];

                            while (true) {
                                --int_0;
                                if (int_0 < 0) {
                                    while (true) {
                                        --int_2;
                                        if (int_2 < 0) {
                                            return;
                                        }

                                        method2795(Rasterizer2D.graphicsPixels, int_1, 0, 0, int_3 >> 14, int_4 >> 14,
                                                int_7, int_19);
                                        int_3 += int_17;
                                        int_4 += int_15;
                                        int_7 += int_20;
                                        int_1 += Rasterizer2D.graphicsPixelsWidth;
                                    }
                                }

                                method2795(Rasterizer2D.graphicsPixels, int_1, 0, 0, int_5 >> 14, int_4 >> 14, int_7,
                                        int_19);
                                int_5 += int_16;
                                int_4 += int_15;
                                int_7 += int_20;
                                int_1 += Rasterizer2D.graphicsPixelsWidth;
                            }
                        } else {
                            int_2 -= int_0;
                            int_0 -= int_1;
                            int_1 = rasterClipY[int_1];

                            while (true) {
                                --int_0;
                                if (int_0 < 0) {
                                    while (true) {
                                        --int_2;
                                        if (int_2 < 0) {
                                            return;
                                        }

                                        method2795(Rasterizer2D.graphicsPixels, int_1, 0, 0, int_4 >> 14, int_3 >> 14,
                                                int_7, int_19);
                                        int_3 += int_17;
                                        int_4 += int_15;
                                        int_7 += int_20;
                                        int_1 += Rasterizer2D.graphicsPixelsWidth;
                                    }
                                }

                                method2795(Rasterizer2D.graphicsPixels, int_1, 0, 0, int_4 >> 14, int_5 >> 14, int_7,
                                        int_19);
                                int_5 += int_16;
                                int_4 += int_15;
                                int_7 += int_20;
                                int_1 += Rasterizer2D.graphicsPixelsWidth;
                            }
                        }
                    }
                }
            } else if (int_2 < Rasterizer3D_clipHeight) {
                if (int_0 > Rasterizer3D_clipHeight) {
                    int_0 = Rasterizer3D_clipHeight;
                }

                if (int_1 > Rasterizer3D_clipHeight) {
                    int_1 = Rasterizer3D_clipHeight;
                }

                int_8 = int_19 + ((int_8 << 8) - (int_5 * int_19));
                if (int_0 < int_1) {
                    int_4 = int_5 <<= 14;
                    if (int_2 < 0) {
                        int_4 -= int_15 * int_2;
                        int_5 -= int_17 * int_2;
                        int_8 -= int_20 * int_2;
                        int_2 = 0;
                    }

                    int_3 <<= 14;
                    if (int_0 < 0) {
                        int_3 -= int_0 * int_16;
                        int_0 = 0;
                    }

                    if (int_15 < int_17) {
                        int_1 -= int_0;
                        int_0 -= int_2;
                        int_2 = rasterClipY[int_2];

                        while (true) {
                            --int_0;
                            if (int_0 < 0) {
                                while (true) {
                                    --int_1;
                                    if (int_1 < 0) {
                                        return;
                                    }

                                    method2795(Rasterizer2D.graphicsPixels, int_2, 0, 0, int_4 >> 14, int_3 >> 14,
                                            int_8, int_19);
                                    int_4 += int_15;
                                    int_3 += int_16;
                                    int_8 += int_20;
                                    int_2 += Rasterizer2D.graphicsPixelsWidth;
                                }
                            }

                            method2795(Rasterizer2D.graphicsPixels, int_2, 0, 0, int_4 >> 14, int_5 >> 14, int_8,
                                    int_19);
                            int_4 += int_15;
                            int_5 += int_17;
                            int_8 += int_20;
                            int_2 += Rasterizer2D.graphicsPixelsWidth;
                        }
                    } else {
                        int_1 -= int_0;
                        int_0 -= int_2;
                        int_2 = rasterClipY[int_2];

                        while (true) {
                            --int_0;
                            if (int_0 < 0) {
                                while (true) {
                                    --int_1;
                                    if (int_1 < 0) {
                                        return;
                                    }

                                    method2795(Rasterizer2D.graphicsPixels, int_2, 0, 0, int_3 >> 14, int_4 >> 14,
                                            int_8, int_19);
                                    int_4 += int_15;
                                    int_3 += int_16;
                                    int_8 += int_20;
                                    int_2 += Rasterizer2D.graphicsPixelsWidth;
                                }
                            }

                            method2795(Rasterizer2D.graphicsPixels, int_2, 0, 0, int_5 >> 14, int_4 >> 14, int_8,
                                    int_19);
                            int_4 += int_15;
                            int_5 += int_17;
                            int_8 += int_20;
                            int_2 += Rasterizer2D.graphicsPixelsWidth;
                        }
                    }
                } else {
                    int_3 = int_5 <<= 14;
                    if (int_2 < 0) {
                        int_3 -= int_15 * int_2;
                        int_5 -= int_17 * int_2;
                        int_8 -= int_20 * int_2;
                        int_2 = 0;
                    }

                    int_4 <<= 14;
                    if (int_1 < 0) {
                        int_4 -= int_16 * int_1;
                        int_1 = 0;
                    }

                    if (int_15 < int_17) {
                        int_0 -= int_1;
                        int_1 -= int_2;
                        int_2 = rasterClipY[int_2];

                        while (true) {
                            --int_1;
                            if (int_1 < 0) {
                                while (true) {
                                    --int_0;
                                    if (int_0 < 0) {
                                        return;
                                    }

                                    method2795(Rasterizer2D.graphicsPixels, int_2, 0, 0, int_4 >> 14, int_5 >> 14,
                                            int_8, int_19);
                                    int_4 += int_16;
                                    int_5 += int_17;
                                    int_8 += int_20;
                                    int_2 += Rasterizer2D.graphicsPixelsWidth;
                                }
                            }

                            method2795(Rasterizer2D.graphicsPixels, int_2, 0, 0, int_3 >> 14, int_5 >> 14, int_8,
                                    int_19);
                            int_3 += int_15;
                            int_5 += int_17;
                            int_8 += int_20;
                            int_2 += Rasterizer2D.graphicsPixelsWidth;
                        }
                    } else {
                        int_0 -= int_1;
                        int_1 -= int_2;
                        int_2 = rasterClipY[int_2];

                        while (true) {
                            --int_1;
                            if (int_1 < 0) {
                                while (true) {
                                    --int_0;
                                    if (int_0 < 0) {
                                        return;
                                    }

                                    method2795(Rasterizer2D.graphicsPixels, int_2, 0, 0, int_5 >> 14, int_4 >> 14,
                                            int_8, int_19);
                                    int_4 += int_16;
                                    int_5 += int_17;
                                    int_8 += int_20;
                                    int_2 += Rasterizer2D.graphicsPixelsWidth;
                                }
                            }

                            method2795(Rasterizer2D.graphicsPixels, int_2, 0, 0, int_5 >> 14, int_3 >> 14, int_8,
                                    int_19);
                            int_3 += int_15;
                            int_5 += int_17;
                            int_8 += int_20;
                            int_2 += Rasterizer2D.graphicsPixelsWidth;
                        }
                    }
                }
            }
        }
    }

    static void method2795(final int[] ints_0, int int_0, int int_1, int int_2, int int_3, int int_4, int int_5,
                           int int_6) {
        if (rasterClipEnable) {
            if (int_4 > rasterClipX) {
                int_4 = rasterClipX;
            }

            if (int_3 < 0) {
                int_3 = 0;
            }
        }

        if (int_3 < int_4) {
            int_0 += int_3;
            int_5 += int_3 * int_6;
            int int_7;
            int int_8;
            int int_9;
            if (rasterGouraudLowRes) {
                int_2 = (int_4 - int_3) >> 2;
                int_6 <<= 2;
                if (rasterAlpha == 0) {
                    if (int_2 > 0) {
                        do {
                            int_1 = colorPalette[int_5 >> 8];
                            int_5 += int_6;
                            ints_0[int_0++] = int_1;
                            ints_0[int_0++] = int_1;
                            ints_0[int_0++] = int_1;
                            ints_0[int_0++] = int_1;
                            --int_2;
                        }
                        while (int_2 > 0);
                    }

                    int_2 = (int_4 - int_3) & 0x3;
                    if (int_2 > 0) {
                        int_1 = colorPalette[int_5 >> 8];

                        do {
                            ints_0[int_0++] = int_1;
                            --int_2;
                        }
                        while (int_2 > 0);
                    }
                } else {
                    int_7 = rasterAlpha;
                    int_8 = 256 - rasterAlpha;
                    if (int_2 > 0) {
                        do {
                            int_1 = colorPalette[int_5 >> 8];
                            int_5 += int_6;
                            int_1 = (((int_8 * (int_1 & 0xFF00)) >> 8) & 0xFF00)
                                    + (((int_8 * (int_1 & 0xFF00FF)) >> 8) & 0xFF00FF);
                            int_9 = ints_0[int_0];
                            ints_0[int_0++] = ((((int_9 & 0xFF00FF) * int_7) >> 8) & 0xFF00FF) + int_1
                                    + (((int_7 * (int_9 & 0xFF00)) >> 8) & 0xFF00);
                            int_9 = ints_0[int_0];
                            ints_0[int_0++] = ((((int_9 & 0xFF00FF) * int_7) >> 8) & 0xFF00FF) + int_1
                                    + (((int_7 * (int_9 & 0xFF00)) >> 8) & 0xFF00);
                            int_9 = ints_0[int_0];
                            ints_0[int_0++] = ((((int_9 & 0xFF00FF) * int_7) >> 8) & 0xFF00FF) + int_1
                                    + (((int_7 * (int_9 & 0xFF00)) >> 8) & 0xFF00);
                            int_9 = ints_0[int_0];
                            ints_0[int_0++] = ((((int_9 & 0xFF00FF) * int_7) >> 8) & 0xFF00FF) + int_1
                                    + (((int_7 * (int_9 & 0xFF00)) >> 8) & 0xFF00);
                            --int_2;
                        }
                        while (int_2 > 0);
                    }

                    int_2 = (int_4 - int_3) & 0x3;
                    if (int_2 > 0) {
                        int_1 = colorPalette[int_5 >> 8];
                        int_1 = (((int_8 * (int_1 & 0xFF00)) >> 8) & 0xFF00)
                                + (((int_8 * (int_1 & 0xFF00FF)) >> 8) & 0xFF00FF);

                        do {
                            int_9 = ints_0[int_0];
                            ints_0[int_0++] = ((((int_9 & 0xFF00FF) * int_7) >> 8) & 0xFF00FF) + int_1
                                    + (((int_7 * (int_9 & 0xFF00)) >> 8) & 0xFF00);
                            --int_2;
                        }
                        while (int_2 > 0);
                    }
                }

            } else {
                int_2 = int_4 - int_3;
                if (rasterAlpha == 0) {
                    do {
                        ints_0[int_0++] = colorPalette[int_5 >> 8];
                        int_5 += int_6;
                        --int_2;
                    }
                    while (int_2 > 0);
                } else {
                    int_7 = rasterAlpha;
                    int_8 = 256 - rasterAlpha;

                    do {
                        int_1 = colorPalette[int_5 >> 8];
                        int_5 += int_6;
                        int_1 = (((int_8 * (int_1 & 0xFF00)) >> 8) & 0xFF00)
                                + (((int_8 * (int_1 & 0xFF00FF)) >> 8) & 0xFF00FF);
                        int_9 = ints_0[int_0];
                        ints_0[int_0++] = ((((int_9 & 0xFF00FF) * int_7) >> 8) & 0xFF00FF) + int_1
                                + (((int_7 * (int_9 & 0xFF00)) >> 8) & 0xFF00);
                        --int_2;
                    }
                    while (int_2 > 0);
                }

            }
        }
    }

    public static void rasterFlat(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, final int int_6) {
        int int_7 = 0;
        if (int_0 != int_1) {
            int_7 = ((int_4 - int_3) << 14) / (int_1 - int_0);
        }

        int int_8 = 0;
        if (int_2 != int_1) {
            int_8 = ((int_5 - int_4) << 14) / (int_2 - int_1);
        }

        int int_9 = 0;
        if (int_0 != int_2) {
            int_9 = ((int_3 - int_5) << 14) / (int_0 - int_2);
        }

        if ((int_0 <= int_1) && (int_0 <= int_2)) {
            if (int_0 < Rasterizer3D_clipHeight) {
                if (int_1 > Rasterizer3D_clipHeight) {
                    int_1 = Rasterizer3D_clipHeight;
                }

                if (int_2 > Rasterizer3D_clipHeight) {
                    int_2 = Rasterizer3D_clipHeight;
                }

                if (int_1 < int_2) {
                    int_5 = int_3 <<= 14;
                    if (int_0 < 0) {
                        int_5 -= int_0 * int_9;
                        int_3 -= int_0 * int_7;
                        int_0 = 0;
                    }

                    int_4 <<= 14;
                    if (int_1 < 0) {
                        int_4 -= int_8 * int_1;
                        int_1 = 0;
                    }

                    if (((int_0 != int_1) && (int_9 < int_7)) || ((int_0 == int_1) && (int_9 > int_8))) {
                        int_2 -= int_1;
                        int_1 -= int_0;
                        int_0 = rasterClipY[int_0];

                        while (true) {
                            --int_1;
                            if (int_1 < 0) {
                                while (true) {
                                    --int_2;
                                    if (int_2 < 0) {
                                        return;
                                    }

                                    method2825(Rasterizer2D.graphicsPixels, int_0, int_6, 0, int_5 >> 14, int_4 >> 14);
                                    int_5 += int_9;
                                    int_4 += int_8;
                                    int_0 += Rasterizer2D.graphicsPixelsWidth;
                                }
                            }

                            method2825(Rasterizer2D.graphicsPixels, int_0, int_6, 0, int_5 >> 14, int_3 >> 14);
                            int_5 += int_9;
                            int_3 += int_7;
                            int_0 += Rasterizer2D.graphicsPixelsWidth;
                        }
                    } else {
                        int_2 -= int_1;
                        int_1 -= int_0;
                        int_0 = rasterClipY[int_0];

                        while (true) {
                            --int_1;
                            if (int_1 < 0) {
                                while (true) {
                                    --int_2;
                                    if (int_2 < 0) {
                                        return;
                                    }

                                    method2825(Rasterizer2D.graphicsPixels, int_0, int_6, 0, int_4 >> 14, int_5 >> 14);
                                    int_5 += int_9;
                                    int_4 += int_8;
                                    int_0 += Rasterizer2D.graphicsPixelsWidth;
                                }
                            }

                            method2825(Rasterizer2D.graphicsPixels, int_0, int_6, 0, int_3 >> 14, int_5 >> 14);
                            int_5 += int_9;
                            int_3 += int_7;
                            int_0 += Rasterizer2D.graphicsPixelsWidth;
                        }
                    }
                } else {
                    int_4 = int_3 <<= 14;
                    if (int_0 < 0) {
                        int_4 -= int_0 * int_9;
                        int_3 -= int_0 * int_7;
                        int_0 = 0;
                    }

                    int_5 <<= 14;
                    if (int_2 < 0) {
                        int_5 -= int_8 * int_2;
                        int_2 = 0;
                    }

                    if (((int_0 != int_2) && (int_9 < int_7)) || ((int_0 == int_2) && (int_8 > int_7))) {
                        int_1 -= int_2;
                        int_2 -= int_0;
                        int_0 = rasterClipY[int_0];

                        while (true) {
                            --int_2;
                            if (int_2 < 0) {
                                while (true) {
                                    --int_1;
                                    if (int_1 < 0) {
                                        return;
                                    }

                                    method2825(Rasterizer2D.graphicsPixels, int_0, int_6, 0, int_5 >> 14, int_3 >> 14);
                                    int_5 += int_8;
                                    int_3 += int_7;
                                    int_0 += Rasterizer2D.graphicsPixelsWidth;
                                }
                            }

                            method2825(Rasterizer2D.graphicsPixels, int_0, int_6, 0, int_4 >> 14, int_3 >> 14);
                            int_4 += int_9;
                            int_3 += int_7;
                            int_0 += Rasterizer2D.graphicsPixelsWidth;
                        }
                    } else {
                        int_1 -= int_2;
                        int_2 -= int_0;
                        int_0 = rasterClipY[int_0];

                        while (true) {
                            --int_2;
                            if (int_2 < 0) {
                                while (true) {
                                    --int_1;
                                    if (int_1 < 0) {
                                        return;
                                    }

                                    method2825(Rasterizer2D.graphicsPixels, int_0, int_6, 0, int_3 >> 14, int_5 >> 14);
                                    int_5 += int_8;
                                    int_3 += int_7;
                                    int_0 += Rasterizer2D.graphicsPixelsWidth;
                                }
                            }

                            method2825(Rasterizer2D.graphicsPixels, int_0, int_6, 0, int_3 >> 14, int_4 >> 14);
                            int_4 += int_9;
                            int_3 += int_7;
                            int_0 += Rasterizer2D.graphicsPixelsWidth;
                        }
                    }
                }
            }
        } else if (int_1 <= int_2) {
            if (int_1 < Rasterizer3D_clipHeight) {
                if (int_2 > Rasterizer3D_clipHeight) {
                    int_2 = Rasterizer3D_clipHeight;
                }

                if (int_0 > Rasterizer3D_clipHeight) {
                    int_0 = Rasterizer3D_clipHeight;
                }

                if (int_2 < int_0) {
                    int_3 = int_4 <<= 14;
                    if (int_1 < 0) {
                        int_3 -= int_7 * int_1;
                        int_4 -= int_8 * int_1;
                        int_1 = 0;
                    }

                    int_5 <<= 14;
                    if (int_2 < 0) {
                        int_5 -= int_9 * int_2;
                        int_2 = 0;
                    }

                    if (((int_2 == int_1) || (int_7 >= int_8)) && ((int_2 != int_1) || (int_7 <= int_9))) {
                        int_0 -= int_2;
                        int_2 -= int_1;
                        int_1 = rasterClipY[int_1];

                        while (true) {
                            --int_2;
                            if (int_2 < 0) {
                                while (true) {
                                    --int_0;
                                    if (int_0 < 0) {
                                        return;
                                    }

                                    method2825(Rasterizer2D.graphicsPixels, int_1, int_6, 0, int_5 >> 14, int_3 >> 14);
                                    int_3 += int_7;
                                    int_5 += int_9;
                                    int_1 += Rasterizer2D.graphicsPixelsWidth;
                                }
                            }

                            method2825(Rasterizer2D.graphicsPixels, int_1, int_6, 0, int_4 >> 14, int_3 >> 14);
                            int_3 += int_7;
                            int_4 += int_8;
                            int_1 += Rasterizer2D.graphicsPixelsWidth;
                        }
                    } else {
                        int_0 -= int_2;
                        int_2 -= int_1;
                        int_1 = rasterClipY[int_1];

                        while (true) {
                            --int_2;
                            if (int_2 < 0) {
                                while (true) {
                                    --int_0;
                                    if (int_0 < 0) {
                                        return;
                                    }

                                    method2825(Rasterizer2D.graphicsPixels, int_1, int_6, 0, int_3 >> 14, int_5 >> 14);
                                    int_3 += int_7;
                                    int_5 += int_9;
                                    int_1 += Rasterizer2D.graphicsPixelsWidth;
                                }
                            }

                            method2825(Rasterizer2D.graphicsPixels, int_1, int_6, 0, int_3 >> 14, int_4 >> 14);
                            int_3 += int_7;
                            int_4 += int_8;
                            int_1 += Rasterizer2D.graphicsPixelsWidth;
                        }
                    }
                } else {
                    int_5 = int_4 <<= 14;
                    if (int_1 < 0) {
                        int_5 -= int_7 * int_1;
                        int_4 -= int_8 * int_1;
                        int_1 = 0;
                    }

                    int_3 <<= 14;
                    if (int_0 < 0) {
                        int_3 -= int_0 * int_9;
                        int_0 = 0;
                    }

                    if (int_7 < int_8) {
                        int_2 -= int_0;
                        int_0 -= int_1;
                        int_1 = rasterClipY[int_1];

                        while (true) {
                            --int_0;
                            if (int_0 < 0) {
                                while (true) {
                                    --int_2;
                                    if (int_2 < 0) {
                                        return;
                                    }

                                    method2825(Rasterizer2D.graphicsPixels, int_1, int_6, 0, int_3 >> 14, int_4 >> 14);
                                    int_3 += int_9;
                                    int_4 += int_8;
                                    int_1 += Rasterizer2D.graphicsPixelsWidth;
                                }
                            }

                            method2825(Rasterizer2D.graphicsPixels, int_1, int_6, 0, int_5 >> 14, int_4 >> 14);
                            int_5 += int_7;
                            int_4 += int_8;
                            int_1 += Rasterizer2D.graphicsPixelsWidth;
                        }
                    } else {
                        int_2 -= int_0;
                        int_0 -= int_1;
                        int_1 = rasterClipY[int_1];

                        while (true) {
                            --int_0;
                            if (int_0 < 0) {
                                while (true) {
                                    --int_2;
                                    if (int_2 < 0) {
                                        return;
                                    }

                                    method2825(Rasterizer2D.graphicsPixels, int_1, int_6, 0, int_4 >> 14, int_3 >> 14);
                                    int_3 += int_9;
                                    int_4 += int_8;
                                    int_1 += Rasterizer2D.graphicsPixelsWidth;
                                }
                            }

                            method2825(Rasterizer2D.graphicsPixels, int_1, int_6, 0, int_4 >> 14, int_5 >> 14);
                            int_5 += int_7;
                            int_4 += int_8;
                            int_1 += Rasterizer2D.graphicsPixelsWidth;
                        }
                    }
                }
            }
        } else if (int_2 < Rasterizer3D_clipHeight) {
            if (int_0 > Rasterizer3D_clipHeight) {
                int_0 = Rasterizer3D_clipHeight;
            }

            if (int_1 > Rasterizer3D_clipHeight) {
                int_1 = Rasterizer3D_clipHeight;
            }

            if (int_0 < int_1) {
                int_4 = int_5 <<= 14;
                if (int_2 < 0) {
                    int_4 -= int_8 * int_2;
                    int_5 -= int_9 * int_2;
                    int_2 = 0;
                }

                int_3 <<= 14;
                if (int_0 < 0) {
                    int_3 -= int_0 * int_7;
                    int_0 = 0;
                }

                if (int_8 < int_9) {
                    int_1 -= int_0;
                    int_0 -= int_2;
                    int_2 = rasterClipY[int_2];

                    while (true) {
                        --int_0;
                        if (int_0 < 0) {
                            while (true) {
                                --int_1;
                                if (int_1 < 0) {
                                    return;
                                }

                                method2825(Rasterizer2D.graphicsPixels, int_2, int_6, 0, int_4 >> 14, int_3 >> 14);
                                int_4 += int_8;
                                int_3 += int_7;
                                int_2 += Rasterizer2D.graphicsPixelsWidth;
                            }
                        }

                        method2825(Rasterizer2D.graphicsPixels, int_2, int_6, 0, int_4 >> 14, int_5 >> 14);
                        int_4 += int_8;
                        int_5 += int_9;
                        int_2 += Rasterizer2D.graphicsPixelsWidth;
                    }
                } else {
                    int_1 -= int_0;
                    int_0 -= int_2;
                    int_2 = rasterClipY[int_2];

                    while (true) {
                        --int_0;
                        if (int_0 < 0) {
                            while (true) {
                                --int_1;
                                if (int_1 < 0) {
                                    return;
                                }

                                method2825(Rasterizer2D.graphicsPixels, int_2, int_6, 0, int_3 >> 14, int_4 >> 14);
                                int_4 += int_8;
                                int_3 += int_7;
                                int_2 += Rasterizer2D.graphicsPixelsWidth;
                            }
                        }

                        method2825(Rasterizer2D.graphicsPixels, int_2, int_6, 0, int_5 >> 14, int_4 >> 14);
                        int_4 += int_8;
                        int_5 += int_9;
                        int_2 += Rasterizer2D.graphicsPixelsWidth;
                    }
                }
            } else {
                int_3 = int_5 <<= 14;
                if (int_2 < 0) {
                    int_3 -= int_8 * int_2;
                    int_5 -= int_9 * int_2;
                    int_2 = 0;
                }

                int_4 <<= 14;
                if (int_1 < 0) {
                    int_4 -= int_7 * int_1;
                    int_1 = 0;
                }

                if (int_8 < int_9) {
                    int_0 -= int_1;
                    int_1 -= int_2;
                    int_2 = rasterClipY[int_2];

                    while (true) {
                        --int_1;
                        if (int_1 < 0) {
                            while (true) {
                                --int_0;
                                if (int_0 < 0) {
                                    return;
                                }

                                method2825(Rasterizer2D.graphicsPixels, int_2, int_6, 0, int_4 >> 14, int_5 >> 14);
                                int_4 += int_7;
                                int_5 += int_9;
                                int_2 += Rasterizer2D.graphicsPixelsWidth;
                            }
                        }

                        method2825(Rasterizer2D.graphicsPixels, int_2, int_6, 0, int_3 >> 14, int_5 >> 14);
                        int_3 += int_8;
                        int_5 += int_9;
                        int_2 += Rasterizer2D.graphicsPixelsWidth;
                    }
                } else {
                    int_0 -= int_1;
                    int_1 -= int_2;
                    int_2 = rasterClipY[int_2];

                    while (true) {
                        --int_1;
                        if (int_1 < 0) {
                            while (true) {
                                --int_0;
                                if (int_0 < 0) {
                                    return;
                                }

                                method2825(Rasterizer2D.graphicsPixels, int_2, int_6, 0, int_5 >> 14, int_4 >> 14);
                                int_4 += int_7;
                                int_5 += int_9;
                                int_2 += Rasterizer2D.graphicsPixelsWidth;
                            }
                        }

                        method2825(Rasterizer2D.graphicsPixels, int_2, int_6, 0, int_5 >> 14, int_3 >> 14);
                        int_3 += int_8;
                        int_5 += int_9;
                        int_2 += Rasterizer2D.graphicsPixelsWidth;
                    }
                }
            }
        }
    }

    static void method2825(final int[] ints_0, int int_0, int int_1, int int_2, int int_3, int int_4) {
        if (rasterClipEnable) {
            if (int_4 > rasterClipX) {
                int_4 = rasterClipX;
            }

            if (int_3 < 0) {
                int_3 = 0;
            }
        }

        if (int_3 < int_4) {
            int_0 += int_3;
            int_2 = (int_4 - int_3) >> 2;
            if (rasterAlpha != 0) {
                if (rasterAlpha == 254) {
                    while (true) {
                        --int_2;
                        if (int_2 < 0) {
                            int_2 = (int_4 - int_3) & 0x3;

                            while (true) {
                                --int_2;
                                if (int_2 < 0) {
                                    return;
                                }

                                ints_0[int_0++] = ints_0[int_0];
                            }
                        }

                        ints_0[int_0++] = ints_0[int_0];
                        ints_0[int_0++] = ints_0[int_0];
                        ints_0[int_0++] = ints_0[int_0];
                        ints_0[int_0++] = ints_0[int_0];
                    }
                } else {
                    final int int_5 = rasterAlpha;
                    final int int_6 = 256 - rasterAlpha;
                    int_1 = (((int_6 * (int_1 & 0xFF00)) >> 8) & 0xFF00)
                            + (((int_6 * (int_1 & 0xFF00FF)) >> 8) & 0xFF00FF);

                    while (true) {
                        --int_2;
                        int int_7;
                        if (int_2 < 0) {
                            int_2 = (int_4 - int_3) & 0x3;

                            while (true) {
                                --int_2;
                                if (int_2 < 0) {
                                    return;
                                }

                                int_7 = ints_0[int_0];
                                ints_0[int_0++] = ((((int_7 & 0xFF00FF) * int_5) >> 8) & 0xFF00FF) + int_1
                                        + (((int_5 * (int_7 & 0xFF00)) >> 8) & 0xFF00);
                            }
                        }

                        int_7 = ints_0[int_0];
                        ints_0[int_0++] = ((((int_7 & 0xFF00FF) * int_5) >> 8) & 0xFF00FF) + int_1
                                + (((int_5 * (int_7 & 0xFF00)) >> 8) & 0xFF00);
                        int_7 = ints_0[int_0];
                        ints_0[int_0++] = ((((int_7 & 0xFF00FF) * int_5) >> 8) & 0xFF00FF) + int_1
                                + (((int_5 * (int_7 & 0xFF00)) >> 8) & 0xFF00);
                        int_7 = ints_0[int_0];
                        ints_0[int_0++] = ((((int_7 & 0xFF00FF) * int_5) >> 8) & 0xFF00FF) + int_1
                                + (((int_5 * (int_7 & 0xFF00)) >> 8) & 0xFF00);
                        int_7 = ints_0[int_0];
                        ints_0[int_0++] = ((((int_7 & 0xFF00FF) * int_5) >> 8) & 0xFF00FF) + int_1
                                + (((int_5 * (int_7 & 0xFF00)) >> 8) & 0xFF00);
                    }
                }
            } else {
                while (true) {
                    --int_2;
                    if (int_2 < 0) {
                        int_2 = (int_4 - int_3) & 0x3;

                        while (true) {
                            --int_2;
                            if (int_2 < 0) {
                                return;
                            }

                            ints_0[int_0++] = int_1;
                        }
                    }

                    ints_0[int_0++] = int_1;
                    ints_0[int_0++] = int_1;
                    ints_0[int_0++] = int_1;
                    ints_0[int_0++] = int_1;
                }
            }
        }
    }

    static void rasterTextureAffine(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6,
                                    int int_7, int int_8, final int int_9, int int_10, int int_11, final int int_12, int int_13, int int_14,
                                    final int int_15, int int_16, int int_17, final int int_18) {
        final int[] ints_0 = textureLoader.load(int_18);
        int int_19;
        if (ints_0 == null) {
            int_19 = textureLoader.getAverageTextureRGB(int_18);
            rasterGouraud(int_0, int_1, int_2, int_3, int_4, int_5, method2802(int_19, int_6),
                    method2802(int_19, int_7), method2802(int_19, int_8));
        } else {
            lowMem = textureLoader.vmethod3082(int_18);
            field1668 = textureLoader.vmethod3081(int_18);
            int_19 = int_4 - int_3;
            final int int_20 = int_1 - int_0;
            final int int_21 = int_5 - int_3;
            final int int_22 = int_2 - int_0;
            final int int_23 = int_7 - int_6;
            final int int_24 = int_8 - int_6;
            int int_25 = 0;
            if (int_0 != int_1) {
                int_25 = ((int_4 - int_3) << 14) / (int_1 - int_0);
            }

            int int_26 = 0;
            if (int_2 != int_1) {
                int_26 = ((int_5 - int_4) << 14) / (int_2 - int_1);
            }

            int int_27 = 0;
            if (int_0 != int_2) {
                int_27 = ((int_3 - int_5) << 14) / (int_0 - int_2);
            }

            final int int_28 = (int_19 * int_22) - (int_21 * int_20);
            if (int_28 != 0) {
                final int int_29 = (((int_23 * int_22) - (int_24 * int_20)) << 9) / int_28;
                final int int_30 = (((int_24 * int_19) - (int_23 * int_21)) << 9) / int_28;
                int_10 = int_9 - int_10;
                int_13 = int_12 - int_13;
                int_16 = int_15 - int_16;
                int_11 -= int_9;
                int_14 -= int_12;
                int_17 -= int_15;
                int int_31 = ((int_11 * int_12) - (int_9 * int_14)) << 14;
                final int int_32 = (int) (((long) ((int_15 * int_14) - (int_17 * int_12)) << 3 << 14)
                        / Rasterizer3D_zoom);
                final int int_33 = (int) (((long) ((int_17 * int_9) - (int_11 * int_15)) << 14) / Rasterizer3D_zoom);
                int int_34 = ((int_10 * int_12) - (int_13 * int_9)) << 14;
                final int int_35 = (int) (((long) ((int_13 * int_15) - (int_16 * int_12)) << 3 << 14)
                        / Rasterizer3D_zoom);
                final int int_36 = (int) (((long) ((int_16 * int_9) - (int_10 * int_15)) << 14) / Rasterizer3D_zoom);
                int int_37 = ((int_13 * int_11) - (int_10 * int_14)) << 14;
                final int int_38 = (int) (((long) ((int_16 * int_14) - (int_13 * int_17)) << 3 << 14)
                        / Rasterizer3D_zoom);
                final int int_39 = (int) (((long) ((int_17 * int_10) - (int_11 * int_16)) << 14) / Rasterizer3D_zoom);
                int int_40;
                if ((int_0 <= int_1) && (int_0 <= int_2)) {
                    if (int_0 < Rasterizer3D_clipHeight) {
                        if (int_1 > Rasterizer3D_clipHeight) {
                            int_1 = Rasterizer3D_clipHeight;
                        }

                        if (int_2 > Rasterizer3D_clipHeight) {
                            int_2 = Rasterizer3D_clipHeight;
                        }

                        int_6 = int_29 + ((int_6 << 9) - (int_3 * int_29));
                        if (int_1 < int_2) {
                            int_5 = int_3 <<= 14;
                            if (int_0 < 0) {
                                int_5 -= int_0 * int_27;
                                int_3 -= int_0 * int_25;
                                int_6 -= int_0 * int_30;
                                int_0 = 0;
                            }

                            int_4 <<= 14;
                            if (int_1 < 0) {
                                int_4 -= int_26 * int_1;
                                int_1 = 0;
                            }

                            int_40 = int_0 - centerY;
                            int_31 += int_33 * int_40;
                            int_34 += int_36 * int_40;
                            int_37 += int_39 * int_40;
                            if (((int_0 != int_1) && (int_27 < int_25)) || ((int_0 == int_1) && (int_27 > int_26))) {
                                int_2 -= int_1;
                                int_1 -= int_0;
                                int_0 = rasterClipY[int_0];

                                while (true) {
                                    --int_1;
                                    if (int_1 < 0) {
                                        while (true) {
                                            --int_2;
                                            if (int_2 < 0) {
                                                return;
                                            }

                                            method2813(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_0, int_5 >> 14,
                                                    int_4 >> 14, int_6, int_29, int_31, int_34, int_37, int_32, int_35,
                                                    int_38);
                                            int_5 += int_27;
                                            int_4 += int_26;
                                            int_6 += int_30;
                                            int_0 += Rasterizer2D.graphicsPixelsWidth;
                                            int_31 += int_33;
                                            int_34 += int_36;
                                            int_37 += int_39;
                                        }
                                    }

                                    method2813(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_0, int_5 >> 14,
                                            int_3 >> 14, int_6, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                                    int_5 += int_27;
                                    int_3 += int_25;
                                    int_6 += int_30;
                                    int_0 += Rasterizer2D.graphicsPixelsWidth;
                                    int_31 += int_33;
                                    int_34 += int_36;
                                    int_37 += int_39;
                                }
                            } else {
                                int_2 -= int_1;
                                int_1 -= int_0;
                                int_0 = rasterClipY[int_0];

                                while (true) {
                                    --int_1;
                                    if (int_1 < 0) {
                                        while (true) {
                                            --int_2;
                                            if (int_2 < 0) {
                                                return;
                                            }

                                            method2813(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_0, int_4 >> 14,
                                                    int_5 >> 14, int_6, int_29, int_31, int_34, int_37, int_32, int_35,
                                                    int_38);
                                            int_5 += int_27;
                                            int_4 += int_26;
                                            int_6 += int_30;
                                            int_0 += Rasterizer2D.graphicsPixelsWidth;
                                            int_31 += int_33;
                                            int_34 += int_36;
                                            int_37 += int_39;
                                        }
                                    }

                                    method2813(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_0, int_3 >> 14,
                                            int_5 >> 14, int_6, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                                    int_5 += int_27;
                                    int_3 += int_25;
                                    int_6 += int_30;
                                    int_0 += Rasterizer2D.graphicsPixelsWidth;
                                    int_31 += int_33;
                                    int_34 += int_36;
                                    int_37 += int_39;
                                }
                            }
                        } else {
                            int_4 = int_3 <<= 14;
                            if (int_0 < 0) {
                                int_4 -= int_0 * int_27;
                                int_3 -= int_0 * int_25;
                                int_6 -= int_0 * int_30;
                                int_0 = 0;
                            }

                            int_5 <<= 14;
                            if (int_2 < 0) {
                                int_5 -= int_26 * int_2;
                                int_2 = 0;
                            }

                            int_40 = int_0 - centerY;
                            int_31 += int_33 * int_40;
                            int_34 += int_36 * int_40;
                            int_37 += int_39 * int_40;
                            if (((int_0 == int_2) || (int_27 >= int_25)) && ((int_0 != int_2) || (int_26 <= int_25))) {
                                int_1 -= int_2;
                                int_2 -= int_0;
                                int_0 = rasterClipY[int_0];

                                while (true) {
                                    --int_2;
                                    if (int_2 < 0) {
                                        while (true) {
                                            --int_1;
                                            if (int_1 < 0) {
                                                return;
                                            }

                                            method2813(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_0, int_3 >> 14,
                                                    int_5 >> 14, int_6, int_29, int_31, int_34, int_37, int_32, int_35,
                                                    int_38);
                                            int_5 += int_26;
                                            int_3 += int_25;
                                            int_6 += int_30;
                                            int_0 += Rasterizer2D.graphicsPixelsWidth;
                                            int_31 += int_33;
                                            int_34 += int_36;
                                            int_37 += int_39;
                                        }
                                    }

                                    method2813(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_0, int_3 >> 14,
                                            int_4 >> 14, int_6, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                                    int_4 += int_27;
                                    int_3 += int_25;
                                    int_6 += int_30;
                                    int_0 += Rasterizer2D.graphicsPixelsWidth;
                                    int_31 += int_33;
                                    int_34 += int_36;
                                    int_37 += int_39;
                                }
                            } else {
                                int_1 -= int_2;
                                int_2 -= int_0;
                                int_0 = rasterClipY[int_0];

                                while (true) {
                                    --int_2;
                                    if (int_2 < 0) {
                                        while (true) {
                                            --int_1;
                                            if (int_1 < 0) {
                                                return;
                                            }

                                            method2813(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_0, int_5 >> 14,
                                                    int_3 >> 14, int_6, int_29, int_31, int_34, int_37, int_32, int_35,
                                                    int_38);
                                            int_5 += int_26;
                                            int_3 += int_25;
                                            int_6 += int_30;
                                            int_0 += Rasterizer2D.graphicsPixelsWidth;
                                            int_31 += int_33;
                                            int_34 += int_36;
                                            int_37 += int_39;
                                        }
                                    }

                                    method2813(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_0, int_4 >> 14,
                                            int_3 >> 14, int_6, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                                    int_4 += int_27;
                                    int_3 += int_25;
                                    int_6 += int_30;
                                    int_0 += Rasterizer2D.graphicsPixelsWidth;
                                    int_31 += int_33;
                                    int_34 += int_36;
                                    int_37 += int_39;
                                }
                            }
                        }
                    }
                } else if (int_1 <= int_2) {
                    if (int_1 < Rasterizer3D_clipHeight) {
                        if (int_2 > Rasterizer3D_clipHeight) {
                            int_2 = Rasterizer3D_clipHeight;
                        }

                        if (int_0 > Rasterizer3D_clipHeight) {
                            int_0 = Rasterizer3D_clipHeight;
                        }

                        int_7 = int_29 + ((int_7 << 9) - (int_29 * int_4));
                        if (int_2 < int_0) {
                            int_3 = int_4 <<= 14;
                            if (int_1 < 0) {
                                int_3 -= int_25 * int_1;
                                int_4 -= int_26 * int_1;
                                int_7 -= int_30 * int_1;
                                int_1 = 0;
                            }

                            int_5 <<= 14;
                            if (int_2 < 0) {
                                int_5 -= int_27 * int_2;
                                int_2 = 0;
                            }

                            int_40 = int_1 - centerY;
                            int_31 += int_33 * int_40;
                            int_34 += int_36 * int_40;
                            int_37 += int_39 * int_40;
                            if (((int_2 != int_1) && (int_25 < int_26)) || ((int_2 == int_1) && (int_25 > int_27))) {
                                int_0 -= int_2;
                                int_2 -= int_1;
                                int_1 = rasterClipY[int_1];

                                while (true) {
                                    --int_2;
                                    if (int_2 < 0) {
                                        while (true) {
                                            --int_0;
                                            if (int_0 < 0) {
                                                return;
                                            }

                                            method2813(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_1, int_3 >> 14,
                                                    int_5 >> 14, int_7, int_29, int_31, int_34, int_37, int_32, int_35,
                                                    int_38);
                                            int_3 += int_25;
                                            int_5 += int_27;
                                            int_7 += int_30;
                                            int_1 += Rasterizer2D.graphicsPixelsWidth;
                                            int_31 += int_33;
                                            int_34 += int_36;
                                            int_37 += int_39;
                                        }
                                    }

                                    method2813(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_1, int_3 >> 14,
                                            int_4 >> 14, int_7, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                                    int_3 += int_25;
                                    int_4 += int_26;
                                    int_7 += int_30;
                                    int_1 += Rasterizer2D.graphicsPixelsWidth;
                                    int_31 += int_33;
                                    int_34 += int_36;
                                    int_37 += int_39;
                                }
                            } else {
                                int_0 -= int_2;
                                int_2 -= int_1;
                                int_1 = rasterClipY[int_1];

                                while (true) {
                                    --int_2;
                                    if (int_2 < 0) {
                                        while (true) {
                                            --int_0;
                                            if (int_0 < 0) {
                                                return;
                                            }

                                            method2813(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_1, int_5 >> 14,
                                                    int_3 >> 14, int_7, int_29, int_31, int_34, int_37, int_32, int_35,
                                                    int_38);
                                            int_3 += int_25;
                                            int_5 += int_27;
                                            int_7 += int_30;
                                            int_1 += Rasterizer2D.graphicsPixelsWidth;
                                            int_31 += int_33;
                                            int_34 += int_36;
                                            int_37 += int_39;
                                        }
                                    }

                                    method2813(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_1, int_4 >> 14,
                                            int_3 >> 14, int_7, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                                    int_3 += int_25;
                                    int_4 += int_26;
                                    int_7 += int_30;
                                    int_1 += Rasterizer2D.graphicsPixelsWidth;
                                    int_31 += int_33;
                                    int_34 += int_36;
                                    int_37 += int_39;
                                }
                            }
                        } else {
                            int_5 = int_4 <<= 14;
                            if (int_1 < 0) {
                                int_5 -= int_25 * int_1;
                                int_4 -= int_26 * int_1;
                                int_7 -= int_30 * int_1;
                                int_1 = 0;
                            }

                            int_3 <<= 14;
                            if (int_0 < 0) {
                                int_3 -= int_0 * int_27;
                                int_0 = 0;
                            }

                            int_40 = int_1 - centerY;
                            int_31 += int_33 * int_40;
                            int_34 += int_36 * int_40;
                            int_37 += int_39 * int_40;
                            if (int_25 < int_26) {
                                int_2 -= int_0;
                                int_0 -= int_1;
                                int_1 = rasterClipY[int_1];

                                while (true) {
                                    --int_0;
                                    if (int_0 < 0) {
                                        while (true) {
                                            --int_2;
                                            if (int_2 < 0) {
                                                return;
                                            }

                                            method2813(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_1, int_3 >> 14,
                                                    int_4 >> 14, int_7, int_29, int_31, int_34, int_37, int_32, int_35,
                                                    int_38);
                                            int_3 += int_27;
                                            int_4 += int_26;
                                            int_7 += int_30;
                                            int_1 += Rasterizer2D.graphicsPixelsWidth;
                                            int_31 += int_33;
                                            int_34 += int_36;
                                            int_37 += int_39;
                                        }
                                    }

                                    method2813(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_1, int_5 >> 14,
                                            int_4 >> 14, int_7, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                                    int_5 += int_25;
                                    int_4 += int_26;
                                    int_7 += int_30;
                                    int_1 += Rasterizer2D.graphicsPixelsWidth;
                                    int_31 += int_33;
                                    int_34 += int_36;
                                    int_37 += int_39;
                                }
                            } else {
                                int_2 -= int_0;
                                int_0 -= int_1;
                                int_1 = rasterClipY[int_1];

                                while (true) {
                                    --int_0;
                                    if (int_0 < 0) {
                                        while (true) {
                                            --int_2;
                                            if (int_2 < 0) {
                                                return;
                                            }

                                            method2813(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_1, int_4 >> 14,
                                                    int_3 >> 14, int_7, int_29, int_31, int_34, int_37, int_32, int_35,
                                                    int_38);
                                            int_3 += int_27;
                                            int_4 += int_26;
                                            int_7 += int_30;
                                            int_1 += Rasterizer2D.graphicsPixelsWidth;
                                            int_31 += int_33;
                                            int_34 += int_36;
                                            int_37 += int_39;
                                        }
                                    }

                                    method2813(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_1, int_4 >> 14,
                                            int_5 >> 14, int_7, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                                    int_5 += int_25;
                                    int_4 += int_26;
                                    int_7 += int_30;
                                    int_1 += Rasterizer2D.graphicsPixelsWidth;
                                    int_31 += int_33;
                                    int_34 += int_36;
                                    int_37 += int_39;
                                }
                            }
                        }
                    }
                } else if (int_2 < Rasterizer3D_clipHeight) {
                    if (int_0 > Rasterizer3D_clipHeight) {
                        int_0 = Rasterizer3D_clipHeight;
                    }

                    if (int_1 > Rasterizer3D_clipHeight) {
                        int_1 = Rasterizer3D_clipHeight;
                    }

                    int_8 = ((int_8 << 9) - (int_5 * int_29)) + int_29;
                    if (int_0 < int_1) {
                        int_4 = int_5 <<= 14;
                        if (int_2 < 0) {
                            int_4 -= int_26 * int_2;
                            int_5 -= int_27 * int_2;
                            int_8 -= int_30 * int_2;
                            int_2 = 0;
                        }

                        int_3 <<= 14;
                        if (int_0 < 0) {
                            int_3 -= int_0 * int_25;
                            int_0 = 0;
                        }

                        int_40 = int_2 - centerY;
                        int_31 += int_33 * int_40;
                        int_34 += int_36 * int_40;
                        int_37 += int_39 * int_40;
                        if (int_26 < int_27) {
                            int_1 -= int_0;
                            int_0 -= int_2;
                            int_2 = rasterClipY[int_2];

                            while (true) {
                                --int_0;
                                if (int_0 < 0) {
                                    while (true) {
                                        --int_1;
                                        if (int_1 < 0) {
                                            return;
                                        }

                                        method2813(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_2, int_4 >> 14,
                                                int_3 >> 14, int_8, int_29, int_31, int_34, int_37, int_32, int_35,
                                                int_38);
                                        int_4 += int_26;
                                        int_3 += int_25;
                                        int_8 += int_30;
                                        int_2 += Rasterizer2D.graphicsPixelsWidth;
                                        int_31 += int_33;
                                        int_34 += int_36;
                                        int_37 += int_39;
                                    }
                                }

                                method2813(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_2, int_4 >> 14, int_5 >> 14,
                                        int_8, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                                int_4 += int_26;
                                int_5 += int_27;
                                int_8 += int_30;
                                int_2 += Rasterizer2D.graphicsPixelsWidth;
                                int_31 += int_33;
                                int_34 += int_36;
                                int_37 += int_39;
                            }
                        } else {
                            int_1 -= int_0;
                            int_0 -= int_2;
                            int_2 = rasterClipY[int_2];

                            while (true) {
                                --int_0;
                                if (int_0 < 0) {
                                    while (true) {
                                        --int_1;
                                        if (int_1 < 0) {
                                            return;
                                        }

                                        method2813(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_2, int_3 >> 14,
                                                int_4 >> 14, int_8, int_29, int_31, int_34, int_37, int_32, int_35,
                                                int_38);
                                        int_4 += int_26;
                                        int_3 += int_25;
                                        int_8 += int_30;
                                        int_2 += Rasterizer2D.graphicsPixelsWidth;
                                        int_31 += int_33;
                                        int_34 += int_36;
                                        int_37 += int_39;
                                    }
                                }

                                method2813(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_2, int_5 >> 14, int_4 >> 14,
                                        int_8, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                                int_4 += int_26;
                                int_5 += int_27;
                                int_8 += int_30;
                                int_2 += Rasterizer2D.graphicsPixelsWidth;
                                int_31 += int_33;
                                int_34 += int_36;
                                int_37 += int_39;
                            }
                        }
                    } else {
                        int_3 = int_5 <<= 14;
                        if (int_2 < 0) {
                            int_3 -= int_26 * int_2;
                            int_5 -= int_27 * int_2;
                            int_8 -= int_30 * int_2;
                            int_2 = 0;
                        }

                        int_4 <<= 14;
                        if (int_1 < 0) {
                            int_4 -= int_25 * int_1;
                            int_1 = 0;
                        }

                        int_40 = int_2 - centerY;
                        int_31 += int_33 * int_40;
                        int_34 += int_36 * int_40;
                        int_37 += int_39 * int_40;
                        if (int_26 < int_27) {
                            int_0 -= int_1;
                            int_1 -= int_2;
                            int_2 = rasterClipY[int_2];

                            while (true) {
                                --int_1;
                                if (int_1 < 0) {
                                    while (true) {
                                        --int_0;
                                        if (int_0 < 0) {
                                            return;
                                        }

                                        method2813(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_2, int_4 >> 14,
                                                int_5 >> 14, int_8, int_29, int_31, int_34, int_37, int_32, int_35,
                                                int_38);
                                        int_4 += int_25;
                                        int_5 += int_27;
                                        int_8 += int_30;
                                        int_2 += Rasterizer2D.graphicsPixelsWidth;
                                        int_31 += int_33;
                                        int_34 += int_36;
                                        int_37 += int_39;
                                    }
                                }

                                method2813(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_2, int_3 >> 14, int_5 >> 14,
                                        int_8, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                                int_3 += int_26;
                                int_5 += int_27;
                                int_8 += int_30;
                                int_2 += Rasterizer2D.graphicsPixelsWidth;
                                int_31 += int_33;
                                int_34 += int_36;
                                int_37 += int_39;
                            }
                        } else {
                            int_0 -= int_1;
                            int_1 -= int_2;
                            int_2 = rasterClipY[int_2];

                            while (true) {
                                --int_1;
                                if (int_1 < 0) {
                                    while (true) {
                                        --int_0;
                                        if (int_0 < 0) {
                                            return;
                                        }

                                        method2813(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_2, int_5 >> 14,
                                                int_4 >> 14, int_8, int_29, int_31, int_34, int_37, int_32, int_35,
                                                int_38);
                                        int_4 += int_25;
                                        int_5 += int_27;
                                        int_8 += int_30;
                                        int_2 += Rasterizer2D.graphicsPixelsWidth;
                                        int_31 += int_33;
                                        int_34 += int_36;
                                        int_37 += int_39;
                                    }
                                }

                                method2813(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_2, int_5 >> 14, int_3 >> 14,
                                        int_8, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                                int_3 += int_26;
                                int_5 += int_27;
                                int_8 += int_30;
                                int_2 += Rasterizer2D.graphicsPixelsWidth;
                                int_31 += int_33;
                                int_34 += int_36;
                                int_37 += int_39;
                            }
                        }
                    }
                }
            }
        }
    }

    static void method2813(final int[] ints_0, final int[] ints_1, int int_0, int int_1, int int_2, int int_3,
                           int int_4, int int_5, int int_6, int int_7, int int_8, int int_9, final int int_10, final int int_11,
                           final int int_12) {
        if (rasterClipEnable) {
            if (int_4 > rasterClipX) {
                int_4 = rasterClipX;
            }

            if (int_3 < 0) {
                int_3 = 0;
            }
        }

        if (int_3 < int_4) {
            int_2 += int_3;
            int_5 += int_3 * int_6;
            int int_13 = int_4 - int_3;
            int int_14;
            int int_16;
            int int_17;
            int int_18;
            int int_19;
            int int_20;
            int int_21;
            int int_22;
            if (lowMem) {
                int_14 = int_3 - centerX;
                int_7 += int_14 * (int_10 >> 3);
                int_8 += (int_11 >> 3) * int_14;
                int_9 += int_14 * (int_12 >> 3);
                int_16 = int_9 >> 12;
                if (int_16 != 0) {
                    int_17 = int_7 / int_16;
                    int_18 = int_8 / int_16;
                    if (int_17 < 0) {
                        int_17 = 0;
                    } else if (int_17 > 4032) {
                        int_17 = 4032;
                    }
                } else {
                    int_17 = 0;
                    int_18 = 0;
                }

                int_7 += int_10;
                int_8 += int_11;
                int_9 += int_12;
                int_16 = int_9 >> 12;
                if (int_16 != 0) {
                    int_19 = int_7 / int_16;
                    int_20 = int_8 / int_16;
                    if (int_19 < 0) {
                        int_19 = 0;
                    } else if (int_19 > 4032) {
                        int_19 = 4032;
                    }
                } else {
                    int_19 = 0;
                    int_20 = 0;
                }

                int_0 = (int_17 << 20) + int_18;
                int_21 = ((int_20 - int_18) >> 3) + (((int_19 - int_17) >> 3) << 20);
                int_13 >>= 3;
                int_6 <<= 3;
                int_22 = int_5 >> 8;
                if (field1668) {
                    if (int_13 > 0) {
                        do {
                            int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)];
                            ints_0[int_2++] = (((int_22 * (int_1 & 0xFF00)) & 0xFF0000)
                                    + (((int_1 & 0xFF00FF) * int_22) & 0xFF00FF00)) >> 8;
                            int_0 += int_21;
                            int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)];
                            ints_0[int_2++] = (((int_22 * (int_1 & 0xFF00)) & 0xFF0000)
                                    + (((int_1 & 0xFF00FF) * int_22) & 0xFF00FF00)) >> 8;
                            int_0 += int_21;
                            int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)];
                            ints_0[int_2++] = (((int_22 * (int_1 & 0xFF00)) & 0xFF0000)
                                    + (((int_1 & 0xFF00FF) * int_22) & 0xFF00FF00)) >> 8;
                            int_0 += int_21;
                            int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)];
                            ints_0[int_2++] = (((int_22 * (int_1 & 0xFF00)) & 0xFF0000)
                                    + (((int_1 & 0xFF00FF) * int_22) & 0xFF00FF00)) >> 8;
                            int_0 += int_21;
                            int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)];
                            ints_0[int_2++] = (((int_22 * (int_1 & 0xFF00)) & 0xFF0000)
                                    + (((int_1 & 0xFF00FF) * int_22) & 0xFF00FF00)) >> 8;
                            int_0 += int_21;
                            int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)];
                            ints_0[int_2++] = (((int_22 * (int_1 & 0xFF00)) & 0xFF0000)
                                    + (((int_1 & 0xFF00FF) * int_22) & 0xFF00FF00)) >> 8;
                            int_0 += int_21;
                            int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)];
                            ints_0[int_2++] = (((int_22 * (int_1 & 0xFF00)) & 0xFF0000)
                                    + (((int_1 & 0xFF00FF) * int_22) & 0xFF00FF00)) >> 8;
                            int_0 += int_21;
                            int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)];
                            ints_0[int_2++] = (((int_22 * (int_1 & 0xFF00)) & 0xFF0000)
                                    + (((int_1 & 0xFF00FF) * int_22) & 0xFF00FF00)) >> 8;
                            int_17 = int_19;
                            int_18 = int_20;
                            int_7 += int_10;
                            int_8 += int_11;
                            int_9 += int_12;
                            int_16 = int_9 >> 12;
                            if (int_16 != 0) {
                                int_19 = int_7 / int_16;
                                int_20 = int_8 / int_16;
                                if (int_19 < 0) {
                                    int_19 = 0;
                                } else if (int_19 > 4032) {
                                    int_19 = 4032;
                                }
                            } else {
                                int_19 = 0;
                                int_20 = 0;
                            }

                            int_0 = (int_17 << 20) + int_18;
                            int_21 = ((int_20 - int_18) >> 3) + (((int_19 - int_17) >> 3) << 20);
                            int_5 += int_6;
                            int_22 = int_5 >> 8;
                            --int_13;
                        }
                        while (int_13 > 0);
                    }

                    int_13 = (int_4 - int_3) & 0x7;
                    if (int_13 > 0) {
                        do {
                            int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)];
                            ints_0[int_2++] = (((int_22 * (int_1 & 0xFF00)) & 0xFF0000)
                                    + (((int_1 & 0xFF00FF) * int_22) & 0xFF00FF00)) >> 8;
                            int_0 += int_21;
                            --int_13;
                        }
                        while (int_13 > 0);
                    }
                } else {
                    if (int_13 > 0) {
                        do {
                            if ((int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)]) != 0) {
                                ints_0[int_2] = (((int_22 * (int_1 & 0xFF00)) & 0xFF0000)
                                        + (((int_1 & 0xFF00FF) * int_22) & 0xFF00FF00)) >> 8;
                            }

                            ++int_2;
                            int_0 += int_21;
                            if ((int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)]) != 0) {
                                ints_0[int_2] = (((int_22 * (int_1 & 0xFF00)) & 0xFF0000)
                                        + (((int_1 & 0xFF00FF) * int_22) & 0xFF00FF00)) >> 8;
                            }

                            ++int_2;
                            int_0 += int_21;
                            if ((int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)]) != 0) {
                                ints_0[int_2] = (((int_22 * (int_1 & 0xFF00)) & 0xFF0000)
                                        + (((int_1 & 0xFF00FF) * int_22) & 0xFF00FF00)) >> 8;
                            }

                            ++int_2;
                            int_0 += int_21;
                            if ((int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)]) != 0) {
                                ints_0[int_2] = (((int_22 * (int_1 & 0xFF00)) & 0xFF0000)
                                        + (((int_1 & 0xFF00FF) * int_22) & 0xFF00FF00)) >> 8;
                            }

                            ++int_2;
                            int_0 += int_21;
                            if ((int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)]) != 0) {
                                ints_0[int_2] = (((int_22 * (int_1 & 0xFF00)) & 0xFF0000)
                                        + (((int_1 & 0xFF00FF) * int_22) & 0xFF00FF00)) >> 8;
                            }

                            ++int_2;
                            int_0 += int_21;
                            if ((int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)]) != 0) {
                                ints_0[int_2] = (((int_22 * (int_1 & 0xFF00)) & 0xFF0000)
                                        + (((int_1 & 0xFF00FF) * int_22) & 0xFF00FF00)) >> 8;
                            }

                            ++int_2;
                            int_0 += int_21;
                            if ((int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)]) != 0) {
                                ints_0[int_2] = (((int_22 * (int_1 & 0xFF00)) & 0xFF0000)
                                        + (((int_1 & 0xFF00FF) * int_22) & 0xFF00FF00)) >> 8;
                            }

                            ++int_2;
                            int_0 += int_21;
                            if ((int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)]) != 0) {
                                ints_0[int_2] = (((int_22 * (int_1 & 0xFF00)) & 0xFF0000)
                                        + (((int_1 & 0xFF00FF) * int_22) & 0xFF00FF00)) >> 8;
                            }

                            ++int_2;
                            int_17 = int_19;
                            int_18 = int_20;
                            int_7 += int_10;
                            int_8 += int_11;
                            int_9 += int_12;
                            int_16 = int_9 >> 12;
                            if (int_16 != 0) {
                                int_19 = int_7 / int_16;
                                int_20 = int_8 / int_16;
                                if (int_19 < 0) {
                                    int_19 = 0;
                                } else if (int_19 > 4032) {
                                    int_19 = 4032;
                                }
                            } else {
                                int_19 = 0;
                                int_20 = 0;
                            }

                            int_0 = (int_17 << 20) + int_18;
                            int_21 = ((int_20 - int_18) >> 3) + (((int_19 - int_17) >> 3) << 20);
                            int_5 += int_6;
                            int_22 = int_5 >> 8;
                            --int_13;
                        }
                        while (int_13 > 0);
                    }

                    int_13 = (int_4 - int_3) & 0x7;
                    if (int_13 > 0) {
                        do {
                            if ((int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)]) != 0) {
                                ints_0[int_2] = (((int_22 * (int_1 & 0xFF00)) & 0xFF0000)
                                        + (((int_1 & 0xFF00FF) * int_22) & 0xFF00FF00)) >> 8;
                            }

                            ++int_2;
                            int_0 += int_21;
                            --int_13;
                        }
                        while (int_13 > 0);
                    }
                }
            } else {
                int_14 = int_3 - centerX;
                int_7 += int_14 * (int_10 >> 3);
                int_8 += (int_11 >> 3) * int_14;
                int_9 += int_14 * (int_12 >> 3);
                int_16 = int_9 >> 14;
                if (int_16 != 0) {
                    int_17 = int_7 / int_16;
                    int_18 = int_8 / int_16;
                    if (int_17 < 0) {
                        int_17 = 0;
                    } else if (int_17 > 16256) {
                        int_17 = 16256;
                    }
                } else {
                    int_17 = 0;
                    int_18 = 0;
                }

                int_7 += int_10;
                int_8 += int_11;
                int_9 += int_12;
                int_16 = int_9 >> 14;
                if (int_16 != 0) {
                    int_19 = int_7 / int_16;
                    int_20 = int_8 / int_16;
                    if (int_19 < 0) {
                        int_19 = 0;
                    } else if (int_19 > 16256) {
                        int_19 = 16256;
                    }
                } else {
                    int_19 = 0;
                    int_20 = 0;
                }

                int_0 = (int_17 << 18) + int_18;
                int_21 = ((int_20 - int_18) >> 3) + (((int_19 - int_17) >> 3) << 18);
                int_13 >>= 3;
                int_6 <<= 3;
                int_22 = int_5 >> 8;
                if (field1668) {
                    if (int_13 > 0) {
                        do {
                            int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)];
                            ints_0[int_2++] = (((int_22 * (int_1 & 0xFF00)) & 0xFF0000)
                                    + (((int_1 & 0xFF00FF) * int_22) & 0xFF00FF00)) >> 8;
                            int_0 += int_21;
                            int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)];
                            ints_0[int_2++] = (((int_22 * (int_1 & 0xFF00)) & 0xFF0000)
                                    + (((int_1 & 0xFF00FF) * int_22) & 0xFF00FF00)) >> 8;
                            int_0 += int_21;
                            int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)];
                            ints_0[int_2++] = (((int_22 * (int_1 & 0xFF00)) & 0xFF0000)
                                    + (((int_1 & 0xFF00FF) * int_22) & 0xFF00FF00)) >> 8;
                            int_0 += int_21;
                            int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)];
                            ints_0[int_2++] = (((int_22 * (int_1 & 0xFF00)) & 0xFF0000)
                                    + (((int_1 & 0xFF00FF) * int_22) & 0xFF00FF00)) >> 8;
                            int_0 += int_21;
                            int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)];
                            ints_0[int_2++] = (((int_22 * (int_1 & 0xFF00)) & 0xFF0000)
                                    + (((int_1 & 0xFF00FF) * int_22) & 0xFF00FF00)) >> 8;
                            int_0 += int_21;
                            int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)];
                            ints_0[int_2++] = (((int_22 * (int_1 & 0xFF00)) & 0xFF0000)
                                    + (((int_1 & 0xFF00FF) * int_22) & 0xFF00FF00)) >> 8;
                            int_0 += int_21;
                            int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)];
                            ints_0[int_2++] = (((int_22 * (int_1 & 0xFF00)) & 0xFF0000)
                                    + (((int_1 & 0xFF00FF) * int_22) & 0xFF00FF00)) >> 8;
                            int_0 += int_21;
                            int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)];
                            ints_0[int_2++] = (((int_22 * (int_1 & 0xFF00)) & 0xFF0000)
                                    + (((int_1 & 0xFF00FF) * int_22) & 0xFF00FF00)) >> 8;
                            int_17 = int_19;
                            int_18 = int_20;
                            int_7 += int_10;
                            int_8 += int_11;
                            int_9 += int_12;
                            int_16 = int_9 >> 14;
                            if (int_16 != 0) {
                                int_19 = int_7 / int_16;
                                int_20 = int_8 / int_16;
                                if (int_19 < 0) {
                                    int_19 = 0;
                                } else if (int_19 > 16256) {
                                    int_19 = 16256;
                                }
                            } else {
                                int_19 = 0;
                                int_20 = 0;
                            }

                            int_0 = (int_17 << 18) + int_18;
                            int_21 = ((int_20 - int_18) >> 3) + (((int_19 - int_17) >> 3) << 18);
                            int_5 += int_6;
                            int_22 = int_5 >> 8;
                            --int_13;
                        }
                        while (int_13 > 0);
                    }

                    int_13 = (int_4 - int_3) & 0x7;
                    if (int_13 > 0) {
                        do {
                            int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)];
                            ints_0[int_2++] = (((int_22 * (int_1 & 0xFF00)) & 0xFF0000)
                                    + (((int_1 & 0xFF00FF) * int_22) & 0xFF00FF00)) >> 8;
                            int_0 += int_21;
                            --int_13;
                        }
                        while (int_13 > 0);
                    }
                } else {
                    if (int_13 > 0) {
                        do {
                            if ((int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)]) != 0) {
                                ints_0[int_2] = (((int_22 * (int_1 & 0xFF00)) & 0xFF0000)
                                        + (((int_1 & 0xFF00FF) * int_22) & 0xFF00FF00)) >> 8;
                            }

                            ++int_2;
                            int_0 += int_21;
                            if ((int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)]) != 0) {
                                ints_0[int_2] = (((int_22 * (int_1 & 0xFF00)) & 0xFF0000)
                                        + (((int_1 & 0xFF00FF) * int_22) & 0xFF00FF00)) >> 8;
                            }

                            ++int_2;
                            int_0 += int_21;
                            if ((int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)]) != 0) {
                                ints_0[int_2] = (((int_22 * (int_1 & 0xFF00)) & 0xFF0000)
                                        + (((int_1 & 0xFF00FF) * int_22) & 0xFF00FF00)) >> 8;
                            }

                            ++int_2;
                            int_0 += int_21;
                            if ((int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)]) != 0) {
                                ints_0[int_2] = (((int_22 * (int_1 & 0xFF00)) & 0xFF0000)
                                        + (((int_1 & 0xFF00FF) * int_22) & 0xFF00FF00)) >> 8;
                            }

                            ++int_2;
                            int_0 += int_21;
                            if ((int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)]) != 0) {
                                ints_0[int_2] = (((int_22 * (int_1 & 0xFF00)) & 0xFF0000)
                                        + (((int_1 & 0xFF00FF) * int_22) & 0xFF00FF00)) >> 8;
                            }

                            ++int_2;
                            int_0 += int_21;
                            if ((int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)]) != 0) {
                                ints_0[int_2] = (((int_22 * (int_1 & 0xFF00)) & 0xFF0000)
                                        + (((int_1 & 0xFF00FF) * int_22) & 0xFF00FF00)) >> 8;
                            }

                            ++int_2;
                            int_0 += int_21;
                            if ((int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)]) != 0) {
                                ints_0[int_2] = (((int_22 * (int_1 & 0xFF00)) & 0xFF0000)
                                        + (((int_1 & 0xFF00FF) * int_22) & 0xFF00FF00)) >> 8;
                            }

                            ++int_2;
                            int_0 += int_21;
                            if ((int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)]) != 0) {
                                ints_0[int_2] = (((int_22 * (int_1 & 0xFF00)) & 0xFF0000)
                                        + (((int_1 & 0xFF00FF) * int_22) & 0xFF00FF00)) >> 8;
                            }

                            ++int_2;
                            int_17 = int_19;
                            int_18 = int_20;
                            int_7 += int_10;
                            int_8 += int_11;
                            int_9 += int_12;
                            int_16 = int_9 >> 14;
                            if (int_16 != 0) {
                                int_19 = int_7 / int_16;
                                int_20 = int_8 / int_16;
                                if (int_19 < 0) {
                                    int_19 = 0;
                                } else if (int_19 > 16256) {
                                    int_19 = 16256;
                                }
                            } else {
                                int_19 = 0;
                                int_20 = 0;
                            }

                            int_0 = (int_17 << 18) + int_18;
                            int_21 = ((int_20 - int_18) >> 3) + (((int_19 - int_17) >> 3) << 18);
                            int_5 += int_6;
                            int_22 = int_5 >> 8;
                            --int_13;
                        }
                        while (int_13 > 0);
                    }

                    int_13 = (int_4 - int_3) & 0x7;
                    if (int_13 > 0) {
                        do {
                            if ((int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)]) != 0) {
                                ints_0[int_2] = (((int_22 * (int_1 & 0xFF00)) & 0xFF0000)
                                        + (((int_1 & 0xFF00FF) * int_22) & 0xFF00FF00)) >> 8;
                            }

                            ++int_2;
                            int_0 += int_21;
                            --int_13;
                        }
                        while (int_13 > 0);
                    }
                }
            }

        }
    }

    static void rasterTexture(int int_0, int int_1, int int_2, int int_3, int int_4, int int_5, int int_6, int int_7,
                              int int_8, final int int_9, int int_10, int int_11, final int int_12, int int_13, int int_14,
                              final int int_15, int int_16, int int_17, final int int_18) {
        final int[] ints_0 = textureLoader.load(int_18);
        int int_19;
        if (ints_0 == null) {
            int_19 = textureLoader.getAverageTextureRGB(int_18);
            rasterGouraud(int_0, int_1, int_2, int_3, int_4, int_5, method2802(int_19, int_6),
                    method2802(int_19, int_7), method2802(int_19, int_8));
        } else {
            lowMem = textureLoader.vmethod3082(int_18);
            field1668 = textureLoader.vmethod3081(int_18);
            int_19 = int_4 - int_3;
            final int int_20 = int_1 - int_0;
            final int int_21 = int_5 - int_3;
            final int int_22 = int_2 - int_0;
            final int int_23 = int_7 - int_6;
            final int int_24 = int_8 - int_6;
            int int_25 = 0;
            if (int_0 != int_1) {
                int_25 = ((int_4 - int_3) << 14) / (int_1 - int_0);
            }

            int int_26 = 0;
            if (int_2 != int_1) {
                int_26 = ((int_5 - int_4) << 14) / (int_2 - int_1);
            }

            int int_27 = 0;
            if (int_0 != int_2) {
                int_27 = ((int_3 - int_5) << 14) / (int_0 - int_2);
            }

            final int int_28 = (int_19 * int_22) - (int_21 * int_20);
            if (int_28 != 0) {
                final int int_29 = (((int_23 * int_22) - (int_24 * int_20)) << 9) / int_28;
                final int int_30 = (((int_24 * int_19) - (int_23 * int_21)) << 9) / int_28;
                int_10 = int_9 - int_10;
                int_13 = int_12 - int_13;
                int_16 = int_15 - int_16;
                int_11 -= int_9;
                int_14 -= int_12;
                int_17 -= int_15;
                int int_31 = ((int_11 * int_12) - (int_9 * int_14)) << 14;
                final int int_32 = (int) (((long) ((int_15 * int_14) - (int_17 * int_12)) << 14) / Rasterizer3D_zoom);
                final int int_33 = (int) (((long) ((int_17 * int_9) - (int_11 * int_15)) << 14) / Rasterizer3D_zoom);
                int int_34 = ((int_10 * int_12) - (int_13 * int_9)) << 14;
                final int int_35 = (int) (((long) ((int_13 * int_15) - (int_16 * int_12)) << 14) / Rasterizer3D_zoom);
                final int int_36 = (int) (((long) ((int_16 * int_9) - (int_10 * int_15)) << 14) / Rasterizer3D_zoom);
                int int_37 = ((int_13 * int_11) - (int_10 * int_14)) << 14;
                final int int_38 = (int) (((long) ((int_16 * int_14) - (int_13 * int_17)) << 14) / Rasterizer3D_zoom);
                final int int_39 = (int) (((long) ((int_17 * int_10) - (int_11 * int_16)) << 14) / Rasterizer3D_zoom);
                int int_40;
                if ((int_0 <= int_1) && (int_0 <= int_2)) {
                    if (int_0 < Rasterizer3D_clipHeight) {
                        if (int_1 > Rasterizer3D_clipHeight) {
                            int_1 = Rasterizer3D_clipHeight;
                        }

                        if (int_2 > Rasterizer3D_clipHeight) {
                            int_2 = Rasterizer3D_clipHeight;
                        }

                        int_6 = int_29 + ((int_6 << 9) - (int_3 * int_29));
                        if (int_1 < int_2) {
                            int_5 = int_3 <<= 14;
                            if (int_0 < 0) {
                                int_5 -= int_0 * int_27;
                                int_3 -= int_0 * int_25;
                                int_6 -= int_0 * int_30;
                                int_0 = 0;
                            }

                            int_4 <<= 14;
                            if (int_1 < 0) {
                                int_4 -= int_26 * int_1;
                                int_1 = 0;
                            }

                            int_40 = int_0 - centerY;
                            int_31 += int_33 * int_40;
                            int_34 += int_36 * int_40;
                            int_37 += int_39 * int_40;
                            if (((int_0 != int_1) && (int_27 < int_25)) || ((int_0 == int_1) && (int_27 > int_26))) {
                                int_2 -= int_1;
                                int_1 -= int_0;
                                int_0 = rasterClipY[int_0];

                                while (true) {
                                    --int_1;
                                    if (int_1 < 0) {
                                        while (true) {
                                            --int_2;
                                            if (int_2 < 0) {
                                                return;
                                            }

                                            method2847(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_0, int_5 >> 14,
                                                    int_4 >> 14, int_6, int_29, int_31, int_34, int_37, int_32, int_35,
                                                    int_38);
                                            int_5 += int_27;
                                            int_4 += int_26;
                                            int_6 += int_30;
                                            int_0 += Rasterizer2D.graphicsPixelsWidth;
                                            int_31 += int_33;
                                            int_34 += int_36;
                                            int_37 += int_39;
                                        }
                                    }

                                    method2847(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_0, int_5 >> 14,
                                            int_3 >> 14, int_6, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                                    int_5 += int_27;
                                    int_3 += int_25;
                                    int_6 += int_30;
                                    int_0 += Rasterizer2D.graphicsPixelsWidth;
                                    int_31 += int_33;
                                    int_34 += int_36;
                                    int_37 += int_39;
                                }
                            } else {
                                int_2 -= int_1;
                                int_1 -= int_0;
                                int_0 = rasterClipY[int_0];

                                while (true) {
                                    --int_1;
                                    if (int_1 < 0) {
                                        while (true) {
                                            --int_2;
                                            if (int_2 < 0) {
                                                return;
                                            }

                                            method2847(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_0, int_4 >> 14,
                                                    int_5 >> 14, int_6, int_29, int_31, int_34, int_37, int_32, int_35,
                                                    int_38);
                                            int_5 += int_27;
                                            int_4 += int_26;
                                            int_6 += int_30;
                                            int_0 += Rasterizer2D.graphicsPixelsWidth;
                                            int_31 += int_33;
                                            int_34 += int_36;
                                            int_37 += int_39;
                                        }
                                    }

                                    method2847(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_0, int_3 >> 14,
                                            int_5 >> 14, int_6, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                                    int_5 += int_27;
                                    int_3 += int_25;
                                    int_6 += int_30;
                                    int_0 += Rasterizer2D.graphicsPixelsWidth;
                                    int_31 += int_33;
                                    int_34 += int_36;
                                    int_37 += int_39;
                                }
                            }
                        } else {
                            int_4 = int_3 <<= 14;
                            if (int_0 < 0) {
                                int_4 -= int_0 * int_27;
                                int_3 -= int_0 * int_25;
                                int_6 -= int_0 * int_30;
                                int_0 = 0;
                            }

                            int_5 <<= 14;
                            if (int_2 < 0) {
                                int_5 -= int_26 * int_2;
                                int_2 = 0;
                            }

                            int_40 = int_0 - centerY;
                            int_31 += int_33 * int_40;
                            int_34 += int_36 * int_40;
                            int_37 += int_39 * int_40;
                            if (((int_0 != int_2) && (int_27 < int_25)) || ((int_0 == int_2) && (int_26 > int_25))) {
                                int_1 -= int_2;
                                int_2 -= int_0;
                                int_0 = rasterClipY[int_0];

                                while (true) {
                                    --int_2;
                                    if (int_2 < 0) {
                                        while (true) {
                                            --int_1;
                                            if (int_1 < 0) {
                                                return;
                                            }

                                            method2847(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_0, int_5 >> 14,
                                                    int_3 >> 14, int_6, int_29, int_31, int_34, int_37, int_32, int_35,
                                                    int_38);
                                            int_5 += int_26;
                                            int_3 += int_25;
                                            int_6 += int_30;
                                            int_0 += Rasterizer2D.graphicsPixelsWidth;
                                            int_31 += int_33;
                                            int_34 += int_36;
                                            int_37 += int_39;
                                        }
                                    }

                                    method2847(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_0, int_4 >> 14,
                                            int_3 >> 14, int_6, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                                    int_4 += int_27;
                                    int_3 += int_25;
                                    int_6 += int_30;
                                    int_0 += Rasterizer2D.graphicsPixelsWidth;
                                    int_31 += int_33;
                                    int_34 += int_36;
                                    int_37 += int_39;
                                }
                            } else {
                                int_1 -= int_2;
                                int_2 -= int_0;
                                int_0 = rasterClipY[int_0];

                                while (true) {
                                    --int_2;
                                    if (int_2 < 0) {
                                        while (true) {
                                            --int_1;
                                            if (int_1 < 0) {
                                                return;
                                            }

                                            method2847(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_0, int_3 >> 14,
                                                    int_5 >> 14, int_6, int_29, int_31, int_34, int_37, int_32, int_35,
                                                    int_38);
                                            int_5 += int_26;
                                            int_3 += int_25;
                                            int_6 += int_30;
                                            int_0 += Rasterizer2D.graphicsPixelsWidth;
                                            int_31 += int_33;
                                            int_34 += int_36;
                                            int_37 += int_39;
                                        }
                                    }

                                    method2847(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_0, int_3 >> 14,
                                            int_4 >> 14, int_6, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                                    int_4 += int_27;
                                    int_3 += int_25;
                                    int_6 += int_30;
                                    int_0 += Rasterizer2D.graphicsPixelsWidth;
                                    int_31 += int_33;
                                    int_34 += int_36;
                                    int_37 += int_39;
                                }
                            }
                        }
                    }
                } else if (int_1 <= int_2) {
                    if (int_1 < Rasterizer3D_clipHeight) {
                        if (int_2 > Rasterizer3D_clipHeight) {
                            int_2 = Rasterizer3D_clipHeight;
                        }

                        if (int_0 > Rasterizer3D_clipHeight) {
                            int_0 = Rasterizer3D_clipHeight;
                        }

                        int_7 = int_29 + ((int_7 << 9) - (int_29 * int_4));
                        if (int_2 < int_0) {
                            int_3 = int_4 <<= 14;
                            if (int_1 < 0) {
                                int_3 -= int_25 * int_1;
                                int_4 -= int_26 * int_1;
                                int_7 -= int_30 * int_1;
                                int_1 = 0;
                            }

                            int_5 <<= 14;
                            if (int_2 < 0) {
                                int_5 -= int_27 * int_2;
                                int_2 = 0;
                            }

                            int_40 = int_1 - centerY;
                            int_31 += int_33 * int_40;
                            int_34 += int_36 * int_40;
                            int_37 += int_39 * int_40;
                            if (((int_2 != int_1) && (int_25 < int_26)) || ((int_2 == int_1) && (int_25 > int_27))) {
                                int_0 -= int_2;
                                int_2 -= int_1;
                                int_1 = rasterClipY[int_1];

                                while (true) {
                                    --int_2;
                                    if (int_2 < 0) {
                                        while (true) {
                                            --int_0;
                                            if (int_0 < 0) {
                                                return;
                                            }

                                            method2847(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_1, int_3 >> 14,
                                                    int_5 >> 14, int_7, int_29, int_31, int_34, int_37, int_32, int_35,
                                                    int_38);
                                            int_3 += int_25;
                                            int_5 += int_27;
                                            int_7 += int_30;
                                            int_1 += Rasterizer2D.graphicsPixelsWidth;
                                            int_31 += int_33;
                                            int_34 += int_36;
                                            int_37 += int_39;
                                        }
                                    }

                                    method2847(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_1, int_3 >> 14,
                                            int_4 >> 14, int_7, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                                    int_3 += int_25;
                                    int_4 += int_26;
                                    int_7 += int_30;
                                    int_1 += Rasterizer2D.graphicsPixelsWidth;
                                    int_31 += int_33;
                                    int_34 += int_36;
                                    int_37 += int_39;
                                }
                            } else {
                                int_0 -= int_2;
                                int_2 -= int_1;
                                int_1 = rasterClipY[int_1];

                                while (true) {
                                    --int_2;
                                    if (int_2 < 0) {
                                        while (true) {
                                            --int_0;
                                            if (int_0 < 0) {
                                                return;
                                            }

                                            method2847(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_1, int_5 >> 14,
                                                    int_3 >> 14, int_7, int_29, int_31, int_34, int_37, int_32, int_35,
                                                    int_38);
                                            int_3 += int_25;
                                            int_5 += int_27;
                                            int_7 += int_30;
                                            int_1 += Rasterizer2D.graphicsPixelsWidth;
                                            int_31 += int_33;
                                            int_34 += int_36;
                                            int_37 += int_39;
                                        }
                                    }

                                    method2847(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_1, int_4 >> 14,
                                            int_3 >> 14, int_7, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                                    int_3 += int_25;
                                    int_4 += int_26;
                                    int_7 += int_30;
                                    int_1 += Rasterizer2D.graphicsPixelsWidth;
                                    int_31 += int_33;
                                    int_34 += int_36;
                                    int_37 += int_39;
                                }
                            }
                        } else {
                            int_5 = int_4 <<= 14;
                            if (int_1 < 0) {
                                int_5 -= int_25 * int_1;
                                int_4 -= int_26 * int_1;
                                int_7 -= int_30 * int_1;
                                int_1 = 0;
                            }

                            int_3 <<= 14;
                            if (int_0 < 0) {
                                int_3 -= int_0 * int_27;
                                int_0 = 0;
                            }

                            int_40 = int_1 - centerY;
                            int_31 += int_33 * int_40;
                            int_34 += int_36 * int_40;
                            int_37 += int_39 * int_40;
                            if (int_25 < int_26) {
                                int_2 -= int_0;
                                int_0 -= int_1;
                                int_1 = rasterClipY[int_1];

                                while (true) {
                                    --int_0;
                                    if (int_0 < 0) {
                                        while (true) {
                                            --int_2;
                                            if (int_2 < 0) {
                                                return;
                                            }

                                            method2847(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_1, int_3 >> 14,
                                                    int_4 >> 14, int_7, int_29, int_31, int_34, int_37, int_32, int_35,
                                                    int_38);
                                            int_3 += int_27;
                                            int_4 += int_26;
                                            int_7 += int_30;
                                            int_1 += Rasterizer2D.graphicsPixelsWidth;
                                            int_31 += int_33;
                                            int_34 += int_36;
                                            int_37 += int_39;
                                        }
                                    }

                                    method2847(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_1, int_5 >> 14,
                                            int_4 >> 14, int_7, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                                    int_5 += int_25;
                                    int_4 += int_26;
                                    int_7 += int_30;
                                    int_1 += Rasterizer2D.graphicsPixelsWidth;
                                    int_31 += int_33;
                                    int_34 += int_36;
                                    int_37 += int_39;
                                }
                            } else {
                                int_2 -= int_0;
                                int_0 -= int_1;
                                int_1 = rasterClipY[int_1];

                                while (true) {
                                    --int_0;
                                    if (int_0 < 0) {
                                        while (true) {
                                            --int_2;
                                            if (int_2 < 0) {
                                                return;
                                            }

                                            method2847(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_1, int_4 >> 14,
                                                    int_3 >> 14, int_7, int_29, int_31, int_34, int_37, int_32, int_35,
                                                    int_38);
                                            int_3 += int_27;
                                            int_4 += int_26;
                                            int_7 += int_30;
                                            int_1 += Rasterizer2D.graphicsPixelsWidth;
                                            int_31 += int_33;
                                            int_34 += int_36;
                                            int_37 += int_39;
                                        }
                                    }

                                    method2847(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_1, int_4 >> 14,
                                            int_5 >> 14, int_7, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                                    int_5 += int_25;
                                    int_4 += int_26;
                                    int_7 += int_30;
                                    int_1 += Rasterizer2D.graphicsPixelsWidth;
                                    int_31 += int_33;
                                    int_34 += int_36;
                                    int_37 += int_39;
                                }
                            }
                        }
                    }
                } else if (int_2 < Rasterizer3D_clipHeight) {
                    if (int_0 > Rasterizer3D_clipHeight) {
                        int_0 = Rasterizer3D_clipHeight;
                    }

                    if (int_1 > Rasterizer3D_clipHeight) {
                        int_1 = Rasterizer3D_clipHeight;
                    }

                    int_8 = ((int_8 << 9) - (int_5 * int_29)) + int_29;
                    if (int_0 < int_1) {
                        int_4 = int_5 <<= 14;
                        if (int_2 < 0) {
                            int_4 -= int_26 * int_2;
                            int_5 -= int_27 * int_2;
                            int_8 -= int_30 * int_2;
                            int_2 = 0;
                        }

                        int_3 <<= 14;
                        if (int_0 < 0) {
                            int_3 -= int_0 * int_25;
                            int_0 = 0;
                        }

                        int_40 = int_2 - centerY;
                        int_31 += int_33 * int_40;
                        int_34 += int_36 * int_40;
                        int_37 += int_39 * int_40;
                        if (int_26 < int_27) {
                            int_1 -= int_0;
                            int_0 -= int_2;
                            int_2 = rasterClipY[int_2];

                            while (true) {
                                --int_0;
                                if (int_0 < 0) {
                                    while (true) {
                                        --int_1;
                                        if (int_1 < 0) {
                                            return;
                                        }

                                        method2847(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_2, int_4 >> 14,
                                                int_3 >> 14, int_8, int_29, int_31, int_34, int_37, int_32, int_35,
                                                int_38);
                                        int_4 += int_26;
                                        int_3 += int_25;
                                        int_8 += int_30;
                                        int_2 += Rasterizer2D.graphicsPixelsWidth;
                                        int_31 += int_33;
                                        int_34 += int_36;
                                        int_37 += int_39;
                                    }
                                }

                                method2847(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_2, int_4 >> 14, int_5 >> 14,
                                        int_8, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                                int_4 += int_26;
                                int_5 += int_27;
                                int_8 += int_30;
                                int_2 += Rasterizer2D.graphicsPixelsWidth;
                                int_31 += int_33;
                                int_34 += int_36;
                                int_37 += int_39;
                            }
                        } else {
                            int_1 -= int_0;
                            int_0 -= int_2;
                            int_2 = rasterClipY[int_2];

                            while (true) {
                                --int_0;
                                if (int_0 < 0) {
                                    while (true) {
                                        --int_1;
                                        if (int_1 < 0) {
                                            return;
                                        }

                                        method2847(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_2, int_3 >> 14,
                                                int_4 >> 14, int_8, int_29, int_31, int_34, int_37, int_32, int_35,
                                                int_38);
                                        int_4 += int_26;
                                        int_3 += int_25;
                                        int_8 += int_30;
                                        int_2 += Rasterizer2D.graphicsPixelsWidth;
                                        int_31 += int_33;
                                        int_34 += int_36;
                                        int_37 += int_39;
                                    }
                                }

                                method2847(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_2, int_5 >> 14, int_4 >> 14,
                                        int_8, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                                int_4 += int_26;
                                int_5 += int_27;
                                int_8 += int_30;
                                int_2 += Rasterizer2D.graphicsPixelsWidth;
                                int_31 += int_33;
                                int_34 += int_36;
                                int_37 += int_39;
                            }
                        }
                    } else {
                        int_3 = int_5 <<= 14;
                        if (int_2 < 0) {
                            int_3 -= int_26 * int_2;
                            int_5 -= int_27 * int_2;
                            int_8 -= int_30 * int_2;
                            int_2 = 0;
                        }

                        int_4 <<= 14;
                        if (int_1 < 0) {
                            int_4 -= int_25 * int_1;
                            int_1 = 0;
                        }

                        int_40 = int_2 - centerY;
                        int_31 += int_33 * int_40;
                        int_34 += int_36 * int_40;
                        int_37 += int_39 * int_40;
                        if (int_26 < int_27) {
                            int_0 -= int_1;
                            int_1 -= int_2;
                            int_2 = rasterClipY[int_2];

                            while (true) {
                                --int_1;
                                if (int_1 < 0) {
                                    while (true) {
                                        --int_0;
                                        if (int_0 < 0) {
                                            return;
                                        }

                                        method2847(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_2, int_4 >> 14,
                                                int_5 >> 14, int_8, int_29, int_31, int_34, int_37, int_32, int_35,
                                                int_38);
                                        int_4 += int_25;
                                        int_5 += int_27;
                                        int_8 += int_30;
                                        int_2 += Rasterizer2D.graphicsPixelsWidth;
                                        int_31 += int_33;
                                        int_34 += int_36;
                                        int_37 += int_39;
                                    }
                                }

                                method2847(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_2, int_3 >> 14, int_5 >> 14,
                                        int_8, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                                int_3 += int_26;
                                int_5 += int_27;
                                int_8 += int_30;
                                int_2 += Rasterizer2D.graphicsPixelsWidth;
                                int_31 += int_33;
                                int_34 += int_36;
                                int_37 += int_39;
                            }
                        } else {
                            int_0 -= int_1;
                            int_1 -= int_2;
                            int_2 = rasterClipY[int_2];

                            while (true) {
                                --int_1;
                                if (int_1 < 0) {
                                    while (true) {
                                        --int_0;
                                        if (int_0 < 0) {
                                            return;
                                        }

                                        method2847(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_2, int_5 >> 14,
                                                int_4 >> 14, int_8, int_29, int_31, int_34, int_37, int_32, int_35,
                                                int_38);
                                        int_4 += int_25;
                                        int_5 += int_27;
                                        int_8 += int_30;
                                        int_2 += Rasterizer2D.graphicsPixelsWidth;
                                        int_31 += int_33;
                                        int_34 += int_36;
                                        int_37 += int_39;
                                    }
                                }

                                method2847(Rasterizer2D.graphicsPixels, ints_0, 0, 0, int_2, int_5 >> 14, int_3 >> 14,
                                        int_8, int_29, int_31, int_34, int_37, int_32, int_35, int_38);
                                int_3 += int_26;
                                int_5 += int_27;
                                int_8 += int_30;
                                int_2 += Rasterizer2D.graphicsPixelsWidth;
                                int_31 += int_33;
                                int_34 += int_36;
                                int_37 += int_39;
                            }
                        }
                    }
                }
            }
        }
    }

    static void method2847(final int[] ints_0, final int[] ints_1, int int_0, int int_1, int int_2, int int_3,
                           int int_4, int int_5, int int_6, int int_7, int int_8, int int_9, final int int_10, final int int_11,
                           final int int_12) {
        if (rasterClipEnable) {
            if (int_4 > rasterClipX) {
                int_4 = rasterClipX;
            }

            if (int_3 < 0) {
                int_3 = 0;
            }
        }

        if (int_3 < int_4) {
            int_2 += int_3;
            int_5 += int_3 * int_6;
            int int_13 = int_4 - int_3;
            int int_14;
            int int_15;
            int int_16;
            int int_17;
            int int_18;
            int int_19;
            int int_20;
            int int_21;
            if (lowMem) {
                int_14 = int_3 - centerX;
                int_7 += int_14 * int_10;
                int_8 += int_11 * int_14;
                int_9 += int_14 * int_12;
                int_15 = int_9 >> 12;
                if (int_15 != 0) {
                    int_16 = int_7 / int_15;
                    int_17 = int_8 / int_15;
                } else {
                    int_16 = 0;
                    int_17 = 0;
                }

                int_7 += int_13 * int_10;
                int_8 += int_11 * int_13;
                int_9 += int_13 * int_12;
                int_15 = int_9 >> 12;
                if (int_15 != 0) {
                    int_18 = int_7 / int_15;
                    int_19 = int_8 / int_15;
                } else {
                    int_18 = 0;
                    int_19 = 0;
                }

                int_0 = (int_16 << 20) + int_17;
                int_20 = ((int_19 - int_17) / int_13) + (((int_18 - int_16) / int_13) << 20);
                int_13 >>= 3;
                int_6 <<= 3;
                int_21 = int_5 >> 8;
                if (field1668) {
                    if (int_13 > 0) {
                        do {
                            int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)];
                            ints_0[int_2++] = (((int_21 * (int_1 & 0xFF00)) & 0xFF0000)
                                    + (((int_1 & 0xFF00FF) * int_21) & 0xFF00FF00)) >> 8;
                            int_0 += int_20;
                            int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)];
                            ints_0[int_2++] = (((int_21 * (int_1 & 0xFF00)) & 0xFF0000)
                                    + (((int_1 & 0xFF00FF) * int_21) & 0xFF00FF00)) >> 8;
                            int_0 += int_20;
                            int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)];
                            ints_0[int_2++] = (((int_21 * (int_1 & 0xFF00)) & 0xFF0000)
                                    + (((int_1 & 0xFF00FF) * int_21) & 0xFF00FF00)) >> 8;
                            int_0 += int_20;
                            int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)];
                            ints_0[int_2++] = (((int_21 * (int_1 & 0xFF00)) & 0xFF0000)
                                    + (((int_1 & 0xFF00FF) * int_21) & 0xFF00FF00)) >> 8;
                            int_0 += int_20;
                            int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)];
                            ints_0[int_2++] = (((int_21 * (int_1 & 0xFF00)) & 0xFF0000)
                                    + (((int_1 & 0xFF00FF) * int_21) & 0xFF00FF00)) >> 8;
                            int_0 += int_20;
                            int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)];
                            ints_0[int_2++] = (((int_21 * (int_1 & 0xFF00)) & 0xFF0000)
                                    + (((int_1 & 0xFF00FF) * int_21) & 0xFF00FF00)) >> 8;
                            int_0 += int_20;
                            int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)];
                            ints_0[int_2++] = (((int_21 * (int_1 & 0xFF00)) & 0xFF0000)
                                    + (((int_1 & 0xFF00FF) * int_21) & 0xFF00FF00)) >> 8;
                            int_0 += int_20;
                            int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)];
                            ints_0[int_2++] = (((int_21 * (int_1 & 0xFF00)) & 0xFF0000)
                                    + (((int_1 & 0xFF00FF) * int_21) & 0xFF00FF00)) >> 8;
                            int_0 += int_20;
                            int_5 += int_6;
                            int_21 = int_5 >> 8;
                            --int_13;
                        }
                        while (int_13 > 0);
                    }

                    int_13 = (int_4 - int_3) & 0x7;
                    if (int_13 > 0) {
                        do {
                            int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)];
                            ints_0[int_2++] = (((int_21 * (int_1 & 0xFF00)) & 0xFF0000)
                                    + (((int_1 & 0xFF00FF) * int_21) & 0xFF00FF00)) >> 8;
                            int_0 += int_20;
                            --int_13;
                        }
                        while (int_13 > 0);
                    }
                } else {
                    if (int_13 > 0) {
                        do {
                            if ((int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)]) != 0) {
                                ints_0[int_2] = (((int_21 * (int_1 & 0xFF00)) & 0xFF0000)
                                        + (((int_1 & 0xFF00FF) * int_21) & 0xFF00FF00)) >> 8;
                            }

                            ++int_2;
                            int_0 += int_20;
                            if ((int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)]) != 0) {
                                ints_0[int_2] = (((int_21 * (int_1 & 0xFF00)) & 0xFF0000)
                                        + (((int_1 & 0xFF00FF) * int_21) & 0xFF00FF00)) >> 8;
                            }

                            ++int_2;
                            int_0 += int_20;
                            if ((int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)]) != 0) {
                                ints_0[int_2] = (((int_21 * (int_1 & 0xFF00)) & 0xFF0000)
                                        + (((int_1 & 0xFF00FF) * int_21) & 0xFF00FF00)) >> 8;
                            }

                            ++int_2;
                            int_0 += int_20;
                            if ((int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)]) != 0) {
                                ints_0[int_2] = (((int_21 * (int_1 & 0xFF00)) & 0xFF0000)
                                        + (((int_1 & 0xFF00FF) * int_21) & 0xFF00FF00)) >> 8;
                            }

                            ++int_2;
                            int_0 += int_20;
                            if ((int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)]) != 0) {
                                ints_0[int_2] = (((int_21 * (int_1 & 0xFF00)) & 0xFF0000)
                                        + (((int_1 & 0xFF00FF) * int_21) & 0xFF00FF00)) >> 8;
                            }

                            ++int_2;
                            int_0 += int_20;
                            if ((int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)]) != 0) {
                                ints_0[int_2] = (((int_21 * (int_1 & 0xFF00)) & 0xFF0000)
                                        + (((int_1 & 0xFF00FF) * int_21) & 0xFF00FF00)) >> 8;
                            }

                            ++int_2;
                            int_0 += int_20;
                            if ((int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)]) != 0) {
                                ints_0[int_2] = (((int_21 * (int_1 & 0xFF00)) & 0xFF0000)
                                        + (((int_1 & 0xFF00FF) * int_21) & 0xFF00FF00)) >> 8;
                            }

                            ++int_2;
                            int_0 += int_20;
                            if ((int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)]) != 0) {
                                ints_0[int_2] = (((int_21 * (int_1 & 0xFF00)) & 0xFF0000)
                                        + (((int_1 & 0xFF00FF) * int_21) & 0xFF00FF00)) >> 8;
                            }

                            ++int_2;
                            int_0 += int_20;
                            int_5 += int_6;
                            int_21 = int_5 >> 8;
                            --int_13;
                        }
                        while (int_13 > 0);
                    }

                    int_13 = (int_4 - int_3) & 0x7;
                    if (int_13 > 0) {
                        do {
                            if ((int_1 = ints_1[(int_0 >>> 26) + (int_0 & 0xFC0)]) != 0) {
                                ints_0[int_2] = (((int_21 * (int_1 & 0xFF00)) & 0xFF0000)
                                        + (((int_1 & 0xFF00FF) * int_21) & 0xFF00FF00)) >> 8;
                            }

                            ++int_2;
                            int_0 += int_20;
                            --int_13;
                        }
                        while (int_13 > 0);
                    }
                }
            } else {
                int_14 = int_3 - centerX;
                int_7 += int_14 * int_10;
                int_8 += int_11 * int_14;
                int_9 += int_14 * int_12;
                int_15 = int_9 >> 14;
                if (int_15 != 0) {
                    int_16 = int_7 / int_15;
                    int_17 = int_8 / int_15;
                } else {
                    int_16 = 0;
                    int_17 = 0;
                }

                int_7 += int_13 * int_10;
                int_8 += int_11 * int_13;
                int_9 += int_13 * int_12;
                int_15 = int_9 >> 14;
                if (int_15 != 0) {
                    int_18 = int_7 / int_15;
                    int_19 = int_8 / int_15;
                } else {
                    int_18 = 0;
                    int_19 = 0;
                }

                int_0 = (int_16 << 18) + int_17;
                int_20 = ((int_19 - int_17) / int_13) + (((int_18 - int_16) / int_13) << 18);
                int_13 >>= 3;
                int_6 <<= 3;
                int_21 = int_5 >> 8;
                if (field1668) {
                    if (int_13 > 0) {
                        do {
                            int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)];
                            ints_0[int_2++] = (((int_21 * (int_1 & 0xFF00)) & 0xFF0000)
                                    + (((int_1 & 0xFF00FF) * int_21) & 0xFF00FF00)) >> 8;
                            int_0 += int_20;
                            int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)];
                            ints_0[int_2++] = (((int_21 * (int_1 & 0xFF00)) & 0xFF0000)
                                    + (((int_1 & 0xFF00FF) * int_21) & 0xFF00FF00)) >> 8;
                            int_0 += int_20;
                            int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)];
                            ints_0[int_2++] = (((int_21 * (int_1 & 0xFF00)) & 0xFF0000)
                                    + (((int_1 & 0xFF00FF) * int_21) & 0xFF00FF00)) >> 8;
                            int_0 += int_20;
                            int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)];
                            ints_0[int_2++] = (((int_21 * (int_1 & 0xFF00)) & 0xFF0000)
                                    + (((int_1 & 0xFF00FF) * int_21) & 0xFF00FF00)) >> 8;
                            int_0 += int_20;
                            int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)];
                            ints_0[int_2++] = (((int_21 * (int_1 & 0xFF00)) & 0xFF0000)
                                    + (((int_1 & 0xFF00FF) * int_21) & 0xFF00FF00)) >> 8;
                            int_0 += int_20;
                            int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)];
                            ints_0[int_2++] = (((int_21 * (int_1 & 0xFF00)) & 0xFF0000)
                                    + (((int_1 & 0xFF00FF) * int_21) & 0xFF00FF00)) >> 8;
                            int_0 += int_20;
                            int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)];
                            ints_0[int_2++] = (((int_21 * (int_1 & 0xFF00)) & 0xFF0000)
                                    + (((int_1 & 0xFF00FF) * int_21) & 0xFF00FF00)) >> 8;
                            int_0 += int_20;
                            int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)];
                            ints_0[int_2++] = (((int_21 * (int_1 & 0xFF00)) & 0xFF0000)
                                    + (((int_1 & 0xFF00FF) * int_21) & 0xFF00FF00)) >> 8;
                            int_0 += int_20;
                            int_5 += int_6;
                            int_21 = int_5 >> 8;
                            --int_13;
                        }
                        while (int_13 > 0);
                    }

                    int_13 = (int_4 - int_3) & 0x7;
                    if (int_13 > 0) {
                        do {
                            int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)];
                            ints_0[int_2++] = (((int_21 * (int_1 & 0xFF00)) & 0xFF0000)
                                    + (((int_1 & 0xFF00FF) * int_21) & 0xFF00FF00)) >> 8;
                            int_0 += int_20;
                            --int_13;
                        }
                        while (int_13 > 0);
                    }
                } else {
                    if (int_13 > 0) {
                        do {
                            if ((int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)]) != 0) {
                                ints_0[int_2] = (((int_21 * (int_1 & 0xFF00)) & 0xFF0000)
                                        + (((int_1 & 0xFF00FF) * int_21) & 0xFF00FF00)) >> 8;
                            }

                            ++int_2;
                            int_0 += int_20;
                            if ((int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)]) != 0) {
                                ints_0[int_2] = (((int_21 * (int_1 & 0xFF00)) & 0xFF0000)
                                        + (((int_1 & 0xFF00FF) * int_21) & 0xFF00FF00)) >> 8;
                            }

                            ++int_2;
                            int_0 += int_20;
                            if ((int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)]) != 0) {
                                ints_0[int_2] = (((int_21 * (int_1 & 0xFF00)) & 0xFF0000)
                                        + (((int_1 & 0xFF00FF) * int_21) & 0xFF00FF00)) >> 8;
                            }

                            ++int_2;
                            int_0 += int_20;
                            if ((int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)]) != 0) {
                                ints_0[int_2] = (((int_21 * (int_1 & 0xFF00)) & 0xFF0000)
                                        + (((int_1 & 0xFF00FF) * int_21) & 0xFF00FF00)) >> 8;
                            }

                            ++int_2;
                            int_0 += int_20;
                            if ((int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)]) != 0) {
                                ints_0[int_2] = (((int_21 * (int_1 & 0xFF00)) & 0xFF0000)
                                        + (((int_1 & 0xFF00FF) * int_21) & 0xFF00FF00)) >> 8;
                            }

                            ++int_2;
                            int_0 += int_20;
                            if ((int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)]) != 0) {
                                ints_0[int_2] = (((int_21 * (int_1 & 0xFF00)) & 0xFF0000)
                                        + (((int_1 & 0xFF00FF) * int_21) & 0xFF00FF00)) >> 8;
                            }

                            ++int_2;
                            int_0 += int_20;
                            if ((int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)]) != 0) {
                                ints_0[int_2] = (((int_21 * (int_1 & 0xFF00)) & 0xFF0000)
                                        + (((int_1 & 0xFF00FF) * int_21) & 0xFF00FF00)) >> 8;
                            }

                            ++int_2;
                            int_0 += int_20;
                            if ((int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)]) != 0) {
                                ints_0[int_2] = (((int_21 * (int_1 & 0xFF00)) & 0xFF0000)
                                        + (((int_1 & 0xFF00FF) * int_21) & 0xFF00FF00)) >> 8;
                            }

                            ++int_2;
                            int_0 += int_20;
                            int_5 += int_6;
                            int_21 = int_5 >> 8;
                            --int_13;
                        }
                        while (int_13 > 0);
                    }

                    int_13 = (int_4 - int_3) & 0x7;
                    if (int_13 > 0) {
                        do {
                            if ((int_1 = ints_1[(int_0 & 0x3F80) + (int_0 >>> 25)]) != 0) {
                                ints_0[int_2] = (((int_21 * (int_1 & 0xFF00)) & 0xFF0000)
                                        + (((int_1 & 0xFF00FF) * int_21) & 0xFF00FF00)) >> 8;
                            }

                            ++int_2;
                            int_0 += int_20;
                            --int_13;
                        }
                        while (int_13 > 0);
                    }
                }
            }

        }
    }

    static int method2802(final int int_0, int int_1) {
        int_1 = ((int_0 & 0x7F) * int_1) >> 7;
        if (int_1 < 2) {
            int_1 = 2;
        } else if (int_1 > 126) {
            int_1 = 126;
        }

        return (int_0 & 0xFF80) + int_1;
    }

    static int method2803(final int int_0, final int int_1, final int int_2, final int int_3) {
        return ((int_0 * int_2) + (int_3 * int_1)) >> 16;
    }

    static int method2828(final int int_0, final int int_1, final int int_2, final int int_3) {
        return ((int_2 * int_1) - (int_3 * int_0)) >> 16;
    }

    static int method2805(final int int_0, final int int_1, final int int_2, final int int_3) {
        return ((int_0 * int_2) - (int_3 * int_1)) >> 16;
    }

    static int method2806(final int int_0, final int int_1, final int int_2, final int int_3) {
        return ((int_3 * int_0) + (int_2 * int_1)) >> 16;
    }

    static int method2807(final int int_0, final int int_1, final int int_2, final int int_3) {
        return ((int_0 * int_2) + (int_3 * int_1)) >> 16;
    }

    static int method2790(final int int_0, final int int_1, final int int_2, final int int_3) {
        return ((int_2 * int_1) - (int_3 * int_0)) >> 16;
    }

}
