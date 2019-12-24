public class RuinMisc {

    public static int DRAG = 5;
    public static boolean HIDE_TITLES = false;
    public static boolean SHOW_GROUND_ITEM_COLORS = false;
    public static boolean SNOW_ON_GROUND = false;

    public static void handleCustomVarp(int id, int value) {
        id -= 20000;
        if(id == 0) {
            DRAG = value;
            return;
        }
        if(id == 1) {
            SwitchGrading.required = value;
            return;
        }
        if(id == 2) {
            boolean hide = value == 1;
            for(int i = 0; i < 11; i++) {
                Widget c1 = Widget.get(90, 29 + i);
                c1.isHidden = hide;
                Player.method1114(c1);

                Widget c2 = Widget.get(90, 40 + i);
                c2.isHidden = hide;
                Player.method1114(c2);
            }
            Widget minimise = Widget.get(90, 51);
            minimise.isHidden = hide;
            Player.method1114(minimise);
            return;
        }
        if(id == 3) {
            boolean pvpZone = value == 1;
            if(pvpZone) {
                if((Game.flags & 0x4) != 0)
                    return;
                Game.flags |= 0x4;
            } else {
                if((Game.flags & 0x4) == 0)
                    return;
                Game.flags &= ~0x4;
            }
            return;
        }
        if(id == 4) {
            WidgetTimer.SHOW_WIDGETS = value == 1;
            return;
        }
        if (id == 5) {
            HIDE_TITLES = value == 1;
            return;
        }
        if(id == 6) {
            SHOW_GROUND_ITEM_COLORS = value == 1;
            return;
        }
    }

}