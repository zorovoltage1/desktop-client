public class class224 extends CacheableNode {

    static int field2555;
    static int[] field2554;
    static IndexData indexCache3;
    public final int field2553;
    public final int field2549;
    public final int[] field2550;
    public final int[] field2551;

    class224(final int int_0, final int int_1, final int[] ints_0, final int[] ints_1, final int int_2) {
        field2553 = int_0;
        field2549 = int_1;
        field2550 = ints_0;
        field2551 = ints_1;
    }

    public boolean method4423(final int int_0, final int int_1) {
        if ((int_1 >= 0) && (int_1 < field2551.length)) {
            final int int_2 = field2551[int_1];
            return (int_0 >= int_2) && (int_0 <= (int_2 + field2550[int_1]));
        }

        return false;
    }

    static int method4426(final IndexDataBase indexdatabase_0, final IndexDataBase indexdatabase_1) {
        int int_0 = 0;
        if (indexdatabase_0.tryLoadRecordByNames("title.jpg", "")) {
            ++int_0;
        }

        if (indexdatabase_1.tryLoadRecordByNames("logo", "")) {
            ++int_0;
        }

        if (indexdatabase_1.tryLoadRecordByNames("logo_deadman_mode", "")) {
            ++int_0;
        }

        if (indexdatabase_1.tryLoadRecordByNames("titlebox", "")) {
            ++int_0;
        }

        if (indexdatabase_1.tryLoadRecordByNames("titlebutton", "")) {
            ++int_0;
        }

        if (indexdatabase_1.tryLoadRecordByNames("runes", "")) {
            ++int_0;
        }

        if (indexdatabase_1.tryLoadRecordByNames("title_mute", "")) {
            ++int_0;
        }

        if (indexdatabase_1.tryLoadRecordByNames("options_radio_buttons,0", "")) {
            ++int_0;
        }

        if (indexdatabase_1.tryLoadRecordByNames("options_radio_buttons,2", "")) {
            ++int_0;
        }

        if (indexdatabase_1.tryLoadRecordByNames("options_radio_buttons,4", "")) {
            ++int_0;
        }

        if (indexdatabase_1.tryLoadRecordByNames("options_radio_buttons,6", "")) {
            ++int_0;
        }

        indexdatabase_1.tryLoadRecordByNames("sl_back", "");
        indexdatabase_1.tryLoadRecordByNames("sl_flags", "");
        indexdatabase_1.tryLoadRecordByNames("sl_arrows", "");
        indexdatabase_1.tryLoadRecordByNames("sl_stars", "");
        indexdatabase_1.tryLoadRecordByNames("sl_button", "");
        return int_0;
    }

    static void method4422(final int int_0, final int int_1, final int int_2, final int int_3, final int int_4) {
        long long_0 = MapIcon.region.method2898(int_0, int_1, int_2);
        int int_5;
        int int_6;
        int int_7;
        int int_8;
        int int_10;
        int int_14;
        if (long_0 != 0L) {
            int_5 = MapIcon.region.method2902(int_0, int_1, int_2, long_0);
            int_6 = (int_5 >> 6) & 0x3;
            int_7 = int_5 & 0x1F;
            int_8 = int_3;
            boolean bool_0 = long_0 != 0L;
            if (bool_0) {
                final boolean bool_1 = (int) ((long_0 >>> 16) & 0x1L) == 1;
                bool_0 = !bool_1;
            }

            if (bool_0) {
                int_8 = int_4;
            }

            final int[] ints_0 = NPC.minimapSprite.pixels;
            int_14 = (int_1 * 4) + ((103 - int_2) * 2048) + 24624;
            int_10 = KeyFocusListener.method673(long_0);
            final ObjectComposition objectcomposition_0 = FileOnDisk.getObjectDefinition(int_10);
            if (objectcomposition_0.mapSceneId != -1) {
                final IndexedSprite indexedsprite_0 = class25.mapscene[objectcomposition_0.mapSceneId];
                if (indexedsprite_0 != null) {
                    final int int_11 = ((objectcomposition_0.width * 4) - indexedsprite_0.width) / 2;
                    final int int_12 = ((objectcomposition_0.length * 4) - indexedsprite_0.height) / 2;
                    indexedsprite_0.method5829(int_11 + (int_1 * 4) + 48,
                            int_12 + ((104 - int_2 - objectcomposition_0.length) * 4) + 48);
                }
            } else {
                if ((int_7 == 0) || (int_7 == 2)) {
                    if (int_6 == 0) {
                        ints_0[int_14] = int_8;
                        ints_0[int_14 + 512] = int_8;
                        ints_0[int_14 + 1024] = int_8;
                        ints_0[int_14 + 1536] = int_8;
                    } else if (int_6 == 1) {
                        ints_0[int_14] = int_8;
                        ints_0[int_14 + 1] = int_8;
                        ints_0[int_14 + 2] = int_8;
                        ints_0[int_14 + 3] = int_8;
                    } else if (int_6 == 2) {
                        ints_0[int_14 + 3] = int_8;
                        ints_0[int_14 + 512 + 3] = int_8;
                        ints_0[int_14 + 1024 + 3] = int_8;
                        ints_0[int_14 + 1536 + 3] = int_8;
                    } else if (int_6 == 3) {
                        ints_0[int_14 + 1536] = int_8;
                        ints_0[int_14 + 1536 + 1] = int_8;
                        ints_0[int_14 + 1536 + 2] = int_8;
                        ints_0[int_14 + 1536 + 3] = int_8;
                    }
                }

                if (int_7 == 3) {
                    if (int_6 == 0) {
                        ints_0[int_14] = int_8;
                    } else if (int_6 == 1) {
                        ints_0[int_14 + 3] = int_8;
                    } else if (int_6 == 2) {
                        ints_0[int_14 + 1536 + 3] = int_8;
                    } else if (int_6 == 3) {
                        ints_0[int_14 + 1536] = int_8;
                    }
                }

                if (int_7 == 2) {
                    if (int_6 == 3) {
                        ints_0[int_14] = int_8;
                        ints_0[int_14 + 512] = int_8;
                        ints_0[int_14 + 1024] = int_8;
                        ints_0[int_14 + 1536] = int_8;
                    } else if (int_6 == 0) {
                        ints_0[int_14] = int_8;
                        ints_0[int_14 + 1] = int_8;
                        ints_0[int_14 + 2] = int_8;
                        ints_0[int_14 + 3] = int_8;
                    } else if (int_6 == 1) {
                        ints_0[int_14 + 3] = int_8;
                        ints_0[int_14 + 512 + 3] = int_8;
                        ints_0[int_14 + 1024 + 3] = int_8;
                        ints_0[int_14 + 1536 + 3] = int_8;
                    } else if (int_6 == 2) {
                        ints_0[int_14 + 1536] = int_8;
                        ints_0[int_14 + 1536 + 1] = int_8;
                        ints_0[int_14 + 1536 + 2] = int_8;
                        ints_0[int_14 + 1536 + 3] = int_8;
                    }
                }
            }
        }

        long_0 = MapIcon.region.method2900(int_0, int_1, int_2);
        if (long_0 != 0L) {
            int_5 = MapIcon.region.method2902(int_0, int_1, int_2, long_0);
            int_6 = (int_5 >> 6) & 0x3;
            int_7 = int_5 & 0x1F;
            int_8 = KeyFocusListener.method673(long_0);
            final ObjectComposition objectcomposition_1 = FileOnDisk.getObjectDefinition(int_8);
            if (objectcomposition_1.mapSceneId != -1) {
                final IndexedSprite indexedsprite_2 = class25.mapscene[objectcomposition_1.mapSceneId];
                if (indexedsprite_2 != null) {
                    int_14 = ((objectcomposition_1.width * 4) - indexedsprite_2.width) / 2;
                    int_10 = ((objectcomposition_1.length * 4) - indexedsprite_2.height) / 2;
                    indexedsprite_2.method5829((int_1 * 4) + int_14 + 48,
                            ((104 - int_2 - objectcomposition_1.length) * 4) + int_10 + 48);
                }
            } else if (int_7 == 9) {
                int int_13 = 15658734;
                if (FriendManager.method1683(long_0)) {
                    int_13 = 15597568;
                }

                final int[] ints_1 = NPC.minimapSprite.pixels;
                int_10 = (int_1 * 4) + ((103 - int_2) * 2048) + 24624;
                if ((int_6 != 0) && (int_6 != 2)) {
                    ints_1[int_10] = int_13;
                    ints_1[int_10 + 1 + 512] = int_13;
                    ints_1[int_10 + 1024 + 2] = int_13;
                    ints_1[int_10 + 1536 + 3] = int_13;
                } else {
                    ints_1[int_10 + 1536] = int_13;
                    ints_1[int_10 + 1 + 1024] = int_13;
                    ints_1[int_10 + 512 + 2] = int_13;
                    ints_1[int_10 + 3] = int_13;
                }
            }
        }

        long_0 = MapIcon.region.method2901(int_0, int_1, int_2);
        if (long_0 != 0L) {
            int_5 = KeyFocusListener.method673(long_0);
            final ObjectComposition objectcomposition_2 = FileOnDisk.getObjectDefinition(int_5);
            if (objectcomposition_2.mapSceneId != -1) {
                final IndexedSprite indexedsprite_1 = class25.mapscene[objectcomposition_2.mapSceneId];
                if (indexedsprite_1 != null) {
                    int_8 = ((objectcomposition_2.width * 4) - indexedsprite_1.width) / 2;
                    final int int_9 = ((objectcomposition_2.length * 4) - indexedsprite_1.height) / 2;
                    indexedsprite_1.method5829((int_1 * 4) + int_8 + 48,
                            int_9 + ((104 - int_2 - objectcomposition_2.length) * 4) + 48);
                }
            }
        }

    }

}
