public class Bounds
{

	public int field3746;
	public int field3743;
	public int field3747;
	public int field3745;

	public Bounds(final int int_0, final int int_1, final int int_2, final int int_3)
	{
		method5679(int_0, int_1);
		method5680(int_2, int_3);
	}

	public Bounds(final int int_0, final int int_1)
	{
		this(0, 0, int_0, int_1);
	}

	public void method5679(final int int_0, final int int_1)
	{
		field3746 = int_0;
		field3743 = int_1;
	}

	public void method5680(final int int_0, final int int_1)
	{
		field3747 = int_0;
		field3745 = int_1;
	}

	public void method5681(final Bounds bounds_1, final Bounds bounds_2)
	{
		method5682(bounds_1, bounds_2);
		method5683(bounds_1, bounds_2);
	}

	void method5682(final Bounds bounds_1, final Bounds bounds_2)
	{
		bounds_2.field3746 = field3746;
		bounds_2.field3747 = field3747;
		if (field3746 < bounds_1.field3746)
		{
			bounds_2.field3747 -= bounds_1.field3746 - field3746;
			bounds_2.field3746 = bounds_1.field3746;
		}

		if (bounds_2.method5684() > bounds_1.method5684())
		{
			bounds_2.field3747 -= bounds_2.method5684() - bounds_1.method5684();
		}

		if (bounds_2.field3747 < 0)
		{
			bounds_2.field3747 = 0;
		}

	}

	void method5683(final Bounds bounds_1, final Bounds bounds_2)
	{
		bounds_2.field3743 = field3743;
		bounds_2.field3745 = field3745;
		if (field3743 < bounds_1.field3743)
		{
			bounds_2.field3745 -= bounds_1.field3743 - field3743;
			bounds_2.field3743 = bounds_1.field3743;
		}

		if (bounds_2.method5685() > bounds_1.method5685())
		{
			bounds_2.field3745 -= bounds_2.method5685() - bounds_1.method5685();
		}

		if (bounds_2.field3745 < 0)
		{
			bounds_2.field3745 = 0;
		}

	}

	int method5684()
	{
		return field3746 + field3747;
	}

	int method5685()
	{
		return field3743 + field3745;
	}

	@Override
	public String toString()
	{
		return null;
	}

	public static void method5697()
	{
		class313.classInfos = new CombatInfoList();
	}

}
