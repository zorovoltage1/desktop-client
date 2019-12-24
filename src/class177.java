import java.io.File;
import java.io.IOException;

public class class177 {

	public static IndexDataBase indices;
	static int field2283;
	public static Track1 track;

	public static void method3509(final String string_0, final String string_1, final int int_0, final int int_1)
			throws IOException {
		class148.idxCount = int_1;
		class141.field1885 = int_0;

		try {
			class229.osName = System.getProperty("os.name");
		} catch (final Exception exception_0) {
			class229.osName = "Unknown";
		}

		ContextMenuRow.osNameLC = class229.osName.toLowerCase();

		try {
			WorldMapType1.userHome = System.getProperty("user.home");
			if (WorldMapType1.userHome != null) {
				WorldMapType1.userHome = WorldMapType1.userHome + "/";
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}

		try {
			if (ContextMenuRow.osNameLC.startsWith("win")) {
				if (WorldMapType1.userHome == null) {
					WorldMapType1.userHome = System.getenv("USERPROFILE");
				}
			} else if (WorldMapType1.userHome == null) {
				WorldMapType1.userHome = System.getenv("HOME");
			}

			if (WorldMapType1.userHome != null) {
				WorldMapType1.userHome = WorldMapType1.userHome + "/";
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}

		if (WorldMapType1.userHome == null) {
			WorldMapType1.userHome = "~/";
		}

		class155.cacheLocations = new String[] { "c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/",
				WorldMapType1.userHome, "/tmp/", "" };
		class8.field52 = new String[] { ".jagex_cache_" + class141.field1885, ".file_store_" + class141.field1885 };
		int int_2 = 0;

		label92: while (int_2 < 4) {
			class155.field1966 = World.method1583(string_0, string_1, int_2);
			if (!class155.field1966.exists()) {
				class155.field1966.mkdirs();
			}

			final File[] files_0 = class155.field1966.listFiles();
			if (files_0 == null) {
				break;
			}

			final File[] files_1 = files_0;
			int int_3 = 0;

			while (true) {
				if (int_3 >= files_1.length) {
					break label92;
				}

				final File file_1 = files_1[int_3];
				if (!GraphicsObject.method1766(file_1, false)) {
					++int_2;
					break;
				}

				++int_3;
			}
		}

		final File file_0 = class155.field1966;
		class158.field1974 = file_0;
		if (!class158.field1974.exists()) {
			throw new RuntimeException("");
		} else {
			class158.field1979 = true;
			MapCacheArchiveNames.method476();
			class155.dat2File = new CacheFile(
					new FileOnDisk(class151.method3238("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
			class155.idx255File = new CacheFile(
					new FileOnDisk(class151.method3238("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
			class76.idxFiles = new CacheFile[class148.idxCount];

			for (int int_4 = 0; int_4 < class148.idxCount; int_4++) {
				class76.idxFiles[int_4] = new CacheFile(
						new FileOnDisk(class151.method3238("main_file_cache.idx" + int_4), "rw", 1048576L), 6000, 0);
			}

		}
	}

	static void method3512(final PacketBuffer packetbuffer_0) {
		int int_0 = 0;
		packetbuffer_0.bitAccess();

		int int_1;
		int int_2;
		int int_3;
		for (int_1 = 0; int_1 < class81.playerIndexesCount; int_1++) {
			int_2 = class81.playerIndices[int_1];
			if ((class81.field1156[int_2] & 0x1) == 0) {
				if (int_0 > 0) {
					--int_0;
					class81.field1156[int_2] = (byte) (class81.field1156[int_2] | 0x2);
				} else {
					int_3 = packetbuffer_0.getBits(1);
					if (int_3 == 0) {
						int_0 = ServerPacket.method3445(packetbuffer_0);
						class81.field1156[int_2] = (byte) (class81.field1156[int_2] | 0x2);
					} else {
						class6.decodeMovement(packetbuffer_0, int_2);
					}
				}
			}
		}

		packetbuffer_0.byteAccess();
		if (int_0 != 0) {
			throw new RuntimeException();
		} else {
			packetbuffer_0.bitAccess();

			for (int_1 = 0; int_1 < class81.playerIndexesCount; int_1++) {
				int_2 = class81.playerIndices[int_1];
				if ((class81.field1156[int_2] & 0x1) != 0) {
					if (int_0 > 0) {
						--int_0;
						class81.field1156[int_2] = (byte) (class81.field1156[int_2] | 0x2);
					} else {
						int_3 = packetbuffer_0.getBits(1);
						if (int_3 == 0) {
							int_0 = ServerPacket.method3445(packetbuffer_0);
							class81.field1156[int_2] = (byte) (class81.field1156[int_2] | 0x2);
						} else {
							class6.decodeMovement(packetbuffer_0, int_2);
						}
					}
				}
			}

			packetbuffer_0.byteAccess();
			if (int_0 != 0) {
				throw new RuntimeException();
			} else {
				packetbuffer_0.bitAccess();

				for (int_1 = 0; int_1 < class81.field1160; int_1++) {
					int_2 = class81.field1161[int_1];
					if ((class81.field1156[int_2] & 0x1) != 0) {
						if (int_0 > 0) {
							--int_0;
							class81.field1156[int_2] = (byte) (class81.field1156[int_2] | 0x2);
						} else {
							int_3 = packetbuffer_0.getBits(1);
							if (int_3 == 0) {
								int_0 = ServerPacket.method3445(packetbuffer_0);
								class81.field1156[int_2] = (byte) (class81.field1156[int_2] | 0x2);
							} else if (class240.decodeRegionHash(packetbuffer_0, int_2)) {
								class81.field1156[int_2] = (byte) (class81.field1156[int_2] | 0x2);
							}
						}
					}
				}

				packetbuffer_0.byteAccess();
				if (int_0 != 0) {
					throw new RuntimeException();
				} else {
					packetbuffer_0.bitAccess();

					for (int_1 = 0; int_1 < class81.field1160; int_1++) {
						int_2 = class81.field1161[int_1];
						if ((class81.field1156[int_2] & 0x1) == 0) {
							if (int_0 > 0) {
								--int_0;
								class81.field1156[int_2] = (byte) (class81.field1156[int_2] | 0x2);
							} else {
								int_3 = packetbuffer_0.getBits(1);
								if (int_3 == 0) {
									int_0 = ServerPacket.method3445(packetbuffer_0);
									class81.field1156[int_2] = (byte) (class81.field1156[int_2] | 0x2);
								} else if (class240.decodeRegionHash(packetbuffer_0, int_2)) {
									class81.field1156[int_2] = (byte) (class81.field1156[int_2] | 0x2);
								}
							}
						}
					}

					packetbuffer_0.byteAccess();
					if (int_0 != 0) {
						throw new RuntimeException();
					} else {
						class81.playerIndexesCount = 0;
						class81.field1160 = 0;

						for (int_1 = 1; int_1 < 2048; int_1++) {
							class81.field1156[int_1] = (byte) (class81.field1156[int_1] >> 1);
							final Player player_0 = Game.cachedPlayers[int_1];
							if (player_0 != null) {
								class81.playerIndices[++class81.playerIndexesCount - 1] = int_1;
							} else {
								class81.field1161[++class81.field1160 - 1] = int_1;
							}
						}

					}
				}
			}
		}
	}

	static void method3510(final int int_0, final int int_1, final int int_2, final int int_3) {
		for (int int_4 = int_1; int_4 <= (int_3 + int_1); int_4++) {
			for (int int_5 = int_0; int_5 <= (int_0 + int_2); int_5++) {
				if ((int_5 >= 0) && (int_5 < 104) && (int_4 >= 0) && (int_4 < 104)) {
					class50.field447[0][int_5][int_4] = 127;
					if ((int_0 == int_5) && (int_5 > 0)) {
						class50.tileHeights[0][int_5][int_4] = class50.tileHeights[0][int_5 - 1][int_4];
					}

					if ((int_5 == (int_0 + int_2)) && (int_5 < 103)) {
						class50.tileHeights[0][int_5][int_4] = class50.tileHeights[0][int_5 + 1][int_4];
					}

					if ((int_4 == int_1) && (int_4 > 0)) {
						class50.tileHeights[0][int_5][int_4] = class50.tileHeights[0][int_5][int_4 - 1];
					}

					if (((int_3 + int_1) == int_4) && (int_4 < 103)) {
						class50.tileHeights[0][int_5][int_4] = class50.tileHeights[0][int_5][int_4 + 1];
					}
				}
			}
		}

	}

	static void method3507(final int int_0) {
		final ItemContainer itemcontainer_0 = (ItemContainer) ItemContainer.itemContainers.get(int_0);
		if (itemcontainer_0 != null) {
			itemcontainer_0.unlink();
		}
	}

	static void method3513() {
		Region.regionLowMemory = false;
		Game.lowMemory = false;
	}

	static void method3508(final String string_0) {
		if (WorldMapType3.clanMemberManager != null) {
			final PacketNode packetnode_0 = class26.method433(ClientPacket.field2174, Game.field626.field1218);
			packetnode_0.packetBuffer.putByte(class316.getLength(string_0));
			packetnode_0.packetBuffer.putString(string_0);
			Game.field626.method1980(packetnode_0);
		}
	}

}
