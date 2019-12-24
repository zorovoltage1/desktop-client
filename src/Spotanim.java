public class Spotanim extends CacheableNode {

    public static IndexDataBase SpotAnimationDefinition_indexCache;
    public static IndexDataBase SpotAnimationDefinition_modelIndexCache;
    public static NodeCache spotanims;
    public static NodeCache SpotAnimationDefinition_cachedModels;
    int id;
    int field3268;
    public int animationId;
    short[] field3266;
    short[] field3270;
    short[] field3274;
    short[] field3275;
    int widthScale;
    int heightScale;
    int orientation;
    int field3273;
    int field3269;

    static {
        spotanims = new NodeCache(64);
        SpotAnimationDefinition_cachedModels = new NodeCache(30);
    }

    Spotanim() {
        animationId = -1;
        widthScale = 128;
        heightScale = 128;
        orientation = 0;
        field3273 = 0;
        field3269 = 0;
    }

    void decode(final Buffer buffer_0) {
        while (true) {
            final int int_0 = buffer_0.readUnsignedByte();
            if (int_0 == 0)
                return;
            readNext(buffer_0, int_0);
        }
    }

    void postDecode() {
        if (id == 994 || id == 995) { // Skeleton champion arrow gfx (Ket'ian custom boss)
            widthScale *= 2;
            heightScale *= 2;
        } else if (id == 26 || id == 25) { // Ket'ian's drawback gfxs (fire arrow and ice arrow)
            animationId = 5515;
            widthScale *= 3;
            heightScale *= 3;
        } else if (id == 17 || id == 16) { // Ket'ian's projectile gfxs (fire arrow and ice arrow)
            widthScale *= 3;
            heightScale *= 3;
        }
    }

    void readNext(final Buffer buffer_0, final int int_0) {
        if (int_0 == 1) {
            field3268 = buffer_0.readUnsignedShort();
        } else if (int_0 == 2) {
            animationId = buffer_0.readUnsignedShort();
        } else if (int_0 == 4) {
            widthScale = buffer_0.readUnsignedShort();
        } else if (int_0 == 5) {
            heightScale = buffer_0.readUnsignedShort();
        } else if (int_0 == 6) {
            orientation = buffer_0.readUnsignedShort();
        } else if (int_0 == 7) {
            field3273 = buffer_0.readUnsignedByte();
        } else if (int_0 == 8) {
            field3269 = buffer_0.readUnsignedByte();
        } else {
            int int_1;
            int int_2;
            if (int_0 == 40) {
                int_1 = buffer_0.readUnsignedByte();
                field3266 = new short[int_1];
                field3270 = new short[int_1];

                for (int_2 = 0; int_2 < int_1; int_2++) {
                    field3266[int_2] = (short) buffer_0.readUnsignedShort();
                    field3270[int_2] = (short) buffer_0.readUnsignedShort();
                }
            } else if (int_0 == 41) {
                int_1 = buffer_0.readUnsignedByte();
                field3274 = new short[int_1];
                field3275 = new short[int_1];

                for (int_2 = 0; int_2 < int_1; int_2++) {
                    field3274[int_2] = (short) buffer_0.readUnsignedShort();
                    field3275[int_2] = (short) buffer_0.readUnsignedShort();
                }
            }
        }

    }

    public Model getModel(final int int_0) {
        Model model_0 = (Model) SpotAnimationDefinition_cachedModels.get(id);
        if (model_0 == null) {
            final ModelData modeldata_0 = ModelData.method2568(SpotAnimationDefinition_modelIndexCache, field3268, 0);
            if (modeldata_0 == null) {
                return null;
            }

            int int_1;
            if (field3266 != null) {
                for (int_1 = 0; int_1 < field3266.length; int_1++) {
                    modeldata_0.recolor(field3266[int_1], field3270[int_1]);
                }
            }

            if (field3274 != null) {
                for (int_1 = 0; int_1 < field3274.length; int_1++) {
                    modeldata_0.method2582(field3274[int_1], field3275[int_1]);
                }
            }

            model_0 = modeldata_0.light(field3273 + 64, field3269 + 850, -30, -50, -30);
            SpotAnimationDefinition_cachedModels.put(model_0, id);
        }

        Model model_1;
        if ((animationId != -1) && (int_0 != -1)) {
            model_1 = TotalQuantityComparator.getAnimation(animationId).transformSpotAnimModel(model_0, int_0);
        } else {
            model_1 = model_0.toSharedSpotAnimModel(true);
        }

        if ((widthScale != 128) || (heightScale != 128)) {
            model_1.scale(widthScale, heightScale, widthScale);
        }

        if (orientation != 0) {
            if (orientation == 90) {
                model_1.rotateY90Ccw();
            }

            if (orientation == 180) {
                model_1.rotateY90Ccw();
                model_1.rotateY90Ccw();
            }

            if (orientation == 270) {
                model_1.rotateY90Ccw();
                model_1.rotateY90Ccw();
                model_1.rotateY90Ccw();
            }
        }

        return model_1;
    }

}
