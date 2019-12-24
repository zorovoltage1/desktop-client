import java.lang.ref.SoftReference;

public class class207 extends class212
{

	SoftReference field2429;

	class207(final Object object_0, final int int_0)
	{
		super(int_0);
		field2429 = new SoftReference(object_0);
	}

	@Override
	Object vmethod4137()
	{
		return field2429.get();
	}

	@Override
	boolean vmethod4136()
	{
		return true;
	}

}
