public class FriendManager {

    static int field978;
    static int[][] xteaKeys;
    final JagexLoginType field974;
    public final class290 field970;
    public final class284 field975;
    int field976;

    FriendManager(final JagexLoginType jagexlogintype_0) {
        field976 = 0;
        field974 = jagexlogintype_0;
        field970 = new class290(jagexlogintype_0);
        field975 = new class284(jagexlogintype_0);
    }

    boolean method1624() {
        return field976 == 2;
    }

    void method1625() {
        field976 = 1;
    }

    void method1679(final Buffer buffer_0, final int int_0) {
        field970.method5424(buffer_0, int_0);
        field976 = 2;
        ItemContainer.method1012();
    }

    void method1627() {
        for (class294 class294_0 = (class294) field970.field3639
                .method4111(); class294_0 != null; class294_0 = (class294) field970.field3639.method4114()) {
            if (class294_0.field3665 < ((Buffer.safeCurrentTimeMillis() / 1000L) - 5L)) {
                if (class294_0.field3664 > 0) {
                    class143.sendGameMessage(5, "", class294_0.field3662 + " has logged in.");
                }

                if (class294_0.field3664 == 0) {
                    class143.sendGameMessage(5, "", class294_0.field3662 + " has logged out.");
                }

                class294_0.method4121();
            }
        }

    }

    void method1628() {
        field976 = 0;
        field970.method5326();
        field975.method5326();
    }

    boolean isFriended(final Name name_0, final boolean bool_0) {
        return name_0 != null && (name_0.equals(class138.localPlayer.name) || field970.method5423(name_0, bool_0));
    }

    boolean isIgnored(final Name name_0) {
        return name_0 != null && field975.isMember(name_0);
    }

    void addToFriendsList(final String string_0) {
        if (string_0 != null) {
            final Name name_0 = new Name(string_0, field974);
            if (name_0.isCleanNameValid()) {
                String string_1;
                if (isFriendsListFull()) {
                    string_1 = "Your friend list is full. Max of 200 for free users, and 400 for members";
                    class143.sendGameMessage(30, "", string_1);
                } else if (class138.localPlayer.name.equals(name_0)) {
                    string_1 = "You can\'t add yourself to your own friend list";
                    class143.sendGameMessage(30, "", string_1);
                } else if (isFriended(name_0, false)) {
                    WorldMapDecorationType.method4588(string_0);
                } else if (isIgnored(name_0)) {
                    class51.method995(string_0);
                } else {
                    final PacketNode packetnode_0 = class26.method433(ClientPacket.ADD_FRIEND, Game.field626.field1218);
                    packetnode_0.packetBuffer.putByte(class316.getLength(string_0));
                    packetnode_0.packetBuffer.putString(string_0);
                    Game.field626.method1980(packetnode_0);
                }
            }
        }
    }

    boolean isFriendsListFull() {
        return field970.method5328() || ((field970.getCount() >= 200) && (Game.field698 != 1));
    }

    void addToIgnoreList(final String string_0) {
        if (string_0 != null) {
            final Name name_0 = new Name(string_0, field974);
            if (name_0.isCleanNameValid()) {
                if (method1634()) {
                    MapIcon.method475();
                } else {
                    StringBuilder stringbuilder_0;
                    String string_1;
                    if (class138.localPlayer.name.equals(name_0)) {
                        stringbuilder_0 = null;
                        string_1 = "You can\'t add yourself to your own ignore list";
                        class143.sendGameMessage(30, "", string_1);
                    } else if (isIgnored(name_0)) {
                        class21.method271(string_0);
                    } else if (isFriended(name_0, false)) {
                        stringbuilder_0 = new StringBuilder();
                        stringbuilder_0 = stringbuilder_0.append("Please remove ").append(string_0);
                        string_1 = stringbuilder_0.append(" from your friend list first").toString();
                        class143.sendGameMessage(30, "", string_1);
                    } else {
                        final PacketNode packetnode_0 = class26.method433(ClientPacket.ADD_IGNORE, Game.field626.field1218);
                        packetnode_0.packetBuffer.putByte(class316.getLength(string_0));
                        packetnode_0.packetBuffer.putString(string_0);
                        Game.field626.method1980(packetnode_0);
                    }
                }
            }
        }
    }

    boolean method1634() {
        return field975.method5328() || ((field975.getCount() >= 100) && (Game.field698 != 1));
    }

    void method1665(final String string_0) {
        if (string_0 != null) {
            final Name name_0 = new Name(string_0, field974);
            if (name_0.isCleanNameValid()) {
                if (field970.method5393(name_0)) {
                    Game.field647 = Game.cycleCntr;
                    final PacketNode packetnode_0 = class26.method433(ClientPacket.REMOVE_FRIEND, Game.field626.field1218);
                    packetnode_0.packetBuffer.putByte(class316.getLength(string_0));
                    packetnode_0.packetBuffer.putString(string_0);
                    Game.field626.method1980(packetnode_0);
                }

                ItemContainer.method1012();
            }
        }
    }

    void method1636(final String string_0) {
        if (string_0 != null) {
            final Name name_0 = new Name(string_0, field974);
            if (name_0.isCleanNameValid()) {
                if (field975.method5393(name_0)) {
                    Game.field647 = Game.cycleCntr;
                    final PacketNode packetnode_0 = class26.method433(ClientPacket.REMOVE_IGNORE, Game.field626.field1218);
                    packetnode_0.packetBuffer.putByte(class316.getLength(string_0));
                    packetnode_0.packetBuffer.putString(string_0);
                    Game.field626.method1980(packetnode_0);
                }

                GameEngine.method910();
                if (WorldMapType3.clanMemberManager != null) {
                    WorldMapType3.clanMemberManager.method5468();
                }

            }
        }
    }

    boolean method1637(final Name name_0) {
        final Friend friend_0 = (Friend) field970.method5330(name_0);
        return (friend_0 != null) && friend_0.method5415();
    }

    public static boolean method1683(final long long_0) {
        boolean bool_0 = long_0 != 0L;
        if (bool_0) {
            final boolean bool_1 = (int) ((long_0 >>> 16) & 0x1L) == 1;
            bool_0 = !bool_1;
        }

        return bool_0;
    }

    static int method1668(final IterableHashTable iterablehashtable_0, final int int_0, final int int_1) {
        if (iterablehashtable_0 == null) {
            return int_1;
        } else {
            final IntegerNode integernode_0 = (IntegerNode) iterablehashtable_0.get(int_0);
            return integernode_0 == null ? int_1 : integernode_0.value;
        }
    }

    public static void method1685(final int int_0, int int_1) {
        Varbit varbit_0 = (Varbit) Varbit.varbits.get(int_0);
        Varbit varbit_1;
        if (varbit_0 != null) {
            varbit_1 = varbit_0;
        } else {
            final byte[] bytes_0 = Varbit.varbit_ref.getConfigData(14, int_0);
            varbit_0 = new Varbit();
            if (bytes_0 != null) {
                varbit_0.decode(new Buffer(bytes_0));
            }

            Varbit.varbits.put(varbit_0, int_0);
            varbit_1 = varbit_0;
        }

        final int int_2 = varbit_1.configId;
        final int int_3 = varbit_1.leastSignificantBit;
        final int int_4 = varbit_1.mostSignificantBit;
        int int_5 = class225.varpsMasks[int_4 - int_3];
        if ((int_1 < 0) || (int_1 > int_5)) {
            int_1 = 0;
        }

        int_5 <<= int_3;
        class225.clientVarps[int_2] = (class225.clientVarps[int_2] & ~int_5) | ((int_1 << int_3) & int_5);
    }

    static void method1682(final IndexedSprite indexedsprite_0) {
        final short short_0 = 256;

        int int_0;
        for (int_0 = 0; int_0 < AbstractByteBuffer.field2367.length; int_0++) {
            AbstractByteBuffer.field2367[int_0] = 0;
        }

        int int_1;
        for (int_0 = 0; int_0 < 5000; int_0++) {
            int_1 = (int) (Math.random() * 128.0D * short_0);
            AbstractByteBuffer.field2367[int_1] = (int) (Math.random() * 256.0D);
        }

        int int_2;
        int int_3;
        for (int_0 = 0; int_0 < 20; int_0++) {
            for (int_1 = 1; int_1 < (short_0 - 1); int_1++) {
                for (int_2 = 1; int_2 < 127; int_2++) {
                    int_3 = int_2 + (int_1 << 7);
                    class81.field1169[int_3] = (AbstractByteBuffer.field2367[int_3 - 128]
                            + AbstractByteBuffer.field2367[int_3 + 1] + AbstractByteBuffer.field2367[int_3 + 128]
                            + AbstractByteBuffer.field2367[int_3 - 1]) / 4;
                }
            }

            final int[] ints_0 = AbstractByteBuffer.field2367;
            AbstractByteBuffer.field2367 = class81.field1169;
            class81.field1169 = ints_0;
        }

        if (indexedsprite_0 != null) {
            int_0 = 0;

            for (int_1 = 0; int_1 < indexedsprite_0.height; int_1++) {
                for (int_2 = 0; int_2 < indexedsprite_0.width; int_2++) {
                    if (indexedsprite_0.pixels[int_0++] != 0) {
                        int_3 = int_2 + indexedsprite_0.offsetX + 16;
                        final int int_4 = int_1 + indexedsprite_0.offsetY + 16;
                        final int int_5 = int_3 + (int_4 << 7);
                        AbstractByteBuffer.field2367[int_5] = 0;
                    }
                }
            }
        }

    }

    static void method1655() {
        final int int_0 = class81.playerIndexesCount;
        final int[] ints_0 = class81.playerIndices;

        for (int int_1 = 0; int_1 < int_0; int_1++) {
            if ((ints_0[int_1] != Game.field707) && (ints_0[int_1] != Game.localInteractingIndex)) {
                class11.method98(Game.cachedPlayers[ints_0[int_1]], true);
            }
        }

    }

}
