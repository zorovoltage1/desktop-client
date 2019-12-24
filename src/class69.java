import java.util.Calendar;

public class class69
{

	static int[] field1005;
	static int[] field1000;
	static int[][] SHAPE_VERTICES;
	static int[] intStack;
	static int intStackSize;
	static String[] scriptStringStack;
	static SoundTask task;
	static int scriptStackCount;
	static class51[] scriptStack;
	static Calendar field1007;
	static final String[] field998;
	static int field1009;

	static
	{
		field1000 = new int[5];
		SHAPE_VERTICES = new int[5][5000];
		intStack = new int[1000];
		scriptStringStack = new String[1000];
		scriptStackCount = 0;
		scriptStack = new class51[50];
		field1007 = Calendar.getInstance();
		field998 = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		field1009 = 0;
	}

}
