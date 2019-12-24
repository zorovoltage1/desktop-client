public final class class50
{

	static int field456;
	static int[][][] tileHeights;
	static byte[][][] tileSettings;
	static int field442;
	static byte[][][] tileUnderlayIds;
	static byte[][][] tileOverlayPath;
	static byte[][][] field447;
	static int[][] field448;
	static int[] floorHues;
	static final int[] field450;
	static final int[] field451;
	static final int[] field452;
	static final int[] field453;
	static final int[] field458;
	static final int[] field449;
	static int field457;
	static int field455;
	static IndexData indexCache13;

	static
	{
		tileHeights = new int[4][105][105];
		tileSettings = new byte[4][104][104];
		field442 = 99;
		field450 = new int[] { 1, 2, 4, 8 };
		field451 = new int[] { 16, 32, 64, 128 };
		field452 = new int[] { 1, 0, -1, 0 };
		field453 = new int[] { 0, -1, 0, 1 };
		field458 = new int[] { 1, -1, -1, 1 };
		field449 = new int[] { -1, -1, 1, 1 };
		field457 = (int) (Math.random() * 17.0D) - 8;
		field455 = (int) (Math.random() * 33.0D) - 16;
	}

	static void method965(final int int_0, final int int_1)
	{
		if ((Game.field811 != 0) && (int_0 != -1))
		{
			Actor.method1554(OwnWorldComparator.indexTrack2, int_0, 0, Game.field811, false);
			Game.field813 = true;
		}

	}

	static void method991(final int int_0)
	{
		Game.field791 = 0L;
        Game.isResized = int_0 >= 2;

		final int int_1 = Game.isResized ? 2 : 1;
		if (int_1 == 1)
		{
			Buffer.clientInstance.method906(765, 503);
		}
		else
		{
			Buffer.clientInstance.method906(7680, 2160);
		}

		if (Game.gameState >= 25)
		{
			final PacketNode packetnode_0 = class26.method433(ClientPacket.RESIZE_CLIENT_FRAME, Game.field626.field1218);
			final PacketBuffer packetbuffer_0 = packetnode_0.packetBuffer;
			final int int_2 = Game.isResized ? 2 : 1;
			packetbuffer_0.putByte(int_2);
			packetnode_0.packetBuffer.putShort(Varcs.canvasWidth);
			packetnode_0.packetBuffer.putShort(BuildType.canvasHeight);
			Game.field626.method1980(packetnode_0);
		}

	}

	public static void addMenuEntry(final String string_0, final String string_1, final int int_0, final int int_1,
	        final int int_2, final int int_3)
	{
		BuildType.method4612(string_0, string_1, int_0, int_1, int_2, int_3, false);
	}

}
