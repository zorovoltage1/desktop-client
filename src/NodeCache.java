public final class NodeCache
{

	CacheableNode field2409;
	int capacity;
	int remainingCapacity;
	HashTable table;
	Node2LinkedList list;

	public NodeCache(final int int_0)
	{
		field2409 = new CacheableNode();
		list = new Node2LinkedList();
		capacity = int_0;
		remainingCapacity = int_0;

		int int_1;
		for (int_1 = 1; (int_1 + int_1) < int_0; int_1 += int_1)
		{
        }

		table = new HashTable(int_1);
	}

	public CacheableNode get(final long long_0)
	{
		final CacheableNode cacheablenode_0 = (CacheableNode) table.get(long_0);
		if (cacheablenode_0 != null)
		{
			list.push(cacheablenode_0);
		}

		return cacheablenode_0;
	}

	public void remove(final long long_0)
	{
		final CacheableNode cacheablenode_0 = (CacheableNode) table.get(long_0);
		if (cacheablenode_0 != null)
		{
			cacheablenode_0.unlink();
			cacheablenode_0.unlinkDual();
			++remainingCapacity;
		}

	}

	public void put(final CacheableNode cacheablenode_0, final long long_0)
	{
		if (remainingCapacity == 0)
		{
			CacheableNode cacheablenode_1 = list.pop();
			cacheablenode_1.unlink();
			cacheablenode_1.unlinkDual();
			if (cacheablenode_1 == field2409)
			{
				cacheablenode_1 = list.pop();
				cacheablenode_1.unlink();
				cacheablenode_1.unlinkDual();
			}
		}
		else
		{
			--remainingCapacity;
		}

		table.put(cacheablenode_0, long_0);
		list.push(cacheablenode_0);
	}

	public void reset()
	{
		list.clear();
		table.clear();
		field2409 = new CacheableNode();
		remainingCapacity = capacity;
	}

}
