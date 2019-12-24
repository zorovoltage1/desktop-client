public class ItemComposition extends CacheableNode {

    public static IndexDataBase item_ref;
    public static IndexDataBase ItemDefinition_modelIndexCache;
    public static boolean isMembersWorld;
    static NodeCache items;
    static NodeCache itemModelCache;
    public static NodeCache itemSpriteCache;
    public static Font field3466;
    static int field3478;
    public int id;
    int inventoryModel;
    public String name;
    short[] colourToReplace;
    short[] colourToReplaceWith;
    short[] textureToReplace;
    short[] textToReplaceWith;
    public int zoom2d;
    public int xan2d;
    public int yan2d;
    public int zan2d;
    public int offsetX2d;
    public int offsetY2d;
    public int isStackable;
    public int price;
    public int BMValue;
    public boolean isMembers;
    public String[] groundActions;
    public String[] inventoryActions;
    int shiftClickIndex;
    int maleModel;
    int maleModel1;
    int maleOffset;
    int femaleModel;
    int femaleModel1;
    int femaleOffset;
    int maleModel2;
    int femaleModel2;
    int maleHeadModel;
    int maleHeadModel2;
    int femaleHeadModel;
    int femaleHeadModel2;
    int[] countObj;
    int[] countCo;
    public int note;
    public int notedTemplate;
    int resizeX;
    int resizeY;
    int resizeZ;
    public int ambient;
    public int contrast;
    public int team;
    IterableHashTable params;
    public boolean isTradable;
    int unnotedId;
    int notedId;
    public int placeholderId;
    public int placeholderTemplateId;

    static {
        items = new NodeCache(64);
        itemModelCache = new NodeCache(50);
        itemSpriteCache = new NodeCache(200);
    }

    ItemComposition() {
        name = "null";
        zoom2d = 2000;
        xan2d = 0;
        yan2d = 0;
        zan2d = 0;
        offsetX2d = 0;
        offsetY2d = 0;
        isStackable = 0;
        price = 1;
        isMembers = false;
        groundActions = new String[]{null, null, "Take", null, null};
        inventoryActions = new String[]{null, null, null, null, "Drop"};
        shiftClickIndex = -2;
        maleModel = -1;
        maleModel1 = -1;
        maleOffset = 0;
        femaleModel = -1;
        femaleModel1 = -1;
        femaleOffset = 0;
        maleModel2 = -1;
        femaleModel2 = -1;
        maleHeadModel = -1;
        maleHeadModel2 = -1;
        femaleHeadModel = -1;
        femaleHeadModel2 = -1;
        note = -1;
        notedTemplate = -1;
        resizeX = 128;
        resizeY = 128;
        resizeZ = 128;
        ambient = 0;
        contrast = 0;
        team = 0;
        isTradable = false;
        unnotedId = -1;
        notedId = -1;
        placeholderId = -1;
        placeholderTemplateId = -1;
    }

    void post() {
    }

    void loadBuffer(final Buffer buffer_0) {
        while (true) {
            final int int_0 = buffer_0.readUnsignedByte();
            if (int_0 == 0) {
                return;
            }

            populateFromBuffer(buffer_0, int_0);
        }
    }

    void postDecode() {
        if(id == 2742) {
            name = "Coin Casket (small)";
            inventoryActions[1] = null;
        }

        if(id == 2744) {
            name = "Coin Casket (medium)";
            inventoryActions[1] = null;
        }

        if(id == 2746) {
            name = "Coin Casket (large)";
            inventoryActions[1] = null;
        }

        if(id == 2748) {
            name = "Coin Casket (giant)";
            inventoryActions[1] = null;
        }

        if(id == 13190) { //bond
            name = Loader.SERVER_NAME + " Credit";
            isStackable = 1;
            inventoryActions[0] = "Claim";
            inventoryActions[2] = null;
        }

        if(id == 6199) {
            inventoryActions[2] = "Gift";
        }

        if(id == 290) {
            name = "Super Mystery Box";
            inventoryActions[1] = "Open";
            inventoryActions[2] = "Gift";
        }

        if(id == 6828) {
            name = "Pet Mystery Box";
            inventoryActions[1] = "Open";
            inventoryActions[2] = "Gift";
        }

        if(id == 6829) {
            name = "Voting Mystery Box";
            inventoryActions[1] = "Open";
            inventoryActions[2] = "Gift";
        }

        if(id == 6830) {
            name = "Cape mystery Box";
            inventoryActions[1] = "Open";
            inventoryActions[2] = "Gift";
        }

        if(id == 6831) {
            name = "3rd Age Mystery Box";
            inventoryActions[1] = "Open";
            inventoryActions[2] = "Gift";
        }

        if(id == 6832) {
            name = "Activity Mystery Box";
            inventoryActions[1] = "Open";
            inventoryActions[2] = "Gift";
        }

        if(id == 6833) {
            name = "Loyalty Mystery Box";
            inventoryActions[1] = "Open";
            inventoryActions[2] = "Gift";
        }

        if(id == 1505) {
            name = "Obelisk destination scroll";
        }

        if(id == 4067) {
            name = "Vote ticket";
        }

        if(id == 10834) {
            name = "Dice bag";
            inventoryActions[0] = "Roll 4-sided";
            inventoryActions[1] = "Roll 12-sided";
            inventoryActions[2] = "Roll 100-sided";
        }

        if(id == 786) {
            name = "Item Upgrade Scroll";
        }

        if(id == 19625) {
            name = "Home teleport";
        }
        if(id == 8007) {
            inventoryActions[1] = null;
        }
        if(id >= 1567 && id <= 1572)
            name = "Overgrown cat";
        /* Quick option for repairing all broken items */
        if(name.endsWith("(broken)"))
            inventoryActions[0] = "Fix";

        if(id == 11169) {
            name = Loader.SERVER_NAME + " Herald";
            inventoryActions[0] = "View-updates";
            inventoryActions[1] = null;
            inventoryActions[4] = "Destroy";
        }
        if(id == 12746 || (id >= 12748 && id <= 12756)) {
            inventoryActions[0] = "Info";
            inventoryActions[1] = "Redeem";
        }
        if(id == 5023) {
            name = "Tournament ticket";
            inventoryActions[0] = "Read";
            isStackable = 1;
        }
        if (WorldType.isPVP()) { // i don't know if this will work out when using the world switcher... probably not...
            if (id == 12810) {
                name = "Contender's helm";
            }
            if (id == 12811) {
                name = "Contender's platebody";
            }
            if (id == 12812) {
                name = "Contender's platelegs";
            }
            if (id == 12813) {
                name = "Champion's helm";
            }
            if (id == 12814) {
                name = "Champion's platebody";
            }
            if (id == 12815) {
                name = "Champion's platelegs";
            }
            if (id == 20792) {
                name = "Legend's helm";
            }
            if (id == 20794) {
                name = "Legend's platebody";
            }
            if (id == 20796) {
                name = "Legend's platelegs";
            }
        }
        if(id == 21532) {
            name = "Fragments";
        }

        if(id == 607) {
            name = "Rare Drop Scroll";
            inventoryActions[0] = "Activate";
        }
        if(id == 608) {
            name = "Pet Drop Scroll";
            inventoryActions[0] = "Activate";
        }
        if(id == 6758) {
            name = "Bonus Exp Scroll";
            inventoryActions[0] = "Activate";
        }

        if(id == 2730) {
            name = "Wilderness Reward Box (small)";
            inventoryActions[0] = "Open";
            inventoryActions[1] = null;
        }

        if(id == 2732) {
            name = "Wilderness Reward Box (medium)";
            inventoryActions[0] = "Open";
            inventoryActions[1] = null;
        }

        if(id == 2734) {
            name = "Wilderness Reward Box (large)";
            inventoryActions[0] = "Open";
            inventoryActions[1] = null;
        }

        if(id == 2736) {
            name = "Wilderness Reward Box (giant)";
            inventoryActions[0] = "Open";
            inventoryActions[1] = null;
        }

        if (id == 13215) {
            ItemComposition platinumTokenClone = TextureProvider.getItemDefinition(13204);
            price = platinumTokenClone.price;
            femaleModel1 = platinumTokenClone.femaleModel1;
            femaleOffset = platinumTokenClone.femaleOffset;
            inventoryActions = platinumTokenClone.inventoryActions;
            inventoryModel = platinumTokenClone.inventoryModel;
            maleModel = platinumTokenClone.maleModel;
            isMembers = platinumTokenClone.isMembers;
            name = "Bloody Token";
            isStackable = platinumTokenClone.isStackable;
            xan2d = platinumTokenClone.xan2d;
            yan2d = platinumTokenClone.yan2d;
            offsetY2d = platinumTokenClone.offsetY2d;
            zoom2d = platinumTokenClone.zoom2d;
            offsetX2d = platinumTokenClone.offsetX2d;
            zan2d = platinumTokenClone.zan2d;
            colourToReplace = new short[]{5813, 9139, 26006};
            colourToReplaceWith = new short[]{947, 948, 949};
            countCo = new int[]{2, 3, 4, 5, 0, 0, 0, 0, 0, 0};
            countObj = new int[]{13216, 13217, 13218, 13218, 0, 0, 0, 0, 0, 0};
        }

        if (id == 13216) {
            ItemComposition platinumTokenClone = TextureProvider.getItemDefinition(3985);
            price = platinumTokenClone.price;
            femaleModel1 = platinumTokenClone.femaleModel1;
            name = "Bloody Token";
            femaleOffset = platinumTokenClone.femaleOffset;
            inventoryActions = platinumTokenClone.inventoryActions;
            inventoryModel = platinumTokenClone.inventoryModel;
            maleModel = platinumTokenClone.maleModel;
            isMembers = platinumTokenClone.isMembers;
            isStackable = platinumTokenClone.isStackable;
            xan2d = platinumTokenClone.xan2d;
            yan2d = platinumTokenClone.yan2d;
            offsetY2d = platinumTokenClone.offsetY2d;
            zoom2d = platinumTokenClone.zoom2d;
            offsetX2d = platinumTokenClone.offsetX2d;
            zan2d = platinumTokenClone.zan2d;
            colourToReplace = new short[]{5813, 9139, 26006};
            colourToReplaceWith = new short[]{947, 948, 949};
        }

        if (id == 13217) {
            ItemComposition platinumTokenClone = TextureProvider.getItemDefinition(3987);
            price = platinumTokenClone.price;
            femaleModel1 = platinumTokenClone.femaleModel1;
            name = "Bloody Token";
            femaleOffset = platinumTokenClone.femaleOffset;
            inventoryActions = platinumTokenClone.inventoryActions;
            inventoryModel = platinumTokenClone.inventoryModel;
            maleModel = platinumTokenClone.maleModel;
            isMembers = platinumTokenClone.isMembers;
            isStackable = platinumTokenClone.isStackable;
            xan2d = platinumTokenClone.xan2d;
            yan2d = platinumTokenClone.yan2d;
            offsetY2d = platinumTokenClone.offsetY2d;
            zoom2d = platinumTokenClone.zoom2d;
            offsetX2d = platinumTokenClone.offsetX2d;
            zan2d = platinumTokenClone.zan2d;
            colourToReplace = new short[]{5813, 9139, 26006};
            colourToReplaceWith = new short[]{947, 948, 949};
        }

        if (id == 13218) {
            ItemComposition platinumTokenClone = TextureProvider.getItemDefinition(3989);
            price = platinumTokenClone.price;
            femaleModel1 = platinumTokenClone.femaleModel1;
            femaleOffset = platinumTokenClone.femaleOffset;
            name = "Bloody Token";
            inventoryActions = platinumTokenClone.inventoryActions;
            inventoryModel = platinumTokenClone.inventoryModel;
            maleModel = platinumTokenClone.maleModel;
            isMembers = platinumTokenClone.isMembers;
            isStackable = platinumTokenClone.isStackable;
            xan2d = platinumTokenClone.xan2d;
            yan2d = platinumTokenClone.yan2d;
            offsetY2d = platinumTokenClone.offsetY2d;
            zoom2d = platinumTokenClone.zoom2d;
            offsetX2d = platinumTokenClone.offsetX2d;
            zan2d = platinumTokenClone.zan2d;
            colourToReplace = new short[]{5813, 9139, 26006};
            colourToReplaceWith = new short[]{947, 948, 949};
        }

        if(id == 22330) {
            name = "PVP Armour Mystery Box";
            inventoryActions[0] = "Open";
            inventoryActions[1] = "Gift";
            inventoryActions[2] = null;
            inventoryActions[3] = null;
        }

        if(WorldType.isPVP()) {
            if (id == 13329 || id == 13331 || id == 21776 || id == 13333 ||
                    id == 21780 || id == 13335 || id == 21784 || id == 13337 ||
                    id == 21898 || id == 20760 || id == 21285) {
                inventoryActions[2] = "Revert";
            }
        }

        if (id == 3606 || id == 3608 || id == 7297) {
            ItemComposition bloodyKey = TextureProvider.getItemDefinition(20526);

            switch (id) {
                case 3606:
                    name = "Bloody key (easy)";
                    break;
                case 3608:
                    name = "Bloody key (medium)";
                    break;
                case 7297:
                    name = "Bloody key (hard)";
                    break;
            }

            inventoryModel = bloodyKey.inventoryModel;
            xan2d = bloodyKey.xan2d;
            offsetY2d = bloodyKey.offsetY2d;
            yan2d = bloodyKey.yan2d;
            offsetX2d = bloodyKey.offsetX2d;
            zoom2d = bloodyKey.zoom2d;
        }

        if(id == 22521 || id == 22522 || id == 22523 || id == 22524) {
            String size = "";
            if(id == 22521)
                size = "(small)";
            else if(id == 22522)
                size = "(medium)";
            else if(id == 22523)
                size = "(large)";
            else if(id == 22524)
                size = "(giant)";
            name = "Blood money pouch " + size;
            colourToReplace = new short[]{6798};
            colourToReplaceWith = new short[]{948};
        }

        if(id == 2528) {
            name = "Skill Lamp";
        }

        if(id == 11918) {
            name = "Santa Outfit Box";
            inventoryActions[0] = "Open";
        }

        if(id == 12897) {
            name = "Anti-Santa Outfit Box";
            inventoryActions[0] = "Open";
        }

        if(id == 22816 || id == 22817) {
            inventoryActions[4] = "Destroy";
        }

        if(id == 21227) {
            name = "Easter Egg";
            inventoryActions[0] = "Open";
        }

        if (id == 8943 || id == 8944 || id == 8945 || id == 8946 || id == 8947 || id == 8948) {
            ItemComposition bloodyKey = TextureProvider.getItemDefinition(20526);

            switch (id) {
                case 8943:
                    name = "Wilderness key (1M OSRS)";
                    break;
                case 8944:
                    name = "Wilderness key (5M OSRS)";
                    break;
                case 8945:
                    name = "Wilderness key (10M OSRS)";
                    break;
                case 8946:
                    name = "Wilderness key (25M OSRS)";
                    break;
                case 8947:
                    name = "Wilderness key (50M OSRS)";
                    break;
                case 8948:
                    name = "Wilderness key (100M OSRS)";
                    break;
            }

            inventoryActions[0] = "Information";
            inventoryActions[3] = null;
            inventoryActions[4] = "Destroy";
            inventoryModel = bloodyKey.inventoryModel;
            xan2d = bloodyKey.xan2d;
            offsetY2d = bloodyKey.offsetY2d;
            yan2d = bloodyKey.yan2d;
            offsetX2d = bloodyKey.offsetX2d;
            zoom2d = bloodyKey.zoom2d;
        }

    }

    /**
     * Used for the drop colors.. downfall is we have to manually add items.
     */
    void populateBloodMoneyValue() {
        if(id == 1187)
            BMValue = 300;
        if(id == 1249)
            BMValue = 300;
        if(id == 2577)
            BMValue = 1500;
        if(id == 2581)
            BMValue = 3000;
        if(id == 3140)
            BMValue = 300;
        if(id == 4087)
            BMValue = 300;
        if(id == 4151)
            BMValue = 450;
        if(id == 4153)
            BMValue = 900;
        if(id == 4170)
            BMValue = 150;
        if(id == 4585)
            BMValue = 300;
        if(id == 4708)
            BMValue = 1200;
        if(id == 4710)
            BMValue = 1200;
        if(id == 4712)
            BMValue = 1800;
        if(id == 4714)
            BMValue = 1800;
        if(id == 4716)
            BMValue = 1200;
        if(id == 4718)
            BMValue = 1200;
        if(id == 4720)
            BMValue = 1800;
        if(id == 4722)
            BMValue = 1800;
        if(id == 4724)
            BMValue = 1200;
        if(id == 4726)
            BMValue = 1200;
        if(id == 4728)
            BMValue = 1800;
        if(id == 4730)
            BMValue = 1800;
        if(id == 4732)
            BMValue = 1200;
        if(id == 4734)
            BMValue = 1200;
        if(id == 4736)
            BMValue = 1800;
        if(id == 4738)
            BMValue = 1800;
        if(id == 4745)
            BMValue = 1200;
        if(id == 4747)
            BMValue = 1200;
        if(id == 4749)
            BMValue = 1800;
        if(id == 4751)
            BMValue = 1800;
        if(id == 4753)
            BMValue = 1200;
        if(id == 4755)
            BMValue = 1200;
        if(id == 4757)
            BMValue = 1800;
        if(id == 4759)
            BMValue = 1800;
        if(id == 6522)
            BMValue = 60;
        if(id == 6524)
            BMValue = 300;
        if(id == 6528)
            BMValue = 300;
        if(id == 6563)
            BMValue = 300;
        if(id == 6568)
            BMValue = 300;
        if(id == 6570)
            BMValue = 3000;
        if(id == 6585)
            BMValue = 3000;
        if(id == 6731)
            BMValue = 3000;
        if(id == 6733)
            BMValue = 1200;
        if(id == 6735)
            BMValue = 1200;
        if(id == 6737)
            BMValue = 3000;
        if(id == 6889)
            BMValue = 4800;
        if(id == 6914)
            BMValue = 1200;
        if(id == 6916)
            BMValue = 1200;
        if(id == 6918)
            BMValue = 1200;
        if(id == 6920)
            BMValue = 1200;
        if(id == 6922)
            BMValue = 750;
        if(id == 6924)
            BMValue = 1200;
        if(id == 8839)
            BMValue = 2100;
        if(id == 8840)
            BMValue = 2100;
        if(id == 8842)
            BMValue = 300;
        if(id == 10156)
            BMValue = 150;
        if(id == 10548)
            BMValue = 600;
        if(id == 10551)
            BMValue = 900;
        if(id == 10555)
            BMValue = 300;
        if(id == 10887)
            BMValue = 300;
        if(id == 11061)
            BMValue = 600;
        if(id == 11128)
            BMValue = 600;
        if(id == 11133)
            BMValue = 300;
        if(id == 11212)
            BMValue = 9;
        if(id == 11230)
            BMValue = 6;
        if(id == 11235)
            BMValue = 2400;
        if(id == 11283 || id == 11284 || id == 21634 || id == 21633 || id == 22002 || id == 22003)
            BMValue = 12000;
        if(id == 11335)
            BMValue = 300;
        if(id == 11663)
            BMValue = 600;
        if(id == 11664)
            BMValue = 600;
        if(id == 11665)
            BMValue = 600;
        if(id == 11785)
            BMValue = 7200;
        if(id == 11791)
            BMValue = 6000;
        if(id == 11802)
            BMValue = 30000;
        if(id == 11804)
            BMValue = 15000;
        if(id == 11806)
            BMValue = 9000;
        if(id == 11808)
            BMValue = 9000;
        if(id == 11824)
            BMValue = 6000;
        if(id == 11826)
            BMValue = 4800;
        if(id == 11828)
            BMValue = 6000;
        if(id == 11830)
            BMValue = 6000;
        if(id == 11832)
            BMValue = 9000;
        if(id == 11834)
            BMValue = 9000;
        if(id == 11836)
            BMValue = 1500;
        if(id == 11838)
            BMValue = 2100;
        if(id == 11840)
            BMValue = 1500;
        if(id == 11896)
            BMValue = 300;
        if(id == 11897)
            BMValue = 300;
        if(id == 11898)
            BMValue = 300;
        if(id == 11899)
            BMValue = 300;
        if(id == 11900)
            BMValue = 300;
        if(id == 11901)
            BMValue = 300;
        if(id == 11908)
            BMValue = 1500;
        if(id == 11920)
            BMValue = 3000;
        if(id == 11924)
            BMValue = 3000;
        if(id == 11926)
            BMValue = 3000;
        if(id == 11936)
            BMValue = 15;
        if(id == 11941)
            BMValue = 1200;
        if(id == 11998)
            BMValue = 500;
        if(id == 12000)
            BMValue = 300;
        if(id == 12002)
            BMValue = 2100;
        if(id == 12004)
            BMValue = 1350;
        if(id == 12006)
            BMValue = 1800;
        if(id == 12526)
            BMValue = 3000;
        if(id == 12528)
            BMValue = 600;
        if(id == 12530)
            BMValue = 600;
        if(id == 12532)
            BMValue = 3000;
        if(id == 12534)
            BMValue = 1500;
        if(id == 12536)
            BMValue = 1500;
        if(id == 12538)
            BMValue = 1500;
        if(id == 12596)
            BMValue = 3000;
        if(id == 12601)
            BMValue = 2100;
        if(id == 12603)
            BMValue = 2100;
        if(id == 12605)
            BMValue = 2100;
        if(id == 12608)
            BMValue = 300;
        if(id == 12610)
            BMValue = 300;
        if(id == 12612)
            BMValue = 300;
        if(id == 12625)
            BMValue = 12;
        if(id == 12637)
            BMValue = 600;
        if(id == 12638)
            BMValue = 600;
        if(id == 12639)
            BMValue = 600;
        if(id == 12695)
            BMValue = 18;
        if(id == 12746)
            BMValue = 300;
        if(id == 12748)
            BMValue = 500;
        if(id == 12749)
            BMValue = 750;
        if(id == 12750)
            BMValue = 1000;
        if(id == 12751)
            BMValue = 1500;
        if(id == 12752)
            BMValue = 2000;
        if(id == 12753)
            BMValue = 3000;
        if(id == 12754)
            BMValue = 5000;
        if(id == 12755)
            BMValue = 7500;
        if(id == 12756)
            BMValue = 10000;
        if(id == 12757)
            BMValue = 600;
        if(id == 12759)
            BMValue = 600;
        if(id == 12761)
            BMValue = 600;
        if(id == 12763)
            BMValue = 600;
        if(id == 12769)
            BMValue = 300;
        if(id == 12771)
            BMValue = 300;
        if(id == 12791)
            BMValue = 9000;
        if(id == 12798)
            BMValue = 3000;
        if(id == 12802)
            BMValue = 3000;
        if(id == 12804)
            BMValue = 3000;
        if(id == 12829)
            BMValue = 600;
        if(id == 12831)
            BMValue = 1800;
        if(id == 12846)
            BMValue = 1500;
        if(id == 12849)
            BMValue = 1500;
        if(id == 12853)
            BMValue = 1500;
        if(id == 12855)
            BMValue = 600;
        if(id == 12856)
            BMValue = 600;
        if(id == 12900)
            BMValue = 15000;
        if(id == 12902)
            BMValue = 18000;
        if(id == 12905)
            BMValue = 15;
        if(id == 12913)
            BMValue = 15;
        if(id == 12924)
            BMValue = 12000;
        if(id == 12929)
            BMValue = 12000;
        if(id == 12934)
            BMValue = 1;
        if(id == 12954)
            BMValue = 900;
        if(id == 13111)
            BMValue = 6000;
        if(id == 13124)
            BMValue = 1500;
        if(id == 13196)
            BMValue = 18000;
        if(id == 13198)
            BMValue = 18000;
        if(id == 13233)
            BMValue = 2500;
        if(id == 13235)
            BMValue = 6000;
        if(id == 13237)
            BMValue = 6000;
        if(id == 13239)
            BMValue = 6000;
        if(id == 13256)
            BMValue = 4200;
        if(id == 13263)
            BMValue = 6000;
        if(id == 13271)
            BMValue = 4500;
        if(id == 13441)
            BMValue = 30;
        if(id == 13576)
            BMValue = 4500;
        if(id == 13652)
            BMValue = 60000;
        if(id == 19478)
            BMValue = 6000;
        if(id == 19481)
            BMValue = 9000;
        if(id == 19484)
            BMValue = 30;
        if(id == 19544)
            BMValue = 9000;
        if(id == 19547)
            BMValue = 9000;
        if(id == 19550)
            BMValue = 9000;
        if(id == 19553)
            BMValue = 12000;
        if(id == 19994)
            BMValue = 1500;
        if(id == 20002)
            BMValue = 3000;
        if(id == 20062)
            BMValue = 6000;
        if(id == 20065)
            BMValue = 3000;
        if(id == 20068)
            BMValue = 6000;
        if(id == 20071)
            BMValue = 3000;
        if(id == 20074)
            BMValue = 3000;
        if(id == 20077)
            BMValue = 3000;
        if(id == 20128)
            BMValue = 1500;
        if(id == 20131)
            BMValue = 1500;
        if(id == 20137)
            BMValue = 1500;
        if(id == 20140)
            BMValue = 1500;
        if(id == 20143)
            BMValue = 3000;
        if(id == 20517)
            BMValue = 600;
        if(id == 20520)
            BMValue = 600;
        if(id == 20595)
            BMValue = 600;
        if(id == 20714)
            BMValue = 1800;
        if(id == 20724)
            BMValue = 9000;
        if(id == 20733)
            BMValue = 300;
        if(id == 20739)
            BMValue = 300;
        if(id == 20849)
            BMValue = 60;
        if(id == 21018)
            BMValue = 50000;
        if(id == 21021)
            BMValue = 75000;
        if(id == 21024)
            BMValue = 75000;
        if(id == 21202)
            BMValue = 3000;
        if(id == 21295)
            BMValue = 120000;
        if(id == 21298)
            BMValue = 4500;
        if(id == 21301)
            BMValue = 4500;
        if(id == 21304)
            BMValue = 4500;
        if(id == 21326)
            BMValue = 6;
        if(id == 21532)
            BMValue = 2;
        if(id == 21634)
            BMValue = 15000;
        if(id == 21733)
            BMValue = 4800;
        if(id == 21739)
            BMValue = 300;
        if(id == 21807)
            BMValue = 2500;
        if(id == 21810)
            BMValue = 5000;
        if(id == 21813)
            BMValue = 10000;
        if(id == 21817)
            BMValue = 500;
        if(id == 22109)
            BMValue = 4500;
        if(id == 22114)
            BMValue = 3000;
        if(id == 22231)
            BMValue = 3000;
        if(id == 22246)
            BMValue = 6000;
        if(id == 22296)
            BMValue = 10000;
        if(id == 22324)
            BMValue = 100000;
        if(id == 22326)
            BMValue = 50000;
        if(id == 22327)
            BMValue = 75000;
        if(id == 22328)
            BMValue = 75000;
        if(id == 13307)
            BMValue = 1;
        if(id == 20997)
            BMValue = 75000;
        if(id == 4866 || id == 4860 || id == 4872 || id == 4878)
            BMValue = 500;
        if(id == 4932 || id == 4938 || id == 4944 || id == 4950)
            BMValue = 500;
        if(id == 4884 || id == 4890 || id == 4896 || id == 4902)
            BMValue = 500;
        if(id == 4980 || id == 4986 || id == 4992 || id == 4998)
            BMValue = 500;
        if(id == 4956 || id == 4962 || id == 4968 || id == 4974)
            BMValue = 500;
        if(id == 22622)
            BMValue = 75000;
        if(id == 22625)
            BMValue = 75000;
        if(id == 22628)
            BMValue = 75000;
        if(id == 22631)
            BMValue = 75000;
        if(id == 22610)
            BMValue = 75000;
        if(id == 22613)
            BMValue = 75000;
        if(id == 22616)
            BMValue = 75000;
        if(id == 22619)
            BMValue = 75000;
        if(id == 22647)
            BMValue = 75000;
        if(id == 22650)
            BMValue = 75000;
        if(id == 22653)
            BMValue = 75000;
        if(id == 22656)
            BMValue = 75000;
        if(id == 22638)
            BMValue = 75000;
        if(id == 22641)
            BMValue = 75000;
        if(id == 22644)
            BMValue = 75000;
        if(id == 22634)
            BMValue = 75000;
        if(id == 22636)
            BMValue = 75000;
        if(id == 22545 || id == 22550 || id == 22555)
            BMValue = 50000;
    }

    void populateFromBuffer(final Buffer buffer_0, final int int_0) {
        if (int_0 == 1) {
            inventoryModel = buffer_0.readUnsignedShort();
        } else if (int_0 == 2) {
            name = buffer_0.readString();
        } else if (int_0 == 4) {
            zoom2d = buffer_0.readUnsignedShort();
        } else if (int_0 == 5) {
            xan2d = buffer_0.readUnsignedShort();
        } else if (int_0 == 6) {
            yan2d = buffer_0.readUnsignedShort();
        } else if (int_0 == 7) {
            offsetX2d = buffer_0.readUnsignedShort();
            if (offsetX2d > 32767) {
                offsetX2d -= 65536;
            }
        } else if (int_0 == 8) {
            offsetY2d = buffer_0.readUnsignedShort();
            if (offsetY2d > 32767) {
                offsetY2d -= 65536;
            }
        } else if (int_0 == 11) {
            isStackable = 1;
        } else if (int_0 == 12) {
            price = buffer_0.readInt();
        } else if (int_0 == 16) {
            isMembers = true;
        } else if (int_0 == 23) {
            maleModel = buffer_0.readUnsignedShort();
            maleOffset = buffer_0.readUnsignedByte();
        } else if (int_0 == 24) {
            maleModel1 = buffer_0.readUnsignedShort();
        } else if (int_0 == 25) {
            femaleModel = buffer_0.readUnsignedShort();
            femaleOffset = buffer_0.readUnsignedByte();
        } else if (int_0 == 26) {
            femaleModel1 = buffer_0.readUnsignedShort();
        } else if ((int_0 >= 30) && (int_0 < 35)) {
            groundActions[int_0 - 30] = buffer_0.readString();
            if (groundActions[int_0 - 30].equalsIgnoreCase("Hidden")) {
                groundActions[int_0 - 30] = null;
            }
        } else if ((int_0 >= 35) && (int_0 < 40)) {
            inventoryActions[int_0 - 35] = buffer_0.readString();
        } else {
            int int_1;
            int int_2;
            if (int_0 == 40) {
                int_1 = buffer_0.readUnsignedByte();
                colourToReplace = new short[int_1];
                colourToReplaceWith = new short[int_1];

                for (int_2 = 0; int_2 < int_1; int_2++) {
                    colourToReplace[int_2] = (short) buffer_0.readUnsignedShort();
                    colourToReplaceWith[int_2] = (short) buffer_0.readUnsignedShort();
                }
            } else if (int_0 == 41) {
                int_1 = buffer_0.readUnsignedByte();
                textureToReplace = new short[int_1];
                textToReplaceWith = new short[int_1];

                for (int_2 = 0; int_2 < int_1; int_2++) {
                    textureToReplace[int_2] = (short) buffer_0.readUnsignedShort();
                    textToReplaceWith[int_2] = (short) buffer_0.readUnsignedShort();
                }
            } else if (int_0 == 42) {
                shiftClickIndex = buffer_0.readByte();
            } else if (int_0 == 65) {
                isTradable = true;
            } else if (int_0 == 78) {
                maleModel2 = buffer_0.readUnsignedShort();
            } else if (int_0 == 79) {
                femaleModel2 = buffer_0.readUnsignedShort();
            } else if (int_0 == 90) {
                maleHeadModel = buffer_0.readUnsignedShort();
            } else if (int_0 == 91) {
                femaleHeadModel = buffer_0.readUnsignedShort();
            } else if (int_0 == 92) {
                maleHeadModel2 = buffer_0.readUnsignedShort();
            } else if (int_0 == 93) {
                femaleHeadModel2 = buffer_0.readUnsignedShort();
            } else if (int_0 == 95) {
                zan2d = buffer_0.readUnsignedShort();
            } else if (int_0 == 97) {
                note = buffer_0.readUnsignedShort();
            } else if (int_0 == 98) {
                notedTemplate = buffer_0.readUnsignedShort();
            } else if ((int_0 >= 100) && (int_0 < 110)) {
                if (countObj == null) {
                    countObj = new int[10];
                    countCo = new int[10];
                }

                countObj[int_0 - 100] = buffer_0.readUnsignedShort();
                countCo[int_0 - 100] = buffer_0.readUnsignedShort();
            } else if (int_0 == 110) {
                resizeX = buffer_0.readUnsignedShort();
            } else if (int_0 == 111) {
                resizeY = buffer_0.readUnsignedShort();
            } else if (int_0 == 112) {
                resizeZ = buffer_0.readUnsignedShort();
            } else if (int_0 == 113) {
                ambient = buffer_0.readByte();
            } else if (int_0 == 114) {
                contrast = buffer_0.readByte() * 5;
            } else if (int_0 == 115) {
                team = buffer_0.readUnsignedByte();
            } else if (int_0 == 139) {
                unnotedId = buffer_0.readUnsignedShort();
            } else if (int_0 == 140) {
                notedId = buffer_0.readUnsignedShort();
            } else if (int_0 == 148) {
                placeholderId = buffer_0.readUnsignedShort();
            } else if (int_0 == 149) {
                placeholderTemplateId = buffer_0.readUnsignedShort();
            } else if (int_0 == 249) {
                params = KeyFocusListener.readStringIntParameters(buffer_0, params);
            }
        }

    }

    void updateNote(final ItemComposition itemcomposition_1, final ItemComposition itemcomposition_2) {
        inventoryModel = itemcomposition_1.inventoryModel;
        zoom2d = itemcomposition_1.zoom2d;
        xan2d = itemcomposition_1.xan2d;
        yan2d = itemcomposition_1.yan2d;
        zan2d = itemcomposition_1.zan2d;
        offsetX2d = itemcomposition_1.offsetX2d;
        offsetY2d = itemcomposition_1.offsetY2d;
        colourToReplace = itemcomposition_1.colourToReplace;
        colourToReplaceWith = itemcomposition_1.colourToReplaceWith;
        textureToReplace = itemcomposition_1.textureToReplace;
        textToReplaceWith = itemcomposition_1.textToReplaceWith;
        name = itemcomposition_2.name;
        isMembers = itemcomposition_2.isMembers;
        price = itemcomposition_2.price;
        isStackable = 1;
    }

    void method5110(final ItemComposition itemcomposition_1, final ItemComposition itemcomposition_2) {
        inventoryModel = itemcomposition_1.inventoryModel;
        zoom2d = itemcomposition_1.zoom2d;
        xan2d = itemcomposition_1.xan2d;
        yan2d = itemcomposition_1.yan2d;
        zan2d = itemcomposition_1.zan2d;
        offsetX2d = itemcomposition_1.offsetX2d;
        offsetY2d = itemcomposition_1.offsetY2d;
        colourToReplace = itemcomposition_2.colourToReplace;
        colourToReplaceWith = itemcomposition_2.colourToReplaceWith;
        textureToReplace = itemcomposition_2.textureToReplace;
        textToReplaceWith = itemcomposition_2.textToReplaceWith;
        name = itemcomposition_2.name;
        isMembers = itemcomposition_2.isMembers;
        isStackable = itemcomposition_2.isStackable;
        maleModel = itemcomposition_2.maleModel;
        maleModel1 = itemcomposition_2.maleModel1;
        maleModel2 = itemcomposition_2.maleModel2;
        femaleModel = itemcomposition_2.femaleModel;
        femaleModel1 = itemcomposition_2.femaleModel1;
        femaleModel2 = itemcomposition_2.femaleModel2;
        maleHeadModel = itemcomposition_2.maleHeadModel;
        maleHeadModel2 = itemcomposition_2.maleHeadModel2;
        femaleHeadModel = itemcomposition_2.femaleHeadModel;
        femaleHeadModel2 = itemcomposition_2.femaleHeadModel2;
        team = itemcomposition_2.team;
        groundActions = itemcomposition_2.groundActions;
        inventoryActions = new String[5];
        if (itemcomposition_2.inventoryActions != null) {
            for (int int_0 = 0; int_0 < 4; int_0++) {
                inventoryActions[int_0] = itemcomposition_2.inventoryActions[int_0];
            }
        }

        inventoryActions[4] = "Discard";
        price = 0;
    }

    void method5091(final ItemComposition itemcomposition_1, final ItemComposition itemcomposition_2) {
        inventoryModel = itemcomposition_1.inventoryModel;
        zoom2d = itemcomposition_1.zoom2d;
        xan2d = itemcomposition_1.xan2d;
        yan2d = itemcomposition_1.yan2d;
        zan2d = itemcomposition_1.zan2d;
        offsetX2d = itemcomposition_1.offsetX2d;
        offsetY2d = itemcomposition_1.offsetY2d;
        colourToReplace = itemcomposition_1.colourToReplace;
        colourToReplaceWith = itemcomposition_1.colourToReplaceWith;
        textureToReplace = itemcomposition_1.textureToReplace;
        textToReplaceWith = itemcomposition_1.textToReplaceWith;
        isStackable = itemcomposition_1.isStackable;
        name = itemcomposition_2.name;
        price = 0;
        isMembers = false;
        isTradable = false;
    }

    public ModelData method5092(final int int_0) {
        int int_2;
        if ((countObj != null) && (int_0 > 1)) {
            int int_1 = -1;

            for (int_2 = 0; int_2 < 10; int_2++) {
                if ((int_0 >= countCo[int_2]) && (countCo[int_2] != 0)) {
                    int_1 = countObj[int_2];
                }
            }

            if (int_1 != -1) {
                return TextureProvider.getItemDefinition(int_1).method5092(1);
            }
        }

        final ModelData modeldata_0 = ModelData.method2568(ItemDefinition_modelIndexCache, inventoryModel, 0);
        if (modeldata_0 == null) {
            return null;
        } else {
            if ((resizeX != 128) || (resizeY != 128) || (resizeZ != 128)) {
                modeldata_0.method2592(resizeX, resizeY, resizeZ);
            }

            if (colourToReplace != null) {
                for (int_2 = 0; int_2 < colourToReplace.length; int_2++) {
                    modeldata_0.recolor(colourToReplace[int_2], colourToReplaceWith[int_2]);
                }
            }

            if (textureToReplace != null) {
                for (int_2 = 0; int_2 < textureToReplace.length; int_2++) {
                    modeldata_0.method2582(textureToReplace[int_2], textToReplaceWith[int_2]);
                }
            }

            return modeldata_0;
        }
    }

    public Model getModel(final int int_0) {
        if ((countObj != null) && (int_0 > 1)) {
            int int_1 = -1;

            for (int int_2 = 0; int_2 < 10; int_2++) {
                if ((int_0 >= countCo[int_2]) && (countCo[int_2] != 0)) {
                    int_1 = countObj[int_2];
                }
            }

            if (int_1 != -1) {
                return TextureProvider.getItemDefinition(int_1).getModel(1);
            }
        }

        Model model_0 = (Model) itemModelCache.get(id);
        if (model_0 != null) {
            return model_0;
        } else {
            final ModelData modeldata_0 = ModelData.method2568(ItemDefinition_modelIndexCache, inventoryModel, 0);
            if (modeldata_0 == null) {
                return null;
            } else {
                if ((resizeX != 128) || (resizeY != 128) || (resizeZ != 128)) {
                    modeldata_0.method2592(resizeX, resizeY, resizeZ);
                }

                int int_3;
                if (colourToReplace != null) {
                    for (int_3 = 0; int_3 < colourToReplace.length; int_3++) {
                        modeldata_0.recolor(colourToReplace[int_3], colourToReplaceWith[int_3]);
                    }
                }

                if (textureToReplace != null) {
                    for (int_3 = 0; int_3 < textureToReplace.length; int_3++) {
                        modeldata_0.method2582(textureToReplace[int_3], textToReplaceWith[int_3]);
                    }
                }

                model_0 = modeldata_0.light(ambient + 64, contrast + 768, -50, -10, -50);
                model_0.field1603 = true;
                itemModelCache.put(model_0, id);
                return model_0;
            }
        }
    }

    public ItemComposition method5094(final int int_0) {
        if ((countObj != null) && (int_0 > 1)) {
            int int_1 = -1;

            for (int int_2 = 0; int_2 < 10; int_2++) {
                if ((int_0 >= countCo[int_2]) && (countCo[int_2] != 0)) {
                    int_1 = countObj[int_2];
                }
            }

            if (int_1 != -1) {
                return TextureProvider.getItemDefinition(int_1);
            }
        }

        return this;
    }

    public boolean readyWorn(final boolean bool_0) {
        int int_0 = maleModel;
        int int_1 = maleModel1;
        int int_2 = maleModel2;
        if (bool_0) {
            int_0 = femaleModel;
            int_1 = femaleModel1;
            int_2 = femaleModel2;
        }

        if (int_0 == -1) {
            return true;
        } else {
            boolean bool_1 = true;
            if (!ItemDefinition_modelIndexCache.tryLoadRecord(int_0, 0)) {
                bool_1 = false;
            }

            if ((int_1 != -1) && !ItemDefinition_modelIndexCache.tryLoadRecord(int_1, 0)) {
                bool_1 = false;
            }

            if ((int_2 != -1) && !ItemDefinition_modelIndexCache.tryLoadRecord(int_2, 0)) {
                bool_1 = false;
            }

            return bool_1;
        }
    }

    public ModelData getWornModelData(final boolean bool_0) {
        int int_0 = maleModel;
        int int_1 = maleModel1;
        int int_2 = maleModel2;
        if (bool_0) {
            int_0 = femaleModel;
            int_1 = femaleModel1;
            int_2 = femaleModel2;
        }

        if (int_0 == -1) {
            return null;
        } else {
            ModelData modeldata_0 = ModelData.method2568(ItemDefinition_modelIndexCache, int_0, 0);
            if (int_1 != -1) {
                final ModelData modeldata_1 = ModelData.method2568(ItemDefinition_modelIndexCache, int_1, 0);
                if (int_2 != -1) {
                    final ModelData modeldata_2 = ModelData.method2568(ItemDefinition_modelIndexCache, int_2, 0);
                    final ModelData[] modeldatas_0 = new ModelData[]{modeldata_0, modeldata_1, modeldata_2};
                    modeldata_0 = new ModelData(modeldatas_0, 3);
                } else {
                    final ModelData[] modeldatas_1 = new ModelData[]{modeldata_0, modeldata_1};
                    modeldata_0 = new ModelData(modeldatas_1, 2);
                }
            }

            if (!bool_0 && (maleOffset != 0)) {
                modeldata_0.method2580(0, maleOffset, 0);
            }

            if (bool_0 && (femaleOffset != 0)) {
                modeldata_0.method2580(0, femaleOffset, 0);
            }

            int int_3;
            if (colourToReplace != null) {
                for (int_3 = 0; int_3 < colourToReplace.length; int_3++) {
                    modeldata_0.recolor(colourToReplace[int_3], colourToReplaceWith[int_3]);
                }
            }

            if (textureToReplace != null) {
                for (int_3 = 0; int_3 < textureToReplace.length; int_3++) {
                    modeldata_0.method2582(textureToReplace[int_3], textToReplaceWith[int_3]);
                }
            }

            return modeldata_0;
        }
    }

    public boolean method5097(final boolean bool_0) {
        int int_0 = maleHeadModel;
        int int_1 = maleHeadModel2;
        if (bool_0) {
            int_0 = femaleHeadModel;
            int_1 = femaleHeadModel2;
        }

        if (int_0 == -1) {
            return true;
        } else {
            boolean bool_1 = true;
            if (!ItemDefinition_modelIndexCache.tryLoadRecord(int_0, 0)) {
                bool_1 = false;
            }

            if ((int_1 != -1) && !ItemDefinition_modelIndexCache.tryLoadRecord(int_1, 0)) {
                bool_1 = false;
            }

            return bool_1;
        }
    }

    public ModelData method5098(final boolean bool_0) {
        int int_0 = maleHeadModel;
        int int_1 = maleHeadModel2;
        if (bool_0) {
            int_0 = femaleHeadModel;
            int_1 = femaleHeadModel2;
        }

        if (int_0 == -1) {
            return null;
        } else {
            ModelData modeldata_0 = ModelData.method2568(ItemDefinition_modelIndexCache, int_0, 0);
            if (int_1 != -1) {
                final ModelData modeldata_1 = ModelData.method2568(ItemDefinition_modelIndexCache, int_1, 0);
                final ModelData[] modeldatas_0 = new ModelData[]{modeldata_0, modeldata_1};
                modeldata_0 = new ModelData(modeldatas_0, 2);
            }

            int int_2;
            if (colourToReplace != null) {
                for (int_2 = 0; int_2 < colourToReplace.length; int_2++) {
                    modeldata_0.recolor(colourToReplace[int_2], colourToReplaceWith[int_2]);
                }
            }

            if (textureToReplace != null) {
                for (int_2 = 0; int_2 < textureToReplace.length; int_2++) {
                    modeldata_0.method2582(textureToReplace[int_2], textToReplaceWith[int_2]);
                }
            }

            return modeldata_0;
        }
    }

    public int method5099(final int int_0, final int int_1) {
        return FriendManager.method1668(params, int_0, int_1);
    }

    public String method5121(final int int_0, final String string_0) {
        return WorldMapRectangle.method171(params, int_0, string_0);
    }

    public int getShiftClickActionIndex() {
        return (shiftClickIndex != -1) && (inventoryActions != null)
                ? (shiftClickIndex >= 0 ? (inventoryActions[shiftClickIndex] != null ? shiftClickIndex : -1)
                : ("Drop".equalsIgnoreCase(inventoryActions[4]) ? 4 : -1))
                : -1;
    }

}
