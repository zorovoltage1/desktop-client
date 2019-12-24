public class ModelData extends Renderable {

    static int[] field1494;
    static int[] field1475;
    static int field1474;
    static int[] field1497;
    static int[] field1495;
    int vertexCount;
    int[] vertexX;
    int[] vertexY;
    int[] vertexZ;
    int triangleFaceCount;
    int[] trianglePointsX;
    int[] trianglePointsY;
    int[] trianglePointsZ;
    byte[] faceRenderType;
    byte[] faceRenderPriorities;
    byte[] faceAlphas;
    byte[] textureCoords;
    short[] faceColor;
    short[] faceTextures;
    byte priority;
    int field1484;
    byte[] textureRenderTypes;
    short[] texTriangleX;
    short[] texTriangleY;
    short[] texTriangleZ;
    int[] vertexSkins;
    int[] triangleSkinValues;
    int[][] field1481;
    int[][] field1482;
    FaceNormal[] faceNormals;
    VertexNormal[] normals;
    VertexNormal[] field1485;
    public short field1486;
    public short contrast;
    boolean field1488;
    int field1489;
    int field1480;
    int field1492;
    int field1498;
    int field1493;

    static {
        field1494 = new int[10000];
        field1475 = new int[10000];
        field1474 = 0;
        field1497 = Graphics3D.SINE;
        field1495 = Graphics3D.COSINE;
    }

    ModelData() {
        vertexCount = 0;
        triangleFaceCount = 0;
        priority = 0;
        field1488 = false;
    }

    public ModelData(final ModelData[] modeldatas_0, final int int_0) {
        vertexCount = 0;
        triangleFaceCount = 0;
        priority = 0;
        field1488 = false;
        boolean bool_0 = false;
        boolean bool_1 = false;
        boolean bool_2 = false;
        boolean bool_3 = false;
        boolean bool_4 = false;
        boolean bool_5 = false;
        vertexCount = 0;
        triangleFaceCount = 0;
        field1484 = 0;
        priority = -1;

        int int_1;
        ModelData modeldata_1;
        for (int_1 = 0; int_1 < int_0; int_1++) {
            modeldata_1 = modeldatas_0[int_1];
            if (modeldata_1 != null) {
                vertexCount += modeldata_1.vertexCount;
                triangleFaceCount += modeldata_1.triangleFaceCount;
                field1484 += modeldata_1.field1484;
                if (modeldata_1.faceRenderPriorities != null) {
                    bool_1 = true;
                } else {
                    if (priority == -1) {
                        priority = modeldata_1.priority;
                    }

                    if (priority != modeldata_1.priority) {
                        bool_1 = true;
                    }
                }

                bool_0 |= modeldata_1.faceRenderType != null;
                bool_2 |= modeldata_1.faceAlphas != null;
                bool_3 |= modeldata_1.triangleSkinValues != null;
                bool_4 |= modeldata_1.faceTextures != null;
                bool_5 |= modeldata_1.textureCoords != null;
            }
        }

        vertexX = new int[vertexCount];
        vertexY = new int[vertexCount];
        vertexZ = new int[vertexCount];
        vertexSkins = new int[vertexCount];
        trianglePointsX = new int[triangleFaceCount];
        trianglePointsY = new int[triangleFaceCount];
        trianglePointsZ = new int[triangleFaceCount];
        if (bool_0) {
            faceRenderType = new byte[triangleFaceCount];
        }

        if (bool_1) {
            faceRenderPriorities = new byte[triangleFaceCount];
        }

        if (bool_2) {
            faceAlphas = new byte[triangleFaceCount];
        }

        if (bool_3) {
            triangleSkinValues = new int[triangleFaceCount];
        }

        if (bool_4) {
            faceTextures = new short[triangleFaceCount];
        }

        if (bool_5) {
            textureCoords = new byte[triangleFaceCount];
        }

        faceColor = new short[triangleFaceCount];
        if (field1484 > 0) {
            textureRenderTypes = new byte[field1484];
            texTriangleX = new short[field1484];
            texTriangleY = new short[field1484];
            texTriangleZ = new short[field1484];
        }

        vertexCount = 0;
        triangleFaceCount = 0;
        field1484 = 0;

        for (int_1 = 0; int_1 < int_0; int_1++) {
            modeldata_1 = modeldatas_0[int_1];
            if (modeldata_1 != null) {
                int int_2;
                for (int_2 = 0; int_2 < modeldata_1.triangleFaceCount; int_2++) {
                    if (bool_0 && (modeldata_1.faceRenderType != null)) {
                        faceRenderType[triangleFaceCount] = modeldata_1.faceRenderType[int_2];
                    }

                    if (bool_1) {
                        if (modeldata_1.faceRenderPriorities != null) {
                            faceRenderPriorities[triangleFaceCount] = modeldata_1.faceRenderPriorities[int_2];
                        } else {
                            faceRenderPriorities[triangleFaceCount] = modeldata_1.priority;
                        }
                    }

                    if (bool_2 && (modeldata_1.faceAlphas != null)) {
                        faceAlphas[triangleFaceCount] = modeldata_1.faceAlphas[int_2];
                    }

                    if (bool_3 && (modeldata_1.triangleSkinValues != null)) {
                        triangleSkinValues[triangleFaceCount] = modeldata_1.triangleSkinValues[int_2];
                    }

                    if (bool_4) {
                        if (modeldata_1.faceTextures != null) {
                            faceTextures[triangleFaceCount] = modeldata_1.faceTextures[int_2];
                        } else {
                            faceTextures[triangleFaceCount] = -1;
                        }
                    }

                    if (bool_5) {
                        if ((modeldata_1.textureCoords != null) && (modeldata_1.textureCoords[int_2] != -1)) {
                            textureCoords[triangleFaceCount] = (byte) (field1484 + modeldata_1.textureCoords[int_2]);
                        } else {
                            textureCoords[triangleFaceCount] = -1;
                        }
                    }

                    faceColor[triangleFaceCount] = modeldata_1.faceColor[int_2];
                    trianglePointsX[triangleFaceCount] = method2572(modeldata_1, modeldata_1.trianglePointsX[int_2]);
                    trianglePointsY[triangleFaceCount] = method2572(modeldata_1, modeldata_1.trianglePointsY[int_2]);
                    trianglePointsZ[triangleFaceCount] = method2572(modeldata_1, modeldata_1.trianglePointsZ[int_2]);
                    ++triangleFaceCount;
                }

                for (int_2 = 0; int_2 < modeldata_1.field1484; int_2++) {
                    final byte byte_0 = textureRenderTypes[field1484] = modeldata_1.textureRenderTypes[int_2];
                    if (byte_0 == 0) {
                        texTriangleX[field1484] = (short) method2572(modeldata_1, modeldata_1.texTriangleX[int_2]);
                        texTriangleY[field1484] = (short) method2572(modeldata_1, modeldata_1.texTriangleY[int_2]);
                        texTriangleZ[field1484] = (short) method2572(modeldata_1, modeldata_1.texTriangleZ[int_2]);
                    }

                    ++field1484;
                }
            }
        }

    }

    ModelData(final byte[] bytes_0) {
        vertexCount = 0;
        triangleFaceCount = 0;
        priority = 0;
        field1488 = false;
        if ((bytes_0[bytes_0.length - 1] == -1) && (bytes_0[bytes_0.length - 2] == -1)) {
            decodeNewFormat(bytes_0);
        } else {
            decodeOldFormat(bytes_0);
        }

    }

    public ModelData(final ModelData modeldata_1, final boolean bool_0, final boolean bool_1, final boolean bool_2,
                     final boolean bool_3) {
        vertexCount = 0;
        triangleFaceCount = 0;
        priority = 0;
        field1488 = false;
        vertexCount = modeldata_1.vertexCount;
        triangleFaceCount = modeldata_1.triangleFaceCount;
        field1484 = modeldata_1.field1484;
        int int_0;
        if (bool_0) {
            vertexX = modeldata_1.vertexX;
            vertexY = modeldata_1.vertexY;
            vertexZ = modeldata_1.vertexZ;
        } else {
            vertexX = new int[vertexCount];
            vertexY = new int[vertexCount];
            vertexZ = new int[vertexCount];

            for (int_0 = 0; int_0 < vertexCount; int_0++) {
                vertexX[int_0] = modeldata_1.vertexX[int_0];
                vertexY[int_0] = modeldata_1.vertexY[int_0];
                vertexZ[int_0] = modeldata_1.vertexZ[int_0];
            }
        }

        if (bool_1) {
            faceColor = modeldata_1.faceColor;
        } else {
            faceColor = new short[triangleFaceCount];

            for (int_0 = 0; int_0 < triangleFaceCount; int_0++) {
                faceColor[int_0] = modeldata_1.faceColor[int_0];
            }
        }

        if (!bool_2 && (modeldata_1.faceTextures != null)) {
            faceTextures = new short[triangleFaceCount];

            for (int_0 = 0; int_0 < triangleFaceCount; int_0++) {
                faceTextures[int_0] = modeldata_1.faceTextures[int_0];
            }
        } else {
            faceTextures = modeldata_1.faceTextures;
        }

        faceAlphas = modeldata_1.faceAlphas;
        trianglePointsX = modeldata_1.trianglePointsX;
        trianglePointsY = modeldata_1.trianglePointsY;
        trianglePointsZ = modeldata_1.trianglePointsZ;
        faceRenderType = modeldata_1.faceRenderType;
        faceRenderPriorities = modeldata_1.faceRenderPriorities;
        textureCoords = modeldata_1.textureCoords;
        priority = modeldata_1.priority;
        textureRenderTypes = modeldata_1.textureRenderTypes;
        texTriangleX = modeldata_1.texTriangleX;
        texTriangleY = modeldata_1.texTriangleY;
        texTriangleZ = modeldata_1.texTriangleZ;
        vertexSkins = modeldata_1.vertexSkins;
        triangleSkinValues = modeldata_1.triangleSkinValues;
        field1481 = modeldata_1.field1481;
        field1482 = modeldata_1.field1482;
        normals = modeldata_1.normals;
        faceNormals = modeldata_1.faceNormals;
        field1485 = modeldata_1.field1485;
        field1486 = modeldata_1.field1486;
        contrast = modeldata_1.contrast;
    }

    void decodeNewFormat(final byte[] bytes_0) {
        final Buffer buffer_0 = new Buffer(bytes_0);
        final Buffer buffer_1 = new Buffer(bytes_0);
        final Buffer buffer_2 = new Buffer(bytes_0);
        final Buffer buffer_3 = new Buffer(bytes_0);
        final Buffer buffer_4 = new Buffer(bytes_0);
        final Buffer buffer_5 = new Buffer(bytes_0);
        final Buffer buffer_6 = new Buffer(bytes_0);
        buffer_0.offset = bytes_0.length - 23;
        final int int_0 = buffer_0.readUnsignedShort();
        final int int_1 = buffer_0.readUnsignedShort();
        final int int_2 = buffer_0.readUnsignedByte();
        final int int_3 = buffer_0.readUnsignedByte();
        final int int_4 = buffer_0.readUnsignedByte();
        final int int_5 = buffer_0.readUnsignedByte();
        final int int_6 = buffer_0.readUnsignedByte();
        final int int_7 = buffer_0.readUnsignedByte();
        final int int_8 = buffer_0.readUnsignedByte();
        final int int_9 = buffer_0.readUnsignedShort();
        final int int_10 = buffer_0.readUnsignedShort();
        final int int_11 = buffer_0.readUnsignedShort();
        final int int_12 = buffer_0.readUnsignedShort();
        final int int_13 = buffer_0.readUnsignedShort();
        int int_14 = 0;
        int int_15 = 0;
        int int_16 = 0;
        int int_17;
        if (int_2 > 0) {
            textureRenderTypes = new byte[int_2];
            buffer_0.offset = 0;

            for (int_17 = 0; int_17 < int_2; int_17++) {
                final byte byte_0 = textureRenderTypes[int_17] = buffer_0.readByte();
                if (byte_0 == 0) {
                    ++int_14;
                }

                if ((byte_0 >= 1) && (byte_0 <= 3)) {
                    ++int_15;
                }

                if (byte_0 == 2) {
                    ++int_16;
                }
            }
        }

        int_17 = int_2 + int_0;
        final int int_18 = int_17;
        if (int_3 == 1) {
            int_17 += int_1;
        }

        final int int_19 = int_17;
        int_17 += int_1;
        final int int_20 = int_17;
        if (int_4 == 255) {
            int_17 += int_1;
        }

        final int int_21 = int_17;
        if (int_6 == 1) {
            int_17 += int_1;
        }

        final int int_22 = int_17;
        if (int_8 == 1) {
            int_17 += int_0;
        }

        final int int_23 = int_17;
        if (int_5 == 1) {
            int_17 += int_1;
        }

        final int int_24 = int_17;
        int_17 += int_12;
        final int int_25 = int_17;
        if (int_7 == 1) {
            int_17 += int_1 * 2;
        }

        final int int_26 = int_17;
        int_17 += int_13;
        final int int_27 = int_17;
        int_17 += int_1 * 2;
        final int int_28 = int_17;
        int_17 += int_9;
        final int int_29 = int_17;
        int_17 += int_10;
        final int int_30 = int_17;
        int_17 += int_11;
        final int int_31 = int_17;
        int_17 += int_14 * 6;
        final int int_32 = int_17;
        int_17 += int_15 * 6;
        final int int_33 = int_17;
        int_17 += int_15 * 6;
        final int int_34 = int_17;
        int_17 += int_15 * 2;
        final int int_35 = int_17;
        int_17 += int_15;
        final int int_36 = int_17;
        int_17 += (int_15 * 2) + (int_16 * 2);
        vertexCount = int_0;
        triangleFaceCount = int_1;
        field1484 = int_2;
        vertexX = new int[int_0];
        vertexY = new int[int_0];
        vertexZ = new int[int_0];
        trianglePointsX = new int[int_1];
        trianglePointsY = new int[int_1];
        trianglePointsZ = new int[int_1];
        if (int_8 == 1) {
            vertexSkins = new int[int_0];
        }

        if (int_3 == 1) {
            faceRenderType = new byte[int_1];
        }

        if (int_4 == 255) {
            faceRenderPriorities = new byte[int_1];
        } else {
            priority = (byte) int_4;
        }

        if (int_5 == 1) {
            faceAlphas = new byte[int_1];
        }

        if (int_6 == 1) {
            triangleSkinValues = new int[int_1];
        }

        if (int_7 == 1) {
            faceTextures = new short[int_1];
        }

        if ((int_7 == 1) && (int_2 > 0)) {
            textureCoords = new byte[int_1];
        }

        faceColor = new short[int_1];
        if (int_2 > 0) {
            texTriangleX = new short[int_2];
            texTriangleY = new short[int_2];
            texTriangleZ = new short[int_2];
        }

        buffer_0.offset = int_2;
        buffer_1.offset = int_28;
        buffer_2.offset = int_29;
        buffer_3.offset = int_30;
        buffer_4.offset = int_22;
        int int_37 = 0;
        int int_38 = 0;
        int int_39 = 0;

        int int_40;
        int int_41;
        int int_42;
        int int_43;
        int int_44;
        for (int_40 = 0; int_40 < int_0; int_40++) {
            int_41 = buffer_0.readUnsignedByte();
            int_42 = 0;
            if ((int_41 & 0x1) != 0) {
                int_42 = buffer_1.readShortSmart();
            }

            int_43 = 0;
            if ((int_41 & 0x2) != 0) {
                int_43 = buffer_2.readShortSmart();
            }

            int_44 = 0;
            if ((int_41 & 0x4) != 0) {
                int_44 = buffer_3.readShortSmart();
            }

            vertexX[int_40] = int_37 + int_42;
            vertexY[int_40] = int_38 + int_43;
            vertexZ[int_40] = int_39 + int_44;
            int_37 = vertexX[int_40];
            int_38 = vertexY[int_40];
            int_39 = vertexZ[int_40];
            if (int_8 == 1) {
                vertexSkins[int_40] = buffer_4.readUnsignedByte();
            }
        }

        buffer_0.offset = int_27;
        buffer_1.offset = int_18;
        buffer_2.offset = int_20;
        buffer_3.offset = int_23;
        buffer_4.offset = int_21;
        buffer_5.offset = int_25;
        buffer_6.offset = int_26;

        for (int_40 = 0; int_40 < int_1; int_40++) {
            faceColor[int_40] = (short) buffer_0.readUnsignedShort();
            if (int_3 == 1) {
                faceRenderType[int_40] = buffer_1.readByte();
            }

            if (int_4 == 255) {
                faceRenderPriorities[int_40] = buffer_2.readByte();
            }

            if (int_5 == 1) {
                faceAlphas[int_40] = buffer_3.readByte();
            }

            if (int_6 == 1) {
                triangleSkinValues[int_40] = buffer_4.readUnsignedByte();
            }

            if (int_7 == 1) {
                faceTextures[int_40] = (short) (buffer_5.readUnsignedShort() - 1);
            }

            if ((textureCoords != null) && (faceTextures[int_40] != -1)) {
                textureCoords[int_40] = (byte) (buffer_6.readUnsignedByte() - 1);
            }
        }

        buffer_0.offset = int_24;
        buffer_1.offset = int_19;
        int_40 = 0;
        int_41 = 0;
        int_42 = 0;
        int_43 = 0;

        int int_45;
        for (int_44 = 0; int_44 < int_1; int_44++) {
            int_45 = buffer_1.readUnsignedByte();
            if (int_45 == 1) {
                int_40 = buffer_0.readShortSmart() + int_43;
                int_41 = buffer_0.readShortSmart() + int_40;
                int_42 = buffer_0.readShortSmart() + int_41;
                int_43 = int_42;
                trianglePointsX[int_44] = int_40;
                trianglePointsY[int_44] = int_41;
                trianglePointsZ[int_44] = int_42;
            }

            if (int_45 == 2) {
                int_41 = int_42;
                int_42 = buffer_0.readShortSmart() + int_43;
                int_43 = int_42;
                trianglePointsX[int_44] = int_40;
                trianglePointsY[int_44] = int_41;
                trianglePointsZ[int_44] = int_42;
            }

            if (int_45 == 3) {
                int_40 = int_42;
                int_42 = buffer_0.readShortSmart() + int_43;
                int_43 = int_42;
                trianglePointsX[int_44] = int_40;
                trianglePointsY[int_44] = int_41;
                trianglePointsZ[int_44] = int_42;
            }

            if (int_45 == 4) {
                final int int_46 = int_40;
                int_40 = int_41;
                int_41 = int_46;
                int_42 = buffer_0.readShortSmart() + int_43;
                int_43 = int_42;
                trianglePointsX[int_44] = int_40;
                trianglePointsY[int_44] = int_46;
                trianglePointsZ[int_44] = int_42;
            }
        }

        buffer_0.offset = int_31;
        buffer_1.offset = int_32;
        buffer_2.offset = int_33;
        buffer_3.offset = int_34;
        buffer_4.offset = int_35;
        buffer_5.offset = int_36;

        for (int_44 = 0; int_44 < int_2; int_44++) {
            int_45 = textureRenderTypes[int_44] & 0xFF;
            if (int_45 == 0) {
                texTriangleX[int_44] = (short) buffer_0.readUnsignedShort();
                texTriangleY[int_44] = (short) buffer_0.readUnsignedShort();
                texTriangleZ[int_44] = (short) buffer_0.readUnsignedShort();
            }
        }

        buffer_0.offset = int_17;
        int_44 = buffer_0.readUnsignedByte();
        if (int_44 != 0) {
            new class126();
            buffer_0.readUnsignedShort();
            buffer_0.readUnsignedShort();
            buffer_0.readUnsignedShort();
            buffer_0.readInt();
        }

    }

    void decodeOldFormat(final byte[] bytes_0) {
        boolean bool_0 = false;
        boolean bool_1 = false;
        final Buffer buffer_0 = new Buffer(bytes_0);
        final Buffer buffer_1 = new Buffer(bytes_0);
        final Buffer buffer_2 = new Buffer(bytes_0);
        final Buffer buffer_3 = new Buffer(bytes_0);
        final Buffer buffer_4 = new Buffer(bytes_0);
        buffer_0.offset = bytes_0.length - 18;
        final int int_0 = buffer_0.readUnsignedShort();
        final int int_1 = buffer_0.readUnsignedShort();
        final int int_2 = buffer_0.readUnsignedByte();
        final int int_3 = buffer_0.readUnsignedByte();
        final int int_4 = buffer_0.readUnsignedByte();
        final int int_5 = buffer_0.readUnsignedByte();
        final int int_6 = buffer_0.readUnsignedByte();
        final int int_7 = buffer_0.readUnsignedByte();
        final int int_9 = buffer_0.readUnsignedShort();
        final int int_10 = buffer_0.readUnsignedShort();
        final int int_11 = buffer_0.readUnsignedShort();
        final int int_12 = buffer_0.readUnsignedShort();
        final byte byte_0 = 0;
        int int_34 = byte_0 + int_0;
        final int int_13 = int_34;
        int_34 += int_1;
        final int int_14 = int_34;
        if (int_4 == 255) {
            int_34 += int_1;
        }

        final int int_15 = int_34;
        if (int_6 == 1) {
            int_34 += int_1;
        }

        final int int_16 = int_34;
        if (int_3 == 1) {
            int_34 += int_1;
        }

        final int int_17 = int_34;
        if (int_7 == 1) {
            int_34 += int_0;
        }

        final int int_18 = int_34;
        if (int_5 == 1) {
            int_34 += int_1;
        }

        final int int_19 = int_34;
        int_34 += int_12;
        final int int_20 = int_34;
        int_34 += int_1 * 2;
        final int int_21 = int_34;
        int_34 += int_2 * 6;
        final int int_22 = int_34;
        int_34 += int_9;
        final int int_23 = int_34;
        int_34 += int_10;
        vertexCount = int_0;
        triangleFaceCount = int_1;
        field1484 = int_2;
        vertexX = new int[int_0];
        vertexY = new int[int_0];
        vertexZ = new int[int_0];
        trianglePointsX = new int[int_1];
        trianglePointsY = new int[int_1];
        trianglePointsZ = new int[int_1];
        if (int_2 > 0) {
            textureRenderTypes = new byte[int_2];
            texTriangleX = new short[int_2];
            texTriangleY = new short[int_2];
            texTriangleZ = new short[int_2];
        }

        if (int_7 == 1) {
            vertexSkins = new int[int_0];
        }

        if (int_3 == 1) {
            faceRenderType = new byte[int_1];
            textureCoords = new byte[int_1];
            faceTextures = new short[int_1];
        }

        if (int_4 == 255) {
            faceRenderPriorities = new byte[int_1];
        } else {
            priority = (byte) int_4;
        }

        if (int_5 == 1) {
            faceAlphas = new byte[int_1];
        }

        if (int_6 == 1) {
            triangleSkinValues = new int[int_1];
        }

        faceColor = new short[int_1];
        buffer_0.offset = byte_0;
        buffer_1.offset = int_22;
        buffer_2.offset = int_23;
        buffer_3.offset = int_34;
        buffer_4.offset = int_17;
        int int_24 = 0;
        int int_25 = 0;
        int int_26 = 0;

        int int_27;
        int int_28;
        int int_29;
        int int_30;
        int int_31;
        for (int_27 = 0; int_27 < int_0; int_27++) {
            int_28 = buffer_0.readUnsignedByte();
            int_29 = 0;
            if ((int_28 & 0x1) != 0) {
                int_29 = buffer_1.readShortSmart();
            }

            int_30 = 0;
            if ((int_28 & 0x2) != 0) {
                int_30 = buffer_2.readShortSmart();
            }

            int_31 = 0;
            if ((int_28 & 0x4) != 0) {
                int_31 = buffer_3.readShortSmart();
            }

            vertexX[int_27] = int_24 + int_29;
            vertexY[int_27] = int_25 + int_30;
            vertexZ[int_27] = int_26 + int_31;
            int_24 = vertexX[int_27];
            int_25 = vertexY[int_27];
            int_26 = vertexZ[int_27];
            if (int_7 == 1) {
                vertexSkins[int_27] = buffer_4.readUnsignedByte();
            }
        }

        buffer_0.offset = int_20;
        buffer_1.offset = int_16;
        buffer_2.offset = int_14;
        buffer_3.offset = int_18;
        buffer_4.offset = int_15;

        for (int_27 = 0; int_27 < int_1; int_27++) {
            faceColor[int_27] = (short) buffer_0.readUnsignedShort();
            if (int_3 == 1) {
                int_28 = buffer_1.readUnsignedByte();
                if ((int_28 & 0x1) == 1) {
                    faceRenderType[int_27] = 1;
                    bool_0 = true;
                } else {
                    faceRenderType[int_27] = 0;
                }

                if ((int_28 & 0x2) == 2) {
                    textureCoords[int_27] = (byte) (int_28 >> 2);
                    faceTextures[int_27] = faceColor[int_27];
                    faceColor[int_27] = 127;
                    if (faceTextures[int_27] != -1) {
                        bool_1 = true;
                    }
                } else {
                    textureCoords[int_27] = -1;
                    faceTextures[int_27] = -1;
                }
            }

            if (int_4 == 255) {
                faceRenderPriorities[int_27] = buffer_2.readByte();
            }

            if (int_5 == 1) {
                faceAlphas[int_27] = buffer_3.readByte();
            }

            if (int_6 == 1) {
                triangleSkinValues[int_27] = buffer_4.readUnsignedByte();
            }
        }

        buffer_0.offset = int_19;
        buffer_1.offset = int_13;
        int_27 = 0;
        int_28 = 0;
        int_29 = 0;
        int_30 = 0;

        int int_32;
        int int_33;
        for (int_31 = 0; int_31 < int_1; int_31++) {
            int_32 = buffer_1.readUnsignedByte();
            if (int_32 == 1) {
                int_27 = buffer_0.readShortSmart() + int_30;
                int_28 = buffer_0.readShortSmart() + int_27;
                int_29 = buffer_0.readShortSmart() + int_28;
                int_30 = int_29;
                trianglePointsX[int_31] = int_27;
                trianglePointsY[int_31] = int_28;
                trianglePointsZ[int_31] = int_29;
            }

            if (int_32 == 2) {
                int_28 = int_29;
                int_29 = buffer_0.readShortSmart() + int_30;
                int_30 = int_29;
                trianglePointsX[int_31] = int_27;
                trianglePointsY[int_31] = int_28;
                trianglePointsZ[int_31] = int_29;
            }

            if (int_32 == 3) {
                int_27 = int_29;
                int_29 = buffer_0.readShortSmart() + int_30;
                int_30 = int_29;
                trianglePointsX[int_31] = int_27;
                trianglePointsY[int_31] = int_28;
                trianglePointsZ[int_31] = int_29;
            }

            if (int_32 == 4) {
                int_33 = int_27;
                int_27 = int_28;
                int_28 = int_33;
                int_29 = buffer_0.readShortSmart() + int_30;
                int_30 = int_29;
                trianglePointsX[int_31] = int_27;
                trianglePointsY[int_31] = int_33;
                trianglePointsZ[int_31] = int_29;
            }
        }

        buffer_0.offset = int_21;

        for (int_31 = 0; int_31 < int_2; int_31++) {
            textureRenderTypes[int_31] = 0;
            texTriangleX[int_31] = (short) buffer_0.readUnsignedShort();
            texTriangleY[int_31] = (short) buffer_0.readUnsignedShort();
            texTriangleZ[int_31] = (short) buffer_0.readUnsignedShort();
        }

        if (textureCoords != null) {
            boolean bool_2 = false;

            for (int_32 = 0; int_32 < int_1; int_32++) {
                int_33 = textureCoords[int_32] & 0xFF;
                if (int_33 != 255) {
                    if ((trianglePointsX[int_32] == (texTriangleX[int_33] & 0xFFFF))
                            && (trianglePointsY[int_32] == (texTriangleY[int_33] & 0xFFFF))
                            && (trianglePointsZ[int_32] == (texTriangleZ[int_33] & 0xFFFF))) {
                        textureCoords[int_32] = -1;
                    } else {
                        bool_2 = true;
                    }
                }
            }

            if (!bool_2) {
                textureCoords = null;
            }
        }

        if (!bool_1) {
            faceTextures = null;
        }

        if (!bool_0) {
            faceRenderType = null;
        }

    }

    int method2572(final ModelData modeldata_1, final int int_0) {
        int int_1 = -1;
        final int int_2 = modeldata_1.vertexX[int_0];
        final int int_3 = modeldata_1.vertexY[int_0];
        final int int_4 = modeldata_1.vertexZ[int_0];

        for (int int_5 = 0; int_5 < vertexCount; int_5++) {
            if ((int_2 == vertexX[int_5]) && (int_3 == vertexY[int_5]) && (int_4 == vertexZ[int_5])) {
                int_1 = int_5;
                break;
            }
        }

        if (int_1 == -1) {
            vertexX[vertexCount] = int_2;
            vertexY[vertexCount] = int_3;
            vertexZ[vertexCount] = int_4;
            if (modeldata_1.vertexSkins != null) {
                vertexSkins[vertexCount] = modeldata_1.vertexSkins[int_0];
            }

            int_1 = vertexCount++;
        }

        return int_1;
    }

    public ModelData method2650() {
        final ModelData modeldata_1 = new ModelData();
        if (faceRenderType != null) {
            modeldata_1.faceRenderType = new byte[triangleFaceCount];

            for (int int_0 = 0; int_0 < triangleFaceCount; int_0++) {
                modeldata_1.faceRenderType[int_0] = faceRenderType[int_0];
            }
        }

        modeldata_1.vertexCount = vertexCount;
        modeldata_1.triangleFaceCount = triangleFaceCount;
        modeldata_1.field1484 = field1484;
        modeldata_1.vertexX = vertexX;
        modeldata_1.vertexY = vertexY;
        modeldata_1.vertexZ = vertexZ;
        modeldata_1.trianglePointsX = trianglePointsX;
        modeldata_1.trianglePointsY = trianglePointsY;
        modeldata_1.trianglePointsZ = trianglePointsZ;
        modeldata_1.faceRenderPriorities = faceRenderPriorities;
        modeldata_1.faceAlphas = faceAlphas;
        modeldata_1.textureCoords = textureCoords;
        modeldata_1.faceColor = faceColor;
        modeldata_1.faceTextures = faceTextures;
        modeldata_1.priority = priority;
        modeldata_1.textureRenderTypes = textureRenderTypes;
        modeldata_1.texTriangleX = texTriangleX;
        modeldata_1.texTriangleY = texTriangleY;
        modeldata_1.texTriangleZ = texTriangleZ;
        modeldata_1.vertexSkins = vertexSkins;
        modeldata_1.triangleSkinValues = triangleSkinValues;
        modeldata_1.field1481 = field1481;
        modeldata_1.field1482 = field1482;
        modeldata_1.normals = normals;
        modeldata_1.faceNormals = faceNormals;
        modeldata_1.field1486 = field1486;
        modeldata_1.contrast = contrast;
        return modeldata_1;
    }

    public ModelData method2567(final int[][] ints_0, final int int_0, final int int_1, final int int_2,
                                final boolean bool_0, final int int_3) {
        method2627();
        int int_4 = int_0 + field1480;
        int int_5 = int_0 + field1492;
        int int_6 = int_2 + field1493;
        int int_7 = int_2 + field1498;
        if ((int_4 >= 0) && (((int_5 + 128) >> 7) < ints_0.length) && (int_6 >= 0)
                && (((int_7 + 128) >> 7) < ints_0[0].length)) {
            int_4 >>= 7;
            int_5 = (int_5 + 127) >> 7;
            int_6 >>= 7;
            int_7 = (int_7 + 127) >> 7;
            if ((int_1 == ints_0[int_4][int_6]) && (int_1 == ints_0[int_5][int_6]) && (int_1 == ints_0[int_4][int_7])
                    && (int_1 == ints_0[int_5][int_7])) {
                return this;
            } else {
                final ModelData modeldata_1 = new ModelData();
                modeldata_1.vertexCount = vertexCount;
                modeldata_1.triangleFaceCount = triangleFaceCount;
                modeldata_1.field1484 = field1484;
                modeldata_1.vertexX = vertexX;
                modeldata_1.vertexZ = vertexZ;
                modeldata_1.trianglePointsX = trianglePointsX;
                modeldata_1.trianglePointsY = trianglePointsY;
                modeldata_1.trianglePointsZ = trianglePointsZ;
                modeldata_1.faceRenderType = faceRenderType;
                modeldata_1.faceRenderPriorities = faceRenderPriorities;
                modeldata_1.faceAlphas = faceAlphas;
                modeldata_1.textureCoords = textureCoords;
                modeldata_1.faceColor = faceColor;
                modeldata_1.faceTextures = faceTextures;
                modeldata_1.priority = priority;
                modeldata_1.textureRenderTypes = textureRenderTypes;
                modeldata_1.texTriangleX = texTriangleX;
                modeldata_1.texTriangleY = texTriangleY;
                modeldata_1.texTriangleZ = texTriangleZ;
                modeldata_1.vertexSkins = vertexSkins;
                modeldata_1.triangleSkinValues = triangleSkinValues;
                modeldata_1.field1481 = field1481;
                modeldata_1.field1482 = field1482;
                modeldata_1.field1486 = field1486;
                modeldata_1.contrast = contrast;
                modeldata_1.vertexY = new int[modeldata_1.vertexCount];
                int int_8;
                int int_9;
                int int_10;
                int int_11;
                int int_12;
                int int_13;
                int int_14;
                int int_15;
                int int_16;
                int int_17;
                if (int_3 == 0) {
                    for (int_8 = 0; int_8 < modeldata_1.vertexCount; int_8++) {
                        int_9 = int_0 + vertexX[int_8];
                        int_10 = int_2 + vertexZ[int_8];
                        int_11 = int_9 & 0x7F;
                        int_12 = int_10 & 0x7F;
                        int_13 = int_9 >> 7;
                        int_14 = int_10 >> 7;
                        int_15 = ((ints_0[int_13][int_14] * (128 - int_11))
                                + (ints_0[int_13 + 1][int_14] * int_11)) >> 7;
                        int_16 = ((ints_0[int_13][int_14 + 1] * (128 - int_11))
                                + (int_11 * ints_0[int_13 + 1][int_14 + 1])) >> 7;
                        int_17 = ((int_15 * (128 - int_12)) + (int_16 * int_12)) >> 7;
                        modeldata_1.vertexY[int_8] = (int_17 + vertexY[int_8]) - int_1;
                    }
                } else {
                    for (int_8 = 0; int_8 < modeldata_1.vertexCount; int_8++) {
                        int_9 = (-vertexY[int_8] << 16) / super.modelHeight;
                        if (int_9 < int_3) {
                            int_10 = int_0 + vertexX[int_8];
                            int_11 = int_2 + vertexZ[int_8];
                            int_12 = int_10 & 0x7F;
                            int_13 = int_11 & 0x7F;
                            int_14 = int_10 >> 7;
                            int_15 = int_11 >> 7;
                            int_16 = ((ints_0[int_14][int_15] * (128 - int_12))
                                    + (ints_0[int_14 + 1][int_15] * int_12)) >> 7;
                            int_17 = ((ints_0[int_14][int_15 + 1] * (128 - int_12))
                                    + (int_12 * ints_0[int_14 + 1][int_15 + 1])) >> 7;
                            final int int_18 = ((int_16 * (128 - int_13)) + (int_17 * int_13)) >> 7;
                            modeldata_1.vertexY[int_8] = (((int_3 - int_9) * (int_18 - int_1)) / int_3)
                                    + vertexY[int_8];
                        }
                    }
                }

                modeldata_1.method2586();
                return modeldata_1;
            }
        } else {
            return this;
        }
    }

    void computeAnimationTables() {
        int[] ints_0;
        int int_0;
        int int_1;
        int int_2;
        if (vertexSkins != null) {
            ints_0 = new int[256];
            int_0 = 0;

            for (int_1 = 0; int_1 < vertexCount; int_1++) {
                int_2 = vertexSkins[int_1];
                ++ints_0[int_2];
                if (int_2 > int_0) {
                    int_0 = int_2;
                }
            }

            field1481 = new int[int_0 + 1][];

            for (int_1 = 0; int_1 <= int_0; int_1++) {
                field1481[int_1] = new int[ints_0[int_1]];
                ints_0[int_1] = 0;
            }

            for (int_1 = 0; int_1 < vertexCount; field1481[int_2][ints_0[int_2]++] = int_1++) {
                int_2 = vertexSkins[int_1];
            }

            vertexSkins = null;
        }

        if (triangleSkinValues != null) {
            ints_0 = new int[256];
            int_0 = 0;

            for (int_1 = 0; int_1 < triangleFaceCount; int_1++) {
                int_2 = triangleSkinValues[int_1];
                ++ints_0[int_2];
                if (int_2 > int_0) {
                    int_0 = int_2;
                }
            }

            field1482 = new int[int_0 + 1][];

            for (int_1 = 0; int_1 <= int_0; int_1++) {
                field1482[int_1] = new int[ints_0[int_1]];
                ints_0[int_1] = 0;
            }

            for (int_1 = 0; int_1 < triangleFaceCount; field1482[int_2][ints_0[int_2]++] = int_1++) {
                int_2 = triangleSkinValues[int_1];
            }

            triangleSkinValues = null;
        }

    }

    public void method2576() {
        for (int int_0 = 0; int_0 < vertexCount; int_0++) {
            final int int_1 = vertexX[int_0];
            vertexX[int_0] = vertexZ[int_0];
            vertexZ[int_0] = -int_1;
        }

        method2586();
    }

    public void method2573() {
        for (int int_0 = 0; int_0 < vertexCount; int_0++) {
            vertexX[int_0] = -vertexX[int_0];
            vertexZ[int_0] = -vertexZ[int_0];
        }

        method2586();
    }

    public void method2578() {
        for (int int_0 = 0; int_0 < vertexCount; int_0++) {
            final int int_1 = vertexZ[int_0];
            vertexZ[int_0] = vertexX[int_0];
            vertexX[int_0] = -int_1;
        }

        method2586();
    }

    public void method2653(final int int_0) {
        final int int_1 = field1497[int_0];
        final int int_2 = field1495[int_0];

        for (int int_3 = 0; int_3 < vertexCount; int_3++) {
            final int int_4 = ((int_1 * vertexZ[int_3]) + (int_2 * vertexX[int_3])) >> 16;
            vertexZ[int_3] = ((int_2 * vertexZ[int_3]) - (int_1 * vertexX[int_3])) >> 16;
            vertexX[int_3] = int_4;
        }

        method2586();
    }

    public void method2580(final int int_0, final int int_1, final int int_2) {
        for (int int_3 = 0; int_3 < vertexCount; int_3++) {
            vertexX[int_3] += int_0;
            vertexY[int_3] += int_1;
            vertexZ[int_3] += int_2;
        }

        method2586();
    }

    public void recolor(final short short_0, final short short_1) {
        for (int int_0 = 0; int_0 < triangleFaceCount; int_0++) {
            if (faceColor[int_0] == short_0) {
                faceColor[int_0] = short_1;
            }
        }

    }

    public void method2582(final short short_0, final short short_1) {
        if (faceTextures != null) {
            for (int int_0 = 0; int_0 < triangleFaceCount; int_0++) {
                if (faceTextures[int_0] == short_0) {
                    faceTextures[int_0] = short_1;
                }
            }

        }
    }

    public void method2583() {
        int int_0;
        for (int_0 = 0; int_0 < vertexCount; int_0++) {
            vertexZ[int_0] = -vertexZ[int_0];
        }

        for (int_0 = 0; int_0 < triangleFaceCount; int_0++) {
            final int int_1 = trianglePointsX[int_0];
            trianglePointsX[int_0] = trianglePointsZ[int_0];
            trianglePointsZ[int_0] = int_1;
        }

        method2586();
    }

    public void method2592(final int int_0, final int int_1, final int int_2) {
        for (int int_3 = 0; int_3 < vertexCount; int_3++) {
            vertexX[int_3] = (vertexX[int_3] * int_0) / 128;
            vertexY[int_3] = (int_1 * vertexY[int_3]) / 128;
            vertexZ[int_3] = (int_2 * vertexZ[int_3]) / 128;
        }

        method2586();
    }

    public void computeNormals() {
        if (normals == null) {
            normals = new VertexNormal[vertexCount];

            int int_0;
            for (int_0 = 0; int_0 < vertexCount; int_0++) {
                normals[int_0] = new VertexNormal();
            }

            for (int_0 = 0; int_0 < triangleFaceCount; int_0++) {
                final int int_1 = trianglePointsX[int_0];
                final int int_2 = trianglePointsY[int_0];
                final int int_3 = trianglePointsZ[int_0];
                final int int_4 = vertexX[int_2] - vertexX[int_1];
                final int int_5 = vertexY[int_2] - vertexY[int_1];
                final int int_6 = vertexZ[int_2] - vertexZ[int_1];
                final int int_7 = vertexX[int_3] - vertexX[int_1];
                final int int_8 = vertexY[int_3] - vertexY[int_1];
                final int int_9 = vertexZ[int_3] - vertexZ[int_1];
                int int_10 = (int_5 * int_9) - (int_8 * int_6);
                int int_11 = (int_6 * int_7) - (int_9 * int_4);

                int int_12;
                for (int_12 = (int_4 * int_8) - (int_7 * int_5); (int_10 > 8192) || (int_11 > 8192) || (int_12 > 8192)
                        || (int_10 < -8192) || (int_11 < -8192) || (int_12 < -8192); int_12 >>= 1) {
                    int_10 >>= 1;
                    int_11 >>= 1;
                }

                int int_13 = (int) Math.sqrt((int_10 * int_10) + (int_11 * int_11) + (int_12 * int_12));
                if (int_13 <= 0) {
                    int_13 = 1;
                }

                int_10 = (int_10 * 256) / int_13;
                int_11 = (int_11 * 256) / int_13;
                int_12 = (int_12 * 256) / int_13;
                byte byte_0;
                if (faceRenderType == null) {
                    byte_0 = 0;
                } else {
                    byte_0 = faceRenderType[int_0];
                }

                if (byte_0 == 0) {
                    VertexNormal vertexnormal_0 = normals[int_1];
                    vertexnormal_0.x += int_10;
                    vertexnormal_0.y += int_11;
                    vertexnormal_0.z += int_12;
                    ++vertexnormal_0.magnitude;
                    vertexnormal_0 = normals[int_2];
                    vertexnormal_0.x += int_10;
                    vertexnormal_0.y += int_11;
                    vertexnormal_0.z += int_12;
                    ++vertexnormal_0.magnitude;
                    vertexnormal_0 = normals[int_3];
                    vertexnormal_0.x += int_10;
                    vertexnormal_0.y += int_11;
                    vertexnormal_0.z += int_12;
                    ++vertexnormal_0.magnitude;
                } else if (byte_0 == 1) {
                    if (faceNormals == null) {
                        faceNormals = new FaceNormal[triangleFaceCount];
                    }

                    final FaceNormal facenormal_0 = faceNormals[int_0] = new FaceNormal();
                    facenormal_0.x = int_10;
                    facenormal_0.y = int_11;
                    facenormal_0.z = int_12;
                }
            }

        }
    }

    void method2586() {
        normals = null;
        field1485 = null;
        faceNormals = null;
        field1488 = false;
    }

    void method2627() {
        if (!field1488) {
            super.modelHeight = 0;
            field1489 = 0;
            field1480 = 999999;
            field1492 = -999999;
            field1498 = -99999;
            field1493 = 99999;

            for (int int_0 = 0; int_0 < vertexCount; int_0++) {
                final int int_1 = vertexX[int_0];
                final int int_2 = vertexY[int_0];
                final int int_3 = vertexZ[int_0];
                if (int_1 < field1480) {
                    field1480 = int_1;
                }

                if (int_1 > field1492) {
                    field1492 = int_1;
                }

                if (int_3 < field1493) {
                    field1493 = int_3;
                }

                if (int_3 > field1498) {
                    field1498 = int_3;
                }

                if (-int_2 > super.modelHeight) {
                    super.modelHeight = -int_2;
                }

                if (int_2 > field1489) {
                    field1489 = int_2;
                }
            }

            field1488 = true;
        }
    }

    public Model light(final int int_0, final int int_1, final int int_2, final int int_3, final int int_4) {
        computeNormals();
        final int int_5 = (int) Math.sqrt((int_4 * int_4) + (int_2 * int_2) + (int_3 * int_3));
        final int int_6 = (int_5 * int_1) >> 8;
        final Model model_0 = new Model();
        model_0.field1615 = new int[triangleFaceCount];
        model_0.field1620 = new int[triangleFaceCount];
        model_0.field1591 = new int[triangleFaceCount];
        if ((field1484 > 0) && (textureCoords != null)) {
            final int[] ints_0 = new int[field1484];

            int int_7;
            for (int_7 = 0; int_7 < triangleFaceCount; int_7++) {
                if (textureCoords[int_7] != -1) {
                    ++ints_0[textureCoords[int_7] & 0xFF];
                }
            }

            model_0.field1597 = 0;

            for (int_7 = 0; int_7 < field1484; int_7++) {
                if ((ints_0[int_7] > 0) && (textureRenderTypes[int_7] == 0)) {
                    ++model_0.field1597;
                }
            }

            model_0.field1621 = new int[model_0.field1597];
            model_0.field1599 = new int[model_0.field1597];
            model_0.field1600 = new int[model_0.field1597];
            int_7 = 0;

            int int_9;
            for (int_9 = 0; int_9 < field1484; int_9++) {
                if ((ints_0[int_9] > 0) && (textureRenderTypes[int_9] == 0)) {
                    model_0.field1621[int_7] = texTriangleX[int_9] & 0xFFFF;
                    model_0.field1599[int_7] = texTriangleY[int_9] & 0xFFFF;
                    model_0.field1600[int_7] = texTriangleZ[int_9] & 0xFFFF;
                    ints_0[int_9] = int_7++;
                } else {
                    ints_0[int_9] = -1;
                }
            }

            model_0.field1617 = new byte[triangleFaceCount];

            for (int_9 = 0; int_9 < triangleFaceCount; int_9++) {
                if (textureCoords[int_9] != -1) {
                    model_0.field1617[int_9] = (byte) ints_0[textureCoords[int_9] & 0xFF];
                } else {
                    model_0.field1617[int_9] = -1;
                }
            }
        }

        for (int int_8 = 0; int_8 < triangleFaceCount; int_8++) {
            byte byte_0;
            if (faceRenderType == null) {
                byte_0 = 0;
            } else {
                byte_0 = faceRenderType[int_8];
            }

            byte byte_1;
            if (faceAlphas == null) {
                byte_1 = 0;
            } else {
                byte_1 = faceAlphas[int_8];
            }

            short short_0;
            if (faceTextures == null) {
                short_0 = -1;
            } else {
                short_0 = faceTextures[int_8];
            }

            if (byte_1 == -2) {
                byte_0 = 3;
            }

            if (byte_1 == -1) {
                byte_0 = 2;
            }

            VertexNormal vertexnormal_0;
            int int_11;
            FaceNormal facenormal_0;
            if (short_0 == -1) {
                if (byte_0 != 0) {
                    if (byte_0 == 1) {
                        facenormal_0 = faceNormals[int_8];
                        int_11 = (((int_3 * facenormal_0.y) + (int_4 * facenormal_0.z) + (int_2 * facenormal_0.x))
                                / ((int_6 / 2) + int_6)) + int_0;
                        model_0.field1615[int_8] = method2590(faceColor[int_8] & 0xFFFF, int_11);
                        model_0.field1591[int_8] = -1;
                    } else if (byte_0 == 3) {
                        model_0.field1615[int_8] = 128;
                        model_0.field1591[int_8] = -1;
                    } else {
                        model_0.field1591[int_8] = -2;
                    }
                } else {
                    final int int_10 = faceColor[int_8] & 0xFFFF;
                    if ((field1485 != null) && (field1485[trianglePointsX[int_8]] != null)) {
                        vertexnormal_0 = field1485[trianglePointsX[int_8]];
                    } else {
                        vertexnormal_0 = normals[trianglePointsX[int_8]];
                    }

                    int_11 = (((int_3 * vertexnormal_0.y) + (int_4 * vertexnormal_0.z) + (int_2 * vertexnormal_0.x))
                            / (int_6 * vertexnormal_0.magnitude)) + int_0;
                    model_0.field1615[int_8] = method2590(int_10, int_11);
                    if ((field1485 != null) && (field1485[trianglePointsY[int_8]] != null)) {
                        vertexnormal_0 = field1485[trianglePointsY[int_8]];
                    } else {
                        vertexnormal_0 = normals[trianglePointsY[int_8]];
                    }

                    int_11 = (((int_3 * vertexnormal_0.y) + (int_4 * vertexnormal_0.z) + (int_2 * vertexnormal_0.x))
                            / (int_6 * vertexnormal_0.magnitude)) + int_0;
                    model_0.field1620[int_8] = method2590(int_10, int_11);
                    if ((field1485 != null) && (field1485[trianglePointsZ[int_8]] != null)) {
                        vertexnormal_0 = field1485[trianglePointsZ[int_8]];
                    } else {
                        vertexnormal_0 = normals[trianglePointsZ[int_8]];
                    }

                    int_11 = (((int_3 * vertexnormal_0.y) + (int_4 * vertexnormal_0.z) + (int_2 * vertexnormal_0.x))
                            / (int_6 * vertexnormal_0.magnitude)) + int_0;
                    model_0.field1591[int_8] = method2590(int_10, int_11);
                }
            } else if (byte_0 != 0) {
                if (byte_0 == 1) {
                    facenormal_0 = faceNormals[int_8];
                    int_11 = (((int_3 * facenormal_0.y) + (int_4 * facenormal_0.z) + (int_2 * facenormal_0.x))
                            / ((int_6 / 2) + int_6)) + int_0;
                    model_0.field1615[int_8] = method2591(int_11);
                    model_0.field1591[int_8] = -1;
                } else {
                    model_0.field1591[int_8] = -2;
                }
            } else {
                if ((field1485 != null) && (field1485[trianglePointsX[int_8]] != null)) {
                    vertexnormal_0 = field1485[trianglePointsX[int_8]];
                } else {
                    vertexnormal_0 = normals[trianglePointsX[int_8]];
                }

                int_11 = (((int_3 * vertexnormal_0.y) + (int_4 * vertexnormal_0.z) + (int_2 * vertexnormal_0.x))
                        / (int_6 * vertexnormal_0.magnitude)) + int_0;
                model_0.field1615[int_8] = method2591(int_11);
                if ((field1485 != null) && (field1485[trianglePointsY[int_8]] != null)) {
                    vertexnormal_0 = field1485[trianglePointsY[int_8]];
                } else {
                    vertexnormal_0 = normals[trianglePointsY[int_8]];
                }

                int_11 = (((int_3 * vertexnormal_0.y) + (int_4 * vertexnormal_0.z) + (int_2 * vertexnormal_0.x))
                        / (int_6 * vertexnormal_0.magnitude)) + int_0;
                model_0.field1620[int_8] = method2591(int_11);
                if ((field1485 != null) && (field1485[trianglePointsZ[int_8]] != null)) {
                    vertexnormal_0 = field1485[trianglePointsZ[int_8]];
                } else {
                    vertexnormal_0 = normals[trianglePointsZ[int_8]];
                }

                int_11 = (((int_3 * vertexnormal_0.y) + (int_4 * vertexnormal_0.z) + (int_2 * vertexnormal_0.x))
                        / (int_6 * vertexnormal_0.magnitude)) + int_0;
                model_0.field1591[int_8] = method2591(int_11);
            }
        }

        computeAnimationTables();
        model_0.verticesCount = vertexCount;
        model_0.verticesX = vertexX;
        model_0.verticesY = vertexY;
        model_0.verticesZ = vertexZ;
        model_0.indicesCount = triangleFaceCount;
        model_0.indices1 = trianglePointsX;
        model_0.indices2 = trianglePointsY;
        model_0.indices3 = trianglePointsZ;
        model_0.field1645 = faceRenderPriorities;
        model_0.field1593 = faceAlphas;
        model_0.field1596 = priority;
        model_0.vertexGroups = field1481;
        model_0.field1602 = field1482;
        model_0.field1604 = faceTextures;
        return model_0;
    }

    public static ModelData method2568(final IndexDataBase indexdatabase_0, final int int_0, final int int_1) {
        final byte[] bytes_0 = indexdatabase_0.getConfigData(int_0, int_1);
        return bytes_0 == null ? null : new ModelData(bytes_0);
    }

    static void method2588(final ModelData modeldata_0, final ModelData modeldata_1, final int int_0, final int int_1,
                           final int int_2, final boolean bool_0) {
        modeldata_0.method2627();
        modeldata_0.computeNormals();
        modeldata_1.method2627();
        modeldata_1.computeNormals();
        ++field1474;
        int int_3 = 0;
        final int[] ints_0 = modeldata_1.vertexX;
        final int int_4 = modeldata_1.vertexCount;

        int int_5;
        for (int_5 = 0; int_5 < modeldata_0.vertexCount; int_5++) {
            final VertexNormal vertexnormal_0 = modeldata_0.normals[int_5];
            if (vertexnormal_0.magnitude != 0) {
                final int int_6 = modeldata_0.vertexY[int_5] - int_1;
                if (int_6 <= modeldata_1.field1489) {
                    final int int_7 = modeldata_0.vertexX[int_5] - int_0;
                    if ((int_7 >= modeldata_1.field1480) && (int_7 <= modeldata_1.field1492)) {
                        final int int_8 = modeldata_0.vertexZ[int_5] - int_2;
                        if ((int_8 >= modeldata_1.field1493) && (int_8 <= modeldata_1.field1498)) {
                            for (int int_9 = 0; int_9 < int_4; int_9++) {
                                final VertexNormal vertexnormal_1 = modeldata_1.normals[int_9];
                                if ((int_7 == ints_0[int_9]) && (int_8 == modeldata_1.vertexZ[int_9])
                                        && (int_6 == modeldata_1.vertexY[int_9]) && (vertexnormal_1.magnitude != 0)) {
                                    if (modeldata_0.field1485 == null) {
                                        modeldata_0.field1485 = new VertexNormal[modeldata_0.vertexCount];
                                    }

                                    if (modeldata_1.field1485 == null) {
                                        modeldata_1.field1485 = new VertexNormal[int_4];
                                    }

                                    VertexNormal vertexnormal_2 = modeldata_0.field1485[int_5];
                                    if (vertexnormal_2 == null) {
                                        vertexnormal_2 = modeldata_0.field1485[int_5] = new VertexNormal(
                                                vertexnormal_0);
                                    }

                                    VertexNormal vertexnormal_3 = modeldata_1.field1485[int_9];
                                    if (vertexnormal_3 == null) {
                                        vertexnormal_3 = modeldata_1.field1485[int_9] = new VertexNormal(
                                                vertexnormal_1);
                                    }

                                    vertexnormal_2.x += vertexnormal_1.x;
                                    vertexnormal_2.y += vertexnormal_1.y;
                                    vertexnormal_2.z += vertexnormal_1.z;
                                    vertexnormal_2.magnitude += vertexnormal_1.magnitude;
                                    vertexnormal_3.x += vertexnormal_0.x;
                                    vertexnormal_3.y += vertexnormal_0.y;
                                    vertexnormal_3.z += vertexnormal_0.z;
                                    vertexnormal_3.magnitude += vertexnormal_0.magnitude;
                                    ++int_3;
                                    field1494[int_5] = field1474;
                                    field1475[int_9] = field1474;
                                }
                            }
                        }
                    }
                }
            }
        }

        if ((int_3 >= 3) && bool_0) {
            for (int_5 = 0; int_5 < modeldata_0.triangleFaceCount; int_5++) {
                if ((field1494[modeldata_0.trianglePointsX[int_5]] == field1474)
                        && (field1494[modeldata_0.trianglePointsY[int_5]] == field1474)
                        && (field1494[modeldata_0.trianglePointsZ[int_5]] == field1474)) {
                    if (modeldata_0.faceRenderType == null) {
                        modeldata_0.faceRenderType = new byte[modeldata_0.triangleFaceCount];
                    }

                    modeldata_0.faceRenderType[int_5] = 2;
                }
            }

            for (int_5 = 0; int_5 < modeldata_1.triangleFaceCount; int_5++) {
                if ((field1474 == field1475[modeldata_1.trianglePointsX[int_5]])
                        && (field1474 == field1475[modeldata_1.trianglePointsY[int_5]])
                        && (field1474 == field1475[modeldata_1.trianglePointsZ[int_5]])) {
                    if (modeldata_1.faceRenderType == null) {
                        modeldata_1.faceRenderType = new byte[modeldata_1.triangleFaceCount];
                    }

                    modeldata_1.faceRenderType[int_5] = 2;
                }
            }

        }
    }

    static int method2590(final int int_0, int int_1) {
        int_1 = ((int_0 & 0x7F) * int_1) >> 7;
        if (int_1 < 2) {
            int_1 = 2;
        } else if (int_1 > 126) {
            int_1 = 126;
        }

        return (int_0 & 0xFF80) + int_1;
    }

    static int method2591(int int_0) {
        if (int_0 < 2) {
            int_0 = 2;
        } else if (int_0 > 126) {
            int_0 = 126;
        }

        return int_0;
    }

}
