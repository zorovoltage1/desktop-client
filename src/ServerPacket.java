public class ServerPacket {


    /**
     * Default packets
     */
    public static final ServerPacket NPC_DIALOGUE_HEAD = new ServerPacket(0, 6);
    public static final ServerPacket field2050 = new ServerPacket(1, 14);
    public static final ServerPacket field2051 = new ServerPacket(2, 5);
    public static final ServerPacket SCRIPT = new ServerPacket(3, -2);
    public static final ServerPacket field2053 = new ServerPacket(4, 6);
    public static final ServerPacket SYS_UPDATE = new ServerPacket(5, 2);
    public static final ServerPacket field2055 = new ServerPacket(6, -2);
    public static final ServerPacket ITEM_CONTAINER = new ServerPacket(7, -2);
    public static final ServerPacket NPC_UPDATE_LARGE_VIEW = new ServerPacket(8, -2);
    public static final ServerPacket PROJECTILE = new ServerPacket(9, 15);
    public static final ServerPacket SKILL_UPDATE = new ServerPacket(10, 6);
    public static final ServerPacket CLOSE_INTERFACE = new ServerPacket(11, 4);
    public static final ServerPacket ANIMATE_OBJECT = new ServerPacket(12, 4);
    public static final ServerPacket UPDATE_IGNORE_LIST = new ServerPacket(13, -2);
    public static final ServerPacket MOVE_INTERFACE = new ServerPacket(14, 8);
    public static final ServerPacket field2106 = new ServerPacket(15, -1);
    public static final ServerPacket INTERFACE_ROOT = new ServerPacket(16, 2);
    public static final ServerPacket PLAYER_MENU_OPTION = new ServerPacket(17, -1);
    public static final ServerPacket field2128 = new ServerPacket(18, 6);
    public static final ServerPacket field2105 = new ServerPacket(19, 7);
    public static final ServerPacket INTERFACE_HIDDEN = new ServerPacket(20, 5);
    public static final ServerPacket SERVER_MESSAGE = new ServerPacket(21, -1);
    public static final ServerPacket ITEM_CONTAINER_UPDATE = new ServerPacket(22, -2);
    public static final ServerPacket field2072 = new ServerPacket(23, 0);
    public static final ServerPacket CLAN_CHAT_MESSAGE = new ServerPacket(24, -1);
    public static final ServerPacket field2074 = new ServerPacket(25, 4);
    public static final ServerPacket RESET_MAP_FLAG = new ServerPacket(26, 2);
    public static final ServerPacket field2058 = new ServerPacket(27, 1);
    public static final ServerPacket DESTORY_ITEM_CONTAINER = new ServerPacket(28, 2);
    public static final ServerPacket MUSIC = new ServerPacket(29, 2);
    public static final ServerPacket ADD_PRIVATE_MESSAGE_RECEIVED = new ServerPacket(30, -2);
    public static final ServerPacket field2080 = new ServerPacket(31, 20);
    public static final ServerPacket GRAPHIC = new ServerPacket(32, 6);
    public static final ServerPacket NPC_UPDATE = new ServerPacket(33, -2);
    public static final ServerPacket field2079 = new ServerPacket(34, -2);
    public static final ServerPacket INTERFACE_CONFIG = new ServerPacket(35, 12);
    public static final ServerPacket LOAD_REGION = new ServerPacket(36, -2);
    public static final ServerPacket INTERFACE_TEXT = new ServerPacket(37, -2);
    public static final ServerPacket field2087 = new ServerPacket(38, 8);
    public static final ServerPacket field2088 = new ServerPacket(39, 4);
    public static final ServerPacket field2089 = new ServerPacket(40, 8);
    public static final ServerPacket SET_ALIGNMENT = new ServerPacket(41, 8);
    public static final ServerPacket ADD_PRIVATE_MESSAGE_SENT = new ServerPacket(42, -2);
    public static final ServerPacket SEND_AREA_SOUND = new ServerPacket(43, 5);
    public static final ServerPacket field2093 = new ServerPacket(44, 2);
    public static final ServerPacket REFRESH_GAMEFRAME = new ServerPacket(45, 0);
    public static final ServerPacket RUN_ENERGY = new ServerPacket(46, 1);
    public static final ServerPacket field2096 = new ServerPacket(47, -1);
    public static final ServerPacket field2097 = new ServerPacket(48, 6);
    public static final ServerPacket VARP_SMALL = new ServerPacket(49, 3);
    public static final ServerPacket VARP_BIG = new ServerPacket(50, 6);
    public static final ServerPacket RESET_CAMERA = new ServerPacket(51, 0);
    public static final ServerPacket field2101 = new ServerPacket(52, 10);
    public static final ServerPacket WEIGHT = new ServerPacket(53, 2);
    public static final ServerPacket SEND_ITEM = new ServerPacket(54, 10);
    public static final ServerPacket field2104 = new ServerPacket(55, 1);
    public static final ServerPacket PLAYER_UPDATE = new ServerPacket(56, -2);
    public static final ServerPacket RESET_VARPS = new ServerPacket(57, 0);
    public static final ServerPacket field2119 = new ServerPacket(58, 2);
    public static final ServerPacket field2108 = new ServerPacket(59, -2);
    public static final ServerPacket SEND_HINT_ICON = new ServerPacket(60, 6);
    public static final ServerPacket ADD_GROUND_ITEM = new ServerPacket(61, 5);
    public static final ServerPacket REGION_COORDINATES = new ServerPacket(62, 2);
    public static final ServerPacket field2112 = new ServerPacket(63, 28);
    public static final ServerPacket field2113 = new ServerPacket(64, -2);
    public static final ServerPacket ANIMATE_INTERFACE = new ServerPacket(65, 6);
    public static final ServerPacket field2115 = new ServerPacket(66, -1);
    public static final ServerPacket field2073 = new ServerPacket(67, 6);
    public static final ServerPacket LOGOUT = new ServerPacket(68, 0);
    public static final ServerPacket SHAKE_CAMERA = new ServerPacket(69, 4);
    public static final ServerPacket PLAYER_DIALOGUE_HEAD = new ServerPacket(70, 4);
    public static final ServerPacket SEND_FRIENDS_LIST = new ServerPacket(71, -2);
    public static final ServerPacket field2121 = new ServerPacket(72, 0);
    public static final ServerPacket field2103 = new ServerPacket(73, 1);
    public static final ServerPacket field2120 = new ServerPacket(74, 0);
    public static final ServerPacket REMOVE_GROUND_ITEM = new ServerPacket(75, 3);
    public static final ServerPacket field2125 = new ServerPacket(76, 4);
    public static final ServerPacket field2130 = new ServerPacket(77, 6);
    public static final ServerPacket SOUND_EFFECT = new ServerPacket(78, 5);
    public static final ServerPacket OPEN_INTERFACE = new ServerPacket(79, 7);
    public static final ServerPacket CLEAR_CHUNK = new ServerPacket(80, 2);
    public static final ServerPacket LOAD_DYNAMIC_REGION = new ServerPacket(81, -2);
    public static final ServerPacket MAP_STATE = new ServerPacket(82, 1);
    public static final ServerPacket field2132 = new ServerPacket(83, -2);

    /**
     * Custom packets
     */
    public static final ServerPacket CLAN_CHAT_SETTINGS = new ServerPacket(84, -1);
    public static final ServerPacket OPEN_URL = new ServerPacket(85, -1);
    public static final ServerPacket JOURNAL = new ServerPacket(86, -2);
    public static final ServerPacket JOURNAL_ENTRY = new ServerPacket(87, -1);
    public static final ServerPacket WIDGET_TIMER = new ServerPacket(88, -2);
    public static final ServerPacket SHOP_INTERFACE = new ServerPacket(89, -2);
    public static final ServerPacket TELEPORT_INTERFACE = new ServerPacket(90, -2);
    public static final ServerPacket DROP_TABLE_INTERFACE = new ServerPacket(91, -2);
    public static final ServerPacket ACCOUNT_MANAGEMENT_INTERFACE = new ServerPacket(92, -2);
    public static final ServerPacket LOYALTY_INTERFACE = new ServerPacket(93, -2);
    public static final ServerPacket DISCORD_PRESENCE = new ServerPacket(94, -2);
    public static final ServerPacket SKILL_INTERFACE = new ServerPacket(95, -2);


    public final int packetId;
    public final int packetLength;

    ServerPacket(final int packetId, final int packetLength) {
        this.packetId = packetId;
        this.packetLength = packetLength;
    }

    static int method3445(final PacketBuffer packetbuffer_0) {
        final int int_0 = packetbuffer_0.getBits(2);
        int int_1;
        if (int_0 == 0) {
            int_1 = 0;
        } else if (int_0 == 1) {
            int_1 = packetbuffer_0.getBits(5);
        } else if (int_0 == 2) {
            int_1 = packetbuffer_0.getBits(8);
        } else {
            int_1 = packetbuffer_0.getBits(11);
        }

        return int_1;
    }

    public static void method3444() {
        Area.areaSpriteCache.reset();
    }

}
