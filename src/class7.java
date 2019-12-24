import java.util.Comparator;

final class class7 implements Comparator
{

	public static IndexDataBase field42;
	static int[] indexedSpriteOffsetXs;
	static int cameraPitch;

	int method76(final GrandExchangeEvent grandexchangeevent_0, final GrandExchangeEvent grandexchangeevent_1)
	{
		return grandexchangeevent_0.field20 < grandexchangeevent_1.field20 ? -1
		        : (grandexchangeevent_1.field20 == grandexchangeevent_0.field20 ? 0 : 1);
	}

	@Override
	public boolean equals(final Object object_0)
	{
		return super.equals(object_0);
	}

	@Override
	public int compare(final Object object_0, final Object object_1)
	{
		return method76((GrandExchangeEvent) object_0, (GrandExchangeEvent) object_1);
	}

	public static boolean method83(final int int_0)
	{
		return ((int_0 >> 28) & 0x1) != 0;
	}

}
