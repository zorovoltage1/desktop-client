public class SoundTask implements Runnable {

    static IndexData configsIndex;
    AbstractSoundSystem[] systems;

    SoundTask() {
        systems = new AbstractSoundSystem[2];
    }

    @Override
    public void run() {
        try {
            for (int int_0 = 0; int_0 < 2; int_0++) {
                final AbstractSoundSystem abstractsoundsystem_0 = systems[int_0];
                if (abstractsoundsystem_0 != null) {
                    abstractsoundsystem_0.method2144();
                }
            }
        } catch (final Exception exception_0) {
            UnitPriceComparator.processClientError(null, exception_0);
        }

    }

    public static boolean method2214(final int int_0, final int int_1) {
        return ((int_0 >> (int_1 + 1)) & 0x1) != 0;
    }

    public static byte[] toByteArray(final Object object_0, final boolean bool_0) {
        if (object_0 == null) {
            return null;
        } else if (object_0 instanceof byte[]) {
            final byte[] bytes_0 = ((byte[]) object_0);
            return bool_0 ? class59.method1075(bytes_0) : bytes_0;
        } else if (object_0 instanceof AbstractByteBuffer) {
            final AbstractByteBuffer abstractbytebuffer_0 = (AbstractByteBuffer) object_0;
            return abstractbytebuffer_0.get();
        } else {
            throw new IllegalArgumentException();
        }
    }

    static void method2213() {
        Game.field626.close();
        class54.clear();
        MapIcon.region.reset();

        for (int int_0 = 0; int_0 < 4; int_0++) {
            Game.collisionMaps[int_0].reset();
        }

        System.gc();
        class26.method427(2);
        Game.field812 = -1;
        Game.field813 = false;

        for (class68 class68_0 = (class68) class68.field985
                .getFront(); class68_0 != null; class68_0 = (class68) class68.field985.getNext()) {
            if (class68_0.field993 != null) {
                MapIconReference.field310.method2009(class68_0.field993);
                class68_0.field993 = null;
            }

            if (class68_0.field980 != null) {
                MapIconReference.field310.method2009(class68_0.field980);
                class68_0.field980 = null;
            }
        }

        class68.field985.clear();
        MouseInput.setGameState(10);
    }

    static void method2215() {
        if (class21.field175 != null) {
            Game.field650 = Game.gameCycle;
            class21.field175.method4774();

            for (int int_0 = 0; int_0 < Game.cachedPlayers.length; int_0++) {
                if (Game.cachedPlayers[int_0] != null) {
                    class21.field175.method4773((Game.cachedPlayers[int_0].x >> 7) + PendingSpawn.baseX,
                            (Game.cachedPlayers[int_0].y >> 7) + Game.baseY);
                }
            }
        }

    }

}
