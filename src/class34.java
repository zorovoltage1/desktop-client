public class class34 extends class16
{

	static IndexFile indexStore255;
	static int field301;
	int field299;
	int field297;
	int field298;
	int field296;

	void method561(final Buffer buffer_0, final Buffer buffer_1)
	{
		int int_0 = buffer_1.readUnsignedByte();
		if (int_0 != class25.field209.field211)
		{
			throw new IllegalStateException("");
		}
		else
		{
			super.field120 = buffer_1.readUnsignedByte();
			super.field121 = buffer_1.readUnsignedByte();
			super.field127 = buffer_1.readUnsignedShort();
			super.field117 = buffer_1.readUnsignedShort();
			field299 = buffer_1.readUnsignedByte();
			field297 = buffer_1.readUnsignedByte();
			super.field118 = buffer_1.readUnsignedShort();
			super.field119 = buffer_1.readUnsignedShort();
			field298 = buffer_1.readUnsignedByte();
			field296 = buffer_1.readUnsignedByte();
			super.field121 = Math.min(super.field121, 4);
			super.field125 = new short[1][64][64];
			super.field123 = new short[super.field121][64][64];
			super.field124 = new byte[super.field121][64][64];
			super.field116 = new byte[super.field121][64][64];
			super.decorations = new WorldMapDecoration[super.field121][64][64][];
			int_0 = buffer_0.readUnsignedByte();
			if (int_0 != class24.field204.field205)
			{
				throw new IllegalStateException("");
			}
			else
			{
				final int int_1 = buffer_0.readUnsignedByte();
				final int int_2 = buffer_0.readUnsignedByte();
				final int int_3 = buffer_0.readUnsignedByte();
				final int int_4 = buffer_0.readUnsignedByte();
				if ((int_1 == super.field118) && (int_2 == super.field119) && (int_3 == field298)
				        && (int_4 == field296))
				{
					for (int int_5 = 0; int_5 < 8; int_5++)
					{
						for (int int_6 = 0; int_6 < 8; int_6++)
						{
							method150(int_5 + (field298 * 8), int_6 + (field296 * 8), buffer_0);
						}
					}

				}
				else
				{
					throw new IllegalStateException("");
				}
			}
		}
	}

	boolean method562(final int int_0, final int int_1)
	{
		return int_0 >= (field298 * 8) && (int_1 >= (field296 * 8) && (int_0 < ((field298 * 8) + 8) && int_1 < ((field296 * 8) + 8)));
	}

	int method584()
	{
		return field299;
	}

	int method564()
	{
		return field297;
	}

	int method565()
	{
		return field298;
	}

	int method563()
	{
		return field296;
	}

	@Override
	public boolean equals(final Object object_0)
	{
		if (!(object_0 instanceof class34))
		{
			return false;
		}
		else
		{
			final class34 class34_1 = (class34) object_0;
			return ((class34_1.field118 == super.field118) && (super.field119 == class34_1.field119)) && ((class34_1.field298 == field298) && (class34_1.field296 == field296));
		}
	}

	@Override
	public int hashCode()
	{
		return super.field118 | (super.field119 << 8) | (field298 << 16) | (field296 << 24);
	}

	static void method586()
	{
		if (class78.Login_isUsernameRemembered && (class78.username != null) && (class78.username.length() > 0))
		{
			class78.currentLoginField = 1;
		}
		else
		{
			class78.currentLoginField = 0;
		}

	}

	static int method560(final int int_0, int int_1, final int int_2)
	{
		if (int_2 > 179)
		{
			int_1 /= 2;
		}

		if (int_2 > 192)
		{
			int_1 /= 2;
		}

		if (int_2 > 217)
		{
			int_1 /= 2;
		}

		if (int_2 > 243)
		{
			int_1 /= 2;
		}

		final int int_3 = ((int_1 / 32) << 7) + ((int_0 / 4) << 10) + (int_2 / 2);
		return int_3;
	}

	static void method585()
	{
		if (Game.spellSelected)
		{
			final Widget widget_0 = class146.getWidgetChild(SoundTaskDataProvider.field361, Game.field736);
			if ((widget_0 != null) && (widget_0.onTargetLeaveListener != null))
			{
				final ScriptEvent scriptevent_0 = new ScriptEvent();
				scriptevent_0.widget = widget_0;
				scriptevent_0.objs = widget_0.onTargetLeaveListener;
				class68.method1696(scriptevent_0);
			}

			Game.spellSelected = false;
			Player.method1114(widget_0);
		}
	}

}
