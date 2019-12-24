public class class24
{

	static int field203;
	static final class24 field208;
	static final class24 field204;
	static IndexData indexWorldMap;
	final int field205;

	static
	{
		field208 = new class24(0);
		field204 = new class24(1);
	}

	class24(final int int_0)
	{
		field205 = int_0;
	}

	static void method424(final boolean bool_0)
	{
		for (int int_0 = 0; int_0 < Game.npcIndexesCount; int_0++)
		{
			final NPC npc_0 = Game.cachedNPCs[Game.npcIndices[int_0]];
			if ((npc_0 != null) && npc_0.hasConfig() && (npc_0.composition.isVisible == bool_0)
			        && npc_0.composition.method5165())
			{
				final int int_1 = npc_0.x >> 7;
				final int int_2 = npc_0.y >> 7;
				if ((int_1 >= 0) && (int_1 < 104) && (int_2 >= 0) && (int_2 < 104))
				{
					if ((npc_0.field874 == 1) && ((npc_0.x & 0x7F) == 64) && ((npc_0.y & 0x7F) == 64))
					{
						if (Game.field761[int_1][int_2] == Game.field687)
						{
							continue;
						}

						Game.field761[int_1][int_2] = Game.field687;
					}

					final long long_0 = class76.method1804(0, 0, 1, !npc_0.composition.field3504,
					        Game.npcIndices[int_0]);
					npc_0.field889 = Game.gameCycle;
					MapIcon.region.method2883(class13.plane, npc_0.x, npc_0.y,
					        WorldMapType2.getTileHeight(((npc_0.field874 * 64) - 64) + npc_0.x,
					                ((npc_0.field874 * 64) - 64) + npc_0.y, class13.plane),
					        ((npc_0.field874 * 64) - 64) + 60, npc_0, npc_0.angle, long_0, npc_0.field873);
				}
			}
		}

	}

	static int getWidgetClickMask(final Widget widget_0)
	{
		final IntegerNode integernode_0 = (IntegerNode) Game.widgetFlags
		        .get(widget_0.index + ((long) widget_0.interfaceHash << 32));
		return integernode_0 != null ? integernode_0.value : widget_0.clickMask;
	}

}
