import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class WorldMapManager
{

	boolean loaded;
	boolean loading;
	class33 field265;
	SpritePixels field266;
	HashMap field267;
	WorldMapRegion[][] mapRegions;
	HashMap field269;
	IndexedSprite[] field279;
	final HashMap mapFonts;
	int mapSurfaceBaseOffsetX;
	int mapSurfaceBaseOffsetY;
	int field274;
	int field270;
	public int field276;

	public WorldMapManager(final IndexedSprite[] indexedsprites_0, final HashMap hashmap_0)
	{
		loaded = false;
		loading = false;
		field269 = new HashMap();
		field276 = 0;
		field279 = indexedsprites_0;
		mapFonts = hashmap_0;
	}

	public void load(final IndexDataBase indexdatabase_0, final String string_0, final boolean bool_0)
	{
		if (!loading)
		{
			loaded = false;
			loading = true;
			System.nanoTime();
			final int int_0 = indexdatabase_0.getFile(MapCacheArchiveNames.DETAILS.name);
			final int int_1 = indexdatabase_0.getChild(int_0, string_0);
			final Buffer buffer_0 = new Buffer(
			        indexdatabase_0.takeRecordByNames(MapCacheArchiveNames.DETAILS.name, string_0));
			final Buffer buffer_1 = new Buffer(
			        indexdatabase_0.takeRecordByNames(MapCacheArchiveNames.COMPOSITE_MAP.name, string_0));
			final Buffer buffer_2 = new Buffer(
			        indexdatabase_0.takeRecordByNames(string_0, MapCacheArchiveNames.AREA.name));
			System.nanoTime();
			System.nanoTime();
			field265 = new class33();

			try
			{
				field265.method550(buffer_0, buffer_2, buffer_1, int_1, bool_0);
			}
			catch (final IllegalStateException illegalstateexception_0)
			{
				return;
			}

			field265.method217();
			field265.method218();
			field265.method219();
			mapSurfaceBaseOffsetX = field265.getMinX() * 64;
			mapSurfaceBaseOffsetY = field265.getMinY() * 64;
			field274 = ((field265.method214() - field265.getMinX()) + 1) * 64;
			field270 = ((field265.method249() - field265.getMinY()) + 1) * 64;
			final int int_2 = (field265.method214() - field265.getMinX()) + 1;
			final int int_3 = (field265.method249() - field265.getMinY()) + 1;
			System.nanoTime();
			System.nanoTime();
			WorldMapRegion.field188.method4006();
			WorldMapRegion.field189.method4006();
			mapRegions = new WorldMapRegion[int_2][int_3];
			final Iterator iterator_0 = field265.field292.iterator();

			while (iterator_0.hasNext())
			{
				final class10 class10_0 = (class10) iterator_0.next();
				final int int_4 = class10_0.field127;
				final int int_5 = class10_0.field117;
				final int int_6 = int_4 - field265.getMinX();
				final int int_7 = int_5 - field265.getMinY();
				mapRegions[int_6][int_7] = new WorldMapRegion(int_4, int_5, field265.method211(), mapFonts);
				mapRegions[int_6][int_7].method400(class10_0, field265.field290);
			}

			for (int int_8 = 0; int_8 < int_2; int_8++)
			{
				for (int int_9 = 0; int_9 < int_3; int_9++)
				{
					if (mapRegions[int_8][int_9] == null)
					{
						mapRegions[int_8][int_9] = new WorldMapRegion(field265.getMinX() + int_8,
						        field265.getMinY() + int_9, field265.method211(), mapFonts);
						mapRegions[int_8][int_9].method287(field265.field291, field265.field290);
					}
				}
			}

			System.nanoTime();
			System.nanoTime();
			if (indexdatabase_0.method4644(MapCacheArchiveNames.COMPOSITE_TEXTURE.name, string_0))
			{
				final byte[] bytes_0 = indexdatabase_0.takeRecordByNames(MapCacheArchiveNames.COMPOSITE_TEXTURE.name,
				        string_0);
				field266 = class284.method5324(bytes_0);
			}

			System.nanoTime();
			indexdatabase_0.method4702();
			indexdatabase_0.reset();
			loaded = true;
		}
	}

	public void method482()
	{
		field267 = null;
	}

	public void drawMapRegion(final int int_0, final int int_1, final int int_2, final int int_3, final int int_4,
	        final int int_5, final int int_6, final int int_7)
	{
		final int[] ints_0 = Rasterizer2D.graphicsPixels;
		final int int_8 = Rasterizer2D.graphicsPixelsWidth;
		final int int_9 = Rasterizer2D.graphicsPixelsHeight;
		final int[] ints_1 = new int[4];
		Rasterizer2D.copyDrawRegion(ints_1);
		final WorldMapRectangle worldmaprectangle_0 = getRegionRectForViewport(int_0, int_1, int_2, int_3);
		final float float_0 = method492(int_6 - int_4, int_2 - int_0);
		final int int_10 = (int) Math.ceil(float_0);
		field276 = int_10;
		if (!field269.containsKey(Integer.valueOf(int_10)))
		{
			final class35 class35_0 = new class35(int_10);
			class35_0.method592();
			field269.put(Integer.valueOf(int_10), class35_0);
		}

		final WorldMapRegion[] worldmapregions_0 = new WorldMapRegion[8];

		int int_11;
		int int_12;
		for (int_11 = worldmaprectangle_0.worldMapRegionX; int_11 < (worldmaprectangle_0.worldMapRegionX
		        + worldmaprectangle_0.worldMapRegionWidth); int_11++)
		{
			for (int_12 = worldmaprectangle_0.worldMapRegionY; int_12 < (worldmaprectangle_0.worldMapRegionY
			        + worldmaprectangle_0.worldMapRegionHeight); int_12++)
			{
				method485(int_11, int_12, worldmapregions_0);
				mapRegions[int_11][int_12].method290(int_10, (class35) field269.get(Integer.valueOf(int_10)),
				        worldmapregions_0, field279);
			}
		}

		Rasterizer2D.setRasterBuffer(ints_0, int_8, int_9);
		Rasterizer2D.setDrawRegion(ints_1);
		int_11 = (int) (64.0F * float_0);
		int_12 = mapSurfaceBaseOffsetX + int_0;
		final int int_13 = int_1 + mapSurfaceBaseOffsetY;

		for (int int_14 = worldmaprectangle_0.worldMapRegionX; int_14 < (worldmaprectangle_0.worldMapRegionWidth
		        + worldmaprectangle_0.worldMapRegionX); int_14++)
		{
			for (int int_15 = worldmaprectangle_0.worldMapRegionY; int_15 < (worldmaprectangle_0.worldMapRegionHeight
			        + worldmaprectangle_0.worldMapRegionY); int_15++)
			{
				mapRegions[int_14][int_15].method314(
				        int_4 + ((int_11 * ((mapRegions[int_14][int_15].field191 * 64) - int_12)) / 64),
				        int_7 - ((int_11 * (((mapRegions[int_14][int_15].field192 * 64) - int_13) + 64)) / 64), int_11);
			}
		}

	}

	public void drawMapIcons(final int int_0, final int int_1, final int int_2, final int int_3, final int int_4,
	        final int int_5, final int int_6, final int int_7, final HashSet hashset_0, final HashSet hashset_1,
	        final int int_8, final int int_9, final boolean bool_0)
	{
		final WorldMapRectangle worldmaprectangle_0 = getRegionRectForViewport(int_0, int_1, int_2, int_3);
		final float float_0 = method492(int_6 - int_4, int_2 - int_0);
		final int int_10 = (int) (float_0 * 64.0F);
		final int int_11 = mapSurfaceBaseOffsetX + int_0;
		final int int_12 = int_1 + mapSurfaceBaseOffsetY;

		int int_13;
		int int_14;
		for (int_13 = worldmaprectangle_0.worldMapRegionX; int_13 < (worldmaprectangle_0.worldMapRegionX
		        + worldmaprectangle_0.worldMapRegionWidth); int_13++)
		{
			for (int_14 = worldmaprectangle_0.worldMapRegionY; int_14 < (worldmaprectangle_0.worldMapRegionY
			        + worldmaprectangle_0.worldMapRegionHeight); int_14++)
			{
				if (bool_0)
				{
					mapRegions[int_13][int_14].method340();
				}

				mapRegions[int_13][int_14].method382(
				        int_4 + ((int_10 * ((mapRegions[int_13][int_14].field191 * 64) - int_11)) / 64),
				        int_7 - ((int_10 * (((mapRegions[int_13][int_14].field192 * 64) - int_12) + 64)) / 64), int_10,
				        hashset_0);
			}
		}

		if ((hashset_1 != null) && (int_8 > 0))
		{
			for (int_13 = worldmaprectangle_0.worldMapRegionX; int_13 < (worldmaprectangle_0.worldMapRegionX
			        + worldmaprectangle_0.worldMapRegionWidth); int_13++)
			{
				for (int_14 = worldmaprectangle_0.worldMapRegionY; int_14 < (worldmaprectangle_0.worldMapRegionHeight
				        + worldmaprectangle_0.worldMapRegionY); int_14++)
				{
					mapRegions[int_13][int_14].drawFlashingMapIcons(hashset_1, int_8, int_9);
				}
			}
		}

	}

	void method485(final int int_0, final int int_1, final WorldMapRegion[] worldmapregions_0)
	{
		final boolean bool_0 = int_0 <= 0;
		final boolean bool_1 = int_0 >= (mapRegions.length - 1);
		final boolean bool_2 = int_1 <= 0;
		final boolean bool_3 = int_1 >= (mapRegions[0].length - 1);
		if (bool_3)
		{
			worldmapregions_0[class240.field3101.vmethod5815()] = null;
		}
		else
		{
			worldmapregions_0[class240.field3101.vmethod5815()] = mapRegions[int_0][int_1 + 1];
		}

		worldmapregions_0[class240.field3107.vmethod5815()] = !bool_3 && !bool_1 ? mapRegions[int_0 + 1][int_1 + 1]
		        : null;
		worldmapregions_0[class240.field3103.vmethod5815()] = !bool_3 && !bool_0 ? mapRegions[int_0 - 1][int_1 + 1]
		        : null;
		worldmapregions_0[class240.field3097.vmethod5815()] = bool_1 ? null : mapRegions[int_0 + 1][int_1];
		worldmapregions_0[class240.field3102.vmethod5815()] = bool_0 ? null : mapRegions[int_0 - 1][int_1];
		worldmapregions_0[class240.field3100.vmethod5815()] = bool_2 ? null : mapRegions[int_0][int_1 - 1];
		worldmapregions_0[class240.field3099.vmethod5815()] = !bool_2 && !bool_1 ? mapRegions[int_0 + 1][int_1 - 1]
		        : null;
		worldmapregions_0[class240.field3098.vmethod5815()] = !bool_2 && !bool_0 ? mapRegions[int_0 - 1][int_1 - 1]
		        : null;
	}

	public void method486(final int int_0, final int int_1, final int int_2, final int int_3, final HashSet hashset_0,
	        final int int_4, final int int_5)
	{
		if (field266 != null)
		{
			field266.method5853(int_0, int_1, int_2, int_3);
			if ((int_4 > 0) && ((int_4 % int_5) < (int_5 / 2)))
			{
				if (field267 == null)
				{
					method505();
				}

				final Iterator iterator_0 = hashset_0.iterator();

				while (true)
				{
					List list_0;
					do
					{
						if (!iterator_0.hasNext())
						{
							return;
						}

						final int int_6 = ((Integer) iterator_0.next()).intValue();
						list_0 = (List) field267.get(Integer.valueOf(int_6));
					}
					while (list_0 == null);

					final Iterator iterator_1 = list_0.iterator();

					while (iterator_1.hasNext())
					{
						final MapIcon mapicon_0 = (MapIcon) iterator_1.next();
						final int int_7 = (int_2 * (mapicon_0.field236.worldX - mapSurfaceBaseOffsetX)) / field274;
						final int int_8 = int_3
						        - (((mapicon_0.field236.worldY - mapSurfaceBaseOffsetY) * int_3) / field270);
						Rasterizer2D.method5784(int_7 + int_0, int_8 + int_1, 2, 16776960, 256);
					}
				}
			}
		}
	}

	public List method487(final int int_0, final int int_1, final int int_2, final int int_3, final int int_4,
	        final int int_5, final int int_6, final int int_7, final int int_8, final int int_9)
	{
		final LinkedList linkedlist_0 = new LinkedList();
		if (!loaded)
		{
			return linkedlist_0;
		}
		else
		{
			final WorldMapRectangle worldmaprectangle_0 = getRegionRectForViewport(int_0, int_1, int_2, int_3);
			final float float_0 = method492(int_6, int_2 - int_0);
			final int int_10 = (int) (64.0F * float_0);
			final int int_11 = mapSurfaceBaseOffsetX + int_0;
			final int int_12 = int_1 + mapSurfaceBaseOffsetY;

			for (int int_13 = worldmaprectangle_0.worldMapRegionX; int_13 < (worldmaprectangle_0.worldMapRegionX
			        + worldmaprectangle_0.worldMapRegionWidth); int_13++)
			{
				for (int int_14 = worldmaprectangle_0.worldMapRegionY; int_14 < (worldmaprectangle_0.worldMapRegionY
				        + worldmaprectangle_0.worldMapRegionHeight); int_14++)
				{
					final List list_0 = mapRegions[int_13][int_14].method319(
					        int_4 + ((int_10 * ((mapRegions[int_13][int_14].field191 * 64) - int_11)) / 64),
					        (int_7 + int_5)
					                - ((int_10 * (((mapRegions[int_13][int_14].field192 * 64) - int_12) + 64)) / 64),
					        int_10, int_8, int_9);
					if (!list_0.isEmpty())
					{
						linkedlist_0.addAll(list_0);
					}
				}
			}

			return linkedlist_0;
		}
	}

	WorldMapRectangle getRegionRectForViewport(final int int_0, final int int_1, final int int_2, final int int_3)
	{
		final WorldMapRectangle worldmaprectangle_0 = new WorldMapRectangle(this);
		final int int_4 = mapSurfaceBaseOffsetX + int_0;
		final int int_5 = int_1 + mapSurfaceBaseOffsetY;
		final int int_6 = int_2 + mapSurfaceBaseOffsetX;
		final int int_7 = int_3 + mapSurfaceBaseOffsetY;
		final int int_8 = int_4 / 64;
		final int int_9 = int_5 / 64;
		final int int_10 = int_6 / 64;
		final int int_11 = int_7 / 64;
		worldmaprectangle_0.worldMapRegionWidth = (int_10 - int_8) + 1;
		worldmaprectangle_0.worldMapRegionHeight = (int_11 - int_9) + 1;
		worldmaprectangle_0.worldMapRegionX = int_8 - field265.getMinX();
		worldmaprectangle_0.worldMapRegionY = int_9 - field265.getMinY();
		if (worldmaprectangle_0.worldMapRegionX < 0)
		{
			worldmaprectangle_0.worldMapRegionWidth += worldmaprectangle_0.worldMapRegionX;
			worldmaprectangle_0.worldMapRegionX = 0;
		}

		if (worldmaprectangle_0.worldMapRegionX > (mapRegions.length - worldmaprectangle_0.worldMapRegionWidth))
		{
			worldmaprectangle_0.worldMapRegionWidth = mapRegions.length - worldmaprectangle_0.worldMapRegionX;
		}

		if (worldmaprectangle_0.worldMapRegionY < 0)
		{
			worldmaprectangle_0.worldMapRegionHeight += worldmaprectangle_0.worldMapRegionY;
			worldmaprectangle_0.worldMapRegionY = 0;
		}

		if (worldmaprectangle_0.worldMapRegionY > (mapRegions[0].length - worldmaprectangle_0.worldMapRegionHeight))
		{
			worldmaprectangle_0.worldMapRegionHeight = mapRegions[0].length - worldmaprectangle_0.worldMapRegionY;
		}

		worldmaprectangle_0.worldMapRegionWidth = Math.min(worldmaprectangle_0.worldMapRegionWidth, mapRegions.length);
		worldmaprectangle_0.worldMapRegionHeight = Math.min(worldmaprectangle_0.worldMapRegionHeight,
		        mapRegions[0].length);
		return worldmaprectangle_0;
	}

	public boolean getLoaded()
	{
		return loaded;
	}

	public HashMap method489()
	{
		method505();
		return field267;
	}

	void method505()
	{
		if (field267 == null)
		{
			field267 = new HashMap();
		}

		field267.clear();

		for (int int_0 = 0; int_0 < mapRegions.length; int_0++)
		{
			for (int int_1 = 0; int_1 < mapRegions[int_0].length; int_1++)
			{
				final List list_0 = mapRegions[int_0][int_1].method356();
				final Iterator iterator_0 = list_0.iterator();

				while (iterator_0.hasNext())
				{
					final MapIcon mapicon_0 = (MapIcon) iterator_0.next();
					if (!field267.containsKey(Integer.valueOf(mapicon_0.areaId)))
					{
						final LinkedList linkedlist_0 = new LinkedList();
						linkedlist_0.add(mapicon_0);
						field267.put(Integer.valueOf(mapicon_0.areaId), linkedlist_0);
					}
					else
					{
						final List list_1 = (List) field267.get(Integer.valueOf(mapicon_0.areaId));
						list_1.add(mapicon_0);
					}
				}
			}
		}

	}

	float method492(final int int_0, final int int_1)
	{
		final float float_0 = (float) int_0 / (float) int_1;
		if (float_0 > 8.0F)
		{
			return 8.0F;
		}
		else if (float_0 < 1.0F)
		{
			return 1.0F;
		}
		else
		{
			final int int_2 = Math.round(float_0);
			return Math.abs(int_2 - float_0) < 0.05F ? (float) int_2 : float_0;
		}
	}

	static int adjustHSLListness0(final int int_0, int int_1)
	{
		if (int_0 == -2)
		{
			return 12345678;
		}
		else if (int_0 == -1)
		{
			if (int_1 < 2)
			{
				int_1 = 2;
			}
			else if (int_1 > 126)
			{
				int_1 = 126;
			}

			return int_1;
		}
		else
		{
			int_1 = ((int_0 & 0x7F) * int_1) / 128;
			if (int_1 < 2)
			{
				int_1 = 2;
			}
			else if (int_1 > 126)
			{
				int_1 = 126;
			}

			return (int_0 & 0xFF80) + int_1;
		}
	}

	static void method484()
	{
		Game.field626.method1978();
		Game.field626.packetBuffer.offset = 0;
		Game.field626.serverPacket = null;
		Game.field626.field1215 = null;
		Game.field626.field1226 = null;
		Game.field626.field1227 = null;
		Game.field626.packetLength = 0;
		Game.field626.field1228 = 0;
		Game.field598 = 0;
		Game.menuOptionCount = 0;
		Game.isMenuOpen = false;
		Game.field810 = 0;
		Game.destinationX = 0;

		int int_0;
		for (int_0 = 0; int_0 < 2048; int_0++)
		{
			Game.cachedPlayers[int_0] = null;
		}

		class138.localPlayer = null;

		for (int_0 = 0; int_0 < Game.cachedNPCs.length; int_0++)
		{
			final NPC npc_0 = Game.cachedNPCs[int_0];
			if (npc_0 != null)
			{
				npc_0.interacting = -1;
				npc_0.field898 = false;
			}
		}

		ItemContainer.itemContainers = new HashTable(32);
		MouseInput.setGameState(30);

		for (int_0 = 0; int_0 < 100; int_0++)
		{
			Game.field697[int_0] = true;
		}

		final PacketNode packetnode_0 = class26.method433(ClientPacket.RESIZE_CLIENT_FRAME, Game.field626.field1218);
		final PacketBuffer packetbuffer_0 = packetnode_0.packetBuffer;
		final int int_1 = Game.isResized ? 2 : 1;
		packetbuffer_0.putByte(int_1);
		packetnode_0.packetBuffer.putShort(Varcs.canvasWidth);
		packetnode_0.packetBuffer.putShort(BuildType.canvasHeight);
		Game.field626.method1980(packetnode_0);
	}

	static void method516()
	{
		if (Game.field627 > 0)
		{
			SoundTask.method2213();
		}
		else
		{
			Game.field804.method5262();
			MouseInput.setGameState(40);
			PendingSpawn.field869 = Game.field626.getSocket();
			Game.field626.method1984();
		}
	}

	static void method500(final boolean bool_0, final PacketBuffer packetbuffer_0)
	{
		while (true)
		{
			if (packetbuffer_0.bitsAvail(Game.field626.packetLength) >= 27)
			{
				final int int_0 = packetbuffer_0.getBits(15);
				if (int_0 != 32767)
				{
					boolean bool_1 = false;
					if (Game.cachedNPCs[int_0] == null)
					{
						Game.cachedNPCs[int_0] = new NPC();
						bool_1 = true;
					}

					final NPC npc_0 = Game.cachedNPCs[int_0];
					Game.npcIndices[++Game.npcIndexesCount - 1] = int_0;
					npc_0.npcCycle = Game.gameCycle;
					int int_1;
					if (bool_0)
					{
						int_1 = packetbuffer_0.getBits(8);
						if (int_1 > 127)
						{
							int_1 -= 256;
						}
					}
					else
					{
						int_1 = packetbuffer_0.getBits(5);
						if (int_1 > 15)
						{
							int_1 -= 32;
						}
					}

					final int int_2 = Game.field706[packetbuffer_0.getBits(3)];
					if (bool_1)
					{
						npc_0.orientation = npc_0.angle = int_2;
					}

					final int int_3 = packetbuffer_0.getBits(1);
					int int_4;
					if (bool_0)
					{
						int_4 = packetbuffer_0.getBits(8);
						if (int_4 > 127)
						{
							int_4 -= 256;
						}
					}
					else
					{
						int_4 = packetbuffer_0.getBits(5);
						if (int_4 > 15)
						{
							int_4 -= 32;
						}
					}

					npc_0.composition = HorizontalAlignment.getNpcDefinition(packetbuffer_0.getBits(14));
					final int int_5 = packetbuffer_0.getBits(1);
					if (int_5 == 1)
					{
						Game.pendingNpcFlagsIndices[++Game.pendingNpcFlagsCount - 1] = int_0;
					}

					npc_0.field874 = npc_0.composition.size;
					npc_0.field924 = npc_0.composition.rotation;
					if (npc_0.field924 == 0)
					{
						npc_0.angle = 0;
					}

					npc_0.field899 = npc_0.composition.walkingAnimation;
					npc_0.field880 = npc_0.composition.rotate180Animation;
					npc_0.field870 = npc_0.composition.rotate90RightAnimation;
					npc_0.field882 = npc_0.composition.rotate90LeftAnimation;
					npc_0.idlePoseAnimation = npc_0.composition.standingAnimation;
					npc_0.field877 = npc_0.composition.field3496;
					npc_0.field878 = npc_0.composition.field3486;
					npc_0.method1788(class138.localPlayer.pathX[0] + int_1, class138.localPlayer.pathY[0] + int_4,
					        int_3 == 1);
					continue;
				}
			}

			packetbuffer_0.byteAccess();
			return;
		}
	}

}
