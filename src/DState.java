public final class DState
{

	public static FriendManager friendManager;
	final int field2333;
	final int field2320;
	final int field2327;
	final int field2300;
	final int field2298;
	final int field2299;
	byte[] strm;
	int next_in;
	int total_out_lo32;
	byte[] out;
	int next_out;
	int field2310;
	int total_out_hi32;
	byte out_ch;
	int out_len;
	int total_in_hi32;
	int total_in_lo32;
	int blockSize100k;
	int field2312;
	int tPos;
	int k0;
	int[] field2315;
	int nblock_used;
	int[] field2317;
	int nInUse;
	boolean[] inUse;
	boolean[] field2296;
	byte[] seqToUnseq;
	byte[] field2322;
	int[] field2323;
	byte[] field2324;
	byte[] field2328;
	byte[][] field2303;
	int[][] field2301;
	int[][] field2297;
	int[][] field2329;
	int[] field2330;
	int field2331;

	DState()
	{
		field2333 = 4096;
		field2320 = 16;
		field2327 = 258;
		field2300 = 6;
		field2298 = 50;
		field2299 = 18002;
		next_in = 0;
		next_out = 0;
		field2315 = new int[256];
		field2317 = new int[257];
		inUse = new boolean[256];
		field2296 = new boolean[16];
		seqToUnseq = new byte[256];
		field2322 = new byte[4096];
		field2323 = new int[16];
		field2324 = new byte[18002];
		field2328 = new byte[18002];
		field2303 = new byte[6][258];
		field2301 = new int[6][258];
		field2297 = new int[6][258];
		field2329 = new int[6][258];
		field2330 = new int[6];
	}

	public static void method3529(final Huffman huffman_0)
	{
		class300.huffman = huffman_0;
	}

	static void method3528(final int int_0, final int int_1, final int int_2,
	        final ObjectComposition objectcomposition_0, final int int_3)
	{
		final class68 class68_0 = new class68();
		class68_0.field981 = int_0;
		class68_0.field988 = int_1 * 128;
		class68_0.field983 = int_2 * 128;
		int int_4 = objectcomposition_0.width;
		int int_5 = objectcomposition_0.length;
		if ((int_3 == 1) || (int_3 == 3))
		{
			int_4 = objectcomposition_0.length;
			int_5 = objectcomposition_0.width;
		}

		class68_0.field984 = (int_4 + int_1) * 128;
		class68_0.field992 = (int_5 + int_2) * 128;
		class68_0.field987 = objectcomposition_0.ambientSoundId;
		class68_0.field991 = objectcomposition_0.int4 * 128;
		class68_0.field989 = objectcomposition_0.int5;
		class68_0.field982 = objectcomposition_0.int6;
		class68_0.field986 = objectcomposition_0.field3417;
		if (objectcomposition_0.impostorIds != null)
		{
			class68_0.field994 = objectcomposition_0;
			class68_0.method1688();
		}

		class68.field985.addFront(class68_0);
		if (class68_0.field986 != null)
		{
			class68_0.field990 = class68_0.field989 + (int) (Math.random() * (class68_0.field982 - class68_0.field989));
		}

	}

	static int method3526(final int int_0, final Script script_0, final boolean bool_0)
	{
		int int_1;
		if (int_0 == 5504)
		{
			class69.intStackSize -= 2;
			int_1 = class69.intStack[class69.intStackSize];
			final int int_2 = class69.intStack[class69.intStackSize + 1];
			if (!Game.field822)
			{
				Game.cameraPitchTarget = int_1;
				Game.mapAngle = int_2;
			}

			return 1;
		}
		else if (int_0 == 5505)
		{
			class69.intStack[++class69.intStackSize - 1] = Game.cameraPitchTarget;
			return 1;
		}
		else if (int_0 == 5506)
		{
			class69.intStack[++class69.intStackSize - 1] = Game.mapAngle;
			return 1;
		}
		else if (int_0 == 5530)
		{
			int_1 = class69.intStack[--class69.intStackSize];
			if (int_1 < 0)
			{
				int_1 = 0;
			}

			Game.field644 = int_1;
			return 1;
		}
		else if (int_0 == 5531)
		{
			class69.intStack[++class69.intStackSize - 1] = Game.field644;
			return 1;
		}
		else
		{
			return 2;
		}
	}

	static void method3527()
	{
		if (Game.field663 && (class138.localPlayer != null))
		{
			final int int_0 = class138.localPlayer.pathX[0];
			final int int_1 = class138.localPlayer.pathY[0];
			if ((int_0 < 0) || (int_1 < 0) || (int_0 >= 104) || (int_1 >= 104))
			{
				return;
			}

			CacheFile.field1428 = class138.localPlayer.x;
			final int int_2 = WorldMapType2.getTileHeight(class138.localPlayer.x, class138.localPlayer.y, class13.plane)
			        - Game.field644;
			if (int_2 < ItemComposition.field3478)
			{
				ItemComposition.field3478 = int_2;
			}

			GrandExchangeEvent.field23 = class138.localPlayer.y;
			Game.field663 = false;
		}

	}

}
