import java.text.DecimalFormat;

public class class78
{

	static boolean field1101;
	static int field1082;
	static IndexedSprite field1083;
	static IndexedSprite field1084;
	static IndexedSprite[] runeSprites;
	static SpritePixels field1092;
	static SpritePixels field1087;
	static IndexedSprite field1089;
	static int loginWindowX;
	static int field1091;
	static int[] field1093;
	static int field1088;
	static int field1094;
	static int field1095;
	static int field1096;
	static int field1097;
	static int field1114;
	static int loadingBarPercentage;
	static String loadingText;
	static int loginIndex;
	static String Login_response0;
	static String loginMessage1;
	static String loginMessage2;
	static String loginMessage3;
	static String username;
	static String password;
	static boolean Login_isUsernameRemembered;
	static boolean field1110;
	static boolean field1115;
	static boolean field1104;
	static int currentLoginField;
	static boolean worldSelectShown;
	static int field1116;
	static long field1109;
	static long field1118;

	static
	{
		field1082 = 0;
		loginWindowX = field1082 + 202;
		field1093 = new int[256];
		field1088 = 0;
		field1094 = 0;
		field1095 = 0;
		field1096 = 0;
		field1097 = 0;
		field1114 = 0;
		loadingBarPercentage = 10;
		loadingText = "";
		loginIndex = 0;
		Login_response0 = "";
		loginMessage1 = "";
		loginMessage2 = "";
		loginMessage3 = "";
		username = "";
		password = "";
		Login_isUsernameRemembered = false;
		field1110 = false;
		field1115 = false;
		field1104 = true;
		currentLoginField = 0;
		worldSelectShown = false;
		field1116 = -1;
		new DecimalFormat("##0.00");
		new class148();
		field1109 = -1L;
		field1118 = -1L;
	}

	public static String getString(final byte[] bytes_0, final int int_0, final int int_1)
	{
		final char[] chars_0 = new char[int_1];
		int int_2 = 0;

		for (int int_3 = 0; int_3 < int_1; int_3++)
		{
			int int_4 = bytes_0[int_3 + int_0] & 0xFF;
			if (int_4 != 0)
			{
				if ((int_4 >= 128) && (int_4 < 160))
				{
					char char_0 = class301.cp1252AsciiExtension[int_4 - 128];
					if (char_0 == 0)
					{
						char_0 = 63;
					}

					int_4 = char_0;
				}

				chars_0[int_2++] = (char) int_4;
			}
		}

		return new String(chars_0, 0, int_2);
	}

}
