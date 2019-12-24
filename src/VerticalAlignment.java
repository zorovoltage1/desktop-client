public enum VerticalAlignment implements Enumerated
{

	field3224(2, 0), field3222(1, 1), field3221(0, 2);

	public final int value;
	final int field3225;

	VerticalAlignment(final int int_1, final int int_2)
	{
		value = int_1;
		field3225 = int_2;
	}

	@Override
	public int vmethod5815()
	{
		return field3225;
	}

}
