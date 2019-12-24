public final class class49
{

	static UrlRequest listFetcher;

	public static FloorUnderlayDefinition getUnderlayDefinition(final int int_0)
	{
		FloorUnderlayDefinition floorunderlaydefinition_0 = (FloorUnderlayDefinition) FloorUnderlayDefinition.underlays
		        .get(int_0);
		if (floorunderlaydefinition_0 != null)
		{
			return floorunderlaydefinition_0;
		}
		else
		{
			final byte[] bytes_0 = FloorUnderlayDefinition.underlay_ref.getConfigData(1, int_0);
			floorunderlaydefinition_0 = new FloorUnderlayDefinition();
			if (bytes_0 != null)
			{
				floorunderlaydefinition_0.decode(new Buffer(bytes_0), int_0);
			}

			floorunderlaydefinition_0.post();
			FloorUnderlayDefinition.underlays.put(floorunderlaydefinition_0, int_0);
			return floorunderlaydefinition_0;
		}
	}

	static void method952()
	{
		class50.tileUnderlayIds = null;
		class165.tileOverlayIds = null;
		class50.tileOverlayPath = null;
		WorldMapDecoration.overlayRotations = null;
		class37.field325 = null;
		class50.field447 = null;
		class50.field448 = null;
		class50.floorHues = null;
		class305.floorSaturations = null;
		NPC.field1035 = null;
		Varbit.floorMultiplier = null;
		BuildType.field3137 = null;
	}

	static IndexedSprite[] method950()
	{
		final IndexedSprite[] indexedsprites_0 = new IndexedSprite[class319.indexedSpriteCount];

		for (int int_0 = 0; int_0 < class319.indexedSpriteCount; int_0++)
		{
			final IndexedSprite indexedsprite_0 = indexedsprites_0[int_0] = new IndexedSprite();
			indexedsprite_0.originalWidth = class305.indexedSpriteWidth;
			indexedsprite_0.originalHeight = class319.indexedSpriteHeight;
			indexedsprite_0.offsetX = class7.indexedSpriteOffsetXs[int_0];
			indexedsprite_0.offsetY = class225.indexedSpriteOffsetYs[int_0];
			indexedsprite_0.width = class319.indexSpriteWidths[int_0];
			indexedsprite_0.height = class319.indexedSpriteHeights[int_0];
			indexedsprite_0.palette = PacketNode.indexedSpritePalette;
			indexedsprite_0.pixels = class319.spritePixels[int_0];
		}

		class7.indexedSpriteOffsetXs = null;
		class225.indexedSpriteOffsetYs = null;
		class319.indexSpriteWidths = null;
		class319.indexedSpriteHeights = null;
		PacketNode.indexedSpritePalette = null;
		class319.spritePixels = null;
		return indexedsprites_0;
	}

	static void method951(final int int_0, final int int_1, final int int_2, final int int_3, final int int_4,
	        final int int_5)
	{
		final int int_6 = (2048 - int_3) & 0x7FF;
		final int int_7 = (2048 - int_4) & 0x7FF;
		int int_8 = 0;
		int int_9 = 0;
		int int_10 = int_5;
		int int_11;
		int int_12;
		int int_13;
		if (int_6 != 0)
		{
			int_11 = Graphics3D.SINE[int_6];
			int_12 = Graphics3D.COSINE[int_6];
			int_13 = ((int_12 * int_9) - (int_5 * int_11)) >> 16;
			int_10 = ((int_12 * int_5) + (int_9 * int_11)) >> 16;
			int_9 = int_13;
		}

		if (int_7 != 0)
		{
			int_11 = Graphics3D.SINE[int_7];
			int_12 = Graphics3D.COSINE[int_7];
			int_13 = ((int_8 * int_12) + (int_11 * int_10)) >> 16;
			int_10 = ((int_10 * int_12) - (int_8 * int_11)) >> 16;
			int_8 = int_13;
		}

		CacheFile.cameraX = int_0 - int_8;
		SceneTilePaint.cameraZ = int_1 - int_9;
		Coordinates.cameraY = int_2 - int_10;
		class7.cameraPitch = int_3;
		DynamicObject.cameraYaw = int_4;
		if ((Game.field655 == 1) && (Game.rights >= 2) && ((Game.gameCycle % 50) == 0)
		        && (((CacheFile.field1428 >> 7) != (class138.localPlayer.x >> 7))
		                || ((GrandExchangeEvent.field23 >> 7) != (class138.localPlayer.y >> 7))))
		{
			int_11 = class138.localPlayer.field567;
			int_12 = (CacheFile.field1428 >> 7) + PendingSpawn.baseX;
			int_13 = (GrandExchangeEvent.field23 >> 7) + Game.baseY;
			WorldMapDecoration.method197(int_12, int_13, int_11, true);
		}

	}

}
