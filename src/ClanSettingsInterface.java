public class ClanSettingsInterface {

    public static void update(String name, int enterRank, int talkRank, int kickRank) {
        Widget nameInter = Widget.get(94, 10);
        nameInter.text = name;
        Player.method1114(nameInter);

        Widget enterInter = Widget.get(94, 13);
        enterInter.text = enterInter.actions[enterRank == -1 ? 0 : enterRank];
        Player.method1114(enterInter);

        Widget talkInter = Widget.get(94, 16);
        talkInter.text = talkInter.actions[talkRank == -1 ? 0 : talkRank];
        Player.method1114(talkInter);

        Widget kickInter = Widget.get(94, 19);
        kickInter.text = kickInter.actions[kickRank == -1 ? 3 : kickRank + 1];
        Player.method1114(kickInter);
    }

    public static void update(Widget inter, int option) {
        int interfaceId = inter.interfaceHash >> 16;
        if (interfaceId != 94)
            return;
        int childId = inter.interfaceHash & 0xffff;
        if (childId == 13 || childId == 16 || childId == 19)
            inter.text = inter.actions[option - 1];
    }

}
