public class ContextMenuRow
{

	public static String osNameLC;
	int type;
	int param0;
	int param1;
	int identifier;
	String option;

	public static int method1802(final int int_0, final int int_1, int int_2)
	{
		int_2 &= 0x3;
		return int_2 == 0 ? int_1 : (int_2 == 1 ? 7 - int_0 : (int_2 == 2 ? 7 - int_1 : int_0));
	}

}
