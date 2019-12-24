public class Area extends CacheableNode
{

	public static IndexDataBase field3237;
	public static Area[] mapAreaType;
	public static int field3236;
	static NodeCache areaSpriteCache;
	public final int id;
	public int spriteId;
	int field3234;
	public String name;
	public int field3242;
	public int field3243;
	public String[] field3244;
	public String field3255;
	int[] field3245;
	int field3247;
	int field3235;
	int field3249;
	int field3248;
	public HorizontalAlignment horizontalAlignment;
	public VerticalAlignment verticalAlignment;
	int[] field3250;
	byte[] field3254;
	public int field3240;

	static
	{
		areaSpriteCache = new NodeCache(256);
	}

	public Area(final int int_0)
	{
		spriteId = -1;
		field3234 = -1;
		field3243 = 0;
		field3244 = new String[5];
		field3247 = Integer.MAX_VALUE;
		field3235 = Integer.MAX_VALUE;
		field3249 = Integer.MIN_VALUE;
		field3248 = Integer.MIN_VALUE;
		horizontalAlignment = HorizontalAlignment.field3479;
		verticalAlignment = VerticalAlignment.field3222;
		field3240 = -1;
		id = int_0;
	}

	public void method4816(final Buffer buffer_0)
	{
		while (true)
		{
			final int int_0 = buffer_0.readUnsignedByte();
			if (int_0 == 0)
			{
				return;
			}

			method4817(buffer_0, int_0);
		}
	}

	void method4817(final Buffer buffer_0, final int int_0)
	{
		if (int_0 == 1)
		{
			spriteId = buffer_0.method3546();
		}
		else if (int_0 == 2)
		{
			field3234 = buffer_0.method3546();
		}
		else if (int_0 == 3)
		{
			name = buffer_0.readString();
		}
		else if (int_0 == 4)
		{
			field3242 = buffer_0.read24BitInt();
		}
		else if (int_0 == 5)
		{
			buffer_0.read24BitInt();
		}
		else if (int_0 == 6)
		{
			field3243 = buffer_0.readUnsignedByte();
		}
		else
		{
			int int_1;
			if (int_0 == 7)
			{
				int_1 = buffer_0.readUnsignedByte();
				if ((int_1 & 0x1) == 0)
				{
                }

				if ((int_1 & 0x2) == 2)
				{
                }
			}
			else if (int_0 == 8)
			{
				buffer_0.readUnsignedByte();
			}
			else if ((int_0 >= 10) && (int_0 <= 14))
			{
				field3244[int_0 - 10] = buffer_0.readString();
			}
			else if (int_0 == 15)
			{
				int_1 = buffer_0.readUnsignedByte();
				field3245 = new int[int_1 * 2];

				int int_2;
				for (int_2 = 0; int_2 < (int_1 * 2); int_2++)
				{
					field3245[int_2] = buffer_0.readShort();
				}

				buffer_0.readInt();
				int_2 = buffer_0.readUnsignedByte();
				field3250 = new int[int_2];

				int int_3;
				for (int_3 = 0; int_3 < field3250.length; int_3++)
				{
					field3250[int_3] = buffer_0.readInt();
				}

				field3254 = new byte[int_1];

				for (int_3 = 0; int_3 < int_1; int_3++)
				{
					field3254[int_3] = buffer_0.readByte();
				}
			}
			else if (int_0 != 16)
			{
				if (int_0 == 17)
				{
					field3255 = buffer_0.readString();
				}
				else if (int_0 == 18)
				{
					buffer_0.method3546();
				}
				else if (int_0 == 19)
				{
					field3240 = buffer_0.readUnsignedShort();
				}
				else if (int_0 == 21)
				{
					buffer_0.readInt();
				}
				else if (int_0 == 22)
				{
					buffer_0.readInt();
				}
				else if (int_0 == 23)
				{
					buffer_0.readUnsignedByte();
					buffer_0.readUnsignedByte();
					buffer_0.readUnsignedByte();
				}
				else if (int_0 == 24)
				{
					buffer_0.readShort();
					buffer_0.readShort();
				}
				else if (int_0 == 25)
				{
					buffer_0.method3546();
				}
				else if (int_0 == 28)
				{
					buffer_0.readUnsignedByte();
				}
				else if (int_0 == 29)
				{
					final HorizontalAlignment[] horizontalalignments_0 = new HorizontalAlignment[] {
					        HorizontalAlignment.field3479, HorizontalAlignment.field3484,
					        HorizontalAlignment.field3481 };
					horizontalAlignment = (HorizontalAlignment) class76.forOrdinal(horizontalalignments_0,
					        buffer_0.readUnsignedByte());
				}
				else if (int_0 == 30)
				{
					final VerticalAlignment[] verticalalignments_0 = new VerticalAlignment[] {
					        VerticalAlignment.field3221, VerticalAlignment.field3222, VerticalAlignment.field3224 };
					verticalAlignment = (VerticalAlignment) class76.forOrdinal(verticalalignments_0,
					        buffer_0.readUnsignedByte());
				}
			}
		}

	}

	public void method4828()
	{
		if (field3245 != null)
		{
			for (int int_0 = 0; int_0 < field3245.length; int_0 += 2)
			{
				if (field3245[int_0] < field3247)
				{
					field3247 = field3245[int_0];
				}
				else if (field3245[int_0] > field3249)
				{
					field3249 = field3245[int_0];
				}

				if (field3245[int_0 + 1] < field3235)
				{
					field3235 = field3245[int_0 + 1];
				}
				else if (field3245[int_0 + 1] > field3248)
				{
					field3248 = field3245[int_0 + 1];
				}
			}
		}

	}

	public SpritePixels getMapIcon(final boolean bool_0)
	{
		final int int_0 = spriteId;
		return method4820(int_0);
	}

	SpritePixels method4820(final int int_0)
	{
		if (int_0 < 0)
		{
			return null;
		}
		else
		{
			SpritePixels spritepixels_0 = (SpritePixels) areaSpriteCache.get(int_0);
			if (spritepixels_0 != null)
			{
				return spritepixels_0;
			}
			else
			{
				spritepixels_0 = class229.method4499(field3237, int_0, 0);
				if (spritepixels_0 != null)
				{
					areaSpriteCache.put(spritepixels_0, int_0);
				}

				return spritepixels_0;
			}
		}
	}

	public int method4821()
	{
		return id;
	}

}
