import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Iterator;

public class class37 implements WorldMapSectionBase {

    static int[][][] field325;
    static IndexData indexSoundEffects;
    int field318;
    int field324;
    int field319;
    int field317;
    int field315;
    int field320;
    int field321;
    int field322;
    int field316;
    int field323;

    @Override
    public void vmethod635(final WorldMapData worldmapdata_0) {
        if (worldmapdata_0.minX > field315) {
            worldmapdata_0.minX = field315;
        }

        if (worldmapdata_0.field167 < field315) {
            worldmapdata_0.field167 = field315;
        }

        if (worldmapdata_0.minY > field320) {
            worldmapdata_0.minY = field320;
        }

        if (worldmapdata_0.field162 < field320) {
            worldmapdata_0.field162 = field320;
        }

    }

    @Override
    public boolean containsCoord(final int int_0, final int int_1, final int int_2) {
        return ((int_0 >= field318) && (int_0 < (field318 + field324))) && ((int_1 >= ((field319 << 6) + (field321 << 3)))
                && (int_1 <= ((field319 << 6) + (field321 << 3) + 7)) && (int_2 >= ((field317 << 6) + (field322 << 3)))
                && (int_2 <= ((field317 << 6) + (field322 << 3) + 7)));
    }

    @Override
    public boolean vmethod637(final int int_0, final int int_1) {
        return (int_0 >= ((field315 << 6) + (field316 << 3))) && (int_0 <= ((field315 << 6) + (field316 << 3) + 7))
                && (int_1 >= ((field320 << 6) + (field323 << 3))) && (int_1 <= ((field320 << 6) + (field323 << 3) + 7));
    }

    @Override
    public int[] vmethod638(final int int_0, final int int_1, final int int_2) {
        if (!containsCoord(int_0, int_1, int_2)) {
            return null;
        } else {
            final int[] ints_0 = new int[]{
                    ((field315 * 64) - (field319 * 64)) + int_1 + ((field316 * 8) - (field321 * 8)),
                    int_2 + ((field320 * 64) - (field317 * 64)) + ((field323 * 8) - (field322 * 8))};
            return ints_0;
        }
    }

    @Override
    public Coordinates vmethod659(final int int_0, final int int_1) {
        if (!vmethod637(int_0, int_1)) {
            return null;
        } else {
            final int int_2 = ((field319 * 64) - (field315 * 64)) + ((field321 * 8) - (field316 * 8)) + int_0;
            final int int_3 = ((field317 * 64) - (field320 * 64)) + int_1 + ((field322 * 8) - (field323 * 8));
            return new Coordinates(field318, int_2, int_3);
        }
    }

    @Override
    public void vmethod639(final Buffer buffer_0) {
        field318 = buffer_0.readUnsignedByte();
        field324 = buffer_0.readUnsignedByte();
        field319 = buffer_0.readUnsignedShort();
        field321 = buffer_0.readUnsignedByte();
        field317 = buffer_0.readUnsignedShort();
        field322 = buffer_0.readUnsignedByte();
        field315 = buffer_0.readUnsignedShort();
        field316 = buffer_0.readUnsignedByte();
        field320 = buffer_0.readUnsignedShort();
        field323 = buffer_0.readUnsignedByte();
        method641();
    }

    void method641() {
    }

    static void initializeGPI(final PacketBuffer packetbuffer_0) {
        packetbuffer_0.bitAccess();
        final int int_0 = Game.localInteractingIndex;
        final Player player_0 = class138.localPlayer = Game.cachedPlayers[int_0] = new Player();
        player_0.playerId = int_0;
        final int int_1 = packetbuffer_0.getBits(30);
        final byte byte_0 = (byte) (int_1 >> 28);
        final int int_2 = (int_1 >> 14) & 0x3FFF;
        final int int_3 = int_1 & 0x3FFF;
        player_0.pathX[0] = int_2 - PendingSpawn.baseX;
        player_0.x = (player_0.pathX[0] << 7) + (player_0.getSize() << 6);
        player_0.pathY[0] = int_3 - Game.baseY;
        player_0.y = (player_0.pathY[0] << 7) + (player_0.getSize() << 6);
        class13.plane = player_0.field567 = byte_0;
        if (class81.field1157[int_0] != null) {
            player_0.decodeApperance(class81.field1157[int_0]);
        }

        class81.playerIndexesCount = 0;
        class81.playerIndices[++class81.playerIndexesCount - 1] = int_0;
        class81.field1156[int_0] = 0;
        class81.field1160 = 0;

        for (int int_4 = 1; int_4 < 2048; int_4++) {
            if (int_4 != int_0) {
                final int int_5 = packetbuffer_0.getBits(18);
                final int int_6 = int_5 >> 16;
                final int int_7 = (int_5 >> 8) & 0x255;
                final int int_8 = int_5 & 0x255;
                class81.Players_regions[int_4] = (int_7 << 14) + int_8 + (int_6 << 28);
                class81.Players_orientations[int_4] = 0;
                class81.Players_targetIndices[int_4] = -1;
                class81.field1161[++class81.field1160 - 1] = int_4;
                class81.field1156[int_4] = 0;
            }
        }

        packetbuffer_0.byteAccess();
    }

    public static int method652() {
        return ++MouseInput.mouseIdleTicks - 1;
    }

    public static int method662(final long long_0) {
        return (int) ((long_0 >>> 0) & 0x7FL);
    }

    static void method640() {
        final Iterator iterator_0 = class83.messages.iterator();

        while (iterator_0.hasNext()) {
            final MessageNode messagenode_0 = (MessageNode) iterator_0.next();
            messagenode_0.method1048();
        }

    }

    protected static int method661() {
        int int_0 = 0;
        if ((VertexNormal.field1660 == null) || !VertexNormal.field1660.isValid()) {
            try {
                final Iterator iterator_0 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                while (iterator_0.hasNext()) {
                    final GarbageCollectorMXBean garbagecollectormxbean_0 = (GarbageCollectorMXBean) iterator_0.next();
                    if (garbagecollectormxbean_0.isValid()) {
                        VertexNormal.field1660 = garbagecollectormxbean_0;
                        GameEngine.garbageCollectorLastCheckTimeMs = -1L;
                        GameEngine.garbageCollectorLastCollectionTime = -1L;
                    }
                }
            } catch (final Throwable throwable_0) {
            }
        }

        if (VertexNormal.field1660 != null) {
            final long long_0 = Buffer.safeCurrentTimeMillis();
            final long long_1 = VertexNormal.field1660.getCollectionTime();
            if (GameEngine.garbageCollectorLastCollectionTime != -1L) {
                final long long_2 = long_1 - GameEngine.garbageCollectorLastCollectionTime;
                final long long_3 = long_0 - GameEngine.garbageCollectorLastCheckTimeMs;
                if (long_3 != 0L) {
                    int_0 = (int) ((100L * long_2) / long_3);
                }
            }

            GameEngine.garbageCollectorLastCollectionTime = long_1;
            GameEngine.garbageCollectorLastCheckTimeMs = long_0;
        }

        return int_0;
    }

}
