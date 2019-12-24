public class class35 {

    int field303;
    byte[][][] field304;

    class35(final int int_0) {
        field303 = int_0;
    }

    void method606(final int int_0, final int int_1, final int int_2, final int int_3, final int int_4, final int int_5,
                   int int_6, int int_7) {
        if ((int_6 != 0) && (field303 != 0) && (field304 != null)) {
            int_7 = method590(int_7, int_6);
            int_6 = method591(int_6);
            Rasterizer2D.method5733(int_0, int_1, int_4, int_5, int_2, int_3, field304[int_6 - 1][int_7], field303);
        }
    }

    int method590(int int_0, final int int_1) {
        if (int_1 == 9) {
            int_0 = (int_0 + 1) & 0x3;
        }

        if (int_1 == 10) {
            int_0 = (int_0 + 3) & 0x3;
        }

        if (int_1 == 11) {
            int_0 = (int_0 + 3) & 0x3;
        }

        return int_0;
    }

    int method591(final int int_0) {
        return (int_0 != 9) && (int_0 != 10) ? (int_0 == 11 ? 8 : int_0) : 1;
    }

    void method592() {
        if (field304 == null) {
            field304 = new byte[8][4][];
            method593();
            method625();
            method607();
            method596();
            method612();
            method598();
            method629();
            method595();
        }
    }

    void method593() {
        byte[] bytes_0 = new byte[field303 * field303];
        int int_0 = 0;

        int int_1;
        int int_2;
        for (int_1 = 0; int_1 < field303; int_1++) {
            for (int_2 = 0; int_2 < field303; int_2++) {
                if (int_2 <= int_1) {
                    bytes_0[int_0] = -1;
                }

                ++int_0;
            }
        }

        field304[0][0] = bytes_0;
        bytes_0 = new byte[field303 * field303];
        int_0 = 0;

        for (int_1 = field303 - 1; int_1 >= 0; --int_1) {
            for (int_2 = 0; int_2 < field303; int_2++) {
                if (int_2 <= int_1) {
                    bytes_0[int_0] = -1;
                }

                ++int_0;
            }
        }

        field304[0][1] = bytes_0;
        bytes_0 = new byte[field303 * field303];
        int_0 = 0;

        for (int_1 = 0; int_1 < field303; int_1++) {
            for (int_2 = 0; int_2 < field303; int_2++) {
                if (int_2 >= int_1) {
                    bytes_0[int_0] = -1;
                }

                ++int_0;
            }
        }

        field304[0][2] = bytes_0;
        bytes_0 = new byte[field303 * field303];
        int_0 = 0;

        for (int_1 = field303 - 1; int_1 >= 0; --int_1) {
            for (int_2 = 0; int_2 < field303; int_2++) {
                if (int_2 >= int_1) {
                    bytes_0[int_0] = -1;
                }

                ++int_0;
            }
        }

        field304[0][3] = bytes_0;
    }

    void method625() {
        byte[] bytes_0 = new byte[field303 * field303];
        int int_0 = 0;

        int int_1;
        int int_2;
        for (int_1 = field303 - 1; int_1 >= 0; --int_1) {
            for (int_2 = 0; int_2 < field303; int_2++) {
                if (int_2 <= (int_1 >> 1)) {
                    bytes_0[int_0] = -1;
                }

                ++int_0;
            }
        }

        field304[1][0] = bytes_0;
        bytes_0 = new byte[field303 * field303];
        int_0 = 0;

        for (int_1 = 0; int_1 < field303; int_1++) {
            for (int_2 = 0; int_2 < field303; int_2++) {
                if ((int_0 >= 0) && (int_0 < bytes_0.length)) {
                    if (int_2 >= (int_1 << 1)) {
                        bytes_0[int_0] = -1;
                    }

                    ++int_0;
                } else {
                    ++int_0;
                }
            }
        }

        field304[1][1] = bytes_0;
        bytes_0 = new byte[field303 * field303];
        int_0 = 0;

        for (int_1 = 0; int_1 < field303; int_1++) {
            for (int_2 = field303 - 1; int_2 >= 0; --int_2) {
                if (int_2 <= (int_1 >> 1)) {
                    bytes_0[int_0] = -1;
                }

                ++int_0;
            }
        }

        field304[1][2] = bytes_0;
        bytes_0 = new byte[field303 * field303];
        int_0 = 0;

        for (int_1 = field303 - 1; int_1 >= 0; --int_1) {
            for (int_2 = field303 - 1; int_2 >= 0; --int_2) {
                if (int_2 >= (int_1 << 1)) {
                    bytes_0[int_0] = -1;
                }

                ++int_0;
            }
        }

        field304[1][3] = bytes_0;
    }

    void method607() {
        byte[] bytes_0 = new byte[field303 * field303];
        int int_0 = 0;

        int int_1;
        int int_2;
        for (int_1 = field303 - 1; int_1 >= 0; --int_1) {
            for (int_2 = field303 - 1; int_2 >= 0; --int_2) {
                if (int_2 <= (int_1 >> 1)) {
                    bytes_0[int_0] = -1;
                }

                ++int_0;
            }
        }

        field304[2][0] = bytes_0;
        bytes_0 = new byte[field303 * field303];
        int_0 = 0;

        for (int_1 = field303 - 1; int_1 >= 0; --int_1) {
            for (int_2 = 0; int_2 < field303; int_2++) {
                if (int_2 >= (int_1 << 1)) {
                    bytes_0[int_0] = -1;
                }

                ++int_0;
            }
        }

        field304[2][1] = bytes_0;
        bytes_0 = new byte[field303 * field303];
        int_0 = 0;

        for (int_1 = 0; int_1 < field303; int_1++) {
            for (int_2 = 0; int_2 < field303; int_2++) {
                if (int_2 <= (int_1 >> 1)) {
                    bytes_0[int_0] = -1;
                }

                ++int_0;
            }
        }

        field304[2][2] = bytes_0;
        bytes_0 = new byte[field303 * field303];
        int_0 = 0;

        for (int_1 = 0; int_1 < field303; int_1++) {
            for (int_2 = field303 - 1; int_2 >= 0; --int_2) {
                if (int_2 >= (int_1 << 1)) {
                    bytes_0[int_0] = -1;
                }

                ++int_0;
            }
        }

        field304[2][3] = bytes_0;
    }

    void method596() {
        byte[] bytes_0 = new byte[field303 * field303];
        int int_0 = 0;

        int int_1;
        int int_2;
        for (int_1 = field303 - 1; int_1 >= 0; --int_1) {
            for (int_2 = 0; int_2 < field303; int_2++) {
                if (int_2 >= (int_1 >> 1)) {
                    bytes_0[int_0] = -1;
                }

                ++int_0;
            }
        }

        field304[3][0] = bytes_0;
        bytes_0 = new byte[field303 * field303];
        int_0 = 0;

        for (int_1 = 0; int_1 < field303; int_1++) {
            for (int_2 = 0; int_2 < field303; int_2++) {
                if (int_2 <= (int_1 << 1)) {
                    bytes_0[int_0] = -1;
                }

                ++int_0;
            }
        }

        field304[3][1] = bytes_0;
        bytes_0 = new byte[field303 * field303];
        int_0 = 0;

        for (int_1 = 0; int_1 < field303; int_1++) {
            for (int_2 = field303 - 1; int_2 >= 0; --int_2) {
                if (int_2 >= (int_1 >> 1)) {
                    bytes_0[int_0] = -1;
                }

                ++int_0;
            }
        }

        field304[3][2] = bytes_0;
        bytes_0 = new byte[field303 * field303];
        int_0 = 0;

        for (int_1 = field303 - 1; int_1 >= 0; --int_1) {
            for (int_2 = field303 - 1; int_2 >= 0; --int_2) {
                if (int_2 <= (int_1 << 1)) {
                    bytes_0[int_0] = -1;
                }

                ++int_0;
            }
        }

        field304[3][3] = bytes_0;
    }

    void method612() {
        byte[] bytes_0 = new byte[field303 * field303];
        int int_0 = 0;

        int int_1;
        int int_2;
        for (int_1 = field303 - 1; int_1 >= 0; --int_1) {
            for (int_2 = field303 - 1; int_2 >= 0; --int_2) {
                if (int_2 >= (int_1 >> 1)) {
                    bytes_0[int_0] = -1;
                }

                ++int_0;
            }
        }

        field304[4][0] = bytes_0;
        bytes_0 = new byte[field303 * field303];
        int_0 = 0;

        for (int_1 = field303 - 1; int_1 >= 0; --int_1) {
            for (int_2 = 0; int_2 < field303; int_2++) {
                if (int_2 <= (int_1 << 1)) {
                    bytes_0[int_0] = -1;
                }

                ++int_0;
            }
        }

        field304[4][1] = bytes_0;
        bytes_0 = new byte[field303 * field303];
        int_0 = 0;

        for (int_1 = 0; int_1 < field303; int_1++) {
            for (int_2 = 0; int_2 < field303; int_2++) {
                if (int_2 >= (int_1 >> 1)) {
                    bytes_0[int_0] = -1;
                }

                ++int_0;
            }
        }

        field304[4][2] = bytes_0;
        bytes_0 = new byte[field303 * field303];
        int_0 = 0;

        for (int_1 = 0; int_1 < field303; int_1++) {
            for (int_2 = field303 - 1; int_2 >= 0; --int_2) {
                if (int_2 <= (int_1 << 1)) {
                    bytes_0[int_0] = -1;
                }

                ++int_0;
            }
        }

        field304[4][3] = bytes_0;
    }

    void method598() {
        byte[] bytes_0 = new byte[field303 * field303];
        bytes_0 = new byte[field303 * field303];
        int int_2 = 0;

        int int_0;
        int int_1;
        for (int_0 = 0; int_0 < field303; int_0++) {
            for (int_1 = 0; int_1 < field303; int_1++) {
                if (int_1 <= (field303 / 2)) {
                    bytes_0[int_2] = -1;
                }

                ++int_2;
            }
        }

        field304[5][0] = bytes_0;
        bytes_0 = new byte[field303 * field303];
        int_2 = 0;

        for (int_0 = 0; int_0 < field303; int_0++) {
            for (int_1 = 0; int_1 < field303; int_1++) {
                if (int_0 <= (field303 / 2)) {
                    bytes_0[int_2] = -1;
                }

                ++int_2;
            }
        }

        field304[5][1] = bytes_0;
        bytes_0 = new byte[field303 * field303];
        int_2 = 0;

        for (int_0 = 0; int_0 < field303; int_0++) {
            for (int_1 = 0; int_1 < field303; int_1++) {
                if (int_1 >= (field303 / 2)) {
                    bytes_0[int_2] = -1;
                }

                ++int_2;
            }
        }

        field304[5][2] = bytes_0;
        bytes_0 = new byte[field303 * field303];
        int_2 = 0;

        for (int_0 = 0; int_0 < field303; int_0++) {
            for (int_1 = 0; int_1 < field303; int_1++) {
                if (int_0 >= (field303 / 2)) {
                    bytes_0[int_2] = -1;
                }

                ++int_2;
            }
        }

        field304[5][3] = bytes_0;
    }

    void method629() {
        byte[] bytes_0 = new byte[field303 * field303];
        bytes_0 = new byte[field303 * field303];
        int int_2 = 0;

        int int_0;
        int int_1;
        for (int_0 = 0; int_0 < field303; int_0++) {
            for (int_1 = 0; int_1 < field303; int_1++) {
                if (int_1 <= (int_0 - (field303 / 2))) {
                    bytes_0[int_2] = -1;
                }

                ++int_2;
            }
        }

        field304[6][0] = bytes_0;
        bytes_0 = new byte[field303 * field303];
        int_2 = 0;

        for (int_0 = field303 - 1; int_0 >= 0; --int_0) {
            for (int_1 = 0; int_1 < field303; int_1++) {
                if (int_1 <= (int_0 - (field303 / 2))) {
                    bytes_0[int_2] = -1;
                }

                ++int_2;
            }
        }

        field304[6][1] = bytes_0;
        bytes_0 = new byte[field303 * field303];
        int_2 = 0;

        for (int_0 = field303 - 1; int_0 >= 0; --int_0) {
            for (int_1 = field303 - 1; int_1 >= 0; --int_1) {
                if (int_1 <= (int_0 - (field303 / 2))) {
                    bytes_0[int_2] = -1;
                }

                ++int_2;
            }
        }

        field304[6][2] = bytes_0;
        bytes_0 = new byte[field303 * field303];
        int_2 = 0;

        for (int_0 = 0; int_0 < field303; int_0++) {
            for (int_1 = field303 - 1; int_1 >= 0; --int_1) {
                if (int_1 <= (int_0 - (field303 / 2))) {
                    bytes_0[int_2] = -1;
                }

                ++int_2;
            }
        }

        field304[6][3] = bytes_0;
    }

    void method595() {
        byte[] bytes_0 = new byte[field303 * field303];
        bytes_0 = new byte[field303 * field303];
        int int_2 = 0;

        int int_0;
        int int_1;
        for (int_0 = 0; int_0 < field303; int_0++) {
            for (int_1 = 0; int_1 < field303; int_1++) {
                if (int_1 >= (int_0 - (field303 / 2))) {
                    bytes_0[int_2] = -1;
                }

                ++int_2;
            }
        }

        field304[7][0] = bytes_0;
        bytes_0 = new byte[field303 * field303];
        int_2 = 0;

        for (int_0 = field303 - 1; int_0 >= 0; --int_0) {
            for (int_1 = 0; int_1 < field303; int_1++) {
                if (int_1 >= (int_0 - (field303 / 2))) {
                    bytes_0[int_2] = -1;
                }

                ++int_2;
            }
        }

        field304[7][1] = bytes_0;
        bytes_0 = new byte[field303 * field303];
        int_2 = 0;

        for (int_0 = field303 - 1; int_0 >= 0; --int_0) {
            for (int_1 = field303 - 1; int_1 >= 0; --int_1) {
                if (int_1 >= (int_0 - (field303 / 2))) {
                    bytes_0[int_2] = -1;
                }

                ++int_2;
            }
        }

        field304[7][2] = bytes_0;
        bytes_0 = new byte[field303 * field303];
        int_2 = 0;

        for (int_0 = 0; int_0 < field303; int_0++) {
            for (int_1 = field303 - 1; int_1 >= 0; --int_1) {
                if (int_1 >= (int_0 - (field303 / 2))) {
                    bytes_0[int_2] = -1;
                }

                ++int_2;
            }
        }

        field304[7][3] = bytes_0;
    }

    static void method609(final Actor actor_0) {
        actor_0.poseAnimation = actor_0.idlePoseAnimation;
        if (actor_0.queueSize == 0) {
            actor_0.field923 = 0;
        } else {
            if ((actor_0.animation != -1) && (actor_0.actionAnimationDisable == 0)) {
                final Sequence sequence_0 = TotalQuantityComparator.getAnimation(actor_0.animation);
                if ((actor_0.field930 > 0) && (sequence_0.precedenceAnimating == 0)) {
                    ++actor_0.field923;
                    return;
                }

                if ((actor_0.field930 <= 0) && (sequence_0.priority == 0)) {
                    ++actor_0.field923;
                    return;
                }
            }

            final int int_0 = actor_0.x;
            final int int_1 = actor_0.y;
            final int int_2 = (actor_0.pathX[actor_0.queueSize - 1] * 128) + (actor_0.field874 * 64);
            final int int_3 = (actor_0.pathY[actor_0.queueSize - 1] * 128) + (actor_0.field874 * 64);
            if (int_0 < int_2) {
                if (int_1 < int_3) {
                    actor_0.orientation = 1280;
                } else if (int_1 > int_3) {
                    actor_0.orientation = 1792;
                } else {
                    actor_0.orientation = 1536;
                }
            } else if (int_0 > int_2) {
                if (int_1 < int_3) {
                    actor_0.orientation = 768;
                } else if (int_1 > int_3) {
                    actor_0.orientation = 256;
                } else {
                    actor_0.orientation = 512;
                }
            } else if (int_1 < int_3) {
                actor_0.orientation = 1024;
            } else if (int_1 > int_3) {
                actor_0.orientation = 0;
            }

            final byte byte_0 = actor_0.pathTraversed[actor_0.queueSize - 1];
            if (((int_2 - int_0) <= 256) && ((int_2 - int_0) >= -256) && ((int_3 - int_1) <= 256)
                    && ((int_3 - int_1) >= -256)) {
                int int_4 = (actor_0.orientation - actor_0.angle) & 0x7FF;
                if (int_4 > 1024) {
                    int_4 -= 2048;
                }

                int int_5 = actor_0.field880;
                if ((int_4 >= -256) && (int_4 <= 256)) {
                    int_5 = actor_0.field899;
                } else if ((int_4 >= 256) && (int_4 < 768)) {
                    int_5 = actor_0.field882;
                } else if ((int_4 >= -768) && (int_4 <= -256)) {
                    int_5 = actor_0.field870;
                }

                if (int_5 == -1) {
                    int_5 = actor_0.field899;
                }

                actor_0.poseAnimation = int_5;
                int int_6 = 4;
                boolean bool_0 = true;
                if (actor_0 instanceof NPC) {
                    bool_0 = ((NPC) actor_0).composition.isClickable;
                }

                if (bool_0) {
                    if ((actor_0.orientation != actor_0.angle) && (actor_0.interacting == -1)
                            && (actor_0.field924 != 0)) {
                        int_6 = 2;
                    }

                    if (actor_0.queueSize > 2) {
                        int_6 = 6;
                    }

                    if (actor_0.queueSize > 3) {
                        int_6 = 8;
                    }

                    if ((actor_0.field923 > 0) && (actor_0.queueSize > 1)) {
                        int_6 = 8;
                        --actor_0.field923;
                    }
                } else {
                    if (actor_0.queueSize > 1) {
                        int_6 = 6;
                    }

                    if (actor_0.queueSize > 2) {
                        int_6 = 8;
                    }

                    if ((actor_0.field923 > 0) && (actor_0.queueSize > 1)) {
                        int_6 = 8;
                        --actor_0.field923;
                    }
                }

                if (byte_0 == 2) {
                    int_6 <<= 1;
                }

                if ((int_6 >= 8) && (actor_0.field899 == actor_0.poseAnimation) && (actor_0.field883 != -1)) {
                    actor_0.poseAnimation = actor_0.field883;
                }

                if ((int_0 != int_2) || (int_1 != int_3)) {
                    if (int_0 < int_2) {
                        actor_0.x += int_6;
                        if (actor_0.x > int_2) {
                            actor_0.x = int_2;
                        }
                    } else if (int_0 > int_2) {
                        actor_0.x -= int_6;
                        if (actor_0.x < int_2) {
                            actor_0.x = int_2;
                        }
                    }

                    if (int_1 < int_3) {
                        actor_0.y += int_6;
                        if (actor_0.y > int_3) {
                            actor_0.y = int_3;
                        }
                    } else if (int_1 > int_3) {
                        actor_0.y -= int_6;
                        if (actor_0.y < int_3) {
                            actor_0.y = int_3;
                        }
                    }
                }

                if ((int_2 == actor_0.x) && (int_3 == actor_0.y)) {
                    --actor_0.queueSize;
                    if (actor_0.field930 > 0) {
                        --actor_0.field930;
                    }
                }

            } else {
                actor_0.x = int_2;
                actor_0.y = int_3;
                --actor_0.queueSize;
                if (actor_0.field930 > 0) {
                    --actor_0.field930;
                }

            }
        }
    }

    static void draw2DExtras(final Actor actor_0, final int int_0, final int int_1, final int int_2, final int int_3,
                             final int int_4) {
        if ((actor_0 != null) && actor_0.hasConfig()) {
            if (actor_0 instanceof NPC) {
                NPCComposition npccomposition_0 = ((NPC) actor_0).composition;
                if (npccomposition_0.configs != null) {
                    npccomposition_0 = npccomposition_0.transform();
                }

                if (npccomposition_0 == null) {
                    return;
                }
            }

            final int int_5 = class81.playerIndexesCount;
            final int[] ints_0 = class81.playerIndices;
            byte byte_0 = 0;
            Player player_0;
            if ((int_0 < int_5) && (actor_0.field889 == Game.gameCycle)) {
                player_0 = (Player) actor_0;
                boolean bool_0;
                if (Game.playerNameMask == 0) {
                    bool_0 = false;
                } else {
                    boolean bool_2;
                    if (player_0 == class138.localPlayer) {
                        bool_2 = (Game.playerNameMask & 0x8) != 0;
                        bool_0 = bool_2;
                    } else {
                        bool_2 = WorldMapData.method260();
                        if (!bool_2) {
                            final boolean bool_3 = (Game.playerNameMask & 0x1) != 0;
                            bool_2 = bool_3 && player_0.isFriend();
                        }

                        bool_0 = bool_2 || (MouseInput.method943() && player_0.isClanMember());
                    }
                }

                if (bool_0) {
                    final Player player_1 = (Player) actor_0;
                    if (int_0 < int_5) {
                        MessageNode.characterToScreen(actor_0, actor_0.logicalHeight + 15);
                        final FontTypeFace fonttypeface_0 = (FontTypeFace) Game.fontsMap
                                .get(FontName.FontName_plain12);
                        final byte byte_1 = 9;
                        fonttypeface_0.drawTextCentered(player_1.name.getName(), int_1 + Game.screenX,
                                (int_2 + Game.screenY) - byte_1, 16777215, 0);
                        byte_0 = 18;
                    }
                }
            }

            int int_59 = -2;
            int int_7;
            int int_12;
            int int_13;
            if (!actor_0.combatInfoList.isEmpty()) {
                MessageNode.characterToScreen(actor_0, actor_0.logicalHeight + 15);

                for (CombatInfoListHolder combatinfolistholder_0 = (CombatInfoListHolder) actor_0.combatInfoList
                        .last(); combatinfolistholder_0 != null; combatinfolistholder_0 = (CombatInfoListHolder) actor_0.combatInfoList
                        .previous()) {
                    final CombatInfo1 combatinfo1_0 = combatinfolistholder_0.method1773(Game.gameCycle);
                    if (combatinfo1_0 == null) {
                        if (combatinfolistholder_0.method1774()) {
                            combatinfolistholder_0.unlink();
                        }
                    } else {
                        final CombatInfo2 combatinfo2_0 = combatinfolistholder_0.combatInfo2;
                        final SpritePixels spritepixels_0 = combatinfo2_0.method4918();
                        final SpritePixels spritepixels_1 = combatinfo2_0.method4917();
                        int int_6 = 0;
                        if ((spritepixels_0 != null) && (spritepixels_1 != null)) {
                            if ((combatinfo2_0.field3318 * 2) < spritepixels_1.width) {
                                int_6 = combatinfo2_0.field3318;
                            }

                            int_7 = spritepixels_1.width - (int_6 * 2);
                        } else {
                            int_7 = combatinfo2_0.healthScale;
                        }

                        int int_8 = 255;
                        final int int_9 = Game.gameCycle - combatinfo1_0.cycle;
                        final int int_10 = (int_7 * combatinfo1_0.health) / combatinfo2_0.healthScale;
                        int int_11;
                        int int_60;
                        if (combatinfo1_0.int2 > int_9) {
                            int_11 = combatinfo2_0.field3308 == 0 ? 0
                                    : combatinfo2_0.field3308 * (int_9 / combatinfo2_0.field3308);
                            int_12 = (int_7 * combatinfo1_0.healthRatio) / combatinfo2_0.healthScale;
                            int_60 = ((int_11 * (int_10 - int_12)) / combatinfo1_0.int2) + int_12;
                        } else {
                            int_60 = int_10;
                            int_11 = (combatinfo2_0.field3313 + combatinfo1_0.int2) - int_9;
                            if (combatinfo2_0.field3312 >= 0) {
                                int_8 = (int_11 << 8) / (combatinfo2_0.field3313 - combatinfo2_0.field3312);
                            }
                        }

                        if ((combatinfo1_0.health > 0) && (int_60 < 1)) {
                            int_60 = 1;
                        }

                        if ((spritepixels_0 != null) && (spritepixels_1 != null)) {
                            if (int_7 == int_60) {
                                int_60 += int_6 * 2;
                            } else {
                                int_60 += int_6;
                            }

                            int_11 = spritepixels_0.height;
                            int_59 += int_11;
                            int_12 = (int_1 + Game.screenX) - (int_7 >> 1);
                            int_13 = (int_2 + Game.screenY) - int_59;
                            int_12 -= int_6;
                            if ((int_8 >= 0) && (int_8 < 255)) {
                                spritepixels_0.drawAtOpacity(int_12, int_13, int_8);
                                Rasterizer2D.setInnerDrawRegion(int_12, int_13, int_12 + int_60, int_13 + int_11);
                                spritepixels_1.drawAtOpacity(int_12, int_13, int_8);
                            } else {
                                spritepixels_0.drawAt(int_12, int_13);
                                Rasterizer2D.setInnerDrawRegion(int_12, int_13, int_60 + int_12, int_11 + int_13);
                                spritepixels_1.drawAt(int_12, int_13);
                            }

                            Rasterizer2D.setDrawRegion(int_1, int_2, int_1 + int_3, int_2 + int_4);
                            int_59 += 2;
                        } else {
                            int_59 += 5;
                            if (Game.screenX > -1) {
                                int_11 = (int_1 + Game.screenX) - (int_7 >> 1);
                                int_12 = (int_2 + Game.screenY) - int_59;
                                Rasterizer2D.Rasterizer2D_fillRectangle(int_11, int_12, int_60, 5, 65280);
                                Rasterizer2D.Rasterizer2D_fillRectangle(int_11 + int_60, int_12, int_7 - int_60, 5,
                                        16711680);
                            }

                            int_59 += 2;
                        }
                    }
                }
            }

            if (int_59 == -2) {
                int_59 += 7;
            }

            int_59 += byte_0;
            if (int_0 < int_5) {
                player_0 = (Player) actor_0;
                if (player_0.hidden) {
                    return;
                }

                if ((player_0.skullIcon != -1) || (player_0.overheadIcon != -1)) {
                    MessageNode.characterToScreen(actor_0, actor_0.logicalHeight + 15);
                    if (Game.screenX > -1) {
                        if (player_0.skullIcon != -1) {
                            int_59 += 25;
                            MilliTimer.headIconsPk[player_0.skullIcon].drawAt((int_1 + Game.screenX) - 12,
                                    (int_2 + Game.screenY) - int_59);
                        }

                        if (player_0.overheadIcon != -1) {
                            int_59 += 25;
                            class43.headIconsPrayer[player_0.overheadIcon].drawAt((int_1 + Game.screenX) - 12,
                                    (int_2 + Game.screenY) - int_59);
                        }
                    }
                }

                if ((int_0 >= 0) && (Game.hintArrowTargetType == 10)
                        && (ints_0[int_0] == Game.hintArrowPlayerTargetIdx)) {
                    MessageNode.characterToScreen(actor_0, actor_0.logicalHeight + 15);
                    if (Game.screenX > -1) {
                        int_59 += MilliTimer.headIconsHint[1].height;
                        MilliTimer.headIconsHint[1].drawAt((int_1 + Game.screenX) - 12,
                                (int_2 + Game.screenY) - int_59);
                    }
                }
            } else {
                NPCComposition npccomposition_1 = ((NPC) actor_0).composition;
                if (npccomposition_1.configs != null) {
                    npccomposition_1 = npccomposition_1.transform();
                }

                if ((npccomposition_1.headIcon >= 0) && (npccomposition_1.headIcon < class43.headIconsPrayer.length)) {
                    MessageNode.characterToScreen(actor_0, actor_0.logicalHeight + 15);
                    if (Game.screenX > -1) {
                        class43.headIconsPrayer[npccomposition_1.headIcon].drawAt((int_1 + Game.screenX) - 12,
                                (int_2 + Game.screenY) - 30);
                    }
                }

                if ((Game.hintArrowTargetType == 1)
                        && (Game.npcIndices[int_0 - int_5] == Game.hintArrowNpcTargetIdx)
                        && ((Game.gameCycle % 20) < 10)) {
                    MessageNode.characterToScreen(actor_0, actor_0.logicalHeight + 15);
                    if (Game.screenX > -1) {
                        MilliTimer.headIconsHint[0].drawAt((int_1 + Game.screenX) - 12,
                                (int_2 + Game.screenY) - 28);
                    }
                }
            }

            if ((actor_0.overhead != null) && ((int_0 >= int_5) || (!actor_0.field886 && ((Game.publicChatMode == 4)
                    || (!actor_0.field885 && ((Game.publicChatMode == 0) || (Game.publicChatMode == 3)
                    || ((Game.publicChatMode == 1) && ((Player) actor_0).isFriend()))))))) {
                MessageNode.characterToScreen(actor_0, actor_0.logicalHeight);
                if ((Game.screenX > -1) && (Game.overheadTextCount < Game.field648)) {
                    Game.overheadTextsOffsetX[Game.overheadTextCount] = ClanMemberManager.fontBold12
                            .getTextWidth(actor_0.overhead) / 2;
                    Game.overheadTextsOffsetY[Game.overheadTextCount] = ClanMemberManager.fontBold12.verticalSpace;
                    Game.overheadTextsX[Game.overheadTextCount] = Game.screenX;
                    Game.overheadTextsY[Game.overheadTextCount] = Game.screenY;
                    Game.field673[Game.overheadTextCount] = actor_0.field888;
                    Game.field674[Game.overheadTextCount] = actor_0.field927;
                    Game.overheadTextsCyclesRemaining[Game.overheadTextCount] = actor_0.overheadTextCyclesRemaining;
                    Game.overheadTexts[Game.overheadTextCount] = actor_0.overhead;
                    ++Game.overheadTextCount;
                }
            }

            for (int int_14 = 0; int_14 < 4; int_14++) {
                final int int_61 = actor_0.hitsplatCycles[int_14];
                final int int_62 = actor_0.hitsplatTypes[int_14];
                class267 class267_1 = null;
                int int_15 = 0;
                if (int_62 >= 0) {
                    if (int_61 <= Game.gameCycle) {
                        continue;
                    }

                    class267_1 = WorldMapType3.method123(actor_0.hitsplatTypes[int_14]);
                    int_15 = class267_1.field3355;
                    if ((class267_1 != null) && (class267_1.field3366 != null)) {
                        class267_1 = class267_1.method4995();
                        if (class267_1 == null) {
                            actor_0.hitsplatCycles[int_14] = -1;
                            continue;
                        }
                    }
                } else if (int_61 < 0) {
                    continue;
                }

                int_7 = actor_0.field894[int_14];
                class267 class267_0 = null;
                if (int_7 >= 0) {
                    class267_0 = WorldMapType3.method123(int_7);
                    if ((class267_0 != null) && (class267_0.field3366 != null)) {
                        class267_0 = class267_0.method4995();
                    }
                }

                if ((int_61 - int_15) <= Game.gameCycle) {
                    if (class267_1 == null) {
                        actor_0.hitsplatCycles[int_14] = -1;
                    } else {
                        MessageNode.characterToScreen(actor_0, actor_0.logicalHeight / 2);
                        if (Game.screenX > -1) {
                            if (int_14 == 1) {
                                Game.screenY -= 20;
                            }

                            if (int_14 == 2) {
                                Game.screenX -= 15;
                                Game.screenY -= 10;
                            }

                            if (int_14 == 3) {
                                Game.screenX += 15;
                                Game.screenY -= 10;
                            }

                            SpritePixels spritepixels_2 = null;
                            SpritePixels spritepixels_3 = null;
                            SpritePixels spritepixels_4 = null;
                            SpritePixels spritepixels_5 = null;
                            int_12 = 0;
                            int_13 = 0;
                            int int_16 = 0;
                            int int_17 = 0;
                            int int_18 = 0;
                            int int_19 = 0;
                            int int_20 = 0;
                            int int_21 = 0;
                            SpritePixels spritepixels_6 = null;
                            SpritePixels spritepixels_7 = null;
                            SpritePixels spritepixels_8 = null;
                            SpritePixels spritepixels_9 = null;
                            int int_22 = 0;
                            int int_23 = 0;
                            int int_24 = 0;
                            int int_25 = 0;
                            int int_26 = 0;
                            int int_27 = 0;
                            int int_28 = 0;
                            int int_29 = 0;
                            int int_30 = 0;
                            spritepixels_2 = class267_1.method4994();
                            int int_31;
                            if (spritepixels_2 != null) {
                                int_12 = spritepixels_2.width;
                                int_31 = spritepixels_2.height;
                                if (int_31 > int_30) {
                                    int_30 = int_31;
                                }

                                int_18 = spritepixels_2.offsetX;
                            }

                            spritepixels_3 = class267_1.method5000();
                            if (spritepixels_3 != null) {
                                int_13 = spritepixels_3.width;
                                int_31 = spritepixels_3.height;
                                if (int_31 > int_30) {
                                    int_30 = int_31;
                                }

                                int_19 = spritepixels_3.offsetX;
                            }

                            spritepixels_4 = class267_1.method4996();
                            if (spritepixels_4 != null) {
                                int_16 = spritepixels_4.width;
                                int_31 = spritepixels_4.height;
                                if (int_31 > int_30) {
                                    int_30 = int_31;
                                }

                                int_20 = spritepixels_4.offsetX;
                            }

                            spritepixels_5 = class267_1.method4997();
                            if (spritepixels_5 != null) {
                                int_17 = spritepixels_5.width;
                                int_31 = spritepixels_5.height;
                                if (int_31 > int_30) {
                                    int_30 = int_31;
                                }

                                int_21 = spritepixels_5.offsetX;
                            }

                            if (class267_0 != null) {
                                spritepixels_6 = class267_0.method4994();
                                if (spritepixels_6 != null) {
                                    int_22 = spritepixels_6.width;
                                    int_31 = spritepixels_6.height;
                                    if (int_31 > int_30) {
                                        int_30 = int_31;
                                    }

                                    int_26 = spritepixels_6.offsetX;
                                }

                                spritepixels_7 = class267_0.method5000();
                                if (spritepixels_7 != null) {
                                    int_23 = spritepixels_7.width;
                                    int_31 = spritepixels_7.height;
                                    if (int_31 > int_30) {
                                        int_30 = int_31;
                                    }

                                    int_27 = spritepixels_7.offsetX;
                                }

                                spritepixels_8 = class267_0.method4996();
                                if (spritepixels_8 != null) {
                                    int_24 = spritepixels_8.width;
                                    int_31 = spritepixels_8.height;
                                    if (int_31 > int_30) {
                                        int_30 = int_31;
                                    }

                                    int_28 = spritepixels_8.offsetX;
                                }

                                spritepixels_9 = class267_0.method4997();
                                if (spritepixels_9 != null) {
                                    int_25 = spritepixels_9.width;
                                    int_31 = spritepixels_9.height;
                                    if (int_31 > int_30) {
                                        int_30 = int_31;
                                    }

                                    int_29 = spritepixels_9.offsetX;
                                }
                            }

                            Font font_0 = class267_1.method4998();
                            if (font_0 == null) {
                                font_0 = class151.fontPlain11;
                            }

                            Font font_1;
                            if (class267_0 != null) {
                                font_1 = class267_0.method4998();
                                if (font_1 == null) {
                                    font_1 = class151.fontPlain11;
                                }
                            } else {
                                font_1 = class151.fontPlain11;
                            }

                            String string_0 = null;
                            String string_1 = null;
                            int int_32 = 0;
                            string_0 = class267_1.method5014(actor_0.hitsplatValues[int_14]);
                            final int int_63 = font_0.getTextWidth(string_0);
                            if (class267_0 != null) {
                                string_1 = class267_0.method5014(actor_0.field921[int_14]);
                                int_32 = font_1.getTextWidth(string_1);
                            }

                            int int_33 = 0;
                            int int_34 = 0;
                            if (int_13 > 0) {
                                if ((spritepixels_4 == null) && (spritepixels_5 == null)) {
                                    int_33 = 1;
                                } else {
                                    int_33 = (int_63 / int_13) + 1;
                                }
                            }

                            if ((class267_0 != null) && (int_23 > 0)) {
                                if ((spritepixels_8 == null) && (spritepixels_9 == null)) {
                                    int_34 = 1;
                                } else {
                                    int_34 = (int_32 / int_23) + 1;
                                }
                            }

                            int int_35 = 0;
                            final int int_36 = int_35;
                            if (int_12 > 0) {
                                int_35 += int_12;
                            }

                            int_35 += 2;
                            final int int_37 = int_35;
                            if (int_16 > 0) {
                                int_35 += int_16;
                            }

                            final int int_38 = int_35;
                            int int_39 = int_35;
                            int int_40;
                            if (int_13 > 0) {
                                int_40 = int_33 * int_13;
                                int_35 += int_40;
                                int_39 += (int_40 - int_63) / 2;
                            } else {
                                int_35 += int_63;
                            }

                            int_40 = int_35;
                            if (int_17 > 0) {
                                int_35 += int_17;
                            }

                            int int_41 = 0;
                            int int_42 = 0;
                            int int_43 = 0;
                            int int_44 = 0;
                            int int_45 = 0;
                            int int_46;
                            if (class267_0 != null) {
                                int_35 += 2;
                                int_41 = int_35;
                                if (int_22 > 0) {
                                    int_35 += int_22;
                                }

                                int_35 += 2;
                                int_42 = int_35;
                                if (int_24 > 0) {
                                    int_35 += int_24;
                                }

                                int_43 = int_35;
                                int_45 = int_35;
                                if (int_23 > 0) {
                                    int_46 = int_34 * int_23;
                                    int_35 += int_46;
                                    int_45 += (int_46 - int_32) / 2;
                                } else {
                                    int_35 += int_32;
                                }

                                int_44 = int_35;
                                if (int_25 > 0) {
                                    int_35 += int_25;
                                }
                            }

                            int_46 = actor_0.hitsplatCycles[int_14] - Game.gameCycle;
                            final int int_47 = class267_1.field3365
                                    - ((int_46 * class267_1.field3365) / class267_1.field3355);
                            final int int_48 = ((int_46 * class267_1.field3361) / class267_1.field3355)
                                    + -class267_1.field3361;
                            final int int_49 = int_47 + ((int_1 + Game.screenX) - (int_35 >> 1));
                            final int int_50 = int_48 + ((int_2 + Game.screenY) - 12);
                            int int_51 = int_50;
                            int int_52 = int_50 + int_30;
                            final int int_53 = int_50 + class267_1.field3347 + 15;
                            final int int_54 = int_53 - font_0.minSpacing;
                            final int int_55 = int_53 + font_0.maxSpacing;
                            if (int_54 < int_50) {
                                int_51 = int_54;
                            }

                            if (int_55 > int_52) {
                                int_52 = int_55;
                            }

                            int int_56 = 0;
                            int int_57;
                            int int_58;
                            if (class267_0 != null) {
                                int_56 = int_50 + class267_0.field3347 + 15;
                                int_57 = int_56 - font_1.minSpacing;
                                int_58 = int_56 + font_1.maxSpacing;
                                if (int_57 < int_51) {
                                }

                                if (int_58 > int_52) {
                                }
                            }

                            int_57 = 255;
                            if (class267_1.field3354 >= 0) {
                                int_57 = (int_46 << 8) / (class267_1.field3355 - class267_1.field3354);
                            }

                            if ((int_57 >= 0) && (int_57 < 255)) {
                                if (spritepixels_2 != null) {
                                    spritepixels_2.drawAtOpacity((int_49 + int_36) - int_18, int_50, int_57);
                                }

                                if (spritepixels_4 != null) {
                                    spritepixels_4.drawAtOpacity((int_49 + int_37) - int_20, int_50, int_57);
                                }

                                if (spritepixels_3 != null) {
                                    for (int_58 = 0; int_58 < int_33; int_58++) {
                                        spritepixels_3.drawAtOpacity((int_13 * int_58) + ((int_38 + int_49) - int_19),
                                                int_50, int_57);
                                    }
                                }

                                if (spritepixels_5 != null) {
                                    spritepixels_5.drawAtOpacity((int_40 + int_49) - int_21, int_50, int_57);
                                }

                                font_0.method5523(string_0, int_49 + int_39, int_53, class267_1.field3364, 0, int_57);
                                if (class267_0 != null) {
                                    if (spritepixels_6 != null) {
                                        spritepixels_6.drawAtOpacity((int_49 + int_41) - int_26, int_50, int_57);
                                    }

                                    if (spritepixels_8 != null) {
                                        spritepixels_8.drawAtOpacity((int_42 + int_49) - int_28, int_50, int_57);
                                    }

                                    if (spritepixels_7 != null) {
                                        for (int_58 = 0; int_58 < int_34; int_58++) {
                                            spritepixels_7.drawAtOpacity(
                                                    (int_58 * int_23) + ((int_43 + int_49) - int_27), int_50, int_57);
                                        }
                                    }

                                    if (spritepixels_9 != null) {
                                        spritepixels_9.drawAtOpacity((int_49 + int_44) - int_29, int_50, int_57);
                                    }

                                    font_1.method5523(string_1, int_45 + int_49, int_56, class267_0.field3364, 0,
                                            int_57);
                                }
                            } else {
                                if (spritepixels_2 != null) {
                                    spritepixels_2.drawAt((int_49 + int_36) - int_18, int_50);
                                }

                                if (spritepixels_4 != null) {
                                    spritepixels_4.drawAt((int_49 + int_37) - int_20, int_50);
                                }

                                if (spritepixels_3 != null) {
                                    for (int_58 = 0; int_58 < int_33; int_58++) {
                                        spritepixels_3.drawAt((int_13 * int_58) + ((int_49 + int_38) - int_19), int_50);
                                    }
                                }

                                if (spritepixels_5 != null) {
                                    spritepixels_5.drawAt((int_49 + int_40) - int_21, int_50);
                                }

                                font_0.method5522(string_0, int_49 + int_39, int_53, class267_1.field3364 | 0xFF000000,
                                        0);
                                if (class267_0 != null) {
                                    if (spritepixels_6 != null) {
                                        spritepixels_6.drawAt((int_41 + int_49) - int_26, int_50);
                                    }

                                    if (spritepixels_8 != null) {
                                        spritepixels_8.drawAt((int_42 + int_49) - int_28, int_50);
                                    }

                                    if (spritepixels_7 != null) {
                                        for (int_58 = 0; int_58 < int_34; int_58++) {
                                            spritepixels_7.drawAt((int_58 * int_23) + ((int_43 + int_49) - int_27),
                                                    int_50);
                                        }
                                    }

                                    if (spritepixels_9 != null) {
                                        spritepixels_9.drawAt((int_44 + int_49) - int_29, int_50);
                                    }

                                    font_1.method5522(string_1, int_49 + int_45, int_56,
                                            class267_0.field3364 | 0xFF000000, 0);
                                }
                            }
                        }
                    }
                }
            }

        }
    }

    static void method630(final int int_0, final int int_1, final int int_2, final int int_3, final int int_4,
                          final int int_5, final int int_6, final int int_7) {
        if (CombatInfo2.loadWidget(int_0)) {
            Occluder.field1814 = null;
            MapIcon.gameDraw(GameCanvas.widgets[int_0], -1, int_1, int_2, int_3, int_4, int_5, int_6, int_7);
            if (Occluder.field1814 != null) {
                MapIcon.gameDraw(Occluder.field1814, -1412584499, int_1, int_2, int_3, int_4, class297.field3687,
                        GrandExchangeEvents.field15, int_7);
                Occluder.field1814 = null;
            }

        } else {
            if (int_7 != -1) {
                Game.field697[int_7] = true;
            } else {
                for (int int_8 = 0; int_8 < 100; int_8++) {
                    Game.field697[int_8] = true;
                }
            }

        }
    }

    static String method623(final int int_0) {
        String string_0 = Integer.toString(int_0);

        for (int int_1 = string_0.length() - 3; int_1 > 0; int_1 -= 3) {
            string_0 = string_0.substring(0, int_1) + "," + string_0.substring(int_1);
        }

        return string_0.length() > 9
                ? " " + class6.getColTags(65408) + string_0.substring(0, string_0.length() - 8) + "M" + " " + " ("
                + string_0 + ")" + "</col>"
                : (string_0.length() > 6
                ? " " + class6.getColTags(16777215) + string_0.substring(0, string_0.length() - 4) + "K" + " "
                + " (" + string_0 + ")" + "</col>"
                : " " + class6.getColTags(16776960) + string_0 + "</col>");
    }

}
