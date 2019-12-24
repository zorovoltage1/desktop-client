public class class140 extends class283
{

	final boolean field1883;

	public class140(final boolean bool_0)
	{
		field1883 = bool_0;
	}

	int method3147(final ChatPlayer chatplayer_0, final ChatPlayer chatplayer_1)
	{
		return (Game.world == chatplayer_0.world) && (chatplayer_1.world == Game.world)
		        ? (field1883 ? chatplayer_0.field3627 - chatplayer_1.field3627
		                : chatplayer_1.field3627 - chatplayer_0.field3627)
		        : method5308(chatplayer_0, chatplayer_1);
	}

	@Override
	public int compare(final Object object_0, final Object object_1)
	{
		return method3147((ChatPlayer) object_0, (ChatPlayer) object_1);
	}

	public static boolean method3150(final int int_0)
	{
		return ((int_0 >> 29) & 0x1) != 0;
	}

}
