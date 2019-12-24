public class class267 extends CacheableNode
{

	static IndexDataBase field3367;
	static IndexDataBase field3348;
	public static NodeCache field3349;
	public static NodeCache field3356;
	public static NodeCache field3351;
	int field3353;
	public int field3364;
	public int field3355;
	int field3358;
	int field3357;
	int field3350;
	int field3359;
	public int field3365;
	public int field3361;
	public int field3354;
	String field3363;
	public int field3360;
	public int field3347;
	public int[] field3366;
	int field3362;
	int field3368;

	static
	{
		field3349 = new NodeCache(64);
		field3356 = new NodeCache(64);
		field3351 = new NodeCache(20);
	}

	class267()
	{
		field3353 = -1;
		field3364 = 16777215;
		field3355 = 70;
		field3358 = -1;
		field3357 = -1;
		field3350 = -1;
		field3359 = -1;
		field3365 = 0;
		field3361 = 0;
		field3354 = -1;
		field3363 = "";
		field3360 = -1;
		field3347 = 0;
		field3362 = -1;
		field3368 = -1;
	}

	void method4990(final Buffer buffer_0)
	{
		while (true)
		{
			final int int_0 = buffer_0.readUnsignedByte();
			if (int_0 == 0)
			{
				return;
			}

			method4991(buffer_0, int_0);
		}
	}

	void method4991(final Buffer buffer_0, final int int_0)
	{
		if (int_0 == 1)
		{
			field3353 = buffer_0.method3546();
		}
		else if (int_0 == 2)
		{
			field3364 = buffer_0.read24BitInt();
		}
		else if (int_0 == 3)
		{
			field3358 = buffer_0.method3546();
		}
		else if (int_0 == 4)
		{
			field3350 = buffer_0.method3546();
		}
		else if (int_0 == 5)
		{
			field3357 = buffer_0.method3546();
		}
		else if (int_0 == 6)
		{
			field3359 = buffer_0.method3546();
		}
		else if (int_0 == 7)
		{
			field3365 = buffer_0.readShort();
		}
		else if (int_0 == 8)
		{
			field3363 = buffer_0.getJagString();
		}
		else if (int_0 == 9)
		{
			field3355 = buffer_0.readUnsignedShort();
		}
		else if (int_0 == 10)
		{
			field3361 = buffer_0.readShort();
		}
		else if (int_0 == 11)
		{
			field3354 = 0;
		}
		else if (int_0 == 12)
		{
			field3360 = buffer_0.readUnsignedByte();
		}
		else if (int_0 == 13)
		{
			field3347 = buffer_0.readShort();
		}
		else if (int_0 == 14)
		{
			field3354 = buffer_0.readUnsignedShort();
		}
		else if ((int_0 == 17) || (int_0 == 18))
		{
			field3362 = buffer_0.readUnsignedShort();
			if (field3362 == 65535)
			{
				field3362 = -1;
			}

			field3368 = buffer_0.readUnsignedShort();
			if (field3368 == 65535)
			{
				field3368 = -1;
			}

			int int_1 = -1;
			if (int_0 == 18)
			{
				int_1 = buffer_0.readUnsignedShort();
				if (int_1 == 65535)
				{
					int_1 = -1;
				}
			}

			final int int_2 = buffer_0.readUnsignedByte();
			field3366 = new int[int_2 + 2];

			for (int int_3 = 0; int_3 <= int_2; int_3++)
			{
				field3366[int_3] = buffer_0.readUnsignedShort();
				if (field3366[int_3] == 65535)
				{
					field3366[int_3] = -1;
				}
			}

			field3366[int_2 + 1] = int_1;
		}

	}

	public class267 method4995()
	{
		int int_0 = -1;
		if (field3362 != -1)
		{
			int_0 = GameSocket.getVarbit(field3362);
		}
		else if (field3368 != -1)
		{
			int_0 = class225.clientVarps[field3368];
		}

		int int_1;
		if ((int_0 >= 0) && (int_0 < (field3366.length - 1)))
		{
			int_1 = field3366[int_0];
		}
		else
		{
			int_1 = field3366[field3366.length - 1];
		}

		return int_1 != -1 ? WorldMapType3.method123(int_1) : null;
	}

	public String method5014(final int int_0)
	{
		String string_0 = field3363;

		while (true)
		{
			final int int_1 = string_0.indexOf("%1");
			if (int_1 < 0)
			{
				return string_0;
			}

			final String string_1 = string_0.substring(0, int_1);
			final String string_2 = Integer.toString(int_0);
			string_0 = string_1 + string_2 + string_0.substring(int_1 + 2);
		}
	}

	public SpritePixels method4994()
	{
		if (field3358 < 0)
		{
			return null;
		}
		else
		{
			SpritePixels spritepixels_0 = (SpritePixels) field3356.get(field3358);
			if (spritepixels_0 != null)
			{
				return spritepixels_0;
			}
			else
			{
				spritepixels_0 = class229.method4499(field3348, field3358, 0);
				if (spritepixels_0 != null)
				{
					field3356.put(spritepixels_0, field3358);
				}

				return spritepixels_0;
			}
		}
	}

	public SpritePixels method5000()
	{
		if (field3357 < 0)
		{
			return null;
		}
		else
		{
			SpritePixels spritepixels_0 = (SpritePixels) field3356.get(field3357);
			if (spritepixels_0 != null)
			{
				return spritepixels_0;
			}
			else
			{
				spritepixels_0 = class229.method4499(field3348, field3357, 0);
				if (spritepixels_0 != null)
				{
					field3356.put(spritepixels_0, field3357);
				}

				return spritepixels_0;
			}
		}
	}

	public SpritePixels method4996()
	{
		if (field3350 < 0)
		{
			return null;
		}
		else
		{
			SpritePixels spritepixels_0 = (SpritePixels) field3356.get(field3350);
			if (spritepixels_0 != null)
			{
				return spritepixels_0;
			}
			else
			{
				spritepixels_0 = class229.method4499(field3348, field3350, 0);
				if (spritepixels_0 != null)
				{
					field3356.put(spritepixels_0, field3350);
				}

				return spritepixels_0;
			}
		}
	}

	public SpritePixels method4997()
	{
		if (field3359 < 0)
		{
			return null;
		}
		else
		{
			SpritePixels spritepixels_0 = (SpritePixels) field3356.get(field3359);
			if (spritepixels_0 != null)
			{
				return spritepixels_0;
			}
			else
			{
				spritepixels_0 = class229.method4499(field3348, field3359, 0);
				if (spritepixels_0 != null)
				{
					field3356.put(spritepixels_0, field3359);
				}

				return spritepixels_0;
			}
		}
	}

	public Font method4998()
	{
		if (field3353 == -1)
		{
			return null;
		}
		else
		{
			Font font_0 = (Font) field3351.get(field3353);
			if (font_0 != null)
			{
				return font_0;
			}
			else
			{
				font_0 = MessageNode.method1058(field3348, class139.field1877, field3353, 0);
				if (font_0 != null)
				{
					field3351.put(font_0, field3353);
				}

				return font_0;
			}
		}
	}

}
