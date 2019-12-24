public abstract class Timer {

    public abstract void vmethod3330();

    public abstract int vmethod3331(int var1, int var2);

    public static void method3344(final IndexDataBase indexdatabase_0) {
        InvType.field3226 = indexdatabase_0;
    }

    static void method3338(final int int_0, final int int_1, final int int_2) {
        int int_3;
        for (int_3 = 0; int_3 < 8; int_3++) {
            for (int int_4 = 0; int_4 < 8; int_4++) {
                class50.tileHeights[int_0][int_3 + int_1][int_4 + int_2] = 0;
            }
        }

        if (int_1 > 0) {
            for (int_3 = 1; int_3 < 8; int_3++) {
                class50.tileHeights[int_0][int_1][int_3 + int_2] = class50.tileHeights[int_0][int_1 - 1][int_3 + int_2];
            }
        }

        if (int_2 > 0) {
            for (int_3 = 1; int_3 < 8; int_3++) {
                class50.tileHeights[int_0][int_3 + int_1][int_2] = class50.tileHeights[int_0][int_3 + int_1][int_2 - 1];
            }
        }

        if ((int_1 > 0) && (class50.tileHeights[int_0][int_1 - 1][int_2] != 0)) {
            class50.tileHeights[int_0][int_1][int_2] = class50.tileHeights[int_0][int_1 - 1][int_2];
        } else if ((int_2 > 0) && (class50.tileHeights[int_0][int_1][int_2 - 1] != 0)) {
            class50.tileHeights[int_0][int_1][int_2] = class50.tileHeights[int_0][int_1][int_2 - 1];
        } else if ((int_1 > 0) && (int_2 > 0) && (class50.tileHeights[int_0][int_1 - 1][int_2 - 1] != 0)) {
            class50.tileHeights[int_0][int_1][int_2] = class50.tileHeights[int_0][int_1 - 1][int_2 - 1];
        }

    }

    static int method3341(final int int_0, final Script script_0, final boolean bool_0) {
        Widget widget_0;
        if (int_0 == 2700) {
            widget_0 = Widget.getWidget(class69.intStack[--class69.intStackSize]);
            class69.intStack[++class69.intStackSize - 1] = widget_0.itemId;
            return 1;
        } else if (int_0 == 2701) {
            widget_0 = Widget.getWidget(class69.intStack[--class69.intStackSize]);
            if (widget_0.itemId != -1) {
                class69.intStack[++class69.intStackSize - 1] = widget_0.itemQuantity;
            } else {
                class69.intStack[++class69.intStackSize - 1] = 0;
            }

            return 1;
        } else if (int_0 == 2702) {
            final int int_1 = class69.intStack[--class69.intStackSize];
            final WidgetNode widgetnode_0 = (WidgetNode) Game.componentTable.get(int_1);
            if (widgetnode_0 != null) {
                class69.intStack[++class69.intStackSize - 1] = 1;
            } else {
                class69.intStack[++class69.intStackSize - 1] = 0;
            }

            return 1;
        } else if (int_0 == 2706) {
            class69.intStack[++class69.intStackSize - 1] = Game.widgetRoot;
            return 1;
        } else {
            return 2;
        }
    }

    static void method3342() {
        for (PendingSpawn pendingspawn_0 = (PendingSpawn) Game.pendingSpawns.getFront(); pendingspawn_0 != null; pendingspawn_0 = (PendingSpawn) Game.pendingSpawns.getNext()) {
            if (pendingspawn_0.hitpoints == -1) {
                pendingspawn_0.delay = 0;
                class74.method1800(pendingspawn_0);
            } else {
                pendingspawn_0.unlink();
            }
        }

    }

}
