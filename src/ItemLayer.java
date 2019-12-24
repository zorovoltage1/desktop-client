public final class ItemLayer {

    static JagexGame field1455;
    Renderable bottom;
    int hash;
    int x;
    int y;
    Renderable middle;
    Renderable top;
    long field1456;
    int height;

    public static int method2566(final int int_0, final int int_1, final int int_2, final class166 class166_0, final CollisionData collisiondata_0, final boolean bool_0, final int[] ints_0, final int[] ints_1) {
        int int_4;
        for (int int_3 = 0; int_3 < 128; int_3++) {
            for (int_4 = 0; int_4 < 128; int_4++) {
                class165.field2035[int_3][int_4] = 0;
                class165.field2041[int_3][int_4] = 99999999;
            }
        }

        int int_5;
        int int_6;
        byte byte_1;
        int int_7;
        int int_8;
        int int_9;
        int int_10;
        int int_11;
        int int_13;
        boolean bool_1;
        int int_19;
        int int_20;
        int int_21;
        if (int_2 == 1) {
            int_5 = int_0;
            int_6 = int_1;
            final byte byte_0 = 64;
            byte_1 = 64;
            int_7 = int_0 - byte_0;
            int_8 = int_1 - byte_1;
            class165.field2035[byte_0][byte_1] = 99;
            class165.field2041[byte_0][byte_1] = 0;
            final byte byte_2 = 0;
            int_9 = 0;
            class165.field2039[byte_2] = int_0;
            int_21 = byte_2 + 1;
            class165.field2038[byte_2] = int_1;
            final int[][] ints_2 = collisiondata_0.flags;

            boolean bool_2;
            while (true) {
                if (int_21 == int_9) {
                    WorldMapDecoration.field152 = int_5;
                    class165.field2037 = int_6;
                    bool_2 = false;
                    break;
                }

                int_5 = class165.field2039[int_9];
                int_6 = class165.field2038[int_9];
                int_9 = (int_9 + 1) & 0xFFF;
                int_19 = int_5 - int_7;
                int_20 = int_6 - int_8;
                int_10 = int_5 - collisiondata_0.x;
                int_11 = int_6 - collisiondata_0.y;
                if (class166_0.vmethod3440(1, int_5, int_6, collisiondata_0)) {
                    WorldMapDecoration.field152 = int_5;
                    class165.field2037 = int_6;
                    bool_2 = true;
                    break;
                }

                int_13 = class165.field2041[int_19][int_20] + 1;
                if ((int_19 > 0) && (class165.field2035[int_19 - 1][int_20] == 0)
                        && ((ints_2[int_10 - 1][int_11] & 0x1240108) == 0)) {
                    class165.field2039[int_21] = int_5 - 1;
                    class165.field2038[int_21] = int_6;
                    int_21 = (int_21 + 1) & 0xFFF;
                    class165.field2035[int_19 - 1][int_20] = 2;
                    class165.field2041[int_19 - 1][int_20] = int_13;
                }

                if ((int_19 < 127) && (class165.field2035[int_19 + 1][int_20] == 0)
                        && ((ints_2[int_10 + 1][int_11] & 0x1240180) == 0)) {
                    class165.field2039[int_21] = int_5 + 1;
                    class165.field2038[int_21] = int_6;
                    int_21 = (int_21 + 1) & 0xFFF;
                    class165.field2035[int_19 + 1][int_20] = 8;
                    class165.field2041[int_19 + 1][int_20] = int_13;
                }

                if ((int_20 > 0) && (class165.field2035[int_19][int_20 - 1] == 0)
                        && ((ints_2[int_10][int_11 - 1] & 0x1240102) == 0)) {
                    class165.field2039[int_21] = int_5;
                    class165.field2038[int_21] = int_6 - 1;
                    int_21 = (int_21 + 1) & 0xFFF;
                    class165.field2035[int_19][int_20 - 1] = 1;
                    class165.field2041[int_19][int_20 - 1] = int_13;
                }

                if ((int_20 < 127) && (class165.field2035[int_19][int_20 + 1] == 0)
                        && ((ints_2[int_10][int_11 + 1] & 0x1240120) == 0)) {
                    class165.field2039[int_21] = int_5;
                    class165.field2038[int_21] = int_6 + 1;
                    int_21 = (int_21 + 1) & 0xFFF;
                    class165.field2035[int_19][int_20 + 1] = 4;
                    class165.field2041[int_19][int_20 + 1] = int_13;
                }

                if ((int_19 > 0) && (int_20 > 0) && (class165.field2035[int_19 - 1][int_20 - 1] == 0)
                        && ((ints_2[int_10 - 1][int_11 - 1] & 0x124010E) == 0)
                        && ((ints_2[int_10 - 1][int_11] & 0x1240108) == 0)
                        && ((ints_2[int_10][int_11 - 1] & 0x1240102) == 0)) {
                    class165.field2039[int_21] = int_5 - 1;
                    class165.field2038[int_21] = int_6 - 1;
                    int_21 = (int_21 + 1) & 0xFFF;
                    class165.field2035[int_19 - 1][int_20 - 1] = 3;
                    class165.field2041[int_19 - 1][int_20 - 1] = int_13;
                }

                if ((int_19 < 127) && (int_20 > 0) && (class165.field2035[int_19 + 1][int_20 - 1] == 0)
                        && ((ints_2[int_10 + 1][int_11 - 1] & 0x1240183) == 0)
                        && ((ints_2[int_10 + 1][int_11] & 0x1240180) == 0)
                        && ((ints_2[int_10][int_11 - 1] & 0x1240102) == 0)) {
                    class165.field2039[int_21] = int_5 + 1;
                    class165.field2038[int_21] = int_6 - 1;
                    int_21 = (int_21 + 1) & 0xFFF;
                    class165.field2035[int_19 + 1][int_20 - 1] = 9;
                    class165.field2041[int_19 + 1][int_20 - 1] = int_13;
                }

                if ((int_19 > 0) && (int_20 < 127) && (class165.field2035[int_19 - 1][int_20 + 1] == 0)
                        && ((ints_2[int_10 - 1][int_11 + 1] & 0x1240138) == 0)
                        && ((ints_2[int_10 - 1][int_11] & 0x1240108) == 0)
                        && ((ints_2[int_10][int_11 + 1] & 0x1240120) == 0)) {
                    class165.field2039[int_21] = int_5 - 1;
                    class165.field2038[int_21] = int_6 + 1;
                    int_21 = (int_21 + 1) & 0xFFF;
                    class165.field2035[int_19 - 1][int_20 + 1] = 6;
                    class165.field2041[int_19 - 1][int_20 + 1] = int_13;
                }

                if ((int_19 < 127) && (int_20 < 127) && (class165.field2035[int_19 + 1][int_20 + 1] == 0)
                        && ((ints_2[int_10 + 1][int_11 + 1] & 0x12401E0) == 0)
                        && ((ints_2[int_10 + 1][int_11] & 0x1240180) == 0)
                        && ((ints_2[int_10][int_11 + 1] & 0x1240120) == 0)) {
                    class165.field2039[int_21] = int_5 + 1;
                    class165.field2038[int_21] = int_6 + 1;
                    int_21 = (int_21 + 1) & 0xFFF;
                    class165.field2035[int_19 + 1][int_20 + 1] = 12;
                    class165.field2041[int_19 + 1][int_20 + 1] = int_13;
                }
            }

            bool_1 = bool_2;
        } else if (int_2 == 2) {
            bool_1 = SoundTaskDataProvider.method693(int_0, int_1, class166_0, collisiondata_0);
        } else {
            bool_1 = class21.method273(int_0, int_1, int_2, class166_0, collisiondata_0);
        }

        int_4 = int_0 - 64;
        int_5 = int_1 - 64;
        int_6 = WorldMapDecoration.field152;
        int_19 = class165.field2037;
        if (!bool_1) {
            int_20 = Integer.MAX_VALUE;
            int_7 = Integer.MAX_VALUE;
            final byte byte_3 = 10;
            int_21 = class166_0.field2043;
            int_9 = class166_0.field2048;
            final int int_12 = class166_0.field2042;
            int_10 = class166_0.field2045;

            for (int_11 = int_21 - byte_3; int_11 <= (byte_3 + int_21); int_11++) {
                for (int_13 = int_9 - byte_3; int_13 <= (byte_3 + int_9); int_13++) {
                    final int int_14 = int_11 - int_4;
                    final int int_15 = int_13 - int_5;
                    if ((int_14 >= 0) && (int_15 >= 0) && (int_14 < 128) && (int_15 < 128)
                            && (class165.field2041[int_14][int_15] < 100)) {
                        int int_16 = 0;
                        if (int_11 < int_21) {
                            int_16 = int_21 - int_11;
                        } else if (int_11 > ((int_12 + int_21) - 1)) {
                            int_16 = int_11 - ((int_12 + int_21) - 1);
                        }

                        int int_17 = 0;
                        if (int_13 < int_9) {
                            int_17 = int_9 - int_13;
                        } else if (int_13 > ((int_9 + int_10) - 1)) {
                            int_17 = int_13 - ((int_9 + int_10) - 1);
                        }

                        final int int_18 = (int_16 * int_16) + (int_17 * int_17);
                        if ((int_18 < int_20) || ((int_20 == int_18) && (class165.field2041[int_14][int_15] < int_7))) {
                            int_20 = int_18;
                            int_7 = class165.field2041[int_14][int_15];
                            int_6 = int_11;
                            int_19 = int_13;
                        }
                    }
                }
            }

            if (int_20 == Integer.MAX_VALUE) {
                return -1;
            }
        }

        if ((int_0 == int_6) && (int_19 == int_1)) {
            return 0;
        } else {
            byte_1 = 0;
            class165.field2039[byte_1] = int_6;
            int_20 = byte_1 + 1;
            class165.field2038[byte_1] = int_19;

            for (int_7 = int_8 = class165.field2035[int_6 - int_4][int_19 - int_5]; (int_0 != int_6)
                    || (int_19 != int_1); int_7 = class165.field2035[int_6 - int_4][int_19 - int_5]) {
                if (int_8 != int_7) {
                    int_8 = int_7;
                    class165.field2039[int_20] = int_6;
                    class165.field2038[int_20++] = int_19;
                }

                if ((int_7 & 0x2) != 0) {
                    ++int_6;
                } else if ((int_7 & 0x8) != 0) {
                    --int_6;
                }

                if ((int_7 & 0x1) != 0) {
                    ++int_19;
                } else if ((int_7 & 0x4) != 0) {
                    --int_19;
                }
            }

            int_21 = 0;

            while (int_20-- > 0) {
                ints_0[int_21] = class165.field2039[int_20];
                ints_1[int_21++] = class165.field2038[int_20];
                if (int_21 >= ints_0.length) {
                    break;
                }
            }

            return int_21;
        }
    }

    static void method2564(final int int_0) {
        if (int_0 >= 0) {
            final int int_1 = Game.menuActionParams0[int_0];
            final int int_2 = Game.menuActionParams1[int_0];
            final int int_3 = Game.menuTypes[int_0];
            final int int_4 = Game.menuIdentifiers[int_0];
            final String string_0 = Game.menuOptions[int_0];
            final String string_1 = Game.menuTargets[int_0];
            KeyFocusListener.menuAction(int_1, int_2, int_3, int_4, string_0, string_1, MouseInput.mouseLastPressedX,
                    MouseInput.mouseLastPressedY);
        }
    }

    static String method2565(final Widget widget_0, final int int_0) {
        return !SoundTask.method2214(class24.getWidgetClickMask(widget_0), int_0)
                && (widget_0.onOpListener == null)
                ? null
                : ((widget_0.actions != null) && (widget_0.actions.length > int_0)
                && (widget_0.actions[int_0] != null) && (widget_0.actions[int_0].trim().length() != 0)
                ? widget_0.actions[int_0]
                : null);
    }

}
