import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

public class class151 implements Runnable
{
	private static final double LOG_2 = Math.log(2.0D);
	static Font fontPlain11;
	static int field1933;
	Thread field1930;
	InputStream field1937;
	int field1934;
	byte[] field1932;
	int field1931;
	int field1929;
	IOException field1935;

	class151(final InputStream inputstream_0, final int int_0)
	{
		field1931 = 0;
		field1929 = 0;
		field1937 = inputstream_0;
		field1934 = int_0 + 1;
		field1932 = new byte[field1934];
		field1930 = new Thread(this);
		field1930.setDaemon(true);
		field1930.start();
	}

	boolean method3219(final int int_0) throws IOException
	{
		if (int_0 == 0)
		{
			return true;
		}
		else if ((int_0 > 0) && (int_0 < field1934))
		{
			synchronized (this)
			{
				int int_1;
				if (field1931 <= field1929)
				{
					int_1 = field1929 - field1931;
				}
				else
				{
					int_1 = (field1934 - field1931) + field1929;
				}

				if (int_1 < int_0)
				{
					if (field1935 != null)
					{
						throw new IOException(field1935.toString());
					}
					else
					{
						notifyAll();
						return false;
					}
				}
				else
				{
					return true;
				}
			}
		}
		else
		{
			throw new IOException();
		}
	}

	int method3217() throws IOException
	{
		synchronized (this)
		{
			int int_0;
			if (field1931 <= field1929)
			{
				int_0 = field1929 - field1931;
			}
			else
			{
				int_0 = (field1934 - field1931) + field1929;
			}

			if ((int_0 <= 0) && (field1935 != null))
			{
				throw new IOException(field1935.toString());
			}
			else
			{
				notifyAll();
				return int_0;
			}
		}
	}

	int method3218() throws IOException
	{
		synchronized (this)
		{
			if (field1931 == field1929)
			{
				if (field1935 != null)
				{
					throw new IOException(field1935.toString());
				}
				else
				{
					return -1;
				}
			}
			else
			{
				final int int_0 = field1932[field1931] & 0xFF;
				field1931 = (field1931 + 1) % field1934;
				notifyAll();
				return int_0;
			}
		}
	}

	int method3224(final byte[] bytes_0, final int int_0, int int_1) throws IOException
	{
		if ((int_1 >= 0) && (int_0 >= 0) && ((int_1 + int_0) <= bytes_0.length))
		{
			synchronized (this)
			{
				int int_2;
				if (field1931 <= field1929)
				{
					int_2 = field1929 - field1931;
				}
				else
				{
					int_2 = (field1934 - field1931) + field1929;
				}

				if (int_1 > int_2)
				{
					int_1 = int_2;
				}

				if ((int_1 == 0) && (field1935 != null))
				{
					throw new IOException(field1935.toString());
				}
				else
				{
					if ((int_1 + field1931) <= field1934)
					{
						System.arraycopy(field1932, field1931, bytes_0, int_0, int_1);
					}
					else
					{
						final int int_3 = field1934 - field1931;
						System.arraycopy(field1932, field1931, bytes_0, int_0, int_3);
						System.arraycopy(field1932, 0, bytes_0, int_3 + int_0, int_1 - int_3);
					}

					field1931 = (int_1 + field1931) % field1934;
					notifyAll();
					return int_1;
				}
			}
		}
		else
		{
			throw new IOException();
		}
	}

	void method3215()
	{
		synchronized (this)
		{
			if (field1935 == null)
			{
				field1935 = new IOException("");
			}

			notifyAll();
		}

		try
		{
			field1930.join();
		}
		catch (final InterruptedException interruptedexception_0)
		{
        }

	}

	@Override
	public void run()
	{
		while (true)
		{
			int int_0;
			synchronized (this)
			{
				while (true)
				{
					if (field1935 != null)
					{
						return;
					}

					if (field1931 == 0)
					{
						int_0 = field1934 - field1929 - 1;
					}
					else if (field1931 <= field1929)
					{
						int_0 = field1934 - field1929;
					}
					else
					{
						int_0 = field1931 - field1929 - 1;
					}

					if (int_0 > 0)
					{
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

			int int_1;
			try
			{
				int_1 = field1937.read(field1932, field1929, int_0);
				if (int_1 == -1)
				{
					throw new EOFException();
				}
			}
			catch (final IOException ioexception_0)
			{
				final IOException ioexception_1 = ioexception_0;
				synchronized (this)
				{
					field1935 = ioexception_1;
					return;
				}
			}

			synchronized (this)
			{
				field1929 = (int_1 + field1929) % field1934;
			}
		}
	}

	static File method3238(final String string_0)
	{
		if (!class158.field1979)
		{
			throw new RuntimeException("");
		}
		else
		{
			final File file_0 = (File) class158.field1975.get(string_0);
			if (file_0 != null)
			{
				return file_0;
			}
			else
			{
				final File file_1 = new File(class158.field1974, string_0);
				RandomAccessFile randomaccessfile_0 = null;

				try
				{
					final File file_2 = new File(file_1.getParent());
					if (!file_2.exists())
					{
						throw new RuntimeException("");
					}
					else
					{
						randomaccessfile_0 = new RandomAccessFile(file_1, "rw");
						final int int_0 = randomaccessfile_0.read();
						randomaccessfile_0.seek(0L);
						randomaccessfile_0.write(int_0);
						randomaccessfile_0.seek(0L);
						randomaccessfile_0.close();
						class158.field1975.put(string_0, file_1);
						return file_1;
					}
				}
				catch (final Exception exception_0)
				{
					try
					{
						if (randomaccessfile_0 != null)
						{
							randomaccessfile_0.close();
							randomaccessfile_0 = null;
						}
					}
					catch (final Exception exception_1)
					{
                    }

					throw new RuntimeException();
				}
			}
		}
	}

	static int method3240(final int int_0, final Script script_0, final boolean bool_0)
	{
		if (int_0 == 6200)
		{
			class69.intStackSize -= 2;
			Game.minFov = (short) Math.pow(2.0D, (double)(7.0F + (float)class69.intStack[class69.intStackSize] / 256.0F));
			if (Game.minFov <= 0)
			{
				Game.minFov = 256;
			}

			Game.maxFov = (short) Math.pow(2.0D, (double)(7.0F + (float)class69.intStack[class69.intStackSize + 1] / 256.0F));
			if (Game.maxFov <= 0)
			{
				Game.maxFov = 205;
			}

			return 1;
		}
		else if (int_0 == 6201)
		{
			class69.intStackSize -= 2;
			Game.minZoom = (short) class69.intStack[class69.intStackSize];
			if (Game.minZoom <= 0)
			{
				Game.minZoom = 256;
			}

			Game.maxZoom = (short) class69.intStack[class69.intStackSize + 1];
			if (Game.maxZoom <= 0)
			{
				Game.maxZoom = 320;
			}

			return 1;
		}
		else if (int_0 == 6202)
		{
			class69.intStackSize -= 4;
			Game.field832 = (short) class69.intStack[class69.intStackSize];
			if (Game.field832 <= 0)
			{
				Game.field832 = 1;
			}

			Game.field833 = (short) class69.intStack[class69.intStackSize + 1];
			if (Game.field833 <= 0)
			{
				Game.field833 = 32767;
			}
			else if (Game.field833 < Game.field832)
			{
				Game.field833 = Game.field832;
			}

			Game.field834 = (short) class69.intStack[class69.intStackSize + 2];
			if (Game.field834 <= 0)
			{
				Game.field834 = 1;
			}

			Game.field835 = (short) class69.intStack[class69.intStackSize + 3];
			if (Game.field835 <= 0)
			{
				Game.field835 = 32767;
			}
			else if (Game.field835 < Game.field834)
			{
				Game.field835 = Game.field834;
			}

			return 1;
		}
		else if (int_0 == 6203)
		{
			if (Game.field784 != null)
			{
				class43.method714(0, 0, Game.field784.width, Game.field784.height, false);
				class69.intStack[++class69.intStackSize - 1] = Game.viewportWidth;
				class69.intStack[++class69.intStackSize - 1] = Game.viewportHeight;
			}
			else
			{
				class69.intStack[++class69.intStackSize - 1] = -1;
				class69.intStack[++class69.intStackSize - 1] = -1;
			}

			return 1;
		}
		else if (int_0 == 6204)
		{
			class69.intStack[++class69.intStackSize - 1] = Game.minZoom;
			class69.intStack[++class69.intStackSize - 1] = Game.maxZoom;
			return 1;
		}
		else if (int_0 == 6205)
		{
			class69.intStack[++class69.intStackSize - 1] = (int)((Math.log((double)Game.minFov) / LOG_2 - 7.0D) * 256.0D);
			class69.intStack[++class69.intStackSize - 1] = (int)((Math.log((double)Game.maxFov) / LOG_2 - 7.0D) * 256.0D);
			return 1;
		}
		else
		{
			return 2;
		}
	}

	static String method3239(final Widget widget_0)
	{
		return Signlink.method3252(class24.getWidgetClickMask(widget_0)) == 0 ? null
		        : ((widget_0.targetVerb != null) && (widget_0.targetVerb.trim().length() != 0) ? widget_0.targetVerb
		                : null);
	}

}
