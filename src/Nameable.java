public class Nameable implements Comparable
{

	Name name;
	Name field3611;

	public Name method5287()
	{
		return name;
	}

	public String method5288()
	{
		return name == null ? "" : name.getName();
	}

	public String method5289()
	{
		return field3611 == null ? "" : field3611.getName();
	}

	void method5290(final Name name_0, final Name name_1)
	{
		if (name_0 == null)
		{
			throw new NullPointerException();
		}
		else
		{
			name = name_0;
			field3611 = name_1;
		}
	}

	public int vmethod5453(final Nameable nameable_1)
	{
		return name.compareCleanName(nameable_1.name);
	}

	@Override
	public int compareTo(final Object object_0)
	{
		return vmethod5453((Nameable) object_0);
	}

}
