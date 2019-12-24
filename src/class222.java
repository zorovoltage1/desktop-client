import java.io.IOException;

public class class222 extends TaskDataNode
{

	class218 field2545;
	Deque field2543;
	class88 field2544;

	class222(final class218 class218_0)
	{
		field2543 = new Deque();
		field2544 = new class88();
		field2545 = class218_0;
	}

	void method4387(final class219 class219_0, final int[] ints_0, int int_0, int int_1, final int int_2)
	{
		if (((field2545.field2478[class219_0.field2500] & 0x4) != 0) && (class219_0.field2508 < 0))
		{
			final int int_3 = field2545.field2483[class219_0.field2500] / AbstractSoundSystem.sampleRate;

			while (true)
			{
				final int int_4 = ((int_3 + 1048575) - class219_0.field2514) / int_3;
				if (int_4 > int_1)
				{
					class219_0.field2514 += int_1 * int_3;
					break;
				}

				class219_0.field2512.vmethod4385(ints_0, int_0, int_4);
				int_0 += int_4;
				int_1 -= int_4;
				class219_0.field2514 += (int_3 * int_4) - 1048576;
				int int_5 = AbstractSoundSystem.sampleRate / 100;
				final int int_6 = 262144 / int_3;
				if (int_6 < int_5)
				{
					int_5 = int_6;
				}

				final class103 class103_0 = class219_0.field2512;
				if (field2545.field2471[class219_0.field2500] == 0)
				{
					class219_0.field2512 = class103.method2256(class219_0.field2496, class103_0.method2351(),
					        class103_0.method2262(), class103_0.method2263());
				}
				else
				{
					class219_0.field2512 = class103.method2256(class219_0.field2496, class103_0.method2351(), 0,
					        class103_0.method2263());
					field2545.method4208(class219_0, class219_0.field2517.field2534[class219_0.field2502] < 0);
					class219_0.field2512.method2408(int_5, class103_0.method2262());
				}

				if (class219_0.field2517.field2534[class219_0.field2502] < 0)
				{
					class219_0.field2512.method2258(-1);
				}

				class103_0.method2269(int_5);
				class103_0.vmethod4385(ints_0, int_0, int_2 - int_0);
				if (class103_0.method2273())
				{
					field2544.method2032(class103_0);
				}
			}
		}

		class219_0.field2512.vmethod4385(ints_0, int_0, int_1);
	}

	void method4388(final class219 class219_0, int int_0)
	{
		if (((field2545.field2478[class219_0.field2500] & 0x4) != 0) && (class219_0.field2508 < 0))
		{
			final int int_1 = field2545.field2483[class219_0.field2500] / AbstractSoundSystem.sampleRate;
			final int int_2 = ((int_1 + 1048575) - class219_0.field2514) / int_1;
			class219_0.field2514 = ((int_1 * int_0) + class219_0.field2514) & 0xFFFFF;
			if (int_2 <= int_0)
			{
				if (field2545.field2471[class219_0.field2500] == 0)
				{
					class219_0.field2512 = class103.method2256(class219_0.field2496, class219_0.field2512.method2351(),
					        class219_0.field2512.method2262(), class219_0.field2512.method2263());
				}
				else
				{
					class219_0.field2512 = class103.method2256(class219_0.field2496, class219_0.field2512.method2351(),
					        0, class219_0.field2512.method2263());
					field2545.method4208(class219_0, class219_0.field2517.field2534[class219_0.field2502] < 0);
				}

				if (class219_0.field2517.field2534[class219_0.field2502] < 0)
				{
					class219_0.field2512.method2258(-1);
				}

				int_0 = class219_0.field2514 / int_1;
			}
		}

		class219_0.field2512.vmethod4386(int_0);
	}

	@Override
	protected TaskDataNode vmethod4382()
	{
		final class219 class219_0 = (class219) field2543.getFront();
		return class219_0 == null ? null : (class219_0.field2512 != null ? class219_0.field2512 : vmethod4389());
	}

	@Override
	protected TaskDataNode vmethod4389()
	{
		class219 class219_0;
		do
		{
			class219_0 = (class219) field2543.getNext();
			if (class219_0 == null)
			{
				return null;
			}
		}
		while (class219_0.field2512 == null);

		return class219_0.field2512;
	}

	@Override
	protected int vmethod4395()
	{
		return 0;
	}

	@Override
	protected void vmethod4385(final int[] ints_0, final int int_0, final int int_1)
	{
		field2544.vmethod4385(ints_0, int_0, int_1);

		for (class219 class219_0 = (class219) field2543
		        .getFront(); class219_0 != null; class219_0 = (class219) field2543.getNext())
		{
			if (!field2545.method4230(class219_0))
			{
				int int_2 = int_0;
				int int_3 = int_1;

				do
				{
					if (int_3 <= class219_0.field2513)
					{
						method4387(class219_0, ints_0, int_2, int_3, int_2 + int_3);
						class219_0.field2513 -= int_3;
						break;
					}

					method4387(class219_0, ints_0, int_2, class219_0.field2513, int_2 + int_3);
					int_2 += class219_0.field2513;
					int_3 -= class219_0.field2513;
				}
				while (!field2545.method4231(class219_0, ints_0, int_2, int_3));
			}
		}

	}

	@Override
	protected void vmethod4386(final int int_0)
	{
		field2544.vmethod4386(int_0);

		for (class219 class219_0 = (class219) field2543
		        .getFront(); class219_0 != null; class219_0 = (class219) field2543.getNext())
		{
			if (!field2545.method4230(class219_0))
			{
				int int_1 = int_0;

				do
				{
					if (int_1 <= class219_0.field2513)
					{
						method4388(class219_0, int_1);
						class219_0.field2513 -= int_1;
						break;
					}

					method4388(class219_0, class219_0.field2513);
					int_1 -= class219_0.field2513;
				}
				while (!field2545.method4231(class219_0, null, 0, int_1));
			}
		}

	}

	public static void sendConInfo(final boolean bool_0)
	{
		if (class250.NetCache_socket != null)
		{
			try
			{
				final Buffer buffer_0 = new Buffer(4);
				buffer_0.putByte(bool_0 ? 2 : 3);
				buffer_0.put24bitInt(0);
				class250.NetCache_socket.vmethod3347(buffer_0.payload, 0, 4);
			}
			catch (final IOException ioexception_0)
			{
				try
				{
					class250.NetCache_socket.vmethod3346();
				}
				catch (final Exception exception_0)
				{
                }

				++class250.field3215;
				class250.NetCache_socket = null;
			}

		}
	}

}
