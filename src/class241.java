public final class class241 {

    public static class264 method4603(final int int_0) {
        class264 class264_0 = (class264) class264.field3328.get(int_0);
        if (class264_0 != null) {
            return class264_0;
        } else {
            final byte[] bytes_0 = class264.field3327.getConfigData(11, int_0);
            class264_0 = new class264();
            if (bytes_0 != null) {
                class264_0.method4948(new Buffer(bytes_0));
            }

            class264_0.method4954();
            class264.field3328.put(class264_0, int_0);
            return class264_0;
        }
    }

    static void method4602(final int int_0, final int int_1, final int int_2, final int int_3, final int int_4,
                           final int int_5, final int int_6, final int int_7, final int int_8) {
        PendingSpawn pendingspawn_0 = null;

        for (PendingSpawn pendingspawn_1 = (PendingSpawn) Game.pendingSpawns.getFront(); pendingspawn_1 != null; pendingspawn_1 = (PendingSpawn) Game.pendingSpawns.getNext()) {
            if ((int_0 == pendingspawn_1.level) && (pendingspawn_1.x == int_1) && (int_2 == pendingspawn_1.y)
                    && (int_3 == pendingspawn_1.type)) {
                pendingspawn_0 = pendingspawn_1;
                break;
            }
        }

        if (pendingspawn_0 == null) {
            pendingspawn_0 = new PendingSpawn();
            pendingspawn_0.level = int_0;
            pendingspawn_0.type = int_3;
            pendingspawn_0.x = int_1;
            pendingspawn_0.y = int_2;
            class74.method1800(pendingspawn_0);
            Game.pendingSpawns.addFront(pendingspawn_0);
        }

        pendingspawn_0.id = int_4;
        pendingspawn_0.field864 = int_5;
        pendingspawn_0.orientation = int_6;
        pendingspawn_0.delay = int_7;
        pendingspawn_0.hitpoints = int_8;
    }

}
