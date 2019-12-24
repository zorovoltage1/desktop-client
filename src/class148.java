public class class148 implements class147
{

	public static int idxCount;

	static void method3195(final int int_0, final int int_1)
	{
		final int[] ints_0 = new int[4];
		final int[] ints_1 = new int[4];
		ints_0[0] = int_0;
		ints_1[0] = int_1;
		int int_2 = 1;

		for (int int_3 = 0; int_3 < 4; int_3++)
		{
			if (World.field946[int_3] != int_0)
			{
				ints_0[int_2] = World.field946[int_3];
				ints_1[int_2] = World.field939[int_3];
				++int_2;
			}
		}

		World.field946 = ints_0;
		World.field939 = ints_1;
		MapLabel.method282(World.worldList, 0, World.worldList.length - 1, World.field946, World.field939);
	}

	public static boolean method3196()
	{
		try
		{
			if (class217.field2460 == 2)
			{
				if (class177.track == null)
				{
					class177.track = Track1.getMusicFile(class138.field1871, class217.field2461,
					        class217.field2462);
					if (class177.track == null)
					{
						return false;
					}
				}

				if (Item.field1149 == null)
				{
					Item.field1149 = new class98(class217.field2458, class217.field2464);
				}

				if (class217.field2459.method4198(class177.track, class177.indices, Item.field1149, 22050))
				{
					class217.field2459.method4199();
					class217.field2459.method4236(class309.field3740);
					class217.field2459.method4267(class177.track, class217.field2463);
					class217.field2460 = 0;
					class177.track = null;
					Item.field1149 = null;
					class138.field1871 = null;
					return true;
				}
			}
		}
		catch (final Exception exception_0)
		{
			exception_0.printStackTrace();
			class217.field2459.method4202();
			class217.field2460 = 0;
			class177.track = null;
			Item.field1149 = null;
			class138.field1871 = null;
		}

		return false;
	}

	public static boolean method3197(final int int_0)
	{
		return ((int_0 >> 31) & 0x1) != 0;
	}

	static void method3198()
	{
		if (((class138.localPlayer.x >> 7) == Game.destinationX)
		        && ((class138.localPlayer.y >> 7) == Game.destinationY))
		{
			Game.destinationX = 0;
		}

	}

}
