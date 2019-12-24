import java.util.Comparator;

public abstract class class283 implements Comparator
{

	Comparator field3613;

	void method5307(final Comparator comparator_0)
	{
		if (field3613 == null)
		{
			field3613 = comparator_0;
		}
		else if (field3613 instanceof class283)
		{
			((class283) field3613).method5307(comparator_0);
		}

	}

	protected int method5308(final Nameable nameable_0, final Nameable nameable_1)
	{
		return field3613 == null ? 0 : field3613.compare(nameable_0, nameable_1);
	}

	@Override
	public boolean equals(final Object object_0)
	{
		return super.equals(object_0);
	}

}
