public class GrandExchangeEvent
{

	static int field23;
	public final int world;
	public final long field20;
	public final GrandExchangeOffer grandExchangeOffer;
	String string1;
	String string2;

	GrandExchangeEvent(final Buffer buffer_0, final byte byte_0, final int int_0)
	{
		string1 = buffer_0.readString();
		string2 = buffer_0.readString();
		world = buffer_0.readUnsignedShort();
		field20 = buffer_0.readLong();
		final int int_1 = buffer_0.readInt();
		final int int_2 = buffer_0.readInt();
		grandExchangeOffer = new GrandExchangeOffer();
		grandExchangeOffer.method44(2);
		grandExchangeOffer.method40(byte_0);
		grandExchangeOffer.price = int_1;
		grandExchangeOffer.totalQuantity = int_2;
		grandExchangeOffer.quantitySold = 0;
		grandExchangeOffer.spent = 0;
		grandExchangeOffer.itemId = int_0;
	}

	public String method16()
	{
		return string1;
	}

	public String method18()
	{
		return string2;
	}

	public static KitDefinition getKitDefinition(final int int_0)
	{
		KitDefinition kitdefinition_0 = (KitDefinition) KitDefinition.identKits.get(int_0);
		if (kitdefinition_0 != null)
		{
			return kitdefinition_0;
		}
		else
		{
			final byte[] bytes_0 = KitDefinition.identKit_ref.getConfigData(3, int_0);
			kitdefinition_0 = new KitDefinition();
			if (bytes_0 != null)
			{
				kitdefinition_0.decode(new Buffer(bytes_0));
			}

			KitDefinition.identKits.put(kitdefinition_0, int_0);
			return kitdefinition_0;
		}
	}

	static void method22(final String string_0, final String string_1, final String string_2)
	{
		class78.loginMessage1 = string_0;
		class78.loginMessage2 = string_1;
		class78.loginMessage3 = string_2;
	}

}
