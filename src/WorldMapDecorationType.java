public enum WorldMapDecorationType implements Enumerated
{

	field2773(0, 0), field2775(1, 0), field2755(2, 0), field2757(3, 0), field2758(9, 2), field2754(4, 1), field2770(5,
	        1), field2761(6, 1), field2762(7, 1), field2763(8, 1), field2760(12, 2), field2765(13, 2), field2766(14,
	                2), field2767(15, 2), field2768(16, 2), field2769(17, 2), field2774(18,
	                        2), field2771(19, 2), field2772(20,
	                                2), field2756(21, 2), field2759(10, 2), field2764(11, 2), field2776(22, 3);

	public final int rsOrdinal;

	WorldMapDecorationType(final int int_1, final int int_2)
	{
		rsOrdinal = int_1;
	}

	@Override
	public int vmethod5815()
	{
		return rsOrdinal;
	}

	public static IndexedSprite method4589(final IndexDataBase indexdatabase_0, final int int_0)
	{
		final byte[] bytes_0 = indexdatabase_0.takeRecordFlat(int_0);
		boolean bool_0;
		if (bytes_0 == null)
		{
			bool_0 = false;
		}
		else
		{
			ObjectComposition.decodeSprite(bytes_0);
			bool_0 = true;
		}

		return !bool_0 ? null : class305.method5658();
	}

	static void method4588(final String string_0)
	{
		final StringBuilder stringbuilder_0 = (new StringBuilder()).append(string_0);
		final String string_1 = stringbuilder_0.append(" is already on your friend list").toString();
		class143.sendGameMessage(30, "", string_1);
	}

}
