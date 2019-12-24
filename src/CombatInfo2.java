public class CombatInfo2 extends CacheableNode {

    public static IndexDataBase field3304;
    static IndexDataBase field3314;
    public static NodeCache field3305;
    public static NodeCache field3306;
    public int field3317;
    public int field3310;
    public int field3307;
    public int field3312;
    public int field3308;
    public int field3313;
    int field3315;
    int field3316;
    public int healthScale;
    public int field3318;

    static {
        field3305 = new NodeCache(64);
        field3306 = new NodeCache(64);
    }

    public CombatInfo2() {
        field3310 = 255;
        field3307 = 255;
        field3312 = -1;
        field3308 = 1;
        field3313 = 70;
        field3315 = -1;
        field3316 = -1;
        healthScale = 30;
        field3318 = 0;
    }

    public void read(final Buffer buffer_0) {
        while (true) {
            final int int_0 = buffer_0.readUnsignedByte();
            if (int_0 == 0) {
                return;
            }

            readNext(buffer_0, int_0);
        }
    }

    void readNext(final Buffer buffer_0, final int int_0) {
        if (int_0 == 1) {
            buffer_0.readUnsignedShort();
        } else if (int_0 == 2) {
            field3310 = buffer_0.readUnsignedByte();
        } else if (int_0 == 3) {
            field3307 = buffer_0.readUnsignedByte();
        } else if (int_0 == 4) {
            field3312 = 0;
        } else if (int_0 == 5) {
            field3313 = buffer_0.readUnsignedShort();
        } else if (int_0 == 6) {
            buffer_0.readUnsignedByte();
        } else if (int_0 == 7) {
            field3315 = buffer_0.method3546();
        } else if (int_0 == 8) {
            field3316 = buffer_0.method3546();
        } else if (int_0 == 11) {
            field3312 = buffer_0.readUnsignedShort();
        } else if (int_0 == 14) {
            healthScale = buffer_0.readUnsignedByte();
        } else if (int_0 == 15) {
            field3318 = buffer_0.readUnsignedByte();
        }

    }

    public SpritePixels method4917() {
        if (field3315 < 0) {
            return null;
        } else {
            SpritePixels spritepixels_0 = (SpritePixels) field3306.get(field3315);
            if (spritepixels_0 != null) {
                return spritepixels_0;
            } else {
                spritepixels_0 = class229.method4499(field3314, field3315, 0);
                if (spritepixels_0 != null) {
                    field3306.put(spritepixels_0, field3315);
                }

                return spritepixels_0;
            }
        }
    }

    public SpritePixels method4918() {
        if (field3316 < 0) {
            return null;
        } else {
            SpritePixels spritepixels_0 = (SpritePixels) field3306.get(field3316);
            if (spritepixels_0 != null) {
                return spritepixels_0;
            } else {
                spritepixels_0 = class229.method4499(field3314, field3316, 0);
                if (spritepixels_0 != null) {
                    field3306.put(spritepixels_0, field3316);
                }

                return spritepixels_0;
            }
        }
    }

    public static boolean loadWidget(final int int_0) {
        if (GZipDecompressor.validInterfaces[int_0]) {
            return true;
        } else if (!Widget.widgetIndex.containsFile(int_0)) {
            return false;
        } else {
            final int int_1 = Widget.widgetIndex.fileCount(int_0);
            if (int_1 == 0) {
                GZipDecompressor.validInterfaces[int_0] = true;
                return true;
            } else {
                if (GameCanvas.widgets[int_0] == null) {
                    GameCanvas.widgets[int_0] = new Widget[int_1];
                }

                for (int int_2 = 0; int_2 < int_1; int_2++) {
                    if (GameCanvas.widgets[int_0][int_2] == null) {
                        final byte[] bytes_0 = Widget.widgetIndex.getConfigData(int_0, int_2);
                        if (bytes_0 != null) {
                            GameCanvas.widgets[int_0][int_2] = new Widget();
                            GameCanvas.widgets[int_0][int_2].interfaceHash = int_2 + (int_0 << 16);
                            if (bytes_0[0] == -1) {
                                GameCanvas.widgets[int_0][int_2].decodeActive(new Buffer(bytes_0));
                            } else {
                                GameCanvas.widgets[int_0][int_2].decode(new Buffer(bytes_0));
                            }
                            InterfaceEdits.childLoaded(GameCanvas.widgets[int_0][int_2]);
                        }
                    }
                }

                //InterfaceEdits.parentLoaded(parentId);
                GZipDecompressor.validInterfaces[int_0] = true;
                return true;
            }
        }
    }

}
