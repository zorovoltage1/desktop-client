import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;

public class MessageNode extends CacheableNode
{

	int id;
	int tick;
	int type;
	String name;
	Name field534;
	class289 field539;
	class289 field536;
	String sender;
	String value;

	MessageNode(final int int_0, final String string_0, final String string_1, final String string_2)
	{
		field539 = class289.field3633;
		field536 = class289.field3633;
		final int int_1 = ++class83.field1186 - 1;
		id = int_1;
		tick = Game.gameCycle;
		type = int_0;
		name = string_0;
		method1044();
		sender = string_1;
		value = string_2;
	}

	void setMessage(final int int_0, final String string_0, final String string_1, final String string_2)
	{
		final int int_1 = ++class83.field1186 - 1;
		id = int_1;
		tick = Game.gameCycle;
		type = int_0;
		name = string_0;
		method1044();
		sender = string_1;
		value = string_2;
	}

	void method1048()
	{
		field539 = class289.field3633;
	}

	boolean method1040()
	{
		if (field539 == class289.field3633)
		{
			method1041();
		}

		return field539 == class289.field3631;
	}

	void method1041()
	{
		field539 = DState.friendManager.field970.isMember(field534) ? class289.field3631 : class289.field3634;
	}

	void method1042()
	{
		field536 = class289.field3633;
	}

	boolean method1043()
	{
		if (field536 == class289.field3633)
		{
			method1061();
		}

		return field536 == class289.field3631;
	}

	void method1061()
	{
		field536 = DState.friendManager.field975.isMember(field534) ? class289.field3631 : class289.field3634;
	}

	void method1044()
	{
		if (name != null)
		{
			field534 = new Name(class139.method3138(name), MapIconReference.loginType);
		}
		else
		{
			field534 = null;
		}

	}

	public static void method1069(final IndexDataBase indexdatabase_0)
	{
		FloorUnderlayDefinition.underlay_ref = indexdatabase_0;
	}

	public static Font method1058(final IndexDataBase indexdatabase_0, final IndexDataBase indexdatabase_1,
	        final int int_0, final int int_1)
	{
		if (!class306.method5660(indexdatabase_0, int_0, int_1))
		{
			return null;
		}
		else
		{
			final byte[] bytes_0 = indexdatabase_1.getConfigData(int_0, int_1);
			Font font_0;
			if (bytes_0 == null)
			{
				font_0 = null;
			}
			else
			{
				final Font font_1 = new Font(bytes_0, class7.indexedSpriteOffsetXs, class225.indexedSpriteOffsetYs,
				        class319.indexSpriteWidths, class319.indexedSpriteHeights, PacketNode.indexedSpritePalette,
				        class319.spritePixels);
				class7.indexedSpriteOffsetXs = null;
				class225.indexedSpriteOffsetYs = null;
				class319.indexSpriteWidths = null;
				class319.indexedSpriteHeights = null;
				PacketNode.indexedSpritePalette = null;
				class319.spritePixels = null;
				font_0 = font_1;
			}

			return font_0;
		}
	}

	static void method1053(final String string_0, final boolean bool_0, final String string_1, final boolean bool_1)
	{
		if (bool_0)
		{
			if (!bool_1 && Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE))
			{
				try
				{
					Desktop.getDesktop().browse(new URI(string_0));
					return;
				}
				catch (final Exception exception_0)
				{
                }
			}

			if (class45.field379.startsWith("win") && !bool_1)
			{
				WallObject.method3071(string_0, 0);
				return;
			}

			if (class45.field379.startsWith("mac"))
			{
				class13.method112(string_0, 1, string_1);
				return;
			}

			WallObject.method3071(string_0, 2);
		}
		else
		{
			WallObject.method3071(string_0, 3);
		}

	}

	static void characterToScreen(final Actor actor_0, final int int_0)
	{
		class238.worldToScreen(actor_0.x, actor_0.y, int_0);
	}

}
