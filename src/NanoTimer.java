public class NanoTimer extends Timer
{

	long nanoTime;

	NanoTimer()
	{
		nanoTime = System.nanoTime();
	}

	@Override
	public void vmethod3330()
	{
		nanoTime = System.nanoTime();
	}

	@Override
	public int vmethod3331(final int int_0, final int int_1)
	{
		final long long_0 = 1000000L * int_1;
		long long_1 = nanoTime - System.nanoTime();
		if (long_1 < long_0)
		{
			long_1 = long_0;
		}

		Actor.method1539(long_1 / 1000000L);
		final long long_2 = System.nanoTime();

		int int_2;
		for (int_2 = 0; (int_2 < 10) && ((int_2 < 1) || (nanoTime < long_2)); nanoTime += 1000000L * int_0)
		{
			++int_2;
		}

		if (nanoTime < long_2)
		{
			nanoTime = long_2;
		}

		return int_2;
	}

}
