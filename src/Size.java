public class Size {

    public static final Size field70;
    public static final Size field71;
    public static final Size field72;
    final String field73;
    final int field79;
    final int field75;
    final int field76;

    static {
        field70 = new Size("SMALL", 0, 0, 4);
        field71 = new Size("MEDIUM", 2, 1, 2);
        field72 = new Size("LARGE", 1, 2, 0);
    }

    Size(final String string_0, final int int_0, final int int_1, final int int_2) {
        field73 = string_0;
        field79 = int_0;
        field75 = int_1;
        field76 = int_2;
    }

    boolean method103(final float float_0) {
        return float_0 >= field76;
    }

    static Size method101(final int int_0) {
        final Size[] sizes_0 = new Size[]{field72, field70, field71};
        final Size[] sizes_1 = sizes_0;

        for (int int_1 = 0; int_1 < sizes_1.length; int_1++) {
            final Size size_0 = sizes_1[int_1];
            if (int_0 == size_0.field75) {
                return size_0;
            }
        }

        return null;
    }

    static void method104(final class21 class21_0, final int int_0, final int int_1) {
        WorldMapRegion.field189.method4007(class21_0, class43.method716(int_0, int_1, 0));
    }

    static int method108() {
        if (class10.preferences.hideRoofs) {
            return class13.plane;
        } else {
            int int_0 = 3;
            if (class7.cameraPitch < 310) {
                int int_1;
                int int_2;
                if (Game.field655 == 1) {
                    int_1 = CacheFile.field1428 >> 7;
                    int_2 = GrandExchangeEvent.field23 >> 7;
                } else {
                    int_1 = class138.localPlayer.x >> 7;
                    int_2 = class138.localPlayer.y >> 7;
                }

                int int_3 = CacheFile.cameraX >> 7;
                int int_4 = Coordinates.cameraY >> 7;
                if ((int_3 < 0) || (int_4 < 0) || (int_3 >= 104) || (int_4 >= 104)) {
                    return class13.plane;
                }

                if ((int_1 < 0) || (int_2 < 0) || (int_1 >= 104) || (int_2 >= 104)) {
                    return class13.plane;
                }

                if ((class50.tileSettings[class13.plane][int_3][int_4] & 0x4) != 0) {
                    int_0 = class13.plane;
                }

                int int_5;
                if (int_1 > int_3) {
                    int_5 = int_1 - int_3;
                } else {
                    int_5 = int_3 - int_1;
                }

                int int_6;
                if (int_2 > int_4) {
                    int_6 = int_2 - int_4;
                } else {
                    int_6 = int_4 - int_2;
                }

                int int_7;
                int int_8;
                if (int_5 > int_6) {
                    int_7 = (int_6 * 65536) / int_5;
                    int_8 = 32768;

                    while (int_3 != int_1) {
                        if (int_3 < int_1) {
                            ++int_3;
                        } else if (int_3 > int_1) {
                            --int_3;
                        }

                        if ((class50.tileSettings[class13.plane][int_3][int_4] & 0x4) != 0) {
                            int_0 = class13.plane;
                        }

                        int_8 += int_7;
                        if (int_8 >= 65536) {
                            int_8 -= 65536;
                            if (int_4 < int_2) {
                                ++int_4;
                            } else if (int_4 > int_2) {
                                --int_4;
                            }

                            if ((class50.tileSettings[class13.plane][int_3][int_4] & 0x4) != 0) {
                                int_0 = class13.plane;
                            }
                        }
                    }
                } else if (int_6 > 0) {
                    int_7 = (int_5 * 65536) / int_6;
                    int_8 = 32768;

                    while (int_2 != int_4) {
                        if (int_4 < int_2) {
                            ++int_4;
                        } else if (int_4 > int_2) {
                            --int_4;
                        }

                        if ((class50.tileSettings[class13.plane][int_3][int_4] & 0x4) != 0) {
                            int_0 = class13.plane;
                        }

                        int_8 += int_7;
                        if (int_8 >= 65536) {
                            int_8 -= 65536;
                            if (int_3 < int_1) {
                                ++int_3;
                            } else if (int_3 > int_1) {
                                --int_3;
                            }

                            if ((class50.tileSettings[class13.plane][int_3][int_4] & 0x4) != 0) {
                                int_0 = class13.plane;
                            }
                        }
                    }
                }
            }

            if ((class138.localPlayer.x >= 0) && (class138.localPlayer.y >= 0) && (class138.localPlayer.x < 13312)
                    && (class138.localPlayer.y < 13312)) {
                if ((class50.tileSettings[class13.plane][class138.localPlayer.x >> 7][class138.localPlayer.y >> 7]
                        & 0x4) != 0) {
                    int_0 = class13.plane;
                }

                return int_0;
            } else {
                return class13.plane;
            }
        }
    }

    static void method102(final Widget[] widgets_0, final int int_0, final int int_1, final int int_2, final int int_3,
                          final int int_4, final int int_5, final int int_6) {
        for (int int_7 = 0; int_7 < widgets_0.length; int_7++) {
            final Widget widget_0 = widgets_0[int_7];
            if ((widget_0 != null)
                    && (!widget_0.hasScript || (widget_0.type == 0) || widget_0.hasListener
                    || (class24.getWidgetClickMask(widget_0) != 0) || (widget_0 == Game.field752)
                    || (widget_0.contentType == 1338))
                    && (widget_0.parentHash == int_0) && (!widget_0.hasScript || !class81.method1885(widget_0))) {
                final int int_8 = widget_0.relativeX + int_5;
                final int int_9 = int_6 + widget_0.relativeY;
                int int_10;
                int int_11;
                int int_12;
                int int_13;
                int int_14;
                int int_15;
                int int_21;
                if (widget_0.type == 2) {
                    int_10 = int_1;
                    int_11 = int_2;
                    int_12 = int_3;
                    int_13 = int_4;
                } else if (widget_0.type == 9) {
                    int_14 = int_8;
                    int_15 = int_9;
                    int int_16 = int_8 + widget_0.width;
                    int_21 = int_9 + widget_0.height;
                    if (int_16 < int_8) {
                        int_14 = int_16;
                        int_16 = int_8;
                    }

                    if (int_21 < int_9) {
                        int_15 = int_21;
                        int_21 = int_9;
                    }

                    ++int_16;
                    ++int_21;
                    int_10 = int_14 > int_1 ? int_14 : int_1;
                    int_11 = int_15 > int_2 ? int_15 : int_2;
                    int_12 = int_16 < int_3 ? int_16 : int_3;
                    int_13 = int_21 < int_4 ? int_21 : int_4;
                } else {
                    int_14 = int_8 + widget_0.width;
                    int_15 = int_9 + widget_0.height;
                    int_10 = int_8 > int_1 ? int_8 : int_1;
                    int_11 = int_9 > int_2 ? int_9 : int_2;
                    int_12 = int_14 < int_3 ? int_14 : int_3;
                    int_13 = int_15 < int_4 ? int_15 : int_4;
                }

                if (widget_0 == Game.draggedWidget) {
                    Game.field772 = true;
                    Game.field696 = int_8;
                    Game.field760 = int_9;
                }

                if (!widget_0.hasScript || ((int_10 < int_12) && (int_11 < int_13))) {
                    ScriptEvent scriptevent_2;
                    if (!widget_0.noClickThrough) {
                        if (widget_0.noScrollThrough && (MouseInput.mouseLastX >= int_10)
                                && ((MouseInput.mouseLastY * 673804999) >= int_11)
                                && (MouseInput.mouseLastX < int_12)
                                && ((MouseInput.mouseLastY * 673804999) < int_13)) {
                            for (scriptevent_2 = (ScriptEvent) Game.field638
                                    .getFront(); scriptevent_2 != null; scriptevent_2 = (ScriptEvent) Game.field638
                                    .getNext()) {
                                if (scriptevent_2.boolean1
                                        && (scriptevent_2.widget.onScrollWheelListener == scriptevent_2.objs)) {
                                    scriptevent_2.unlink();
                                }
                            }
                        }
                    } else if ((MouseInput.mouseLastX >= int_10)
                            && ((MouseInput.mouseLastY * 673804999) >= int_11)
                            && (MouseInput.mouseLastX < int_12)
                            && ((MouseInput.mouseLastY * 673804999) < int_13)) {
                        for (scriptevent_2 = (ScriptEvent) Game.field638
                                .getFront(); scriptevent_2 != null; scriptevent_2 = (ScriptEvent) Game.field638
                                .getNext()) {
                            if (scriptevent_2.boolean1) {
                                scriptevent_2.unlink();
                                scriptevent_2.widget.field2731 = false;
                            }
                        }

                        if (class6.field39 == 0) {
                            Game.draggedWidget = null;
                            Game.field752 = null;
                        }

                        if (!Game.isMenuOpen) {
                            class59.method1077();
                        }
                    }
                    int_14 = MouseInput.mouseLastX;
                    int_15 = MouseInput.mouseLastY * 673804999;
                    if (MouseInput.mouseLastButton != 0) {
                        int_14 = MouseInput.mouseLastPressedX;
                        int_15 = MouseInput.mouseLastPressedY;
                    }

                    boolean bool_1 = (int_14 >= int_10) && (int_15 >= int_11) && (int_14 < int_12) && (int_15 < int_13);
                    int int_17;
                    int int_18;
                    int int_19;
                    int int_24;
                    int int_31;
                    if (widget_0.contentType == 1337) {
                        if (!Game.field625 && !Game.isMenuOpen && bool_1) {
                            if ((Game.itemSelectionState == 0) && !Game.spellSelected) {
                                class50.addMenuEntry("Walk here", "", 23, 0, int_14 - int_10, int_15 - int_11);
                            }

                            long long_0 = -1L;
                            long long_1 = -1L;
                            int_17 = 0;

                            while (true) {
                                int_19 = class120.Viewport_entityCountAtMouse;
                                if (int_17 >= int_19) {
                                    if (long_0 != -1L) {
                                        int_17 = class37.method662(long_0);
                                        int_18 = CacheFile.method2484(long_0);
                                        final Player player_0 = Game.cachedPlayers[Game.field707];
                                        class221.method4371(player_0, Game.field707, int_17, int_18);
                                    }
                                    break;
                                }

                                final long long_2 = WorldMapData.method262(int_17);
                                if (long_2 != long_1) {
                                    label1671:
                                    {
                                        long_1 = long_2;
                                        int_24 = TotalQuantityComparator.method32(int_17);
                                        int_31 = WorldMapType2.method435(int_17);
                                        final long long_3 = class120.field1647[int_17];
                                        final int int_26 = (int) ((long_3 >>> 14) & 0x3L);
                                        final int int_27 = Item.method1864(int_17);
                                        if ((int_26 == 2) && (MapIcon.region.method2902(class13.plane, int_24, int_31,
                                                long_2) >= 0)) {
                                            ObjectComposition objectcomposition_0 = FileOnDisk
                                                    .getObjectDefinition(int_27);
                                            if (objectcomposition_0.impostorIds != null) {
                                                objectcomposition_0 = objectcomposition_0.getImpostor();
                                            }

                                            if (objectcomposition_0 == null) {
                                                break label1671;
                                            }

                                            if (Game.itemSelectionState == 1) {
                                                class50.addMenuEntry("Use",
                                                        Game.lastSelectedItemName + " " + "->" + " "
                                                                + class6.getColTags(65535) + objectcomposition_0.name,
                                                        1, int_27, int_24, int_31);
                                            } else if (Game.spellSelected) {
                                                if ((Actor.field932 & 0x4) == 4) {
                                                    class50.addMenuEntry(Game.field612, Game.field739 + " " + "->"
                                                                    + " " + class6.getColTags(65535) + objectcomposition_0.name,
                                                            2, int_27, int_24, int_31);
                                                }
                                            } else {
                                                final String[] strings_1 = objectcomposition_0.actions;
                                                if (strings_1 != null) {
                                                    for (int int_29 = 4; int_29 >= 0; --int_29) {
                                                        if (strings_1[int_29] != null) {
                                                            short short_0 = 0;
                                                            if (int_29 == 0) {
                                                                short_0 = 3;
                                                            }

                                                            if (int_29 == 1) {
                                                                short_0 = 4;
                                                            }

                                                            if (int_29 == 2) {
                                                                short_0 = 5;
                                                            }

                                                            if (int_29 == 3) {
                                                                short_0 = 6;
                                                            }

                                                            if (int_29 == 4) {
                                                                short_0 = 1001;
                                                            }

                                                            class50.addMenuEntry(strings_1[int_29],
                                                                    class6.getColTags(65535) + objectcomposition_0.name,
                                                                    short_0, int_27, int_24, int_31);
                                                        }
                                                    }
                                                }

                                                class50.addMenuEntry("Examine",
                                                        class6.getColTags(65535) + objectcomposition_0.name, 1002,
                                                        objectcomposition_0.id, int_24, int_31);
                                            }
                                        }

                                        int int_28;
                                        NPC npc_0;
                                        Player player_1;
                                        int[] ints_0;
                                        int int_32;
                                        if (int_26 == 1) {
                                            final NPC npc_1 = Game.cachedNPCs[int_27];
                                            if (npc_1 == null) {
                                                break label1671;
                                            }

                                            if ((npc_1.composition.size == 1) && ((npc_1.x & 0x7F) == 64)
                                                    && ((npc_1.y & 0x7F) == 64)) {
                                                for (int_28 = 0; int_28 < Game.npcIndexesCount; int_28++) {
                                                    npc_0 = Game.cachedNPCs[Game.npcIndices[int_28]];
                                                    if ((npc_0 != null) && (npc_1 != npc_0)
                                                            && (npc_0.composition.size == 1) && (npc_0.x == npc_1.x)
                                                            && (npc_1.y == npc_0.y)) {
                                                        MapIcon.method474(npc_0.composition, Game.npcIndices[int_28],
                                                                int_24, int_31);
                                                    }
                                                }

                                                int_28 = class81.playerIndexesCount;
                                                ints_0 = class81.playerIndices;

                                                for (int_32 = 0; int_32 < int_28; int_32++) {
                                                    player_1 = Game.cachedPlayers[ints_0[int_32]];
                                                    if ((player_1 != null) && (player_1.x == npc_1.x)
                                                            && (player_1.y == npc_1.y)) {
                                                        class221.method4371(player_1, ints_0[int_32], int_24, int_31);
                                                    }
                                                }
                                            }

                                            MapIcon.method474(npc_1.composition, int_27, int_24, int_31);
                                        }

                                        if (int_26 == 0) {
                                            final Player player_2 = Game.cachedPlayers[int_27];
                                            if (player_2 == null) {
                                                break label1671;
                                            }

                                            if (((player_2.x & 0x7F) == 64) && ((player_2.y & 0x7F) == 64)) {
                                                for (int_28 = 0; int_28 < Game.npcIndexesCount; int_28++) {
                                                    npc_0 = Game.cachedNPCs[Game.npcIndices[int_28]];
                                                    if ((npc_0 != null) && (npc_0.composition.size == 1)
                                                            && (player_2.x == npc_0.x) && (npc_0.y == player_2.y)) {
                                                        MapIcon.method474(npc_0.composition, Game.npcIndices[int_28],
                                                                int_24, int_31);
                                                    }
                                                }

                                                int_28 = class81.playerIndexesCount;
                                                ints_0 = class81.playerIndices;

                                                for (int_32 = 0; int_32 < int_28; int_32++) {
                                                    player_1 = Game.cachedPlayers[ints_0[int_32]];
                                                    if ((player_1 != null) && (player_1 != player_2)
                                                            && (player_2.x == player_1.x) && (player_1.y == player_2.y)) {
                                                        class221.method4371(player_1, ints_0[int_32], int_24, int_31);
                                                    }
                                                }
                                            }

                                            if (int_27 != Game.field707) {
                                                class221.method4371(player_2, int_27, int_24, int_31);
                                            } else {
                                                long_0 = long_2;
                                            }
                                        }

                                        if (int_26 == 3) {
                                            final Deque deque_0 = Game.groundItemDeque[class13.plane][int_24][int_31];
                                            if (deque_0 != null) {
                                                for (Item item_0 = (Item) deque_0
                                                        .getTail(); item_0 != null; item_0 = (Item) deque_0
                                                        .getPrevious()) {
                                                    final ItemComposition itemcomposition_1 = TextureProvider
                                                            .getItemDefinition(item_0.id);
                                                    if (Game.itemSelectionState == 1) {
                                                        class50.addMenuEntry("Use",
                                                                Game.lastSelectedItemName + " " + "->" + " "
                                                                        + class6.getColTags(16748608)
                                                                        + itemcomposition_1.name,
                                                                16, item_0.id, int_24, int_31);
                                                    } else if (Game.spellSelected) {
                                                        if ((Actor.field932 & 0x1) == 1) {
                                                            class50.addMenuEntry(Game.field612,
                                                                    Game.field739 + " " + "->" + " "
                                                                            + class6.getColTags(16748608)
                                                                            + itemcomposition_1.name,
                                                                    17, item_0.id, int_24, int_31);
                                                        }
                                                    } else {
                                                        final String[] strings_2 = itemcomposition_1.groundActions;

                                                        for (int int_30 = 4; int_30 >= 0; --int_30) {
                                                            if ((strings_2 != null) && (strings_2[int_30] != null)) {
                                                                byte byte_1 = 0;
                                                                if (int_30 == 0) {
                                                                    byte_1 = 18;
                                                                }

                                                                if (int_30 == 1) {
                                                                    byte_1 = 19;
                                                                }

                                                                if (int_30 == 2) {
                                                                    byte_1 = 20;
                                                                }

                                                                if (int_30 == 3) {
                                                                    byte_1 = 21;
                                                                }

                                                                if (int_30 == 4) {
                                                                    byte_1 = 22;
                                                                }

                                                                int valueColor = 0;
                                                                if (WorldType.isPVP() && RuinMisc.SHOW_GROUND_ITEM_COLORS) {
                                                                    if(itemcomposition_1.id == 13307) {
                                                                        valueColor = 8590343;
                                                                    } else if(itemcomposition_1.BMValue >= 1) {
                                                                        valueColor = 9342520;
                                                                    } else {
                                                                        valueColor = 16748608;
                                                                    }
                                                                }

                                                                class50.addMenuEntry(strings_2[int_30],
                                                                        class6.getColTags(RuinMisc.SHOW_GROUND_ITEM_COLORS ? valueColor : 16748608) + itemcomposition_1.name,
                                                                        byte_1, item_0.id, int_24, int_31);
                                                            } else if (int_30 == 2) {
                                                                class50.addMenuEntry("Take",
                                                                        class6.getColTags(16748608)
                                                                                + itemcomposition_1.name,
                                                                        20, item_0.id, int_24, int_31);
                                                            }
                                                        }

                                                        class50.addMenuEntry("Examine",
                                                                class6.getColTags(16748608) + itemcomposition_1.name,
                                                                1004, item_0.id, int_24, int_31);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }

                                ++int_17;
                            }
                        }
                    } else if (widget_0.contentType == 1338) {
                        MapIconReference.method632(widget_0, int_8, int_9);
                    } else {
                        if (widget_0.contentType == 1400) { //World map interface
                            ItemContainer.renderOverview.method6003(MouseInput.mouseLastX, MouseInput.mouseLastY * 673804999, bool_1, int_8, int_9, widget_0.width, widget_0.height);
                        }

                        int int_20;
                        int int_22;
                        int int_23;
                        boolean bool_4;
                        if (!Game.isMenuOpen && bool_1) {
                            if (widget_0.contentType == 1400) {
                                ItemContainer.renderOverview.method6158(int_8, int_9, widget_0.width, widget_0.height,
                                        int_14, int_15);
                            } else {
                                int_21 = int_14 - int_8;
                                int_20 = int_15 - int_9;
                                if (widget_0.field2709 == 1) {
                                    class50.addMenuEntry(widget_0.tooltip, "", 24, 0, 0, widget_0.interfaceHash);
                                }

                                String string_0;
                                if ((widget_0.field2709 == 2) && !Game.spellSelected) {
                                    string_0 = class151.method3239(widget_0);
                                    if (string_0 != null) {
                                        class50.addMenuEntry(string_0, class6.getColTags(65280) + widget_0.spellName,
                                                25, 0, -1, widget_0.interfaceHash);
                                    }
                                }

                                if (widget_0.field2709 == 3) {
                                    class50.addMenuEntry("Close", "", 26, 0, 0, widget_0.interfaceHash);
                                }

                                if (widget_0.field2709 == 4) {
                                    class50.addMenuEntry(widget_0.tooltip, "", 28, 0, 0, widget_0.interfaceHash);
                                }

                                if (widget_0.field2709 == 5) {
                                    class50.addMenuEntry(widget_0.tooltip, "", 29, 0, 0, widget_0.interfaceHash);
                                }

                                if ((widget_0.field2709 == 6) && (Game.field744 == null)) {
                                    class50.addMenuEntry(widget_0.tooltip, "", 30, 0, -1, widget_0.interfaceHash);
                                }

                                if (widget_0.type == 2) {
                                    int_23 = 0;

                                    for (int_22 = 0; int_22 < widget_0.height; int_22++) {
                                        for (int_17 = 0; int_17 < widget_0.width; int_17++) {
                                            int_18 = int_17 * (widget_0.paddingX + 32);
                                            int_19 = int_22 * (widget_0.paddingY + 32);
                                            if (int_23 < 20) {
                                                int_18 += widget_0.xSprites[int_23];
                                                int_19 += widget_0.field2738[int_23];
                                            }

                                            if ((int_21 >= int_18) && (int_20 >= int_19) && (int_21 < (int_18 + 32))
                                                    && (int_20 < (int_19 + 32))) {
                                                Game.field691 = int_23;
                                                Occluder.field1819 = widget_0;
                                                if (widget_0.itemIds[int_23] > 0) {
                                                    final ItemComposition itemcomposition_0 = TextureProvider
                                                            .getItemDefinition(widget_0.itemIds[int_23] - 1);
                                                    if ((Game.itemSelectionState == 1) && class145
                                                            .method3188(class24.getWidgetClickMask(widget_0))) {
                                                        if ((widget_0.interfaceHash != class187.field2372)
                                                                || (int_23 != class13.selectedItemIndex)) {
                                                            class50.addMenuEntry("Use",
                                                                    Game.lastSelectedItemName + " " + "->" + " "
                                                                            + class6.getColTags(16748608)
                                                                            + itemcomposition_0.name,
                                                                    31, itemcomposition_0.id, int_23, widget_0.interfaceHash);
                                                        }
                                                    } else if (Game.spellSelected && class145
                                                            .method3188(class24.getWidgetClickMask(widget_0))) {
                                                        if ((Actor.field932 & 0x10) == 16) {
                                                            class50.addMenuEntry(Game.field612,
                                                                    Game.field739 + " " + "->" + " "
                                                                            + class6.getColTags(16748608)
                                                                            + itemcomposition_0.name,
                                                                    32, itemcomposition_0.id, int_23, widget_0.interfaceHash);
                                                        }
                                                    } else {
                                                        String[] strings_0 = itemcomposition_0.inventoryActions;
                                                        int_24 = -1;
                                                        if (Game.field726) {
                                                            final boolean bool_0 = Game.field727
                                                                    || KeyFocusListener.keyPressed[81];
                                                            if (bool_0) {
                                                                int_24 = itemcomposition_0.getShiftClickActionIndex();
                                                            }
                                                        }

                                                        if (class145.method3188(class24.getWidgetClickMask(widget_0))) {
                                                            for (int_31 = 4; int_31 >= 3; --int_31) {
                                                                if (int_24 != int_31) {
                                                                    ScriptEvent.method1027(widget_0, itemcomposition_0,
                                                                            int_23, int_31, false);
                                                                }
                                                            }
                                                        }

                                                        if (class148.method3197(class24.getWidgetClickMask(widget_0))) {
                                                            class50.addMenuEntry("Use",
                                                                    class6.getColTags(16748608)
                                                                            + itemcomposition_0.name,
                                                                    38, itemcomposition_0.id, int_23, widget_0.interfaceHash);
                                                        }

                                                        if (class145.method3188(class24.getWidgetClickMask(widget_0))) {
                                                            for (int_31 = 2; int_31 >= 0; --int_31) {
                                                                if (int_31 != int_24) {
                                                                    ScriptEvent.method1027(widget_0, itemcomposition_0,
                                                                            int_23, int_31, false);
                                                                }
                                                            }

                                                            if (int_24 >= 0) {
                                                                ScriptEvent.method1027(widget_0, itemcomposition_0,
                                                                        int_23, int_24, true);
                                                            }
                                                        }

                                                        strings_0 = widget_0.configActions;
                                                        if (strings_0 != null) {
                                                            for (int_31 = 4; int_31 >= 0; --int_31) {
                                                                if (strings_0[int_31] != null) {
                                                                    byte byte_0 = 0;
                                                                    if (int_31 == 0) {
                                                                        byte_0 = 39;
                                                                    }

                                                                    if (int_31 == 1) {
                                                                        byte_0 = 40;
                                                                    }

                                                                    if (int_31 == 2) {
                                                                        byte_0 = 41;
                                                                    }

                                                                    if (int_31 == 3) {
                                                                        byte_0 = 42;
                                                                    }

                                                                    if (int_31 == 4) {
                                                                        byte_0 = 43;
                                                                    }

                                                                    class50.addMenuEntry(strings_0[int_31],
                                                                            class6.getColTags(16748608)
                                                                                    + itemcomposition_0.name,
                                                                            byte_0, itemcomposition_0.id, int_23,
                                                                            widget_0.interfaceHash);
                                                                }
                                                            }
                                                        }

                                                        class50.addMenuEntry("Examine",
                                                                class6.getColTags(16748608) + itemcomposition_0.name,
                                                                1005, itemcomposition_0.id, int_23, widget_0.interfaceHash);
                                                    }
                                                }
                                            }

                                            ++int_23;
                                        }
                                    }
                                }

                                if (widget_0.hasScript) {
                                    if (Game.spellSelected) {
                                        int_22 = class24.getWidgetClickMask(widget_0);
                                        bool_4 = ((int_22 >> 21) & 0x1) != 0;
                                        if (bool_4 && ((Actor.field932 & 0x20) == 32)) {
                                            class50.addMenuEntry(Game.field612,
                                                    Game.field739 + " " + "->" + " " + widget_0.opBase, 58, 0,
                                                    widget_0.index, widget_0.interfaceHash);
                                        }
                                    } else {
                                        for (int_23 = 9; int_23 >= 5; --int_23) {
                                            final String string_1 = ItemLayer.method2565(widget_0, int_23);
                                            if (string_1 != null) {
                                                class50.addMenuEntry(string_1, widget_0.opBase, 1007, int_23 + 1,
                                                        widget_0.index, widget_0.interfaceHash);
                                            }
                                        }

                                        string_0 = class151.method3239(widget_0);
                                        if (string_0 != null) {
                                            class50.addMenuEntry(string_0, widget_0.opBase, 25, 0, widget_0.index,
                                                    widget_0.interfaceHash);
                                        }

                                        for (int_22 = 4; int_22 >= 0; --int_22) {
                                            final String string_2 = ItemLayer.method2565(widget_0, int_22);
                                            if (string_2 != null) {
                                                class50.addMenuEntry(string_2, widget_0.opBase, 57, int_22 + 1,
                                                        widget_0.index, widget_0.interfaceHash);
                                            }
                                        }

                                        int_17 = class24.getWidgetClickMask(widget_0);
                                        final boolean bool_5 = (int_17 & 0x1) != 0;
                                        if (bool_5) {
                                            class50.addMenuEntry("Continue", "", 30, 0, widget_0.index, widget_0.interfaceHash);
                                        }
                                    }
                                }
                            }
                        }

                        if (widget_0.type == 0) {
                            if (!widget_0.hasScript && class81.method1885(widget_0) && (widget_0 != class143.field1897)) {
                                continue;
                            }

                            method102(widgets_0, widget_0.interfaceHash, int_10, int_11, int_12, int_13, int_8 - widget_0.scrollX,
                                    int_9 - widget_0.scrollY);
                            if (widget_0.children != null) {
                                method102(widget_0.children, widget_0.interfaceHash, int_10, int_11, int_12, int_13,
                                        int_8 - widget_0.scrollX, int_9 - widget_0.scrollY);
                            }

                            final WidgetNode widgetnode_0 = (WidgetNode) Game.componentTable.get(widget_0.interfaceHash);
                            if (widgetnode_0 != null) {
                                if ((widgetnode_0.owner == 0) && (MouseInput.mouseLastX >= int_10)
                                        && ((MouseInput.mouseLastY * 673804999) >= int_11)
                                        && (MouseInput.mouseLastX < int_12)
                                        && ((MouseInput.mouseLastY * 673804999) < int_13) && !Game.isMenuOpen) {
                                    for (ScriptEvent scriptevent_0 = (ScriptEvent) Game.field638
                                            .getFront(); scriptevent_0 != null; scriptevent_0 = (ScriptEvent) Game.field638
                                            .getNext()) {
                                        if (scriptevent_0.boolean1) {
                                            scriptevent_0.unlink();
                                            scriptevent_0.widget.field2731 = false;
                                        }
                                    }

                                    if (class6.field39 == 0) {
                                        Game.draggedWidget = null;
                                        Game.field752 = null;
                                    }

                                    if (!Game.isMenuOpen) {
                                        class59.method1077();
                                    }
                                }

                                int_20 = widgetnode_0.id;
                                if (CombatInfo2.loadWidget(int_20)) {
                                    method102(GameCanvas.widgets[int_20], -1, int_10, int_11, int_12, int_13, int_8,
                                            int_9);
                                }
                            }
                        }

                        if (widget_0.hasScript) {
                            bool_1 = (MouseInput.mouseLastX >= int_10) && ((MouseInput.mouseLastY * 673804999) >= int_11)
                                    && (MouseInput.mouseLastX < int_12)
                                    && ((MouseInput.mouseLastY * 673804999) < int_13);
                            boolean bool_3 = false;
                            if (((MouseInput.mouseCurrentButton == 1)
                                    || (!InvType.middleMouseMovesCamera && (MouseInput.mouseCurrentButton == 4)))
                                    && bool_1) {
                                bool_3 = true;
                            }

                            boolean bool_2 = false;
                            if (((MouseInput.mouseLastButton == 1)
                                    || (!InvType.middleMouseMovesCamera && (MouseInput.mouseLastButton == 4)))
                                    && (MouseInput.mouseLastPressedX >= int_10)
                                    && (MouseInput.mouseLastPressedY >= int_11)
                                    && (MouseInput.mouseLastPressedX < int_12)
                                    && (MouseInput.mouseLastPressedY < int_13)) {
                                bool_2 = true;
                            }

                            if (bool_2) {
                                ClientPacket.method3447(widget_0, MouseInput.mouseLastPressedX - int_8,
                                        MouseInput.mouseLastPressedY - int_9);
                            }

                            if (widget_0.contentType == 1400) {
                                ItemContainer.renderOverview.method6174(int_14, int_15, bool_1 & bool_3,
                                        bool_1 & bool_2);
                            }

                            if ((Game.draggedWidget != null) && (widget_0 != Game.draggedWidget) && bool_1) {
                                int_22 = class24.getWidgetClickMask(widget_0);
                                bool_4 = ((int_22 >> 20) & 0x1) != 0;
                                if (bool_4) {
                                    Game.draggedOnWidget = widget_0;
                                }
                            }

                            if (widget_0 == Game.field752) {
                                Game.field601 = true;
                                Game.field757 = int_8;
                                Game.field758 = int_9;
                            }

                            if (widget_0.hasListener) {
                                ScriptEvent scriptevent_3;
                                if (bool_1 && (Game.mouseWheelRotation != 0)
                                        && (widget_0.onScrollWheelListener != null)) {
                                    scriptevent_3 = new ScriptEvent();
                                    scriptevent_3.boolean1 = true;
                                    scriptevent_3.widget = widget_0;
                                    scriptevent_3.field508 = Game.mouseWheelRotation;
                                    scriptevent_3.objs = widget_0.onScrollWheelListener;
                                    Game.field638.addFront(scriptevent_3);
                                }

                                if ((Game.draggedWidget != null) || (class276.field3559 != null) || Game.isMenuOpen) {
                                    bool_2 = false;
                                    bool_3 = false;
                                    bool_1 = false;
                                }

                                if (!widget_0.field2674 && bool_2) {
                                    widget_0.field2674 = true;
                                    if (widget_0.onClickListener != null) {
                                        scriptevent_3 = new ScriptEvent();
                                        scriptevent_3.boolean1 = true;
                                        scriptevent_3.widget = widget_0;
                                        scriptevent_3.field511 = MouseInput.mouseLastPressedX - int_8;
                                        scriptevent_3.field508 = MouseInput.mouseLastPressedY - int_9;
                                        scriptevent_3.objs = widget_0.onClickListener;
                                        Game.field638.addFront(scriptevent_3);
                                    }
                                }


                                if (widget_0.field2674 && bool_3 && (widget_0.onClickRepeatListener != null)) {
                                    scriptevent_3 = new ScriptEvent();
                                    scriptevent_3.boolean1 = true;
                                    scriptevent_3.widget = widget_0;
                                    scriptevent_3.field511 = MouseInput.mouseLastX - int_8;
                                    scriptevent_3.field508 = (MouseInput.mouseLastY * 673804999) - int_9;
                                    scriptevent_3.objs = widget_0.onClickRepeatListener;
                                    Game.field638.addFront(scriptevent_3);
                                }

                                if (widget_0.field2674 && !bool_3) {
                                    widget_0.field2674 = false;
                                    if (widget_0.onReleaseListener != null) {
                                        scriptevent_3 = new ScriptEvent();
                                        scriptevent_3.boolean1 = true;
                                        scriptevent_3.widget = widget_0;
                                        scriptevent_3.field511 = MouseInput.mouseLastX - int_8;
                                        scriptevent_3.field508 = (MouseInput.mouseLastY * 673804999) - int_9;
                                        scriptevent_3.objs = widget_0.onReleaseListener;
                                        Game.field779.addFront(scriptevent_3);
                                    }
                                }

                                if (bool_3 && (widget_0.onHoldListener != null)) {
                                    scriptevent_3 = new ScriptEvent();
                                    scriptevent_3.boolean1 = true;
                                    scriptevent_3.widget = widget_0;
                                    scriptevent_3.field511 = MouseInput.mouseLastX - int_8;
                                    scriptevent_3.field508 = (MouseInput.mouseLastY * 673804999) - int_9;
                                    scriptevent_3.objs = widget_0.onHoldListener;
                                    Game.field638.addFront(scriptevent_3);
                                }

                                if (!widget_0.field2731 && bool_1) {
                                    widget_0.field2731 = true;
                                    if (widget_0.onMouseOverListener != null) {
                                        scriptevent_3 = new ScriptEvent();
                                        scriptevent_3.boolean1 = true;
                                        scriptevent_3.widget = widget_0;
                                        scriptevent_3.field511 = MouseInput.mouseLastX - int_8;
                                        scriptevent_3.field508 = (MouseInput.mouseLastY * 673804999) - int_9;
                                        scriptevent_3.objs = widget_0.onMouseOverListener;
                                        Game.field638.addFront(scriptevent_3);
                                    }
                                }

                                if (widget_0.field2731 && bool_1 && (widget_0.onMouseRepeatListener != null)) {
                                    scriptevent_3 = new ScriptEvent();
                                    scriptevent_3.boolean1 = true;
                                    scriptevent_3.widget = widget_0;
                                    scriptevent_3.field511 = MouseInput.mouseLastX - int_8;
                                    scriptevent_3.field508 = (MouseInput.mouseLastY * 673804999) - int_9;
                                    scriptevent_3.objs = widget_0.onMouseRepeatListener;
                                    Game.field638.addFront(scriptevent_3);
                                }

                                if (widget_0.field2731 && !bool_1) {
                                    widget_0.field2731 = false;
                                    if (widget_0.onMouseLeaveListener != null) {
                                        scriptevent_3 = new ScriptEvent();
                                        scriptevent_3.boolean1 = true;
                                        scriptevent_3.widget = widget_0;
                                        scriptevent_3.field511 = MouseInput.mouseLastX - int_8;
                                        scriptevent_3.field508 = (MouseInput.mouseLastY * 673804999) - int_9;
                                        scriptevent_3.objs = widget_0.onMouseLeaveListener;
                                        Game.field779.addFront(scriptevent_3);
                                    }
                                }

                                if (widget_0.onTimerListener != null) {
                                    scriptevent_3 = new ScriptEvent();
                                    scriptevent_3.widget = widget_0;
                                    scriptevent_3.objs = widget_0.onTimerListener;
                                    Game.field778.addFront(scriptevent_3);
                                }

                                ScriptEvent scriptevent_1;
                                if ((widget_0.onVarTransmitListener != null)
                                        && (Game.pendingVarbitCount > widget_0.field2683)) {
                                    if ((widget_0.varTransmitTriggers != null)
                                            && ((Game.pendingVarbitCount - widget_0.field2683) <= 32)) {
                                        label1369:
                                        for (int_23 = widget_0.field2683; int_23 < Game.pendingVarbitCount; int_23++) {
                                            int_22 = Game.pendingVarbitChanges[int_23 & 0x1F];

                                            for (int_17 = 0; int_17 < widget_0.varTransmitTriggers.length; int_17++) {
                                                if (int_22 == widget_0.varTransmitTriggers[int_17]) {
                                                    scriptevent_1 = new ScriptEvent();
                                                    scriptevent_1.widget = widget_0;
                                                    scriptevent_1.objs = widget_0.onVarTransmitListener;
                                                    Game.field638.addFront(scriptevent_1);
                                                    break label1369;
                                                }
                                            }
                                        }
                                    } else {
                                        scriptevent_3 = new ScriptEvent();
                                        scriptevent_3.widget = widget_0;
                                        scriptevent_3.objs = widget_0.onVarTransmitListener;
                                        Game.field638.addFront(scriptevent_3);
                                    }

                                    widget_0.field2683 = Game.pendingVarbitCount;
                                }

                                if ((widget_0.onInvTransmitListener != null) && (Game.field767 > widget_0.field2735)) {
                                    if ((widget_0.invTransmitTriggers != null)
                                            && ((Game.field767 - widget_0.field2735) <= 32)) {
                                        label1345:
                                        for (int_23 = widget_0.field2735; int_23 < Game.field767; int_23++) {
                                            int_22 = Game.interfaceItemTriggers[int_23 & 0x1F];

                                            for (int_17 = 0; int_17 < widget_0.invTransmitTriggers.length; int_17++) {
                                                if (int_22 == widget_0.invTransmitTriggers[int_17]) {
                                                    scriptevent_1 = new ScriptEvent();
                                                    scriptevent_1.widget = widget_0;
                                                    scriptevent_1.objs = widget_0.onInvTransmitListener;
                                                    Game.field638.addFront(scriptevent_1);
                                                    break label1345;
                                                }
                                            }
                                        }
                                    } else {
                                        scriptevent_3 = new ScriptEvent();
                                        scriptevent_3.widget = widget_0;
                                        scriptevent_3.objs = widget_0.onInvTransmitListener;
                                        Game.field638.addFront(scriptevent_3);
                                    }

                                    widget_0.field2735 = Game.field767;
                                }

                                if ((widget_0.onStatTransmitListener != null)
                                        && (Game.changedSkillsCount > widget_0.field2702)) {
                                    if ((widget_0.statTransmitTriggers != null)
                                            && ((Game.changedSkillsCount - widget_0.field2702) <= 32)) {
                                        label1321:
                                        for (int_23 = widget_0.field2702; int_23 < Game.changedSkillsCount; int_23++) {
                                            int_22 = Game.changedSkills[int_23 & 0x1F];

                                            for (int_17 = 0; int_17 < widget_0.statTransmitTriggers.length; int_17++) {
                                                if (int_22 == widget_0.statTransmitTriggers[int_17]) {
                                                    scriptevent_1 = new ScriptEvent();
                                                    scriptevent_1.widget = widget_0;
                                                    scriptevent_1.objs = widget_0.onStatTransmitListener;
                                                    Game.field638.addFront(scriptevent_1);
                                                    break label1321;
                                                }
                                            }
                                        }
                                    } else {
                                        scriptevent_3 = new ScriptEvent();
                                        scriptevent_3.widget = widget_0;
                                        scriptevent_3.objs = widget_0.onStatTransmitListener;
                                        Game.field638.addFront(scriptevent_3);
                                    }

                                    widget_0.field2702 = Game.changedSkillsCount;
                                }

                                if ((Game.chatCycle > widget_0.field2697)
                                        && (widget_0.onChatTransmitListener != null)) {
                                    scriptevent_3 = new ScriptEvent();
                                    scriptevent_3.widget = widget_0;
                                    scriptevent_3.objs = widget_0.onChatTransmitListener;
                                    Game.field638.addFront(scriptevent_3);
                                }

                                if ((Game.field647 > widget_0.field2697)
                                        && (widget_0.onFriendTransmitListener != null)) {
                                    scriptevent_3 = new ScriptEvent();
                                    scriptevent_3.widget = widget_0;
                                    scriptevent_3.objs = widget_0.onFriendTransmitListener;
                                    Game.field638.addFront(scriptevent_3);
                                }

                                if ((Game.field828 > widget_0.field2697) && (widget_0.onClanTransmitListener != null)) {
                                    scriptevent_3 = new ScriptEvent();
                                    scriptevent_3.widget = widget_0;
                                    scriptevent_3.objs = widget_0.onClanTransmitListener;
                                    Game.field638.addFront(scriptevent_3);
                                }

                                if ((Game.field793 > widget_0.field2697)
                                        && (widget_0.onStockTransmitListener != null)) {
                                    scriptevent_3 = new ScriptEvent();
                                    scriptevent_3.widget = widget_0;
                                    scriptevent_3.objs = widget_0.onStockTransmitListener;
                                    Game.field638.addFront(scriptevent_3);
                                }

                                if ((Game.field774 > widget_0.field2697) && (widget_0.onCamFinishedListener != null)) {
                                    scriptevent_3 = new ScriptEvent();
                                    scriptevent_3.widget = widget_0;
                                    scriptevent_3.objs = widget_0.onCamFinishedListener;
                                    Game.field638.addFront(scriptevent_3);
                                }

                                if ((Game.field775 > widget_0.field2697) && (widget_0.onMiscTransmitListener != null)) {
                                    scriptevent_3 = new ScriptEvent();
                                    scriptevent_3.widget = widget_0;
                                    scriptevent_3.objs = widget_0.onMiscTransmitListener;
                                    Game.field638.addFront(scriptevent_3);
                                }

                                widget_0.field2697 = Game.cycleCntr;
                                if (widget_0.onKeyListener != null) {
                                    for (int_23 = 0; int_23 < Game.field799; int_23++) {
                                        final ScriptEvent scriptevent_4 = new ScriptEvent();
                                        scriptevent_4.widget = widget_0;
                                        scriptevent_4.pressedKey = Game.field773[int_23];
                                        scriptevent_4.typedKey = Game.field800[int_23];
                                        scriptevent_4.objs = widget_0.onKeyListener;
                                        Game.field638.addFront(scriptevent_4);
                                    }
                                }
                            }
                        }

                        if (!widget_0.hasScript && (Game.draggedWidget == null) && (class276.field3559 == null)
                                && !Game.isMenuOpen) {
                            if (((widget_0.field2713 >= 0) || (widget_0.field2632 != 0))
                                    && (MouseInput.mouseLastX >= int_10)
                                    && ((MouseInput.mouseLastY * 673804999) >= int_11)
                                    && (MouseInput.mouseLastX < int_12)
                                    && ((MouseInput.mouseLastY * 673804999) < int_13)) {
                                if (widget_0.field2713 >= 0) {
                                    class143.field1897 = widgets_0[widget_0.field2713];
                                } else {
                                    class143.field1897 = widget_0;
                                }
                            }

                            if ((widget_0.type == 8) && (MouseInput.mouseLastX >= int_10)
                                    && ((MouseInput.mouseLastY * 673804999) >= int_11)
                                    && (MouseInput.mouseLastX < int_12)
                                    && ((MouseInput.mouseLastY * 673804999) < int_13)) {
                                class141.field1888 = widget_0;
                            }

                            if (widget_0.scrollHeight > widget_0.height) {
                                int_21 = int_8 + widget_0.width;
                                int_20 = widget_0.height;
                                int_23 = widget_0.scrollHeight;
                                int_22 = MouseInput.mouseLastX;
                                int_17 = MouseInput.mouseLastY * 673804999;
                                if (Game.field746) {
                                    Game.field660 = 32;
                                } else {
                                    Game.field660 = 0;
                                }

                                Game.field746 = false;
                                if ((MouseInput.mouseCurrentButton == 1)
                                        || (!InvType.middleMouseMovesCamera && (MouseInput.mouseCurrentButton == 4))) {
                                    if ((int_22 >= int_21) && (int_22 < (int_21 + 16)) && (int_17 >= int_9)
                                            && (int_17 < (int_9 + 16))) {
                                        widget_0.scrollY -= 4;
                                        Player.method1114(widget_0);
                                    } else if ((int_22 >= int_21) && (int_22 < (int_21 + 16))
                                            && (int_17 >= ((int_9 + int_20) - 16)) && (int_17 < (int_9 + int_20))) {
                                        widget_0.scrollY += 4;
                                        Player.method1114(widget_0);
                                    } else if ((int_22 >= (int_21 - Game.field660))
                                            && (int_22 < (int_21 + Game.field660 + 16)) && (int_17 >= (int_9 + 16))
                                            && (int_17 < ((int_9 + int_20) - 16))) {
                                        int_18 = (int_20 * (int_20 - 32)) / int_23;
                                        if (int_18 < 8) {
                                            int_18 = 8;
                                        }

                                        int_19 = int_17 - int_9 - 16 - (int_18 / 2);
                                        final int int_25 = int_20 - 32 - int_18;
                                        widget_0.scrollY = (int_19 * (int_23 - int_20)) / int_25;
                                        Player.method1114(widget_0);
                                        Game.field746 = true;
                                    }
                                }

                                if (Game.mouseWheelRotation != 0) {
                                    int_18 = widget_0.width;
                                    if ((int_22 >= (int_21 - int_18)) && (int_17 >= int_9) && (int_22 < (int_21 + 16))
                                            && (int_17 <= (int_20 + int_9))) {
                                        widget_0.scrollY += Game.mouseWheelRotation * 45;
                                        Player.method1114(widget_0);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    static void method110(final String string_0) {
        if (!string_0.equals("")) {
            final PacketNode packetnode_0 = class26.method433(ClientPacket.field2153, Game.field626.field1218);
            packetnode_0.packetBuffer.putByte(class316.getLength(string_0));
            packetnode_0.packetBuffer.putString(string_0);
            Game.field626.method1980(packetnode_0);
        }
    }

}
