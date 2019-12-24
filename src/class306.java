public class class306
{

	static boolean method5660(final IndexDataBase indexdatabase_0, final int int_0, final int int_1)
	{
		final byte[] bytes_0 = indexdatabase_0.getConfigData(int_0, int_1);
		if (bytes_0 == null)
		{
			return false;
		}
		else
		{
			ObjectComposition.decodeSprite(bytes_0);
			return true;
		}
	}

}
