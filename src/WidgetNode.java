public class WidgetNode extends Node
{

	static int field495;
	static int scriptStringStackSize;
	int id;
	int owner;
	boolean field496;

	WidgetNode()
	{
		field496 = false;
	}

	static void drawDot(final int int_0, final int int_1, final int int_2, final int int_3,
	        final SpritePixels spritepixels_0, final class224 class224_0)
	{
		if (spritepixels_0 != null)
		{
			final int int_4 = Game.mapAngle & 0x7FF;
			final int int_5 = (int_3 * int_3) + (int_2 * int_2);
			if (int_5 <= 6400)
			{
				final int int_6 = Graphics3D.SINE[int_4];
				final int int_7 = Graphics3D.COSINE[int_4];
				final int int_8 = ((int_3 * int_6) + (int_7 * int_2)) >> 16;
				final int int_9 = ((int_3 * int_7) - (int_6 * int_2)) >> 16;
				if (int_5 > 2500)
				{
					spritepixels_0.method5867((int_8 + (class224_0.field2553 / 2)) - (spritepixels_0.maxWidth / 2),
					        (class224_0.field2549 / 2) - int_9 - (spritepixels_0.maxHeight / 2), int_0, int_1,
					        class224_0.field2553, class224_0.field2549, class224_0.field2551, class224_0.field2550);
				}
				else
				{
					spritepixels_0.drawAt((int_0 + int_8 + (class224_0.field2553 / 2)) - (spritepixels_0.maxWidth / 2),
					        ((class224_0.field2549 / 2) + int_1) - int_9 - (spritepixels_0.maxHeight / 2));
				}

			}
		}
	}

}
