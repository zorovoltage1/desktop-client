import java.util.Iterator;

public class CombatInfoList implements Iterable
{

	Node node;
	Node current;

	public CombatInfoList()
	{
		node = new Node();
		node.next = node;
		node.previous = node;
	}

	public void method4030()
	{
		while (node.next != node)
		{
			node.next.unlink();
		}

	}

	public void addFirst(final Node node_0)
	{
		if (node_0.previous != null)
		{
			node_0.unlink();
		}

		node_0.previous = node.previous;
		node_0.next = node;
		node_0.previous.next = node_0;
		node_0.next.previous = node_0;
	}

	public void addLast(final Node node_0)
	{
		if (node_0.previous != null)
		{
			node_0.unlink();
		}

		node_0.previous = node;
		node_0.next = node.next;
		node_0.previous.next = node_0;
		node_0.next.previous = node_0;
	}

	public Node last()
	{
		return previousOrLast(null);
	}

	Node previousOrLast(final Node node_0)
	{
		Node node_1;
		if (node_0 == null)
		{
			node_1 = node.next;
		}
		else
		{
			node_1 = node_0;
		}

		if (node_1 == node)
		{
			current = null;
			return null;
		}
		else
		{
			current = node_1.next;
			return node_1;
		}
	}

	public Node previous()
	{
		final Node node_0 = current;
		if (node_0 == node)
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

	public boolean isEmpty()
	{
		return node.next == node;
	}

	@Override
	public Iterator iterator()
	{
		return new class199(this);
	}

	public static void method4036(final Node node_0, final Node node_1)
	{
		if (node_0.previous != null)
		{
			node_0.unlink();
		}

		node_0.previous = node_1;
		node_0.next = node_1.next;
		node_0.previous.next = node_0;
		node_0.next.previous = node_0;
	}

}
