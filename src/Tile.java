public final class Tile extends Node
{

	int renderLevel;
	int plane;
	int x;
	int y;
	SceneTilePaint paint;
	SceneTileModel overlay;
	WallObject wallObject;
	DecorativeObject decorativeObject;
	GroundObject groundObject;
	ItemLayer itemLayer;
	int entityCount;
	GameObject[] objects;
	int[] entityFlags;
	int flags;
	int physicalLevel;
	boolean draw;
	boolean visible;
	boolean drawEntities;
	int wallCullDirection;
	int wallUncullDirection;
	int wallCullOppositeDirection;
	int wallDrawFlags;
	Tile bridge;

	Tile(final int int_0, final int int_1, final int int_2)
	{
		objects = new GameObject[5];
		entityFlags = new int[5];
		flags = 0;
		renderLevel = plane = int_0;
		x = int_1;
		y = int_2;
	}

}
