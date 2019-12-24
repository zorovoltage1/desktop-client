public class class264 extends CacheableNode
{

	public static IndexDataBase field3327;
	public static NodeCache field3328;
	char field3331;
	public int field3330;
	public String field3333;
	boolean field3332;

	static
	{
		field3328 = new NodeCache(64);
	}

	class264()
	{
		field3332 = true;
	}

	void method4954()
	{
	}

	void method4948(final Buffer buffer_0)
	{
		while (true)
		{
			final int int_0 = buffer_0.readUnsignedByte();
			if (int_0 == 0)
			{
				return;
			}

			method4950(buffer_0, int_0);
		}
	}

	void method4950(final Buffer buffer_0, final int int_0)
	{
		if (int_0 == 1)
		{
			final byte byte_0 = buffer_0.readByte();
			int int_1 = byte_0 & 0xFF;
			if (int_1 == 0)
			{
				throw new IllegalArgumentException("");
			}

			if ((int_1 >= 128) && (int_1 < 160))
			{
				char char_0 = class301.cp1252AsciiExtension[int_1 - 128];
				if (char_0 == 0)
				{
					char_0 = 63;
				}

				int_1 = char_0;
			}

			final char char_1 = (char) int_1;
			field3331 = char_1;
		}
		else if (int_0 == 2)
		{
			field3330 = buffer_0.readInt();
		}
		else if (int_0 == 4)
		{
			field3332 = false;
		}
		else if (int_0 == 5)
		{
			field3333 = buffer_0.readString();
		}

	}

	public boolean method4951()
	{
		return field3331 == 115;
	}

}
