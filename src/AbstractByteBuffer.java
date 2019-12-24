public abstract class AbstractByteBuffer {

    static boolean directBufferUnavailable;
    static int[] field2367;

    static {
        directBufferUnavailable = false;
    }

    abstract byte[] get();

    abstract void put(byte[] var1);

    static void method3806(final GameEngine gameengine_0) {
        int int_2;
        int int_5;
        if (class78.worldSelectShown) {
            if ((MouseInput.mouseLastButton == 1)
                    || (!InvType.middleMouseMovesCamera && (MouseInput.mouseLastButton == 4))) {
                final int int_0 = class78.field1082 + 280;
                if ((MouseInput.mouseLastPressedX >= int_0) && (MouseInput.mouseLastPressedX <= (int_0 + 14))
                        && (MouseInput.mouseLastPressedY >= 4) && (MouseInput.mouseLastPressedY <= 18)) {
                    class148.method3195(0, 0);
                } else if ((MouseInput.mouseLastPressedX >= (int_0 + 15))
                        && (MouseInput.mouseLastPressedX <= (int_0 + 80)) && (MouseInput.mouseLastPressedY >= 4)
                        && (MouseInput.mouseLastPressedY <= 18)) {
                    class148.method3195(0, 1);
                } else {
                    final int int_1 = class78.field1082 + 390;
                    if ((MouseInput.mouseLastPressedX >= int_1) && (MouseInput.mouseLastPressedX <= (int_1 + 14))
                            && (MouseInput.mouseLastPressedY >= 4) && (MouseInput.mouseLastPressedY <= 18)) {
                        class148.method3195(1, 0);
                    } else if ((MouseInput.mouseLastPressedX >= (int_1 + 15))
                            && (MouseInput.mouseLastPressedX <= (int_1 + 80)) && (MouseInput.mouseLastPressedY >= 4)
                            && (MouseInput.mouseLastPressedY <= 18)) {
                        class148.method3195(1, 1);
                    } else {
                        int_2 = class78.field1082 + 500;
                        if ((MouseInput.mouseLastPressedX >= int_2) && (MouseInput.mouseLastPressedX <= (int_2 + 14))
                                && (MouseInput.mouseLastPressedY >= 4) && (MouseInput.mouseLastPressedY <= 18)) {
                            class148.method3195(2, 0);
                        } else if ((MouseInput.mouseLastPressedX >= (int_2 + 15))
                                && (MouseInput.mouseLastPressedX <= (int_2 + 80)) && (MouseInput.mouseLastPressedY >= 4)
                                && (MouseInput.mouseLastPressedY <= 18)) {
                            class148.method3195(2, 1);
                        } else {
                            int_5 = class78.field1082 + 610;
                            if ((MouseInput.mouseLastPressedX >= int_5)
                                    && (MouseInput.mouseLastPressedX <= (int_5 + 14))
                                    && (MouseInput.mouseLastPressedY >= 4) && (MouseInput.mouseLastPressedY <= 18)) {
                                class148.method3195(3, 0);
                            } else if ((MouseInput.mouseLastPressedX >= (int_5 + 15))
                                    && (MouseInput.mouseLastPressedX <= (int_5 + 80))
                                    && (MouseInput.mouseLastPressedY >= 4) && (MouseInput.mouseLastPressedY <= 18)) {
                                class148.method3195(3, 1);
                            } else if ((MouseInput.mouseLastPressedX >= (class78.field1082 + 708))
                                    && (MouseInput.mouseLastPressedY >= 4)
                                    && (MouseInput.mouseLastPressedX <= (class78.field1082 + 708 + 50))
                                    && (MouseInput.mouseLastPressedY <= 20)) {
                                class78.worldSelectShown = false;
                                class78.field1092.method5849(class78.field1082, 0);
                                class78.field1087.method5849(class78.field1082 + 382, 0);
                            } else if (class78.field1116 != -1) {
                                final World world_0 = World.worldList[class78.field1116];
                                OwnWorldComparator.changeWorld(world_0);
                                class78.worldSelectShown = false;
                               class78.field1092.method5849(class78.field1082, 0);
                                class78.field1087.method5849(class78.field1082 + 382, 0);
                            }
                        }
                    }
                }
            }

        } else {
            if (((MouseInput.mouseLastButton == 1)
                    || (!InvType.middleMouseMovesCamera && (MouseInput.mouseLastButton == 4)))
                    && (MouseInput.mouseLastPressedX >= ((class78.field1082 + 765) - 50))
                    && (MouseInput.mouseLastPressedY >= 453)) {
                class10.preferences.muted = !class10.preferences.muted;
                class54.method1018();
                if (!class10.preferences.muted) {
                    class219.method4325(Item.indexTrack1, "scape main", "", 255, false);
                } else {
                    class9.method88();
                }
            }

            if (Game.gameState != 5) {
                if (class78.field1109 == -1L) {
                    class78.field1109 = Buffer.safeCurrentTimeMillis() + 1000L;
                }

                final long long_0 = Buffer.safeCurrentTimeMillis();
                if (class10.method92() && (class78.field1118 == -1L)) {
                    class78.field1118 = long_0;
                    if (class78.field1118 > class78.field1109) {
                        class78.field1109 = class78.field1118;
                    }
                }

                ++class78.field1097;
                if ((Game.gameState == 10) || (Game.gameState == 11)) {
                    if (Game.languageId == 0) {
                        if ((MouseInput.mouseLastButton == 1)
                                || (!InvType.middleMouseMovesCamera && (MouseInput.mouseLastButton == 4))) {
                            int_2 = class78.field1082 + 5;
                            final short short_0 = 463;
                            final byte byte_0 = 100;
                            final byte byte_1 = 35;
                            if ((MouseInput.mouseLastPressedX >= int_2)
                                    && (MouseInput.mouseLastPressedX <= (int_2 + byte_0))
                                    && (MouseInput.mouseLastPressedY >= short_0)
                                    && (MouseInput.mouseLastPressedY <= (short_0 + byte_1))) {
                                class59.method1078();
                                return;
                            }
                        }

                        if (class49.listFetcher != null) {
                            class59.method1078();
                        }
                    }

                    int_2 = MouseInput.mouseLastButton;
                    int_5 = MouseInput.mouseLastPressedX;
                    int int_6 = MouseInput.mouseLastPressedY;
                    if (int_2 == 0) {
                        int_5 = MouseInput.mouseLastX;
                        int_6 = MouseInput.mouseLastY * 673804999;
                    }

                    if (!InvType.middleMouseMovesCamera && (int_2 == 4)) {
                        int_2 = 1;
                    }

                    int int_3;
                    short short_1;
                    if (class78.loginIndex == 0) {
                        boolean bool_1 = false;

                        while (GrandExchangeEvents.method8()) {
                            if (GameSocket.currentPressedKey == 84) {
                                bool_1 = true;
                            }
                        }

                        int_3 = class78.field1091 - 80;
                        short_1 = 291;
                        if ((int_2 == 1) && (int_5 >= (int_3 - 75)) && (int_5 <= (int_3 + 75))
                                && (int_6 >= (short_1 - 20)) && (int_6 <= (short_1 + 20))) {
                            HorizontalAlignment.method5156(Loader.WEBSITE_URL + "/register", true, false);
                        }

                        int_3 = class78.field1091 + 80;
                        if (((int_2 == 1) && (int_5 >= (int_3 - 75)) && (int_5 <= (int_3 + 75))
                                && (int_6 >= (short_1 - 20)) && (int_6 <= (short_1 + 20))) || bool_1) {
                            if ((Game.flags & 0x2000000) != 0) {
                                class78.Login_response0 = "";
                                class78.loginMessage1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                                class78.loginMessage2 = "Your normal account will not be affected.";
                                class78.loginMessage3 = "";
                                class78.loginIndex = 1;
                                class34.method586();
                            } /*else if ((Game.flags & 0x4) != 0) {
                                if ((Game.flags & 0x400) != 0) {
                                    class78.loginMessage1 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                                    class78.loginMessage2 = "Players can attack each other almost everywhere";
                                    class78.loginMessage3 = "and the Protect Item prayer won\'t work.";
                                } else {
                                    class78.loginMessage1 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                                    class78.loginMessage2 = "Players can attack each other";
                                    class78.loginMessage3 = "almost everywhere.";
                                }

                                class78.Login_response0 = "Warning!";
                                class78.loginIndex = 1;
                                class34.method586();
                            }*/ else if ((Game.flags & 0x400) != 0) {
                                class78.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                                class78.loginMessage2 = "The Protect Item prayer will";
                                class78.loginMessage3 = "not work on this world.";
                                class78.Login_response0 = "Warning!";
                                class78.loginIndex = 1;
                                class34.method586();
                            } else {
                                ScriptEvent.method1030(false);
                            }
                        }
                    } else {
                        int int_7;
                        short short_3;
                        if (class78.loginIndex != 1) {
                            short short_2;
                            if (class78.loginIndex == 2) {
                                short_2 = 201;
                                int_7 = short_2 + 52;
                                if ((int_2 == 1) && (int_6 >= (int_7 - 12)) && (int_6 < (int_7 + 2))) {
                                    class78.currentLoginField = 0;
                                }

                                int_7 += 15;
                                if ((int_2 == 1) && (int_6 >= (int_7 - 12)) && (int_6 < (int_7 + 2))) {
                                    class78.currentLoginField = 1;
                                }

                                int_7 += 15;
                                short_2 = 361;
                                if ((int_2 == 1) && (int_6 >= (short_2 - 15)) && (int_6 < short_2)) {
                                    GrandExchangeEvent.method22("Please enter your username.",
                                            "If you created your account after November",
                                            "2010, this will be the creation email address.");
                                    class78.loginIndex = 5;
                                    return;
                                }

                                int_3 = class78.field1091 - 80;
                                short_1 = 321;
                                if ((int_2 == 1) && (int_5 >= (int_3 - 75)) && (int_5 <= (int_3 + 75))
                                        && (int_6 >= (short_1 - 20)) && (int_6 <= (short_1 + 20))) {
                                    class78.username = class78.username.trim();
                                    if (class78.username.length() == 0) {
                                        GrandExchangeEvent.method22("", "Please enter your username/email address.",
                                                "");
                                        return;
                                    }

                                    if (class78.password.length() == 0) {
                                        GrandExchangeEvent.method22("", "Please enter your password.", "");
                                        return;
                                    }

                                    GrandExchangeEvent.method22("", "Connecting to server...", "");
                                    NetWriter.method2005(false);
                                    MouseInput.setGameState(20);
                                    return;
                                }

                                int_3 = class78.loginWindowX + 180 + 80;
                                if ((int_2 == 1) && (int_5 >= (int_3 - 75)) && (int_5 <= (int_3 + 75))
                                        && (int_6 >= (short_1 - 20)) && (int_6 <= (short_1 + 20))) {
                                    class78.loginIndex = 0;
                                    class78.username = "";
                                    class78.password = "";
                                    WorldMapType3.field104 = 0;
                                    MapIcon.field238 = "";
                                    class78.field1104 = true;
                                }

                                int_3 = class78.field1091 + -117;
                                short_1 = 277;
                                class78.field1110 = (int_5 >= int_3) && (int_5 < (int_3 + FriendManager.field978))
                                        && (int_6 >= short_1) && (int_6 < (short_1 + Preferences.field966));
                                if ((int_2 == 1) && class78.field1110) {
                                    class78.Login_isUsernameRemembered = !class78.Login_isUsernameRemembered;
                                    if (!class78.Login_isUsernameRemembered
                                            && (class10.preferences.rememberedUsername != null)) {
                                        class10.preferences.rememberedUsername = null;
                                        class54.method1018();
                                    }
                                }

                                int_3 = class78.field1091 + 24;
                                short_1 = 277;
                                class78.field1115 = (int_5 >= int_3) && (int_5 < (int_3 + FriendManager.field978))
                                        && (int_6 >= short_1) && (int_6 < (short_1 + Preferences.field966));
                                if ((int_2 == 1) && class78.field1115) {
                                    class10.preferences.hideUsername = !class10.preferences.hideUsername;
                                    if (!class10.preferences.hideUsername) {
                                        class78.username = "";
                                        class10.preferences.rememberedUsername = null;
                                        class34.method586();
                                    }

                                    class54.method1018();
                                }

                                while (true) {
                                    while (GrandExchangeEvents.method8()) {
                                        boolean bool_0 = false;

                                        for (int int_4 = 0; int_4 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| "
                                                .length(); int_4++) {
                                            if (KeyFocusListener.currentTypedKey == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| "
                                                    .charAt(int_4)) {
                                                bool_0 = true;
                                                break;
                                            }
                                        }

                                        if (GameSocket.currentPressedKey == 13) {
                                            class78.loginIndex = 0;
                                            class78.username = "";
                                            class78.password = "";
                                            WorldMapType3.field104 = 0;
                                            MapIcon.field238 = "";
                                            class78.field1104 = true;
                                        } else if (class78.currentLoginField == 0) {
                                            if ((GameSocket.currentPressedKey == 85) && (class78.username.length() > 0)) {
                                                class78.username = class78.username.substring(0,
                                                        class78.username.length() - 1);
                                            }

                                            if ((GameSocket.currentPressedKey == 84)
                                                    || (GameSocket.currentPressedKey == 80)) {
                                                class78.currentLoginField = 1;
                                            }

                                            if (bool_0 && (class78.username.length() < 320)) {
                                                class78.username = class78.username + KeyFocusListener.currentTypedKey;
                                            }
                                        } else if (class78.currentLoginField == 1) {
                                            if ((GameSocket.currentPressedKey == 85) && (class78.password.length() > 0)) {
                                                class78.password = class78.password.substring(0,
                                                        class78.password.length() - 1);
                                            }

                                            if ((GameSocket.currentPressedKey == 84)
                                                    || (GameSocket.currentPressedKey == 80)) {
                                                class78.currentLoginField = 0;
                                            }

                                            if (GameSocket.currentPressedKey == 84) {
                                                class78.username = class78.username.trim();
                                                if (class78.username.length() == 0) {
                                                    GrandExchangeEvent.method22("",
                                                            "Please enter your username/email address.", "");
                                                    return;
                                                }

                                                if (class78.password.length() == 0) {
                                                    GrandExchangeEvent.method22("", "Please enter your password.", "");
                                                    return;
                                                }

                                                GrandExchangeEvent.method22("", "Connecting to server...", "");
                                                NetWriter.method2005(false);
                                                MouseInput.setGameState(20);
                                                return;
                                            }

                                            if (bool_0 && (class78.password.length() < 20)) {
                                                class78.password = class78.password + KeyFocusListener.currentTypedKey;
                                            }
                                        }
                                    }

                                    return;
                                }
                            } else if (class78.loginIndex == 3) {
                                int_7 = class78.loginWindowX + 180;
                                short_3 = 276;
                                if ((int_2 == 1) && (int_5 >= (int_7 - 75)) && (int_5 <= (int_7 + 75))
                                        && (int_6 >= (short_3 - 20)) && (int_6 <= (short_3 + 20))) {
                                    ScriptEvent.method1030(false);
                                }

                                int_7 = class78.loginWindowX + 180;
                                short_3 = 326;
                                if ((int_2 == 1) && (int_5 >= (int_7 - 75)) && (int_5 <= (int_7 + 75))
                                        && (int_6 >= (short_3 - 20)) && (int_6 <= (short_3 + 20))) {
                                    GrandExchangeEvent.method22("Please enter your username.",
                                            "If you created your account after November",
                                            "2010, this will be the creation email address.");
                                    class78.loginIndex = 5;
                                    return;
                                }
                            } else {
                                boolean bool_2;
                                int int_8;
                                if (class78.loginIndex == 4) {
                                    int_7 = (class78.loginWindowX + 180) - 80;
                                    short_3 = 321;
                                    if ((int_2 == 1) && (int_5 >= (int_7 - 75)) && (int_5 <= (int_7 + 75))
                                            && (int_6 >= (short_3 - 20)) && (int_6 <= (short_3 + 20))) {
                                        MapIcon.field238.trim();
                                        if (MapIcon.field238.length() != 6) {
                                            GrandExchangeEvent.method22("", "Please enter a 6-digit PIN.", "");
                                            return;
                                        }

                                        WorldMapType3.field104 = Integer.parseInt(MapIcon.field238);
                                        MapIcon.field238 = "";
                                        NetWriter.method2005(true);
                                        GrandExchangeEvent.method22("", "Connecting to server...", "");
                                        MouseInput.setGameState(20);
                                        return;
                                    }

                                    if ((int_2 == 1) && (int_5 >= ((class78.loginWindowX + 180) - 9))
                                            && (int_5 <= (class78.loginWindowX + 180 + 130)) && (int_6 >= 263)
                                            && (int_6 <= 296)) {
                                        class78.field1104 = !class78.field1104;
                                    }

                                    if ((int_2 == 1) && (int_5 >= ((class78.loginWindowX + 180) - 34))
                                            && (int_5 <= (class78.loginWindowX + 34 + 180)) && (int_6 >= 351)
                                            && (int_6 <= 363)) {
                                        HorizontalAlignment.method5156(class142.method3161("secure", true)
                                                + "m=totp-authenticator/disableTOTPRequest", true, false);
                                    }

                                    int_7 = class78.loginWindowX + 180 + 80;
                                    if ((int_2 == 1) && (int_5 >= (int_7 - 75)) && (int_5 <= (int_7 + 75))
                                            && (int_6 >= (short_3 - 20)) && (int_6 <= (short_3 + 20))) {
                                        class78.loginIndex = 0;
                                        class78.username = "";
                                        class78.password = "";
                                        WorldMapType3.field104 = 0;
                                        MapIcon.field238 = "";
                                    }

                                    while (GrandExchangeEvents.method8()) {
                                        bool_2 = false;

                                        for (int_8 = 0; int_8 < "1234567890".length(); int_8++) {
                                            if (KeyFocusListener.currentTypedKey == "1234567890".charAt(int_8)) {
                                                bool_2 = true;
                                                break;
                                            }
                                        }

                                        if (GameSocket.currentPressedKey == 13) {
                                            class78.loginIndex = 0;
                                            class78.username = "";
                                            class78.password = "";
                                            WorldMapType3.field104 = 0;
                                            MapIcon.field238 = "";
                                        } else {
                                            if ((GameSocket.currentPressedKey == 85) && (MapIcon.field238.length() > 0)) {
                                                MapIcon.field238 = MapIcon.field238.substring(0,
                                                        MapIcon.field238.length() - 1);
                                            }

                                            if (GameSocket.currentPressedKey == 84) {
                                                MapIcon.field238.trim();
                                                if (MapIcon.field238.length() != 6) {
                                                    GrandExchangeEvent.method22("", "Please enter a 6-digit PIN.", "");
                                                    return;
                                                }

                                                WorldMapType3.field104 = Integer.parseInt(MapIcon.field238);
                                                MapIcon.field238 = "";
                                                NetWriter.method2005(true);
                                                GrandExchangeEvent.method22("", "Connecting to server...", "");
                                                MouseInput.setGameState(20);
                                                return;
                                            }

                                            if (bool_2 && (MapIcon.field238.length() < 6)) {
                                                MapIcon.field238 = MapIcon.field238 + KeyFocusListener.currentTypedKey;
                                            }
                                        }
                                    }
                                } else if (class78.loginIndex == 5) {
                                    int_7 = (class78.loginWindowX + 180) - 80;
                                    short_3 = 321;
                                    if ((int_2 == 1) && (int_5 >= (int_7 - 75)) && (int_5 <= (int_7 + 75))
                                            && (int_6 >= (short_3 - 20)) && (int_6 <= (short_3 + 20))) {
                                        class234.method4590();
                                        return;
                                    }

                                    int_7 = class78.loginWindowX + 180 + 80;
                                    if ((int_2 == 1) && (int_5 >= (int_7 - 75)) && (int_5 <= (int_7 + 75))
                                            && (int_6 >= (short_3 - 20)) && (int_6 <= (short_3 + 20))) {
                                        ScriptEvent.method1030(true);
                                    }

                                    while (GrandExchangeEvents.method8()) {
                                        bool_2 = false;

                                        for (int_8 = 0; int_8 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| "
                                                .length(); int_8++) {
                                            if (KeyFocusListener.currentTypedKey == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| "
                                                    .charAt(int_8)) {
                                                bool_2 = true;
                                                break;
                                            }
                                        }

                                        if (GameSocket.currentPressedKey == 13) {
                                            ScriptEvent.method1030(true);
                                        } else {
                                            if ((GameSocket.currentPressedKey == 85) && (class78.username.length() > 0)) {
                                                class78.username = class78.username.substring(0,
                                                        class78.username.length() - 1);
                                            }

                                            if (GameSocket.currentPressedKey == 84) {
                                                class234.method4590();
                                                return;
                                            }

                                            if (bool_2 && (class78.username.length() < 320)) {
                                                class78.username = class78.username + KeyFocusListener.currentTypedKey;
                                            }
                                        }
                                    }
                                } else if (class78.loginIndex == 6) {
                                    while (true) {
                                        do {
                                            if (!GrandExchangeEvents.method8()) {
                                                short_2 = 321;
                                                if ((int_2 == 1) && (int_6 >= (short_2 - 20))
                                                        && (int_6 <= (short_2 + 20))) {
                                                    ScriptEvent.method1030(true);
                                                }

                                                return;
                                            }
                                        }
                                        while ((GameSocket.currentPressedKey != 84)
                                                && (GameSocket.currentPressedKey != 13));

                                        ScriptEvent.method1030(true);
                                    }
                                } else if (class78.loginIndex == 7) {
                                    int_7 = (class78.loginWindowX + 180) - 80;
                                    short_3 = 321;
                                    if ((int_2 == 1) && (int_5 >= (int_7 - 75)) && (int_5 <= (int_7 + 75))
                                            && (int_6 >= (short_3 - 20)) && (int_6 <= (short_3 + 20))) {
                                        HorizontalAlignment.method5156(
                                                class142.method3161("secure", true) + "m=dob/set_dob.ws", true, false);
                                        GrandExchangeEvent.method22("", "Page has opened in a new window.",
                                                "(Please check your popup blocker.)");
                                        class78.loginIndex = 6;
                                        return;
                                    }

                                    int_7 = class78.loginWindowX + 180 + 80;
                                    if ((int_2 == 1) && (int_5 >= (int_7 - 75)) && (int_5 <= (int_7 + 75))
                                            && (int_6 >= (short_3 - 20)) && (int_6 <= (short_3 + 20))) {
                                        ScriptEvent.method1030(true);
                                    }

                                } else if (class78.loginIndex == 8) {
                                    int_7 = (class78.loginWindowX + 180) - 80;
                                    short_3 = 321;
                                    if ((int_2 == 1) && (int_5 >= (int_7 - 75)) && (int_5 <= (int_7 + 75))
                                            && (int_6 >= (short_3 - 20)) && (int_6 <= (short_3 + 20))) {
                                        HorizontalAlignment.method5156("https://www.jagex.com/terms/privacy/#eight",
                                                true, false);
                                        GrandExchangeEvent.method22("", "Page has opened in a new window.",
                                                "(Please check your popup blocker.)");
                                        class78.loginIndex = 6;
                                        return;
                                    }

                                    int_7 = class78.loginWindowX + 180 + 80;
                                    if ((int_2 == 1) && (int_5 >= (int_7 - 75)) && (int_5 <= (int_7 + 75))
                                            && (int_6 >= (short_3 - 20)) && (int_6 <= (short_3 + 20))) {
                                        ScriptEvent.method1030(true);
                                    }
                                }
                            }

                        } else {
                            while (GrandExchangeEvents.method8()) {
                                if (GameSocket.currentPressedKey == 84) {
                                    ScriptEvent.method1030(false);
                                } else if (GameSocket.currentPressedKey == 13) {
                                    class78.loginIndex = 0;
                                }
                            }

                            int_7 = class78.field1091 - 80;
                            short_3 = 321;
                            if ((int_2 == 1) && (int_5 >= (int_7 - 75)) && (int_5 <= (int_7 + 75))
                                    && (int_6 >= (short_3 - 20)) && (int_6 <= (short_3 + 20))) {
                                ScriptEvent.method1030(false);
                            }

                            int_7 = class78.field1091 + 80;
                            if ((int_2 == 1) && (int_5 >= (int_7 - 75)) && (int_5 <= (int_7 + 75))
                                    && (int_6 >= (short_3 - 20)) && (int_6 <= (short_3 + 20))) {
                                class78.loginIndex = 0;
                            }
                        }
                    }

                }
            }
        }
    }

    static int getSmoothNoise2D(final int int_0, final int int_1) {
        final int int_2 = FileOnDisk.method2511(int_0 - 1, int_1 - 1) + FileOnDisk.method2511(1 + int_0, int_1 - 1)
                + FileOnDisk.method2511(int_0 - 1, int_1 + 1) + FileOnDisk.method2511(1 + int_0, 1 + int_1);
        final int int_3 = FileOnDisk.method2511(int_0 - 1, int_1) + FileOnDisk.method2511(1 + int_0, int_1)
                + FileOnDisk.method2511(int_0, int_1 - 1) + FileOnDisk.method2511(int_0, 1 + int_1);
        final int int_4 = FileOnDisk.method2511(int_0, int_1);
        return (int_2 / 16) + (int_3 / 8) + (int_4 / 4);
    }

}
