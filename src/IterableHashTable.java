import java.util.Iterator;

public final class IterableHashTable implements Iterable
{

	int size;
	Node[] buckets;
	Node head;
	Node tail;
	int index;

	public IterableHashTable(final int int_0)
	{
		index = 0;
		size = int_0;
		buckets = new Node[int_0];

		for (int int_1 = 0; int_1 < int_0; int_1++)
		{
			final Node node_0 = buckets[int_1] = new Node();
			node_0.next = node_0;
			node_0.previous = node_0;
		}

	}

	public Node get(final long long_0)
	{
		final Node node_0 = buckets[(int) (long_0 & size - 1)];

		for (head = node_0.next; node_0 != head; head = head.next)
		{
			if (head.hash == long_0)
			{
				final Node node_1 = head;
				head = head.next;
				return node_1;
			}
		}

		head = null;
		return null;
	}

	public void put(final Node node_0, final long long_0)
	{
		if (node_0.previous != null)
		{
			node_0.unlink();
		}

		final Node node_1 = buckets[(int) (long_0 & size - 1)];
		node_0.previous = node_1.previous;
		node_0.next = node_1;
		node_0.previous.next = node_0;
		node_0.next.previous = node_0;
		node_0.hash = long_0;
	}

	public void clear()
	{
		for (int int_0 = 0; int_0 < size; int_0++)
		{
			final Node node_0 = buckets[int_0];

			while (true)
			{
				final Node node_1 = node_0.next;
				if (node_1 == node_0)
				{
					break;
				}

				node_1.unlink();
			}
		}

		head = null;
		tail = null;
	}

	public Node getHead()
	{
		index = 0;
		return getTail();
	}

	public Node getTail()
	{
		Node node_0;
		if ((index > 0) && (buckets[index - 1] != tail))
		{
			node_0 = tail;
			tail = node_0.next;
			return node_0;
		}
		else
		{
			do
			{
				if (index >= size)
				{
					return null;
				}

				node_0 = buckets[index++].next;
			}
			while (node_0 == buckets[index - 1]);

			tail = node_0.next;
			return node_0;
		}
	}

	@Override
	public Iterator iterator()
	{
		return new HashTableIterator(this);
	}

}
