public class class183
{

	static int field2344;
	static int field2346;
	static int field2342;
	static byte[][] field2340;
	static byte[][] field2343;
	static byte[][] field2345;
	static int[] field2348;
	static int[] field2347;
	static byte[][][] field2341;

	static
	{
		field2344 = 0;
		field2346 = 0;
		field2342 = 0;
		field2340 = new byte[1000][];
		field2343 = new byte[250][];
		field2345 = new byte[50][];
	}

	static synchronized byte[] method3773(final int int_0, final boolean bool_0)
	{
		byte[] bytes_0;
		if (int_0 != 100)
		{
			if (int_0 < 100)
			{
            }
		}
		else if (field2344 > 0)
		{
			bytes_0 = field2340[--field2344];
			field2340[field2344] = null;
			return bytes_0;
		}

		if (int_0 != 5000)
		{
			if (int_0 < 5000)
			{
            }
		}
		else if (field2346 > 0)
		{
			bytes_0 = field2343[--field2346];
			field2343[field2346] = null;
			return bytes_0;
		}

		if (int_0 != 30000)
		{
			if (int_0 < 30000)
			{
            }
		}
		else if (field2342 > 0)
		{
			bytes_0 = field2345[--field2342];
			field2345[field2342] = null;
			return bytes_0;
		}

		if (field2341 != null)
		{
			for (int int_1 = 0; int_1 < field2348.length; int_1++)
			{
				if (field2348[int_1] != int_0)
				{
					if (int_0 < field2348[int_1])
					{
                    }
				}
				else if (field2347[int_1] > 0)
				{
					final byte[] bytes_1 = field2341[int_1][--field2347[int_1]];
					field2341[int_1][field2347[int_1]] = null;
					return bytes_1;
				}
			}
		}

		return new byte[int_0];
	}

}
