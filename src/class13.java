import java.net.URL;

public class class13 {

    static IndexedSprite[] slFlagSprites;
    static int plane;
    static int selectedItemIndex;
    int field83;
    Coordinates field88;

    class13(final int int_0, final Coordinates coordinates_0) {
        field83 = int_0;
        field88 = coordinates_0;
    }

    public static IndexedSprite[] getIndexedSprites(final IndexDataBase indexdatabase_0, final String string_0,
                                                    final String string_1) {
        final int int_0 = indexdatabase_0.getFile(string_0);
        final int int_1 = indexdatabase_0.getChild(int_0, string_1);
        return class21.method278(indexdatabase_0, int_0, int_1);
    }

    static boolean method112(final String string_0, final int int_0, final String string_1) {
        if (int_0 == 0) {
            try {
                if (!class45.field379.startsWith("win")) {
                    throw new Exception();
                } else if (!string_0.startsWith("http://") && !string_0.startsWith("https://")) {
                    throw new Exception();
                } else {
                    final String string_2 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

                    for (int int_1 = 0; int_1 < string_0.length(); int_1++) {
                        if (string_2.indexOf(string_0.charAt(int_1)) == -1) {
                            throw new Exception();
                        }
                    }

                    Runtime.getRuntime().exec("cmd /c start \"j\" \"" + string_0 + "\"");
                    return true;
                }
            } catch (final Throwable throwable_0) {
                return false;
            }
        } else if (int_0 == 1) {
            try {
                final Object object_0 = class41.method700(class45.field378, string_1,
                        new Object[]{(new URL(class45.field378.getCodeBase(), string_0)).toString()});
                return object_0 != null;
            } catch (final Throwable throwable_1) {
                return false;
            }
        } else if (int_0 == 2) {
            try {
                class45.field378.getAppletContext().showDocument(new URL(class45.field378.getCodeBase(), string_0),
                        "_blank");
                return true;
            } catch (final Exception exception_0) {
                return false;
            }
        } else if (int_0 == 3) {
            try {
                class41.method702(class45.field378, "loggedout");
            } catch (final Throwable throwable_2) {
            }

            try {
                class45.field378.getAppletContext().showDocument(new URL(class45.field378.getCodeBase(), string_0),
                        "_top");
                return true;
            } catch (final Exception exception_1) {
                return false;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    static int method111(final int int_0, final Script script_0, final boolean bool_0) {
        final Widget widget_0 = Widget.getWidget(class69.intStack[--class69.intStackSize]);
        if (int_0 == 2600) {
            class69.intStack[++class69.intStackSize - 1] = widget_0.scrollX;
            return 1;
        } else if (int_0 == 2601) {
            class69.intStack[++class69.intStackSize - 1] = widget_0.scrollY;
            return 1;
        } else if (int_0 == 2602) {
            class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = widget_0.text;
            return 1;
        } else if (int_0 == 2603) {
            class69.intStack[++class69.intStackSize - 1] = widget_0.scrollWidth;
            return 1;
        } else if (int_0 == 2604) {
            class69.intStack[++class69.intStackSize - 1] = widget_0.scrollHeight;
            return 1;
        } else if (int_0 == 2605) {
            class69.intStack[++class69.intStackSize - 1] = widget_0.modelZoom;
            return 1;
        } else if (int_0 == 2606) {
            class69.intStack[++class69.intStackSize - 1] = widget_0.rotationX;
            return 1;
        } else if (int_0 == 2607) {
            class69.intStack[++class69.intStackSize - 1] = widget_0.rotationY;
            return 1;
        } else if (int_0 == 2608) {
            class69.intStack[++class69.intStackSize - 1] = widget_0.rotationZ;
            return 1;
        } else if (int_0 == 2609) {
            class69.intStack[++class69.intStackSize - 1] = widget_0.opacity;
            return 1;
        } else if (int_0 == 2610) {
            class69.intStack[++class69.intStackSize - 1] = widget_0.field2608;
            return 1;
        } else if (int_0 == 2611) {
            class69.intStack[++class69.intStackSize - 1] = widget_0.textColor;
            return 1;
        } else if (int_0 == 2612) {
            class69.intStack[++class69.intStackSize - 1] = widget_0.field2631;
            return 1;
        } else if (int_0 == 2613) {
            class69.intStack[++class69.intStackSize - 1] = widget_0.field2701.vmethod5815();
            return 1;
        } else if (int_0 == 2614) {
            class69.intStack[++class69.intStackSize - 1] = widget_0.field2726 ? 1 : 0;
            return 1;
        } else {
            return 2;
        }
    }

}
