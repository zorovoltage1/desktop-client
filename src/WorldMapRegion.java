import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class WorldMapRegion
{

	static class201 field188;
	static class201 field189;
	static final Coordinates field193;
	int field191;
	int field192;
	class10 field197;
	LinkedList field195;
	int field194;
	int pixelsPerTile;
	List field196;
	HashMap field199;
	final HashMap mapFonts;

	static
	{
		field188 = new class201(37748736, 256);
		field189 = new class201(256, 256);
		field193 = new Coordinates();
	}

	WorldMapRegion(final int int_0, final int int_1, final int int_2, final HashMap hashmap_0)
	{
		field191 = int_0;
		field192 = int_1;
		field195 = new LinkedList();
		field196 = new LinkedList();
		field199 = new HashMap();
		field194 = int_2 | 0xFF000000;
		mapFonts = hashmap_0;
	}

	void method314(final int int_0, final int int_1, final int int_2)
	{
		final int int_3 = field191;
		final int int_4 = field192;
		final int int_5 = pixelsPerTile;
		final SpritePixels spritepixels_0 = (SpritePixels) field188.method3997(class43.method716(int_3, int_4, int_5));
		if (spritepixels_0 != null)
		{
			if (int_2 == (pixelsPerTile * 64))
			{
				spritepixels_0.method5849(int_0, int_1);
			}
			else
			{
				spritepixels_0.method5872(int_0, int_1, int_2, int_2);
			}

		}
	}

	void method400(final class10 class10_0, final List list_0)
	{
		field199.clear();
		field197 = class10_0;
		method294(0, 0, 64, 64, field197);
		method289(list_0);
	}

	void method287(final HashSet hashset_0, final List list_0)
	{
		field199.clear();
		final Iterator iterator_0 = hashset_0.iterator();

		while (iterator_0.hasNext())
		{
			final class34 class34_0 = (class34) iterator_0.next();
			if ((class34_0.method149() == field191) && (class34_0.method168() == field192))
			{
				field195.add(class34_0);
				method294(class34_0.method565() * 8, class34_0.method563() * 8, 8, 8, class34_0);
			}
		}

		method289(list_0);
	}

	void method294(final int int_0, final int int_1, final int int_2, final int int_3, final class16 class16_0)
	{
		for (int int_4 = int_0; int_4 < (int_2 + int_0); int_4++)
		{
			label55: for (int int_5 = int_1; int_5 < (int_1 + int_3); int_5++)
			{
				final Coordinates coordinates_0 = new Coordinates(0, int_4, int_5);

				for (int int_6 = 0; int_6 < class16_0.field121; int_6++)
				{
					final WorldMapDecoration[] worldmapdecorations_0 = class16_0.decorations[int_6][int_4][int_5];
					if ((worldmapdecorations_0 != null) && (worldmapdecorations_0.length != 0))
					{
						final WorldMapDecoration[] worldmapdecorations_1 = worldmapdecorations_0;

						for (int int_7 = 0; int_7 < worldmapdecorations_1.length; int_7++)
						{
							final WorldMapDecoration worldmapdecoration_0 = worldmapdecorations_1[int_7];
							final Area area_0 = method348(worldmapdecoration_0.objectDefinitionId);
							if (area_0 != null)
							{
								final Coordinates coordinates_1 = new Coordinates(int_6, (field191 * 64) + int_4,
								        (field192 * 64) + int_5);
								Coordinates coordinates_2 = null;
								if (field197 != null)
								{
									coordinates_2 = new Coordinates(field197.field120 + int_6,
									        int_4 + (field197.field127 * 64), int_5 + (field197.field117 * 64));
								}
								else
								{
									final class34 class34_0 = (class34) class16_0;
									coordinates_2 = new Coordinates(int_6 + class34_0.field120,
									        int_4 + (class34_0.field127 * 64) + (class34_0.method584() * 8),
									        (class34_0.field117 * 64) + int_5 + (class34_0.method564() * 8));
								}

								final MapIcon mapicon_0 = new MapIcon(area_0.id, coordinates_2, coordinates_1,
								        createMapLabel(area_0));
								field199.put(coordinates_0, mapicon_0);
								continue label55;
							}
						}
					}
				}
			}
		}

	}

	void method289(final List list_0)
	{
		final Iterator iterator_0 = list_0.iterator();

		while (iterator_0.hasNext())
		{
			final class13 class13_0 = (class13) iterator_0.next();
			if (((class13_0.field88.worldX >> 6) == field191) && ((class13_0.field88.worldY >> 6) == field192))
			{
				final MapIcon mapicon_0 = new MapIcon(class13_0.field83, class13_0.field88, class13_0.field88,
				        method306(class13_0.field83));
				field196.add(mapicon_0);
			}
		}

	}

	void method290(final int int_0, final class35 class35_0, final WorldMapRegion[] worldmapregions_0,
	        final IndexedSprite[] indexedsprites_0)
	{
		pixelsPerTile = int_0;
		if ((field197 != null) || !field195.isEmpty())
		{
			final int int_1 = field191;
			final int int_2 = field192;
			final SpritePixels spritepixels_0 = (SpritePixels) field188
			        .method3997(class43.method716(int_1, int_2, int_0));
			if (spritepixels_0 == null)
			{
				final class21 class21_0 = method297(field191, field192, worldmapregions_0);
				final SpritePixels spritepixels_1 = new SpritePixels(pixelsPerTile * 64, pixelsPerTile * 64);
				spritepixels_1.setRaster();
				if (field197 != null)
				{
					method293(class35_0, worldmapregions_0, indexedsprites_0, class21_0);
				}
				else
				{
					method373(class35_0, indexedsprites_0, class21_0);
				}

				PacketNode.method3458(spritepixels_1, field191, field192, pixelsPerTile);
			}
		}
	}

	void method382(final int int_0, final int int_1, final int int_2, HashSet hashset_0)
	{
		if (hashset_0 == null)
		{
			hashset_0 = new HashSet();
		}

		drawNonLinkMapIcons(int_0, int_1, hashset_0, int_2);
		drawMapLinks(int_0, int_1, hashset_0, int_2);
	}

	void drawFlashingMapIcons(final HashSet hashset_0, final int int_0, final int int_1)
	{
		final Iterator iterator_0 = field199.values().iterator();

		while (iterator_0.hasNext())
		{
			final MapIcon mapicon_0 = (MapIcon) iterator_0.next();
			if (hashset_0.contains(Integer.valueOf(mapicon_0.areaId)))
			{
				final Area area_0 = Area.mapAreaType[mapicon_0.areaId];
				method307(area_0, mapicon_0.screenX, mapicon_0.screenY, int_0, int_1);
			}
		}

		method309(hashset_0, int_0, int_1);
	}

	void method293(final class35 class35_0, final WorldMapRegion[] worldmapregions_0,
	        final IndexedSprite[] indexedsprites_0, final class21 class21_0)
	{
		int int_0;
		int int_1;
		for (int_0 = 0; int_0 < 64; int_0++)
		{
			for (int_1 = 0; int_1 < 64; int_1++)
			{
				method320(int_0, int_1, field197, class35_0, class21_0);
				method296(int_0, int_1, field197, class35_0);
			}
		}

		for (int_0 = 0; int_0 < 64; int_0++)
		{
			for (int_1 = 0; int_1 < 64; int_1++)
			{
				method295(int_0, int_1, field197, class35_0, indexedsprites_0);
			}
		}

	}

	void method373(final class35 class35_0, final IndexedSprite[] indexedsprites_0, final class21 class21_0)
	{
		Iterator iterator_0 = field195.iterator();

		class34 class34_0;
		int int_0;
		int int_1;
		while (iterator_0.hasNext())
		{
			class34_0 = (class34) iterator_0.next();

			for (int_0 = class34_0.method565() * 8; int_0 < ((class34_0.method565() * 8) + 8); int_0++)
			{
				for (int_1 = class34_0.method563() * 8; int_1 < ((class34_0.method563() * 8) + 8); int_1++)
				{
					method320(int_0, int_1, class34_0, class35_0, class21_0);
					method296(int_0, int_1, class34_0, class35_0);
				}
			}
		}

		iterator_0 = field195.iterator();

		while (iterator_0.hasNext())
		{
			class34_0 = (class34) iterator_0.next();

			for (int_0 = class34_0.method565() * 8; int_0 < ((class34_0.method565() * 8) + 8); int_0++)
			{
				for (int_1 = class34_0.method563() * 8; int_1 < ((class34_0.method563() * 8) + 8); int_1++)
				{
					method295(int_0, int_1, class34_0, class35_0, indexedsprites_0);
				}
			}
		}

	}

	void method295(final int int_0, final int int_1, final class16 class16_0, final class35 class35_0,
	        final IndexedSprite[] indexedsprites_0)
	{
		method304(int_0, int_1, class16_0);
		method406(int_0, int_1, class16_0, indexedsprites_0);
	}

	void method320(final int int_0, final int int_1, final class16 class16_0, final class35 class35_0,
	        final class21 class21_0)
	{
		final int int_2 = class16_0.field125[0][int_0][int_1] - 1;
		final int int_3 = class16_0.field123[0][int_0][int_1] - 1;
		if ((int_2 == -1) && (int_3 == -1))
		{
			Rasterizer2D.Rasterizer2D_fillRectangle(pixelsPerTile * int_0, pixelsPerTile * (63 - int_1), pixelsPerTile,
			        pixelsPerTile, field194);
		}

		int int_4 = 16711935;
		if (int_3 != -1)
		{
			int_4 = class6.method69(int_3, field194);
		}

		if ((int_3 > -1) && (class16_0.field124[0][int_0][int_1] == 0))
		{
			Rasterizer2D.Rasterizer2D_fillRectangle(pixelsPerTile * int_0, pixelsPerTile * (63 - int_1), pixelsPerTile,
			        pixelsPerTile, int_4);
		}
		else
		{
			final int int_5 = method302(int_0, int_1, class16_0, class21_0);
			if (int_3 == -1)
			{
				Rasterizer2D.Rasterizer2D_fillRectangle(pixelsPerTile * int_0, pixelsPerTile * (63 - int_1),
				        pixelsPerTile, pixelsPerTile, int_5);
			}
			else
			{
				class35_0.method606(pixelsPerTile * int_0, pixelsPerTile * (63 - int_1), int_5, int_4, pixelsPerTile,
				        pixelsPerTile, class16_0.field124[0][int_0][int_1], class16_0.field116[0][int_0][int_1]);
			}
		}
	}

	void method296(final int int_0, final int int_1, final class16 class16_0, final class35 class35_0)
	{
		for (int int_2 = 1; int_2 < class16_0.field121; int_2++)
		{
			final int int_3 = class16_0.field123[int_2][int_0][int_1] - 1;
			if (int_3 > -1)
			{
				final int int_4 = class6.method69(int_3, field194);
				if (class16_0.field124[int_2][int_0][int_1] == 0)
				{
					Rasterizer2D.Rasterizer2D_fillRectangle(pixelsPerTile * int_0, pixelsPerTile * (63 - int_1),
					        pixelsPerTile, pixelsPerTile, int_4);
				}
				else
				{
					class35_0.method606(pixelsPerTile * int_0, pixelsPerTile * (63 - int_1), 0, int_4, pixelsPerTile,
					        pixelsPerTile, class16_0.field124[int_2][int_0][int_1],
					        class16_0.field116[int_2][int_0][int_1]);
				}
			}
		}

	}

	class21 method297(final int int_0, final int int_1, final WorldMapRegion[] worldmapregions_0)
	{
		final class21 class21_0 = (class21) field189.method3997(class43.method716(int_0, int_1, 0));
		class21 class21_1 = class21_0;
		if (class21_0 == null)
		{
			class21_1 = method298(worldmapregions_0);
			Size.method104(class21_1, int_0, int_1);
		}

		return class21_1;
	}

	class21 method298(final WorldMapRegion[] worldmapregions_0)
	{
		final class32 class32_0 = new class32(64, 64);
		if (field197 != null)
		{
			method300(0, 0, 64, 64, field197, class32_0);
		}
		else
		{
			final Iterator iterator_0 = field195.iterator();

			while (iterator_0.hasNext())
			{
				final class34 class34_0 = (class34) iterator_0.next();
				method300(class34_0.method565() * 8, class34_0.method563() * 8, 8, 8, class34_0, class32_0);
			}
		}

		method299(worldmapregions_0, class32_0);
		final class21 class21_0 = new class21();
		class21_0.method265(class32_0);
		return class21_0;
	}

	void method299(final WorldMapRegion[] worldmapregions_0, final class32 class32_0)
	{
		final class240[] class240s_0 = class9.method85();
		final class240[] class240s_1 = class240s_0;

		for (int int_0 = 0; int_0 < class240s_1.length; int_0++)
		{
			final class240 class240_0 = class240s_1[int_0];
			if (worldmapregions_0[class240_0.vmethod5815()] != null)
			{
				byte byte_0 = 0;
				byte byte_1 = 0;
				byte byte_2 = 64;
				byte byte_3 = 64;
				byte byte_4 = 0;
				byte byte_5 = 0;
				switch (class240_0.field3104)
				{
					case 0:
						byte_1 = 59;
						byte_3 = 5;
						byte_4 = 59;
						byte_2 = 5;
						break;
					case 1:
						byte_4 = 59;
						byte_2 = 5;
						break;
					case 2:
						byte_5 = 59;
						byte_3 = 5;
						byte_0 = 59;
						byte_2 = 5;
						break;
					case 3:
						byte_1 = 59;
						byte_3 = 5;
						break;
					case 4:
						byte_4 = 59;
						byte_5 = 59;
						byte_2 = 5;
						byte_3 = 5;
						break;
					case 5:
						byte_1 = 59;
						byte_3 = 5;
						byte_0 = 59;
						byte_2 = 5;
						break;
					case 6:
						byte_5 = 59;
						byte_3 = 5;
						break;
					case 7:
						byte_0 = 59;
						byte_2 = 5;
				}

				method301(byte_4, byte_5, byte_0, byte_1, byte_2, byte_3, worldmapregions_0[class240_0.vmethod5815()],
				        class32_0);
			}
		}

	}

	void method300(final int int_0, final int int_1, final int int_2, final int int_3, final class16 class16_0,
	        final class32 class32_0)
	{
		for (int int_4 = int_0; int_4 < (int_2 + int_0); int_4++)
		{
			for (int int_5 = int_1; int_5 < (int_1 + int_3); int_5++)
			{
				final int int_6 = class16_0.field125[0][int_4][int_5] - 1;
				if (int_6 != -1)
				{
					final FloorUnderlayDefinition floorunderlaydefinition_0 = class49.getUnderlayDefinition(int_6);
					class32_0.method541(int_4, int_5, 5, floorunderlaydefinition_0);
				}
			}
		}

	}

	void method301(final int int_0, final int int_1, final int int_2, final int int_3, final int int_4, final int int_5,
	        final WorldMapRegion worldmapregion_1, final class32 class32_0)
	{
		for (int int_6 = 0; int_6 < int_4; int_6++)
		{
			for (int int_7 = 0; int_7 < int_5; int_7++)
			{
				final int int_8 = worldmapregion_1.method322(int_6 + int_0, int_7 + int_1);
				if (int_8 != -1)
				{
					final FloorUnderlayDefinition floorunderlaydefinition_0 = class49.getUnderlayDefinition(int_8);
					class32_0.method541(int_2 + int_6, int_7 + int_3, 5, floorunderlaydefinition_0);
				}
			}
		}

	}

	int method302(final int int_0, final int int_1, final class16 class16_0, final class21 class21_0)
	{
		return class16_0.field125[0][int_0][int_1] == 0 ? field194 : class21_0.method272(int_0, int_1);
	}

	void method406(final int int_0, final int int_1, final class16 class16_0, final IndexedSprite[] indexedsprites_0)
	{
		for (int int_2 = 0; int_2 < class16_0.field121; int_2++)
		{
			final WorldMapDecoration[] worldmapdecorations_0 = class16_0.decorations[int_2][int_0][int_1];
			if ((worldmapdecorations_0 != null) && (worldmapdecorations_0.length != 0))
			{
				final WorldMapDecoration[] worldmapdecorations_1 = worldmapdecorations_0;

				for (int int_3 = 0; int_3 < worldmapdecorations_1.length; int_3++)
				{
					final WorldMapDecoration worldmapdecoration_0 = worldmapdecorations_1[int_3];
					if (!RunException.method3247(worldmapdecoration_0.decoration))
					{
						final int int_4 = worldmapdecoration_0.decoration;
						final boolean bool_0 = int_4 == WorldMapDecorationType.field2776.rsOrdinal;
						if (!bool_0)
						{
							continue;
						}
					}

					final ObjectComposition objectcomposition_0 = FileOnDisk
					        .getObjectDefinition(worldmapdecoration_0.objectDefinitionId);
					if (objectcomposition_0.mapSceneId != -1)
					{
						if ((objectcomposition_0.mapSceneId != 46) && (objectcomposition_0.mapSceneId != 52))
						{
							indexedsprites_0[objectcomposition_0.mapSceneId].method5825(pixelsPerTile * int_0,
							        pixelsPerTile * (63 - int_1), pixelsPerTile * 2, pixelsPerTile * 2);
						}
						else
						{
							indexedsprites_0[objectcomposition_0.mapSceneId].method5825(pixelsPerTile * int_0,
							        pixelsPerTile * (63 - int_1), (pixelsPerTile * 2) + 1, (pixelsPerTile * 2) + 1);
						}
					}
				}
			}
		}

	}

	void method304(final int int_0, final int int_1, final class16 class16_0)
	{
		for (int int_2 = 0; int_2 < class16_0.field121; int_2++)
		{
			final WorldMapDecoration[] worldmapdecorations_0 = class16_0.decorations[int_2][int_0][int_1];
			if ((worldmapdecorations_0 != null) && (worldmapdecorations_0.length != 0))
			{
				final WorldMapDecoration[] worldmapdecorations_1 = worldmapdecorations_0;

				for (int int_3 = 0; int_3 < worldmapdecorations_1.length; int_3++)
				{
					final WorldMapDecoration worldmapdecoration_0 = worldmapdecorations_1[int_3];
					if (FaceNormal.method3073(worldmapdecoration_0.decoration))
					{
						final ObjectComposition objectcomposition_0 = FileOnDisk
						        .getObjectDefinition(worldmapdecoration_0.objectDefinitionId);
						final int int_4 = objectcomposition_0.int1 != 0 ? -3407872 : -3355444;
						if (worldmapdecoration_0.decoration == WorldMapDecorationType.field2773.rsOrdinal)
						{
							method321(int_0, int_1, worldmapdecoration_0.rotation, int_4);
						}

						if (worldmapdecoration_0.decoration == WorldMapDecorationType.field2755.rsOrdinal)
						{
							method321(int_0, int_1, worldmapdecoration_0.rotation, -3355444);
							method321(int_0, int_1, worldmapdecoration_0.rotation + 1, int_4);
						}

						if (worldmapdecoration_0.decoration == WorldMapDecorationType.field2757.rsOrdinal)
						{
							if (worldmapdecoration_0.rotation == 0)
							{
								Rasterizer2D.method5736(pixelsPerTile * int_0, pixelsPerTile * (63 - int_1), 1, int_4);
							}

							if (worldmapdecoration_0.rotation == 1)
							{
								Rasterizer2D.method5736(((pixelsPerTile * int_0) + pixelsPerTile) - 1,
								        pixelsPerTile * (63 - int_1), 1, int_4);
							}

							if (worldmapdecoration_0.rotation == 2)
							{
								Rasterizer2D.method5736(((pixelsPerTile * int_0) + pixelsPerTile) - 1,
								        ((pixelsPerTile * (63 - int_1)) + pixelsPerTile) - 1, 1, int_4);
							}

							if (worldmapdecoration_0.rotation == 3)
							{
								Rasterizer2D.method5736(pixelsPerTile * int_0,
								        ((pixelsPerTile * (63 - int_1)) + pixelsPerTile) - 1, 1, int_4);
							}
						}

						if (worldmapdecoration_0.decoration == WorldMapDecorationType.field2758.rsOrdinal)
						{
							final int int_5 = worldmapdecoration_0.rotation % 2;
							int int_6;
							if (int_5 == 0)
							{
								for (int_6 = 0; int_6 < pixelsPerTile; int_6++)
								{
									Rasterizer2D.method5736(int_6 + (pixelsPerTile * int_0),
									        ((64 - int_1) * pixelsPerTile) - 1 - int_6, 1, int_4);
								}
							}
							else
							{
								for (int_6 = 0; int_6 < pixelsPerTile; int_6++)
								{
									Rasterizer2D.method5736(int_6 + (pixelsPerTile * int_0),
									        int_6 + (pixelsPerTile * (63 - int_1)), 1, int_4);
								}
							}
						}
					}
				}
			}
		}

	}

	void drawNonLinkMapIcons(final int int_0, final int int_1, final HashSet hashset_0, final int int_2)
	{
		final float float_0 = int_2 / 64.0F;
		final float float_1 = float_0 / 2.0F;
		final Iterator iterator_0 = field199.entrySet().iterator();

		while (iterator_0.hasNext())
		{
			final Entry map$entry_0 = (Entry) iterator_0.next();
			final Coordinates coordinates_0 = (Coordinates) map$entry_0.getKey();
			final int int_3 = (int) (((coordinates_0.worldX * float_0) + int_0) - float_1);
			final int int_4 = (int) (int_1 + int_2 - (coordinates_0.worldY * float_0) - float_1);
			final MapIcon mapicon_0 = (MapIcon) map$entry_0.getValue();
			if (mapicon_0 != null)
			{
				mapicon_0.screenX = int_3;
				mapicon_0.screenY = int_4;
				final Area area_0 = Area.mapAreaType[mapicon_0.areaId];
				if (!hashset_0.contains(Integer.valueOf(area_0.method4821())))
				{
					method308(mapicon_0, int_3, int_4, float_0);
				}
			}
		}

	}

	void method309(final HashSet hashset_0, final int int_0, final int int_1)
	{
		final Iterator iterator_0 = field196.iterator();

		while (iterator_0.hasNext())
		{
			final MapIcon mapicon_0 = (MapIcon) iterator_0.next();
			final Area area_0 = Area.mapAreaType[mapicon_0.areaId];
			if ((area_0 != null) && hashset_0.contains(Integer.valueOf(area_0.method4821())))
			{
				method307(area_0, mapicon_0.screenX, mapicon_0.screenY, int_0, int_1);
			}
		}

	}

	void method307(final Area area_0, final int int_0, final int int_1, final int int_2, final int int_3)
	{
		final SpritePixels spritepixels_0 = area_0.getMapIcon(false);
		if (spritepixels_0 != null)
		{
			spritepixels_0.drawAt(int_0 - (spritepixels_0.width / 2), int_1 - (spritepixels_0.height / 2));
			if ((int_2 % int_3) < (int_3 / 2))
			{
				Rasterizer2D.method5784(int_0, int_1, 15, 16776960, 128);
				Rasterizer2D.method5784(int_0, int_1, 7, 16777215, 256);
			}

		}
	}

	void method308(final MapIcon mapicon_0, final int int_0, final int int_1, final float float_0)
	{
		final Area area_0 = Area.mapAreaType[mapicon_0.areaId];
		method317(area_0, int_0, int_1);
		method362(mapicon_0, area_0, int_0, int_1, float_0);
	}

	void method317(final Area area_0, final int int_0, final int int_1)
	{
		final SpritePixels spritepixels_0 = area_0.getMapIcon(false);
		if (spritepixels_0 != null)
		{
			final int int_2 = method288(spritepixels_0, area_0.horizontalAlignment);
			final int int_3 = method284(spritepixels_0, area_0.verticalAlignment);
			spritepixels_0.drawAt(int_2 + int_0, int_1 + int_3);
		}

	}

	void method362(final MapIcon mapicon_0, final Area area_0, final int int_0, final int int_1, final float float_0)
	{
		if (mapicon_0.field246 != null)
		{
			if (mapicon_0.field246.fontSize.method103(float_0))
			{
				final Font font_0 = (Font) mapFonts.get(mapicon_0.field246.fontSize);
				font_0.method5526(mapicon_0.field246.text, int_0 - (mapicon_0.field246.field184 / 2), int_1,
				        mapicon_0.field246.field184, mapicon_0.field246.field182, 0xFF000000 | area_0.field3242, 0, 1,
				        0, font_0.verticalSpace / 2);
			}
		}
	}

	void drawMapLinks(final int int_0, final int int_1, final HashSet hashset_0, final int int_2)
	{
		final float float_0 = int_2 / 64.0F;
		final Iterator iterator_0 = field196.iterator();

		while (iterator_0.hasNext())
		{
			final MapIcon mapicon_0 = (MapIcon) iterator_0.next();
			final int int_3 = mapicon_0.field236.worldX % 64;
			final int int_4 = mapicon_0.field236.worldY % 64;
			mapicon_0.screenX = (int) (int_0 + (float_0 * int_3));
			mapicon_0.screenY = (int) ((float_0 * (63 - int_4)) + int_1);
			if (!hashset_0.contains(Integer.valueOf(mapicon_0.areaId)))
			{
				method308(mapicon_0, mapicon_0.screenX, mapicon_0.screenY, float_0);
			}
		}

	}

	void method340()
	{
		if (field197 != null)
		{
			for (int int_0 = 0; int_0 < 64; int_0++)
			{
				for (int int_1 = 0; int_1 < 64; int_1++)
				{
					method313(int_0, int_1, field197);
				}
			}
		}
		else
		{
			final Iterator iterator_0 = field195.iterator();

			while (iterator_0.hasNext())
			{
				final class34 class34_0 = (class34) iterator_0.next();

				for (int int_2 = class34_0.method565() * 8; int_2 < ((class34_0.method565() * 8) + 8); int_2++)
				{
					for (int int_3 = class34_0.method563() * 8; int_3 < ((class34_0.method563() * 8) + 8); int_3++)
					{
						method313(int_2, int_3, class34_0);
					}
				}
			}
		}

	}

	void method313(final int int_0, final int int_1, final class16 class16_0)
	{
		field193.set(0, int_0, int_1);

		for (int int_2 = 0; int_2 < class16_0.field121; int_2++)
		{
			final WorldMapDecoration[] worldmapdecorations_0 = class16_0.decorations[int_2][int_0][int_1];
			if ((worldmapdecorations_0 != null) && (worldmapdecorations_0.length != 0))
			{
				final WorldMapDecoration[] worldmapdecorations_1 = worldmapdecorations_0;

				for (int int_3 = 0; int_3 < worldmapdecorations_1.length; int_3++)
				{
					final WorldMapDecoration worldmapdecoration_0 = worldmapdecorations_1[int_3];
					final Area area_0 = method348(worldmapdecoration_0.objectDefinitionId);
					if (area_0 != null)
					{
						MapIcon mapicon_0 = (MapIcon) field199.get(field193);
						if (mapicon_0 != null)
						{
							if (mapicon_0.areaId != area_0.id)
							{
								final MapIcon mapicon_1 = new MapIcon(area_0.id, mapicon_0.field243, mapicon_0.field236,
								        createMapLabel(area_0));
								field199.put(new Coordinates(field193), mapicon_1);
								mapicon_0 = mapicon_1;
							}

							final int int_4 = mapicon_0.field243.plane - mapicon_0.field236.plane;
							mapicon_0.field236.plane = int_2;
							mapicon_0.field243.plane = int_4 + int_2;
							return;
						}

						final Coordinates coordinates_0 = new Coordinates(int_2, (field191 * 64) + int_0,
						        (field192 * 64) + int_1);
						Coordinates coordinates_1 = null;
						if (field197 != null)
						{
							coordinates_1 = new Coordinates(field197.field120 + int_2, (field197.field127 * 64) + int_0,
							        int_1 + (field197.field117 * 64));
						}
						else
						{
							final Iterator iterator_0 = field195.iterator();

							while (iterator_0.hasNext())
							{
								final class34 class34_0 = (class34) iterator_0.next();
								if (class34_0.method562(int_0, int_1))
								{
									coordinates_1 = new Coordinates(int_2 + class34_0.field120,
									        int_0 + (class34_0.field127 * 64) + (class34_0.method584() * 8),
									        int_1 + (class34_0.field117 * 64) + (class34_0.method564() * 8));
									break;
								}
							}
						}

						if (coordinates_1 != null)
						{
							mapicon_0 = new MapIcon(area_0.id, coordinates_1, coordinates_0, createMapLabel(area_0));
							field199.put(new Coordinates(field193), mapicon_0);
							return;
						}
					}
				}
			}
		}

		field199.remove(field193);
	}

	int method288(final SpritePixels spritepixels_0, final HorizontalAlignment horizontalalignment_0)
	{
		switch (horizontalalignment_0.value)
		{
			case 0:
				return -spritepixels_0.width / 2;
			case 1:
				return 0;
			default:
				return -spritepixels_0.width;
		}
	}

	int method284(final SpritePixels spritepixels_0, final VerticalAlignment verticalalignment_0)
	{
		switch (verticalalignment_0.value)
		{
			case 1:
				return -spritepixels_0.height / 2;
			case 2:
				return 0;
			default:
				return -spritepixels_0.height;
		}
	}

	Area method348(final int int_0)
	{
		ObjectComposition objectcomposition_0 = FileOnDisk.getObjectDefinition(int_0);
		if (objectcomposition_0.impostorIds != null)
		{
			objectcomposition_0 = objectcomposition_0.getImpostor();
			if (objectcomposition_0 == null)
			{
				return null;
			}
		}

		return objectcomposition_0.mapIconId != -1 ? Area.mapAreaType[objectcomposition_0.mapIconId] : null;
	}

	MapLabel method306(final int int_0)
	{
		final Area area_0 = Area.mapAreaType[int_0];
		return createMapLabel(area_0);
	}

	MapLabel createMapLabel(final Area area_0)
	{
		if ((area_0.name != null) && (mapFonts != null) && (mapFonts.get(Size.field70) != null))
		{
			final Size size_0 = Size.method101(area_0.field3243);
			if (size_0 == null)
			{
				return null;
			}
			else
			{
				final Font font_0 = (Font) mapFonts.get(size_0);
				if (font_0 == null)
				{
					return null;
				}
				else
				{
					final int int_0 = font_0.method5520(area_0.name, 1000000);
					final String[] strings_0 = new String[int_0];
					font_0.method5518(area_0.name, null, strings_0);
					final int int_1 = (strings_0.length * font_0.verticalSpace) / 2;
					int int_2 = 0;
					final String[] strings_1 = strings_0;

					for (int int_3 = 0; int_3 < strings_1.length; int_3++)
					{
						final String string_0 = strings_1[int_3];
						final int int_4 = font_0.getTextWidth(string_0);
						if (int_4 > int_2)
						{
							int_2 = int_4;
						}
					}

					return new MapLabel(area_0.name, int_2, int_1, size_0);
				}
			}
		}
		else
		{
			return null;
		}
	}

	List method319(final int int_0, final int int_1, final int int_2, final int int_3, final int int_4)
	{
		final LinkedList linkedlist_0 = new LinkedList();
		if ((int_3 >= int_0) && (int_4 >= int_1))
		{
			if ((int_3 < (int_2 + int_0)) && (int_4 < (int_2 + int_1)))
			{
				Iterator iterator_0 = field199.values().iterator();

				MapIcon mapicon_0;
				while (iterator_0.hasNext())
				{
					mapicon_0 = (MapIcon) iterator_0.next();
					if (mapicon_0.method464(int_3, int_4))
					{
						linkedlist_0.add(mapicon_0);
					}
				}

				iterator_0 = field196.iterator();

				while (iterator_0.hasNext())
				{
					mapicon_0 = (MapIcon) iterator_0.next();
					if (mapicon_0.method464(int_3, int_4))
					{
						linkedlist_0.add(mapicon_0);
					}
				}

				return linkedlist_0;
			}
			else
			{
				return linkedlist_0;
			}
		}
		else
		{
			return linkedlist_0;
		}
	}

	List method356()
	{
		final LinkedList linkedlist_0 = new LinkedList();
		linkedlist_0.addAll(field196);
		linkedlist_0.addAll(field199.values());
		return linkedlist_0;
	}

	void method321(final int int_0, final int int_1, int int_2, final int int_3)
	{
		int_2 %= 4;
		if (int_2 == 0)
		{
			Rasterizer2D.method5738(pixelsPerTile * int_0, pixelsPerTile * (63 - int_1), pixelsPerTile, int_3);
		}

		if (int_2 == 1)
		{
			Rasterizer2D.method5736(pixelsPerTile * int_0, pixelsPerTile * (63 - int_1), pixelsPerTile, int_3);
		}

		if (int_2 == 2)
		{
			Rasterizer2D.method5738(((pixelsPerTile * int_0) + pixelsPerTile) - 1, pixelsPerTile * (63 - int_1),
			        pixelsPerTile, int_3);
		}

		if (int_2 == 3)
		{
			Rasterizer2D.method5736(pixelsPerTile * int_0, ((pixelsPerTile * (63 - int_1)) + pixelsPerTile) - 1,
			        pixelsPerTile, int_3);
		}

	}

	int method322(final int int_0, final int int_1)
	{
		if (field197 != null)
		{
			return field197.method153(int_0, int_1);
		}
		else
		{
			if (!field195.isEmpty())
			{
				final Iterator iterator_0 = field195.iterator();

				while (iterator_0.hasNext())
				{
					final class34 class34_0 = (class34) iterator_0.next();
					if (class34_0.method562(int_0, int_1))
					{
						return class34_0.method153(int_0, int_1);
					}
				}
			}

			return -1;
		}
	}

	public static class316[] method423()
	{
		return new class316[] { class316.field3771, class316.field3775, class316.field3774, class316.field3772,
		        class316.field3773 };
	}

	public static void method422(final int int_0, final IndexDataBase indexdatabase_0, final String string_0,
	        final String string_1, final int int_1, final boolean bool_0)
	{
		final int int_2 = indexdatabase_0.getFile(string_0);
		final int int_3 = indexdatabase_0.getChild(int_2, string_1);
		World.method1602(int_0, indexdatabase_0, int_2, int_3, int_1, bool_0);
	}

	public static int encodeStringCp1252(final CharSequence charsequence_0, final int int_0, final int int_1,
	        final byte[] bytes_0, final int int_2)
	{
		final int int_3 = int_1 - int_0;

		for (int int_4 = 0; int_4 < int_3; int_4++)
		{
			final char char_0 = charsequence_0.charAt(int_4 + int_0);
			if (((char_0 > 0) && (char_0 < 128)) || ((char_0 >= 160) && (char_0 <= 255)))
			{
				bytes_0[int_4 + int_2] = (byte) char_0;
			}
			else if (char_0 == 8364)
			{
				bytes_0[int_4 + int_2] = -128;
			}
			else if (char_0 == 8218)
			{
				bytes_0[int_4 + int_2] = -126;
			}
			else if (char_0 == 402)
			{
				bytes_0[int_4 + int_2] = -125;
			}
			else if (char_0 == 8222)
			{
				bytes_0[int_4 + int_2] = -124;
			}
			else if (char_0 == 8230)
			{
				bytes_0[int_4 + int_2] = -123;
			}
			else if (char_0 == 8224)
			{
				bytes_0[int_4 + int_2] = -122;
			}
			else if (char_0 == 8225)
			{
				bytes_0[int_4 + int_2] = -121;
			}
			else if (char_0 == 710)
			{
				bytes_0[int_4 + int_2] = -120;
			}
			else if (char_0 == 8240)
			{
				bytes_0[int_4 + int_2] = -119;
			}
			else if (char_0 == 352)
			{
				bytes_0[int_4 + int_2] = -118;
			}
			else if (char_0 == 8249)
			{
				bytes_0[int_4 + int_2] = -117;
			}
			else if (char_0 == 338)
			{
				bytes_0[int_4 + int_2] = -116;
			}
			else if (char_0 == 381)
			{
				bytes_0[int_4 + int_2] = -114;
			}
			else if (char_0 == 8216)
			{
				bytes_0[int_4 + int_2] = -111;
			}
			else if (char_0 == 8217)
			{
				bytes_0[int_4 + int_2] = -110;
			}
			else if (char_0 == 8220)
			{
				bytes_0[int_4 + int_2] = -109;
			}
			else if (char_0 == 8221)
			{
				bytes_0[int_4 + int_2] = -108;
			}
			else if (char_0 == 8226)
			{
				bytes_0[int_4 + int_2] = -107;
			}
			else if (char_0 == 8211)
			{
				bytes_0[int_4 + int_2] = -106;
			}
			else if (char_0 == 8212)
			{
				bytes_0[int_4 + int_2] = -105;
			}
			else if (char_0 == 732)
			{
				bytes_0[int_4 + int_2] = -104;
			}
			else if (char_0 == 8482)
			{
				bytes_0[int_4 + int_2] = -103;
			}
			else if (char_0 == 353)
			{
				bytes_0[int_4 + int_2] = -102;
			}
			else if (char_0 == 8250)
			{
				bytes_0[int_4 + int_2] = -101;
			}
			else if (char_0 == 339)
			{
				bytes_0[int_4 + int_2] = -100;
			}
			else if (char_0 == 382)
			{
				bytes_0[int_4 + int_2] = -98;
			}
			else if (char_0 == 376)
			{
				bytes_0[int_4 + int_2] = -97;
			}
			else
			{
				bytes_0[int_4 + int_2] = 63;
			}
		}

		return int_3;
	}

}
