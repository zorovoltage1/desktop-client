import java.io.EOFException;

public class Varcs {

    public static int canvasWidth;
    boolean[] varcSerials;
    boolean[] varcstringSerials;
    int[] varcs;
    String[] varcstrings;
    boolean changed;
    long field1177;

    Varcs() {
        changed = false;
        varcs = new int[SoundTask.configsIndex.fileCount(19)];
        varcstrings = new String[SoundTask.configsIndex.fileCount(15)];
        varcSerials = new boolean[varcs.length];

        int int_0;
        for (int_0 = 0; int_0 < varcs.length; int_0++) {
            final VarCInt varcint_0 = class21.method275(int_0);
            varcSerials[int_0] = varcint_0.field3256;
        }

        varcstringSerials = new boolean[varcstrings.length];

        for (int_0 = 0; int_0 < varcstrings.length; int_0++) {
            final VarCString varcstring_0 = GZipDecompressor.method3485(int_0);
            varcstringSerials[int_0] = varcstring_0.field3261;
        }

        for (int_0 = 0; int_0 < varcs.length; int_0++) {
            varcs[int_0] = -1;
        }

        deserialize();
    }

    void putVarc(final int int_0, final int int_1) {
        varcs[int_0] = int_1;
        if (varcSerials[int_0]) {
            changed = true;
        }

    }

    int getVarc(final int int_0) {
        return varcs[int_0];
    }

    void putVarcString(final int int_0, final String string_0) {
        varcstrings[int_0] = string_0;
        if (varcstringSerials[int_0]) {
            changed = true;
        }

    }

    String getVarcString(final int int_0) {
        return varcstrings[int_0];
    }

    void reset() {
        int int_0;
        for (int_0 = 0; int_0 < varcs.length; int_0++) {
            if (!varcSerials[int_0]) {
                varcs[int_0] = -1;
            }
        }

        for (int_0 = 0; int_0 < varcstrings.length; int_0++) {
            if (!varcstringSerials[int_0]) {
                varcstrings[int_0] = null;
            }
        }

    }

    FileOnDisk getVarPrefs(final boolean bool_0) {
        return MapLabel.getPreferencesFile("2", ItemLayer.field1455.name, bool_0);
    }

    void serialize() {
        final FileOnDisk fileondisk_0 = getVarPrefs(true);

        try {
            int int_0 = 3;
            int int_1 = 0;

            int int_2;
            for (int_2 = 0; int_2 < varcs.length; int_2++) {
                if (varcSerials[int_2] && (varcs[int_2] != -1)) {
                    int_0 += 6;
                    ++int_1;
                }
            }

            int_0 += 2;
            int_2 = 0;

            for (int int_3 = 0; int_3 < varcstrings.length; int_3++) {
                if (varcstringSerials[int_3] && (varcstrings[int_3] != null)) {
                    int_0 += 2 + class316.getLength(varcstrings[int_3]);
                    ++int_2;
                }
            }

            final Buffer buffer_0 = new Buffer(int_0);
            buffer_0.putByte(1);
            buffer_0.putShort(int_1);

            int int_4;
            for (int_4 = 0; int_4 < varcs.length; int_4++) {
                if (varcSerials[int_4] && (varcs[int_4] != -1)) {
                    buffer_0.putShort(int_4);
                    buffer_0.putInt(varcs[int_4]);
                }
            }

            buffer_0.putShort(int_2);

            for (int_4 = 0; int_4 < varcstrings.length; int_4++) {
                if (varcstringSerials[int_4] && (varcstrings[int_4] != null)) {
                    buffer_0.putShort(int_4);
                    buffer_0.putString(varcstrings[int_4]);
                }
            }

            fileondisk_0.write(buffer_0.payload, 0, buffer_0.offset);
        } catch (final Exception exception_0) {
        } finally {
            try {
                fileondisk_0.close();
            } catch (final Exception exception_1) {
            }

        }

        changed = false;
        field1177 = Buffer.safeCurrentTimeMillis();
    }

    void deserialize() {
        final FileOnDisk fileondisk_0 = getVarPrefs(false);

        try {
            final byte[] bytes_0 = new byte[(int) fileondisk_0.length()];

            int int_1;
            for (int int_0 = 0; int_0 < bytes_0.length; int_0 += int_1) {
                int_1 = fileondisk_0.read(bytes_0, int_0, bytes_0.length - int_0);
                if (int_1 == -1) {
                    throw new EOFException();
                }
            }

            final Buffer buffer_0 = new Buffer(bytes_0);
            if ((buffer_0.payload.length - buffer_0.offset) < 1) {
                return;
            }

            final int int_2 = buffer_0.readUnsignedByte();
            if ((int_2 < 0) || (int_2 > 1)) {
                return;
            }

            final int int_3 = buffer_0.readUnsignedShort();

            int int_4;
            int int_5;
            int int_6;
            for (int_4 = 0; int_4 < int_3; int_4++) {
                int_5 = buffer_0.readUnsignedShort();
                int_6 = buffer_0.readInt();
                if (varcSerials[int_5]) {
                    varcs[int_5] = int_6;
                }
            }

            int_4 = buffer_0.readUnsignedShort();

            for (int_5 = 0; int_5 < int_4; int_5++) {
                int_6 = buffer_0.readUnsignedShort();
                final String string_0 = buffer_0.readString();
                if (varcstringSerials[int_6]) {
                    varcstrings[int_6] = string_0;
                }
            }
        } catch (final Exception exception_0) {
        } finally {
            try {
                fileondisk_0.close();
            } catch (final Exception exception_1) {
            }

        }

        changed = false;
    }

    void process() {
        if (changed && (field1177 < (Buffer.safeCurrentTimeMillis() - 60000L))) {
            serialize();
        }

    }

    boolean changed() {
        return changed;
    }

    static void method1894() {
        if (class13.plane != Game.field651) {
            Game.field651 = class13.plane;
            final int int_0 = class13.plane;
            final int[] ints_0 = NPC.minimapSprite.pixels;
            final int int_1 = ints_0.length;

            int int_2;
            for (int_2 = 0; int_2 < int_1; int_2++) {
                ints_0[int_2] = 0;
            }

            int int_3;
            int x;
            for (int_2 = 1; int_2 < 103; int_2++) {
                int_3 = ((103 - int_2) * 2048) + 24628;

                for (x = 1; x < 103; x++) {
                    if ((class50.tileSettings[int_0][x][int_2] & 0x18) == 0) {
                        MapIcon.region.drawTile(ints_0, int_3, 512, int_0, x, int_2);
                    }

                    if ((int_0 < 3) && ((class50.tileSettings[int_0 + 1][x][int_2] & 0x8) != 0)) {
                        MapIcon.region.drawTile(ints_0, int_3, 512, int_0 + 1, x, int_2);
                    }

                    int_3 += 4;
                }
            }

            int_2 = (((238 + (int) (Math.random() * 20.0D)) - 10) << 16)
                    + (((238 + (int) (Math.random() * 20.0D)) - 10) << 8)
                    + ((238 + (int) (Math.random() * 20.0D)) - 10);
            int_3 = ((238 + (int) (Math.random() * 20.0D)) - 10) << 16;
            NPC.minimapSprite.setRaster();

            int y;
            for (x = 1; x < 103; x++) {
                for (y = 1; y < 103; y++) {
                    if ((class50.tileSettings[int_0][y][x] & 0x18) == 0) {
                        class224.method4422(int_0, y, x, int_2, int_3);
                    }

                    if ((int_0 < 3) && ((class50.tileSettings[int_0 + 1][y][x] & 0x8) != 0)) {
                        class224.method4422(int_0 + 1, y, x, int_2, int_3);
                    }
                }
            }

            Game.mapIconCount = 0;

            for (x = 0; x < 104; x++) {
                for (y = 0; y < 104; y++) {
                    final long long_0 = MapIcon.region.method2901(class13.plane, x, y);
                    if (long_0 != 0L) {
                        final int int_6 = KeyFocusListener.method673(long_0);
                        final int int_7 = FileOnDisk.getObjectDefinition(int_6).mapIconId;
                        if (int_7 >= 0) {
                            Game.mapIcons[Game.mapIconCount] = Area.mapAreaType[int_7].getMapIcon(false);
                            Game.mapIconTileX[Game.mapIconCount] = x;
                            Game.mapIconTileY[Game.mapIconCount] = y;
                            ++Game.mapIconCount;
                        }
                    }
                    int absX = PendingSpawn.baseX + x;
                    int absY = Game.baseY + y;

                    if (WorldType.isPVP() && absX == 3078 && absY == 3510) {
                        Game.mapIcons[Game.mapIconCount] = Loader.bmIcon;
                        Game.mapIconTileX[Game.mapIconCount] = x;
                        Game.mapIconTileY[Game.mapIconCount] = y;
                        Game.mapIconCount++;
                    }

                    if (WorldType.isPVP() && absX == 3082 && absY == 3507) {
                        Game.mapIcons[Game.mapIconCount] = Loader.donatorIcon;
                        Game.mapIconTileX[Game.mapIconCount] = x;
                        Game.mapIconTileY[Game.mapIconCount] = y;
                        Game.mapIconCount++;
                    }

                    if (WorldType.isEco() && absX == 3080 && absY == 3513) {
                        Game.mapIcons[Game.mapIconCount] = Loader.donatorIcon;
                        Game.mapIconTileX[Game.mapIconCount] = x;
                        Game.mapIconTileY[Game.mapIconCount] = y;
                        Game.mapIconCount++;
                    }

                    if (absX == 3099 && absY == 3510) {
                        Game.mapIcons[Game.mapIconCount] = Loader.prayerIcon;
                        Game.mapIconTileX[Game.mapIconCount] = x;
                        Game.mapIconTileY[Game.mapIconCount] = y;
                        Game.mapIconCount++;
                    }

                    if (absX == 3088 && absY == 3495) {
                        Game.mapIcons[Game.mapIconCount] = Loader.helpIcon;
                        Game.mapIconTileX[Game.mapIconCount] = x;
                        Game.mapIconTileY[Game.mapIconCount] = y;
                        Game.mapIconCount++;
                    }

                    if (absX == 3087 && absY == 3507) {
                        Game.mapIcons[Game.mapIconCount] = Loader.transportationIcon;
                        Game.mapIconTileX[Game.mapIconCount] = x;
                        Game.mapIconTileY[Game.mapIconCount] = y;
                        Game.mapIconCount++;
                    }


                    if (WorldType.isPVP() && absX == 3092 && absY == 3508) {
                        Game.mapIcons[Game.mapIconCount] = Loader.heartIcon;
                        Game.mapIconTileX[Game.mapIconCount] = x;
                        Game.mapIconTileY[Game.mapIconCount] = y;
                        Game.mapIconCount++;
                    }

                    if (WorldType.isEco() && absX == 3083 && absY == 3510) {
                        Game.mapIcons[Game.mapIconCount] = Loader.ironmanIcon;
                        Game.mapIconTileX[Game.mapIconCount] = x;
                        Game.mapIconTileY[Game.mapIconCount] = y;
                        Game.mapIconCount++;
                    }

                    if (absX == 3099 && absY == 3514) {
                        Game.mapIcons[Game.mapIconCount] = Loader.bankIcon;
                        Game.mapIconTileX[Game.mapIconCount] = x;
                        Game.mapIconTileY[Game.mapIconCount] = y;
                        Game.mapIconCount++;
                    }

                    if (absX == 3092 && absY == 3514) {
                        Game.mapIcons[Game.mapIconCount] = Loader.bankIcon;
                        Game.mapIconTileX[Game.mapIconCount] = x;
                        Game.mapIconTileY[Game.mapIconCount] = y;
                        Game.mapIconCount++;
                    }

                    if (absX == 3095 && absY == 3514) {
                        Game.mapIcons[Game.mapIconCount] = Loader.poolIcon;
                        Game.mapIconTileX[Game.mapIconCount] = x;
                        Game.mapIconTileY[Game.mapIconCount] = y;
                        Game.mapIconCount++;
                    }

                    if (WorldType.isEco() && absX == 3092 && absY == 3505) {
                        Game.mapIcons[Game.mapIconCount] = Loader.slayerIcon;
                        Game.mapIconTileX[Game.mapIconCount] = x;
                        Game.mapIconTileY[Game.mapIconCount] = y;
                        Game.mapIconCount++;
                    }

                    if (WorldType.isEco() && absX == 3077 && absY == 3510) {
                        Game.mapIcons[Game.mapIconCount] = Loader.coinIcon;
                        Game.mapIconTileX[Game.mapIconCount] = x;
                        Game.mapIconTileY[Game.mapIconCount] = y;
                        Game.mapIconCount++;
                    }

                    if (WorldType.isEco() && absX == 3109 && absY == 3514) {
                        Game.mapIcons[Game.mapIconCount] = Loader.minigameIcon;
                        Game.mapIconTileX[Game.mapIconCount] = x;
                        Game.mapIconTileY[Game.mapIconCount] = y;
                        Game.mapIconCount++;
                    }

                    if (WorldType.isEco() && absX == 3084 && absY == 3492) {
                        Game.mapIcons[Game.mapIconCount] = Loader.thievingIcon;
                        Game.mapIconTileX[Game.mapIconCount] = x;
                        Game.mapIconTileY[Game.mapIconCount] = y;
                        Game.mapIconCount++;
                    }

                    if (WorldType.isEco() && absX == 3090 && absY == 3499) {
                        Game.mapIcons[Game.mapIconCount] = Loader.heartIcon;
                        Game.mapIconTileX[Game.mapIconCount] = x;
                        Game.mapIconTileY[Game.mapIconCount] = y;
                        Game.mapIconCount++;
                    }

                }
            }

            GameSocket.rasterProvider.setRaster();
        }

    }

    static void method1921(final int int_0, final int int_1) {
        final PacketNode packetnode_0 = class26.method433(ClientPacket.ADVANCE_DIALOGUE, Game.field626.field1218);
        packetnode_0.packetBuffer.addLEInt(int_0);
        packetnode_0.packetBuffer.addShortA(int_1);
        Game.field626.method1980(packetnode_0);
    }

}
