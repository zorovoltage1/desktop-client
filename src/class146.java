public enum class146 implements Enumerated
{

	field1908(3, 0), field1910(1, 1), field1907(2, 2), field1905(0, 3);

	public final int field1909;
	final int field1906;

	class146(final int int_1, final int int_2)
	{
		field1909 = int_1;
		field1906 = int_2;
	}

	@Override
	public int vmethod5815()
	{
		return field1906;
	}

	public static int nextPowerOfTwo(int int_0)
	{
		--int_0;
		int_0 |= int_0 >>> 1;
		int_0 |= int_0 >>> 2;
		int_0 |= int_0 >>> 4;
		int_0 |= int_0 >>> 8;
		int_0 |= int_0 >>> 16;
		return int_0 + 1;
	}

	public static Widget getWidgetChild(final int int_0, final int int_1)
	{
		final Widget widget_0 = Widget.getWidget(int_0);
		return int_1 == -1 ? widget_0
		        : ((widget_0 != null) && (widget_0.children != null) && (int_1 < widget_0.children.length)
		                ? widget_0.children[int_1]
		                : null);
	}

	public static void method3190(final Buffer buffer_0, final int int_0)
	{
		if (class155.randomDat != null)
		{
			try
			{
				class155.randomDat.seek(0L);
				class155.randomDat.write(buffer_0.payload, int_0, 24);
			}
			catch (final Exception exception_0)
			{
            }
		}

	}

}
