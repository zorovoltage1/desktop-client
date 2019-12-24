public class CombatInfo1 extends Node
{

	static int[] field936;
	int cycle;
	int healthRatio;
	int health;
	int int2;

	CombatInfo1(final int int_0, final int int_1, final int int_2, final int int_3)
	{
		cycle = int_0;
		healthRatio = int_1;
		health = int_2;
		int2 = int_3;
	}

	void set(final int int_0, final int int_1, final int int_2, final int int_3)
	{
		cycle = int_0;
		healthRatio = int_1;
		health = int_2;
		int2 = int_3;
	}

	static void method1560()
	{
		class224.field2554 = new int[2000];
		int int_0 = 0;
		int int_1 = 240;

		int int_2;
		for (final byte byte_0 = 12; int_0 < 16; int_1 -= byte_0)
		{
			int_2 = class143.method3167(int_1 / 360.0F, 0.9998999834060669D, 0.075F + ((int_0 * 0.425F) / 16.0F));
			class224.field2554[int_0] = int_2;
			++int_0;
		}

		int_1 = 48;

		for (final int int_4 = int_1 / 6; int_0 < class224.field2554.length; int_1 -= int_4)
		{
			int_2 = int_0 * 2;

			for (final int int_3 = class143.method3167(int_1 / 360.0F, 0.9998999834060669D, 0.5D); (int_0 < int_2)
			        && (int_0 < class224.field2554.length); int_0++)
			{
				class224.field2554[int_0] = int_3;
			}
		}

	}

	static int method1558(final int int_0, final Script script_0, final boolean bool_0)
	{
		int int_1;
		if (int_0 == 6600)
		{
			int_1 = class13.plane;
			final int int_6 = (class138.localPlayer.x >> 7) + PendingSpawn.baseX;
			final int int_2 = (class138.localPlayer.y >> 7) + Game.baseY;
			WorldMapType1.method196().method6011(int_1, int_6, int_2, true);
			return 1;
		}
		else
		{
			WorldMapData worldmapdata_0;
			if (int_0 == 6601)
			{
				int_1 = class69.intStack[--class69.intStackSize];
				String string_0 = "";
				worldmapdata_0 = WorldMapType1.method196().getWorldMapDataByFileId(int_1);
				if (worldmapdata_0 != null)
				{
					string_0 = worldmapdata_0.getName();
				}

				class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = string_0;
				return 1;
			}
			else if (int_0 == 6602)
			{
				int_1 = class69.intStack[--class69.intStackSize];
				WorldMapType1.method196().method6012(int_1);
				return 1;
			}
			else if (int_0 == 6603)
			{
				class69.intStack[++class69.intStackSize - 1] = WorldMapType1.method196().method6026();
				return 1;
			}
			else if (int_0 == 6604)
			{
				int_1 = class69.intStack[--class69.intStackSize];
				WorldMapType1.method196().method6023(int_1);
				return 1;
			}
			else if (int_0 == 6605)
			{
				class69.intStack[++class69.intStackSize - 1] = WorldMapType1.method196().method6096() ? 1 : 0;
				return 1;
			}
			else
			{
				Coordinates coordinates_3;
				if (int_0 == 6606)
				{
					coordinates_3 = new Coordinates(class69.intStack[--class69.intStackSize]);
					WorldMapType1.method196().setWorldMapPositionTarget(coordinates_3.worldX, coordinates_3.worldY);
					return 1;
				}
				else if (int_0 == 6607)
				{
					coordinates_3 = new Coordinates(class69.intStack[--class69.intStackSize]);
					WorldMapType1.method196().method6031(coordinates_3.worldX, coordinates_3.worldY);
					return 1;
				}
				else if (int_0 == 6608)
				{
					coordinates_3 = new Coordinates(class69.intStack[--class69.intStackSize]);
					WorldMapType1.method196().method6046(coordinates_3.plane, coordinates_3.worldX,
					        coordinates_3.worldY);
					return 1;
				}
				else if (int_0 == 6609)
				{
					coordinates_3 = new Coordinates(class69.intStack[--class69.intStackSize]);
					WorldMapType1.method196().method6033(coordinates_3.plane, coordinates_3.worldX,
					        coordinates_3.worldY);
					return 1;
				}
				else if (int_0 == 6610)
				{
					class69.intStack[++class69.intStackSize - 1] = WorldMapType1.method196().method6002();
					class69.intStack[++class69.intStackSize - 1] = WorldMapType1.method196().method6035();
					return 1;
				}
				else
				{
					WorldMapData worldmapdata_1;
					if (int_0 == 6611)
					{
						int_1 = class69.intStack[--class69.intStackSize];
						worldmapdata_1 = WorldMapType1.method196().getWorldMapDataByFileId(int_1);
						if (worldmapdata_1 == null)
						{
							class69.intStack[++class69.intStackSize - 1] = 0;
						}
						else
						{
							class69.intStack[++class69.intStackSize - 1] = worldmapdata_1.method256().bitpack();
						}

						return 1;
					}
					else if (int_0 == 6612)
					{
						int_1 = class69.intStack[--class69.intStackSize];
						worldmapdata_1 = WorldMapType1.method196().getWorldMapDataByFileId(int_1);
						if (worldmapdata_1 == null)
						{
							class69.intStack[++class69.intStackSize - 1] = 0;
							class69.intStack[++class69.intStackSize - 1] = 0;
						}
						else
						{
							class69.intStack[++class69.intStackSize
							        - 1] = ((worldmapdata_1.method214() - worldmapdata_1.getMinX()) + 1) * 64;
							class69.intStack[++class69.intStackSize
							        - 1] = ((worldmapdata_1.method249() - worldmapdata_1.getMinY()) + 1) * 64;
						}

						return 1;
					}
					else if (int_0 == 6613)
					{
						int_1 = class69.intStack[--class69.intStackSize];
						worldmapdata_1 = WorldMapType1.method196().getWorldMapDataByFileId(int_1);
						if (worldmapdata_1 == null)
						{
							class69.intStack[++class69.intStackSize - 1] = 0;
							class69.intStack[++class69.intStackSize - 1] = 0;
							class69.intStack[++class69.intStackSize - 1] = 0;
							class69.intStack[++class69.intStackSize - 1] = 0;
						}
						else
						{
							class69.intStack[++class69.intStackSize - 1] = worldmapdata_1.getMinX() * 64;
							class69.intStack[++class69.intStackSize - 1] = worldmapdata_1.getMinY() * 64;
							class69.intStack[++class69.intStackSize - 1] = ((worldmapdata_1.method214() * 64) + 64) - 1;
							class69.intStack[++class69.intStackSize - 1] = ((worldmapdata_1.method249() * 64) + 64) - 1;
						}

						return 1;
					}
					else if (int_0 == 6614)
					{
						int_1 = class69.intStack[--class69.intStackSize];
						worldmapdata_1 = WorldMapType1.method196().getWorldMapDataByFileId(int_1);
						if (worldmapdata_1 == null)
						{
							class69.intStack[++class69.intStackSize - 1] = -1;
						}
						else
						{
							class69.intStack[++class69.intStackSize - 1] = worldmapdata_1.getInitialMapSurfaceZoom();
						}

						return 1;
					}
					else if (int_0 == 6615)
					{
						coordinates_3 = WorldMapType1.method196().method6001();
						if (coordinates_3 == null)
						{
							class69.intStack[++class69.intStackSize - 1] = -1;
							class69.intStack[++class69.intStackSize - 1] = -1;
						}
						else
						{
							class69.intStack[++class69.intStackSize - 1] = coordinates_3.worldX;
							class69.intStack[++class69.intStackSize - 1] = coordinates_3.worldY;
						}

						return 1;
					}
					else if (int_0 == 6616)
					{
						class69.intStack[++class69.intStackSize - 1] = WorldMapType1.method196().method6153();
						return 1;
					}
					else if (int_0 == 6617)
					{
						coordinates_3 = new Coordinates(class69.intStack[--class69.intStackSize]);
						worldmapdata_1 = WorldMapType1.method196().method6014();
						if (worldmapdata_1 == null)
						{
							class69.intStack[++class69.intStackSize - 1] = -1;
							class69.intStack[++class69.intStackSize - 1] = -1;
							return 1;
						}
						else
						{
							final int[] ints_0 = worldmapdata_1.method213(coordinates_3.plane, coordinates_3.worldX,
							        coordinates_3.worldY);
							if (ints_0 == null)
							{
								class69.intStack[++class69.intStackSize - 1] = -1;
								class69.intStack[++class69.intStackSize - 1] = -1;
							}
							else
							{
								class69.intStack[++class69.intStackSize - 1] = ints_0[0];
								class69.intStack[++class69.intStackSize - 1] = ints_0[1];
							}

							return 1;
						}
					}
					else
					{
						Coordinates coordinates_0;
						if (int_0 == 6618)
						{
							coordinates_3 = new Coordinates(class69.intStack[--class69.intStackSize]);
							worldmapdata_1 = WorldMapType1.method196().method6014();
							if (worldmapdata_1 == null)
							{
								class69.intStack[++class69.intStackSize - 1] = -1;
								class69.intStack[++class69.intStackSize - 1] = -1;
								return 1;
							}
							else
							{
								coordinates_0 = worldmapdata_1.method205(coordinates_3.worldX, coordinates_3.worldY);
								if (coordinates_0 == null)
								{
									class69.intStack[++class69.intStackSize - 1] = -1;
								}
								else
								{
									class69.intStack[++class69.intStackSize - 1] = coordinates_0.bitpack();
								}

								return 1;
							}
						}
						else
						{
							int int_3;
							int int_4;
							int int_5;
							Coordinates coordinates_1;
							Coordinates coordinates_2;
							if (int_0 == 6619)
							{
								class69.intStackSize -= 2;
								int_1 = class69.intStack[class69.intStackSize];
								coordinates_2 = new Coordinates(class69.intStack[class69.intStackSize + 1]);
								worldmapdata_0 = WorldMapType1.method196().getWorldMapDataByFileId(int_1);
								int_3 = class138.localPlayer.field567;
								int_4 = (class138.localPlayer.x >> 7) + PendingSpawn.baseX;
								int_5 = (class138.localPlayer.y >> 7) + Game.baseY;
								coordinates_1 = new Coordinates(int_3, int_4, int_5);
								WorldMapType1.method196().method6073(worldmapdata_0, coordinates_1, coordinates_2,
								        false);
								return 1;
							}
							else if (int_0 == 6620)
							{
								class69.intStackSize -= 2;
								int_1 = class69.intStack[class69.intStackSize];
								coordinates_2 = new Coordinates(class69.intStack[class69.intStackSize + 1]);
								worldmapdata_0 = WorldMapType1.method196().getWorldMapDataByFileId(int_1);
								int_3 = class138.localPlayer.field567;
								int_4 = (class138.localPlayer.x >> 7) + PendingSpawn.baseX;
								int_5 = (class138.localPlayer.y >> 7) + Game.baseY;
								coordinates_1 = new Coordinates(int_3, int_4, int_5);
								WorldMapType1.method196().method6073(worldmapdata_0, coordinates_1, coordinates_2,
								        true);
								return 1;
							}
							else if (int_0 == 6621)
							{
								class69.intStackSize -= 2;
								int_1 = class69.intStack[class69.intStackSize];
								coordinates_2 = new Coordinates(class69.intStack[class69.intStackSize + 1]);
								worldmapdata_0 = WorldMapType1.method196().getWorldMapDataByFileId(int_1);
								if (worldmapdata_0 == null)
								{
									class69.intStack[++class69.intStackSize - 1] = 0;
									return 1;
								}
								else
								{
									class69.intStack[++class69.intStackSize - 1] = worldmapdata_0.containsCoord(
									        coordinates_2.plane, coordinates_2.worldX, coordinates_2.worldY) ? 1 : 0;
									return 1;
								}
							}
							else if (int_0 == 6622)
							{
								class69.intStack[++class69.intStackSize - 1] = WorldMapType1.method196().method6142();
								class69.intStack[++class69.intStackSize - 1] = WorldMapType1.method196().method6038();
								return 1;
							}
							else if (int_0 == 6623)
							{
								coordinates_3 = new Coordinates(class69.intStack[--class69.intStackSize]);
								worldmapdata_1 = WorldMapType1.method196().getWorldMapDataContainingCoord(
								        coordinates_3.plane, coordinates_3.worldX, coordinates_3.worldY);
								if (worldmapdata_1 == null)
								{
									class69.intStack[++class69.intStackSize - 1] = -1;
								}
								else
								{
									class69.intStack[++class69.intStackSize - 1] = worldmapdata_1.getFileId();
								}

								return 1;
							}
							else if (int_0 == 6624)
							{
								WorldMapType1.method196().method6089(class69.intStack[--class69.intStackSize]);
								return 1;
							}
							else if (int_0 == 6625)
							{
								WorldMapType1.method196().method6040();
								return 1;
							}
							else if (int_0 == 6626)
							{
								WorldMapType1.method196().method6041(class69.intStack[--class69.intStackSize]);
								return 1;
							}
							else if (int_0 == 6627)
							{
								WorldMapType1.method196().method6042();
								return 1;
							}
							else
							{
								boolean bool_2;
								if (int_0 == 6628)
								{
									bool_2 = class69.intStack[--class69.intStackSize] == 1;
									WorldMapType1.method196().method6034(bool_2);
									return 1;
								}
								else if (int_0 == 6629)
								{
									int_1 = class69.intStack[--class69.intStackSize];
									WorldMapType1.method196().method6106(int_1);
									return 1;
								}
								else if (int_0 == 6630)
								{
									int_1 = class69.intStack[--class69.intStackSize];
									WorldMapType1.method196().method6152(int_1);
									return 1;
								}
								else if (int_0 == 6631)
								{
									WorldMapType1.method196().method6114();
									return 1;
								}
								else if (int_0 == 6632)
								{
									bool_2 = class69.intStack[--class69.intStackSize] == 1;
									WorldMapType1.method196().method6047(bool_2);
									return 1;
								}
								else
								{
									boolean bool_1;
									if (int_0 == 6633)
									{
										class69.intStackSize -= 2;
										int_1 = class69.intStack[class69.intStackSize];
										bool_1 = class69.intStack[class69.intStackSize + 1] == 1;
										WorldMapType1.method196().method6048(int_1, bool_1);
										return 1;
									}
									else if (int_0 == 6634)
									{
										class69.intStackSize -= 2;
										int_1 = class69.intStack[class69.intStackSize];
										bool_1 = class69.intStack[class69.intStackSize + 1] == 1;
										WorldMapType1.method196().method6049(int_1, bool_1);
										return 1;
									}
									else if (int_0 == 6635)
									{
										class69.intStack[++class69.intStackSize - 1] = WorldMapType1.method196()
										        .method6050() ? 1 : 0;
										return 1;
									}
									else if (int_0 == 6636)
									{
										int_1 = class69.intStack[--class69.intStackSize];
										class69.intStack[++class69.intStackSize - 1] = WorldMapType1.method196()
										        .method6051(int_1) ? 1 : 0;
										return 1;
									}
									else if (int_0 == 6637)
									{
										int_1 = class69.intStack[--class69.intStackSize];
										class69.intStack[++class69.intStackSize - 1] = WorldMapType1.method196()
										        .method6052(int_1) ? 1 : 0;
										return 1;
									}
									else if (int_0 == 6638)
									{
										class69.intStackSize -= 2;
										int_1 = class69.intStack[class69.intStackSize];
										coordinates_2 = new Coordinates(class69.intStack[class69.intStackSize + 1]);
										coordinates_0 = WorldMapType1.method196().method6100(int_1, coordinates_2);
										if (coordinates_0 == null)
										{
											class69.intStack[++class69.intStackSize - 1] = -1;
										}
										else
										{
											class69.intStack[++class69.intStackSize - 1] = coordinates_0.bitpack();
										}

										return 1;
									}
									else
									{
										MapIcon mapicon_0;
										if (int_0 == 6639)
										{
											mapicon_0 = WorldMapType1.method196().method6146();
											if (mapicon_0 == null)
											{
												class69.intStack[++class69.intStackSize - 1] = -1;
												class69.intStack[++class69.intStackSize - 1] = -1;
											}
											else
											{
												class69.intStack[++class69.intStackSize - 1] = mapicon_0.areaId;
												class69.intStack[++class69.intStackSize - 1] = mapicon_0.field236
												        .bitpack();
											}

											return 1;
										}
										else if (int_0 == 6640)
										{
											mapicon_0 = WorldMapType1.method196().method6186();
											if (mapicon_0 == null)
											{
												class69.intStack[++class69.intStackSize - 1] = -1;
												class69.intStack[++class69.intStackSize - 1] = -1;
											}
											else
											{
												class69.intStack[++class69.intStackSize - 1] = mapicon_0.areaId;
												class69.intStack[++class69.intStackSize - 1] = mapicon_0.field236
												        .bitpack();
											}

											return 1;
										}
										else
										{
											Area area_0;
											if (int_0 == 6693)
											{
												int_1 = class69.intStack[--class69.intStackSize];
												area_0 = Area.mapAreaType[int_1];
												if (area_0.name == null)
												{
													class69.scriptStringStack[++WidgetNode.scriptStringStackSize
													        - 1] = "";
												}
												else
												{
													class69.scriptStringStack[++WidgetNode.scriptStringStackSize
													        - 1] = area_0.name;
												}

												return 1;
											}
											else if (int_0 == 6694)
											{
												int_1 = class69.intStack[--class69.intStackSize];
												area_0 = Area.mapAreaType[int_1];
												class69.intStack[++class69.intStackSize - 1] = area_0.field3243;
												return 1;
											}
											else if (int_0 == 6695)
											{
												int_1 = class69.intStack[--class69.intStackSize];
												area_0 = Area.mapAreaType[int_1];
												if (area_0 == null)
												{
													class69.intStack[++class69.intStackSize - 1] = -1;
												}
												else
												{
													class69.intStack[++class69.intStackSize - 1] = area_0.field3240;
												}

												return 1;
											}
											else if (int_0 == 6696)
											{
												int_1 = class69.intStack[--class69.intStackSize];
												area_0 = Area.mapAreaType[int_1];
												if (area_0 == null)
												{
													class69.intStack[++class69.intStackSize - 1] = -1;
												}
												else
												{
													class69.intStack[++class69.intStackSize - 1] = area_0.spriteId;
												}

												return 1;
											}
											else if (int_0 == 6697)
											{
												class69.intStack[++class69.intStackSize
												        - 1] = ClassInfo.field3750.areaId;
												return 1;
											}
											else if (int_0 == 6698)
											{
												class69.intStack[++class69.intStackSize
												        - 1] = ClassInfo.field3750.field311.bitpack();
												return 1;
											}
											else if (int_0 == 6699)
											{
												class69.intStack[++class69.intStackSize
												        - 1] = ClassInfo.field3750.field308.bitpack();
												return 1;
											}
											else
											{
												return 2;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	static void method1563(final Widget widget_0, final int int_0, final int int_1, final boolean bool_0)
	{
		final int int_2 = widget_0.width;
		final int int_3 = widget_0.height;
		if (widget_0.dynamicWidth == 0)
		{
			widget_0.width = widget_0.originalWidth;
		}
		else if (widget_0.dynamicWidth == 1)
		{
			widget_0.width = int_0 - widget_0.originalWidth;
		}
		else if (widget_0.dynamicWidth == 2)
		{
			widget_0.width = (widget_0.originalWidth * int_0) >> 14;
		}

		if (widget_0.buttonType == 0)
		{
			widget_0.height = widget_0.originalHeight;
		}
		else if (widget_0.buttonType == 1)
		{
			widget_0.height = int_1 - widget_0.originalHeight;
		}
		else if (widget_0.buttonType == 2)
		{
			widget_0.height = (int_1 * widget_0.originalHeight) >> 14;
		}

		if (widget_0.dynamicWidth == 4)
		{
			widget_0.width = (widget_0.height * widget_0.field2622) / widget_0.field2623;
		}

		if (widget_0.buttonType == 4)
		{
			widget_0.height = (widget_0.field2623 * widget_0.width) / widget_0.field2622;
		}

		if (widget_0.contentType == 1337)
		{
			Game.field784 = widget_0;
		}

		if (bool_0 && (widget_0.onResizeListener != null) && ((int_2 != widget_0.width) || (int_3 != widget_0.height)))
		{
			final ScriptEvent scriptevent_0 = new ScriptEvent();
			scriptevent_0.widget = widget_0;
			scriptevent_0.objs = widget_0.onResizeListener;
			Game.field638.addFront(scriptevent_0);
		}

	}

}
