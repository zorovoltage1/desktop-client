public class CacheableNode extends Node
{

	long field2428;
	public CacheableNode previous;
	public CacheableNode next;

	public void unlinkDual()
	{
		if (next != null)
		{
			next.previous = previous;
			previous.next = next;
			previous = null;
			next = null;
		}
	}

}
