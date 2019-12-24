public final class class176
{

	static DState state;

	static
	{
		state = new DState();
	}

	public static int Bzip2Decompressor_decompress(final byte[] bytes_0, int int_0, final byte[] bytes_1,
	        final int int_1, final int int_2)
	{
		synchronized (state)
		{
			state.strm = bytes_1;
			state.next_in = int_2;
			state.out = bytes_0;
			state.next_out = 0;
			state.field2310 = int_0;
			state.total_in_lo32 = 0;
			state.total_in_hi32 = 0;
			state.total_out_lo32 = 0;
			state.total_out_hi32 = 0;
			method3491(state);
			int_0 -= state.field2310;
			state.strm = null;
			state.out = null;
			return int_0;
		}
	}

	static void method3500(final DState dstate_0)
	{
		byte byte_0 = dstate_0.out_ch;
		int int_0 = dstate_0.out_len;
		int int_1 = dstate_0.nblock_used;
		int int_2 = dstate_0.k0;
		final int[] ints_0 = class25.tt;
		int int_3 = dstate_0.tPos;
		final byte[] bytes_0 = dstate_0.out;
		int int_4 = dstate_0.next_out;
		int int_5 = dstate_0.field2310;
		final int int_6 = dstate_0.field2331 + 1;

		label65: while (true)
		{
			if (int_0 > 0)
			{
				while (true)
				{
					if (int_5 == 0)
					{
						break label65;
					}

					if (int_0 == 1)
					{
						if (int_5 == 0)
						{
							int_0 = 1;
							break label65;
						}

						bytes_0[int_4] = byte_0;
						++int_4;
						--int_5;
						break;
					}

					bytes_0[int_4] = byte_0;
					--int_0;
					++int_4;
					--int_5;
				}
			}

			boolean bool_0 = true;

			byte byte_1;
			while (bool_0)
			{
				bool_0 = false;
				if (int_1 == int_6)
				{
					int_0 = 0;
					break label65;
				}

				byte_0 = (byte) int_2;
				int_3 = ints_0[int_3];
				byte_1 = (byte) (int_3 & 0xFF);
				int_3 >>= 8;
				++int_1;
				if (byte_1 != int_2)
				{
					int_2 = byte_1;
					if (int_5 == 0)
					{
						int_0 = 1;
						break label65;
					}

					bytes_0[int_4] = byte_0;
					++int_4;
					--int_5;
					bool_0 = true;
				}
				else if (int_1 == int_6)
				{
					if (int_5 == 0)
					{
						int_0 = 1;
						break label65;
					}

					bytes_0[int_4] = byte_0;
					++int_4;
					--int_5;
					bool_0 = true;
				}
			}

			int_0 = 2;
			int_3 = ints_0[int_3];
			byte_1 = (byte) (int_3 & 0xFF);
			int_3 >>= 8;
			++int_1;
			if (int_1 != int_6)
			{
				if (byte_1 != int_2)
				{
					int_2 = byte_1;
				}
				else
				{
					int_0 = 3;
					int_3 = ints_0[int_3];
					byte_1 = (byte) (int_3 & 0xFF);
					int_3 >>= 8;
					++int_1;
					if (int_1 != int_6)
					{
						if (byte_1 != int_2)
						{
							int_2 = byte_1;
						}
						else
						{
							int_3 = ints_0[int_3];
							byte_1 = (byte) (int_3 & 0xFF);
							int_3 >>= 8;
							++int_1;
							int_0 = (byte_1 & 0xFF) + 4;
							int_3 = ints_0[int_3];
							int_2 = (byte) (int_3 & 0xFF);
							int_3 >>= 8;
							++int_1;
						}
					}
				}
			}
		}

		final int int_7 = dstate_0.total_out_hi32;
		dstate_0.total_out_hi32 += int_5 - int_5;
		if (dstate_0.total_out_hi32 < int_7)
		{
        }

		dstate_0.out_ch = byte_0;
		dstate_0.out_len = int_0;
		dstate_0.nblock_used = int_1;
		dstate_0.k0 = int_2;
		class25.tt = ints_0;
		dstate_0.tPos = int_3;
		dstate_0.out = bytes_0;
		dstate_0.next_out = int_4;
		dstate_0.field2310 = int_5;
	}

	static void method3491(final DState dstate_0)
	{
		int int_0 = 0;
		int[] ints_0 = null;
		int[] ints_1 = null;
		int[] ints_2 = null;
		dstate_0.blockSize100k = 1;
		if (class25.tt == null)
		{
			class25.tt = new int[dstate_0.blockSize100k * 100000];
		}

		boolean bool_18 = true;

		while (true)
		{
			while (bool_18)
			{
				byte byte_0 = method3492(dstate_0);
				if (byte_0 == 23)
				{
					return;
				}

				byte_0 = method3492(dstate_0);
				byte_0 = method3492(dstate_0);
				byte_0 = method3492(dstate_0);
				byte_0 = method3492(dstate_0);
				byte_0 = method3492(dstate_0);
				byte_0 = method3492(dstate_0);
				byte_0 = method3492(dstate_0);
				byte_0 = method3492(dstate_0);
				byte_0 = method3492(dstate_0);
				byte_0 = method3493(dstate_0);
				if (byte_0 != 0)
				{
                }

				dstate_0.field2312 = 0;
				byte_0 = method3492(dstate_0);
				dstate_0.field2312 = (dstate_0.field2312 << 8) | (byte_0 & 0xFF);
				byte_0 = method3492(dstate_0);
				dstate_0.field2312 = (dstate_0.field2312 << 8) | (byte_0 & 0xFF);
				byte_0 = method3492(dstate_0);
				dstate_0.field2312 = (dstate_0.field2312 << 8) | (byte_0 & 0xFF);

				int int_7;
				for (int_7 = 0; int_7 < 16; int_7++)
				{
					byte_0 = method3493(dstate_0);
                    dstate_0.field2296[int_7] = byte_0 == 1;
				}

				for (int_7 = 0; int_7 < 256; int_7++)
				{
					dstate_0.inUse[int_7] = false;
				}

				int int_8;
				for (int_7 = 0; int_7 < 16; int_7++)
				{
					if (dstate_0.field2296[int_7])
					{
						for (int_8 = 0; int_8 < 16; int_8++)
						{
							byte_0 = method3493(dstate_0);
							if (byte_0 == 1)
							{
								dstate_0.inUse[int_8 + (int_7 * 16)] = true;
							}
						}
					}
				}

				method3494(dstate_0);
				final int int_10 = dstate_0.nInUse + 2;
				final int int_11 = method3490(3, dstate_0);
				final int int_12 = method3490(15, dstate_0);

				for (int_7 = 0; int_7 < int_12; int_7++)
				{
					int_8 = 0;

					while (true)
					{
						byte_0 = method3493(dstate_0);
						if (byte_0 == 0)
						{
							dstate_0.field2328[int_7] = (byte) int_8;
							break;
						}

						++int_8;
					}
				}

				final byte[] bytes_0 = new byte[6];

				byte byte_1;
				for (byte_1 = 0; byte_1 < int_11; bytes_0[byte_1] = byte_1++)
				{
                }

				for (int_7 = 0; int_7 < int_12; int_7++)
				{
					byte_1 = dstate_0.field2328[int_7];

					byte byte_2;
					for (byte_2 = bytes_0[byte_1]; byte_1 > 0; --byte_1)
					{
						bytes_0[byte_1] = bytes_0[byte_1 - 1];
					}

					bytes_0[0] = byte_2;
					dstate_0.field2324[int_7] = byte_2;
				}

				int int_9;
				for (int_9 = 0; int_9 < int_11; int_9++)
				{
					int int_20 = method3490(5, dstate_0);

					for (int_7 = 0; int_7 < int_10; int_7++)
					{
						while (true)
						{
							byte_0 = method3493(dstate_0);
							if (byte_0 == 0)
							{
								dstate_0.field2303[int_9][int_7] = (byte) int_20;
								break;
							}

							byte_0 = method3493(dstate_0);
							if (byte_0 == 0)
							{
								++int_20;
							}
							else
							{
								--int_20;
							}
						}
					}
				}

				for (int_9 = 0; int_9 < int_11; int_9++)
				{
					byte byte_3 = 32;
					byte byte_4 = 0;

					for (int_7 = 0; int_7 < int_10; int_7++)
					{
						if (dstate_0.field2303[int_9][int_7] > byte_4)
						{
							byte_4 = dstate_0.field2303[int_9][int_7];
						}

						if (dstate_0.field2303[int_9][int_7] < byte_3)
						{
							byte_3 = dstate_0.field2303[int_9][int_7];
						}
					}

					method3495(dstate_0.field2301[int_9], dstate_0.field2297[int_9], dstate_0.field2329[int_9],
					        dstate_0.field2303[int_9], byte_3, byte_4, int_10);
					dstate_0.field2330[int_9] = byte_3;
				}

				final int int_13 = dstate_0.nInUse + 1;
				int int_14 = -1;
				byte byte_5 = 0;

				for (int_7 = 0; int_7 <= 255; int_7++)
				{
					dstate_0.field2315[int_7] = 0;
				}

				int int_23 = 4095;

				int int_1;
				int int_24;
				for (int_1 = 15; int_1 >= 0; --int_1)
				{
					for (int_24 = 15; int_24 >= 0; --int_24)
					{
						dstate_0.field2322[int_23] = (byte) (int_24 + (int_1 * 16));
						--int_23;
					}

					dstate_0.field2323[int_1] = int_23 + 1;
				}

				int int_17 = 0;
				byte byte_7;
				if (byte_5 == 0)
				{
					++int_14;
					byte_5 = 50;
					byte_7 = dstate_0.field2324[int_14];
					int_0 = dstate_0.field2330[byte_7];
					ints_0 = dstate_0.field2301[byte_7];
					ints_2 = dstate_0.field2329[byte_7];
					ints_1 = dstate_0.field2297[byte_7];
				}

				int int_15 = byte_5 - 1;
				int int_21 = int_0;

				int int_22;
				byte byte_6;
				for (int_22 = method3490(int_0, dstate_0); int_22 > ints_0[int_21]; int_22 = (int_22 << 1) | byte_6)
				{
					++int_21;
					byte_6 = method3493(dstate_0);
				}

				int int_16 = ints_2[int_22 - ints_1[int_21]];

				while (true)
				{
					while (int_16 != int_13)
					{
						if ((int_16 != 0) && (int_16 != 1))
						{
							int int_2 = int_16 - 1;
							int int_3;
							if (int_2 < 16)
							{
								int_3 = dstate_0.field2323[0];

								for (byte_0 = dstate_0.field2322[int_3 + int_2]; int_2 > 3; int_2 -= 4)
								{
									final int int_4 = int_3 + int_2;
									dstate_0.field2322[int_4] = dstate_0.field2322[int_4 - 1];
									dstate_0.field2322[int_4 - 1] = dstate_0.field2322[int_4 - 2];
									dstate_0.field2322[int_4 - 2] = dstate_0.field2322[int_4 - 3];
									dstate_0.field2322[int_4 - 3] = dstate_0.field2322[int_4 - 4];
								}

								while (int_2 > 0)
								{
									dstate_0.field2322[int_3 + int_2] = dstate_0.field2322[(int_3 + int_2) - 1];
									--int_2;
								}

								dstate_0.field2322[int_3] = byte_0;
							}
							else
							{
								int int_5 = int_2 / 16;
								final int int_6 = int_2 % 16;
								int_3 = dstate_0.field2323[int_5] + int_6;

								for (byte_0 = dstate_0.field2322[int_3]; int_3 > dstate_0.field2323[int_5]; --int_3)
								{
									dstate_0.field2322[int_3] = dstate_0.field2322[int_3 - 1];
								}

								++dstate_0.field2323[int_5];

								while (int_5 > 0)
								{
									--dstate_0.field2323[int_5];
									dstate_0.field2322[dstate_0.field2323[int_5]] = dstate_0.field2322[(dstate_0.field2323[int_5
									        - 1] + 16) - 1];
									--int_5;
								}

								--dstate_0.field2323[0];
								dstate_0.field2322[dstate_0.field2323[0]] = byte_0;
								if (dstate_0.field2323[0] == 0)
								{
									int_23 = 4095;

									for (int_1 = 15; int_1 >= 0; --int_1)
									{
										for (int_24 = 15; int_24 >= 0; --int_24)
										{
											dstate_0.field2322[int_23] = dstate_0.field2322[dstate_0.field2323[int_1]
											        + int_24];
											--int_23;
										}

										dstate_0.field2323[int_1] = int_23 + 1;
									}
								}
							}

							++dstate_0.field2315[dstate_0.seqToUnseq[byte_0 & 0xFF] & 0xFF];
							class25.tt[int_17] = dstate_0.seqToUnseq[byte_0 & 0xFF] & 0xFF;
							++int_17;
							if (int_15 == 0)
							{
								++int_14;
								int_15 = 50;
								byte_7 = dstate_0.field2324[int_14];
								int_0 = dstate_0.field2330[byte_7];
								ints_0 = dstate_0.field2301[byte_7];
								ints_2 = dstate_0.field2329[byte_7];
								ints_1 = dstate_0.field2297[byte_7];
							}

							--int_15;
							int_21 = int_0;

							for (int_22 = method3490(int_0, dstate_0); int_22 > ints_0[int_21]; int_22 = (int_22 << 1)
							        | byte_6)
							{
								++int_21;
								byte_6 = method3493(dstate_0);
							}

							int_16 = ints_2[int_22 - ints_1[int_21]];
						}
						else
						{
							int int_18 = -1;
							int int_19 = 1;

							do
							{
								if (int_16 == 0)
								{
									int_18 += int_19;
								}
								else if (int_16 == 1)
								{
									int_18 += int_19 * 2;
								}

								int_19 *= 2;
								if (int_15 == 0)
								{
									++int_14;
									int_15 = 50;
									byte_7 = dstate_0.field2324[int_14];
									int_0 = dstate_0.field2330[byte_7];
									ints_0 = dstate_0.field2301[byte_7];
									ints_2 = dstate_0.field2329[byte_7];
									ints_1 = dstate_0.field2297[byte_7];
								}

								--int_15;
								int_21 = int_0;

								for (int_22 = method3490(int_0,
								        dstate_0); int_22 > ints_0[int_21]; int_22 = (int_22 << 1) | byte_6)
								{
									++int_21;
									byte_6 = method3493(dstate_0);
								}

								int_16 = ints_2[int_22 - ints_1[int_21]];
							}
							while ((int_16 == 0) || (int_16 == 1));

							++int_18;
							byte_0 = dstate_0.seqToUnseq[dstate_0.field2322[dstate_0.field2323[0]] & 0xFF];

							for (dstate_0.field2315[byte_0 & 0xFF] += int_18; int_18 > 0; --int_18)
							{
								class25.tt[int_17] = byte_0 & 0xFF;
								++int_17;
							}
						}
					}

					dstate_0.out_len = 0;
					dstate_0.out_ch = 0;
					dstate_0.field2317[0] = 0;

					for (int_7 = 1; int_7 <= 256; int_7++)
					{
						dstate_0.field2317[int_7] = dstate_0.field2315[int_7 - 1];
					}

					for (int_7 = 1; int_7 <= 256; int_7++)
					{
						dstate_0.field2317[int_7] += dstate_0.field2317[int_7 - 1];
					}

					for (int_7 = 0; int_7 < int_17; int_7++)
					{
						byte_0 = (byte) (class25.tt[int_7] & 0xFF);
						class25.tt[dstate_0.field2317[byte_0 & 0xFF]] |= int_7 << 8;
						++dstate_0.field2317[byte_0 & 0xFF];
					}

					dstate_0.tPos = class25.tt[dstate_0.field2312] >> 8;
					dstate_0.nblock_used = 0;
					dstate_0.tPos = class25.tt[dstate_0.tPos];
					dstate_0.k0 = (byte) (dstate_0.tPos & 0xFF);
					dstate_0.tPos >>= 8;
					++dstate_0.nblock_used;
					dstate_0.field2331 = int_17;
					method3500(dstate_0);
					if (((dstate_0.field2331 + 1) == dstate_0.nblock_used) && (dstate_0.out_len == 0))
					{
						bool_18 = true;
						break;
					}

					bool_18 = false;
					break;
				}
			}

			return;
		}
	}

	static byte method3492(final DState dstate_0)
	{
		return (byte) method3490(8, dstate_0);
	}

	static byte method3493(final DState dstate_0)
	{
		return (byte) method3490(1, dstate_0);
	}

	static int method3490(final int int_0, final DState dstate_0)
	{
		while (dstate_0.total_in_lo32 < int_0)
		{
			dstate_0.total_in_hi32 = (dstate_0.total_in_hi32 << 8) | (dstate_0.strm[dstate_0.next_in] & 0xFF);
			dstate_0.total_in_lo32 += 8;
			++dstate_0.next_in;
			++dstate_0.total_out_lo32;
			if (dstate_0.total_out_lo32 == 0)
			{
            }
		}

		final int int_1 = (dstate_0.total_in_hi32 >> (dstate_0.total_in_lo32 - int_0)) & ((1 << int_0) - 1);
		dstate_0.total_in_lo32 -= int_0;
		return int_1;
	}

	static void method3494(final DState dstate_0)
	{
		dstate_0.nInUse = 0;

		for (int int_0 = 0; int_0 < 256; int_0++)
		{
			if (dstate_0.inUse[int_0])
			{
				dstate_0.seqToUnseq[dstate_0.nInUse] = (byte) int_0;
				++dstate_0.nInUse;
			}
		}

	}

	static void method3495(final int[] ints_0, final int[] ints_1, final int[] ints_2, final byte[] bytes_0,
	        final int int_0, final int int_1, final int int_2)
	{
		int int_3 = 0;

		int int_4;
		for (int_4 = int_0; int_4 <= int_1; int_4++)
		{
			for (int int_5 = 0; int_5 < int_2; int_5++)
			{
				if (int_4 == bytes_0[int_5])
				{
					ints_2[int_3] = int_5;
					++int_3;
				}
			}
		}

		for (int_4 = 0; int_4 < 23; int_4++)
		{
			ints_1[int_4] = 0;
		}

		for (int_4 = 0; int_4 < int_2; int_4++)
		{
			++ints_1[bytes_0[int_4] + 1];
		}

		for (int_4 = 1; int_4 < 23; int_4++)
		{
			ints_1[int_4] += ints_1[int_4 - 1];
		}

		for (int_4 = 0; int_4 < 23; int_4++)
		{
			ints_0[int_4] = 0;
		}

		int int_6 = 0;

		for (int_4 = int_0; int_4 <= int_1; int_4++)
		{
			int_6 += ints_1[int_4 + 1] - ints_1[int_4];
			ints_0[int_4] = int_6 - 1;
			int_6 <<= 1;
		}

		for (int_4 = int_0 + 1; int_4 <= int_1; int_4++)
		{
			ints_1[int_4] = ((ints_0[int_4 - 1] + 1) << 1) - ints_1[int_4];
		}

	}

}
