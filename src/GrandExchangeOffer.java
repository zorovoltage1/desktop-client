import java.net.URL;

public class GrandExchangeOffer {

    byte state;
    public int itemId;
    public int price;
    public int totalQuantity;
    public int quantitySold;
    public int spent;

    public GrandExchangeOffer() {
    }

    public GrandExchangeOffer(final Buffer buffer_0, final boolean bool_0) {
        state = buffer_0.readByte();
        itemId = buffer_0.readUnsignedShort();
        price = buffer_0.readInt();
        totalQuantity = buffer_0.readInt();
        quantitySold = buffer_0.readInt();
        spent = buffer_0.readInt();
    }

    public int status() {
        return state & 0x7;
    }

    public int type() {
        return (state & 0x8) == 8 ? 1 : 0;
    }

    void method44(final int int_0) {
        state &= 0xFFFFFFF8;
        state = (byte) (state | (int_0 & 0x7));
    }

    void method40(final int int_0) {
        state &= 0xFFFFFFF7;
        if (int_0 == 1) {
            state = (byte) (state | 0x8);
        }

    }

    static boolean loadWorlds() {
        try {
            if (class49.listFetcher == null) {
                class49.listFetcher = MapIcon.urlRequester.request(new URL(class26.field219));
            } else if (class49.listFetcher.isDone()) {
                final byte[] bytes_0 = class49.listFetcher.getResponse();
                final Buffer buffer_0 = new Buffer(bytes_0);
                buffer_0.readInt();
                World.worldCount = buffer_0.readUnsignedShort();
                World.worldList = new World[World.worldCount];

                World world_0;
                for (int int_0 = 0; int_0 < World.worldCount; world_0.index = int_0++) {
                    world_0 = World.worldList[int_0] = new World();
                    world_0.id = buffer_0.readUnsignedShort();
                    world_0.mask = buffer_0.readInt();
                    world_0.address = buffer_0.readString();
                    world_0.activity = buffer_0.readString();
                    world_0.location = buffer_0.readUnsignedByte();
                    world_0.playerCount = buffer_0.readShort();
                }

                MapLabel.method282(World.worldList, 0, World.worldList.length - 1, World.field946, World.field939);
                class49.listFetcher = null;
                return true;
            }
        } catch (final Exception exception_0) {
            exception_0.printStackTrace();
            class49.listFetcher = null;
        }

        return false;
    }

    static void method56() {
        if (!class120.Viewport_false0) {
            final int int_0 = Region.pitchSin;
            final int int_1 = Region.pitchCos;
            final int int_2 = Region.yawSin;
            final int int_3 = Region.yawCos;
            final byte byte_0 = 50;
            final short short_0 = 3500;
            int int_4 = ((class120.Viewport_mouseX - Graphics3D.centerX) * byte_0) / Graphics3D.Rasterizer3D_zoom;
            int int_5 = ((class120.Viewport_mouseY - Graphics3D.centerY) * byte_0) / Graphics3D.Rasterizer3D_zoom;
            final int int_6 = ((class120.Viewport_mouseX - Graphics3D.centerX) * short_0)
                    / Graphics3D.Rasterizer3D_zoom;
            int int_7 = ((class120.Viewport_mouseY - Graphics3D.centerY) * short_0) / Graphics3D.Rasterizer3D_zoom;
            int int_8 = Graphics3D.method2807(int_5, byte_0, int_1, int_0);
            int int_9 = Graphics3D.method2790(int_5, byte_0, int_1, int_0);
            int_5 = int_8;
            int_8 = Graphics3D.method2807(int_7, short_0, int_1, int_0);
            int int_10 = Graphics3D.method2790(int_7, short_0, int_1, int_0);
            int_7 = int_8;
            int_8 = Graphics3D.method2805(int_4, int_9, int_3, int_2);
            int_9 = Graphics3D.method2806(int_4, int_9, int_3, int_2);
            int_4 = int_8;
            int_8 = Graphics3D.method2805(int_6, int_10, int_3, int_2);
            int_10 = Graphics3D.method2806(int_6, int_10, int_3, int_2);
            class120.field1657 = (int_8 + int_4) / 2;
            class120.field1659 = (int_7 + int_5) / 2;
            class177.field2283 = (int_10 + int_9) / 2;
            class303.field3721 = (int_8 - int_4) / 2;
            class120.field1651 = (int_7 - int_5) / 2;
            class120.field1654 = (int_10 - int_9) / 2;
            class98.field1335 = Math.abs(class303.field3721);
            class120.field1655 = Math.abs(class120.field1651);
            ClassInfo.field3757 = Math.abs(class120.field1654);
        }
    }

}
