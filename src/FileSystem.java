public class FileSystem extends Node {

    static int field3154;
    int type;
    byte[] field3149;
    IndexFile index;
    IndexData data;

    static void updateNpcs(final boolean bool_0, final PacketBuffer packetbuffer_0) {
        Game.field701 = 0;
        Game.pendingNpcFlagsCount = 0;
        final PacketBuffer packetbuffer_1 = Game.field626.packetBuffer;
        packetbuffer_1.bitAccess();
        int int_0 = packetbuffer_1.getBits(8);
        int int_1;
        if (int_0 < Game.npcIndexesCount) {
            for (int_1 = int_0; int_1 < Game.npcIndexesCount; int_1++) {
                Game.field702[++Game.field701 - 1] = Game.npcIndices[int_1];
            }
        }

        if (int_0 > Game.npcIndexesCount) {
            throw new RuntimeException("");
        } else {
            Game.npcIndexesCount = 0;

            int int_2;
            int int_3;
            int int_6;
            int int_7;
            int int_8;
            int int_9;
            for (int_1 = 0; int_1 < int_0; int_1++) {
                int_2 = Game.npcIndices[int_1];
                final NPC npc_0 = Game.cachedNPCs[int_2];
                int_3 = packetbuffer_1.getBits(1);
                if (int_3 == 0) {
                    Game.npcIndices[++Game.npcIndexesCount - 1] = int_2;
                    npc_0.npcCycle = Game.gameCycle;
                } else {
                    int_6 = packetbuffer_1.getBits(2);
                    if (int_6 == 0) {
                        Game.npcIndices[++Game.npcIndexesCount - 1] = int_2;
                        npc_0.npcCycle = Game.gameCycle;
                        Game.pendingNpcFlagsIndices[++Game.pendingNpcFlagsCount - 1] = int_2;
                    } else if (int_6 == 1) {
                        Game.npcIndices[++Game.npcIndexesCount - 1] = int_2;
                        npc_0.npcCycle = Game.gameCycle;
                        int_7 = packetbuffer_1.getBits(3);
                        npc_0.method1794(int_7, (byte) 1);
                        int_8 = packetbuffer_1.getBits(1);
                        if (int_8 == 1) {
                            Game.pendingNpcFlagsIndices[++Game.pendingNpcFlagsCount - 1] = int_2;
                        }
                    } else if (int_6 == 2) {
                        Game.npcIndices[++Game.npcIndexesCount - 1] = int_2;
                        npc_0.npcCycle = Game.gameCycle;
                        int_7 = packetbuffer_1.getBits(3);
                        npc_0.method1794(int_7, (byte) 2);
                        int_8 = packetbuffer_1.getBits(3);
                        npc_0.method1794(int_8, (byte) 2);
                        int_9 = packetbuffer_1.getBits(1);
                        if (int_9 == 1) {
                            Game.pendingNpcFlagsIndices[++Game.pendingNpcFlagsCount - 1] = int_2;
                        }
                    } else if (int_6 == 3) {
                        Game.field702[++Game.field701 - 1] = int_2;
                    }
                }
            }

            WorldMapManager.method500(bool_0, packetbuffer_0);

            int int_4;
            for (int_4 = 0; int_4 < Game.pendingNpcFlagsCount; int_4++) {
                int_0 = Game.pendingNpcFlagsIndices[int_4];
                final NPC npc_1 = Game.cachedNPCs[int_0];
                int_2 = packetbuffer_0.readUnsignedByte();
                int int_5;
                if ((int_2 & 0x4) != 0) { //gfx
                    npc_1.graphic = packetbuffer_0.readUnsignedLEShortA();
                    int_5 = packetbuffer_0.readInt1();
                    npc_1.field871 = int_5 >> 16;
                    npc_1.graphicsDelay = (int_5 & 0xFFFF) + Game.gameCycle;
                    npc_1.spotAnimFrame = 0;
                    npc_1.spotAnimFrameCycle = 0;
                    if (npc_1.graphicsDelay > Game.gameCycle) {
                        npc_1.spotAnimFrame = -1;
                    }

                    if (npc_1.graphic == 65535) {
                        npc_1.graphic = -1;
                    }
                }

                if ((int_2 & 0x1) != 0) { //face coords
                    int_5 = packetbuffer_0.readUnsignedLEShort();
                    int_3 = packetbuffer_0.readUnsignedLEShort();
                    int_6 = npc_1.x - ((int_5 - PendingSpawn.baseX - PendingSpawn.baseX) * 64);
                    int_7 = npc_1.y - ((int_3 - Game.baseY - Game.baseY) * 64);
                    if ((int_6 != 0) || (int_7 != 0)) {
                        npc_1.field920 = (int) (Math.atan2(int_6, int_7) * 325.949D) & 0x7FF;
                    }
                }

                if ((int_2 & 0x40) != 0) { //hits
                    int_5 = packetbuffer_0.readUnsignedByteA();
                    int int_10;
                    if (int_5 > 0) {
                        for (int_3 = 0; int_3 < int_5; int_3++) {
                            int_7 = -1;
                            int_8 = -1;
                            int_9 = -1;
                            int_6 = packetbuffer_0.getUSmart();
                            if (int_6 == 32767) {
                                int_6 = packetbuffer_0.getUSmart();
                                int_8 = packetbuffer_0.getUSmart();
                                int_7 = packetbuffer_0.getUSmart();
                                int_9 = packetbuffer_0.getUSmart();
                            } else if (int_6 != 32766) {
                                int_8 = packetbuffer_0.getUSmart();
                            } else {
                                int_6 = -1;
                            }

                            int_10 = packetbuffer_0.getUSmart();
                            npc_1.applyActorHitsplat(int_6, int_8, int_7, int_9, Game.gameCycle, int_10);
                        }
                    }

                    int_3 = packetbuffer_0.readUnsignedByteA();
                    if (int_3 > 0) {
                        for (int_6 = 0; int_6 < int_3; int_6++) {
                            int_7 = packetbuffer_0.getUSmart();
                            int_8 = packetbuffer_0.getUSmart();
                            if (int_8 != 32767) {
                                int_9 = packetbuffer_0.getUSmart();
                                int_10 = packetbuffer_0.readUnsignedByteS();
                                final int int_11 = int_8 > 0 ? packetbuffer_0.readUnsignedByteS() : int_10;
                                npc_1.setCombatInfo(int_7, Game.gameCycle, int_8, int_9, int_10, int_11);
                            } else {
                                npc_1.method1557(int_7);
                            }
                        }
                    }
                }

                if ((int_2 & 0x8) != 0) { //transform
                    npc_1.composition = HorizontalAlignment.getNpcDefinition(packetbuffer_0.readUnsignedShortA());
                    npc_1.field874 = npc_1.composition.size;
                    npc_1.field924 = npc_1.composition.rotation;
                    npc_1.field899 = npc_1.composition.walkingAnimation;
                    npc_1.field880 = npc_1.composition.rotate180Animation;
                    npc_1.field870 = npc_1.composition.rotate90RightAnimation;
                    npc_1.field882 = npc_1.composition.rotate90LeftAnimation;
                    npc_1.idlePoseAnimation = npc_1.composition.standingAnimation;
                    npc_1.field877 = npc_1.composition.field3496;
                    npc_1.field878 = npc_1.composition.field3486;
                }

                if ((int_2 & 0x10) != 0) { //face entity
                    npc_1.interacting = packetbuffer_0.readUnsignedLEShort();
                    if (npc_1.interacting == 65535) {
                        npc_1.interacting = -1;
                    }
                }

                if ((int_2 & 0x20) != 0) { //anim
                    int_5 = packetbuffer_0.readUnsignedShortA();
                    if (int_5 == 65535) {
                        int_5 = -1;
                    }

                    int_3 = packetbuffer_0.readUnsignedByte();
                    if ((int_5 == npc_1.animation) && (int_5 != -1)) {
                        int_6 = TotalQuantityComparator.getAnimation(int_5).replyMode;
                        if (int_6 == 1) {
                            npc_1.actionFrame = 0;
                            npc_1.actionFrameCycle = 0;
                            npc_1.actionAnimationDisable = int_3;
                            npc_1.field907 = 0;
                        }

                        if (int_6 == 2) {
                            npc_1.field907 = 0;
                        }
                    } else if ((int_5 == -1) || (npc_1.animation == -1)
                            || (TotalQuantityComparator.getAnimation(int_5).forcedPriority >= TotalQuantityComparator
                            .getAnimation(npc_1.animation).forcedPriority)) {
                        npc_1.animation = int_5;
                        npc_1.actionFrame = 0;
                        npc_1.actionFrameCycle = 0;
                        npc_1.actionAnimationDisable = int_3;
                        npc_1.field907 = 0;
                        npc_1.field930 = npc_1.queueSize;
                    }
                }

                if ((int_2 & 0x2) != 0) { //force text
                    npc_1.overhead = packetbuffer_0.readString();
                    npc_1.overheadTextCyclesRemaining = 100;
                }
            }

            for (int_4 = 0; int_4 < Game.field701; int_4++) {
                int_0 = Game.field702[int_4];
                if (Game.cachedNPCs[int_0].npcCycle != Game.gameCycle) {
                    Game.cachedNPCs[int_0].composition = null;
                    Game.cachedNPCs[int_0] = null;
                }
            }

            if (packetbuffer_0.offset != Game.field626.packetLength) {
                throw new RuntimeException(packetbuffer_0.offset + "," + Game.field626.packetLength);
            } else {
                for (int_4 = 0; int_4 < Game.npcIndexesCount; int_4++) {
                    if (Game.cachedNPCs[Game.npcIndices[int_4]] == null) {
                        throw new RuntimeException(int_4 + "," + Game.npcIndexesCount);
                    }
                }

            }
        }
    }

    static void method4620(final Widget[] widgets_0, final int int_0) {
        for (int int_1 = 0; int_1 < widgets_0.length; int_1++) {
            final Widget widget_0 = widgets_0[int_1];
            if ((widget_0 != null) && (widget_0.parentHash == int_0)
                    && (!widget_0.hasScript || !class81.method1885(widget_0))) {
                if (widget_0.type == 0) {
                    if (!widget_0.hasScript && class81.method1885(widget_0) && (widget_0 != class143.field1897)) {
                        continue;
                    }

                    method4620(widgets_0, widget_0.interfaceHash);
                    if (widget_0.children != null) {
                        method4620(widget_0.children, widget_0.interfaceHash);
                    }

                    final WidgetNode widgetnode_0 = (WidgetNode) Game.componentTable.get(widget_0.interfaceHash);
                    if (widgetnode_0 != null) {
                        class21.method270(widgetnode_0.id);
                    }
                }

                if (widget_0.type == 6) {
                    int int_2;
                    if ((widget_0.field2595 != -1) || (widget_0.field2653 != -1)) {
                        final boolean bool_0 = Occluder.method3097(widget_0);
                        if (bool_0) {
                            int_2 = widget_0.field2653;
                        } else {
                            int_2 = widget_0.field2595;
                        }

                        if (int_2 != -1) {
                            final Sequence sequence_0 = TotalQuantityComparator.getAnimation(int_2);

                            for (widget_0.field2613 += Game.field700; widget_0.field2613 > sequence_0.frameLengths[widget_0.field2728]; Player
                                    .method1114(widget_0)) {
                                widget_0.field2613 -= sequence_0.frameLengths[widget_0.field2728];
                                ++widget_0.field2728;
                                if (widget_0.field2728 >= sequence_0.frameIDs.length) {
                                    widget_0.field2728 -= sequence_0.frameStep;
                                    if ((widget_0.field2728 < 0) || (widget_0.field2728 >= sequence_0.frameIDs.length)) {
                                        widget_0.field2728 = 0;
                                    }
                                }
                            }
                        }
                    }

                    if ((widget_0.field2732 != 0) && !widget_0.hasScript) {
                        int int_3 = widget_0.field2732 >> 16;
                        int_2 = (widget_0.field2732 << 16) >> 16;
                        int_3 *= Game.field700;
                        int_2 *= Game.field700;
                        widget_0.rotationX = (int_3 + widget_0.rotationX) & 0x7FF;
                        widget_0.rotationZ = (int_2 + widget_0.rotationZ) & 0x7FF;
                        Player.method1114(widget_0);
                    }
                }
            }
        }

    }

}
