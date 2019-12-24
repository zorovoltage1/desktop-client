public class class138 extends class283
{

	public static IndexDataBase field1871;
	static Player localPlayer;
	final boolean field1872;

	public class138(final boolean bool_0)
	{
		field1872 = bool_0;
	}

	int method3128(final ChatPlayer chatplayer_0, final ChatPlayer chatplayer_1)
	{
		return (Game.world == chatplayer_0.world) && (chatplayer_1.world == Game.world)
		        ? (field1872 ? chatplayer_0.method5287().compareCleanName(chatplayer_1.method5287())
		                : chatplayer_1.method5287().compareCleanName(chatplayer_0.method5287()))
		        : method5308(chatplayer_0, chatplayer_1);
	}

	@Override
	public int compare(final Object object_0, final Object object_1)
	{
		return method3128((ChatPlayer) object_0, (ChatPlayer) object_1);
	}

	public static int method3137(final CharSequence charsequence_0, final int int_0)
	{
		return class68.parseInt(charsequence_0, int_0, true);
	}

}
