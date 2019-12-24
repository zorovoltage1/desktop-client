public enum class15 implements Enumerated {

    field108(2, (byte) 0), field107(3, (byte) 1), field112(0, (byte) 2), field106(1, (byte) 3);

    final int worldMapType;
    final byte field111;

    class15(final int int_1, final byte byte_0) {
        worldMapType = int_1;
        field111 = byte_0;
    }

    @Override
    public int vmethod5815() {
        return field111;
    }

    static class15[] getWorldMapTypes() {
        return new class15[]{field106, field107, field108, field112};
    }

    private static final byte[] INVALID_MAP_DATA = new byte[1];

    static void method148() {
        WorldMapType3.flush(false);
        Game.field633 = 0;
        boolean bool_0 = true;

        int int_0;
        for (int_0 = 0; int_0 < class171.field2252.length; int_0++) {
            if ((FontName.landMapFileIds[int_0] != -1) && (class171.field2252[int_0] == null)) {
                class171.field2252[int_0] = FileRequest.indexMaps.getConfigData(FontName.landMapFileIds[int_0], 0);
                if (class171.field2252[int_0] == null) {
                    bool_0 = false;
                    ++Game.field633;
                }
            }

            if ((class9.landRegionFileIds[int_0] != -1) && (MapCacheArchiveNames.field253[int_0] == null)) {
                try {
                    MapCacheArchiveNames.field253[int_0] = FileRequest.indexMaps.getConfigDataKeys(class9.landRegionFileIds[int_0], 0, FriendManager.xteaKeys[int_0]);
                } catch(Throwable t) {
                    MapCacheArchiveNames.field253[int_0] = INVALID_MAP_DATA;
                    System.err.println("Map " + class143.mapRegions[int_0] + " could not be loaded!");
                }

                if (MapCacheArchiveNames.field253[int_0] == null) {
                    bool_0 = false;
                    ++Game.field633;
                }
            }
        }

        if (!bool_0) {
            Game.field751 = 1;
        } else {
            Game.field635 = 0;
            bool_0 = true;

            int int_1;
            int int_2;
            for (int_0 = 0; int_0 < class171.field2252.length; int_0++) {
                final byte[] bytes_0 = MapCacheArchiveNames.field253[int_0];
                if (bytes_0 != null) {
                    int_1 = ((class143.mapRegions[int_0] >> 8) * 64) - PendingSpawn.baseX;
                    int_2 = ((class143.mapRegions[int_0] & 0xFF) * 64) - Game.baseY;
                    if (Game.isDynamicRegion) {
                        int_1 = 10;
                        int_2 = 10;
                    }

                    bool_0 &= class33.method557(bytes_0, int_1, int_2);
                }
            }

            if (!bool_0) {
                Game.field751 = 2;
            } else {
                if (Game.field751 != 0) {
                    class83.method1933("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
                }

                class54.method1017();
                MapIcon.region.reset();

                for (int_0 = 0; int_0 < 4; int_0++) {
                    Game.collisionMaps[int_0].reset();
                }

                int int_3;
                for (int_0 = 0; int_0 < 4; int_0++) {
                    for (int_3 = 0; int_3 < 104; int_3++) {
                        for (int_1 = 0; int_1 < 104; int_1++) {
                            class50.tileSettings[int_0][int_3][int_1] = 0;
                        }
                    }
                }

                class54.method1017();
                SoundTaskDataProvider.method695();
                int_0 = class171.field2252.length;

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
                WorldMapType3.flush(true);
                int int_4;
                int int_5;
                int int_6;
                int int_7;
                int int_8;
                int int_9;
                int int_10;
                int int_12;
                int int_13;
                int int_14;
                int int_15;
                int int_16;
                int int_17;
                int int_18;
                int int_19;
                int int_20;
                if (!Game.isDynamicRegion) {
                    byte[] bytes_1;
                    for (int_3 = 0; int_3 < int_0; int_3++) {
                        int_1 = ((class143.mapRegions[int_3] >> 8) * 64) - PendingSpawn.baseX;
                        int_2 = ((class143.mapRegions[int_3] & 0xFF) * 64) - Game.baseY;
                        bytes_1 = class171.field2252[int_3];
                        if (bytes_1 != null) {
                            class54.method1017();
                            int_4 = (WorldMapType2.field224 * 8) - 48;
                            int_5 = (class34.field301 * 8) - 48;
                            final CollisionData[] collisiondatas_0 = Game.collisionMaps;

                            for (int_6 = 0; int_6 < 4; int_6++) {
                                for (int_7 = 0; int_7 < 64; int_7++) {
                                    for (int_8 = 0; int_8 < 64; int_8++) {
                                        if (((int_7 + int_1) > 0) && ((int_1 + int_7) < 103) && ((int_8 + int_2) > 0)
                                                && ((int_8 + int_2) < 103)) {
                                            collisiondatas_0[int_6].flags[int_7 + int_1][int_2 + int_8] &= 0xFEFFFFFF;
                                        }
                                    }
                                }
                            }

                            final Buffer buffer_0 = new Buffer(bytes_1);

                            for (int_7 = 0; int_7 < 4; int_7++) {
                                for (int_8 = 0; int_8 < 64; int_8++) {
                                    for (int_9 = 0; int_9 < 64; int_9++) {
                                        World.loadTerrain(buffer_0, int_7, int_8 + int_1, int_9 + int_2, int_4, int_5,
                                                0);
                                    }
                                }
                            }
                        }
                    }

                    for (int_3 = 0; int_3 < int_0; int_3++) {
                        int_1 = ((class143.mapRegions[int_3] >> 8) * 64) - PendingSpawn.baseX;
                        int_2 = ((class143.mapRegions[int_3] & 0xFF) * 64) - Game.baseY;
                        bytes_1 = class171.field2252[int_3];
                        if ((bytes_1 == null) && (class34.field301 < 800)) {
                            class54.method1017();
                            class177.method3510(int_1, int_2, 64, 64);
                        }
                    }

                    WorldMapType3.flush(true);

                    for (int_3 = 0; int_3 < int_0; int_3++) {
                        final byte[] bytes_3 = MapCacheArchiveNames.field253[int_3];
                        if (bytes_3 != null) {
                            int_2 = ((class143.mapRegions[int_3] >> 8) * 64) - PendingSpawn.baseX;
                            int_10 = ((class143.mapRegions[int_3] & 0xFF) * 64) - Game.baseY;
                            class54.method1017();
                            final Region region_0 = MapIcon.region;
                            final CollisionData[] collisiondatas_2 = Game.collisionMaps;
                            final Buffer buffer_2 = new Buffer(bytes_3);
                            int_6 = -1;

                            while (true) {
                                int_7 = buffer_2.method3563();
                                if (int_7 == 0) {
                                    break;
                                }

                                int_6 += int_7;
                                int_8 = 0;

                                while (true) {
                                    int_9 = buffer_2.getUSmart();
                                    if (int_9 == 0) {
                                        break;
                                    }

                                    int_8 += int_9 - 1;
                                    int_18 = int_8 & 0x3F;
                                    int_12 = (int_8 >> 6) & 0x3F;
                                    int_13 = int_8 >> 12;
                                    int_14 = buffer_2.readUnsignedByte();
                                    int_15 = int_14 >> 2;
                                    int_19 = int_14 & 0x3;
                                    int_16 = int_2 + int_12;
                                    int_17 = int_18 + int_10;
                                    if ((int_16 > 0) && (int_17 > 0) && (int_16 < 103) && (int_17 < 103)) {
                                        int_20 = int_13;
                                        if ((class50.tileSettings[1][int_16][int_17] & 0x2) == 2) {
                                            int_20 = int_13 - 1;
                                        }

                                        CollisionData collisiondata_0 = null;
                                        if (int_20 >= 0) {
                                            collisiondata_0 = collisiondatas_2[int_20];
                                        }

                                        class171.addObject(int_13, int_16, int_17, int_6, int_19, int_15, region_0,
                                                collisiondata_0, false);
                                    }
                                }
                            }
                        }
                    }
                }

                int int_11;
                int int_21;
                int int_22;
                int int_23;
                int int_24;
                int int_25;
                int int_26;
                int int_27;
                int int_28;
                int int_31;
                int int_32;
                int int_33;
                int int_34;
                int int_35;
                int int_36;
                int int_37;
                int int_38;
                if (Game.isDynamicRegion) {
                    CollisionData[] collisiondatas_1;
                    Buffer buffer_1;
                    for (int_3 = 0; int_3 < 4; int_3++) {
                        class54.method1017();

                        for (int_1 = 0; int_1 < 13; int_1++) {
                            for (int_2 = 0; int_2 < 13; int_2++) {
                                boolean bool_1 = false;
                                int_4 = Game.instanceTemplateChunks[int_3][int_1][int_2];
                                if (int_4 != -1) {
                                    int_5 = (int_4 >> 24) & 0x3;
                                    int_11 = (int_4 >> 1) & 0x3;
                                    int_6 = (int_4 >> 14) & 0x3FF;
                                    int_7 = (int_4 >> 3) & 0x7FF;
                                    int_8 = ((int_6 / 8) << 8) + (int_7 / 8);

                                    for (int_9 = 0; int_9 < class143.mapRegions.length; int_9++) {
                                        if ((class143.mapRegions[int_9] == int_8)
                                                && (class171.field2252[int_9] != null)) {
                                            final byte[] bytes_2 = class171.field2252[int_9];
                                            int_12 = int_1 * 8;
                                            int_13 = int_2 * 8;
                                            int_14 = (int_6 & 0x7) * 8;
                                            int_15 = (int_7 & 0x7) * 8;
                                            collisiondatas_1 = Game.collisionMaps;

                                            for (int_16 = 0; int_16 < 8; int_16++) {
                                                for (int_17 = 0; int_17 < 8; int_17++) {
                                                    if (((int_12 + int_16) > 0) && ((int_12 + int_16) < 103)
                                                            && ((int_17 + int_13) > 0) && ((int_17 + int_13) < 103)) {
                                                        collisiondatas_1[int_3].flags[int_12 + int_16][int_17
                                                                + int_13] &= 0xFEFFFFFF;
                                                    }
                                                }
                                            }

                                            buffer_1 = new Buffer(bytes_2);

                                            for (int_17 = 0; int_17 < 4; int_17++) {
                                                for (int_20 = 0; int_20 < 64; int_20++) {
                                                    for (int_21 = 0; int_21 < 64; int_21++) {
                                                        if ((int_17 == int_5) && (int_20 >= int_14)
                                                                && (int_20 < (int_14 + 8)) && (int_21 >= int_15)
                                                                && (int_21 < (int_15 + 8))) {
                                                            int_26 = int_20 & 0x7;
                                                            int_27 = int_21 & 0x7;
                                                            int_28 = int_11 & 0x3;
                                                            if (int_28 == 0) {
                                                                int_25 = int_26;
                                                            } else if (int_28 == 1) {
                                                                int_25 = int_27;
                                                            } else if (int_28 == 2) {
                                                                int_25 = 7 - int_26;
                                                            } else {
                                                                int_25 = 7 - int_27;
                                                            }

                                                            World.loadTerrain(buffer_1, int_3, int_25 + int_12,
                                                                    int_13 + ContextMenuRow.method1802(int_20 & 0x7,
                                                                            int_21 & 0x7, int_11),
                                                                    0, 0, int_11);
                                                        } else {
                                                            World.loadTerrain(buffer_1, 0, -1, -1, 0, 0, 0);
                                                        }
                                                    }
                                                }
                                            }

                                            bool_1 = true;
                                            break;
                                        }
                                    }
                                }

                                if (!bool_1) {
                                    Timer.method3338(int_3, int_1 * 8, int_2 * 8);
                                }
                            }
                        }
                    }

                    for (int_3 = 0; int_3 < 13; int_3++) {
                        for (int_1 = 0; int_1 < 13; int_1++) {
                            int_2 = Game.instanceTemplateChunks[0][int_3][int_1];
                            if (int_2 == -1) {
                                class177.method3510(int_3 * 8, int_1 * 8, 8, 8);
                            }
                        }
                    }

                    WorldMapType3.flush(true);

                    for (int_3 = 0; int_3 < 4; int_3++) {
                        class54.method1017();

                        for (int_1 = 0; int_1 < 13; int_1++) {
                            label1302:
                            for (int_2 = 0; int_2 < 13; int_2++) {
                                int_10 = Game.instanceTemplateChunks[int_3][int_1][int_2];
                                if (int_10 != -1) {
                                    int_4 = (int_10 >> 24) & 0x3;
                                    int_5 = (int_10 >> 1) & 0x3;
                                    int_11 = (int_10 >> 14) & 0x3FF;
                                    int_6 = (int_10 >> 3) & 0x7FF;
                                    int_7 = ((int_11 / 8) << 8) + (int_6 / 8);

                                    for (int_8 = 0; int_8 < class143.mapRegions.length; int_8++) {
                                        if ((class143.mapRegions[int_8] == int_7)
                                                && (MapCacheArchiveNames.field253[int_8] != null)) {
                                            final byte[] bytes_4 = MapCacheArchiveNames.field253[int_8];
                                            int_18 = int_1 * 8;
                                            int_12 = int_2 * 8;
                                            int_13 = (int_11 & 0x7) * 8;
                                            int_14 = (int_6 & 0x7) * 8;
                                            final Region region_1 = MapIcon.region;
                                            collisiondatas_1 = Game.collisionMaps;
                                            buffer_1 = new Buffer(bytes_4);
                                            int_17 = -1;

                                            while (true) {
                                                int_20 = buffer_1.method3563();
                                                if (int_20 == 0) {
                                                    continue label1302;
                                                }

                                                int_17 += int_20;
                                                int_21 = 0;

                                                while (true) {
                                                    int_22 = buffer_1.getUSmart();
                                                    if (int_22 == 0) {
                                                        break;
                                                    }

                                                    int_21 += int_22 - 1;
                                                    int_23 = int_21 & 0x3F;
                                                    int_24 = (int_21 >> 6) & 0x3F;
                                                    int_25 = int_21 >> 12;
                                                    int_26 = buffer_1.readUnsignedByte();
                                                    int_27 = int_26 >> 2;
                                                    int_28 = int_26 & 0x3;
                                                    if ((int_4 == int_25) && (int_24 >= int_13)
                                                            && (int_24 < (int_13 + 8)) && (int_23 >= int_14)
                                                            && (int_23 < (int_14 + 8))) {
                                                        final ObjectComposition objectcomposition_0 = FileOnDisk
                                                                .getObjectDefinition(int_17);
                                                        int_32 = int_24 & 0x7;
                                                        int_33 = int_23 & 0x7;
                                                        int_35 = objectcomposition_0.width;
                                                        int int_42 = objectcomposition_0.length;
                                                        if ((int_28 & 0x1) == 1) {
                                                            int_36 = int_35;
                                                            int_35 = int_42;
                                                            int_42 = int_36;
                                                        }

                                                        int_34 = int_5 & 0x3;
                                                        if (int_34 == 0) {
                                                            int_31 = int_32;
                                                        } else if (int_34 == 1) {
                                                            int_31 = int_33;
                                                        } else if (int_34 == 2) {
                                                            int_31 = 7 - int_32 - (int_35 - 1);
                                                        } else {
                                                            int_31 = 7 - int_33 - (int_42 - 1);
                                                        }

                                                        int_36 = int_18 + int_31;
                                                        int_38 = int_12 + ChatLineBuffer.method1970(int_24 & 0x7,
                                                                int_23 & 0x7, int_5, objectcomposition_0.width,
                                                                objectcomposition_0.length, int_28);
                                                        if ((int_36 > 0) && (int_38 > 0) && (int_36 < 103)
                                                                && (int_38 < 103)) {
                                                            int_37 = int_3;
                                                            if ((class50.tileSettings[1][int_36][int_38] & 0x2) == 2) {
                                                                int_37 = int_3 - 1;
                                                            }

                                                            CollisionData collisiondata_1 = null;
                                                            if (int_37 >= 0) {
                                                                collisiondata_1 = collisiondatas_1[int_37];
                                                            }

                                                            class171.addObject(int_3, int_36, int_38, int_17,
                                                                    (int_5 + int_28) & 0x3, int_27, region_1,
                                                                    collisiondata_1, false);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                /* custom obj spawning lol */
                for(int z = 0; z < 4; z++) {
                    for(int localX = 0; localX < 104; localX++) {
                        for(int localY = 0; localY < 104; localY++)
                            ClientObj.spawn(localX, localY, z);
                    }
                }


                WorldMapType3.flush(true);
                class54.method1017();
                final Region region_2 = MapIcon.region;
                final CollisionData[] collisiondatas_3 = Game.collisionMaps;

                for (int_2 = 0; int_2 < 4; int_2++) {
                    for (int_10 = 0; int_10 < 104; int_10++) {
                        for (int_4 = 0; int_4 < 104; int_4++) {
                            if ((class50.tileSettings[int_2][int_10][int_4] & 0x1) == 1) {
                                int_5 = int_2;
                                if ((class50.tileSettings[1][int_10][int_4] & 0x2) == 2) {
                                    int_5 = int_2 - 1;
                                }

                                if (int_5 >= 0) {
                                    collisiondatas_3[int_5].method3395(int_10, int_4);
                                }
                            }
                        }
                    }
                }

                class50.field457 += (int) (Math.random() * 5.0D) - 2;
                if (class50.field457 < -8) {
                    class50.field457 = -8;
                }

                if (class50.field457 > 8) {
                    class50.field457 = 8;
                }

                class50.field455 += (int) (Math.random() * 5.0D) - 2;
                if (class50.field455 < -16) {
                    class50.field455 = -16;
                }

                if (class50.field455 > 16) {
                    class50.field455 = 16;
                }

                for (int_2 = 0; int_2 < 4; int_2++) {
                    final byte[][] bytes_5 = class50.field447[int_2];
                    int_8 = (int) Math.sqrt(5100.0D);
                    int_9 = (int_8 * 768) >> 8;

                    for (int_18 = 1; int_18 < 103; int_18++) {
                        for (int_12 = 1; int_12 < 103; int_12++) {
                            int_13 = class50.tileHeights[int_2][int_12 + 1][int_18]
                                    - class50.tileHeights[int_2][int_12 - 1][int_18];
                            int_14 = class50.tileHeights[int_2][int_12][int_18 + 1]
                                    - class50.tileHeights[int_2][int_12][int_18 - 1];
                            int_15 = (int) Math.sqrt((int_14 * int_14) + (int_13 * int_13) + 65536);
                            int_19 = (int_13 << 8) / int_15;
                            int_16 = 65536 / int_15;
                            int_17 = (int_14 << 8) / int_15;
                            int_20 = (((int_19 * -50) + (int_17 * -50) + (int_16 * -10)) / int_9) + 96;
                            int_21 = (bytes_5[int_12 - 1][int_18] >> 2) + (bytes_5[int_12][int_18 - 1] >> 2)
                                    + (bytes_5[int_12 + 1][int_18] >> 3) + (bytes_5[int_12][int_18 + 1] >> 3)
                                    + (bytes_5[int_12][int_18] >> 1);
                            class50.field448[int_12][int_18] = int_20 - int_21;
                        }
                    }

                    for (int_18 = 0; int_18 < 104; int_18++) {
                        class50.floorHues[int_18] = 0;
                        class305.floorSaturations[int_18] = 0;
                        NPC.field1035[int_18] = 0;
                        Varbit.floorMultiplier[int_18] = 0;
                        BuildType.field3137[int_18] = 0;
                    }

                    for (int_18 = -5; int_18 < 109; int_18++) {
                        for (int_12 = 0; int_12 < 104; int_12++) {
                            int_13 = int_18 + 5;
                            if ((int_13 >= 0) && (int_13 < 104)) {
                                int_14 = class50.tileUnderlayIds[int_2][int_13][int_12] & 0xFF;
                                if (int_14 > 0) {
                                    final FloorUnderlayDefinition floorunderlaydefinition_1 = class49
                                            .getUnderlayDefinition(int_14 - 1);
                                    class50.floorHues[int_12] += floorunderlaydefinition_1.hue;
                                    class305.floorSaturations[int_12] += floorunderlaydefinition_1.saturation;
                                    NPC.field1035[int_12] += floorunderlaydefinition_1.lightness;
                                    Varbit.floorMultiplier[int_12] += floorunderlaydefinition_1.hueMultiplier;
                                    ++BuildType.field3137[int_12];
                                }
                            }

                            int_14 = int_18 - 5;
                            if ((int_14 >= 0) && (int_14 < 104)) {
                                int_15 = class50.tileUnderlayIds[int_2][int_14][int_12] & 0xFF;
                                if (int_15 > 0) {
                                    final FloorUnderlayDefinition floorunderlaydefinition_0 = class49
                                            .getUnderlayDefinition(int_15 - 1);
                                    class50.floorHues[int_12] -= floorunderlaydefinition_0.hue;
                                    class305.floorSaturations[int_12] -= floorunderlaydefinition_0.saturation;
                                    NPC.field1035[int_12] -= floorunderlaydefinition_0.lightness;
                                    Varbit.floorMultiplier[int_12] -= floorunderlaydefinition_0.hueMultiplier;
                                    --BuildType.field3137[int_12];
                                }
                            }
                        }

                        if ((int_18 >= 1) && (int_18 < 103)) {
                            int_12 = 0;
                            int_13 = 0;
                            int_14 = 0;
                            int_15 = 0;
                            int_19 = 0;

                            for (int_16 = -5; int_16 < 109; int_16++) {
                                int_17 = int_16 + 5;
                                if ((int_17 >= 0) && (int_17 < 104)) {
                                    int_12 += class50.floorHues[int_17];
                                    int_13 += class305.floorSaturations[int_17];
                                    int_14 += NPC.field1035[int_17];
                                    int_15 += Varbit.floorMultiplier[int_17];
                                    int_19 += BuildType.field3137[int_17];
                                }

                                int_20 = int_16 - 5;
                                if ((int_20 >= 0) && (int_20 < 104)) {
                                    int_12 -= class50.floorHues[int_20];
                                    int_13 -= class305.floorSaturations[int_20];
                                    int_14 -= NPC.field1035[int_20];
                                    int_15 -= Varbit.floorMultiplier[int_20];
                                    int_19 -= BuildType.field3137[int_20];
                                }

                                if ((int_16 >= 1) && (int_16 < 103)
                                        && (!Game.lowMemory || ((class50.tileSettings[0][int_18][int_16] & 0x2) != 0)
                                        || ((class50.tileSettings[int_2][int_18][int_16] & 0x10) == 0))) {
                                    if (int_2 < class50.field442) {
                                        class50.field442 = int_2;
                                    }

                                    int_21 = class50.tileUnderlayIds[int_2][int_18][int_16] & 0xFF;
                                    int_22 = class165.tileOverlayIds[int_2][int_18][int_16] & 0xFF;
                                    if ((int_21 > 0) || (int_22 > 0)) {
                                        int_23 = class50.tileHeights[int_2][int_18][int_16];
                                        int_24 = class50.tileHeights[int_2][int_18 + 1][int_16];
                                        int_25 = class50.tileHeights[int_2][int_18 + 1][int_16 + 1];
                                        int_26 = class50.tileHeights[int_2][int_18][int_16 + 1];
                                        int_27 = class50.field448[int_18][int_16];
                                        int_28 = class50.field448[int_18 + 1][int_16];
                                        final int int_29 = class50.field448[int_18 + 1][int_16 + 1];
                                        final int int_30 = class50.field448[int_18][int_16 + 1];
                                        int_31 = -1;
                                        int_32 = -1;
                                        if (int_21 > 0) {
                                            int_33 = (int_12 * 256) / int_15;
                                            int_34 = int_13 / int_19;
                                            int_35 = int_14 / int_19;
                                            int_31 = class34.method560(int_33, int_34, int_35);
                                            int_33 = (int_33 + class50.field457) & 0xFF;
                                            int_35 += class50.field455;
                                            if (int_35 < 0) {
                                                int_35 = 0;
                                            } else if (int_35 > 255) {
                                                int_35 = 255;
                                            }

                                            int_32 = class34.method560(int_33, int_34, int_35);
                                        }

                                        if (int_2 > 0) {
                                            boolean bool_2 = true;
                                            if ((int_21 == 0) && (class50.tileOverlayPath[int_2][int_18][int_16] != 0)) {
                                                bool_2 = false;
                                            }

                                            if ((int_22 > 0)
                                                    && !GrandExchangeEvents.getOverlayDefinition(int_22 - 1).isHidden) {
                                                bool_2 = false;
                                            }

                                            if (bool_2 && (int_23 == int_24) && (int_23 == int_25)
                                                    && (int_23 == int_26)) {
                                                class37.field325[int_2][int_18][int_16] |= 0x924;
                                            }
                                        }

                                        int_33 = 0;
                                        if (int_32 != -1) {
                                            int_33 = Graphics3D.colorPalette[Resampler.method2248(int_32, 96)];
                                        }

                                        if (int_22 == 0) {
                                            region_2.addTile(int_2, int_18, int_16, 0, 0, -1, int_23, int_24, int_25,
                                                    int_26, Resampler.method2248(int_31, int_27),
                                                    Resampler.method2248(int_31, int_28),
                                                    Resampler.method2248(int_31, int_29),
                                                    Resampler.method2248(int_31, int_30), 0, 0, 0, 0, int_33, 0);
                                        } else {
                                            int_34 = class50.tileOverlayPath[int_2][int_18][int_16] + 1;
                                            final byte byte_0 = WorldMapDecoration.overlayRotations[int_2][int_18][int_16];
                                            final Overlay overlay_0 = GrandExchangeEvents
                                                    .getOverlayDefinition(int_22 - 1);
                                            int_36 = overlay_0.texture;
                                            int int_39;
                                            int int_40;
                                            if (int_36 >= 0) {
                                                int_37 = Graphics3D.textureLoader.getAverageTextureRGB(int_36);
                                                int_38 = -1;
                                            } else if (overlay_0.color == 16711935) {
                                                int_38 = -2;
                                                int_36 = -1;
                                                int_37 = -2;
                                            } else {
                                                int_38 = class34.method560(overlay_0.hue, overlay_0.saturation,
                                                        overlay_0.lightness);
                                                int_39 = (overlay_0.hue + class50.field457) & 0xFF;
                                                int_40 = overlay_0.lightness + class50.field455;
                                                if (int_40 < 0) {
                                                    int_40 = 0;
                                                } else if (int_40 > 255) {
                                                    int_40 = 255;
                                                }

                                                int_37 = class34.method560(int_39, overlay_0.saturation, int_40);
                                            }

                                            int_39 = 0;
                                            if (int_37 != -2) {
                                                int_39 = Graphics3D.colorPalette[WorldMapManager
                                                        .adjustHSLListness0(int_37, 96)];
                                            }

                                            if (overlay_0.otherRgbColor != -1) {
                                                int_40 = (overlay_0.otherHue + class50.field457) & 0xFF;
                                                int int_41 = overlay_0.otherLightness + class50.field455;
                                                if (int_41 < 0) {
                                                    int_41 = 0;
                                                } else if (int_41 > 255) {
                                                    int_41 = 255;
                                                }

                                                int_37 = class34.method560(int_40, overlay_0.otherSaturation, int_41);
                                                int_39 = Graphics3D.colorPalette[WorldMapManager
                                                        .adjustHSLListness0(int_37, 96)];
                                            }

                                            region_2.addTile(int_2, int_18, int_16, int_34, byte_0, int_36, int_23,
                                                    int_24, int_25, int_26, Resampler.method2248(int_31, int_27),
                                                    Resampler.method2248(int_31, int_28),
                                                    Resampler.method2248(int_31, int_29),
                                                    Resampler.method2248(int_31, int_30),
                                                    WorldMapManager.adjustHSLListness0(int_38, int_27),
                                                    WorldMapManager.adjustHSLListness0(int_38, int_28),
                                                    WorldMapManager.adjustHSLListness0(int_38, int_29),
                                                    WorldMapManager.adjustHSLListness0(int_38, int_30), int_33, int_39);
                                        }
                                    }
                                }
                            }
                        }
                    }

                    for (int_18 = 1; int_18 < 103; int_18++) {
                        for (int_12 = 1; int_12 < 103; int_12++) {
                            if ((class50.tileSettings[int_2][int_12][int_18] & 0x8) != 0) {
                                int_16 = 0;
                            } else if ((int_2 > 0) && ((class50.tileSettings[1][int_12][int_18] & 0x2) != 0)) {
                                int_16 = int_2 - 1;
                            } else {
                                int_16 = int_2;
                            }

                            region_2.setPhysicalLevel(int_2, int_12, int_18, int_16);
                        }
                    }

                    class50.tileUnderlayIds[int_2] = null;
                    class165.tileOverlayIds[int_2] = null;
                    class50.tileOverlayPath[int_2] = null;
                    WorldMapDecoration.overlayRotations[int_2] = null;
                    class50.field447[int_2] = null;
                }

                region_2.applyLighting(-50, -10, -50);

                for (int_2 = 0; int_2 < 104; int_2++) {
                    for (int_10 = 0; int_10 < 104; int_10++) {
                        if ((class50.tileSettings[1][int_2][int_10] & 0x2) == 2) {
                            region_2.setBridge(int_2, int_10);
                        }
                    }
                }

                int_2 = 1;
                int_10 = 2;
                int_4 = 4;

                for (int_5 = 0; int_5 < 4; int_5++) {
                    if (int_5 > 0) {
                        int_2 <<= 3;
                        int_10 <<= 3;
                        int_4 <<= 3;
                    }

                    for (int_11 = 0; int_11 <= int_5; int_11++) {
                        for (int_6 = 0; int_6 <= 104; int_6++) {
                            for (int_7 = 0; int_7 <= 104; int_7++) {
                                short short_0;
                                if ((class37.field325[int_11][int_7][int_6] & int_2) != 0) {
                                    int_8 = int_6;
                                    int_9 = int_6;
                                    int_18 = int_11;

                                    for (int_12 = int_11; (int_8 > 0)
                                            && ((class37.field325[int_11][int_7][int_8 - 1] & int_2) != 0); --int_8) {
                                    }

                                    while ((int_9 < 104) && ((class37.field325[int_11][int_7][int_9 + 1] & int_2) != 0)) {
                                        ++int_9;
                                    }

                                    label1030:
                                    while (int_18 > 0) {
                                        for (int_13 = int_8; int_13 <= int_9; int_13++) {
                                            if ((class37.field325[int_18 - 1][int_7][int_13] & int_2) == 0) {
                                                break label1030;
                                            }
                                        }

                                        --int_18;
                                    }

                                    label1019:
                                    while (int_12 < int_5) {
                                        for (int_13 = int_8; int_13 <= int_9; int_13++) {
                                            if ((class37.field325[int_12 + 1][int_7][int_13] & int_2) == 0) {
                                                break label1019;
                                            }
                                        }

                                        ++int_12;
                                    }

                                    int_13 = ((int_9 - int_8) + 1) * ((int_12 + 1) - int_18);
                                    if (int_13 >= 8) {
                                        short_0 = 240;
                                        int_15 = class50.tileHeights[int_12][int_7][int_8] - short_0;
                                        int_19 = class50.tileHeights[int_18][int_7][int_8];
                                        Region.addOcclude(int_5, 1, int_7 * 128, int_7 * 128, int_8 * 128,
                                                (int_9 * 128) + 128, int_15, int_19);

                                        for (int_16 = int_18; int_16 <= int_12; int_16++) {
                                            for (int_17 = int_8; int_17 <= int_9; int_17++) {
                                                class37.field325[int_16][int_7][int_17] &= ~int_2;
                                            }
                                        }
                                    }
                                }

                                if ((class37.field325[int_11][int_7][int_6] & int_10) != 0) {
                                    int_8 = int_7;
                                    int_9 = int_7;
                                    int_18 = int_11;

                                    for (int_12 = int_11; (int_8 > 0)
                                            && ((class37.field325[int_11][int_8 - 1][int_6] & int_10) != 0); --int_8) {
                                    }

                                    while ((int_9 < 104)
                                            && ((class37.field325[int_11][int_9 + 1][int_6] & int_10) != 0)) {
                                        ++int_9;
                                    }

                                    label1083:
                                    while (int_18 > 0) {
                                        for (int_13 = int_8; int_13 <= int_9; int_13++) {
                                            if ((class37.field325[int_18 - 1][int_13][int_6] & int_10) == 0) {
                                                break label1083;
                                            }
                                        }

                                        --int_18;
                                    }

                                    label1072:
                                    while (int_12 < int_5) {
                                        for (int_13 = int_8; int_13 <= int_9; int_13++) {
                                            if ((class37.field325[int_12 + 1][int_13][int_6] & int_10) == 0) {
                                                break label1072;
                                            }
                                        }

                                        ++int_12;
                                    }

                                    int_13 = ((int_9 - int_8) + 1) * ((int_12 + 1) - int_18);
                                    if (int_13 >= 8) {
                                        short_0 = 240;
                                        int_15 = class50.tileHeights[int_12][int_8][int_6] - short_0;
                                        int_19 = class50.tileHeights[int_18][int_8][int_6];
                                        Region.addOcclude(int_5, 2, int_8 * 128, (int_9 * 128) + 128, int_6 * 128,
                                                int_6 * 128, int_15, int_19);

                                        for (int_16 = int_18; int_16 <= int_12; int_16++) {
                                            for (int_17 = int_8; int_17 <= int_9; int_17++) {
                                                class37.field325[int_16][int_17][int_6] &= ~int_10;
                                            }
                                        }
                                    }
                                }

                                if ((class37.field325[int_11][int_7][int_6] & int_4) != 0) {
                                    int_8 = int_7;
                                    int_9 = int_7;
                                    int_18 = int_6;

                                    for (int_12 = int_6; (int_18 > 0) && ((class37.field325[int_11][int_7][int_18 - 1] & int_4) != 0); --int_18) {
                                    }

                                    while ((int_12 < 104) && ((class37.field325[int_11][int_7][int_12 + 1] & int_4) != 0)) {
                                        ++int_12;
                                    }

                                    label1136:
                                    while (int_8 > 0) {
                                        for (int_13 = int_18; int_13 <= int_12; int_13++) {
                                            if ((class37.field325[int_11][int_8 - 1][int_13] & int_4) == 0) {
                                                break label1136;
                                            }
                                        }

                                        --int_8;
                                    }

                                    label1125:
                                    while (int_9 < 104) {
                                        for (int_13 = int_18; int_13 <= int_12; int_13++) {
                                            if ((class37.field325[int_11][int_9 + 1][int_13] & int_4) == 0) {
                                                break label1125;
                                            }
                                        }

                                        ++int_9;
                                    }

                                    if ((((int_12 - int_18) + 1) * ((int_9 - int_8) + 1)) >= 4) {
                                        int_13 = class50.tileHeights[int_11][int_8][int_18];
                                        Region.addOcclude(int_5, 4, int_8 * 128, (int_9 * 128) + 128, int_18 * 128,
                                                (int_12 * 128) + 128, int_13, int_13);

                                        for (int_14 = int_8; int_14 <= int_9; int_14++) {
                                            for (int_15 = int_18; int_15 <= int_12; int_15++) {
                                                class37.field325[int_11][int_14][int_15] &= ~int_4;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                WorldMapType3.flush(true);
                int_2 = class50.field442;
                if (int_2 > class13.plane) {
                    int_2 = class13.plane;
                }

                if (int_2 < (class13.plane - 1)) {
                    int_2 = class13.plane - 1;
                }

                if (Game.lowMemory) {
                    MapIcon.region.setup(class50.field442);
                } else {
                    MapIcon.region.setup(0);
                }

                for (int_10 = 0; int_10 < 104; int_10++) {
                    for (int_4 = 0; int_4 < 104; int_4++) {
                        InvType.groundItemSpawned(int_10, int_4);
                    }
                }

                class54.method1017();
                Timer.method3342();
                ObjectComposition.field3391.reset();
                PacketNode packetnode_0;
                if (Buffer.clientInstance.method801()) {
                    packetnode_0 = class26.method433(ClientPacket.field2148, Game.field626.field1218);
                    packetnode_0.packetBuffer.putInt(1057001181);
                    Game.field626.method1980(packetnode_0);
                }

                if (!Game.isDynamicRegion) {
                    int_10 = (WorldMapType2.field224 - 6) / 8;
                    int_4 = (WorldMapType2.field224 + 6) / 8;
                    int_5 = (class34.field301 - 6) / 8;
                    int_11 = (class34.field301 + 6) / 8;

                    for (int_6 = int_10 - 1; int_6 <= (int_4 + 1); int_6++) {
                        for (int_7 = int_5 - 1; int_7 <= (int_11 + 1); int_7++) {
                            if ((int_6 < int_10) || (int_6 > int_4) || (int_7 < int_5) || (int_7 > int_11)) {
                                FileRequest.indexMaps.method4648("m" + int_6 + "_" + int_7);
                                FileRequest.indexMaps.method4648("l" + int_6 + "_" + int_7);
                            }
                        }
                    }
                }

                MouseInput.setGameState(30);
                class54.method1017();
                class49.method952();
                packetnode_0 = class26.method433(ClientPacket.REGION_UPDATE, Game.field626.field1218);
                Game.field626.method1980(packetnode_0);
                class43.timer.vmethod3330();

                for (int_4 = 0; int_4 < 32; int_4++) {
                    GameEngine.field394[int_4] = 0L;
                }

                for (int_4 = 0; int_4 < 32; int_4++) {
                    GameEngine.field404[int_4] = 0L;
                }

                class8.field48 = 0;
            }
        }
    }

}
