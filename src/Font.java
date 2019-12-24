public final class Font extends FontTypeFace
{

	public Font(final byte[] bytes_0, final int[] ints_0, final int[] ints_1, final int[] ints_2, final int[] ints_3,
	        final int[] ints_4, final byte[][] bytes_1)
	{
		super(bytes_0, ints_0, ints_1, ints_2, ints_3, ints_4, bytes_1);
	}

	public Font(final byte[] bytes_0)
	{
		super(bytes_0);
	}

	@Override
	void renderRGB(final byte[] bytes_0, int int_0, int int_1, int int_2, int int_3, final int int_4)
	{
		int int_5 = (int_1 * Rasterizer2D.graphicsPixelsWidth) + int_0;
		int int_6 = Rasterizer2D.graphicsPixelsWidth - int_2;
		int int_7 = 0;
		int int_8 = 0;
		int int_9;
		if (int_1 < Rasterizer2D.topY)
		{
			int_9 = Rasterizer2D.topY - int_1;
			int_3 -= int_9;
			int_1 = Rasterizer2D.topY;
			int_8 += int_9 * int_2;
			int_5 += int_9 * Rasterizer2D.graphicsPixelsWidth;
		}

		if ((int_1 + int_3) > Rasterizer2D.bottomY)
		{
			int_3 -= (int_1 + int_3) - Rasterizer2D.bottomY;
		}

		if (int_0 < Rasterizer2D.topX)
		{
			int_9 = Rasterizer2D.topX - int_0;
			int_2 -= int_9;
			int_0 = Rasterizer2D.topX;
			int_8 += int_9;
			int_5 += int_9;
			int_7 += int_9;
			int_6 += int_9;
		}

		if ((int_0 + int_2) > Rasterizer2D.bottomX)
		{
			int_9 = (int_0 + int_2) - Rasterizer2D.bottomX;
			int_2 -= int_9;
			int_7 += int_9;
			int_6 += int_9;
		}

		if ((int_2 > 0) && (int_3 > 0))
		{
			FontTypeFace.render(Rasterizer2D.graphicsPixels, bytes_0, int_4, int_8, int_5, int_2, int_3, int_6, int_7);
		}
	}

	@Override
	void renderRGBA(final byte[] bytes_0, int int_0, int int_1, int int_2, int int_3, final int int_4, final int int_5)
	{
		int int_6 = (int_1 * Rasterizer2D.graphicsPixelsWidth) + int_0;
		int int_7 = Rasterizer2D.graphicsPixelsWidth - int_2;
		int int_8 = 0;
		int int_9 = 0;
		int int_10;
		if (int_1 < Rasterizer2D.topY)
		{
			int_10 = Rasterizer2D.topY - int_1;
			int_3 -= int_10;
			int_1 = Rasterizer2D.topY;
			int_9 += int_10 * int_2;
			int_6 += int_10 * Rasterizer2D.graphicsPixelsWidth;
		}

		if ((int_1 + int_3) > Rasterizer2D.bottomY)
		{
			int_3 -= (int_1 + int_3) - Rasterizer2D.bottomY;
		}

		if (int_0 < Rasterizer2D.topX)
		{
			int_10 = Rasterizer2D.topX - int_0;
			int_2 -= int_10;
			int_0 = Rasterizer2D.topX;
			int_9 += int_10;
			int_6 += int_10;
			int_8 += int_10;
			int_7 += int_10;
		}

		if ((int_0 + int_2) > Rasterizer2D.bottomX)
		{
			int_10 = (int_0 + int_2) - Rasterizer2D.bottomX;
			int_2 -= int_10;
			int_8 += int_10;
			int_7 += int_10;
		}

		if ((int_2 > 0) && (int_3 > 0))
		{
			FontTypeFace.renderRGBA(Rasterizer2D.graphicsPixels, bytes_0, int_4, int_9, int_6, int_2, int_3, int_7,
			        int_8, int_5);
		}
	}

}
