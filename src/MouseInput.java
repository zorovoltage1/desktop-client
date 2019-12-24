import java.awt.event.*;

public class MouseInput implements MouseListener, MouseMotionListener, FocusListener {

    public static MouseInput mouse;
    static int mouseIdleTicks;
    public static int MouseHandler_currentButton;
    public static int mouseLastX;
    public static int mouseX;
    public static int mouseLastY;
    public static int mouseY;
    public static int mouseCurrentButton;
    public static int MouseHandler_lastButton;
    public static int MouseHandler_lastPressedX;
    public static int MouseHandler_lastPressedY;
    public static long MouseHandler_lastPressedTimeMillis;
    public static int mouseLastButton;
    public static int mouseLastPressedX;
    public static int mouseLastPressedY;
    public static long mouseLastPressedTimeMillis;
    static int menuX;

    static {
        mouse = new MouseInput();
        mouseIdleTicks = 0;
        MouseHandler_currentButton = 0;
        mouseX = -1;
        mouseY = -1;
        mouseCurrentButton = 0;
        mouseLastX = 0;
        mouseLastY = 0;
        MouseHandler_lastButton = 0;
        MouseHandler_lastPressedX = 0;
        MouseHandler_lastPressedY = 0;
        MouseHandler_lastPressedTimeMillis = 0L;
        mouseLastButton = 0;
        mouseLastPressedX = 0;
        mouseLastPressedY = 0;
        mouseLastPressedTimeMillis = 0L;
    }

    int method916(final MouseEvent mouseevent_0) {
        final int int_0 = mouseevent_0.getButton();
        return !mouseevent_0.isAltDown() && (int_0 != 2) ? (!mouseevent_0.isMetaDown() && (int_0 != 3) ? 1 : 2) : 4;
    }

    @Override
    public synchronized void mousePressed(final MouseEvent mouseevent_0) {
        if (mouse != null) {
            mouseIdleTicks = 0;
            MouseHandler_lastPressedX = mouseevent_0.getX();
            MouseHandler_lastPressedY = mouseevent_0.getY();
            MouseHandler_lastPressedTimeMillis = Buffer.safeCurrentTimeMillis();
            MouseHandler_lastButton = method916(mouseevent_0);
            if (MouseHandler_lastButton != 0) {
                MouseHandler_currentButton = MouseHandler_lastButton;
            }
        }

        if (mouseevent_0.isPopupTrigger()) {
            mouseevent_0.consume();
        }

    }

    @Override
    public synchronized void mouseReleased(final MouseEvent mouseevent_0) {
        if (mouse != null) {
            mouseIdleTicks = 0;
            MouseHandler_currentButton = 0;
        }

        if (mouseevent_0.isPopupTrigger()) {
            mouseevent_0.consume();
        }

    }

    @Override
    public synchronized void mouseEntered(final MouseEvent mouseevent_0) {
        if (mouse != null) {
            mouseIdleTicks = 0;
            mouseX = mouseevent_0.getX();
            mouseY = mouseevent_0.getY();
        }

    }

    @Override
    public synchronized void mouseDragged(final MouseEvent mouseevent_0) {
        if (mouse != null) {
            mouseIdleTicks = 0;
            mouseX = mouseevent_0.getX();
            mouseY = mouseevent_0.getY();
        }

    }

    @Override
    public synchronized void mouseMoved(final MouseEvent mouseevent_0) {
        if (mouse != null) {
            mouseIdleTicks = 0;
            mouseX = mouseevent_0.getX();
            mouseY = mouseevent_0.getY();
        }

    }

    @Override
    public synchronized void focusLost(final FocusEvent focusevent_0) {
        if (mouse != null) {
            MouseHandler_currentButton = 0;
        }

    }

    @Override
    public synchronized void mouseExited(final MouseEvent mouseevent_0) {
        if (mouse != null) {
            mouseIdleTicks = 0;
            mouseX = -1;
            mouseY = -1;
        }

    }

    @Override
    public void mouseClicked(final MouseEvent mouseevent_0) {
        if (mouseevent_0.isPopupTrigger()) {
            mouseevent_0.consume();
        }

    }

    @Override
    public void focusGained(final FocusEvent focusevent_0) {
    }

    static void setGameState(final int int_0) {
        if (int_0 != Game.gameState) {
            if (Game.gameState == 0) {
                Buffer.clientInstance.method842();
            }

            if ((int_0 == 20) || (int_0 == 40) || (int_0 == 45)) {
                Game.loginState = 0;
                Game.field616 = 0;
                Game.field617 = 0;
                Game.field804.method5246(int_0);
                if (int_0 != 20) {
                    NetWriter.method2005(false);
                }
            }

            if ((int_0 != 20) && (int_0 != 40) && (PendingSpawn.field869 != null)) {
                PendingSpawn.field869.vmethod3346();
                PendingSpawn.field869 = null;
            }

            if (Game.gameState == 25) {
                Game.field751 = 0;
                Game.field633 = 0;
                Game.field634 = 1;
                Game.field635 = 0;
                Game.field636 = 1;
            }

            if ((int_0 != 5) && (int_0 != 10)) {
                if (int_0 == 20) {
                    NetWriter.method1994(GameEngine.canvas, MapLabel.indexCache10, GZipDecompressor.indexSprites, true,
                            Game.gameState == 11 ? 4 : 0);
                } else if (int_0 == 11) {
                    NetWriter.method1994(GameEngine.canvas, MapLabel.indexCache10, GZipDecompressor.indexSprites, false, 4);
                } else {
                    class59.method1079();
                }
            } else {
                NetWriter.method1994(GameEngine.canvas, MapLabel.indexCache10, GZipDecompressor.indexSprites, true, 0);
            }

            Game.gameState = int_0;
        }
    }

    static boolean method943() {
        return (Game.playerNameMask & 0x2) != 0;
    }

    static void method948(final int int_0, final int int_1, final int int_2, final int int_3) {
        for (int int_4 = 0; int_4 < Game.widgetCount; int_4++) {
            if (((Game.widgetPositionX[int_4] + Game.widgetBoundsWidth[int_4]) > int_0)
                    && (Game.widgetPositionX[int_4] < (int_0 + int_2))
                    && ((Game.widgetPositionY[int_4] + Game.widgetBoundsHeight[int_4]) > int_1)
                    && (Game.widgetPositionY[int_4] < (int_3 + int_1))) {
                Game.field697[int_4] = true;
            }
        }

    }

}
