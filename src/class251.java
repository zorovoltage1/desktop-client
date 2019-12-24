import java.util.HashMap;

public class class251
{

	final HashMap field3220;
	Bounds field3219;
	int[] field3218;
	int[] field3216;
	int field3217;

	public class251()
	{
		field3220 = new HashMap();
		field3219 = new Bounds(0, 0);
		field3218 = new int[2048];
		field3216 = new int[2048];
		field3217 = 0;
		CombatInfo1.method1560();
	}

	void method4771(final int int_0)
	{
		final int int_1 = (int_0 * 2) + 1;
		final double[] doubles_0 = Enum.method4986(0.0D, int_0 / 3.0F, int_0);
		final double double_0 = doubles_0[int_0] * doubles_0[int_0];
		final int[] ints_0 = new int[int_1 * int_1];
		boolean bool_0 = false;

		for (int int_2 = 0; int_2 < int_1; int_2++)
		{
			for (int int_3 = 0; int_3 < int_1; int_3++)
			{
				final int int_4 = ints_0[int_3
				        + (int_2 * int_1)] = (int) (256.0D * ((doubles_0[int_2] * doubles_0[int_3]) / double_0));
				if (!bool_0 && (int_4 > 0))
				{
					bool_0 = true;
				}
			}
		}

		final SpritePixels spritepixels_0 = new SpritePixels(ints_0, int_1, int_1);
		field3220.put(Integer.valueOf(int_0), spritepixels_0);
	}

	SpritePixels method4772(final int int_0)
	{
		if (!field3220.containsKey(Integer.valueOf(int_0)))
		{
			method4771(int_0);
		}

		return (SpritePixels) field3220.get(Integer.valueOf(int_0));
	}

	public void method4773(final int int_0, final int int_1)
	{
		if (field3217 < field3218.length)
		{
			field3218[field3217] = int_0;
			field3216[field3217] = int_1;
			++field3217;
		}
	}

	public void method4774()
	{
		field3217 = 0;
	}

	public void method4776(final int int_0, final int int_1, final SpritePixels spritepixels_0, final float float_0)
	{
		final int int_2 = (int) (float_0 * 18.0F);
		final SpritePixels spritepixels_1 = method4772(int_2);
		final int int_3 = (int_2 * 2) + 1;
		final Bounds bounds_0 = new Bounds(0, 0, spritepixels_0.width, spritepixels_0.height);
		final Bounds bounds_1 = new Bounds(0, 0);
		field3219.method5680(int_3, int_3);
		System.nanoTime();

		int int_4;
		int int_5;
		int int_6;
		for (int_4 = 0; int_4 < field3217; int_4++)
		{
			int_5 = field3218[int_4];
			int_6 = field3216[int_4];
			final int int_7 = (int) ((int_5 - int_0) * float_0) - int_2;
			final int int_8 = (int) (spritepixels_0.height - (float_0 * (int_6 - int_1))) - int_2;
			field3219.method5679(int_7, int_8);
			field3219.method5681(bounds_0, bounds_1);
			method4790(spritepixels_1, spritepixels_0, bounds_1);
		}

		System.nanoTime();
		System.nanoTime();

		for (int_4 = 0; int_4 < spritepixels_0.pixels.length; int_4++)
		{
			if (spritepixels_0.pixels[int_4] == 0)
			{
				spritepixels_0.pixels[int_4] = -16777216;
			}
			else
			{
				int_5 = ((spritepixels_0.pixels[int_4] + 64) - 1) / 256;
				if (int_5 <= 0)
				{
					spritepixels_0.pixels[int_4] = -16777216;
				}
				else
				{
					if (int_5 > class224.field2554.length)
					{
						int_5 = class224.field2554.length;
					}

					int_6 = class224.field2554[int_5 - 1];
					spritepixels_0.pixels[int_4] = 0xFF000000 | int_6;
				}
			}
		}

		System.nanoTime();
	}

	void method4790(final SpritePixels spritepixels_0, final SpritePixels spritepixels_1, final Bounds bounds_0)
	{
		if ((bounds_0.field3747 != 0) && (bounds_0.field3745 != 0))
		{
			int int_1 = 0;
			int int_2 = 0;
			if (bounds_0.field3746 == 0)
			{
				int_1 = spritepixels_0.width - bounds_0.field3747;
			}

			if (bounds_0.field3743 == 0)
			{
				int_2 = spritepixels_0.height - bounds_0.field3745;
			}

			int int_3 = int_1 + (int_2 * spritepixels_0.width);
			int int_4 = bounds_0.field3746 + (spritepixels_1.width * bounds_0.field3743);

			for (int int_5 = 0; int_5 < bounds_0.field3745; int_5++)
			{
				for (int int_6 = 0; int_6 < bounds_0.field3747; int_6++)
				{
					final int int_0 = int_4++;
					spritepixels_1.pixels[int_0] += spritepixels_0.pixels[int_3++];
				}

				int_3 += spritepixels_0.width - bounds_0.field3747;
				int_4 += spritepixels_1.width - bounds_0.field3747;
			}

		}
	}

	public static String method4794(final CharSequence[] charsequences_0, final int int_0, final int int_1)
	{
		if (int_1 == 0)
		{
			return "";
		}
		else if (int_1 == 1)
		{
			final CharSequence charsequence_0 = charsequences_0[int_0];
			return charsequence_0 == null ? "null" : charsequence_0.toString();
		}
		else
		{
			final int int_2 = int_1 + int_0;
			int int_3 = 0;

			for (int int_4 = int_0; int_4 < int_2; int_4++)
			{
				final CharSequence charsequence_1 = charsequences_0[int_4];
				if (charsequence_1 == null)
				{
					int_3 += 4;
				}
				else
				{
					int_3 += charsequence_1.length();
				}
			}

			final StringBuilder stringbuilder_0 = new StringBuilder(int_3);

			for (int int_5 = int_0; int_5 < int_2; int_5++)
			{
				final CharSequence charsequence_2 = charsequences_0[int_5];
				if (charsequence_2 == null)
				{
					stringbuilder_0.append("null");
				}
				else
				{
					stringbuilder_0.append(charsequence_2);
				}
			}

			return stringbuilder_0.toString();
		}
	}

}
