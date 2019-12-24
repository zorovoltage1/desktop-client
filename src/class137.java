import java.util.Comparator;

public class class137 implements Comparator
{

	final boolean field1870;

	public class137(final boolean bool_0)
	{
		field1870 = bool_0;
	}

	int method3120(final ChatPlayer chatplayer_0, final ChatPlayer chatplayer_1)
	{
		return field1870 ? chatplayer_0.field3627 - chatplayer_1.field3627
		        : chatplayer_1.field3627 - chatplayer_0.field3627;
	}

	@Override
	public boolean equals(final Object object_0)
	{
		return super.equals(object_0);
	}

	@Override
	public int compare(final Object object_0, final Object object_1)
	{
		return method3120((ChatPlayer) object_0, (ChatPlayer) object_1);
	}

	public static SpritePixels method3127(final IndexDataBase indexdatabase_0, final String string_0,
	        final String string_1)
	{
		final int int_0 = indexdatabase_0.getFile(string_0);
		final int int_1 = indexdatabase_0.getChild(int_0, string_1);
		return class229.method4499(indexdatabase_0, int_0, int_1);
	}

	static int method3119(final Widget widget_0, final int int_0)
	{
		if ((widget_0.dynamicValues != null) && (int_0 < widget_0.dynamicValues.length))
		{
			try
			{
				final int[] ints_0 = widget_0.dynamicValues[int_0];
				int int_1 = 0;
				int int_2 = 0;
				byte byte_0 = 0;

				while (true)
				{
					final int int_3 = ints_0[int_2++];
					int int_4 = 0;
					byte byte_1 = 0;
					if (int_3 == 0)
					{
						return int_1;
					}

					if (int_3 == 1)
					{
						int_4 = Game.boostedSkillLevels[ints_0[int_2++]];
					}

					if (int_3 == 2)
					{
						int_4 = Game.realSkillLevels[ints_0[int_2++]];
					}

					if (int_3 == 3)
					{
						int_4 = Game.skillExperiences[ints_0[int_2++]];
					}

					int int_5;
					Widget widget_1;
					int int_6;
					int int_7;
					if (int_3 == 4)
					{
						int_5 = ints_0[int_2++] << 16;
						int_5 += ints_0[int_2++];
						widget_1 = Widget.getWidget(int_5);
						int_6 = ints_0[int_2++];
						if ((int_6 != -1) && (!TextureProvider.getItemDefinition(int_6).isMembers || Game.isMembers))
						{
							for (int_7 = 0; int_7 < widget_1.itemIds.length; int_7++)
							{
								if ((int_6 + 1) == widget_1.itemIds[int_7])
								{
									int_4 += widget_1.itemQuantities[int_7];
								}
							}
						}
					}

					if (int_3 == 5)
					{
						int_4 = class225.clientVarps[ints_0[int_2++]];
					}

					if (int_3 == 6)
					{
						int_4 = class234.field2779[Game.realSkillLevels[ints_0[int_2++]] - 1];
					}

					if (int_3 == 7)
					{
						int_4 = (class225.clientVarps[ints_0[int_2++]] * 100) / 46875;
					}

					if (int_3 == 8)
					{
						int_4 = class138.localPlayer.combatLevel;
					}

					if (int_3 == 9)
					{
						for (int_5 = 0; int_5 < 25; int_5++)
						{
							if (class234.field2780[int_5])
							{
								int_4 += Game.realSkillLevels[int_5];
							}
						}
					}

					if (int_3 == 10)
					{
						int_5 = ints_0[int_2++] << 16;
						int_5 += ints_0[int_2++];
						widget_1 = Widget.getWidget(int_5);
						int_6 = ints_0[int_2++];
						if ((int_6 != -1) && (!TextureProvider.getItemDefinition(int_6).isMembers || Game.isMembers))
						{
							for (int_7 = 0; int_7 < widget_1.itemIds.length; int_7++)
							{
								if ((int_6 + 1) == widget_1.itemIds[int_7])
								{
									int_4 = 999999999;
									break;
								}
							}
						}
					}

					if (int_3 == 11)
					{
						int_4 = Game.energy;
					}

					if (int_3 == 12)
					{
						int_4 = Game.weight;
					}

					if (int_3 == 13)
					{
						int_5 = class225.clientVarps[ints_0[int_2++]];
						final int int_8 = ints_0[int_2++];
						int_4 = (int_5 & (1 << int_8)) != 0 ? 1 : 0;
					}

					if (int_3 == 14)
					{
						int_5 = ints_0[int_2++];
						int_4 = GameSocket.getVarbit(int_5);
					}

					if (int_3 == 15)
					{
						byte_1 = 1;
					}

					if (int_3 == 16)
					{
						byte_1 = 2;
					}

					if (int_3 == 17)
					{
						byte_1 = 3;
					}

					if (int_3 == 18)
					{
						int_4 = (class138.localPlayer.x >> 7) + PendingSpawn.baseX;
					}

					if (int_3 == 19)
					{
						int_4 = (class138.localPlayer.y >> 7) + Game.baseY;
					}

					if (int_3 == 20)
					{
						int_4 = ints_0[int_2++];
					}

					if (byte_1 == 0)
					{
						if (byte_0 == 0)
						{
							int_1 += int_4;
						}

						if (byte_0 == 1)
						{
							int_1 -= int_4;
						}

						if ((byte_0 == 2) && (int_4 != 0))
						{
							int_1 /= int_4;
						}

						if (byte_0 == 3)
						{
							int_1 *= int_4;
						}

						byte_0 = 0;
					}
					else
					{
						byte_0 = byte_1;
					}
				}
			}
			catch (final Exception exception_0)
			{
				return -1;
			}
		}
		else
		{
			return -2;
		}
	}

}
