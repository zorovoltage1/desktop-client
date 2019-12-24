public final class class21 {

    public static class251 field175;
    static IndexData indexModels;
    final int[] field178;

    class21() {
        field178 = new int[4096];
    }

    void method265(final class32 class32_0) {
        for (int int_0 = 0; int_0 < 64; int_0++) {
            for (int int_1 = 0; int_1 < 64; int_1++) {
                field178[(int_0 * 64) + int_1] = class32_0.method547(int_0, int_1) | 0xFF000000;
            }
        }

    }

    int method272(final int int_0, final int int_1) {
        return field178[(int_0 * 64) + int_1];
    }

    static IndexedSprite[] method278(final IndexDataBase indexdatabase_0, final int int_0, final int int_1) {
        return !class306.method5660(indexdatabase_0, int_0, int_1) ? null : class49.method950();
    }

    public static void method277(final IndexDataBase indexdatabase_0) {
        Overlay.overlay_ref = indexdatabase_0;
    }

    public static VarCInt method275(final int int_0) {
        VarCInt varcint_0 = (VarCInt) VarCInt.field3257.get(int_0);
        if (varcint_0 != null) {
            return varcint_0;
        } else {
            final byte[] bytes_0 = VarCInt.field3258.getConfigData(19, int_0);
            varcint_0 = new VarCInt();
            if (bytes_0 != null) {
                varcint_0.method4848(new Buffer(bytes_0));
            }

            VarCInt.field3257.put(varcint_0, int_0);
            return varcint_0;
        }
    }

    static boolean method273(final int int_0, final int int_1, final int int_2, final class166 class166_0,
                             final CollisionData collisiondata_0) {
        int int_3 = int_0;
        int int_4 = int_1;
        final byte byte_0 = 64;
        final byte byte_1 = 64;
        final int int_5 = int_0 - byte_0;
        final int int_6 = int_1 - byte_1;
        class165.field2035[byte_0][byte_1] = 99;
        class165.field2041[byte_0][byte_1] = 0;
        final byte byte_2 = 0;
        int int_7 = 0;
        class165.field2039[byte_2] = int_0;
        int int_14 = byte_2 + 1;
        class165.field2038[byte_2] = int_1;
        final int[][] ints_0 = collisiondata_0.flags;

        while (true) {
            label313:
            while (true) {
                int int_8;
                int int_9;
                int int_10;
                int int_11;
                int int_12;
                int int_13;
                do {
                    do {
                        do {
                            label290:
                            do {
                                if (int_7 == int_14) {
                                    WorldMapDecoration.field152 = int_3;
                                    class165.field2037 = int_4;
                                    return false;
                                }

                                int_3 = class165.field2039[int_7];
                                int_4 = class165.field2038[int_7];
                                int_7 = (int_7 + 1) & 0xFFF;
                                int_12 = int_3 - int_5;
                                int_13 = int_4 - int_6;
                                int_8 = int_3 - collisiondata_0.x;
                                int_9 = int_4 - collisiondata_0.y;
                                if (class166_0.vmethod3440(int_2, int_3, int_4, collisiondata_0)) {
                                    WorldMapDecoration.field152 = int_3;
                                    class165.field2037 = int_4;
                                    return true;
                                }

                                int_10 = class165.field2041[int_12][int_13] + 1;
                                if ((int_12 > 0) && (class165.field2035[int_12 - 1][int_13] == 0)
                                        && ((ints_0[int_8 - 1][int_9] & 0x124010E) == 0)
                                        && ((ints_0[int_8 - 1][(int_9 + int_2) - 1] & 0x1240138) == 0)) {
                                    int_11 = 1;

                                    while (true) {
                                        if (int_11 >= (int_2 - 1)) {
                                            class165.field2039[int_14] = int_3 - 1;
                                            class165.field2038[int_14] = int_4;
                                            int_14 = (int_14 + 1) & 0xFFF;
                                            class165.field2035[int_12 - 1][int_13] = 2;
                                            class165.field2041[int_12 - 1][int_13] = int_10;
                                            break;
                                        }

                                        if ((ints_0[int_8 - 1][int_11 + int_9] & 0x124013E) != 0) {
                                            break;
                                        }

                                        ++int_11;
                                    }
                                }

                                if ((int_12 < (128 - int_2)) && (class165.field2035[int_12 + 1][int_13] == 0)
                                        && ((ints_0[int_8 + int_2][int_9] & 0x1240183) == 0)
                                        && ((ints_0[int_8 + int_2][(int_9 + int_2) - 1] & 0x12401E0) == 0)) {
                                    int_11 = 1;

                                    while (true) {
                                        if (int_11 >= (int_2 - 1)) {
                                            class165.field2039[int_14] = int_3 + 1;
                                            class165.field2038[int_14] = int_4;
                                            int_14 = (int_14 + 1) & 0xFFF;
                                            class165.field2035[int_12 + 1][int_13] = 8;
                                            class165.field2041[int_12 + 1][int_13] = int_10;
                                            break;
                                        }

                                        if ((ints_0[int_8 + int_2][int_9 + int_11] & 0x12401E3) != 0) {
                                            break;
                                        }

                                        ++int_11;
                                    }
                                }

                                if ((int_13 > 0) && (class165.field2035[int_12][int_13 - 1] == 0)
                                        && ((ints_0[int_8][int_9 - 1] & 0x124010E) == 0)
                                        && ((ints_0[(int_8 + int_2) - 1][int_9 - 1] & 0x1240183) == 0)) {
                                    int_11 = 1;

                                    while (true) {
                                        if (int_11 >= (int_2 - 1)) {
                                            class165.field2039[int_14] = int_3;
                                            class165.field2038[int_14] = int_4 - 1;
                                            int_14 = (int_14 + 1) & 0xFFF;
                                            class165.field2035[int_12][int_13 - 1] = 1;
                                            class165.field2041[int_12][int_13 - 1] = int_10;
                                            break;
                                        }

                                        if ((ints_0[int_8 + int_11][int_9 - 1] & 0x124018F) != 0) {
                                            break;
                                        }

                                        ++int_11;
                                    }
                                }

                                if ((int_13 < (128 - int_2)) && (class165.field2035[int_12][int_13 + 1] == 0)
                                        && ((ints_0[int_8][int_9 + int_2] & 0x1240138) == 0)
                                        && ((ints_0[(int_8 + int_2) - 1][int_9 + int_2] & 0x12401E0) == 0)) {
                                    int_11 = 1;

                                    while (true) {
                                        if (int_11 >= (int_2 - 1)) {
                                            class165.field2039[int_14] = int_3;
                                            class165.field2038[int_14] = int_4 + 1;
                                            int_14 = (int_14 + 1) & 0xFFF;
                                            class165.field2035[int_12][int_13 + 1] = 4;
                                            class165.field2041[int_12][int_13 + 1] = int_10;
                                            break;
                                        }

                                        if ((ints_0[int_11 + int_8][int_9 + int_2] & 0x12401F8) != 0) {
                                            break;
                                        }

                                        ++int_11;
                                    }
                                }

                                if ((int_12 > 0) && (int_13 > 0) && (class165.field2035[int_12 - 1][int_13 - 1] == 0)
                                        && ((ints_0[int_8 - 1][int_9 - 1] & 0x124010E) == 0)) {
                                    int_11 = 1;

                                    while (true) {
                                        if (int_11 >= int_2) {
                                            class165.field2039[int_14] = int_3 - 1;
                                            class165.field2038[int_14] = int_4 - 1;
                                            int_14 = (int_14 + 1) & 0xFFF;
                                            class165.field2035[int_12 - 1][int_13 - 1] = 3;
                                            class165.field2041[int_12 - 1][int_13 - 1] = int_10;
                                            break;
                                        }

                                        if (((ints_0[int_8 - 1][int_11 + (int_9 - 1)] & 0x124013E) != 0)
                                                || ((ints_0[int_11 + (int_8 - 1)][int_9 - 1] & 0x124018F) != 0)) {
                                            break;
                                        }

                                        ++int_11;
                                    }
                                }

                                if ((int_12 < (128 - int_2)) && (int_13 > 0)
                                        && (class165.field2035[int_12 + 1][int_13 - 1] == 0)
                                        && ((ints_0[int_8 + int_2][int_9 - 1] & 0x1240183) == 0)) {
                                    int_11 = 1;

                                    while (true) {
                                        if (int_11 >= int_2) {
                                            class165.field2039[int_14] = int_3 + 1;
                                            class165.field2038[int_14] = int_4 - 1;
                                            int_14 = (int_14 + 1) & 0xFFF;
                                            class165.field2035[int_12 + 1][int_13 - 1] = 9;
                                            class165.field2041[int_12 + 1][int_13 - 1] = int_10;
                                            break;
                                        }

                                        if (((ints_0[int_8 + int_2][int_11 + (int_9 - 1)] & 0x12401E3) != 0)
                                                || ((ints_0[int_8 + int_11][int_9 - 1] & 0x124018F) != 0)) {
                                            break;
                                        }

                                        ++int_11;
                                    }
                                }

                                if ((int_12 > 0) && (int_13 < (128 - int_2))
                                        && (class165.field2035[int_12 - 1][int_13 + 1] == 0)
                                        && ((ints_0[int_8 - 1][int_9 + int_2] & 0x1240138) == 0)) {
                                    for (int_11 = 1; int_11 < int_2; int_11++) {
                                        if (((ints_0[int_8 - 1][int_11 + int_9] & 0x124013E) != 0)
                                                || ((ints_0[int_11 + (int_8 - 1)][int_9 + int_2] & 0x12401F8) != 0)) {
                                            continue label290;
                                        }
                                    }

                                    class165.field2039[int_14] = int_3 - 1;
                                    class165.field2038[int_14] = int_4 + 1;
                                    int_14 = (int_14 + 1) & 0xFFF;
                                    class165.field2035[int_12 - 1][int_13 + 1] = 6;
                                    class165.field2041[int_12 - 1][int_13 + 1] = int_10;
                                }
                            }
                            while (int_12 >= (128 - int_2));
                        }
                        while (int_13 >= (128 - int_2));
                    }
                    while (class165.field2035[int_12 + 1][int_13 + 1] != 0);
                }
                while ((ints_0[int_8 + int_2][int_9 + int_2] & 0x12401E0) != 0);

                for (int_11 = 1; int_11 < int_2; int_11++) {
                    if (((ints_0[int_11 + int_8][int_9 + int_2] & 0x12401F8) != 0)
                            || ((ints_0[int_8 + int_2][int_9 + int_11] & 0x12401E3) != 0)) {
                        continue label313;
                    }
                }

                class165.field2039[int_14] = int_3 + 1;
                class165.field2038[int_14] = int_4 + 1;
                int_14 = (int_14 + 1) & 0xFFF;
                class165.field2035[int_12 + 1][int_13 + 1] = 12;
                class165.field2041[int_12 + 1][int_13 + 1] = int_10;
            }
        }
    }

    public static SpritePixels[] getSprites(final IndexDataBase indexdatabase_0, final String string_0,
                                            final String string_1) {
        final int int_0 = indexdatabase_0.getFile(string_0);
        final int int_1 = indexdatabase_0.getChild(int_0, string_1);
        SpritePixels[] spritepixelss_0;
        if (!class306.method5660(indexdatabase_0, int_0, int_1)) {
            spritepixelss_0 = null;
        } else {
            final SpritePixels[] spritepixelss_1 = new SpritePixels[class319.indexedSpriteCount];

            for (int int_2 = 0; int_2 < class319.indexedSpriteCount; int_2++) {
                final SpritePixels spritepixels_0 = spritepixelss_1[int_2] = new SpritePixels();
                spritepixels_0.maxWidth = class305.indexedSpriteWidth;
                spritepixels_0.maxHeight = class319.indexedSpriteHeight;
                spritepixels_0.offsetX = class7.indexedSpriteOffsetXs[int_2];
                spritepixels_0.offsetY = class225.indexedSpriteOffsetYs[int_2];
                spritepixels_0.width = class319.indexSpriteWidths[int_2];
                spritepixels_0.height = class319.indexedSpriteHeights[int_2];
                final int int_3 = spritepixels_0.height * spritepixels_0.width;
                final byte[] bytes_0 = class319.spritePixels[int_2];
                spritepixels_0.pixels = new int[int_3];

                for (int int_4 = 0; int_4 < int_3; int_4++) {
                    spritepixels_0.pixels[int_4] = PacketNode.indexedSpritePalette[bytes_0[int_4] & 0xFF];
                }
            }

            class7.indexedSpriteOffsetXs = null;
            class225.indexedSpriteOffsetYs = null;
            class319.indexSpriteWidths = null;
            class319.indexedSpriteHeights = null;
            PacketNode.indexedSpritePalette = null;
            class319.spritePixels = null;
            spritepixelss_0 = spritepixelss_1;
        }

        return spritepixelss_0;
    }

    static int method274(int int_0, final Script script_0, final boolean bool_0) {
        boolean cc = true;
        Widget widget_0;
        if (int_0 >= 2000) {
            int_0 -= 1000;
            widget_0 = Widget.getWidget(class69.intStack[--class69.intStackSize]);
            cc = false;
        } else {
            widget_0 = bool_0 ? class276.field3561 : KitDefinition.field3301;
        }

        int int_1;
        if (int_0 == 1300) {
            int_1 = class69.intStack[--class69.intStackSize] - 1;
            if ((int_1 >= 0) && (int_1 <= 9)) {
                String action = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
                widget_0.setAction(int_1, action);
                InterfaceEdits.optionSet(widget_0, int_1, action);
                return 1;
            } else {
                --WidgetNode.scriptStringStackSize;
                return 1;
            }
        } else if (int_0 == 1301) {
            class69.intStackSize -= 2;
            int_1 = class69.intStack[class69.intStackSize];
            final int int_2 = class69.intStack[class69.intStackSize + 1];
            widget_0.dragParent = class146.getWidgetChild(int_1, int_2);
            return 1;
        } else if (int_0 == 1302) {
            widget_0.dragRenderBehavior = class69.intStack[--class69.intStackSize] == 1;
            return 1;
        } else if (int_0 == 1303) {
            widget_0.dragDeadZone = class69.intStack[--class69.intStackSize];
            return 1;
        } else if (int_0 == 1304) {
            widget_0.dragDeadTime = class69.intStack[--class69.intStackSize];
            return 1;
        } else if (int_0 == 1305) {
            widget_0.opBase = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
            ShopInterface.updateOptions(widget_0);
            return 1;
        } else if (int_0 == 1306) {
            widget_0.targetVerb = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
            return 1;
        } else if (int_0 == 1307) {
            widget_0.actions = null;
            return 1;
        } else if (int_0 == 1350) {
            if (cc) {
                class69.intStackSize -= 10;
            } else {
                class69.intStackSize -= 2;
            }

            class69.intStackSize -= 1;
            return 1;
        } else {
            return 2;
        }
    }

    public static SpritePixels createSprite(final int int_0, final int int_1, final int int_2, final int int_3,
                                            int int_4, final boolean bool_0) {
        if (int_1 == -1) {
            int_4 = 0;
        } else if ((int_4 == 2) && (int_1 != 1)) {
            int_4 = 1;
        }

        final long long_0 = ((long) int_3 << 42) + ((long) int_4 << 40) + ((long) int_2 << 38) + ((long) int_1 << 16)
                + int_0;
        SpritePixels spritepixels_0;
        if (!bool_0) {
            spritepixels_0 = (SpritePixels) ItemComposition.itemSpriteCache.get(long_0);
            if (spritepixels_0 != null) {
                return spritepixels_0;
            }
        }

        ItemComposition itemcomposition_0 = TextureProvider.getItemDefinition(int_0);
        if ((int_1 > 1) && (itemcomposition_0.countObj != null)) {
            int int_5 = -1;

            for (int int_6 = 0; int_6 < 10; int_6++) {
                if ((int_1 >= itemcomposition_0.countCo[int_6]) && (itemcomposition_0.countCo[int_6] != 0)) {
                    int_5 = itemcomposition_0.countObj[int_6];
                }
            }

            if (int_5 != -1) {
                itemcomposition_0 = TextureProvider.getItemDefinition(int_5);
            }
        }

        final Model model_0 = itemcomposition_0.getModel(1);
        if (model_0 == null) {
            return null;
        } else {
            SpritePixels spritepixels_1 = null;
            if (itemcomposition_0.notedTemplate != -1) {
                spritepixels_1 = createSprite(itemcomposition_0.note, 10, 1, 0, 0, true);
                if (spritepixels_1 == null) {
                    return null;
                }
            } else if (itemcomposition_0.notedId != -1) {
                spritepixels_1 = createSprite(itemcomposition_0.unnotedId, int_1, int_2, int_3, 0, false);
                if (spritepixels_1 == null) {
                    return null;
                }
            } else if (itemcomposition_0.placeholderTemplateId != -1) {
                spritepixels_1 = createSprite(itemcomposition_0.placeholderId, int_1, 0, 0, 0, false);
                if (spritepixels_1 == null) {
                    return null;
                }
            }

            final int[] ints_0 = Rasterizer2D.graphicsPixels;
            final int int_7 = Rasterizer2D.graphicsPixelsWidth;
            final int int_8 = Rasterizer2D.graphicsPixelsHeight;
            final int[] ints_1 = new int[4];
            Rasterizer2D.copyDrawRegion(ints_1);
            spritepixels_0 = new SpritePixels(36, 32);
            Rasterizer2D.setRasterBuffer(spritepixels_0.pixels, 36, 32);
            Rasterizer2D.reset();
            Graphics3D.Rasterizer3D_method1();
            Graphics3D.method2827(16, 16);
            Graphics3D.rasterGouraudLowRes = false;
            if (itemcomposition_0.placeholderTemplateId != -1) {
                spritepixels_1.drawAt(0, 0);
            }

            int int_9 = itemcomposition_0.zoom2d;
            if (bool_0) {
                int_9 = (int) (1.5D * int_9);
            } else if (int_2 == 2) {
                int_9 = (int) (int_9 * 1.04D);
            }

            final int int_10 = (int_9 * Graphics3D.SINE[itemcomposition_0.xan2d]) >> 16;
            final int int_11 = (int_9 * Graphics3D.COSINE[itemcomposition_0.xan2d]) >> 16;
            model_0.calculateBoundsCylinder();
            model_0.method2682(0, itemcomposition_0.yan2d, itemcomposition_0.zan2d, itemcomposition_0.xan2d,
                    itemcomposition_0.offsetX2d, (model_0.modelHeight / 2) + int_10 + itemcomposition_0.offsetY2d,
                    int_11 + itemcomposition_0.offsetY2d);
            if (itemcomposition_0.notedId != -1) {
                spritepixels_1.drawAt(0, 0);
            }

            if (int_2 >= 1) {
                spritepixels_0.method5847(1);
            }

            if (int_2 >= 2) {
                spritepixels_0.method5847(16777215);
            }

            if (int_3 != 0) {
                spritepixels_0.method5848(int_3);
            }

            Rasterizer2D.setRasterBuffer(spritepixels_0.pixels, 36, 32);
            if (itemcomposition_0.notedTemplate != -1) {
                spritepixels_1.drawAt(0, 0);
            }

            if ((int_4 == 1) || ((int_4 == 2) && (itemcomposition_0.isStackable == 1))) {
                final Font font_0 = ItemComposition.field3466;
                String string_0;
                if (int_1 < 100000) {
                    string_0 = "<col=ffff00>" + int_1 + "</col>";
                } else if (int_1 < 10000000) {
                    string_0 = "<col=ffffff>" + (int_1 / 1000) + "K" + "</col>";
                } else {
                    string_0 = "<col=00ff80>" + (int_1 / 1000000) + "M" + "</col>";
                }

                font_0.method5522(string_0, 0, 9, 16776960, 1);
            }

            if (!bool_0) {
                ItemComposition.itemSpriteCache.put(spritepixels_0, long_0);
            }

            Rasterizer2D.setRasterBuffer(ints_0, int_7, int_8);
            Rasterizer2D.setDrawRegion(ints_1);
            Graphics3D.Rasterizer3D_method1();
            Graphics3D.rasterGouraudLowRes = true;
            return spritepixels_0;
        }
    }

    static void method271(final String string_0) {
        final StringBuilder stringbuilder_0 = (new StringBuilder()).append(string_0);
        final String string_1 = stringbuilder_0.append(" is already on your ignore list").toString();
        class143.sendGameMessage(30, "", string_1);
    }

    static Widget method264(final Widget widget_0) {
        Widget widget_1 = widget_0;
        final int int_0 = ISAACCipher.method3865(class24.getWidgetClickMask(widget_0));
        Widget widget_2;
        if (int_0 == 0) {
            widget_2 = null;
        } else {
            int int_1 = 0;

            while (true) {
                if (int_1 >= int_0) {
                    widget_2 = widget_1;
                    break;
                }

                widget_1 = Widget.getWidget(widget_1.parentHash);
                if (widget_1 == null) {
                    widget_2 = null;
                    break;
                }

                ++int_1;
            }
        }

        Widget widget_3 = widget_2;
        if (widget_2 == null) {
            widget_3 = widget_0.dragParent;
        }

        return widget_3;
    }

    static void method270(final int int_0) {
        if (CombatInfo2.loadWidget(int_0)) {
            FileSystem.method4620(GameCanvas.widgets[int_0], -1);
        }
    }

}
