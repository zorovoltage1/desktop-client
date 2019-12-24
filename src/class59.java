public class class59 extends class166
{

	static IndexData vorbisIndex;

	@Override
	protected boolean vmethod3440(final int int_0, final int int_1, final int int_2,
	        final CollisionData collisiondata_0)
	{
		return (int_1 == super.field2043) && (int_2 == super.field2048);
	}

	static String method1076()
	{
		return class10.preferences.hideUsername ? class265.method4976(class78.username) : class78.username;
	}

	static void method1079()
	{
		if (class78.field1101)
		{
			class78.field1083 = null;
			class78.field1084 = null;
			class78.runeSprites = null;
			class78.field1092 = null;
			class78.field1087 = null;
			FrameMap.titlemuteSprite = null;
			class235.field2783 = null;
			class78.field1089 = null;
			class166.field2047 = null;
			class13.slFlagSprites = null;
			class126.slArrowSprites = null;
			MapIcon.slStarSprites = null;
			class232.field2752 = null;
			CombatInfo1.field936 = null;
			class185.field2364 = null;
			class11.field69 = null;
			AttackOption.field1077 = null;
			AbstractByteBuffer.field2367 = null;
			class81.field1169 = null;
			SoundTaskDataProvider.field357 = null;
			class76.field1073 = null;
			class26.method427(2);
			class222.sendConInfo(true);
			class78.field1101 = false;
		}
	}

	static byte[] method1075(final byte[] bytes_0)
	{
		final int int_0 = bytes_0.length;
		final byte[] bytes_1 = new byte[int_0];
		System.arraycopy(bytes_0, 0, bytes_1, 0, int_0);
		return bytes_1;
	}

	static void method1078()
	{
		if (GrandExchangeOffer.loadWorlds())
		{
			class78.worldSelectShown = true;
		}

	}

	static void method1080(final Actor actor_0, final int int_0)
	{
		if (actor_0.field917 > Game.gameCycle)
		{
			final int int_1 = actor_0.field917 - Game.gameCycle;
			final int int_2 = (actor_0.field913 * 128) + (actor_0.field874 * 64);
			final int int_3 = (actor_0.field915 * 128) + (actor_0.field874 * 64);
			actor_0.x += (int_2 - actor_0.x) / int_1;
			actor_0.y += (int_3 - actor_0.y) / int_1;
			actor_0.field923 = 0;
			actor_0.orientation = actor_0.field919;
		}
		else if (actor_0.field918 >= Game.gameCycle)
		{
			Item.method1865(actor_0);
		}
		else
		{
			class35.method609(actor_0);
		}

		if ((actor_0.x < 128) || (actor_0.y < 128) || (actor_0.x >= 13184) || (actor_0.y >= 13184))
		{
			actor_0.animation = -1;
			actor_0.graphic = -1;
			actor_0.field917 = 0;
			actor_0.field918 = 0;
			actor_0.x = (actor_0.pathX[0] * 128) + (actor_0.field874 * 64);
			actor_0.y = (actor_0.pathY[0] * 128) + (actor_0.field874 * 64);
			actor_0.method1540();
		}

		if ((class138.localPlayer == actor_0)
		        && ((actor_0.x < 1536) || (actor_0.y < 1536) || (actor_0.x >= 11776) || (actor_0.y >= 11776)))
		{
			actor_0.animation = -1;
			actor_0.graphic = -1;
			actor_0.field917 = 0;
			actor_0.field918 = 0;
			actor_0.x = (actor_0.pathX[0] * 128) + (actor_0.field874 * 64);
			actor_0.y = (actor_0.pathY[0] * 128) + (actor_0.field874 * 64);
			actor_0.method1540();
		}

		TotalQuantityComparator.method26(actor_0);
		FontName.method5502(actor_0);
	}

	static void method1077()
	{
		Game.menuOptionCount = 0;
		Game.isMenuOpen = false;
		Game.menuOptions[0] = "Cancel";
		Game.menuTargets[0] = "";
		Game.menuTypes[0] = 1006;
		Game.menuBooleanArray[0] = false;
		Game.menuOptionCount = 1;
	}

}
