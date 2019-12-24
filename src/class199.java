import java.util.Iterator;

public class class199 implements Iterator
{

	CombatInfoList field2404;
	Node field2403;
	Node field2402;

	class199(final CombatInfoList combatinfolist_0)
	{
		field2402 = null;
		field2404 = combatinfolist_0;
		field2403 = field2404.node.next;
		field2402 = null;
	}

	@Override
	public Object next()
	{
		Node node_0 = field2403;
		if (node_0 == field2404.node)
		{
			node_0 = null;
			field2403 = null;
		}
		else
		{
			field2403 = node_0.next;
		}

		field2402 = node_0;
		return node_0;
	}

	@Override
	public boolean hasNext()
	{
		return field2404.node != field2403;
	}

	@Override
	public void remove()
	{
		if (field2402 == null)
		{
			throw new IllegalStateException();
		}
		else
		{
			field2402.unlink();
			field2402 = null;
		}
	}

}
