public class class11
{

	static int field68;
	static int[] field69;

	public static void method100(final IndexDataBase indexdatabase_0, final IndexDataBase indexdatabase_1,
	        final IndexDataBase indexdatabase_2, final IndexDataBase indexdatabase_3)
	{
		Widget.widgetIndex = indexdatabase_0;
		Widget.field2642 = indexdatabase_1;
		Signlink.field1956 = indexdatabase_2;
		Widget.field2598 = indexdatabase_3;
		GameCanvas.widgets = new Widget[Widget.widgetIndex.size()][];
		GZipDecompressor.validInterfaces = new boolean[Widget.widgetIndex.size()];
	}

	static int method99()
	{
		return 11;
	}

	static void method98(final Player player_0, final boolean bool_0)
	{
		if ((player_0 != null) && player_0.hasConfig() && !player_0.hidden)
		{
            player_0.isLowDetail = ((Game.lowMemory && (class81.playerIndexesCount > 50)) || (class81.playerIndexesCount > 200))
                    && bool_0 && (player_0.idlePoseAnimation == player_0.poseAnimation);

			final int int_0 = player_0.x >> 7;
			final int int_1 = player_0.y >> 7;
			if ((int_0 >= 0) && (int_0 < 104) && (int_1 >= 0) && (int_1 < 104))
			{
				final long long_0 = class76.method1804(0, 0, 0, false, player_0.playerId);
				if ((player_0.model != null) && (Game.gameCycle >= player_0.animationCycleStart)
				        && (Game.gameCycle < player_0.animationCycleEnd))
				{
					player_0.isLowDetail = false;
					player_0.field562 = WorldMapType2.getTileHeight(player_0.x, player_0.y, class13.plane);
					player_0.field889 = Game.gameCycle;
					MapIcon.region.method3010(class13.plane, player_0.x, player_0.y, player_0.field562, 60, player_0,
					        player_0.angle, long_0, player_0.field559, player_0.field547, player_0.field565,
					        player_0.field553);
				}
				else
				{
					if (((player_0.x & 0x7F) == 64) && ((player_0.y & 0x7F) == 64))
					{
						if (Game.field761[int_0][int_1] == Game.field687)
						{
							return;
						}

						Game.field761[int_0][int_1] = Game.field687;
					}

					player_0.field562 = WorldMapType2.getTileHeight(player_0.x, player_0.y, class13.plane);
					player_0.field889 = Game.gameCycle;
					MapIcon.region.method2883(class13.plane, player_0.x, player_0.y, player_0.field562, 60, player_0,
					        player_0.angle, long_0, player_0.field873);
				}
			}
		}

	}

}
