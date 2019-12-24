import java.util.ArrayList;
import java.util.List;

public class JournalInterface {

    public static final Object[][] ECO_JOURNALS = {
            //tab name, tab icon, tab btn icon
            {"Journal", 776, 835},
            {"Achievements", 1053, 836},
            {"Presets", 1052, 1054},
            {"Toggles", 1299, 1297},
            {"Bestiary", RuinUtils.customInterSpriteId(0), RuinUtils.customInterSpriteId(1)}
    };

    public static final Object[][] PVP_JOURNALS = {
            //tab name, tab icon, tab btn icon
            {"Journal", 776, 835},
            {"Presets", 1052, 1054},
            {"Presets", 1299, 1297},
            {"Toggles", RuinUtils.customInterSpriteId(0), RuinUtils.customInterSpriteId(1)},
            {"Bestiary", RuinUtils.customInterSpriteId(0), RuinUtils.customInterSpriteId(1)}
    };

    private static Object[][] getJournals() {
        return WorldType.active == WorldType.PVP ? PVP_JOURNALS : ECO_JOURNALS;
    }


    public static Object[] ACTIVE_JOURNAL = getJournals()[0];

    public static void init(int active, List<Object[]> categories) {
        if(Widget.get(259, 4).children == null) {
            //Interface isn't loaded (Pretty much only happens from raids)
            return;
        }
        ACTIVE_JOURNAL = getJournals()[active];

        /**
         * Tab name & icon (Forces tab to refresh using varp 1055)
         */
        class45.method749(1055);
        Game.pendingVarbitChanges[Game.pendingVarbitCount++ & 0x1F] = 1055;

        /**
         * Tab title
         */
        Widget title = Widget.getWidget(259 << 16);
        title.text = (String) ACTIVE_JOURNAL[0];
        title.fontHorizontalAlignment = 0;
        title.originalX = 10;
        Player.method1114(title);
        Game.widgetMethod0(title);

        /**
         * Children (Any new children have to be added after this!)
         */
        Widget[] children = GameCanvas.widgets[259];
        int childCount = Widget.widgetIndex.fileCount(259);
        ArrayList<Widget> newChildren = new ArrayList<Widget>();
        for(int i = 0; i < childCount; i++)
            newChildren.add(children[i]);

        /**
         * Tab nav buttons
         */
        Widget baseBtn1 = children[1];
        Widget baseBtn2 = children[2];
        Widget baseBtn3 = children[3];
        baseBtn1.isHidden = baseBtn2.isHidden = baseBtn3.isHidden = true;

        Widget journalBtn;
        journalBtn = new Widget();
        journalBtn.hasScript = true;
        journalBtn.parentHash = baseBtn1.parentHash;
        journalBtn.type = baseBtn1.type;
        journalBtn.originalY = baseBtn1.originalY;
        journalBtn.originalWidth = baseBtn1.originalWidth;
        journalBtn.originalHeight = baseBtn1.originalHeight;
        journalBtn.hasListener = true;
        journalBtn.onMouseOverListener = baseBtn1.onMouseOverListener;
        journalBtn.onMouseLeaveListener = baseBtn1.onMouseLeaveListener;
        newChildren.add(journalBtn);

        Widget achievementsBtn = null;
        if (WorldType.active == WorldType.ECO) {
            achievementsBtn = new Widget();
            achievementsBtn.hasScript = true;
            achievementsBtn.parentHash = baseBtn1.parentHash;
            achievementsBtn.type = baseBtn1.type;
            achievementsBtn.originalY = baseBtn1.originalY;
            achievementsBtn.originalWidth = baseBtn1.originalWidth;
            achievementsBtn.originalHeight = baseBtn1.originalHeight;
            achievementsBtn.hasListener = true;
            achievementsBtn.onMouseOverListener = baseBtn1.onMouseOverListener;
            achievementsBtn.onMouseLeaveListener = baseBtn1.onMouseLeaveListener;
            newChildren.add(achievementsBtn);
        }


        Widget presetsBtn;
        presetsBtn = new Widget();
        presetsBtn.hasScript = true;
        presetsBtn.parentHash = baseBtn1.parentHash;
        presetsBtn.type = baseBtn1.type;
        presetsBtn.originalY = baseBtn1.originalY;
        presetsBtn.originalWidth = baseBtn1.originalWidth;
        presetsBtn.originalHeight = baseBtn1.originalHeight;
        presetsBtn.hasListener = true;
        presetsBtn.onMouseOverListener = baseBtn1.onMouseOverListener;
        presetsBtn.onMouseLeaveListener = baseBtn1.onMouseLeaveListener;
        newChildren.add(presetsBtn);

        Widget togglesBtn;
        togglesBtn = new Widget();
        togglesBtn.hasScript = true;
        togglesBtn.parentHash = baseBtn1.parentHash;
        togglesBtn.type = baseBtn1.type;
        togglesBtn.originalY = baseBtn1.originalY;
        togglesBtn.originalWidth = baseBtn1.originalWidth;
        togglesBtn.originalHeight = baseBtn1.originalHeight;
        togglesBtn.hasListener = true;
        togglesBtn.onMouseOverListener = baseBtn1.onMouseOverListener;
        togglesBtn.onMouseLeaveListener = baseBtn1.onMouseLeaveListener;
        newChildren.add(togglesBtn);

        Widget bestiaryBtn;
        bestiaryBtn = new Widget();
        bestiaryBtn.hasScript = true;
        bestiaryBtn.parentHash = baseBtn1.parentHash;
        bestiaryBtn.type = baseBtn1.type;
        bestiaryBtn.originalY = baseBtn1.originalY;
        bestiaryBtn.originalWidth = baseBtn1.originalWidth;
        bestiaryBtn.originalHeight = baseBtn1.originalHeight;
        bestiaryBtn.hasListener = true;
        bestiaryBtn.onMouseOverListener = baseBtn1.onMouseOverListener;
        bestiaryBtn.onMouseLeaveListener = baseBtn1.onMouseLeaveListener;
        newChildren.add(bestiaryBtn);


        Widget[] navBtns;
        if (WorldType.active == WorldType.ECO) {
            navBtns = new Widget[]{journalBtn, achievementsBtn, presetsBtn, togglesBtn, bestiaryBtn};
        } else {
            navBtns = new Widget[]{journalBtn, presetsBtn, togglesBtn, bestiaryBtn};
        }
        int navX = 190;
        for(int i = (navBtns.length - 1); i >= 0; i--) {
            Widget btn = navBtns[i];
            if(!btn.isHidden) {
                Object[] btnType = getJournals()[i];
                btn.originalX = (navX -= 18);
                btn.spriteId = (Integer) btnType[2];
                btn.setAction(0, "View " + btnType[0]);
                Player.method1114(btn);
            }
        }
        /**
         * Footer text
         */
        Widget footerText = new Widget();
        footerText.parentHash = -1;
        footerText.type = 4;
        footerText.originalX = title.originalX;
        footerText.originalY = 250;
        footerText.originalWidth = 171;
        footerText.fontId = 494;
        footerText.textColor = title.textColor;
        footerText.textShadowed = true;
        footerText.text = "";
        newChildren.add(footerText);

        Widget cpText = new Widget();
        cpText.parentHash = -1;
        cpText.type = 4;
        cpText.originalX = title.originalX;
        cpText.originalY = 250;
        cpText.originalWidth = 171;
        cpText.fontId = 494;
        cpText.textColor = title.textColor;
        cpText.textShadowed = true;
        cpText.fontHorizontalAlignment = 2;
        cpText.text = Loader.WEBSITE_URL;
        newChildren.add(cpText);
        /**
         * Children (Any new children have to become before this!)
         */
        for(int i = childCount; i < newChildren.size(); i++) {
            Widget child = newChildren.get(i);
            child.interfaceHash = 259 << 16 | i;
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
        GameCanvas.widgets[259] = newChildren.toArray(new Widget[newChildren.size()]);
        /**
         * Tab list children
         */
        int listHash = 259 << 16 | 4;
        Widget list = Widget.getWidget(listHash);
        list.children = null;

        int childId = 0;
        int yPosition = 9;
        ArrayList<Object[]> headers = new ArrayList<Object[]>();
        for(Object[] cat : categories) {
            String name = (String) cat[0];
            int size = (Integer) cat[1];
            if(!name.isEmpty()) {
                headers.add(new Object[]{yPosition, name});
                yPosition += 20;
            }
            for(int i = 0; i < size; i++) {
                Widget child = Widget.addChild(listHash, 4, childId++);
                child.originalX = 10;
                child.originalY = yPosition;
                child.originalWidth = 152;
                child.originalHeight = 15;
                child.fontId = 494;
                child.textShadowed = true;
                child.text = "child: " + (childId - 1);
                child.hasListener = true;
                child.onMouseOverListener = new Object[]{85, -2147483645, -2147483643, 16777215};
                child.onMouseLeaveListener = new Object[]{85, -2147483645, -2147483643, child.textColor};
                child.setAction(0, "Select");
                Player.method1114(child);
                Game.widgetMethod0(child);
                yPosition += 15;
            }
        }
        for(Object[] obj : headers) {
            Widget child = Widget.addChild(listHash, 4, childId++);
            child.originalX = 10;
            child.originalY = (Integer) obj[0];
            child.originalWidth = 152;
            child.originalHeight = 15;
            child.fontId = 496;
            child.textColor = 16750899;
            child.textShadowed = true;
            child.text = (String) obj[1];
            Player.method1114(child);
            Game.widgetMethod0(child);
        }

        /**
         * Scrolling
         */
        list.scrollY = 0;
        list.scrollHeight = Math.max(list.originalHeight, yPosition + 5);
        final ScriptEvent script = new ScriptEvent();
        script.objs = new Object[]{31, 259 << 16 | 7, listHash, 792, 789, 790, 791, 773, 788};;
        class68.method1696(script);

        /**
         * Unlocking children
         */
        InterfaceEdits.unlock(listHash, 0, childId, 0);
        /**
         * Refresh
         */
        Player.method1114(list);
    }

    public static void update(int childId, String text, int colorIndex) {
        if(Widget.get(259, 4).children == null) {
            //Interface isn't loaded (Pretty much only happens from raids)
            return;
        }
        Widget child = Widget.getWidget(259 << 16 | 4).children[childId];
        child.text = text;
        if(colorIndex != 255) {
            int[] colors = {
                    /**
                     * OSRS colors
                    */
                    16711680,   //red
                    0xffff00,   //yellow
                    65280,      //green
                    /**
                     * Custom colors
                    */
                    class138.method3137("FFA500", 16),   //orange
                    class138.method3137("FF4500", 16),   //orange red
                    class138.method3137("FF6347", 16),   //tomato
                    class138.method3137("DC143C", 16),   //crimson

                    class138.method3137("0000FF", 16),   //blue
                    class138.method3137("0040ff", 16),   //cool blue
                    class138.method3137("1E90FF", 16),   //baby blue
                    class138.method3137("00FFFF", 16),   //cyan

                    class138.method3137("800080", 16),   //purple
                    class138.method3137("EE82EE", 16),   //violet
                    class138.method3137("FFC0CB", 16),   //pink

                    class138.method3137("FFFFFF", 16),   //white
                    class138.method3137("F5DEB3", 16),   //wheat
                    class138.method3137("C0C0C0", 16),   //silver

                    class138.method3137("808000", 16),   //olive
                    class138.method3137("D37E2A", 16),   //bronze
                    class138.method3137("FFD700", 16),   //gold
            };
            int color = colors[colorIndex];
            child.textColor = color;
            if(child.onMouseLeaveListener == null) //todo figure out how/why this is happening
                ;
//                new Throwable(childId + ", \"" + text + "\", " + colorIndex).printStackTrace();
            else
                child.onMouseLeaveListener[3] = color;
            Player.method1114(child);
        }
    }

}
