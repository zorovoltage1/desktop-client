public class Resampler {

    static IndexedSprite field1352;
    int storedSampleRateRatio;
    int playbackSampleRateRatio;
    int[][] resampleTable;

    public Resampler(int int_0, int int_1) {
        if (int_1 != int_0) {
            int int_2 = int_0;
            int int_3 = int_1;
            if (int_1 > int_0) {
                int_2 = int_1;
                int_3 = int_0;
            }

            while (int_3 != 0) {
                final int int_4 = int_2 % int_3;
                int_2 = int_3;
                int_3 = int_4;
            }

            int_0 /= int_2;
            int_1 /= int_2;
            storedSampleRateRatio = int_0;
            playbackSampleRateRatio = int_1;
            resampleTable = new int[int_0][14];

            for (int int_5 = 0; int_5 < int_0; int_5++) {
                final int[] ints_0 = resampleTable[int_5];
                final double double_0 = ((double) int_5 / (double) int_0) + 6.0D;
                int int_6 = (int) Math.floor((double_0 - 7.0D) + 1.0D);
                if (int_6 < 0) {
                    int_6 = 0;
                }

                int int_7 = (int) Math.ceil(7.0D + double_0);
                if (int_7 > 14) {
                    int_7 = 14;
                }

                for (final double double_1 = (double) int_1 / (double) int_0; int_6 < int_7; int_6++) {
                    final double double_2 = (int_6 - double_0) * 3.141592653589793D;
                    double double_3 = double_1;
                    if ((double_2 < -1.0E-4D) || (double_2 > 1.0E-4D)) {
                        double_3 = double_1 * (Math.sin(double_2) / double_2);
                    }

                    double_3 *= 0.54D + (0.46D * Math.cos(0.2243994752564138D * (int_6 - double_0)));
                    ints_0[int_6] = (int) Math.floor((double_3 * 65536.0D) + 0.5D);
                }
            }

        }
    }

    byte[] resampleIfNecessary(byte[] bytes_0) {
        if (resampleTable != null) {
            final int int_0 = (int) (((long) playbackSampleRateRatio * (long) bytes_0.length) / storedSampleRateRatio)
                    + 14;
            final int[] ints_0 = new int[int_0];
            int int_1 = 0;
            int int_2 = 0;

            int int_3;
            for (int_3 = 0; int_3 < bytes_0.length; int_3++) {
                final byte byte_0 = bytes_0[int_3];
                final int[] ints_1 = resampleTable[int_2];

                int int_4;
                for (int_4 = 0; int_4 < 14; int_4++) {
                    ints_0[int_1 + int_4] += byte_0 * ints_1[int_4];
                }

                int_2 += playbackSampleRateRatio;
                int_4 = int_2 / storedSampleRateRatio;
                int_1 += int_4;
                int_2 -= int_4 * storedSampleRateRatio;
            }

            bytes_0 = new byte[int_0];

            for (int_3 = 0; int_3 < int_0; int_3++) {
                final int int_5 = (ints_0[int_3] + 32768) >> 16;
                if (int_5 < -128) {
                    bytes_0[int_3] = -128;
                } else if (int_5 > 127) {
                    bytes_0[int_3] = 127;
                } else {
                    bytes_0[int_3] = (byte) int_5;
                }
            }
        }

        return bytes_0;
    }

    int method2240(int int_0) {
        if (resampleTable != null) {
            int_0 = (int) (((long) int_0 * (long) playbackSampleRateRatio) / storedSampleRateRatio);
        }

        return int_0;
    }

    int method2241(int int_0) {
        if (resampleTable != null) {
            int_0 = (int) (((long) playbackSampleRateRatio * (long) int_0) / storedSampleRateRatio) + 6;
        }

        return int_0;
    }

    public static boolean method2249(final CharSequence charsequence_0) {
        boolean bool_0 = false;
        boolean bool_1 = false;
        int int_0 = 0;
        final int int_1 = charsequence_0.length();
        int int_2 = 0;

        boolean bool_2;
        while (true) {
            if (int_2 >= int_1) {
                bool_2 = bool_1;
                break;
            }

            label86:
            {
                final char char_0 = charsequence_0.charAt(int_2);
                if (int_2 == 0) {
                    if (char_0 == 45) {
                        bool_0 = true;
                        break label86;
                    }

                    if (char_0 == 43) {
                        break label86;
                    }
                }

                int int_4;
                if ((char_0 >= 48) && (char_0 <= 57)) {
                    int_4 = char_0 - 48;
                } else if ((char_0 >= 65) && (char_0 <= 90)) {
                    int_4 = char_0 - 55;
                } else {
                    if ((char_0 < 97) || (char_0 > 122)) {
                        bool_2 = false;
                        break;
                    }

                    int_4 = char_0 - 87;
                }

                if (int_4 >= 10) {
                    bool_2 = false;
                    break;
                }

                if (bool_0) {
                    int_4 = -int_4;
                }

                final int int_3 = (int_0 * 10) + int_4;
                if (int_0 != (int_3 / 10)) {
                    bool_2 = false;
                    break;
                }

                int_0 = int_3;
                bool_1 = true;
            }

            ++int_2;
        }

        return bool_2;
    }

    static int method2238(int int_0, final Script script_0, final boolean bool_0) {
        int int_1 = -1;
        Widget widget_0;
        if (int_0 >= 2000) {
            int_0 -= 1000;
            int_1 = class69.intStack[--class69.intStackSize];
            widget_0 = Widget.getWidget(int_1);
        } else {
            widget_0 = bool_0 ? class276.field3561 : KitDefinition.field3301;
        }

        if (int_0 == 1100) {
            class69.intStackSize -= 2;
            widget_0.scrollX = class69.intStack[class69.intStackSize];
            if (widget_0.scrollX > (widget_0.scrollWidth - widget_0.width)) {
                widget_0.scrollX = widget_0.scrollWidth - widget_0.width;
            }

            if (widget_0.scrollX < 0) {
                widget_0.scrollX = 0;
            }

            widget_0.scrollY = class69.intStack[class69.intStackSize + 1];
            if (widget_0.scrollY > (widget_0.scrollHeight - widget_0.height)) {
                widget_0.scrollY = widget_0.scrollHeight - widget_0.height;
            }

            if (widget_0.scrollY < 0) {
                widget_0.scrollY = 0;
            }

            Player.method1114(widget_0);
            return 1;
        } else if (int_0 == 1101) {
            widget_0.textColor = class69.intStack[--class69.intStackSize];
            Player.method1114(widget_0);
            return 1;
        } else if (int_0 == 1102) {
            widget_0.filled = class69.intStack[--class69.intStackSize] == 1;
            Player.method1114(widget_0);
            return 1;
        } else if (int_0 == 1103) {
            int opacity = class69.intStack[--class69.intStackSize];
            if((widget_0.interfaceHash >> 16) == 100 && widget_0.itemId != -1) {
                //fixes alpha for placeholder items on the shop interface
                ItemComposition def = TextureProvider.getItemDefinition(widget_0.itemId);
                if(def.placeholderTemplateId != -1 && def.placeholderId != -1) {
                    if(opacity == 0) //default
                        opacity = 120;
                    else if(opacity == 100) //dim on click
                        opacity = 200;
                }
            }
            widget_0.opacity = opacity;
            Player.method1114(widget_0);
            return 1;
        } else if (int_0 == 1104) {
            widget_0.lineWidth = class69.intStack[--class69.intStackSize];
            Player.method1114(widget_0);
            return 1;
        } else if (int_0 == 1105) {
            widget_0.spriteId = class69.intStack[--class69.intStackSize];
            Player.method1114(widget_0);
            return 1;
        } else if (int_0 == 1106) {
            widget_0.textureId = class69.intStack[--class69.intStackSize];
            Player.method1114(widget_0);
            return 1;
        } else if (int_0 == 1107) {
            widget_0.spriteTiling = class69.intStack[--class69.intStackSize] == 1;
            Player.method1114(widget_0);
            return 1;
        } else if (int_0 == 1108) {
            widget_0.modelType = 1;
            widget_0.modelId = class69.intStack[--class69.intStackSize];
            Player.method1114(widget_0);
            return 1;
        } else if (int_0 == 1109) {
            class69.intStackSize -= 6;
            widget_0.offsetX2d = class69.intStack[class69.intStackSize];
            widget_0.offsetY2d = class69.intStack[class69.intStackSize + 1];
            widget_0.rotationX = class69.intStack[class69.intStackSize + 2];
            widget_0.rotationZ = class69.intStack[class69.intStackSize + 3];
            widget_0.rotationY = class69.intStack[class69.intStackSize + 4];
            widget_0.modelZoom = class69.intStack[class69.intStackSize + 5];
            Player.method1114(widget_0);
            return 1;
        } else {
            int int_2;
            if (int_0 == 1110) {
                int_2 = class69.intStack[--class69.intStackSize];
                if (int_2 != widget_0.field2595) {
                    widget_0.field2595 = int_2;
                    widget_0.field2728 = 0;
                    widget_0.field2613 = 0;
                    Player.method1114(widget_0);
                }

                return 1;
            } else if (int_0 == 1111) {
                widget_0.field2662 = class69.intStack[--class69.intStackSize] == 1;
                Player.method1114(widget_0);
                return 1;
            } else if (int_0 == 1112) {
                final String string_0 = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
                if (!string_0.equals(widget_0.text)) {
                    widget_0.text = string_0.replaceAll("RuneScape", Loader.SERVER_NAME);
                    if(string_0.equalsIgnoreCase("Membership: <col=ff0000>None</col>"))
                        return 1;
                    if(widget_0.interfaceHash >> 16 == 284) {
                        widget_0.text = string_0.replace("Learn More", "Vote Now").replace("Bond Pouch", "Hiscores");
                    }
                    Player.method1114(widget_0);
                }
                return 1;
            } else if (int_0 == 1113) {
                widget_0.fontId = class69.intStack[--class69.intStackSize];
                Player.method1114(widget_0);
                return 1;
            } else if (int_0 == 1114) {
                class69.intStackSize -= 3;
                widget_0.fontHorizontalAlignment = class69.intStack[class69.intStackSize];
                widget_0.fontVerticalAlignment = class69.intStack[class69.intStackSize + 1];
                widget_0.lineHeight = class69.intStack[class69.intStackSize + 2];
                Player.method1114(widget_0);
                return 1;
            } else if (int_0 == 1115) {
                widget_0.textShadowed = class69.intStack[--class69.intStackSize] == 1;
                Player.method1114(widget_0);
                return 1;
            } else if (int_0 == 1116) {
                widget_0.borderThickness = class69.intStack[--class69.intStackSize];
                Player.method1114(widget_0);
                return 1;
            } else if (int_0 == 1117) {
                widget_0.shadow = class69.intStack[--class69.intStackSize];
                Player.method1114(widget_0);
                return 1;
            } else if (int_0 == 1118) {
                widget_0.flippedVertically = class69.intStack[--class69.intStackSize] == 1;
                Player.method1114(widget_0);
                return 1;
            } else if (int_0 == 1119) {
                widget_0.flippedHorizontally = class69.intStack[--class69.intStackSize] == 1;
                Player.method1114(widget_0);
                return 1;
            } else if (int_0 == 1120) {
                class69.intStackSize -= 2;
                widget_0.scrollWidth = class69.intStack[class69.intStackSize];
                widget_0.scrollHeight = class69.intStack[class69.intStackSize + 1];
                ShopInterface.open(widget_0);
                Player.method1114(widget_0);
                if ((int_1 != -1) && (widget_0.type == 0)) {
                    GameSocket.method3388(GameCanvas.widgets[int_1 >> 16], widget_0, false);
                }

                return 1;
            } else if (int_0 == 1121) {
                Varcs.method1921(widget_0.interfaceHash, widget_0.index);
                Game.field744 = widget_0;
                Player.method1114(widget_0);
                return 1;
            } else if (int_0 == 1122) {
                widget_0.field2641 = class69.intStack[--class69.intStackSize];
                Player.method1114(widget_0);
                return 1;
            } else if (int_0 == 1123) {
                widget_0.field2631 = class69.intStack[--class69.intStackSize];
                Player.method1114(widget_0);
                return 1;
            } else if (int_0 == 1124) {
                widget_0.field2608 = class69.intStack[--class69.intStackSize];
                Player.method1114(widget_0);
                return 1;
            } else if (int_0 == 1125) {
                int_2 = class69.intStack[--class69.intStackSize];
                final class316 class316_0 = (class316) class76.forOrdinal(WorldMapRegion.method423(), int_2);
                if (class316_0 != null) {
                    widget_0.field2701 = class316_0;
                    Player.method1114(widget_0);
                }

                return 1;
            } else {
                boolean bool_1;
                if (int_0 == 1126) {
                    bool_1 = class69.intStack[--class69.intStackSize] == 1;
                    widget_0.field2639 = bool_1;
                    return 1;
                } else if (int_0 == 1127) {
                    bool_1 = class69.intStack[--class69.intStackSize] == 1;
                    widget_0.field2726 = bool_1;
                    return 1;
                } else {
                    return 2;
                }
            }
        }
    }

    static int method2248(final int int_0, int int_1) {
        if (int_0 == -1) {
            return 12345678;
        } else {
            int_1 = ((int_0 & 0x7F) * int_1) / 128;
            if (int_1 < 2) {
                int_1 = 2;
            } else if (int_1 > 126) {
                int_1 = 126;
            }

            return (int_0 & 0xFF80) + int_1;
        }
    }

}
