public final class DecorativeObject
{

	static int field1834;
	int renderFlag;
	int floor;
	int x;
	int y;
	int rotation;
	int offsetX;
	int offsetY;
	public Renderable field1823;
	public Renderable renderable2;
	public long field1824;
	int field1833;

	DecorativeObject()
	{
		field1824 = 0L;
		field1833 = 0;
	}

	static Script method3099(final int int_0)
	{
		Script script_0 = (Script) Script.field1190.get(int_0);
		if (script_0 != null)
		{
			return script_0;
		}
		else
		{
			final byte[] bytes_0 = Game.indexScripts.getConfigData(int_0, 0);
			if (bytes_0 == null)
			{
				return null;
			}
			else
			{
				script_0 = class10.newScript(bytes_0);
				script_0.id = int_0;
				Script.field1190.put(script_0, int_0);
				return script_0;
			}
		}
	}

	public static void method3100(final String[] strings_0, final short[] shorts_0)
	{
		method3101(strings_0, shorts_0, 0, strings_0.length - 1);
	}

	static void method3101(final String[] strings_0, final short[] shorts_0, final int int_0, final int int_1)
	{
		if (int_0 < int_1)
		{
			final int int_2 = (int_1 + int_0) / 2;
			int int_3 = int_0;
			final String string_0 = strings_0[int_2];
			strings_0[int_2] = strings_0[int_1];
			strings_0[int_1] = string_0;
			final short short_0 = shorts_0[int_2];
			shorts_0[int_2] = shorts_0[int_1];
			shorts_0[int_1] = short_0;

			for (int int_4 = int_0; int_4 < int_1; int_4++)
			{
				if ((string_0 == null)
				        || ((strings_0[int_4] != null) && (strings_0[int_4].compareTo(string_0) < (int_4 & 0x1))))
				{
					final String string_1 = strings_0[int_4];
					strings_0[int_4] = strings_0[int_3];
					strings_0[int_3] = string_1;
					final short short_1 = shorts_0[int_4];
					shorts_0[int_4] = shorts_0[int_3];
					shorts_0[int_3++] = short_1;
				}
			}

			strings_0[int_1] = strings_0[int_3];
			strings_0[int_3] = string_0;
			shorts_0[int_1] = shorts_0[int_3];
			shorts_0[int_3] = short_0;
			method3101(strings_0, shorts_0, int_0, int_3 - 1);
			method3101(strings_0, shorts_0, int_3 + 1, int_1);
		}

	}

	static void method3098()
	{
		final short short_0 = 256;
		int int_0;
		if (class78.field1088 > 0)
		{
			for (int_0 = 0; int_0 < 256; int_0++)
			{
				if (class78.field1088 > 768)
				{
					AttackOption.field1077[int_0] = class33.method558(CombatInfo1.field936[int_0],
					        class185.field2364[int_0], 1024 - class78.field1088);
				}
				else if (class78.field1088 > 256)
				{
					AttackOption.field1077[int_0] = class185.field2364[int_0];
				}
				else
				{
					AttackOption.field1077[int_0] = class33.method558(class185.field2364[int_0],
					        CombatInfo1.field936[int_0], 256 - class78.field1088);
				}
			}
		}
		else if (class78.field1094 > 0)
		{
			for (int_0 = 0; int_0 < 256; int_0++)
			{
				if (class78.field1094 > 768)
				{
					AttackOption.field1077[int_0] = class33.method558(CombatInfo1.field936[int_0],
					        class11.field69[int_0], 1024 - class78.field1094);
				}
				else if (class78.field1094 > 256)
				{
					AttackOption.field1077[int_0] = class11.field69[int_0];
				}
				else
				{
					AttackOption.field1077[int_0] = class33.method558(class11.field69[int_0],
					        CombatInfo1.field936[int_0], 256 - class78.field1094);
				}
			}
		}
		else
		{
			for (int_0 = 0; int_0 < 256; int_0++)
			{
				AttackOption.field1077[int_0] = CombatInfo1.field936[int_0];
			}
		}

		Rasterizer2D.setDrawRegion(class78.field1082, 9, class78.field1082 + 128, short_0 + 7);
		//class78.field1092.method5849(class78.field1082, 0);
		Rasterizer2D.noClip();
		int_0 = 0;
		int int_1 = (GameSocket.rasterProvider.width * 9) + class78.field1082;

		int int_2;
		int int_3;
		int int_4;
		int int_5;
		int int_6;
		int int_7;
		int int_8;
		int int_9;
		for (int_2 = 1; int_2 < (short_0 - 1); int_2++)
		{
			int_3 = (class78.field1093[int_2] * (short_0 - int_2)) / short_0;
			int_4 = int_3 + 22;
			if (int_4 < 0)
			{
				int_4 = 0;
			}

			int_0 += int_4;

			for (int_5 = int_4; int_5 < 128; int_5++)
			{
				int_6 = SoundTaskDataProvider.field357[int_0++];
				if (int_6 != 0)
				{
					int_7 = int_6;
					int_8 = 256 - int_6;
					int_6 = AttackOption.field1077[int_6];
					int_9 = GameSocket.rasterProvider.pixels[int_1];
					GameSocket.rasterProvider.pixels[int_1++] = (((((int_6 & 0xFF00FF) * int_7)
					        + ((int_9 & 0xFF00FF) * int_8)) & 0xFF00FF00)
					        + (((int_7 * (int_6 & 0xFF00)) + (int_8 * (int_9 & 0xFF00))) & 0xFF0000)) >> 8;
				}
				else
				{
					++int_1;
				}
			}

			int_1 += (int_4 + GameSocket.rasterProvider.width) - 128;
		}

		Rasterizer2D.setDrawRegion((class78.field1082 + 765) - 128, 9, class78.field1082 + 765, short_0 + 7);
		//class78.field1087.method5849(class78.field1082 + 382, 0);
		Rasterizer2D.noClip();
		int_0 = 0;
		int_1 = (GameSocket.rasterProvider.width * 9) + class78.field1082 + 637 + 24;

		for (int_2 = 1; int_2 < (short_0 - 1); int_2++)
		{
			int_3 = (class78.field1093[int_2] * (short_0 - int_2)) / short_0;
			int_4 = 103 - int_3;
			int_1 += int_3;

			for (int_5 = 0; int_5 < int_4; int_5++)
			{
				int_6 = SoundTaskDataProvider.field357[int_0++];
				if (int_6 != 0)
				{
					int_7 = int_6;
					int_8 = 256 - int_6;
					int_6 = AttackOption.field1077[int_6];
					int_9 = GameSocket.rasterProvider.pixels[int_1];
					GameSocket.rasterProvider.pixels[int_1++] = (((((int_6 & 0xFF00FF) * int_7)
					        + ((int_9 & 0xFF00FF) * int_8)) & 0xFF00FF00)
					        + (((int_8 * (int_9 & 0xFF00)) + (int_7 * (int_6 & 0xFF00))) & 0xFF0000)) >> 8;
				}
				else
				{
					++int_1;
				}
			}

			int_0 += 128 - int_4;
			int_1 += GameSocket.rasterProvider.width - int_4 - int_3;
		}

	}

}
