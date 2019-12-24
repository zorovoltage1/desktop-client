public class Ignore extends Nameable
{

	int field3624;

	int method5406(final Ignore ignore_1)
	{
		return field3624 - ignore_1.field3624;
	}

	@Override
	public int vmethod5453(final Nameable nameable_0)
	{
		return method5406((Ignore) nameable_0);
	}

	@Override
	public int compareTo(final Object object_0)
	{
		return method5406((Ignore) object_0);
	}

}
