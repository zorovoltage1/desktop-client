public class WorldMapType2 implements WorldMapSectionBase {

    static MachineInfo platformInfo;
    static short[] field231;
    static int field230;
    static int field224;
    int field226;
    int field225;
    int field234;
    int field227;
    int field233;
    int field229;

    @Override
    public void vmethod635(final WorldMapData worldmapdata_0) {
        if (worldmapdata_0.minX > field233) {
            worldmapdata_0.minX = field233;
        }

        if (worldmapdata_0.field167 < field233) {
            worldmapdata_0.field167 = field233;
        }

        if (worldmapdata_0.minY > field229) {
            worldmapdata_0.minY = field229;
        }

        if (worldmapdata_0.field162 < field229) {
            worldmapdata_0.field162 = field229;
        }

    }

    @Override
    public boolean containsCoord(final int int_0, final int int_1, final int int_2) {
        return ((int_0 >= field226) && (int_0 < (field226 + field225))) && (((int_1 >> 6) == field234) && ((int_2 >> 6) == field227));
    }

    @Override
    public boolean vmethod637(final int int_0, final int int_1) {
        return ((int_0 >> 6) == field233) && ((int_1 >> 6) == field229);
    }

    @Override
    public int[] vmethod638(final int int_0, final int int_1, final int int_2) {
        if (!containsCoord(int_0, int_1, int_2)) {
            return null;
        } else {
            final int[] ints_0 = new int[]{((field233 * 64) - (field234 * 64)) + int_1,
                    int_2 + ((field229 * 64) - (field227 * 64))};
            return ints_0;
        }
    }

    @Override
    public Coordinates vmethod659(final int int_0, final int int_1) {
        if (!vmethod637(int_0, int_1)) {
            return null;
        } else {
            final int int_2 = ((field234 * 64) - (field233 * 64)) + int_0;
            final int int_3 = ((field227 * 64) - (field229 * 64)) + int_1;
            return new Coordinates(field226, int_2, int_3);
        }
    }

    @Override
    public void vmethod639(final Buffer buffer_0) {
        field226 = buffer_0.readUnsignedByte();
        field225 = buffer_0.readUnsignedByte();
        field234 = buffer_0.readUnsignedShort();
        field227 = buffer_0.readUnsignedShort();
        field233 = buffer_0.readUnsignedShort();
        field229 = buffer_0.readUnsignedShort();
        method442();
    }

    void method442() {
    }

    public static int method435(final int int_0) {
        return CacheFile.method2484(class120.field1647[int_0]);
    }

    static int getTileHeight(final int int_0, final int int_1, final int int_2) {
        final int int_3 = int_0 >> 7;
        final int int_4 = int_1 >> 7;
        if ((int_3 >= 0) && (int_4 >= 0) && (int_3 <= 103) && (int_4 <= 103)) {
            int int_5 = int_2;
            if ((int_2 < 3) && ((class50.tileSettings[1][int_3][int_4] & 0x2) == 2)) {
                int_5 = int_2 + 1;
            }

            final int int_6 = int_0 & 0x7F;
            final int int_7 = int_1 & 0x7F;
            final int int_8 = (((128 - int_6) * class50.tileHeights[int_5][int_3][int_4])
                    + (int_6 * class50.tileHeights[int_5][int_3 + 1][int_4])) >> 7;
            final int int_9 = ((int_6 * class50.tileHeights[int_5][int_3 + 1][int_4 + 1])
                    + (class50.tileHeights[int_5][int_3][int_4 + 1] * (128 - int_6))) >> 7;
            return ((int_9 * int_7) + (int_8 * (128 - int_7))) >> 7;
        } else {
            return 0;
        }
    }

}
