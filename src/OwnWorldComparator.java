import java.util.Comparator;

public class OwnWorldComparator implements Comparator {

    static Resampler field577;
    static IndexData indexTrack2;
    boolean field575;

    int method1123(final GrandExchangeEvent grandexchangeevent_0, final GrandExchangeEvent grandexchangeevent_1) {
        if (grandexchangeevent_1.world == grandexchangeevent_0.world) {
            return 0;
        } else {
            if (field575) {
                if (Game.world == grandexchangeevent_0.world) {
                    return -1;
                }

                if (grandexchangeevent_1.world == Game.world) {
                    return 1;
                }
            }

            return grandexchangeevent_0.world < grandexchangeevent_1.world ? -1 : 1;
        }
    }

    @Override
    public int compare(final Object object_0, final Object object_1) {
        return method1123((GrandExchangeEvent) object_0, (GrandExchangeEvent) object_1);
    }

    @Override
    public boolean equals(final Object object_0) {
        return super.equals(object_0);
    }

    static MessageNode method1130(final int int_0) {
        return (MessageNode) class83.messages.get(int_0);
    }

    static void changeWorld(final World world) {
        if (world.method1589() != Game.isMembers) {
            Game.isMembers = world.method1589();
            final boolean bool_0 = world.method1589();
            if (bool_0 != ItemComposition.isMembersWorld) {
                MouseRecorder.method1036();
                ItemComposition.isMembersWorld = bool_0;
            }
        }

        class54.host = world.address;
        Game.world = world.id;
        Game.flags = world.mask;
        class26.port1 = Game.socketType == 0 ? 7306 : world.id + 40000;
        class68.port2 = Game.socketType == 0 ? 7306 : world.id + 50000;
        class290.myWorldPort = class26.port1;
        Loader.updateWorld();
    }

    static int method1126(final int int_0, final Script script_0, final boolean bool_0) {
        final Widget widget_0 = Widget.getWidget(class69.intStack[--class69.intStackSize]);
        if (int_0 == 2800) {
            class69.intStack[++class69.intStackSize - 1] = Signlink.method3252(class24.getWidgetClickMask(widget_0));
            return 1;
        } else if (int_0 != 2801) {
            if (int_0 == 2802) {
                if (widget_0.opBase == null) {
                    class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = "";
                } else {
                    class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = widget_0.opBase;
                }

                return 1;
            } else {
                return 2;
            }
        } else {
            int int_1 = class69.intStack[--class69.intStackSize];
            --int_1;
            if ((widget_0.actions != null) && (int_1 < widget_0.actions.length) && (widget_0.actions[int_1] != null)) {
                class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = widget_0.actions[int_1];
            } else {
                class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = "";
            }

            return 1;
        }
    }

}
