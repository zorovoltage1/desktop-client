import java.util.zip.Inflater;

public class GZipDecompressor {

    static boolean[] validInterfaces;
    static IndexData indexSprites;
    Inflater inflator;

    GZipDecompressor(final int int_0, final int int_1, final int int_2) {
    }

    public GZipDecompressor() {
        this(-1, 1000000, 1000000);
    }

    public void decompress(final Buffer buffer_0, final byte[] bytes_0) {
        if ((buffer_0.payload[buffer_0.offset] == 31) && (buffer_0.payload[buffer_0.offset + 1] == -117)) {
            if (inflator == null) {
                inflator = new Inflater(true);
            }

            try {
                inflator.setInput(buffer_0.payload, buffer_0.offset + 10,
                        buffer_0.payload.length - (buffer_0.offset + 8 + 10));
                inflator.inflate(bytes_0);
            } catch (final Exception exception_0) {
                inflator.reset();
                throw new RuntimeException("");
            }

            inflator.reset();
        } else {
            throw new RuntimeException("");
        }
    }

    public static VarCString method3485(final int int_0) {
        VarCString varcstring_0 = (VarCString) VarCString.field3260.get(int_0);
        if (varcstring_0 != null) {
            return varcstring_0;
        } else {
            final byte[] bytes_0 = VarCString.field3264.getConfigData(15, int_0);
            varcstring_0 = new VarCString();
            if (bytes_0 != null) {
                varcstring_0.method4852(new Buffer(bytes_0));
            }

            VarCString.field3260.put(varcstring_0, int_0);
            return varcstring_0;
        }
    }

    static void method3487(final Buffer buffer_0, final int int_0) {
        final byte[] bytes_0 = buffer_0.payload;
        if (Game.field620 == null) {
            Game.field620 = new byte[24];
        }

        class193.method3873(bytes_0, int_0, Game.field620, 0, 24);
        class146.method3190(buffer_0, int_0);
    }

}
