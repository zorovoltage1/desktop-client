import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GrandExchangeEvents {

    static int field15;
    public static Comparator field9;
    public static Comparator field13;
    public static Comparator field11;
    public static Comparator field16;
    static Fonts fonts;
    public final List events;

    static {
        field9 = new class7();
        new WorldComparator();
        field13 = new UnitPriceComparator();
        field11 = new class6();
        field16 = new TotalQuantityComparator();
    }

    public GrandExchangeEvents(final Buffer buffer_0, final boolean bool_0) {
        final int int_0 = buffer_0.readUnsignedShort();
        final boolean bool_1 = buffer_0.readUnsignedByte() == 1;
        byte byte_0;
        if (bool_1) {
            byte_0 = 1;
        } else {
            byte_0 = 0;
        }

        final int int_1 = buffer_0.readUnsignedShort();
        events = new ArrayList(int_1);

        for (int int_2 = 0; int_2 < int_1; int_2++) {
            events.add(new GrandExchangeEvent(buffer_0, byte_0, int_0));
        }

    }

    public void sort(final Comparator comparator_0, final boolean bool_0) {
        if (bool_0) {
            Collections.sort(events, comparator_0);
        } else {
            Collections.sort(events, Collections.reverseOrder(comparator_0));
        }

    }

    public static boolean method8() {
        synchronized (KeyFocusListener.keyboard) {
            if (KeyFocusListener.field352 == KeyFocusListener.field350) {
                return false;
            } else {
                GameSocket.currentPressedKey = KeyFocusListener.field348[KeyFocusListener.field350];
                KeyFocusListener.currentTypedKey = KeyFocusListener.field346[KeyFocusListener.field350];
                KeyFocusListener.field350 = (KeyFocusListener.field350 + 1) & 0x7F;
                return true;
            }
        }
    }

    public static Overlay getOverlayDefinition(final int int_0) {
        Overlay overlay_0 = (Overlay) Overlay.overlays.get(int_0);
        if (overlay_0 != null) {
            return overlay_0;
        } else {
            final byte[] bytes_0 = Overlay.overlay_ref.getConfigData(4, int_0);
            overlay_0 = new Overlay();
            if (bytes_0 != null) {
                overlay_0.decode(new Buffer(bytes_0), int_0);
            }

            overlay_0.post();
            Overlay.overlays.put(overlay_0, int_0);
            return overlay_0;
        }
    }

    static String method11(String string_0, final Widget widget_0) {
        if (string_0.indexOf("%") != -1) {
            for (int int_0 = 1; int_0 <= 5; int_0++) {
                while (true) {
                    final int int_1 = string_0.indexOf("%" + int_0);
                    if (int_1 == -1) {
                        break;
                    }

                    final String string_1 = string_0.substring(0, int_1);
                    final int int_2 = class137.method3119(widget_0, int_0 - 1);
                    String string_2;
                    if (int_2 < 999999999) {
                        string_2 = Integer.toString(int_2);
                    } else {
                        string_2 = "*";
                    }

                    string_0 = string_1 + string_2 + string_0.substring(int_1 + 2);
                }
            }
        }

        return string_0;
    }

    static void method13() {
        Game.field828 = Game.cycleCntr;
        class54.field489 = true;
    }

}
