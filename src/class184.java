public class class184 {

    static long field2351;
    static long field2350;

    static void method3785(final int int_0, final int int_1) {
        int int_2 = ClanMemberManager.fontBold12.getTextWidth("Choose Option");

        int int_3;
        int int_4;
        for (int_3 = 0; int_3 < Game.menuOptionCount; int_3++) {
            int_4 = ClanMemberManager.fontBold12.getTextWidth(WorldMapType1.method176(int_3));
            if (int_4 > int_2) {
                int_2 = int_4;
            }
        }

        int_2 += 8;
        int_3 = (Game.menuOptionCount * 15) + 22;
        int_4 = int_0 - (int_2 / 2);
        if ((int_2 + int_4) > Varcs.canvasWidth) {
            int_4 = Varcs.canvasWidth - int_2;
        }

        if (int_4 < 0) {
            int_4 = 0;
        }

        int int_5 = int_1;
        if ((int_1 + int_3) > BuildType.canvasHeight) {
            int_5 = BuildType.canvasHeight - int_3;
        }

        if (int_5 < 0) {
            int_5 = 0;
        }

        MouseInput.menuX = int_4;
        WorldComparator.menuY = int_5;
        UrlRequester.field1856 = int_2;
        class151.field1933 = (Game.menuOptionCount * 15) + 22;
    }

}
