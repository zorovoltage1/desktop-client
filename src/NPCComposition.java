public class NPCComposition extends CacheableNode {

    public static IndexDataBase NpcDefinition_indexCache;
    public static IndexDataBase NpcDefinition_modelIndexCache;
    public static NodeCache npcs;
    public static NodeCache npcModelCache;
    public int id;
    public String name;
    public int size;
    int[] models;
    int[] additionalModels;
    public int standingAnimation;
    public int field3496;
    public int field3486;
    public int walkingAnimation;
    public int rotate180Animation;
    public int rotate90RightAnimation;
    public int rotate90LeftAnimation;
    short[] colors;
    short[] modifiedColors;
    short[] textureToReplace;
    short[] textureToReplaceWith;
    public String[] actions;
    public boolean isMinimapVisible;
    public int combatLevel;
    int widthScale;
    int heightScale;
    public boolean isVisible;
    int ambient;
    int contrast;
    public int headIcon;
    public int rotation;
    public int[] configs;
    int varpIndex;
    int varp32Index;
    public boolean field3504;
    public boolean isClickable;
    public boolean field3517;
    IterableHashTable params;


    void copy(int otherId) {
        NPCComposition otherDef = HorizontalAlignment.getNpcDefinition(otherId);

        isMinimapVisible = otherDef.isMinimapVisible;
        standingAnimation = otherDef.standingAnimation;
        size = otherDef.size;
        rotate180Animation = otherDef.rotate180Animation;
        name = otherDef.name;
        field3496 = otherDef.field3496;
        field3486 = otherDef.field3486;
        walkingAnimation = otherDef.walkingAnimation;
        rotate90LeftAnimation = otherDef.rotate90LeftAnimation;
        rotate90RightAnimation = otherDef.rotate90RightAnimation;
        field3517 = otherDef.field3517;
        actions = otherDef.actions == null ? null : otherDef.actions.clone();
        combatLevel = otherDef.combatLevel;
        isVisible = otherDef.isVisible;
        headIcon = otherDef.headIcon;
        rotation = otherDef.rotation;
        configs = otherDef.configs == null ? null : otherDef.configs.clone();
        isClickable = otherDef.isClickable;
        field3504 = otherDef.field3504;
        textureToReplace = otherDef.textureToReplace == null ? null : otherDef.textureToReplace.clone();
        textureToReplaceWith = otherDef.textureToReplaceWith == null ? null : otherDef.textureToReplaceWith.clone();
        varp32Index = otherDef.varp32Index;
        models = otherDef.models;
        colors = otherDef.colors == null ? null : otherDef.colors.clone();
        additionalModels = otherDef.additionalModels == null ? null : otherDef.additionalModels.clone();
        varpIndex = otherDef.varpIndex;
        modifiedColors = modifiedColors == null ? null : otherDef.modifiedColors.clone();
        widthScale = otherDef.widthScale;
        heightScale = otherDef.heightScale;
        ambient = otherDef.ambient;
        contrast = otherDef.contrast;
    }

    static {
        npcs = new NodeCache(64);
        npcModelCache = new NodeCache(50);
    }

    NPCComposition() {
        name = "null";
        size = 1;
        standingAnimation = -1;
        field3496 = -1;
        field3486 = -1;
        walkingAnimation = -1;
        rotate180Animation = -1;
        rotate90RightAnimation = -1;
        rotate90LeftAnimation = -1;
        actions = new String[5];
        isMinimapVisible = true;
        combatLevel = -1;
        widthScale = 128;
        heightScale = 128;
        isVisible = false;
        ambient = 0;
        contrast = 0;
        headIcon = -1;
        rotation = 32;
        varpIndex = -1;
        varp32Index = -1;
        field3504 = true;
        isClickable = true;
        field3517 = false;
    }

    void post() {
    }

    void decode(final Buffer buffer_0) {
        while (true) {
            final int int_0 = buffer_0.readUnsignedByte();
            if (int_0 == 0) {
                return;
            }

            readNext(buffer_0, int_0);
        }
    }

    void postDecode() {
        if (id == 5527) {
            /* Twiggy O'Korn */
            actions[2] = "Rewards";
        } else if (id == 315) {
            name = "Rustin";
            actions[0] = "Trade";
            actions[2] = "Set-skull";
            actions[3] = "Reset-kdr";
            actions[4] = null;
        } else if (id == 1815) {
            name = "Vote Manager";
            actions[0] = "Trade";
            actions[2] = "Cast-votes";
            actions[3] = "Claim-votes";
        } else if (id == 2108) {
            name = "Credit Manager";
            actions[0] = "Open-shop";
            actions[2] = "Claim-purchases";
        } else if (id == 306) {
            name = Loader.SERVER_NAME + " Expert";
            actions[0] = "Talk-to";
            if(WorldType.isPVP())
                actions[2] = "View-help";
            actions[3] = "View-guide";
            if(WorldType.isPVP())
                actions[4] = "Task-rewards";
        } else if (id == 5442) {
            name = "Security Advisor";
            //actions[2] = "Check Pin Settings";
            //actions[3] = "Check 2FA Settings";
        } else if (id == 535) {
            /* Horvik */
            actions[0] = "Repair-items";
            actions[2] = "Upgrade-items";
        } else if (id == 3894) {
            /* Sigmund the Merchant */
            actions[0] = null;
            actions[2] = "Buy-items";
            actions[3] = "Sell-items";
            actions[4] = "Sets";
        } else if (id == 4398) {
            /* ECO Wizard */
            name = Loader.SERVER_NAME + " Wizard";
            actions[0] = "Teleport";
            actions[2] = "Teleport-previous";
        } else if (id == 4159) {
            /* PVP Wizard */
            name = Loader.SERVER_NAME + " Wizard";
            actions[0] = "Teleport";
            actions[2] = "Teleport-previous";
        } else if (id == 2462) {
            /* Shanomi */
            actions[2] = "Trade";
        } else if (id == 6481) {
            /* Mac */
            actions[0] = "Buy-capes";
            actions[2] = WorldType.isPVP() ? null : "Reset-levels";
            actions[3] = "Decant-potions";
            combatLevel = 0;
        } else if (id == 3343) {
            name = Loader.SERVER_NAME + " Nurse";
        } else if (id == 1603) {
            /* Kolodion */
            name = "Battle Point Exchange";
            actions[2] = "Trade";
            actions[3] = "Check-points";
        } else if (id == 3278) {
            name = "Construction Worker";
        } else if (id == 1307) {
            actions[0] = "Change-looks";
            actions[2] = "Skin-unlocks";
            actions[3] = "Title-unlocks";
            actions[4] = null;
        } else if (id == 4225) {
            name = "Shop";
            actions[0] = "Untradeable";
        } else if (id == 6650) {
            name = "Shop";
            actions[0] = "Ornament";
            actions[2] = null;
        } else if (id == 1199) {
            name = "Shop";
            actions[0] = "Consumable";
        } else if (id == 5081) {
            name = "Shop";
            actions[0] = "Magic";
        } else if (id == 5051) {
            name = "Shop";
            actions[0] = "Ranged";
        } else if (id == 2153) {
            name = "Shop";
            actions[0] = "Melee";
        } else if (id == 4579) {
            name = "Shop";
            actions[0] = "Misc";
        } else if (id == 2668) {
            if (WorldType.isPVP()) {
                name = "Max hit dummy";
                actions[2] = null;
                actions[3] = null;
                actions[4] = null;
            }
        } else if (id == 6118) {
            name = "Elvarg";
            combatLevel = 280;
        } else if (id == 3358) {
            name = "Ket'ian";
            combatLevel = 420;
            widthScale *= 2;
            heightScale *= 2;
            size = 2;
        } else if (id == 5906) {
            actions[2] = null;
        } else if ("Pick-up".equals(actions[0]) && "Talk-to".equals(actions[2]) && "Chase".equals(actions[3]) && "Interact".equals(actions[4])) {
            actions[3] = "Age";
            actions[4] = null;
        } else if (id == 1849) {
            name = "Loyalty Fairy";
            actions[0] = "About";
        } else if (id == 7759) {
            actions[0] = actions[2] = null;
        } else if (id == 7316) {
            name = "Tournament Manager";
            actions[0] = "Sign-up";
        } else if (id == 7941) {
            name = "Rustin";
            actions[2] = actions[3] = actions[4] = null;
        } else if (id == 3080) { // man at home. remove attack option so people can't be assholes to newbies that are just starting out
            actions[1] = null;
            combatLevel = 0;
        } else if (id == 307) { // second guide npc (with no options); originally dr jekyll
            name = Loader.SERVER_NAME + " Expert";
            actions[0] = null;
            actions[4] = null;
            models = new int[]{214, 250, 5674, 5668, 5672, 7127, 7123};
            additionalModels = new int[]{52, 82};
            colors = new short[]{6466, 5541, 6457, 8844, 6798};
            modifiedColors = new short[]{127, -24254, 127, 6478, -11139};
            standingAnimation = 813;
            walkingAnimation = 1205;
        } else if(WorldType.isPVP() && id == 311) {
            name = "Ironman";
            actions[1] = "Open-shop";
            actions[2] = null;
        } else if(id == 7951) {
            name = "PvP Event Manager";
            actions[0] = "Join-event";
            actions[1] = "Create-event";
        } else if(id == 8009) {
            actions[3] = "Metamorphosis";
        } else if(id == 8507) {
            name = "Bloody Merchant";
            actions[0] = "Trade";
        } else if(id == 7297) { // Skotizo (For eco world)
            // Replaces Mistag
            copy(7286);
        } else if(id == 6002) {
            name = "Novea Caretaker";
            actions[0] = "Trade";
        } else if(id == 8500) {
            name = "Old man";
            actions[1] = "Trade";
        }
    }

    void readNext(final Buffer buffer_0, final int int_0) {
        int int_1;
        int int_2;
        if (int_0 == 1) {
            int_1 = buffer_0.readUnsignedByte();
            models = new int[int_1];

            for (int_2 = 0; int_2 < int_1; int_2++) {
                models[int_2] = buffer_0.readUnsignedShort();
                if(id == 4420) {
                    System.out.println(models[int_2]);
                }
            }
        } else if (int_0 == 2) {
            name = buffer_0.readString();
        } else if (int_0 == 12) {
            size = buffer_0.readUnsignedByte();
        } else if (int_0 == 13) {
            standingAnimation = buffer_0.readUnsignedShort();
        } else if (int_0 == 14) {
            walkingAnimation = buffer_0.readUnsignedShort();
        } else if (int_0 == 15) {
            field3496 = buffer_0.readUnsignedShort();
        } else if (int_0 == 16) {
            field3486 = buffer_0.readUnsignedShort();
        } else if (int_0 == 17) {
            walkingAnimation = buffer_0.readUnsignedShort();
            rotate180Animation = buffer_0.readUnsignedShort();
            rotate90RightAnimation = buffer_0.readUnsignedShort();
            rotate90LeftAnimation = buffer_0.readUnsignedShort();
        } else if ((int_0 >= 30) && (int_0 < 35)) {
            actions[int_0 - 30] = buffer_0.readString();
            if (actions[int_0 - 30].equalsIgnoreCase("Hidden")) {
                actions[int_0 - 30] = null;
            }
        } else if (int_0 == 40) {
            int_1 = buffer_0.readUnsignedByte();
            colors = new short[int_1];
            modifiedColors = new short[int_1];

            for (int_2 = 0; int_2 < int_1; int_2++) {
                colors[int_2] = (short) buffer_0.readUnsignedShort();
                modifiedColors[int_2] = (short) buffer_0.readUnsignedShort();
            }
        } else if (int_0 == 41) {
            int_1 = buffer_0.readUnsignedByte();
            textureToReplace = new short[int_1];
            textureToReplaceWith = new short[int_1];

            for (int_2 = 0; int_2 < int_1; int_2++) {
                textureToReplace[int_2] = (short) buffer_0.readUnsignedShort();
                textureToReplaceWith[int_2] = (short) buffer_0.readUnsignedShort();
            }
        } else if (int_0 == 60) {
            int_1 = buffer_0.readUnsignedByte();
            additionalModels = new int[int_1];

            for (int_2 = 0; int_2 < int_1; int_2++) {
                additionalModels[int_2] = buffer_0.readUnsignedShort();
            }
        } else if (int_0 == 93) {
            isMinimapVisible = false;
        } else if (int_0 == 95) {
            combatLevel = buffer_0.readUnsignedShort();
        } else if (int_0 == 97) {
            widthScale = buffer_0.readUnsignedShort();
        } else if (int_0 == 98) {
            heightScale = buffer_0.readUnsignedShort();
        } else if (int_0 == 99) {
            isVisible = true;
        } else if (int_0 == 100) {
            ambient = buffer_0.readByte();
        } else if (int_0 == 101) {
            contrast = buffer_0.readByte() * 5;
        } else if (int_0 == 102) {
            headIcon = buffer_0.readUnsignedShort();
        } else if (int_0 == 103) {
            rotation = buffer_0.readUnsignedShort();
        } else if ((int_0 != 106) && (int_0 != 118)) {
            if (int_0 == 107) {
                field3504 = false;
            } else if (int_0 == 109) {
                isClickable = false;
            } else if (int_0 == 111) {
                field3517 = true;
            } else if (int_0 == 249) {
                params = KeyFocusListener.readStringIntParameters(buffer_0, params);
            }
        } else {
            varpIndex = buffer_0.readUnsignedShort();
            if (varpIndex == 65535) {
                varpIndex = -1;
            }

            varp32Index = buffer_0.readUnsignedShort();
            if (varp32Index == 65535) {
                varp32Index = -1;
            }

            int_1 = -1;
            if (int_0 == 118) {
                int_1 = buffer_0.readUnsignedShort();
                if (int_1 == 65535) {
                    int_1 = -1;
                }
            }

            int_2 = buffer_0.readUnsignedByte();
            configs = new int[int_2 + 2];

            for (int int_3 = 0; int_3 <= int_2; int_3++) {
                configs[int_3] = buffer_0.readUnsignedShort();
                if (configs[int_3] == 65535) {
                    configs[int_3] = -1;
                }
            }

            configs[int_2 + 1] = int_1;
        }

    }

    public Model getModel(final Sequence sequence_0, final int int_0, final Sequence sequence_1, final int int_1) {
        if (configs != null) {
            final NPCComposition npccomposition_1 = transform();
            return npccomposition_1 == null ? null : npccomposition_1.getModel(sequence_0, int_0, sequence_1, int_1);
        } else {
            Model model_0 = (Model) npcModelCache.get(id);
            if (model_0 == null) {
                boolean bool_0 = false;

                for (int int_2 = 0; int_2 < models.length; int_2++) {
                    if (!NpcDefinition_modelIndexCache.tryLoadRecord(models[int_2], 0)) {
                        bool_0 = true;
                    }
                }

                if (bool_0) {
                    return null;
                }

                final ModelData[] modeldatas_0 = new ModelData[models.length];

                int int_3;
                for (int_3 = 0; int_3 < models.length; int_3++) {
                    modeldatas_0[int_3] = ModelData.method2568(NpcDefinition_modelIndexCache, models[int_3], 0);
                }

                ModelData modeldata_0;
                if (modeldatas_0.length == 1) {
                    modeldata_0 = modeldatas_0[0];
                } else {
                    modeldata_0 = new ModelData(modeldatas_0, modeldatas_0.length);
                }

                if (colors != null) {
                    for (int_3 = 0; int_3 < colors.length; int_3++) {
                        modeldata_0.recolor(colors[int_3], modifiedColors[int_3]);
                    }
                }

                if (textureToReplace != null) {
                    for (int_3 = 0; int_3 < textureToReplace.length; int_3++) {
                        modeldata_0.method2582(textureToReplace[int_3], textureToReplaceWith[int_3]);
                    }
                }

                model_0 = modeldata_0.light(ambient + 64, contrast + 850, -30, -50, -30);
                npcModelCache.put(model_0, id);
            }

            Model model_1;
            if ((sequence_0 != null) && (sequence_1 != null)) {
                model_1 = sequence_0.applyTransformations(model_0, int_0, sequence_1, int_1);
            } else if (sequence_0 != null) {
                model_1 = sequence_0.transformActorModel(model_0, int_0);
            } else if (sequence_1 != null) {
                model_1 = sequence_1.transformActorModel(model_0, int_1);
            } else {
                model_1 = model_0.toSharedModel(true);
            }

            if ((widthScale != 128) || (heightScale != 128)) {
                model_1.scale(widthScale, heightScale, widthScale);
            }

            return model_1;
        }
    }

    public ModelData method5158() {
        if (configs != null) {
            final NPCComposition npccomposition_1 = transform();
            return npccomposition_1 == null ? null : npccomposition_1.method5158();
        } else if (additionalModels == null) {
            return null;
        } else {
            boolean bool_0 = false;

            for (int int_0 = 0; int_0 < additionalModels.length; int_0++) {
                if (!NpcDefinition_modelIndexCache.tryLoadRecord(additionalModels[int_0], 0)) {
                    bool_0 = true;
                }
            }

            if (bool_0) {
                return null;
            } else {
                final ModelData[] modeldatas_0 = new ModelData[additionalModels.length];

                for (int int_1 = 0; int_1 < additionalModels.length; int_1++) {
                    modeldatas_0[int_1] = ModelData.method2568(NpcDefinition_modelIndexCache, additionalModels[int_1],
                            0);
                }

                ModelData modeldata_0;
                if (modeldatas_0.length == 1) {
                    modeldata_0 = modeldatas_0[0];
                } else {
                    modeldata_0 = new ModelData(modeldatas_0, modeldatas_0.length);
                }

                int int_2;
                if (colors != null) {
                    for (int_2 = 0; int_2 < colors.length; int_2++) {
                        modeldata_0.recolor(colors[int_2], modifiedColors[int_2]);
                    }
                }

                if (textureToReplace != null) {
                    for (int_2 = 0; int_2 < textureToReplace.length; int_2++) {
                        modeldata_0.method2582(textureToReplace[int_2], textureToReplaceWith[int_2]);
                    }
                }

                return modeldata_0;
            }
        }
    }

    public NPCComposition transform() {
        int int_0 = -1;
        if (varpIndex != -1) {
            int_0 = GameSocket.getVarbit(varpIndex);
        } else if (varp32Index != -1) {
            int_0 = class225.clientVarps[varp32Index];
        }

        int int_1;
        if ((int_0 >= 0) && (int_0 < (configs.length - 1))) {
            int_1 = configs[int_0];
        } else {
            int_1 = configs[configs.length - 1];
        }

        return int_1 != -1 ? HorizontalAlignment.getNpcDefinition(int_1) : null;
    }

    public boolean method5165() {
        if (configs == null) {
            return true;
        } else {
            int int_0 = -1;
            if (varpIndex != -1) {
                int_0 = GameSocket.getVarbit(varpIndex);
            } else if (varp32Index != -1) {
                int_0 = class225.clientVarps[varp32Index];
            }

            return (int_0 >= 0) && (int_0 < configs.length) ? configs[int_0] != -1 : configs[configs.length - 1] != -1;
        }
    }

    public int method5166(final int int_0, final int int_1) {
        return FriendManager.method1668(params, int_0, int_1);
    }

    public String method5167(final int int_0, final String string_0) {
        return WorldMapRectangle.method171(params, int_0, string_0);
    }


}
