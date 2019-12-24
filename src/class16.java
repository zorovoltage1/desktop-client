import java.util.LinkedList;

public abstract class class16 {

    int field127;
    int field117;
    int field118;
    int field119;
    int field120;
    int field121;
    short[][][] field125;
    short[][][] field123;
    byte[][][] field124;
    byte[][][] field116;
    WorldMapDecoration[][][][] decorations;

    class16() {
        new LinkedList();
    }

    void method150(final int int_0, final int int_1, final Buffer buffer_0) {
        final int int_2 = buffer_0.readUnsignedByte();
        if (int_2 != 0) {
            if ((int_2 & 0x1) != 0) {
                method167(int_0, int_1, buffer_0, int_2);
            } else {
                method152(int_0, int_1, buffer_0, int_2);
            }

        }
    }

    void method167(final int int_0, final int int_1, final Buffer buffer_0, final int int_2) {
        final boolean bool_0 = (int_2 & 0x2) != 0;
        if (bool_0) {
            field123[0][int_0][int_1] = (short) buffer_0.readUnsignedByte();
        }

        field125[0][int_0][int_1] = (short) buffer_0.readUnsignedByte();
    }

    void method152(final int int_0, final int int_1, final Buffer buffer_0, final int int_2) {
        final int int_3 = ((int_2 & 0x18) >> 3) + 1;
        final boolean bool_0 = (int_2 & 0x2) != 0;
        final boolean bool_1 = (int_2 & 0x4) != 0;
        field125[0][int_0][int_1] = (short) buffer_0.readUnsignedByte();
        int int_4;
        int int_5;
        int int_7;
        if (bool_0) {
            int_4 = buffer_0.readUnsignedByte();

            for (int_5 = 0; int_5 < int_4; int_5++) {
                final int int_6 = buffer_0.readUnsignedByte();
                if (int_6 != 0) {
                    field123[int_5][int_0][int_1] = (short) int_6;
                    int_7 = buffer_0.readUnsignedByte();
                    field124[int_5][int_0][int_1] = (byte) (int_7 >> 2);
                    field116[int_5][int_0][int_1] = (byte) (int_7 & 0x3);
                }
            }
        }

        if (bool_1) {
            for (int_4 = 0; int_4 < int_3; int_4++) {
                int_5 = buffer_0.readUnsignedByte();
                if (int_5 != 0) {
                    final WorldMapDecoration[] worldmapdecorations_0 = decorations[int_4][int_0][int_1] = new WorldMapDecoration[int_5];

                    for (int_7 = 0; int_7 < int_5; int_7++) {
                        final int int_8 = buffer_0.method3546();
                        final int int_9 = buffer_0.readUnsignedByte();
                        worldmapdecorations_0[int_7] = new WorldMapDecoration(int_8, int_9 >> 2, int_9 & 0x3);
                    }
                }
            }
        }

    }

    int method153(final int int_0, final int int_1) {
        return (int_0 >= 0) && (int_1 >= 0) ? ((int_0 < 64) && (int_1 < 64) ? field125[0][int_0][int_1] - 1 : -1) : -1;
    }

    int method149() {
        return field118;
    }

    int method168() {
        return field119;
    }

    static void method158(final int int_0, final int int_1, final int int_2, final int int_3) {
        if (Game.field621) {
            if (Game.cursorState == 1) {
                class161.crossSprites[Game.field803 / 100].drawAt(Game.lastLeftClickX - 8,
                        Game.lastLeftClickY - 8);
            }

            if (Game.cursorState == 2) {
                class161.crossSprites[(Game.field803 / 100) + 4].drawAt(Game.lastLeftClickX - 8,
                        Game.lastLeftClickY - 8);
            }
        }

        Game.myPlayerIndex = 0;
        final int int_4 = (class138.localPlayer.x >> 7) + PendingSpawn.baseX;
        final int int_5 = (class138.localPlayer.y >> 7) + Game.baseY;
        if ((int_4 >= 3053) && (int_4 <= 3156) && (int_5 >= 3056) && (int_5 <= 3136)) {
            Game.myPlayerIndex = 1;
        }

        if ((int_4 >= 3072) && (int_4 <= 3118) && (int_5 >= 9492) && (int_5 <= 9535)) {
            Game.myPlayerIndex = 1;
        }

        if ((Game.myPlayerIndex == 1) && (int_4 >= 3139) && (int_4 <= 3199) && (int_5 >= 3008) && (int_5 <= 3062)) {
            Game.myPlayerIndex = 0;
        }

    }

}
