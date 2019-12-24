import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DropViewerInterface {

    public static void init(String tableName, int petId, int petAverage, List<Integer[]> drops) {
        Widget infoX = Widget.get(522, 17);
        if(infoX != null)
            infoX.onClickListener = null;

        Widget.getWidget(383 << 16 | 1).children[1].text = "Viewing drop table for: " + tableName; //set title
        Widget.getWidget(383 << 16 | 2).isHidden = true; //hide "Exchange" button

        Widget parent = Widget.getWidget(383 << 16 | 3);
        parent.children = null; //reset previous children

        Collections.sort(drops, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] d1, Integer[] d2) {
                int x = d1[4];
                int y = d2[4];
                return (x < y) ? -1 : ((x == y) ? 0 : 1);
            }
        });
        if(petId != 65535)
            drops.add(0, new Integer[]{petId, 1, -1, -1, petAverage}); //"pet" specifically identified by minAmount == -1

        int childId = 0;
        String[] columns = {"Min Amount", "Max Amount", "Drop Chance"};
        for(int i = 0; i < drops.size(); i++) {
            Integer[] drop = drops.get(i);

            int itemId = drop[0];
            int broadcastType = drop[1];
            int minAmount = drop[2];
            int maxAmount = drop[3];
            int average = drop[4];

            boolean pet = minAmount == -1;

            Widget bg = Widget.addChild(parent.interfaceHash, 5, childId++);
            bg.originalX = 0;
            bg.originalY = i * 38;
            bg.originalWidth = 424;
            bg.originalHeight = 38;
            bg.spriteId = 1040;
            bg.spriteTiling = true;
            bg.filled = true;
            bg.onMouseOverListener = new Object[]{1015, -2147483645, -2147483643, 0, 255};
            if(i % 2 == 0) {
                bg.opacity = 0;
                bg.onMouseLeaveListener = new Object[]{1015, -2147483645, -2147483643, 0, 0};
            } else {
                bg.opacity = 125;
                bg.onMouseLeaveListener = new Object[]{1015, -2147483645, -2147483643, 0, 125};
            }
            bg.hasListener = true;
            Player.method1114(bg);
            Game.widgetMethod0(bg);

            ItemComposition def = TextureProvider.getItemDefinition(itemId);
            boolean note = def.notedTemplate >= 0 && def.notedId >= 0;
            String name = (note ? TextureProvider.getItemDefinition(def.notedId).name : def.name);

            Widget examine = Widget.addChild(parent.interfaceHash, 5, childId++);
            examine.originalX = 0;
            examine.originalY = bg.originalY;
            examine.originalWidth = 40;
            examine.originalHeight = bg.originalHeight;
            examine.setAction(0, "Examine <col=ff9040>" + name + "</col>");
            Player.method1114(examine);
            Game.widgetMethod0(examine);

            Widget item = Widget.addChild(parent.interfaceHash, 5, childId++);
            item.originalX = 3;
            item.originalY = bg.originalY + 3;
            item.originalWidth = 36;
            item.originalHeight = 32;
            Widget.setItem(item, itemId, (minAmount == maxAmount ? minAmount : (maxAmount / 2)), 0);
            item.shadow = 3355443;
            item.borderThickness = 1;
            Player.method1114(item);
            Game.widgetMethod0(item);

            Widget itemName = Widget.addChild(parent.interfaceHash, 4, childId++);
            itemName.originalX = 38;
            itemName.originalY = bg.originalY + 5;
            itemName.originalWidth = 140;
            itemName.originalHeight = 38;
            itemName.fontId = 495;
            itemName.textShadowed = true;
            itemName.textColor = 16750623;
            itemName.text = "<col=ffb83f>" + name;
            itemName.fontHorizontalAlignment = 1;
            itemName.fontVerticalAlignment = 0;
            Player.method1114(itemName);
            Game.widgetMethod0(itemName);

            Widget broadcast = Widget.addChild(parent.interfaceHash, 4, childId++);
            broadcast.originalX = itemName.originalX;
            broadcast.originalY = itemName.originalY + 16;
            broadcast.originalWidth = itemName.originalWidth;
            broadcast.originalHeight = 10;
            broadcast.fontId = 494;
            broadcast.textShadowed = true;
            broadcast.textColor = 16750623;
            broadcast.fontHorizontalAlignment = 1;
            broadcast.fontVerticalAlignment = 0;
            String b = "None";
            if(broadcastType == 0)
                b = "Friends";
            else if(broadcastType == 1)
                b = "World";
            else if(broadcastType == 2)
                b = "Global";
            broadcast.text = "Broadcast: <col=ffb83f>" + b;
            Player.method1114(broadcast);
            Game.widgetMethod0(broadcast);

            if(pet) {
                Widget info = Widget.addChild(parent.interfaceHash, 4, childId++);
                info.originalX = 170;
                info.originalY = bg.originalY + 1;
                info.originalWidth = 165;
                info.originalHeight = bg.originalHeight;
                info.fontId = 494;
                info.textShadowed = true;
                info.textColor = 16750623;
                info.text = "<col=F5DEB3>Pet unlocks do not affect<br><col=F5DEB3>drops and vice versa.";
                info.fontHorizontalAlignment = 1;
                info.fontVerticalAlignment = 1;
                Player.method1114(info);
                Game.widgetMethod0(info);

                Widget column = Widget.addChild(parent.interfaceHash, 4, childId++);
                column.originalX = 340;
                column.originalY = bg.originalY + 7;
                column.originalWidth = 80;
                column.originalHeight = 32;
                column.fontId = 494;
                column.textShadowed = true;
                column.textColor = 16750623;
                column.fontHorizontalAlignment = 1;
                column.text = "Unlock Chance:";
                Player.method1114(column);
                Game.widgetMethod0(column);

                Widget value = Widget.addChild(parent.interfaceHash, 4, childId++);
                value.originalX = column.originalX;
                value.originalY = column.originalY + 12;
                value.originalWidth = column.originalWidth;
                value.originalHeight = 10;
                value.fontId = 494;
                value.textShadowed = true;
                value.textColor = 16750623;
                value.fontHorizontalAlignment = 1;
                value.text = "<col=ffb83f>~ 1 / " + average;
                Player.method1114(value);
                Game.widgetMethod0(value);
            } else {
                int x = 170;
                for(int c = 0; c < columns.length; c++) {
                    String s = columns[c];
                    Widget column = Widget.addChild(parent.interfaceHash, 4, childId++);
                    column.originalX = x;
                    column.originalY = bg.originalY + 7;
                    column.originalWidth = 80;
                    column.originalHeight = 32;
                    column.fontId = 494;
                    column.textShadowed = true;
                    column.textColor = 16750623;
                    column.fontHorizontalAlignment = 1;
                    column.text = s + ":";
                    Player.method1114(column);
                    Game.widgetMethod0(column);
                    x += 85;

                    Widget value = Widget.addChild(parent.interfaceHash, 4, childId++);
                    value.originalX = column.originalX;
                    value.originalY = column.originalY + 12;
                    value.originalWidth = column.originalWidth;
                    value.originalHeight = 10;
                    value.fontId = 494;
                    value.textShadowed = true;
                    value.textColor = 16750623;
                    value.fontHorizontalAlignment = 1;

                    if(c == 0)
                        value.text = "<col=ffb83f>" + (minAmount == 0 ? "-" : minAmount);
                    else if(c == 1)
                        value.text = "<col=ffb83f>" + (maxAmount == 0 ? "-" : maxAmount);
                    else if(c == 2)
                        value.text = "<col=ffb83f>" + (average == 1 ? "Always" : ("~ 1 / " + average));
                    Player.method1114(value);
                    Game.widgetMethod0(value);
                }
            }
        }
        /**
         * Scrolling
         */
        parent.scrollY = 0;
        parent.scrollHeight = Math.max(parent.originalHeight, drops.size() * 38);
        final ScriptEvent scriptevent_0 = new ScriptEvent();
        scriptevent_0.objs = new Object[]{31, 25100292, 25100291, 792, 789, 790, 791, 773, 788};
        class68.method1696(scriptevent_0);


        /**
         * Unlocking
         */
        InterfaceEdits.unlock(parent.interfaceHash, 0, childId, 0);

        /**
         * Refresh
         */
        Player.method1114(parent);
    }

}
