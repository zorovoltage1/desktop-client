import java.util.HashMap;
import java.util.Map;

public class class83 {

    static final Map chatLineMap;
    static final IterableHashTable messages;
    static final IterableDualNodeQueue field1184;
    static int field1186;

    static {
        chatLineMap = new HashMap();
        messages = new IterableHashTable(1024);
        field1184 = new IterableDualNodeQueue();
        field1186 = 0;
    }

    static void method1933(final String string_0, final boolean bool_0) {
        if (Game.field677) {
            final byte byte_0 = 4;
            final int int_0 = byte_0 + 6;
            final int int_1 = byte_0 + 6;
            final int int_2 = Actor.font_p12full.method5519(string_0, 250);
            final int int_3 = Actor.font_p12full.method5520(string_0, 250) * 13;
            Rasterizer2D.Rasterizer2D_fillRectangle(int_0 - byte_0, int_1 - byte_0, byte_0 + int_2 + byte_0,
                    byte_0 + byte_0 + int_3, 0);
            Rasterizer2D.drawRectangle(int_0 - byte_0, int_1 - byte_0, byte_0 + int_2 + byte_0, int_3 + byte_0 + byte_0,
                    16777215);
            Actor.font_p12full.method5526(string_0, int_0, int_1, int_2, int_3, 16777215, -1, 1, 1, 0);
            MouseInput.method948(int_0 - byte_0, int_1 - byte_0, byte_0 + int_2 + byte_0, byte_0 + byte_0 + int_3);
            if (bool_0) {
                GameSocket.rasterProvider.drawFull(0, 0);
            } else {
                final int int_4 = int_0;
                final int int_5 = int_1;
                final int int_6 = int_2;
                final int int_7 = int_3;

                for (int int_8 = 0; int_8 < Game.widgetCount; int_8++) {
                    if (((Game.widgetBoundsWidth[int_8] + Game.widgetPositionX[int_8]) > int_4)
                            && (Game.widgetPositionX[int_8] < (int_4 + int_6))
                            && ((Game.widgetBoundsHeight[int_8] + Game.widgetPositionY[int_8]) > int_5)
                            && (Game.widgetPositionY[int_8] < (int_7 + int_5))) {
                        Game.field788[int_8] = true;
                    }
                }
            }

        }
    }

    static void method1940() {
        final int int_0 = MouseInput.menuX;
        final int int_1 = WorldComparator.menuY;
        final int int_2 = UrlRequester.field1856;
        final int int_3 = class151.field1933;
        final int int_4 = 6116423;
        Rasterizer2D.Rasterizer2D_fillRectangle(int_0, int_1, int_2, int_3, int_4);
        Rasterizer2D.Rasterizer2D_fillRectangle(int_0 + 1, int_1 + 1, int_2 - 2, 16, 0);
        Rasterizer2D.drawRectangle(int_0 + 1, int_1 + 18, int_2 - 2, int_3 - 19, 0);
        ClanMemberManager.fontBold12.method5522("Choose Option", int_0 + 3, int_1 + 14, int_4, -1);
        final int int_5 = MouseInput.mouseLastX;
        final int int_6 = MouseInput.mouseLastY * 673804999;

        int int_7;
        int int_8;
        int int_9;
        for (int_7 = 0; int_7 < Game.menuOptionCount; int_7++) {
            int_8 = int_1 + ((Game.menuOptionCount - 1 - int_7) * 15) + 31;
            int_9 = 16777215;
            if ((int_5 > int_0) && (int_5 < (int_2 + int_0)) && (int_6 > (int_8 - 13)) && (int_6 < (int_8 + 3))) {
                int_9 = 16776960;
            }

            ClanMemberManager.fontBold12.method5522(WorldMapType1.method176(int_7), int_0 + 3, int_8, int_9, 0);
        }

        int_7 = MouseInput.menuX;
        int_8 = WorldComparator.menuY;
        int_9 = UrlRequester.field1856;
        final int int_10 = class151.field1933;

        for (int int_11 = 0; int_11 < Game.widgetCount; int_11++) {
            if (((Game.widgetBoundsWidth[int_11] + Game.widgetPositionX[int_11]) > int_7)
                    && (Game.widgetPositionX[int_11] < (int_7 + int_9))
                    && ((Game.widgetBoundsHeight[int_11] + Game.widgetPositionY[int_11]) > int_8)
                    && (Game.widgetPositionY[int_11] < (int_8 + int_10))) {
                Game.field788[int_11] = true;
            }
        }

    }

    static void method1923(final Widget[] widgets_0, final int int_0) {
        for (int int_1 = 0; int_1 < widgets_0.length; int_1++) {
            final Widget widget_0 = widgets_0[int_1];
            if (widget_0 != null) {
                if (widget_0.type == 0) {
                    if (widget_0.children != null) {
                        method1923(widget_0.children, int_0);
                    }

                    final WidgetNode widgetnode_0 = (WidgetNode) Game.componentTable.get(widget_0.interfaceHash);
                    if (widgetnode_0 != null) {
                        final int int_2 = widgetnode_0.id;
                        if (CombatInfo2.loadWidget(int_2)) {
                            method1923(GameCanvas.widgets[int_2], int_0);
                        }
                    }
                }

                ScriptEvent scriptevent_0;
                if ((int_0 == 0) && (widget_0.onDialogAbortListener != null)) {
                    scriptevent_0 = new ScriptEvent();
                    scriptevent_0.widget = widget_0;
                    scriptevent_0.objs = widget_0.onDialogAbortListener;
                    class68.method1696(scriptevent_0);
                }

                if ((int_0 == 1) && (widget_0.onSubChangeListener != null)) {
                    if (widget_0.index >= 0) {
                        final Widget widget_1 = Widget.getWidget(widget_0.interfaceHash);
                        if ((widget_1 == null) || (widget_1.children == null)
                                || (widget_0.index >= widget_1.children.length)
                                || (widget_0 != widget_1.children[widget_0.index])) {
                            continue;
                        }
                    }

                    scriptevent_0 = new ScriptEvent();
                    scriptevent_0.widget = widget_0;
                    scriptevent_0.objs = widget_0.onSubChangeListener;
                    class68.method1696(scriptevent_0);
                }
            }
        }

    }

}
