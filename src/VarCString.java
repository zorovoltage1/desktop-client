public class VarCString extends CacheableNode
{

	public static IndexDataBase field3264;
	static NodeCache field3260;
	static int field3259;
	public boolean field3261;

	static
	{
		field3260 = new NodeCache(64);
	}

	VarCString()
	{
		field3261 = false;
	}

	void method4852(final Buffer buffer_0)
	{
		while (true)
		{
			final int int_0 = buffer_0.readUnsignedByte();
			if (int_0 == 0)
			{
				return;
			}

			method4854(buffer_0, int_0);
		}
	}

	void method4854(final Buffer buffer_0, final int int_0)
	{
		if (int_0 == 2)
		{
			field3261 = true;
		}

	}

	public static void method4851(final IndexDataBase indexdatabase_0, final IndexDataBase indexdatabase_1)
	{
		KitDefinition.identKit_ref = indexdatabase_0;
		KitDefinition.field3290 = indexdatabase_1;
		KitDefinition.field3294 = KitDefinition.identKit_ref.fileCount(3);
	}

}
