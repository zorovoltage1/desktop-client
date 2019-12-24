public class class262 {

    static void method4939(final int int_0, final int int_1, final int int_2, final int int_3, final int int_4,
                           final int int_5, final int int_6, final Region region_0, final CollisionData collisiondata_0) {
        final ObjectComposition objectcomposition_0 = FileOnDisk.getObjectDefinition(int_4);
        int int_7;
        int int_8;
        if ((int_5 != 1) && (int_5 != 3)) {
            int_7 = objectcomposition_0.width;
            int_8 = objectcomposition_0.length;
        } else {
            int_7 = objectcomposition_0.length;
            int_8 = objectcomposition_0.width;
        }

        int int_9;
        int int_10;
        if ((int_7 + int_2) <= 104) {
            int_9 = (int_7 >> 1) + int_2;
            int_10 = int_2 + ((int_7 + 1) >> 1);
        } else {
            int_9 = int_2;
            int_10 = int_2 + 1;
        }

        int int_11;
        int int_12;
        if ((int_3 + int_8) <= 104) {
            int_11 = int_3 + (int_8 >> 1);
            int_12 = int_3 + ((int_8 + 1) >> 1);
        } else {
            int_11 = int_3;
            int_12 = int_3 + 1;
        }

        final int[][] ints_0 = class50.tileHeights[int_1];
        final int int_13 = (ints_0[int_9][int_12] + ints_0[int_9][int_11] + ints_0[int_10][int_11]
                + ints_0[int_10][int_12]) >> 2;
        final int int_14 = (int_2 << 7) + (int_7 << 6);
        final int int_15 = (int_3 << 7) + (int_8 << 6);
        final long long_0 = class76.method1804(int_2, int_3, 2, objectcomposition_0.int1 == 0, int_4);
        int int_16 = (int_5 << 6) + int_6;
        if (objectcomposition_0.supportItems == 1) {
            int_16 += 256;
        }

        Object object_0;
        if (int_6 == 22) {
            if ((objectcomposition_0.animationId == -1) && (objectcomposition_0.impostorIds == null)) {
                object_0 = objectcomposition_0.method5031(22, int_5, ints_0, int_14, int_13, int_15);
            } else {
                object_0 = new DynamicObject(int_4, 22, int_5, int_1, int_2, int_3, objectcomposition_0.animationId,
                        true, null);
            }

            region_0.method3009(int_0, int_2, int_3, int_13, (Renderable) object_0, long_0, int_16);
            if (objectcomposition_0.clipType == 1) {
                collisiondata_0.method3410(int_2, int_3);
            }

        } else if ((int_6 != 10) && (int_6 != 11)) {
            if (int_6 >= 12) {
                if ((objectcomposition_0.animationId == -1) && (objectcomposition_0.impostorIds == null)) {
                    object_0 = objectcomposition_0.method5031(int_6, int_5, ints_0, int_14, int_13, int_15);
                } else {
                    object_0 = new DynamicObject(int_4, int_6, int_5, int_1, int_2, int_3,
                            objectcomposition_0.animationId, true, null);
                }

                region_0.method2882(int_0, int_2, int_3, int_13, 1, 1, (Renderable) object_0, 0, long_0, int_16);
                if (objectcomposition_0.clipType != 0) {
                    collisiondata_0.addObject(int_2, int_3, int_7, int_8, objectcomposition_0.blocksProjectile);
                }

            } else if (int_6 == 0) {
                if ((objectcomposition_0.animationId == -1) && (objectcomposition_0.impostorIds == null)) {
                    object_0 = objectcomposition_0.method5031(0, int_5, ints_0, int_14, int_13, int_15);
                } else {
                    object_0 = new DynamicObject(int_4, 0, int_5, int_1, int_2, int_3, objectcomposition_0.animationId,
                            true, null);
                }

                region_0.method2927(int_0, int_2, int_3, int_13, (Renderable) object_0, null,
                        class50.field450[int_5], 0, long_0, int_16);
                if (objectcomposition_0.clipType != 0) {
                    collisiondata_0.method3393(int_2, int_3, int_6, int_5, objectcomposition_0.blocksProjectile);
                }

            } else if (int_6 == 1) {
                if ((objectcomposition_0.animationId == -1) && (objectcomposition_0.impostorIds == null)) {
                    object_0 = objectcomposition_0.method5031(1, int_5, ints_0, int_14, int_13, int_15);
                } else {
                    object_0 = new DynamicObject(int_4, 1, int_5, int_1, int_2, int_3, objectcomposition_0.animationId,
                            true, null);
                }

                region_0.method2927(int_0, int_2, int_3, int_13, (Renderable) object_0, null,
                        class50.field451[int_5], 0, long_0, int_16);
                if (objectcomposition_0.clipType != 0) {
                    collisiondata_0.method3393(int_2, int_3, int_6, int_5, objectcomposition_0.blocksProjectile);
                }

            } else {
                int int_17;
                if (int_6 == 2) {
                    int_17 = (int_5 + 1) & 0x3;
                    Object object_1;
                    Object object_2;
                    if ((objectcomposition_0.animationId == -1) && (objectcomposition_0.impostorIds == null)) {
                        object_1 = objectcomposition_0.method5031(2, int_5 + 4, ints_0, int_14, int_13, int_15);
                        object_2 = objectcomposition_0.method5031(2, int_17, ints_0, int_14, int_13, int_15);
                    } else {
                        object_1 = new DynamicObject(int_4, 2, int_5 + 4, int_1, int_2, int_3,
                                objectcomposition_0.animationId, true, null);
                        object_2 = new DynamicObject(int_4, 2, int_17, int_1, int_2, int_3,
                                objectcomposition_0.animationId, true, null);
                    }

                    region_0.method2927(int_0, int_2, int_3, int_13, (Renderable) object_1, (Renderable) object_2,
                            class50.field450[int_5], class50.field450[int_17], long_0, int_16);
                    if (objectcomposition_0.clipType != 0) {
                        collisiondata_0.method3393(int_2, int_3, int_6, int_5, objectcomposition_0.blocksProjectile);
                    }

                } else if (int_6 == 3) {
                    if ((objectcomposition_0.animationId == -1) && (objectcomposition_0.impostorIds == null)) {
                        object_0 = objectcomposition_0.method5031(3, int_5, ints_0, int_14, int_13, int_15);
                    } else {
                        object_0 = new DynamicObject(int_4, 3, int_5, int_1, int_2, int_3,
                                objectcomposition_0.animationId, true, null);
                    }

                    region_0.method2927(int_0, int_2, int_3, int_13, (Renderable) object_0, null,
                            class50.field451[int_5], 0, long_0, int_16);
                    if (objectcomposition_0.clipType != 0) {
                        collisiondata_0.method3393(int_2, int_3, int_6, int_5, objectcomposition_0.blocksProjectile);
                    }

                } else if (int_6 == 9) {
                    if ((objectcomposition_0.animationId == -1) && (objectcomposition_0.impostorIds == null)) {
                        object_0 = objectcomposition_0.method5031(int_6, int_5, ints_0, int_14, int_13, int_15);
                    } else {
                        object_0 = new DynamicObject(int_4, int_6, int_5, int_1, int_2, int_3,
                                objectcomposition_0.animationId, true, null);
                    }

                    region_0.method2882(int_0, int_2, int_3, int_13, 1, 1, (Renderable) object_0, 0, long_0, int_16);
                    if (objectcomposition_0.clipType != 0) {
                        collisiondata_0.addObject(int_2, int_3, int_7, int_8, objectcomposition_0.blocksProjectile);
                    }

                } else if (int_6 == 4) {
                    if ((objectcomposition_0.animationId == -1) && (objectcomposition_0.impostorIds == null)) {
                        object_0 = objectcomposition_0.method5031(4, int_5, ints_0, int_14, int_13, int_15);
                    } else {
                        object_0 = new DynamicObject(int_4, 4, int_5, int_1, int_2, int_3,
                                objectcomposition_0.animationId, true, null);
                    }

                    region_0.method2881(int_0, int_2, int_3, int_13, (Renderable) object_0, null,
                            class50.field450[int_5], 0, 0, 0, long_0, int_16);
                } else {
                    long long_1;
                    Object object_3;
                    if (int_6 == 5) {
                        int_17 = 16;
                        long_1 = region_0.method2898(int_0, int_2, int_3);
                        if (long_1 != 0L) {
                            int_17 = FileOnDisk
                                    .getObjectDefinition(KeyFocusListener.method673(long_1)).decorDisplacement;
                        }

                        if ((objectcomposition_0.animationId == -1) && (objectcomposition_0.impostorIds == null)) {
                            object_3 = objectcomposition_0.method5031(4, int_5, ints_0, int_14, int_13, int_15);
                        } else {
                            object_3 = new DynamicObject(int_4, 4, int_5, int_1, int_2, int_3,
                                    objectcomposition_0.animationId, true, null);
                        }

                        region_0.method2881(int_0, int_2, int_3, int_13, (Renderable) object_3, null,
                                class50.field450[int_5], 0, int_17 * class50.field452[int_5],
                                int_17 * class50.field453[int_5], long_0, int_16);
                    } else if (int_6 == 6) {
                        int_17 = 8;
                        long_1 = region_0.method2898(int_0, int_2, int_3);
                        if (long_1 != 0L) {
                            int_17 = FileOnDisk
                                    .getObjectDefinition(KeyFocusListener.method673(long_1)).decorDisplacement / 2;
                        }

                        if ((objectcomposition_0.animationId == -1) && (objectcomposition_0.impostorIds == null)) {
                            object_3 = objectcomposition_0.method5031(4, int_5 + 4, ints_0, int_14, int_13, int_15);
                        } else {
                            object_3 = new DynamicObject(int_4, 4, int_5 + 4, int_1, int_2, int_3,
                                    objectcomposition_0.animationId, true, null);
                        }

                        region_0.method2881(int_0, int_2, int_3, int_13, (Renderable) object_3, null, 256,
                                int_5, int_17 * class50.field458[int_5], int_17 * class50.field449[int_5], long_0,
                                int_16);
                    } else if (int_6 == 7) {
                        final int int_18 = (int_5 + 2) & 0x3;
                        if ((objectcomposition_0.animationId == -1) && (objectcomposition_0.impostorIds == null)) {
                            object_0 = objectcomposition_0.method5031(4, int_18 + 4, ints_0, int_14, int_13, int_15);
                        } else {
                            object_0 = new DynamicObject(int_4, 4, int_18 + 4, int_1, int_2, int_3,
                                    objectcomposition_0.animationId, true, null);
                        }

                        region_0.method2881(int_0, int_2, int_3, int_13, (Renderable) object_0, null, 256,
                                int_18, 0, 0, long_0, int_16);
                    } else if (int_6 == 8) {
                        int_17 = 8;
                        long_1 = region_0.method2898(int_0, int_2, int_3);
                        if (long_1 != 0L) {
                            int_17 = FileOnDisk
                                    .getObjectDefinition(KeyFocusListener.method673(long_1)).decorDisplacement / 2;
                        }

                        final int int_19 = (int_5 + 2) & 0x3;
                        Object object_4;
                        if ((objectcomposition_0.animationId == -1) && (objectcomposition_0.impostorIds == null)) {
                            object_3 = objectcomposition_0.method5031(4, int_5 + 4, ints_0, int_14, int_13, int_15);
                            object_4 = objectcomposition_0.method5031(4, int_19 + 4, ints_0, int_14, int_13, int_15);
                        } else {
                            object_3 = new DynamicObject(int_4, 4, int_5 + 4, int_1, int_2, int_3,
                                    objectcomposition_0.animationId, true, null);
                            object_4 = new DynamicObject(int_4, 4, int_19 + 4, int_1, int_2, int_3,
                                    objectcomposition_0.animationId, true, null);
                        }

                        region_0.method2881(int_0, int_2, int_3, int_13, (Renderable) object_3, (Renderable) object_4,
                                256, int_5, int_17 * class50.field458[int_5], int_17 * class50.field449[int_5], long_0,
                                int_16);
                    }
                }
            }
        } else {
            if ((objectcomposition_0.animationId == -1) && (objectcomposition_0.impostorIds == null)) {
                object_0 = objectcomposition_0.method5031(10, int_5, ints_0, int_14, int_13, int_15);
            } else {
                object_0 = new DynamicObject(int_4, 10, int_5, int_1, int_2, int_3, objectcomposition_0.animationId,
                        true, null);
            }

            if (object_0 != null) {
                region_0.method2882(int_0, int_2, int_3, int_13, int_7, int_8, (Renderable) object_0,
                        int_6 == 11 ? 256 : 0, long_0, int_16);
            }

            if (objectcomposition_0.clipType != 0) {
                collisiondata_0.addObject(int_2, int_3, int_7, int_8, objectcomposition_0.blocksProjectile);
            }

        }
    }

}
