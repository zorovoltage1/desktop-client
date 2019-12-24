import java.util.Iterator;

public class class214 implements Iterator
{

	IterableDualNodeQueue field2442;
	CacheableNode field2441;
	CacheableNode field2443;

	class214(final IterableDualNodeQueue iterabledualnodequeue_0)
	{
		field2443 = null;
		field2442 = iterabledualnodequeue_0;
		field2441 = field2442.sentinel.previous;
		field2443 = null;
	}

	@Override
	public boolean hasNext()
	{
		return field2442.sentinel != field2441;
	}

	@Override
	public Object next()
	{
		CacheableNode cacheablenode_0 = field2441;
		if (cacheablenode_0 == field2442.sentinel)
		{
			cacheablenode_0 = null;
			field2441 = null;
		}
		else
		{
			field2441 = cacheablenode_0.previous;
		}

		field2443 = cacheablenode_0;
		return cacheablenode_0;
	}

	@Override
	public void remove()
	{
		if (field2443 == null)
		{
			throw new IllegalStateException();
		}
		else
		{
			field2443.unlinkDual();
			field2443 = null;
		}
	}

}
