public class WorldMapDecoration {

    static GrandExchangeEvents grandExchangeEvents;
    static int field152;
    static byte[][][] overlayRotations;
    final int objectDefinitionId;
    final int decoration;
    final int rotation;

    WorldMapDecoration(final int int_0, final int int_1, final int int_2) {
        objectDefinitionId = int_0;
        decoration = int_1;
        rotation = int_2;
    }

    static Frames getFrames(final int int_0) {
        final Frames frames_0 = (Frames) Sequence.skeletons.get(int_0);
        if (frames_0 != null) {
            return frames_0;
        } else {
            final IndexDataBase indexdatabase_0 = Sequence.skel_ref;
            final IndexDataBase indexdatabase_1 = Sequence.skin_ref;
            boolean bool_0 = true;
            final int[] ints_0 = indexdatabase_0.getChilds(int_0);

            for (int int_1 = 0; int_1 < ints_0.length; int_1++) {
                final byte[] bytes_0 = indexdatabase_0.getChild(int_0, ints_0[int_1]);
                if (bytes_0 == null) {
                    bool_0 = false;
                } else {
                    final int int_2 = ((bytes_0[0] & 0xFF) << 8) | (bytes_0[1] & 0xFF);
                    final byte[] bytes_1 = indexdatabase_1.getChild(int_2, 0);
                    if (bytes_1 == null) {
                        bool_0 = false;
                    }
                }
            }

            Frames frames_1;
            if (!bool_0) {
                frames_1 = null;
            } else {
                try {
                    frames_1 = new Frames(indexdatabase_0, indexdatabase_1, int_0, false);
                } catch (final Exception exception_0) {
                    frames_1 = null;
                }
            }

            if (frames_1 != null) {
                Sequence.skeletons.put(frames_1, int_0);
            }

            return frames_1;
        }
    }

    public static void method197(final int int_0, final int int_1, final int int_2, final boolean bool_0) {
        final PacketNode packetnode_0 = class26.method433(ClientPacket.WORLD_MAP_TELEPORT, Game.field626.field1218);
        packetnode_0.packetBuffer.addByteC(int_2);
        packetnode_0.packetBuffer.addInt2(bool_0 ? Game.field853 : 0);
        packetnode_0.packetBuffer.addShortA(int_1);
        packetnode_0.packetBuffer.addLEShortA(int_0);
        Game.field626.method1980(packetnode_0);
    }

}
