public final class class305
{

	static int indexedSpriteWidth;
	static int[] floorSaturations;

	static IndexedSprite method5658()
	{
		final IndexedSprite indexedsprite_0 = new IndexedSprite();
		indexedsprite_0.originalWidth = indexedSpriteWidth;
		indexedsprite_0.originalHeight = class319.indexedSpriteHeight;
		indexedsprite_0.offsetX = class7.indexedSpriteOffsetXs[0];
		indexedsprite_0.offsetY = class225.indexedSpriteOffsetYs[0];
		indexedsprite_0.width = class319.indexSpriteWidths[0];
		indexedsprite_0.height = class319.indexedSpriteHeights[0];
		indexedsprite_0.palette = PacketNode.indexedSpritePalette;
		indexedsprite_0.pixels = class319.spritePixels[0];
		class7.indexedSpriteOffsetXs = null;
		class225.indexedSpriteOffsetYs = null;
		class319.indexSpriteWidths = null;
		class319.indexedSpriteHeights = null;
		PacketNode.indexedSpritePalette = null;
		class319.spritePixels = null;
		return indexedsprite_0;
	}

	static int method5659(int int_0, final Script script_0, final boolean bool_0)
	{
		Widget widget_0;
		if (int_0 >= 2000)
		{
			int_0 -= 1000;
			widget_0 = Widget.getWidget(class69.intStack[--class69.intStackSize]);
		}
		else
		{
			widget_0 = bool_0 ? class276.field3561 : KitDefinition.field3301;
		}

		if (int_0 == 1927)
		{
			if (class69.field1009 >= 10)
			{
				throw new RuntimeException();
			}
			else if (widget_0.onResizeListener == null)
			{
				return 0;
			}
			else
			{
				final ScriptEvent scriptevent_0 = new ScriptEvent();
				scriptevent_0.widget = widget_0;
				scriptevent_0.objs = widget_0.onResizeListener;
				scriptevent_0.field514 = class69.field1009 + 1;
				Game.field638.addFront(scriptevent_0);
				return 1;
			}
		}
		else
		{
			return 2;
		}
	}

}
