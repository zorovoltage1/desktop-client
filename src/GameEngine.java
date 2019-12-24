import java.applet.Applet;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.Iterator;

public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	protected static Signlink taskManager;
	static GameEngine shell;
	static int shellCount;
	static long field388;
	static boolean field389;
	static int field391;
	static int field385;
	protected static int FPS;
	protected static long[] field394;
	protected static long[] field404;
	static int field413;
	static boolean focused;
	static long garbageCollectorLastCollectionTime;
	static long garbageCollectorLastCheckTimeMs;
	boolean hasErrored;
	protected int field396;
	protected int field397;
	int field398;
	int field411;
	int field395;
	int field402;
	int field400;
	int field414;
	java.awt.Frame frame;
	static Canvas canvas;
	boolean field406;
	boolean field408;
	boolean field409;
	long field410;
	MouseWheelHandler mouseWheelHandler;
	Clipboard clipboard;
	final EventQueue eventQueue;

	static {
		shell = null;
		shellCount = 0;
		field388 = 0L;
		field389 = false;
		field391 = 20;
		field385 = 1;
		FPS = 0;
		field394 = new long[32];
		field404 = new long[32];
		field413 = 500;
		focused = true;
		garbageCollectorLastCollectionTime = -1L;
		garbageCollectorLastCheckTimeMs = -1L;
	}

	protected GameEngine() {
		hasErrored = false;
		field398 = 0;
		field411 = 0;
		field406 = true;
		field408 = false;
		field409 = false;
		field410 = 0L;
		EventQueue eventqueue_0 = null;

		try {
			eventqueue_0 = Toolkit.getDefaultToolkit().getSystemEventQueue();
		} catch (final Throwable throwable_0) {
		}

		eventQueue = eventqueue_0;
		final SoundTaskDataProvider soundtaskdataprovider_0 = new SoundTaskDataProvider();
		AbstractSoundSystem.soundTaskDataProvider = soundtaskdataprovider_0;
	}

	protected void method906(final int int_0, final int int_1) {
		if ((field400 != int_0) || (int_1 != field414)) {
			method784();
		}

		field400 = int_0;
		field414 = int_1;
	}

	void method768(final Object object_0) {
		if (eventQueue != null) {
			for (int int_0 = 0; (int_0 < 50) && (eventQueue.peekEvent() != null); int_0++) {
				Actor.method1539(1L);
			}

			if (object_0 != null) {
				eventQueue.postEvent(new ActionEvent(object_0, 1001, "dummy"));
			}

		}
	}

	protected MouseWheel mouseWheel() {
		if (mouseWheelHandler == null) {
			mouseWheelHandler = new MouseWheelHandler();
			mouseWheelHandler.addTo(canvas);
		}

		return mouseWheelHandler;
	}

	protected void setUpClipboard() {
		clipboard = getToolkit().getSystemClipboard();
	}

	protected void method771(final String string_0) {
		clipboard.setContents(new StringSelection(string_0), null);
	}

	protected void setUpKeyboard() {
		if (Signlink.javaVendor.toLowerCase().indexOf("microsoft") != -1) {
			KeyFocusListener.KeyHandler_keyCodes[186] = 57;
			KeyFocusListener.KeyHandler_keyCodes[187] = 27;
			KeyFocusListener.KeyHandler_keyCodes[188] = 71;
			KeyFocusListener.KeyHandler_keyCodes[189] = 26;
			KeyFocusListener.KeyHandler_keyCodes[190] = 72;
			KeyFocusListener.KeyHandler_keyCodes[191] = 73;
			KeyFocusListener.KeyHandler_keyCodes[192] = 58;
			KeyFocusListener.KeyHandler_keyCodes[219] = 42;
			KeyFocusListener.KeyHandler_keyCodes[220] = 74;
			KeyFocusListener.KeyHandler_keyCodes[221] = 43;
			KeyFocusListener.KeyHandler_keyCodes[222] = 59;
			KeyFocusListener.KeyHandler_keyCodes[223] = 28;
		} else {
			KeyFocusListener.KeyHandler_keyCodes[44] = 71;
			KeyFocusListener.KeyHandler_keyCodes[45] = 26;
			KeyFocusListener.KeyHandler_keyCodes[46] = 72;
			KeyFocusListener.KeyHandler_keyCodes[47] = 73;
			KeyFocusListener.KeyHandler_keyCodes[59] = 57;
			KeyFocusListener.KeyHandler_keyCodes[61] = 27;
			KeyFocusListener.KeyHandler_keyCodes[91] = 42;
			KeyFocusListener.KeyHandler_keyCodes[92] = 74;
			KeyFocusListener.KeyHandler_keyCodes[93] = 43;
			KeyFocusListener.KeyHandler_keyCodes[192] = 28;
			KeyFocusListener.KeyHandler_keyCodes[222] = 58;
			KeyFocusListener.KeyHandler_keyCodes[520] = 59;
		}

		final Canvas canvas_0 = canvas;
		canvas_0.setFocusTraversalKeysEnabled(false);
		canvas_0.addKeyListener(KeyFocusListener.keyboard);
		canvas_0.addFocusListener(KeyFocusListener.keyboard);
	}

	protected void setUpMouse() {
		final Canvas canvas_0 = canvas;
		canvas_0.addMouseListener(MouseInput.mouse);
		canvas_0.addMouseMotionListener(MouseInput.mouse);
		canvas_0.addFocusListener(MouseInput.mouse);
	}

	void method854() {
		final Container container_0 = container();
		if (container_0 != null) {
			final Bounds bounds_0 = method800();
			field396 = Math.max(bounds_0.field3747, field395);
			field397 = Math.max(bounds_0.field3745, field402);
			if (field396 <= 0) {
				field396 = 1;
			}

			if (field397 <= 0) {
				field397 = 1;
			}

			Varcs.canvasWidth = Math.min(field396, field400);
			BuildType.canvasHeight = Math.min(field397, field414);
			field398 = (field396 - Varcs.canvasWidth) / 2;
			field411 = 0;
			canvas.setSize(Varcs.canvasWidth, BuildType.canvasHeight);
			GameSocket.rasterProvider = new MainBufferProvider(Varcs.canvasWidth, BuildType.canvasHeight, canvas);
			if (container_0 == frame) {
				final Insets insets_0 = frame.getInsets();
				canvas.setLocation(field398 + insets_0.left, insets_0.top + field411);
			} else {
				canvas.setLocation(field398, field411);
			}

			field406 = true;
			vmethod1144();
		}
	}

	protected abstract void vmethod1144();

	void method776() {
		final int int_0 = field398;
		final int int_1 = field411;
		final int int_2 = field396 - Varcs.canvasWidth - int_0;
		final int int_3 = field397 - BuildType.canvasHeight - int_1;
		if ((int_0 > 0) || (int_2 > 0) || (int_1 > 0) || (int_3 > 0)) {
			try {
				final Container container_0 = container();
				int int_4 = 0;
				int int_5 = 0;
				if (container_0 == frame) {
					final Insets insets_0 = frame.getInsets();
					int_4 = insets_0.left;
					int_5 = insets_0.top;
				}

				final Graphics graphics_0 = container_0.getGraphics();
				graphics_0.setColor(Color.black);
				if (int_0 > 0) {
					graphics_0.fillRect(int_4, int_5, int_0, field397);
				}

				if (int_1 > 0) {
					graphics_0.fillRect(int_4, int_5, field396, int_1);
				}

				if (int_2 > 0) {
					graphics_0.fillRect((int_4 + field396) - int_2, int_5, int_2, field397);
				}

				if (int_3 > 0) {
					graphics_0.fillRect(int_4, (int_5 + field397) - int_3, field396, int_3);
				}
			} catch (final Exception exception_0) {
			}
		}

	}

	void method777() {
		final Canvas canvas_0 = canvas;
		canvas_0.removeKeyListener(KeyFocusListener.keyboard);
		canvas_0.removeFocusListener(KeyFocusListener.keyboard);
		KeyFocusListener.field329 = -1;
		final Canvas canvas_1 = canvas;
		canvas_1.removeMouseListener(MouseInput.mouse);
		canvas_1.removeMouseMotionListener(MouseInput.mouse);
		canvas_1.removeFocusListener(MouseInput.mouse);
		MouseInput.MouseHandler_currentButton = 0;
		if (mouseWheelHandler != null) {
			mouseWheelHandler.removeFrom(canvas);
		}

		replaceCanvas();
		final Canvas canvas_2 = canvas;
		canvas_2.setFocusTraversalKeysEnabled(false);
		canvas_2.addKeyListener(KeyFocusListener.keyboard);
		canvas_2.addFocusListener(KeyFocusListener.keyboard);
		final Canvas canvas_3 = canvas;
		canvas_3.addMouseListener(MouseInput.mouse);
		canvas_3.addMouseMotionListener(MouseInput.mouse);
		canvas_3.addFocusListener(MouseInput.mouse);
		if (mouseWheelHandler != null) {
			mouseWheelHandler.addTo(canvas);
		}

		method784();
	}

	protected void initialize(final int int_0, final int int_1, final int int_2) {
		try {
			if (shell != null) {
				++shellCount;
				if (shellCount >= 3) {
					error("alreadyloaded");
					return;
				}

				getAppletContext().showDocument(getDocumentBase(), "_self");
				return;
			}

			shell = this;
			Varcs.canvasWidth = int_0;
			BuildType.canvasHeight = int_1;
			GameCanvas.revision = int_2;
			RunException.field1938 = this;
			if (taskManager == null) {
				taskManager = new Signlink();
			}

			taskManager.createRunnable(this, 1);
		} catch (final Exception exception_0) {
			UnitPriceComparator.processClientError(null, exception_0);
			error("crash");
		}

	}

	synchronized void replaceCanvas() {
		final Container container_0 = container();
		if (canvas != null) {
			canvas.removeFocusListener(this);
			container_0.remove(canvas);
		}

		Varcs.canvasWidth = Math.max(container_0.getWidth(), field395);
		BuildType.canvasHeight = Math.max(container_0.getHeight(), field402);
		Insets insets_0;
		if (frame != null) {
			insets_0 = frame.getInsets();
			Varcs.canvasWidth -= insets_0.right + insets_0.left;
			BuildType.canvasHeight -= insets_0.bottom + insets_0.top;
		}

		canvas = new GameCanvas(this);
		container_0.add(canvas);
		canvas.setSize(Varcs.canvasWidth, BuildType.canvasHeight);
		canvas.setVisible(true);
		canvas.setBackground(Color.BLACK);
		if (container_0 == frame) {
			insets_0 = frame.getInsets();
			canvas.setLocation(insets_0.left + field398, insets_0.top + field411);
		} else {
			canvas.setLocation(field398, field411);
		}

		canvas.addFocusListener(this);
		canvas.requestFocus();
		field406 = true;
		if ((GameSocket.rasterProvider != null) && (Varcs.canvasWidth == GameSocket.rasterProvider.width)
				&& (BuildType.canvasHeight == GameSocket.rasterProvider.height)) {
			((MainBufferProvider) GameSocket.rasterProvider).replaceComponent(canvas);
			GameSocket.rasterProvider.drawFull(0, 0);
		} else {
			GameSocket.rasterProvider = new MainBufferProvider(Varcs.canvasWidth, BuildType.canvasHeight, canvas);
		}

		field409 = false;
		field410 = Buffer.safeCurrentTimeMillis();
	}

	protected boolean isValidHost() {
		if (true)
			return true;
		String string_0 = getDocumentBase().getHost().toLowerCase();
		if (!string_0.equals("jagex.com") && !string_0.endsWith(".jagex.com")) {
			if (!string_0.equals("runescape.com") && !string_0.endsWith(".runescape.com")) {
				if (string_0.endsWith("127.0.0.1")) {
					return true;
				} else {
					while ((string_0.length() > 0) && (string_0.charAt(string_0.length() - 1) >= 48)
							&& (string_0.charAt(string_0.length() - 1) <= 57)) {
						string_0 = string_0.substring(0, string_0.length() - 1);
					}

					if (string_0.endsWith("192.168.1.")) {
						return true;
					} else {
						error("invalidhost");
						return false;
					}
				}
			} else {
				return true;
			}
		} else {
			return true;
		}
	}

	void method781() {
		final long long_0 = Buffer.safeCurrentTimeMillis();
		final long long_1 = field404[WorldMapData.field172];
		field404[WorldMapData.field172] = long_0;
		WorldMapData.field172 = (WorldMapData.field172 + 1) & 0x1F;
		if ((long_1 != 0L) && (long_0 > long_1)) {
		}

		synchronized (this) {
			WorldMapType1.field146 = focused;
		}

		packetHandler();
	}

	void method782() {
		final Container container_0 = container();
		final long long_0 = Buffer.safeCurrentTimeMillis();
		final long long_1 = field394[VarCString.field3259];
		field394[VarCString.field3259] = long_0;
		VarCString.field3259 = (VarCString.field3259 + 1) & 0x1F;
		if ((long_1 != 0L) && (long_0 > long_1)) {
			final int int_0 = (int) (long_0 - long_1);
			FPS = ((int_0 >> 1) + 32000) / int_0;
		}

		if ((++field413 - 1) > 50) {
			field413 -= 50;
			field406 = true;
			canvas.setSize(Varcs.canvasWidth, BuildType.canvasHeight);
			canvas.setVisible(true);
			if (container_0 == frame) {
				final Insets insets_0 = frame.getInsets();
				canvas.setLocation(field398 + insets_0.left, field411 + insets_0.top);
			} else {
				canvas.setLocation(field398, field411);
			}
		}

		if (field409) {
			method777();
		}

		method783();
		methodDraw(Loader.CHRISTMAS || field406);
		if (field406) {
			method776();
		}

		field406 = false;
	}

	void method783() {
		final Bounds bounds_0 = method800();
		if ((bounds_0.field3747 != field396) || (field397 != bounds_0.field3745) || field408) {
			method854();
			field408 = false;
		}

	}

	void method784() {
		field408 = true;
	}

	synchronized void method785() {
		if (!field389) {
			field389 = true;

			try {
				canvas.removeFocusListener(this);
			} catch (final Exception exception_0) {
			}

			try {
				vmethod1187();
			} catch (final Exception exception_1) {
			}

			if (frame != null) {
				try {
					System.exit(0);
				} catch (final Throwable throwable_0) {
				}
			}

			if (taskManager != null) {
				try {
					taskManager.join();
				} catch (final Exception exception_2) {
				}
			}

			vmethod1132();
		}
	}

	protected abstract void setUp();

	protected abstract void packetHandler();

	protected abstract void methodDraw(boolean var1);

	protected abstract void vmethod1187();

	protected void drawLoadingScreen(final int int_0, final String string_0, final boolean bool_0) {
		try {
			final Graphics graphics_0 = canvas.getGraphics();
			if (Signlink.field1961 == null) {
				Signlink.field1961 = new java.awt.Font("Helvetica", 1, 13);
				MapCacheArchiveNames.field256 = canvas.getFontMetrics(Signlink.field1961);
			}

			if (bool_0) {
				graphics_0.setColor(Color.black);
				graphics_0.fillRect(0, 0, Varcs.canvasWidth, BuildType.canvasHeight);
			}

			final Color color_0 = new Color(140, 17, 17);

			try {
				if (CombatInfoListHolder.field1028 == null) {
					CombatInfoListHolder.field1028 = canvas.createImage(304, 34);
				}

				final Graphics graphics_1 = CombatInfoListHolder.field1028.getGraphics();
				graphics_1.setColor(color_0);
				graphics_1.drawRect(0, 0, 303, 33);
				graphics_1.fillRect(2, 2, int_0 * 3, 30);
				graphics_1.setColor(Color.black);
				graphics_1.drawRect(1, 1, 301, 31);
				graphics_1.fillRect((int_0 * 3) + 2, 2, 300 - (int_0 * 3), 30);
				graphics_1.setFont(Signlink.field1961);
				graphics_1.setColor(Color.white);
				graphics_1.drawString(string_0, (304 - MapCacheArchiveNames.field256.stringWidth(string_0)) / 2, 22);
				graphics_0.drawImage(CombatInfoListHolder.field1028, (Varcs.canvasWidth / 2) - 152,
						(BuildType.canvasHeight / 2) - 18, null);
			} catch (final Exception exception_1) {
				final int int_1 = (Varcs.canvasWidth / 2) - 152;
				final int int_2 = (BuildType.canvasHeight / 2) - 18;
				graphics_0.setColor(color_0);
				graphics_0.drawRect(int_1, int_2, 303, 33);
				graphics_0.fillRect(int_1 + 2, int_2 + 2, int_0 * 3, 30);
				graphics_0.setColor(Color.black);
				graphics_0.drawRect(int_1 + 1, int_2 + 1, 301, 31);
				graphics_0.fillRect(int_1 + (int_0 * 3) + 2, int_2 + 2, 300 - (int_0 * 3), 30);
				graphics_0.setFont(Signlink.field1961);
				graphics_0.setColor(Color.white);
				graphics_0.drawString(string_0,
						int_1 + ((304 - MapCacheArchiveNames.field256.stringWidth(string_0)) / 2), int_2 + 22);
			}
		} catch (final Exception exception_0) {
			canvas.repaint();
		}

	}

	protected void method842() {
		CombatInfoListHolder.field1028 = null;
		Signlink.field1961 = null;
		MapCacheArchiveNames.field256 = null;
	}

	protected void error(final String string_0) {
		if (!hasErrored) {
			hasErrored = true;
			System.out.println("error_game_" + string_0);

			try {
				getAppletContext().showDocument(new URL(getCodeBase(), "error_game_" + string_0 + ".ws"), "_self");
			} catch (final Exception exception_0) {
			}

		}
	}

	Container container() {
		return frame != null ? frame : this;
	}

	Bounds method800() {
		final Container container_0 = container();
		int int_0 = Math.max(container_0.getWidth(), field395);
		int int_1 = Math.max(container_0.getHeight(), field402);
		if (frame != null) {
			final Insets insets_0 = frame.getInsets();
			int_0 -= insets_0.left + insets_0.right;
			int_1 -= insets_0.top + insets_0.bottom;
		}

		return new Bounds(int_0, int_1);
	}

	protected boolean method801() {
		return frame != null;
	}

	protected abstract void vmethod1132();

	@Override
	public void destroy() {
		if ((this == shell) && !field389) {
			field388 = Buffer.safeCurrentTimeMillis();
			Actor.method1539(5000L);
			method785();
		}
	}

	@Override
	public synchronized void paint(final Graphics graphics_0) {
		if ((this == shell) && !field389) {
			field406 = true;
			if ((Buffer.safeCurrentTimeMillis() - field410) > 1000L) {
				final Rectangle rectangle_0 = graphics_0.getClipBounds();
				if ((rectangle_0 == null) || ((rectangle_0.width >= Varcs.canvasWidth)
						&& (rectangle_0.height >= BuildType.canvasHeight))) {
					field409 = true;
				}
			}

		}
	}

	@Override
	public void run() {
		try {
			if (Signlink.javaVendor != null) {
				final String string_0 = Signlink.javaVendor.toLowerCase();
				if ((string_0.indexOf("sun") != -1) || (string_0.indexOf("apple") != -1)) {
					final String string_1 = Signlink.javaVersion;
					if (string_1.equals("1.1") || string_1.startsWith("1.1.") || string_1.equals("1.2")
							|| string_1.startsWith("1.2.") || string_1.equals("1.3") || string_1.startsWith("1.3.")
							|| string_1.equals("1.4") || string_1.startsWith("1.4.") || string_1.equals("1.5")
							|| string_1.startsWith("1.5.") || string_1.equals("1.6.0")) {
						error("wrongjava");
						return;
					}

					if (string_1.startsWith("1.6.0_")) {
						int int_0;
						for (int_0 = 6; int_0 < string_1.length(); int_0++) {
							final char char_0 = string_1.charAt(int_0);
							final boolean bool_0 = (char_0 >= 48) && (char_0 <= 57);
							if (!bool_0) {
								break;
							}
						}

						final String string_2 = string_1.substring(6, int_0);
						if (Resampler.method2249(string_2)) {
							final int int_2 = class68.parseInt(string_2, 10, true);
							if (int_2 < 10) {
								error("wrongjava");
								return;
							}
						}
					}

					field385 = 5;
				}
			}

			setFocusCycleRoot(true);
			replaceCanvas();
			setUp();
			class43.timer = class43.method712();

			while ((field388 == 0L) || (Buffer.safeCurrentTimeMillis() < field388)) {
				class8.field48 = class43.timer.vmethod3331(field391, field385);

				for (int int_1 = 0; int_1 < class8.field48; int_1++) {
					method781();
				}

				method782();
				method768(canvas);
			}
		} catch (final Exception exception_0) {
			UnitPriceComparator.processClientError(null, exception_0);
			error("crash");
		}

		method785();
	}

	@Override
	public void start() {
		if ((this == shell) && !field389) {
			field388 = 0L;
		}
	}

	@Override
	public void stop() {
		if ((this == shell) && !field389) {
			field388 = Buffer.safeCurrentTimeMillis() + 4000L;
		}
	}

	@Override
	public void update(final Graphics graphics_0) {
		paint(graphics_0);
	}

	@Override
	public void focusGained(final FocusEvent focusevent_0) {
		focused = true;
		field406 = true;
	}

	@Override
	public void focusLost(final FocusEvent focusevent_0) {
		focused = false;
	}

	@Override
	public void windowDeactivated(final WindowEvent windowevent_0) {
	}

	@Override
	public void windowIconified(final WindowEvent windowevent_0) {
	}

	@Override
	public void windowOpened(final WindowEvent windowevent_0) {
	}

	@Override
	public void windowDeiconified(final WindowEvent windowevent_0) {
	}

	@Override
	public void windowActivated(final WindowEvent windowevent_0) {
	}

	@Override
	public void windowClosed(final WindowEvent windowevent_0) {
	}

	@Override
	public void windowClosing(final WindowEvent windowevent_0) {
		destroy();
	}

	@Override
	public abstract void init();

	public static class157 method911(final Socket socket_0, final int int_0, final int int_1) throws IOException {
		return new class159(socket_0, int_0, int_1);
	}

	static int method909(int int_0, final Script script_0, final boolean bool_0) {
		int int_1 = -1;
		Widget widget_0;
		if (int_0 >= 2000) {
			int_0 -= 1000;
			int_1 = class69.intStack[--class69.intStackSize];
			widget_0 = Widget.getWidget(int_1);
		} else {
			widget_0 = bool_0 ? class276.field3561 : KitDefinition.field3301;
		}

		if (int_0 == 1000) {
			class69.intStackSize -= 4;
			widget_0.originalX = class69.intStack[class69.intStackSize];
			widget_0.originalY = class69.intStack[class69.intStackSize + 1];
			widget_0.dynamicX = class69.intStack[class69.intStackSize + 2];
			widget_0.dynamicY = class69.intStack[class69.intStackSize + 3];
			Player.method1114(widget_0);
			Buffer.clientInstance.widgetMethod0(widget_0);
			if ((int_1 != -1) && (widget_0.type == 0)) {
				GameSocket.method3388(GameCanvas.widgets[int_1 >> 16], widget_0, false);
			}

			return 1;
		} else if (int_0 == 1001) {
			class69.intStackSize -= 4;
			widget_0.originalWidth = class69.intStack[class69.intStackSize];
			widget_0.originalHeight = class69.intStack[class69.intStackSize + 1];
			widget_0.dynamicWidth = class69.intStack[class69.intStackSize + 2];
			widget_0.buttonType = class69.intStack[class69.intStackSize + 3];
			Player.method1114(widget_0);
			Buffer.clientInstance.widgetMethod0(widget_0);
			if ((int_1 != -1) && (widget_0.type == 0)) {
				GameSocket.method3388(GameCanvas.widgets[int_1 >> 16], widget_0, false);
			}

			return 1;
		} else if (int_0 == 1003) {
			final boolean bool_1 = class69.intStack[--class69.intStackSize] == 1;
			if (bool_1 != widget_0.isHidden) {
				widget_0.isHidden = bool_1;
				Player.method1114(widget_0);
			}

			return 1;
		} else if (int_0 == 1005) {
			widget_0.noClickThrough = class69.intStack[--class69.intStackSize] == 1;
			return 1;
		} else if (int_0 == 1006) {
			widget_0.noScrollThrough = class69.intStack[--class69.intStackSize] == 1;
			return 1;
		} else {
			return 2;
		}
	}

	static void method910() {
		final Iterator iterator_0 = class83.messages.iterator();

		while (iterator_0.hasNext()) {
			final MessageNode messagenode_0 = (MessageNode) iterator_0.next();
			messagenode_0.method1042();
		}

	}

	public static void method913(final int int_0, final int int_1) {
		class120.Viewport_mouseX = int_0;
		class120.Viewport_mouseY = int_1;
		class120.Viewport_containsMouse = true;
		class120.Viewport_entityCountAtMouse = 0;
		class120.Viewport_false0 = false;
	}

	static int method914(final int int_0, final Script script_0, final boolean bool_0) {
		final Widget widget_0 = bool_0 ? class276.field3561 : KitDefinition.field3301;
		if (int_0 == 1800) {
			class69.intStack[++class69.intStackSize - 1] = Signlink.method3252(class24.getWidgetClickMask(widget_0));
			return 1;
		} else if (int_0 != 1801) {
			if (int_0 == 1802) {
				if (widget_0.opBase == null) {
					class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = "";
				} else {
					class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = widget_0.opBase;
				}

				return 1;
			} else {
				return 2;
			}
		} else {
			int int_1 = class69.intStack[--class69.intStackSize];
			--int_1;
			if ((widget_0.actions != null) && (int_1 < widget_0.actions.length) && (widget_0.actions[int_1] != null)) {
				class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = widget_0.actions[int_1];
			} else {
				class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = "";
			}

			return 1;
		}
	}

	static byte[] decodeContainer(final byte[] bytes_0) {
		final Buffer buffer_0 = new Buffer(bytes_0);
		final int int_0 = buffer_0.readUnsignedByte();
		final int int_1 = buffer_0.readInt();
		if ((int_1 < 0) || ((IndexDataBase.field3176 != 0) && (int_1 > IndexDataBase.field3176))) {
			throw new RuntimeException();
		} else if (int_0 == 0) {
			final byte[] bytes_1 = new byte[int_1];
			buffer_0.readBytes(bytes_1, 0, int_1);
			return bytes_1;
		} else {
			final int int_2 = buffer_0.readInt();
			if ((int_2 >= 0) && ((IndexDataBase.field3176 == 0) || (int_2 <= IndexDataBase.field3176))) {
				final byte[] bytes_2 = new byte[int_2];
				if (int_0 == 1) {
					class176.Bzip2Decompressor_decompress(bytes_2, int_2, bytes_0, int_1, 9);
				} else {
					IndexDataBase.gzip.decompress(buffer_0, bytes_2);
				}

				return bytes_2;
			} else {
				throw new RuntimeException();
			}
		}
	}

}
