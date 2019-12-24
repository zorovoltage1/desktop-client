import java.io.File;

public class class155
{

	static File jagexClDat;
	static File field1966;
	public static CacheFile randomDat;
	public static CacheFile dat2File;
	public static CacheFile idx255File;
	static String[] cacheLocations;

	static
	{
		randomDat = null;
		dat2File = null;
		idx255File = null;
	}

	public static int method3269(final CharSequence charsequence_0, final CharSequence charsequence_1, final int int_0)
	{
		final int int_1 = charsequence_0.length();
		final int int_2 = charsequence_1.length();
		int int_3 = 0;
		int int_4 = 0;
		byte byte_0 = 0;
		byte byte_1 = 0;

		while (((int_3 - byte_0) < int_1) || ((int_4 - byte_1) < int_2))
		{
			if ((int_3 - byte_0) >= int_1)
			{
				return -1;
			}

			if ((int_4 - byte_1) >= int_2)
			{
				return 1;
			}

			char char_0;
			if (byte_0 != 0)
			{
				char_0 = (char) byte_0;
			}
			else
			{
				char_0 = charsequence_0.charAt(int_3++);
			}

			char char_1;
			if (byte_1 != 0)
			{
				char_1 = (char) byte_1;
			}
			else
			{
				char_1 = charsequence_1.charAt(int_4++);
			}

			byte byte_2;
			if (char_0 == 198)
			{
				byte_2 = 69;
			}
			else if (char_0 == 230)
			{
				byte_2 = 101;
			}
			else if (char_0 == 223)
			{
				byte_2 = 115;
			}
			else if (char_0 == 338)
			{
				byte_2 = 69;
			}
			else if (char_0 == 339)
			{
				byte_2 = 101;
			}
			else
			{
				byte_2 = 0;
			}

			byte_0 = byte_2;
			byte byte_3;
			if (char_1 == 198)
			{
				byte_3 = 69;
			}
			else if (char_1 == 230)
			{
				byte_3 = 101;
			}
			else if (char_1 == 223)
			{
				byte_3 = 115;
			}
			else if (char_1 == 338)
			{
				byte_3 = 69;
			}
			else if (char_1 == 339)
			{
				byte_3 = 101;
			}
			else
			{
				byte_3 = 0;
			}

			byte_1 = byte_3;
			char_0 = WorldMapRectangle.method169(char_0, int_0);
			char_1 = WorldMapRectangle.method169(char_1, int_0);
			if ((char_0 != char_1) && (Character.toUpperCase(char_0) != Character.toUpperCase(char_1)))
			{
				char_0 = Character.toLowerCase(char_0);
				char_1 = Character.toLowerCase(char_1);
				if (char_1 != char_0)
				{
					return class139.method3145(char_0, int_0) - class139.method3145(char_1, int_0);
				}
			}
		}

		final int int_5 = Math.min(int_1, int_2);

		int int_6;
		char char_4;
		for (int_6 = 0; int_6 < int_5; int_6++)
		{
			char char_3 = charsequence_0.charAt(int_6);
			char_4 = charsequence_1.charAt(int_6);
			if ((char_4 != char_3) && (Character.toUpperCase(char_3) != Character.toUpperCase(char_4)))
			{
				char_3 = Character.toLowerCase(char_3);
				char_4 = Character.toLowerCase(char_4);
				if (char_4 != char_3)
				{
					return class139.method3145(char_3, int_0) - class139.method3145(char_4, int_0);
				}
			}
		}

		int_6 = int_1 - int_2;
		if (int_6 != 0)
		{
			return int_6;
		}
		else
		{
			for (int int_7 = 0; int_7 < int_5; int_7++)
			{
				char_4 = charsequence_0.charAt(int_7);
				final char char_2 = charsequence_1.charAt(int_7);
				if (char_4 != char_2)
				{
					return class139.method3145(char_4, int_0) - class139.method3145(char_2, int_0);
				}
			}

			return 0;
		}
	}

	static void method3275(final int int_0, final int int_1, final int int_2, final int int_3)
	{
		final Widget widget_0 = class146.getWidgetChild(int_0, int_1);
		if ((widget_0 != null) && (widget_0.onTargetEnterListener != null))
		{
			final ScriptEvent scriptevent_0 = new ScriptEvent();
			scriptevent_0.widget = widget_0;
			scriptevent_0.objs = widget_0.onTargetEnterListener;
			class68.method1696(scriptevent_0);
		}

		Game.field737 = int_3;
		Game.spellSelected = true;
		SoundTaskDataProvider.field361 = int_0;
		Game.field736 = int_1;
		Actor.field932 = int_2;
		Player.method1114(widget_0);
	}

}
