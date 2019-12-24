public enum class240 implements Enumerated
{

	field3101(3, 0), field3107(5, 1), field3097(7, 2), field3099(2, 3), field3100(6, 4), field3098(4, 5), field3102(1,
	        6), field3103(0, 7);

	static Widget field3096;
	public final int field3104;
	final int field3105;

	class240(final int int_1, final int int_2)
	{
		field3104 = int_1;
		field3105 = int_2;
	}

	@Override
	public int vmethod5815()
	{
		return field3105;
	}

	static boolean decodeRegionHash(final PacketBuffer packetbuffer_0, final int int_0)
	{
		final int int_1 = packetbuffer_0.getBits(2);
		int int_2;
		int int_3;
		int int_5;
		int int_6;
		int int_7;
		int int_8;
		if (int_1 == 0)
		{
			if (packetbuffer_0.getBits(1) != 0)
			{
				decodeRegionHash(packetbuffer_0, int_0);
			}

			int_2 = packetbuffer_0.getBits(13);
			int_3 = packetbuffer_0.getBits(13);
			final boolean bool_0 = packetbuffer_0.getBits(1) == 1;
			if (bool_0)
			{
				class81.field1166[++class81.field1165 - 1] = int_0;
			}

			if (Game.cachedPlayers[int_0] != null)
			{
				throw new RuntimeException();
			}
			else
			{
				final Player player_0 = Game.cachedPlayers[int_0] = new Player();
				player_0.playerId = int_0;
				if (class81.field1157[int_0] != null)
				{
					player_0.decodeApperance(class81.field1157[int_0]);
				}

				player_0.orientation = class81.Players_orientations[int_0];
				player_0.interacting = class81.Players_targetIndices[int_0];
				int_5 = class81.Players_regions[int_0];
				int_6 = int_5 >> 28;
				int_7 = (int_5 >> 14) & 0xFF;
				int_8 = int_5 & 0xFF;
				player_0.pathTraversed[0] = class81.field1153[int_0];
				player_0.field567 = (byte) int_6;
				player_0.method1103(((int_7 << 13) + int_2) - PendingSpawn.baseX,
				        ((int_8 << 13) + int_3) - Game.baseY);
				player_0.field571 = false;
				return true;
			}
		}
		else if (int_1 == 1)
		{
			int_2 = packetbuffer_0.getBits(2);
			int_3 = class81.Players_regions[int_0];
			class81.Players_regions[int_0] = (int_3 & 0xFFFFFFF) + ((((int_3 >> 28) + int_2) & 0x3) << 28);
			return false;
		}
		else
		{
			int int_4;
			int int_9;
			if (int_1 == 2)
			{
				int_2 = packetbuffer_0.getBits(5);
				int_3 = int_2 >> 3;
				int_4 = int_2 & 0x7;
				int_9 = class81.Players_regions[int_0];
				int_5 = ((int_9 >> 28) + int_3) & 0x3;
				int_6 = (int_9 >> 14) & 0xFF;
				int_7 = int_9 & 0xFF;
				if (int_4 == 0)
				{
					--int_6;
					--int_7;
				}

				if (int_4 == 1)
				{
					--int_7;
				}

				if (int_4 == 2)
				{
					++int_6;
					--int_7;
				}

				if (int_4 == 3)
				{
					--int_6;
				}

				if (int_4 == 4)
				{
					++int_6;
				}

				if (int_4 == 5)
				{
					--int_6;
					++int_7;
				}

				if (int_4 == 6)
				{
					++int_7;
				}

				if (int_4 == 7)
				{
					++int_6;
					++int_7;
				}

				class81.Players_regions[int_0] = (int_6 << 14) + int_7 + (int_5 << 28);
				return false;
			}
			else
			{
				int_2 = packetbuffer_0.getBits(18);
				int_3 = int_2 >> 16;
				int_4 = (int_2 >> 8) & 0xFF;
				int_9 = int_2 & 0xFF;
				int_5 = class81.Players_regions[int_0];
				int_6 = ((int_5 >> 28) + int_3) & 0x3;
				int_7 = (int_4 + (int_5 >> 14)) & 0xFF;
				int_8 = (int_9 + int_5) & 0xFF;
				class81.Players_regions[int_0] = (int_7 << 14) + int_8 + (int_6 << 28);
				return false;
			}
		}
	}

}
