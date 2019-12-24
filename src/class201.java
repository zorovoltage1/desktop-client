public final class class201
{

	int field2410;
	int field2411;
	IterableHashTable field2412;
	IterableDualNodeQueue field2413;

	public class201(final int int_0, final int int_1)
	{
		field2413 = new IterableDualNodeQueue();
		field2410 = int_0;
		field2411 = int_0;

		int int_2;
		for (int_2 = 1; ((int_2 + int_2) < int_0) && (int_2 < int_1); int_2 += int_2)
		{
        }

		field2412 = new IterableHashTable(int_2);
	}

	public Object method3997(final long long_0)
	{
		final class212 class212_0 = (class212) field2412.get(long_0);
		if (class212_0 == null)
		{
			return null;
		}
		else
		{
			final Object object_0 = class212_0.vmethod4137();
			if (object_0 == null)
			{
				class212_0.unlink();
				class212_0.unlinkDual();
				field2411 += class212_0.field2439;
				return null;
			}
			else
			{
				if (class212_0.vmethod4136())
				{
					final class196 class196_0 = new class196(object_0, class212_0.field2439);
					field2412.put(class196_0, class212_0.hash);
					field2413.add(class196_0);
					class196_0.field2428 = 0L;
					class212_0.unlink();
					class212_0.unlinkDual();
				}
				else
				{
					field2413.add(class212_0);
					class212_0.field2428 = 0L;
				}

				return object_0;
			}
		}
	}

	void method3993(final long long_0)
	{
		final class212 class212_0 = (class212) field2412.get(long_0);
		method3996(class212_0);
	}

	void method3996(final class212 class212_0)
	{
		if (class212_0 != null)
		{
			class212_0.unlink();
			class212_0.unlinkDual();
			field2411 += class212_0.field2439;
		}

	}

	public void method4007(final Object object_0, final long long_0)
	{
		method3998(object_0, long_0, 1);
	}

	public void method3998(final Object object_0, final long long_0, final int int_0)
	{
		if (int_0 > field2410)
		{
			throw new IllegalStateException();
		}
		else
		{
			method3993(long_0);
			field2411 -= int_0;

			while (field2411 < 0)
			{
				final class212 class212_0 = (class212) field2413.method4156();
				method3996(class212_0);
			}

			final class196 class196_0 = new class196(object_0, int_0);
			field2412.put(class196_0, long_0);
			field2413.add(class196_0);
			class196_0.field2428 = 0L;
		}
	}

	public void method3999(final int int_0)
	{
		for (class212 class212_0 = (class212) field2413
		        .method4177(); class212_0 != null; class212_0 = (class212) field2413.method4159())
		{
			if (class212_0.vmethod4136())
			{
				if (class212_0.vmethod4137() == null)
				{
					class212_0.unlink();
					class212_0.unlinkDual();
					field2411 += class212_0.field2439;
				}
			}
			else if (++class212_0.field2428 > int_0)
			{
				final class207 class207_0 = new class207(class212_0.vmethod4137(), class212_0.field2439);
				field2412.put(class207_0, class212_0.hash);
				Node2LinkedList.method3909(class207_0, class212_0);
				class212_0.unlink();
				class212_0.unlinkDual();
			}
		}

	}

	public void method4006()
	{
		field2413.clear();
		field2412.clear();
		field2411 = field2410;
	}

}
