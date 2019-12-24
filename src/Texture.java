public class Texture extends Node
{

	static int[] field1541;
	int field1527;
	boolean field1530;
	int[] fileIds;
	int[] field1535;
	int[] field1532;
	int[] field1536;
	int field1537;
	int field1538;
	int[] pixels;
	boolean loaded;

	Texture(final Buffer buffer_0)
	{
		loaded = false;
		field1527 = buffer_0.readUnsignedShort();
		field1530 = buffer_0.readUnsignedByte() == 1;
		final int int_0 = buffer_0.readUnsignedByte();
		if ((int_0 >= 1) && (int_0 <= 4))
		{
			fileIds = new int[int_0];

			int int_1;
			for (int_1 = 0; int_1 < int_0; int_1++)
			{
				fileIds[int_1] = buffer_0.readUnsignedShort();
			}

			if (int_0 > 1)
			{
				field1535 = new int[int_0 - 1];

				for (int_1 = 0; int_1 < (int_0 - 1); int_1++)
				{
					field1535[int_1] = buffer_0.readUnsignedByte();
				}
			}

			if (int_0 > 1)
			{
				field1532 = new int[int_0 - 1];

				for (int_1 = 0; int_1 < (int_0 - 1); int_1++)
				{
					field1532[int_1] = buffer_0.readUnsignedByte();
				}
			}

			field1536 = new int[int_0];

			for (int_1 = 0; int_1 < int_0; int_1++)
			{
				field1536[int_1] = buffer_0.readInt();
			}

			field1537 = buffer_0.readUnsignedByte();
			field1538 = buffer_0.readUnsignedByte();
			pixels = null;
		}
		else
		{
			throw new RuntimeException();
		}
	}

	boolean method2661(final double double_0, final int int_0, final IndexDataBase indexdatabase_0)
	{
		int int_1;
		for (int_1 = 0; int_1 < fileIds.length; int_1++)
		{
			if (indexdatabase_0.getRecordFlat(fileIds[int_1]) == null)
			{
				return false;
			}
		}

		int_1 = int_0 * int_0;
		pixels = new int[int_1];

		for (int int_2 = 0; int_2 < fileIds.length; int_2++)
		{
			final IndexedSprite indexedsprite_0 = WorldMapDecorationType.method4589(indexdatabase_0, fileIds[int_2]);
			indexedsprite_0.normalize();
			final byte[] bytes_0 = indexedsprite_0.pixels;
			final int[] ints_0 = indexedsprite_0.palette;
			final int int_3 = field1536[int_2];
			if ((int_3 & 0xFF000000) == 16777216)
			{
            }

			if ((int_3 & 0xFF000000) == 33554432)
			{
            }

			int int_4;
			int int_5;
			int int_6;
			int int_7;
			if ((int_3 & 0xFF000000) == 50331648)
			{
				int_4 = int_3 & 0xFF00FF;
				int_5 = (int_3 >> 8) & 0xFF;

				for (int_6 = 0; int_6 < ints_0.length; int_6++)
				{
					int_7 = ints_0[int_6];
					if ((int_7 >> 8) == (int_7 & 0xFFFF))
					{
						int_7 &= 0xFF;
						ints_0[int_6] = (((int_4 * int_7) >> 8) & 0xFF00FF) | ((int_5 * int_7) & 0xFF00);
					}
				}
			}

			for (int_4 = 0; int_4 < ints_0.length; int_4++)
			{
				ints_0[int_4] = Graphics3D.adjustRGB(ints_0[int_4], double_0);
			}

			if (int_2 == 0)
			{
				int_4 = 0;
			}
			else
			{
				int_4 = field1535[int_2 - 1];
			}

			if (int_4 == 0)
			{
				if (int_0 == indexedsprite_0.width)
				{
					for (int_5 = 0; int_5 < int_1; int_5++)
					{
						pixels[int_5] = ints_0[bytes_0[int_5] & 0xFF];
					}
				}
				else if ((indexedsprite_0.width == 64) && (int_0 == 128))
				{
					int_5 = 0;

					for (int_6 = 0; int_6 < int_0; int_6++)
					{
						for (int_7 = 0; int_7 < int_0; int_7++)
						{
							pixels[int_5++] = ints_0[bytes_0[((int_6 >> 1) << 6) + (int_7 >> 1)] & 0xFF];
						}
					}
				}
				else
				{
					if ((indexedsprite_0.width != 128) || (int_0 != 64))
					{
						throw new RuntimeException();
					}

					int_5 = 0;

					for (int_6 = 0; int_6 < int_0; int_6++)
					{
						for (int_7 = 0; int_7 < int_0; int_7++)
						{
							pixels[int_5++] = ints_0[bytes_0[(int_7 << 1) + (int_6 << 1 << 7)] & 0xFF];
						}
					}
				}
			}

			if (int_4 == 1)
			{
            }

			if (int_4 == 2)
			{
            }

			if (int_4 == 3)
			{
            }
		}

		return true;
	}

	void resetPixels()
	{
		pixels = null;
	}

	void method2657(final int int_0)
	{
		if (pixels != null)
		{
			short short_0;
			int int_1;
			int int_2;
			int int_3;
			int int_4;
			int int_5;
			int[] ints_0;
			if ((field1537 == 1) || (field1537 == 3))
			{
				if ((field1541 == null) || (field1541.length < pixels.length))
				{
					field1541 = new int[pixels.length];
				}

				if (pixels.length == 4096)
				{
					short_0 = 64;
				}
				else
				{
					short_0 = 128;
				}

				int_1 = pixels.length;
				int_2 = short_0 * field1538 * int_0;
				int_3 = int_1 - 1;
				if (field1537 == 1)
				{
					int_2 = -int_2;
				}

				for (int_4 = 0; int_4 < int_1; int_4++)
				{
					int_5 = (int_4 + int_2) & int_3;
					field1541[int_4] = pixels[int_5];
				}

				ints_0 = pixels;
				pixels = field1541;
				field1541 = ints_0;
			}

			if ((field1537 == 2) || (field1537 == 4))
			{
				if ((field1541 == null) || (field1541.length < pixels.length))
				{
					field1541 = new int[pixels.length];
				}

				if (pixels.length == 4096)
				{
					short_0 = 64;
				}
				else
				{
					short_0 = 128;
				}

				int_1 = pixels.length;
				int_2 = field1538 * int_0;
				int_3 = short_0 - 1;
				if (field1537 == 2)
				{
					int_2 = -int_2;
				}

				for (int_4 = 0; int_4 < int_1; int_4 += short_0)
				{
					for (int_5 = 0; int_5 < short_0; int_5++)
					{
						final int int_6 = int_4 + int_5;
						final int int_7 = int_4 + ((int_5 + int_2) & int_3);
						field1541[int_6] = pixels[int_7];
					}
				}

				ints_0 = pixels;
				pixels = field1541;
				field1541 = ints_0;
			}

		}
	}

}
