public abstract class IndexDataBase {

    static GZipDecompressor gzip;
    static int field3176;
    int validArchivesCount;
    int[] archiveIds;
    int[] archiveNames;
    Identifiers identifiers;
    int[] archiveCrcs;
    int[] archiveRevisions;
    int[] archiveNumberOfFiles;
    int[][] archiveFileIds;
    int[][] archiveFileNames;
    Identifiers[] childIdentifiers;
    Object[] archives;
    Object[][] childs;
    public int crc;
    boolean releaseArchives;
    boolean shallowRecords;

    static {
        gzip = new GZipDecompressor();
        field3176 = 0;
    }

    IndexDataBase(final boolean bool_0, final boolean bool_1) {
        releaseArchives = bool_0;
        shallowRecords = bool_1;
    }

    void setIndexReference(final byte[] bytes_0) {
        final int int_0 = bytes_0.length;
        final int int_1 = class187.method3812(bytes_0, 0, int_0);
        crc = int_1;
        final Buffer buffer_0 = new Buffer(GameEngine.decodeContainer(bytes_0));
        final int int_2 = buffer_0.readUnsignedByte();
        if ((int_2 >= 5) && (int_2 <= 7)) {
            if (int_2 >= 6) {
                buffer_0.readInt();
            }

            final int int_3 = buffer_0.readUnsignedByte();
            if (int_2 >= 7) {
                validArchivesCount = buffer_0.getLargeSmart();
            } else {
                validArchivesCount = buffer_0.readUnsignedShort();
            }

            int int_4 = 0;
            int int_5 = -1;
            archiveIds = new int[validArchivesCount];
            int int_6;
            if (int_2 >= 7) {
                for (int_6 = 0; int_6 < validArchivesCount; int_6++) {
                    archiveIds[int_6] = int_4 += buffer_0.getLargeSmart();
                    if (archiveIds[int_6] > int_5) {
                        int_5 = archiveIds[int_6];
                    }
                }
            } else {
                for (int_6 = 0; int_6 < validArchivesCount; int_6++) {
                    archiveIds[int_6] = int_4 += buffer_0.readUnsignedShort();
                    if (archiveIds[int_6] > int_5) {
                        int_5 = archiveIds[int_6];
                    }
                }
            }

            archiveCrcs = new int[int_5 + 1];
            archiveRevisions = new int[int_5 + 1];
            archiveNumberOfFiles = new int[int_5 + 1];
            archiveFileIds = new int[int_5 + 1][];
            archives = new Object[int_5 + 1];
            childs = new Object[int_5 + 1][];
            if (int_3 != 0) {
                archiveNames = new int[int_5 + 1];

                for (int_6 = 0; int_6 < validArchivesCount; int_6++) {
                    archiveNames[archiveIds[int_6]] = buffer_0.readInt();
                }

                identifiers = new Identifiers(archiveNames);
            }

            for (int_6 = 0; int_6 < validArchivesCount; int_6++) {
                archiveCrcs[archiveIds[int_6]] = buffer_0.readInt();
            }

            for (int_6 = 0; int_6 < validArchivesCount; int_6++) {
                archiveRevisions[archiveIds[int_6]] = buffer_0.readInt();
            }

            for (int_6 = 0; int_6 < validArchivesCount; int_6++) {
                archiveNumberOfFiles[archiveIds[int_6]] = buffer_0.readUnsignedShort();
            }

            int int_7;
            int int_8;
            int int_9;
            int int_10;
            int int_11;
            if (int_2 >= 7) {
                for (int_6 = 0; int_6 < validArchivesCount; int_6++) {
                    int_7 = archiveIds[int_6];
                    int_8 = archiveNumberOfFiles[int_7];
                    int_4 = 0;
                    int_9 = -1;
                    archiveFileIds[int_7] = new int[int_8];

                    for (int_10 = 0; int_10 < int_8; int_10++) {
                        int_11 = archiveFileIds[int_7][int_10] = int_4 += buffer_0.getLargeSmart();
                        if (int_11 > int_9) {
                            int_9 = int_11;
                        }
                    }

                    childs[int_7] = new Object[int_9 + 1];
                }
            } else {
                for (int_6 = 0; int_6 < validArchivesCount; int_6++) {
                    int_7 = archiveIds[int_6];
                    int_8 = archiveNumberOfFiles[int_7];
                    int_4 = 0;
                    int_9 = -1;
                    archiveFileIds[int_7] = new int[int_8];

                    for (int_10 = 0; int_10 < int_8; int_10++) {
                        int_11 = archiveFileIds[int_7][int_10] = int_4 += buffer_0.readUnsignedShort();
                        if (int_11 > int_9) {
                            int_9 = int_11;
                        }
                    }

                    childs[int_7] = new Object[int_9 + 1];
                }
            }

            if (int_3 != 0) {
                archiveFileNames = new int[int_5 + 1][];
                childIdentifiers = new Identifiers[int_5 + 1];

                for (int_6 = 0; int_6 < validArchivesCount; int_6++) {
                    int_7 = archiveIds[int_6];
                    int_8 = archiveNumberOfFiles[int_7];
                    archiveFileNames[int_7] = new int[childs[int_7].length];

                    for (int_9 = 0; int_9 < int_8; int_9++) {
                        archiveFileNames[int_7][archiveFileIds[int_7][int_9]] = buffer_0.readInt();
                    }

                    childIdentifiers[int_7] = new Identifiers(archiveFileNames[int_7]);
                }
            }

        } else {
            throw new RuntimeException("");
        }
    }

    void vmethod4721(final int int_0) {
    }

    public byte[] getConfigData(final int int_0, final int int_1) {
        return getConfigDataKeys(int_0, int_1, null);
    }

    public byte[] getConfigDataKeys(final int int_0, final int int_1, final int[] ints_0) {
        if ((int_0 >= 0) && (int_0 < childs.length) && (childs[int_0] != null) && (int_1 >= 0)
                && (int_1 < childs[int_0].length)) {
            if (childs[int_0][int_1] == null) {
                boolean bool_0 = buildRecords(int_0, ints_0);
                if (!bool_0) {
                    loadArchive(int_0);
                    bool_0 = buildRecords(int_0, ints_0);
                    if (!bool_0) {
                        return null;
                    }
                }
            }

            final byte[] bytes_0 = SoundTask.toByteArray(childs[int_0][int_1], false);
            if (shallowRecords) {
                childs[int_0][int_1] = null;
            }

            return bytes_0;
        } else {
            return null;
        }
    }

    public boolean tryLoadRecord(final int int_0, final int int_1) {
        if ((int_0 >= 0) && (int_0 < childs.length) && (childs[int_0] != null) && (int_1 >= 0)
                && (int_1 < childs[int_0].length)) {
            if (childs[int_0][int_1] != null) {
                return true;
            } else if (archives[int_0] != null) {
                return true;
            } else {
                loadArchive(int_0);
                return archives[int_0] != null;
            }
        } else {
            return false;
        }
    }

    public boolean method4627(final int int_0) {
        if (childs.length == 1) {
            return tryLoadRecord(0, int_0);
        } else if (childs[int_0].length == 1) {
            return tryLoadRecord(int_0, 0);
        } else {
            throw new RuntimeException();
        }
    }

    public boolean containsFile(final int int_0) {
        if (archives[int_0] != null) {
            return true;
        } else {
            loadArchive(int_0);
            return archives[int_0] != null;
        }
    }

    public boolean method4629() {
        boolean bool_0 = true;

        for (int int_0 = 0; int_0 < archiveIds.length; int_0++) {
            final int int_1 = archiveIds[int_0];
            if (archives[int_1] == null) {
                loadArchive(int_1);
                if (archives[int_1] == null) {
                    bool_0 = false;
                }
            }
        }

        return bool_0;
    }

    int archiveLoadPercent(final int int_0) {
        return archives[int_0] != null ? 100 : 0;
    }

    public byte[] takeRecordFlat(final int int_0) {
        if (childs.length == 1) {
            return getConfigData(0, int_0);
        } else if (childs[int_0].length == 1) {
            return getConfigData(int_0, 0);
        } else {
            throw new RuntimeException();
        }
    }

    public byte[] getChild(final int int_0, final int int_1) {
        if ((int_0 >= 0) && (int_0 < childs.length) && (childs[int_0] != null) && (int_1 >= 0)
                && (int_1 < childs[int_0].length)) {
            if (childs[int_0][int_1] == null) {
                boolean bool_0 = buildRecords(int_0, null);
                if (!bool_0) {
                    loadArchive(int_0);
                    bool_0 = buildRecords(int_0, null);
                    if (!bool_0) {
                        return null;
                    }
                }
            }

            final byte[] bytes_0 = SoundTask.toByteArray(childs[int_0][int_1], false);
            return bytes_0;
        } else {
            return null;
        }
    }

    public byte[] getRecordFlat(final int int_0) {
        if (childs.length == 1) {
            return this.getChild(0, int_0);
        } else if (childs[int_0].length == 1) {
            return this.getChild(int_0, 0);
        } else {
            throw new RuntimeException();
        }
    }

    void loadArchive(final int int_0) {
    }

    public int[] getChilds(final int int_0) {
        return archiveFileIds[int_0];
    }

    public int fileCount(final int int_0) {
        return childs[int_0].length;
    }

    public int size() {
        return childs.length;
    }

    public void method4702() {
        for (int int_0 = 0; int_0 < archives.length; int_0++) {
            archives[int_0] = null;
        }

    }

    public void method4639(final int int_0) {
        for (int int_1 = 0; int_1 < childs[int_0].length; int_1++) {
            childs[int_0][int_1] = null;
        }

    }

    public void reset() {
        for (int int_0 = 0; int_0 < childs.length; int_0++) {
            if (childs[int_0] != null) {
                for (int int_1 = 0; int_1 < childs[int_0].length; int_1++) {
                    childs[int_0][int_1] = null;
                }
            }
        }

    }

    boolean buildRecords(final int int_0, final int[] ints_0) {
        if (archives[int_0] == null) {
            return false;
        } else {
            final int int_1 = archiveNumberOfFiles[int_0];
            final int[] ints_1 = archiveFileIds[int_0];
            final Object[] objects_0 = childs[int_0];
            boolean bool_0 = true;

            for (int int_2 = 0; int_2 < int_1; int_2++) {
                if (objects_0[ints_1[int_2]] == null) {
                    bool_0 = false;
                    break;
                }
            }

            if (bool_0) {
                return true;
            } else {
                byte[] bytes_0;
                if ((ints_0 != null) && ((ints_0[0] != 0) || (ints_0[1] != 0) || (ints_0[2] != 0) || (ints_0[3] != 0))) {
                    bytes_0 = SoundTask.toByteArray(archives[int_0], true);
                    final Buffer buffer_0 = new Buffer(bytes_0);
                    buffer_0.decryptXtea(ints_0, 5, buffer_0.payload.length);
                } else {
                    bytes_0 = SoundTask.toByteArray(archives[int_0], false);
                }

                final byte[] bytes_2 = GameEngine.decodeContainer(bytes_0);
                if (releaseArchives) {
                    archives[int_0] = null;
                }

                if (int_1 > 1) {
                    int int_3 = bytes_2.length;
                    --int_3;
                    final int int_4 = bytes_2[int_3] & 0xFF;
                    int_3 -= int_1 * int_4 * 4;
                    final Buffer buffer_1 = new Buffer(bytes_2);
                    final int[] ints_2 = new int[int_1];
                    buffer_1.offset = int_3;

                    int int_6;
                    int int_7;
                    for (int int_5 = 0; int_5 < int_4; int_5++) {
                        int_6 = 0;

                        for (int_7 = 0; int_7 < int_1; int_7++) {
                            int_6 += buffer_1.readInt();
                            ints_2[int_7] += int_6;
                        }
                    }

                    final byte[][] bytes_1 = new byte[int_1][];

                    for (int_6 = 0; int_6 < int_1; int_6++) {
                        bytes_1[int_6] = new byte[ints_2[int_6]];
                        ints_2[int_6] = 0;
                    }

                    buffer_1.offset = int_3;
                    int_6 = 0;

                    for (int_7 = 0; int_7 < int_4; int_7++) {
                        int int_8 = 0;

                        for (int int_9 = 0; int_9 < int_1; int_9++) {
                            int_8 += buffer_1.readInt();
                            System.arraycopy(bytes_2, int_6, bytes_1[int_9], ints_2[int_9], int_8);
                            ints_2[int_9] += int_8;
                            int_6 += int_8;
                        }
                    }

                    for (int_7 = 0; int_7 < int_1; int_7++) {
                        if (!shallowRecords) {
                            objects_0[ints_1[int_7]] = class159.byteArrayToObject(bytes_1[int_7], false);
                        } else {
                            objects_0[ints_1[int_7]] = bytes_1[int_7];
                        }
                    }
                } else if (!shallowRecords) {
                    objects_0[ints_1[0]] = class159.byteArrayToObject(bytes_2, false);
                } else {
                    objects_0[ints_1[0]] = bytes_2;
                }

                return true;
            }
        }
    }

    public int getFile(String string_0) {
        string_0 = string_0.toLowerCase();
        return identifiers.getFile(class277.djb2Hash(string_0));
    }

    public int getChild(final int int_0, String string_0) {
        string_0 = string_0.toLowerCase();
        return childIdentifiers[int_0].getFile(class277.djb2Hash(string_0));
    }

    public boolean method4644(String string_0, String string_1) {
        string_0 = string_0.toLowerCase();
        string_1 = string_1.toLowerCase();
        final int int_0 = identifiers.getFile(class277.djb2Hash(string_0));
        if (int_0 < 0) {
            return false;
        } else {
            final int int_1 = childIdentifiers[int_0].getFile(class277.djb2Hash(string_1));
            return int_1 >= 0;
        }
    }

    public byte[] takeRecordByNames(String string_0, String string_1) {
        string_0 = string_0.toLowerCase();
        string_1 = string_1.toLowerCase();
        final int int_0 = identifiers.getFile(class277.djb2Hash(string_0));
        final int int_1 = childIdentifiers[int_0].getFile(class277.djb2Hash(string_1));
        return getConfigData(int_0, int_1);
    }

    public boolean tryLoadRecordByNames(String string_0, String string_1) {
        string_0 = string_0.toLowerCase();
        string_1 = string_1.toLowerCase();
        final int int_0 = identifiers.getFile(class277.djb2Hash(string_0));
        final int int_1 = childIdentifiers[int_0].getFile(class277.djb2Hash(string_1));
        return tryLoadRecord(int_0, int_1);
    }

    public boolean tryLoadArchiveByName(String string_0) {
        string_0 = string_0.toLowerCase();
        final int int_0 = identifiers.getFile(class277.djb2Hash(string_0));
        return containsFile(int_0);
    }

    public void method4648(String string_0) {
        string_0 = string_0.toLowerCase();
        final int int_0 = identifiers.getFile(class277.djb2Hash(string_0));
        if (int_0 >= 0) {
            vmethod4721(int_0);
        }
    }

    public int archiveLoadPercentByName(String string_0) {
        string_0 = string_0.toLowerCase();
        final int int_0 = identifiers.getFile(class277.djb2Hash(string_0));
        return archiveLoadPercent(int_0);
    }

}
