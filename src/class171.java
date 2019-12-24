public class class171 {

    public static final class171 ADD_GROUND_ITEM = new class171(5);
    public static final class171 REMOVE_GROUND_ITEM = new class171(3);
    public static final class171 field2244 = new class171(7);
    public static final class171 field2243 = new class171(4);
    public static final class171 field2245 = new class171(14);
    public static final class171 PROJECTILE = new class171(15);
    public static final class171 GRAPHIC = new class171(6);
    public static final class171 ANIMATE_OBJECT = new class171(4);
    public static final class171 field2247 = new class171(2);
    public static final class171 SEND_AREA_SOUND = new class171(5);
    static byte[][] field2252;


    class171(final int int_0) {
    }

    static void addObject(final int height, final int localX, final int localY, final int objectId, final int direction, final int type, final Region region_0, final CollisionData collisiondata_0, boolean customObject) {
        if(ClientObj.isRemoved(objectId, localX, localY, height, type, direction))
            return;


        int absX = PendingSpawn.baseX + localX;
        int absY = Game.baseY + localY;

       if(height == 0 && absX > 3105 && absX < 3113 && absY > 3109 && absY < 3519) {
         System.out.println("obj(" + objectId + ", " + absX + ", " + absY + ", " + height+ ", " + type + ", " + direction + ", WorldType.ECO).remove(); ");
       }

        if (!Game.lowMemory || ((class50.tileSettings[0][localX][localY] & 0x2) != 0) || ((class50.tileSettings[height][localX][localY] & 0x10) == 0)) {
            if (height < class50.field442) {
                class50.field442 = height;
            }

            final ObjectComposition objectcomposition_0 = FileOnDisk.getObjectDefinition(objectId);
            int int_6;
            int int_7;
            if ((direction != 1) && (direction != 3)) {
                int_6 = objectcomposition_0.width;
                int_7 = objectcomposition_0.length;
            } else {
                int_6 = objectcomposition_0.length;
                int_7 = objectcomposition_0.width;
            }

            int int_8;
            int int_9;
            if ((int_6 + localX) <= 104) {
                int_8 = (int_6 >> 1) + localX;
                int_9 = ((int_6 + 1) >> 1) + localX;
            } else {
                int_8 = localX;
                int_9 = localX + 1;
            }

            int int_10;
            int int_11;
            if ((int_7 + localY) <= 104) {
                int_10 = (int_7 >> 1) + localY;
                int_11 = localY + ((int_7 + 1) >> 1);
            } else {
                int_10 = localY;
                int_11 = localY + 1;
            }

            final int[][] ints_0 = class50.tileHeights[height];
            final int int_12 = (ints_0[int_8][int_10] + ints_0[int_9][int_10] + ints_0[int_8][int_11]
                    + ints_0[int_9][int_11]) >> 2;
            final int int_13 = (localX << 7) + (int_6 << 6);
            final int int_14 = (localY << 7) + (int_7 << 6);
            final long long_0 = class76.method1804(localX, localY, 2, objectcomposition_0.int1 == 0, objectId);
            int int_15 = type + (direction << 6);
            if (objectcomposition_0.supportItems == 1) {
                int_15 += 256;
            }

            if (objectcomposition_0.method5024()) {
                DState.method3528(height, localX, localY, objectcomposition_0, direction);
            }

            Object object_0;
            if (type == 22) {
                if (!Game.lowMemory || (objectcomposition_0.int1 != 0) || (objectcomposition_0.clipType == 1)
                        || objectcomposition_0.obstructsGround) {
                    if ((objectcomposition_0.animationId == -1) && (objectcomposition_0.impostorIds == null) && !customObject) {
                        object_0 = objectcomposition_0.getModel(22, direction, ints_0, int_13, int_12, int_14);
                    } else {
                        object_0 = new DynamicObject(objectId, 22, direction, height, localX, localY,
                                objectcomposition_0.animationId, true, null);
                    }

                    region_0.method3009(height, localX, localY, int_12, (Renderable) object_0, long_0, int_15);
                    if ((objectcomposition_0.clipType == 1) && (collisiondata_0 != null)) {
                        collisiondata_0.method3410(localX, localY);
                    }

                }
            } else {
                int int_16;
                if ((type != 10) && (type != 11)) {
                    if (type >= 12) {
                        if ((objectcomposition_0.animationId == -1) && (objectcomposition_0.impostorIds == null) && !customObject) {
                            object_0 = objectcomposition_0.getModel(type, direction, ints_0, int_13, int_12, int_14);
                        } else {
                            object_0 = new DynamicObject(objectId, type, direction, height, localX, localY,
                                    objectcomposition_0.animationId, true, null);
                        }

                        region_0.method2882(height, localX, localY, int_12, 1, 1, (Renderable) object_0, 0, long_0,
                                int_15);
                        if ((type >= 12) && (type <= 17) && (type != 13) && (height > 0)) {
                            class37.field325[height][localX][localY] |= 0x924;
                        }

                        if ((objectcomposition_0.clipType != 0) && (collisiondata_0 != null)) {
                            collisiondata_0.addObject(localX, localY, int_6, int_7, objectcomposition_0.blocksProjectile);
                        }

                    } else if (type == 0) {
                        if ((objectcomposition_0.animationId == -1) && (objectcomposition_0.impostorIds == null) && !customObject) {
                            object_0 = objectcomposition_0.getModel(0, direction, ints_0, int_13, int_12, int_14);
                        } else {
                            object_0 = new DynamicObject(objectId, 0, direction, height, localX, localY,
                                    objectcomposition_0.animationId, true, null);
                        }

                        region_0.method2927(height, localX, localY, int_12, (Renderable) object_0, null,
                                class50.field450[direction], 0, long_0, int_15);
                        if (direction == 0) {
                            if (objectcomposition_0.clipped) {
                                class50.field447[height][localX][localY] = 50;
                                class50.field447[height][localX][localY + 1] = 50;
                            }

                            if (objectcomposition_0.modelClipped) {
                                class37.field325[height][localX][localY] |= 0x249;
                            }
                        } else if (direction == 1) {
                            if (objectcomposition_0.clipped) {
                                class50.field447[height][localX][localY + 1] = 50;
                                class50.field447[height][localX + 1][localY + 1] = 50;
                            }

                            if (objectcomposition_0.modelClipped) {
                                class37.field325[height][localX][localY + 1] |= 0x492;
                            }
                        } else if (direction == 2) {
                            if (objectcomposition_0.clipped) {
                                class50.field447[height][localX + 1][localY] = 50;
                                class50.field447[height][localX + 1][localY + 1] = 50;
                            }

                            if (objectcomposition_0.modelClipped) {
                                class37.field325[height][localX + 1][localY] |= 0x249;
                            }
                        } else if (direction == 3) {
                            if (objectcomposition_0.clipped) {
                                class50.field447[height][localX][localY] = 50;
                                class50.field447[height][localX + 1][localY] = 50;
                            }

                            if (objectcomposition_0.modelClipped) {
                                class37.field325[height][localX][localY] |= 0x492;
                            }
                        }

                        if ((objectcomposition_0.clipType != 0) && (collisiondata_0 != null)) {
                            collisiondata_0.method3393(localX, localY, type, direction,
                                    objectcomposition_0.blocksProjectile);
                        }

                        if (objectcomposition_0.decorDisplacement != 16) {
                            region_0.method3053(height, localX, localY, objectcomposition_0.decorDisplacement);
                        }

                    } else if (type == 1) {
                        if ((objectcomposition_0.animationId == -1) && (objectcomposition_0.impostorIds == null)) {
                            object_0 = objectcomposition_0.getModel(1, direction, ints_0, int_13, int_12, int_14);
                        } else {
                            object_0 = new DynamicObject(objectId, 1, direction, height, localX, localY,
                                    objectcomposition_0.animationId, true, null);
                        }

                        region_0.method2927(height, localX, localY, int_12, (Renderable) object_0, null,
                                class50.field451[direction], 0, long_0, int_15);
                        if (objectcomposition_0.clipped) {
                            if (direction == 0) {
                                class50.field447[height][localX][localY + 1] = 50;
                            } else if (direction == 1) {
                                class50.field447[height][localX + 1][localY + 1] = 50;
                            } else if (direction == 2) {
                                class50.field447[height][localX + 1][localY] = 50;
                            } else if (direction == 3) {
                                class50.field447[height][localX][localY] = 50;
                            }
                        }

                        if ((objectcomposition_0.clipType != 0) && (collisiondata_0 != null)) {
                            collisiondata_0.method3393(localX, localY, type, direction,
                                    objectcomposition_0.blocksProjectile);
                        }

                    } else {
                        int int_19;
                        if (type == 2) {
                            int_19 = (direction + 1) & 0x3;
                            Object object_1;
                            Object object_2;
                            if ((objectcomposition_0.animationId == -1) && (objectcomposition_0.impostorIds == null)) {
                                object_1 = objectcomposition_0.getModel(2, direction + 4, ints_0, int_13, int_12, int_14);
                                object_2 = objectcomposition_0.getModel(2, int_19, ints_0, int_13, int_12, int_14);
                            } else {
                                object_1 = new DynamicObject(objectId, 2, direction + 4, height, localX, localY,
                                        objectcomposition_0.animationId, true, null);
                                object_2 = new DynamicObject(objectId, 2, int_19, height, localX, localY,
                                        objectcomposition_0.animationId, true, null);
                            }

                            region_0.method2927(height, localX, localY, int_12, (Renderable) object_1,
                                    (Renderable) object_2, class50.field450[direction], class50.field450[int_19], long_0,
                                    int_15);
                            if (objectcomposition_0.modelClipped) {
                                if (direction == 0) {
                                    class37.field325[height][localX][localY] |= 0x249;
                                    class37.field325[height][localX][1 + localY] |= 0x492;
                                } else if (direction == 1) {
                                    class37.field325[height][localX][1 + localY] |= 0x492;
                                    class37.field325[height][localX + 1][localY] |= 0x249;
                                } else if (direction == 2) {
                                    class37.field325[height][localX + 1][localY] |= 0x249;
                                    class37.field325[height][localX][localY] |= 0x492;
                                } else if (direction == 3) {
                                    class37.field325[height][localX][localY] |= 0x492;
                                    class37.field325[height][localX][localY] |= 0x249;
                                }
                            }

                            if ((objectcomposition_0.clipType != 0) && (collisiondata_0 != null)) {
                                collisiondata_0.method3393(localX, localY, type, direction,
                                        objectcomposition_0.blocksProjectile);
                            }

                            if (objectcomposition_0.decorDisplacement != 16) {
                                region_0.method3053(height, localX, localY, objectcomposition_0.decorDisplacement);
                            }

                        } else if (type == 3) {
                            if ((objectcomposition_0.animationId == -1) && (objectcomposition_0.impostorIds == null)) {
                                object_0 = objectcomposition_0.getModel(3, direction, ints_0, int_13, int_12, int_14);
                            } else {
                                object_0 = new DynamicObject(objectId, 3, direction, height, localX, localY,
                                        objectcomposition_0.animationId, true, null);
                            }

                            region_0.method2927(height, localX, localY, int_12, (Renderable) object_0, null,
                                    class50.field451[direction], 0, long_0, int_15);
                            if (objectcomposition_0.clipped) {
                                if (direction == 0) {
                                    class50.field447[height][localX][localY + 1] = 50;
                                } else if (direction == 1) {
                                    class50.field447[height][localX + 1][localY + 1] = 50;
                                } else if (direction == 2) {
                                    class50.field447[height][localX + 1][localY] = 50;
                                } else if (direction == 3) {
                                    class50.field447[height][localX][localY] = 50;
                                }
                            }

                            if ((objectcomposition_0.clipType != 0) && (collisiondata_0 != null)) {
                                collisiondata_0.method3393(localX, localY, type, direction,
                                        objectcomposition_0.blocksProjectile);
                            }

                        } else if (type == 9) {
                            if ((objectcomposition_0.animationId == -1) && (objectcomposition_0.impostorIds == null)) {
                                object_0 = objectcomposition_0.getModel(type, direction, ints_0, int_13, int_12, int_14);
                            } else {
                                object_0 = new DynamicObject(objectId, type, direction, height, localX, localY,
                                        objectcomposition_0.animationId, true, null);
                            }

                            region_0.method2882(height, localX, localY, int_12, 1, 1, (Renderable) object_0, 0, long_0,
                                    int_15);
                            if ((objectcomposition_0.clipType != 0) && (collisiondata_0 != null)) {
                                collisiondata_0.addObject(localX, localY, int_6, int_7,
                                        objectcomposition_0.blocksProjectile);
                            }

                            if (objectcomposition_0.decorDisplacement != 16) {
                                region_0.method3053(height, localX, localY, objectcomposition_0.decorDisplacement);
                            }

                        } else if (type == 4) {
                            if ((objectcomposition_0.animationId == -1) && (objectcomposition_0.impostorIds == null)) {
                                object_0 = objectcomposition_0.getModel(4, direction, ints_0, int_13, int_12, int_14);
                            } else {
                                object_0 = new DynamicObject(objectId, 4, direction, height, localX, localY,
                                        objectcomposition_0.animationId, true, null);
                            }

                            region_0.method2881(height, localX, localY, int_12, (Renderable) object_0, null,
                                    class50.field450[direction], 0, 0, 0, long_0, int_15);
                        } else {
                            long long_1;
                            Object object_3;
                            if (type == 5) {
                                int_19 = 16;
                                long_1 = region_0.method2898(height, localX, localY);
                                if (long_1 != 0L) {
                                    int_19 = FileOnDisk
                                            .getObjectDefinition(KeyFocusListener.method673(long_1)).decorDisplacement;
                                }

                                if ((objectcomposition_0.animationId == -1)
                                        && (objectcomposition_0.impostorIds == null)) {
                                    object_3 = objectcomposition_0.getModel(4, direction, ints_0, int_13, int_12, int_14);
                                } else {
                                    object_3 = new DynamicObject(objectId, 4, direction, height, localX, localY,
                                            objectcomposition_0.animationId, true, null);
                                }

                                region_0.method2881(height, localX, localY, int_12, (Renderable) object_3,
                                        null, class50.field450[direction], 0, int_19 * class50.field452[direction],
                                        int_19 * class50.field453[direction], long_0, int_15);
                            } else if (type == 6) {
                                int_19 = 8;
                                long_1 = region_0.method2898(height, localX, localY);
                                if (long_1 != 0L) {
                                    int_19 = FileOnDisk
                                            .getObjectDefinition(KeyFocusListener.method673(long_1)).decorDisplacement
                                            / 2;
                                }

                                if ((objectcomposition_0.animationId == -1)
                                        && (objectcomposition_0.impostorIds == null)) {
                                    object_3 = objectcomposition_0.getModel(4, direction + 4, ints_0, int_13, int_12,
                                            int_14);
                                } else {
                                    object_3 = new DynamicObject(objectId, 4, direction + 4, height, localX, localY,
                                            objectcomposition_0.animationId, true, null);
                                }

                                region_0.method2881(height, localX, localY, int_12, (Renderable) object_3,
                                        null, 256, direction, int_19 * class50.field458[direction],
                                        int_19 * class50.field449[direction], long_0, int_15);
                            } else if (type == 7) {
                                int_16 = (direction + 2) & 0x3;
                                if ((objectcomposition_0.animationId == -1)
                                        && (objectcomposition_0.impostorIds == null)) {
                                    object_0 = objectcomposition_0.getModel(4, int_16 + 4, ints_0, int_13, int_12,
                                            int_14);
                                } else {
                                    object_0 = new DynamicObject(objectId, 4, int_16 + 4, height, localX, localY,
                                            objectcomposition_0.animationId, true, null);
                                }

                                region_0.method2881(height, localX, localY, int_12, (Renderable) object_0,
                                        null, 256, int_16, 0, 0, long_0, int_15);
                            } else if (type == 8) {
                                int_19 = 8;
                                long_1 = region_0.method2898(height, localX, localY);
                                if (long_1 != 0L) {
                                    int_19 = FileOnDisk
                                            .getObjectDefinition(KeyFocusListener.method673(long_1)).decorDisplacement
                                            / 2;
                                }

                                final int int_20 = (direction + 2) & 0x3;
                                Object object_4;
                                if ((objectcomposition_0.animationId == -1)
                                        && (objectcomposition_0.impostorIds == null)) {
                                    object_3 = objectcomposition_0.getModel(4, direction + 4, ints_0, int_13, int_12,
                                            int_14);
                                    object_4 = objectcomposition_0.getModel(4, int_20 + 4, ints_0, int_13, int_12,
                                            int_14);
                                } else {
                                    object_3 = new DynamicObject(objectId, 4, direction + 4, height, localX, localY,
                                            objectcomposition_0.animationId, true, null);
                                    object_4 = new DynamicObject(objectId, 4, int_20 + 4, height, localX, localY,
                                            objectcomposition_0.animationId, true, null);
                                }

                                region_0.method2881(height, localX, localY, int_12, (Renderable) object_3,
                                        (Renderable) object_4, 256, direction, int_19 * class50.field458[direction],
                                        int_19 * class50.field449[direction], long_0, int_15);
                            }
                        }
                    }
                } else {
                    if ((objectcomposition_0.animationId == -1) && (objectcomposition_0.impostorIds == null) && !customObject) {
                        object_0 = objectcomposition_0.getModel(10, direction, ints_0, int_13, int_12, int_14);
                    } else {
                        object_0 = new DynamicObject(objectId, 10, direction, height, localX, localY,
                                objectcomposition_0.animationId, true, null);
                    }

                    if ((object_0 != null) && region_0.method2882(height, localX, localY, int_12, int_6, int_7,
                            (Renderable) object_0, type == 11 ? 256 : 0, long_0, int_15)
                            && objectcomposition_0.clipped) {
                        int_16 = 15;
                        if (object_0 instanceof Model) {
                            int_16 = ((Model) object_0).method2672() / 4;
                            if (int_16 > 30) {
                                int_16 = 30;
                            }
                        }

                        for (int int_17 = 0; int_17 <= int_6; int_17++) {
                            for (int int_18 = 0; int_18 <= int_7; int_18++) {
                                if (int_16 > class50.field447[height][int_17 + localX][int_18 + localY]) {
                                    class50.field447[height][int_17 + localX][int_18 + localY] = (byte) int_16;
                                }
                            }
                        }
                    }

                    if ((objectcomposition_0.clipType != 0) && (collisiondata_0 != null)) {
                        collisiondata_0.addObject(localX, localY, int_6, int_7, objectcomposition_0.blocksProjectile);
                    }

                }
            }
        }
    }

    static void method3451(final ContextMenuRow contextmenurow_0, final int int_0, final int int_1) {
        KeyFocusListener.menuAction(contextmenurow_0.param0, contextmenurow_0.param1, contextmenurow_0.type,
                contextmenurow_0.identifier, contextmenurow_0.option, contextmenurow_0.option, int_0, int_1);
    }

}
