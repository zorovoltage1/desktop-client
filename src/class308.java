import java.util.Comparator;

public class class308 implements Comparator
{

	final boolean field3738;

	public class308(final boolean bool_0)
	{
		field3738 = bool_0;
	}

	int method5664(final Nameable nameable_0, final Nameable nameable_1)
	{
		return field3738 ? nameable_0.vmethod5453(nameable_1) : nameable_1.vmethod5453(nameable_0);
	}

	@Override
	public int compare(final Object object_0, final Object object_1)
	{
		return method5664((Nameable) object_0, (Nameable) object_1);
	}

	@Override
	public boolean equals(final Object object_0)
	{
		return super.equals(object_0);
	}

}
