public class VarPlayerType extends CacheableNode
{

	public static int field3232;
	public static NodeCache varplayers;
	public int configType;

	static
	{
		varplayers = new NodeCache(64);
	}

	VarPlayerType()
	{
		configType = 0;
	}

	void decode(final Buffer buffer_0)
	{
		while (true)
		{
			final int int_0 = buffer_0.readUnsignedByte();
			if (int_0 == 0)
			{
				return;
			}

			this.decode(buffer_0, int_0);
		}
	}

	void decode(final Buffer buffer_0, final int int_0)
	{
		if (int_0 == 5)
		{
			configType = buffer_0.readUnsignedShort();
		}

	}

}
