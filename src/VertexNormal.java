import java.lang.management.GarbageCollectorMXBean;

public class VertexNormal
{

	static GarbageCollectorMXBean field1660;
	int magnitude;
	int x;
	int y;
	int z;

	VertexNormal()
	{
	}

	VertexNormal(final VertexNormal vertexnormal_1)
	{
		x = vertexnormal_1.x;
		y = vertexnormal_1.y;
		z = vertexnormal_1.z;
		magnitude = vertexnormal_1.magnitude;
	}

	static void method2782(final int int_0)
	{
		final ItemContainer itemcontainer_0 = (ItemContainer) ItemContainer.itemContainers.get(int_0);
		if (itemcontainer_0 != null)
		{
			for (int int_1 = 0; int_1 < itemcontainer_0.itemIds.length; int_1++)
			{
				itemcontainer_0.itemIds[int_1] = -1;
				itemcontainer_0.stackSizes[int_1] = 0;
			}

		}
	}

	static void worldToMinimap(final int int_0, final int int_1, final int int_2, final int int_3,
	        final SpritePixels spritepixels_0, final class224 class224_0)
	{
		final int int_4 = (int_3 * int_3) + (int_2 * int_2);
		if ((int_4 > 4225) && (int_4 < 90000))
		{
			final int int_5 = Game.mapAngle & 0x7FF;
			final int int_6 = Graphics3D.SINE[int_5];
			final int int_7 = Graphics3D.COSINE[int_5];
			final int int_8 = ((int_7 * int_2) + (int_3 * int_6)) >> 16;
			final int int_9 = ((int_3 * int_7) - (int_6 * int_2)) >> 16;
			final double double_0 = Math.atan2(int_8, int_9);
			final int int_10 = (class224_0.field2553 / 2) - 25;
			final int int_11 = (int) (Math.sin(double_0) * int_10);
			final int int_12 = (int) (Math.cos(double_0) * int_10);
			final byte byte_0 = 20;
			UrlRequest.mapedge.method5865(int_11 + ((int_0 + (class224_0.field2553 / 2)) - (byte_0 / 2)),
			        ((class224_0.field2549 / 2) + int_1) - (byte_0 / 2) - int_12 - 10, byte_0, byte_0, 15, 15, double_0,
			        256);
		}
		else
		{
			WidgetNode.drawDot(int_0, int_1, int_2, int_3, spritepixels_0, class224_0);
		}

	}

}
