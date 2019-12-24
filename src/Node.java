public class Node
{

	public long hash;
	public Node next;
	Node previous;

	public void unlink()
	{
		if (previous != null)
		{
			previous.next = next;
			next.previous = previous;
			next = null;
			previous = null;
		}
	}

	public boolean linked()
	{
		return previous != null;
	}

}
