import java.io.IOException;

public final class Item extends Renderable {

    public static class98 field1149;
    static IndexData indexTrack1;
    int id;
    int quantity;

    public Item(int id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public Item() {

    }

    @Override
    protected Model getModel() {
        return TextureProvider.getItemDefinition(id).getModel(quantity);
    }

    static Preferences method1859() {
        FileOnDisk fileondisk_0 = null;
        Preferences preferences_0 = new Preferences();

        try {
            fileondisk_0 = MapLabel.getPreferencesFile("", ItemLayer.field1455.name, false);
            final byte[] bytes_0 = new byte[(int) fileondisk_0.length()];

            int int_1;
            for (int int_0 = 0; int_0 < bytes_0.length; int_0 += int_1) {
                int_1 = fileondisk_0.read(bytes_0, int_0, bytes_0.length - int_0);
                if (int_1 == -1) {
                    throw new IOException();
                }
            }

            preferences_0 = new Preferences(new Buffer(bytes_0));
        } catch (final Exception exception_0) {
        }

        try {
            if (fileondisk_0 != null) {
                fileondisk_0.close();
            }
        } catch (final Exception exception_1) {
        }

        return preferences_0;
    }

    public static void method1866(final int int_0) {
        MouseInput.mouseIdleTicks = int_0;
    }

    public static int method1864(final int int_0) {
        return KeyFocusListener.method673(class120.field1647[int_0]);
    }

    static void method1865(final Actor actor_0) {
        if ((actor_0.field918 == Game.gameCycle) || (actor_0.animation == -1) || (actor_0.actionAnimationDisable != 0)
                || ((actor_0.actionFrameCycle + 1) > TotalQuantityComparator
                .getAnimation(actor_0.animation).frameLengths[actor_0.actionFrame])) {
            final int int_0 = actor_0.field918 - actor_0.field917;
            final int int_1 = Game.gameCycle - actor_0.field917;
            final int int_2 = (actor_0.field913 * 128) + (actor_0.field874 * 64);
            final int int_3 = (actor_0.field915 * 128) + (actor_0.field874 * 64);
            final int int_4 = (actor_0.field916 * 128) + (actor_0.field874 * 64);
            final int int_5 = (actor_0.field929 * 128) + (actor_0.field874 * 64);
            actor_0.x = ((int_1 * int_4) + (int_2 * (int_0 - int_1))) / int_0;
            actor_0.y = ((int_1 * int_5) + (int_3 * (int_0 - int_1))) / int_0;
        }

        actor_0.field923 = 0;
        actor_0.orientation = actor_0.field919;
        actor_0.angle = actor_0.orientation;
    }

}
