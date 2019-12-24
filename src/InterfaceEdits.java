public class InterfaceEdits {

    public static void childLoaded(Widget inter) {
        int parentId = inter.interfaceHash >> 16;
        int childId = inter.interfaceHash & 0xffff;
        inter.text = inter.text.replace("RuneScape", Loader.SERVER_NAME);
        if(parentId == 24) { //barrows overlay
            if(childId == 9 || childId == 10) {
                inter.originalX = inter.originalX = 0;
                inter.width = inter.height = 0;
                inter.isHidden = true;
            }
            return;
        }
        if(parentId == 193) { //1 item dialogue
            if(childId == 3 || childId == 4)
                inter.isHidden = true;
            return;
        }
        if(parentId == 109) {
            if(childId == 3)
                inter.setAction(0, "Open Store");
        }
        if(parentId == 261) { //options tab
            if(childId == 77) {
                inter.setAction(0, "Buy Credits");
//                inter.onOpListener[4] = "Buy Credits";
            }
            return;
        }
        if(parentId == 275) { //quest scroll
            if(childId >= 4 && childId <= 133)
                inter.text = "";
            return;
        }
        if(parentId == 320) { //skills
            if(childId == 27) {
                inter.setAction(0, "Shout total level");
                inter.setAction(1, "Shout total XP");
                unlock(inter.interfaceHash, -1, -1, 0, 1);
            }
            return;
        }
        if(parentId == 596) { //target overlay
            if(childId == 2)
                inter.width += 70;
            return;
        }
        if(parentId == 541) { //prayer interface
            if(childId == 30 || childId == 31) {
                inter.setAction(1, "Refund Scroll");
                unlock(inter.interfaceHash, -1, -1, 0, 1, 1);
            }
        }
    }


    public static void optionSet(Widget inter, int index, String option) {
        int parentId = inter.interfaceHash >> 16;
        int childId = inter.interfaceHash & 0xffff;
        if(option.equals("Quest List")) {
            inter.setAction(index, (String) JournalInterface.ACTIVE_JOURNAL[0]);
            return;
        }
        if(parentId == 320) {
            if(childId >= 1 && childId <= 23) {
                if(childId >= 1 && childId <= 6 || childId == 9) {
                    if (WorldType.isPVP())
                        inter.setAction(0, option.replace("View", "Set").replace("guide", "level"));
                    else
                        inter.setAction(0, option.replace("Set", "View").replace("level", "guide"));
                } else {
                    inter.setAction(0, option.replace("Set", "View").replace("level", "guide"));
                }
                inter.setAction(1, option.replace("View", "Shout").replace("guide", "level"));
                inter.setAction(2, option.replace("View", "Shout").replace("guide", "XP"));
                unlock(inter.interfaceHash, -1, -1, 0, 1, 2);
            }
        }

        if(parentId == 284) {
            if(childId == 6) {
                inter.setAction(0, option.replace("Learn More", "Vote Now"));
            }
            if(childId == 7) {
                inter.setAction(0, option.replace("Bond Pouch", "Hiscores"));
            }
        }
    }

    public static void unlock(int interfaceHash, int minChildId, int maxChildId, int... optionIndexes) {
        int mask = 0;
        for(int i : optionIndexes)
            mask |= 2 << i;
        for(int slot = minChildId; slot <= maxChildId; slot++) {
            long l = (((long) interfaceHash << 32) + (long) slot);
            final Node node_0 = Game.widgetFlags.get(l);
            if (node_0 != null)
                node_0.unlink();
            Game.widgetFlags.put(new IntegerNode(mask), l);
        }
    }

    public static boolean allowUnload(int interfaceId) {
        return interfaceId != 94;
    }

}