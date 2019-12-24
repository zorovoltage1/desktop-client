public class Script extends CacheableNode
{

	static int field1197;
	static NodeCache field1190;
	public int id;
	int[] instructions;
	int[] intOperands;
	String[] stringOperands;
	int localIntCount;
	int localStringCount;
	int intStackCount;
	int stringStackCount;
	IterableHashTable[] switches;

	static
	{
		field1190 = new NodeCache(128);
	}

	IterableHashTable[] method1944(final int int_0)
	{
		return new IterableHashTable[int_0];
	}

	public static void method1955()
	{
		while (true)
		{
			FileSystem filesystem_0;
			synchronized (IndexStoreActionHandler.IndexStoreActionHandler_requestQueue)
			{
				filesystem_0 = (FileSystem) IndexStoreActionHandler.IndexStoreActionHandler_responseQueue.popFront();
			}

			if (filesystem_0 == null)
			{
				return;
			}

			filesystem_0.data.load(filesystem_0.index, (int) filesystem_0.hash, filesystem_0.field3149, false);
		}
	}

	static synchronized byte[] method1943(final int int_0)
	{
		return class183.method3773(int_0, false);
	}

	static void method1956(final TaskDataNode taskdatanode_0)
	{
		taskdatanode_0.field1385 = false;
		if (taskdatanode_0.data != null)
		{
			taskdatanode_0.data.int1 = 0;
		}

		for (TaskDataNode taskdatanode_1 = taskdatanode_0
		        .vmethod4382(); taskdatanode_1 != null; taskdatanode_1 = taskdatanode_0.vmethod4389())
		{
			method1956(taskdatanode_1);
		}

	}

	static void method1946(final int int_0, final int int_1, final int int_2, final boolean bool_0)
	{
		if (CombatInfo2.loadWidget(int_0))
		{
			class304.method5635(GameCanvas.widgets[int_0], -1, int_1, int_2, bool_0);
		}
	}

}
