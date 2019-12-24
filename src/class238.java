public class class238
{

	static void worldToScreen(int int_0, int int_1, final int int_2)
	{
		if ((int_0 >= 128) && (int_1 >= 128) && (int_0 <= 13056) && (int_1 <= 13056))
		{
			int int_3 = WorldMapType2.getTileHeight(int_0, int_1, class13.plane) - int_2;
			int_0 -= CacheFile.cameraX;
			int_3 -= SceneTilePaint.cameraZ;
			int_1 -= Coordinates.cameraY;
			final int int_4 = Graphics3D.SINE[class7.cameraPitch];
			final int int_5 = Graphics3D.COSINE[class7.cameraPitch];
			final int int_6 = Graphics3D.SINE[DynamicObject.cameraYaw];
			final int int_7 = Graphics3D.COSINE[DynamicObject.cameraYaw];
			int int_8 = ((int_6 * int_1) + (int_0 * int_7)) >> 16;
			int_1 = ((int_7 * int_1) - (int_0 * int_6)) >> 16;
			int_0 = int_8;
			int_8 = ((int_5 * int_3) - (int_4 * int_1)) >> 16;
			int_1 = ((int_3 * int_4) + (int_5 * int_1)) >> 16;
			if (int_1 >= 50)
			{
				Game.screenX = ((int_0 * Game.scale) / int_1) + (Game.viewportWidth / 2);
				Game.screenY = ((int_8 * Game.scale) / int_1) + (Game.viewportHeight / 2);
			}
			else
			{
				Game.screenX = -1;
				Game.screenY = -1;
			}

		}
		else
		{
			Game.screenX = -1;
			Game.screenY = -1;
		}
	}

}
