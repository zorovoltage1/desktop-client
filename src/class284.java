import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class class284 extends NameableContainer {

    final JagexLoginType field3615;

    public class284(final JagexLoginType jagexlogintype_0) {
        super(400);
        field3615 = jagexlogintype_0;
    }

    @Override
    Nameable vmethod5461() {
        return new Ignore();
    }

    @Override
    Nameable[] vmethod5462(final int int_0) {
        return new Ignore[int_0];
    }

    public void method5317(final Buffer buffer_0, final int int_0) {
        while (true) {
            if (buffer_0.offset < int_0) {
                final int int_1 = buffer_0.readUnsignedByte();
                final boolean bool_0 = (int_1 & 0x1) == 1;
                final Name name_0 = new Name(buffer_0.readString(), field3615);
                final Name name_1 = new Name(buffer_0.readString(), field3615);
                buffer_0.readString();
                if ((name_0 != null) && name_0.isCleanNameValid()) {
                    Ignore ignore_0 = (Ignore) method5331(name_0);
                    if (bool_0) {
                        final Ignore ignore_1 = (Ignore) method5331(name_1);
                        if ((ignore_1 != null) && (ignore_1 != ignore_0)) {
                            if (ignore_0 != null) {
                                method5334(ignore_1);
                            } else {
                                ignore_0 = ignore_1;
                            }
                        }
                    }

                    if (ignore_0 != null) {
                        method5338(ignore_0, name_0, name_1);
                        continue;
                    }

                    if (getCount() < 400) {
                        final int int_2 = getCount();
                        ignore_0 = (Ignore) method5335(name_0, name_1);
                        ignore_0.field3624 = int_2;
                    }
                    continue;
                }

                throw new IllegalStateException();
            }

            return;
        }
    }

    public static SpritePixels method5324(final byte[] bytes_0) {
        BufferedImage bufferedimage_0 = null;

        try {
            bufferedimage_0 = ImageIO.read(new ByteArrayInputStream(bytes_0));
            final int int_0 = bufferedimage_0.getWidth();
            final int int_1 = bufferedimage_0.getHeight();
            final int[] ints_0 = new int[int_0 * int_1];
            final PixelGrabber pixelgrabber_0 = new PixelGrabber(bufferedimage_0, 0, 0, int_0, int_1, ints_0, 0, int_0);
            pixelgrabber_0.grabPixels();
            return new SpritePixels(ints_0, int_0, int_1);
        } catch (final IOException ioexception_0) {
        } catch (final InterruptedException interruptedexception_0) {
        }

        return new SpritePixels(0, 0);
    }

}
