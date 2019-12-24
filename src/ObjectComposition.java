public class ObjectComposition extends CacheableNode {

    public static boolean objectCompositionLowDetail;
    public static IndexDataBase objects_ref;
    static NodeCache objects;
    public static NodeCache field3391;
    static NodeCache cachedModels;
    static NodeCache field3374;
    static ModelData[] field3375;
    static IndexData indexTextures;
    public int id;
    int[] objectModels;
    int[] objectTypes;
    public String name;
    short[] recolorToFind;
    short[] recolorToReplace;
    short[] textureToFind;
    short[] textureToReplace;
    public int width;
    public int length;
    public int clipType;
    public boolean blocksProjectile;
    public int int1;
    int contouredGround;
    boolean nonFlatShading;
    public boolean modelClipped;
    public int animationId;
    public int decorDisplacement;
    int ambient;
    int contrast;
    public String[] actions;
    public int mapIconId;
    public int mapSceneId;
    boolean isRotated;
    public boolean clipped;
    int modelSizeX;
    int modelSizeHeight;
    int modelSizeY;
    int offsetX;
    int offsetHeight;
    int offsetY;
    public boolean obstructsGround;
    boolean isHollow;
    public int supportItems;
    public int[] impostorIds;
    int varpId;
    int configId;
    public int ambientSoundId;
    public int int4;
    public int int5;
    public int int6;
    public int[] field3417;
    IterableHashTable params;

    static {
        objectCompositionLowDetail = false;
        objects = new NodeCache(4096);
        field3391 = new NodeCache(500);
        cachedModels = new NodeCache(30);
        field3374 = new NodeCache(30);
        field3375 = new ModelData[4];
    }

    private void copy(int id) {
        ObjectComposition from = FileOnDisk.getObjectDefinition(id);
        name = from.name;
        width = from.width;
        length = from.length;
        clipType = from.clipType;
        blocksProjectile = from.blocksProjectile;
        int1 = from.int1;
        contouredGround = from.contouredGround;
        nonFlatShading = from.nonFlatShading;
        modelClipped = from.modelClipped;
        animationId = from.animationId;
        decorDisplacement = from.decorDisplacement;
        ambient = from.ambient;
        contrast = from.contrast;
        actions = from.actions;
        mapIconId = from.mapIconId;
        mapSceneId = from.mapSceneId;
        isRotated = from.isRotated;
        clipped = from.clipped;
        modelSizeX = from.modelSizeX;
        modelSizeHeight = from.modelSizeHeight;
        modelSizeY = from.modelSizeY;
        offsetX = from.offsetX;
        offsetHeight = from.offsetHeight;
        offsetY = from.offsetY;
        obstructsGround = from.obstructsGround;
        isHollow = from.isHollow;
        supportItems = from.supportItems;
        varpId = from.varpId;
        configId = from.configId;
        ambientSoundId = from.ambientSoundId;
        int4 = from.int4;
        int5 = from.int5;
        int6 = from.int6;
        objectModels = from.objectModels;
    }

    ObjectComposition() {
        name = "null";
        width = 1;
        length = 1;
        clipType = 2;
        blocksProjectile = true;
        int1 = -1;
        contouredGround = -1;
        nonFlatShading = false;
        modelClipped = false;
        animationId = -1;
        decorDisplacement = 16;
        ambient = 0;
        contrast = 0;
        actions = new String[5];
        mapIconId = -1;
        mapSceneId = -1;
        isRotated = false;
        clipped = true;
        modelSizeX = 128;
        modelSizeHeight = 128;
        modelSizeY = 128;
        offsetX = 0;
        offsetHeight = 0;
        offsetY = 0;
        obstructsGround = false;
        isHollow = false;
        supportItems = -1;
        varpId = -1;
        configId = -1;
        ambientSoundId = -1;
        int4 = 0;
        int5 = 0;
        int6 = 0;
    }

    void post() {
        if (int1 == -1) {
            int1 = 0;
            if ((objectModels != null) && ((objectTypes == null) || (objectTypes[0] == 10))) {
                int1 = 1;
            }

            for (int int_0 = 0; int_0 < 5; int_0++) {
                if (actions[int_0] != null) {
                    int1 = 1;
                }
            }
        }

        if (supportItems == -1) {
            supportItems = clipType != 0 ? 1 : 0;
        }

    }

    void decode(final Buffer buffer_0) {
        while (true) {
            final int int_0 = buffer_0.readUnsignedByte();
            if (int_0 == 0) {
                return;
            }

            loadData(buffer_0, int_0);
        }
    }

    void postDecode() {
        if(id == 1534) {
            /* home room curtains */
            actions[0] = null;
        } else if(id == 18258) {
            /* custom altar */
            actions[0] = "Pray-at";
            actions[1] = "Spellbook";
        } else if(id == 11833) {
            actions[1] = "Practice";
        } else if(id == 32758) {
            name = "Loyalty Chest";
            actions[0] = "Loot";
            actions[1] = "About";
            actions[2] = null;
            actions[3] = null;
            actions[4] = null;
        } else if(id == 32759) {
            name = "Loyalty Chest";
            actions[0] = null;
            actions[1] = null;
            actions[2] = null;
            actions[3] = null;
            actions[4] = null;
        } else if(id == 31379) { //is this obj ever used?????????
            name = "Donation table";
            int1 = 1;
            width = length = 2;
            obstructsGround = false;
            supportItems = 1;
            impostorIds = null;
            objectModels = new int[]{32153};
            varpId = -1;
            actions[0] = "Buy-credits";
        } else if(id == 25203) { // decapitated elvarg corpse
            actions[0] = "Loot";
        } else if(id == 29226) {
            if(WorldType.isPVP()) {
                name = "Pet list";
                actions[4] = null;
            }
        } else if(id == 6045) {
            if(WorldType.isPVP()) {
                actions[0] = "Dump-ore";
            }
        } else if(id == 3581) {
            name = "Ticket exchange";
            actions[0] = "Use";
        } else if(id == 15477) {
            if(WorldType.isPVP()) {
                name = "Chambers of Xeric";
                actions[1] = null;
                actions[2] = null;
                actions[3] = null;
                actions[4] = null;
            }
        } else if(id == 11508 || id == 11509) {
            //curtain
            clipType = 0;
        } else if (id == 30395) { // home portal
            name = "Great Portal";
            actions[0] = "Teleport";
            actions[1] = "Teleport-previous";
        } else if(id == 31380) {
            //uhh i hope 31380 isn't ever used
            name = "Rejuvenation pool";
            int1 = 1;
            width = length = 2;
            animationId = 7304;
            int4 = 3;
            blocksProjectile = false;
            actions[0] = "Drink";
            ambientSoundId = 2149;
            clipType = 1;
            obstructsGround = false;
            impostorIds = null;
            ambient = 40;
            objectModels = new int[]{32101};
            varpId = -1;
        } else if(id == 30352) {
            name = "test";
            actions[1] = "Practice";
        } else if(id == 539) {
            name = "Donator Area";
        } else if(id == 33114) {
            name = "PvP Supply Chest";
            actions[0] = "Check-timer";
        } else if(id == 33115) {
            name = "PvP Supply Chest";
        } else if(id == 31583) {
            name = "PvP Supply Chest";
        } else if(id == 32572) {
            name = "Bloody Chest";
            actions[1] = "Information";
        } else if(id == 32573) {
            name = "Bloody Chest";
            actions[0] = null;
            actions[1] = null;
            actions[2] = null;
            actions[3] = null;
            actions[4] = null;
        } else if (id == 30169) { // Dagannoth kings crack
            actions[0] = "Instance";
            actions[1] = "Peek";
        } else if (id == 1816) { // KBD Lever
            actions[1] = "Instance";
            actions[2] = "Commune";
        } else if (id == 535) { // Thermonuclear smoke devil crevice
            actions[1] = "Instance";
            actions[2] = "Peek";
        } else if (id == 23104) { // Cerberus iron winch
            actions[1] = "Instance";
            actions[2] = "Peek";
        } else if (id == 29705) { // KQ Crack
            actions[0] = "Instance";
            actions[1] = "Peek";
        } else if (id >= 26502 && id <= 26505) { // GWD boss doors
            actions[1] = "Instance";
            actions[2] = "Peek";
        } else if (id == 31618 || id == 4407) { // pvm instance portal
            name = "Boss instance portal";
            actions[0] = "Use";
        } else if(id == 19038) { //christmas tree
            name = "Christmas tree";
            actions[0] = "Grab-present";
        } else if(id == 29709) {
            name = "Snowball Exchange";
            actions[0] = "Open";
            actions[1] = "Information";
        } else if (id == 40000) {
            copy(32546);
            name = "Giveaway booth";
            actions[0] = "Use";
        } else if(id == 40001) {
            copy(4525);
            actions[0] = "Exit";
            actions[1] = null;
            actions[4] = null;
        } else if(id == 40002) {
            copy(32424);
            name = "Consumables";
        } else if(id == 40003) {
            copy(32425);
            name = "Equipment";
        } else if(id == 28925) {
            name = "Fun PVP Portal";
        } else if(id == 14845 || id == 14844) {
            name = "PVP Instance Portal";
        } else if(id == 2654) {
            name = "Bloody Fountain";
            actions[0] = "Drink";
            actions[1] = null;
            modelSizeHeight = 200;
            modelSizeX = 200;
            modelSizeY = 200;
            width = 3;
            length = 3;
        } else if(id == 4470) {
            name = "Donator Zone";
            actions[0] = "Enter";
        } else if(id == 40004) {
            copy(29241);
            actions[4] = null;
        } else if(id == 40005) {
            copy(31858);
            actions[0] = "Pray-at";
            actions[1] = "Spellbook";
            actions[2] = null;
            actions[3] = null;
            actions[4] = null;
        } else if(id == 40006) {
            copy(4537);
            actions[4] = null;
        } else if(id == 40007) {
            copy(13619);
            name = "Fun PVP Portal";
            actions[4] = null;
        } else if(id == 40008) {
            copy(20839);
            name = "Tournament Barrier";
            actions[0] = "Use";
        } else if(id == 40009) {
            copy(18774);
            name = "Cosmetic Chest";
            actions[0] = "Open";
            actions[1] = "View-rewards";
            actions[2] = null;
            actions[3] = null;
            actions[4] = null;
        } else if(id == 31846) {
            name = "Tournament Information";
            actions[0] = "Read";
        } else if(id == 29087) {
            name = "Ticket Exchange";
            actions[0] = "Use";
        } else if(id == 172) {
            name = "Crystal Chest";
        } else if(id == 40010) {
            copy(18775);
            name = "Cosmetic Chest";
            actions[0] = null;
            actions[1] = null;
            actions[2] = null;
            actions[3] = null;
            actions[4] = null;
        }
    }

    void loadData(final Buffer buffer_0, final int int_0) {
        int int_1;
        int int_2;
        if (int_0 == 1) {
            int_1 = buffer_0.readUnsignedByte();
            if (int_1 > 0) {
                if ((objectModels != null) && !objectCompositionLowDetail) {
                    buffer_0.offset += 3 * int_1;
                } else {
                    objectTypes = new int[int_1];
                    objectModels = new int[int_1];

                    for (int_2 = 0; int_2 < int_1; int_2++) {
                        objectModels[int_2] = buffer_0.readUnsignedShort();
                        objectTypes[int_2] = buffer_0.readUnsignedByte();
                    }
                }
            }
        } else if (int_0 == 2) {
            name = buffer_0.readString();
        } else if (int_0 == 5) {
            int_1 = buffer_0.readUnsignedByte();
            if (int_1 > 0) {
                if ((objectModels != null) && !objectCompositionLowDetail) {
                    buffer_0.offset += 2 * int_1;
                } else {
                    objectTypes = null;
                    objectModels = new int[int_1];

                    for (int_2 = 0; int_2 < int_1; int_2++) {
                        objectModels[int_2] = buffer_0.readUnsignedShort();
                    }
                }
            }
        } else if (int_0 == 14) {
            width = buffer_0.readUnsignedByte();
        } else if (int_0 == 15) {
            length = buffer_0.readUnsignedByte();
        } else if (int_0 == 17) {
            clipType = 0;
            blocksProjectile = false;
        } else if (int_0 == 18) {
            blocksProjectile = false;
        } else if (int_0 == 19) {
            int1 = buffer_0.readUnsignedByte();
        } else if (int_0 == 21) {
            contouredGround = 0;
        } else if (int_0 == 22) {
            nonFlatShading = true;
        } else if (int_0 == 23) {
            modelClipped = true;
        } else if (int_0 == 24) {
            animationId = buffer_0.readUnsignedShort();
            if (animationId == 65535) {
                animationId = -1;
            }
        } else if (int_0 == 27) {
            clipType = 1;
        } else if (int_0 == 28) {
            decorDisplacement = buffer_0.readUnsignedByte();
        } else if (int_0 == 29) {
            ambient = buffer_0.readByte();
        } else if (int_0 == 39) {
            contrast = buffer_0.readByte() * 25;
        } else if ((int_0 >= 30) && (int_0 < 35)) {
            actions[int_0 - 30] = buffer_0.readString();
            if (actions[int_0 - 30].equalsIgnoreCase("Hidden")) {
                actions[int_0 - 30] = null;
            }
        } else if (int_0 == 40) {
            int_1 = buffer_0.readUnsignedByte();
            recolorToFind = new short[int_1];
            recolorToReplace = new short[int_1];

            for (int_2 = 0; int_2 < int_1; int_2++) {
                recolorToFind[int_2] = (short) buffer_0.readUnsignedShort();
                recolorToReplace[int_2] = (short) buffer_0.readUnsignedShort();
            }
        } else if (int_0 == 41) {
            int_1 = buffer_0.readUnsignedByte();
            textureToFind = new short[int_1];
            textureToReplace = new short[int_1];

            for (int_2 = 0; int_2 < int_1; int_2++) {
                textureToFind[int_2] = (short) buffer_0.readUnsignedShort();
                textureToReplace[int_2] = (short) buffer_0.readUnsignedShort();
            }
        } else if (int_0 == 62) {
            isRotated = true;
        } else if (int_0 == 64) {
            clipped = false;
        } else if (int_0 == 65) {
            modelSizeX = buffer_0.readUnsignedShort();
        } else if (int_0 == 66) {
            modelSizeHeight = buffer_0.readUnsignedShort();
        } else if (int_0 == 67) {
            modelSizeY = buffer_0.readUnsignedShort();
        } else if (int_0 == 68) {
            mapSceneId = buffer_0.readUnsignedShort();
        } else if (int_0 == 69) {
            buffer_0.readUnsignedByte();
        } else if (int_0 == 70) {
            offsetX = buffer_0.readShort();
        } else if (int_0 == 71) {
            offsetHeight = buffer_0.readShort();
        } else if (int_0 == 72) {
            offsetY = buffer_0.readShort();
        } else if (int_0 == 73) {
            obstructsGround = true;
        } else if (int_0 == 74) {
            isHollow = true;
        } else if (int_0 == 75) {
            supportItems = buffer_0.readUnsignedByte();
        } else if ((int_0 != 77) && (int_0 != 92)) {
            if (int_0 == 78) {
                ambientSoundId = buffer_0.readUnsignedShort();
                int4 = buffer_0.readUnsignedByte();
            } else if (int_0 == 79) {
                int5 = buffer_0.readUnsignedShort();
                int6 = buffer_0.readUnsignedShort();
                int4 = buffer_0.readUnsignedByte();
                int_1 = buffer_0.readUnsignedByte();
                field3417 = new int[int_1];

                for (int_2 = 0; int_2 < int_1; int_2++) {
                    field3417[int_2] = buffer_0.readUnsignedShort();
                }
            } else if (int_0 == 81) {
                contouredGround = buffer_0.readUnsignedByte() * 256;
            } else if (int_0 == 82) {
                mapIconId = buffer_0.readUnsignedShort();
            } else if (int_0 == 249) {
                params = KeyFocusListener.readStringIntParameters(buffer_0, params);
            }
        } else {
            varpId = buffer_0.readUnsignedShort();
            if (varpId == 65535) {
                varpId = -1;
            }

            configId = buffer_0.readUnsignedShort();
            if (configId == 65535) {
                configId = -1;
            }

            int_1 = -1;
            if (int_0 == 92) {
                int_1 = buffer_0.readUnsignedShort();
                if (int_1 == 65535) {
                    int_1 = -1;
                }
            }

            int_2 = buffer_0.readUnsignedByte();
            impostorIds = new int[int_2 + 2];

            for (int int_3 = 0; int_3 <= int_2; int_3++) {
                impostorIds[int_3] = buffer_0.readUnsignedShort();
                if (impostorIds[int_3] == 65535) {
                    impostorIds[int_3] = -1;
                }
            }

            impostorIds[int_2 + 1] = int_1;
        }

    }

    public boolean method5048(final int int_0) {
        if (objectTypes != null) {
            for (int int_2 = 0; int_2 < objectTypes.length; int_2++) {
                if (objectTypes[int_2] == int_0) {
                    return Frames.field1801.tryLoadRecord(objectModels[int_2] & 0xFFFF, 0);
                }
            }

            return true;
        } else if (objectModels == null) {
            return true;
        } else if (int_0 != 10) {
            return true;
        } else {
            boolean bool_0 = true;

            for (int int_1 = 0; int_1 < objectModels.length; int_1++) {
                bool_0 &= Frames.field1801.tryLoadRecord(objectModels[int_1] & 0xFFFF, 0);
            }

            return bool_0;
        }
    }

    public boolean method5051() {
        if (objectModels == null) {
            return true;
        } else {
            boolean bool_0 = true;

            for (int int_0 = 0; int_0 < objectModels.length; int_0++) {
                bool_0 &= Frames.field1801.tryLoadRecord(objectModels[int_0] & 0xFFFF, 0);
            }

            return bool_0;
        }
    }

    public Renderable getModel(final int int_0, final int int_1, final int[][] ints_0, final int int_2, final int int_3,
                               final int int_4) {
        long long_0;
        if (objectTypes == null) {
            long_0 = int_1 + (id << 10);
        } else {
            long_0 = int_1 + (int_0 << 3) + (id << 10);
        }

        Object object_0 = cachedModels.get(long_0);
        if (object_0 == null) {
            final ModelData modeldata_0 = this.getModel(int_0, int_1);
            if (modeldata_0 == null) {
                return null;
            }

            if (!nonFlatShading) {
                object_0 = modeldata_0.light(ambient + 64, contrast + 768, -50, -10, -50);
            } else {
                modeldata_0.field1486 = (short) (ambient + 64);
                modeldata_0.contrast = (short) (contrast + 768);
                modeldata_0.computeNormals();
                object_0 = modeldata_0;
            }

            cachedModels.put((CacheableNode) object_0, long_0);
        }

        if (nonFlatShading) {
            object_0 = ((ModelData) object_0).method2650();
        }

        if (contouredGround >= 0) {
            if (object_0 instanceof Model) {
                object_0 = ((Model) object_0).method2665(ints_0, int_2, int_3, int_4, true, contouredGround);
            } else if (object_0 instanceof ModelData) {
                object_0 = ((ModelData) object_0).method2567(ints_0, int_2, int_3, int_4, true, contouredGround);
            }
        }

        return (Renderable) object_0;
    }

    public Model method5031(final int int_0, final int int_1, final int[][] ints_0, final int int_2, final int int_3,
                            final int int_4) {
        long long_0;
        if (objectTypes == null) {
            long_0 = int_1 + (id << 10);
        } else {
            long_0 = int_1 + (int_0 << 3) + (id << 10);
        }

        Model model_0 = (Model) field3374.get(long_0);
        if (model_0 == null) {
            final ModelData modeldata_0 = this.getModel(int_0, int_1);
            if (modeldata_0 == null) {
                return null;
            }

            model_0 = modeldata_0.light(ambient + 64, contrast + 768, -50, -10, -50);
            field3374.put(model_0, long_0);
        }

        if (contouredGround >= 0) {
            model_0 = model_0.method2665(ints_0, int_2, int_3, int_4, true, contouredGround);
        }

        return model_0;
    }

    public Model method5032(final int int_0, final int int_1, final int[][] ints_0, final int int_2, final int int_3,
                            final int int_4, final Sequence sequence_0, final int int_5) {
        long long_0;
        if (objectTypes == null) {
            long_0 = int_1 + (id << 10);
        } else {
            long_0 = int_1 + (int_0 << 3) + (id << 10);
        }

        Model model_0 = (Model) field3374.get(long_0);
        if (model_0 == null) {
            final ModelData modeldata_0 = this.getModel(int_0, int_1);
            if (modeldata_0 == null) {
                return null;
            }

            model_0 = modeldata_0.light(ambient + 64, contrast + 768, -50, -10, -50);
            field3374.put(model_0, long_0);
        }

        if ((sequence_0 == null) && (contouredGround == -1)) {
            return model_0;
        } else {
            if (sequence_0 != null) {
                model_0 = sequence_0.transformObjectModel(model_0, int_5, int_1);
            } else {
                model_0 = model_0.toSharedModel(true);
            }

            if (contouredGround >= 0) {
                model_0 = model_0.method2665(ints_0, int_2, int_3, int_4, false, contouredGround);
            }

            return model_0;
        }
    }

    ModelData getModel(final int int_0, int int_1) {
        ModelData modeldata_0 = null;
        boolean bool_0;
        int int_2;
        int int_4;
        if (objectTypes == null) {
            if (int_0 != 10) {
                return null;
            }

            if (objectModels == null) {
                return null;
            }

            bool_0 = isRotated;
            if ((int_0 == 2) && (int_1 > 3)) {
                bool_0 = !bool_0;
            }

            int_2 = objectModels.length;

            for (int int_3 = 0; int_3 < int_2; int_3++) {
                int_4 = objectModels[int_3];
                if (bool_0) {
                    int_4 += 65536;
                }

                modeldata_0 = (ModelData) field3391.get(int_4);
                if (modeldata_0 == null) {
                    modeldata_0 = ModelData.method2568(Frames.field1801, int_4 & 0xFFFF, 0);
                    if (modeldata_0 == null) {
                        return null;
                    }

                    if (bool_0) {
                        modeldata_0.method2583();
                    }

                    field3391.put(modeldata_0, int_4);
                }

                if (int_2 > 1) {
                    field3375[int_3] = modeldata_0;
                }
            }

            if (int_2 > 1) {
                modeldata_0 = new ModelData(field3375, int_2);
            }
        } else {
            int int_5 = -1;

            for (int_2 = 0; int_2 < objectTypes.length; int_2++) {
                if (objectTypes[int_2] == int_0) {
                    int_5 = int_2;
                    break;
                }
            }

            if (int_5 == -1) {
                return null;
            }

            int_2 = objectModels[int_5];
            final boolean bool_1 = isRotated ^ (int_1 > 3);
            if (bool_1) {
                int_2 += 65536;
            }

            modeldata_0 = (ModelData) field3391.get(int_2);
            if (modeldata_0 == null) {
                modeldata_0 = ModelData.method2568(Frames.field1801, int_2 & 0xFFFF, 0);
                if (modeldata_0 == null) {
                    return null;
                }

                if (bool_1) {
                    modeldata_0.method2583();
                }

                field3391.put(modeldata_0, int_2);
            }
        }

        bool_0 = (modelSizeX != 128) || (modelSizeHeight != 128) || (modelSizeY != 128);

        boolean bool_2;
        bool_2 = (offsetX != 0) || (offsetHeight != 0) || (offsetY != 0);

        final ModelData modeldata_1 = new ModelData(modeldata_0, (int_1 == 0) && !bool_0 && !bool_2,
                recolorToFind == null, textureToFind == null, true);
        if ((int_0 == 4) && (int_1 > 3)) {
            modeldata_1.method2653(256);
            modeldata_1.method2580(45, 0, -45);
        }

        int_1 &= 0x3;
        if (int_1 == 1) {
            modeldata_1.method2576();
        } else if (int_1 == 2) {
            modeldata_1.method2573();
        } else if (int_1 == 3) {
            modeldata_1.method2578();
        }

        if (recolorToFind != null) {
            for (int_4 = 0; int_4 < recolorToFind.length; int_4++) {
                modeldata_1.recolor(recolorToFind[int_4], recolorToReplace[int_4]);
            }
        }

        if (textureToFind != null) {
            for (int_4 = 0; int_4 < textureToFind.length; int_4++) {
                modeldata_1.method2582(textureToFind[int_4], textureToReplace[int_4]);
            }
        }

        if (bool_0) {
            modeldata_1.method2592(modelSizeX, modelSizeHeight, modelSizeY);
        }

        if (bool_2) {
            modeldata_1.method2580(offsetX, offsetHeight, offsetY);
        }

        return modeldata_1;
    }

    public ObjectComposition getImpostor() {
        int int_0 = -1;
        if (varpId != -1) {
            int_0 = GameSocket.getVarbit(varpId);
        } else if (configId != -1) {
            int_0 = class225.clientVarps[configId];
        }

        int int_1;
        if ((int_0 >= 0) && (int_0 < (impostorIds.length - 1))) {
            int_1 = impostorIds[int_0];
        } else {
            int_1 = impostorIds[impostorIds.length - 1];
        }

        return int_1 != -1 ? FileOnDisk.getObjectDefinition(int_1) : null;
    }

    public int method5035(final int int_0, final int int_1) {
        return FriendManager.method1668(params, int_0, int_1);
    }

    public String method5036(final int int_0, final String string_0) {
        return WorldMapRectangle.method171(params, int_0, string_0);
    }

    public boolean method5024() {
        if (impostorIds == null) {
            return (ambientSoundId != -1) || (field3417 != null);
        } else {
            for (int int_0 = 0; int_0 < impostorIds.length; int_0++) {
                if (impostorIds[int_0] != -1) {
                    final ObjectComposition objectcomposition_1 = FileOnDisk.getObjectDefinition(impostorIds[int_0]);
                    if ((objectcomposition_1.ambientSoundId != -1) || (objectcomposition_1.field3417 != null)) {
                        return true;
                    }
                }
            }

            return false;
        }
    }

    static void decodeSprite(final byte[] bytes_0) {
        final Buffer buffer_0 = new Buffer(bytes_0);
        buffer_0.offset = bytes_0.length - 2;
        class319.indexedSpriteCount = buffer_0.readUnsignedShort();
        class7.indexedSpriteOffsetXs = new int[class319.indexedSpriteCount];
        class225.indexedSpriteOffsetYs = new int[class319.indexedSpriteCount];
        class319.indexSpriteWidths = new int[class319.indexedSpriteCount];
        class319.indexedSpriteHeights = new int[class319.indexedSpriteCount];
        class319.spritePixels = new byte[class319.indexedSpriteCount][];
        buffer_0.offset = bytes_0.length - 7 - (class319.indexedSpriteCount * 8);
        class305.indexedSpriteWidth = buffer_0.readUnsignedShort();
        class319.indexedSpriteHeight = buffer_0.readUnsignedShort();
        final int int_0 = (buffer_0.readUnsignedByte() & 0xFF) + 1;

        int int_1;
        for (int_1 = 0; int_1 < class319.indexedSpriteCount; int_1++) {
            class7.indexedSpriteOffsetXs[int_1] = buffer_0.readUnsignedShort();
        }

        for (int_1 = 0; int_1 < class319.indexedSpriteCount; int_1++) {
            class225.indexedSpriteOffsetYs[int_1] = buffer_0.readUnsignedShort();
        }

        for (int_1 = 0; int_1 < class319.indexedSpriteCount; int_1++) {
            class319.indexSpriteWidths[int_1] = buffer_0.readUnsignedShort();
        }

        for (int_1 = 0; int_1 < class319.indexedSpriteCount; int_1++) {
            class319.indexedSpriteHeights[int_1] = buffer_0.readUnsignedShort();
        }

        buffer_0.offset = bytes_0.length - 7 - (class319.indexedSpriteCount * 8) - ((int_0 - 1) * 3);
        PacketNode.indexedSpritePalette = new int[int_0];

        for (int_1 = 1; int_1 < int_0; int_1++) {
            PacketNode.indexedSpritePalette[int_1] = buffer_0.read24BitInt();
            if (PacketNode.indexedSpritePalette[int_1] == 0) {
                PacketNode.indexedSpritePalette[int_1] = 1;
            }
        }

        buffer_0.offset = 0;

        for (int_1 = 0; int_1 < class319.indexedSpriteCount; int_1++) {
            final int int_2 = class319.indexSpriteWidths[int_1];
            final int int_3 = class319.indexedSpriteHeights[int_1];
            final int int_4 = int_2 * int_3;
            final byte[] bytes_1 = new byte[int_4];
            class319.spritePixels[int_1] = bytes_1;
            final int int_5 = buffer_0.readUnsignedByte();
            int int_6;
            if (int_5 == 0) {
                for (int_6 = 0; int_6 < int_4; int_6++) {
                    bytes_1[int_6] = buffer_0.readByte();
                }
            } else if (int_5 == 1) {
                for (int_6 = 0; int_6 < int_2; int_6++) {
                    for (int int_7 = 0; int_7 < int_3; int_7++) {
                        bytes_1[int_6 + (int_7 * int_2)] = buffer_0.readByte();
                    }
                }
            }
        }

    }

    static void method5085() {
        for (int int_0 = 0; int_0 < Game.queuedSoundEffectCount; int_0++) {
            --Game.unknownSoundValues2[int_0];
            if (Game.unknownSoundValues2[int_0] >= -10) {
                SoundEffect soundeffect_0 = Game.audioEffects[int_0];
                if (soundeffect_0 == null) {
                    soundeffect_0 = SoundEffect.getTrack(UrlRequester.indexCache4, Game.queuedSoundEffectIDs[int_0],
                            0);
                    if (soundeffect_0 == null) {
                        continue;
                    }

                    Game.unknownSoundValues2[int_0] += soundeffect_0.calculateDelay();
                    Game.audioEffects[int_0] = soundeffect_0;
                }

                if (Game.unknownSoundValues2[int_0] < 0) {
                    int int_8;
                    if (Game.soundLocations[int_0] != 0) {
                        final int int_2 = (Game.soundLocations[int_0] & 0xFF) * 128;
                        final int int_3 = (Game.soundLocations[int_0] >> 16) & 0xFF;
                        int int_4 = ((int_3 * 128) + 64) - class138.localPlayer.x;
                        if (int_4 < 0) {
                            int_4 = -int_4;
                        }

                        final int int_5 = (Game.soundLocations[int_0] >> 8) & 0xFF;
                        int int_6 = ((int_5 * 128) + 64) - class138.localPlayer.y;
                        if (int_6 < 0) {
                            int_6 = -int_6;
                        }

                        int int_7 = (int_6 + int_4) - 128;
                        if (int_7 > int_2) {
                            Game.unknownSoundValues2[int_0] = -100;
                            continue;
                        }

                        if (int_7 < 0) {
                            int_7 = 0;
                        }

                        int_8 = ((int_2 - int_7) * Game.field815) / int_2;
                    } else {
                        int_8 = Game.field814;
                    }

                    if (int_8 > 0) {
                        final RawAudioNode rawaudionode_0 = soundeffect_0.method2069()
                                .applyResampler(OwnWorldComparator.field577);
                        final class103 class103_0 = class103.method2287(rawaudionode_0, 100, int_8);
                        class103_0.method2258(Game.unknownSoundValues1[int_0] - 1);
                        MapIconReference.field310.method2032(class103_0);
                    }

                    Game.unknownSoundValues2[int_0] = -100;
                }
            } else {
                --Game.queuedSoundEffectCount;

                for (int int_1 = int_0; int_1 < Game.queuedSoundEffectCount; int_1++) {
                    Game.queuedSoundEffectIDs[int_1] = Game.queuedSoundEffectIDs[int_1 + 1];
                    Game.audioEffects[int_1] = Game.audioEffects[int_1 + 1];
                    Game.unknownSoundValues1[int_1] = Game.unknownSoundValues1[int_1 + 1];
                    Game.unknownSoundValues2[int_1] = Game.unknownSoundValues2[int_1 + 1];
                    Game.soundLocations[int_1] = Game.soundLocations[int_1 + 1];
                }

                --int_0;
            }
        }

        if (Game.field813) {
            boolean bool_0;
            if (class217.field2460 != 0) {
                bool_0 = true;
            } else {
                bool_0 = class217.field2459.method4203();
            }

            if (!bool_0) {
                if ((Game.field811 != 0) && (Game.field812 != -1)) {
                    Actor.method1554(Item.indexTrack1, Game.field812, 0, Game.field811, false);
                }

                Game.field813 = false;
            }
        }

    }

}
