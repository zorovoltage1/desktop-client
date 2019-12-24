import java.io.EOFException;
import java.io.IOException;

public final class IndexFile
{

	static byte[] IndexStore_buffer;
	CacheFile dataFile;
	CacheFile indexFile;
	int index;
	int maxSize;

	static
	{
		IndexStore_buffer = new byte[520];
	}

	public IndexFile(final int int_0, final CacheFile cachefile_0, final CacheFile cachefile_1, final int int_1)
	{
		dataFile = null;
		indexFile = null;
		maxSize = 65000;
		index = int_0;
		dataFile = cachefile_0;
		indexFile = cachefile_1;
		maxSize = int_1;
	}

	public byte[] read(final int int_0)
	{
		synchronized (dataFile)
		{
			try
			{
				Object object_0;
				if (indexFile.length() < (int_0 * 6) + 6)
				{
					object_0 = null;
					return (byte[]) object_0;
				}
				else
				{
					indexFile.seek(int_0 * 6);
					indexFile.read(IndexStore_buffer, 0, 6);
					final int int_1 = ((IndexStore_buffer[0] & 0xFF) << 16) + (IndexStore_buffer[2] & 0xFF)
					        + ((IndexStore_buffer[1] & 0xFF) << 8);
					int int_2 = (IndexStore_buffer[5] & 0xFF) + ((IndexStore_buffer[3] & 0xFF) << 16)
					        + ((IndexStore_buffer[4] & 0xFF) << 8);
					if ((int_1 < 0) || (int_1 > maxSize))
					{
						object_0 = null;
						return (byte[]) object_0;
					}
					else if ((int_2 <= 0) || (int_2 > (dataFile.length() / 520L)))
					{
						object_0 = null;
						return (byte[]) object_0;
					}
					else
					{
						final byte[] bytes_0 = new byte[int_1];
						int int_3 = 0;
						int int_4 = 0;

						while (int_3 < int_1)
						{
							if (int_2 == 0)
							{
								object_0 = null;
								return (byte[]) object_0;
							}

							dataFile.seek(int_2 * 520);
							int int_5 = int_1 - int_3;
							if (int_5 > 512)
							{
								int_5 = 512;
							}

							dataFile.read(IndexStore_buffer, 0, int_5 + 8);
							final int int_6 = (IndexStore_buffer[1] & 0xFF) + ((IndexStore_buffer[0] & 0xFF) << 8);
							final int int_7 = (IndexStore_buffer[3] & 0xFF) + ((IndexStore_buffer[2] & 0xFF) << 8);
							final int int_8 = ((IndexStore_buffer[5] & 0xFF) << 8)
							        + ((IndexStore_buffer[4] & 0xFF) << 16) + (IndexStore_buffer[6] & 0xFF);
							final int int_9 = IndexStore_buffer[7] & 0xFF;
							if ((int_6 == int_0) && (int_4 == int_7) && (int_9 == index))
							{
								if ((int_8 >= 0) && (int_8 <= (dataFile.length() / 520L)))
								{
									for (int int_10 = 0; int_10 < int_5; int_10++)
									{
										bytes_0[int_3++] = IndexStore_buffer[int_10 + 8];
									}

									int_2 = int_8;
									++int_4;
									continue;
								}

								object_0 = null;
								return (byte[]) object_0;
							}

							object_0 = null;
							return (byte[]) object_0;
						}

						final byte[] bytes_1 = bytes_0;
						return bytes_1;
					}
				}
			}
			catch (final IOException ioexception_0)
			{
				return null;
			}
		}
	}

	public boolean write(final int int_0, final byte[] bytes_0, final int int_1)
	{
		synchronized (dataFile)
		{
			if ((int_1 >= 0) && (int_1 <= maxSize))
			{
				boolean bool_0 = write0(int_0, bytes_0, int_1, true);
				if (!bool_0)
				{
					bool_0 = write0(int_0, bytes_0, int_1, false);
				}

				return bool_0;
			}
			else
			{
				throw new IllegalArgumentException();
			}
		}
	}

	boolean write0(final int int_0, final byte[] bytes_0, final int int_1, boolean bool_0)
	{
		synchronized (dataFile)
		{
			try
			{
				int int_2;
				boolean bool_1;
				if (bool_0)
				{
					if (indexFile.length() < (int_0 * 6) + 6)
					{
						bool_1 = false;
						return bool_1;
					}

					indexFile.seek(int_0 * 6);
					indexFile.read(IndexStore_buffer, 0, 6);
					int_2 = (IndexStore_buffer[5] & 0xFF) + ((IndexStore_buffer[3] & 0xFF) << 16)
					        + ((IndexStore_buffer[4] & 0xFF) << 8);
					if ((int_2 <= 0) || (int_2 > (dataFile.length() / 520L)))
					{
						bool_1 = false;
						return bool_1;
					}
				}
				else
				{
					int_2 = (int) ((dataFile.length() + 519L) / 520L);
					if (int_2 == 0)
					{
						int_2 = 1;
					}
				}

				IndexStore_buffer[0] = (byte) (int_1 >> 16);
				IndexStore_buffer[1] = (byte) (int_1 >> 8);
				IndexStore_buffer[2] = (byte) int_1;
				IndexStore_buffer[3] = (byte) (int_2 >> 16);
				IndexStore_buffer[4] = (byte) (int_2 >> 8);
				IndexStore_buffer[5] = (byte) int_2;
				indexFile.seek(int_0 * 6);
				indexFile.write(IndexStore_buffer, 0, 6);
				int int_3 = 0;
				int int_4 = 0;

				while (true)
				{
					if (int_3 < int_1)
					{
						label143:
						{
							int int_5 = 0;
							int int_6;
							if (bool_0)
							{
								dataFile.seek(int_2 * 520);

								try
								{
									dataFile.read(IndexStore_buffer, 0, 8);
								}
								catch (final EOFException eofexception_0)
								{
									break label143;
								}

								int_6 = (IndexStore_buffer[1] & 0xFF) + ((IndexStore_buffer[0] & 0xFF) << 8);
								final int int_7 = (IndexStore_buffer[3] & 0xFF) + ((IndexStore_buffer[2] & 0xFF) << 8);
								int_5 = ((IndexStore_buffer[5] & 0xFF) << 8) + ((IndexStore_buffer[4] & 0xFF) << 16)
								        + (IndexStore_buffer[6] & 0xFF);
								final int int_8 = IndexStore_buffer[7] & 0xFF;
								if ((int_6 != int_0) || (int_4 != int_7) || (int_8 != index))
								{
									bool_1 = false;
									return bool_1;
								}

								if ((int_5 < 0) || (int_5 > (dataFile.length() / 520L)))
								{
									bool_1 = false;
									return bool_1;
								}
							}

							if (int_5 == 0)
							{
								bool_0 = false;
								int_5 = (int) ((dataFile.length() + 519L) / 520L);
								if (int_5 == 0)
								{
									++int_5;
								}

								if (int_5 == int_2)
								{
									++int_5;
								}
							}

							if ((int_1 - int_3) <= 512)
							{
								int_5 = 0;
							}

							IndexStore_buffer[0] = (byte) (int_0 >> 8);
							IndexStore_buffer[1] = (byte) int_0;
							IndexStore_buffer[2] = (byte) (int_4 >> 8);
							IndexStore_buffer[3] = (byte) int_4;
							IndexStore_buffer[4] = (byte) (int_5 >> 16);
							IndexStore_buffer[5] = (byte) (int_5 >> 8);
							IndexStore_buffer[6] = (byte) int_5;
							IndexStore_buffer[7] = (byte) index;
							dataFile.seek(int_2 * 520);
							dataFile.write(IndexStore_buffer, 0, 8);
							int_6 = int_1 - int_3;
							if (int_6 > 512)
							{
								int_6 = 512;
							}

							dataFile.write(bytes_0, int_3, int_6);
							int_3 += int_6;
							int_2 = int_5;
							++int_4;
							continue;
						}
					}

					bool_1 = true;
					return bool_1;
				}
			}
			catch (final IOException ioexception_0)
			{
				return false;
			}
		}
	}

	static void method3380()
	{
		if (Game.field699)
		{
			class11.method98(class138.localPlayer, false);
		}

	}

}
