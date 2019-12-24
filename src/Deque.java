public class Deque
{

	public Node head;
	Node current;

	public Deque()
	{
		head = new Node();
		head.next = head;
		head.previous = head;
	}

	public void clear()
	{
		while (true)
		{
			final Node node_0 = head.next;
			if (node_0 == head)
			{
				current = null;
				return;
			}

			node_0.unlink();
		}
	}

	public void addFront(final Node node_0)
	{
		if (node_0.previous != null)
		{
			node_0.unlink();
		}

		node_0.previous = head.previous;
		node_0.next = head;
		node_0.previous.next = node_0;
		node_0.next.previous = node_0;
	}

	public void addTail(final Node node_0)
	{
		if (node_0.previous != null)
		{
			node_0.unlink();
		}

		node_0.previous = head;
		node_0.next = head.next;
		node_0.previous.next = node_0;
		node_0.next.previous = node_0;
	}

	public Node popFront()
	{
		final Node node_0 = head.next;
		if (node_0 == head)
		{
			return null;
		}
		else
		{
			node_0.unlink();
			return node_0;
		}
	}

	public Node popTail()
	{
		final Node node_0 = head.previous;
		if (node_0 == head)
		{
			return null;
		}
		else
		{
			node_0.unlink();
			return node_0;
		}
	}

	public Node getFront()
	{
		final Node node_0 = head.next;
		if (node_0 == head)
		{
			current = null;
			return null;
		}
		else
		{
			current = node_0.next;
			return node_0;
		}
	}

	public Node getTail()
	{
		final Node node_0 = head.previous;
		if (node_0 == head)
		{
			current = null;
			return null;
		}
		else
		{
			current = node_0.previous;
			return node_0;
		}
	}

	public Node getNext()
	{
		final Node node_0 = current;
		if (node_0 == head)
		{
			current = null;
			return null;
		}
		else
		{
			current = node_0.next;
			return node_0;
		}
	}

	public Node getPrevious()
	{
		final Node node_0 = current;
		if (node_0 == head)
		{
			current = null;
			return null;
		}
		else
		{
			current = node_0.previous;
			return node_0;
		}
	}

	public static void method4075(final Node node_0, final Node node_1)
	{
		if (node_0.previous != null)
		{
			node_0.unlink();
		}

		node_0.previous = node_1.previous;
		node_0.next = node_1;
		node_0.previous.next = node_0;
		node_0.next.previous = node_0;
	}

}
