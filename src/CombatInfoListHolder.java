import java.awt.Image;

public class CombatInfoListHolder extends Node
{

	static Image field1028;
	CombatInfo2 combatInfo2;
	CombatInfoList combatInfo1;

	CombatInfoListHolder(final CombatInfo2 combatinfo2_0)
	{
		combatInfo1 = new CombatInfoList();
		combatInfo2 = combatinfo2_0;
	}

	void method1772(final int int_0, final int int_1, final int int_2, final int int_3)
	{
		CombatInfo1 combatinfo1_0 = null;
		int int_4 = 0;

		for (CombatInfo1 combatinfo1_1 = (CombatInfo1) combatInfo1
		        .last(); combatinfo1_1 != null; combatinfo1_1 = (CombatInfo1) combatInfo1.previous())
		{
			++int_4;
			if (combatinfo1_1.cycle == int_0)
			{
				combatinfo1_1.set(int_0, int_1, int_2, int_3);
				return;
			}

			if (combatinfo1_1.cycle <= int_0)
			{
				combatinfo1_0 = combatinfo1_1;
			}
		}

		if (combatinfo1_0 == null)
		{
			if (int_4 < 4)
			{
				combatInfo1.addLast(new CombatInfo1(int_0, int_1, int_2, int_3));
			}

		}
		else
		{
			CombatInfoList.method4036(new CombatInfo1(int_0, int_1, int_2, int_3), combatinfo1_0);
			if (int_4 >= 4)
			{
				combatInfo1.last().unlink();
			}

		}
	}

	CombatInfo1 method1773(final int int_0)
	{
		CombatInfo1 combatinfo1_0 = (CombatInfo1) combatInfo1.last();
		if ((combatinfo1_0 != null) && (combatinfo1_0.cycle <= int_0))
		{
			for (CombatInfo1 combatinfo1_1 = (CombatInfo1) combatInfo1.previous(); (combatinfo1_1 != null)
			        && (combatinfo1_1.cycle <= int_0); combatinfo1_1 = (CombatInfo1) combatInfo1.previous())
			{
				combatinfo1_0.unlink();
				combatinfo1_0 = combatinfo1_1;
			}

			if ((combatInfo2.field3313 + combatinfo1_0.cycle + combatinfo1_0.int2) > int_0)
			{
				return combatinfo1_0;
			}
			else
			{
				combatinfo1_0.unlink();
				return null;
			}
		}
		else
		{
			return null;
		}
	}

	boolean method1774()
	{
		return combatInfo1.isEmpty();
	}

	static SpritePixels method1781()
	{
		final SpritePixels spritepixels_0 = new SpritePixels();
		spritepixels_0.maxWidth = class305.indexedSpriteWidth;
		spritepixels_0.maxHeight = class319.indexedSpriteHeight;
		spritepixels_0.offsetX = class7.indexedSpriteOffsetXs[0];
		spritepixels_0.offsetY = class225.indexedSpriteOffsetYs[0];
		spritepixels_0.width = class319.indexSpriteWidths[0];
		spritepixels_0.height = class319.indexedSpriteHeights[0];
		final int int_0 = spritepixels_0.height * spritepixels_0.width;
		final byte[] bytes_0 = class319.spritePixels[0];
		spritepixels_0.pixels = new int[int_0];

		for (int int_1 = 0; int_1 < int_0; int_1++)
		{
			spritepixels_0.pixels[int_1] = PacketNode.indexedSpritePalette[bytes_0[int_1] & 0xFF];
		}

		class7.indexedSpriteOffsetXs = null;
		class225.indexedSpriteOffsetYs = null;
		class319.indexSpriteWidths = null;
		class319.indexedSpriteHeights = null;
		PacketNode.indexedSpritePalette = null;
		class319.spritePixels = null;
		return spritepixels_0;
	}

}
