public class class218 extends TaskDataNode
{

	HashTable field2481;
	int field2466;
	int field2474;
	int[] field2468;
	int[] field2469;
	int[] field2473;
	int[] field2484;
	int[] field2472;
	int[] field2467;
	int[] field2465;
	int[] field2475;
	int[] field2476;
	int[] field2478;
	int[] field2479;
	int[] field2480;
	int[] field2471;
	int[] field2482;
	int[] field2483;
	class219[][] field2470;
	class219[][] field2485;
	class220 field2486;
	boolean field2487;
	int field2488;
	int field2489;
	long field2490;
	long field2491;
	class222 field2492;

	public class218()
	{
		field2466 = 256;
		field2474 = 1000000;
		field2468 = new int[16];
		field2469 = new int[16];
		field2473 = new int[16];
		field2484 = new int[16];
		field2472 = new int[16];
		field2467 = new int[16];
		field2465 = new int[16];
		field2475 = new int[16];
		field2476 = new int[16];
		field2478 = new int[16];
		field2479 = new int[16];
		field2480 = new int[16];
		field2471 = new int[16];
		field2482 = new int[16];
		field2483 = new int[16];
		field2470 = new class219[16][128];
		field2485 = new class219[16][128];
		field2486 = new class220();
		field2492 = new class222(this);
		field2481 = new HashTable(128);
		method4216();
	}

	public synchronized void method4236(final int int_0)
	{
		field2466 = int_0;
	}

	public int method4288()
	{
		return field2466;
	}

	synchronized boolean method4198(final Track1 track1_0, final IndexDataBase indexdatabase_0, final class98 class98_0,
	        final int int_0)
	{
		track1_0.method4412();
		boolean bool_0 = true;
		int[] ints_0 = null;
		if (int_0 > 0)
		{
			ints_0 = new int[] { int_0 };
		}

		for (ByteArrayNode bytearraynode_0 = (ByteArrayNode) track1_0.field2547
		        .first(); bytearraynode_0 != null; bytearraynode_0 = (ByteArrayNode) track1_0.field2547.next())
		{
			final int int_1 = (int) bytearraynode_0.hash;
			class221 class221_0 = (class221) field2481.get(int_1);
			if (class221_0 == null)
			{
				final byte[] bytes_0 = indexdatabase_0.takeRecordFlat(int_1);
				class221 class221_1;
				if (bytes_0 == null)
				{
					class221_1 = null;
				}
				else
				{
					class221_1 = new class221(bytes_0);
				}

				class221_0 = class221_1;
				if (class221_1 == null)
				{
					bool_0 = false;
					continue;
				}

				field2481.put(class221_1, int_1);
			}

			if (!class221_0.method4372(class98_0, bytearraynode_0.byteArray, ints_0))
			{
				bool_0 = false;
			}
		}

		if (bool_0)
		{
			track1_0.method4413();
		}

		return bool_0;
	}

	synchronized void method4199()
	{
		for (class221 class221_0 = (class221) field2481.first(); class221_0 != null; class221_0 = (class221) field2481
		        .next())
		{
			class221_0.method4373();
		}

	}

	public synchronized void method4200()
	{
		for (class221 class221_0 = (class221) field2481.first(); class221_0 != null; class221_0 = (class221) field2481
		        .next())
		{
			class221_0.unlink();
		}

	}

	@Override
	protected synchronized TaskDataNode vmethod4382()
	{
		return field2492;
	}

	@Override
	protected synchronized TaskDataNode vmethod4389()
	{
		return null;
	}

	@Override
	protected synchronized int vmethod4395()
	{
		return 0;
	}

	@Override
	protected synchronized void vmethod4385(final int[] ints_0, int int_0, int int_1)
	{
		if (field2486.method4345())
		{
			final int int_2 = (field2486.field2519 * field2474) / AbstractSoundSystem.sampleRate;

			do
			{
				final long long_0 = field2490 + ((long) int_1 * (long) int_2);
				if ((field2491 - long_0) >= 0L)
				{
					field2490 = long_0;
					break;
				}

				final int int_3 = (int) ((((field2491 - field2490) + int_2) - 1L) / int_2);
				field2490 += (long) int_2 * (long) int_3;
				field2492.vmethod4385(ints_0, int_0, int_3);
				int_0 += int_3;
				int_1 -= int_3;
				method4277();
			}
			while (field2486.method4345());
		}

		field2492.vmethod4385(ints_0, int_0, int_1);
	}

	synchronized void method4267(final Track1 track1_0, final boolean bool_0)
	{
		method4202();
		field2486.method4328(track1_0.field2546);
		field2487 = bool_0;
		field2490 = 0L;
		final int int_0 = field2486.method4331();

		for (int int_1 = 0; int_1 < int_0; int_1++)
		{
			field2486.method4350(int_1);
			field2486.method4335(int_1);
			field2486.method4333(int_1);
		}

		field2488 = field2486.method4339();
		field2489 = field2486.field2525[field2488];
		field2491 = field2486.method4338(field2489);
	}

	@Override
	protected synchronized void vmethod4386(int int_0)
	{
		if (field2486.method4345())
		{
			final int int_1 = (field2486.field2519 * field2474) / AbstractSoundSystem.sampleRate;

			do
			{
				final long long_0 = ((long) int_0 * (long) int_1) + field2490;
				if ((field2491 - long_0) >= 0L)
				{
					field2490 = long_0;
					break;
				}

				final int int_2 = (int) ((((field2491 - field2490) + int_1) - 1L) / int_1);
				field2490 += (long) int_2 * (long) int_1;
				field2492.vmethod4386(int_2);
				int_0 -= int_2;
				method4277();
			}
			while (field2486.method4345());
		}

		field2492.vmethod4386(int_0);
	}

	public synchronized void method4202()
	{
		field2486.method4329();
		method4216();
	}

	public synchronized boolean method4203()
	{
		return field2486.method4345();
	}

	public synchronized void method4257(final int int_0, final int int_1)
	{
		method4205(int_0, int_1);
	}

	void method4205(final int int_0, final int int_1)
	{
		field2484[int_0] = int_1;
		field2467[int_0] = int_1 & 0xFFFFFF80;
		method4206(int_0, int_1);
	}

	void method4206(final int int_0, final int int_1)
	{
		if (int_1 != field2472[int_0])
		{
			field2472[int_0] = int_1;

			for (int int_2 = 0; int_2 < 128; int_2++)
			{
				field2485[int_0][int_2] = null;
			}
		}

	}

	void method4305(final int int_0, final int int_1, final int int_2)
	{
		method4209(int_0, int_1, 64);
		if ((field2478[int_0] & 0x2) != 0)
		{
			for (class219 class219_0 = (class219) field2492.field2543
			        .getTail(); class219_0 != null; class219_0 = (class219) field2492.field2543.getPrevious())
			{
				if ((class219_0.field2500 == int_0) && (class219_0.field2508 < 0))
				{
					field2470[int_0][class219_0.field2502] = null;
					field2470[int_0][int_1] = class219_0;
					final int int_3 = ((class219_0.field2504 * class219_0.field2503) >> 12) + class219_0.field2516;
					class219_0.field2516 += (int_1 - class219_0.field2502) << 8;
					class219_0.field2503 = int_3 - class219_0.field2516;
					class219_0.field2504 = 4096;
					class219_0.field2502 = int_1;
					return;
				}
			}
		}

		final class221 class221_0 = (class221) field2481.get(field2472[int_0]);
		if (class221_0 != null)
		{
			final RawAudioNode rawaudionode_0 = class221_0.field2533[int_1];
			if (rawaudionode_0 != null)
			{
				final class219 class219_1 = new class219();
				class219_1.field2500 = int_0;
				class219_1.field2517 = class221_0;
				class219_1.field2496 = rawaudionode_0;
				class219_1.field2511 = class221_0.field2537[int_1];
				class219_1.field2498 = class221_0.field2538[int_1];
				class219_1.field2502 = int_1;
				class219_1.field2507 = ((int_2 * int_2 * class221_0.field2532[int_1] * class221_0.field2540)
				        + 1024) >> 11;
				class219_1.field2501 = class221_0.field2536[int_1] & 0xFF;
				class219_1.field2516 = (int_1 << 8) - (class221_0.field2534[int_1] & 0x7FFF);
				class219_1.field2505 = 0;
				class219_1.field2506 = 0;
				class219_1.field2497 = 0;
				class219_1.field2508 = -1;
				class219_1.field2495 = 0;
				if (field2471[int_0] == 0)
				{
					class219_1.field2512 = class103.method2256(rawaudionode_0, method4249(class219_1),
					        method4222(class219_1), method4286(class219_1));
				}
				else
				{
					class219_1.field2512 = class103.method2256(rawaudionode_0, method4249(class219_1), 0,
					        method4286(class219_1));
					method4208(class219_1, class221_0.field2534[int_1] < 0);
				}

				if (class221_0.field2534[int_1] < 0)
				{
					class219_1.field2512.method2258(-1);
				}

				if (class219_1.field2498 >= 0)
				{
					final class219 class219_2 = field2485[int_0][class219_1.field2498];
					if ((class219_2 != null) && (class219_2.field2508 < 0))
					{
						field2470[int_0][class219_2.field2502] = null;
						class219_2.field2508 = 0;
					}

					field2485[int_0][class219_1.field2498] = class219_1;
				}

				field2492.field2543.addFront(class219_1);
				field2470[int_0][int_1] = class219_1;
			}
		}
	}

	void method4208(final class219 class219_0, final boolean bool_0)
	{
		int int_0 = class219_0.field2496.audioBuffer.length;
		int int_2;
		if (bool_0 && class219_0.field2496.field1281)
		{
			final int int_1 = (int_0 + int_0) - class219_0.field2496.startPosition;
			int_2 = (int) (((long) int_1 * (long) field2471[class219_0.field2500]) >> 6);
			int_0 <<= 8;
			if (int_2 >= int_0)
			{
				int_2 = (int_0 + int_0) - 1 - int_2;
				class219_0.field2512.method2307();
			}
		}
		else
		{
			int_2 = (int) (((long) int_0 * (long) field2471[class219_0.field2500]) >> 6);
		}

		class219_0.field2512.method2264(int_2);
	}

	void method4209(final int int_0, final int int_1, final int int_2)
	{
		final class219 class219_0 = field2470[int_0][int_1];
		if (class219_0 != null)
		{
			field2470[int_0][int_1] = null;
			if ((field2478[int_0] & 0x2) != 0)
			{
				for (class219 class219_1 = (class219) field2492.field2543
				        .getFront(); class219_1 != null; class219_1 = (class219) field2492.field2543.getNext())
				{
					if ((class219_1.field2500 == class219_0.field2500) && (class219_1.field2508 < 0)
					        && (class219_0 != class219_1))
					{
						class219_0.field2508 = 0;
						break;
					}
				}
			}
			else
			{
				class219_0.field2508 = 0;
			}

		}
	}

	void method4210(final int int_0, final int int_1, final int int_2)
	{
	}

	void method4211(final int int_0, final int int_1)
	{
	}

	void method4212(final int int_0, final int int_1)
	{
		field2465[int_0] = int_1;
	}

	void method4213(final int int_0)
	{
		for (class219 class219_0 = (class219) field2492.field2543
		        .getFront(); class219_0 != null; class219_0 = (class219) field2492.field2543.getNext())
		{
			if ((int_0 < 0) || (class219_0.field2500 == int_0))
			{
				if (class219_0.field2512 != null)
				{
					class219_0.field2512.method2269(AbstractSoundSystem.sampleRate / 100);
					if (class219_0.field2512.method2273())
					{
						field2492.field2544.method2032(class219_0.field2512);
					}

					class219_0.method4322();
				}

				if (class219_0.field2508 < 0)
				{
					field2470[class219_0.field2500][class219_0.field2502] = null;
				}

				class219_0.unlink();
			}
		}

	}

	void method4241(int int_0)
	{
		if (int_0 >= 0)
		{
			field2468[int_0] = 12800;
			field2469[int_0] = 8192;
			field2473[int_0] = 16383;
			field2465[int_0] = 8192;
			field2475[int_0] = 0;
			field2476[int_0] = 8192;
			method4278(int_0);
			method4218(int_0);
			field2478[int_0] = 0;
			field2479[int_0] = 32767;
			field2480[int_0] = 256;
			field2471[int_0] = 0;
			method4309(int_0, 8192);
		}
		else
		{
			for (int_0 = 0; int_0 < 16; int_0++)
			{
				method4241(int_0);
			}

		}
	}

	void method4215(final int int_0)
	{
		for (class219 class219_0 = (class219) field2492.field2543
		        .getFront(); class219_0 != null; class219_0 = (class219) field2492.field2543.getNext())
		{
			if (((int_0 < 0) || (class219_0.field2500 == int_0)) && (class219_0.field2508 < 0))
			{
				field2470[class219_0.field2500][class219_0.field2502] = null;
				class219_0.field2508 = 0;
			}
		}

	}

	void method4216()
	{
		method4213(-1);
		method4241(-1);

		int int_0;
		for (int_0 = 0; int_0 < 16; int_0++)
		{
			field2472[int_0] = field2484[int_0];
		}

		for (int_0 = 0; int_0 < 16; int_0++)
		{
			field2467[int_0] = field2484[int_0] & 0xFFFFFF80;
		}

	}

	void method4278(final int int_0)
	{
		if ((field2478[int_0] & 0x2) != 0)
		{
			for (class219 class219_0 = (class219) field2492.field2543
			        .getFront(); class219_0 != null; class219_0 = (class219) field2492.field2543.getNext())
			{
				if ((class219_0.field2500 == int_0) && (field2470[int_0][class219_0.field2502] == null)
				        && (class219_0.field2508 < 0))
				{
					class219_0.field2508 = 0;
				}
			}
		}

	}

	void method4218(final int int_0)
	{
		if ((field2478[int_0] & 0x4) != 0)
		{
			for (class219 class219_0 = (class219) field2492.field2543
			        .getFront(); class219_0 != null; class219_0 = (class219) field2492.field2543.getNext())
			{
				if (class219_0.field2500 == int_0)
				{
					class219_0.field2514 = 0;
				}
			}
		}

	}

	void method4219(final int int_0)
	{
		int int_1 = int_0 & 0xF0;
		int int_2;
		int int_3;
		int int_4;
		if (int_1 == 128)
		{
			int_2 = int_0 & 0xF;
			int_3 = (int_0 >> 8) & 0x7F;
			int_4 = (int_0 >> 16) & 0x7F;
			method4209(int_2, int_3, int_4);
		}
		else if (int_1 == 144)
		{
			int_2 = int_0 & 0xF;
			int_3 = (int_0 >> 8) & 0x7F;
			int_4 = (int_0 >> 16) & 0x7F;
			if (int_4 > 0)
			{
				method4305(int_2, int_3, int_4);
			}
			else
			{
				method4209(int_2, int_3, 64);
			}

		}
		else if (int_1 == 160)
		{
			int_2 = int_0 & 0xF;
			int_3 = (int_0 >> 8) & 0x7F;
			int_4 = (int_0 >> 16) & 0x7F;
			method4210(int_2, int_3, int_4);
		}
		else if (int_1 == 176)
		{
			int_2 = int_0 & 0xF;
			int_3 = (int_0 >> 8) & 0x7F;
			int_4 = (int_0 >> 16) & 0x7F;
			if (int_3 == 0)
			{
				field2467[int_2] = (int_4 << 14) + (field2467[int_2] & 0xFFE03FFF);
			}

			if (int_3 == 32)
			{
				field2467[int_2] = (int_4 << 7) + (field2467[int_2] & 0xFFFFC07F);
			}

			if (int_3 == 1)
			{
				field2475[int_2] = (int_4 << 7) + (field2475[int_2] & 0xFFFFC07F);
			}

			if (int_3 == 33)
			{
				field2475[int_2] = int_4 + (field2475[int_2] & 0xFFFFFF80);
			}

			if (int_3 == 5)
			{
				field2476[int_2] = (int_4 << 7) + (field2476[int_2] & 0xFFFFC07F);
			}

			if (int_3 == 37)
			{
				field2476[int_2] = int_4 + (field2476[int_2] & 0xFFFFFF80);
			}

			if (int_3 == 7)
			{
				field2468[int_2] = (int_4 << 7) + (field2468[int_2] & 0xFFFFC07F);
			}

			if (int_3 == 39)
			{
				field2468[int_2] = int_4 + (field2468[int_2] & 0xFFFFFF80);
			}

			if (int_3 == 10)
			{
				field2469[int_2] = (int_4 << 7) + (field2469[int_2] & 0xFFFFC07F);
			}

			if (int_3 == 42)
			{
				field2469[int_2] = int_4 + (field2469[int_2] & 0xFFFFFF80);
			}

			if (int_3 == 11)
			{
				field2473[int_2] = (int_4 << 7) + (field2473[int_2] & 0xFFFFC07F);
			}

			if (int_3 == 43)
			{
				field2473[int_2] = int_4 + (field2473[int_2] & 0xFFFFFF80);
			}

			if (int_3 == 64)
			{
				if (int_4 >= 64)
				{
					field2478[int_2] |= 0x1;
				}
				else
				{
					field2478[int_2] &= 0xFFFFFFFE;
				}
			}

			if (int_3 == 65)
			{
				if (int_4 >= 64)
				{
					field2478[int_2] |= 0x2;
				}
				else
				{
					method4278(int_2);
					field2478[int_2] &= 0xFFFFFFFD;
				}
			}

			if (int_3 == 99)
			{
				field2479[int_2] = (int_4 << 7) + (field2479[int_2] & 0x7F);
			}

			if (int_3 == 98)
			{
				field2479[int_2] = (field2479[int_2] & 0x3F80) + int_4;
			}

			if (int_3 == 101)
			{
				field2479[int_2] = (int_4 << 7) + (field2479[int_2] & 0x7F) + 16384;
			}

			if (int_3 == 100)
			{
				field2479[int_2] = (field2479[int_2] & 0x3F80) + int_4 + 16384;
			}

			if (int_3 == 120)
			{
				method4213(int_2);
			}

			if (int_3 == 121)
			{
				method4241(int_2);
			}

			if (int_3 == 123)
			{
				method4215(int_2);
			}

			int int_5;
			if (int_3 == 6)
			{
				int_5 = field2479[int_2];
				if (int_5 == 16384)
				{
					field2480[int_2] = (int_4 << 7) + (field2480[int_2] & 0xFFFFC07F);
				}
			}

			if (int_3 == 38)
			{
				int_5 = field2479[int_2];
				if (int_5 == 16384)
				{
					field2480[int_2] = int_4 + (field2480[int_2] & 0xFFFFFF80);
				}
			}

			if (int_3 == 16)
			{
				field2471[int_2] = (int_4 << 7) + (field2471[int_2] & 0xFFFFC07F);
			}

			if (int_3 == 48)
			{
				field2471[int_2] = int_4 + (field2471[int_2] & 0xFFFFFF80);
			}

			if (int_3 == 81)
			{
				if (int_4 >= 64)
				{
					field2478[int_2] |= 0x4;
				}
				else
				{
					method4218(int_2);
					field2478[int_2] &= 0xFFFFFFFB;
				}
			}

			if (int_3 == 17)
			{
				method4309(int_2, (int_4 << 7) + (field2482[int_2] & 0xFFFFC07F));
			}

			if (int_3 == 49)
			{
				method4309(int_2, int_4 + (field2482[int_2] & 0xFFFFFF80));
			}

		}
		else if (int_1 == 192)
		{
			int_2 = int_0 & 0xF;
			int_3 = (int_0 >> 8) & 0x7F;
			method4206(int_2, int_3 + field2467[int_2]);
		}
		else if (int_1 == 208)
		{
			int_2 = int_0 & 0xF;
			int_3 = (int_0 >> 8) & 0x7F;
			method4211(int_2, int_3);
		}
		else if (int_1 == 224)
		{
			int_2 = int_0 & 0xF;
			int_3 = ((int_0 >> 8) & 0x7F) + ((int_0 >> 9) & 0x3F80);
			method4212(int_2, int_3);
		}
		else
		{
			int_1 = int_0 & 0xFF;
			if (int_1 == 255)
			{
				method4216();
			}
		}
	}

	void method4309(final int int_0, final int int_1)
	{
		field2482[int_0] = int_1;
		field2483[int_0] = (int) ((2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * int_1)) + 0.5D);
	}

	int method4249(final class219 class219_0)
	{
		int int_0 = ((class219_0.field2503 * class219_0.field2504) >> 12) + class219_0.field2516;
		int_0 += ((field2465[class219_0.field2500] - 8192) * field2480[class219_0.field2500]) >> 12;
		final class216 class216_0 = class219_0.field2511;
		int int_1;
		if ((class216_0.field2452 > 0) && ((class216_0.field2453 > 0) || (field2475[class219_0.field2500] > 0)))
		{
			int_1 = class216_0.field2453 << 2;
			final int int_2 = class216_0.field2454 << 1;
			if (class219_0.field2499 < int_2)
			{
				int_1 = (int_1 * class219_0.field2499) / int_2;
			}

			int_1 += field2475[class219_0.field2500] >> 7;
			final double double_0 = Math.sin(0.01227184630308513D * (class219_0.field2509 & 0x1FF));
			int_0 += (int) (double_0 * int_1);
		}

		int_1 = (int) (((class219_0.field2496.sampleRate * 256 * Math.pow(2.0D, int_0 * 3.255208333333333E-4D))
		        / AbstractSoundSystem.sampleRate) + 0.5D);
		return int_1 < 1 ? 1 : int_1;
	}

	int method4222(final class219 class219_0)
	{
		final class216 class216_0 = class219_0.field2511;
		int int_0 = ((field2473[class219_0.field2500] * field2468[class219_0.field2500]) + 4096) >> 13;
		int_0 = ((int_0 * int_0) + 16384) >> 15;
		int_0 = ((int_0 * class219_0.field2507) + 16384) >> 15;
		int_0 = ((int_0 * field2466) + 128) >> 8;
		if (class216_0.field2448 > 0)
		{
			int_0 = (int) ((int_0 * Math.pow(0.5D, 1.953125E-5D * class219_0.field2505 * class216_0.field2448)) + 0.5D);
		}

		int int_1;
		int int_2;
		int int_3;
		int int_4;
		if (class216_0.field2447 != null)
		{
			int_1 = class219_0.field2506;
			int_2 = class216_0.field2447[class219_0.field2497 + 1];
			if (class219_0.field2497 < (class216_0.field2447.length - 2))
			{
				int_3 = (class216_0.field2447[class219_0.field2497] & 0xFF) << 8;
				int_4 = (class216_0.field2447[class219_0.field2497 + 2] & 0xFF) << 8;
				int_2 += ((int_1 - int_3) * (class216_0.field2447[class219_0.field2497 + 3] - int_2)) / (int_4 - int_3);
			}

			int_0 = ((int_0 * int_2) + 32) >> 6;
		}

		if ((class219_0.field2508 > 0) && (class216_0.field2449 != null))
		{
			int_1 = class219_0.field2508;
			int_2 = class216_0.field2449[class219_0.field2495 + 1];
			if (class219_0.field2495 < (class216_0.field2449.length - 2))
			{
				int_3 = (class216_0.field2449[class219_0.field2495] & 0xFF) << 8;
				int_4 = (class216_0.field2449[class219_0.field2495 + 2] & 0xFF) << 8;
				int_2 += ((int_1 - int_3) * (class216_0.field2449[class219_0.field2495 + 3] - int_2)) / (int_4 - int_3);
			}

			int_0 = ((int_2 * int_0) + 32) >> 6;
		}

		return int_0;
	}

	int method4286(final class219 class219_0)
	{
		final int int_0 = field2469[class219_0.field2500];
		return int_0 < 8192 ? ((int_0 * class219_0.field2501) + 32) >> 6
		        : 16384 - ((((128 - class219_0.field2501) * (16384 - int_0)) + 32) >> 6);
	}

	void method4277()
	{
		int int_0 = field2488;
		int int_1 = field2489;

		long long_0;
		for (long_0 = field2491; int_1 == field2489; long_0 = field2486.method4338(int_1))
		{
			while (int_1 == field2486.field2525[int_0])
			{
				field2486.method4350(int_0);
				final int int_2 = field2486.method4336(int_0);
				if (int_2 == 1)
				{
					field2486.method4334();
					field2486.method4333(int_0);
					if (field2486.method4340())
					{
						if (!field2487 || (int_1 == 0))
						{
							method4216();
							field2486.method4329();
							return;
						}

						field2486.method4341(long_0);
					}
					break;
				}

				if ((int_2 & 0x80) != 0)
				{
					method4219(int_2);
				}

				field2486.method4335(int_0);
				field2486.method4333(int_0);
			}

			int_0 = field2486.method4339();
			int_1 = field2486.field2525[int_0];
		}

		field2488 = int_0;
		field2489 = int_1;
		field2491 = long_0;
	}

	boolean method4230(final class219 class219_0)
	{
		if (class219_0.field2512 == null)
		{
			if (class219_0.field2508 >= 0)
			{
				class219_0.unlink();
				if ((class219_0.field2498 > 0) && (class219_0 == field2485[class219_0.field2500][class219_0.field2498]))
				{
					field2485[class219_0.field2500][class219_0.field2498] = null;
				}
			}

			return true;
		}
		else
		{
			return false;
		}
	}

	boolean method4231(final class219 class219_0, final int[] ints_0, final int int_0, final int int_1)
	{
		class219_0.field2513 = AbstractSoundSystem.sampleRate / 100;
		if ((class219_0.field2508 < 0) || ((class219_0.field2512 != null) && !class219_0.field2512.method2272()))
		{
			int int_2 = class219_0.field2504;
			if (int_2 > 0)
			{
				int_2 -= (int) ((16.0D * Math.pow(2.0D, 4.921259842519685E-4D * field2476[class219_0.field2500]))
				        + 0.5D);
				if (int_2 < 0)
				{
					int_2 = 0;
				}

				class219_0.field2504 = int_2;
			}

			class219_0.field2512.method2270(method4249(class219_0));
			final class216 class216_0 = class219_0.field2511;
			boolean bool_0 = false;
			++class219_0.field2499;
			class219_0.field2509 += class216_0.field2452;
			final double double_0 = (((class219_0.field2502 - 60) << 8)
			        + ((class219_0.field2503 * class219_0.field2504) >> 12)) * 5.086263020833333E-6D;
			if (class216_0.field2448 > 0)
			{
				if (class216_0.field2451 > 0)
				{
					class219_0.field2505 += (int) ((128.0D * Math.pow(2.0D, double_0 * class216_0.field2451)) + 0.5D);
				}
				else
				{
					class219_0.field2505 += 128;
				}
			}

			if (class216_0.field2447 != null)
			{
				if (class216_0.field2450 > 0)
				{
					class219_0.field2506 += (int) ((128.0D * Math.pow(2.0D, class216_0.field2450 * double_0)) + 0.5D);
				}
				else
				{
					class219_0.field2506 += 128;
				}

				while ((class219_0.field2497 < (class216_0.field2447.length - 2))
				        && (class219_0.field2506 > ((class216_0.field2447[class219_0.field2497 + 2] & 0xFF) << 8)))
				{
					class219_0.field2497 += 2;
				}

				if (((class216_0.field2447.length - 2) == class219_0.field2497)
				        && (class216_0.field2447[class219_0.field2497 + 1] == 0))
				{
					bool_0 = true;
				}
			}

			if ((class219_0.field2508 >= 0) && (class216_0.field2449 != null)
			        && ((field2478[class219_0.field2500] & 0x1) == 0) && ((class219_0.field2498 < 0)
			                || (class219_0 != field2485[class219_0.field2500][class219_0.field2498])))
			{
				if (class216_0.field2446 > 0)
				{
					class219_0.field2508 += (int) ((128.0D * Math.pow(2.0D, class216_0.field2446 * double_0)) + 0.5D);
				}
				else
				{
					class219_0.field2508 += 128;
				}

				while ((class219_0.field2495 < (class216_0.field2449.length - 2))
				        && (class219_0.field2508 > ((class216_0.field2449[class219_0.field2495 + 2] & 0xFF) << 8)))
				{
					class219_0.field2495 += 2;
				}

				if ((class216_0.field2449.length - 2) == class219_0.field2495)
				{
					bool_0 = true;
				}
			}

			if (bool_0)
			{
				class219_0.field2512.method2269(class219_0.field2513);
				if (ints_0 != null)
				{
					class219_0.field2512.vmethod4385(ints_0, int_0, int_1);
				}
				else
				{
					class219_0.field2512.vmethod4386(int_1);
				}

				if (class219_0.field2512.method2273())
				{
					field2492.field2544.method2032(class219_0.field2512);
				}

				class219_0.method4322();
				if (class219_0.field2508 >= 0)
				{
					class219_0.unlink();
					if ((class219_0.field2498 > 0)
					        && (class219_0 == field2485[class219_0.field2500][class219_0.field2498]))
					{
						field2485[class219_0.field2500][class219_0.field2498] = null;
					}
				}

				return true;
			}
			else
			{
				class219_0.field2512.method2268(class219_0.field2513, method4222(class219_0), method4286(class219_0));
				return false;
			}
		}
		else
		{
			class219_0.method4322();
			class219_0.unlink();
			if ((class219_0.field2498 > 0) && (class219_0 == field2485[class219_0.field2500][class219_0.field2498]))
			{
				field2485[class219_0.field2500][class219_0.field2498] = null;
			}

			return true;
		}
	}

}
