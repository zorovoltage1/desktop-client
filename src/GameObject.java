public final class GameObject
{

	public Renderable renderable;
	int plane;
	int height;
	int x;
	int y;
	int field1845;
	int relativeX;
	int offsetX;
	int relativeY;
	int offsetY;
	int drawPriority;
	int cycle;
	public long field1848;
	int field1849;

	GameObject()
	{
		field1848 = 0L;
		field1849 = 0;
	}

	static Script method3104(final int int_0, final int int_1)
	{
		Script script_0 = (Script) Script.field1190.get(int_0 << 16);
		if (script_0 != null)
		{
			return script_0;
		}
		else
		{
			final String string_0 = String.valueOf(int_0);
			final int int_2 = Game.indexScripts.getFile(string_0);
			if (int_2 == -1)
			{
				return null;
			}
			else
			{
				final byte[] bytes_0 = Game.indexScripts.takeRecordFlat(int_2);
				if (bytes_0 != null)
				{
					if (bytes_0.length <= 1)
					{
						return null;
					}

					script_0 = class10.newScript(bytes_0);
					if (script_0 != null)
					{
						Script.field1190.put(script_0, int_0 << 16);
						return script_0;
					}
				}

				return null;
			}
		}
	}

	static void method3102(final Player player_0, final int int_0, final int int_1)
	{
		if ((player_0.animation == int_0) && (int_0 != -1))
		{
			final int int_2 = TotalQuantityComparator.getAnimation(int_0).replyMode;
			if (int_2 == 1)
			{
				player_0.actionFrame = 0;
				player_0.actionFrameCycle = 0;
				player_0.actionAnimationDisable = int_1;
				player_0.field907 = 0;
			}

			if (int_2 == 2)
			{
				player_0.field907 = 0;
			}
		}
		else if ((int_0 == -1) || (player_0.animation == -1)
		        || (TotalQuantityComparator.getAnimation(int_0).forcedPriority >= TotalQuantityComparator
		                .getAnimation(player_0.animation).forcedPriority))
		{
			player_0.animation = int_0;
			player_0.actionFrame = 0;
			player_0.actionFrameCycle = 0;
			player_0.actionAnimationDisable = int_1;
			player_0.field907 = 0;
			player_0.field930 = player_0.queueSize;
		}

	}

	static void method3103()
	{
		boolean bool_0 = false;

		while (!bool_0)
		{
			bool_0 = true;

			for (int int_0 = 0; int_0 < (Game.menuOptionCount - 1); int_0++)
			{
				if ((Game.menuTypes[int_0] < 1000) && (Game.menuTypes[int_0 + 1] > 1000))
				{
					final String string_0 = Game.menuTargets[int_0];
					Game.menuTargets[int_0] = Game.menuTargets[int_0 + 1];
					Game.menuTargets[int_0 + 1] = string_0;
					final String string_1 = Game.menuOptions[int_0];
					Game.menuOptions[int_0] = Game.menuOptions[int_0 + 1];
					Game.menuOptions[int_0 + 1] = string_1;
					int int_1 = Game.menuTypes[int_0];
					Game.menuTypes[int_0] = Game.menuTypes[int_0 + 1];
					Game.menuTypes[int_0 + 1] = int_1;
					int_1 = Game.menuActionParams0[int_0];
					Game.menuActionParams0[int_0] = Game.menuActionParams0[int_0 + 1];
					Game.menuActionParams0[int_0 + 1] = int_1;
					int_1 = Game.menuActionParams1[int_0];
					Game.menuActionParams1[int_0] = Game.menuActionParams1[int_0 + 1];
					Game.menuActionParams1[int_0 + 1] = int_1;
					int_1 = Game.menuIdentifiers[int_0];
					Game.menuIdentifiers[int_0] = Game.menuIdentifiers[int_0 + 1];
					Game.menuIdentifiers[int_0 + 1] = int_1;
					final boolean bool_1 = Game.menuBooleanArray[int_0];
					Game.menuBooleanArray[int_0] = Game.menuBooleanArray[int_0 + 1];
					Game.menuBooleanArray[int_0 + 1] = bool_1;
					bool_0 = false;
				}
			}
		}

	}

}
