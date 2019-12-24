public class class145 extends class283
{

	final boolean field1903;

	public class145(final boolean bool_0)
	{
		field1903 = bool_0;
	}

	int method3182(final ChatPlayer chatplayer_0, final ChatPlayer chatplayer_1)
	{
		return (chatplayer_0.world != 0) && (chatplayer_1.world != 0)
		        ? (field1903 ? chatplayer_0.method5287().compareCleanName(chatplayer_1.method5287())
		                : chatplayer_1.method5287().compareCleanName(chatplayer_0.method5287()))
		        : method5308(chatplayer_0, chatplayer_1);
	}

	@Override
	public int compare(final Object object_0, final Object object_1)
	{
		return method3182((ChatPlayer) object_0, (ChatPlayer) object_1);
	}

	public static boolean method3188(final int int_0)
	{
		return ((int_0 >> 30) & 0x1) != 0;
	}

}
