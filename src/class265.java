public class class265 extends CacheableNode
{

	public static NodeCache field3334;
	IterableHashTable field3335;

	static
	{
		field3334 = new NodeCache(64);
	}

	public void method4961()
	{
	}

	public void method4960(final Buffer buffer_0)
	{
		while (true)
		{
			final int int_0 = buffer_0.readUnsignedByte();
			if (int_0 == 0)
			{
				return;
			}

			method4967(buffer_0, int_0);
		}
	}

	void method4967(final Buffer buffer_0, final int int_0)
	{
		if (int_0 == 249)
		{
			field3335 = KeyFocusListener.readStringIntParameters(buffer_0, field3335);
		}

	}

	public int method4962(final int int_0, final int int_1)
	{
		return FriendManager.method1668(field3335, int_0, int_1);
	}

	public String method4963(final int int_0, final String string_0)
	{
		return WorldMapRectangle.method171(field3335, int_0, string_0);
	}

	public static String method4976(final CharSequence charsequence_0)
	{
		final int int_0 = charsequence_0.length();
		final char[] chars_0 = new char[int_0];

		for (int int_1 = 0; int_1 < int_0; int_1++)
		{
			chars_0[int_1] = 42;
		}

		final String string_0 = new String(chars_0);
		return string_0;
	}

}
