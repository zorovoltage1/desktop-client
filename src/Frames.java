public class Frames extends CacheableNode
{

	public static IndexDataBase field1801;
	static String[] field1800;
	Frame[] skeletons;

	public Frames(final IndexDataBase indexdatabase_0, final IndexDataBase indexdatabase_1, final int int_0,
	        final boolean bool_0)
	{
		final Deque deque_0 = new Deque();
		final int int_1 = indexdatabase_0.fileCount(int_0);
		skeletons = new Frame[int_1];
		final int[] ints_0 = indexdatabase_0.getChilds(int_0);

		for (int int_2 = 0; int_2 < ints_0.length; int_2++)
		{
			final byte[] bytes_0 = indexdatabase_0.getConfigData(int_0, ints_0[int_2]);
			FrameMap framemap_0 = null;
			final int int_3 = ((bytes_0[0] & 0xFF) << 8) | (bytes_0[1] & 0xFF);

			for (FrameMap framemap_1 = (FrameMap) deque_0
			        .getFront(); framemap_1 != null; framemap_1 = (FrameMap) deque_0.getNext())
			{
				if (int_3 == framemap_1.id)
				{
					framemap_0 = framemap_1;
					break;
				}
			}

			if (framemap_0 == null)
			{
				final byte[] bytes_1 = indexdatabase_1.getChild(int_3, 0);
				framemap_0 = new FrameMap(int_3, bytes_1);
				deque_0.addFront(framemap_0);
			}

			skeletons[ints_0[int_2]] = new Frame(bytes_0, framemap_0);
		}

	}

	public boolean method3075(final int int_0)
	{
		return skeletons[int_0].showing;
	}

	public static InvType method3074(final int int_0)
	{
		InvType invtype_0 = (InvType) InvType.inventoryCache.get(int_0);
		if (invtype_0 != null)
		{
			return invtype_0;
		}
		else
		{
			final byte[] bytes_0 = InvType.field3226.getConfigData(5, int_0);
			invtype_0 = new InvType();
			if (bytes_0 != null)
			{
				invtype_0.decode(new Buffer(bytes_0));
			}

			InvType.inventoryCache.put(invtype_0, int_0);
			return invtype_0;
		}
	}

	static void method3077(final int int_0)
	{
		for (IntegerNode integernode_0 = (IntegerNode) Game.widgetFlags
		        .first(); integernode_0 != null; integernode_0 = (IntegerNode) Game.widgetFlags.next())
		{
			if (int_0 == ((integernode_0.hash >> 48) & 0xFFFFL))
			{
				integernode_0.unlink();
			}
		}

	}

}
