public class WorldMapType1 implements WorldMapSectionBase
{

	static String userHome;
	protected static boolean field146;
	int field137;
	int field148;
	int field138;
	int field139;
	int field140;
	int field141;
	int field142;
	int field136;
	int field144;
	int field145;

	@Override
	public void vmethod635(final WorldMapData worldmapdata_0)
	{
		if (worldmapdata_0.minX > field142)
		{
			worldmapdata_0.minX = field142;
		}

		if (worldmapdata_0.field167 < field144)
		{
			worldmapdata_0.field167 = field144;
		}

		if (worldmapdata_0.minY > field136)
		{
			worldmapdata_0.minY = field136;
		}

		if (worldmapdata_0.field162 < field145)
		{
			worldmapdata_0.field162 = field145;
		}

	}

	@Override
	public boolean containsCoord(final int int_0, final int int_1, final int int_2)
	{
		return ((int_0 >= field137) && (int_0 < (field137 + field148))) && (((int_1 >> 6) >= field138)
                && ((int_1 >> 6) <= field140) && ((int_2 >> 6) >= field139) && ((int_2 >> 6) <= field141));
	}

	@Override
	public boolean vmethod637(final int int_0, final int int_1)
	{
		return ((int_0 >> 6) >= field142) && ((int_0 >> 6) <= field144) && ((int_1 >> 6) >= field136)
		        && ((int_1 >> 6) <= field145);
	}

	@Override
	public int[] vmethod638(final int int_0, final int int_1, final int int_2)
	{
		if (!containsCoord(int_0, int_1, int_2))
		{
			return null;
		}
		else
		{
			final int[] ints_0 = new int[] { ((field142 * 64) - (field138 * 64)) + int_1,
			        int_2 + ((field136 * 64) - (field139 * 64)) };
			return ints_0;
		}
	}

	@Override
	public Coordinates vmethod659(final int int_0, final int int_1)
	{
		if (!vmethod637(int_0, int_1))
		{
			return null;
		}
		else
		{
			final int int_2 = ((field138 * 64) - (field142 * 64)) + int_0;
			final int int_3 = ((field139 * 64) - (field136 * 64)) + int_1;
			return new Coordinates(field137, int_2, int_3);
		}
	}

	@Override
	public void vmethod639(final Buffer buffer_0)
	{
		field137 = buffer_0.readUnsignedByte();
		field148 = buffer_0.readUnsignedByte();
		field138 = buffer_0.readUnsignedShort();
		field139 = buffer_0.readUnsignedShort();
		field140 = buffer_0.readUnsignedShort();
		field141 = buffer_0.readUnsignedShort();
		field142 = buffer_0.readUnsignedShort();
		field136 = buffer_0.readUnsignedShort();
		field144 = buffer_0.readUnsignedShort();
		field145 = buffer_0.readUnsignedShort();
		method179();
	}

	void method179()
	{
	}

	static RenderOverview method196()
	{
		return ItemContainer.renderOverview;
	}

	static String method176(final int int_0)
	{
		return int_0 < 0 ? ""
		        : (Game.menuTargets[int_0].length() > 0 ? Game.menuOptions[int_0] + " " + Game.menuTargets[int_0]
		                : Game.menuOptions[int_0]);
	}

}
