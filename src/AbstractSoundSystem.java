import javax.sound.sampled.LineUnavailableException;

public class AbstractSoundSystem {

    public static int sampleRate;
    protected static boolean audioHighMemory;
    public static class89 soundTaskDataProvider;
    protected int[] samples;
    TaskDataNode field1311;
    int field1298;
    long field1305;
    int offset;
    int field1303;
    int field1306;
    long field1294;
    int field1304;
    int field1307;
    int field1308;
    long field1301;
    boolean field1310;
    int field1313;
    TaskDataNode[] field1312;
    TaskDataNode[] field1309;

    protected AbstractSoundSystem() {
        field1298 = 32;
        field1305 = Buffer.safeCurrentTimeMillis();
        field1294 = 0L;
        field1304 = 0;
        field1307 = 0;
        field1308 = 0;
        field1301 = 0L;
        field1310 = true;
        field1313 = 0;
        field1312 = new TaskDataNode[8];
        field1309 = new TaskDataNode[8];
    }

    protected void vmethod2176() {
    }

    protected void create(final int int_0) throws LineUnavailableException {
    }

    protected int size() {
        return offset;
    }

    protected void write() {
    }

    protected void close() {
    }

    protected void flush() {
    }

    public synchronized void method2143(final TaskDataNode taskdatanode_0) {
        field1311 = taskdatanode_0;
    }

    public synchronized void method2144() {
        if (samples != null) {
            long long_0 = Buffer.safeCurrentTimeMillis();

            try {
                if (field1294 != 0L) {
                    if (long_0 < field1294) {
                        return;
                    }

                    create(offset);
                    field1294 = 0L;
                    field1310 = true;
                }

                int int_0 = size();
                if ((field1308 - int_0) > field1304) {
                    field1304 = field1308 - int_0;
                }

                int int_1 = field1303 + field1306;
                if ((int_1 + 256) > 16384) {
                    int_1 = 16128;
                }

                if ((int_1 + 256) > offset) {
                    offset += 1024;
                    if (offset > 16384) {
                        offset = 16384;
                    }

                    close();
                    create(offset);
                    int_0 = 0;
                    field1310 = true;
                    if ((int_1 + 256) > offset) {
                        int_1 = offset - 256;
                        field1306 = int_1 - field1303;
                    }
                }

                while (int_0 < int_1) {
                    method2149(samples, 256);
                    write();
                    int_0 += 256;
                }

                if (long_0 > field1301) {
                    if (!field1310) {
                        if ((field1304 == 0) && (field1307 == 0)) {
                            close();
                            field1294 = long_0 + 2000L;
                            return;
                        }

                        field1306 = Math.min(field1307, field1304);
                        field1307 = field1304;
                    } else {
                        field1310 = false;
                    }

                    field1304 = 0;
                    field1301 = long_0 + 2000L;
                }

                field1308 = int_0;
            } catch (final Exception exception_0) {
                close();
                field1294 = 2000L + long_0;
            }

            try {
                if (long_0 > (500000L + field1305)) {
                    long_0 = field1305;
                }

                while (long_0 > (5000L + field1305)) {
                    method2188(256);
                    field1305 += 256000 / sampleRate;
                }
            } catch (final Exception exception_1) {
                field1305 = long_0;
            }

        }
    }

    public void method2145() {
        field1310 = true;
    }

    public synchronized void tryFlush() {
        field1310 = true;

        try {
            flush();
        } catch (final Exception exception_0) {
            close();
            field1294 = Buffer.safeCurrentTimeMillis() + 2000L;
        }

    }

    public synchronized void shutdown() {
        if (class69.task != null) {
            boolean bool_0 = true;

            for (int int_0 = 0; int_0 < 2; int_0++) {
                if (this == class69.task.systems[int_0]) {
                    class69.task.systems[int_0] = null;
                }

                if (class69.task.systems[int_0] != null) {
                    bool_0 = false;
                }
            }

            if (bool_0) {
                UrlRequester.field1855.shutdownNow();
                UrlRequester.field1855 = null;
                class69.task = null;
            }
        }

        close();
        samples = null;
    }

    void method2188(final int int_0) {
        field1313 -= int_0;
        if (field1313 < 0) {
            field1313 = 0;
        }

        if (field1311 != null) {
            field1311.vmethod4386(int_0);
        }

    }

    void method2149(final int[] ints_0, final int int_0) {
        int int_1 = int_0;
        if (audioHighMemory) {
            int_1 = int_0 << 1;
        }

        class193.method3895(ints_0, 0, int_1);
        field1313 -= int_0;
        if ((field1311 != null) && (field1313 <= 0)) {
            field1313 += sampleRate >> 4;
            Script.method1956(field1311);
            method2184(field1311, field1311.vmethod2435());
            int int_2 = 0;
            int int_3 = 255;

            int int_4;
            TaskDataNode taskdatanode_1;
            label104:
            for (int_4 = 7; int_3 != 0; --int_4) {
                int int_5;
                int int_6;
                if (int_4 < 0) {
                    int_5 = int_4 & 0x3;
                    int_6 = -(int_4 >> 2);
                } else {
                    int_5 = int_4;
                    int_6 = 0;
                }

                for (int int_7 = (int_3 >>> int_5) & 0x11111111; int_7 != 0; int_7 >>>= 4) {
                    if ((int_7 & 0x1) != 0) {
                        int_3 &= ~(1 << int_5);
                        taskdatanode_1 = null;
                        TaskDataNode taskdatanode_2 = field1312[int_5];

                        label98:
                        while (true) {
                            while (true) {
                                if (taskdatanode_2 == null) {
                                    break label98;
                                }

                                final AbstractIntegerNode0 abstractintegernode0_0 = taskdatanode_2.data;
                                if ((abstractintegernode0_0 != null) && (abstractintegernode0_0.int1 > int_6)) {
                                    int_3 |= 1 << int_5;
                                    taskdatanode_1 = taskdatanode_2;
                                    taskdatanode_2 = taskdatanode_2.field1382;
                                } else {
                                    taskdatanode_2.field1385 = true;
                                    final int int_8 = taskdatanode_2.vmethod4395();
                                    int_2 += int_8;
                                    if (abstractintegernode0_0 != null) {
                                        abstractintegernode0_0.int1 += int_8;
                                    }

                                    if (int_2 >= field1298) {
                                        break label104;
                                    }

                                    TaskDataNode taskdatanode_3 = taskdatanode_2.vmethod4382();
                                    if (taskdatanode_3 != null) {
                                        for (final int int_9 = taskdatanode_2.field1384; taskdatanode_3 != null; taskdatanode_3 = taskdatanode_2
                                                .vmethod4389()) {
                                            method2184(taskdatanode_3, (int_9 * taskdatanode_3.vmethod2435()) >> 8);
                                        }
                                    }

                                    final TaskDataNode taskdatanode_4 = taskdatanode_2.field1382;
                                    taskdatanode_2.field1382 = null;
                                    if (taskdatanode_1 == null) {
                                        field1312[int_5] = taskdatanode_4;
                                    } else {
                                        taskdatanode_1.field1382 = taskdatanode_4;
                                    }

                                    if (taskdatanode_4 == null) {
                                        field1309[int_5] = taskdatanode_1;
                                    }

                                    taskdatanode_2 = taskdatanode_4;
                                }
                            }
                        }
                    }

                    int_5 += 4;
                    ++int_6;
                }
            }

            for (int_4 = 0; int_4 < 8; int_4++) {
                TaskDataNode taskdatanode_0 = field1312[int_4];
                final TaskDataNode[] taskdatanodes_0 = field1312;
                field1309[int_4] = null;

                for (taskdatanodes_0[int_4] = null; taskdatanode_0 != null; taskdatanode_0 = taskdatanode_1) {
                    taskdatanode_1 = taskdatanode_0.field1382;
                    taskdatanode_0.field1382 = null;
                }
            }
        }

        if (field1313 < 0) {
            field1313 = 0;
        }

        if (field1311 != null) {
            field1311.vmethod4385(ints_0, 0, int_0);
        }

        field1305 = Buffer.safeCurrentTimeMillis();
    }

    void method2184(final TaskDataNode taskdatanode_0, final int int_0) {
        final int int_1 = int_0 >> 5;
        final TaskDataNode taskdatanode_1 = field1309[int_1];
        if (taskdatanode_1 == null) {
            field1312[int_1] = taskdatanode_0;
        } else {
            taskdatanode_1.field1382 = taskdatanode_0;
        }

        field1309[int_1] = taskdatanode_0;
        taskdatanode_0.field1384 = int_0;
    }

    public static RunException method2195(final Throwable throwable_0, final String string_0) {
        RunException exception;
        if (throwable_0 instanceof RunException) {
            exception = (RunException) throwable_0;
            exception.field1941 = exception.field1941 + ' ' + string_0;
        } else {
            exception = new RunException(throwable_0, string_0);
        }

        return exception;
    }

}
