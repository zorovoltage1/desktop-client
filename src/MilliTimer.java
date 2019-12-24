public class MilliTimer extends Timer
{

	static int field1928;
	static SpritePixels[] headIconsPk;
	static SpritePixels[] headIconsHint;
	long[] field1922;
	int field1920;
	int sleepTime;
	long field1925;
	int field1923;
	int field1924;

	MilliTimer()
	{
		field1922 = new long[10];
		field1920 = 256;
		sleepTime = 1;
		field1923 = 0;
		field1925 = Buffer.safeCurrentTimeMillis();

		for (int int_0 = 0; int_0 < 10; int_0++)
		{
			field1922[int_0] = field1925;
		}

	}

	@Override
	public void vmethod3330()
	{
		for (int int_0 = 0; int_0 < 10; int_0++)
		{
			field1922[int_0] = 0L;
		}

	}

	@Override
	public int vmethod3331(final int int_0, final int int_1)
	{
		final int int_2 = field1920;
		final int int_3 = sleepTime;
		field1920 = 300;
		sleepTime = 1;
		field1925 = Buffer.safeCurrentTimeMillis();
		if (field1922[field1924] == 0L)
		{
			field1920 = int_2;
			sleepTime = int_3;
		}
		else if (field1925 > field1922[field1924])
		{
			field1920 = (int) (int_0 * 2560 / (field1925 - field1922[field1924]));
		}

		if (field1920 < 25)
		{
			field1920 = 25;
		}

		if (field1920 > 256)
		{
			field1920 = 256;
			sleepTime = (int) (int_0 - ((field1925 - field1922[field1924]) / 10L));
		}

		if (sleepTime > int_0)
		{
			sleepTime = int_0;
		}

		field1922[field1924] = field1925;
		field1924 = (field1924 + 1) % 10;
		int int_4;
		if (sleepTime > 1)
		{
			for (int_4 = 0; int_4 < 10; int_4++)
			{
				if (field1922[int_4] != 0L)
				{
					field1922[int_4] += sleepTime;
				}
			}
		}

		if (sleepTime < int_1)
		{
			sleepTime = int_1;
		}

		Actor.method1539(sleepTime);

		for (int_4 = 0; field1923 < 256; field1923 += field1920)
		{
			++int_4;
		}

		field1923 &= 0xFF;
		return int_4;
	}

}
