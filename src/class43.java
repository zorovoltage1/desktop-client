import javax.imageio.ImageIO;

public class class43
{

	protected static Timer timer;
	static SpritePixels[] headIconsPrayer;

	static
	{
		ImageIO.setUseCache(false);
	}

	static long method716(final int int_0, final int int_1, final int int_2)
	{
		return (int_2 << 16) | (int_0 << 8) | int_1;
	}

	public static void method715()
	{
		Overlay.overlays.reset();
	}

	public static Timer method712()
	{
		try
		{
			return new NanoTimer();
		}
		catch (final Throwable throwable_0)
		{
			return new MilliTimer();
		}
	}

	static void method714(int int_0, int int_1, int width, int height, final boolean bool_0)
	{
		if (width < 1)
		{
			width = 1;
		}

		if (height < 1)
		{
			height = 1;
		}

		int int_4 = height - 334;
		int int_5;

		if (int_4 < 0)
		{
			int_5 = Game.minFov;
		}
		else if (int_4 >= 100)
		{
			int_5 = Game.maxFov;
		}
		else
		{
			int_5 = (((Game.maxFov - Game.minFov) * int_4) / 100) + Game.minFov;
		}

		final int int_6 = (height * int_5 * 512) / (width * 334);
		int int_7;
		int int_8;
		short short_0;
		if (int_6 < Game.field834)
		{
			short_0 = Game.field834;
			int_5 = (short_0 * width * 334) / (height * 512);
			if (int_5 > Game.field833)
			{
				int_5 = Game.field833;
				int_7 = (height * int_5 * 512) / (short_0 * 334);
				int_8 = (width - int_7) / 2;
				if (bool_0)
				{
					Rasterizer2D.noClip();
					Rasterizer2D.Rasterizer2D_fillRectangle(int_0, int_1, int_8, height, -16777216);
					Rasterizer2D.Rasterizer2D_fillRectangle((int_0 + width) - int_8, int_1, int_8, height, -16777216);
				}

				int_0 += int_8;
				width -= int_8 * 2;
			}
		}
		else if (int_6 > Game.field835)
		{
			short_0 = Game.field835;
			int_5 = (short_0 * width * 334) / (height * 512);
			if (int_5 < Game.field832)
			{
				int_5 = Game.field832;
				int_7 = (short_0 * width * 334) / (int_5 * 512);
				int_8 = (height - int_7) / 2;
				if (bool_0)
				{
					Rasterizer2D.noClip();
					Rasterizer2D.Rasterizer2D_fillRectangle(int_0, int_1, width, int_8, -16777216);
					Rasterizer2D.Rasterizer2D_fillRectangle(int_0, (height + int_1) - int_8, width, int_8, -16777216);
				}

				int_1 += int_8;
				height -= int_8 * 2;
			}
		}

		Game.scale = height * int_5 / 334;
		if ((width != Game.viewportWidth) || (height != Game.viewportHeight))
		{
			final int[] ints_0 = new int[9];

			for (int int_9 = 0; int_9 < 9; int_9++)
			{
				final int int_10 = (int_9 * 32) + 15 + 128; // var4
				final int int_11 = (int_10 * 3) + 600; // var5
				final int int_12 = Graphics3D.SINE[int_10]; // var7
				int int_13 = height - 334; // var9
				if (int_13 < 0)
				{
					int_13 = 0;
				}
				else if (int_13 > 100)
				{
					int_13 = 100;
				}

				int int_14 = (Game.maxZoom - Game.minZoom) * int_13 / 100 + Game.minZoom;
				int int_15 = int_14 * int_11 / 256;

				ints_0[int_9] = int_12 * int_15 >> 16;
			}

			Region.buildVisibilityMaps(ints_0, 500, 800, width * 334 / height, 334);
		}

		Game.Viewport_xOffset = int_0;
		Game.Viewport_yOffset = int_1;
		Game.viewportWidth = width;
		Game.viewportHeight = height;
	}

	static boolean method713(final int int_0)
	{
		if (int_0 < 0)
		{
			return false;
		}
		else
		{
			int int_1 = Game.menuTypes[int_0];
			if (int_1 >= 2000)
			{
				int_1 -= 2000;
			}

			return int_1 == 1007;
		}
	}

}
