public class class88 extends TaskDataNode
{

	Deque field1229;
	Deque field1230;
	int field1231;
	int field1232;

	public class88()
	{
		field1229 = new Deque();
		field1230 = new Deque();
		field1231 = 0;
		field1232 = -1;
	}

	public synchronized void method2032(final TaskDataNode taskdatanode_0)
	{
		field1229.addTail(taskdatanode_0);
	}

	public synchronized void method2009(final TaskDataNode taskdatanode_0)
	{
		taskdatanode_0.unlink();
	}

	void method2010()
	{
		if (field1231 > 0)
		{
			for (class100 class100_0 = (class100) field1230
			        .getFront(); class100_0 != null; class100_0 = (class100) field1230.getNext())
			{
				class100_0.field1338 -= field1231;
			}

			field1232 -= field1231;
			field1231 = 0;
		}

	}

	void method2011(Node node_0, final class100 class100_0)
	{
		while ((field1230.head != node_0) && (((class100) node_0).field1338 <= class100_0.field1338))
		{
			node_0 = node_0.next;
		}

		Deque.method4075(class100_0, node_0);
		field1232 = ((class100) field1230.head.next).field1338;
	}

	void method2008(final class100 class100_0)
	{
		class100_0.unlink();
		class100_0.method2231();
		final Node node_0 = field1230.head.next;
		if (node_0 == field1230.head)
		{
			field1232 = -1;
		}
		else
		{
			field1232 = ((class100) node_0).field1338;
		}

	}

	@Override
	protected TaskDataNode vmethod4382()
	{
		return (TaskDataNode) field1229.getFront();
	}

	@Override
	protected TaskDataNode vmethod4389()
	{
		return (TaskDataNode) field1229.getNext();
	}

	@Override
	protected int vmethod4395()
	{
		return 0;
	}

	@Override
	public synchronized void vmethod4385(final int[] ints_0, int int_0, int int_1)
	{
		do
		{
			if (field1232 < 0)
			{
				method2042(ints_0, int_0, int_1);
				return;
			}

			if ((int_1 + field1231) < field1232)
			{
				field1231 += int_1;
				method2042(ints_0, int_0, int_1);
				return;
			}

			final int int_2 = field1232 - field1231;
			method2042(ints_0, int_0, int_2);
			int_0 += int_2;
			int_1 -= int_2;
			field1231 += int_2;
			method2010();
			final class100 class100_0 = (class100) field1230.getFront();
			synchronized (class100_0)
			{
				final int int_3 = class100_0.method2232();
				if (int_3 < 0)
				{
					class100_0.field1338 = 0;
					method2008(class100_0);
				}
				else
				{
					class100_0.field1338 = int_3;
					method2011(class100_0.next, class100_0);
				}
			}
		}
		while (int_1 != 0);

	}

	void method2042(final int[] ints_0, final int int_0, final int int_1)
	{
		for (TaskDataNode taskdatanode_0 = (TaskDataNode) field1229
		        .getFront(); taskdatanode_0 != null; taskdatanode_0 = (TaskDataNode) field1229.getNext())
		{
			taskdatanode_0.method2439(ints_0, int_0, int_1);
		}

	}

	@Override
	public synchronized void vmethod4386(int int_0)
	{
		do
		{
			if (field1232 < 0)
			{
				method2025(int_0);
				return;
			}

			if ((field1231 + int_0) < field1232)
			{
				field1231 += int_0;
				method2025(int_0);
				return;
			}

			final int int_1 = field1232 - field1231;
			method2025(int_1);
			int_0 -= int_1;
			field1231 += int_1;
			method2010();
			final class100 class100_0 = (class100) field1230.getFront();
			synchronized (class100_0)
			{
				final int int_2 = class100_0.method2232();
				if (int_2 < 0)
				{
					class100_0.field1338 = 0;
					method2008(class100_0);
				}
				else
				{
					class100_0.field1338 = int_2;
					method2011(class100_0.next, class100_0);
				}
			}
		}
		while (int_0 != 0);

	}

	void method2025(final int int_0)
	{
		for (TaskDataNode taskdatanode_0 = (TaskDataNode) field1229
		        .getFront(); taskdatanode_0 != null; taskdatanode_0 = (TaskDataNode) field1229.getNext())
		{
			taskdatanode_0.vmethod4386(int_0);
		}

	}

}
