public class class139 extends class283
{

	static IndexDataBase field1877;
	final boolean field1881;

	public class139(final boolean bool_0)
	{
		field1881 = bool_0;
	}

	int method3139(final ChatPlayer chatplayer_0, final ChatPlayer chatplayer_1)
	{
		if (Game.world == chatplayer_0.world)
		{
			if (chatplayer_1.world != Game.world)
			{
				return field1881 ? -1 : 1;
			}
		}
		else if (chatplayer_1.world == Game.world)
		{
			return field1881 ? 1 : -1;
		}

		return method5308(chatplayer_0, chatplayer_1);
	}

	@Override
	public int compare(final Object object_0, final Object object_1)
	{
		return method3139((ChatPlayer) object_0, (ChatPlayer) object_1);
	}

	static int method3143(final int int_0, final int int_1)
	{
		final ItemContainer itemcontainer_0 = (ItemContainer) ItemContainer.itemContainers.get(int_0);
		if (itemcontainer_0 == null)
		{
			return 0;
		}
		else if (int_1 == -1)
		{
			return 0;
		}
		else
		{
			int int_2 = 0;

			for (int int_3 = 0; int_3 < itemcontainer_0.stackSizes.length; int_3++)
			{
				if (itemcontainer_0.itemIds[int_3] == int_1)
				{
					int_2 += itemcontainer_0.stackSizes[int_3];
				}
			}

			return int_2;
		}
	}

	static int method3145(char char_0, final int int_0)
	{
		int int_1 = char_0 << 4;
		if (Character.isUpperCase(char_0) || Character.isTitleCase(char_0))
		{
			char_0 = Character.toLowerCase(char_0);
			int_1 = (char_0 << 4) + 1;
		}

		return int_1;
	}

	static String method3138(String string_0)
	{
		final Permission[] permissions_0 = WorldMapData.method216();

		for (int int_0 = 0; int_0 < permissions_0.length; int_0++)
		{
			final Permission permission_0 = permissions_0[int_0];
			if (permission_0.field3128 != -1)
			{
				final int int_1 = permission_0.field3128;
				final String string_1 = "<img=" + int_1 + ">";
				if (string_0.startsWith(string_1))
				{
					string_0 = string_0.substring(6 + Integer.toString(permission_0.field3128).length());
					break;
				}
			}
		}

		return string_0;
	}

}
