import java.util.Date;

public class MouseRecorder implements Runnable
{

	static int mapX;
	boolean isRunning;
	Object lock;
	int index;
	int[] xs;
	int[] ys;

	MouseRecorder()
	{
		isRunning = true;
		lock = new Object();
		index = 0;
		xs = new int[500];
		ys = new int[500];
	}

	@Override
	public void run()
	{
		for (; isRunning; Actor.method1539(50L))
		{
			synchronized (lock)
			{
				if (index < 500)
				{
					xs[index] = MouseInput.mouseLastX;
					ys[index] = MouseInput.mouseLastY * 673804999;
					++index;
				}
			}
		}

	}

	public static Spotanim getSpotAnimType(final int int_0)
	{
		Spotanim spotanim_0 = (Spotanim) Spotanim.spotanims.get(int_0);
		if (spotanim_0 != null)
		{
			return spotanim_0;
		}
		else
		{
			final byte[] bytes_0 = Spotanim.SpotAnimationDefinition_indexCache.getConfigData(13, int_0);
			spotanim_0 = new Spotanim();
			spotanim_0.id = int_0;
			if (bytes_0 != null)
			{
				spotanim_0.decode(new Buffer(bytes_0));
				spotanim_0.postDecode();
			}

			Spotanim.spotanims.put(spotanim_0, int_0);
			return spotanim_0;
		}
	}

	static int method1034(final int int_0, final Script script_0, final boolean bool_0)
	{
		String string_0;
		int int_1;
		if (int_0 == 4100)
		{
			string_0 = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
			int_1 = class69.intStack[--class69.intStackSize];
			class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = string_0 + int_1;
			return 1;
		}
		else
		{
			String string_3;
			if (int_0 == 4101)
			{
				WidgetNode.scriptStringStackSize -= 2;
				string_0 = class69.scriptStringStack[WidgetNode.scriptStringStackSize];
				string_3 = class69.scriptStringStack[WidgetNode.scriptStringStackSize + 1];
				class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = string_0 + string_3;
				return 1;
			}
			else
			{
				int int_11;
				if (int_0 == 4102)
				{
					string_0 = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
					int_1 = class69.intStack[--class69.intStackSize];
					final String[] strings_0 = class69.scriptStringStack;
					int_11 = ++WidgetNode.scriptStringStackSize - 1;
					String string_1;
					if (int_1 < 0)
					{
						string_1 = Integer.toString(int_1);
					}
					else
					{
						int int_2 = int_1;
						String string_2;
						if (int_1 < 0)
						{
							string_2 = Integer.toString(int_1, 10);
						}
						else
						{
							int int_5 = 2;

							for (int int_6 = int_1 / 10; int_6 != 0; int_5++)
							{
								int_6 /= 10;
							}

							final char[] chars_0 = new char[int_5];
							chars_0[0] = 43;

							for (int int_7 = int_5 - 1; int_7 > 0; --int_7)
							{
								final int int_8 = int_2;
								int_2 /= 10;
								final int int_9 = int_8 - (int_2 * 10);
								if (int_9 >= 10)
								{
									chars_0[int_7] = (char) (int_9 + 87);
								}
								else
								{
									chars_0[int_7] = (char) (int_9 + 48);
								}
							}

							string_2 = new String(chars_0);
						}

						string_1 = string_2;
					}

					strings_0[int_11] = string_0 + string_1;
					return 1;
				}
				else if (int_0 == 4103)
				{
					string_0 = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
					class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = string_0.toLowerCase();
					return 1;
				}
				else
				{
					int int_3;
					if (int_0 == 4104)
					{
						int_3 = class69.intStack[--class69.intStackSize];
						final long long_0 = 86400000L * (int_3 + 11745L);
						class69.field1007.setTime(new Date(long_0));
						int_11 = class69.field1007.get(5);
						final int int_12 = class69.field1007.get(2);
						final int int_4 = class69.field1007.get(1);
						class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = int_11 + "-"
						        + class69.field998[int_12] + "-" + int_4;
						return 1;
					}
					else if (int_0 == 4105)
					{
						WidgetNode.scriptStringStackSize -= 2;
						string_0 = class69.scriptStringStack[WidgetNode.scriptStringStackSize];
						string_3 = class69.scriptStringStack[WidgetNode.scriptStringStackSize + 1];
						if ((class138.localPlayer.composition != null) && class138.localPlayer.composition.isFemale)
						{
							class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = string_3;
						}
						else
						{
							class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = string_0;
						}

						return 1;
					}
					else if (int_0 == 4106)
					{
						int_3 = class69.intStack[--class69.intStackSize];
						class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = Integer.toString(int_3);
						return 1;
					}
					else if (int_0 == 4107)
					{
						WidgetNode.scriptStringStackSize -= 2;
						final int[] ints_1 = class69.intStack;
						int_1 = ++class69.intStackSize - 1;
						int_11 = class155.method3269(class69.scriptStringStack[WidgetNode.scriptStringStackSize],
						        class69.scriptStringStack[WidgetNode.scriptStringStackSize + 1], Game.languageId);
						byte byte_0;
						if (int_11 > 0)
						{
							byte_0 = 1;
						}
						else if (int_11 < 0)
						{
							byte_0 = -1;
						}
						else
						{
							byte_0 = 0;
						}

						ints_1[int_1] = byte_0;
						return 1;
					}
					else
					{
						Font font_0;
						int int_10;
						byte[] bytes_0;
						if (int_0 == 4108)
						{
							string_0 = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
							class69.intStackSize -= 2;
							int_1 = class69.intStack[class69.intStackSize];
							int_10 = class69.intStack[class69.intStackSize + 1];
							bytes_0 = class50.indexCache13.getConfigData(int_10, 0);
							font_0 = new Font(bytes_0);
							class69.intStack[++class69.intStackSize - 1] = font_0.method5520(string_0, int_1);
							return 1;
						}
						else if (int_0 == 4109)
						{
							string_0 = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
							class69.intStackSize -= 2;
							int_1 = class69.intStack[class69.intStackSize];
							int_10 = class69.intStack[class69.intStackSize + 1];
							bytes_0 = class50.indexCache13.getConfigData(int_10, 0);
							font_0 = new Font(bytes_0);
							class69.intStack[++class69.intStackSize - 1] = font_0.method5519(string_0, int_1);
							return 1;
						}
						else if (int_0 == 4110)
						{
							WidgetNode.scriptStringStackSize -= 2;
							string_0 = class69.scriptStringStack[WidgetNode.scriptStringStackSize];
							string_3 = class69.scriptStringStack[WidgetNode.scriptStringStackSize + 1];
							if (class69.intStack[--class69.intStackSize] == 1)
							{
								class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = string_0;
							}
							else
							{
								class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = string_3;
							}

							return 1;
						}
						else if (int_0 == 4111)
						{
							string_0 = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
							class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = FontTypeFace
							        .appendTags(string_0);
							return 1;
						}
						else if (int_0 == 4112)
						{
							string_0 = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
							int_1 = class69.intStack[--class69.intStackSize];
							class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = string_0 + (char) int_1;
							return 1;
						}
						else if (int_0 == 4113)
						{
							int_3 = class69.intStack[--class69.intStackSize];
							class69.intStack[++class69.intStackSize - 1] = class52.method1002((char) int_3) ? 1 : 0;
							return 1;
						}
						else if (int_0 == 4114)
						{
							int_3 = class69.intStack[--class69.intStackSize];
							class69.intStack[++class69.intStackSize - 1] = class161.method3362((char) int_3) ? 1 : 0;
							return 1;
						}
						else
						{
							int[] ints_0;
							boolean bool_1;
							char char_0;
							if (int_0 == 4115)
							{
								int_3 = class69.intStack[--class69.intStackSize];
								ints_0 = class69.intStack;
								int_10 = ++class69.intStackSize - 1;
								char_0 = (char) int_3;
								bool_1 = ((char_0 >= 65) && (char_0 <= 90)) || ((char_0 >= 97) && (char_0 <= 122));
								ints_0[int_10] = bool_1 ? 1 : 0;
								return 1;
							}
							else if (int_0 != 4116)
							{
								if (int_0 == 4117)
								{
									string_0 = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
									if (string_0 != null)
									{
										class69.intStack[++class69.intStackSize - 1] = string_0.length();
									}
									else
									{
										class69.intStack[++class69.intStackSize - 1] = 0;
									}

									return 1;
								}
								else if (int_0 == 4118)
								{
									string_0 = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
									class69.intStackSize -= 2;
									int_1 = class69.intStack[class69.intStackSize];
									int_10 = class69.intStack[class69.intStackSize + 1];
									class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = string_0
									        .substring(int_1, int_10);
									return 1;
								}
								else if (int_0 == 4119)
								{
									string_0 = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
									final StringBuilder stringbuilder_0 = new StringBuilder(string_0.length());
									boolean bool_2 = false;

									for (int_11 = 0; int_11 < string_0.length(); int_11++)
									{
										char_0 = string_0.charAt(int_11);
										if (char_0 == 60)
										{
											bool_2 = true;
										}
										else if (char_0 == 62)
										{
											bool_2 = false;
										}
										else if (!bool_2)
										{
											stringbuilder_0.append(char_0);
										}
									}

									class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = stringbuilder_0
									        .toString();
									return 1;
								}
								else if (int_0 == 4120)
								{
									string_0 = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
									int_1 = class69.intStack[--class69.intStackSize];
									class69.intStack[++class69.intStackSize - 1] = string_0.indexOf(int_1);
									return 1;
								}
								else if (int_0 == 4121)
								{
									WidgetNode.scriptStringStackSize -= 2;
									string_0 = class69.scriptStringStack[WidgetNode.scriptStringStackSize];
									string_3 = class69.scriptStringStack[WidgetNode.scriptStringStackSize + 1];
									int_10 = class69.intStack[--class69.intStackSize];
									class69.intStack[++class69.intStackSize - 1] = string_0.indexOf(string_3, int_10);
									return 1;
								}
								else
								{
									return 2;
								}
							}
							else
							{
								int_3 = class69.intStack[--class69.intStackSize];
								ints_0 = class69.intStack;
								int_10 = ++class69.intStackSize - 1;
								char_0 = (char) int_3;
								bool_1 = (char_0 >= 48) && (char_0 <= 57);
								ints_0[int_10] = bool_1 ? 1 : 0;
								return 1;
							}
						}
					}
				}
			}
		}
	}

	public static void method1036()
	{
		ItemComposition.items.reset();
		ItemComposition.itemModelCache.reset();
		ItemComposition.itemSpriteCache.reset();
	}

}
