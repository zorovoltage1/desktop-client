public class KitDefinition extends CacheableNode {

    static IndexDataBase identKit_ref;
    static IndexDataBase field3290;
    public static int field3294;
    public static NodeCache identKits;
    static Widget field3301;
    public int bodyPartId;
    int[] modelIds;
    short[] recolorToFind;
    short[] recolorToReplace;
    short[] retextureToFind;
    short[] retextureToReplace;
    int[] models;
    public boolean nonSelectable;

    static {
        identKits = new NodeCache(64);
    }

    KitDefinition() {
        bodyPartId = -1;
        models = new int[]{-1, -1, -1, -1, -1};
        nonSelectable = false;
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
        if (int_0 == 1) {
            bodyPartId = buffer_0.readUnsignedByte();
        } else {
            int int_1;
            int int_2;
            if (int_0 == 2) {
                int_1 = buffer_0.readUnsignedByte();
                modelIds = new int[int_1];

                for (int_2 = 0; int_2 < int_1; int_2++) {
                    modelIds[int_2] = buffer_0.readUnsignedShort();
                }
            } else if (int_0 == 3) {
                nonSelectable = true;
            } else if (int_0 == 40) {
                int_1 = buffer_0.readUnsignedByte();
                recolorToFind = new short[int_1];
                recolorToReplace = new short[int_1];

                for (int_2 = 0; int_2 < int_1; int_2++) {
                    recolorToFind[int_2] = (short) buffer_0.readUnsignedShort();
                    recolorToReplace[int_2] = (short) buffer_0.readUnsignedShort();
                }
            } else if (int_0 == 41) {
                int_1 = buffer_0.readUnsignedByte();
                retextureToFind = new short[int_1];
                retextureToReplace = new short[int_1];

                for (int_2 = 0; int_2 < int_1; int_2++) {
                    retextureToFind[int_2] = (short) buffer_0.readUnsignedShort();
                    retextureToReplace[int_2] = (short) buffer_0.readUnsignedShort();
                }
            } else if ((int_0 >= 60) && (int_0 < 70)) {
                models[int_0 - 60] = buffer_0.readUnsignedShort();
            }
        }

    }

    public boolean ready() {
        if (modelIds == null) {
            return true;
        } else {
            boolean bool_0 = true;

            for (int int_0 = 0; int_0 < modelIds.length; int_0++) {
                if (!field3290.tryLoadRecord(modelIds[int_0], 0)) {
                    bool_0 = false;
                }
            }

            return bool_0;
        }
    }

    public ModelData getModelData() {
        if (modelIds == null) {
            return null;
        } else {
            final ModelData[] modeldatas_0 = new ModelData[modelIds.length];

            for (int int_0 = 0; int_0 < modelIds.length; int_0++) {
                modeldatas_0[int_0] = ModelData.method2568(field3290, modelIds[int_0], 0);
            }

            ModelData modeldata_0;
            if (modeldatas_0.length == 1) {
                modeldata_0 = modeldatas_0[0];
            } else {
                modeldata_0 = new ModelData(modeldatas_0, modeldatas_0.length);
            }

            int int_1;
            if (recolorToFind != null) {
                for (int_1 = 0; int_1 < recolorToFind.length; int_1++) {
                    modeldata_0.recolor(recolorToFind[int_1], recolorToReplace[int_1]);
                }
            }

            if (retextureToFind != null) {
                for (int_1 = 0; int_1 < retextureToFind.length; int_1++) {
                    modeldata_0.method2582(retextureToFind[int_1], retextureToReplace[int_1]);
                }
            }

            return modeldata_0;
        }
    }

    public boolean method4905() {
        boolean bool_0 = true;

        for (int int_0 = 0; int_0 < 5; int_0++) {
            if ((models[int_0] != -1) && !field3290.tryLoadRecord(models[int_0], 0)) {
                bool_0 = false;
            }
        }

        return bool_0;
    }

    public ModelData method4899() {
        final ModelData[] modeldatas_0 = new ModelData[5];
        int int_0 = 0;

        for (int int_1 = 0; int_1 < 5; int_1++) {
            if (models[int_1] != -1) {
                modeldatas_0[int_0++] = ModelData.method2568(field3290, models[int_1], 0);
            }
        }

        final ModelData modeldata_0 = new ModelData(modeldatas_0, int_0);
        int int_2;
        if (recolorToFind != null) {
            for (int_2 = 0; int_2 < recolorToFind.length; int_2++) {
                modeldata_0.recolor(recolorToFind[int_2], recolorToReplace[int_2]);
            }
        }

        if (retextureToFind != null) {
            for (int_2 = 0; int_2 < retextureToFind.length; int_2++) {
                modeldata_0.method2582(retextureToFind[int_2], retextureToReplace[int_2]);
            }
        }

        return modeldata_0;
    }

    static int method4908(final int int_0, int int_1, final int int_2) {
        if (int_2 > 179) {
            int_1 /= 2;
        }

        if (int_2 > 192) {
            int_1 /= 2;
        }

        if (int_2 > 217) {
            int_1 /= 2;
        }

        if (int_2 > 243) {
            int_1 /= 2;
        }

        final int int_3 = ((int_1 / 32) << 7) + ((int_0 / 4) << 10) + (int_2 / 2);
        return int_3;
    }

}
