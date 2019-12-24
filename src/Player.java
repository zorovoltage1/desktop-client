public final class Player extends Actor {

    Name name;
    PlayerComposition composition;
    int skullIcon;
    int overheadIcon;
    String[] actions;
    int combatLevel;
    int totalLevel;
    int field562;
    int animationCycleStart;
    int animationCycleEnd;
    int field556;
    int field557;
    int field558;
    Model model;
    int field559;
    int field547;
    int field565;
    int field553;
    boolean isLowDetail;
    int team;
    boolean hidden;
    int field567;
    int playerId;
    class289 field569;
    class289 field554;
    boolean field571;
    int field572;
    int field573;

    // User titles
    private String prefix, suffix;

    Player() {
        skullIcon = -1;
        overheadIcon = -1;
        actions = new String[3];

        for (int int_0 = 0; int_0 < 3; int_0++) {
            actions[int_0] = "";
        }

        combatLevel = 0;
        totalLevel = 0;
        animationCycleStart = 0;
        animationCycleEnd = 0;
        isLowDetail = false;
        team = 0;
        hidden = false;
        field569 = class289.field3633;
        field554 = class289.field3633;
        field571 = false;
    }

    private SwitchGrading timedSwitch;

    void decodeApperance(final Buffer buffer_0) {
        buffer_0.offset = 0;
        final int int_0 = buffer_0.readUnsignedByte();
        skullIcon = buffer_0.readByte();
        overheadIcon = buffer_0.readByte();
        int int_1 = -1;
        team = 0;
        final int[] ints_0 = new int[12];

        int int_3;
        int int_4;
        for (int int_2 = 0; int_2 < 12; int_2++) {
            int_3 = buffer_0.readUnsignedByte();
            if (int_3 == 0) {
                ints_0[int_2] = 0;
            } else {
                int_4 = buffer_0.readUnsignedByte();
                ints_0[int_2] = int_4 + (int_3 << 8);
                if ((int_2 == 0) && (ints_0[0] == 65535)) {
                    int_1 = buffer_0.readUnsignedShort();
                    break;
                }

                if (ints_0[int_2] >= 512) {
                    final int int_5 = TextureProvider.getItemDefinition(ints_0[int_2] - 512).team;
                    if (int_5 != 0) {
                        team = int_5;
                    }
                }
            }
        }

        final int[] ints_1 = new int[5];

        for (int_3 = 0; int_3 < 5; int_3++) {
            int_4 = buffer_0.readUnsignedByte();
            if ((int_4 < 0) || (int_4 >= PlayerComposition.colorsToReplace[int_3].length)) {
                int_4 = 0;
            }

            ints_1[int_3] = int_4;
        }

        super.idlePoseAnimation = buffer_0.readUnsignedShort();
        if (super.idlePoseAnimation == 65535) {
            super.idlePoseAnimation = -1;
        }

        super.field877 = buffer_0.readUnsignedShort();
        if (super.field877 == 65535) {
            super.field877 = -1;
        }

        super.field878 = super.field877;
        super.field899 = buffer_0.readUnsignedShort();
        if (super.field899 == 65535) {
            super.field899 = -1;
        }

        super.field880 = buffer_0.readUnsignedShort();
        if (super.field880 == 65535) {
            super.field880 = -1;
        }

        super.field870 = buffer_0.readUnsignedShort();
        if (super.field870 == 65535) {
            super.field870 = -1;
        }

        super.field882 = buffer_0.readUnsignedShort();
        if (super.field882 == 65535) {
            super.field882 = -1;
        }

        super.field883 = buffer_0.readUnsignedShort();
        if (super.field883 == 65535) {
            super.field883 = -1;
        }

        name = new Name(buffer_0.readString(), MapIconReference.loginType);
        prefix = buffer_0.readString();//titles (custom)
        suffix = buffer_0.readString();
        method1084();
        method1086();
        if (this == class138.localPlayer) {
            RunException.field1939 = name.getName();
        }

        combatLevel = buffer_0.readUnsignedByte();
        totalLevel = buffer_0.readUnsignedShort();
        hidden = buffer_0.readUnsignedByte() == 1;
        if ((Game.socketType == 0) && (Game.rights >= 2)) {
            hidden = false;
        }

        if (composition == null) {
            composition = new PlayerComposition();
        }

        composition.method4462(ints_0, ints_1, int_0 == 1, int_1);
        if (this == class138.localPlayer) {
            Game.customizedAppearance.method4462(ints_0, ints_1, int_0 == 1, int_1); //custom bit to keep the design interface updated
            if (timedSwitch == null)
                timedSwitch = new SwitchGrading();
            timedSwitch.check(this);
        }
    }

    boolean isFriend() {
        if (field569 == class289.field3633) {
            method1085();
        }

        return field569 == class289.field3631;
    }

    void method1084() {
        field569 = class289.field3633;
    }

    void method1085() {
        field569 = DState.friendManager.method1637(name) ? class289.field3631 : class289.field3634;
    }

    boolean isClanMember() {
        if (field554 == class289.field3633) {
            method1087();
        }

        return field554 == class289.field3631;
    }

    void method1086() {
        field554 = class289.field3633;
    }

    void method1087() {
        field554 = (WorldMapType3.clanMemberManager != null) && WorldMapType3.clanMemberManager.isMember(name)
                ? class289.field3631
                : class289.field3634;
    }

    int getSize() {
        return (composition != null) && (composition.transformedNpcId != -1)
                ? HorizontalAlignment.getNpcDefinition(composition.transformedNpcId).size
                : 1;
    }

    @Override
    protected Model getModel() {
        if (composition == null) {
            return null;
        } else {
            final Sequence sequence_0 = (super.animation != -1) && (super.actionAnimationDisable == 0)
                    ? TotalQuantityComparator.getAnimation(super.animation)
                    : null;
            final Sequence sequence_1 = (super.poseAnimation == -1) || isLowDetail
                    || ((super.poseAnimation == super.idlePoseAnimation) && (sequence_0 != null)) ? null
                    : TotalQuantityComparator.getAnimation(super.poseAnimation);
            Model model_0 = composition.getModel(sequence_0, super.actionFrame, sequence_1, super.poseFrame);
            if (model_0 == null) {
                return null;
            } else {
                model_0.calculateBoundsCylinder();
                super.logicalHeight = model_0.modelHeight;
                Model model_1;
                Model[] models_0;
                if (!isLowDetail && (super.graphic != -1) && (super.spotAnimFrame != -1)) {
                    model_1 = MouseRecorder.getSpotAnimType(super.graphic).getModel(super.spotAnimFrame);
                    if (model_1 != null) {
                        model_1.offsetBy(0, -super.field871, 0);
                        models_0 = new Model[]{model_0, model_1};
                        model_0 = new Model(models_0, 2);
                    }
                }

                if (!isLowDetail && (model != null)) {
                    if (Game.gameCycle >= animationCycleEnd) {
                        model = null;
                    }

                    if ((Game.gameCycle >= animationCycleStart) && (Game.gameCycle < animationCycleEnd)) {
                        model_1 = model;
                        model_1.offsetBy(field556 - super.x, field557 - field562, field558 - super.y);
                        if (super.orientation == 512) {
                            model_1.rotateY90Ccw();
                            model_1.rotateY90Ccw();
                            model_1.rotateY90Ccw();
                        } else if (super.orientation == 1024) {
                            model_1.rotateY90Ccw();
                            model_1.rotateY90Ccw();
                        } else if (super.orientation == 1536) {
                            model_1.rotateY90Ccw();
                        }

                        models_0 = new Model[]{model_0, model_1};
                        model_0 = new Model(models_0, 2);
                        if (super.orientation == 512) {
                            model_1.rotateY90Ccw();
                        } else if (super.orientation == 1024) {
                            model_1.rotateY90Ccw();
                            model_1.rotateY90Ccw();
                        } else if (super.orientation == 1536) {
                            model_1.rotateY90Ccw();
                            model_1.rotateY90Ccw();
                            model_1.rotateY90Ccw();
                        }

                        model_1.offsetBy(super.x - field556, field562 - field557, super.y - field558);
                    }
                }

                model_0.field1603 = true;
                return model_0;
            }
        }
    }

    void method1106(final int int_0, final int int_1, final byte byte_0) {
        if ((super.animation != -1) && (TotalQuantityComparator.getAnimation(super.animation).priority == 1)) {
            super.animation = -1;
        }

        super.field920 = -1;
        if ((int_0 >= 0) && (int_0 < 104) && (int_1 >= 0) && (int_1 < 104)) {
            if ((super.pathX[0] >= 0) && (super.pathX[0] < 104) && (super.pathY[0] >= 0) && (super.pathY[0] < 104)) {
                if (byte_0 == 2) {
                    PendingSpawn.method1538(this, int_0, int_1, (byte) 2);
                }

                method1105(int_0, int_1, byte_0);
            } else {
                method1103(int_0, int_1);
            }
        } else {
            method1103(int_0, int_1);
        }

    }

    void method1103(final int int_0, final int int_1) {
        super.queueSize = 0;
        super.field930 = 0;
        super.field923 = 0;
        super.pathX[0] = int_0;
        super.pathY[0] = int_1;
        final int int_2 = getSize();
        super.x = (int_2 * 64) + (super.pathX[0] * 128);
        super.y = (int_2 * 64) + (super.pathY[0] * 128);
    }

    void method1105(final int int_0, final int int_1, final byte byte_0) {
        if (super.queueSize < 9) {
            ++super.queueSize;
        }

        for (int int_2 = super.queueSize; int_2 > 0; --int_2) {
            super.pathX[int_2] = super.pathX[int_2 - 1];
            super.pathY[int_2] = super.pathY[int_2 - 1];
            super.pathTraversed[int_2] = super.pathTraversed[int_2 - 1];
        }

        super.pathX[0] = int_0;
        super.pathY[0] = int_1;
        super.pathTraversed[0] = byte_0;
    }

    public String getName(boolean useTitle) {
        if (useTitle && !RuinMisc.HIDE_TITLES) {
            if (prefix != null)
                return prefix + name.getName();
            if (suffix != null)
               return name.getName() + suffix;
            return name.name;
        } else {
            return name.name;
        }
    }


    @Override
    boolean hasConfig() {
        return composition != null;
    }

    static void method1120(final int int_0, final int int_1) {
        class171.method3451(class229.topContextMenuRow, int_0, int_1);
        class229.topContextMenuRow = null;
    }

    static void method1114(final Widget widget_0) {
        if (widget_0.loopCycle == Game.field830) {
            Game.field697[widget_0.boundsIndex] = true;
        }

    }

}
