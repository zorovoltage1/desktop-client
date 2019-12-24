public enum JagexGame implements Enumerated
{

	field3146("runescape", "RuneScape", 0), field3141("stellardawn", "Stellar Dawn", 1), field3142("game3", "Game 3",
	        2), field3143("game4", "Game 4",
	                3), field3140("game5", "Game 5", 4), field3145("oldscape", "RuneScape 2007", 5);

	public final String name;
	final int id;

	JagexGame(final String string_1, final String string_2, final int int_1)
	{
		name = string_1;
		id = int_1;
	}

	@Override
	public int vmethod5815()
	{
		return id;
	}

	public static byte[] method4618(final CharSequence charsequence_0)
	{
		final int int_0 = charsequence_0.length();
		final byte[] bytes_0 = new byte[int_0];

		for (int int_1 = 0; int_1 < int_0; int_1++)
		{
			final char char_0 = charsequence_0.charAt(int_1);
			if (((char_0 > 0) && (char_0 < 128)) || ((char_0 >= 160) && (char_0 <= 255)))
			{
				bytes_0[int_1] = (byte) char_0;
			}
			else if (char_0 == 8364)
			{
				bytes_0[int_1] = -128;
			}
			else if (char_0 == 8218)
			{
				bytes_0[int_1] = -126;
			}
			else if (char_0 == 402)
			{
				bytes_0[int_1] = -125;
			}
			else if (char_0 == 8222)
			{
				bytes_0[int_1] = -124;
			}
			else if (char_0 == 8230)
			{
				bytes_0[int_1] = -123;
			}
			else if (char_0 == 8224)
			{
				bytes_0[int_1] = -122;
			}
			else if (char_0 == 8225)
			{
				bytes_0[int_1] = -121;
			}
			else if (char_0 == 710)
			{
				bytes_0[int_1] = -120;
			}
			else if (char_0 == 8240)
			{
				bytes_0[int_1] = -119;
			}
			else if (char_0 == 352)
			{
				bytes_0[int_1] = -118;
			}
			else if (char_0 == 8249)
			{
				bytes_0[int_1] = -117;
			}
			else if (char_0 == 338)
			{
				bytes_0[int_1] = -116;
			}
			else if (char_0 == 381)
			{
				bytes_0[int_1] = -114;
			}
			else if (char_0 == 8216)
			{
				bytes_0[int_1] = -111;
			}
			else if (char_0 == 8217)
			{
				bytes_0[int_1] = -110;
			}
			else if (char_0 == 8220)
			{
				bytes_0[int_1] = -109;
			}
			else if (char_0 == 8221)
			{
				bytes_0[int_1] = -108;
			}
			else if (char_0 == 8226)
			{
				bytes_0[int_1] = -107;
			}
			else if (char_0 == 8211)
			{
				bytes_0[int_1] = -106;
			}
			else if (char_0 == 8212)
			{
				bytes_0[int_1] = -105;
			}
			else if (char_0 == 732)
			{
				bytes_0[int_1] = -104;
			}
			else if (char_0 == 8482)
			{
				bytes_0[int_1] = -103;
			}
			else if (char_0 == 353)
			{
				bytes_0[int_1] = -102;
			}
			else if (char_0 == 8250)
			{
				bytes_0[int_1] = -101;
			}
			else if (char_0 == 339)
			{
				bytes_0[int_1] = -100;
			}
			else if (char_0 == 382)
			{
				bytes_0[int_1] = -98;
			}
			else if (char_0 == 376)
			{
				bytes_0[int_1] = -97;
			}
			else
			{
				bytes_0[int_1] = 63;
			}
		}

		return bytes_0;
	}

}
