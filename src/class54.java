public class class54
{

	static boolean field489;
	static String host;

	static void method1021(final int int_0, final int int_1)
	{
		final long long_0 = (int_0 << 16) + int_1;
		final FileRequest filerequest_0 = (FileRequest) class250.NetCache_pendingWrites.get(long_0);
		if (filerequest_0 != null)
		{
			class250.NetCache_pendingWritesQueue.setHead(filerequest_0);
		}
	}

	static void method1018()
	{
		FileOnDisk fileondisk_0 = null;

		try
		{
			fileondisk_0 = MapLabel.getPreferencesFile("", ItemLayer.field1455.name, true);
			final Buffer buffer_0 = class10.preferences.serialize();
			fileondisk_0.write(buffer_0.payload, 0, buffer_0.offset);
		}
		catch (final Exception exception_0)
		{
        }

		try
		{
			if (fileondisk_0 != null)
			{
				fileondisk_0.closeSync(true);
			}
		}
		catch (final Exception exception_1)
		{
        }

	}

	static void clear()
	{
		class43.method715();
		FloorUnderlayDefinition.underlays.reset();
		KitDefinition.identKits.reset();
		TotalQuantityComparator.method34();
		NPCComposition.npcs.reset();
		NPCComposition.npcModelCache.reset();
		MouseRecorder.method1036();
		Sequence.sequences.reset();
		Sequence.skeletons.reset();
		Spotanim.spotanims.reset();
		Spotanim.SpotAnimationDefinition_cachedModels.reset();
		Varbit.varbits.reset();
		VarPlayerType.varplayers.reset();
		class267.field3349.reset();
		class267.field3356.reset();
		class267.field3351.reset();
		CombatInfo2.field3305.reset();
		CombatInfo2.field3306.reset();
		class265.field3334.reset();
		class264.field3328.reset();
		ServerPacket.method3444();
		class192.method3871();
		class68.method1698();
		((TextureProvider) Graphics3D.textureLoader).reset();
		Script.field1190.reset();
		AttackOption.indexInterfaces.reset();
		class37.indexSoundEffects.reset();
		class224.indexCache3.reset();
		UrlRequester.indexCache4.reset();
		FileRequest.indexMaps.reset();
		Item.indexTrack1.reset();
		class21.indexModels.reset();
		GZipDecompressor.indexSprites.reset();
		ObjectComposition.indexTextures.reset();
		MapLabel.indexCache10.reset();
		OwnWorldComparator.indexTrack2.reset();
		Game.indexScripts.reset();
	}

	static void method1017()
	{
		if (Actor.soundSystem1 != null)
		{
			Actor.soundSystem1.method2144();
		}

		if (MapIcon.soundSystem0 != null)
		{
			MapIcon.soundSystem0.method2144();
		}

	}

	static void method1019()
	{
		if ((Game.field707 >= 0) && (Game.cachedPlayers[Game.field707] != null))
		{
			class11.method98(Game.cachedPlayers[Game.field707], false);
		}

	}

}
