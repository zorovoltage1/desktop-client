import java.util.Iterator;

public class IterableDualNodeQueue implements Iterable
{

	public CacheableNode sentinel;
	CacheableNode field2444;

	public IterableDualNodeQueue()
	{
		sentinel = new CacheableNode();
		sentinel.previous = sentinel;
		sentinel.next = sentinel;
	}

	public void clear()
	{
		while (sentinel.previous != sentinel)
		{
			sentinel.previous.unlinkDual();
		}

	}

	public void add(final CacheableNode cacheablenode_0)
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

	CacheableNode method4156()
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

	CacheableNode method4177()
	{
		return method4160(null);
	}

	CacheableNode method4160(final CacheableNode cacheablenode_0)
	{
		CacheableNode cacheablenode_1;
		if (cacheablenode_0 == null)
		{
			cacheablenode_1 = sentinel.previous;
		}
		else
		{
			cacheablenode_1 = cacheablenode_0;
		}

		if (cacheablenode_1 == sentinel)
		{
			field2444 = null;
			return null;
		}
		else
		{
			field2444 = cacheablenode_1.previous;
			return cacheablenode_1;
		}
	}

	CacheableNode method4159()
	{
		final CacheableNode cacheablenode_0 = field2444;
		if (cacheablenode_0 == sentinel)
		{
			field2444 = null;
			return null;
		}
		else
		{
			field2444 = cacheablenode_0.previous;
			return cacheablenode_0;
		}
	}

	@Override
	public Iterator iterator()
	{
		return new class214(this);
	}

}
