import java.io.File;
import java.io.IOException;

public class MapLabel
{

	static Varcs varcs;
	static IndexData indexCache10;
	String text;
	int field184;
	int field182;
	Size fontSize;

	MapLabel(final String string_0, final int int_0, final int int_1, final Size size_0)
	{
		text = string_0;
		field184 = int_0;
		field182 = int_1;
		fontSize = size_0;
	}

	static void requestNetFile(final IndexData indexdata_0, final int int_0, final int int_1, final int int_2,
	        final byte byte_0, final boolean bool_0)
	{
		final long long_0 = (int_0 << 16) + int_1;
		FileRequest filerequest_0 = (FileRequest) class250.NetCache_pendingPriorityWrites.get(long_0);
		if (filerequest_0 == null)
		{
			filerequest_0 = (FileRequest) class250.NetCache_pendingPriorityResponses.get(long_0);
			if (filerequest_0 == null)
			{
				filerequest_0 = (FileRequest) class250.NetCache_pendingWrites.get(long_0);
				if (filerequest_0 != null)
				{
					if (bool_0)
					{
						filerequest_0.unlinkDual();
						class250.NetCache_pendingPriorityWrites.put(filerequest_0, long_0);
						--class250.NetCache_pendingWritesCount;
						++class250.NetCache_pendingPriorityWritesCount;
					}

				}
				else
				{
					if (!bool_0)
					{
						filerequest_0 = (FileRequest) class250.NetCache_pendingResponses.get(long_0);
						if (filerequest_0 != null)
						{
							return;
						}
					}

					filerequest_0 = new FileRequest();
					filerequest_0.index = indexdata_0;
					filerequest_0.crc = int_2;
					filerequest_0.padding = byte_0;
					if (bool_0)
					{
						class250.NetCache_pendingPriorityWrites.put(filerequest_0, long_0);
						++class250.NetCache_pendingPriorityWritesCount;
					}
					else
					{
						class250.NetCache_pendingWritesQueue.push(filerequest_0);
						class250.NetCache_pendingWrites.put(filerequest_0, long_0);
						++class250.NetCache_pendingWritesCount;
					}

				}
			}
		}
	}

	static void method282(final World[] worlds_0, final int int_0, final int int_1, final int[] ints_0,
	        final int[] ints_1)
	{
		if (int_0 < int_1)
		{
			int int_2 = int_0 - 1;
			int int_3 = int_1 + 1;
			final int int_4 = (int_1 + int_0) / 2;
			final World world_0 = worlds_0[int_4];
			worlds_0[int_4] = worlds_0[int_0];
			worlds_0[int_0] = world_0;

			while (int_2 < int_3)
			{
				boolean bool_0 = true;

				int int_5;
				int int_6;
				int int_7;
				do
				{
					--int_3;

					for (int_5 = 0; int_5 < 4; int_5++)
					{
						if (ints_0[int_5] == 2)
						{
							int_6 = worlds_0[int_3].index;
							int_7 = world_0.index;
						}
						else if (ints_0[int_5] == 1)
						{
							int_6 = worlds_0[int_3].playerCount;
							int_7 = world_0.playerCount;
							if ((int_6 == -1) && (ints_1[int_5] == 1))
							{
								int_6 = 2001;
							}

							if ((int_7 == -1) && (ints_1[int_5] == 1))
							{
								int_7 = 2001;
							}
						}
						else if (ints_0[int_5] == 3)
						{
							int_6 = worlds_0[int_3].method1589() ? 1 : 0;
							int_7 = world_0.method1589() ? 1 : 0;
						}
						else
						{
							int_6 = worlds_0[int_3].id;
							int_7 = world_0.id;
						}

						if (int_6 != int_7)
						{
							if (((ints_1[int_5] != 1) || (int_6 <= int_7))
							        && ((ints_1[int_5] != 0) || (int_6 >= int_7)))
							{
								bool_0 = false;
							}
							break;
						}

						if (int_5 == 3)
						{
							bool_0 = false;
						}
					}
				}
				while (bool_0);

				bool_0 = true;

				do
				{
					++int_2;

					for (int_5 = 0; int_5 < 4; int_5++)
					{
						if (ints_0[int_5] == 2)
						{
							int_6 = worlds_0[int_2].index;
							int_7 = world_0.index;
						}
						else if (ints_0[int_5] == 1)
						{
							int_6 = worlds_0[int_2].playerCount;
							int_7 = world_0.playerCount;
							if ((int_6 == -1) && (ints_1[int_5] == 1))
							{
								int_6 = 2001;
							}

							if ((int_7 == -1) && (ints_1[int_5] == 1))
							{
								int_7 = 2001;
							}
						}
						else if (ints_0[int_5] == 3)
						{
							int_6 = worlds_0[int_2].method1589() ? 1 : 0;
							int_7 = world_0.method1589() ? 1 : 0;
						}
						else
						{
							int_6 = worlds_0[int_2].id;
							int_7 = world_0.id;
						}

						if (int_7 != int_6)
						{
							if (((ints_1[int_5] != 1) || (int_6 >= int_7))
							        && ((ints_1[int_5] != 0) || (int_6 <= int_7)))
							{
								bool_0 = false;
							}
							break;
						}

						if (int_5 == 3)
						{
							bool_0 = false;
						}
					}
				}
				while (bool_0);

				if (int_2 < int_3)
				{
					final World world_1 = worlds_0[int_2];
					worlds_0[int_2] = worlds_0[int_3];
					worlds_0[int_3] = world_1;
				}
			}

			method282(worlds_0, int_0, int_3, ints_0, ints_1);
			method282(worlds_0, int_3 + 1, int_1, ints_0, ints_1);
		}

	}

	public static FileOnDisk getPreferencesFile(final String string_0, final String string_1, final boolean bool_0)
	{
		final File file_0 = new File(class155.field1966, "preferences" + string_0 + ".dat");
		if (file_0.exists())
		{
			try
			{
				final FileOnDisk fileondisk_1 = new FileOnDisk(file_0, "rw", 10000L);
				return fileondisk_1;
			}
			catch (final IOException ioexception_1)
			{
            }
		}

		String string_2 = "";
		if (class141.field1885 == 33)
		{
			string_2 = "_rc";
		}
		else if (class141.field1885 == 34)
		{
			string_2 = "_wip";
		}

		final File file_1 = new File(WorldMapType1.userHome,
		        "jagex_" + string_1 + "_preferences" + string_0 + string_2 + ".dat");
		FileOnDisk fileondisk_0;
		if (!bool_0 && file_1.exists())
		{
			try
			{
				fileondisk_0 = new FileOnDisk(file_1, "rw", 10000L);
				return fileondisk_0;
			}
			catch (final IOException ioexception_2)
			{
            }
		}

		try
		{
			fileondisk_0 = new FileOnDisk(file_0, "rw", 10000L);
			return fileondisk_0;
		}
		catch (final IOException ioexception_0)
		{
			throw new RuntimeException();
		}
	}

	static void method281(final Widget widget_0, final int int_0, final int int_1)
	{
		if (widget_0.dynamicX == 0)
		{
			widget_0.relativeX = widget_0.originalX;
		}
		else if (widget_0.dynamicX == 1)
		{
			widget_0.relativeX = widget_0.originalX + ((int_0 - widget_0.width) / 2);
		}
		else if (widget_0.dynamicX == 2)
		{
			widget_0.relativeX = int_0 - widget_0.width - widget_0.originalX;
		}
		else if (widget_0.dynamicX == 3)
		{
			widget_0.relativeX = (widget_0.originalX * int_0) >> 14;
		}
		else if (widget_0.dynamicX == 4)
		{
			widget_0.relativeX = ((int_0 - widget_0.width) / 2) + ((widget_0.originalX * int_0) >> 14);
		}
		else
		{
			widget_0.relativeX = int_0 - widget_0.width - ((widget_0.originalX * int_0) >> 14);
		}

		if (widget_0.dynamicY == 0)
		{
			widget_0.relativeY = widget_0.originalY;
		}
		else if (widget_0.dynamicY == 1)
		{
			widget_0.relativeY = ((int_1 - widget_0.height) / 2) + widget_0.originalY;
		}
		else if (widget_0.dynamicY == 2)
		{
			widget_0.relativeY = int_1 - widget_0.height - widget_0.originalY;
		}
		else if (widget_0.dynamicY == 3)
		{
			widget_0.relativeY = (int_1 * widget_0.originalY) >> 14;
		}
		else if (widget_0.dynamicY == 4)
		{
			widget_0.relativeY = ((int_1 - widget_0.height) / 2) + ((int_1 * widget_0.originalY) >> 14);
		}
		else
		{
			widget_0.relativeY = int_1 - widget_0.height - ((int_1 * widget_0.originalY) >> 14);
		}

	}

}
