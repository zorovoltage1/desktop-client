import java.util.Comparator;

final class class6 implements Comparator
{

	static int field39;
	public static int field37;

	int method66(final GrandExchangeEvent grandexchangeevent_0, final GrandExchangeEvent grandexchangeevent_1)
	{
		return grandexchangeevent_0.method16().compareTo(grandexchangeevent_1.method16());
	}

	@Override
	public int compare(final Object object_0, final Object object_1)
	{
		return method66((GrandExchangeEvent) object_0, (GrandExchangeEvent) object_1);
	}

	@Override
	public boolean equals(final Object object_0)
	{
		return super.equals(object_0);
	}

	static int method69(final int int_0, final int int_1)
	{
		final Overlay overlay_0 = GrandExchangeEvents.getOverlayDefinition(int_0);
		if (overlay_0 == null)
		{
			return int_1;
		}
		else if (overlay_0.otherRgbColor >= 0)
		{
			return overlay_0.otherRgbColor | 0xFF000000;
		}
		else
		{
			int int_2;
			byte byte_0;
			int int_3;
			int int_4;
			if (overlay_0.texture >= 0)
			{
				int_2 = Graphics3D.textureLoader.getAverageTextureRGB(overlay_0.texture);
				byte_0 = 96;
				if (int_2 == -2)
				{
					int_3 = 12345678;
				}
				else if (int_2 == -1)
				{
					if (byte_0 < 0)
					{
						byte_0 = 0;
					}
					else if (byte_0 > 127)
					{
						byte_0 = 127;
					}

					int_4 = 127 - byte_0;
					int_3 = int_4;
				}
				else
				{
					int_4 = (byte_0 * (int_2 & 0x7F)) / 128;
					if (int_4 < 2)
					{
						int_4 = 2;
					}
					else if (int_4 > 126)
					{
						int_4 = 126;
					}

					int_3 = int_4 + (int_2 & 0xFF80);
				}

				return Graphics3D.colorPalette[int_3] | 0xFF000000;
			}
			else if (overlay_0.color == 16711935)
			{
				return int_1;
			}
			else
			{
				int_3 = KitDefinition.method4908(overlay_0.hue, overlay_0.saturation, overlay_0.lightness);
				byte_0 = 96;
				if (int_3 == -2)
				{
					int_2 = 12345678;
				}
				else if (int_3 == -1)
				{
					if (byte_0 < 0)
					{
						byte_0 = 0;
					}
					else if (byte_0 > 127)
					{
						byte_0 = 127;
					}

					int_4 = 127 - byte_0;
					int_2 = int_4;
				}
				else
				{
					int_4 = (byte_0 * (int_3 & 0x7F)) / 128;
					if (int_4 < 2)
					{
						int_4 = 2;
					}
					else if (int_4 > 126)
					{
						int_4 = 126;
					}

					int_2 = int_4 + (int_3 & 0xFF80);
				}

				return Graphics3D.colorPalette[int_2] | 0xFF000000;
			}
		}
	}

	static String getColTags(final int int_0)
	{
		return "<col=" + Integer.toHexString(int_0) + ">";
	}

	static void method75()
	{
		for (class68 class68_0 = (class68) class68.field985
		        .getFront(); class68_0 != null; class68_0 = (class68) class68.field985.getNext())
		{
			if (class68_0.field994 != null)
			{
				class68_0.method1688();
			}
		}

	}

	static void decodeMovement(final PacketBuffer packetbuffer_0, final int int_0)
	{
		final boolean bool_0 = packetbuffer_0.getBits(1) == 1;
		if (bool_0)
		{
			class81.field1166[++class81.field1165 - 1] = int_0;
		}

		final int int_1 = packetbuffer_0.getBits(2);
		final Player player_0 = Game.cachedPlayers[int_0];
		if (int_1 == 0)
		{
			if (bool_0)
			{
				player_0.field571 = false;
			}
			else if (Game.localInteractingIndex == int_0)
			{
				throw new RuntimeException();
			}
			else
			{
				class81.Players_regions[int_0] = (player_0.field567 << 28)
				        + (((PendingSpawn.baseX + player_0.pathX[0]) >> 13) << 14)
				        + ((Game.baseY + player_0.pathY[0]) >> 13);
				if (player_0.field920 != -1)
				{
					class81.Players_orientations[int_0] = player_0.field920;
				}
				else
				{
					class81.Players_orientations[int_0] = player_0.orientation;
				}

				class81.Players_targetIndices[int_0] = player_0.interacting;
				Game.cachedPlayers[int_0] = null;
				if (packetbuffer_0.getBits(1) != 0)
				{
					class240.decodeRegionHash(packetbuffer_0, int_0);
				}

			}
		}
		else
		{
			int int_2;
			int int_3;
			int int_4;
			if (int_1 == 1)
			{
				int_2 = packetbuffer_0.getBits(3);
				int_3 = player_0.pathX[0];
				int_4 = player_0.pathY[0];
				if (int_2 == 0)
				{
					--int_3;
					--int_4;
				}
				else if (int_2 == 1)
				{
					--int_4;
				}
				else if (int_2 == 2)
				{
					++int_3;
					--int_4;
				}
				else if (int_2 == 3)
				{
					--int_3;
				}
				else if (int_2 == 4)
				{
					++int_3;
				}
				else if (int_2 == 5)
				{
					--int_3;
					++int_4;
				}
				else if (int_2 == 6)
				{
					++int_4;
				}
				else if (int_2 == 7)
				{
					++int_3;
					++int_4;
				}

				if ((Game.localInteractingIndex == int_0) && ((player_0.x < 1536) || (player_0.y < 1536)
				        || (player_0.x >= 11776) || (player_0.y >= 11776)))
				{
					player_0.method1103(int_3, int_4);
					player_0.field571 = false;
				}
				else if (bool_0)
				{
					player_0.field571 = true;
					player_0.field572 = int_3;
					player_0.field573 = int_4;
				}
				else
				{
					player_0.field571 = false;
					player_0.method1106(int_3, int_4, class81.field1153[int_0]);
				}

			}
			else if (int_1 == 2)
			{
				int_2 = packetbuffer_0.getBits(4);
				int_3 = player_0.pathX[0];
				int_4 = player_0.pathY[0];
				if (int_2 == 0)
				{
					int_3 -= 2;
					int_4 -= 2;
				}
				else if (int_2 == 1)
				{
					--int_3;
					int_4 -= 2;
				}
				else if (int_2 == 2)
				{
					int_4 -= 2;
				}
				else if (int_2 == 3)
				{
					++int_3;
					int_4 -= 2;
				}
				else if (int_2 == 4)
				{
					int_3 += 2;
					int_4 -= 2;
				}
				else if (int_2 == 5)
				{
					int_3 -= 2;
					--int_4;
				}
				else if (int_2 == 6)
				{
					int_3 += 2;
					--int_4;
				}
				else if (int_2 == 7)
				{
					int_3 -= 2;
				}
				else if (int_2 == 8)
				{
					int_3 += 2;
				}
				else if (int_2 == 9)
				{
					int_3 -= 2;
					++int_4;
				}
				else if (int_2 == 10)
				{
					int_3 += 2;
					++int_4;
				}
				else if (int_2 == 11)
				{
					int_3 -= 2;
					int_4 += 2;
				}
				else if (int_2 == 12)
				{
					--int_3;
					int_4 += 2;
				}
				else if (int_2 == 13)
				{
					int_4 += 2;
				}
				else if (int_2 == 14)
				{
					++int_3;
					int_4 += 2;
				}
				else if (int_2 == 15)
				{
					int_3 += 2;
					int_4 += 2;
				}

				if ((Game.localInteractingIndex == int_0) && ((player_0.x < 1536) || (player_0.y < 1536)
				        || (player_0.x >= 11776) || (player_0.y >= 11776)))
				{
					player_0.method1103(int_3, int_4);
					player_0.field571 = false;
				}
				else if (bool_0)
				{
					player_0.field571 = true;
					player_0.field572 = int_3;
					player_0.field573 = int_4;
				}
				else
				{
					player_0.field571 = false;
					player_0.method1106(int_3, int_4, class81.field1153[int_0]);
				}

			}
			else
			{
				int_2 = packetbuffer_0.getBits(1);
				int int_5;
				int int_6;
				int int_7;
				int int_8;
				if (int_2 == 0)
				{
					int_3 = packetbuffer_0.getBits(12);
					int_4 = int_3 >> 10;
					int_5 = (int_3 >> 5) & 0x1F;
					if (int_5 > 15)
					{
						int_5 -= 32;
					}

					int_6 = int_3 & 0x1F;
					if (int_6 > 15)
					{
						int_6 -= 32;
					}

					int_7 = int_5 + player_0.pathX[0];
					int_8 = int_6 + player_0.pathY[0];
					if ((Game.localInteractingIndex == int_0) && ((player_0.x < 1536) || (player_0.y < 1536)
					        || (player_0.x >= 11776) || (player_0.y >= 11776)))
					{
						player_0.method1103(int_7, int_8);
						player_0.field571 = false;
					}
					else if (bool_0)
					{
						player_0.field571 = true;
						player_0.field572 = int_7;
						player_0.field573 = int_8;
					}
					else
					{
						player_0.field571 = false;
						player_0.method1106(int_7, int_8, class81.field1153[int_0]);
					}

					player_0.field567 = (byte) ((int_4 + player_0.field567) & 0x3);
					if (Game.localInteractingIndex == int_0)
					{
						class13.plane = player_0.field567;
					}

				}
				else
				{
					int_3 = packetbuffer_0.getBits(30);
					int_4 = int_3 >> 28;
					int_5 = (int_3 >> 14) & 0x3FFF;
					int_6 = int_3 & 0x3FFF;
					int_7 = ((int_5 + PendingSpawn.baseX + player_0.pathX[0]) & 0x3FFF) - PendingSpawn.baseX;
					int_8 = ((int_6 + Game.baseY + player_0.pathY[0]) & 0x3FFF) - Game.baseY;
					if ((Game.localInteractingIndex == int_0) && ((player_0.x < 1536) || (player_0.y < 1536)
					        || (player_0.x >= 11776) || (player_0.y >= 11776)))
					{
						player_0.method1103(int_7, int_8);
						player_0.field571 = false;
					}
					else if (bool_0)
					{
						player_0.field571 = true;
						player_0.field572 = int_7;
						player_0.field573 = int_8;
					}
					else
					{
						player_0.field571 = false;
						player_0.method1106(int_7, int_8, class81.field1153[int_0]);
					}

					player_0.field567 = (byte) ((int_4 + player_0.field567) & 0x3);
					if (Game.localInteractingIndex == int_0)
					{
						class13.plane = player_0.field567;
					}

				}
			}
		}
	}

	static int method74(final int int_0, final Script script_0, final boolean bool_0)
	{
		if (int_0 == 5306)
		{
			final int[] ints_0 = class69.intStack;
			final int int_1 = ++class69.intStackSize - 1;
			final int int_2 = Game.isResized ? 2 : 1;
			ints_0[int_1] = int_2;
			return 1;
		}
		else
		{
			int int_3;
			if (int_0 == 5307)
			{
				int_3 = class69.intStack[--class69.intStackSize];
				if ((int_3 == 1) || (int_3 == 2))
				{
					class50.method991(int_3);
				}

				return 1;
			}
			else if (int_0 == 5308)
			{
				class69.intStack[++class69.intStackSize - 1] = class10.preferences.screenType;
				return 1;
			}
			else if (int_0 != 5309)
			{
				return 2;
			}
			else
			{
				int_3 = class69.intStack[--class69.intStackSize];
				if ((int_3 == 1) || (int_3 == 2))
				{
					class10.preferences.screenType = int_3;
					class54.method1018();
				}

				return 1;
			}
		}
	}

}
