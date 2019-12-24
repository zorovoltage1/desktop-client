public abstract class class166
{

	static SpritePixels[] field2047;
	public int field2043;
	public int field2048;
	public int field2042;
	public int field2045;

	protected abstract boolean vmethod3440(int var1, int var2, int var3, CollisionData var4);

	public static byte charToByteCp1252(final char char_0)
	{
		byte byte_0;
		if (((char_0 > 0) && (char_0 < 128)) || ((char_0 >= 160) && (char_0 <= 255)))
		{
			byte_0 = (byte) char_0;
		}
		else if (char_0 == 8364)
		{
			byte_0 = -128;
		}
		else if (char_0 == 8218)
		{
			byte_0 = -126;
		}
		else if (char_0 == 402)
		{
			byte_0 = -125;
		}
		else if (char_0 == 8222)
		{
			byte_0 = -124;
		}
		else if (char_0 == 8230)
		{
			byte_0 = -123;
		}
		else if (char_0 == 8224)
		{
			byte_0 = -122;
		}
		else if (char_0 == 8225)
		{
			byte_0 = -121;
		}
		else if (char_0 == 710)
		{
			byte_0 = -120;
		}
		else if (char_0 == 8240)
		{
			byte_0 = -119;
		}
		else if (char_0 == 352)
		{
			byte_0 = -118;
		}
		else if (char_0 == 8249)
		{
			byte_0 = -117;
		}
		else if (char_0 == 338)
		{
			byte_0 = -116;
		}
		else if (char_0 == 381)
		{
			byte_0 = -114;
		}
		else if (char_0 == 8216)
		{
			byte_0 = -111;
		}
		else if (char_0 == 8217)
		{
			byte_0 = -110;
		}
		else if (char_0 == 8220)
		{
			byte_0 = -109;
		}
		else if (char_0 == 8221)
		{
			byte_0 = -108;
		}
		else if (char_0 == 8226)
		{
			byte_0 = -107;
		}
		else if (char_0 == 8211)
		{
			byte_0 = -106;
		}
		else if (char_0 == 8212)
		{
			byte_0 = -105;
		}
		else if (char_0 == 732)
		{
			byte_0 = -104;
		}
		else if (char_0 == 8482)
		{
			byte_0 = -103;
		}
		else if (char_0 == 353)
		{
			byte_0 = -102;
		}
		else if (char_0 == 8250)
		{
			byte_0 = -101;
		}
		else if (char_0 == 339)
		{
			byte_0 = -100;
		}
		else if (char_0 == 382)
		{
			byte_0 = -98;
		}
		else if (char_0 == 376)
		{
			byte_0 = -97;
		}
		else
		{
			byte_0 = 63;
		}

		return byte_0;
	}

}
