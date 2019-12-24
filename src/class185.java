public class class185
{

	static final int[] field2361;
	static final int[] field2362;
	public static Buffer NetCache_reference;
	static int[] field2364;

	static
	{
		field2361 = new int[2048];
		field2362 = new int[2048];
		final double double_0 = 0.0030679615757712823D;

		for (int int_0 = 0; int_0 < 2048; int_0++)
		{
			field2361[int_0] = (int) (65536.0D * Math.sin(double_0 * int_0));
			field2362[int_0] = (int) (65536.0D * Math.cos(double_0 * int_0));
		}

	}

	public static void method3787()
	{
		if (MouseInput.mouse != null)
		{
			synchronized (MouseInput.mouse)
			{
				MouseInput.mouse = null;
			}
		}

	}

	public static int method3786(final boolean bool_0, final boolean bool_1)
	{
		final byte byte_0 = 0;
		final int int_0 = byte_0 + class250.NetCache_pendingPriorityResponsesCount
		        + class250.NetCache_pendingPriorityWritesCount;
		return int_0;
	}

}
