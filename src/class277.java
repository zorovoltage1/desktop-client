public class class277
{

	public static int djb2Hash(final CharSequence charsequence_0)
	{
		final int int_0 = charsequence_0.length();
		int int_1 = 0;

		for (int int_2 = 0; int_2 < int_0; int_2++)
		{
			int_1 = ((int_1 << 5) - int_1) + class166.charToByteCp1252(charsequence_0.charAt(int_2));
		}

		return int_1;
	}

}
