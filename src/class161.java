import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public final class class161 extends class157 implements Runnable
{

	static SpritePixels[] crossSprites;
	InputStream field1988;
	OutputStream field1986;
	Socket field1985;
	boolean field1990;
	Signlink field1989;
	Task field1987;
	byte[] field1994;
	int field1992;
	int field1993;
	boolean field1998;
	final int field1995;
	final int field1996;

	public class161(final Socket socket_0, final Signlink signlink_0, final int int_0) throws IOException
	{
		field1990 = false;
		field1992 = 0;
		field1993 = 0;
		field1998 = false;
		field1989 = signlink_0;
		field1985 = socket_0;
		field1995 = int_0;
		field1996 = int_0 - 100;
		field1985.setSoTimeout(30000);
		field1985.setTcpNoDelay(true);
		field1985.setReceiveBufferSize(65536);
		field1985.setSendBufferSize(65536);
		field1988 = field1985.getInputStream();
		field1986 = field1985.getOutputStream();
	}

	@Override
	public boolean vmethod3350(final int int_0) throws IOException
	{
		return !field1990 && field1988.available() >= int_0;
	}

	@Override
	public int vmethod3349() throws IOException
	{
		return field1990 ? 0 : field1988.available();
	}

	@Override
	public int vmethod3353() throws IOException
	{
		return field1990 ? 0 : field1988.read();
	}

	@Override
	public int vmethod3351(final byte[] bytes_0, int int_0, int int_1) throws IOException
	{
		if (field1990)
		{
			return 0;
		}
		else
		{
			int int_2;
			int int_3;
			for (int_2 = int_1; int_1 > 0; int_1 -= int_3)
			{
				int_3 = field1988.read(bytes_0, int_0, int_1);
				if (int_3 <= 0)
				{
					throw new EOFException();
				}

				int_0 += int_3;
			}

			return int_2;
		}
	}

	@Override
	public void vmethod3347(final byte[] bytes_0, final int int_0, final int int_1) throws IOException
	{
		method3352(bytes_0, int_0, int_1);
	}

	@Override
	public void vmethod3346()
	{
		if (!field1990)
		{
			synchronized (this)
			{
				field1990 = true;
				notifyAll();
			}

			if (field1987 != null)
			{
				while (field1987.status == 0)
				{
					Actor.method1539(1L);
				}

				if (field1987.status == 1)
				{
					try
					{
						((Thread) field1987.value).join();
					}
					catch (final InterruptedException interruptedexception_0)
					{
                    }
				}
			}

			field1987 = null;
		}
	}

	void method3352(final byte[] bytes_0, final int int_0, final int int_1) throws IOException
	{
		if (!field1990)
		{
			if (field1998)
			{
				field1998 = false;
				throw new IOException();
			}
			else
			{
				if (field1994 == null)
				{
					field1994 = new byte[field1995];
				}

				synchronized (this)
				{
					for (int int_2 = 0; int_2 < int_1; int_2++)
					{
						field1994[field1993] = bytes_0[int_2 + int_0];
						field1993 = (field1993 + 1) % field1995;
						if (((field1996 + field1992) % field1995) == field1993)
						{
							throw new IOException();
						}
					}

					if (field1987 == null)
					{
						field1987 = field1989.createRunnable(this, 3);
					}

					notifyAll();
				}
			}
		}
	}

	@Override
	public void run()
	{
		try
		{
			while (true)
			{
				label84:
				{
					int int_0;
					int int_1;
					synchronized (this)
					{
						if (field1993 == field1992)
						{
							if (field1990)
							{
								break label84;
							}

							try
							{
								this.wait();
							}
							catch (final InterruptedException interruptedexception_0)
							{
                            }
						}

						int_0 = field1992;
						if (field1993 >= field1992)
						{
							int_1 = field1993 - field1992;
						}
						else
						{
							int_1 = field1995 - field1992;
						}
					}

					if (int_1 <= 0)
					{
						continue;
					}

					try
					{
						field1986.write(field1994, int_0, int_1);
					}
					catch (final IOException ioexception_1)
					{
						field1998 = true;
					}

					field1992 = (int_1 + field1992) % field1995;

					try
					{
						if (field1993 == field1992)
						{
							field1986.flush();
						}
					}
					catch (final IOException ioexception_2)
					{
						field1998 = true;
					}
					continue;
				}

				try
				{
					if (field1988 != null)
					{
						field1988.close();
					}

					if (field1986 != null)
					{
						field1986.close();
					}

					if (field1985 != null)
					{
						field1985.close();
					}
				}
				catch (final IOException ioexception_0)
				{
                }

				field1994 = null;
				break;
			}
		}
		catch (final Exception exception_0)
		{
			UnitPriceComparator.processClientError(null, exception_0);
		}

	}

	@Override
	protected void finalize()
	{
		vmethod3346();
	}

	public static boolean method3362(final char char_0)
	{
		return ((char_0 >= 48) && (char_0 <= 57)) || ((char_0 >= 65) && (char_0 <= 90))
		        || ((char_0 >= 97) && (char_0 <= 122));
	}

}
