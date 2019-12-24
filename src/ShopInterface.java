import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class ShopInterface {

    public static int[][] ITEMS;
    public static int[] REMAINING;
    private static final String[] OPTIONS = new String[] { "Value", "Buy-1", "Buy-5", "Buy-10", "Buy-50", "Buy-X" };;
    private static final TreeMap<Long, String> a = new TreeMap<Long, String>();

    static {
        a.put(1000L, "k");
        a.put(1000000L, "M");
    }

    public static void init(final String title, final int[][] items, final int[] remaining) {
        Widget.get(100, 1).onLoadListener[2] = title;
        InterfaceEdits.unlock(100 << 16 | 4, -1, items.length, 0, 1, 2, 3, 4, 5, 9);
        ShopInterface.ITEMS = items;
        ShopInterface.REMAINING = remaining;
        final Widget b = Widget.addChild(6553602, 4, 0);
        b.hasScript = true;
        b.originalY = -5;
        b.relativeY = -5;
        b.width = 438;
        b.originalWidth = 438;
        b.height = 25;
        b.originalHeight = 25;
        b.fontHorizontalAlignment = 1;
        b.fontId = 494;
        b.text = "";
        b.fontVerticalAlignment = 1;
        b.textShadowed = true;
        b.textColor = 16777215;
    }

    public static void updateMappedContainer(int scriptId, Item[] stock) {
        Enum script = Buffer.method3603(scriptId);
        script.size = stock.length;
        script.keys = new int[stock.length];
        script.intVals = new int[stock.length];
        for (int i = 0; i < stock.length; i++) {
            script.keys[i] = i;
            script.intVals[i] = stock[i].id;
        }
    }

    public static void open(final Widget widget) {
        if (ITEMS == null || widget.interfaceHash >> 16 != 100) {
            return;
        }
        final Widget a = Widget.get(100, 4);

        //Widget loadouts = Widget.get(100, 2);
        //loadouts.isHidden = true;
        final ArrayList<Widget> list = new ArrayList<Widget>();
        int n = 0;
        for (final Widget em2 : a.children) {
            if (em2.type != 4) {
                em2.index = n++;
                list.add(em2);
            }
        }
        a.children = list.toArray(new Widget[0]);
        int length2 = a.children.length;
        int n2 = 0;
        int n3 = 0;
        for (final Widget em3 : a.children) {
            if (em3.itemId != -1 && !em3.isHidden) {
                final ItemComposition a2 = TextureProvider.getItemDefinition(em3.itemId);
                if (a2.placeholderId != -1 && a2.placeholderTemplateId != -1) {
                    widget.opacity = 180;
                }
                if(em3.index >= ITEMS.length)
                    return;
                final int n5 = REMAINING[em3.index];
                if(n5 != 0) {
                    final Widget b3 = Widget.addChild(a.interfaceHash, 4, length2++);
                    b3.hasScript = true;
                    b3.type = 4;
                    b3.originalX = em3.originalX;
                    b3.originalY = em3.originalY + 4;
                    b3.originalWidth = em3.originalWidth;
                    b3.originalHeight = em3.originalHeight;
                    b3.fontId = 494;
                    final int n4 = ITEMS[em3.index][1];
                    if (n4 == 0) {
                        ++n2;
                        b3.text = "";
                    } else {
                        ++n3;
                        b3.text = "<col=ffff00>" + format(n4);
                    }
                    b3.textShadowed = true;
                    b3.fontHorizontalAlignment = 2;
                    b3.fontVerticalAlignment = 2;
                    b3.textColor = 16777215;
                    Player.method1114(b3);
                    Game.widgetMethod0(b3);
                }
                // remaining
                final Widget b4 = Widget.addChild(a.interfaceHash, 4, length2++);
                b4.hasScript = true;
                b4.type = 4;
                b4.originalX = em3.originalX;
                b4.originalY = em3.originalY - 20;
                b4.originalWidth = em3.originalWidth;
                b4.originalHeight = em3.originalHeight;
                b4.fontId = 494;
                if (n5 == -1) {
                    b4.text = "";
                } else if(n5 == 0) {
                    b4.text = "<col=b20c0c> Sold ";
                    b4.originalX = em3.originalX - 7;
                    b4.originalY = em3.originalY - 10;
                }
                else {
                    b4.text = "<col=438c0b>x" + format(n5);
                }
                b4.width = 100;
                b4.textShadowed = true;
                b4.fontHorizontalAlignment = 2;
                b4.fontVerticalAlignment  = 2;
                b4.textColor = 16777215;
                Player.method1114(b4);
                Game.widgetMethod0(b4);
            }
        }
        a.originalY += 20;
        a.originalHeight += 20;
        a.scrollHeight += 10;

        Widget[] children = GameCanvas.widgets[100];
        int childCount = Widget.widgetIndex.fileCount(100);
        ArrayList<Widget> newChildren = new ArrayList<Widget>();
        for(int i = 0; i < childCount; i++)
            newChildren.add(children[i]);

        Widget priceText = new Widget();
        priceText.fontId = 494;
        priceText.originalWidth = 100;
        priceText.hasScript = true;
        priceText.type = 4;
        priceText.originalX = 5;
        priceText.originalY = 50;
        priceText.originalWidth = 500;
        priceText.originalHeight = 20;
        priceText.textShadowed = true;
        priceText.fontHorizontalAlignment = 1;
        priceText.textColor = 16777215;

        if (n2 > 0) {
            if (n3 > 0)
                priceText.text = "Prices are displayed at the bottom right of each item. Items without a price are <col=4dff4d>free</col>!";
            else
                priceText.text = "All items in this shop are <col=4dff4d>free</col>!";
        } else {
            priceText.text = "Prices are displayed at the bottom right of each item.";
        }

        Player.method1114(priceText);
        Game.widgetMethod0(priceText);
        newChildren.add(priceText);

        /**
         * Children (Any new children have to become before this!)
         */
        for(int i = childCount; i < newChildren.size(); i++) {
            Widget child = newChildren.get(i);
            child.interfaceHash = 100 << 16 | i;
            if(child.type == 5) {
                long var37 = ((long) child.interfaceHash << 32) + (long) -1; //-1 is min/max value
                final Node node_0 = Game.widgetFlags.get(var37);
                if (node_0 != null)
                    node_0.unlink();
                Game.widgetFlags.put(new IntegerNode(2), var37);
            }
            Player.method1114(child);
            Game.widgetMethod0(child);
        }
        GameCanvas.widgets[100] = newChildren.toArray(new Widget[newChildren.size()]);
    }

    public static void updateOptions(final Widget widget) {
        if (ITEMS == null || widget.interfaceHash >> 16 != 100) {
            return;
        }
        for(int x = 0; x < OPTIONS.length; x++) {
            String s = OPTIONS[x];
            widget.setAction(x, s.isEmpty() ? null : s);
        }
    }

    public static void updateItem(Widget inter, ItemComposition def) {
        if(inter.interfaceHash >> 16 != 100)
            return;
        if(def.placeholderId != -1 && def.placeholderTemplateId != -1) {
            /* dim placeholder items properly in shop */
            inter.opacity = 120;
        }
    }

    static String format(final long number) {
        if (number == Long.MIN_VALUE) {
            return format(-9223372036854775807L);
        }
        if (number < 0L) {
            return "-" + format(-number);
        }
        if (number < 1000L) {
            return Long.toString(number);
        }
        final Map.Entry<Long, String> floorEntry = ShopInterface.a.floorEntry(number);
        final Long n2 = floorEntry.getKey();
        final String s = floorEntry.getValue();
        final long n3 = number / (n2 / 10L);
        return (n3 < 100L && n3 / 10.0 != n3 / 10L) ? (n3 / 10.0 + s) : (n3 / 10L + s);
    }

}
