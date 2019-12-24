public class class220
{

	static final byte[] field2527;
	Buffer field2530;
	int field2519;
	int[] field2520;
	int[] field2521;
	int[] field2525;
	int[] field2523;
	int field2524;
	long field2526;

	static
	{
		field2527 = new byte[] { (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2,
		        (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2,
		        (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2,
		        (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2,
		        (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2,
		        (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2,
		        (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 1, (byte) 1, (byte) 1, (byte) 1,
		        (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1,
		        (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1,
		        (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 2, (byte) 2,
		        (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2,
		        (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 0, (byte) 1, (byte) 2, (byte) 1, (byte) 0, (byte) 0,
		        (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0 };
	}

	class220(final byte[] bytes_0)
	{
		field2530 = new Buffer(null);
		method4328(bytes_0);
	}

	class220()
	{
		field2530 = new Buffer(null);
	}

	void method4328(final byte[] bytes_0)
	{
		field2530.payload = bytes_0;
		field2530.offset = 10;
		final int int_0 = field2530.readUnsignedShort();
		field2519 = field2530.readUnsignedShort();
		field2524 = 500000;
		field2520 = new int[int_0];

		int int_1;
		int int_3;
		for (int_1 = 0; int_1 < int_0; field2530.offset += int_3)
		{
			final int int_2 = field2530.readInt();
			int_3 = field2530.readInt();
			if (int_2 == 1297379947)
			{
				field2520[int_1] = field2530.offset;
				++int_1;
			}
		}

		field2526 = 0L;
		field2521 = new int[int_0];

		for (int_1 = 0; int_1 < int_0; int_1++)
		{
			field2521[int_1] = field2520[int_1];
		}

		field2525 = new int[int_0];
		field2523 = new int[int_0];
	}

	void method4329()
	{
		field2530.payload = null;
		field2520 = null;
		field2521 = null;
		field2525 = null;
		field2523 = null;
	}

	boolean method4345()
	{
		return field2530.payload != null;
	}

	int method4331()
	{
		return field2521.length;
	}

	void method4350(final int int_0)
	{
		field2530.offset = field2521[int_0];
	}

	void method4333(final int int_0)
	{
		field2521[int_0] = field2530.offset;
	}

	void method4334()
	{
		field2530.offset = -1;
	}

	void method4335(final int int_0)
	{
		final int int_1 = field2530.readVarInt();
		field2525[int_0] += int_1;
	}

	int method4336(final int int_0)
	{
		final int int_1 = method4327(int_0);
		return int_1;
	}

	int method4327(final int int_0)
	{
		final byte byte_0 = field2530.payload[field2530.offset];
		int int_3;
		if (byte_0 < 0)
		{
			int_3 = byte_0 & 0xFF;
			field2523[int_0] = int_3;
			++field2530.offset;
		}
		else
		{
			int_3 = field2523[int_0];
		}

		if ((int_3 != 240) && (int_3 != 247))
		{
			return method4337(int_0, int_3);
		}
		else
		{
			final int int_1 = field2530.readVarInt();
			if ((int_3 == 247) && (int_1 > 0))
			{
				final int int_2 = field2530.payload[field2530.offset] & 0xFF;
				if (((int_2 >= 241) && (int_2 <= 243)) || (int_2 == 246) || (int_2 == 248)
				        || ((int_2 >= 250) && (int_2 <= 252)) || (int_2 == 254))
				{
					++field2530.offset;
					field2523[int_0] = int_2;
					return method4337(int_0, int_2);
				}
			}

			field2530.offset += int_1;
			return 0;
		}
	}

	int method4337(final int int_0, final int int_1)
	{
		int int_2;
		if (int_1 == 255)
		{
			final int int_5 = field2530.readUnsignedByte();
			int_2 = field2530.readVarInt();
			if (int_5 == 47)
			{
				field2530.offset += int_2;
				return 1;
			}
			else if (int_5 == 81)
			{
				final int int_3 = field2530.read24BitInt();
				int_2 -= 3;
				final int int_4 = field2525[int_0];
				field2526 += (long) int_4 * (long) (field2524 - int_3);
				field2524 = int_3;
				field2530.offset += int_2;
				return 2;
			}
			else
			{
				field2530.offset += int_2;
				return 3;
			}
		}
		else
		{
			final byte byte_0 = field2527[int_1 - 128];
			int_2 = int_1;
			if (byte_0 >= 1)
			{
				int_2 = int_1 | (field2530.readUnsignedByte() << 8);
			}

			if (byte_0 >= 2)
			{
				int_2 |= field2530.readUnsignedByte() << 16;
			}

			return int_2;
		}
	}

	long method4338(final int int_0)
	{
		return field2526 + ((long) int_0 * (long) field2524);
	}

	int method4339()
	{
		final int int_0 = field2521.length;
		int int_1 = -1;
		int int_2 = Integer.MAX_VALUE;

		for (int int_3 = 0; int_3 < int_0; int_3++)
		{
			if ((field2521[int_3] >= 0) && (field2525[int_3] < int_2))
			{
				int_1 = int_3;
				int_2 = field2525[int_3];
			}
		}

		return int_1;
	}

	boolean method4340()
	{
		final int int_0 = field2521.length;

		for (int int_1 = 0; int_1 < int_0; int_1++)
		{
			if (field2521[int_1] >= 0)
			{
				return false;
			}
		}

		return true;
	}

	void method4341(final long long_0)
	{
		field2526 = long_0;
		final int int_0 = field2521.length;

		for (int int_1 = 0; int_1 < int_0; int_1++)
		{
			field2525[int_1] = 0;
			field2523[int_1] = 0;
			field2530.offset = field2520[int_1];
			method4335(int_1);
			field2521[int_1] = field2530.offset;
		}

	}

}
