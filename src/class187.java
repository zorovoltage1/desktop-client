public class class187
{

	static int field2372;

	public static int method3812(final byte[] bytes_0, final int int_0, final int int_1)
	{
		int int_2 = -1;

		for (int int_3 = int_0; int_3 < int_1; int_3++)
		{
			int_2 = (int_2 >>> 8) ^ Buffer.crc32Table[(int_2 ^ bytes_0[int_3]) & 0xFF];
		}

		int_2 = ~int_2;
		return int_2;
	}

}
