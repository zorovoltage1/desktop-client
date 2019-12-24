public class Track1 extends Node
{

	HashTable field2547;
	byte[] field2546;

	Track1(final Buffer buffer_0)
	{
		buffer_0.offset = buffer_0.payload.length - 3;
		final int int_0 = buffer_0.readUnsignedByte();
		final int int_1 = buffer_0.readUnsignedShort();
		int int_2 = (int_0 * 10) + 14;
		buffer_0.offset = 0;
		int int_3 = 0;
		int int_4 = 0;
		int int_5 = 0;
		int int_6 = 0;
		int int_7 = 0;
		int int_8 = 0;
		int int_9 = 0;
		int int_10 = 0;

		int int_11;
		int int_12;
		int int_13;
		for (int_11 = 0; int_11 < int_0; int_11++)
		{
			int_12 = -1;

			while (true)
			{
				int_13 = buffer_0.readUnsignedByte();
				if (int_13 != int_12)
				{
					++int_2;
				}

				int_12 = int_13 & 0xF;
				if (int_13 == 7)
				{
					break;
				}

				if (int_13 == 23)
				{
					++int_3;
				}
				else if (int_12 == 0)
				{
					++int_5;
				}
				else if (int_12 == 1)
				{
					++int_6;
				}
				else if (int_12 == 2)
				{
					++int_4;
				}
				else if (int_12 == 3)
				{
					++int_7;
				}
				else if (int_12 == 4)
				{
					++int_8;
				}
				else if (int_12 == 5)
				{
					++int_9;
				}
				else
				{
					if (int_12 != 6)
					{
						throw new RuntimeException();
					}

					++int_10;
				}
			}
		}

		int_2 += int_3 * 5;
		int_2 += (int_5 + int_6 + int_4 + int_7 + int_9) * 2;
		int_2 = int_2 + int_8 + int_10;
		int_11 = buffer_0.offset;
		int_12 = int_0 + int_3 + int_4 + int_5 + int_6 + int_7 + int_8 + int_9 + int_10;

		for (int_13 = 0; int_13 < int_12; int_13++)
		{
			buffer_0.readVarInt();
		}

		int_2 += buffer_0.offset - int_11;
		int_13 = buffer_0.offset;
		int int_14 = 0;
		int int_15 = 0;
		int int_16 = 0;
		int int_17 = 0;
		int int_18 = 0;
		int int_19 = 0;
		int int_20 = 0;
		int int_21 = 0;
		int int_22 = 0;
		int int_23 = 0;
		int int_24 = 0;
		int int_25 = 0;
		int int_26 = 0;

		int int_27;
		for (int_27 = 0; int_27 < int_4; int_27++)
		{
			int_26 = (int_26 + buffer_0.readUnsignedByte()) & 0x7F;
			if ((int_26 != 0) && (int_26 != 32))
			{
				if (int_26 == 1)
				{
					++int_14;
				}
				else if (int_26 == 33)
				{
					++int_15;
				}
				else if (int_26 == 7)
				{
					++int_16;
				}
				else if (int_26 == 39)
				{
					++int_17;
				}
				else if (int_26 == 10)
				{
					++int_18;
				}
				else if (int_26 == 42)
				{
					++int_19;
				}
				else if (int_26 == 99)
				{
					++int_20;
				}
				else if (int_26 == 98)
				{
					++int_21;
				}
				else if (int_26 == 101)
				{
					++int_22;
				}
				else if (int_26 == 100)
				{
					++int_23;
				}
				else if ((int_26 != 64) && (int_26 != 65) && (int_26 != 120) && (int_26 != 121) && (int_26 != 123))
				{
					++int_25;
				}
				else
				{
					++int_24;
				}
			}
			else
			{
				++int_10;
			}
		}

		int_27 = 0;
		int int_28 = buffer_0.offset;
		buffer_0.offset += int_24;
		int int_29 = buffer_0.offset;
		buffer_0.offset += int_9;
		int int_30 = buffer_0.offset;
		buffer_0.offset += int_8;
		int int_31 = buffer_0.offset;
		buffer_0.offset += int_7;
		int int_32 = buffer_0.offset;
		buffer_0.offset += int_14;
		int int_33 = buffer_0.offset;
		buffer_0.offset += int_16;
		int int_34 = buffer_0.offset;
		buffer_0.offset += int_18;
		int int_35 = buffer_0.offset;
		buffer_0.offset += int_5 + int_6 + int_9;
		int int_36 = buffer_0.offset;
		buffer_0.offset += int_5;
		int int_37 = buffer_0.offset;
		buffer_0.offset += int_25;
		int int_38 = buffer_0.offset;
		buffer_0.offset += int_6;
		int int_39 = buffer_0.offset;
		buffer_0.offset += int_15;
		int int_40 = buffer_0.offset;
		buffer_0.offset += int_17;
		int int_41 = buffer_0.offset;
		buffer_0.offset += int_19;
		int int_42 = buffer_0.offset;
		buffer_0.offset += int_10;
		int int_43 = buffer_0.offset;
		buffer_0.offset += int_7;
		int int_44 = buffer_0.offset;
		buffer_0.offset += int_20;
		int int_45 = buffer_0.offset;
		buffer_0.offset += int_21;
		int int_46 = buffer_0.offset;
		buffer_0.offset += int_22;
		int int_47 = buffer_0.offset;
		buffer_0.offset += int_23;
		int int_48 = buffer_0.offset;
		buffer_0.offset += int_3 * 3;
		field2546 = new byte[int_2];
		final Buffer buffer_1 = new Buffer(field2546);
		buffer_1.putInt(1297377380);
		buffer_1.putInt(6);
		buffer_1.putShort(int_0 > 1 ? 1 : 0);
		buffer_1.putShort(int_0);
		buffer_1.putShort(int_1);
		buffer_0.offset = int_11;
		int int_49 = 0;
		int int_50 = 0;
		int int_51 = 0;
		int int_52 = 0;
		int int_53 = 0;
		int int_54 = 0;
		int int_55 = 0;
		final int[] ints_0 = new int[128];
		int_26 = 0;

		label230: for (int int_56 = 0; int_56 < int_0; int_56++)
		{
			buffer_1.putInt(1297379947);
			buffer_1.offset += 4;
			final int int_57 = buffer_1.offset;
			int int_58 = -1;

			while (true)
			{
				while (true)
				{
					final int int_59 = buffer_0.readVarInt();
					buffer_1.putVarInt(int_59);
					final int int_60 = buffer_0.payload[int_27++] & 0xFF;
					final boolean bool_0 = int_60 != int_58;
					int_58 = int_60 & 0xF;
					if (int_60 == 7)
					{
						if (bool_0)
						{
							buffer_1.putByte(255);
						}

						buffer_1.putByte(47);
						buffer_1.putByte(0);
						buffer_1.putLengthInt(buffer_1.offset - int_57);
						continue label230;
					}

					if (int_60 == 23)
					{
						if (bool_0)
						{
							buffer_1.putByte(255);
						}

						buffer_1.putByte(81);
						buffer_1.putByte(3);
						buffer_1.putByte(buffer_0.payload[int_48++]);
						buffer_1.putByte(buffer_0.payload[int_48++]);
						buffer_1.putByte(buffer_0.payload[int_48++]);
					}
					else
					{
						int_49 ^= int_60 >> 4;
						if (int_58 == 0)
						{
							if (bool_0)
							{
								buffer_1.putByte(int_49 + 144);
							}

							int_50 += buffer_0.payload[int_35++];
							int_51 += buffer_0.payload[int_36++];
							buffer_1.putByte(int_50 & 0x7F);
							buffer_1.putByte(int_51 & 0x7F);
						}
						else if (int_58 == 1)
						{
							if (bool_0)
							{
								buffer_1.putByte(int_49 + 128);
							}

							int_50 += buffer_0.payload[int_35++];
							int_52 += buffer_0.payload[int_38++];
							buffer_1.putByte(int_50 & 0x7F);
							buffer_1.putByte(int_52 & 0x7F);
						}
						else if (int_58 == 2)
						{
							if (bool_0)
							{
								buffer_1.putByte(int_49 + 176);
							}

							int_26 = (int_26 + buffer_0.payload[int_13++]) & 0x7F;
							buffer_1.putByte(int_26);
							byte byte_0;
							if ((int_26 != 0) && (int_26 != 32))
							{
								if (int_26 == 1)
								{
									byte_0 = buffer_0.payload[int_32++];
								}
								else if (int_26 == 33)
								{
									byte_0 = buffer_0.payload[int_39++];
								}
								else if (int_26 == 7)
								{
									byte_0 = buffer_0.payload[int_33++];
								}
								else if (int_26 == 39)
								{
									byte_0 = buffer_0.payload[int_40++];
								}
								else if (int_26 == 10)
								{
									byte_0 = buffer_0.payload[int_34++];
								}
								else if (int_26 == 42)
								{
									byte_0 = buffer_0.payload[int_41++];
								}
								else if (int_26 == 99)
								{
									byte_0 = buffer_0.payload[int_44++];
								}
								else if (int_26 == 98)
								{
									byte_0 = buffer_0.payload[int_45++];
								}
								else if (int_26 == 101)
								{
									byte_0 = buffer_0.payload[int_46++];
								}
								else if (int_26 == 100)
								{
									byte_0 = buffer_0.payload[int_47++];
								}
								else if ((int_26 != 64) && (int_26 != 65) && (int_26 != 120) && (int_26 != 121)
								        && (int_26 != 123))
								{
									byte_0 = buffer_0.payload[int_37++];
								}
								else
								{
									byte_0 = buffer_0.payload[int_28++];
								}
							}
							else
							{
								byte_0 = buffer_0.payload[int_42++];
							}

							final int int_61 = byte_0 + ints_0[int_26];
							ints_0[int_26] = int_61;
							buffer_1.putByte(int_61 & 0x7F);
						}
						else if (int_58 == 3)
						{
							if (bool_0)
							{
								buffer_1.putByte(int_49 + 224);
							}

							int_53 += buffer_0.payload[int_43++];
							int_53 += buffer_0.payload[int_31++] << 7;
							buffer_1.putByte(int_53 & 0x7F);
							buffer_1.putByte((int_53 >> 7) & 0x7F);
						}
						else if (int_58 == 4)
						{
							if (bool_0)
							{
								buffer_1.putByte(int_49 + 208);
							}

							int_54 += buffer_0.payload[int_30++];
							buffer_1.putByte(int_54 & 0x7F);
						}
						else if (int_58 == 5)
						{
							if (bool_0)
							{
								buffer_1.putByte(int_49 + 160);
							}

							int_50 += buffer_0.payload[int_35++];
							int_55 += buffer_0.payload[int_29++];
							buffer_1.putByte(int_50 & 0x7F);
							buffer_1.putByte(int_55 & 0x7F);
						}
						else
						{
							if (int_58 != 6)
							{
								throw new RuntimeException();
							}

							if (bool_0)
							{
								buffer_1.putByte(int_49 + 192);
							}

							buffer_1.putByte(buffer_0.payload[int_42++]);
						}
					}
				}
			}
		}

	}

	void method4412()
	{
		if (field2547 == null)
		{
			field2547 = new HashTable(16);
			final int[] ints_0 = new int[16];
			final int[] ints_1 = new int[16];
			ints_1[9] = 128;
			ints_0[9] = 128;
			final class220 class220_0 = new class220(field2546);
			final int int_0 = class220_0.method4331();

			int int_1;
			for (int_1 = 0; int_1 < int_0; int_1++)
			{
				class220_0.method4350(int_1);
				class220_0.method4335(int_1);
				class220_0.method4333(int_1);
			}

			label52: do
			{
				while (true)
				{
					int_1 = class220_0.method4339();
					final int int_2 = class220_0.field2525[int_1];

					while (int_2 == class220_0.field2525[int_1])
					{
						class220_0.method4350(int_1);
						final int int_3 = class220_0.method4336(int_1);
						if (int_3 == 1)
						{
							class220_0.method4334();
							class220_0.method4333(int_1);
							continue label52;
						}

						final int int_4 = int_3 & 0xF0;
						int int_5;
						int int_6;
						int int_7;
						if (int_4 == 176)
						{
							int_5 = int_3 & 0xF;
							int_6 = (int_3 >> 8) & 0x7F;
							int_7 = (int_3 >> 16) & 0x7F;
							if (int_6 == 0)
							{
								ints_0[int_5] = (int_7 << 14) + (ints_0[int_5] & 0xFFE03FFF);
							}

							if (int_6 == 32)
							{
								ints_0[int_5] = (ints_0[int_5] & 0xFFFFC07F) + (int_7 << 7);
							}
						}

						if (int_4 == 192)
						{
							int_5 = int_3 & 0xF;
							int_6 = (int_3 >> 8) & 0x7F;
							ints_1[int_5] = int_6 + ints_0[int_5];
						}

						if (int_4 == 144)
						{
							int_5 = int_3 & 0xF;
							int_6 = (int_3 >> 8) & 0x7F;
							int_7 = (int_3 >> 16) & 0x7F;
							if (int_7 > 0)
							{
								final int int_8 = ints_1[int_5];
								ByteArrayNode bytearraynode_0 = (ByteArrayNode) field2547.get(int_8);
								if (bytearraynode_0 == null)
								{
									bytearraynode_0 = new ByteArrayNode(new byte[128]);
									field2547.put(bytearraynode_0, int_8);
								}

								bytearraynode_0.byteArray[int_6] = 1;
							}
						}

						class220_0.method4335(int_1);
						class220_0.method4333(int_1);
					}
				}
			}
			while (!class220_0.method4340());

		}
	}

	void method4413()
	{
		field2547 = null;
	}

	static Track1 getMusicFile(final IndexDataBase indexdatabase_0, final int int_0, final int int_1)
	{
		final byte[] bytes_0 = indexdatabase_0.getConfigData(int_0, int_1);
		return bytes_0 == null ? null : new Track1(new Buffer(bytes_0));
	}

}
