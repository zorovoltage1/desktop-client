public class class51 {

    Script field466;
    int field463;
    int[] field462;
    String[] field465;

    class51() {
        field463 = -1;
    }

    public static Parameters[] method996() {
        return new Parameters[]{Parameters.field3596, Parameters.field3580, Parameters.field3582,
                Parameters.field3585, Parameters.field3593, Parameters.field3587, Parameters.field3583,
                Parameters.field3595, Parameters.field3592, Parameters.field3588, Parameters.field3586,
                Parameters.field3590, Parameters.field3594, Parameters.field3589, Parameters.field3581,
                Parameters.field3584};
    }

    public static String method998(final String string_0) {
        final int int_0 = string_0.length();
        final char[] chars_0 = new char[int_0];
        byte byte_0 = 2;

        for (int int_1 = 0; int_1 < int_0; int_1++) {
            char char_0 = string_0.charAt(int_1);
            if (byte_0 == 0) {
                char_0 = Character.toLowerCase(char_0);
            } else if ((byte_0 == 2) || Character.isUpperCase(char_0)) {
                char_0 = Name.method5450(char_0);
            }

            if (Character.isLetter(char_0)) {
                byte_0 = 0;
            } else if ((char_0 != 46) && (char_0 != 63) && (char_0 != 33)) {
                if (Character.isSpaceChar(char_0)) {
                    if (byte_0 != 2) {
                        byte_0 = 1;
                    }
                } else {
                    byte_0 = 1;
                }
            } else {
                byte_0 = 2;
            }

            chars_0[int_1] = char_0;
        }

        return new String(chars_0);
    }

    static void method995(final String string_0) {
        StringBuilder stringbuilder_0 = new StringBuilder();
        stringbuilder_0 = stringbuilder_0.append("Please remove ").append(string_0);
        final String string_1 = stringbuilder_0.append(" from your ignore list first").toString();
        class143.sendGameMessage(30, "", string_1);
    }

    static void xteaChanged(final boolean dynamicRegion, final PacketBuffer packetBuffer) {
        Game.isDynamicRegion = dynamicRegion;
        int chunkX;
        int chunkY;
        int count;
        int pointZ;
        int pointX;
        int pointY;
        if (!Game.isDynamicRegion) {
            chunkX = packetBuffer.readUnsignedShortA();
            chunkY = packetBuffer.readUnsignedLEShortA();
            int regionCount = packetBuffer.readUnsignedShort();
            FriendManager.xteaKeys = new int[regionCount][4];

            for (count = 0; count < regionCount; count++) {
                for (pointZ = 0; pointZ < 4; pointZ++) {
                    FriendManager.xteaKeys[count][pointZ] = packetBuffer.readInt();
                }
            }

            class143.mapRegions = new int[regionCount];
            FontName.landMapFileIds = new int[regionCount];
            class9.landRegionFileIds = new int[regionCount];
            class171.field2252 = new byte[regionCount][];
            MapCacheArchiveNames.field253 = new byte[regionCount][];
            boolean bool_2 = false;
            if ((((chunkX / 8) == 48) || ((chunkX / 8) == 49)) && ((chunkY / 8) == 48)) {
                bool_2 = true;
            }

            if (((chunkX / 8) == 48) && ((chunkY / 8) == 148)) {
                bool_2 = true;
            }

            regionCount = 0;

            for (pointZ = (chunkX - 6) / 8; pointZ <= ((chunkX + 6) / 8); pointZ++) {
                for (pointX = (chunkY - 6) / 8; pointX <= ((chunkY + 6) / 8); pointX++) {
                    pointY = pointX + (pointZ << 8);
                    if (!bool_2 || ((pointX != 49) && (pointX != 149) && (pointX != 147) && (pointZ != 50) && ((pointZ != 49) || (pointX != 47)))) {
                        class143.mapRegions[regionCount] = pointY;
                        FontName.landMapFileIds[regionCount] = FileRequest.indexMaps.getFile("m" + pointZ + "_" + pointX);
                        class9.landRegionFileIds[regionCount] = FileRequest.indexMaps.getFile("l" + pointZ + "_" + pointX);
                        ++regionCount;
                    }
                }
            }

            PendingSpawn.method1537(chunkX, chunkY, true);
        } else {
            chunkX = packetBuffer.readUnsignedLEShort();
            chunkY = packetBuffer.readUnsignedLEShort();
            final boolean bool_1 = packetBuffer.readUnsignedByte() == 1;
            count = packetBuffer.readUnsignedShort();
            packetBuffer.bitAccess();

            int int_7;
            for (pointZ = 0; pointZ < 4; pointZ++) {
                for (pointX = 0; pointX < 13; pointX++) {
                    for (pointY = 0; pointY < 13; pointY++) {
                        int_7 = packetBuffer.getBits(1);
                        if (int_7 == 1) {
                            Game.instanceTemplateChunks[pointZ][pointX][pointY] = packetBuffer.getBits(26);
                        } else {
                            Game.instanceTemplateChunks[pointZ][pointX][pointY] = -1;
                        }
                    }
                }
            }

            packetBuffer.byteAccess();
            FriendManager.xteaKeys = new int[count][4];

            for (pointZ = 0; pointZ < count; pointZ++) {
                for (pointX = 0; pointX < 4; pointX++) {
                    FriendManager.xteaKeys[pointZ][pointX] = packetBuffer.readInt();
                }
            }

            class143.mapRegions = new int[count];
            FontName.landMapFileIds = new int[count];
            class9.landRegionFileIds = new int[count];
            class171.field2252 = new byte[count][];
            MapCacheArchiveNames.field253 = new byte[count][];
            count = 0;

            for (pointZ = 0; pointZ < 4; pointZ++) {
                for (pointX = 0; pointX < 13; pointX++) {
                    for (pointY = 0; pointY < 13; pointY++) {
                        int_7 = Game.instanceTemplateChunks[pointZ][pointX][pointY];
                        if (int_7 != -1) {
                            final int int_8 = (int_7 >> 14) & 0x3FF;
                            final int int_9 = (int_7 >> 3) & 0x7FF;
                            int int_10 = ((int_8 / 8) << 8) + (int_9 / 8);

                            int int_11;
                            for (int_11 = 0; int_11 < count; int_11++) {
                                if (class143.mapRegions[int_11] == int_10) {
                                    int_10 = -1;
                                    break;
                                }
                            }

                            if (int_10 != -1) {
                                class143.mapRegions[count] = int_10;
                                int_11 = (int_10 >> 8) & 0xFF;
                                final int int_12 = int_10 & 0xFF;
                                FontName.landMapFileIds[count] = FileRequest.indexMaps
                                        .getFile("m" + int_11 + "_" + int_12);
                                class9.landRegionFileIds[count] = FileRequest.indexMaps
                                        .getFile("l" + int_11 + "_" + int_12);
                                ++count;
                            }
                        }
                    }
                }
            }

            PendingSpawn.method1537(chunkX, chunkY, !bool_1);
        }

    }

    static void method997(final int int_0, final int int_1) {
        if ((Game.menuOptionCount >= 2) || (Game.itemSelectionState != 0) || Game.spellSelected) {
            if (Game.field728) {
                final int int_2 = Game.menuOptionCount - 1;
                String string_0;
                if ((Game.itemSelectionState == 1) && (Game.menuOptionCount < 2)) {
                    string_0 = "Use" + " " + Game.lastSelectedItemName + " " + "->";
                } else if (Game.spellSelected && (Game.menuOptionCount < 2)) {
                    string_0 = Game.field612 + " " + Game.field739 + " " + "->";
                } else {
                    string_0 = WorldMapType1.method176(int_2);
                }

                if (Game.menuOptionCount > 2) {
                    string_0 = string_0 + class6.getColTags(16777215) + " " + '/' + " " + (Game.menuOptionCount - 2)
                            + " more options";
                }

                ClanMemberManager.fontBold12.drawRandomizedMouseoverText(string_0, int_0 + 4, int_1 + 15, 16777215, 0,
                        Game.gameCycle / 1000);
            }
        }
    }

}
