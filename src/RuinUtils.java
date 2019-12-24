import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class RuinUtils {

    /**
     * Icons
     */

    public static void loadIcons(boolean display) {
        ArrayList<byte[]> iconData = new ArrayList<byte[]>();
        for(int i = 0; i < 1000; i++) {
            byte[] data = resourceToBytes("img/icons/" + i + ".png");
            if(data != null)
                iconData.add(data);
        }
        try {
            ArrayList<IndexedSprite> icons = new ArrayList<IndexedSprite>();
            for(IndexedSprite icon : JagexLoginType.modIconSprites) {
                if(icon != null)
                    icons.add(icon);
            }
            for(byte[] data : iconData)
                icons.add(IndexedSprite.fromBytes(data));
            FontTypeFace.modIcons = icons.toArray(new IndexedSprite[icons.size()]);
        } catch(Exception e) {
            /* ignored */
        }
        if(display) {
            for(int i = 0; i < FontTypeFace.modIcons.length; i++) {
                IndexedSprite icon = FontTypeFace.modIcons[i];
                if(icon != null)
                    class143.sendGameMessage(99, "", "<img=" + i + ">    #" + i);
            }
        }
    }

    /**
     * Pk Icons
     */

    public static void loadPkIcons() {
        ArrayList<byte[]> iconData = new ArrayList<byte[]>();
        for(int i = 0; i < 1000; i++) {
            byte[] data = resourceToBytes("img/icons/pk/" + i + ".png");
            if(data != null)
                iconData.add(data);
        }
        try {
            ArrayList<SpritePixels> icons = new ArrayList<SpritePixels>();
            for(SpritePixels icon : MilliTimer.headIconsPk) {
                if(icon != null)
                    icons.add(icon);
            }
            for(byte[] data : iconData)
                icons.add(new SpritePixels(data, GameEngine.canvas));
            MilliTimer.headIconsPk = icons.toArray(new SpritePixels[icons.size()]);
        } catch(Exception e) {
            /* ignored */
        }
    }

    /**
     * Prayer Icons
     */

    public static void loadPrayerIcons() {
        ArrayList<byte[]> iconData = new ArrayList<byte[]>();
        for(int i = 0; i < 1000; i++) {
            byte[] data = resourceToBytes("img/icons/prayer/" + i + ".png");
            if(data != null)
                iconData.add(data);
        }
        try {
            ArrayList<SpritePixels> icons = new ArrayList<SpritePixels>();
            for(SpritePixels icon : class43.headIconsPrayer) {
                if(icon != null)
                    icons.add(icon);
            }
            for(byte[] data : iconData)
                icons.add(new SpritePixels(data, GameEngine.canvas));
            class43.headIconsPrayer = icons.toArray(new SpritePixels[icons.size()]);
        } catch(Exception e) {
            /* ignored */
        }
    }

    /**
     * Interface sprites
     */

    private static final int customInterSpriteOffset = 1000000;

    public static SpritePixels[] customInterSprites;

    public static void loadCustomInterfaceSprites() {
        ArrayList<byte[]> spriteData = new ArrayList<byte[]>();
        for(int i = 0; i < 1000; i++) {
            byte[] data = resourceToBytes("img/inter/" + i + ".png");
            if(data != null)
                spriteData.add(data);
        }
        try {
            ArrayList<SpritePixels> icons = new ArrayList<SpritePixels>();
            for(byte[] data : spriteData)
                icons.add(new SpritePixels(data, GameEngine.canvas));
            customInterSprites = icons.toArray(new SpritePixels[icons.size()]);
        } catch(Exception e) {
            /* ignored */
        }
    }

    public static int customInterSpriteId(int id) {
        return customInterSpriteOffset + id;
    }

    public static SpritePixels customInterSprite(int spriteId) {
        return spriteId < customInterSpriteOffset ? null : customInterSprites[spriteId - customInterSpriteOffset];
    }

    /**
     * Custom image stuff
     */

    private static BufferedImage createBufferedImage(int width, int height, int[] pixels) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        bi.setRGB(0, 0, width, height, pixels, 0, width);
        Image img = makeColorTransparent(bi, new Color(0, 0, 0));
        return imageToBufferedImage(img);
    }

    private static BufferedImage imageToBufferedImage(Image image) {
        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = bufferedImage.createGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
        return bufferedImage;
    }

    private static Image makeColorTransparent(BufferedImage im, final Color color) {
        RGBImageFilter filter = new RGBImageFilter() {
            int markerRGB = color.getRGB() | 0xFF000000;

            public final int filterRGB(int x, int y, int rgb) {
                if((rgb | 0xFF000000) == markerRGB) {
                    return 0x00FFFFFF & rgb;
                } else {
                    return rgb;
                }
            }
        };
        ImageProducer ip = new FilteredImageSource(im.getSource(), filter);
        return Toolkit.getDefaultToolkit().createImage(ip);
    }

    public static BufferedImage getItemImage(int id) {
        ItemComposition def = TextureProvider.getItemDefinition(id);
        if(def == null || def.name == null || def.name.equals("null"))
            return null;
        SpritePixels a = class21.createSprite(id, 10000, 1, 3355443, 0, false);
        if(a == null)
            return null;
        return createBufferedImage(a.width, a.height, a.pixels);
    }


    /**
     * Misc
     */

    public static byte[] fileToBytes(File file) {
        byte[] data = new byte[(int) file.length()];
        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
            if(in.read(data) != data.length)
                throw new IOException("Failed to read all bytes!");
        } catch(Exception e) {
            /* ignored */
        } finally {
            if(in != null) {
                try {
                    in.close();
                } catch(IOException e) {
                    /* ignored */
                }
            }
        }
        return data;
    }

    public static byte[] resourceToBytes(String resourcePath) {
        InputStream in = null;
        try {
            in = RuinUtils.class.getResourceAsStream(resourcePath);
            byte[] data = new byte[in.available()];
            if(in.read(data) != data.length)
                throw new IOException("Failed to read all bytes!");
            return data;
        } catch(Exception e) {
            /* ignored */
        } finally {
            if(in != null) {
                try {
                    in.close();
                } catch(IOException e) {
                    /* ignored */
                }
            }
        }
        return null;
    }

    public static String getPath(String... paths) {
        StringBuilder path = new StringBuilder();
        for(String s : paths) {
            if(path.length() > 0)
                path.append(File.separator);
            path.append(s);
        }
        return path.toString();
    }


    static String getFormattedTime(int time) {
        int seconds = time / 50;
        if (seconds < 60)
            return "0:" + (seconds < 10 ? "0" : "") + seconds;
        else {
            int mins = seconds / 60;
            int remainderSecs = seconds - (mins * 60);
            if (mins < 60) {
                return mins + ":" + (remainderSecs < 10 ? "0" : "") + remainderSecs + "";
            } else {
                int hours = mins / 60;
                int remainderMins = mins - (hours * 60);
                return (hours < 10 ? "0" : "") + hours + "h " + (remainderMins < 10 ? "0" : "") + remainderMins + "m " + (remainderSecs < 10 ? "0" : "") + remainderSecs + "s";
            }
        }
    }

}