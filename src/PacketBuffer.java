public final class PacketBuffer extends Buffer {

    static final int[] field2374;
    ISAACCipher cipher;
    int bitPosition;

    static {
        field2374 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535,
                131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727,
                268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
    }

    public PacketBuffer(final int int_0) {
        super(int_0);
    }

    public void seed(final int[] ints_0) {
        cipher = new ISAACCipher(ints_0);
    }

    public void setIsaacCipher(final ISAACCipher isaaccipher_0) {
        cipher = isaaccipher_0;
    }

    public void putOpcode(final int int_0) {
        super.payload[super.offset++] = (byte) (int_0 + cipher.nextInt());
    }

    public int readOpcode() {
        return (super.payload[super.offset++] - cipher.nextInt()) & 0xFF;
    }

    public boolean method3821() {
        final int int_0 = (super.payload[super.offset] - cipher.method3853()) & 0xFF;
        return int_0 >= 128;
    }

    public int method3841() {
        final int int_0 = (super.payload[super.offset++] - cipher.nextInt()) & 0xFF;
        return int_0 < 128 ? int_0 : ((int_0 - 128) << 8) + ((super.payload[super.offset++] - cipher.nextInt()) & 0xFF);
    }

    public void bitAccess() {
        bitPosition = super.offset * 8;
    }

    public int getBits(int int_0) {
        int int_1 = bitPosition >> 3;
        int int_2 = 8 - (bitPosition & 0x7);
        int int_3 = 0;

        for (bitPosition += int_0; int_0 > int_2; int_2 = 8) {
            int_3 += (super.payload[int_1++] & field2374[int_2]) << (int_0 - int_2);
            int_0 -= int_2;
        }

        if (int_2 == int_0) {
            int_3 += super.payload[int_1] & field2374[int_2];
        } else {
            int_3 += (super.payload[int_1] >> (int_2 - int_0)) & field2374[int_0];
        }

        return int_3;
    }

    public void byteAccess() {
        super.offset = (bitPosition + 7) / 8;
    }

    public int bitsAvail(final int int_0) {
        return (int_0 * 8) - bitPosition;
    }

    public static class307 method3847(final int int_0) {
        final class307[] class307s_0 = new class307[]{class307.field3733, class307.field3732, class307.field3734};
        final class307[] class307s_1 = class307s_0;

        for (int int_1 = 0; int_1 < class307s_1.length; int_1++) {
            final class307 class307_0 = class307s_1[int_1];
            if (int_0 == class307_0.field3735) {
                return class307_0;
            }
        }

        return null;
    }

    static void method3848() {
        synchronized (IndexStoreActionHandler.IndexStoreActionHandler_lock) {
            if (IndexStoreActionHandler.field3179 == 0) {
                IndexStoreActionHandler.IndexStoreActionHandler_thread = new Thread(new IndexStoreActionHandler());
                IndexStoreActionHandler.IndexStoreActionHandler_thread.setDaemon(true);
                IndexStoreActionHandler.IndexStoreActionHandler_thread.start();
                IndexStoreActionHandler.IndexStoreActionHandler_thread.setPriority(5);
            }

            IndexStoreActionHandler.field3179 = 600;
        }
    }

    public static int method3840(final Buffer buffer_0, final String string_0) {
        final int int_0 = buffer_0.offset;
        final byte[] bytes_0 = JagexGame.method4618(string_0);
        buffer_0.putShortSmart(bytes_0.length);
        buffer_0.offset += class300.huffman.compress(bytes_0, 0, bytes_0.length, buffer_0.payload, buffer_0.offset);
        return buffer_0.offset - int_0;
    }

}
