import java.util.Comparator;

public class class309 implements Comparator {

    public static int field3740;
    final boolean field3741;

    public class309(final boolean bool_0) {
        field3741 = bool_0;
    }

    int method5670(final Nameable nameable_0, final Nameable nameable_1) {
        return field3741 ? nameable_0.method5287().compareCleanName(nameable_1.method5287())
                : nameable_1.method5287().compareCleanName(nameable_0.method5287());
    }

    @Override
    public int compare(final Object object_0, final Object object_1) {
        return method5670((Nameable) object_0, (Nameable) object_1);
    }

    @Override
    public boolean equals(final Object object_0) {
        return super.equals(object_0);
    }

    static void method5674(final ScriptEvent scriptevent_0, final int int_0) {
        final Object[] objects_0 = scriptevent_0.objs;
        final int int_1 = scriptevent_0.field515;
        final boolean bool_0 = (int_1 == 10) || (int_1 == 11) || (int_1 == 12) || (int_1 == 13) || (int_1 == 14)
                || (int_1 == 15) || (int_1 == 16) || (int_1 == 17);
        int int_3;
        int int_4;
        int int_5;
        int int_6;
        Script script_2;
        int int_7;
        if (bool_0) {
            ClassInfo.field3750 = (MapIconReference) objects_0[0];
            final Area area_0 = Area.mapAreaType[ClassInfo.field3750.areaId];
            final int int_2 = scriptevent_0.field515;
            int_3 = area_0.id;
            int_4 = area_0.field3240;
            int_5 = WorldMapRectangle.method170(int_3, int_2);
            Script script_0 = GameObject.method3104(int_5, int_2);
            Script script_1;
            if (script_0 != null) {
                script_1 = script_0;
            } else {
                int_6 = int_2 + ((int_4 + 40000) << 8);
                script_0 = GameObject.method3104(int_6, int_2);
                if (script_0 != null) {
                    script_1 = script_0;
                } else {
                    script_1 = null;
                }
            }

            script_2 = script_1;
        } else {
            int_7 = ((Integer) objects_0[0]).intValue();
            script_2 = DecorativeObject.method3099(int_7);
        }

        if (script_2 != null) {
            class69.intStackSize = 0;
            WidgetNode.scriptStringStackSize = 0;
            int_7 = -1;
            int[] ints_2 = script_2.instructions;
            int[] ints_0 = script_2.intOperands;
            final byte byte_1 = -1;
            class69.scriptStackCount = 0;

            int int_8;
            try {
                class69.field1005 = new int[script_2.localIntCount];
                int_4 = 0;
                Frames.field1800 = new String[script_2.localStringCount];
                int_5 = 0;

                String string_0;
                for (int_8 = 1; int_8 < objects_0.length; int_8++) {
                    if (objects_0[int_8] instanceof Integer) {
                        int_6 = ((Integer) objects_0[int_8]).intValue();
                        if (int_6 == -2147483647) {
                            int_6 = scriptevent_0.field511;
                        }

                        if (int_6 == -2147483646) {
                            int_6 = scriptevent_0.field508;
                        }

                        if (int_6 == -2147483645) {
                            int_6 = scriptevent_0.widget != null ? scriptevent_0.widget.interfaceHash : -1;
                        }

                        if (int_6 == -2147483644) {
                            int_6 = scriptevent_0.field517;
                        }

                        if (int_6 == -2147483643) {
                            int_6 = scriptevent_0.widget != null ? scriptevent_0.widget.index : -1;
                        }

                        if (int_6 == -2147483642) {
                            int_6 = scriptevent_0.field507 != null ? scriptevent_0.field507.interfaceHash : -1;
                        }

                        if (int_6 == -2147483641) {
                            int_6 = scriptevent_0.field507 != null ? scriptevent_0.field507.index : -1;
                        }

                        if (int_6 == -2147483640) {
                            int_6 = scriptevent_0.pressedKey;
                        }

                        if (int_6 == -2147483639) {
                            int_6 = scriptevent_0.typedKey;
                        }

                        class69.field1005[int_4++] = int_6;
                    } else if (objects_0[int_8] instanceof String) {
                        string_0 = (String) objects_0[int_8];
                        if (string_0.equals("event_opbase")) {
                            string_0 = scriptevent_0.string;
                        }

                        Frames.field1800[int_5++] = string_0;
                    }
                }

                int_8 = 0;
                class69.field1009 = scriptevent_0.field514;

                while (true) {
                    while (true) {
                        while (true) {
                            while (true) {
                                while (true) {
                                    while (true) {
                                        while (true) {
                                            while (true) {
                                                while (true) {
                                                    while (true) {
                                                        while (true) {
                                                            while (true) {
                                                                while (true) {
                                                                    while (true) {
                                                                        while (true) {
                                                                            while (true) {
                                                                                while (true) {
                                                                                    while (true) {
                                                                                        while (true) {
                                                                                            while (true) {
                                                                                                while (true) {
                                                                                                    while (true) {
                                                                                                        while (true) {
                                                                                                            while (true) {
                                                                                                                while (true) {
                                                                                                                    label310:
                                                                                                                    while (true) {
                                                                                                                        ++int_8;
                                                                                                                        if (int_8 > int_0) {
                                                                                                                            throw new RuntimeException();
                                                                                                                        }

                                                                                                                        ++int_7;
                                                                                                                        int_3 = ints_2[int_7];
                                                                                                                        int int_10;
                                                                                                                        if (int_3 < 100) {
                                                                                                                            if (int_3 != 0) {
                                                                                                                                if (int_3 != 1) {
                                                                                                                                    if (int_3 != 2) {
                                                                                                                                        if (int_3 != 3) {
                                                                                                                                            if (int_3 != 6) {
                                                                                                                                                if (int_3 != 7) {
                                                                                                                                                    if (int_3 != 8) {
                                                                                                                                                        if (int_3 != 9) {
                                                                                                                                                            if (int_3 != 10) {
                                                                                                                                                                if (int_3 != 21) {
                                                                                                                                                                    if (int_3 != 25) {
                                                                                                                                                                        if (int_3 != 27) {
                                                                                                                                                                            if (int_3 != 31) {
                                                                                                                                                                                if (int_3 != 32) {
                                                                                                                                                                                    if (int_3 != 33) {
                                                                                                                                                                                        if (int_3 != 34) {
                                                                                                                                                                                            if (int_3 != 35) {
                                                                                                                                                                                                if (int_3 != 36) {
                                                                                                                                                                                                    if (int_3 != 37) {
                                                                                                                                                                                                        if (int_3 != 38) {
                                                                                                                                                                                                            if (int_3 != 39) {
                                                                                                                                                                                                                int int_9;
                                                                                                                                                                                                                if (int_3 != 40) {
                                                                                                                                                                                                                    if (int_3 != 42) {
                                                                                                                                                                                                                        if (int_3 != 43) {
                                                                                                                                                                                                                            if (int_3 == 44) {
                                                                                                                                                                                                                                int_6 = ints_0[int_7] >> 16;
                                                                                                                                                                                                                                int_10 = ints_0[int_7]
                                                                                                                                                                                                                                        & 0xFFFF;
                                                                                                                                                                                                                                final int int_11 = class69.intStack[--class69.intStackSize];
                                                                                                                                                                                                                                if ((int_11 >= 0)
                                                                                                                                                                                                                                        && (int_11 <= 5000)) {
                                                                                                                                                                                                                                    class69.field1000[int_6] = int_11;
                                                                                                                                                                                                                                    byte byte_0 = -1;
                                                                                                                                                                                                                                    if (int_10 == 105) {
                                                                                                                                                                                                                                        byte_0 = 0;
                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                    int_9 = 0;

                                                                                                                                                                                                                                    while (true) {
                                                                                                                                                                                                                                        if (int_9 >= int_11) {
                                                                                                                                                                                                                                            continue label310;
                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                        class69.SHAPE_VERTICES[int_6][int_9] = byte_0;
                                                                                                                                                                                                                                        ++int_9;
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                throw new RuntimeException();
                                                                                                                                                                                                                            } else if (int_3 == 45) {
                                                                                                                                                                                                                                int_6 = ints_0[int_7];
                                                                                                                                                                                                                                int_10 = class69.intStack[--class69.intStackSize];
                                                                                                                                                                                                                                if ((int_10 < 0)
                                                                                                                                                                                                                                        || (int_10 >= class69.field1000[int_6])) {
                                                                                                                                                                                                                                    throw new RuntimeException();
                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                class69.intStack[++class69.intStackSize
                                                                                                                                                                                                                                        - 1] = class69.SHAPE_VERTICES[int_6][int_10];
                                                                                                                                                                                                                            } else if (int_3 == 46) {
                                                                                                                                                                                                                                int_6 = ints_0[int_7];
                                                                                                                                                                                                                                class69.intStackSize -= 2;
                                                                                                                                                                                                                                int_10 = class69.intStack[class69.intStackSize];
                                                                                                                                                                                                                                if ((int_10 < 0)
                                                                                                                                                                                                                                        || (int_10 >= class69.field1000[int_6])) {
                                                                                                                                                                                                                                    throw new RuntimeException();
                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                class69.SHAPE_VERTICES[int_6][int_10] = class69.intStack[class69.intStackSize
                                                                                                                                                                                                                                        + 1];
                                                                                                                                                                                                                            } else if (int_3 == 47) {
                                                                                                                                                                                                                                string_0 = MapLabel.varcs
                                                                                                                                                                                                                                        .getVarcString(
                                                                                                                                                                                                                                                ints_0[int_7]);
                                                                                                                                                                                                                                if (string_0 == null) {
                                                                                                                                                                                                                                    string_0 = "null";
                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                class69.scriptStringStack[++WidgetNode.scriptStringStackSize
                                                                                                                                                                                                                                        - 1] = string_0;
                                                                                                                                                                                                                            } else if (int_3 == 48) {
                                                                                                                                                                                                                                MapLabel.varcs
                                                                                                                                                                                                                                        .putVarcString(
                                                                                                                                                                                                                                                ints_0[int_7],
                                                                                                                                                                                                                                                class69.scriptStringStack[--WidgetNode.scriptStringStackSize]);
                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                if (int_3 != 60) {
                                                                                                                                                                                                                                    throw new IllegalStateException();
                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                final IterableHashTable iterablehashtable_0 = script_2.switches[ints_0[int_7]];
                                                                                                                                                                                                                                final IntegerNode integernode_0 = (IntegerNode) iterablehashtable_0
                                                                                                                                                                                                                                        .get(class69.intStack[--class69.intStackSize]);
                                                                                                                                                                                                                                if (integernode_0 != null) {
                                                                                                                                                                                                                                    int_7 += integernode_0.value;
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        } else {
                                                                                                                                                                                                                            MapLabel.varcs
                                                                                                                                                                                                                                    .putVarc(
                                                                                                                                                                                                                                            ints_0[int_7],
                                                                                                                                                                                                                                            class69.intStack[--class69.intStackSize]);
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                        class69.intStack[++class69.intStackSize
                                                                                                                                                                                                                                - 1] = MapLabel.varcs
                                                                                                                                                                                                                                .getVarc(
                                                                                                                                                                                                                                        ints_0[int_7]);
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                } else {
                                                                                                                                                                                                                    int_6 = ints_0[int_7];
                                                                                                                                                                                                                    final Script script_3 = DecorativeObject
                                                                                                                                                                                                                            .method3099(
                                                                                                                                                                                                                                    int_6);
                                                                                                                                                                                                                    final int[] ints_1 = new int[script_3.localIntCount];
                                                                                                                                                                                                                    final String[] strings_0 = new String[script_3.localStringCount];

                                                                                                                                                                                                                    for (int_9 = 0; int_9 < script_3.intStackCount; int_9++) {
                                                                                                                                                                                                                        ints_1[int_9] = class69.intStack[int_9
                                                                                                                                                                                                                                + (class69.intStackSize
                                                                                                                                                                                                                                - script_3.intStackCount)];
                                                                                                                                                                                                                    }

                                                                                                                                                                                                                    for (int_9 = 0; int_9 < script_3.stringStackCount; int_9++) {
                                                                                                                                                                                                                        strings_0[int_9] = class69.scriptStringStack[int_9
                                                                                                                                                                                                                                + (WidgetNode.scriptStringStackSize
                                                                                                                                                                                                                                - script_3.stringStackCount)];
                                                                                                                                                                                                                    }

                                                                                                                                                                                                                    class69.intStackSize -= script_3.intStackCount;
                                                                                                                                                                                                                    WidgetNode.scriptStringStackSize -= script_3.stringStackCount;
                                                                                                                                                                                                                    final class51 class51_0 = new class51();
                                                                                                                                                                                                                    class51_0.field466 = script_2;
                                                                                                                                                                                                                    class51_0.field463 = int_7;
                                                                                                                                                                                                                    class51_0.field462 = class69.field1005;
                                                                                                                                                                                                                    class51_0.field465 = Frames.field1800;
                                                                                                                                                                                                                    class69.scriptStack[++class69.scriptStackCount
                                                                                                                                                                                                                            - 1] = class51_0;
                                                                                                                                                                                                                    script_2 = script_3;
                                                                                                                                                                                                                    ints_2 = script_3.instructions;
                                                                                                                                                                                                                    ints_0 = script_3.intOperands;
                                                                                                                                                                                                                    int_7 = -1;
                                                                                                                                                                                                                    class69.field1005 = ints_1;
                                                                                                                                                                                                                    Frames.field1800 = strings_0;
                                                                                                                                                                                                                }
                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                --WidgetNode.scriptStringStackSize;
                                                                                                                                                                                                            }
                                                                                                                                                                                                        } else {
                                                                                                                                                                                                            --class69.intStackSize;
                                                                                                                                                                                                        }
                                                                                                                                                                                                    } else {
                                                                                                                                                                                                        int_6 = ints_0[int_7];
                                                                                                                                                                                                        WidgetNode.scriptStringStackSize -= int_6;
                                                                                                                                                                                                        final String string_1 = class251
                                                                                                                                                                                                                .method4794(
                                                                                                                                                                                                                        class69.scriptStringStack,
                                                                                                                                                                                                                        WidgetNode.scriptStringStackSize,
                                                                                                                                                                                                                        int_6);
                                                                                                                                                                                                        class69.scriptStringStack[++WidgetNode.scriptStringStackSize
                                                                                                                                                                                                                - 1] = string_1;
                                                                                                                                                                                                    }
                                                                                                                                                                                                } else {
                                                                                                                                                                                                    Frames.field1800[ints_0[int_7]] = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
                                                                                                                                                                                                }
                                                                                                                                                                                            } else {
                                                                                                                                                                                                class69.scriptStringStack[++WidgetNode.scriptStringStackSize
                                                                                                                                                                                                        - 1] = Frames.field1800[ints_0[int_7]];
                                                                                                                                                                                            }
                                                                                                                                                                                        } else {
                                                                                                                                                                                            class69.field1005[ints_0[int_7]] = class69.intStack[--class69.intStackSize];
                                                                                                                                                                                        }
                                                                                                                                                                                    } else {
                                                                                                                                                                                        class69.intStack[++class69.intStackSize
                                                                                                                                                                                                - 1] = class69.field1005[ints_0[int_7]];
                                                                                                                                                                                    }
                                                                                                                                                                                } else {
                                                                                                                                                                                    class69.intStackSize -= 2;
                                                                                                                                                                                    if (class69.intStack[class69.intStackSize] >= class69.intStack[class69.intStackSize
                                                                                                                                                                                            + 1]) {
                                                                                                                                                                                        int_7 += ints_0[int_7];
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            } else {
                                                                                                                                                                                class69.intStackSize -= 2;
                                                                                                                                                                                if (class69.intStack[class69.intStackSize] <= class69.intStack[class69.intStackSize
                                                                                                                                                                                        + 1]) {
                                                                                                                                                                                    int_7 += ints_0[int_7];
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        } else {
                                                                                                                                                                            int_6 = ints_0[int_7];
                                                                                                                                                                            FriendManager
                                                                                                                                                                                    .method1685(
                                                                                                                                                                                            int_6,
                                                                                                                                                                                            class69.intStack[--class69.intStackSize]);
                                                                                                                                                                        }
                                                                                                                                                                    } else {
                                                                                                                                                                        int_6 = ints_0[int_7];
                                                                                                                                                                        class69.intStack[++class69.intStackSize
                                                                                                                                                                                - 1] = GameSocket
                                                                                                                                                                                .getVarbit(
                                                                                                                                                                                        int_6);
                                                                                                                                                                    }
                                                                                                                                                                } else {
                                                                                                                                                                    if (class69.scriptStackCount == 0) {
                                                                                                                                                                        return;
                                                                                                                                                                    }

                                                                                                                                                                    final class51 class51_1 = class69.scriptStack[--class69.scriptStackCount];
                                                                                                                                                                    script_2 = class51_1.field466;
                                                                                                                                                                    ints_2 = script_2.instructions;
                                                                                                                                                                    ints_0 = script_2.intOperands;
                                                                                                                                                                    int_7 = class51_1.field463;
                                                                                                                                                                    class69.field1005 = class51_1.field462;
                                                                                                                                                                    Frames.field1800 = class51_1.field465;
                                                                                                                                                                }
                                                                                                                                                            } else {
                                                                                                                                                                class69.intStackSize -= 2;
                                                                                                                                                                if (class69.intStack[class69.intStackSize] > class69.intStack[class69.intStackSize
                                                                                                                                                                        + 1]) {
                                                                                                                                                                    int_7 += ints_0[int_7];
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        } else {
                                                                                                                                                            class69.intStackSize -= 2;
                                                                                                                                                            if (class69.intStack[class69.intStackSize] < class69.intStack[class69.intStackSize
                                                                                                                                                                    + 1]) {
                                                                                                                                                                int_7 += ints_0[int_7];
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    } else {
                                                                                                                                                        class69.intStackSize -= 2;
                                                                                                                                                        if (class69.intStack[class69.intStackSize] == class69.intStack[class69.intStackSize
                                                                                                                                                                + 1]) {
                                                                                                                                                            int_7 += ints_0[int_7];
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                } else {
                                                                                                                                                    class69.intStackSize -= 2;
                                                                                                                                                    if (class69.intStack[class69.intStackSize] != class69.intStack[class69.intStackSize
                                                                                                                                                            + 1]) {
                                                                                                                                                        int_7 += ints_0[int_7];
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            } else {
                                                                                                                                                int_7 += ints_0[int_7];
                                                                                                                                            }
                                                                                                                                        } else {
                                                                                                                                            class69.scriptStringStack[++WidgetNode.scriptStringStackSize
                                                                                                                                                    - 1] = script_2.stringOperands[int_7];
                                                                                                                                        }
                                                                                                                                    } else {
                                                                                                                                        int_6 = ints_0[int_7];
                                                                                                                                        class225.clientVarps[int_6] = class69.intStack[--class69.intStackSize];
                                                                                                                                        class45.method749(
                                                                                                                                                int_6);
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    int_6 = ints_0[int_7];
                                                                                                                                    class69.intStack[++class69.intStackSize
                                                                                                                                            - 1] = class225.clientVarps[int_6];
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                class69.intStack[++class69.intStackSize
                                                                                                                                        - 1] = ints_0[int_7];
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            boolean bool_1;
                                                                                                                            bool_1 = script_2.intOperands[int_7] == 1;

                                                                                                                            int_10 = class191
                                                                                                                                    .method3866(
                                                                                                                                            int_3,
                                                                                                                                            script_2,
                                                                                                                                            bool_1);
                                                                                                                            switch (int_10) {
                                                                                                                                case 0:
                                                                                                                                    return;
                                                                                                                                case 1:
                                                                                                                                default:
                                                                                                                                    break;
                                                                                                                                case 2:
                                                                                                                                    throw new IllegalStateException(int_3 + " " + script_2.id);
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
            } catch (final Exception exception_0) {
                final StringBuilder stringbuilder_0 = new StringBuilder(30);
                stringbuilder_0.append(script_2.hash).append(" ");

                for (int_8 = class69.scriptStackCount - 1; int_8 >= 0; --int_8) {
                    stringbuilder_0.append(class69.scriptStack[int_8].field466.hash).append(" ");
                }

                stringbuilder_0.append(byte_1);
                UnitPriceComparator.processClientError(stringbuilder_0.toString(), exception_0);
            }
        }
    }

    static synchronized void method5671(final byte[] bytes_0) {
        if ((bytes_0.length == 100) && (class183.field2344 < 1000)) {
            class183.field2340[++class183.field2344 - 1] = bytes_0;
        } else if ((bytes_0.length == 5000) && (class183.field2346 < 250)) {
            class183.field2343[++class183.field2346 - 1] = bytes_0;
        } else if ((bytes_0.length == 30000) && (class183.field2342 < 50)) {
            class183.field2345[++class183.field2342 - 1] = bytes_0;
        } else {
            if (class183.field2341 != null) {
                for (int int_0 = 0; int_0 < class183.field2348.length; int_0++) {
                    if ((bytes_0.length == class183.field2348[int_0])
                            && (class183.field2347[int_0] < class183.field2341[int_0].length)) {
                        class183.field2341[int_0][class183.field2347[int_0]++] = bytes_0;
                        return;
                    }
                }
            }

        }
    }

}
