import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class Preferences {

    static int field964;
    static int field966;
    boolean hideRoofs;
    boolean muted;
    int screenType;
    String rememberedUsername;
    boolean hideUsername;
    LinkedHashMap preferences;

    static {
        field964 = 6;
    }

    Preferences() {
        screenType = 1;
        rememberedUsername = null;
        hideUsername = false;
        preferences = new LinkedHashMap();
        method1613(true);
    }

    Preferences(final Buffer buffer_0) {
        screenType = 1;
        rememberedUsername = null;
        hideUsername = false;
        preferences = new LinkedHashMap();
        if ((buffer_0 != null) && (buffer_0.payload != null)) {
            final int int_0 = buffer_0.readUnsignedByte();
            if ((int_0 >= 0) && (int_0 <= field964)) {
                if (buffer_0.readUnsignedByte() == 1) {
                    hideRoofs = true;
                }

                if (int_0 > 1) {
                    muted = buffer_0.readUnsignedByte() == 1;
                }

                if (int_0 > 3) {
                    screenType = buffer_0.readUnsignedByte();
                }

                if (int_0 > 2) {
                    final int int_1 = buffer_0.readUnsignedByte();

                    for (int int_2 = 0; int_2 < int_1; int_2++) {
                        final int int_3 = buffer_0.readInt();
                        final int int_4 = buffer_0.readInt();
                        preferences.put(Integer.valueOf(int_3), Integer.valueOf(int_4));
                    }
                }

                if (int_0 > 4) {
                    rememberedUsername = buffer_0.getNullString();
                }

                if (int_0 > 5) {
                    hideUsername = buffer_0.method3555();
                }
            } else {
                method1613(true);
            }
        } else {
            method1613(true);
        }

    }

    void method1613(final boolean bool_0) {
    }

    Buffer serialize() {
        final Buffer buffer_0 = new Buffer(100);
        buffer_0.putByte(field964);
        buffer_0.putByte(hideRoofs ? 1 : 0);
        buffer_0.putByte(muted ? 1 : 0);
        buffer_0.putByte(screenType);
        buffer_0.putByte(preferences.size());
        final Iterator iterator_0 = preferences.entrySet().iterator();

        while (iterator_0.hasNext()) {
            final Entry map$entry_0 = (Entry) iterator_0.next();
            buffer_0.putInt(((Integer) map$entry_0.getKey()).intValue());
            buffer_0.putInt(((Integer) map$entry_0.getValue()).intValue());
        }

        buffer_0.putString(rememberedUsername != null ? rememberedUsername : "");
        buffer_0.writeBooleanAsByte(hideUsername);
        return buffer_0;
    }

    public static void method1622(final int int_0) {
        if (int_0 != -1) {
            if (GZipDecompressor.validInterfaces[int_0]) {
                Widget.widgetIndex.method4639(int_0);
                if (GameCanvas.widgets[int_0] != null) {
                    boolean bool_0 = true;

                    for (int int_1 = 0; int_1 < GameCanvas.widgets[int_0].length; int_1++) {
                        if (GameCanvas.widgets[int_0][int_1] != null) {
                            if (GameCanvas.widgets[int_0][int_1].type != 2) {
                                GameCanvas.widgets[int_0][int_1] = null;
                            } else {
                                bool_0 = false;
                            }
                        }
                    }

                    if (bool_0) {
                        GameCanvas.widgets[int_0] = null;
                    }

                    GZipDecompressor.validInterfaces[int_0] = false;
                }
            }
        }
    }

    static int method1621(final int int_0) {
        final MessageNode messagenode_0 = (MessageNode) class83.messages.get(int_0);
        return messagenode_0 == null ? -1
                : (messagenode_0.previous == class83.field1184.sentinel ? -1
                : ((MessageNode) messagenode_0.previous).id);
    }

}
