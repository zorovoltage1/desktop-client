public class class173
{

	static void addChatMessage(final int int_0, final String string_0, final String string_1, final String string_2)
	{
		ChatLineBuffer chatlinebuffer_0 = (ChatLineBuffer) class83.chatLineMap.get(Integer.valueOf(int_0));
		if (chatlinebuffer_0 == null)
		{
			chatlinebuffer_0 = new ChatLineBuffer();
			class83.chatLineMap.put(Integer.valueOf(int_0), chatlinebuffer_0);
		}

		final MessageNode messagenode_0 = chatlinebuffer_0.addMessage(int_0, string_0, string_1, string_2);
		class83.messages.put(messagenode_0, messagenode_0.id);
		class83.field1184.add(messagenode_0);
		Game.chatCycle = Game.cycleCntr;
	}

	static int method3469(final int int_0, final Script script_0, final boolean bool_0)
	{
		if (int_0 == 3300)
		{
			class69.intStack[++class69.intStackSize - 1] = Game.gameCycle;
			return 1;
		}
		else
		{
			int int_1;
			int int_2;
			if (int_0 == 3301)
			{
				class69.intStackSize -= 2;
				int_1 = class69.intStack[class69.intStackSize];
				int_2 = class69.intStack[class69.intStackSize + 1];
				class69.intStack[++class69.intStackSize - 1] = Widget.method4559(int_1, int_2);
				return 1;
			}
			else
			{
				int[] ints_0;
				int int_3;
				ItemContainer itemcontainer_0;
				int int_4;
				if (int_0 == 3302)
				{
					class69.intStackSize -= 2;
					int_1 = class69.intStack[class69.intStackSize];
					int_2 = class69.intStack[class69.intStackSize + 1];
					ints_0 = class69.intStack;
					int_3 = ++class69.intStackSize - 1;
					itemcontainer_0 = (ItemContainer) ItemContainer.itemContainers.get(int_1);
					if (itemcontainer_0 == null)
					{
						int_4 = 0;
					}
					else if ((int_2 >= 0) && (int_2 < itemcontainer_0.stackSizes.length))
					{
						int_4 = itemcontainer_0.stackSizes[int_2];
					}
					else
					{
						int_4 = 0;
					}

					ints_0[int_3] = int_4;
					return 1;
				}
				else if (int_0 == 3303)
				{
					class69.intStackSize -= 2;
					int_1 = class69.intStack[class69.intStackSize];
					int_2 = class69.intStack[class69.intStackSize + 1];
					class69.intStack[++class69.intStackSize - 1] = class139.method3143(int_1, int_2);
					return 1;
				}
				else if (int_0 == 3304)
				{
					int_1 = class69.intStack[--class69.intStackSize];
					class69.intStack[++class69.intStackSize - 1] = Frames.method3074(int_1).size;
					return 1;
				}
				else if (int_0 == 3305)
				{
					int_1 = class69.intStack[--class69.intStackSize];
					class69.intStack[++class69.intStackSize - 1] = Game.boostedSkillLevels[int_1];
					return 1;
				}
				else if (int_0 == 3306)
				{
					int_1 = class69.intStack[--class69.intStackSize];
					class69.intStack[++class69.intStackSize - 1] = Game.realSkillLevels[int_1];
					return 1;
				}
				else if (int_0 == 3307)
				{
					int_1 = class69.intStack[--class69.intStackSize];
					class69.intStack[++class69.intStackSize - 1] = Game.skillExperiences[int_1];
					return 1;
				}
				else
				{
					int int_5;
					if (int_0 == 3308)
					{
						int_1 = class13.plane;
						int_2 = (class138.localPlayer.x >> 7) + PendingSpawn.baseX;
						int_5 = (class138.localPlayer.y >> 7) + Game.baseY;
						class69.intStack[++class69.intStackSize - 1] = (int_2 << 14) + int_5 + (int_1 << 28);
						return 1;
					}
					else if (int_0 == 3309)
					{
						int_1 = class69.intStack[--class69.intStackSize];
						class69.intStack[++class69.intStackSize - 1] = (int_1 >> 14) & 0x3FFF;
						return 1;
					}
					else if (int_0 == 3310)
					{
						int_1 = class69.intStack[--class69.intStackSize];
						class69.intStack[++class69.intStackSize - 1] = int_1 >> 28;
						return 1;
					}
					else if (int_0 == 3311)
					{
						int_1 = class69.intStack[--class69.intStackSize];
						class69.intStack[++class69.intStackSize - 1] = int_1 & 0x3FFF;
						return 1;
					}
					else if (int_0 == 3312)
					{
						class69.intStack[++class69.intStackSize - 1] = Game.isMembers ? 1 : 0;
						return 1;
					}
					else if (int_0 == 3313)
					{
						class69.intStackSize -= 2;
						int_1 = class69.intStack[class69.intStackSize] + 32768;
						int_2 = class69.intStack[class69.intStackSize + 1];
						class69.intStack[++class69.intStackSize - 1] = Widget.method4559(int_1, int_2);
						return 1;
					}
					else if (int_0 != 3314)
					{
						if (int_0 == 3315)
						{
							class69.intStackSize -= 2;
							int_1 = class69.intStack[class69.intStackSize] + 32768;
							int_2 = class69.intStack[class69.intStackSize + 1];
							class69.intStack[++class69.intStackSize - 1] = class139.method3143(int_1, int_2);
							return 1;
						}
						else if (int_0 == 3316)
						{
							if (Game.rights >= 2)
							{
								class69.intStack[++class69.intStackSize - 1] = Game.rights;
							}
							else
							{
								class69.intStack[++class69.intStackSize - 1] = 0;
							}

							return 1;
						}
						else if (int_0 == 3317)
						{
							class69.intStack[++class69.intStackSize - 1] = Game.field598;
							return 1;
						}
						else if (int_0 == 3318)
						{
							class69.intStack[++class69.intStackSize - 1] = Game.world;
							return 1;
						}
						else if (int_0 == 3321)
						{
							class69.intStack[++class69.intStackSize - 1] = Game.energy;
							return 1;
						}
						else if (int_0 == 3322)
						{
							class69.intStack[++class69.intStackSize - 1] = Game.weight;
							return 1;
						}
						else if (int_0 == 3323)
						{
							if (Game.field776)
							{
								class69.intStack[++class69.intStackSize - 1] = 1;
							}
							else
							{
								class69.intStack[++class69.intStackSize - 1] = 0;
							}

							return 1;
						}
						else if (int_0 == 3324)
						{
							class69.intStack[++class69.intStackSize - 1] = Game.flags;
							return 1;
						}
						else if (int_0 == 3325)
						{
							class69.intStackSize -= 4;
							int_1 = class69.intStack[class69.intStackSize];
							int_2 = class69.intStack[class69.intStackSize + 1];
							int_5 = class69.intStack[class69.intStackSize + 2];
							int_3 = class69.intStack[class69.intStackSize + 3];
							int_1 += int_2 << 14;
							int_1 += int_5 << 28;
							int_1 += int_3;
							class69.intStack[++class69.intStackSize - 1] = int_1;
							return 1;
						}
						else
						{
							return 2;
						}
					}
					else
					{
						class69.intStackSize -= 2;
						int_1 = class69.intStack[class69.intStackSize] + 32768;
						int_2 = class69.intStack[class69.intStackSize + 1];
						ints_0 = class69.intStack;
						int_3 = ++class69.intStackSize - 1;
						itemcontainer_0 = (ItemContainer) ItemContainer.itemContainers.get(int_1);
						if (itemcontainer_0 == null)
						{
							int_4 = 0;
						}
						else if ((int_2 >= 0) && (int_2 < itemcontainer_0.stackSizes.length))
						{
							int_4 = itemcontainer_0.stackSizes[int_2];
						}
						else
						{
							int_4 = 0;
						}

						ints_0[int_3] = int_4;
						return 1;
					}
				}
			}
		}
	}

	static void queueAnimationSound(final Sequence sequence_0, final int int_0, final int int_1, final int int_2)
	{
		if ((Game.queuedSoundEffectCount
				< 50) && (Game.field815 != 0))
		{
			if ((sequence_0.field3543 != null) && (int_0 < sequence_0.field3543.length))
			{
				final int int_3 = sequence_0.field3543[int_0];
				if (int_3 != 0)
				{
					final int int_4 = int_3 >> 8;
					final int int_5 = (int_3 >> 4) & 0x7;
					final int int_6 = int_3 & 0xF;
					Game.queuedSoundEffectIDs[Game.queuedSoundEffectCount] = int_4;
					Game.unknownSoundValues1[Game.queuedSoundEffectCount] = int_5;
					Game.unknownSoundValues2[Game.queuedSoundEffectCount] = 0;
					Game.audioEffects[Game.queuedSoundEffectCount] = null;
					final int int_7 = (int_1 - 64) / 128;
					final int int_8 = (int_2 - 64) / 128;
					Game.soundLocations[Game.queuedSoundEffectCount] = int_6 + (int_8 << 8) + (int_7 << 16);
					++Game.queuedSoundEffectCount;
				}
			}
		}
	}

	static boolean method3470(final int int_0)
	{
		return (int_0 == 57) || (int_0 == 58) || (int_0 == 1007) || (int_0 == 25) || (int_0 == 30);
	}

	static void method3473(final Widget widget_0, final int int_0, final int int_1, final int int_2)
	{
		class54.method1017();
		final class224 class224_0 = widget_0.method4517(false);
		if (class224_0 != null)
		{
			Rasterizer2D.setDrawRegion(int_0, int_1, class224_0.field2553 + int_0, int_1 + class224_0.field2549);
			if ((Game.field810 != 2) && (Game.field810 != 5))
			{
				final int int_3 = Game.mapAngle & 0x7FF;
				final int int_4 = (class138.localPlayer.x / 32) + 48;
				final int int_5 = 464 - (class138.localPlayer.y / 32);
				NPC.minimapSprite.method5845(int_0, int_1, class224_0.field2553, class224_0.field2549, int_4, int_5,
				        int_3, 256, class224_0.field2551, class224_0.field2550);

				int int_6;
				int int_7;
				int int_8;
				for (int_6 = 0; int_6 < Game.mapIconCount; int_6++)
				{
					int_7 = ((Game.mapIconTileX[int_6] * 4) + 2) - (class138.localPlayer.x / 32);
					int_8 = ((Game.mapIconTileY[int_6] * 4) + 2) - (class138.localPlayer.y / 32);
					WidgetNode.drawDot(int_0, int_1, int_7, int_8, Game.mapIcons[int_6], class224_0);
				}

				int int_9;
				int int_10;
				for (int_6 = 0; int_6 < 104; int_6++)
				{
					for (int_7 = 0; int_7 < 104; int_7++)
					{
						final Deque deque_0 = Game.groundItemDeque[class13.plane][int_6][int_7];
						if (deque_0 != null)
						{
							int_9 = ((int_6 * 4) + 2) - (class138.localPlayer.x / 32);
							int_10 = ((int_7 * 4) + 2) - (class138.localPlayer.y / 32);
							WidgetNode.drawDot(int_0, int_1, int_9, int_10, MapIconReference.mapDots[0], class224_0);
						}
					}
				}

				for (int_6 = 0; int_6 < Game.npcIndexesCount; int_6++)
				{
					final NPC npc_0 = Game.cachedNPCs[Game.npcIndices[int_6]];
					if ((npc_0 != null) && npc_0.hasConfig())
					{
						NPCComposition npccomposition_0 = npc_0.composition;
						if ((npccomposition_0 != null) && (npccomposition_0.configs != null))
						{
							npccomposition_0 = npccomposition_0.transform();
						}

						if ((npccomposition_0 != null) && npccomposition_0.isMinimapVisible
						        && npccomposition_0.field3504)
						{
							int_9 = (npc_0.x / 32) - (class138.localPlayer.x / 32);
							int_10 = (npc_0.y / 32) - (class138.localPlayer.y / 32);
							WidgetNode.drawDot(int_0, int_1, int_9, int_10, MapIconReference.mapDots[1], class224_0);
						}
					}
				}

				int_6 = class81.playerIndexesCount;
				final int[] ints_0 = class81.playerIndices;

				for (int_8 = 0; int_8 < int_6; int_8++)
				{
					final Player player_0 = Game.cachedPlayers[ints_0[int_8]];
					if ((player_0 != null) && player_0.hasConfig() && !player_0.hidden
					        && (player_0 != class138.localPlayer))
					{
						int_10 = (player_0.x / 32) - (class138.localPlayer.x / 32);
						final int int_11 = (player_0.y / 32) - (class138.localPlayer.y / 32);
						boolean bool_0 = false;
						if ((class138.localPlayer.team != 0) && (player_0.team != 0)
						        && (player_0.team == class138.localPlayer.team))
						{
							bool_0 = true;
						}

						if (player_0.isFriend())
						{
							WidgetNode.drawDot(int_0, int_1, int_10, int_11, MapIconReference.mapDots[3], class224_0);
						}
						else if (bool_0)
						{
							WidgetNode.drawDot(int_0, int_1, int_10, int_11, MapIconReference.mapDots[4], class224_0);
						}
						else if (player_0.isClanMember())
						{
							WidgetNode.drawDot(int_0, int_1, int_10, int_11, MapIconReference.mapDots[5], class224_0);
						}
						else
						{
							WidgetNode.drawDot(int_0, int_1, int_10, int_11, MapIconReference.mapDots[2], class224_0);
						}
					}
				}

				if ((Game.hintArrowTargetType != 0) && ((Game.gameCycle % 20) < 10))
				{
					if ((Game.hintArrowTargetType == 1) && (Game.hintArrowNpcTargetIdx >= 0)
					        && (Game.hintArrowNpcTargetIdx < Game.cachedNPCs.length))
					{
						final NPC npc_1 = Game.cachedNPCs[Game.hintArrowNpcTargetIdx];
						if (npc_1 != null)
						{
							int_9 = (npc_1.x / 32) - (class138.localPlayer.x / 32);
							int_10 = (npc_1.y / 32) - (class138.localPlayer.y / 32);
							VertexNormal.worldToMinimap(int_0, int_1, int_9, int_10, TextureProvider.mapMarkers[1],
							        class224_0);
						}
					}

					if (Game.hintArrowTargetType == 2)
					{
						int_8 = (((Game.hintArrowX * 4) - (PendingSpawn.baseX * 4)) + 2)
						        - (class138.localPlayer.x / 32);
						int_9 = (((Game.hintArrowY * 4) - (Game.baseY * 4)) + 2) - (class138.localPlayer.y / 32);
						VertexNormal.worldToMinimap(int_0, int_1, int_8, int_9, TextureProvider.mapMarkers[1],
						        class224_0);
					}

					if ((Game.hintArrowTargetType == 10) && (Game.hintArrowPlayerTargetIdx >= 0)
					        && (Game.hintArrowPlayerTargetIdx < Game.cachedPlayers.length))
					{
						final Player player_1 = Game.cachedPlayers[Game.hintArrowPlayerTargetIdx];
						if (player_1 != null)
						{
							int_9 = (player_1.x / 32) - (class138.localPlayer.x / 32);
							int_10 = (player_1.y / 32) - (class138.localPlayer.y / 32);
							VertexNormal.worldToMinimap(int_0, int_1, int_9, int_10, TextureProvider.mapMarkers[1],
							        class224_0);
						}
					}
				}

				if (Game.destinationX != 0)
				{
					int_8 = ((Game.destinationX * 4) + 2) - (class138.localPlayer.x / 32);
					int_9 = ((Game.destinationY * 4) + 2) - (class138.localPlayer.y / 32);
					WidgetNode.drawDot(int_0, int_1, int_8, int_9, TextureProvider.mapMarkers[0], class224_0);
				}

				if (!class138.localPlayer.hidden)
				{
					Rasterizer2D.Rasterizer2D_fillRectangle(((class224_0.field2553 / 2) + int_0) - 1,
					        ((class224_0.field2549 / 2) + int_1) - 1, 3, 3, 16777215);
				}
			}
			else
			{
				Rasterizer2D.method5742(int_0, int_1, 0, class224_0.field2551, class224_0.field2550);
			}

			Game.field788[int_2] = true;
		}
	}

}
