public class MapIcon {

    static AbstractSoundSystem soundSystem0;
    static String field238;
    static IndexedSprite[] slStarSprites;
    static UrlRequester urlRequester;
    static Region region;
    public final int areaId;
    public final Coordinates field236;
    public final Coordinates field243;
    final int field242;
    final int field239;
    final MapLabel field246;
    int screenX;
    int screenY;

    MapIcon(final int int_0, final Coordinates coordinates_0, final Coordinates coordinates_1,
            final MapLabel maplabel_0) {
        areaId = int_0;
        field243 = coordinates_0;
        field236 = coordinates_1;
        field246 = maplabel_0;
        final Area area_0 = Area.mapAreaType[areaId];
        final SpritePixels spritepixels_0 = area_0.getMapIcon(false);
        if (spritepixels_0 != null) {
            field242 = spritepixels_0.width;
            field239 = spritepixels_0.height;
        } else {
            field242 = 0;
            field239 = 0;
        }

    }

    boolean method464(final int int_0, final int int_1) {
        return method465(int_0, int_1) || method466(int_0, int_1);
    }

    boolean method465(final int int_0, final int int_1) {
        final Area area_0 = Area.mapAreaType[areaId];
        switch (area_0.horizontalAlignment.value) {
            case 0:
                if ((int_0 >= (screenX - (field242 / 2))) && (int_0 <= ((field242 / 2) + screenX))) {
                    break;
                }

                return false;
            case 1:
                if ((int_0 > (screenX - field242)) && (int_0 <= screenX)) {
                    break;
                }

                return false;
            case 2:
                if ((int_0 < screenX) || (int_0 >= (screenX + field242))) {
                    return false;
                }
        }

        switch (area_0.verticalAlignment.value) {
            case 0:
                if ((int_1 >= screenY) && (int_1 < (screenY + field239))) {
                    break;
                }

                return false;
            case 1:
                if ((int_1 < (screenY - (field239 / 2))) || (int_1 > ((field239 / 2) + screenY))) {
                    return false;
                }
                break;
            case 2:
                if ((int_1 <= (screenY - field239)) || (int_1 > screenY)) {
                    return false;
                }
        }

        return true;
    }

    boolean method466(final int int_0, final int int_1) {
        return field246 != null && (((int_0 >= (screenX - (field246.field184 / 2))) && (int_0 <= ((field246.field184 / 2) + screenX))) && ((int_1 >= screenY) && (int_1 <= (field246.field182 + screenY))));
    }

    static void method475() {
        final String string_0 = "Your ignore list is full. Max of 100 for free users, and 400 for members";
        class143.sendGameMessage(30, "", string_0);
    }

    static void method474(NPCComposition npccomposition_0, final int int_0, final int int_1, final int int_2) {
        if (Game.menuOptionCount < 400) {
            if (npccomposition_0.configs != null) {
                npccomposition_0 = npccomposition_0.transform();
            }

            if (npccomposition_0 != null) {
                if (npccomposition_0.field3504) {
                    if (!npccomposition_0.field3517 || (Game.field748 == int_0)) {
                        String string_0 = npccomposition_0.name;
                        if (npccomposition_0.combatLevel != 0) {
                            string_0 = string_0
                                    + UrlRequester.method3113(npccomposition_0.combatLevel,
                                    class138.localPlayer.combatLevel)
                                    + " " + " (" + "level-" + npccomposition_0.combatLevel + ")";
                        }

                        if (npccomposition_0.field3517 && Game.field725) {
                            class50.addMenuEntry("Examine", class6.getColTags(16776960) + string_0, 1003, int_0, int_1,
                                    int_2);
                        }

                        if (Game.itemSelectionState == 1) {
                            class50.addMenuEntry("Use", Game.lastSelectedItemName + " " + "->" + " "
                                    + class6.getColTags(16776960) + string_0, 7, int_0, int_1, int_2);
                        } else if (Game.spellSelected) {
                            if ((Actor.field932 & 0x2) == 2) {
                                class50.addMenuEntry(Game.field612,
                                        Game.field739 + " " + "->" + " " + class6.getColTags(16776960) + string_0, 8,
                                        int_0, int_1, int_2);
                            }
                        } else {
                            final int int_3 = npccomposition_0.field3517 && Game.field725 ? 2000 : 0;
                            final String[] strings_0 = npccomposition_0.actions;
                            int int_4;
                            int int_5;
                            if (strings_0 != null) {
                                for (int_4 = 4; int_4 >= 0; --int_4) {
                                    if ((strings_0[int_4] != null) && !strings_0[int_4].equalsIgnoreCase("Attack")) {
                                        int_5 = 0;
                                        if (int_4 == 0) {
                                            int_5 = int_3 + 9;
                                        }

                                        if (int_4 == 1) {
                                            int_5 = int_3 + 10;
                                        }

                                        if (int_4 == 2) {
                                            int_5 = int_3 + 11;
                                        }

                                        if (int_4 == 3) {
                                            int_5 = int_3 + 12;
                                        }

                                        if (int_4 == 4) {
                                            int_5 = int_3 + 13;
                                        }

                                        class50.addMenuEntry(strings_0[int_4], class6.getColTags(16776960) + string_0,
                                                int_5, int_0, int_1, int_2);
                                    }
                                }
                            }

                            if (strings_0 != null) {
                                for (int_4 = 4; int_4 >= 0; --int_4) {
                                    if ((strings_0[int_4] != null) && strings_0[int_4].equalsIgnoreCase("Attack")) {
                                        short short_0 = 0;
                                        if (Game.npcAttackOption != AttackOption.AttackOption_hidden) {
                                            if ((Game.npcAttackOption == AttackOption.AttackOption_alwaysRightClick)
                                                    || ((AttackOption.AttackOption_dependsOnCombatLevels == Game.npcAttackOption)
                                                    && (npccomposition_0.combatLevel > class138.localPlayer.combatLevel))) {
                                                short_0 = 2000;
                                            }

                                            int_5 = 0;
                                            if (int_4 == 0) {
                                                int_5 = short_0 + 9;
                                            }

                                            if (int_4 == 1) {
                                                int_5 = short_0 + 10;
                                            }

                                            if (int_4 == 2) {
                                                int_5 = short_0 + 11;
                                            }

                                            if (int_4 == 3) {
                                                int_5 = short_0 + 12;
                                            }

                                            if (int_4 == 4) {
                                                int_5 = short_0 + 13;
                                            }

                                            class50.addMenuEntry(strings_0[int_4],
                                                    class6.getColTags(16776960) + string_0, int_5, int_0, int_1, int_2);
                                        }
                                    }
                                }
                            }

                            if (!npccomposition_0.field3517 || !Game.field725) {
                                class50.addMenuEntry("Examine", class6.getColTags(16776960) + string_0, 1003, int_0,
                                        int_1, int_2);
                            }
                        }

                    }
                }
            }
        }
    }

    static void gameDraw(final Widget[] widgets_0, final int int_0, final int int_1, final int int_2, final int int_3,
                         final int int_4, final int int_5, final int int_6, final int int_7) {
        Rasterizer2D.setDrawRegion(int_1, int_2, int_3, int_4);
        Graphics3D.Rasterizer3D_method1();

        for (int int_8 = 0; int_8 < widgets_0.length; int_8++) {
            final Widget widget_0 = widgets_0[int_8];
            if ((widget_0 != null)
                    && ((widget_0.parentHash == int_0) || ((int_0 == -1412584499) && (widget_0 == Game.draggedWidget)))) {
                int int_9;
                if (int_7 == -1) {
                    Game.widgetPositionX[Game.widgetCount] = widget_0.relativeX + int_5;
                    Game.widgetPositionY[Game.widgetCount] = int_6 + widget_0.relativeY;
                    Game.widgetBoundsWidth[Game.widgetCount] = widget_0.width;
                    Game.widgetBoundsHeight[Game.widgetCount] = widget_0.height;
                    int_9 = ++Game.widgetCount - 1;
                } else {
                    int_9 = int_7;
                }

                widget_0.boundsIndex = int_9;
                widget_0.loopCycle = Game.gameCycle;
                if (!widget_0.hasScript || !class81.method1885(widget_0)) {
                    int int_10;
                    if (widget_0.contentType > 0) {
                        int_10 = widget_0.contentType;
                        if (int_10 == 324) {
                            if (Game.field842 == -1) {
                                Game.field842 = widget_0.spriteId;
                                Game.field586 = widget_0.field2641;
                            }

                            if (Game.customizedAppearance.isFemale) {
                                widget_0.spriteId = Game.field842;
                            } else {
                                widget_0.spriteId = Game.field586;
                            }
                        } else if (int_10 == 325) {
                            if (Game.field842 == -1) {
                                Game.field842 = widget_0.spriteId;
                                Game.field586 = widget_0.field2641;
                            }

                            if (Game.customizedAppearance.isFemale) {
                                widget_0.spriteId = Game.field586;
                            } else {
                                widget_0.spriteId = Game.field842;
                            }
                        } else if (int_10 == 327) {
                            widget_0.rotationX = 150;
                            widget_0.rotationZ = (int) (Math.sin(Game.gameCycle / 40.0D) * 256.0D) & 0x7FF;
                            widget_0.modelType = 5;
                            widget_0.modelId = 0;
                        } else if (int_10 == 328) {
                            widget_0.rotationX = 150;
                            widget_0.rotationZ = (int) (Math.sin(Game.gameCycle / 40.0D) * 256.0D) & 0x7FF;
                            widget_0.modelType = 5;
                            widget_0.modelId = 1;
                        }
                    }

                    int_10 = widget_0.relativeX + int_5;
                    int int_11 = int_6 + widget_0.relativeY;
                    int int_12 = widget_0.opacity;
                    int int_13;
                    int int_14;
                    if (widget_0 == Game.draggedWidget) {
                        if ((int_0 != -1412584499) && !widget_0.dragRenderBehavior) {
                            Occluder.field1814 = widgets_0;
                            class297.field3687 = int_5;
                            GrandExchangeEvents.field15 = int_6;
                            continue;
                        }

                        if (Game.draggingWidget && Game.field601) {
                            int_13 = MouseInput.mouseLastX;
                            int_14 = MouseInput.mouseLastY * 673804999;
                            int_13 -= Game.field753;
                            int_14 -= Game.field749;
                            if (int_13 < Game.field757) {
                                int_13 = Game.field757;
                            }

                            if ((int_13 + widget_0.width) > (Game.field757 + Game.field752.width)) {
                                int_13 = (Game.field757 + Game.field752.width) - widget_0.width;
                            }

                            if (int_14 < Game.field758) {
                                int_14 = Game.field758;
                            }

                            if ((int_14 + widget_0.height) > (Game.field758 + Game.field752.height)) {
                                int_14 = (Game.field758 + Game.field752.height) - widget_0.height;
                            }

                            int_10 = int_13;
                            int_11 = int_14;
                        }

                        if (!widget_0.dragRenderBehavior) {
                            int_12 = 128;
                        }
                    }

                    int int_15;
                    int int_16;
                    int int_17;
                    int int_18;
                    int int_19;
                    int int_20;
                    if (widget_0.type == 2) {
                        int_13 = int_1;
                        int_14 = int_2;
                        int_16 = int_3;
                        int_18 = int_4;
                    } else if (widget_0.type == 9) {
                        int_15 = int_10;
                        int_17 = int_11;
                        int_19 = int_10 + widget_0.width;
                        int_20 = int_11 + widget_0.height;
                        if (int_19 < int_10) {
                            int_15 = int_19;
                            int_19 = int_10;
                        }

                        if (int_20 < int_11) {
                            int_17 = int_20;
                            int_20 = int_11;
                        }

                        ++int_19;
                        ++int_20;
                        int_13 = int_15 > int_1 ? int_15 : int_1;
                        int_14 = int_17 > int_2 ? int_17 : int_2;
                        int_16 = int_19 < int_3 ? int_19 : int_3;
                        int_18 = int_20 < int_4 ? int_20 : int_4;
                    } else {
                        int_15 = int_10 + widget_0.width;
                        int_17 = int_11 + widget_0.height;
                        int_13 = int_10 > int_1 ? int_10 : int_1;
                        int_14 = int_11 > int_2 ? int_11 : int_2;
                        int_16 = int_15 < int_3 ? int_15 : int_3;
                        int_18 = int_17 < int_4 ? int_17 : int_4;
                    }

                    if (!widget_0.hasScript || ((int_13 < int_16) && (int_14 < int_18))) {
                        int int_21;
                        int int_22;
                        int int_23;
                        int int_24;
                        int int_25;
                        int int_26;
                        int int_27;
                        int int_28;
                        int int_29;
                        int int_31;
                        int int_32;
                        int int_33;
                        int int_34;
                        int int_35;
                        int int_36;
                        int int_37;
                        int int_38;
                        int int_40;
                        int int_41;
                        int int_42;
                        if (widget_0.contentType != 0) {
                            if (widget_0.contentType == 1336) {
                                if(WidgetTimer.SHOW_WIDGETS)
                                    WidgetTimer.draw();
                                if (Game.displayFps) {
                                    int_11 += 15;
                                    Actor.font_p12full.method5524("Fps:" + GameEngine.FPS, int_10 + widget_0.width,
                                            int_11, 16776960, -1);
                                    int_11 += 15;
                                    final Runtime runtime_0 = Runtime.getRuntime();
                                    int_17 = (int) ((runtime_0.totalMemory() - runtime_0.freeMemory()) / 1024L);
                                    int_19 = 16776960;
                                    if ((int_17 > 327680) && !Game.lowMemory) {
                                        int_19 = 16711680;
                                    }

                                    Actor.font_p12full.method5524("Mem:" + int_17 + "k", int_10 + widget_0.width,
                                            int_11, int_19, -1);
                                    int_11 += 15;
                                }
                                continue;
                            }

                            if (widget_0.contentType == 1337) {
                                Game.field729 = int_10;
                                Game.field730 = int_11;
                                int_19 = widget_0.width;
                                int_20 = widget_0.height;
                                ++Game.field687;
                                class148.method3198();
                                IndexFile.method3380();
                                class54.method1019();
                                class24.method424(true);
                                FriendManager.method1655();
                                class24.method424(false);

                                for (Projectile projectile_0 = (Projectile) Game.projectiles
                                        .getFront(); projectile_0 != null; projectile_0 = (Projectile) Game.projectiles
                                        .getNext()) {
                                    if ((projectile_0.floor == class13.plane)
                                            && (Game.gameCycle <= projectile_0.endCycle)) {
                                        if (Game.gameCycle >= projectile_0.startMovementCycle) {
                                            if (projectile_0.interacting > 0) {
                                                final NPC npc_0 = Game.cachedNPCs[projectile_0.interacting - 1];
                                                if ((npc_0 != null) && (npc_0.x >= 0) && (npc_0.x < 13312)
                                                        && (npc_0.y >= 0) && (npc_0.y < 13312)) {
                                                    projectile_0.moveProjectile(npc_0.x, npc_0.y,
                                                            WorldMapType2.getTileHeight(npc_0.x, npc_0.y,
                                                                    projectile_0.floor) - projectile_0.endHeight,
                                                            Game.gameCycle);
                                                }
                                            }

                                            if (projectile_0.interacting < 0) {
                                                int_22 = -projectile_0.interacting - 1;
                                                Player player_0;
                                                if (int_22 == Game.localInteractingIndex) {
                                                    player_0 = class138.localPlayer;
                                                } else {
                                                    player_0 = Game.cachedPlayers[int_22];
                                                }

                                                if ((player_0 != null) && (player_0.x >= 0) && (player_0.x < 13312)
                                                        && (player_0.y >= 0) && (player_0.y < 13312)) {
                                                    projectile_0.moveProjectile(player_0.x, player_0.y,
                                                            WorldMapType2.getTileHeight(player_0.x, player_0.y,
                                                                    projectile_0.floor) - projectile_0.endHeight,
                                                            Game.gameCycle);
                                                }
                                            }

                                            projectile_0.update(Game.field700);
                                            region.method2883(class13.plane, (int) projectile_0.x, (int) projectile_0.y,
                                                    (int) projectile_0.z, 60, projectile_0, projectile_0.rotationX, -1L,
                                                    false);
                                        }
                                    } else {
                                        projectile_0.unlink();
                                    }
                                }

                                for (GraphicsObject graphicsobject_0 = (GraphicsObject) Game.graphicsObjectDeque
                                        .getFront(); graphicsobject_0 != null; graphicsobject_0 = (GraphicsObject) Game.graphicsObjectDeque
                                        .getNext()) {
                                    if ((graphicsobject_0.level == class13.plane) && !graphicsobject_0.finished) {
                                        if (Game.gameCycle >= graphicsobject_0.startCycle) {
                                            graphicsobject_0.method1771(Game.field700);
                                            if (graphicsobject_0.finished) {
                                                graphicsobject_0.unlink();
                                            } else {
                                                region.method2883(graphicsobject_0.level, graphicsobject_0.x,
                                                        graphicsobject_0.y, graphicsobject_0.height, 60,
                                                        graphicsobject_0, 0, -1L, false);
                                            }
                                        }
                                    } else {
                                        graphicsobject_0.unlink();
                                    }
                                }

                                class43.method714(int_10, int_11, int_19, int_20, true);
                                int_15 = Game.Viewport_xOffset;
                                int_17 = Game.Viewport_yOffset;
                                int_19 = Game.viewportWidth;
                                int_20 = Game.viewportHeight;
                                Rasterizer2D.setDrawRegion(int_15, int_17, int_19 + int_15, int_20 + int_17);
                                Graphics3D.Rasterizer3D_method1();
                                if (!Game.field822) {
                                    int_21 = Game.cameraPitchTarget;
                                    if ((Game.field738 / 256) > int_21) {
                                        int_21 = Game.field738 / 256;
                                    }

                                    if (Game.field823[4] && ((Game.field825[4] + 128) > int_21)) {
                                        int_21 = Game.field825[4] + 128;
                                    }

                                    int_23 = Game.mapAngle & 0x7FF;
                                    class49.method951(CacheFile.field1428, ItemComposition.field3478,
                                            GrandExchangeEvent.field23, int_21, int_23, (int_21 * 3) + 600);
                                }

                                if (!Game.field822) {
                                    int_21 = Size.method108();
                                } else {
                                    if (class10.preferences.hideRoofs) {
                                        int_23 = class13.plane;
                                    } else {
                                        int_22 = WorldMapType2.getTileHeight(CacheFile.cameraX, Coordinates.cameraY,
                                                class13.plane);
                                        if (((int_22 - SceneTilePaint.cameraZ) < 800)
                                                && ((class50.tileSettings[class13.plane][CacheFile.cameraX >> 7][Coordinates.cameraY >> 7]
                                                & 0x4) != 0)) {
                                            int_23 = class13.plane;
                                        } else {
                                            int_23 = 3;
                                        }
                                    }

                                    int_21 = int_23;
                                }

                                int_23 = CacheFile.cameraX;
                                int_22 = SceneTilePaint.cameraZ;
                                int_24 = Coordinates.cameraY;
                                int_25 = class7.cameraPitch;
                                int_26 = DynamicObject.cameraYaw;

                                for (int_27 = 0; int_27 < 5; int_27++) {
                                    if (Game.field823[int_27]) {
                                        int_28 = (int) (((Math.random() * ((Game.field824[int_27] * 2) + 1))
                                                - Game.field824[int_27])
                                                + (Math.sin(
                                                Game.field705[int_27] * (Game.field826[int_27] / 100.0D))
                                                * Game.field825[int_27]));
                                        if (int_27 == 0) {
                                            CacheFile.cameraX += int_28;
                                        }

                                        if (int_27 == 1) {
                                            SceneTilePaint.cameraZ += int_28;
                                        }

                                        if (int_27 == 2) {
                                            Coordinates.cameraY += int_28;
                                        }

                                        if (int_27 == 3) {
                                            DynamicObject.cameraYaw = (int_28 + DynamicObject.cameraYaw) & 0x7FF;
                                        }

                                        if (int_27 == 4) {
                                            class7.cameraPitch += int_28;
                                            if (class7.cameraPitch < 128) {
                                                class7.cameraPitch = 128;
                                            }

                                            if (class7.cameraPitch > 383) {
                                                class7.cameraPitch = 383;
                                            }
                                        }
                                    }
                                }

                                int_27 = MouseInput.mouseLastX;
                                int_28 = MouseInput.mouseLastY * 673804999;
                                if (MouseInput.mouseLastButton != 0) {
                                    int_27 = MouseInput.mouseLastPressedX;
                                    int_28 = MouseInput.mouseLastPressedY;
                                }

                                if ((int_27 >= int_15) && (int_27 < (int_15 + int_19)) && (int_28 >= int_17)
                                        && (int_28 < (int_17 + int_20))) {
                                    GameEngine.method913(int_27 - int_15, int_28 - int_17);
                                } else {
                                    class120.Viewport_containsMouse = false;
                                    class120.Viewport_entityCountAtMouse = 0;
                                }

                                class54.method1017();
                                Rasterizer2D.Rasterizer2D_fillRectangle(int_15, int_17, int_19, int_20, 0);
                                class54.method1017();
                                int_29 = Graphics3D.Rasterizer3D_zoom;
                                Graphics3D.Rasterizer3D_zoom = Game.scale;
                                region.drawRegion(CacheFile.cameraX, SceneTilePaint.cameraZ, Coordinates.cameraY,
                                        class7.cameraPitch, DynamicObject.cameraYaw, int_21);
                                Graphics3D.Rasterizer3D_zoom = int_29;
                                class54.method1017();
                                region.clearEntities();
                                Game.overheadTextCount = 0;
                                boolean bool_3 = false;
                                int_31 = -1;
                                int_32 = -1;
                                int_33 = class81.playerIndexesCount;
                                final int[] ints_0 = class81.playerIndices;

                                for (int_34 = 0; int_34 < (int_33 + Game.npcIndexesCount); int_34++) {
                                    Object object_0;
                                    if (int_34 < int_33) {
                                        object_0 = Game.cachedPlayers[ints_0[int_34]];
                                        if (ints_0[int_34] == Game.field707) {
                                            bool_3 = true;
                                            int_31 = int_34;
                                            continue;
                                        }

                                        if (object_0 == class138.localPlayer) {
                                            int_32 = int_34;
                                            continue;
                                        }
                                    } else {
                                        object_0 = Game.cachedNPCs[Game.npcIndices[int_34 - int_33]];
                                    }

                                    class35.draw2DExtras((Actor) object_0, int_34, int_15, int_17, int_19, int_20);
                                }

                                if (Game.field699 && (int_32 != -1)) {
                                    class35.draw2DExtras(class138.localPlayer, int_32, int_15, int_17, int_19, int_20);
                                }

                                if (bool_3) {
                                    class35.draw2DExtras(Game.cachedPlayers[Game.field707], int_31, int_15, int_17,
                                            int_19, int_20);
                                }

                                for (int_34 = 0; int_34 < Game.overheadTextCount; int_34++) {
                                    int_35 = Game.overheadTextsX[int_34];
                                    int_36 = Game.overheadTextsY[int_34];
                                    int_37 = Game.overheadTextsOffsetX[int_34];
                                    int_38 = Game.overheadTextsOffsetY[int_34];
                                    boolean bool_4 = true;

                                    while (bool_4) {
                                        bool_4 = false;

                                        for (int_40 = 0; int_40 < int_34; int_40++) {
                                            if (((int_36 + 2) > (Game.overheadTextsY[int_40]
                                                    - Game.overheadTextsOffsetY[int_40]))
                                                    && ((int_36 - int_38) < (Game.overheadTextsY[int_40] + 2))
                                                    && ((int_35 - int_37) < (Game.overheadTextsOffsetX[int_40]
                                                    + Game.overheadTextsX[int_40]))
                                                    && ((int_37 + int_35) > (Game.overheadTextsX[int_40]
                                                    - Game.overheadTextsOffsetX[int_40]))
                                                    && ((Game.overheadTextsY[int_40]
                                                    - Game.overheadTextsOffsetY[int_40]) < int_36)) {
                                                int_36 = Game.overheadTextsY[int_40]
                                                        - Game.overheadTextsOffsetY[int_40];
                                                bool_4 = true;
                                            }
                                        }
                                    }

                                    Game.screenX = Game.overheadTextsX[int_34];
                                    Game.screenY = Game.overheadTextsY[int_34] = int_36;
                                    final String string_1 = Game.overheadTexts[int_34];
                                    if (Game.field742 == 0) {
                                        int_41 = 16776960;
                                        if (Game.field673[int_34] < 6) {
                                            int_41 = Game.field731[Game.field673[int_34]];
                                        }

                                        if (Game.field673[int_34] == 6) {
                                            int_41 = (Game.field687 % 20) < 10 ? 16711680 : 16776960;
                                        }

                                        if (Game.field673[int_34] == 7) {
                                            int_41 = (Game.field687 % 20) < 10 ? 255 : 65535;
                                        }

                                        if (Game.field673[int_34] == 8) {
                                            int_41 = (Game.field687 % 20) < 10 ? 45056 : 8454016;
                                        }

                                        if (Game.field673[int_34] == 9) {
                                            int_42 = 150 - Game.overheadTextsCyclesRemaining[int_34];
                                            if (int_42 < 50) {
                                                int_41 = (int_42 * 1280) + 16711680;
                                            } else if (int_42 < 100) {
                                                int_41 = 16776960 - ((int_42 - 50) * 327680);
                                            } else if (int_42 < 150) {
                                                int_41 = ((int_42 - 100) * 5) + 65280;
                                            }
                                        }

                                        if (Game.field673[int_34] == 10) {
                                            int_42 = 150 - Game.overheadTextsCyclesRemaining[int_34];
                                            if (int_42 < 50) {
                                                int_41 = (int_42 * 5) + 16711680;
                                            } else if (int_42 < 100) {
                                                int_41 = 16711935 - ((int_42 - 50) * 327680);
                                            } else if (int_42 < 150) {
                                                int_41 = (((int_42 - 100) * 327680) + 255) - ((int_42 - 100) * 5);
                                            }
                                        }

                                        if (Game.field673[int_34] == 11) {
                                            int_42 = 150 - Game.overheadTextsCyclesRemaining[int_34];
                                            if (int_42 < 50) {
                                                int_41 = 16777215 - (int_42 * 327685);
                                            } else if (int_42 < 100) {
                                                int_41 = ((int_42 - 50) * 327685) + 65280;
                                            } else if (int_42 < 150) {
                                                int_41 = 16777215 - ((int_42 - 100) * 327680);
                                            }
                                        }

                                        if (Game.field674[int_34] == 0) {
                                            ClanMemberManager.fontBold12.drawTextCentered(string_1,
                                                    int_15 + Game.screenX, int_17 + Game.screenY, int_41, 0);
                                        }

                                        if (Game.field674[int_34] == 1) {
                                            ClanMemberManager.fontBold12.method5609(string_1, int_15 + Game.screenX,
                                                    int_17 + Game.screenY, int_41, 0, Game.field687);
                                        }

                                        if (Game.field674[int_34] == 2) {
                                            ClanMemberManager.fontBold12.method5575(string_1, int_15 + Game.screenX,
                                                    int_17 + Game.screenY, int_41, 0, Game.field687);
                                        }

                                        if (Game.field674[int_34] == 3) {
                                            ClanMemberManager.fontBold12.method5539(string_1, int_15 + Game.screenX,
                                                    int_17 + Game.screenY, int_41, 0, Game.field687,
                                                    150 - Game.overheadTextsCyclesRemaining[int_34]);
                                        }

                                        if (Game.field674[int_34] == 4) {
                                            int_42 = ((150 - Game.overheadTextsCyclesRemaining[int_34])
                                                    * (ClanMemberManager.fontBold12.getTextWidth(string_1) + 100))
                                                    / 150;
                                            Rasterizer2D.setInnerDrawRegion((int_15 + Game.screenX) - 50, int_17,
                                                    int_15 + Game.screenX + 50, int_17 + int_20);
                                            ClanMemberManager.fontBold12.method5522(string_1,
                                                    (int_15 + Game.screenX + 50) - int_42, int_17 + Game.screenY,
                                                    int_41, 0);
                                            Rasterizer2D.setDrawRegion(int_15, int_17, int_15 + int_19,
                                                    int_20 + int_17);
                                        }

                                        if (Game.field674[int_34] == 5) {
                                            int_42 = 150 - Game.overheadTextsCyclesRemaining[int_34];
                                            int int_43 = 0;
                                            if (int_42 < 25) {
                                                int_43 = int_42 - 25;
                                            } else if (int_42 > 125) {
                                                int_43 = int_42 - 125;
                                            }

                                            Rasterizer2D.setInnerDrawRegion(int_15,
                                                    (int_17 + Game.screenY)
                                                            - ClanMemberManager.fontBold12.verticalSpace - 1,
                                                    int_19 + int_15, int_17 + Game.screenY + 5);
                                            ClanMemberManager.fontBold12.drawTextCentered(string_1,
                                                    int_15 + Game.screenX, int_43 + int_17 + Game.screenY, int_41,
                                                    0);
                                            Rasterizer2D.setDrawRegion(int_15, int_17, int_15 + int_19,
                                                    int_17 + int_20);
                                        }
                                    } else {
                                        ClanMemberManager.fontBold12.drawTextCentered(string_1, int_15 + Game.screenX,
                                                int_17 + Game.screenY, 16776960, 0);
                                    }
                                }

                                if (Game.hintArrowTargetType == 2) {
                                    class238.worldToScreen(
                                            ((Game.hintArrowX - PendingSpawn.baseX) << 7) + Game.hintArrowOffsetX,
                                            ((Game.hintArrowY - Game.baseY) << 7) + Game.hintArrowOffsetY,
                                            Game.hintArrowOffsetZ * 2);
                                    if ((Game.screenX > -1) && ((Game.gameCycle % 20) < 10)) {
                                        MilliTimer.headIconsHint[0].drawAt((int_15 + Game.screenX) - 12,
                                                (int_17 + Game.screenY) - 28);
                                    }
                                }

                                ((TextureProvider) Graphics3D.textureLoader).checkTextures(Game.field700);
                                class16.method158(int_15, int_17, int_19, int_20);
                                CacheFile.cameraX = int_23;
                                SceneTilePaint.cameraZ = int_22;
                                Coordinates.cameraY = int_24;
                                class7.cameraPitch = int_25;
                                DynamicObject.cameraYaw = int_26;
                                if (Game.field625 && (class185.method3786(true, false) == 0)) {
                                    Game.field625 = false;
                                }

                                if (Game.field625) {
                                    Rasterizer2D.Rasterizer2D_fillRectangle(int_15, int_17, int_19, int_20, 0);
                                    class83.method1933("Loading - please wait.", false);
                                }

                                Game.field697[widget_0.boundsIndex] = true;
                                Rasterizer2D.setDrawRegion(int_1, int_2, int_3, int_4);
                                continue;
                            }

                            if (widget_0.contentType == 1338) {
                                class173.method3473(widget_0, int_10, int_11, int_9);
                                Rasterizer2D.setDrawRegion(int_1, int_2, int_3, int_4);
                                continue;
                            }

                            if (widget_0.contentType == 1339) {
                                final class224 class224_0 = widget_0.method4517(false);
                                if (class224_0 != null) {
                                    if (Game.field810 < 3) {
                                        WallObject.compass.method5845(int_10, int_11, class224_0.field2553,
                                                class224_0.field2549, 25, 25, Game.mapAngle, 256,
                                                class224_0.field2551, class224_0.field2550);
                                    } else {
                                        Rasterizer2D.method5742(int_10, int_11, 0, class224_0.field2551,
                                                class224_0.field2550);
                                    }
                                }

                                Rasterizer2D.setDrawRegion(int_1, int_2, int_3, int_4);
                                continue;
                            }

                            if (widget_0.contentType == 1400) {
                                ItemContainer.renderOverview.extractWorldmap(int_10, int_11, widget_0.width,
                                        widget_0.height, Game.gameCycle);
                            }

                            if (widget_0.contentType == 1401) {
                                ItemContainer.renderOverview.extractData(int_10, int_11, widget_0.width,
                                        widget_0.height);
                            }
                        }

                        boolean bool_0;
                        if (widget_0.type == 0) {
                            if (!widget_0.hasScript) {
                                bool_0 = widget_0.isHidden;
                                if (bool_0 && (widget_0 != class143.field1897)) {
                                    continue;
                                }
                            }

                            if (!widget_0.hasScript) {
                                if (widget_0.scrollY > (widget_0.scrollHeight - widget_0.height)) {
                                    widget_0.scrollY = widget_0.scrollHeight - widget_0.height;
                                }

                                if (widget_0.scrollY < 0) {
                                    widget_0.scrollY = 0;
                                }
                            }

                            gameDraw(widgets_0, widget_0.interfaceHash, int_13, int_14, int_16, int_18, int_10 - widget_0.scrollX,
                                    int_11 - widget_0.scrollY, int_9);
                            if (widget_0.children != null) {
                                gameDraw(widget_0.children, widget_0.interfaceHash, int_13, int_14, int_16, int_18,
                                        int_10 - widget_0.scrollX, int_11 - widget_0.scrollY, int_9);
                            }

                            final WidgetNode widgetnode_0 = (WidgetNode) Game.componentTable.get(widget_0.interfaceHash);
                            if (widgetnode_0 != null) {
                                class35.method630(widgetnode_0.id, int_13, int_14, int_16, int_18, int_10, int_11,
                                        int_9);
                            }

                            Rasterizer2D.setDrawRegion(int_1, int_2, int_3, int_4);
                            Graphics3D.Rasterizer3D_method1();
                        }

                        if (Game.isResized || Game.field723[int_9] || (Game.gameDrawingMode > 1)) {
                            if ((widget_0.type == 0) && !widget_0.hasScript
                                    && (widget_0.scrollHeight > widget_0.height)) {
                                int_15 = int_10 + widget_0.width;
                                int_17 = widget_0.scrollY;
                                int_19 = widget_0.height;
                                int_20 = widget_0.scrollHeight;
                                BuildType.scrollbarSprites[0].method5829(int_15, int_11);
                                BuildType.scrollbarSprites[1].method5829(int_15, (int_19 + int_11) - 16);
                                Rasterizer2D.Rasterizer2D_fillRectangle(int_15, int_11 + 16, 16, int_19 - 32,
                                        Game.field643);
                                int_21 = (int_19 * (int_19 - 32)) / int_20;
                                if (int_21 < 8) {
                                    int_21 = 8;
                                }

                                int_23 = (int_17 * (int_19 - 32 - int_21)) / (int_20 - int_19);
                                Rasterizer2D.Rasterizer2D_fillRectangle(int_15, int_11 + int_23 + 16, 16, int_21,
                                        Game.field584);
                                Rasterizer2D.method5738(int_15, int_23 + int_11 + 16, int_21, Game.field646);
                                Rasterizer2D.method5738(int_15 + 1, int_11 + int_23 + 16, int_21, Game.field646);
                                Rasterizer2D.method5736(int_15, int_11 + int_23 + 16, 16, Game.field646);
                                Rasterizer2D.method5736(int_15, int_23 + int_11 + 17, 16, Game.field646);
                                Rasterizer2D.method5738(int_15 + 15, int_11 + int_23 + 16, int_21, Game.field836);
                                Rasterizer2D.method5738(int_15 + 14, int_23 + int_11 + 17, int_21 - 1, Game.field836);
                                Rasterizer2D.method5736(int_15, int_11 + int_23 + int_21 + 15, 16, Game.field836);
                                Rasterizer2D.method5736(int_15 + 1, int_23 + int_11 + int_21 + 14, 15, Game.field836);
                            }

                            if (widget_0.type != 1) {
                                if (widget_0.type == 2) {
                                    int_15 = 0;

                                    for (int_17 = 0; int_17 < widget_0.originalHeight; int_17++) {
                                        for (int_19 = 0; int_19 < widget_0.originalWidth; int_19++) {
                                            int_20 = int_10 + (int_19 * (widget_0.paddingX + 32));
                                            int_21 = (int_17 * (widget_0.paddingY + 32)) + int_11;
                                            if (int_15 < 20) {
                                                int_20 += widget_0.xSprites[int_15];
                                                int_21 += widget_0.field2738[int_15];
                                            }

                                            if (widget_0.itemIds[int_15] <= 0) {
                                                if ((widget_0.field2676 != null) && (int_15 < 20)) {
                                                    final SpritePixels spritepixels_2 = widget_0.method4509(int_15);
                                                    if (spritepixels_2 != null) {
                                                        spritepixels_2.drawAt(int_20, int_21);
                                                    } else if (Widget.field2603) {
                                                        Player.method1114(widget_0);
                                                    }
                                                }
                                            } else {
                                                int_24 = widget_0.itemIds[int_15] - 1;
                                                if ((((int_20 + 32) > int_1) && (int_20 < int_3)
                                                        && ((int_21 + 32) > int_2) && (int_21 < int_4))
                                                        || ((widget_0 == class276.field3559)
                                                        && (int_15 == Game.field688))) {
                                                    SpritePixels spritepixels_0;
                                                    if ((Game.itemSelectionState == 1)
                                                            && (int_15 == class13.selectedItemIndex)
                                                            && (widget_0.interfaceHash == class187.field2372)) {
                                                        spritepixels_0 = class21.createSprite(int_24,
                                                                widget_0.itemQuantities[int_15], 2, 0, 2, false);
                                                    } else {
                                                        spritepixels_0 = class21.createSprite(int_24,
                                                                widget_0.itemQuantities[int_15], 1, 3153952, 2, false);
                                                    }

                                                    if (spritepixels_0 != null) {
                                                        if ((widget_0 == class276.field3559) && (int_15 == Game.field688)) { int_23 = MouseInput.mouseLastX - Game.field678;int_22 = (MouseInput.mouseLastY * 673804999) - Game.field821;
                                                            if ((int_23 < RuinMisc.DRAG) && (int_23 > -RuinMisc.DRAG)) {
                                                                int_23 = 0;
                                                            }

                                                            if ((int_22 < RuinMisc.DRAG) && (int_22 > -RuinMisc.DRAG)) {
                                                                int_22 = 0;
                                                            }

                                                            if (Game.itemPressedDuration < RuinMisc.DRAG) {
                                                                int_23 = 0;
                                                                int_22 = 0;
                                                            }

                                                            spritepixels_0.drawAtOpacity(int_23 + int_20,
                                                                    int_21 + int_22, 128);
                                                            if (int_0 != -1) {
                                                                final Widget widget_1 = widgets_0[int_0 & 0xFFFF];
                                                                if (((int_22 + int_21) < Rasterizer2D.topY)
                                                                        && (widget_1.scrollY > 0)) {
                                                                    int_27 = ((Rasterizer2D.topY - int_21
                                                                            - int_22) * Game.field700) / 3;
                                                                    if (int_27 > (Game.field700 * 10)) {
                                                                        int_27 = Game.field700 * 10;
                                                                    }

                                                                    if (int_27 > widget_1.scrollY) {
                                                                        int_27 = widget_1.scrollY;
                                                                    }

                                                                    widget_1.scrollY -= int_27;
                                                                    Game.field821 += int_27;
                                                                    Player.method1114(widget_1);
                                                                }

                                                                if (((int_22 + int_21
                                                                        + 32) > Rasterizer2D.bottomY)
                                                                        && (widget_1.scrollY < (widget_1.scrollHeight
                                                                        - widget_1.height))) {
                                                                    int_27 = (((int_22 + int_21 + 32)
                                                                            - Rasterizer2D.bottomY)
                                                                            * Game.field700) / 3;
                                                                    if (int_27 > (Game.field700 * 10)) {
                                                                        int_27 = Game.field700 * 10;
                                                                    }

                                                                    if (int_27 > (widget_1.scrollHeight
                                                                            - widget_1.height - widget_1.scrollY)) {
                                                                        int_27 = widget_1.scrollHeight - widget_1.height
                                                                                - widget_1.scrollY;
                                                                    }

                                                                    widget_1.scrollY += int_27;
                                                                    Game.field821 -= int_27;
                                                                    Player.method1114(widget_1);
                                                                }
                                                            }
                                                        } else if ((widget_0 == class240.field3096)
                                                                && (int_15 == Game.pressedItemIndex)) {
                                                            spritepixels_0.drawAtOpacity(int_20, int_21, 128);
                                                        } else {
                                                            spritepixels_0.drawAt(int_20, int_21);
                                                        }
                                                    } else {
                                                        Player.method1114(widget_0);
                                                    }
                                                }
                                            }

                                            ++int_15;
                                        }
                                    }
                                } else if (widget_0.type == 3) {
                                    if (Occluder.method3097(widget_0)) {
                                        int_15 = widget_0.field2631;
                                        if ((widget_0 == class143.field1897) && (widget_0.field2633 != 0)) {
                                            int_15 = widget_0.field2633;
                                        }
                                    } else {
                                        int_15 = widget_0.textColor;
                                        if ((widget_0 == class143.field1897) && (widget_0.field2632 != 0)) {
                                            int_15 = widget_0.field2632;
                                        }
                                    }

                                    if (widget_0.filled) {
                                        switch (widget_0.field2701.field3776) {
                                            case 1:
                                                Rasterizer2D.method5728(int_10, int_11, widget_0.width, widget_0.height,
                                                        widget_0.textColor, widget_0.field2631,
                                                        256 - (widget_0.opacity & 0xFF),
                                                        256 - (widget_0.field2608 & 0xFF));
                                                break;
                                            case 2:
                                                Rasterizer2D.method5729(int_10, int_11, widget_0.width, widget_0.height,
                                                        widget_0.textColor, widget_0.field2631,
                                                        256 - (widget_0.opacity & 0xFF),
                                                        256 - (widget_0.field2608 & 0xFF));
                                                break;
                                            case 3:
                                                Rasterizer2D.method5739(int_10, int_11, widget_0.width, widget_0.height,
                                                        widget_0.textColor, widget_0.field2631,
                                                        256 - (widget_0.opacity & 0xFF),
                                                        256 - (widget_0.field2608 & 0xFF));
                                                break;
                                            case 4:
                                                Rasterizer2D.method5726(int_10, int_11, widget_0.width, widget_0.height,
                                                        widget_0.textColor, widget_0.field2631,
                                                        256 - (widget_0.opacity & 0xFF),
                                                        256 - (widget_0.field2608 & 0xFF));
                                                break;
                                            default:
                                                if (int_12 == 0) {
                                                    Rasterizer2D.Rasterizer2D_fillRectangle(int_10, int_11,
                                                            widget_0.width, widget_0.height, int_15);
                                                } else {
                                                    Rasterizer2D.fillRectangle(int_10, int_11, widget_0.width,
                                                            widget_0.height, int_15, 256 - (int_12 & 0xFF));
                                                }
                                        }
                                    } else if (int_12 == 0) {
                                        Rasterizer2D.drawRectangle(int_10, int_11, widget_0.width, widget_0.height,
                                                int_15);
                                    } else {
                                        Rasterizer2D.Rasterizer2D_drawRectangleAlpha(int_10, int_11, widget_0.width,
                                                widget_0.height, int_15, 256 - (int_12 & 0xFF));
                                    }
                                } else {
                                    Font font_1;
                                    if (widget_0.type == 4) {
                                        font_1 = widget_0.getFont();
                                        if (font_1 == null) {
                                            if (Widget.field2603) {
                                                Player.method1114(widget_0);
                                            }
                                        } else {
                                            String string_4 = widget_0.text;
                                            if (Occluder.method3097(widget_0)) {
                                                int_17 = widget_0.field2631;
                                                if ((widget_0 == class143.field1897) && (widget_0.field2633 != 0)) {
                                                    int_17 = widget_0.field2633;
                                                }

                                                if (widget_0.string1.length() > 0) {
                                                    string_4 = widget_0.string1;
                                                }
                                            } else {
                                                int_17 = widget_0.textColor;
                                                if ((widget_0 == class143.field1897) && (widget_0.field2632 != 0)) {
                                                    int_17 = widget_0.field2632;
                                                }
                                            }

                                            if (widget_0.hasScript && (widget_0.itemId != -1)) {
                                                final ItemComposition itemcomposition_1 = TextureProvider
                                                        .getItemDefinition(widget_0.itemId);
                                                string_4 = itemcomposition_1.name;
                                                if (string_4 == null) {
                                                    string_4 = "null";
                                                }

                                                if (((itemcomposition_1.isStackable == 1)
                                                        || (widget_0.itemQuantity != 1))
                                                        && (widget_0.itemQuantity != -1)) {
                                                    string_4 = class6.getColTags(16748608) + string_4 + "</col>" + " "
                                                            + 'x' + class35.method623(widget_0.itemQuantity);
                                                }
                                            }

                                            if (widget_0 == Game.field744) {
                                                string_4 = "Please wait...";
                                                int_17 = widget_0.textColor;
                                            }

                                            if (!widget_0.hasScript) {
                                                string_4 = GrandExchangeEvents.method11(string_4, widget_0);
                                            }

                                            font_1.method5526(string_4, int_10, int_11, widget_0.width, widget_0.height,
                                                    int_17, widget_0.textShadowed ? 0 : -1, widget_0.fontHorizontalAlignment,
                                                    widget_0.fontVerticalAlignment, widget_0.lineHeight);
                                        }
                                    } else if (widget_0.type == 5) {
                                        SpritePixels spritepixels_1;
                                        if (!widget_0.hasScript) {
                                            spritepixels_1 = widget_0.method4508(Occluder.method3097(widget_0));
                                            if (spritepixels_1 != null) {
                                                spritepixels_1.drawAt(int_10, int_11);
                                            } else if (Widget.field2603) {
                                                Player.method1114(widget_0);
                                            }
                                        } else {
                                            if (widget_0.itemId != -1) {
                                                spritepixels_1 = class21.createSprite(widget_0.itemId,
                                                        widget_0.itemQuantity, widget_0.borderThickness,
                                                        widget_0.shadow, widget_0.itemAmountSetting, false);
                                            } else {
                                                spritepixels_1 = widget_0.method4508(false);
                                            }

                                            if (spritepixels_1 == null) {
                                                if (Widget.field2603) {
                                                    Player.method1114(widget_0);
                                                }
                                            } else {
                                                int_17 = spritepixels_1.maxWidth;
                                                int_19 = spritepixels_1.maxHeight;
                                                if (!widget_0.spriteTiling) {
                                                    int_20 = (widget_0.width * 4096) / int_17;
                                                    if (widget_0.textureId != 0) {
                                                        spritepixels_1.method5870((widget_0.width / 2) + int_10,
                                                                (widget_0.height / 2) + int_11, widget_0.textureId,
                                                                int_20);
                                                    } else if (int_12 != 0) {
                                                        spritepixels_1.method5856(int_10, int_11, widget_0.width,
                                                                widget_0.height, 256 - (int_12 & 0xFF));
                                                    } else if ((int_17 == widget_0.width) && (int_19 == widget_0.height)) {
                                                        spritepixels_1.drawAt(int_10, int_11);
                                                    } else {
                                                        spritepixels_1.method5853(int_10, int_11, widget_0.width,
                                                                widget_0.height);
                                                    }
                                                } else {
                                                    Rasterizer2D.setInnerDrawRegion(int_10, int_11,
                                                            int_10 + widget_0.width, int_11 + widget_0.height);
                                                    int_20 = ((int_17 - 1) + widget_0.width) / int_17;
                                                    int_21 = ((int_19 - 1) + widget_0.height) / int_19;

                                                    for (int_23 = 0; int_23 < int_20; int_23++) {
                                                        for (int_22 = 0; int_22 < int_21; int_22++) {
                                                            if (widget_0.textureId != 0) {
                                                                spritepixels_1.method5870(
                                                                        (int_17 / 2) + int_10 + (int_23 * int_17),
                                                                        (int_19 / 2) + int_11 + (int_19 * int_22),
                                                                        widget_0.textureId, 4096);
                                                            } else if (int_12 != 0) {
                                                                spritepixels_1.drawAtOpacity(int_10 + (int_23 * int_17),
                                                                        int_11 + (int_19 * int_22),
                                                                        256 - (int_12 & 0xFF));
                                                            } else {
                                                                spritepixels_1.drawAt(int_10 + (int_17 * int_23),
                                                                        int_11 + (int_19 * int_22));
                                                            }
                                                        }
                                                    }

                                                    Rasterizer2D.setDrawRegion(int_1, int_2, int_3, int_4);
                                                }
                                            }
                                        }
                                    } else {
                                        ItemComposition itemcomposition_0;
                                        if (widget_0.type == 6) {
                                            bool_0 = Occluder.method3097(widget_0);
                                            if (bool_0) {
                                                int_17 = widget_0.field2653;
                                            } else {
                                                int_17 = widget_0.field2595;
                                            }

                                            Model model_0 = null;
                                            int_20 = 0;
                                            if (widget_0.itemId != -1) {
                                                itemcomposition_0 = TextureProvider.getItemDefinition(widget_0.itemId);
                                                if (itemcomposition_0 != null) {
                                                    itemcomposition_0 = itemcomposition_0
                                                            .method5094(widget_0.itemQuantity);
                                                    model_0 = itemcomposition_0.getModel(1);
                                                    if (model_0 != null) {
                                                        model_0.calculateBoundsCylinder();
                                                        int_20 = model_0.modelHeight / 2;
                                                    } else {
                                                        Player.method1114(widget_0);
                                                    }
                                                }
                                            } else if (widget_0.modelType == 5) {
                                                if (widget_0.modelId == 0) {
                                                    model_0 = Game.customizedAppearance.getModel(null, -1,
                                                            null, -1);
                                                } else {
                                                    model_0 = class138.localPlayer.getModel();
                                                }
                                            } else if (int_17 == -1) {
                                                model_0 = widget_0.getModel(null, -1, bool_0,
                                                        class138.localPlayer.composition);
                                                if ((model_0 == null) && Widget.field2603) {
                                                    Player.method1114(widget_0);
                                                }
                                            } else {
                                                final Sequence sequence_0 = TotalQuantityComparator
                                                        .getAnimation(int_17);
                                                model_0 = widget_0.getModel(sequence_0, widget_0.field2728, bool_0,
                                                        class138.localPlayer.composition);
                                                if ((model_0 == null) && Widget.field2603) {
                                                    Player.method1114(widget_0);
                                                }
                                            }

                                            Graphics3D.method2827((widget_0.width / 2) + int_10,
                                                    (widget_0.height / 2) + int_11);
                                            int_21 = (Graphics3D.SINE[widget_0.rotationX] * widget_0.modelZoom) >> 16;
                                            int_23 = (Graphics3D.COSINE[widget_0.rotationX] * widget_0.modelZoom) >> 16;
                                            if (model_0 != null) {
                                                if (!widget_0.hasScript) {
                                                    model_0.method2682(0, widget_0.rotationZ, 0, widget_0.rotationX, 0,
                                                            int_21, int_23);
                                                } else {
                                                    model_0.calculateBoundsCylinder();
                                                    if (widget_0.field2662) {
                                                        model_0.method2710(0, widget_0.rotationZ, widget_0.rotationY,
                                                                widget_0.rotationX, widget_0.offsetX2d,
                                                                int_21 + int_20 + widget_0.offsetY2d,
                                                                int_23 + widget_0.offsetY2d, widget_0.modelZoom);
                                                    } else {
                                                        model_0.method2682(0, widget_0.rotationZ, widget_0.rotationY,
                                                                widget_0.rotationX, widget_0.offsetX2d,
                                                                int_20 + int_21 + widget_0.offsetY2d,
                                                                int_23 + widget_0.offsetY2d);
                                                    }
                                                }
                                            }

                                            Graphics3D.Rasterizer3D_method3();
                                        } else {
                                            if (widget_0.type == 7) {
                                                font_1 = widget_0.getFont();
                                                if (font_1 == null) {
                                                    if (Widget.field2603) {
                                                        Player.method1114(widget_0);
                                                    }
                                                    continue;
                                                }

                                                int_17 = 0;

                                                for (int_19 = 0; int_19 < widget_0.originalHeight; int_19++) {
                                                    for (int_20 = 0; int_20 < widget_0.originalWidth; int_20++) {
                                                        if (widget_0.itemIds[int_17] > 0) {
                                                            itemcomposition_0 = TextureProvider.getItemDefinition(widget_0.itemIds[int_17] - 1); //nick
                                                            String string_0;
                                                            if ((itemcomposition_0.isStackable != 1) && (widget_0.itemQuantities[int_17] == 1)) {
                                                                string_0 = class6.getColTags(16748608)
                                                                        + itemcomposition_0.name + "</col>";
                                                            } else {
                                                                string_0 = class6.getColTags(16748608)
                                                                        + itemcomposition_0.name + "</col>" + " " + 'x'
                                                                        + class35.method623(
                                                                        widget_0.itemQuantities[int_17]);
                                                            }

                                                            int_22 = (int_20 * (widget_0.paddingX + 115)) + int_10;
                                                            int_24 = int_11 + ((widget_0.paddingY + 12) * int_19);
                                                            if (widget_0.fontHorizontalAlignment == 0) {
                                                                font_1.method5522(string_0, int_22, int_24,
                                                                        widget_0.textColor,
                                                                        widget_0.textShadowed ? 0 : -1);
                                                            } else if (widget_0.fontHorizontalAlignment == 1) {
                                                                font_1.drawTextCentered(string_0,
                                                                        (widget_0.width / 2) + int_22, int_24,
                                                                        widget_0.textColor,
                                                                        widget_0.textShadowed ? 0 : -1);
                                                            } else {
                                                                font_1.method5524(string_0,
                                                                        (int_22 + widget_0.width) - 1, int_24,
                                                                        widget_0.textColor,
                                                                        widget_0.textShadowed ? 0 : -1);
                                                            }
                                                        }

                                                        ++int_17;
                                                    }
                                                }
                                            }

                                            if ((widget_0.type == 8) && (widget_0 == class141.field1888)
                                                    && (Game.field623 == Game.field732)) {
                                                int_15 = 0;
                                                int_17 = 0;
                                                final Font font_0 = Actor.font_p12full;
                                                String string_2 = widget_0.text;

                                                String string_3;
                                                for (string_2 = GrandExchangeEvents.method11(string_2,
                                                        widget_0); string_2.length() > 0; int_17 = int_17
                                                        + font_0.verticalSpace + 1) {
                                                    int_23 = string_2.indexOf("<br>");
                                                    if (int_23 != -1) {
                                                        string_3 = string_2.substring(0, int_23);
                                                        string_2 = string_2.substring(int_23 + 4);
                                                    } else {
                                                        string_3 = string_2;
                                                        string_2 = "";
                                                    }

                                                    int_22 = font_0.getTextWidth(string_3);
                                                    if (int_22 > int_15) {
                                                        int_15 = int_22;
                                                    }
                                                }

                                                int_15 += 6;
                                                int_17 += 7;
                                                int_23 = (int_10 + widget_0.width) - 5 - int_15;
                                                int_22 = int_11 + widget_0.height + 5;
                                                if (int_23 < (int_10 + 5)) {
                                                    int_23 = int_10 + 5;
                                                }

                                                if ((int_15 + int_23) > int_3) {
                                                    int_23 = int_3 - int_15;
                                                }

                                                if ((int_17 + int_22) > int_4) {
                                                    int_22 = int_4 - int_17;
                                                }

                                                Rasterizer2D.Rasterizer2D_fillRectangle(int_23, int_22, int_15, int_17,
                                                        16777120);
                                                Rasterizer2D.drawRectangle(int_23, int_22, int_15, int_17, 0);
                                                string_2 = widget_0.text;
                                                int_24 = int_22 + font_0.verticalSpace + 2;

                                                for (string_2 = GrandExchangeEvents.method11(string_2,
                                                        widget_0); string_2.length() > 0; int_24 = int_24
                                                        + font_0.verticalSpace + 1) {
                                                    int_25 = string_2.indexOf("<br>");
                                                    if (int_25 != -1) {
                                                        string_3 = string_2.substring(0, int_25);
                                                        string_2 = string_2.substring(int_25 + 4);
                                                    } else {
                                                        string_3 = string_2;
                                                        string_2 = "";
                                                    }

                                                    font_0.method5522(string_3, int_23 + 3, int_24, 0, -1);
                                                }
                                            }

                                            if (widget_0.type == 9) {
                                                if (widget_0.field2639) {
                                                    int_15 = int_10;
                                                    int_17 = int_11 + widget_0.height;
                                                    int_19 = int_10 + widget_0.width;
                                                    int_20 = int_11;
                                                } else {
                                                    int_15 = int_10;
                                                    int_17 = int_11;
                                                    int_19 = int_10 + widget_0.width;
                                                    int_20 = int_11 + widget_0.height;
                                                }

                                                if (widget_0.lineWidth == 1) {
                                                    Rasterizer2D.drawLine(int_15, int_17, int_19, int_20,
                                                            widget_0.textColor);
                                                } else {
                                                    int_22 = widget_0.textColor;
                                                    int_24 = widget_0.lineWidth;
                                                    int_25 = int_19 - int_15;
                                                    int_26 = int_20 - int_17;
                                                    int_27 = int_25 >= 0 ? int_25 : -int_25;
                                                    int_28 = int_26 >= 0 ? int_26 : -int_26;
                                                    int_29 = int_27;
                                                    if (int_27 < int_28) {
                                                        int_29 = int_28;
                                                    }

                                                    if (int_29 != 0) {
                                                        int int_30 = (int_25 << 16) / int_29;
                                                        int_31 = (int_26 << 16) / int_29;
                                                        if (int_31 <= int_30) {
                                                            int_30 = -int_30;
                                                        } else {
                                                            int_31 = -int_31;
                                                        }

                                                        int_32 = (int_24 * int_31) >> 17;
                                                        int_33 = ((int_31 * int_24) + 1) >> 17;
                                                        final int int_44 = (int_24 * int_30) >> 17;
                                                        int_34 = ((int_30 * int_24) + 1) >> 17;
                                                        int_21 = int_15 - Rasterizer2D.topX;
                                                        int_23 = int_17 - Rasterizer2D.topY;
                                                        int_35 = int_21 + int_32;
                                                        int_36 = int_21 - int_33;
                                                        int_37 = (int_21 + int_25) - int_33;
                                                        int_38 = int_32 + int_25 + int_21;
                                                        final int int_39 = int_23 + int_44;
                                                        int_40 = int_23 - int_34;
                                                        int_41 = (int_23 + int_26) - int_34;
                                                        int_42 = int_23 + int_26 + int_44;
                                                        Graphics3D.setRasterClippingEnabled(int_35, int_36, int_37);
                                                        Graphics3D.rasterFlat(int_39, int_40, int_41, int_35, int_36,
                                                                int_37, int_22);
                                                        Graphics3D.setRasterClippingEnabled(int_35, int_37, int_38);
                                                        Graphics3D.rasterFlat(int_39, int_41, int_42, int_35, int_37,
                                                                int_38, int_22);
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
        }

    }

}
