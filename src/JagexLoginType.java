public class JagexLoginType
{

	public static final JagexLoginType field3880;
	static final JagexLoginType field3876;
	static final JagexLoginType field3873;
	static final JagexLoginType field3870;
	static final JagexLoginType field3874;
	static final JagexLoginType field3875;
	static final JagexLoginType field3872;
	static final JagexLoginType field3877;
	public static final JagexLoginType field3878;
	static IndexedSprite[] modIconSprites;
	public final int field3879;
	final String identifier;

	static
	{
		field3880 = new JagexLoginType(0, 0, "", "");
		field3876 = new JagexLoginType(2, 1, "", "");
		field3873 = new JagexLoginType(3, 2, "", "");
		field3870 = new JagexLoginType(7, 3, "", "");
		field3874 = new JagexLoginType(6, 4, "", "");
		field3875 = new JagexLoginType(4, 5, "", "");
		field3872 = new JagexLoginType(1, 6, "", "");
		field3877 = new JagexLoginType(8, 7, "", "");
		field3878 = new JagexLoginType(5, -1, "", "", true,
		        new JagexLoginType[] { field3880, field3876, field3873, field3874, field3870 });
	}

	JagexLoginType(final int int_0, final int int_1, final String string_0, final String string_1)
	{
		field3879 = int_0;
		identifier = string_1;
	}

	JagexLoginType(final int int_0, final int int_1, final String string_0, final String string_1, final boolean bool_0,
	        final JagexLoginType[] jagexlogintypes_0)
	{
		field3879 = int_0;
		identifier = string_1;
	}

	@Override
	public String toString()
	{
		return identifier;
	}

}
