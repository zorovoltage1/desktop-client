import java.math.BigInteger;

public class class73
{

	static final BigInteger field1039 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
	static final BigInteger field1044 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");

	static int method1799(final int int_0, final Script script_0, final boolean bool_0)
	{
		int int_1;
		if (int_0 == 4200)
		{
			int_1 = class69.intStack[--class69.intStackSize];
			class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = TextureProvider
			        .getItemDefinition(int_1).name;
			return 1;
		}
		else
		{
			int int_2;
			ItemComposition itemcomposition_2;
			if (int_0 == 4201)
			{
				class69.intStackSize -= 2;
				int_1 = class69.intStack[class69.intStackSize];
				int_2 = class69.intStack[class69.intStackSize + 1];
				itemcomposition_2 = TextureProvider.getItemDefinition(int_1);
				if ((int_2 >= 1) && (int_2 <= 5) && (itemcomposition_2.groundActions[int_2 - 1] != null))
				{
					class69.scriptStringStack[++WidgetNode.scriptStringStackSize
					        - 1] = itemcomposition_2.groundActions[int_2 - 1];
				}
				else
				{
					class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = "";
				}

				return 1;
			}
			else if (int_0 == 4202)
			{
				class69.intStackSize -= 2;
				int_1 = class69.intStack[class69.intStackSize];
				int_2 = class69.intStack[class69.intStackSize + 1];
				itemcomposition_2 = TextureProvider.getItemDefinition(int_1);
				if ((int_2 >= 1) && (int_2 <= 5) && (itemcomposition_2.inventoryActions[int_2 - 1] != null))
				{
					class69.scriptStringStack[++WidgetNode.scriptStringStackSize
					        - 1] = itemcomposition_2.inventoryActions[int_2 - 1];
				}
				else
				{
					class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = "";
				}

				return 1;
			}
			else if (int_0 == 4203)
			{
				int_1 = class69.intStack[--class69.intStackSize];
				class69.intStack[++class69.intStackSize - 1] = TextureProvider.getItemDefinition(int_1).price;
				return 1;
			}
			else if (int_0 == 4204)
			{
				int_1 = class69.intStack[--class69.intStackSize];
				class69.intStack[++class69.intStackSize - 1] = TextureProvider.getItemDefinition(int_1).isStackable == 1
				        ? 1
				        : 0;
				return 1;
			}
			else
			{
				ItemComposition itemcomposition_0;
				if (int_0 == 4205)
				{
					int_1 = class69.intStack[--class69.intStackSize];
					itemcomposition_0 = TextureProvider.getItemDefinition(int_1);
					if ((itemcomposition_0.notedTemplate == -1) && (itemcomposition_0.note >= 0))
					{
						class69.intStack[++class69.intStackSize - 1] = itemcomposition_0.note;
					}
					else
					{
						class69.intStack[++class69.intStackSize - 1] = int_1;
					}

					return 1;
				}
				else if (int_0 == 4206)
				{
					int_1 = class69.intStack[--class69.intStackSize];
					itemcomposition_0 = TextureProvider.getItemDefinition(int_1);
					if ((itemcomposition_0.notedTemplate >= 0) && (itemcomposition_0.note >= 0))
					{
						class69.intStack[++class69.intStackSize - 1] = itemcomposition_0.note;
					}
					else
					{
						class69.intStack[++class69.intStackSize - 1] = int_1;
					}

					return 1;
				}
				else if (int_0 == 4207)
				{
					int_1 = class69.intStack[--class69.intStackSize];
					class69.intStack[++class69.intStackSize - 1] = TextureProvider.getItemDefinition(int_1).isMembers
					        ? 1
					        : 0;
					return 1;
				}
				else if (int_0 == 4208)
				{
					int_1 = class69.intStack[--class69.intStackSize];
					itemcomposition_0 = TextureProvider.getItemDefinition(int_1);
					if ((itemcomposition_0.placeholderTemplateId == -1) && (itemcomposition_0.placeholderId >= 0))
					{
						class69.intStack[++class69.intStackSize - 1] = itemcomposition_0.placeholderId;
					}
					else
					{
						class69.intStack[++class69.intStackSize - 1] = int_1;
					}

					return 1;
				}
				else if (int_0 == 4209)
				{
					int_1 = class69.intStack[--class69.intStackSize];
					itemcomposition_0 = TextureProvider.getItemDefinition(int_1);
					if ((itemcomposition_0.placeholderTemplateId >= 0) && (itemcomposition_0.placeholderId >= 0))
					{
						class69.intStack[++class69.intStackSize - 1] = itemcomposition_0.placeholderId;
					}
					else
					{
						class69.intStack[++class69.intStackSize - 1] = int_1;
					}

					return 1;
				}
				else if (int_0 == 4210)
				{
					final String string_1 = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
					int_2 = class69.intStack[--class69.intStackSize];
					final boolean bool_1 = int_2 == 1;
					final String string_0 = string_1.toLowerCase();
					short[] shorts_0 = new short[16];
					int int_3 = 0;
					int int_4 = 0;

					while (true)
					{
						if (int_4 >= ChatLineBuffer.field1212)
						{
							WorldMapType2.field231 = shorts_0;
							WidgetNode.field495 = 0;
							class126.field1778 = int_3;
							final String[] strings_0 = new String[class126.field1778];

							for (int int_5 = 0; int_5 < class126.field1778; int_5++)
							{
								strings_0[int_5] = TextureProvider.getItemDefinition(shorts_0[int_5]).name; //nick
							}

							DecorativeObject.method3100(strings_0, WorldMapType2.field231);
							break;
						}

						final ItemComposition itemcomposition_1 = TextureProvider.getItemDefinition(int_4);
						if ((!bool_1 || itemcomposition_1.isTradable) && (itemcomposition_1.notedTemplate == -1)
						        && (itemcomposition_1.name.toLowerCase().indexOf(string_0) != -1))
						{
							if (int_3 >= 250)
							{
								class126.field1778 = -1;
								WorldMapType2.field231 = null;
								break;
							}

							if (int_3 >= shorts_0.length)
							{
								final short[] shorts_1 = new short[shorts_0.length * 2];

								for (int int_6 = 0; int_6 < int_3; int_6++)
								{
									shorts_1[int_6] = shorts_0[int_6];
								}

								shorts_0 = shorts_1;
							}

							shorts_0[int_3++] = (short) int_4;
						}

						++int_4;
					}

					class69.intStack[++class69.intStackSize - 1] = class126.field1778;
					return 1;
				}
				else if (int_0 != 4211)
				{
					if (int_0 == 4212)
					{
						WidgetNode.field495 = 0;
						return 1;
					}
					else
					{
						return 2;
					}
				}
				else
				{
					if ((WorldMapType2.field231 != null) && (WidgetNode.field495 < class126.field1778))
					{
						class69.intStack[++class69.intStackSize - 1] = WorldMapType2.field231[++WidgetNode.field495 - 1]
						        & 0xFFFF;
					}
					else
					{
						class69.intStack[++class69.intStackSize - 1] = -1;
					}

					return 1;
				}
			}
		}
	}

}
