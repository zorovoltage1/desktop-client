public class DynamicObject extends Renderable
{

	static int cameraYaw;
	int id;
	int type;
	int orientation;
	int level;
	int sceneX;
	int sceneY;
	Sequence field1202;
	int animFrame;
	int animCycleCount;

	DynamicObject(final int int_0, final int int_1, final int int_2, final int int_3, final int int_4, final int int_5,
	        final int int_6, final boolean bool_0, final Renderable renderable_0)
	{
		id = int_0;
		type = int_1;
		orientation = int_2;
		level = int_3;
		sceneX = int_4;
		sceneY = int_5;
		if (int_6 != -1)
		{
			field1202 = TotalQuantityComparator.getAnimation(int_6);
			animFrame = 0;
			animCycleCount = Game.gameCycle - 1;
			if ((field1202.replyMode == 0) && (renderable_0 != null) && (renderable_0 instanceof DynamicObject))
			{
				final DynamicObject dynamicobject_1 = (DynamicObject) renderable_0;
				if (field1202 == dynamicobject_1.field1202)
				{
					animFrame = dynamicobject_1.animFrame;
					animCycleCount = dynamicobject_1.animCycleCount;
					return;
				}
			}

			if (bool_0 && (field1202.frameStep != -1))
			{
				animFrame = (int) (Math.random() * field1202.frameIDs.length);
				animCycleCount -= (int) (Math.random() * field1202.frameLengths[animFrame]);
			}
		}

	}

	@Override
	protected Model getModel()
	{
		if (field1202 != null)
		{
			int int_0 = Game.gameCycle - animCycleCount;
			if ((int_0 > 100) && (field1202.frameStep > 0))
			{
				int_0 = 100;
			}

			label55:
			{
				do
				{
					do
					{
						if (int_0 <= field1202.frameLengths[animFrame])
						{
							break label55;
						}

						int_0 -= field1202.frameLengths[animFrame];
						++animFrame;
					}
					while (animFrame < field1202.frameIDs.length);

					animFrame -= field1202.frameStep;
				}
				while ((animFrame >= 0) && (animFrame < field1202.frameIDs.length));

				field1202 = null;
			}

			animCycleCount = Game.gameCycle - int_0;
		}

		ObjectComposition objectcomposition_0 = FileOnDisk.getObjectDefinition(id);
		if (objectcomposition_0.impostorIds != null)
		{
			objectcomposition_0 = objectcomposition_0.getImpostor();
		}

		if (objectcomposition_0 == null)
		{
			return null;
		}
		else
		{
			int int_1;
			int int_2;
			if ((orientation != 1) && (orientation != 3))
			{
				int_1 = objectcomposition_0.width;
				int_2 = objectcomposition_0.length;
			}
			else
			{
				int_1 = objectcomposition_0.length;
				int_2 = objectcomposition_0.width;
			}

			final int int_3 = (int_1 >> 1) + sceneX;
			final int int_4 = ((int_1 + 1) >> 1) + sceneX;
			final int int_5 = (int_2 >> 1) + sceneY;
			final int int_6 = ((int_2 + 1) >> 1) + sceneY;
			final int[][] ints_0 = class50.tileHeights[level];
			final int int_7 = (ints_0[int_4][int_6] + ints_0[int_3][int_6] + ints_0[int_4][int_5]
			        + ints_0[int_3][int_5]) >> 2;
			final int int_8 = (sceneX << 7) + (int_1 << 6);
			final int int_9 = (sceneY << 7) + (int_2 << 6);
			return objectcomposition_0.method5032(type, orientation, ints_0, int_8, int_7, int_9, field1202, animFrame);
		}
	}

	static void method1962()
	{
		int int_0;
		int int_1;
		int int_2;
		int int_3;
		int int_4;
		int int_5;
		if (Game.field655 == 0)
		{
			int_0 = class138.localPlayer.x;
			int_1 = class138.localPlayer.y;
			if (((CacheFile.field1428 - int_0) < -500) || ((CacheFile.field1428 - int_0) > 500)
			        || ((GrandExchangeEvent.field23 - int_1) < -500) || ((GrandExchangeEvent.field23 - int_1) > 500))
			{
				CacheFile.field1428 = int_0;
				GrandExchangeEvent.field23 = int_1;
			}

			if (int_0 != CacheFile.field1428)
			{
				CacheFile.field1428 += (int_0 - CacheFile.field1428) / 16;
			}

			if (int_1 != GrandExchangeEvent.field23)
			{
				GrandExchangeEvent.field23 += (int_1 - GrandExchangeEvent.field23) / 16;
			}

			int_2 = CacheFile.field1428 >> 7;
			int_3 = GrandExchangeEvent.field23 >> 7;
			int_4 = WorldMapType2.getTileHeight(CacheFile.field1428, GrandExchangeEvent.field23, class13.plane);
			int_5 = 0;
			int int_6;
			if ((int_2 > 3) && (int_3 > 3) && (int_2 < 100) && (int_3 < 100))
			{
				for (int_6 = int_2 - 4; int_6 <= (int_2 + 4); int_6++)
				{
					for (int int_7 = int_3 - 4; int_7 <= (int_3 + 4); int_7++)
					{
						int int_8 = class13.plane;
						if ((int_8 < 3) && ((class50.tileSettings[1][int_6][int_7] & 0x2) == 2))
						{
							++int_8;
						}

						final int int_9 = int_4 - class50.tileHeights[int_8][int_6][int_7];
						if (int_9 > int_5)
						{
							int_5 = int_9;
						}
					}
				}
			}

			int_6 = int_5 * 192;
			if (int_6 > 98048)
			{
				int_6 = 98048;
			}

			if (int_6 < 32768)
			{
				int_6 = 32768;
			}

			if (int_6 > Game.field738)
			{
				Game.field738 += (int_6 - Game.field738) / 24;
			}
			else if (int_6 < Game.field738)
			{
				Game.field738 += (int_6 - Game.field738) / 80;
			}

			ItemComposition.field3478 = WorldMapType2.getTileHeight(class138.localPlayer.x, class138.localPlayer.y,
			        class13.plane) - Game.field644;
		}
		else if (Game.field655 == 1)
		{
			DState.method3527();
			short short_0 = -1;
			if (KeyFocusListener.keyPressed[33])
			{
				short_0 = 0;
			}
			else if (KeyFocusListener.keyPressed[49])
			{
				short_0 = 1024;
			}

			if (KeyFocusListener.keyPressed[48])
			{
				if (short_0 == 0)
				{
					short_0 = 1792;
				}
				else if (short_0 == 1024)
				{
					short_0 = 1280;
				}
				else
				{
					short_0 = 1536;
				}
			}
			else if (KeyFocusListener.keyPressed[50])
			{
				if (short_0 == 0)
				{
					short_0 = 256;
				}
				else if (short_0 == 1024)
				{
					short_0 = 768;
				}
				else
				{
					short_0 = 512;
				}
			}

			byte byte_0 = 0;
			if (KeyFocusListener.keyPressed[35])
			{
				byte_0 = -1;
			}
			else if (KeyFocusListener.keyPressed[51])
			{
				byte_0 = 1;
			}

			int_2 = 0;
			if ((short_0 >= 0) || (byte_0 != 0))
			{
				int_2 = KeyFocusListener.keyPressed[81] ? Game.field661 : Game.field750;
				int_2 *= 16;
				Game.field613 = short_0;
				Game.field659 = byte_0;
			}

			if (Game.field657 < int_2)
			{
				Game.field657 += int_2 / 8;
				if (Game.field657 > int_2)
				{
					Game.field657 = int_2;
				}
			}
			else if (Game.field657 > int_2)
			{
				Game.field657 = (Game.field657 * 9) / 10;
			}

			if (Game.field657 > 0)
			{
				int_3 = Game.field657 / 16;
				if (Game.field613 >= 0)
				{
					int_0 = (Game.field613 - cameraYaw) & 0x7FF;
					int_4 = Graphics3D.SINE[int_0];
					int_5 = Graphics3D.COSINE[int_0];
					CacheFile.field1428 += (int_4 * int_3) / 65536;
					GrandExchangeEvent.field23 += (int_3 * int_5) / 65536;
				}

				if (Game.field659 != 0)
				{
					ItemComposition.field3478 += int_3 * Game.field659;
					if (ItemComposition.field3478 > 0)
					{
						ItemComposition.field3478 = 0;
					}
				}
			}
			else
			{
				Game.field613 = -1;
				Game.field659 = -1;
			}

			if (KeyFocusListener.keyPressed[13])
			{
				Game.field626.method1980(class26.method433(ClientPacket.field2142, Game.field626.field1218));
				Game.field655 = 0;
			}
		}

		if ((MouseInput.mouseCurrentButton == 4) && InvType.middleMouseMovesCamera)
		{
			int_0 = (MouseInput.mouseLastY * 673804999) - Game.field654;
			Game.field652 = int_0 * 2;
			Game.field654 = (int_0 != -1) && (int_0 != 1)
			        ? ((MouseInput.mouseLastY * 673804999) + Game.field654) / 2
			        : MouseInput.mouseLastY * 673804999;
			int_1 = Game.field653 - MouseInput.mouseLastX;
			Game.field608 = int_1 * 2;
			Game.field653 = (int_1 != -1) && (int_1 != 1) ? (MouseInput.mouseLastX + Game.field653) / 2
			        : MouseInput.mouseLastX;
		}
		else
		{
			if (KeyFocusListener.keyPressed[96])
			{
				Game.field608 += (-24 - Game.field608) / 2;
			}
			else if (KeyFocusListener.keyPressed[97])
			{
				Game.field608 += (24 - Game.field608) / 2;
			}
			else
			{
				Game.field608 /= 2;
			}

			if (KeyFocusListener.keyPressed[98])
			{
				Game.field652 += (12 - Game.field652) / 2;
			}
			else if (KeyFocusListener.keyPressed[99])
			{
				Game.field652 += (-12 - Game.field652) / 2;
			}
			else
			{
				Game.field652 /= 2;
			}

			Game.field654 = MouseInput.mouseLastY * 673804999;
			Game.field653 = MouseInput.mouseLastX;
		}

		Game.mapAngle = ((Game.field608 / 2) + Game.mapAngle) & 0x7FF;
		Game.cameraPitchTarget += Game.field652 / 2;
		if (Game.cameraPitchTarget < 128)
		{
			Game.cameraPitchTarget = 128;
		}

		if (Game.cameraPitchTarget > 383)
		{
			Game.cameraPitchTarget = 383;
		}

	}

}
