public class class81
{

	static byte[] field1156;
	static byte[] field1153;
	static Buffer[] field1157;
	static int playerIndexesCount;
	static int[] playerIndices;
	static int field1160;
	static int[] field1161;
	static int[] Players_regions;
	static int[] Players_orientations;
	static int[] Players_targetIndices;
	static int field1165;
	static int[] field1166;
	static Buffer field1154;
	static int[] field1169;

	static
	{
		field1156 = new byte[2048];
		field1153 = new byte[2048];
		field1157 = new Buffer[2048];
		playerIndexesCount = 0;
		playerIndices = new int[2048];
		field1160 = 0;
		field1161 = new int[2048];
		Players_regions = new int[2048];
		Players_orientations = new int[2048];
		Players_targetIndices = new int[2048];
		field1165 = 0;
		field1166 = new int[2048];
		field1154 = new Buffer(new byte[5000]);
	}

	static int method1884()
	{
		return class120.Viewport_mouseX;
	}

	static boolean method1885(final Widget widget_0)
	{
		return widget_0.isHidden;
	}

}
