public class class52
{

	final IndexData field469;
	final int field468;
	int field467;

	class52(final IndexData indexdata_0, final String string_0)
	{
		field467 = 0;
		field469 = indexdata_0;
		field468 = indexdata_0.size();
	}

	boolean method1000()
	{
		field467 = 0;

		for (int int_0 = 0; int_0 < field468; int_0++)
		{
			if (!field469.method4734(int_0) || field469.method4725(int_0))
			{
				++field467;
			}
		}

		return field467 >= field468;
	}

	public static boolean method1002(final char char_0)
	{
		return (char_0 >= 32) && (char_0 <= 126) || ((char_0 >= 160) && (char_0 <= 255) || ((char_0 == 8364) || (char_0 == 338) || (char_0 == 8212) || (char_0 == 339)
                || (char_0 == 376)));
	}

}
