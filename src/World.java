import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class World {

    static World[] worldList;
    static int worldCount;
    static int field944;
    static int[] field939;
    static int[] field946;
    int id;
    int mask;
    int playerCount;
    String address;
    String activity;
    int location;
    int index;

    static {
        worldCount = 0;
        field944 = 0;
        field939 = new int[]{1, 1, 1, 1};
        field946 = new int[]{0, 1, 2, 3};
    }

    boolean method1589() {
        return (0x1 & mask) != 0;
    }

    boolean method1567() {
        return (0x2 & mask) != 0;
    }

    boolean method1568() {
        return (0x4 & mask) != 0;
    }

    boolean method1569() {
        return (0x8 & mask) != 0;
    }

    boolean method1570() {
        return (0x20000000 & mask) != 0;
    }

    boolean method1577() {
        return (0x2000000 & mask) != 0;
    }

    static File method1583(final String string_0, final String string_1, final int int_0) {
        final String string_2 = int_0 == 0 ? "" : String.valueOf(int_0);
        class155.jagexClDat = new File(WorldMapType1.userHome, "jagex_cl_" + string_0 + "_" + string_1 + string_2 + ".dat");
        String string_3 = null;
        String string_4 = null;
        boolean bool_0 = false;
        Buffer buffer_0;
        File file_4;
        if (class155.jagexClDat.exists()) {
            try {
                final FileOnDisk fileondisk_0 = new FileOnDisk(class155.jagexClDat, "rw", 10000L);

                int int_1;
                for (buffer_0 = new Buffer((int) fileondisk_0
                        .length()); buffer_0.offset < buffer_0.payload.length; buffer_0.offset += int_1) {
                    int_1 = fileondisk_0.read(buffer_0.payload, buffer_0.offset,
                            buffer_0.payload.length - buffer_0.offset);
                    if (int_1 == -1) {
                        throw new IOException();
                    }
                }

                buffer_0.offset = 0;
                int_1 = buffer_0.readUnsignedByte();
                if ((int_1 < 1) || (int_1 > 3)) {
                    throw new IOException("" + int_1);
                }

                int int_2 = 0;
                if (int_1 > 1) {
                    int_2 = buffer_0.readUnsignedByte();
                }

                if (int_1 <= 2) {
                    string_3 = buffer_0.getJagString();
                    if (int_2 == 1) {
                        string_4 = buffer_0.getJagString();
                    }
                } else {
                    string_3 = buffer_0.getCESU8();
                    if (int_2 == 1) {
                        string_4 = buffer_0.getCESU8();
                    }
                }

                fileondisk_0.close();
            } catch (final IOException ioexception_0) {
                ioexception_0.printStackTrace();
            }

            if (string_3 != null) {
                file_4 = new File(string_3);
                if (!file_4.exists()) {
                    string_3 = null;
                }
            }

            if (string_3 != null) {
                file_4 = new File(string_3, "test.dat");
                if (!GraphicsObject.method1766(file_4, true)) {
                    string_3 = null;
                }
            }
        }

        if ((string_3 == null) && (int_0 == 0)) {
            label137:
            for (int int_3 = 0; int_3 < class8.field52.length; int_3++) {
                for (int i = 0; i < class155.cacheLocations.length; i++) {
                    final File file = new File(class155.cacheLocations[i] + class8.field52[int_3]
                            + File.separatorChar + string_0 + File.separatorChar);
                    if (file.exists() && GraphicsObject.method1766(new File(file, "test.dat"), true)) {
                        string_3 = file.toString();
                        bool_0 = true;
                        break label137;
                    }
                }
            }
        }

        if (string_3 == null) {
            string_3 = WorldMapType1.userHome + File.separatorChar + "jagexcache" + string_2 + File.separatorChar
                    + string_0 + File.separatorChar + string_1 + File.separatorChar;
            bool_0 = true;
        }

        File file_3;
        if (string_4 != null) {
            file_3 = new File(string_4);
            file_4 = new File(string_3);

            try {
                final File[] files_1 = file_3.listFiles();
                final File[] files_0 = files_1;

                for (int int_5 = 0; int_5 < files_0.length; int_5++) {
                    final File file_1 = files_0[int_5];
                    final File file_2 = new File(file_4, file_1.getName());
                    final boolean bool_1 = file_1.renameTo(file_2);
                    if (!bool_1) {
                        throw new IOException();
                    }
                }
            } catch (final Exception exception_0) {
                exception_0.printStackTrace();
            }

            bool_0 = true;
        }

        if (bool_0) {
            file_3 = new File(string_3);
            buffer_0 = null;

            try {
                final FileOnDisk fileondisk_1 = new FileOnDisk(class155.jagexClDat, "rw", 10000L);
                final Buffer buffer_1 = new Buffer(500);
                buffer_1.putByte(3);
                buffer_1.putByte(buffer_0 != null ? 1 : 0);
                buffer_1.putCESU8(file_3.getPath());
                if (buffer_0 != null) {
                    buffer_1.putCESU8("");
                }

                fileondisk_1.write(buffer_1.payload, 0, buffer_1.offset);
                fileondisk_1.close();
            } catch (final IOException ioexception_1) {
                ioexception_1.printStackTrace();
            }
        }

        return new File(string_3);
    }

    static void loadTerrain(final Buffer buffer_0, final int z, final int x, final int y, final int int_3,
                            final int int_4, final int chunkRotation) {
        int int_6;
        if ((x >= 0) && (x < 104) && (y >= 0) && (y < 104)) {
            int absX = x + int_3;
            int absY = y + int_4;
            class50.tileSettings[z][x][y] = 0;

            while (true) {
                int_6 = buffer_0.readUnsignedByte();
                if (int_6 == 0) {
                    if (z == 0) {
                        final int[] ints_0 = class50.tileHeights[0][x];
                        final int int_7 = x + int_3 + 932731;
                        final int int_8 = y + int_4 + 556238;
                        int int_9 = (class32.getSmoothNoise(45365 + int_7, int_8 + 91923, 4) - 128)
                                + ((class32.getSmoothNoise(10294 + int_7, 37821 + int_8, 2) - 128) >> 1)
                                + ((class32.getSmoothNoise(int_7, int_8, 1) - 128) >> 2);
                        int_9 = (int) (int_9 * 0.3D) + 35;
                        if (int_9 < 10) {
                            int_9 = 10;
                        } else if (int_9 > 60) {
                            int_9 = 60;
                        }

                        ints_0[y] = -int_9 * 8;
                    } else {
                        class50.tileHeights[z][x][y] = class50.tileHeights[z - 1][x][y] - 240;
                    }
                    break;
                }

                if (int_6 == 1) {
                    int int_10 = buffer_0.readUnsignedByte();
                    if (int_10 == 1) {
                        int_10 = 0;
                    }

                    if (z == 0) {
                        class50.tileHeights[0][x][y] = -int_10 * 8;
                    } else {
                        class50.tileHeights[z][x][y] = class50.tileHeights[z - 1][x][y]
                                - (int_10 * 8);
                    }
                    break;
                }

                if (int_6 <= 49) {
                    class165.tileOverlayIds[z][x][y] = buffer_0.readByte();
                    class50.tileOverlayPath[z][x][y] = (byte) ((int_6 - 2) / 4);
                    WorldMapDecoration.overlayRotations[z][x][y] = (byte) (((int_6 - 2) + chunkRotation) & 0x3);
                } else if (int_6 <= 81) {
                    class50.tileSettings[z][x][y] = (byte) (int_6 - 49);
                } else {
                    class50.tileUnderlayIds[z][x][y] = (byte) (int_6 - 81);
                }

                if (z == 0 && absX > 3078 && absX < 3081 && absY > 3496 && absY < 3503) {
                    class50.tileOverlayPath[z][x][y] = -1;
                }

                /* Christmas snow underlay! */
                if(Loader.CHRISTMAS) {
                    if (z == 0 && absX > 3067 && absX < 3133 && absY > 3451 && absY < 3523) {
                        class50.tileUnderlayIds[z][x][y] = 58;
                    }
                }

            }
        } else {
            while (true) {
                int_6 = buffer_0.readUnsignedByte();
                if (int_6 == 0) {
                    break;
                }

                if (int_6 == 1) {
                    buffer_0.readUnsignedByte();
                    break;
                }

                if (int_6 <= 49) {
                    buffer_0.readUnsignedByte();
                }
            }
        }

    }

    public static void method1602(final int int_0, final IndexDataBase indexdatabase_0, final int int_1,
                                  final int int_2, final int int_3, final boolean bool_0) {
        class217.field2460 = 1;
        class138.field1871 = indexdatabase_0;
        class217.field2461 = int_1;
        class217.field2462 = int_2;
        class309.field3740 = int_3;
        class217.field2463 = bool_0;
        class6.field37 = int_0;
    }

    static int method1605(final int int_0, final Script script_0, final boolean bool_0) {
        final Widget widget_0 = bool_0 ? class276.field3561 : KitDefinition.field3301;
        if (int_0 == 1500) {
            class69.intStack[++class69.intStackSize - 1] = widget_0.relativeX;
            return 1;
        } else if (int_0 == 1501) {
            class69.intStack[++class69.intStackSize - 1] = widget_0.relativeY;
            return 1;
        } else if (int_0 == 1502) {
            class69.intStack[++class69.intStackSize - 1] = widget_0.width;
            return 1;
        } else if (int_0 == 1503) {
            class69.intStack[++class69.intStackSize - 1] = widget_0.height;
            return 1;
        } else if (int_0 == 1504) {
            class69.intStack[++class69.intStackSize - 1] = widget_0.isHidden ? 1 : 0;
            return 1;
        } else if (int_0 == 1505) {
            class69.intStack[++class69.intStackSize - 1] = widget_0.parentHash;
            return 1;
        } else {
            return 2;
        }
    }

    public static AbstractSoundSystem method1582(final Signlink signlink_0, final int int_0, int int_1) {
        if (AbstractSoundSystem.sampleRate == 0) {
            throw new IllegalStateException();
        } else if ((int_0 >= 0) && (int_0 < 2)) {
            if (int_1 < 256) {
                int_1 = 256;
            }

            try {
                final AbstractSoundSystem abstractsoundsystem_0 = AbstractSoundSystem.soundTaskDataProvider
                        .vmethod2052();
                abstractsoundsystem_0.samples = new int[(AbstractSoundSystem.audioHighMemory ? 2 : 1) * 256];
                abstractsoundsystem_0.field1303 = int_1;
                abstractsoundsystem_0.vmethod2176();
                abstractsoundsystem_0.offset = (int_1 & 0xFFFFFC00) + 1024;
                if (abstractsoundsystem_0.offset > 16384) {
                    abstractsoundsystem_0.offset = 16384;
                }

                abstractsoundsystem_0.create(abstractsoundsystem_0.offset);
                if ((WorldMapType2.field230 > 0) && (class69.task == null)) {
                    class69.task = new SoundTask();
                    UrlRequester.field1855 = Executors.newScheduledThreadPool(1);
                    UrlRequester.field1855.scheduleAtFixedRate(class69.task, 0L, 10L, TimeUnit.MILLISECONDS);
                }

                if (class69.task != null) {
                    if (class69.task.systems[int_0] != null) {
                        throw new IllegalArgumentException();
                    }

                    class69.task.systems[int_0] = abstractsoundsystem_0;
                }

                return abstractsoundsystem_0;
            } catch (final Throwable throwable_0) {
                return new AbstractSoundSystem();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    static void method1604() {
        final PacketNode packetnode_0 = class26.method433(ClientPacket.RESIZE_CLIENT_FRAME, Game.field626.field1218);
        final PacketBuffer packetbuffer_0 = packetnode_0.packetBuffer;
        final int int_0 = Game.isResized ? 2 : 1;
        packetbuffer_0.putByte(int_0);
        packetnode_0.packetBuffer.putShort(Varcs.canvasWidth);
        packetnode_0.packetBuffer.putShort(BuildType.canvasHeight);
        Game.field626.method1980(packetnode_0);
    }

}
