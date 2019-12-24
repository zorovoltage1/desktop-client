public class class143 extends class283
{

	static class307 field1899;
	static int[] mapRegions;
	static Widget field1897;
	final boolean field1893;

	public class143(final boolean bool_0)
	{
		field1893 = bool_0;
	}

	int method3165(final ChatPlayer chatplayer_0, final ChatPlayer chatplayer_1)
	{
		return chatplayer_1.world != chatplayer_0.world
		        ? (field1893 ? chatplayer_0.world - chatplayer_1.world : chatplayer_1.world - chatplayer_0.world)
		        : method5308(chatplayer_0, chatplayer_1);
	}

	@Override
	public int compare(final Object object_0, final Object object_1)
	{
		return method3165((ChatPlayer) object_0, (ChatPlayer) object_1);
	}

	static void sendGameMessage(final int int_0, final String string_0, final String string_1)
	{
		class173.addChatMessage(int_0, string_0, string_1, null);
	}

	public static int method3167(final double double_0, final double double_1, final double double_2)
	{
		double double_3 = double_2;
		double double_4 = double_2;
		double double_5 = double_2;
		if (double_1 != 0.0D)
		{
			double double_6;
			if (double_2 < 0.5D)
			{
				double_6 = double_2 * (double_1 + 1.0D);
			}
			else
			{
				double_6 = (double_2 + double_1) - (double_1 * double_2);
			}

			final double double_7 = (2.0D * double_2) - double_6;
			double double_8 = double_0 + 0.3333333333333333D;
			if (double_8 > 1.0D)
			{
				--double_8;
			}

			double double_9 = double_0 - 0.3333333333333333D;
			if (double_9 < 0.0D)
			{
				++double_9;
			}

			if ((6.0D * double_8) < 1.0D)
			{
				double_3 = double_7 + (double_8 * 6.0D * (double_6 - double_7));
			}
			else if ((double_8 * 2.0D) < 1.0D)
			{
				double_3 = double_6;
			}
			else if ((double_8 * 3.0D) < 2.0D)
			{
				double_3 = double_7 + (6.0D * (0.6666666666666666D - double_8) * (double_6 - double_7));
			}
			else
			{
				double_3 = double_7;
			}

			if ((double_0 * 6.0D) < 1.0D)
			{
				double_4 = double_7 + (double_0 * 6.0D * (double_6 - double_7));
			}
			else if ((2.0D * double_0) < 1.0D)
			{
				double_4 = double_6;
			}
			else if ((3.0D * double_0) < 2.0D)
			{
				double_4 = (6.0D * (0.6666666666666666D - double_0) * (double_6 - double_7)) + double_7;
			}
			else
			{
				double_4 = double_7;
			}

			if ((double_9 * 6.0D) < 1.0D)
			{
				double_5 = ((double_6 - double_7) * 6.0D * double_9) + double_7;
			}
			else if ((2.0D * double_9) < 1.0D)
			{
				double_5 = double_6;
			}
			else if ((3.0D * double_9) < 2.0D)
			{
				double_5 = ((double_6 - double_7) * (0.6666666666666666D - double_9) * 6.0D) + double_7;
			}
			else
			{
				double_5 = double_7;
			}
		}

		final int int_0 = (int) (double_3 * 256.0D);
		final int int_1 = (int) (double_4 * 256.0D);
		final int int_2 = (int) (256.0D * double_5);
		final int int_3 = int_2 + (int_1 << 8) + (int_0 << 16);
		return int_3;
	}

	public static int ilog(int int_0)
	{
		int int_1 = 0;
		if ((int_0 < 0) || (int_0 >= 65536))
		{
			int_0 >>>= 16;
			int_1 += 16;
		}

		if (int_0 >= 256)
		{
			int_0 >>>= 8;
			int_1 += 8;
		}

		if (int_0 >= 16)
		{
			int_0 >>>= 4;
			int_1 += 4;
		}

		if (int_0 >= 4)
		{
			int_0 >>>= 2;
			int_1 += 2;
		}

		if (int_0 >= 1)
		{
			int_0 >>>= 1;
			++int_1;
		}

		return int_0 + int_1;
	}

}
