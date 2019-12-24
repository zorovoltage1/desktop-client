public class class216 {

    byte[] field2447;
    byte[] field2449;
    int field2448;
    int field2450;
    int field2446;
    int field2451;
    int field2453;
    int field2452;
    int field2454;

    static void method4179(final PacketBuffer packetbuffer_0, final int int_0) {
        final int int_1 = packetbuffer_0.offset;
        class81.field1165 = 0;
        class177.method3512(packetbuffer_0);

        for (int int_2 = 0; int_2 < class81.field1165; int_2++) {
            final int int_3 = class81.field1166[int_2];
            final Player player_0 = Game.cachedPlayers[int_3];
            int int_4 = packetbuffer_0.readUnsignedByte();
            if ((int_4 & 0x80) != 0) {
                int_4 += packetbuffer_0.readUnsignedByte() << 8;
            }

            byte byte_0 = -1;
            if ((int_4 & 0x200) != 0) { //teleport mode
                byte_0 = packetbuffer_0.readByteS();
            }

            if ((int_4 & 0x8) != 0) { //force text
                player_0.overhead = packetbuffer_0.readString();
                if (player_0.overhead.charAt(0) == 126) {
                    player_0.overhead = player_0.overhead.substring(1);
                    class143.sendGameMessage(2, player_0.name.getName(), player_0.overhead);
                } else if (player_0 == class138.localPlayer) {
                    class143.sendGameMessage(2, player_0.name.getName(), player_0.overhead);
                }

                player_0.field885 = false;
                player_0.field888 = 0;
                player_0.field927 = 0;
                player_0.overheadTextCyclesRemaining = 150;
            }

            int int_5;
            if ((int_4 & 0x800) != 0) { //gfx
                player_0.graphic = packetbuffer_0.readUnsignedLEShortA();
                int_5 = packetbuffer_0.readLEInt();
                player_0.field871 = int_5 >> 16;
                player_0.graphicsDelay = (int_5 & 0xFFFF) + Game.gameCycle;
                player_0.spotAnimFrame = 0;
                player_0.spotAnimFrameCycle = 0;
                if (player_0.graphicsDelay > Game.gameCycle) {
                    player_0.spotAnimFrame = -1;
                }

                if (player_0.graphic == 65535) {
                    player_0.graphic = -1;
                }
            }

            if ((int_4 & 0x400) != 0) {
                for (int_5 = 0; int_5 < 3; int_5++) {
                    player_0.actions[int_5] = packetbuffer_0.readString();
                }
            }

            int int_6;
            if ((int_4 & 0x20) != 0) { //anim
                int_5 = packetbuffer_0.readUnsignedLEShortA();
                if (int_5 == 65535) {
                    int_5 = -1;
                }

                int_6 = packetbuffer_0.readUnsignedByteA();
                GameObject.method3102(player_0, int_5, int_6);
            }

            int int_7;
            int int_8;
            if ((int_4 & 0x40) != 0) { //public chat
                int_5 = packetbuffer_0.readUnsignedLEShort();
                final Permission permission_0 = (Permission) class76.forOrdinal(WorldMapData.method216(), packetbuffer_0.readUnsignedByteA());
                final boolean bool_0 = packetbuffer_0.readUnsignedByteC() == 1;
                int_7 = packetbuffer_0.readUnsignedByte();
                int_8 = packetbuffer_0.offset;
                if ((player_0.name != null) && (player_0.composition != null)) {
                    boolean bool_1 = false;
                    if (permission_0.field3127 && DState.friendManager.isIgnored(player_0.name)) {
                        bool_1 = true;
                    }

                    if (!bool_1 && (Game.myPlayerIndex == 0) && !player_0.hidden) {
                        class81.field1154.offset = 0;
                        packetbuffer_0.readBytes(class81.field1154.payload, 0, int_7);
                        class81.field1154.offset = 0;
                        final Buffer buffer_0 = class81.field1154;

                        int int_9;
                        String string_0;
                        String string_1;
                        try {
                            int_9 = buffer_0.getUSmart();
                            if (int_9 > 32767) {
                                int_9 = 32767;
                            }

                            final byte[] bytes_0 = new byte[int_9];
                            buffer_0.offset += class300.huffman.decompress(buffer_0.payload, buffer_0.offset, bytes_0,
                                    0, int_9);
                            string_0 = class78.getString(bytes_0, 0, int_9);
                            string_1 = string_0;
                        } catch (final Exception exception_0) {
                            string_1 = "Cabbage";
                        }

                        string_1 = FontTypeFace.appendTags(class51.method998(string_1));
                        player_0.overhead = string_1.trim();
                        player_0.field888 = int_5 >> 8;
                        player_0.field927 = int_5 & 0xFF;
                        player_0.overheadTextCyclesRemaining = 150;
                        player_0.field885 = bool_0;
                        player_0.field886 = (player_0 != class138.localPlayer) && permission_0.field3127
                                && ("" != Game.field796) && (string_1.toLowerCase().indexOf(Game.field796) == -1);
                        if (permission_0.field3126) {
                            int_9 = bool_0 ? 91 : 1;
                        } else {
                            int_9 = bool_0 ? 90 : 2;
                        }

                        if (permission_0.field3128 != -1) {
                            final int int_10 = permission_0.field3128;
                            string_0 = "<img=" + int_10 + ">";
                            class143.sendGameMessage(int_9, string_0 + player_0.name.getName(), string_1);
                        } else {
                            class143.sendGameMessage(int_9, player_0.name.getName(), string_1);
                        }
                    }
                }

                packetbuffer_0.offset = int_7 + int_8;
            }

            if ((int_4 & 0x1000) != 0) { //movement mode
                class81.field1153[int_3] = packetbuffer_0.readByteS();
            }

            if ((int_4 & 0x1) != 0) { //hits
                int_5 = packetbuffer_0.readUnsignedByteA();
                int int_11;
                int int_13;
                int int_14;
                if (int_5 > 0) {
                    for (int_6 = 0; int_6 < int_5; int_6++) {
                        int_7 = -1;
                        int_8 = -1;
                        int_14 = -1;
                        int_13 = packetbuffer_0.getUSmart();
                        if (int_13 == 32767) {
                            int_13 = packetbuffer_0.getUSmart();
                            int_8 = packetbuffer_0.getUSmart();
                            int_7 = packetbuffer_0.getUSmart();
                            int_14 = packetbuffer_0.getUSmart();
                        } else if (int_13 != 32766) {
                            int_8 = packetbuffer_0.getUSmart();
                        } else {
                            int_13 = -1;
                        }

                        int_11 = packetbuffer_0.getUSmart();
                        player_0.applyActorHitsplat(int_13, int_8, int_7, int_14, Game.gameCycle, int_11);
                    }
                }

                int_6 = packetbuffer_0.readUnsignedByte();
                if (int_6 > 0) {
                    for (int_13 = 0; int_13 < int_6; int_13++) {
                        int_7 = packetbuffer_0.getUSmart();
                        int_8 = packetbuffer_0.getUSmart();
                        if (int_8 != 32767) {
                            int_14 = packetbuffer_0.getUSmart();
                            int_11 = packetbuffer_0.readUnsignedByteA();
                            final int int_12 = int_8 > 0 ? packetbuffer_0.readUnsignedByteC() : int_11;
                            player_0.setCombatInfo(int_7, Game.gameCycle, int_8, int_14, int_11, int_12);
                        } else {
                            player_0.method1557(int_7);
                        }
                    }
                }
            }

            if ((int_4 & 0x100) != 0) { //forced movement
                player_0.field913 = packetbuffer_0.readByteA();
                player_0.field915 = packetbuffer_0.readByteS();
                player_0.field916 = packetbuffer_0.readByteA();
                player_0.field929 = packetbuffer_0.readByteS();
                player_0.field917 = packetbuffer_0.readUnsignedShort() + Game.gameCycle;
                player_0.field918 = packetbuffer_0.readUnsignedLEShortA() + Game.gameCycle;
                player_0.field919 = packetbuffer_0.readUnsignedLEShortA();
                if (player_0.field571) {
                    player_0.field913 += player_0.field572;
                    player_0.field915 += player_0.field573;
                    player_0.field916 += player_0.field572;
                    player_0.field929 += player_0.field573;
                    player_0.queueSize = 0;
                } else {
                    player_0.field913 += player_0.pathX[0];
                    player_0.field915 += player_0.pathY[0];
                    player_0.field916 += player_0.pathX[0];
                    player_0.field929 += player_0.pathY[0];
                    player_0.queueSize = 1;
                }

                player_0.field930 = 0;
            }

            if ((int_4 & 0x10) != 0) { //face entity
                player_0.interacting = packetbuffer_0.readUnsignedLEShort();
                if (player_0.interacting == 65535) {
                    player_0.interacting = -1;
                }
            }

            if ((int_4 & 0x4) != 0) { //appearance
                int_5 = packetbuffer_0.readUnsignedByteA();
                final byte[] bytes_1 = new byte[int_5];
                final Buffer buffer_1 = new Buffer(bytes_1);
                packetbuffer_0.readBytes(bytes_1, 0, int_5);
                class81.field1157[int_3] = buffer_1;
                player_0.decodeApperance(buffer_1);
            }

            if ((int_4 & 0x2) != 0) { //face direction
                player_0.field920 = packetbuffer_0.readUnsignedShort();
                if (player_0.queueSize == 0) {
                    player_0.orientation = player_0.field920;
                    player_0.field920 = -1;
                }
            }

            if (player_0.field571) {
                if (byte_0 == 127) {
                    player_0.method1103(player_0.field572, player_0.field573);
                } else {
                    byte byte_1;
                    if (byte_0 != -1) {
                        byte_1 = byte_0;
                    } else {
                        byte_1 = class81.field1153[int_3];
                    }

                    player_0.method1106(player_0.field572, player_0.field573, byte_1);
                }
            }
        }

        if ((packetbuffer_0.offset - int_1) != int_0) {
            throw new RuntimeException((packetbuffer_0.offset - int_1) + " " + int_0);
        }
    }

    static void method4178(final int int_0) {
        if (CombatInfo2.loadWidget(int_0)) {
            final Widget[] widgets_0 = GameCanvas.widgets[int_0];

            for (int int_1 = 0; int_1 < widgets_0.length; int_1++) {
                final Widget widget_0 = widgets_0[int_1];
                if (widget_0 != null) {
                    widget_0.field2728 = 0;
                    widget_0.field2613 = 0;
                }
            }

        }
    }

}
