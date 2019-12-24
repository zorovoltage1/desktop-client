public abstract class TaskDataNode extends Node
{

	boolean field1385;
	TaskDataNode field1382;
	int field1384;
	AbstractIntegerNode0 data;

	protected TaskDataNode()
	{
		field1385 = true;
	}

	protected abstract TaskDataNode vmethod4382();

	protected abstract TaskDataNode vmethod4389();

	protected abstract int vmethod4395();

	protected abstract void vmethod4385(int[] var1, int var2, int var3);

	protected abstract void vmethod4386(int var1);

	int vmethod2435()
	{
		return 255;
	}

	void method2439(final int[] ints_0, final int int_0, final int int_1)
	{
		if (field1385)
		{
			vmethod4385(ints_0, int_0, int_1);
		}
		else
		{
			vmethod4386(int_1);
		}

	}

}
