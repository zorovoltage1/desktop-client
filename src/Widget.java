public class Widget extends Node {

    static IndexDataBase widgetIndex;
    static IndexDataBase field2642;
    static IndexDataBase field2598;
    static NodeCache field2599;
    static NodeCache Widget_cachedModels;
    static NodeCache Widget_cachedFonts;
    static NodeCache field2602;
    public static boolean field2603;
    public boolean hasScript;
    public int interfaceHash;
    public int index;
    public int type;
    public int field2709;
    public int contentType;
    public int dynamicX;
    public int dynamicY;
    public int dynamicWidth;
    public int buttonType;
    public int originalX;
    public int originalY;
    public int originalWidth;
    public int originalHeight;
    public int relativeX;
    public int relativeY;
    public int width;
    public int height;
    public int field2622;
    public int field2623;
    public int parentHash;
    public boolean isHidden;
    public int scrollX;
    public int scrollY;
    public int scrollWidth;
    public int scrollHeight;
    public int textColor;
    public int field2631;
    public int field2632;
    public int field2633;
    public boolean filled;
    public class316 field2701;
    public int opacity;
    public int field2608;
    public int lineWidth;
    public boolean field2639;
    public int spriteId;
    public int field2641;
    public int textureId;
    public boolean spriteTiling;
    public int borderThickness;
    public int shadow;
    public boolean flippedVertically;
    public boolean flippedHorizontally;
    public int modelType;
    public int modelId;
    int field2650;
    int field2651;
    public int field2595;
    public int field2653;
    public int offsetX2d;
    public int offsetY2d;
    public int rotationX;
    public int rotationZ;
    public int rotationY;
    public int modelZoom;
    public int field2660;
    public int field2732;
    public boolean field2662;
    public boolean field2726;
    public int itemAmountSetting;
    public int fontId;
    public String text;
    public String string1;
    public int lineHeight;
    public int fontHorizontalAlignment;
    public int fontVerticalAlignment;
    public boolean textShadowed;
    public int paddingX;
    public int paddingY;
    public int[] xSprites;
    public int[] field2738;
    public int[] field2676;
    public String[] configActions;
    public int clickMask;
    public String opBase;
    public String[] actions;
    public Widget dragParent;
    public int dragDeadZone;
    public int dragDeadTime;
    public boolean dragRenderBehavior;
    public String targetVerb;
    public boolean hasListener;
    public Object[] onLoadListener;
    public Object[] onClickListener;
    public Object[] onClickRepeatListener;
    public Object[] onReleaseListener;
    public Object[] onHoldListener;
    public Object[] onMouseOverListener;
    public Object[] onMouseRepeatListener;
    public Object[] onMouseLeaveListener;
    public Object[] onDragListener;
    public Object[] onDragCompleteListener;
    public Object[] onTargetEnterListener;
    public Object[] onTargetLeaveListener;
    public Object[] onVarTransmitListener;
    public int[] varTransmitTriggers;
    public Object[] onInvTransmitListener;
    public int[] invTransmitTriggers;
    public Object[] onStatTransmitListener;
    public int[] statTransmitTriggers;
    public Object[] onTimerListener;
    public Object[] onOpListener;
    public Object[] onScrollWheelListener;
    public Object[] onChatTransmitListener;
    public Object[] onKeyListener;
    public Object[] onFriendTransmitListener;
    public Object[] onClanTransmitListener;
    public Object[] onMiscTransmitListener;
    public Object[] onDialogAbortListener;
    public Object[] onSubChangeListener;
    public Object[] onResizeListener;
    public Object[] onStockTransmitListener;
    public Object[] onCamFinishedListener;
    public int[][] dynamicValues;
    public int[] tableActions;
    public int[] field2720;
    public int field2713;
    public String spellName;
    public String tooltip;
    public int[] itemIds;
    public int[] itemQuantities;
    public int itemId;
    public int itemQuantity;
    public int field2728;
    public int field2613;
    public Widget[] children;
    public boolean field2731;
    public boolean field2674;
    public int field2697;
    public int field2683;
    public int field2735;
    public int field2702;
    public int boundsIndex;
    public int loopCycle;
    public boolean noClickThrough;
    public boolean noScrollThrough;

    static {
        field2599 = new NodeCache(200);
        Widget_cachedModels = new NodeCache(50);
        Widget_cachedFonts = new NodeCache(20);
        field2602 = new NodeCache(8);
        field2603 = false;
    }

    public Widget() {
        hasScript = false;
        interfaceHash = -1;
        index = -1;
        field2709 = 0;
        contentType = 0;
        dynamicX = 0;
        dynamicY = 0;
        dynamicWidth = 0;
        buttonType = 0;
        originalX = 0;
        originalY = 0;
        originalWidth = 0;
        originalHeight = 0;
        relativeX = 0;
        relativeY = 0;
        width = 0;
        height = 0;
        field2622 = 1;
        field2623 = 1;
        parentHash = -1;
        isHidden = false;
        scrollX = 0;
        scrollY = 0;
        scrollWidth = 0;
        scrollHeight = 0;
        textColor = 0;
        field2631 = 0;
        field2632 = 0;
        field2633 = 0;
        filled = false;
        field2701 = class316.field3775;
        opacity = 0;
        field2608 = 0;
        lineWidth = 1;
        field2639 = false;
        spriteId = -1;
        field2641 = -1;
        textureId = 0;
        spriteTiling = false;
        borderThickness = 0;
        shadow = 0;
        modelType = 1;
        modelId = -1;
        field2650 = 1;
        field2651 = -1;
        field2595 = -1;
        field2653 = -1;
        offsetX2d = 0;
        offsetY2d = 0;
        rotationX = 0;
        rotationZ = 0;
        rotationY = 0;
        modelZoom = 100;
        field2660 = 0;
        field2732 = 0;
        field2662 = false;
        field2726 = false;
        itemAmountSetting = 2;
        fontId = -1;
        text = "";
        string1 = "";
        lineHeight = 0;
        fontHorizontalAlignment = 0;
        fontVerticalAlignment = 0;
        textShadowed = false;
        paddingX = 0;
        paddingY = 0;
        clickMask = 0;
        opBase = "";
        dragParent = null;
        dragDeadZone = 0;
        dragDeadTime = 0;
        dragRenderBehavior = false;
        targetVerb = "";
        hasListener = false;
        field2713 = -1;
        spellName = "";
        tooltip = "Ok";
        itemId = -1;
        itemQuantity = 0;
        field2728 = 0;
        field2613 = 0;
        field2731 = false;
        field2674 = false;
        field2697 = -1;
        field2683 = 0;
        field2735 = 0;
        field2702 = 0;
        boundsIndex = -1;
        loopCycle = -1;
        noClickThrough = false;
        noScrollThrough = false;
    }

    void decode(final Buffer buffer_0) {
        hasScript = false;
        type = buffer_0.readUnsignedByte();
        field2709 = buffer_0.readUnsignedByte();
        contentType = buffer_0.readUnsignedShort();
        originalX = buffer_0.readShort();
        originalY = buffer_0.readShort();
        originalWidth = buffer_0.readUnsignedShort();
        originalHeight = buffer_0.readUnsignedShort();
        opacity = buffer_0.readUnsignedByte();
        parentHash = buffer_0.readUnsignedShort();
        if (parentHash == 65535) {
            parentHash = -1;
        } else {
            parentHash += interfaceHash & 0xFFFF0000;
        }

        field2713 = buffer_0.readUnsignedShort();
        if (field2713 == 65535) {
            field2713 = -1;
        }

        final int int_0 = buffer_0.readUnsignedByte();
        int int_1;
        if (int_0 > 0) {
            tableActions = new int[int_0];
            field2720 = new int[int_0];

            for (int_1 = 0; int_1 < int_0; int_1++) {
                tableActions[int_1] = buffer_0.readUnsignedByte();
                field2720[int_1] = buffer_0.readUnsignedShort();
            }
        }

        int_1 = buffer_0.readUnsignedByte();
        int int_2;
        int int_3;
        int int_4;
        if (int_1 > 0) {
            dynamicValues = new int[int_1][];

            for (int_2 = 0; int_2 < int_1; int_2++) {
                int_3 = buffer_0.readUnsignedShort();
                dynamicValues[int_2] = new int[int_3];

                for (int_4 = 0; int_4 < int_3; int_4++) {
                    dynamicValues[int_2][int_4] = buffer_0.readUnsignedShort();
                    if (dynamicValues[int_2][int_4] == 65535) {
                        dynamicValues[int_2][int_4] = -1;
                    }
                }
            }
        }

        if (type == 0) {
            scrollHeight = buffer_0.readUnsignedShort();
            isHidden = buffer_0.readUnsignedByte() == 1;
        }

        if (type == 1) {
            buffer_0.readUnsignedShort();
            buffer_0.readUnsignedByte();
        }

        if (type == 2) {
            itemIds = new int[originalWidth * originalHeight];
            itemQuantities = new int[originalWidth * originalHeight];
            int_2 = buffer_0.readUnsignedByte();
            if (int_2 == 1) {
                clickMask |= 0x10000000;
            }

            int_3 = buffer_0.readUnsignedByte();
            if (int_3 == 1) {
                clickMask |= 0x40000000;
            }

            int_4 = buffer_0.readUnsignedByte();
            if (int_4 == 1) {
                clickMask |= 0x80000000;
            }

            final int int_5 = buffer_0.readUnsignedByte();
            if (int_5 == 1) {
                clickMask |= 0x20000000;
            }

            paddingX = buffer_0.readUnsignedByte();
            paddingY = buffer_0.readUnsignedByte();
            xSprites = new int[20];
            field2738 = new int[20];
            field2676 = new int[20];

            int int_6;
            for (int_6 = 0; int_6 < 20; int_6++) {
                final int int_7 = buffer_0.readUnsignedByte();
                if (int_7 == 1) {
                    xSprites[int_6] = buffer_0.readShort();
                    field2738[int_6] = buffer_0.readShort();
                    field2676[int_6] = buffer_0.readInt();
                } else {
                    field2676[int_6] = -1;
                }
            }

            configActions = new String[5];

            for (int_6 = 0; int_6 < 5; int_6++) {
                final String string_1 = buffer_0.readString();
                if (string_1.length() > 0) {
                    configActions[int_6] = string_1;
                    clickMask |= 1 << (int_6 + 23);
                }
            }
        }

        if (type == 3) {
            filled = buffer_0.readUnsignedByte() == 1;
        }

        if ((type == 4) || (type == 1)) {
            fontHorizontalAlignment = buffer_0.readUnsignedByte();
            fontVerticalAlignment = buffer_0.readUnsignedByte();
            lineHeight = buffer_0.readUnsignedByte();
            fontId = buffer_0.readUnsignedShort();
            if (fontId == 65535) {
                fontId = -1;
            }

            textShadowed = buffer_0.readUnsignedByte() == 1;
        }

        if (type == 4) {
            text = buffer_0.readString();
            string1 = buffer_0.readString();
        }

        if ((type == 1) || (type == 3) || (type == 4)) {
            textColor = buffer_0.readInt();
        }

        if ((type == 3) || (type == 4)) {
            field2631 = buffer_0.readInt();
            field2632 = buffer_0.readInt();
            field2633 = buffer_0.readInt();
        }

        if (type == 5) {
            spriteId = buffer_0.readInt();
            field2641 = buffer_0.readInt();
        }

        if (type == 6) {
            modelType = 1;
            modelId = buffer_0.readUnsignedShort();
            if (modelId == 65535) {
                modelId = -1;
            }

            field2650 = 1;
            field2651 = buffer_0.readUnsignedShort();
            if (field2651 == 65535) {
                field2651 = -1;
            }

            field2595 = buffer_0.readUnsignedShort();
            if (field2595 == 65535) {
                field2595 = -1;
            }

            field2653 = buffer_0.readUnsignedShort();
            if (field2653 == 65535) {
                field2653 = -1;
            }

            modelZoom = buffer_0.readUnsignedShort();
            rotationX = buffer_0.readUnsignedShort();
            rotationZ = buffer_0.readUnsignedShort();
        }

        if (type == 7) {
            itemIds = new int[originalHeight * originalWidth];
            itemQuantities = new int[originalWidth * originalHeight];
            fontHorizontalAlignment = buffer_0.readUnsignedByte();
            fontId = buffer_0.readUnsignedShort();
            if (fontId == 65535) {
                fontId = -1;
            }

            textShadowed = buffer_0.readUnsignedByte() == 1;
            textColor = buffer_0.readInt();
            paddingX = buffer_0.readShort();
            paddingY = buffer_0.readShort();
            int_2 = buffer_0.readUnsignedByte();
            if (int_2 == 1) {
                clickMask |= 0x40000000;
            }

            configActions = new String[5];

            for (int_3 = 0; int_3 < 5; int_3++) {
                final String string_0 = buffer_0.readString();
                if (string_0.length() > 0) {
                    configActions[int_3] = string_0;
                    clickMask |= 1 << (int_3 + 23);
                }
            }
        }

        if (type == 8) {
            text = buffer_0.readString();
        }

        if ((field2709 == 2) || (type == 2)) {
            targetVerb = buffer_0.readString();
            spellName = buffer_0.readString();
            int_2 = buffer_0.readUnsignedShort() & 0x3F;
            clickMask |= int_2 << 11;
        }

        if ((field2709 == 1) || (field2709 == 4) || (field2709 == 5) || (field2709 == 6)) {
            tooltip = buffer_0.readString();
            if (tooltip.length() == 0) {
                if (field2709 == 1) {
                    tooltip = "Ok";
                }

                if (field2709 == 4) {
                    tooltip = "Select";
                }

                if (field2709 == 5) {
                    tooltip = "Select";
                }

                if (field2709 == 6) {
                    tooltip = "Continue";
                }
            }
        }

        if ((field2709 == 1) || (field2709 == 4) || (field2709 == 5)) {
            clickMask |= 0x400000;
        }

        if (field2709 == 6) {
            clickMask |= 0x1;
        }

    }

    public static Widget get(int parentId, int childId) {
        return getWidget(parentId << 16 | childId);
    }

    public static Widget getWidget(final int int_0) {
        final int int_1 = int_0 >> 16;
        final int int_2 = int_0 & 0xFFFF;
        if ((GameCanvas.widgets[int_1] == null) || (GameCanvas.widgets[int_1][int_2] == null)) {
            final boolean bool_0 = CombatInfo2.loadWidget(int_1);
            if (!bool_0)
                return null;
        }
        return GameCanvas.widgets[int_1][int_2];
    }

    void decodeActive(final Buffer buffer_0) {
        buffer_0.readUnsignedByte();
        hasScript = true;
        type = buffer_0.readUnsignedByte();
        contentType = buffer_0.readUnsignedShort();
        originalX = buffer_0.readShort();
        originalY = buffer_0.readShort();
        originalWidth = buffer_0.readUnsignedShort();
        if (type == 9) {
            originalHeight = buffer_0.readShort();
        } else {
            originalHeight = buffer_0.readUnsignedShort();
        }

        dynamicWidth = buffer_0.readByte();
        buttonType = buffer_0.readByte();
        dynamicX = buffer_0.readByte();
        dynamicY = buffer_0.readByte();
        parentHash = buffer_0.readUnsignedShort();
        if (parentHash == 65535) {
            parentHash = -1;
        } else {
            parentHash += interfaceHash & 0xFFFF0000;
        }

        isHidden = buffer_0.readUnsignedByte() == 1;
        if (type == 0) {
            scrollWidth = buffer_0.readUnsignedShort();
            scrollHeight = buffer_0.readUnsignedShort();
            noClickThrough = buffer_0.readUnsignedByte() == 1;
        }

        if (type == 5) {
            spriteId = buffer_0.readInt();
            textureId = buffer_0.readUnsignedShort();
            spriteTiling = buffer_0.readUnsignedByte() == 1;
            opacity = buffer_0.readUnsignedByte();
            borderThickness = buffer_0.readUnsignedByte();
            shadow = buffer_0.readInt();
            flippedVertically = buffer_0.readUnsignedByte() == 1;
            flippedHorizontally = buffer_0.readUnsignedByte() == 1;
        }

        if (type == 6) {
            modelType = 1;
            modelId = buffer_0.readUnsignedShort();
            if (modelId == 65535) {
                modelId = -1;
            }

            offsetX2d = buffer_0.readShort();
            offsetY2d = buffer_0.readShort();
            rotationX = buffer_0.readUnsignedShort();
            rotationZ = buffer_0.readUnsignedShort();
            rotationY = buffer_0.readUnsignedShort();
            modelZoom = buffer_0.readUnsignedShort();
            field2595 = buffer_0.readUnsignedShort();
            if (field2595 == 65535) {
                field2595 = -1;
            }

            field2662 = buffer_0.readUnsignedByte() == 1;
            buffer_0.readUnsignedShort();
            if (dynamicWidth != 0) {
                field2660 = buffer_0.readUnsignedShort();
            }

            if (buttonType != 0) {
                buffer_0.readUnsignedShort();
            }
        }

        if (type == 4) {
            fontId = buffer_0.readUnsignedShort();
            if (fontId == 65535) {
                fontId = -1;
            }

            text = buffer_0.readString();
            lineHeight = buffer_0.readUnsignedByte();
            fontHorizontalAlignment = buffer_0.readUnsignedByte();
            fontVerticalAlignment = buffer_0.readUnsignedByte();
            textShadowed = buffer_0.readUnsignedByte() == 1;
            textColor = buffer_0.readInt();
        }

        if (type == 3) {
            textColor = buffer_0.readInt();
            filled = buffer_0.readUnsignedByte() == 1;
            opacity = buffer_0.readUnsignedByte();
        }

        if (type == 9) {
            lineWidth = buffer_0.readUnsignedByte();
            textColor = buffer_0.readInt();
            field2639 = buffer_0.readUnsignedByte() == 1;
        }

        clickMask = buffer_0.read24BitInt();
        opBase = buffer_0.readString();
        final int int_0 = buffer_0.readUnsignedByte();
        if (int_0 > 0) {
            actions = new String[int_0];

            for (int int_1 = 0; int_1 < int_0; int_1++) {
                actions[int_1] = buffer_0.readString();
            }
        }

        dragDeadZone = buffer_0.readUnsignedByte();
        dragDeadTime = buffer_0.readUnsignedByte();
        dragRenderBehavior = buffer_0.readUnsignedByte() == 1;
        targetVerb = buffer_0.readString();
        onLoadListener = decodeListener(buffer_0);
        onMouseOverListener = decodeListener(buffer_0);
        onMouseLeaveListener = decodeListener(buffer_0);
        onTargetLeaveListener = decodeListener(buffer_0);
        onTargetEnterListener = decodeListener(buffer_0);
        onVarTransmitListener = decodeListener(buffer_0);
        onInvTransmitListener = decodeListener(buffer_0);
        onStatTransmitListener = decodeListener(buffer_0);
        onTimerListener = decodeListener(buffer_0);
        onOpListener = decodeListener(buffer_0);
        onMouseRepeatListener = decodeListener(buffer_0);
        onClickListener = decodeListener(buffer_0);
        onClickRepeatListener = decodeListener(buffer_0);
        onReleaseListener = decodeListener(buffer_0);
        onHoldListener = decodeListener(buffer_0);
        onDragListener = decodeListener(buffer_0);
        onDragCompleteListener = decodeListener(buffer_0);
        onScrollWheelListener = decodeListener(buffer_0);
        varTransmitTriggers = decodeTransmitList(buffer_0);
        invTransmitTriggers = decodeTransmitList(buffer_0);
        statTransmitTriggers = decodeTransmitList(buffer_0);
    }

    Object[] decodeListener(final Buffer buffer_0) {
        final int int_0 = buffer_0.readUnsignedByte();
        if (int_0 == 0) {
            return null;
        } else {
            final Object[] objects_0 = new Object[int_0];

            for (int int_1 = 0; int_1 < int_0; int_1++) {
                final int int_2 = buffer_0.readUnsignedByte();
                if (int_2 == 0) {
                    objects_0[int_1] = new Integer(buffer_0.readInt());
                } else if (int_2 == 1) {
                    objects_0[int_1] = buffer_0.readString();
                }
            }

            hasListener = true;
            return objects_0;
        }
    }

    int[] decodeTransmitList(final Buffer buffer_0) {
        final int int_0 = buffer_0.readUnsignedByte();
        if (int_0 == 0) {
            return null;
        } else {
            final int[] ints_0 = new int[int_0];

            for (int int_1 = 0; int_1 < int_0; int_1++) {
                ints_0[int_1] = buffer_0.readInt();
            }

            return ints_0;
        }
    }

    public void method4507(final int int_0, final int int_1) {
        int int_2 = itemIds[int_1];
        itemIds[int_1] = itemIds[int_0];
        itemIds[int_0] = int_2;
        int_2 = itemQuantities[int_1];
        itemQuantities[int_1] = itemQuantities[int_0];
        itemQuantities[int_0] = int_2;
    }

    public SpritePixels method4508(final boolean bool_0) {
        field2603 = false;
        int int_0;
        if (bool_0) {
            int_0 = field2641;
        } else {
            int_0 = spriteId;
        }

        if (int_0 == -1) {
            return null;
        } else {
            final long long_0 = ((flippedHorizontally ? 1L : 0L) << 39) + int_0 + ((long) borderThickness << 36)
                    + ((flippedVertically ? 1L : 0L) << 38) + ((long) shadow << 40);
            SpritePixels spritepixels_0 = (SpritePixels) field2599.get(long_0);
            if (spritepixels_0 != null) {
                return spritepixels_0;
            } else {
                if ((spritepixels_0 = RuinUtils.customInterSprite(int_0)) == null)
                    spritepixels_0 = class229.method4499(Signlink.field1956, int_0, 0);
                if (spritepixels_0 == null) {
                    field2603 = true;
                    return null;
                } else {
                    if (flippedVertically) {
                        spritepixels_0.method5842();
                    }

                    if (flippedHorizontally) {
                        spritepixels_0.method5934();
                    }

                    if (borderThickness > 0) {
                        spritepixels_0.method5844(borderThickness);
                    }

                    if (borderThickness >= 1) {
                        spritepixels_0.method5847(1);
                    }

                    if (borderThickness >= 2) {
                        spritepixels_0.method5847(16777215);
                    }

                    if (shadow != 0) {
                        spritepixels_0.method5848(shadow);
                    }

                    field2599.put(spritepixels_0, long_0);
                    return spritepixels_0;
                }
            }
        }
    }

    public Font getFont() {
        field2603 = false;
        if (fontId == -1) {
            return null;
        } else {
            Font font_0 = (Font) Widget_cachedFonts.get(fontId);
            if (font_0 != null) {
                return font_0;
            } else {
                font_0 = MessageNode.method1058(Signlink.field1956, field2598, fontId, 0);
                if (font_0 != null) {
                    Widget_cachedFonts.put(font_0, fontId);
                } else {
                    field2603 = true;
                }

                return font_0;
            }
        }
    }

    public SpritePixels method4509(final int int_0) {
        field2603 = false;
        if ((int_0 >= 0) && (int_0 < field2676.length)) {
            final int int_1 = field2676[int_0];
            if (int_1 == -1) {
                return null;
            } else {
                SpritePixels spritepixels_0 = (SpritePixels) field2599.get(int_1);
                if (spritepixels_0 != null) {
                    return spritepixels_0;
                } else {
                    spritepixels_0 = class229.method4499(Signlink.field1956, int_1, 0);
                    if (spritepixels_0 != null) {
                        field2599.put(spritepixels_0, int_1);
                    } else {
                        field2603 = true;
                    }

                    return spritepixels_0;
                }
            }
        } else {
            return null;
        }
    }

    public Model getModel(final Sequence sequence_0, final int int_0, final boolean bool_0,
                          final PlayerComposition playercomposition_0) {
        field2603 = false;
        int int_1;
        int int_2;
        if (bool_0) {
            int_1 = field2650;
            int_2 = field2651;
        } else {
            int_1 = modelType;
            int_2 = modelId;
        }

        if (int_1 == 0) {
            return null;
        } else if ((int_1 == 1) && (int_2 == -1)) {
            return null;
        } else {
            Model model_0 = (Model) Widget_cachedModels.get(int_2 + (int_1 << 16));
            if (model_0 == null) {
                ModelData modeldata_0;
                if (int_1 == 1) {
                    modeldata_0 = ModelData.method2568(field2642, int_2, 0);
                    if (modeldata_0 == null) {
                        field2603 = true;
                        return null;
                    }

                    model_0 = modeldata_0.light(64, 768, -50, -10, -50);
                }

                if (int_1 == 2) {
                    modeldata_0 = HorizontalAlignment.getNpcDefinition(int_2).method5158();
                    if (modeldata_0 == null) {
                        field2603 = true;
                        return null;
                    }

                    model_0 = modeldata_0.light(64, 768, -50, -10, -50);
                }

                if (int_1 == 3) {
                    if (playercomposition_0 == null) {
                        return null;
                    }

                    modeldata_0 = playercomposition_0.method4469();
                    if (modeldata_0 == null) {
                        field2603 = true;
                        return null;
                    }

                    model_0 = modeldata_0.light(64, 768, -50, -10, -50);
                }

                if (int_1 == 4) {
                    final ItemComposition itemcomposition_0 = TextureProvider.getItemDefinition(int_2);
                    modeldata_0 = itemcomposition_0.method5092(10);
                    if (modeldata_0 == null) {
                        field2603 = true;
                        return null;
                    }

                    model_0 = modeldata_0.light(itemcomposition_0.ambient + 64, itemcomposition_0.contrast + 768, -50,
                            -10, -50);
                }

                Widget_cachedModels.put(model_0, int_2 + (int_1 << 16));
            }

            if (sequence_0 != null) {
                model_0 = sequence_0.method5219(model_0, int_0);
            }

            return model_0;
        }
    }

    public class224 method4517(boolean bool_0) {
        if (field2641 == -1) {
            bool_0 = false;
        }

        final int int_0 = bool_0 ? field2641 : spriteId;
        if (int_0 == -1) {
            return null;
        } else {
            final long long_0 = int_0 + ((long) borderThickness << 36) + ((flippedVertically ? 1L : 0L) << 38)
                    + ((flippedHorizontally ? 1L : 0L) << 39) + ((long) shadow << 40);
            class224 class224_0 = (class224) field2602.get(long_0);
            if (class224_0 != null) {
                return class224_0;
            } else {
                final SpritePixels spritepixels_0 = method4508(bool_0);
                if (spritepixels_0 == null) {
                    return null;
                } else {
                    final SpritePixels spritepixels_1 = spritepixels_0.copy();
                    final int[] ints_0 = new int[spritepixels_1.height];
                    final int[] ints_1 = new int[spritepixels_1.height];

                    for (int int_1 = 0; int_1 < spritepixels_1.height; int_1++) {
                        int int_2 = 0;
                        int int_3 = spritepixels_1.width;

                        int int_4;
                        for (int_4 = 0; int_4 < spritepixels_1.width; int_4++) {
                            if (spritepixels_1.pixels[int_4 + (int_1 * spritepixels_1.width)] == 0) {
                                int_2 = int_4;
                                break;
                            }
                        }

                        for (int_4 = spritepixels_1.width - 1; int_4 >= int_2; --int_4) {
                            if (spritepixels_1.pixels[int_4 + (int_1 * spritepixels_1.width)] == 0) {
                                int_3 = int_4 + 1;
                                break;
                            }
                        }

                        ints_0[int_1] = int_2;
                        ints_1[int_1] = int_3 - int_2;
                    }

                    class224_0 = new class224(spritepixels_1.width, spritepixels_1.height, ints_1, ints_0, int_0);
                    field2602.put(class224_0, long_0);
                    return class224_0;
                }
            }
        }
    }

    public void setAction(final int int_0, final String string_0) {
        if ((actions == null) || (actions.length <= int_0)) {
            final String[] strings_0 = new String[int_0 + 1];
            if (actions != null) {
                for (int int_1 = 0; int_1 < actions.length; int_1++) {
                    strings_0[int_1] = actions[int_1];
                }
            }

            actions = strings_0;
        }

        actions[int_0] = string_0;
    }

    static int method4559(final int int_0, final int int_1) {
        final ItemContainer itemcontainer_0 = (ItemContainer) ItemContainer.itemContainers.get(int_0);
        return itemcontainer_0 == null ? -1
                : ((int_1 >= 0) && (int_1 < itemcontainer_0.itemIds.length) ? itemcontainer_0.itemIds[int_1] : -1);
    }

    /**
     * Custom
     */

    public static Widget addChild(int interfaceHash, int childType, int childId) {
        if (childType == 0)
            throw new RuntimeException();
        Widget parent = Widget.getWidget(interfaceHash);
        if (parent.children == null)
            parent.children = new Widget[childId + 1];
        if (parent.children.length <= childId) {
            Widget[] var35 = new Widget[childId + 1];
            for (int var10 = 0; var10 < parent.children.length; var10++)
                var35[var10] = parent.children[var10];
            parent.children = var35;
        }
        if (childId > 0 && parent.children[childId - 1] == null)
            throw new RuntimeException("" + (childId - 1));
        Widget child = new Widget();
        child.type = childType;
        child.parentHash = child.interfaceHash = parent.interfaceHash;
        child.index = childId;
        child.hasScript = true;
        parent.children[childId] = child;
        Player.method1114(parent);
        return child;
    }

    public static void setItem(Widget inter, int itemId, int itemAmount, int itemAmountSetting) {
        ItemComposition def = TextureProvider.getItemDefinition(itemId);
        inter.itemId = itemId;
        inter.itemQuantity = itemAmount;
        inter.rotationX = def.xan2d;
        inter.rotationZ = def.yan2d;
        inter.rotationY = def.zan2d;
        inter.offsetX2d = def.offsetX2d;
        inter.offsetY2d = def.offsetY2d;
        inter.modelZoom = def.zoom2d;
        inter.itemAmountSetting = itemAmountSetting;
        try {
            if (inter.field2660 > 0)
                inter.modelZoom = inter.modelZoom * 32 / inter.field2660;
            else if (inter.width > 0)
                inter.modelZoom = inter.modelZoom * 32 / inter.originalWidth;
        } catch (ArithmeticException e) {
                e.printStackTrace();
            }
    }


}
