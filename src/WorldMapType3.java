import java.io.IOException;

public class WorldMapType3 implements WorldMapSectionBase {

    static ClanMemberManager clanMemberManager;
    static int field104;
    int field100;
    int field90;
    int field91;
    int field102;
    int field93;
    int field96;
    int field95;
    int field105;
    int field97;
    int field98;
    int field99;
    int field89;
    int field101;
    int field103;

    @Override
    public void vmethod635(final WorldMapData worldmapdata_0) {
        if (worldmapdata_0.minX > field93) {
            worldmapdata_0.minX = field93;
        }

        if (worldmapdata_0.field167 < field93) {
            worldmapdata_0.field167 = field93;
        }

        if (worldmapdata_0.minY > field96) {
            worldmapdata_0.minY = field96;
        }

        if (worldmapdata_0.field162 < field96) {
            worldmapdata_0.field162 = field96;
        }

    }

    @Override
    public boolean containsCoord(final int int_0, final int int_1, final int int_2) {
        return ((int_0 >= field100) && (int_0 < (field90 + field100))) && ((int_1 >= ((field91 << 6) + (field95 << 3)))
                && (int_1 <= ((field91 << 6) + (field97 << 3) + 7)) && (int_2 >= ((field102 << 6) + (field105 << 3)))
                && (int_2 <= ((field102 << 6) + (field98 << 3) + 7)));
    }

    @Override
    public boolean vmethod637(final int int_0, final int int_1) {
        return (int_0 >= ((field93 << 6) + (field99 << 3))) && (int_0 <= ((field93 << 6) + (field101 << 3) + 7))
                && (int_1 >= ((field96 << 6) + (field89 << 3))) && (int_1 <= ((field96 << 6) + (field103 << 3) + 7));
    }

    @Override
    public int[] vmethod638(final int int_0, final int int_1, final int int_2) {
        if (!containsCoord(int_0, int_1, int_2)) {
            return null;
        } else {
            final int[] ints_0 = new int[]{
                    ((field93 * 64) - (field91 * 64)) + int_1 + ((field99 * 8) - (field95 * 8)),
                    int_2 + ((field96 * 64) - (field102 * 64)) + ((field89 * 8) - (field105 * 8))};
            return ints_0;
        }
    }

    @Override
    public Coordinates vmethod659(final int int_0, final int int_1) {
        if (!vmethod637(int_0, int_1)) {
            return null;
        } else {
            final int int_2 = ((field91 * 64) - (field93 * 64)) + ((field95 * 8) - (field99 * 8)) + int_0;
            final int int_3 = ((field102 * 64) - (field96 * 64)) + int_1 + ((field105 * 8) - (field89 * 8));
            return new Coordinates(field100, int_2, int_3);
        }
    }

    @Override
    public void vmethod639(final Buffer buffer_0) {
        field100 = buffer_0.readUnsignedByte();
        field90 = buffer_0.readUnsignedByte();
        field91 = buffer_0.readUnsignedShort();
        field95 = buffer_0.readUnsignedByte();
        field97 = buffer_0.readUnsignedByte();
        field102 = buffer_0.readUnsignedShort();
        field105 = buffer_0.readUnsignedByte();
        field98 = buffer_0.readUnsignedByte();
        field93 = buffer_0.readUnsignedShort();
        field99 = buffer_0.readUnsignedByte();
        field101 = buffer_0.readUnsignedByte();
        field96 = buffer_0.readUnsignedShort();
        field89 = buffer_0.readUnsignedByte();
        field103 = buffer_0.readUnsignedByte();
        method121();
    }

    void method121() {
    }

    public static class267 method123(final int int_0) {
        class267 class267_0 = (class267) class267.field3349.get(int_0);
        if (class267_0 != null) {
            return class267_0;
        } else {
            final byte[] bytes_0 = class267.field3367.getConfigData(32, int_0);
            class267_0 = new class267();
            if (bytes_0 != null) {
                class267_0.method4990(new Buffer(bytes_0));
            }

            class267.field3349.put(class267_0, int_0);
            return class267_0;
        }
    }

    static int method139(final int int_0, final Script script_0, final boolean bool_0) {
        if (int_0 == 5000) {
            class69.intStack[++class69.intStackSize - 1] = Game.publicChatMode;
            return 1;
        } else if (int_0 == 5001) {
            class69.intStackSize -= 3;
            Game.publicChatMode = class69.intStack[class69.intStackSize];
            class143.field1899 = PacketBuffer.method3847(class69.intStack[class69.intStackSize + 1]);
            if (class143.field1899 == null) {
                class143.field1899 = class307.field3734;
            }

            Game.field795 = class69.intStack[class69.intStackSize + 2];
            final PacketNode packetnode_3 = class26.method433(ClientPacket.SETTINGS, Game.field626.field1218);
            packetnode_3.packetBuffer.putByte(Game.publicChatMode);
            packetnode_3.packetBuffer.putByte(class143.field1899.field3735);
            packetnode_3.packetBuffer.putByte(Game.field795);
            Game.field626.method1980(packetnode_3);
            return 1;
        } else {
            String string_0;
            int int_1;
            int int_2;
            if (int_0 == 5002) {
                string_0 = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
                class69.intStackSize -= 2;
                int_1 = class69.intStack[class69.intStackSize];
                int_2 = class69.intStack[class69.intStackSize + 1];
                final PacketNode packetnode_2 = class26.method433(ClientPacket.field2185, Game.field626.field1218);
                packetnode_2.packetBuffer.putByte(class316.getLength(string_0) + 2);
                packetnode_2.packetBuffer.putString(string_0);
                packetnode_2.packetBuffer.putByte(int_1 - 1);
                packetnode_2.packetBuffer.putByte(int_2);
                Game.field626.method1980(packetnode_2);
                return 1;
            } else {
                int int_3;
                if (int_0 == 5003) {
                    class69.intStackSize -= 2;
                    int_3 = class69.intStack[class69.intStackSize];
                    int_1 = class69.intStack[class69.intStackSize + 1];
                    final ChatLineBuffer chatlinebuffer_0 = (ChatLineBuffer) class83.chatLineMap
                            .get(Integer.valueOf(int_3));
                    final MessageNode messagenode_1 = chatlinebuffer_0.getMessage(int_1);
                    if (messagenode_1 != null) {
                        class69.intStack[++class69.intStackSize - 1] = messagenode_1.id;
                        class69.intStack[++class69.intStackSize - 1] = messagenode_1.tick;
                        class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = messagenode_1.name != null
                                ? messagenode_1.name
                                : "";
                        class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = messagenode_1.sender != null
                                ? messagenode_1.sender
                                : "";
                        class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = messagenode_1.value != null
                                ? messagenode_1.value
                                : "";
                        class69.intStack[++class69.intStackSize - 1] = messagenode_1.method1040() ? 1
                                : (messagenode_1.method1043() ? 2 : 0);
                    } else {
                        class69.intStack[++class69.intStackSize - 1] = -1;
                        class69.intStack[++class69.intStackSize - 1] = 0;
                        class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = "";
                        class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = "";
                        class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = "";
                        class69.intStack[++class69.intStackSize - 1] = 0;
                    }

                    return 1;
                } else if (int_0 == 5004) {
                    int_3 = class69.intStack[--class69.intStackSize];
                    final MessageNode messagenode_2 = OwnWorldComparator.method1130(int_3);
                    if (messagenode_2 != null) {
                        class69.intStack[++class69.intStackSize - 1] = messagenode_2.type;
                        class69.intStack[++class69.intStackSize - 1] = messagenode_2.tick;
                        class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = messagenode_2.name != null
                                ? messagenode_2.name
                                : "";
                        class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = messagenode_2.sender != null
                                ? messagenode_2.sender
                                : "";
                        class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = messagenode_2.value != null
                                ? messagenode_2.value
                                : "";
                        class69.intStack[++class69.intStackSize - 1] = messagenode_2.method1040() ? 1
                                : (messagenode_2.method1043() ? 2 : 0);
                    } else {
                        class69.intStack[++class69.intStackSize - 1] = -1;
                        class69.intStack[++class69.intStackSize - 1] = 0;
                        class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = "";
                        class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = "";
                        class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = "";
                        class69.intStack[++class69.intStackSize - 1] = 0;
                    }

                    return 1;
                } else if (int_0 == 5005) {
                    if (class143.field1899 == null) {
                        class69.intStack[++class69.intStackSize - 1] = -1;
                    } else {
                        class69.intStack[++class69.intStackSize - 1] = class143.field1899.field3735;
                    }

                    return 1;
                } else if (int_0 == 5008) {
                    string_0 = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
                    int_1 = class69.intStack[--class69.intStackSize];
                    String string_1 = string_0.toLowerCase();
                    byte byte_1 = 0;
                    if (string_1.startsWith("yellow:")) {
                        byte_1 = 0;
                        string_0 = string_0.substring("yellow:".length());
                    } else if (string_1.startsWith("red:")) {
                        byte_1 = 1;
                        string_0 = string_0.substring("red:".length());
                    } else if (string_1.startsWith("green:")) {
                        byte_1 = 2;
                        string_0 = string_0.substring("green:".length());
                    } else if (string_1.startsWith("cyan:")) {
                        byte_1 = 3;
                        string_0 = string_0.substring("cyan:".length());
                    } else if (string_1.startsWith("purple:")) {
                        byte_1 = 4;
                        string_0 = string_0.substring("purple:".length());
                    } else if (string_1.startsWith("white:")) {
                        byte_1 = 5;
                        string_0 = string_0.substring("white:".length());
                    } else if (string_1.startsWith("flash1:")) {
                        byte_1 = 6;
                        string_0 = string_0.substring("flash1:".length());
                    } else if (string_1.startsWith("flash2:")) {
                        byte_1 = 7;
                        string_0 = string_0.substring("flash2:".length());
                    } else if (string_1.startsWith("flash3:")) {
                        byte_1 = 8;
                        string_0 = string_0.substring("flash3:".length());
                    } else if (string_1.startsWith("glow1:")) {
                        byte_1 = 9;
                        string_0 = string_0.substring("glow1:".length());
                    } else if (string_1.startsWith("glow2:")) {
                        byte_1 = 10;
                        string_0 = string_0.substring("glow2:".length());
                    } else if (string_1.startsWith("glow3:")) {
                        byte_1 = 11;
                        string_0 = string_0.substring("glow3:".length());
                    } else if (Game.languageId != 0) {
                        if (string_1.startsWith("yellow:")) {
                            byte_1 = 0;
                            string_0 = string_0.substring("yellow:".length());
                        } else if (string_1.startsWith("red:")) {
                            byte_1 = 1;
                            string_0 = string_0.substring("red:".length());
                        } else if (string_1.startsWith("green:")) {
                            byte_1 = 2;
                            string_0 = string_0.substring("green:".length());
                        } else if (string_1.startsWith("cyan:")) {
                            byte_1 = 3;
                            string_0 = string_0.substring("cyan:".length());
                        } else if (string_1.startsWith("purple:")) {
                            byte_1 = 4;
                            string_0 = string_0.substring("purple:".length());
                        } else if (string_1.startsWith("white:")) {
                            byte_1 = 5;
                            string_0 = string_0.substring("white:".length());
                        } else if (string_1.startsWith("flash1:")) {
                            byte_1 = 6;
                            string_0 = string_0.substring("flash1:".length());
                        } else if (string_1.startsWith("flash2:")) {
                            byte_1 = 7;
                            string_0 = string_0.substring("flash2:".length());
                        } else if (string_1.startsWith("flash3:")) {
                            byte_1 = 8;
                            string_0 = string_0.substring("flash3:".length());
                        } else if (string_1.startsWith("glow1:")) {
                            byte_1 = 9;
                            string_0 = string_0.substring("glow1:".length());
                        } else if (string_1.startsWith("glow2:")) {
                            byte_1 = 10;
                            string_0 = string_0.substring("glow2:".length());
                        } else if (string_1.startsWith("glow3:")) {
                            byte_1 = 11;
                            string_0 = string_0.substring("glow3:".length());
                        }
                    }

                    string_1 = string_0.toLowerCase();
                    byte byte_0 = 0;
                    if (string_1.startsWith("wave:")) {
                        byte_0 = 1;
                        string_0 = string_0.substring("wave:".length());
                    } else if (string_1.startsWith("wave2:")) {
                        byte_0 = 2;
                        string_0 = string_0.substring("wave2:".length());
                    } else if (string_1.startsWith("shake:")) {
                        byte_0 = 3;
                        string_0 = string_0.substring("shake:".length());
                    } else if (string_1.startsWith("scroll:")) {
                        byte_0 = 4;
                        string_0 = string_0.substring("scroll:".length());
                    } else if (string_1.startsWith("slide:")) {
                        byte_0 = 5;
                        string_0 = string_0.substring("slide:".length());
                    } else if (Game.languageId != 0) {
                        if (string_1.startsWith("wave:")) {
                            byte_0 = 1;
                            string_0 = string_0.substring("wave:".length());
                        } else if (string_1.startsWith("wave2:")) {
                            byte_0 = 2;
                            string_0 = string_0.substring("wave2:".length());
                        } else if (string_1.startsWith("shake:")) {
                            byte_0 = 3;
                            string_0 = string_0.substring("shake:".length());
                        } else if (string_1.startsWith("scroll:")) {
                            byte_0 = 4;
                            string_0 = string_0.substring("scroll:".length());
                        } else if (string_1.startsWith("slide:")) {
                            byte_0 = 5;
                            string_0 = string_0.substring("slide:".length());
                        }
                    }

                    final PacketNode packetnode_1 = class26.method433(ClientPacket.CHATBOX_INPUT, Game.field626.field1218);
                    packetnode_1.packetBuffer.putByte(0);
                    final int int_5 = packetnode_1.packetBuffer.offset;
                    packetnode_1.packetBuffer.putByte(int_1);
                    packetnode_1.packetBuffer.putByte(byte_1);
                    packetnode_1.packetBuffer.putByte(byte_0);
                    PacketBuffer.method3840(packetnode_1.packetBuffer, string_0);
                    packetnode_1.packetBuffer.method3545(packetnode_1.packetBuffer.offset - int_5);
                    Game.field626.method1980(packetnode_1);
                    return 1;
                } else {
                    int int_4;
                    if (int_0 == 5009) {
                        WidgetNode.scriptStringStackSize -= 2;
                        string_0 = class69.scriptStringStack[WidgetNode.scriptStringStackSize];
                        final String string_2 = class69.scriptStringStack[WidgetNode.scriptStringStackSize + 1];
                        final PacketNode packetnode_0 = class26.method433(ClientPacket.PRIVATE_MESSAGE, Game.field626.field1218);
                        packetnode_0.packetBuffer.putShort(0);
                        int_4 = packetnode_0.packetBuffer.offset;
                        packetnode_0.packetBuffer.putString(string_0);
                        PacketBuffer.method3840(packetnode_0.packetBuffer, string_2);
                        packetnode_0.packetBuffer.method3614(packetnode_0.packetBuffer.offset - int_4);
                        Game.field626.method1980(packetnode_0);
                        return 1;
                    } else if (int_0 != 5015) {
                        if (int_0 == 5016) {
                            class69.intStack[++class69.intStackSize - 1] = Game.field795;
                            return 1;
                        } else {
                            int[] ints_0;
                            if (int_0 == 5017) {
                                int_3 = class69.intStack[--class69.intStackSize];
                                ints_0 = class69.intStack;
                                int_2 = ++class69.intStackSize - 1;
                                final ChatLineBuffer chatlinebuffer_1 = (ChatLineBuffer) class83.chatLineMap
                                        .get(Integer.valueOf(int_3));
                                if (chatlinebuffer_1 == null) {
                                    int_4 = 0;
                                } else {
                                    int_4 = chatlinebuffer_1.size();
                                }

                                ints_0[int_2] = int_4;
                                return 1;
                            } else if (int_0 == 5018) {
                                int_3 = class69.intStack[--class69.intStackSize];
                                class69.intStack[++class69.intStackSize - 1] = Preferences.method1621(int_3);
                                return 1;
                            } else if (int_0 == 5019) {
                                int_3 = class69.intStack[--class69.intStackSize];
                                ints_0 = class69.intStack;
                                int_2 = ++class69.intStackSize - 1;
                                final MessageNode messagenode_0 = (MessageNode) class83.messages.get(int_3);
                                if (messagenode_0 == null) {
                                    int_4 = -1;
                                } else if (messagenode_0.next == class83.field1184.sentinel) {
                                    int_4 = -1;
                                } else {
                                    int_4 = ((MessageNode) messagenode_0.next).id;
                                }

                                ints_0[int_2] = int_4;
                                return 1;
                            } else if (int_0 == 5020) {
                                string_0 = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
                                ScriptEvent.method1031(string_0);
                                return 1;
                            } else if (int_0 == 5021) {
                                Game.field796 = class69.scriptStringStack[--WidgetNode.scriptStringStackSize]
                                        .toLowerCase().trim();
                                return 1;
                            } else if (int_0 == 5022) {
                                class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = Game.field796;
                                return 1;
                            } else {
                                return 2;
                            }
                        }
                    } else {
                        if ((class138.localPlayer != null) && (class138.localPlayer.name != null)) {
                            string_0 = class138.localPlayer.getName(true);
                        } else {
                            string_0 = "";
                        }

                        class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = string_0;
                        return 1;
                    }
                }
            }
        }
    }

    static void flush(final boolean bool_0) {
        class54.method1017();
        ++Game.field626.field1224;
        if ((Game.field626.field1224 >= 50) || bool_0) {
            Game.field626.field1224 = 0;
            if (!Game.socketError && (Game.field626.getSocket() != null)) {
                final PacketNode packetnode_0 = class26.method433(ClientPacket.field2211, Game.field626.field1218);
                Game.field626.method1980(packetnode_0);

                try {
                    Game.field626.method1979();
                } catch (final IOException ioexception_0) {
                    Game.socketError = true;
                }
            }

        }
    }

}
