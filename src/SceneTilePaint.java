import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class SceneTilePaint {

    static int cameraZ;
    int swColor;
    int seColor;
    int neColor;
    int nwColor;
    int texture;
    boolean flatShade;
    int rgb;

    SceneTilePaint(final int int_0, final int int_1, final int int_2, final int int_3, final int int_4, final int int_5,
                   final boolean bool_0) {
        flatShade = true;
        swColor = int_0;
        seColor = int_1;
        neColor = int_2;
        nwColor = int_3;
        texture = int_4;
        rgb = int_5;
        flatShade = bool_0;
    }

    public static void encodeClassVerifier(final PacketBuffer packetbuffer_0) {
        final ClassInfo classinfo_0 = (ClassInfo) class313.classInfos.last();
        if (classinfo_0 != null) {
            final int int_0 = packetbuffer_0.offset;
            packetbuffer_0.putInt(classinfo_0.field3758);

            for (int int_1 = 0; int_1 < classinfo_0.count; int_1++) {
                if (classinfo_0.errorIdentifiers[int_1] != 0) {
                    packetbuffer_0.putByte(classinfo_0.errorIdentifiers[int_1]);
                } else {
                    try {
                        final int int_2 = classinfo_0.type[int_1];
                        Field field_0;
                        int int_3;
                        if (int_2 == 0) {
                            field_0 = classinfo_0.fields[int_1];
                            int_3 = field_0.getInt(null);
                            packetbuffer_0.putByte(0);
                            packetbuffer_0.putInt(int_3);
                        } else if (int_2 == 1) {
                            field_0 = classinfo_0.fields[int_1];
                            field_0.setInt(null, classinfo_0.field3753[int_1]);
                            packetbuffer_0.putByte(0);
                        } else if (int_2 == 2) {
                            field_0 = classinfo_0.fields[int_1];
                            int_3 = field_0.getModifiers();
                            packetbuffer_0.putByte(0);
                            packetbuffer_0.putInt(int_3);
                        }

                        Method method_0;
                        if (int_2 != 3) {
                            if (int_2 == 4) {
                                method_0 = classinfo_0.methods[int_1];
                                int_3 = method_0.getModifiers();
                                packetbuffer_0.putByte(0);
                                packetbuffer_0.putInt(int_3);
                            }
                        } else {
                            method_0 = classinfo_0.methods[int_1];
                            final byte[][] bytes_0 = classinfo_0.args[int_1];
                            final Object[] objects_0 = new Object[bytes_0.length];

                            for (int int_4 = 0; int_4 < bytes_0.length; int_4++) {
                                final ObjectInputStream objectinputstream_0 = new ObjectInputStream(
                                        new ByteArrayInputStream(bytes_0[int_4]));
                                objects_0[int_4] = objectinputstream_0.readObject();
                            }

                            final Object object_0 = method_0.invoke(null, objects_0);
                            if (object_0 == null) {
                                packetbuffer_0.putByte(0);
                            } else if (object_0 instanceof Number) {
                                packetbuffer_0.putByte(1);
                                packetbuffer_0.putLong(((Number) object_0).longValue());
                            } else if (object_0 instanceof String) {
                                packetbuffer_0.putByte(2);
                                packetbuffer_0.putString((String) object_0);
                            } else {
                                packetbuffer_0.putByte(4);
                            }
                        }
                    } catch (final ClassNotFoundException classnotfoundexception_0) {
                        packetbuffer_0.putByte(-10);
                    } catch (final InvalidClassException invalidclassexception_0) {
                        packetbuffer_0.putByte(-11);
                    } catch (final StreamCorruptedException streamcorruptedexception_0) {
                        packetbuffer_0.putByte(-12);
                    } catch (final OptionalDataException optionaldataexception_0) {
                        packetbuffer_0.putByte(-13);
                    } catch (final IllegalAccessException illegalaccessexception_0) {
                        packetbuffer_0.putByte(-14);
                    } catch (final IllegalArgumentException illegalargumentexception_0) {
                        packetbuffer_0.putByte(-15);
                    } catch (final InvocationTargetException invocationtargetexception_0) {
                        packetbuffer_0.putByte(-16);
                    } catch (final SecurityException securityexception_0) {
                        packetbuffer_0.putByte(-17);
                    } catch (final IOException ioexception_0) {
                        packetbuffer_0.putByte(-18);
                    } catch (final NullPointerException nullpointerexception_0) {
                        packetbuffer_0.putByte(-19);
                    } catch (final Exception exception_0) {
                        packetbuffer_0.putByte(-20);
                    } catch (final Throwable throwable_0) {
                        packetbuffer_0.putByte(-21);
                    }
                }
            }

            packetbuffer_0.putCrc(int_0);
            classinfo_0.unlink();
        }
    }

    static int method2870(final int int_0, final int int_1, final int int_2, final int int_3) {
        final int int_4 = (65536 - Graphics3D.COSINE[(int_2 * 1024) / int_3]) >> 1;
        return (((65536 - int_4) * int_0) >> 16) + ((int_4 * int_1) >> 16);
    }

}
