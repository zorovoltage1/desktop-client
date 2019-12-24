import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class NetWriter {

	class157 rssocket;
	CombatInfoList packetBufferNodes;
	int field1216;
	Buffer buffer;
	public ISAACCipher field1218;
	PacketBuffer packetBuffer;
	ServerPacket serverPacket;
	int packetLength;
	boolean field1222;
	int field1228;
	int field1224;
	ServerPacket field1215;
	ServerPacket field1226;
	ServerPacket field1227;

	NetWriter() {
		packetBufferNodes = new CombatInfoList();
		field1216 = 0;
		buffer = new Buffer(5000);
		packetBuffer = new PacketBuffer(40000);
		serverPacket = null;
		packetLength = 0;
		field1222 = true;
		field1228 = 0;
		field1224 = 0;
	}

	void method1978() {
		packetBufferNodes.method4030();
		field1216 = 0;
	}

	void method1979() throws IOException {
		if ((rssocket != null) && (field1216 > 0)) {
			buffer.offset = 0;

			while (true) {
				final PacketNode packetnode_0 = (PacketNode) packetBufferNodes.last();
				if ((packetnode_0 == null) || (packetnode_0.field2255 > (buffer.payload.length - buffer.offset))) {
					rssocket.vmethod3347(buffer.payload, 0, buffer.offset);
					field1224 = 0;
					break;
				}

				buffer.putBytes(packetnode_0.packetBuffer.payload, 0, packetnode_0.field2255);
				field1216 -= packetnode_0.field2255;
				packetnode_0.unlink();
				packetnode_0.packetBuffer.method3531();
				packetnode_0.method3460();
			}
		}

	}

	public void method1980(final PacketNode packetnode_0) {
		packetBufferNodes.addFirst(packetnode_0);
		packetnode_0.field2255 = packetnode_0.packetBuffer.offset;
		packetnode_0.packetBuffer.offset = 0;
		field1216 += packetnode_0.field2255;
	}

	void setSocket(final class157 class157_0) {
		rssocket = class157_0;
	}

	void close() {
		if (rssocket != null) {
			rssocket.vmethod3346();
			rssocket = null;
		}

	}

	void method1984() {
		rssocket = null;
	}

	class157 getSocket() {
		return rssocket;
	}

	static void method1994(Component component, final IndexDataBase indexdatabase_0,
			final IndexDataBase indexdatabase_1, final boolean bool_0, final int int_0) {
		if (class78.field1101) {
			if (int_0 == 4) {
				class78.loginIndex = 4;
			}

		} else {
			class78.loginIndex = int_0;
			Rasterizer2D.reset();

			byte[] clientBackgroundLeft;
			byte[] clientBackgroundRight;

			/* Custom background */
			if (Loader.CHRISTMAS) {
				clientBackgroundLeft = loadImage("leftTitleBackgroundChristmas.jpg");
				clientBackgroundRight = loadImage("rightTitleBackgroundChristmas.jpg");
			} else if (Loader.HALLOWEEN) {
				clientBackgroundLeft = loadImage("leftTitleBackgroundHalloween.jpg");
				clientBackgroundRight = loadImage("rightTitleBackgroundHalloween.jpg");
			} else {
				clientBackgroundLeft = loadImage("leftTitleBackground.jpg");
				clientBackgroundRight = loadImage("rightTitleBackground.jpg");
			}

			class78.field1092 = new SpritePixels(clientBackgroundLeft, component);
			class78.field1087 = new SpritePixels(clientBackgroundRight, component);

			Loader.bmIcon = new SpritePixels(loadImage("bm_icon.png"), component);
			Loader.bankIcon = new SpritePixels(loadImage("bank_icon.png"), component);
			Loader.bloodMoneySurvivalIcon = new SpritePixels(loadImage("blood_money_survival_icon.png"), component);
			Loader.dicingIcon = new SpritePixels(loadImage("dicing_icon.png"), component);
			Loader.donatorIcon = new SpritePixels(loadImage("donator_icon.png"), component);
			Loader.eventIcon = new SpritePixels(loadImage("event_icon.png"), component);
			Loader.heartIcon = new SpritePixels(loadImage("heart_icon.png"), component);
			Loader.helpIcon = new SpritePixels(loadImage("help_icon.png"), component);
			Loader.petIcon = new SpritePixels(loadImage("pet_icon.png"), component);
			Loader.transportationIcon = new SpritePixels(loadImage("transportation_icon.png"), component);
			Loader.prayerIcon = new SpritePixels(loadImage("prayer_icon.png"), component);
			Loader.ironmanIcon = new SpritePixels(loadImage("ironman_icon.png"), component);

			Loader.bountyHunterIcon = new SpritePixels(loadImage("bounty_hunter_icon.png"), component);
			Loader.minigameIcon = new SpritePixels(loadImage("minigame_icon.png"), component);
			Loader.pollBoothIcon = new SpritePixels(loadImage("poll_booth_icon.png"), component);
			Loader.slayerIcon = new SpritePixels(loadImage("slayer_icon.png"), component);
			Loader.coinIcon = new SpritePixels(loadImage("coin_icon.png"), component);
			Loader.poolIcon = new SpritePixels(loadImage("pool_icon.png"), component);
			Loader.portalcon = new SpritePixels(loadImage("portal_icon.png"), component);
			Loader.thievingIcon = new SpritePixels(loadImage("thieving_icon.png"), component);

			class78.field1083 = class221.getSprite(indexdatabase_1, "titlebox", "");
			class78.field1084 = class221.getSprite(indexdatabase_1, "titlebutton", "");
			class78.runeSprites = class13.getIndexedSprites(indexdatabase_1, "runes", "");
			FrameMap.titlemuteSprite = class13.getIndexedSprites(indexdatabase_1, "title_mute", "");
			class235.field2783 = class221.getSprite(indexdatabase_1, "options_radio_buttons,0", "");
			Resampler.field1352 = class221.getSprite(indexdatabase_1, "options_radio_buttons,4", "");
			class78.field1089 = class221.getSprite(indexdatabase_1, "options_radio_buttons,2", "");
			ItemContainer.field472 = class221.getSprite(indexdatabase_1, "options_radio_buttons,6", "");
			FriendManager.field978 = class235.field2783.width;
			Preferences.field966 = class235.field2783.height;
			CombatInfo1.field936 = new int[256];

			int int_1;
			for (int_1 = 0; int_1 < 64; int_1++) {
				CombatInfo1.field936[int_1] = int_1 * 262144;
			}

			for (int_1 = 0; int_1 < 64; int_1++) {
				CombatInfo1.field936[int_1 + 64] = (int_1 * 1024) + 16711680;
			}

			for (int_1 = 0; int_1 < 64; int_1++) {
				CombatInfo1.field936[int_1 + 128] = (int_1 * 4) + 16776960;
			}

			for (int_1 = 0; int_1 < 64; int_1++) {
				CombatInfo1.field936[int_1 + 192] = 16777215;
			}

			class185.field2364 = new int[256];

			for (int_1 = 0; int_1 < 64; int_1++) {
				class185.field2364[int_1] = int_1 * 1024;
			}

			for (int_1 = 0; int_1 < 64; int_1++) {
				class185.field2364[int_1 + 64] = (int_1 * 4) + 65280;
			}

			for (int_1 = 0; int_1 < 64; int_1++) {
				class185.field2364[int_1 + 128] = (int_1 * 262144) + 65535;
			}

			for (int_1 = 0; int_1 < 64; int_1++) {
				class185.field2364[int_1 + 192] = 16777215;
			}

			class11.field69 = new int[256];

			for (int_1 = 0; int_1 < 64; int_1++) {
				class11.field69[int_1] = int_1 * 4;
			}

			for (int_1 = 0; int_1 < 64; int_1++) {
				class11.field69[int_1 + 64] = (int_1 * 262144) + 255;
			}

			for (int_1 = 0; int_1 < 64; int_1++) {
				class11.field69[int_1 + 128] = (int_1 * 1024) + 16711935;
			}

			for (int_1 = 0; int_1 < 64; int_1++) {
				class11.field69[int_1 + 192] = 16777215;
			}

			AttackOption.field1077 = new int[256];
			AbstractByteBuffer.field2367 = new int[32768];
			class81.field1169 = new int[32768];
			FriendManager.method1682(null);
			SoundTaskDataProvider.field357 = new int[32768];
			class76.field1073 = new int[32768];
			if (bool_0) {
				class78.username = "";
				class78.password = "";
			}

			WorldMapType3.field104 = 0;
			MapIcon.field238 = "";
			class78.field1104 = true;
			class78.worldSelectShown = false;
			if (!class10.preferences.muted) {
				WorldMapRegion.method422(2, Item.indexTrack1, "scape main", "", 255, false);
			} else {
				class26.method427(2);
			}

			class222.sendConInfo(false);
			class78.field1101 = true;
			class78.field1082 = (Varcs.canvasWidth - 765) / 2;
			class78.loginWindowX = class78.field1082 + 202;
			class78.field1091 = class78.loginWindowX + 180;
			class78.field1092.method5849(class78.field1082, 0);
			class78.field1087.method5849(class78.field1082 + 382, 0);
		}
	}

	public static byte[] loadImage(String imgName) {
		return stream2Bytes(NetWriter.class.getResourceAsStream("img/" + imgName));
		/*
		 * InputStream in = null; try { in = NetWriter.class.getResourceAsStream("/img/"
		 * + imgName); byte[] data = new byte[in.available()]; if(in.read(data) !=
		 * data.length) throw new IOException("Failed to read full image data: " +
		 * imgName); return data; } catch(Exception e) { e.printStackTrace(); } finally
		 * { if(in != null) { try { in.close(); } catch(IOException e) {
		 * e.printStackTrace(); } } }
		 * 
		 * return null;
		 */
	}

	public static byte[] stream2Bytes(InputStream ins) {

		byte[] availableBytes = new byte[0];

		try {
			byte[] buffer = new byte[4096];
			ByteArrayOutputStream outs = new ByteArrayOutputStream();

			int read = 0;
			while ((read = ins.read(buffer)) != -1) {
				outs.write(buffer, 0, read);
			}

			ins.close();
			outs.close();
			availableBytes = outs.toByteArray();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return availableBytes;
	}

	static void method2005(final boolean bool_0) {
		if (bool_0) {
			Game.field619 = class78.field1104 ? class146.field1910 : class146.field1905;
		} else {
			Game.field619 = class10.preferences.preferences.containsKey(
					Integer.valueOf(TotalQuantityComparator.method35(class78.username))) ? class146.field1908
							: class146.field1907;
		}

	}

}
