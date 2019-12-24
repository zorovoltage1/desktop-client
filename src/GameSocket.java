import java.io.IOException;
import java.io.OutputStream;

public class GameSocket implements Runnable {

    public static BufferProvider rasterProvider;
    static String sessionToken;
    public static int currentPressedKey;
    Thread field2008;
    OutputStream field2006;
    int field2015;
    byte[] field2012;
    int field2010;
    int field2005;
    IOException field2011;
    boolean field2009;

    GameSocket(final OutputStream outputstream_0, final int int_0) {
        field2010 = 0;
        field2005 = 0;
        field2006 = outputstream_0;
        field2015 = int_0 + 1;
        field2012 = new byte[field2015];
        field2008 = new Thread(this);
        field2008.setDaemon(true);
        field2008.start();
    }

    boolean method3390() {
        if (field2009) {
            try {
                field2006.close();
                if (field2011 == null) {
                    field2011 = new IOException("");
                }
            } catch (final IOException ioexception_0) {
                if (field2011 == null) {
                    field2011 = new IOException(ioexception_0);
                }
            }

            return true;
        } else {
            return false;
        }
    }

    void read(final byte[] bytes_0, final int int_0, final int int_1) throws IOException {
        if ((int_1 >= 0) && (int_0 >= 0) && ((int_1 + int_0) <= bytes_0.length)) {
            synchronized (this) {
                if (field2011 != null) {
                    throw new IOException(field2011.toString());
                } else {
                    int int_2;
                    if (field2010 <= field2005) {
                        int_2 = ((field2015 - field2005) + field2010) - 1;
                    } else {
                        int_2 = field2010 - field2005 - 1;
                    }

                    if (int_2 < int_1) {
                        throw new IOException("");
                    } else {
                        if ((int_1 + field2005) <= field2015) {
                            System.arraycopy(bytes_0, int_0, field2012, field2005, int_1);
                        } else {
                            final int int_3 = field2015 - field2005;
                            System.arraycopy(bytes_0, int_0, field2012, field2005, int_3);
                            System.arraycopy(bytes_0, int_3 + int_0, field2012, 0, int_1 - int_3);
                        }

                        field2005 = (int_1 + field2005) % field2015;
                        notifyAll();
                    }
                }
            }
        } else {
            throw new IOException();
        }
    }

    void method3384() {
        synchronized (this) {
            field2009 = true;
            notifyAll();
        }

        try {
            field2008.join();
        } catch (final InterruptedException interruptedexception_0) {
        }

    }

    @Override
    public void run() {
        do {
            int int_0;
            synchronized (this) {
                while (true) {
                    if (field2011 != null) {
                        return;
                    }

                    if (field2010 <= field2005) {
                        int_0 = field2005 - field2010;
                    } else {
                        int_0 = (field2015 - field2010) + field2005;
                    }

                    if (int_0 > 0) {
                        break;
                    }

                    try {
                        field2006.flush();
                    } catch (final IOException ioexception_1) {
                        field2011 = ioexception_1;
                        return;
                    }

                    if (method3390()) {
                        return;
                    }

                    try {
                        this.wait();
                    } catch (final InterruptedException interruptedexception_0) {
                    }
                }
            }

            try {
                if ((int_0 + field2010) <= field2015) {
                    field2006.write(field2012, field2010, int_0);
                } else {
                    final int int_1 = field2015 - field2010;
                    field2006.write(field2012, field2010, int_1);
                    field2006.write(field2012, 0, int_0 - int_1);
                }
            } catch (final IOException ioexception_0) {
                final IOException ioexception_2 = ioexception_0;
                synchronized (this) {
                    field2011 = ioexception_2;
                    return;
                }
            }

            synchronized (this) {
                field2010 = (int_0 + field2010) % field2015;
            }
        }
        while (!method3390());

    }

    public static int getVarbit(final int int_0) {
        Varbit varbit_0 = (Varbit) Varbit.varbits.get(int_0);
        Varbit varbit_1;
        if (varbit_0 != null) {
            varbit_1 = varbit_0;
        } else {
            final byte[] bytes_0 = Varbit.varbit_ref.getConfigData(14, int_0);
            varbit_0 = new Varbit();
            if (bytes_0 != null) {
                varbit_0.decode(new Buffer(bytes_0));
            }

            Varbit.varbits.put(varbit_0, int_0);
            varbit_1 = varbit_0;
        }

        final int int_1 = varbit_1.configId;
        final int int_2 = varbit_1.leastSignificantBit;
        final int int_3 = varbit_1.mostSignificantBit;
        final int int_4 = class225.varpsMasks[int_3 - int_2];
        return (class225.clientVarps[int_1] >> int_2) & int_4;
    }

    static void method3388(final Widget[] widgets_0, final Widget widget_0, final boolean bool_0) {
        final int int_0 = widget_0.scrollWidth != 0 ? widget_0.scrollWidth : widget_0.width;
        final int int_1 = widget_0.scrollHeight != 0 ? widget_0.scrollHeight : widget_0.height;
        class304.method5635(widgets_0, widget_0.interfaceHash, int_0, int_1, bool_0);
        if (widget_0.children != null) {
            class304.method5635(widget_0.children, widget_0.interfaceHash, int_0, int_1, bool_0);
        }

        final WidgetNode widgetnode_0 = (WidgetNode) Game.componentTable.get(widget_0.interfaceHash);
        if (widgetnode_0 != null) {
            Script.method1946(widgetnode_0.id, int_0, int_1, bool_0);
        }

        if (widget_0.contentType == 1337) {
        }

    }

}
