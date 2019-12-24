public class IndexStoreActionHandler implements Runnable
{

	static Deque IndexStoreActionHandler_requestQueue;
	static Deque IndexStoreActionHandler_responseQueue;
	public static int field3179;
	public static Object IndexStoreActionHandler_lock;
	static Thread IndexStoreActionHandler_thread;

	static
	{
		IndexStoreActionHandler_requestQueue = new Deque();
		IndexStoreActionHandler_responseQueue = new Deque();
		field3179 = 0;
		IndexStoreActionHandler_lock = new Object();
	}

	@Override
	public void run()
	{
		try
		{
			while (true)
			{
				FileSystem filesystem_0;
				synchronized (IndexStoreActionHandler_requestQueue)
				{
					filesystem_0 = (FileSystem) IndexStoreActionHandler_requestQueue.getFront();
				}

				if (filesystem_0 != null)
				{
					if (filesystem_0.type == 0)
					{
						filesystem_0.index.write((int) filesystem_0.hash, filesystem_0.field3149,
						        filesystem_0.field3149.length);
						synchronized (IndexStoreActionHandler_requestQueue)
						{
							filesystem_0.unlink();
						}
					}
					else if (filesystem_0.type == 1)
					{
						filesystem_0.field3149 = filesystem_0.index.read((int) filesystem_0.hash);
						synchronized (IndexStoreActionHandler_requestQueue)
						{
							IndexStoreActionHandler_responseQueue.addFront(filesystem_0);
						}
					}

					synchronized (IndexStoreActionHandler_lock)
					{
						if (field3179 <= 1)
						{
							field3179 = 0;
							IndexStoreActionHandler_lock.notifyAll();
							return;
						}

						field3179 = 600;
					}
				}
				else
				{
					Actor.method1539(100L);
					synchronized (IndexStoreActionHandler_lock)
					{
						if (field3179 <= 1)
						{
							field3179 = 0;
							IndexStoreActionHandler_lock.notifyAll();
							return;
						}

						--field3179;
					}
				}
			}
		}
		catch (final Exception exception_0)
		{
			UnitPriceComparator.processClientError(null, exception_0);
		}
	}

}
