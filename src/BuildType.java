public class BuildType
{

	static final BuildType RC;
	static final BuildType WIP;
	static final BuildType LIVE;
	static final BuildType BUILD_LIVE;
	static int[] field3137;
	public static int canvasHeight;
	static IndexedSprite[] scrollbarSprites;
	public final String identifier;
	final int field3133;

	static
	{
		RC = new BuildType("LIVE", 0);
		WIP = new BuildType("BUILDLIVE", 3);
		LIVE = new BuildType("RC", 1);
		BUILD_LIVE = new BuildType("WIP", 2);
	}

	BuildType(final String string_0, final int int_0)
	{
		identifier = string_0;
		field3133 = int_0;
	}

	static void method4612(final String string_0, final String string_1, final int int_0, final int int_1,
	        final int int_2, final int int_3, final boolean bool_0)
	{
		if (!Game.isMenuOpen)
		{
			if (Game.menuOptionCount < 500)
			{
				Game.menuOptions[Game.menuOptionCount] = string_0;
				Game.menuTargets[Game.menuOptionCount] = string_1;
				Game.menuTypes[Game.menuOptionCount] = int_0;
				Game.menuIdentifiers[Game.menuOptionCount] = int_1;
				Game.menuActionParams0[Game.menuOptionCount] = int_2;
				Game.menuActionParams1[Game.menuOptionCount] = int_3;
				Game.menuBooleanArray[Game.menuOptionCount] = bool_0;
				++Game.menuOptionCount;
			}

		}
	}

}
