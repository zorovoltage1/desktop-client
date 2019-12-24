public class class304
{

	public static char[] field3722;
	static char[] field3723;
	static int[] field3724;

	static
	{
		field3722 = new char[64];

		int int_0;
		for (int_0 = 0; int_0 < 26; int_0++)
		{
			field3722[int_0] = (char) (int_0 + 65);
		}

		for (int_0 = 26; int_0 < 52; int_0++)
		{
			field3722[int_0] = (char) ((int_0 + 97) - 26);
		}

		for (int_0 = 52; int_0 < 62; int_0++)
		{
			field3722[int_0] = (char) ((int_0 + 48) - 52);
		}

		field3722[62] = 43;
		field3722[63] = 47;
		field3723 = new char[64];

		for (int_0 = 0; int_0 < 26; int_0++)
		{
			field3723[int_0] = (char) (int_0 + 65);
		}

		for (int_0 = 26; int_0 < 52; int_0++)
		{
			field3723[int_0] = (char) ((int_0 + 97) - 26);
		}

		for (int_0 = 52; int_0 < 62; int_0++)
		{
			field3723[int_0] = (char) ((int_0 + 48) - 52);
		}

		field3723[62] = 42;
		field3723[63] = 45;
		field3724 = new int[128];

		for (int_0 = 0; int_0 < field3724.length; int_0++)
		{
			field3724[int_0] = -1;
		}

		for (int_0 = 65; int_0 <= 90; int_0++)
		{
			field3724[int_0] = int_0 - 65;
		}

		for (int_0 = 97; int_0 <= 122; int_0++)
		{
			field3724[int_0] = (int_0 - 97) + 26;
		}

		for (int_0 = 48; int_0 <= 57; int_0++)
		{
			field3724[int_0] = (int_0 - 48) + 52;
		}

		final int[] ints_0 = field3724;
		field3724[43] = 62;
		ints_0[42] = 62;
		final int[] ints_1 = field3724;
		field3724[47] = 63;
		ints_1[45] = 63;
	}

	public static String method5634(final CharSequence charsequence_0)
	{
		final int int_0 = charsequence_0.length();
		final StringBuilder stringbuilder_0 = new StringBuilder(int_0);

		for (int int_1 = 0; int_1 < int_0; int_1++)
		{
			final char char_0 = charsequence_0.charAt(int_1);
			if (((char_0 < 97) || (char_0 > 122)) && ((char_0 < 65) || (char_0 > 90))
			        && ((char_0 < 48) || (char_0 > 57)) && (char_0 != 46) && (char_0 != 45) && (char_0 != 42)
			        && (char_0 != 95))
			{
				if (char_0 == 32)
				{
					stringbuilder_0.append('+');
				}
				else
				{
					final byte byte_0 = class166.charToByteCp1252(char_0);
					stringbuilder_0.append('%');
					int int_2 = (byte_0 >> 4) & 0xF;
					if (int_2 >= 10)
					{
						stringbuilder_0.append((char) (int_2 + 55));
					}
					else
					{
						stringbuilder_0.append((char) (int_2 + 48));
					}

					int_2 = byte_0 & 0xF;
					if (int_2 >= 10)
					{
						stringbuilder_0.append((char) (int_2 + 55));
					}
					else
					{
						stringbuilder_0.append((char) (int_2 + 48));
					}
				}
			}
			else
			{
				stringbuilder_0.append(char_0);
			}
		}

		return stringbuilder_0.toString();
	}

	static void method5635(final Widget[] widgets_0, final int int_0, final int int_1, final int int_2,
	        final boolean bool_0)
	{
		for (int int_3 = 0; int_3 < widgets_0.length; int_3++)
		{
			final Widget widget_0 = widgets_0[int_3];
			if ((widget_0 != null) && (widget_0.parentHash == int_0))
			{
				CombatInfo1.method1563(widget_0, int_1, int_2, bool_0);
				MapLabel.method281(widget_0, int_1, int_2);
				if (widget_0.scrollX > (widget_0.scrollWidth - widget_0.width))
				{
					widget_0.scrollX = widget_0.scrollWidth - widget_0.width;
				}

				if (widget_0.scrollX < 0)
				{
					widget_0.scrollX = 0;
				}

				if (widget_0.scrollY > (widget_0.scrollHeight - widget_0.height))
				{
					widget_0.scrollY = widget_0.scrollHeight - widget_0.height;
				}

				if (widget_0.scrollY < 0)
				{
					widget_0.scrollY = 0;
				}

				if (widget_0.type == 0)
				{
					GameSocket.method3388(widgets_0, widget_0, bool_0);
				}
			}
		}

	}

}
