import java.io.*;
import java.net.URL;
import java.util.Comparator;

final class UnitPriceComparator implements Comparator {

    int method58(final GrandExchangeEvent grandexchangeevent_0, final GrandExchangeEvent grandexchangeevent_1) {
        return grandexchangeevent_0.grandExchangeOffer.price < grandexchangeevent_1.grandExchangeOffer.price ? -1
                : (grandexchangeevent_1.grandExchangeOffer.price == grandexchangeevent_0.grandExchangeOffer.price ? 0
                : 1);
    }

    @Override
    public boolean equals(final Object object_0) {
        return super.equals(object_0);
    }

    @Override
    public int compare(final Object object_0, final Object object_1) {
        return method58((GrandExchangeEvent) object_0, (GrandExchangeEvent) object_1);
    }

    public static void processClientError(final String string_0, final Throwable throwable_0) {
        if(true) {
            System.err.println(string_0);
            throwable_0.printStackTrace();
            return;
        }
        if (throwable_0 != null) {
            throwable_0.printStackTrace();
        } else {
            try {
                String string_1 = "";
                if (throwable_0 != null) {
                    Throwable throwable_1 = throwable_0;
                    String string_2;
                    if (throwable_0 instanceof RunException) {
                        final RunException runexception_0 = (RunException) throwable_0;
                        string_2 = runexception_0.field1941 + " | ";
                        throwable_1 = runexception_0.parent;
                    } else {
                        string_2 = "";
                    }

                    final StringWriter stringwriter_0 = new StringWriter();
                    final PrintWriter printwriter_0 = new PrintWriter(stringwriter_0);
                    throwable_1.printStackTrace(printwriter_0);
                    printwriter_0.close();
                    final String string_3 = stringwriter_0.toString();
                    final BufferedReader bufferedreader_0 = new BufferedReader(new StringReader(string_3));
                    final String string_4 = bufferedreader_0.readLine();

                    label63:
                    while (true) {
                        while (true) {
                            String string_5 = bufferedreader_0.readLine();
                            if (string_5 == null) {
                                string_2 = string_2 + "| " + string_4;
                                string_1 = string_2;
                                break label63;
                            }

                            final int int_0 = string_5.indexOf(40);
                            final int int_1 = string_5.indexOf(41, int_0 + 1);
                            if ((int_0 >= 0) && (int_1 >= 0)) {
                                String string_6 = string_5.substring(int_0 + 1, int_1);
                                final int int_2 = string_6.indexOf(".java:");
                                if (int_2 >= 0) {
                                    string_6 = string_6.substring(0, int_2) + string_6.substring(int_2 + 5);
                                    string_2 = string_2 + string_6 + ' ';
                                    continue;
                                }

                                string_5 = string_5.substring(0, int_0);
                            }

                            string_5 = string_5.trim();
                            string_5 = string_5.substring(string_5.lastIndexOf(32) + 1);
                            string_5 = string_5.substring(string_5.lastIndexOf(9) + 1);
                            string_2 = string_2 + string_5 + ' ';
                        }
                    }
                }

                if (string_0 != null) {
                    if (throwable_0 != null) {
                        string_1 = string_1 + " | ";
                    }

                    string_1 = string_1 + string_0;
                }

                System.out.println("Error: " + string_1);
                string_1 = string_1.replace(':', '.');
                string_1 = string_1.replace('@', '_');
                string_1 = string_1.replace('&', '_');
                string_1 = string_1.replace('#', '_');
                if (RunException.field1938 == null) {
                    return;
                }

                final URL url_0 = new URL(RunException.field1938.getCodeBase(),
                        "clienterror.ws?c=" + GameCanvas.revision + "&u=" + RunException.field1939 + "&v1="
                                + Signlink.javaVendor + "&v2=" + Signlink.javaVersion + "&ct=" + RunException.field1940
                                + "&e=" + string_1);
                final DataInputStream datainputstream_0 = new DataInputStream(url_0.openStream());
                datainputstream_0.read();
                datainputstream_0.close();
            } catch (final Exception exception_0) {
            }

        }
    }

    static int method59(final int int_0, final Script script_0, final boolean bool_0) {
        if (int_0 == 6500) {
            class69.intStack[++class69.intStackSize - 1] = GrandExchangeOffer.loadWorlds() ? 1 : 0;
            return 1;
        } else {
            World world_0;
            if (int_0 == 6501) {
                World.field944 = 0;
                world_0 = class236.method4592();
                if (world_0 != null) {
                    class69.intStack[++class69.intStackSize - 1] = world_0.id;
                    class69.intStack[++class69.intStackSize - 1] = world_0.mask;
                    class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = world_0.activity;
                    class69.intStack[++class69.intStackSize - 1] = world_0.location;
                    class69.intStack[++class69.intStackSize - 1] = world_0.playerCount;
                    class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = world_0.address;
                } else {
                    class69.intStack[++class69.intStackSize - 1] = -1;
                    class69.intStack[++class69.intStackSize - 1] = 0;
                    class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = "";
                    class69.intStack[++class69.intStackSize - 1] = 0;
                    class69.intStack[++class69.intStackSize - 1] = 0;
                    class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = "";
                }

                return 1;
            } else if (int_0 == 6502) {
                world_0 = class236.method4592();
                if (world_0 != null) {
                    class69.intStack[++class69.intStackSize - 1] = world_0.id;
                    class69.intStack[++class69.intStackSize - 1] = world_0.mask;
                    class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = world_0.activity;
                    class69.intStack[++class69.intStackSize - 1] = world_0.location;
                    class69.intStack[++class69.intStackSize - 1] = world_0.playerCount;
                    class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = world_0.address;
                } else {
                    class69.intStack[++class69.intStackSize - 1] = -1;
                    class69.intStack[++class69.intStackSize - 1] = 0;
                    class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = "";
                    class69.intStack[++class69.intStackSize - 1] = 0;
                    class69.intStack[++class69.intStackSize - 1] = 0;
                    class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = "";
                }

                return 1;
            } else {
                World world_1;
                int int_1;
                int int_2;
                if (int_0 == 6506) {
                    int_1 = class69.intStack[--class69.intStackSize];
                    world_1 = null;

                    for (int_2 = 0; int_2 < World.worldCount; int_2++) {
                        if (int_1 == World.worldList[int_2].id) {
                            world_1 = World.worldList[int_2];
                            break;
                        }
                    }

                    if (world_1 != null) {
                        class69.intStack[++class69.intStackSize - 1] = world_1.id;
                        class69.intStack[++class69.intStackSize - 1] = world_1.mask;
                        class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = world_1.activity;
                        class69.intStack[++class69.intStackSize - 1] = world_1.location;
                        class69.intStack[++class69.intStackSize - 1] = world_1.playerCount;
                        class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = world_1.address;
                    } else {
                        class69.intStack[++class69.intStackSize - 1] = -1;
                        class69.intStack[++class69.intStackSize - 1] = 0;
                        class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = "";
                        class69.intStack[++class69.intStackSize - 1] = 0;
                        class69.intStack[++class69.intStackSize - 1] = 0;
                        class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = "";
                    }

                    return 1;
                } else if (int_0 == 6507) {
                    class69.intStackSize -= 4;
                    int_1 = class69.intStack[class69.intStackSize];
                    final boolean bool_2 = class69.intStack[class69.intStackSize + 1] == 1;
                    int_2 = class69.intStack[class69.intStackSize + 2];
                    final boolean bool_1 = class69.intStack[class69.intStackSize + 3] == 1;
                    if (World.worldList != null) {
                        class120.method2781(0, World.worldList.length - 1, int_1, bool_2, int_2, bool_1);
                    }

                    return 1;
                } else if (int_0 != 6511) {
                    if (int_0 == 6512) {
                        Game.field725 = class69.intStack[--class69.intStackSize] == 1;
                        return 1;
                    } else {
                        int int_3;
                        class264 class264_0;
                        if (int_0 == 6513) {
                            class69.intStackSize -= 2;
                            int_1 = class69.intStack[class69.intStackSize];
                            int_3 = class69.intStack[class69.intStackSize + 1];
                            class264_0 = class241.method4603(int_3);
                            if (class264_0.method4951()) {
                                class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = HorizontalAlignment
                                        .getNpcDefinition(int_1).method5167(int_3, class264_0.field3333);
                            } else {
                                class69.intStack[++class69.intStackSize - 1] = HorizontalAlignment
                                        .getNpcDefinition(int_1).method5166(int_3, class264_0.field3330);
                            }

                            return 1;
                        } else if (int_0 == 6514) {
                            class69.intStackSize -= 2;
                            int_1 = class69.intStack[class69.intStackSize];
                            int_3 = class69.intStack[class69.intStackSize + 1];
                            class264_0 = class241.method4603(int_3);
                            if (class264_0.method4951()) {
                                class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = FileOnDisk
                                        .getObjectDefinition(int_1).method5036(int_3, class264_0.field3333);
                            } else {
                                class69.intStack[++class69.intStackSize - 1] = FileOnDisk.getObjectDefinition(int_1)
                                        .method5035(int_3, class264_0.field3330);
                            }

                            return 1;
                        } else if (int_0 == 6515) {
                            class69.intStackSize -= 2;
                            int_1 = class69.intStack[class69.intStackSize];
                            int_3 = class69.intStack[class69.intStackSize + 1];
                            class264_0 = class241.method4603(int_3);
                            if (class264_0.method4951()) {
                                class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = TextureProvider
                                        .getItemDefinition(int_1).method5121(int_3, class264_0.field3333);
                            } else {
                                class69.intStack[++class69.intStackSize - 1] = TextureProvider.getItemDefinition(int_1)
                                        .method5099(int_3, class264_0.field3330);
                            }

                            return 1;
                        } else if (int_0 == 6516) {
                            class69.intStackSize -= 2;
                            int_1 = class69.intStack[class69.intStackSize];
                            int_3 = class69.intStack[class69.intStackSize + 1];
                            class264_0 = class241.method4603(int_3);
                            int int_4;
                            class265 class265_0;
                            class265 class265_1;
                            byte[] bytes_0;
                            if (class264_0.method4951()) {
                                final String[] strings_0 = class69.scriptStringStack;
                                int_4 = ++WidgetNode.scriptStringStackSize - 1;
                                class265_0 = (class265) class265.field3334.get(int_1);
                                if (class265_0 != null) {
                                    class265_1 = class265_0;
                                } else {
                                    bytes_0 = class7.field42.getConfigData(34, int_1);
                                    class265_0 = new class265();
                                    if (bytes_0 != null) {
                                        class265_0.method4960(new Buffer(bytes_0));
                                    }

                                    class265_0.method4961();
                                    class265.field3334.put(class265_0, int_1);
                                    class265_1 = class265_0;
                                }

                                strings_0[int_4] = class265_1.method4963(int_3, class264_0.field3333);
                            } else {
                                final int[] ints_0 = class69.intStack;
                                int_4 = ++class69.intStackSize - 1;
                                class265_0 = (class265) class265.field3334.get(int_1);
                                if (class265_0 != null) {
                                    class265_1 = class265_0;
                                } else {
                                    bytes_0 = class7.field42.getConfigData(34, int_1);
                                    class265_0 = new class265();
                                    if (bytes_0 != null) {
                                        class265_0.method4960(new Buffer(bytes_0));
                                    }

                                    class265_0.method4961();
                                    class265.field3334.put(class265_0, int_1);
                                    class265_1 = class265_0;
                                }

                                ints_0[int_4] = class265_1.method4962(int_3, class264_0.field3330);
                            }

                            return 1;
                        } else if (int_0 == 6518) {
                            class69.intStack[++class69.intStackSize - 1] = Game.field588 ? 1 : 0;
                            return 1;
                        } else if (int_0 == 6519) {
                            class69.intStack[++class69.intStackSize - 1] = Game.field587 & 3;
                            return 1;
                        } else if (int_0 == 6520) {
                            return 1;
                        } else if (int_0 == 6521) {
                            return 1;
                        } else if (int_0 == 6522) {
                            --WidgetNode.scriptStringStackSize;
                            --class69.intStackSize;
                            return 1;
                        } else if (int_0 == 6523) {
                            --WidgetNode.scriptStringStackSize;
                            --class69.intStackSize;
                            return 1;
                        } else if (int_0 == 6524) {
                            class69.intStack[++class69.intStackSize - 1] = -1;
                            return 1;
                        } else if (int_0 == 6525) {
                            class69.intStack[++class69.intStackSize - 1] = 1;
                            return 1;
                        } else if (int_0 == 6526) {
                            class69.intStack[++class69.intStackSize - 1] = 1;
                            return 1;
                        } else {
                            return 2;
                        }
                    }
                } else {
                    int_1 = class69.intStack[--class69.intStackSize];
                    if ((int_1 >= 0) && (int_1 < World.worldCount)) {
                        world_1 = World.worldList[int_1];
                        class69.intStack[++class69.intStackSize - 1] = world_1.id;
                        class69.intStack[++class69.intStackSize - 1] = world_1.mask;
                        class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = world_1.activity;
                        class69.intStack[++class69.intStackSize - 1] = world_1.location;
                        class69.intStack[++class69.intStackSize - 1] = world_1.playerCount;
                        class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = world_1.address;
                    } else {
                        class69.intStack[++class69.intStackSize - 1] = -1;
                        class69.intStack[++class69.intStackSize - 1] = 0;
                        class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = "";
                        class69.intStack[++class69.intStackSize - 1] = 0;
                        class69.intStack[++class69.intStackSize - 1] = 0;
                        class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = "";
                    }

                    return 1;
                }
            }
        }
    }

}
