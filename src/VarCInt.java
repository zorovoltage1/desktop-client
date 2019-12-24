public class VarCInt extends CacheableNode
{

	static IndexDataBase field3258;
	static NodeCache field3257;
	public boolean field3256;

	static
	{
		field3257 = new NodeCache(64);
	}

	VarCInt()
	{
		field3256 = false;
	}

	void method4848(final Buffer buffer_0)
	{
		while (true)
		{
			final int int_0 = buffer_0.readUnsignedByte();
			if (int_0 == 0)
			{
				return;
			}

			method4839(buffer_0, int_0);
		}
	}

	void method4839(final Buffer buffer_0, final int int_0)
	{
		if (int_0 == 2)
		{
			field3256 = true;
		}

	}

}
