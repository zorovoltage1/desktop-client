public class class144 extends class283
{

	final boolean field1902;

	public class144(final boolean bool_0)
	{
		field1902 = bool_0;
	}

	int method3175(final ChatPlayer chatplayer_0, final ChatPlayer chatplayer_1)
	{
		return chatplayer_1.rank != chatplayer_0.rank
		        ? (field1902 ? chatplayer_0.rank - chatplayer_1.rank : chatplayer_1.rank - chatplayer_0.rank)
		        : method5308(chatplayer_0, chatplayer_1);
	}

	@Override
	public int compare(final Object object_0, final Object object_1)
	{
		return method3175((ChatPlayer) object_0, (ChatPlayer) object_1);
	}

	public static void method3181(final IndexDataBase indexdatabase_0, final IndexDataBase indexdatabase_1)
	{
		CombatInfo2.field3304 = indexdatabase_0;
		CombatInfo2.field3314 = indexdatabase_1;
	}

}
