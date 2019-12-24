public class FrameMap extends Node
{

	static IndexedSprite[] titlemuteSprite;
	static int field1709;
	int id;
	int count;
	int[] types;
	int[][] list;

	FrameMap(final int int_0, final byte[] bytes_0)
	{
		id = int_0;
		final Buffer buffer_0 = new Buffer(bytes_0);
		count = buffer_0.readUnsignedByte();
		types = new int[count];
		list = new int[count][];

		int int_1;
		for (int_1 = 0; int_1 < count; int_1++)
		{
			types[int_1] = buffer_0.readUnsignedByte();
		}

		for (int_1 = 0; int_1 < count; int_1++)
		{
			list[int_1] = new int[buffer_0.readUnsignedByte()];
		}

		for (int_1 = 0; int_1 < count; int_1++)
		{
			for (int int_2 = 0; int_2 < list[int_1].length; int_2++)
			{
				list[int_1][int_2] = buffer_0.readUnsignedByte();
			}
		}

	}

}
