public class class141 extends class283
{

	static int field1885;
	static Widget field1888;
	final boolean field1886;

	public class141(final boolean bool_0)
	{
		field1886 = bool_0;
	}

	int method3153(final ChatPlayer chatplayer_0, final ChatPlayer chatplayer_1)
	{
		return (chatplayer_0.world != 0) && (chatplayer_1.world != 0)
		        ? (field1886 ? chatplayer_0.field3627 - chatplayer_1.field3627
		                : chatplayer_1.field3627 - chatplayer_0.field3627)
		        : method5308(chatplayer_0, chatplayer_1);
	}

	@Override
	public int compare(final Object object_0, final Object object_1)
	{
		return method3153((ChatPlayer) object_0, (ChatPlayer) object_1);
	}

}
