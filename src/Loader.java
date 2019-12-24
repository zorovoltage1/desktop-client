import javax.imageio.ImageIO;
import javax.swing.*;
import java.applet.AppletContext;
import java.applet.AppletStub;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Loader implements AppletStub {

	static final boolean CONNECT_TO_OSRS = false;

	static final int BUILD = 171;

	static final int UPDATE_SERVER_SUB_BUILD = 1;

	static final int WORLD_SERVER_SUB_BUILD = WorldType.isPVP() ? 17 : 24;

	/**
	 * Custom images
	 */
	static SpritePixels bmIcon;
	static SpritePixels bankIcon;
	static SpritePixels bloodMoneySurvivalIcon;
	static SpritePixels dicingIcon;
	static SpritePixels donatorIcon;
	static SpritePixels eventIcon;
	static SpritePixels heartIcon;
	static SpritePixels helpIcon;
	static SpritePixels petIcon;
	static SpritePixels transportationIcon;
	static SpritePixels prayerIcon;
	static SpritePixels ironmanIcon;

	static SpritePixels bountyHunterIcon;
	static SpritePixels minigameIcon;
	static SpritePixels pollBoothIcon;
	static SpritePixels slayerIcon;
	static SpritePixels coinIcon;
	static SpritePixels poolIcon;
	static SpritePixels portalcon;
	static SpritePixels thievingIcon;

	/**
	 * Theme toggles
	 */
	static final boolean CHRISTMAS = false;
	static final boolean HALLOWEEN = false;

	private static boolean GS_LOCAL_HOST = true;
	private static boolean FS_LOCAL_HOST = true;

	public static String SERVER_NAME = "EndlessPK";
	public static String WEBSITE_URL = "endlesspk.com";

	static final String FS_HOST = FS_LOCAL_HOST ? "127.0.0.1" : "149.56.243.160";

	public static void updateWorld() {
		// not the best way to do this but. but can't really think of another way right
		// now..
		WorldType.active = WorldType.PVP;

	}

	private final Map<String, String> map = new HashMap<String, String>();

	public static void main(final String[] args) throws Exception {
		Loader loader = new Loader();
		loader.initialize();
		Game game = new Game();
		JFrame frame = new JFrame("EndlessPK - Jump into battle");
		frame.add(game);
		frame.setSize(781, 541);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		try {

			frame.setIconImages(Arrays.asList(ImageIO.read(Loader.class.getResource("/img/icon-48.png")),
					ImageIO.read(Loader.class.getResource("/img/icon-16.png"))));
		} catch (Exception e) {
			e.printStackTrace();
		}
		game.setStub(loader);
		game.init();
		if (!CONNECT_TO_OSRS) {
			class54.host = GS_LOCAL_HOST ? "127.0.0.1" : "149.56.243.160";
			Game.world = GS_LOCAL_HOST ? 2 : 1;
			Game.flags = 0x1 | 0x20; // members | bounty
			WorldType.active = WorldType.PVP;
		}
		try {
			Game.DISCORD_PRESENCE.initiate(); // Discord rich presence
		} catch (Exception e) {
			e.printStackTrace();
		} catch (Error e) {
			e.printStackTrace();
		}
		game.start();
	}

	private void initialize() {
		if (CONNECT_TO_OSRS) {
			map.put("codebase", "http://oldschool77.runescape.com/");
			map.put("initial_jar", "gamepack_1413239.jar");
		}
		map.put("10", "ElZAIrq5NpKN6D3mDdihco3oPeYN2KFy2DCquj7JMmECPmLrDP3Bnw");
		map.put("9", "false");
		map.put("16", "0");
		map.put("7", "true");
		map.put("8", "0");
		map.put("1", ".runescape.com");
		map.put("13", "377");
		map.put("14", "true");
		map.put("4", "1");
		map.put("2", "34189");
		map.put("6", "1");
		map.put("3", "0");
		//map.put("5", "https://noveaps.com/extra/data/worlds.ws?order=LPWM");
		map.put("15", "5");
		map.put("12", "");
		map.put("11", "0");

	}

	@Override
	public String getParameter(String paramName) {
		return map.get(paramName);
	}

	@Override
	public URL getDocumentBase() {
		return getCodeBase();
	}

	@Override
	public URL getCodeBase() {
		try {
			return new URL("http://" + FS_HOST);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean isActive() {
		return true;
	}

	@Override
	public AppletContext getAppletContext() {
		return null;
	}

	@Override
	public void appletResize(int width, int height) {
	}

}
