import java.io.EOFException;
import java.io.IOException;

public class CacheFile
{

	static int cameraX;
	static int field1428;
	FileOnDisk accessFile;
	byte[] readPayload;
	long field1417;
	int field1421;
	byte[] writePayload;
	long field1420;
	int field1426;
	long position;
	long length;
	long capacity;
	long field1427;

	public CacheFile(final FileOnDisk fileondisk_0, final int int_0, final int int_1) throws IOException
	{
		field1417 = -1L;
		field1420 = -1L;
		field1426 = 0;
		accessFile = fileondisk_0;
		capacity = length = fileondisk_0.length();
		readPayload = new byte[int_0];
		writePayload = new byte[int_1];
		position = 0L;
	}

	public void close() throws IOException
	{
		flush();
		accessFile.close();
	}

	public void seek(final long long_0) throws IOException
	{
		if (long_0 < 0L)
		{
			throw new IOException("");
		}
		else
		{
			position = long_0;
		}
	}

	public long length()
	{
		return capacity;
	}

	public void read(final byte[] bytes_0) throws IOException
	{
		this.read(bytes_0, 0, bytes_0.length);
	}

	public void read(final byte[] bytes_0, int int_0, int int_1) throws IOException
	{
		try
		{
			if ((int_1 + int_0) > bytes_0.length)
			{
				throw new ArrayIndexOutOfBoundsException((int_1 + int_0) - bytes_0.length);
			}

			if ((field1420 != -1L) && (position >= field1420) && ((position + int_1) <= (field1426 + field1420)))
			{
				System.arraycopy(writePayload, (int) (position - field1420), bytes_0, int_0, int_1);
				position += int_1;
				return;
			}

			final long long_0 = position;
			final int int_2 = int_1;
			int int_3;
			if ((position >= field1417) && (position < (field1421 + field1417)))
			{
				int_3 = (int) (field1421 - (position - field1417));
				if (int_3 > int_1)
				{
					int_3 = int_1;
				}

				System.arraycopy(readPayload, (int) (position - field1417), bytes_0, int_0, int_3);
				position += int_3;
				int_0 += int_3;
				int_1 -= int_3;
			}

			if (int_1 > readPayload.length)
			{
				accessFile.seek(position);

				for (field1427 = position; int_1 > 0; int_1 -= int_3)
				{
					int_3 = accessFile.read(bytes_0, int_0, int_1);
					if (int_3 == -1)
					{
						break;
					}

					field1427 += int_3;
					position += int_3;
					int_0 += int_3;
				}
			}
			else if (int_1 > 0)
			{
				load();
				int_3 = int_1;
				if (int_1 > field1421)
				{
					int_3 = field1421;
				}

				System.arraycopy(readPayload, 0, bytes_0, int_0, int_3);
				int_0 += int_3;
				int_1 -= int_3;
				position += int_3;
			}

			if (field1420 != -1L)
			{
				if ((field1420 > position) && (int_1 > 0))
				{
					int_3 = int_0 + (int) (field1420 - position);
					if (int_3 > (int_1 + int_0))
					{
						int_3 = int_1 + int_0;
					}

					while (int_0 < int_3)
					{
						bytes_0[int_0++] = 0;
						--int_1;
						++position;
					}
				}

				long long_1 = -1L;
				long long_2 = -1L;
				if ((field1420 >= long_0) && (field1420 < (long_0 + int_2)))
				{
					long_1 = field1420;
				}
				else if ((long_0 >= field1420) && (long_0 < (field1420 + field1426)))
				{
					long_1 = long_0;
				}

				if (((field1426 + field1420) > long_0) && ((field1420 + field1426) <= (long_0 + int_2)))
				{
					long_2 = field1420 + field1426;
				}
				else if (((int_2 + long_0) > field1420) && ((long_0 + int_2) <= (field1426 + field1420)))
				{
					long_2 = int_2 + long_0;
				}

				if ((long_1 > -1L) && (long_2 > long_1))
				{
					final int int_4 = (int) (long_2 - long_1);
					System.arraycopy(writePayload, (int) (long_1 - field1420), bytes_0, (int) (long_1 - long_0) + int_0,
					        int_4);
					if (long_2 > position)
					{
						int_1 = (int) (int_1 - (long_2 - position));
						position = long_2;
					}
				}
			}
		}
		catch (final IOException ioexception_0)
		{
			field1427 = -1L;
			throw ioexception_0;
		}

		if (int_1 > 0)
		{
			throw new EOFException();
		}
	}

	void load() throws IOException
	{
		field1421 = 0;
		if (field1427 != position)
		{
			accessFile.seek(position);
			field1427 = position;
		}

		int int_0;
		for (field1417 = position; field1421 < readPayload.length; field1421 += int_0)
		{
			int_0 = accessFile.read(readPayload, field1421, readPayload.length - field1421);
			if (int_0 == -1)
			{
				break;
			}

			field1427 += int_0;
		}

	}

	public void write(final byte[] bytes_0, int int_0, int int_1) throws IOException
	{
		try
		{
			if ((int_1 + position) > capacity)
			{
				capacity = int_1 + position;
			}

			if ((field1420 != -1L) && ((position < field1420) || (position > (field1420 + field1426))))
			{
				flush();
			}

			if ((field1420 != -1L) && ((position + int_1) > (writePayload.length + field1420)))
			{
				final int int_2 = (int) (writePayload.length - (position - field1420));
				System.arraycopy(bytes_0, int_0, writePayload, (int) (position - field1420), int_2);
				position += int_2;
				int_0 += int_2;
				int_1 -= int_2;
				field1426 = writePayload.length;
				flush();
			}

			if (int_1 <= writePayload.length)
			{
				if (int_1 > 0)
				{
					if (field1420 == -1L)
					{
						field1420 = position;
					}

					System.arraycopy(bytes_0, int_0, writePayload, (int) (position - field1420), int_1);
					position += int_1;
					if ((position - field1420) > field1426)
					{
						field1426 = (int) (position - field1420);
					}

				}
			}
			else
			{
				if (field1427 != position)
				{
					accessFile.seek(position);
					field1427 = position;
				}

				accessFile.write(bytes_0, int_0, int_1);
				field1427 += int_1;
				if (field1427 > length)
				{
					length = field1427;
				}

				long long_0 = -1L;
				long long_1 = -1L;
				if ((position >= field1417) && (position < (field1417 + field1421)))
				{
					long_0 = position;
				}
				else if ((field1417 >= position) && (field1417 < (position + int_1)))
				{
					long_0 = field1417;
				}

				if (((int_1 + position) > field1417) && ((int_1 + position) <= (field1421 + field1417)))
				{
					long_1 = int_1 + position;
				}
				else if (((field1421 + field1417) > position) && ((field1417 + field1421) <= (position + int_1)))
				{
					long_1 = field1421 + field1417;
				}

				if ((long_0 > -1L) && (long_1 > long_0))
				{
					final int int_3 = (int) (long_1 - long_0);
					System.arraycopy(bytes_0, (int) ((long_0 + int_0) - position), readPayload,
					        (int) (long_0 - field1417), int_3);
				}

				position += int_1;
			}
		}
		catch (final IOException ioexception_0)
		{
			field1427 = -1L;
			throw ioexception_0;
		}
	}

	void flush() throws IOException
	{
		if (field1420 != -1L)
		{
			if (field1420 != field1427)
			{
				accessFile.seek(field1420);
				field1427 = field1420;
			}

			accessFile.write(writePayload, 0, field1426);
			field1427 += field1426 * 1776216003 * 2034614507L;
			if (field1427 > length)
			{
				length = field1427;
			}

			long long_0 = -1L;
			long long_1 = -1L;
			if ((field1420 >= field1417) && (field1420 < (field1417 + field1421)))
			{
				long_0 = field1420;
			}
			else if ((field1417 >= field1420) && (field1417 < (field1426 + field1420)))
			{
				long_0 = field1417;
			}

			if (((field1426 + field1420) > field1417) && ((field1420 + field1426) <= (field1421 + field1417)))
			{
				long_1 = field1426 + field1420;
			}
			else if (((field1421 + field1417) > field1420) && ((field1421 + field1417) <= (field1426 + field1420)))
			{
				long_1 = field1421 + field1417;
			}

			if ((long_0 > -1L) && (long_1 > long_0))
			{
				final int int_0 = (int) (long_1 - long_0);
				System.arraycopy(writePayload, (int) (long_0 - field1420), readPayload, (int) (long_0 - field1417),
				        int_0);
			}

			field1420 = -1L;
			field1426 = 0;
		}

	}

	static int method2503(final World world_0, final World world_1, final int int_0, final boolean bool_0,
	        final int int_1, final boolean bool_1)
	{
		final int int_2 = class26.method428(world_0, world_1, int_0, bool_0);
		if (int_2 != 0)
		{
			return bool_0 ? -int_2 : int_2;
		}
		else if (int_1 == -1)
		{
			return 0;
		}
		else
		{
			final int int_3 = class26.method428(world_0, world_1, int_1, bool_1);
			return bool_1 ? -int_3 : int_3;
		}
	}

	public static int method2484(final long long_0)
	{
		return (int) ((long_0 >>> 7) & 0x7FL);
	}

}
