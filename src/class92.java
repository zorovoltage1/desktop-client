public class class92 extends Node
{

	static byte[] payload;
	static int position;
	static int bitPosition;
	static int blockSize0;
	static int blockSize1;
	static CodeBook[] codeBooks;
	static Floor1[] floors;
	static Residue[] residues;
	static Mapping[] mappings;
	static boolean[] modeBlockFlags;
	static int[] modeMappings;
	static boolean field1260;
	static float[] field1265;
	static float[] field1251;
	static float[] field1269;
	static float[] field1268;
	static float[] field1247;
	static float[] field1270;
	static float[] field1271;
	static int[] field1272;
	static int[] field1267;
	byte[][] field1263;
	int field1244;
	int field1245;
	int field1246;
	int field1253;
	boolean field1248;
	float[] field1261;
	int field1264;
	int field1249;
	boolean field1256;
	byte[] field1274;
	int field1275;
	int field1276;

	static
	{
		field1260 = false;
	}

	class92(final byte[] bytes_0)
	{
		method2094(bytes_0);
	}

	void method2094(final byte[] bytes_0)
	{
		final Buffer buffer_0 = new Buffer(bytes_0);
		field1244 = buffer_0.readInt();
		field1245 = buffer_0.readInt();
		field1246 = buffer_0.readInt();
		field1253 = buffer_0.readInt();
		if (field1253 < 0)
		{
			field1253 = ~field1253;
			field1248 = true;
		}

		final int int_0 = buffer_0.readInt();
		field1263 = new byte[int_0][];

		for (int int_1 = 0; int_1 < int_0; int_1++)
		{
			int int_2 = 0;

			int int_3;
			do
			{
				int_3 = buffer_0.readUnsignedByte();
				int_2 += int_3;
			}
			while (int_3 >= 255);

			final byte[] bytes_1 = new byte[int_2];
			buffer_0.readBytes(bytes_1, 0, int_2);
			field1263[int_1] = bytes_1;
		}

	}

	float[] method2086(final int int_0)
	{
		setBytes(field1263[int_0], 0);
		getBit();
		final int int_1 = getInt(class143.ilog(modeMappings.length - 1));
		final boolean bool_0 = modeBlockFlags[int_1];
		final int int_2 = bool_0 ? blockSize1 : blockSize0;
		boolean bool_1 = false;
		boolean bool_2 = false;
		if (bool_0)
		{
			bool_1 = getBit() != 0;
			bool_2 = getBit() != 0;
		}

		final int int_3 = int_2 >> 1;
		int int_4;
		int int_5;
		int int_6;
		if (bool_0 && !bool_1)
		{
			int_4 = (int_2 >> 2) - (blockSize0 >> 2);
			int_5 = (blockSize0 >> 2) + (int_2 >> 2);
			int_6 = blockSize0 >> 1;
		}
		else
		{
			int_4 = 0;
			int_5 = int_3;
			int_6 = int_2 >> 1;
		}

		int int_7;
		int int_8;
		int int_9;
		if (bool_0 && !bool_2)
		{
			int_7 = int_2 - (int_2 >> 2) - (blockSize0 >> 2);
			int_8 = (blockSize0 >> 2) + (int_2 - (int_2 >> 2));
			int_9 = blockSize0 >> 1;
		}
		else
		{
			int_7 = int_3;
			int_8 = int_2;
			int_9 = int_2 >> 1;
		}

		final Mapping mapping_0 = mappings[modeMappings[int_1]];
		final int int_10 = mapping_0.mux;
		int int_11 = mapping_0.submapFloors[int_10];
		final boolean bool_3 = !floors[int_11].decodedFloor();
		final boolean bool_4 = bool_3;

		for (int_11 = 0; int_11 < mapping_0.field1388; int_11++)
		{
			final Residue residue_0 = residues[mapping_0.field1386[int_11]];
			final float[] floats_0 = field1265;
			residue_0.decodeResidue(floats_0, int_2 >> 1, bool_4);
		}

		int int_12;
		if (!bool_3)
		{
			int_11 = mapping_0.mux;
			int_12 = mapping_0.submapFloors[int_11];
			floors[int_12].computeFloor(field1265, int_2 >> 1);
		}

		int int_13;
		if (bool_3)
		{
			for (int_11 = int_2 >> 1; int_11 < int_2; int_11++)
			{
				field1265[int_11] = 0.0F;
			}
		}
		else
		{
			int_11 = int_2 >> 1;
			int_12 = int_2 >> 2;
			int_13 = int_2 >> 3;
			final float[] floats_2 = field1265;

			int int_15;
			for (int_15 = 0; int_15 < int_11; int_15++)
			{
				floats_2[int_15] *= 0.5F;
			}

			for (int_15 = int_11; int_15 < int_2; int_15++)
			{
				floats_2[int_15] = -floats_2[int_2 - int_15 - 1];
			}

			final float[] floats_3 = bool_0 ? field1247 : field1251;
			final float[] floats_4 = bool_0 ? field1270 : field1269;
			final float[] floats_5 = bool_0 ? field1271 : field1268;
			final int[] ints_0 = bool_0 ? field1267 : field1272;

			int int_16;
			float float_0;
			float float_1;
			float float_2;
			float float_3;
			for (int_16 = 0; int_16 < int_12; int_16++)
			{
				float_0 = floats_2[int_16 * 4] - floats_2[int_2 - (int_16 * 4) - 1];
				float_1 = floats_2[(int_16 * 4) + 2] - floats_2[int_2 - (int_16 * 4) - 3];
				float_2 = floats_3[int_16 * 2];
				float_3 = floats_3[(int_16 * 2) + 1];
				floats_2[int_2 - (int_16 * 4) - 1] = (float_0 * float_2) - (float_1 * float_3);
				floats_2[int_2 - (int_16 * 4) - 3] = (float_0 * float_3) + (float_1 * float_2);
			}

			float float_4;
			float float_5;
			for (int_16 = 0; int_16 < int_13; int_16++)
			{
				float_0 = floats_2[int_11 + (int_16 * 4) + 3];
				float_1 = floats_2[int_11 + (int_16 * 4) + 1];
				float_2 = floats_2[(int_16 * 4) + 3];
				float_3 = floats_2[(int_16 * 4) + 1];
				floats_2[int_11 + (int_16 * 4) + 3] = float_0 + float_2;
				floats_2[int_11 + (int_16 * 4) + 1] = float_1 + float_3;
				float_4 = floats_3[int_11 - 4 - (int_16 * 4)];
				float_5 = floats_3[int_11 - 3 - (int_16 * 4)];
				floats_2[(int_16 * 4) + 3] = ((float_0 - float_2) * float_4) - ((float_1 - float_3) * float_5);
				floats_2[(int_16 * 4) + 1] = ((float_1 - float_3) * float_4) + ((float_0 - float_2) * float_5);
			}

			int_16 = class143.ilog(int_2 - 1);

			int int_19;
			int int_20;
			int int_21;
			int int_22;
			for (int_19 = 0; int_19 < (int_16 - 3); int_19++)
			{
				int_20 = int_2 >> (int_19 + 2);
				int_21 = 8 << int_19;

				for (int_22 = 0; int_22 < (2 << int_19); int_22++)
				{
					final int int_23 = int_2 - (int_20 * int_22 * 2);
					final int int_24 = int_2 - (int_20 * ((int_22 * 2) + 1));

					for (int int_17 = 0; int_17 < (int_2 >> (int_19 + 4)); int_17++)
					{
						final int int_18 = int_17 * 4;
						final float float_6 = floats_2[int_23 - 1 - int_18];
						final float float_7 = floats_2[int_23 - 3 - int_18];
						final float float_8 = floats_2[int_24 - 1 - int_18];
						final float float_9 = floats_2[int_24 - 3 - int_18];
						floats_2[int_23 - 1 - int_18] = float_6 + float_8;
						floats_2[int_23 - 3 - int_18] = float_7 + float_9;
						final float float_10 = floats_3[int_17 * int_21];
						final float float_11 = floats_3[(int_17 * int_21) + 1];
						floats_2[int_24 - 1 - int_18] = ((float_6 - float_8) * float_10)
						        - ((float_7 - float_9) * float_11);
						floats_2[int_24 - 3 - int_18] = ((float_7 - float_9) * float_10)
						        + ((float_6 - float_8) * float_11);
					}
				}
			}

			for (int_19 = 1; int_19 < (int_13 - 1); int_19++)
			{
				int_20 = ints_0[int_19];
				if (int_19 < int_20)
				{
					int_21 = int_19 * 8;
					int_22 = int_20 * 8;
					float_4 = floats_2[int_21 + 1];
					floats_2[int_21 + 1] = floats_2[int_22 + 1];
					floats_2[int_22 + 1] = float_4;
					float_4 = floats_2[int_21 + 3];
					floats_2[int_21 + 3] = floats_2[int_22 + 3];
					floats_2[int_22 + 3] = float_4;
					float_4 = floats_2[int_21 + 5];
					floats_2[int_21 + 5] = floats_2[int_22 + 5];
					floats_2[int_22 + 5] = float_4;
					float_4 = floats_2[int_21 + 7];
					floats_2[int_21 + 7] = floats_2[int_22 + 7];
					floats_2[int_22 + 7] = float_4;
				}
			}

			for (int_19 = 0; int_19 < int_11; int_19++)
			{
				floats_2[int_19] = floats_2[(int_19 * 2) + 1];
			}

			for (int_19 = 0; int_19 < int_13; int_19++)
			{
				floats_2[int_2 - 1 - (int_19 * 2)] = floats_2[int_19 * 4];
				floats_2[int_2 - 2 - (int_19 * 2)] = floats_2[(int_19 * 4) + 1];
				floats_2[int_2 - int_12 - 1 - (int_19 * 2)] = floats_2[(int_19 * 4) + 2];
				floats_2[int_2 - int_12 - 2 - (int_19 * 2)] = floats_2[(int_19 * 4) + 3];
			}

			for (int_19 = 0; int_19 < int_13; int_19++)
			{
				float_1 = floats_5[int_19 * 2];
				float_2 = floats_5[(int_19 * 2) + 1];
				float_3 = floats_2[int_11 + (int_19 * 2)];
				float_4 = floats_2[int_11 + (int_19 * 2) + 1];
				float_5 = floats_2[int_2 - 2 - (int_19 * 2)];
				final float float_12 = floats_2[int_2 - 1 - (int_19 * 2)];
				float float_13 = (float_2 * (float_3 - float_5)) + (float_1 * (float_4 + float_12));
				floats_2[int_11 + (int_19 * 2)] = (float_3 + float_5 + float_13) * 0.5F;
				floats_2[int_2 - 2 - (int_19 * 2)] = ((float_3 + float_5) - float_13) * 0.5F;
				float_13 = (float_2 * (float_4 + float_12)) - (float_1 * (float_3 - float_5));
				floats_2[int_11 + (int_19 * 2) + 1] = ((float_4 - float_12) + float_13) * 0.5F;
				floats_2[int_2 - 1 - (int_19 * 2)] = (-float_4 + float_12 + float_13) * 0.5F;
			}

			for (int_19 = 0; int_19 < int_12; int_19++)
			{
				floats_2[int_19] = (floats_2[int_11 + (int_19 * 2)] * floats_4[int_19 * 2])
				        + (floats_2[int_11 + (int_19 * 2) + 1] * floats_4[(int_19 * 2) + 1]);
				floats_2[int_11 - 1 - int_19] = (floats_2[int_11 + (int_19 * 2)] * floats_4[(int_19 * 2) + 1])
				        - (floats_2[int_11 + (int_19 * 2) + 1] * floats_4[int_19 * 2]);
			}

			for (int_19 = 0; int_19 < int_12; int_19++)
			{
				floats_2[int_19 + (int_2 - int_12)] = -floats_2[int_19];
			}

			for (int_19 = 0; int_19 < int_12; int_19++)
			{
				floats_2[int_19] = floats_2[int_12 + int_19];
			}

			for (int_19 = 0; int_19 < int_12; int_19++)
			{
				floats_2[int_12 + int_19] = -floats_2[int_12 - int_19 - 1];
			}

			for (int_19 = 0; int_19 < int_12; int_19++)
			{
				floats_2[int_11 + int_19] = floats_2[int_2 - int_19 - 1];
			}

			for (int_19 = int_4; int_19 < int_5; int_19++)
			{
				float_1 = (float) Math.sin(((int_19 - int_4 + 0.5D) / int_6) * 0.5D * 3.141592653589793D);
				field1265[int_19] *= (float) Math.sin(1.5707963267948966D * float_1 * float_1);
			}

			for (int_19 = int_7; int_19 < int_8; int_19++)
			{
				float_1 = (float) Math
				        .sin((((int_19 - int_7 + 0.5D) / int_9) * 0.5D * 3.141592653589793D) + 1.5707963267948966D);
				field1265[int_19] *= (float) Math.sin(1.5707963267948966D * float_1 * float_1);
			}
		}

		float[] floats_1 = null;
		if (field1264 > 0)
		{
			int_12 = (int_2 + field1264) >> 2;
			floats_1 = new float[int_12];
			int int_14;
			if (!field1256)
			{
				for (int_13 = 0; int_13 < field1249; int_13++)
				{
					int_14 = int_13 + (field1264 >> 1);
					floats_1[int_13] += field1261[int_14];
				}
			}

			if (!bool_3)
			{
				for (int_13 = int_4; int_13 < (int_2 >> 1); int_13++)
				{
					int_14 = (floats_1.length - (int_2 >> 1)) + int_13;
					floats_1[int_14] += field1265[int_13];
				}
			}
		}

		final float[] floats_6 = field1261;
		field1261 = field1265;
		field1265 = floats_6;
		field1264 = int_2;
		field1249 = int_8 - (int_2 >> 1);
		field1256 = bool_3;
		return floats_1;
	}

	RawAudioNode method2083(final int[] ints_0)
	{
		if ((ints_0 != null) && (ints_0[0] <= 0))
		{
			return null;
		}
		else
		{
			if (field1274 == null)
			{
				field1264 = 0;
				field1261 = new float[blockSize1];
				field1274 = new byte[field1245];
				field1275 = 0;
				field1276 = 0;
			}

			for (; field1276 < field1263.length; field1276++)
			{
				if ((ints_0 != null) && (ints_0[0] <= 0))
				{
					return null;
				}

				final float[] floats_0 = method2086(field1276);
				if (floats_0 != null)
				{
					int int_0 = field1275;
					int int_1 = floats_0.length;
					if (int_1 > (field1245 - int_0))
					{
						int_1 = field1245 - int_0;
					}

					for (int int_2 = 0; int_2 < int_1; int_2++)
					{
						int int_3 = (int) (128.0F + (floats_0[int_2] * 128.0F));
						if ((int_3 & 0xFFFFFF00) != 0)
						{
							int_3 = ~int_3 >> 31;
						}

						field1274[int_0++] = (byte) (int_3 - 128);
					}

					if (ints_0 != null)
					{
						ints_0[0] -= int_0 - field1275;
					}

					field1275 = int_0;
				}
			}

			field1261 = null;
			final byte[] bytes_0 = field1274;
			field1274 = null;
			return new RawAudioNode(field1244, bytes_0, field1246, field1253, field1248);
		}
	}

	static float float32Unpack(final int int_0)
	{
		int int_1 = int_0 & 0x1FFFFF;
		final int int_2 = int_0 & 0x80000000;
		final int int_3 = (int_0 & 0x7FE00000) >> 21;
		if (int_2 != 0)
		{
			int_1 = -int_1;
		}

		return (float) (int_1 * Math.pow(2.0D, int_3 - 788));
	}

	static void setBytes(final byte[] bytes_0, final int int_0)
	{
		payload = bytes_0;
		position = int_0;
		bitPosition = 0;
	}

	static int getBit()
	{
		final int int_0 = (payload[position] >> bitPosition) & 0x1;
		++bitPosition;
		position += bitPosition >> 3;
		bitPosition &= 0x7;
		return int_0;
	}

	static int getInt(int int_0)
	{
		int int_1 = 0;

		int int_2;
		int int_3;
		for (int_2 = 0; int_0 >= (8 - bitPosition); int_0 -= int_3)
		{
			int_3 = 8 - bitPosition;
			final int int_4 = (1 << int_3) - 1;
			int_1 += ((payload[position] >> bitPosition) & int_4) << int_2;
			bitPosition = 0;
			++position;
			int_2 += int_3;
		}

		if (int_0 > 0)
		{
			int_3 = (1 << int_0) - 1;
			int_1 += ((payload[position] >> bitPosition) & int_3) << int_2;
			bitPosition += int_0;
		}

		return int_1;
	}

	static void method2082(final byte[] bytes_0)
	{
		setBytes(bytes_0, 0);
		blockSize0 = 1 << getInt(4);
		blockSize1 = 1 << getInt(4);
		field1265 = new float[blockSize1];

		int int_0;
		int int_1;
		int int_2;
		int int_3;
		int int_4;
		for (int_0 = 0; int_0 < 2; int_0++)
		{
			int_1 = int_0 != 0 ? blockSize1 : blockSize0;
			int_2 = int_1 >> 1;
			int_3 = int_1 >> 2;
			int_4 = int_1 >> 3;
			final float[] floats_0 = new float[int_2];

			for (int int_5 = 0; int_5 < int_3; int_5++)
			{
				floats_0[int_5 * 2] = (float) Math.cos((int_5 * 4 * 3.141592653589793D) / int_1);
				floats_0[(int_5 * 2) + 1] = -((float) Math.sin((int_5 * 4 * 3.141592653589793D) / int_1));
			}

			final float[] floats_1 = new float[int_2];

			for (int int_6 = 0; int_6 < int_3; int_6++)
			{
				floats_1[int_6 * 2] = (float) Math.cos((((int_6 * 2) + 1) * 3.141592653589793D) / (int_1 * 2));
				floats_1[(int_6 * 2) + 1] = (float) Math.sin((((int_6 * 2) + 1) * 3.141592653589793D) / (int_1 * 2));
			}

			final float[] floats_2 = new float[int_3];

			for (int int_7 = 0; int_7 < int_4; int_7++)
			{
				floats_2[int_7 * 2] = (float) Math.cos((((int_7 * 4) + 2) * 3.141592653589793D) / int_1);
				floats_2[(int_7 * 2) + 1] = -((float) Math.sin((((int_7 * 4) + 2) * 3.141592653589793D) / int_1));
			}

			final int[] ints_0 = new int[int_4];
			final int int_8 = class143.ilog(int_4 - 1);

			for (int int_9 = 0; int_9 < int_4; int_9++)
			{
				int int_10 = int_9;
				int int_11 = int_8;

				int int_12;
				for (int_12 = 0; int_11 > 0; --int_11)
				{
					int_12 = (int_12 << 1) | (int_10 & 0x1);
					int_10 >>>= 1;
				}

				ints_0[int_9] = int_12;
			}

			if (int_0 != 0)
			{
				field1247 = floats_0;
				field1270 = floats_1;
				field1271 = floats_2;
				field1267 = ints_0;
			}
			else
			{
				field1251 = floats_0;
				field1269 = floats_1;
				field1268 = floats_2;
				field1272 = ints_0;
			}
		}

		int_0 = getInt(8) + 1;
		codeBooks = new CodeBook[int_0];

		for (int_1 = 0; int_1 < int_0; int_1++)
		{
			codeBooks[int_1] = new CodeBook();
		}

		int_1 = getInt(6) + 1;

		for (int_2 = 0; int_2 < int_1; int_2++)
		{
			getInt(16);
		}

		int_1 = getInt(6) + 1;
		floors = new Floor1[int_1];

		for (int_2 = 0; int_2 < int_1; int_2++)
		{
			floors[int_2] = new Floor1();
		}

		int_2 = getInt(6) + 1;
		residues = new Residue[int_2];

		for (int_3 = 0; int_3 < int_2; int_3++)
		{
			residues[int_3] = new Residue();
		}

		int_3 = getInt(6) + 1;
		mappings = new Mapping[int_3];

		for (int_4 = 0; int_4 < int_3; int_4++)
		{
			mappings[int_4] = new Mapping();
		}

		int_4 = getInt(6) + 1;
		modeBlockFlags = new boolean[int_4];
		modeMappings = new int[int_4];

		for (int int_13 = 0; int_13 < int_4; int_13++)
		{
			modeBlockFlags[int_13] = getBit() != 0;
			getInt(16);
			getInt(16);
			modeMappings[int_13] = getInt(8);
		}

	}

	static boolean method2087(final IndexDataBase indexdatabase_0)
	{
		if (!field1260)
		{
			final byte[] bytes_0 = indexdatabase_0.getConfigData(0, 0);
			if (bytes_0 == null)
			{
				return false;
			}

			method2082(bytes_0);
			field1260 = true;
		}

		return true;
	}

	static class92 getInstrument(final IndexDataBase indexdatabase_0, final int int_0, final int int_1)
	{
		if (!method2087(indexdatabase_0))
		{
			indexdatabase_0.tryLoadRecord(int_0, int_1);
			return null;
		}
		else
		{
			final byte[] bytes_0 = indexdatabase_0.getConfigData(int_0, int_1);
			return bytes_0 == null ? null : new class92(bytes_0);
		}
	}

}
