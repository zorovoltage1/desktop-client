public class class120
{

	public static boolean Viewport_containsMouse;
	static int Viewport_mouseX;
	static int Viewport_mouseY;
	static boolean Viewport_false0;
	static int field1657;
	static int field1659;
	static int field1651;
	static int field1654;
	static int field1655;
	public static int Viewport_entityCountAtMouse;
	public static long[] field1647;

	static
	{
		Viewport_containsMouse = false;
		Viewport_mouseX = 0;
		Viewport_mouseY = 0;
		Viewport_false0 = false;
		Viewport_entityCountAtMouse = 0;
		field1647 = new long[1000];
	}

	static void method2781(final int int_0, final int int_1, final int int_2, final boolean bool_0, final int int_3,
	        final boolean bool_1)
	{
		if (int_0 < int_1)
		{
			final int int_4 = (int_0 + int_1) / 2;
			int int_5 = int_0;
			final World world_0 = World.worldList[int_4];
			World.worldList[int_4] = World.worldList[int_1];
			World.worldList[int_1] = world_0;

			for (int int_6 = int_0; int_6 < int_1; int_6++)
			{
				if (CacheFile.method2503(World.worldList[int_6], world_0, int_2, bool_0, int_3, bool_1) <= 0)
				{
					final World world_1 = World.worldList[int_6];
					World.worldList[int_6] = World.worldList[int_5];
					World.worldList[int_5++] = world_1;
				}
			}

			World.worldList[int_1] = World.worldList[int_5];
			World.worldList[int_5] = world_0;
			method2781(int_0, int_5 - 1, int_2, bool_0, int_3, bool_1);
			method2781(int_5 + 1, int_1, int_2, bool_0, int_3, bool_1);
		}

	}

}
