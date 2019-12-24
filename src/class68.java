public final class class68 extends Node
{

	static Deque field985;
	static int port2;
	int field984;
	int field989;
	int field981;
	int field988;
	int field983;
	int field992;
	int field991;
	int field987;
	class103 field993;
	int field982;
	int[] field986;
	int field990;
	class103 field980;
	ObjectComposition field994;

	static
	{
		field985 = new Deque();
	}

	void method1688()
	{
		final int int_0 = field987;
		final ObjectComposition objectcomposition_0 = field994.getImpostor();
		if (objectcomposition_0 != null)
		{
			field987 = objectcomposition_0.ambientSoundId;
			field991 = objectcomposition_0.int4 * 128;
			field989 = objectcomposition_0.int5;
			field982 = objectcomposition_0.int6;
			field986 = objectcomposition_0.field3417;
		}
		else
		{
			field987 = -1;
			field991 = 0;
			field989 = 0;
			field982 = 0;
			field986 = null;
		}

		if ((int_0 != field987) && (field993 != null))
		{
			MapIconReference.field310.method2009(field993);
			field993 = null;
		}

	}

	public static void method1696(final ScriptEvent scriptevent_0)
	{
		class309.method5674(scriptevent_0, 500000);
	}

	public static int parseInt(final CharSequence charsequence_0, final int int_0, final boolean bool_0)
	{
		if ((int_0 >= 2) && (int_0 <= 36))
		{
			boolean bool_1 = false;
			boolean bool_2 = false;
			int int_1 = 0;
			final int int_2 = charsequence_0.length();

			for (int int_3 = 0; int_3 < int_2; int_3++)
			{
				final char char_0 = charsequence_0.charAt(int_3);
				if (int_3 == 0)
				{
					if (char_0 == 45)
					{
						bool_1 = true;
						continue;
					}

					if (char_0 == 43)
					{
						continue;
					}
				}

				int int_5;
				if ((char_0 >= 48) && (char_0 <= 57))
				{
					int_5 = char_0 - 48;
				}
				else if ((char_0 >= 65) && (char_0 <= 90))
				{
					int_5 = char_0 - 55;
				}
				else
				{
					if ((char_0 < 97) || (char_0 > 122))
					{
						throw new NumberFormatException();
					}

					int_5 = char_0 - 87;
				}

				if (int_5 >= int_0)
				{
					throw new NumberFormatException();
				}

				if (bool_1)
				{
					int_5 = -int_5;
				}

				final int int_4 = int_5 + (int_1 * int_0);
				if ((int_4 / int_0) != int_1)
				{
					throw new NumberFormatException();
				}

				int_1 = int_4;
				bool_2 = true;
			}

			if (!bool_2)
			{
				throw new NumberFormatException();
			}
			else
			{
				return int_1;
			}
		}
		else
		{
			throw new IllegalArgumentException("");
		}
	}

	public static void method1698()
	{
		Widget.field2599.reset();
		Widget.Widget_cachedModels.reset();
		Widget.Widget_cachedFonts.reset();
		Widget.field2602.reset();
	}

	public static void method1697(final int int_0, final boolean bool_0, final int int_1)
	{
		if ((int_0 >= 8000) && (int_0 <= 48000))
		{
			AbstractSoundSystem.sampleRate = int_0;
			AbstractSoundSystem.audioHighMemory = bool_0;
			WorldMapType2.field230 = int_1;
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}

}
