public class class10 extends class16
{

	static Preferences preferences;

	void method95(final Buffer buffer_0, final Buffer buffer_1)
	{
		int int_0 = buffer_1.readUnsignedByte();
		if (int_0 != class25.field212.field211)
		{
			throw new IllegalStateException("");
		}
		else
		{
			super.field120 = buffer_1.readUnsignedByte();
			super.field121 = buffer_1.readUnsignedByte();
			super.field127 = buffer_1.readUnsignedShort();
			super.field117 = buffer_1.readUnsignedShort();
			super.field118 = buffer_1.readUnsignedShort();
			super.field119 = buffer_1.readUnsignedShort();
			super.field121 = Math.min(super.field121, 4);
			super.field125 = new short[1][64][64];
			super.field123 = new short[super.field121][64][64];
			super.field124 = new byte[super.field121][64][64];
			super.field116 = new byte[super.field121][64][64];
			super.decorations = new WorldMapDecoration[super.field121][64][64][];
			int_0 = buffer_0.readUnsignedByte();
			if (int_0 != class24.field208.field205)
			{
				throw new IllegalStateException("");
			}
			else
			{
				final int int_1 = buffer_0.readUnsignedByte();
				final int int_2 = buffer_0.readUnsignedByte();
				if ((int_1 == super.field118) && (int_2 == super.field119))
				{
					for (int int_3 = 0; int_3 < 64; int_3++)
					{
						for (int int_4 = 0; int_4 < 64; int_4++)
						{
							method150(int_3, int_4, buffer_0);
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

	@Override
	public boolean equals(final Object object_0)
	{
		if (!(object_0 instanceof class10))
		{
			return false;
		}
		else
		{
			final class10 class10_1 = (class10) object_0;
			return (super.field118 == class10_1.field118) && (class10_1.field119 == super.field119);
		}
	}

	@Override
	public int hashCode()
	{
		return super.field118 | (super.field119 << 8);
	}

	static void setItemTableSlot(final int int_0, final int int_1, final int int_2, final int int_3)
	{
		ItemContainer itemcontainer_0 = (ItemContainer) ItemContainer.itemContainers.get(int_0);
		if (itemcontainer_0 == null)
		{
			itemcontainer_0 = new ItemContainer();
			ItemContainer.itemContainers.put(itemcontainer_0, int_0);
		}

		if (itemcontainer_0.itemIds.length <= int_1)
		{
			final int[] ints_0 = new int[int_1 + 1];
			final int[] ints_1 = new int[int_1 + 1];

			int int_4;
			for (int_4 = 0; int_4 < itemcontainer_0.itemIds.length; int_4++)
			{
				ints_0[int_4] = itemcontainer_0.itemIds[int_4];
				ints_1[int_4] = itemcontainer_0.stackSizes[int_4];
			}

			for (int_4 = itemcontainer_0.itemIds.length; int_4 < int_1; int_4++)
			{
				ints_0[int_4] = -1;
				ints_1[int_4] = 0;
			}

			itemcontainer_0.itemIds = ints_0;
			itemcontainer_0.stackSizes = ints_1;
		}

		itemcontainer_0.itemIds[int_1] = int_2;
		itemcontainer_0.stackSizes[int_1] = int_3;
	}

	static Script newScript(final byte[] bytes_0)
	{
		final Script script_0 = new Script();
		final Buffer buffer_0 = new Buffer(bytes_0);
		buffer_0.offset = buffer_0.payload.length - 2;
		final int int_0 = buffer_0.readUnsignedShort();
		final int int_1 = buffer_0.payload.length - 2 - int_0 - 12;
		buffer_0.offset = int_1;
		final int int_2 = buffer_0.readInt();
		script_0.localIntCount = buffer_0.readUnsignedShort();
		script_0.localStringCount = buffer_0.readUnsignedShort();
		script_0.intStackCount = buffer_0.readUnsignedShort();
		script_0.stringStackCount = buffer_0.readUnsignedShort();
		final int int_3 = buffer_0.readUnsignedByte();
		int int_4;
		int int_5;
		if (int_3 > 0)
		{
			script_0.switches = script_0.method1944(int_3);

			for (int_4 = 0; int_4 < int_3; int_4++)
			{
				int_5 = buffer_0.readUnsignedShort();
				final IterableHashTable iterablehashtable_0 = new IterableHashTable(
				        int_5 > 0 ? class146.nextPowerOfTwo(int_5) : 1);
				script_0.switches[int_4] = iterablehashtable_0;

				while (int_5-- > 0)
				{
					final int int_6 = buffer_0.readInt();
					final int int_7 = buffer_0.readInt();
					iterablehashtable_0.put(new IntegerNode(int_7), int_6);
				}
			}
		}

		buffer_0.offset = 0;
		buffer_0.getNullString();
		script_0.instructions = new int[int_2];
		script_0.intOperands = new int[int_2];
		script_0.stringOperands = new String[int_2];

		for (int_4 = 0; buffer_0.offset < int_1; script_0.instructions[int_4++] = int_5)
		{
			int_5 = buffer_0.readUnsignedShort();
			if (int_5 == 3)
			{
				script_0.stringOperands[int_4] = buffer_0.readString();
			}
			else if ((int_5 < 100) && (int_5 != 21) && (int_5 != 38) && (int_5 != 39))
			{
				script_0.intOperands[int_4] = buffer_0.readInt();
			}
			else
			{
				script_0.intOperands[int_4] = buffer_0.readUnsignedByte();
			}
		}

		return script_0;
	}

	static boolean method92()
	{
		if ((Game.field781 != null) && (Game.field606 < Game.field781.size()))
		{
			while (Game.field606 < Game.field781.size())
			{
				final class52 class52_0 = (class52) Game.field781.get(Game.field606);
				if (!class52_0.method1000())
				{
					return false;
				}

				++Game.field606;
			}

			return true;
		}
		else
		{
			return true;
		}
	}

}
