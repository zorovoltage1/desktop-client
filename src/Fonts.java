import java.util.HashMap;

public class Fonts
{

	IndexDataBase field3681;
	IndexDataBase field3679;
	HashMap map;

	public Fonts(final IndexDataBase indexdatabase_0, final IndexDataBase indexdatabase_1)
	{
		field3681 = indexdatabase_0;
		field3679 = indexdatabase_1;
		map = new HashMap();
	}

	public HashMap createMap(final FontName[] fontnames_0)
	{
		final HashMap hashmap_0 = new HashMap();
		final FontName[] fontnames_1 = fontnames_0;

		for (int int_0 = 0; int_0 < fontnames_1.length; int_0++)
		{
			final FontName fontname_0 = fontnames_1[int_0];
			if (map.containsKey(fontname_0))
			{
				hashmap_0.put(fontname_0, map.get(fontname_0));
			}
			else
			{
				final IndexDataBase indexdatabase_0 = field3681;
				final IndexDataBase indexdatabase_1 = field3679;
				final String string_0 = fontname_0.field3666;
				final int int_1 = indexdatabase_0.getFile(string_0);
				final int int_2 = indexdatabase_0.getChild(int_1, "");
				final Font font_0 = MessageNode.method1058(indexdatabase_0, indexdatabase_1, int_1, int_2);
				if (font_0 != null)
				{
					map.put(fontname_0, font_0);
					hashmap_0.put(fontname_0, font_0);
				}
			}
		}

		return hashmap_0;
	}

}
