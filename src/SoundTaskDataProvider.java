public class SoundTaskDataProvider implements class89
{

	static int[] field357;
	static int field361;

	@Override
	public AbstractSoundSystem vmethod2052()
	{
		return new SourceDataSoundSystem();
	}

	static void method695()
	{
		class50.field442 = 99;
		class50.tileUnderlayIds = new byte[4][104][104];
		class165.tileOverlayIds = new byte[4][104][104];
		class50.tileOverlayPath = new byte[4][104][104];
		WorldMapDecoration.overlayRotations = new byte[4][104][104];
		class37.field325 = new int[4][105][105];
		class50.field447 = new byte[4][105][105];
		class50.field448 = new int[105][105];
		class50.floorHues = new int[104];
		class305.floorSaturations = new int[104];
		NPC.field1035 = new int[104];
		Varbit.floorMultiplier = new int[104];
		BuildType.field3137 = new int[104];
	}

	static boolean method693(final int int_0, final int int_1, final class166 class166_0,
	        final CollisionData collisiondata_0)
	{
		int int_2 = int_0;
		int int_3 = int_1;
		final byte byte_0 = 64;
		final byte byte_1 = 64;
		final int int_4 = int_0 - byte_0;
		final int int_5 = int_1 - byte_1;
		class165.field2035[byte_0][byte_1] = 99;
		class165.field2041[byte_0][byte_1] = 0;
		final byte byte_2 = 0;
		int int_6 = 0;
		class165.field2039[byte_2] = int_0;
		final byte byte_3 = byte_2;
		int int_12 = byte_2 + 1;
		class165.field2038[byte_3] = int_1;
		final int[][] ints_0 = collisiondata_0.flags;

		while (int_6 != int_12)
		{
			int_2 = class165.field2039[int_6];
			int_3 = class165.field2038[int_6];
			int_6 = (int_6 + 1) & 0xFFF;
			final int int_10 = int_2 - int_4;
			final int int_11 = int_3 - int_5;
			final int int_7 = int_2 - collisiondata_0.x;
			final int int_8 = int_3 - collisiondata_0.y;
			if (class166_0.vmethod3440(2, int_2, int_3, collisiondata_0))
			{
				WorldMapDecoration.field152 = int_2;
				class165.field2037 = int_3;
				return true;
			}

			final int int_9 = class165.field2041[int_10][int_11] + 1;
			if ((int_10 > 0) && (class165.field2035[int_10 - 1][int_11] == 0)
			        && ((ints_0[int_7 - 1][int_8] & 0x124010E) == 0)
			        && ((ints_0[int_7 - 1][int_8 + 1] & 0x1240138) == 0))
			{
				class165.field2039[int_12] = int_2 - 1;
				class165.field2038[int_12] = int_3;
				int_12 = (int_12 + 1) & 0xFFF;
				class165.field2035[int_10 - 1][int_11] = 2;
				class165.field2041[int_10 - 1][int_11] = int_9;
			}

			if ((int_10 < 126) && (class165.field2035[int_10 + 1][int_11] == 0)
			        && ((ints_0[int_7 + 2][int_8] & 0x1240183) == 0)
			        && ((ints_0[int_7 + 2][int_8 + 1] & 0x12401E0) == 0))
			{
				class165.field2039[int_12] = int_2 + 1;
				class165.field2038[int_12] = int_3;
				int_12 = (int_12 + 1) & 0xFFF;
				class165.field2035[int_10 + 1][int_11] = 8;
				class165.field2041[int_10 + 1][int_11] = int_9;
			}

			if ((int_11 > 0) && (class165.field2035[int_10][int_11 - 1] == 0)
			        && ((ints_0[int_7][int_8 - 1] & 0x124010E) == 0)
			        && ((ints_0[int_7 + 1][int_8 - 1] & 0x1240183) == 0))
			{
				class165.field2039[int_12] = int_2;
				class165.field2038[int_12] = int_3 - 1;
				int_12 = (int_12 + 1) & 0xFFF;
				class165.field2035[int_10][int_11 - 1] = 1;
				class165.field2041[int_10][int_11 - 1] = int_9;
			}

			if ((int_11 < 126) && (class165.field2035[int_10][int_11 + 1] == 0)
			        && ((ints_0[int_7][int_8 + 2] & 0x1240138) == 0)
			        && ((ints_0[int_7 + 1][int_8 + 2] & 0x12401E0) == 0))
			{
				class165.field2039[int_12] = int_2;
				class165.field2038[int_12] = int_3 + 1;
				int_12 = (int_12 + 1) & 0xFFF;
				class165.field2035[int_10][int_11 + 1] = 4;
				class165.field2041[int_10][int_11 + 1] = int_9;
			}

			if ((int_10 > 0) && (int_11 > 0) && (class165.field2035[int_10 - 1][int_11 - 1] == 0)
			        && ((ints_0[int_7 - 1][int_8] & 0x124013E) == 0)
			        && ((ints_0[int_7 - 1][int_8 - 1] & 0x124010E) == 0)
			        && ((ints_0[int_7][int_8 - 1] & 0x124018F) == 0))
			{
				class165.field2039[int_12] = int_2 - 1;
				class165.field2038[int_12] = int_3 - 1;
				int_12 = (int_12 + 1) & 0xFFF;
				class165.field2035[int_10 - 1][int_11 - 1] = 3;
				class165.field2041[int_10 - 1][int_11 - 1] = int_9;
			}

			if ((int_10 < 126) && (int_11 > 0) && (class165.field2035[int_10 + 1][int_11 - 1] == 0)
			        && ((ints_0[int_7 + 1][int_8 - 1] & 0x124018F) == 0)
			        && ((ints_0[int_7 + 2][int_8 - 1] & 0x1240183) == 0)
			        && ((ints_0[int_7 + 2][int_8] & 0x12401E3) == 0))
			{
				class165.field2039[int_12] = int_2 + 1;
				class165.field2038[int_12] = int_3 - 1;
				int_12 = (int_12 + 1) & 0xFFF;
				class165.field2035[int_10 + 1][int_11 - 1] = 9;
				class165.field2041[int_10 + 1][int_11 - 1] = int_9;
			}

			if ((int_10 > 0) && (int_11 < 126) && (class165.field2035[int_10 - 1][int_11 + 1] == 0)
			        && ((ints_0[int_7 - 1][int_8 + 1] & 0x124013E) == 0)
			        && ((ints_0[int_7 - 1][int_8 + 2] & 0x1240138) == 0)
			        && ((ints_0[int_7][int_8 + 2] & 0x12401F8) == 0))
			{
				class165.field2039[int_12] = int_2 - 1;
				class165.field2038[int_12] = int_3 + 1;
				int_12 = (int_12 + 1) & 0xFFF;
				class165.field2035[int_10 - 1][int_11 + 1] = 6;
				class165.field2041[int_10 - 1][int_11 + 1] = int_9;
			}

			if ((int_10 < 126) && (int_11 < 126) && (class165.field2035[int_10 + 1][int_11 + 1] == 0)
			        && ((ints_0[int_7 + 1][int_8 + 2] & 0x12401F8) == 0)
			        && ((ints_0[int_7 + 2][int_8 + 2] & 0x12401E0) == 0)
			        && ((ints_0[int_7 + 2][int_8 + 1] & 0x12401E3) == 0))
			{
				class165.field2039[int_12] = int_2 + 1;
				class165.field2038[int_12] = int_3 + 1;
				int_12 = (int_12 + 1) & 0xFFF;
				class165.field2035[int_10 + 1][int_11 + 1] = 12;
				class165.field2041[int_10 + 1][int_11 + 1] = int_9;
			}
		}

		WorldMapDecoration.field152 = int_2;
		class165.field2037 = int_3;
		return false;
	}

	static boolean method696()
	{
		return Game.rights >= 2;
	}

}
