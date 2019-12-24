public class LoginPacket implements class167 {

    public static final LoginPacket field2237;
    static final LoginPacket field2236;
    public static final LoginPacket field2235;
    public static final LoginPacket field2238;
    static final LoginPacket[] field2240;
    public final int id;

    static {
        field2237 = new LoginPacket(14, 0);
        field2236 = new LoginPacket(15, 4);
        field2235 = new LoginPacket(16, -2);
        field2238 = new LoginPacket(18, -2);
        field2240 = new LoginPacket[32];
        final LoginPacket[] loginpackets_0 = new LoginPacket[]{field2235, field2236, field2237, field2238};
        final LoginPacket[] loginpackets_1 = loginpackets_0;

        for (int int_0 = 0; int_0 < loginpackets_1.length; int_0++) {
            field2240[loginpackets_1[int_0].id] = loginpackets_1[int_0];
        }

    }

    LoginPacket(final int int_0, final int int_1) {
        id = int_0;
    }

    static void method3449(final int int_0, final int int_1, final int int_2, final int int_3, final int int_4,
                           final int int_5, final int int_6) {
        if ((int_2 >= 1) && (int_3 >= 1) && (int_2 <= 102) && (int_3 <= 102)) {
            if (Game.lowMemory && (int_0 != class13.plane)) {
                return;
            }

            long long_0 = 0L;
            if (int_1 == 0) {
                long_0 = MapIcon.region.method2898(int_0, int_2, int_3);
            }

            if (int_1 == 1) {
                long_0 = MapIcon.region.method2899(int_0, int_2, int_3);
            }

            if (int_1 == 2) {
                long_0 = MapIcon.region.method2900(int_0, int_2, int_3);
            }

            if (int_1 == 3) {
                long_0 = MapIcon.region.method2901(int_0, int_2, int_3);
            }

            int int_7;
            if (long_0 != 0L) {
                int_7 = MapIcon.region.method2902(int_0, int_2, int_3, long_0);
                final int int_8 = KeyFocusListener.method673(long_0);
                final int int_9 = int_7 & 0x1F;
                final int int_10 = (int_7 >> 6) & 0x3;
                ObjectComposition objectcomposition_0;
                if (int_1 == 0) {
                    MapIcon.region.method2889(int_0, int_2, int_3);
                    objectcomposition_0 = FileOnDisk.getObjectDefinition(int_8);
                    if (objectcomposition_0.clipType != 0) {
                        Game.collisionMaps[int_0].removeWall(int_2, int_3, int_9, int_10,
                                objectcomposition_0.blocksProjectile);
                    }
                }

                if (int_1 == 1) {
                    MapIcon.region.method2890(int_0, int_2, int_3);
                }

                if (int_1 == 2) {
                    MapIcon.region.method2891(int_0, int_2, int_3);
                    objectcomposition_0 = FileOnDisk.getObjectDefinition(int_8);
                    if (((int_2 + objectcomposition_0.width) > 103) || ((int_3 + objectcomposition_0.width) > 103)
                            || ((int_2 + objectcomposition_0.length) > 103)
                            || ((int_3 + objectcomposition_0.length) > 103)) {
                        return;
                    }

                    if (objectcomposition_0.clipType != 0) {
                        Game.collisionMaps[int_0].removeObject(int_2, int_3, objectcomposition_0.width,
                                objectcomposition_0.length, int_10, objectcomposition_0.blocksProjectile);
                    }
                }

                if (int_1 == 3) {
                    MapIcon.region.method2971(int_0, int_2, int_3);
                    objectcomposition_0 = FileOnDisk.getObjectDefinition(int_8);
                    if (objectcomposition_0.clipType == 1) {
                        Game.collisionMaps[int_0].method3401(int_2, int_3);
                    }
                }
            }

            if (int_4 >= 0) {
                int_7 = int_0;
                if ((int_0 < 3) && ((class50.tileSettings[1][int_2][int_3] & 0x2) == 2)) {
                    int_7 = int_0 + 1;
                }

                class262.method4939(int_0, int_7, int_2, int_3, int_4, int_5, int_6, MapIcon.region,
                        Game.collisionMaps[int_0]);
            }
        }

    }

    static void method3448() {
        for (int int_0 = 0; int_0 < Game.menuOptionCount; int_0++) {
            if (class173.method3470(Game.menuTypes[int_0])) {
                if (int_0 < (Game.menuOptionCount - 1)) {
                    for (int int_1 = int_0; int_1 < (Game.menuOptionCount - 1); int_1++) {
                        Game.menuOptions[int_1] = Game.menuOptions[int_1 + 1];
                        Game.menuTargets[int_1] = Game.menuTargets[int_1 + 1];
                        Game.menuTypes[int_1] = Game.menuTypes[int_1 + 1];
                        Game.menuIdentifiers[int_1] = Game.menuIdentifiers[int_1 + 1];
                        Game.menuActionParams0[int_1] = Game.menuActionParams0[int_1 + 1];
                        Game.menuActionParams1[int_1] = Game.menuActionParams1[int_1 + 1];
                        Game.menuBooleanArray[int_1] = Game.menuBooleanArray[int_1 + 1];
                    }
                }

                --int_0;
                --Game.menuOptionCount;
            }
        }

        class184.method3785((UrlRequester.field1856 / 2) + MouseInput.menuX, WorldComparator.menuY);
    }

}
