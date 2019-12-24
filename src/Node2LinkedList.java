public final class Node2LinkedList
{

	CacheableNode sentinel;

	public Node2LinkedList()
	{
		sentinel = new CacheableNode();
		sentinel.previous = sentinel;
		sentinel.next = sentinel;
	}

	public void push(final CacheableNode cacheablenode_0)
	{
		if (cacheablenode_0.next != null)
		{
			cacheablenode_0.unlinkDual();
		}

		cacheablenode_0.next = sentinel.next;
		cacheablenode_0.previous = sentinel;
		cacheablenode_0.next.previous = cacheablenode_0;
		cacheablenode_0.previous.next = cacheablenode_0;
	}

	public void setHead(final CacheableNode cacheablenode_0)
	{
		if (cacheablenode_0.next != null)
		{
			cacheablenode_0.unlinkDual();
		}

		cacheablenode_0.next = sentinel;
		cacheablenode_0.previous = sentinel.previous;
		cacheablenode_0.next.previous = cacheablenode_0;
		cacheablenode_0.previous.next = cacheablenode_0;
	}

	CacheableNode pop()
	{
		final CacheableNode cacheablenode_0 = sentinel.previous;
		if (cacheablenode_0 == sentinel)
		{
			return null;
		}
		else
		{
			cacheablenode_0.unlinkDual();
			return cacheablenode_0;
		}
	}

	public CacheableNode peek()
	{
		final CacheableNode cacheablenode_0 = sentinel.previous;
		return cacheablenode_0 == sentinel ? null : cacheablenode_0;
	}

	void clear()
	{
		while (true)
		{
			final CacheableNode cacheablenode_0 = sentinel.previous;
			if (cacheablenode_0 == sentinel)
			{
				return;
			}

			cacheablenode_0.unlinkDual();
		}
	}

	static void method3909(final CacheableNode cacheablenode_0, final CacheableNode cacheablenode_1)
	{
		if (cacheablenode_0.next != null)
		{
			cacheablenode_0.unlinkDual();
		}

		cacheablenode_0.next = cacheablenode_1;
		cacheablenode_0.previous = cacheablenode_1.previous;
		cacheablenode_0.next.previous = cacheablenode_0;
		cacheablenode_0.previous.next = cacheablenode_0;
	}

}
