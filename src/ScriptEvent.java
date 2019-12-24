import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ScriptEvent extends Node {

    Object[] objs;
    boolean boolean1;
    Widget widget;
    int field511;
    int field508;
    int field517;
    Widget field507;
    int pressedKey;
    int typedKey;
    String string;
    int field514;
    int field515;

    public ScriptEvent() {
        field515 = 76;
    }

    public void method1024(final Object[] objects_0) {
        objs = objects_0;
    }

    public void method1025(final int int_0) {
        field515 = int_0;
    }

    static void method1030(final boolean bool_0) {
        class78.loginMessage1 = "";
        class78.loginMessage2 = "Enter your username/email & password.";
        class78.loginMessage3 = "";
        class78.loginIndex = 2;
        if (bool_0) {
            class78.password = "";
        }

        if ((class78.username == null) || (class78.username.length() <= 0)) {
            if (class10.preferences.rememberedUsername != null) {
                class78.username = class10.preferences.rememberedUsername;
                class78.Login_isUsernameRemembered = true;
            } else {
                class78.Login_isUsernameRemembered = false;
            }
        }

        class34.method586();
    }

    static void method1031(final String string_0) {
        if (string_0.equalsIgnoreCase("toggleroof")) {
            class10.preferences.hideRoofs = !class10.preferences.hideRoofs;
            class54.method1018();
            if (class10.preferences.hideRoofs) {
                class143.sendGameMessage(99, "", "Roofs are now all hidden");
            } else {
                class143.sendGameMessage(99, "", "Roofs will only be removed selectively");
            }
        }

        if(string_0.equalsIgnoreCase("dumpsprites")) {
            for (int id = 0; id < 65535; id++) {
                BufferedImage img = RuinUtils.getItemImage(id);
                if (img != null) try {
                    ImageIO.write(img, "png", new File(System.getProperty("user.home") + "/Desktop/sprites/" + id + ".png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if (string_0.equalsIgnoreCase("displayfps")) {
            Game.displayFps = !Game.displayFps;
        }

        if(string_0.equalsIgnoreCase("icons")) {
            RuinUtils.loadIcons(true);
        }

        if (string_0.equalsIgnoreCase("renderself")) {
            Game.field699 = !Game.field699;
        }

        if (string_0.equalsIgnoreCase("mouseovertext")) {
            Game.field728 = !Game.field728;
        }

        if (Game.rights >= 2) {
            if (string_0.equalsIgnoreCase("camera")) {
                Game.field655 = 1;
            }

            if (string_0.equalsIgnoreCase("showcoord")) {
                ItemContainer.renderOverview.field3839 = !ItemContainer.renderOverview.field3839;
            }

            if (string_0.equalsIgnoreCase("fpson")) {
                Game.displayFps = true;
            }

            if (string_0.equalsIgnoreCase("fpsoff")) {
                Game.displayFps = false;
            }

            if (string_0.equalsIgnoreCase("gc")) {
                System.gc();
            }

            if (string_0.equalsIgnoreCase("clientdrop")) {
                WorldMapManager.method516();
            }
        }

        final PacketNode packetnode_0 = class26.method433(ClientPacket.CLIENT_COMMAND, Game.field626.field1218);
        packetnode_0.packetBuffer.putByte(string_0.length() + 1);
        packetnode_0.packetBuffer.putString(string_0);
        Game.field626.method1980(packetnode_0);
    }

    static void method1027(final Widget widget_0, final ItemComposition itemcomposition_0, final int int_0,
                           final int int_1, final boolean bool_0) {
        final String[] strings_0 = itemcomposition_0.inventoryActions;
        byte byte_0 = -1;
        String string_0 = null;
        if ((strings_0 != null) && (strings_0[int_1] != null)) {
            if (int_1 == 0) {
                byte_0 = 33;
            } else if (int_1 == 1) {
                byte_0 = 34;
            } else if (int_1 == 2) {
                byte_0 = 35;
            } else if (int_1 == 3) {
                byte_0 = 36;
            } else {
                byte_0 = 37;
            }

            string_0 = strings_0[int_1];
        } else if (int_1 == 4) {
            byte_0 = 37;
            string_0 = "Drop";
        }

        if ((byte_0 != -1) && (string_0 != null)) {
            BuildType.method4612(string_0, class6.getColTags(16748608) + itemcomposition_0.name, byte_0,
                    itemcomposition_0.id, int_0, widget_0.interfaceHash, bool_0);
        }

    }

}
