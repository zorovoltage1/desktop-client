public class Coordinates
{

	static int mapY;
	static int cameraY;
	public int plane;
	public int worldX;
	public int worldY;

	public Coordinates(final Coordinates coordinates_1)
	{
		plane = coordinates_1.plane;
		worldX = coordinates_1.worldX;
		worldY = coordinates_1.worldY;
	}

	public Coordinates(final int int_0, final int int_1, final int int_2)
	{
		plane = int_0;
		worldX = int_1;
		worldY = int_2;
	}

	public Coordinates()
	{
		plane = -1;
	}

	public Coordinates(final int int_0)
	{
		if (int_0 == -1)
		{
			plane = -1;
		}
		else
		{
			plane = (int_0 >> 28) & 0x3;
			worldX = (int_0 >> 14) & 0x3FFF;
			worldY = int_0 & 0x3FFF;
		}

	}

	public void set(final int int_0, final int int_1, final int int_2)
	{
		plane = int_0;
		worldX = int_1;
		worldY = int_2;
	}

	public int bitpack()
	{
		return (plane << 28) | (worldX << 14) | worldY;
	}

	boolean method4439(final Coordinates coordinates_1)
	{
		return plane == coordinates_1.plane && (worldX == coordinates_1.worldX && worldY == coordinates_1.worldY);
	}

	String method4441(final String string_0)
	{
		return plane + string_0 + (worldX >> 6) + string_0 + (worldY >> 6) + string_0 + (worldX & 0x3F) + string_0
		        + (worldY & 0x3F);
	}

	@Override
	public int hashCode()
	{
		return bitpack();
	}

	@Override
	public String toString()
	{
		return method4441(",");
	}

	@Override
	public boolean equals(final Object object_0)
	{
		return this == object_0 || (object_0 instanceof Coordinates && method4439((Coordinates) object_0));
	}

}
