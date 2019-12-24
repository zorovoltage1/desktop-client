public class class25
{

	static final class25 field212;
	static final class25 field209;
	static int[] tt;
	static IndexedSprite[] mapscene;
	final int field211;

	static
	{
		field212 = new class25(0);
		field209 = new class25(1);
	}

	class25(final int int_0)
	{
		field211 = int_0;
	}

	static boolean method426(final Widget widget_0)
	{
		final int int_0 = widget_0.contentType;
		if (int_0 == 205)
		{
			Game.field627 = 250;
			return true;
		}
		else
		{
			int int_1;
			int int_2;
			if ((int_0 >= 300) && (int_0 <= 313))
			{
				int_1 = (int_0 - 300) / 2;
				int_2 = int_0 & 0x1;
				Game.customizedAppearance.method4478(int_1, int_2 == 1);
			}

			if ((int_0 >= 314) && (int_0 <= 323))
			{
				int_1 = (int_0 - 314) / 2;
				int_2 = int_0 & 0x1;
				Game.customizedAppearance.method4493(int_1, int_2 == 1);
			}

			if (int_0 == 324)
			{
				Game.customizedAppearance.method4465(false);
			}

			if (int_0 == 325)
			{
				Game.customizedAppearance.method4465(true);
			}

			if (int_0 == 326)
			{
				final PacketNode packetnode_0 = class26.method433(ClientPacket.APPEARANCE, Game.field626.field1218);
				Game.customizedAppearance.method4466(packetnode_0.packetBuffer);
				Game.field626.method1980(packetnode_0);
				return true;
			}
			else
			{
				return false;
			}
		}
	}

}
