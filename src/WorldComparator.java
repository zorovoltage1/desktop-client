import java.util.Comparator;

final class WorldComparator implements Comparator
{

	public static IndexDataBase varplayer_ref;
	static int menuY;

	int method1(final GrandExchangeEvent grandexchangeevent_0, final GrandExchangeEvent grandexchangeevent_1)
	{
		return grandexchangeevent_0.world < grandexchangeevent_1.world ? -1
		        : (grandexchangeevent_1.world == grandexchangeevent_0.world ? 0 : 1);
	}

	@Override
	public int compare(final Object object_0, final Object object_1)
	{
		return method1((GrandExchangeEvent) object_0, (GrandExchangeEvent) object_1);
	}

	@Override
	public boolean equals(final Object object_0)
	{
		return super.equals(object_0);
	}

	public static void method7()
	{
		WorldMapRegion.field188.method3999(5);
		WorldMapRegion.field189.method3999(5);
	}

}
