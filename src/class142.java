public class class142 extends class283
{

	final boolean field1890;

	public class142(final boolean bool_0)
	{
		field1890 = bool_0;
	}

	int method3164(final ChatPlayer chatplayer_0, final ChatPlayer chatplayer_1)
	{
		if (chatplayer_0.world != 0)
		{
			if (chatplayer_1.world == 0)
			{
				return field1890 ? -1 : 1;
			}
		}
		else if (chatplayer_1.world != 0)
		{
			return field1890 ? 1 : -1;
		}

		return method5308(chatplayer_0, chatplayer_1);
	}

	@Override
	public int compare(final Object object_0, final Object object_1)
	{
		return method3164((ChatPlayer) object_0, (ChatPlayer) object_1);
	}

	static String method3161(String string_0, final boolean bool_0)
	{
		final String string_1 = bool_0 ? "https://" : "http://";
		if (Game.socketType == 1)
		{
			string_0 = string_0 + "-wtrc";
		}
		else if (Game.socketType == 2)
		{
			string_0 = string_0 + "-wtqa";
		}
		else if (Game.socketType == 3)
		{
			string_0 = string_0 + "-wtwip";
		}
		else if (Game.socketType == 5)
		{
			string_0 = string_0 + "-wti";
		}
		else if (Game.socketType == 4)
		{
			string_0 = "local";
		}

		String string_2 = "";
		if (GameSocket.sessionToken != null)
		{
			string_2 = "/p=" + GameSocket.sessionToken;
		}

		final String string_3 = "runescape.com";
		return string_1 + string_0 + "." + string_3 + "/l=" + Game.languageId + "/a=" + FrameMap.field1709 + string_2
		        + "/";
	}

}
