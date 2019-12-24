public class Sequence extends CacheableNode {

    public static IndexDataBase seq_ref;
    public static IndexDataBase skel_ref;
    public static IndexDataBase skin_ref;
    public static NodeCache sequences;
    public static NodeCache skeletons;
    public int[] frameIDs;
    int[] field3542;
    public int[] frameLengths;
    public int[] field3543;
    public int frameStep;
    int[] interleaveLeave;
    public boolean stretches;
    public int forcedPriority;
    public int leftHandItem;
    public int rightHandItem;
    public int maxLoops;
    public int precedenceAnimating;
    public int priority;
    public int replyMode;

    static {
        sequences = new NodeCache(64);
        skeletons = new NodeCache(100);
    }

    Sequence() {
        frameStep = -1;
        stretches = false;
        forcedPriority = 5;
        leftHandItem = -1;
        rightHandItem = -1;
        maxLoops = 99;
        precedenceAnimating = -1;
        priority = -1;
        replyMode = 2;
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

    void readNext(final Buffer buffer_0, final int int_0) {
        int int_1;
        int int_2;
        if (int_0 == 1) {
            int_1 = buffer_0.readUnsignedShort();
            frameLengths = new int[int_1];

            for (int_2 = 0; int_2 < int_1; int_2++) {
                frameLengths[int_2] = buffer_0.readUnsignedShort();
            }

            frameIDs = new int[int_1];

            for (int_2 = 0; int_2 < int_1; int_2++) {
                frameIDs[int_2] = buffer_0.readUnsignedShort();
            }

            for (int_2 = 0; int_2 < int_1; int_2++) {
                frameIDs[int_2] += buffer_0.readUnsignedShort() << 16;
            }
        } else if (int_0 == 2) {
            frameStep = buffer_0.readUnsignedShort();
        } else if (int_0 == 3) {
            int_1 = buffer_0.readUnsignedByte();
            interleaveLeave = new int[int_1 + 1];

            for (int_2 = 0; int_2 < int_1; int_2++) {
                interleaveLeave[int_2] = buffer_0.readUnsignedByte();
            }

            interleaveLeave[int_1] = 9999999;
        } else if (int_0 == 4) {
            stretches = true;
        } else if (int_0 == 5) {
            forcedPriority = buffer_0.readUnsignedByte();
        } else if (int_0 == 6) {
            leftHandItem = buffer_0.readUnsignedShort();
        } else if (int_0 == 7) {
            rightHandItem = buffer_0.readUnsignedShort();
        } else if (int_0 == 8) {
            maxLoops = buffer_0.readUnsignedByte();
        } else if (int_0 == 9) {
            precedenceAnimating = buffer_0.readUnsignedByte();
        } else if (int_0 == 10) {
            priority = buffer_0.readUnsignedByte();
        } else if (int_0 == 11) {
            replyMode = buffer_0.readUnsignedByte();
        } else if (int_0 == 12) {
            int_1 = buffer_0.readUnsignedByte();
            field3542 = new int[int_1];

            for (int_2 = 0; int_2 < int_1; int_2++) {
                field3542[int_2] = buffer_0.readUnsignedShort();
            }

            for (int_2 = 0; int_2 < int_1; int_2++) {
                field3542[int_2] += buffer_0.readUnsignedShort() << 16;
            }
        } else if (int_0 == 13) {
            int_1 = buffer_0.readUnsignedByte();
            field3543 = new int[int_1];

            for (int_2 = 0; int_2 < int_1; int_2++) {
                field3543[int_2] = buffer_0.read24BitInt();
            }
        }

    }

    void post() {
        if (precedenceAnimating == -1) {
            if (interleaveLeave != null) {
                precedenceAnimating = 2;
            } else {
                precedenceAnimating = 0;
            }
        }

        if (priority == -1) {
            if (interleaveLeave != null) {
                priority = 2;
            } else {
                priority = 0;
            }
        }

    }

    public Model transformActorModel(final Model model_0, int int_0) {
        int_0 = frameIDs[int_0];
        final Frames frames_0 = WorldMapDecoration.getFrames(int_0 >> 16);
        int_0 &= 0xFFFF;
        if (frames_0 == null) {
            return model_0.toSharedModel(true);
        } else {
            final Model model_1 = model_0.toSharedModel(!frames_0.method3075(int_0));
            model_1.method2724(frames_0, int_0);
            return model_1;
        }
    }

    Model transformObjectModel(final Model model_0, int int_0, int int_1) {
        int_0 = frameIDs[int_0];
        final Frames frames_0 = WorldMapDecoration.getFrames(int_0 >> 16);
        int_0 &= 0xFFFF;
        if (frames_0 == null) {
            return model_0.toSharedModel(true);
        } else {
            final Model model_1 = model_0.toSharedModel(!frames_0.method3075(int_0));
            int_1 &= 0x3;
            if (int_1 == 1) {
                model_1.rotateY270Ccw();
            } else if (int_1 == 2) {
                model_1.rotateY180Ccw();
            } else if (int_1 == 3) {
                model_1.rotateY90Ccw();
            }

            model_1.method2724(frames_0, int_0);
            if (int_1 == 1) {
                model_1.rotateY90Ccw();
            } else if (int_1 == 2) {
                model_1.rotateY180Ccw();
            } else if (int_1 == 3) {
                model_1.rotateY270Ccw();
            }

            return model_1;
        }
    }

    Model transformSpotAnimModel(final Model model_0, int int_0) {
        int_0 = frameIDs[int_0];
        final Frames frames_0 = WorldMapDecoration.getFrames(int_0 >> 16);
        int_0 &= 0xFFFF;
        if (frames_0 == null) {
            return model_0.toSharedSpotAnimModel(true);
        } else {
            final Model model_1 = model_0.toSharedSpotAnimModel(!frames_0.method3075(int_0));
            model_1.method2724(frames_0, int_0);
            return model_1;
        }
    }

    public Model applyTransformations(final Model model_0, int int_0, final Sequence sequence_1, int int_1) {
        int_0 = frameIDs[int_0];
        final Frames frames_0 = WorldMapDecoration.getFrames(int_0 >> 16);
        int_0 &= 0xFFFF;
        if (frames_0 == null) {
            return sequence_1.transformActorModel(model_0, int_1);
        } else {
            int_1 = sequence_1.frameIDs[int_1];
            final Frames frames_1 = WorldMapDecoration.getFrames(int_1 >> 16);
            int_1 &= 0xFFFF;
            Model model_1;
            if (frames_1 == null) {
                model_1 = model_0.toSharedModel(!frames_0.method3075(int_0));
                model_1.method2724(frames_0, int_0);
                return model_1;
            } else {
                model_1 = model_0.toSharedModel(!frames_0.method3075(int_0) & !frames_1.method3075(int_1));
                model_1.method2745(frames_0, int_0, frames_1, int_1, interleaveLeave);
                return model_1;
            }
        }
    }

    public Model method5219(final Model model_0, final int int_0) {
        int int_1 = frameIDs[int_0];
        final Frames frames_0 = WorldMapDecoration.getFrames(int_1 >> 16);
        int_1 &= 0xFFFF;
        if (frames_0 == null) {
            return model_0.toSharedModel(true);
        } else {
            Frames frames_1 = null;
            int int_2 = 0;
            if ((field3542 != null) && (int_0 < field3542.length)) {
                int_2 = field3542[int_0];
                frames_1 = WorldMapDecoration.getFrames(int_2 >> 16);
                int_2 &= 0xFFFF;
            }

            Model model_1;
            if ((frames_1 != null) && (int_2 != 65535)) {
                model_1 = model_0.toSharedModel(!frames_0.method3075(int_1) & !frames_1.method3075(int_2));
                model_1.method2724(frames_0, int_1);
                model_1.method2724(frames_1, int_2);
                return model_1;
            } else {
                model_1 = model_0.toSharedModel(!frames_0.method3075(int_1));
                model_1.method2724(frames_0, int_1);
                return model_1;
            }
        }
    }

    static void drawLoginScreen(final Font font_0, final Font font_1, final Font font_2, final boolean bool_0) {
        if (bool_0) {
            class78.field1082 = (Varcs.canvasWidth - 765) / 2;
            class78.loginWindowX = class78.field1082 + 202;
            class78.field1091 = class78.loginWindowX + 180;
            Game.drawSnow();
        }

        byte byte_0;
        int int_0;
        int int_1;
        int int_2;
        int int_3;
        int int_4;
        int int_8;
        int int_9;
        int int_10;
        int int_11;
        int int_12;
        if (class78.worldSelectShown) {
            if (class166.field2047 == null) {
                class166.field2047 = class21.getSprites(GZipDecompressor.indexSprites, "sl_back", "");
            }

            if (class13.slFlagSprites == null) {
                class13.slFlagSprites = class13.getIndexedSprites(GZipDecompressor.indexSprites, "sl_flags", "");
            }

            if (class126.slArrowSprites == null) {
                class126.slArrowSprites = class13.getIndexedSprites(GZipDecompressor.indexSprites, "sl_arrows", "");
            }

            if (MapIcon.slStarSprites == null) {
                MapIcon.slStarSprites = class13.getIndexedSprites(GZipDecompressor.indexSprites, "sl_stars", "");
            }

            Rasterizer2D.Rasterizer2D_fillRectangle(class78.field1082, 23, 765, 480, 0);
            Rasterizer2D.method5748(class78.field1082, 0, 125, 23, 12425273, 9135624);
            Rasterizer2D.method5748(class78.field1082 + 125, 0, 640, 23, 5197647, 2697513);
            font_0.drawTextCentered("Select a world", class78.field1082 + 62, 15, 0, -1);
            if (MapIcon.slStarSprites != null) {
                MapIcon.slStarSprites[1].method5829(class78.field1082 + 140, 1);
                font_1.method5522("Members only world", class78.field1082 + 152, 10, 16777215, -1);
                MapIcon.slStarSprites[0].method5829(class78.field1082 + 140, 12);
                font_1.method5522("Free world", class78.field1082 + 152, 21, 16777215, -1);
            }

            if (class126.slArrowSprites != null) {
                int_8 = class78.field1082 + 280;
                if ((World.field946[0] == 0) && (World.field939[0] == 0)) {
                    class126.slArrowSprites[2].method5829(int_8, 4);
                } else {
                    class126.slArrowSprites[0].method5829(int_8, 4);
                }

                if ((World.field946[0] == 0) && (World.field939[0] == 1)) {
                    class126.slArrowSprites[3].method5829(int_8 + 15, 4);
                } else {
                    class126.slArrowSprites[1].method5829(int_8 + 15, 4);
                }

                font_0.method5522("World", int_8 + 32, 17, 16777215, -1);
                int_0 = class78.field1082 + 390;
                if ((World.field946[0] == 1) && (World.field939[0] == 0)) {
                    class126.slArrowSprites[2].method5829(int_0, 4);
                } else {
                    class126.slArrowSprites[0].method5829(int_0, 4);
                }

                if ((World.field946[0] == 1) && (World.field939[0] == 1)) {
                    class126.slArrowSprites[3].method5829(int_0 + 15, 4);
                } else {
                    class126.slArrowSprites[1].method5829(int_0 + 15, 4);
                }

                font_0.method5522("Players", int_0 + 32, 17, 16777215, -1);
                int_9 = class78.field1082 + 500;
                if ((World.field946[0] == 2) && (World.field939[0] == 0)) {
                    class126.slArrowSprites[2].method5829(int_9, 4);
                } else {
                    class126.slArrowSprites[0].method5829(int_9, 4);
                }

                if ((World.field946[0] == 2) && (World.field939[0] == 1)) {
                    class126.slArrowSprites[3].method5829(int_9 + 15, 4);
                } else {
                    class126.slArrowSprites[1].method5829(int_9 + 15, 4);
                }

                font_0.method5522("Location", int_9 + 32, 17, 16777215, -1);
                int_1 = class78.field1082 + 610;
                if ((World.field946[0] == 3) && (World.field939[0] == 0)) {
                    class126.slArrowSprites[2].method5829(int_1, 4);
                } else {
                    class126.slArrowSprites[0].method5829(int_1, 4);
                }

                if ((World.field946[0] == 3) && (World.field939[0] == 1)) {
                    class126.slArrowSprites[3].method5829(int_1 + 15, 4);
                } else {
                    class126.slArrowSprites[1].method5829(int_1 + 15, 4);
                }

                font_0.method5522("Type", int_1 + 32, 17, 16777215, -1);
            }

            Rasterizer2D.Rasterizer2D_fillRectangle(class78.field1082 + 708, 4, 50, 16, 0);
            font_1.drawTextCentered("Cancel", class78.field1082 + 708 + 25, 16, 16777215, -1);
            class78.field1116 = -1;
            if (class166.field2047 != null) {
                byte_0 = 88;
                final byte byte_4 = 19;
                int_9 = 765 / (byte_0 + 1);
                int_1 = 480 / (byte_4 + 1);

                do {
                    int_2 = int_1;
                    int_10 = int_9;
                    if ((int_1 * (int_9 - 1)) >= World.worldCount) {
                        --int_9;
                    }

                    if ((int_9 * (int_1 - 1)) >= World.worldCount) {
                        --int_1;
                    }

                    if ((int_9 * (int_1 - 1)) >= World.worldCount) {
                        --int_1;
                    }
                }
                while ((int_2 != int_1) || (int_9 != int_10));

                int_2 = (765 - (byte_0 * int_9)) / (int_9 + 1);
                if (int_2 > 5) {
                    int_2 = 5;
                }

                int_10 = (480 - (byte_4 * int_1)) / (int_1 + 1);
                if (int_10 > 5) {
                    int_10 = 5;
                }

                int_11 = (765 - (byte_0 * int_9) - (int_2 * (int_9 - 1))) / 2;
                int_3 = (480 - (int_1 * byte_4) - (int_10 * (int_1 - 1))) / 2;
                int_4 = int_3 + 23;
                int_12 = int_11 + class78.field1082;
                int int_13 = 0;
                boolean bool_6 = false;

                int int_14;
                for (int_14 = 0; int_14 < World.worldCount; int_14++) {
                    final World world_0 = World.worldList[int_14];
                    boolean bool_5 = true;
                    String string_0 = Integer.toString(world_0.playerCount);
                    if (world_0.playerCount == -1) {
                        string_0 = "OFF";
                        bool_5 = false;
                    } else if (world_0.playerCount > 1980) {
                        string_0 = "FULL";
                        bool_5 = false;
                    }

                    int int_6 = 0;
                    byte byte_1;
                    if (world_0.method1577()) {
                        if (world_0.method1589()) {
                            byte_1 = 7;
                        } else {
                            byte_1 = 6;
                        }
                    } else if (world_0.method1570()) {
                        int_6 = 16711680;
                        if (world_0.method1589()) {
                            byte_1 = 5;
                        } else {
                            byte_1 = 4;
                        }
                    } else if (world_0.method1568()) {
                        if (world_0.method1589()) {
                            byte_1 = 3;
                        } else {
                            byte_1 = 2;
                        }
                    } else if (world_0.method1589()) {
                        byte_1 = 1;
                    } else {
                        byte_1 = 0;
                    }

                    if ((MouseInput.mouseLastX >= int_12) && ((MouseInput.mouseLastY * 673804999) >= int_4)
                            && (MouseInput.mouseLastX < (int_12 + byte_0))
                            && ((MouseInput.mouseLastY * 673804999) < (byte_4 + int_4)) && bool_5) {
                        class78.field1116 = int_14;
                        class166.field2047[byte_1].method5855(int_12, int_4, 128, 16777215);
                        bool_6 = true;
                    } else {
                        class166.field2047[byte_1].method5849(int_12, int_4);
                    }

                    if (class13.slFlagSprites != null) {
                        class13.slFlagSprites[(world_0.method1589() ? 8 : 0) + world_0.location].method5829(int_12 + 29,
                                int_4);
                    }

                    font_0.drawTextCentered(Integer.toString(world_0.id), int_12 + 15, (byte_4 / 2) + int_4 + 5, int_6,
                            -1);
                    font_1.drawTextCentered(string_0, int_12 + 60, (byte_4 / 2) + int_4 + 5, 268435455, -1);
                    int_4 = int_4 + byte_4 + int_10;
                    ++int_13;
                    if (int_13 >= int_1) {
                        int_4 = int_3 + 23;
                        int_12 = int_12 + byte_0 + int_2;
                        int_13 = 0;
                    }
                }

                if (bool_6) {
                    int_14 = font_1.getTextWidth(World.worldList[class78.field1116].activity) + 6;
                    final int int_7 = font_1.verticalSpace + 8;
                    Rasterizer2D.Rasterizer2D_fillRectangle(MouseInput.mouseLastX - (int_14 / 2),
                            (MouseInput.mouseLastY * 673804999) + 20 + 5, int_14, int_7, 16777120);
                    Rasterizer2D.drawRectangle(MouseInput.mouseLastX - (int_14 / 2),
                            (MouseInput.mouseLastY * 673804999) + 20 + 5, int_14, int_7, 0);
                    font_1.drawTextCentered(World.worldList[class78.field1116].activity, MouseInput.mouseLastX,
                            (MouseInput.mouseLastY * 673804999) + font_1.verticalSpace + 20 + 5 + 4, 0, -1);
                }
            }

            GameSocket.rasterProvider.drawFull(0, 0);
        } else {
            if (bool_0) {
                class78.field1092.method5849(class78.field1082, 0);
                class78.field1087.method5849(class78.field1082 + 382, 0);
                Game.drawSnow();
            }

            if ((Game.gameState == 0) || (Game.gameState == 5)) {
                byte_0 = 20;
                font_0.drawTextCentered(Loader.SERVER_NAME + " is loading - please wait...", class78.loginWindowX + 180,
                        245 - byte_0, 16777215, -1);
                int_0 = 253 - byte_0;
                Rasterizer2D.drawRectangle((class78.loginWindowX + 180) - 152, int_0, 304, 34, 9179409);
                Rasterizer2D.drawRectangle((class78.loginWindowX + 180) - 151, int_0 + 1, 302, 32, 0);
                Rasterizer2D.Rasterizer2D_fillRectangle((class78.loginWindowX + 180) - 150, int_0 + 2,
                        class78.loadingBarPercentage * 3, 30, 9179409);
                Rasterizer2D.Rasterizer2D_fillRectangle(
                        (class78.loadingBarPercentage * 3) + ((class78.loginWindowX + 180) - 150), int_0 + 2,
                        300 - (class78.loadingBarPercentage * 3), 30, 0);
                font_0.drawTextCentered(class78.loadingText, class78.loginWindowX + 180, 276 - byte_0, 16777215, -1);
            }

            String string_1;
            short short_2;
            short short_3;
            if (Game.gameState == 20) {
                class78.field1083.method5829((class78.loginWindowX + 180) - (class78.field1083.width / 2),
                        271 - (class78.field1083.height / 2));
                short_2 = 201;
                font_0.drawTextCentered(class78.loginMessage1, class78.loginWindowX + 180, short_2, 16776960, 0);
                int_8 = short_2 + 15;
                font_0.drawTextCentered(class78.loginMessage2, class78.loginWindowX + 180, int_8, 16776960, 0);
                int_8 += 15;
                font_0.drawTextCentered(class78.loginMessage3, class78.loginWindowX + 180, int_8, 16776960, 0);
                int_8 += 15;
                int_8 += 7;
                if (class78.loginIndex != 4) {
                    font_0.method5522("Login: ", (class78.loginWindowX + 180) - 110, int_8, 16777215, 0);
                    short_3 = 200;

                    for (string_1 = class59.method1076(); font_0.getTextWidth(string_1) > short_3; string_1 = string_1
                            .substring(0, string_1.length() - 1)) {
                    }

                    font_0.method5522(FontTypeFace.appendTags(string_1), (class78.loginWindowX + 180) - 70, int_8,
                            16777215, 0);
                    int_8 += 15;
                    font_0.method5522("Password: " + class265.method4976(class78.password),
                            (class78.loginWindowX + 180) - 108, int_8, 16777215, 0);
                    int_8 += 15;
                }
            }

            if ((Game.gameState == 10) || (Game.gameState == 11)) {
                class78.field1083.method5829(class78.loginWindowX, 171);
                short short_0;
                if (class78.loginIndex == 0) {
                    short_2 = 251;
                    font_0.drawTextCentered("Welcome to " + Loader.SERVER_NAME, class78.loginWindowX + 180, short_2, 16776960, 0);
                    int_8 = short_2 + 30;
                    int_0 = (class78.loginWindowX + 180) - 80;
                    short_0 = 291;
                    class78.field1084.method5829(int_0 - 73, short_0 - 20);
                    font_0.method5526("New User", int_0 - 73, short_0 - 20, 144, 40, 16777215, 0, 1, 1, 0);
                    int_0 = class78.loginWindowX + 180 + 80;
                    class78.field1084.method5829(int_0 - 73, short_0 - 20);
                    font_0.method5526("Existing User", int_0 - 73, short_0 - 20, 144, 40, 16777215, 0, 1, 1, 0);
                } else if (class78.loginIndex == 1) {
                    font_0.drawTextCentered(class78.Login_response0, class78.loginWindowX + 180, 201, 16776960, 0);
                    short_2 = 236;
                    font_0.drawTextCentered(class78.loginMessage1, class78.loginWindowX + 180, short_2, 16777215, 0);
                    int_8 = short_2 + 15;
                    font_0.drawTextCentered(class78.loginMessage2, class78.loginWindowX + 180, int_8, 16777215, 0);
                    int_8 += 15;
                    font_0.drawTextCentered(class78.loginMessage3, class78.loginWindowX + 180, int_8, 16777215, 0);
                    int_8 += 15;
                    int_0 = (class78.loginWindowX + 180) - 80;
                    short_0 = 321;
                    class78.field1084.method5829(int_0 - 73, short_0 - 20);
                    font_0.drawTextCentered("Continue", int_0, short_0 + 5, 16777215, 0);
                    int_0 = class78.loginWindowX + 180 + 80;
                    class78.field1084.method5829(int_0 - 73, short_0 - 20);
                    font_0.drawTextCentered("Cancel", int_0, short_0 + 5, 16777215, 0);
                } else if (class78.loginIndex == 2) {
                    short_2 = 201;
                    font_0.drawTextCentered(class78.loginMessage1, class78.field1091, short_2, 16776960, 0);
                    int_8 = short_2 + 15;
                    font_0.drawTextCentered(class78.loginMessage2, class78.field1091, int_8, 16776960, 0);
                    int_8 += 15;
                    font_0.drawTextCentered(class78.loginMessage3, class78.field1091, int_8, 16776960, 0);
                    int_8 += 15;
                    int_8 += 7;
                    font_0.method5522("Login: ", class78.field1091 - 110, int_8, 16777215, 0);
                    short_3 = 200;

                    for (string_1 = class59.method1076(); font_0.getTextWidth(string_1) > short_3; string_1 = string_1
                            .substring(1)) {
                    }

                    font_0.method5522(FontTypeFace.appendTags(string_1)
                                    + ((class78.currentLoginField == 0) & ((Game.gameCycle % 40) < 20)
                                    ? class6.getColTags(16776960) + "|"
                                    : ""),
                            class78.field1091 - 70, int_8, 16777215, 0);
                    int_8 += 15;
                    font_0.method5522("Password: " + class265.method4976(class78.password)
                                    + ((class78.currentLoginField == 1) & ((Game.gameCycle % 40) < 20)
                                    ? class6.getColTags(16776960) + "|"
                                    : ""),
                            class78.field1091 - 108, int_8, 16777215, 0);
                    int_8 += 15;
                    short_2 = 277;
                    int_1 = class78.field1091 + -117;
                    final boolean bool_1 = class78.Login_isUsernameRemembered;
                    final boolean bool_2 = class78.field1110;
                    final IndexedSprite indexedsprite_0 = bool_1 ? (bool_2 ? ItemContainer.field472 : class78.field1089)
                            : (bool_2 ? Resampler.field1352 : class235.field2783);
                    indexedsprite_0.method5829(int_1, short_2);
                    int_1 = int_1 + indexedsprite_0.width + 5;
                    font_1.method5522("Remember username", int_1, short_2 + 13, 16776960, 0);
                    int_1 = class78.field1091 + 24;
                    final boolean bool_3 = class10.preferences.hideUsername;
                    final boolean bool_4 = class78.field1115;
                    final IndexedSprite indexedsprite_1 = bool_3 ? (bool_4 ? ItemContainer.field472 : class78.field1089)
                            : (bool_4 ? Resampler.field1352 : class235.field2783);
                    indexedsprite_1.method5829(int_1, short_2);
                    int_1 = int_1 + indexedsprite_1.width + 5;
                    font_1.method5522("Hide username", int_1, short_2 + 13, 16776960, 0);
                    int_8 = short_2 + 15;
                    int int_5 = class78.field1091 - 80;
                    final short short_1 = 321;
                    class78.field1084.method5829(int_5 - 73, short_1 - 20);
                    font_0.drawTextCentered("Login", int_5, short_1 + 5, 16777215, 0);
                    int_5 = class78.field1091 + 80;
                    class78.field1084.method5829(int_5 - 73, short_1 - 20);
                    font_0.drawTextCentered("Cancel", int_5, short_1 + 5, 16777215, 0);
                    short_2 = 357;
                    font_1.drawTextCentered("Forgotten your password? <col=ffffff>Click here.", class78.field1091,
                            short_2, 16776960, 0);
                } else if (class78.loginIndex == 3) {
                    short_2 = 201;
                    font_0.drawTextCentered("Invalid username or password.", class78.loginWindowX + 180, short_2,
                            16776960, 0);
                    int_8 = short_2 + 20;
                    font_1.drawTextCentered("For accounts created after 24th November 2010, please use your",
                            class78.loginWindowX + 180, int_8, 16776960, 0);
                    int_8 += 15;
                    font_1.drawTextCentered("email address to login. Otherwise please login with your username.",
                            class78.loginWindowX + 180, int_8, 16776960, 0);
                    int_8 += 15;
                    int_0 = class78.loginWindowX + 180;
                    short_0 = 276;
                    class78.field1084.method5829(int_0 - 73, short_0 - 20);
                    font_2.drawTextCentered("Try again", int_0, short_0 + 5, 16777215, 0);
                    int_0 = class78.loginWindowX + 180;
                    short_0 = 326;
                    class78.field1084.method5829(int_0 - 73, short_0 - 20);
                    font_2.drawTextCentered("Forgotten password?", int_0, short_0 + 5, 16777215, 0);
                } else if (class78.loginIndex == 4) {
                    font_0.drawTextCentered("Authenticator", class78.loginWindowX + 180, 201, 16776960, 0);
                    short_2 = 236;
                    font_0.drawTextCentered(class78.loginMessage1, class78.loginWindowX + 180, short_2, 16777215, 0);
                    int_8 = short_2 + 15;
                    font_0.drawTextCentered(class78.loginMessage2, class78.loginWindowX + 180, int_8, 16777215, 0);
                    int_8 += 15;
                    font_0.drawTextCentered(class78.loginMessage3, class78.loginWindowX + 180, int_8, 16777215, 0);
                    int_8 += 15;
                    font_0.method5522(
                            "PIN: " + class265.method4976(MapIcon.field238)
                                    + ((Game.gameCycle % 40) < 20 ? class6.getColTags(16776960) + "|" : ""),
                            (class78.loginWindowX + 180) - 108, int_8, 16777215, 0);
                    int_8 -= 8;
                    font_0.method5522("Trust this computer", (class78.loginWindowX + 180) - 9, int_8, 16776960, 0);
                    int_8 += 15;
                    font_0.method5522("for 30 days: ", (class78.loginWindowX + 180) - 9, int_8, 16776960, 0);
                    int_0 = ((class78.loginWindowX + 180) - 9) + font_0.getTextWidth("for 30 days: ") + 15;
                    int_9 = int_8 - font_0.verticalSpace;
                    IndexedSprite indexedsprite_2;
                    if (class78.field1104) {
                        indexedsprite_2 = class78.field1089;
                    } else {
                        indexedsprite_2 = class235.field2783;
                    }

                    indexedsprite_2.method5829(int_0, int_9);
                    int_8 += 15;
                    int_2 = (class78.loginWindowX + 180) - 80;
                    final short short_5 = 321;
                    class78.field1084.method5829(int_2 - 73, short_5 - 20);
                    font_0.drawTextCentered("Continue", int_2, short_5 + 5, 16777215, 0);
                    int_2 = class78.loginWindowX + 180 + 80;
                    class78.field1084.method5829(int_2 - 73, short_5 - 20);
                    font_0.drawTextCentered("Cancel", int_2, short_5 + 5, 16777215, 0);
                    font_1.drawTextCentered("<u=ff>Can\'t Log In?</u>", class78.loginWindowX + 180, short_5 + 36, 255,
                            0);
                } else if (class78.loginIndex == 5) {
                    font_0.drawTextCentered("Forgotten your password?", class78.loginWindowX + 180, 201, 16776960, 0);
                    short_2 = 221;
                    font_2.drawTextCentered(class78.loginMessage1, class78.loginWindowX + 180, short_2, 16776960, 0);
                    int_8 = short_2 + 15;
                    font_2.drawTextCentered(class78.loginMessage2, class78.loginWindowX + 180, int_8, 16776960, 0);
                    int_8 += 15;
                    font_2.drawTextCentered(class78.loginMessage3, class78.loginWindowX + 180, int_8, 16776960, 0);
                    int_8 += 15;
                    int_8 += 14;
                    font_0.method5522("Username/email: ", (class78.loginWindowX + 180) - 145, int_8, 16777215, 0);
                    short_3 = 174;

                    for (string_1 = class59.method1076(); font_0.getTextWidth(string_1) > short_3; string_1 = string_1
                            .substring(1)) {
                    }

                    font_0.method5522(
                            FontTypeFace.appendTags(string_1)
                                    + ((Game.gameCycle % 40) < 20 ? class6.getColTags(16776960) + "|" : ""),
                            (class78.loginWindowX + 180) - 34, int_8, 16777215, 0);
                    int_8 += 15;
                    int_1 = (class78.loginWindowX + 180) - 80;
                    final short short_4 = 321;
                    class78.field1084.method5829(int_1 - 73, short_4 - 20);
                    font_0.drawTextCentered("Recover", int_1, short_4 + 5, 16777215, 0);
                    int_1 = class78.loginWindowX + 180 + 80;
                    class78.field1084.method5829(int_1 - 73, short_4 - 20);
                    font_0.drawTextCentered("Back", int_1, short_4 + 5, 16777215, 0);
                } else if (class78.loginIndex == 6) {
                    short_2 = 201;
                    font_0.drawTextCentered(class78.loginMessage1, class78.loginWindowX + 180, short_2, 16776960, 0);
                    int_8 = short_2 + 15;
                    font_0.drawTextCentered(class78.loginMessage2, class78.loginWindowX + 180, int_8, 16776960, 0);
                    int_8 += 15;
                    font_0.drawTextCentered(class78.loginMessage3, class78.loginWindowX + 180, int_8, 16776960, 0);
                    int_8 += 15;
                    int_0 = class78.loginWindowX + 180;
                    short_0 = 321;
                    class78.field1084.method5829(int_0 - 73, short_0 - 20);
                    font_0.drawTextCentered("Back", int_0, short_0 + 5, 16777215, 0);
                } else if (class78.loginIndex == 7) {
                    short_2 = 216;
                    font_0.drawTextCentered("Your date of birth isn\'t set.", class78.loginWindowX + 180, short_2,
                            16776960, 0);
                    int_8 = short_2 + 15;
                    font_2.drawTextCentered("Please verify your account status by", class78.loginWindowX + 180, int_8,
                            16776960, 0);
                    int_8 += 15;
                    font_2.drawTextCentered("setting your date of birth.", class78.loginWindowX + 180, int_8, 16776960,
                            0);
                    int_8 += 15;
                    int_0 = (class78.loginWindowX + 180) - 80;
                    short_0 = 321;
                    class78.field1084.method5829(int_0 - 73, short_0 - 20);
                    font_0.drawTextCentered("Set Date of Birth", int_0, short_0 + 5, 16777215, 0);
                    int_0 = class78.loginWindowX + 180 + 80;
                    class78.field1084.method5829(int_0 - 73, short_0 - 20);
                    font_0.drawTextCentered("Back", int_0, short_0 + 5, 16777215, 0);
                } else if (class78.loginIndex == 8) {
                    short_2 = 216;
                    font_0.drawTextCentered("Sorry, but your account is not eligible to play.",
                            class78.loginWindowX + 180, short_2, 16776960, 0);
                    int_8 = short_2 + 15;
                    font_2.drawTextCentered("For more information, please take a look at", class78.loginWindowX + 180,
                            int_8, 16776960, 0);
                    int_8 += 15;
                    font_2.drawTextCentered("our privacy policy.", class78.loginWindowX + 180, int_8, 16776960, 0);
                    int_8 += 15;
                    int_0 = (class78.loginWindowX + 180) - 80;
                    short_0 = 321;
                    class78.field1084.method5829(int_0 - 73, short_0 - 20);
                    font_0.drawTextCentered("Privacy Policy", int_0, short_0 + 5, 16777215, 0);
                    int_0 = class78.loginWindowX + 180 + 80;
                    class78.field1084.method5829(int_0 - 73, short_0 - 20);
                    font_0.drawTextCentered("Back", int_0, short_0 + 5, 16777215, 0);
                }
            }

            DecorativeObject.method3098();
            FrameMap.titlemuteSprite[class10.preferences.muted ? 1 : 0].method5829((class78.field1082 + 765) - 40, 463);
            if ((Game.gameState > 5) && (Game.languageId == 0)) {
                if (class232.field2752 != null) {
                    int_8 = class78.field1082 + 5;
                    short_3 = 463;
                    final byte byte_3 = 100;
                    final byte byte_2 = 35;
                    class232.field2752.method5829(int_8, short_3);
                    font_0.drawTextCentered("World" + " " + Game.world, (byte_3 / 2) + int_8,
                            ((byte_2 / 2) + short_3) - 2, 16777215, 0);
                    if (class49.listFetcher != null) {
                        font_1.drawTextCentered("Loading...", (byte_3 / 2) + int_8, (byte_2 / 2) + short_3 + 12,
                                16777215, 0);
                    } else {
                        font_1.drawTextCentered("Click to switch", (byte_3 / 2) + int_8, (byte_2 / 2) + short_3 + 12,
                                16777215, 0);
                    }
                } else {
                    class232.field2752 = class221.getSprite(GZipDecompressor.indexSprites, "sl_button", "");
                }
            }

        }
    }

}
