public class class221 extends Node {

    static long field2535;
    int field2540;
    RawAudioNode[] field2533;
    short[] field2534;
    byte[] field2532;
    byte[] field2536;
    class216[] field2537;
    byte[] field2538;
    int[] field2539;

    class221(final byte[] bytes_0) {
        field2533 = new RawAudioNode[128];
        field2534 = new short[128];
        field2532 = new byte[128];
        field2536 = new byte[128];
        field2537 = new class216[128];
        field2538 = new byte[128];
        field2539 = new int[128];
        final Buffer buffer_0 = new Buffer(bytes_0);

        int int_0;
        for (int_0 = 0; buffer_0.payload[int_0 + buffer_0.offset] != 0; int_0++) {
        }

        final byte[] bytes_1 = new byte[int_0];

        int int_1;
        for (int_1 = 0; int_1 < int_0; int_1++) {
            bytes_1[int_1] = buffer_0.readByte();
        }

        ++buffer_0.offset;
        ++int_0;
        int_1 = buffer_0.offset;
        buffer_0.offset += int_0;

        int int_2;
        for (int_2 = 0; buffer_0.payload[int_2 + buffer_0.offset] != 0; int_2++) {
        }

        final byte[] bytes_2 = new byte[int_2];

        int int_3;
        for (int_3 = 0; int_3 < int_2; int_3++) {
            bytes_2[int_3] = buffer_0.readByte();
        }

        ++buffer_0.offset;
        ++int_2;
        int_3 = buffer_0.offset;
        buffer_0.offset += int_2;

        int int_4;
        for (int_4 = 0; buffer_0.payload[int_4 + buffer_0.offset] != 0; int_4++) {
        }

        final byte[] bytes_3 = new byte[int_4];

        for (int int_5 = 0; int_5 < int_4; int_5++) {
            bytes_3[int_5] = buffer_0.readByte();
        }

        ++buffer_0.offset;
        ++int_4;
        final byte[] bytes_4 = new byte[int_4];
        int int_7;
        int int_8;
        if (int_4 > 1) {
            bytes_4[1] = 1;
            int int_6 = 1;
            int_7 = 2;

            for (int_8 = 2; int_8 < int_4; int_8++) {
                int int_9 = buffer_0.readUnsignedByte();
                if (int_9 == 0) {
                    int_6 = int_7++;
                } else {
                    if (int_9 <= int_6) {
                        --int_9;
                    }

                    int_6 = int_9;
                }

                bytes_4[int_8] = (byte) int_6;
            }
        } else {
            int_7 = int_4;
        }

        final class216[] class216s_0 = new class216[int_7];

        class216 class216_0;
        for (int_8 = 0; int_8 < class216s_0.length; int_8++) {
            class216_0 = class216s_0[int_8] = new class216();
            int int_10 = buffer_0.readUnsignedByte();
            if (int_10 > 0) {
                class216_0.field2447 = new byte[int_10 * 2];
            }

            int_10 = buffer_0.readUnsignedByte();
            if (int_10 > 0) {
                class216_0.field2449 = new byte[(int_10 * 2) + 2];
                class216_0.field2449[1] = 64;
            }
        }

        int_8 = buffer_0.readUnsignedByte();
        final byte[] bytes_7 = int_8 > 0 ? new byte[int_8 * 2] : null;
        int_8 = buffer_0.readUnsignedByte();
        final byte[] bytes_5 = int_8 > 0 ? new byte[int_8 * 2] : null;

        int int_11;
        for (int_11 = 0; buffer_0.payload[int_11 + buffer_0.offset] != 0; int_11++) {
        }

        final byte[] bytes_6 = new byte[int_11];

        int int_12;
        for (int_12 = 0; int_12 < int_11; int_12++) {
            bytes_6[int_12] = buffer_0.readByte();
        }

        ++buffer_0.offset;
        ++int_11;
        int_12 = 0;

        int int_13;
        for (int_13 = 0; int_13 < 128; int_13++) {
            int_12 += buffer_0.readUnsignedByte();
            field2534[int_13] = (short) int_12;
        }

        int_12 = 0;

        for (int_13 = 0; int_13 < 128; int_13++) {
            int_12 += buffer_0.readUnsignedByte();
            field2534[int_13] = (short) (field2534[int_13] + (int_12 << 8));
        }

        int_13 = 0;
        int int_14 = 0;
        int int_15 = 0;

        int int_16;
        for (int_16 = 0; int_16 < 128; int_16++) {
            if (int_13 == 0) {
                if (int_14 < bytes_6.length) {
                    int_13 = bytes_6[int_14++];
                } else {
                    int_13 = -1;
                }

                int_15 = buffer_0.readVarInt();
            }

            field2534[int_16] = (short) (field2534[int_16] + (((int_15 - 1) & 0x2) << 14));
            field2539[int_16] = int_15;
            --int_13;
        }

        int_13 = 0;
        int_14 = 0;
        int_16 = 0;

        int int_17;
        for (int_17 = 0; int_17 < 128; int_17++) {
            if (field2539[int_17] != 0) {
                if (int_13 == 0) {
                    if (int_14 < bytes_1.length) {
                        int_13 = bytes_1[int_14++];
                    } else {
                        int_13 = -1;
                    }

                    int_16 = buffer_0.payload[int_1++] - 1;
                }

                field2538[int_17] = (byte) int_16;
                --int_13;
            }
        }

        int_13 = 0;
        int_14 = 0;
        int_17 = 0;

        for (int int_18 = 0; int_18 < 128; int_18++) {
            if (field2539[int_18] != 0) {
                if (int_13 == 0) {
                    if (int_14 < bytes_2.length) {
                        int_13 = bytes_2[int_14++];
                    } else {
                        int_13 = -1;
                    }

                    int_17 = (buffer_0.payload[int_3++] + 16) << 2;
                }

                field2536[int_18] = (byte) int_17;
                --int_13;
            }
        }

        int_13 = 0;
        int_14 = 0;
        class216 class216_1 = null;

        int int_19;
        for (int_19 = 0; int_19 < 128; int_19++) {
            if (field2539[int_19] != 0) {
                if (int_13 == 0) {
                    class216_1 = class216s_0[bytes_4[int_14]];
                    if (int_14 < bytes_3.length) {
                        int_13 = bytes_3[int_14++];
                    } else {
                        int_13 = -1;
                    }
                }

                field2537[int_19] = class216_1;
                --int_13;
            }
        }

        int_13 = 0;
        int_14 = 0;
        int_19 = 0;

        int int_20;
        for (int_20 = 0; int_20 < 128; int_20++) {
            if (int_13 == 0) {
                if (int_14 < bytes_6.length) {
                    int_13 = bytes_6[int_14++];
                } else {
                    int_13 = -1;
                }

                if (field2539[int_20] > 0) {
                    int_19 = buffer_0.readUnsignedByte() + 1;
                }
            }

            field2532[int_20] = (byte) int_19;
            --int_13;
        }

        field2540 = buffer_0.readUnsignedByte() + 1;

        class216 class216_2;
        int int_21;
        for (int_20 = 0; int_20 < int_7; int_20++) {
            class216_2 = class216s_0[int_20];
            if (class216_2.field2447 != null) {
                for (int_21 = 1; int_21 < class216_2.field2447.length; int_21 += 2) {
                    class216_2.field2447[int_21] = buffer_0.readByte();
                }
            }

            if (class216_2.field2449 != null) {
                for (int_21 = 3; int_21 < (class216_2.field2449.length - 2); int_21 += 2) {
                    class216_2.field2449[int_21] = buffer_0.readByte();
                }
            }
        }

        if (bytes_7 != null) {
            for (int_20 = 1; int_20 < bytes_7.length; int_20 += 2) {
                bytes_7[int_20] = buffer_0.readByte();
            }
        }

        if (bytes_5 != null) {
            for (int_20 = 1; int_20 < bytes_5.length; int_20 += 2) {
                bytes_5[int_20] = buffer_0.readByte();
            }
        }

        for (int_20 = 0; int_20 < int_7; int_20++) {
            class216_2 = class216s_0[int_20];
            if (class216_2.field2449 != null) {
                int_12 = 0;

                for (int_21 = 2; int_21 < class216_2.field2449.length; int_21 += 2) {
                    int_12 = 1 + int_12 + buffer_0.readUnsignedByte();
                    class216_2.field2449[int_21] = (byte) int_12;
                }
            }
        }

        for (int_20 = 0; int_20 < int_7; int_20++) {
            class216_2 = class216s_0[int_20];
            if (class216_2.field2447 != null) {
                int_12 = 0;

                for (int_21 = 2; int_21 < class216_2.field2447.length; int_21 += 2) {
                    int_12 = 1 + int_12 + buffer_0.readUnsignedByte();
                    class216_2.field2447[int_21] = (byte) int_12;
                }
            }
        }

        byte byte_1;
        int int_22;
        int int_23;
        int int_24;
        int int_25;
        int int_26;
        int int_29;
        byte byte_3;
        if (bytes_7 != null) {
            int_12 = buffer_0.readUnsignedByte();
            bytes_7[0] = (byte) int_12;

            for (int_20 = 2; int_20 < bytes_7.length; int_20 += 2) {
                int_12 = 1 + int_12 + buffer_0.readUnsignedByte();
                bytes_7[int_20] = (byte) int_12;
            }

            byte_3 = bytes_7[0];
            byte byte_0 = bytes_7[1];

            for (int_21 = 0; int_21 < byte_3; int_21++) {
                field2532[int_21] = (byte) (((byte_0 * field2532[int_21]) + 32) >> 6);
            }

            for (int_21 = 2; int_21 < bytes_7.length; int_21 += 2) {
                byte_1 = bytes_7[int_21];
                final byte byte_2 = bytes_7[int_21 + 1];
                int_22 = (byte_0 * (byte_1 - byte_3)) + ((byte_1 - byte_3) / 2);

                for (int_23 = byte_3; int_23 < byte_1; int_23++) {
                    int_24 = byte_1 - byte_3;
                    int_25 = int_22 >>> 31;
                    int_26 = ((int_22 + int_25) / int_24) - int_25;
                    field2532[int_23] = (byte) (((int_26 * field2532[int_23]) + 32) >> 6);
                    int_22 += byte_2 - byte_0;
                }

                byte_3 = byte_1;
                byte_0 = byte_2;
            }

            for (int_29 = byte_3; int_29 < 128; int_29++) {
                field2532[int_29] = (byte) (((byte_0 * field2532[int_29]) + 32) >> 6);
            }

            class216_0 = null;
        }

        if (bytes_5 != null) {
            int_12 = buffer_0.readUnsignedByte();
            bytes_5[0] = (byte) int_12;

            for (int_20 = 2; int_20 < bytes_5.length; int_20 += 2) {
                int_12 = 1 + int_12 + buffer_0.readUnsignedByte();
                bytes_5[int_20] = (byte) int_12;
            }

            byte_3 = bytes_5[0];
            int int_28 = bytes_5[1] << 1;

            for (int_21 = 0; int_21 < byte_3; int_21++) {
                int_29 = int_28 + (field2536[int_21] & 0xFF);
                if (int_29 < 0) {
                    int_29 = 0;
                }

                if (int_29 > 128) {
                    int_29 = 128;
                }

                field2536[int_21] = (byte) int_29;
            }

            int int_30;
            for (int_21 = 2; int_21 < bytes_5.length; int_21 += 2) {
                byte_1 = bytes_5[int_21];
                int_30 = bytes_5[int_21 + 1] << 1;
                int_22 = (int_28 * (byte_1 - byte_3)) + ((byte_1 - byte_3) / 2);

                for (int_23 = byte_3; int_23 < byte_1; int_23++) {
                    int_24 = byte_1 - byte_3;
                    int_25 = int_22 >>> 31;
                    int_26 = ((int_25 + int_22) / int_24) - int_25;
                    int int_27 = int_26 + (field2536[int_23] & 0xFF);
                    if (int_27 < 0) {
                        int_27 = 0;
                    }

                    if (int_27 > 128) {
                        int_27 = 128;
                    }

                    field2536[int_23] = (byte) int_27;
                    int_22 += int_30 - int_28;
                }

                byte_3 = byte_1;
                int_28 = int_30;
            }

            for (int_29 = byte_3; int_29 < 128; int_29++) {
                int_30 = int_28 + (field2536[int_29] & 0xFF);
                if (int_30 < 0) {
                    int_30 = 0;
                }

                if (int_30 > 128) {
                    int_30 = 128;
                }

                field2536[int_29] = (byte) int_30;
            }
        }

        for (int_20 = 0; int_20 < int_7; int_20++) {
            class216s_0[int_20].field2448 = buffer_0.readUnsignedByte();
        }

        for (int_20 = 0; int_20 < int_7; int_20++) {
            class216_2 = class216s_0[int_20];
            if (class216_2.field2447 != null) {
                class216_2.field2450 = buffer_0.readUnsignedByte();
            }

            if (class216_2.field2449 != null) {
                class216_2.field2446 = buffer_0.readUnsignedByte();
            }

            if (class216_2.field2448 > 0) {
                class216_2.field2451 = buffer_0.readUnsignedByte();
            }
        }

        for (int_20 = 0; int_20 < int_7; int_20++) {
            class216s_0[int_20].field2452 = buffer_0.readUnsignedByte();
        }

        for (int_20 = 0; int_20 < int_7; int_20++) {
            class216_2 = class216s_0[int_20];
            if (class216_2.field2452 > 0) {
                class216_2.field2453 = buffer_0.readUnsignedByte();
            }
        }

        for (int_20 = 0; int_20 < int_7; int_20++) {
            class216_2 = class216s_0[int_20];
            if (class216_2.field2453 > 0) {
                class216_2.field2454 = buffer_0.readUnsignedByte();
            }
        }

    }

    boolean method4372(final class98 class98_0, final byte[] bytes_0, final int[] ints_0) {
        boolean bool_0 = true;
        int int_0 = 0;
        RawAudioNode rawaudionode_0 = null;

        for (int int_1 = 0; int_1 < 128; int_1++) {
            if ((bytes_0 == null) || (bytes_0[int_1] != 0)) {
                int int_2 = field2539[int_1];
                if (int_2 != 0) {
                    if (int_0 != int_2) {
                        int_0 = int_2--;
                        if ((int_2 & 0x1) == 0) {
                            rawaudionode_0 = class98_0.method2216(int_2 >> 2, ints_0);
                        } else {
                            rawaudionode_0 = class98_0.method2220(int_2 >> 2, ints_0);
                        }

                        if (rawaudionode_0 == null) {
                            bool_0 = false;
                        }
                    }

                    if (rawaudionode_0 != null) {
                        field2533[int_1] = rawaudionode_0;
                        field2539[int_1] = 0;
                    }
                }
            }
        }

        return bool_0;
    }

    void method4373() {
        field2539 = null;
    }

    public static IndexedSprite getSprite(final IndexDataBase indexdatabase_0, final String string_0,
                                          final String string_1) {
        final int int_0 = indexdatabase_0.getFile(string_0);
        final int int_1 = indexdatabase_0.getChild(int_0, string_1);
        IndexedSprite indexedsprite_0;
        if (!class306.method5660(indexdatabase_0, int_0, int_1)) {
            indexedsprite_0 = null;
        } else {
            indexedsprite_0 = class305.method5658();
        }

        return indexedsprite_0;
    }

    static void method4371(final Player player_0, final int int_0, final int int_1, final int int_2) {
        if (class138.localPlayer != player_0) {
            if (Game.menuOptionCount < 400) {
                String string_0;
                if (player_0.totalLevel == 0) {
                    string_0 = player_0.actions[0] + player_0.getName(true) + player_0.actions[1]
                            + UrlRequester.method3113(player_0.combatLevel, class138.localPlayer.combatLevel) + " "
                            + " (" + "level-" + player_0.combatLevel + ")" + player_0.actions[2];
                } else {
                    string_0 = player_0.actions[0] + player_0.getName(true) + player_0.actions[1] + " " + " (" + "skill-"
                            + player_0.totalLevel + ")" + player_0.actions[2];
                }

                int int_3;
                if (Game.itemSelectionState == 1) {
                    class50.addMenuEntry("Use",
                            Game.lastSelectedItemName + " " + "->" + " " + class6.getColTags(16777215) + string_0, 14,
                            int_0, int_1, int_2);
                } else if (Game.spellSelected) {
                    if ((Actor.field932 & 0x8) == 8) {
                        class50.addMenuEntry(Game.field612,
                                Game.field739 + " " + "->" + " " + class6.getColTags(16777215) + string_0, 15, int_0,
                                int_1, int_2);
                    }
                } else {
                    for (int_3 = 7; int_3 >= 0; --int_3) {
                        if (Game.playerOptions[int_3] != null) {
                            short short_0 = 0;
                            if (Game.playerOptions[int_3].equalsIgnoreCase("Attack")) {
                                if (Game.playerAttackOption == AttackOption.AttackOption_hidden) {
                                    continue;
                                }

                                if ((Game.playerAttackOption == AttackOption.AttackOption_alwaysRightClick)
                                        || ((Game.playerAttackOption == AttackOption.AttackOption_dependsOnCombatLevels)
                                        && (player_0.combatLevel > class138.localPlayer.combatLevel))) {
                                    short_0 = 2000;
                                }

                                if ((class138.localPlayer.team != 0) && (player_0.team != 0)) {
                                    if (player_0.team == class138.localPlayer.team) {
                                        short_0 = 2000;
                                    } else {
                                        short_0 = 0;
                                    }
                                }
                            } else if (Game.playerOptionsPriorities[int_3]) {
                                short_0 = 2000;
                            }

                            final int int_4 = Game.playerMenuTypes[int_3] + short_0;
                            class50.addMenuEntry(Game.playerOptions[int_3], class6.getColTags(16777215) + string_0,
                                    int_4, int_0, int_1, int_2);
                        }
                    }
                }

                for (int_3 = 0; int_3 < Game.menuOptionCount; int_3++) {
                    if (Game.menuTypes[int_3] == 23) {
                        Game.menuTargets[int_3] = class6.getColTags(16777215) + string_0;
                        break;
                    }
                }

            }
        }
    }

}
