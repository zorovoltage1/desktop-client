import java.applet.Applet;

public class class45 {

    static Applet field378;
    static String field379;

    static {
        field378 = null;
        field379 = "";
    }

    static void method747(final int int_0, final int int_1, final int int_2, final int int_3, final String string_0) {
        final Widget widget_0 = class146.getWidgetChild(int_1, int_2);
        if (widget_0 != null) {
            if (widget_0.onOpListener != null) {
                final ScriptEvent scriptevent_0 = new ScriptEvent();
                scriptevent_0.widget = widget_0;
                scriptevent_0.field517 = int_0;
                scriptevent_0.string = string_0;
                scriptevent_0.objs = widget_0.onOpListener;
                class68.method1696(scriptevent_0);
            }
            ClanSettingsInterface.update(widget_0, int_0);
            boolean bool_0 = true;
            if (widget_0.contentType > 0) {
                bool_0 = class25.method426(widget_0);
            }

            if (bool_0) {
                final int int_4 = class24.getWidgetClickMask(widget_0);
                final int int_5 = int_0 - 1;
                final boolean bool_1 = ((int_4 >> (int_5 + 1)) & 0x1) != 0;
                if (bool_1) {
                    PacketNode packetNode;
                    if (int_0 == 1) {
                        packetNode = class26.method433(ClientPacket.INTERFACE_ACTION_1, Game.field626.field1218);
                        packetNode.packetBuffer.putInt(int_1);
                        packetNode.packetBuffer.putShort(int_2);
                        packetNode.packetBuffer.putShort(int_3);
                        Game.field626.method1980(packetNode);
                    }

                    if (int_0 == 2) {
                        packetNode = class26.method433(ClientPacket.INTERFACE_ACTION_2, Game.field626.field1218);
                        packetNode.packetBuffer.putInt(int_1);
                        packetNode.packetBuffer.putShort(int_2);
                        packetNode.packetBuffer.putShort(int_3);
                        Game.field626.method1980(packetNode);
                    }

                    if (int_0 == 3) {
                        packetNode = class26.method433(ClientPacket.INTERFACE_ACTION_3, Game.field626.field1218);
                        packetNode.packetBuffer.putInt(int_1);
                        packetNode.packetBuffer.putShort(int_2);
                        packetNode.packetBuffer.putShort(int_3);
                        Game.field626.method1980(packetNode);
                    }

                    if (int_0 == 4) {
                        packetNode = class26.method433(ClientPacket.INTERFACE_ACTION_4, Game.field626.field1218);
                        packetNode.packetBuffer.putInt(int_1);
                        packetNode.packetBuffer.putShort(int_2);
                        packetNode.packetBuffer.putShort(int_3);
                        Game.field626.method1980(packetNode);
                    }

                    if (int_0 == 5) {
                        packetNode = class26.method433(ClientPacket.INTERFACE_ACTION_5, Game.field626.field1218);
                        packetNode.packetBuffer.putInt(int_1);
                        packetNode.packetBuffer.putShort(int_2);
                        packetNode.packetBuffer.putShort(int_3);
                        Game.field626.method1980(packetNode);
                    }

                    if (int_0 == 6) {
                        packetNode = class26.method433(ClientPacket.INTERFACE_ACTION_6, Game.field626.field1218);
                        packetNode.packetBuffer.putInt(int_1);
                        packetNode.packetBuffer.putShort(int_2);
                        packetNode.packetBuffer.putShort(int_3);
                        Game.field626.method1980(packetNode);
                    }

                    if (int_0 == 7) {
                        packetNode = class26.method433(ClientPacket.INTERFACE_ACTION_7, Game.field626.field1218);
                        packetNode.packetBuffer.putInt(int_1);
                        packetNode.packetBuffer.putShort(int_2);
                        packetNode.packetBuffer.putShort(int_3);
                        Game.field626.method1980(packetNode);
                    }

                    if (int_0 == 8) {
                        packetNode = class26.method433(ClientPacket.INTERFACE_ACTION_8, Game.field626.field1218);
                        packetNode.packetBuffer.putInt(int_1);
                        packetNode.packetBuffer.putShort(int_2);
                        packetNode.packetBuffer.putShort(int_3);
                        Game.field626.method1980(packetNode);
                    }

                    if (int_0 == 9) {
                        packetNode = class26.method433(ClientPacket.INTERFACE_ACTION_9, Game.field626.field1218);
                        packetNode.packetBuffer.putInt(int_1);
                        packetNode.packetBuffer.putShort(int_2);
                        packetNode.packetBuffer.putShort(int_3);
                        Game.field626.method1980(packetNode);
                    }

                    if (int_0 == 10) {
                        packetNode = class26.method433(ClientPacket.INTERFACE_ACTION_10, Game.field626.field1218);
                        packetNode.packetBuffer.putInt(int_1);
                        packetNode.packetBuffer.putShort(int_2);
                        packetNode.packetBuffer.putShort(int_3);
                        Game.field626.method1980(packetNode);
                    }

                }
            }
        }
    }

    static void method749(final int int_0) {
        FontName.method5501();
        class6.method75();
        final int int_1 = Actor.method1549(int_0).configType;
        if (int_1 != 0) {
            final int int_2 = class225.clientVarps[int_0];
            if (int_1 == 1) {
                if (int_2 == 1) {
                    Graphics3D.setBrightness(0.9D);
                    ((TextureProvider) Graphics3D.textureLoader).brightness(0.9D);
                }

                if (int_2 == 2) {
                    Graphics3D.setBrightness(0.8D);
                    ((TextureProvider) Graphics3D.textureLoader).brightness(0.8D);
                }

                if (int_2 == 3) {
                    Graphics3D.setBrightness(0.7D);
                    ((TextureProvider) Graphics3D.textureLoader).brightness(0.7D);
                }

                if (int_2 == 4) {
                    Graphics3D.setBrightness(0.6D);
                    ((TextureProvider) Graphics3D.textureLoader).brightness(0.6D);
                }

                ItemComposition.itemSpriteCache.reset();
            }

            if (int_1 == 3) {
                short short_0 = 0;
                if (int_2 == 0) {
                    short_0 = 255;
                }

                if (int_2 == 1) {
                    short_0 = 192;
                }

                if (int_2 == 2) {
                    short_0 = 128;
                }

                if (int_2 == 3) {
                    short_0 = 64;
                }

                if (int_2 == 4) {
                    short_0 = 0;
                }

                if (short_0 != Game.field811) {
                    if ((Game.field811 == 0) && (Game.field812 != -1)) {
                        Actor.method1554(Item.indexTrack1, Game.field812, 0, short_0, false);
                        Game.field813 = false;
                    } else if (short_0 == 0) {
                        class9.method88();
                        Game.field813 = false;
                    } else if (class217.field2460 != 0) {
                        class309.field3740 = short_0;
                    } else {
                        class217.field2459.method4236(short_0);
                    }

                    Game.field811 = short_0;
                }
            }

            if (int_1 == 4) {
                if (int_2 == 0) {
                    Game.field814 = 127;
                }

                if (int_2 == 1) {
                    Game.field814 = 96;
                }

                if (int_2 == 2) {
                    Game.field814 = 64;
                }

                if (int_2 == 3) {
                    Game.field814 = 32;
                }

                if (int_2 == 4) {
                    Game.field814 = 0;
                }
            }

            if (int_1 == 5) {
                Game.field715 = int_2;
            }

            if (int_1 == 6) {
                Game.field742 = int_2;
            }

            if (int_1 == 9) {
                Game.field743 = int_2;
            }

            if (int_1 == 10) {
                if (int_2 == 0) {
                    Game.field815 = 127;
                }

                if (int_2 == 1) {
                    Game.field815 = 96;
                }

                if (int_2 == 2) {
                    Game.field815 = 64;
                }

                if (int_2 == 3) {
                    Game.field815 = 32;
                }

                if (int_2 == 4) {
                    Game.field815 = 0;
                }
            }

            if (int_1 == 17) {
                Game.field748 = int_2 & 0xFFFF;
            }

            AttackOption[] attackoptions_0;
            if (int_1 == 18) {
                attackoptions_0 = new AttackOption[]{AttackOption.AttackOption_dependsOnCombatLevels,
                        AttackOption.AttackOption_hidden, AttackOption.AttackOption_alwaysRightClick,
                        AttackOption.AttackOption_leftClickWhereAvailable};
                Game.playerAttackOption = (AttackOption) class76.forOrdinal(attackoptions_0, int_2);
                if (Game.playerAttackOption == null) {
                    Game.playerAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
                }
            }

            if (int_1 == 19) {
                if (int_2 == -1) {
                    Game.field707 = -1;
                } else {
                    Game.field707 = int_2 & 0x7FF;
                }
            }

            if (int_1 == 22) {
                attackoptions_0 = new AttackOption[]{AttackOption.AttackOption_dependsOnCombatLevels,
                        AttackOption.AttackOption_hidden, AttackOption.AttackOption_alwaysRightClick,
                        AttackOption.AttackOption_leftClickWhereAvailable};
                Game.npcAttackOption = (AttackOption) class76.forOrdinal(attackoptions_0, int_2);
                if (Game.npcAttackOption == null) {
                    Game.npcAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
                }
            }

        }
    }

}
