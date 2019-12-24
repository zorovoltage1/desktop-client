import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public abstract class NameableContainer
{

	final int field3620;
	int count;
	Nameable[] nameables;
	HashMap field3618;
	HashMap field3622;
	Comparator field3621;

	NameableContainer(final int int_0)
	{
		count = 0;
		field3621 = null;
		field3620 = int_0;
		nameables = vmethod5462(int_0);
		field3618 = new HashMap(int_0 / 8);
		field3622 = new HashMap(int_0 / 8);
	}

	abstract Nameable vmethod5461();

	abstract Nameable[] vmethod5462(int var1);

	public void method5326()
	{
		count = 0;
		Arrays.fill(nameables, null);
		field3618.clear();
		field3622.clear();
	}

	public int getCount()
	{
		return count;
	}

	public boolean method5328()
	{
		return field3620 == count;
	}

	public boolean isMember(final Name name_0)
	{
		return name_0.isCleanNameValid() && (field3618.containsKey(name_0) || field3622.containsKey(name_0));
	}

	public Nameable method5330(final Name name_0)
	{
		final Nameable nameable_0 = method5331(name_0);
		return nameable_0 != null ? nameable_0 : method5390(name_0);
	}

	Nameable method5331(final Name name_0)
	{
		return !name_0.isCleanNameValid() ? null : (Nameable) field3618.get(name_0);
	}

	Nameable method5390(final Name name_0)
	{
		return !name_0.isCleanNameValid() ? null : (Nameable) field3622.get(name_0);
	}

	public boolean method5393(final Name name_0)
	{
		final Nameable nameable_0 = method5331(name_0);
		if (nameable_0 == null)
		{
			return false;
		}
		else
		{
			method5334(nameable_0);
			return true;
		}
	}

	void method5334(final Nameable nameable_0)
	{
		final int int_0 = method5339(nameable_0);
		if (int_0 != -1)
		{
			method5343(int_0);
			method5395(nameable_0);
		}
	}

	Nameable method5377(final Name name_0)
	{
		return method5335(name_0, null);
	}

	Nameable method5335(final Name name_0, final Name name_1)
	{
		if (method5331(name_0) != null)
		{
			throw new IllegalStateException();
		}
		else
		{
			final Nameable nameable_0 = vmethod5461();
			nameable_0.method5290(name_0, name_1);
			method5341(nameable_0);
			method5342(nameable_0);
			return nameable_0;
		}
	}

	public Nameable get(final int int_0)
	{
		if ((int_0 >= 0) && (int_0 < count))
		{
			return nameables[int_0];
		}
		else
		{
			throw new ArrayIndexOutOfBoundsException(int_0);
		}
	}

	public void method5337()
	{
		if (field3621 == null)
		{
			Arrays.sort(nameables, 0, count);
		}
		else
		{
			Arrays.sort(nameables, 0, count, field3621);
		}

	}

	void method5338(final Nameable nameable_0, final Name name_0, final Name name_1)
	{
		method5395(nameable_0);
		nameable_0.method5290(name_0, name_1);
		method5342(nameable_0);
	}

	int method5339(final Nameable nameable_0)
	{
		for (int int_0 = 0; int_0 < count; int_0++)
		{
			if (nameables[int_0] == nameable_0)
			{
				return int_0;
			}
		}

		return -1;
	}

	void method5395(final Nameable nameable_0)
	{
		if (field3618.remove(nameable_0.name) == null)
		{
			throw new IllegalStateException();
		}
		else
		{
			if (nameable_0.field3611 != null)
			{
				field3622.remove(nameable_0.field3611);
			}

		}
	}

	void method5341(final Nameable nameable_0)
	{
		nameables[count++] = nameable_0;
	}

	void method5342(final Nameable nameable_0)
	{
		field3618.put(nameable_0.name, nameable_0);
		if (nameable_0.field3611 != null)
		{
			final Nameable nameable_1 = (Nameable) field3622.put(nameable_0.field3611, nameable_0);
			if ((nameable_1 != null) && (nameable_1 != nameable_0))
			{
				nameable_1.field3611 = null;
			}
		}

	}

	void method5343(final int int_0)
	{
		--count;
		if (int_0 < count)
		{
			System.arraycopy(nameables, int_0 + 1, nameables, int_0, count - int_0);
		}

	}

	public void method5346()
	{
		field3621 = null;
	}

	public void method5347(final Comparator comparator_0)
	{
		if (field3621 == null)
		{
			field3621 = comparator_0;
		}
		else if (field3621 instanceof class283)
		{
			((class283) field3621).method5307(comparator_0);
		}

	}

}
