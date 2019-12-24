import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;

public class Signlink implements Runnable
{

	public static String javaVendor;
	public static String javaVersion;
	static IndexDataBase field1956;
	static java.awt.Font field1961;
	Task currentTask;
	Task cachedTask;
	Thread sysEventQueue;
	boolean closed;

	public Signlink()
	{
		currentTask = null;
		cachedTask = null;
		closed = false;
		javaVendor = "Unknown";
		javaVersion = "1.6";

		try
		{
			javaVendor = System.getProperty("java.vendor");
			javaVersion = System.getProperty("java.version");
		}
		catch (final Exception exception_0)
		{
        }

		closed = false;
		sysEventQueue = new Thread(this);
		sysEventQueue.setPriority(10);
		sysEventQueue.setDaemon(true);
		sysEventQueue.start();
	}

	public void join()
	{
		synchronized (this)
		{
			closed = true;
			notifyAll();
		}

		try
		{
			sysEventQueue.join();
		}
		catch (final InterruptedException interruptedexception_0)
		{
        }

	}

	Task newTask(final int int_0, final int int_1, final int int_2, final Object object_0)
	{
		final Task task_0 = new Task();
		task_0.type = int_0;
		task_0.intArgument = int_1;
		task_0.objectArgument = object_0;
		synchronized (this)
		{
			if (cachedTask != null)
			{
				cachedTask.task = task_0;
				cachedTask = task_0;
			}
			else
			{
				cachedTask = currentTask = task_0;
			}

			notify();
			return task_0;
		}
	}

	public Task createSocket(final String string_0, final int int_0)
	{
		return newTask(1, int_0, 0, string_0);
	}

	public Task createRunnable(final Runnable runnable_0, final int int_0)
	{
		return newTask(2, int_0, 0, runnable_0);
	}

	@Override
	public void run()
	{
		while (true)
		{
			Task task_0;
			synchronized (this)
			{
				while (true)
				{
					if (closed)
					{
						return;
					}

					if (currentTask != null)
					{
						task_0 = currentTask;
						currentTask = currentTask.task;
						if (currentTask == null)
						{
							cachedTask = null;
						}
						break;
					}

					try
					{
						this.wait();
					}
					catch (final InterruptedException interruptedexception_0)
					{
                    }
				}
			}

			try
			{
				final int int_0 = task_0.type;
				if (int_0 == 1)
				{
					task_0.value = new Socket(InetAddress.getByName((String) task_0.objectArgument),
					        task_0.intArgument);
				}
				else if (int_0 == 2)
				{
					final Thread thread_0 = new Thread((Runnable) task_0.objectArgument);
					thread_0.setDaemon(true);
					thread_0.start();
					thread_0.setPriority(task_0.intArgument);
					task_0.value = thread_0;
				}
				else if (int_0 == 4)
				{
					task_0.value = new DataInputStream(((URL) task_0.objectArgument).openStream());
				}

				task_0.status = 1;
			}
			catch (final ThreadDeath threaddeath_0)
			{
				throw threaddeath_0;
			}
			catch (final Throwable throwable_0)
			{
				task_0.status = 2;
			}
		}
	}

	public static int method3252(final int int_0)
	{
		return (int_0 >> 11) & 0x3F;
	}

}
