import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class MapCacheArchiveNames {

	public static final MapCacheArchiveNames DETAILS;
	public static final MapCacheArchiveNames COMPOSITE_MAP;
	public static final MapCacheArchiveNames COMPOSITE_TEXTURE;
	public static final MapCacheArchiveNames AREA;
	public static final MapCacheArchiveNames LABELS;
	static FontMetrics field256;
	static byte[][] field253;
	static TextureProvider field250;
	public final String name;

	static {
		DETAILS = new MapCacheArchiveNames("details");
		COMPOSITE_MAP = new MapCacheArchiveNames("compositemap");
		COMPOSITE_TEXTURE = new MapCacheArchiveNames("compositetexture");
		AREA = new MapCacheArchiveNames("area");
		LABELS = new MapCacheArchiveNames("labels");
	}

	MapCacheArchiveNames(final String string_0) {
		name = string_0;
	}

	static void method476() {
		try {
			final File file = new File(WorldMapType1.userHome, Loader.SERVER_NAME.toLowerCase() + "_random.dat");
			int int_1;
			if (file.exists()) {
				class155.randomDat = new CacheFile(new FileOnDisk(file, "rw", 25L), 24, 0);
			} else {
				label38: for (int i = 0; i < class8.field52.length; i++) {
					for (int_1 = 0; int_1 < class155.cacheLocations.length; int_1++) {
						final File file_1 = new File(class155.cacheLocations[int_1] + class8.field52[i]
								+ File.separatorChar + (Loader.SERVER_NAME.toLowerCase() + "_random.dat"));
						if (file_1.exists()) {
							class155.randomDat = new CacheFile(new FileOnDisk(file_1, "rw", 25L), 24, 0);
							break label38;
						}
					}
				}
			}

			if (class155.randomDat == null) {
				final RandomAccessFile randomaccessfile_0 = new RandomAccessFile(file, "rw");
				int_1 = randomaccessfile_0.read();
				randomaccessfile_0.seek(0L);
				randomaccessfile_0.write(int_1);
				randomaccessfile_0.seek(0L);
				randomaccessfile_0.close();
				class155.randomDat = new CacheFile(new FileOnDisk(file, "rw", 25L), 24, 0);
			}
		} catch (final IOException e) {
			e.printStackTrace();
		}

	}

	static int method477(final int int_0, final Script script_0, final boolean bool_0) {
		int int_1;
		if (int_0 == 3903) {
			int_1 = class69.intStack[--class69.intStackSize];
			class69.intStack[++class69.intStackSize - 1] = Game.grandExchangeOffers[int_1].type();
			return 1;
		} else if (int_0 == 3904) {
			int_1 = class69.intStack[--class69.intStackSize];
			class69.intStack[++class69.intStackSize - 1] = Game.grandExchangeOffers[int_1].itemId;
			return 1;
		} else if (int_0 == 3905) {
			int_1 = class69.intStack[--class69.intStackSize];
			class69.intStack[++class69.intStackSize - 1] = Game.grandExchangeOffers[int_1].price;
			return 1;
		} else if (int_0 == 3906) {
			int_1 = class69.intStack[--class69.intStackSize];
			class69.intStack[++class69.intStackSize - 1] = Game.grandExchangeOffers[int_1].totalQuantity;
			return 1;
		} else if (int_0 == 3907) {
			int_1 = class69.intStack[--class69.intStackSize];
			class69.intStack[++class69.intStackSize - 1] = Game.grandExchangeOffers[int_1].quantitySold;
			return 1;
		} else if (int_0 == 3908) {
			int_1 = class69.intStack[--class69.intStackSize];
			class69.intStack[++class69.intStackSize - 1] = Game.grandExchangeOffers[int_1].spent;
			return 1;
		} else {
			int int_5;
			if (int_0 == 3910) {
				int_1 = class69.intStack[--class69.intStackSize];
				int_5 = Game.grandExchangeOffers[int_1].status();
				class69.intStack[++class69.intStackSize - 1] = int_5 == 0 ? 1 : 0;
				return 1;
			} else if (int_0 == 3911) {
				int_1 = class69.intStack[--class69.intStackSize];
				int_5 = Game.grandExchangeOffers[int_1].status();
				class69.intStack[++class69.intStackSize - 1] = int_5 == 2 ? 1 : 0;
				return 1;
			} else if (int_0 == 3912) {
				int_1 = class69.intStack[--class69.intStackSize];
				int_5 = Game.grandExchangeOffers[int_1].status();
				class69.intStack[++class69.intStackSize - 1] = int_5 == 5 ? 1 : 0;
				return 1;
			} else if (int_0 == 3913) {
				int_1 = class69.intStack[--class69.intStackSize];
				int_5 = Game.grandExchangeOffers[int_1].status();
				class69.intStack[++class69.intStackSize - 1] = int_5 == 1 ? 1 : 0;
				return 1;
			} else {
				boolean bool_2;
				if (int_0 == 3914) {
					bool_2 = class69.intStack[--class69.intStackSize] == 1;
					if (WorldMapDecoration.grandExchangeEvents != null) {
						WorldMapDecoration.grandExchangeEvents.sort(GrandExchangeEvents.field11, bool_2);
					}

					return 1;
				} else if (int_0 == 3915) {
					bool_2 = class69.intStack[--class69.intStackSize] == 1;
					if (WorldMapDecoration.grandExchangeEvents != null) {
						WorldMapDecoration.grandExchangeEvents.sort(GrandExchangeEvents.field13, bool_2);
					}

					return 1;
				} else if (int_0 == 3916) {
					class69.intStackSize -= 2;
					bool_2 = class69.intStack[class69.intStackSize] == 1;
					final boolean bool_1 = class69.intStack[class69.intStackSize + 1] == 1;
					if (WorldMapDecoration.grandExchangeEvents != null) {
						Game.field665.field575 = bool_1;
						WorldMapDecoration.grandExchangeEvents.sort(Game.field665, bool_2);
					}

					return 1;
				} else if (int_0 == 3917) {
					bool_2 = class69.intStack[--class69.intStackSize] == 1;
					if (WorldMapDecoration.grandExchangeEvents != null) {
						WorldMapDecoration.grandExchangeEvents.sort(GrandExchangeEvents.field9, bool_2);
					}

					return 1;
				} else if (int_0 == 3918) {
					bool_2 = class69.intStack[--class69.intStackSize] == 1;
					if (WorldMapDecoration.grandExchangeEvents != null) {
						WorldMapDecoration.grandExchangeEvents.sort(GrandExchangeEvents.field16, bool_2);
					}

					return 1;
				} else if (int_0 == 3919) {
					class69.intStack[++class69.intStackSize - 1] = WorldMapDecoration.grandExchangeEvents == null ? 0
							: WorldMapDecoration.grandExchangeEvents.events.size();
					return 1;
				} else {
					GrandExchangeEvent grandexchangeevent_0;
					if (int_0 == 3920) {
						int_1 = class69.intStack[--class69.intStackSize];
						grandexchangeevent_0 = (GrandExchangeEvent) WorldMapDecoration.grandExchangeEvents.events
								.get(int_1);
						class69.intStack[++class69.intStackSize - 1] = grandexchangeevent_0.world;
						return 1;
					} else if (int_0 == 3921) {
						int_1 = class69.intStack[--class69.intStackSize];
						grandexchangeevent_0 = (GrandExchangeEvent) WorldMapDecoration.grandExchangeEvents.events
								.get(int_1);
						class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = grandexchangeevent_0
								.method16();
						return 1;
					} else if (int_0 == 3922) {
						int_1 = class69.intStack[--class69.intStackSize];
						grandexchangeevent_0 = (GrandExchangeEvent) WorldMapDecoration.grandExchangeEvents.events
								.get(int_1);
						class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = grandexchangeevent_0
								.method18();
						return 1;
					} else if (int_0 == 3923) {
						int_1 = class69.intStack[--class69.intStackSize];
						grandexchangeevent_0 = (GrandExchangeEvent) WorldMapDecoration.grandExchangeEvents.events
								.get(int_1);
						final long long_0 = Buffer.safeCurrentTimeMillis() - GraphicsObject.field1013
								- grandexchangeevent_0.field20;
						final int int_2 = (int) (long_0 / 3600000L);
						final int int_3 = (int) ((long_0 - int_2 * 3600000) / 60000L);
						final int int_4 = (int) ((long_0 - int_2 * 3600000 - int_3 * 60000) / 1000L);
						final String string_0 = int_2 + ":" + (int_3 / 10) + (int_3 % 10) + ":" + (int_4 / 10)
								+ (int_4 % 10);
						class69.scriptStringStack[++WidgetNode.scriptStringStackSize - 1] = string_0;
						return 1;
					} else if (int_0 == 3924) {
						int_1 = class69.intStack[--class69.intStackSize];
						grandexchangeevent_0 = (GrandExchangeEvent) WorldMapDecoration.grandExchangeEvents.events
								.get(int_1);
						class69.intStack[++class69.intStackSize
								- 1] = grandexchangeevent_0.grandExchangeOffer.totalQuantity;
						return 1;
					} else if (int_0 == 3925) {
						int_1 = class69.intStack[--class69.intStackSize];
						grandexchangeevent_0 = (GrandExchangeEvent) WorldMapDecoration.grandExchangeEvents.events
								.get(int_1);
						class69.intStack[++class69.intStackSize - 1] = grandexchangeevent_0.grandExchangeOffer.price;
						return 1;
					} else if (int_0 == 3926) {
						int_1 = class69.intStack[--class69.intStackSize];
						grandexchangeevent_0 = (GrandExchangeEvent) WorldMapDecoration.grandExchangeEvents.events
								.get(int_1);
						class69.intStack[++class69.intStackSize - 1] = grandexchangeevent_0.grandExchangeOffer.itemId;
						return 1;
					} else {
						return 2;
					}
				}
			}
		}
	}

	static void load() {
		int int_0;
		if (Game.loadingStage == 0) {
			MapIcon.region = new Region(4, 104, 104, class50.tileHeights);

			for (int_0 = 0; int_0 < 4; int_0++) {
				Game.collisionMaps[int_0] = new CollisionData(104, 104);
			}

			NPC.minimapSprite = new SpritePixels(512, 512);
			class78.loadingText = "Starting game engine...";
			class78.loadingBarPercentage = 5;
			Game.loadingStage = 20;
		} else {
			int int_1;
			int int_2;
			int int_3;
			int int_4;
			if (Game.loadingStage == 20) {
				final int[] ints_0 = new int[9];

				for (int_1 = 0; int_1 < 9; int_1++) {
					int_2 = (int_1 * 32) + 15 + 128;
					int_3 = (int_2 * 3) + 600;
					int_4 = Graphics3D.SINE[int_2];
					ints_0[int_1] = (int_4 * int_3) >> 16;
				}

				Region.buildVisibilityMaps(ints_0, 500, 800, 512, 334);
				class78.loadingText = "Prepared visibility map";
				class78.loadingBarPercentage = 10;
				Game.loadingStage = 30;
			} else if (Game.loadingStage == 30) {
				AttackOption.indexInterfaces = ItemContainer.openCacheIndex(0, false, true, true);
				class37.indexSoundEffects = ItemContainer.openCacheIndex(1, false, true, true);
				SoundTask.configsIndex = ItemContainer.openCacheIndex(2, true, false, true);
				class224.indexCache3 = ItemContainer.openCacheIndex(3, false, true, true);
				UrlRequester.indexCache4 = ItemContainer.openCacheIndex(4, false, true, true);
				FileRequest.indexMaps = ItemContainer.openCacheIndex(5, true, true, true);
				Item.indexTrack1 = ItemContainer.openCacheIndex(6, true, true, true);
				class21.indexModels = ItemContainer.openCacheIndex(7, false, true, true);
				GZipDecompressor.indexSprites = ItemContainer.openCacheIndex(8, false, true, true);
				ObjectComposition.indexTextures = ItemContainer.openCacheIndex(9, false, true, true);
				MapLabel.indexCache10 = ItemContainer.openCacheIndex(10, false, true, true);
				OwnWorldComparator.indexTrack2 = ItemContainer.openCacheIndex(11, false, true, true);
				Game.indexScripts = ItemContainer.openCacheIndex(12, false, true, true);
				class50.indexCache13 = ItemContainer.openCacheIndex(13, true, false, true);
				class59.vorbisIndex = ItemContainer.openCacheIndex(14, false, true, true);
				MapIconReference.indexCache15 = ItemContainer.openCacheIndex(15, false, true, true);
				class24.indexWorldMap = ItemContainer.openCacheIndex(16, true, true, true);
				class78.loadingText = "Connecting to update server";
				System.out.println("We've made it this far...");
				class78.loadingBarPercentage = 20;
				Game.loadingStage = 40;
			} else if (Game.loadingStage == 40) {
				final byte byte_0 = 0;
				int_0 = byte_0 + ((AttackOption.indexInterfaces.percentage() * 4) / 100);
				int_0 += (class37.indexSoundEffects.percentage() * 4) / 100;
				int_0 += (SoundTask.configsIndex.percentage() * 2) / 100;
				int_0 += (class224.indexCache3.percentage() * 2) / 100;
				int_0 += (UrlRequester.indexCache4.percentage() * 6) / 100;
				int_0 += (FileRequest.indexMaps.percentage() * 4) / 100;
				int_0 += (Item.indexTrack1.percentage() * 2) / 100;
				int_0 += (class21.indexModels.percentage() * 58) / 100;
				int_0 += (GZipDecompressor.indexSprites.percentage() * 2) / 100;
				int_0 += (ObjectComposition.indexTextures.percentage() * 2) / 100;
				int_0 += (MapLabel.indexCache10.percentage() * 2) / 100;
				int_0 += (OwnWorldComparator.indexTrack2.percentage() * 2) / 100;
				int_0 += (Game.indexScripts.percentage() * 2) / 100;
				int_0 += (class50.indexCache13.percentage() * 2) / 100;
				int_0 += (class59.vorbisIndex.percentage() * 2) / 100;
				int_0 += (MapIconReference.indexCache15.percentage() * 2) / 100;
				int_0 += (class24.indexWorldMap.percentage() * 2) / 100;
				if (int_0 != 100) {
					if (int_0 != 0) {
						class78.loadingText = "Checking for updates - " + int_0 + "%";
					}

					class78.loadingBarPercentage = 30;
				} else {
					class32.method548(AttackOption.indexInterfaces, "Animations");
					class32.method548(class37.indexSoundEffects, "Skeletons");
					class32.method548(UrlRequester.indexCache4, "Sound FX");
					class32.method548(FileRequest.indexMaps, "Maps");
					class32.method548(Item.indexTrack1, "Music Tracks");
					class32.method548(class21.indexModels, "Models");
					class32.method548(GZipDecompressor.indexSprites, "Sprites");
					class32.method548(OwnWorldComparator.indexTrack2, "Music Jingles");
					class32.method548(class59.vorbisIndex, "Music Samples");
					class32.method548(MapIconReference.indexCache15, "Music Patches");
					class32.method548(class24.indexWorldMap, "World Map");
					class78.loadingText = "Loaded update list";
					class78.loadingBarPercentage = 30;
					Game.loadingStage = 45;
				}
			} else {
				IndexData indexdata_0;
				IndexData indexdata_2;
				if (Game.loadingStage == 45) {
					class68.method1697(22050, !Game.lowMemory, 2);
					final class218 class218_0 = new class218();
					class218_0.method4257(9, 128);
					MapIcon.soundSystem0 = World.method1582(GameEngine.taskManager, 0, 22050);
					MapIcon.soundSystem0.method2143(class218_0);
					indexdata_0 = MapIconReference.indexCache15;
					final IndexData indexdata_1 = class59.vorbisIndex;
					indexdata_2 = UrlRequester.indexCache4;
					class177.indices = indexdata_0;
					class217.field2464 = indexdata_1;
					class217.field2458 = indexdata_2;
					class217.field2459 = class218_0;
					Actor.soundSystem1 = World.method1582(GameEngine.taskManager, 1, 2048);
					MapIconReference.field310 = new class88();
					Actor.soundSystem1.method2143(MapIconReference.field310);
					OwnWorldComparator.field577 = new Resampler(22050, AbstractSoundSystem.sampleRate);
					class78.loadingText = "Prepared sound engine";
					class78.loadingBarPercentage = 35;
					Game.loadingStage = 50;
					GrandExchangeEvents.fonts = new Fonts(GZipDecompressor.indexSprites, class50.indexCache13);
				} else if (Game.loadingStage == 50) {
					int_0 = FontName.method5498().length;
					Game.fontsMap = GrandExchangeEvents.fonts.createMap(FontName.method5498());
					if (Game.fontsMap.size() < int_0) {
						class78.loadingText = "Loading fonts - " + ((Game.fontsMap.size() * 100) / int_0) + "%";
						class78.loadingBarPercentage = 40;
					} else {
						class151.fontPlain11 = (Font) Game.fontsMap.get(FontName.FontName_plain11);
						Actor.font_p12full = (Font) Game.fontsMap.get(FontName.FontName_plain12);
						ClanMemberManager.fontBold12 = (Font) Game.fontsMap.get(FontName.FontName_bold12);
						WorldMapType2.platformInfo = new MachineInfo(true);
						class78.loadingText = "Loaded fonts";
						class78.loadingBarPercentage = 40;
						Game.loadingStage = 60;
					}
				} else if (Game.loadingStage == 60) {
					int_0 = class224.method4426(MapLabel.indexCache10, GZipDecompressor.indexSprites);
					int_1 = class11.method99();
					if (int_0 < int_1) {
						class78.loadingText = "Loading title screen - " + ((int_0 * 100) / int_1) + "%";
						class78.loadingBarPercentage = 50;
					} else {
						class78.loadingText = "Loaded title screen";
						class78.loadingBarPercentage = 50;
						MouseInput.setGameState(5);
						Game.loadingStage = 70;
					}
				} else if (Game.loadingStage == 70) {
					if (!SoundTask.configsIndex.method4629()) {
						class78.loadingText = "Loading config - " + SoundTask.configsIndex.loadPercent() + "%";
						class78.loadingBarPercentage = 60;
					} else {
						class21.method277(SoundTask.configsIndex);
						MessageNode.method1069(SoundTask.configsIndex);
						VarCString.method4851(SoundTask.configsIndex, class21.indexModels);
						final IndexData indexdata_19 = SoundTask.configsIndex;
						indexdata_0 = class21.indexModels;
						final boolean bool_1 = Game.lowMemory;
						ObjectComposition.objects_ref = indexdata_19;
						Frames.field1801 = indexdata_0;
						ObjectComposition.objectCompositionLowDetail = bool_1;
						indexdata_2 = SoundTask.configsIndex;
						final IndexData indexdata_3 = class21.indexModels;
						NPCComposition.NpcDefinition_indexCache = indexdata_2;
						NPCComposition.NpcDefinition_modelIndexCache = indexdata_3;
						final IndexData indexdata_4 = SoundTask.configsIndex;
						class7.field42 = indexdata_4;
						final IndexData indexdata_5 = SoundTask.configsIndex;
						final IndexData indexdata_6 = class21.indexModels;
						final boolean bool_0 = Game.isMembers;
						final Font font_0 = class151.fontPlain11;
						ItemComposition.item_ref = indexdata_5;
						ItemComposition.ItemDefinition_modelIndexCache = indexdata_6;
						ItemComposition.isMembersWorld = bool_0;
						ChatLineBuffer.field1212 = ItemComposition.item_ref.fileCount(10);
						ItemComposition.field3466 = font_0;
						final IndexData indexdata_7 = SoundTask.configsIndex;
						final IndexData indexdata_8 = AttackOption.indexInterfaces;
						final IndexData indexdata_9 = class37.indexSoundEffects;
						Sequence.seq_ref = indexdata_7;
						Sequence.skel_ref = indexdata_8;
						Sequence.skin_ref = indexdata_9;
						final IndexData indexdata_10 = SoundTask.configsIndex;
						final IndexData indexdata_11 = class21.indexModels;
						Spotanim.SpotAnimationDefinition_indexCache = indexdata_10;
						Spotanim.SpotAnimationDefinition_modelIndexCache = indexdata_11;
						final IndexData indexdata_12 = SoundTask.configsIndex;
						Varbit.varbit_ref = indexdata_12;
						final IndexData indexdata_13 = SoundTask.configsIndex;
						WorldComparator.varplayer_ref = indexdata_13;
						VarPlayerType.field3232 = WorldComparator.varplayer_ref.fileCount(16);
						class11.method100(class224.indexCache3, class21.indexModels, GZipDecompressor.indexSprites,
								class50.indexCache13);
						Timer.method3344(SoundTask.configsIndex);
						final IndexData indexdata_14 = SoundTask.configsIndex;
						Enum.EnumDefinition_indexCache = indexdata_14;
						FaceNormal.method3072(SoundTask.configsIndex);
						final IndexData indexdata_15 = SoundTask.configsIndex;
						VarCString.field3264 = indexdata_15;
						final IndexData indexdata_16 = SoundTask.configsIndex;
						class264.field3327 = indexdata_16;
						MapLabel.varcs = new Varcs();
						class250.method4766(SoundTask.configsIndex, GZipDecompressor.indexSprites,
								class50.indexCache13);
						class144.method3181(SoundTask.configsIndex, GZipDecompressor.indexSprites);
						final IndexData indexdata_17 = SoundTask.configsIndex;
						final IndexData indexdata_18 = GZipDecompressor.indexSprites;
						Area.field3237 = indexdata_18;
						if (indexdata_17.method4629()) {
							Area.field3236 = indexdata_17.fileCount(35);
							Area.mapAreaType = new Area[Area.field3236];

							for (int int_5 = 0; int_5 < Area.field3236; int_5++) {
								final byte[] bytes_0 = indexdata_17.getConfigData(35, int_5);
								if (bytes_0 != null) {
									Area.mapAreaType[int_5] = new Area(int_5);
									Area.mapAreaType[int_5].method4816(new Buffer(bytes_0));
									Area.mapAreaType[int_5].method4828();
								}
							}
						}

						class78.loadingText = "Loaded config";
						class78.loadingBarPercentage = 60;
						Game.loadingStage = 80;
					}
				} else if (Game.loadingStage == 80) {
					int_0 = 0;
					if (WallObject.compass == null) {
						WallObject.compass = class137.method3127(GZipDecompressor.indexSprites, "compass", "");
					} else {
						++int_0;
					}

					if (UrlRequest.mapedge == null) {
						UrlRequest.mapedge = class137.method3127(GZipDecompressor.indexSprites, "mapedge", "");
					} else {
						++int_0;
					}

					if (class25.mapscene == null) {
						class25.mapscene = class13.getIndexedSprites(GZipDecompressor.indexSprites, "mapscene", "");
					} else {
						++int_0;
					}

					if (MilliTimer.headIconsPk == null) {
						MilliTimer.headIconsPk = class21.getSprites(GZipDecompressor.indexSprites, "headicons_pk", "");
						RuinUtils.loadPkIcons();
					} else {
						++int_0;
					}

					if (class43.headIconsPrayer == null) {
						class43.headIconsPrayer = class21.getSprites(GZipDecompressor.indexSprites, "headicons_prayer",
								"");
						RuinUtils.loadPrayerIcons();
					} else {
						++int_0;
					}

					if (MilliTimer.headIconsHint == null) {
						MilliTimer.headIconsHint = class21.getSprites(GZipDecompressor.indexSprites, "headicons_hint",
								"");
					} else {
						++int_0;
					}

					if (TextureProvider.mapMarkers == null) {
						TextureProvider.mapMarkers = class21.getSprites(GZipDecompressor.indexSprites, "mapmarker", "");
					} else {
						++int_0;
					}

					if (class161.crossSprites == null) {
						class161.crossSprites = class21.getSprites(GZipDecompressor.indexSprites, "cross", "");
					} else {
						++int_0;
					}

					if (MapIconReference.mapDots == null) {
						MapIconReference.mapDots = class21.getSprites(GZipDecompressor.indexSprites, "mapdots", "");
					} else {
						++int_0;
					}

					if (BuildType.scrollbarSprites == null) {
						BuildType.scrollbarSprites = class13.getIndexedSprites(GZipDecompressor.indexSprites,
								"scrollbar", "");
					} else {
						++int_0;
					}

					if (JagexLoginType.modIconSprites == null) {
						JagexLoginType.modIconSprites = class13.getIndexedSprites(GZipDecompressor.indexSprites,
								"mod_icons", "");
					} else {
						++int_0;
					}

					if (RuinUtils.customInterSprites == null)
						RuinUtils.loadCustomInterfaceSprites();
					else
						++int_0;

					if (int_0 < 12) {
						class78.loadingText = "Loading sprites - " + ((int_0 * 100) / 12) + "%";
						class78.loadingBarPercentage = 70;
					} else {
						FontTypeFace.modIcons = JagexLoginType.modIconSprites;
						RuinUtils.loadIcons(false);
						UrlRequest.mapedge.method5843();
						int_1 = (int) (Math.random() * 21.0D) - 10;
						int_2 = (int) (Math.random() * 21.0D) - 10;
						int_3 = (int) (Math.random() * 21.0D) - 10;
						int_4 = (int) (Math.random() * 41.0D) - 20;
						class25.mapscene[0].method5822(int_1 + int_4, int_2 + int_4, int_3 + int_4);
						class78.loadingText = "Loaded sprites";
						class78.loadingBarPercentage = 70;
						Game.loadingStage = 90;
					}
				} else if (Game.loadingStage == 90) {
					if (!ObjectComposition.indexTextures.method4629()) {
						class78.loadingText = "Loading textures - " + "0%";
						class78.loadingBarPercentage = 90;
					} else {
						field250 = new TextureProvider(ObjectComposition.indexTextures, GZipDecompressor.indexSprites,
								20, 0.8D, Game.lowMemory ? 64 : 128);
						Graphics3D.method2789(field250);
						Graphics3D.setBrightness(0.8D);
						Game.loadingStage = 100;
					}
				} else if (Game.loadingStage == 100) {
					int_0 = field250.method2530();
					if (int_0 < 100) {
						class78.loadingText = "Loading textures - " + int_0 + "%";
						class78.loadingBarPercentage = 90;
					} else {
						class78.loadingText = "Loaded textures";
						class78.loadingBarPercentage = 90;
						Game.loadingStage = 110;
					}
				} else if (Game.loadingStage == 110) {
					class26.mouseRecorder = new MouseRecorder();
					GameEngine.taskManager.createRunnable(class26.mouseRecorder, 10);
					class78.loadingText = "Loaded input handler";
					class78.loadingBarPercentage = 92;
					Game.loadingStage = 120;
				} else if (Game.loadingStage == 120) {
					if (!MapLabel.indexCache10.tryLoadRecordByNames("huffman", "")) {
						class78.loadingText = "Loading wordpack - " + 0 + "%";
						class78.loadingBarPercentage = 94;
					} else {
						final Huffman huffman_0 = new Huffman(MapLabel.indexCache10.takeRecordByNames("huffman", ""));
						DState.method3529(huffman_0);
						class78.loadingText = "Loaded wordpack";
						class78.loadingBarPercentage = 94;
						Game.loadingStage = 130;
					}
				} else if (Game.loadingStage == 130) {
					if (!class224.indexCache3.method4629()) {
						class78.loadingText = "Loading interfaces - " + ((class224.indexCache3.loadPercent() * 4) / 5)
								+ "%";
						class78.loadingBarPercentage = 96;
					} else if (!Game.indexScripts.method4629()) {
						class78.loadingText = "Loading interfaces - " + (80 + (Game.indexScripts.loadPercent() / 6))
								+ "%";
						class78.loadingBarPercentage = 96;
					} else if (!class50.indexCache13.method4629()) {
						class78.loadingText = "Loading interfaces - " + (96 + (class50.indexCache13.loadPercent() / 50))
								+ "%";
						class78.loadingBarPercentage = 96;
					} else {
						class78.loadingText = "Loaded interfaces";
						class78.loadingBarPercentage = 98;
						Game.loadingStage = 140;
					}
				} else if (Game.loadingStage == 140) {
					class78.loadingBarPercentage = 100;
					if (!class24.indexWorldMap.tryLoadArchiveByName(DETAILS.name)) {
						class78.loadingText = "Loading world map - "
								+ (class24.indexWorldMap.archiveLoadPercentByName(DETAILS.name) / 10) + "%";
					} else {
						if (ItemContainer.renderOverview == null) {
							ItemContainer.renderOverview = new RenderOverview();
							ItemContainer.renderOverview.method6000(class24.indexWorldMap, ClanMemberManager.fontBold12,
									Game.fontsMap, class25.mapscene);
						}

						int_0 = ItemContainer.renderOverview.method6094();
						if (int_0 < 100) {
							class78.loadingText = "Loading world map - " + (((int_0 * 9) / 10) + 10) + "%";
						} else {
							class78.loadingText = "Loaded world map";
							Game.loadingStage = 150;
						}
					}
				} else if (Game.loadingStage == 150) {
					MouseInput.setGameState(10);
				}
			}
		}
	}

	static void method479(final class171 class171_0) {
		final PacketBuffer packetbuffer_0 = Game.field626.packetBuffer;
		int duration;
		int targetIndex;
		int offsetHash;
		byte destX;
		int endHeight;
		int curve;
		int something;
		int destY;
		int int_7;
		int projectileId;
		int startHeight;
		int diffX;
		int int_21;
		if (class171.PROJECTILE == class171_0) {
			duration = packetbuffer_0.readUnsignedShort(); // duration
			targetIndex = packetbuffer_0.readShort(); // targetIndex
			final byte byte_5 = packetbuffer_0.readByte(); // offsetHash
			destX = packetbuffer_0.readByteA(); // destX
			endHeight = packetbuffer_0.readUnsignedByte() * 4;// end height
			curve = packetbuffer_0.readUnsignedByteS(); // curve
			something = packetbuffer_0.readUnsignedByteS(); // something
			destY = packetbuffer_0.readUnsignedByteS(); // destY
			int_7 = ((destY >> 4) & 0x7) + MouseRecorder.mapX;
			int_21 = (destY & 0x7) + Coordinates.mapY;
			projectileId = packetbuffer_0.readUnsignedShortA(); // prjectile
			startHeight = packetbuffer_0.readUnsignedByteA() * 4; // start height
			final int delay = packetbuffer_0.readUnsignedShort(); // delay
			offsetHash = byte_5 + int_7;
			diffX = destX + int_21;
			if ((int_7 >= 0) && (int_21 >= 0) && (int_7 < 104) && (int_21 < 104) && (offsetHash >= 0) && (diffX >= 0)
					&& (offsetHash < 104) && (diffX < 104) && (projectileId != 65535)) {
				int_7 = (int_7 * 128) + 64;
				int_21 = (int_21 * 128) + 64;
				offsetHash = (offsetHash * 128) + 64;
				diffX = (diffX * 128) + 64;
				final Projectile projectile_0 = new Projectile(projectileId, class13.plane, int_7, int_21,
						WorldMapType2.getTileHeight(int_7, int_21, class13.plane) - startHeight, delay + Game.gameCycle,
						duration + Game.gameCycle, curve, something, targetIndex, endHeight);
				projectile_0.moveProjectile(offsetHash, diffX,
						WorldMapType2.getTileHeight(offsetHash, diffX, class13.plane) - endHeight,
						delay + Game.gameCycle);
				Game.projectiles.addFront(projectile_0);
				// System.out.println("Projecile: " + duration + " " + targetIndex + " " +
				// byte_5 + " "+ destX + " " + endHeight + " " + curve + " " + something + " " +
				// destY + " " + projectileId + " " + startHeight + " " + delay);
			}

		} else if (class171.field2243 == class171_0) { // create object
			duration = packetbuffer_0.readUnsignedByteC();
			targetIndex = ((duration >> 4) & 0x7) + MouseRecorder.mapX;
			offsetHash = (duration & 0x7) + Coordinates.mapY;
			diffX = packetbuffer_0.readUnsignedByteS();
			endHeight = diffX >> 2;
			curve = diffX & 0x3;
			something = Game.field846[endHeight];
			destY = packetbuffer_0.readUnsignedShortA();
			if ((targetIndex >= 0) && (offsetHash >= 0) && (targetIndex < 104) && (offsetHash < 104)) {
				class241.method4602(class13.plane, targetIndex, offsetHash, something, destY, endHeight, curve, 0, -1);
			}

		} else if (class171.ANIMATE_OBJECT == class171_0) {
			duration = packetbuffer_0.readUnsignedLEShortA();
			targetIndex = packetbuffer_0.readUnsignedByte();
			offsetHash = targetIndex >> 2;
			diffX = targetIndex & 0x3;
			endHeight = Game.field846[offsetHash];
			curve = packetbuffer_0.readUnsignedByte();
			something = ((curve >> 4) & 0x7) + MouseRecorder.mapX;
			destY = (curve & 0x7) + Coordinates.mapY;
			if ((something >= 0) && (destY >= 0) && (something < 103) && (destY < 103)) {
				if (endHeight == 0) {
					final WallObject wallobject_0 = MapIcon.region.method2894(class13.plane, something, destY);
					if (wallobject_0 != null) {
						int_21 = KeyFocusListener.method673(wallobject_0.field1786);
						if (offsetHash == 2) {
							wallobject_0.renderable1 = new DynamicObject(int_21, 2, diffX + 4, class13.plane, something,
									destY, duration, false, wallobject_0.renderable1);
							wallobject_0.renderable2 = new DynamicObject(int_21, 2, (diffX + 1) & 0x3, class13.plane,
									something, destY, duration, false, wallobject_0.renderable2);
						} else {
							wallobject_0.renderable1 = new DynamicObject(int_21, offsetHash, diffX, class13.plane,
									something, destY, duration, false, wallobject_0.renderable1);
						}
					}
				}

				if (endHeight == 1) {
					final DecorativeObject decorativeobject_0 = MapIcon.region.method2895(class13.plane, something,
							destY);
					if (decorativeobject_0 != null) {
						int_21 = KeyFocusListener.method673(decorativeobject_0.field1824);
						if ((offsetHash != 4) && (offsetHash != 5)) {
							if (offsetHash == 6) {
								decorativeobject_0.field1823 = new DynamicObject(int_21, 4, diffX + 4, class13.plane,
										something, destY, duration, false, decorativeobject_0.field1823);
							} else if (offsetHash == 7) {
								decorativeobject_0.field1823 = new DynamicObject(int_21, 4, ((diffX + 2) & 0x3) + 4,
										class13.plane, something, destY, duration, false, decorativeobject_0.field1823);
							} else if (offsetHash == 8) {
								decorativeobject_0.field1823 = new DynamicObject(int_21, 4, diffX + 4, class13.plane,
										something, destY, duration, false, decorativeobject_0.field1823);
								decorativeobject_0.renderable2 = new DynamicObject(int_21, 4, ((diffX + 2) & 0x3) + 4,
										class13.plane, something, destY, duration, false,
										decorativeobject_0.renderable2);
							}
						} else {
							decorativeobject_0.field1823 = new DynamicObject(int_21, 4, diffX, class13.plane, something,
									destY, duration, false, decorativeobject_0.field1823);
						}
					}
				}

				if (endHeight == 2) {
					final GameObject gameobject_0 = MapIcon.region.method2896(class13.plane, something, destY);
					if (offsetHash == 11) {
						offsetHash = 10;
					}

					if (gameobject_0 != null) {
						gameobject_0.renderable = new DynamicObject(KeyFocusListener.method673(gameobject_0.field1848),
								offsetHash, diffX, class13.plane, something, destY, duration, false,
								gameobject_0.renderable);
					}
				}

				if (endHeight == 3) {
					final GroundObject groundobject_0 = MapIcon.region.getFloorDecoration(class13.plane, something,
							destY);
					if (groundobject_0 != null) {
						groundobject_0.renderable = new DynamicObject(
								KeyFocusListener.method673(groundobject_0.field1526), 22, diffX, class13.plane,
								something, destY, duration, false, groundobject_0.renderable);
					}
				}
			}

		} else if (class171.GRAPHIC == class171_0) {
			duration = packetbuffer_0.readUnsignedShort();
			targetIndex = packetbuffer_0.readUnsignedShort();
			offsetHash = packetbuffer_0.readUnsignedByteS();
			diffX = ((offsetHash >> 4) & 0x7) + MouseRecorder.mapX;
			endHeight = (offsetHash & 0x7) + Coordinates.mapY;
			curve = packetbuffer_0.readUnsignedByte();
			if ((diffX >= 0) && (endHeight >= 0) && (diffX < 104) && (endHeight < 104)) {
				diffX = (diffX * 128) + 64;
				endHeight = (endHeight * 128) + 64;
				final GraphicsObject graphicsobject_0 = new GraphicsObject(duration, class13.plane, diffX, endHeight,
						WorldMapType2.getTileHeight(diffX, endHeight, class13.plane) - curve, targetIndex,
						Game.gameCycle);
				Game.graphicsObjectDeque.addFront(graphicsobject_0);
			}

		} else {
			Item item_0;
			if (class171.ADD_GROUND_ITEM == class171_0) {
				duration = packetbuffer_0.readUnsignedByteS();
				targetIndex = ((duration >> 4) & 0x7) + MouseRecorder.mapX;
				offsetHash = (duration & 0x7) + Coordinates.mapY;
				diffX = packetbuffer_0.readUnsignedShortA();
				endHeight = packetbuffer_0.readUnsignedLEShort();
				if ((targetIndex >= 0) && (offsetHash >= 0) && (targetIndex < 104) && (offsetHash < 104)) {
					item_0 = new Item();
					item_0.id = diffX;
					item_0.quantity = endHeight;
					if (Game.groundItemDeque[class13.plane][targetIndex][offsetHash] == null) {
						Game.groundItemDeque[class13.plane][targetIndex][offsetHash] = new Deque();
					}

					Game.groundItemDeque[class13.plane][targetIndex][offsetHash].addFront(item_0);
					InvType.groundItemSpawned(targetIndex, offsetHash);
				}

			} else if (class171.field2247 == class171_0) { // remove object
				duration = packetbuffer_0.readUnsignedByte();
				targetIndex = duration >> 2;
				offsetHash = duration & 0x3;
				diffX = Game.field846[targetIndex];
				endHeight = packetbuffer_0.readUnsignedByteS();
				curve = ((endHeight >> 4) & 0x7) + MouseRecorder.mapX;
				something = (endHeight & 0x7) + Coordinates.mapY;
				if ((curve >= 0) && (something >= 0) && (curve < 104) && (something < 104)) {
					class241.method4602(class13.plane, curve, something, diffX, -1, targetIndex, offsetHash, 0, -1);
				}

			} else if (class171.REMOVE_GROUND_ITEM == class171_0) {
				duration = packetbuffer_0.readUnsignedLEShortA();
				targetIndex = packetbuffer_0.readUnsignedByteA();
				offsetHash = ((targetIndex >> 4) & 0x7) + MouseRecorder.mapX;
				diffX = (targetIndex & 0x7) + Coordinates.mapY;
				if ((offsetHash >= 0) && (diffX >= 0) && (offsetHash < 104) && (diffX < 104)) {
					final Deque deque_1 = Game.groundItemDeque[class13.plane][offsetHash][diffX];
					if (deque_1 != null) {
						for (item_0 = (Item) deque_1.getFront(); item_0 != null; item_0 = (Item) deque_1.getNext()) {
							if ((duration & 0x7FFF) == item_0.id) {
								item_0.unlink();
								break;
							}
						}

						if (deque_1.getFront() == null) {
							Game.groundItemDeque[class13.plane][offsetHash][diffX] = null;
						}

						InvType.groundItemSpawned(offsetHash, diffX);
					}
				}

			} else {
				if (class171.field2245 == class171_0) {
					duration = packetbuffer_0.readUnsignedByteC();
					targetIndex = ((duration >> 4) & 0x7) + MouseRecorder.mapX;
					offsetHash = (duration & 0x7) + Coordinates.mapY;
					destX = packetbuffer_0.readByte();
					endHeight = packetbuffer_0.readUnsignedShort();
					curve = packetbuffer_0.readUnsignedByteC();
					something = curve >> 2;
					destY = curve & 0x3;
					int_7 = Game.field846[something];
					byte byte_1 = packetbuffer_0.readByte();
					projectileId = packetbuffer_0.readUnsignedShort();
					startHeight = packetbuffer_0.readUnsignedLEShort();
					byte byte_2 = packetbuffer_0.readByteS();
					final int int_10 = packetbuffer_0.readUnsignedShortA();
					byte byte_3 = packetbuffer_0.readByteA();
					Player player_0;
					if (int_10 == Game.localInteractingIndex) {
						player_0 = class138.localPlayer;
					} else {
						player_0 = Game.cachedPlayers[int_10];
					}

					if (player_0 != null) {
						final ObjectComposition objectcomposition_0 = FileOnDisk.getObjectDefinition(endHeight);
						int int_11;
						int int_12;
						if ((destY != 1) && (destY != 3)) {
							int_11 = objectcomposition_0.width;
							int_12 = objectcomposition_0.length;
						} else {
							int_11 = objectcomposition_0.length;
							int_12 = objectcomposition_0.width;
						}

						final int int_13 = targetIndex + (int_11 >> 1);
						final int int_14 = targetIndex + ((int_11 + 1) >> 1);
						final int int_15 = offsetHash + (int_12 >> 1);
						final int int_16 = offsetHash + ((int_12 + 1) >> 1);
						final int[][] ints_0 = class50.tileHeights[class13.plane];
						final int int_17 = (ints_0[int_14][int_16] + ints_0[int_13][int_15] + ints_0[int_14][int_15]
								+ ints_0[int_13][int_16]) >> 2;
						final int int_18 = (targetIndex << 7) + (int_11 << 6);
						final int int_19 = (offsetHash << 7) + (int_12 << 6);
						final Model model_0 = objectcomposition_0.method5031(something, destY, ints_0, int_18, int_17,
								int_19);
						if (model_0 != null) {
							class241.method4602(class13.plane, targetIndex, offsetHash, int_7, -1, 0, 0,
									projectileId + 1, startHeight + 1);
							player_0.animationCycleStart = projectileId + Game.gameCycle;
							player_0.animationCycleEnd = startHeight + Game.gameCycle;
							player_0.model = model_0;
							player_0.field556 = (targetIndex * 128) + (int_11 * 64);
							player_0.field558 = (offsetHash * 128) + (int_12 * 64);
							player_0.field557 = int_17;
							byte byte_4;
							if (byte_2 > destX) {
								byte_4 = byte_2;
								byte_2 = destX;
								destX = byte_4;
							}

							if (byte_3 > byte_1) {
								byte_4 = byte_3;
								byte_3 = byte_1;
								byte_1 = byte_4;
							}

							player_0.field559 = byte_2 + targetIndex;
							player_0.field565 = destX + targetIndex;
							player_0.field547 = byte_3 + offsetHash;
							player_0.field553 = offsetHash + byte_1;
						}
					}
				}

				if (class171.SEND_AREA_SOUND == class171_0) {
					duration = packetbuffer_0.readUnsignedByteC();
					targetIndex = packetbuffer_0.readUnsignedByte();
					offsetHash = (targetIndex >> 4) & 0xF;
					diffX = targetIndex & 0x7;
					endHeight = packetbuffer_0.readUnsignedByteC();
					curve = ((endHeight >> 4) & 0x7) + MouseRecorder.mapX;
					something = (endHeight & 0x7) + Coordinates.mapY;
					destY = packetbuffer_0.readUnsignedLEShortA();
					if ((curve >= 0) && (something >= 0) && (curve < 104) && (something < 104)) {
						int_7 = offsetHash + 1;
						if ((class138.localPlayer.pathX[0] >= (curve - int_7))
								&& (class138.localPlayer.pathX[0] <= (curve + int_7))
								&& (class138.localPlayer.pathY[0] >= (something - int_7))
								&& (class138.localPlayer.pathY[0] <= (int_7 + something)) && (Game.field815 != 0)
								&& (diffX > 0) && (Game.queuedSoundEffectCount < 50)) {
							Game.queuedSoundEffectIDs[Game.queuedSoundEffectCount] = destY;
							Game.unknownSoundValues1[Game.queuedSoundEffectCount] = diffX;
							Game.unknownSoundValues2[Game.queuedSoundEffectCount] = duration;
							Game.audioEffects[Game.queuedSoundEffectCount] = null;
							Game.soundLocations[Game.queuedSoundEffectCount] = offsetHash + (something << 8)
									+ (curve << 16);
							++Game.queuedSoundEffectCount;
						}
					}
				}

				if (class171.field2244 == class171_0) {
					duration = packetbuffer_0.readUnsignedByte();
					targetIndex = ((duration >> 4) & 0x7) + MouseRecorder.mapX;
					offsetHash = (duration & 0x7) + Coordinates.mapY;
					diffX = packetbuffer_0.readUnsignedShortA();
					endHeight = packetbuffer_0.readUnsignedShortA();
					curve = packetbuffer_0.readUnsignedLEShortA();
					if ((targetIndex >= 0) && (offsetHash >= 0) && (targetIndex < 104) && (offsetHash < 104)) {
						final Deque deque_0 = Game.groundItemDeque[class13.plane][targetIndex][offsetHash];
						if (deque_0 != null) {
							for (Item item_1 = (Item) deque_0.getFront(); item_1 != null; item_1 = (Item) deque_0
									.getNext()) {
								if (((endHeight & 0x7FFF) == item_1.id) && (curve == item_1.quantity)) {
									item_1.quantity = diffX;
									break;
								}
							}

							InvType.groundItemSpawned(targetIndex, offsetHash);
						}
					}

				}
			}
		}
	}

}
