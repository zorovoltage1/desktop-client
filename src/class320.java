public class class320
{

	String field3807;
	IndexDataBase field3805;
	int field3803;
	boolean field3810;

	class320(final IndexDataBase indexdatabase_0)
	{
		field3803 = 0;
		field3810 = false;
		field3805 = indexdatabase_0;
	}

	void method5995(final String string_0)
	{
		if ((string_0 != null) && !string_0.isEmpty())
		{
			if (string_0 != field3807)
			{
				field3807 = string_0;
				field3803 = 0;
				field3810 = false;
				method5985();
			}
		}
	}

	int method5985()
	{
		if (field3803 < 25)
		{
			if (!field3805.tryLoadRecordByNames(MapCacheArchiveNames.COMPOSITE_MAP.name, field3807))
			{
				return field3803;
			}

			field3803 = 25;
		}

		if (field3803 == 25)
		{
			if (!field3805.tryLoadRecordByNames(field3807, MapCacheArchiveNames.AREA.name))
			{
				return 25 + ((field3805.archiveLoadPercentByName(field3807) * 25) / 100);
			}

			field3803 = 50;
		}

		if (field3803 == 50)
		{
			if (field3805.method4644(MapCacheArchiveNames.COMPOSITE_TEXTURE.name, field3807)
			        && !field3805.tryLoadRecordByNames(MapCacheArchiveNames.COMPOSITE_TEXTURE.name, field3807))
			{
				return 50;
			}

			field3803 = 75;
		}

		if (field3803 == 75)
		{
			if (!field3805.tryLoadRecordByNames(field3807, MapCacheArchiveNames.LABELS.name))
			{
				return 75;
			}

			field3803 = 100;
			field3810 = true;
		}

		return field3803;
	}

	boolean method5987()
	{
		return field3810;
	}

	int method5988()
	{
		return field3803;
	}

}
