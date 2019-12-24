import java.util.zip.CRC32;

public class IndexData extends IndexDataBase
{

	static CRC32 crc32;
	static int field3192;
	IndexFile indexStore;
	IndexFile referenceStore;
	int index;
	boolean field3188;
	boolean field3191;
	boolean[] validArchives;
	int crcValue;
	int indexReferenceVersion;
	int field3194;

	static
	{
		crc32 = new CRC32();
	}

	public IndexData(final IndexFile indexfile_0, final IndexFile indexfile_1, final int int_0, final boolean bool_0,
	        final boolean bool_1, final boolean bool_2)
	{
		super(bool_0, bool_1);
		field3188 = false;
		field3191 = false;
		field3194 = -1;
		indexStore = indexfile_0;
		referenceStore = indexfile_1;
		index = int_0;
		field3191 = bool_2;
		final int int_1 = index;
		if (class185.NetCache_reference != null)
		{
			class185.NetCache_reference.offset = (int_1 * 8) + 5;
			final int int_2 = class185.NetCache_reference.readInt();
			final int int_3 = class185.NetCache_reference.readInt();
			setInformation(int_2, int_3);
		}
		else
		{
			MapLabel.requestNetFile(null, 255, 255, 0, (byte) 0, true);
			class250.NetCache_indexCaches[int_1] = this;
		}

	}

	@Override
	void vmethod4721(final int int_0)
	{
		class54.method1021(index, int_0);
	}

	@Override
	int archiveLoadPercent(final int int_0)
	{
		if (super.archives[int_0] != null)
		{
			return 100;
		}
		else if (validArchives[int_0])
		{
			return 100;
		}
		else
		{
			final int int_1 = index;
			final long long_0 = (int_1 << 16) + int_0;
			int int_2;
			if ((class250.currentRequest != null) && (long_0 == class250.currentRequest.hash))
			{
				int_2 = ((class301.NetCache_responseArchiveBuffer.offset * 99)
				        / (class301.NetCache_responseArchiveBuffer.payload.length - class250.currentRequest.padding))
				        + 1;
			}
			else
			{
				int_2 = 0;
			}

			return int_2;
		}
	}

	@Override
	void loadArchive(final int int_0)
	{
		if ((indexStore != null) && (validArchives != null) && validArchives[int_0])
		{
			final IndexFile indexfile_0 = indexStore;
			byte[] bytes_0 = null;
			synchronized (IndexStoreActionHandler.IndexStoreActionHandler_requestQueue)
			{
				for (FileSystem filesystem_0 = (FileSystem) IndexStoreActionHandler.IndexStoreActionHandler_requestQueue
				        .getFront(); filesystem_0 != null; filesystem_0 = (FileSystem) IndexStoreActionHandler.IndexStoreActionHandler_requestQueue
				                .getNext())
				{
					if ((int_0 == filesystem_0.hash) && (indexfile_0 == filesystem_0.index) && (filesystem_0.type == 0))
					{
						bytes_0 = filesystem_0.field3149;
						break;
					}
				}
			}

			if (bytes_0 != null)
			{
				load(indexfile_0, int_0, bytes_0, true);
			}
			else
			{
				final byte[] bytes_1 = indexfile_0.read(int_0);
				load(indexfile_0, int_0, bytes_1, true);
			}
		}
		else
		{
			MapLabel.requestNetFile(this, index, int_0, super.archiveCrcs[int_0], (byte) 2, true);
		}

	}

	public int percentage()
	{
		if (field3188)
		{
			return 100;
		}
		else if (super.archives != null)
		{
			return 99;
		}
		else
		{
			final int int_0 = index;
			final long long_0 = int_0 + 16711680;
			int int_1;
			if ((class250.currentRequest != null) && (long_0 == class250.currentRequest.hash))
			{
				int_1 = ((class301.NetCache_responseArchiveBuffer.offset * 99)
				        / (class301.NetCache_responseArchiveBuffer.payload.length - class250.currentRequest.padding))
				        + 1;
			}
			else
			{
				int_1 = 0;
			}

			int int_2 = int_1;
			if (int_1 >= 100)
			{
				int_2 = 99;
			}

			return int_2;
		}
	}

	public void setInformation(final int int_0, final int int_1)
	{
		crcValue = int_0;
		indexReferenceVersion = int_1;
		if (referenceStore != null)
		{
			final int int_2 = index;
			final IndexFile indexfile_0 = referenceStore;
			byte[] bytes_0 = null;
			synchronized (IndexStoreActionHandler.IndexStoreActionHandler_requestQueue)
			{
				for (FileSystem filesystem_0 = (FileSystem) IndexStoreActionHandler.IndexStoreActionHandler_requestQueue
				        .getFront(); filesystem_0 != null; filesystem_0 = (FileSystem) IndexStoreActionHandler.IndexStoreActionHandler_requestQueue
				                .getNext())
				{
					if ((int_2 == filesystem_0.hash) && (indexfile_0 == filesystem_0.index) && (filesystem_0.type == 0))
					{
						bytes_0 = filesystem_0.field3149;
						break;
					}
				}
			}

			if (bytes_0 != null)
			{
				load(indexfile_0, int_2, bytes_0, true);
			}
			else
			{
				final byte[] bytes_1 = indexfile_0.read(int_2);
				load(indexfile_0, int_2, bytes_1, true);
			}
		}
		else
		{
			MapLabel.requestNetFile(this, 255, index, crcValue, (byte) 0, true);
		}

	}

	public void write(final int int_0, final byte[] bytes_0, final boolean bool_0, final boolean bool_1)
	{
		if (bool_0)
		{
			if (field3188)
			{
				throw new RuntimeException();
			}

			if (referenceStore != null)
			{
				final int int_1 = index;
				final IndexFile indexfile_0 = referenceStore;
				final FileSystem filesystem_0 = new FileSystem();
				filesystem_0.type = 0;
				filesystem_0.hash = int_1;
				filesystem_0.field3149 = bytes_0;
				filesystem_0.index = indexfile_0;
				synchronized (IndexStoreActionHandler.IndexStoreActionHandler_requestQueue)
				{
					IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.addFront(filesystem_0);
				}

				PacketBuffer.method3848();
			}

			setIndexReference(bytes_0);
			loadAllLocal();
		}
		else
		{
			bytes_0[bytes_0.length - 2] = (byte) (super.archiveRevisions[int_0] >> 8);
			bytes_0[bytes_0.length - 1] = (byte) super.archiveRevisions[int_0];
			if (indexStore != null)
			{
				final IndexFile indexfile_1 = indexStore;
				final FileSystem filesystem_1 = new FileSystem();
				filesystem_1.type = 0;
				filesystem_1.hash = int_0;
				filesystem_1.field3149 = bytes_0;
				filesystem_1.index = indexfile_1;
				synchronized (IndexStoreActionHandler.IndexStoreActionHandler_requestQueue)
				{
					IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.addFront(filesystem_1);
				}

				PacketBuffer.method3848();
				validArchives[int_0] = true;
			}

			if (bool_1)
			{
				super.archives[int_0] = class159.byteArrayToObject(bytes_0, false);
			}
		}

	}

	void load(final IndexFile indexfile_0, final int int_0, final byte[] bytes_0, final boolean bool_0)
	{
		int int_1;
		if (indexfile_0 == referenceStore)
		{
			if (field3188)
			{
				throw new RuntimeException();
			}
			else if (bytes_0 == null)
			{
				MapLabel.requestNetFile(this, 255, index, crcValue, (byte) 0, true);
			}
			else
			{
				crc32.reset();
				crc32.update(bytes_0, 0, bytes_0.length);
				int_1 = (int) crc32.getValue();
				if (int_1 != crcValue)
				{
					MapLabel.requestNetFile(this, 255, index, crcValue, (byte) 0, true);
				}
				else
				{
					final Buffer buffer_0 = new Buffer(GameEngine.decodeContainer(bytes_0));
					final int int_3 = buffer_0.readUnsignedByte();
					if ((int_3 != 5) && (int_3 != 6))
					{
						throw new RuntimeException(int_3 + "," + index + "," + int_0);
					}
					else
					{
						int int_4 = 0;
						if (int_3 >= 6)
						{
							int_4 = buffer_0.readInt();
						}

						if (int_4 != indexReferenceVersion)
						{
							MapLabel.requestNetFile(this, 255, index, crcValue, (byte) 0, true);
						}
						else
						{
							setIndexReference(bytes_0);
							loadAllLocal();
						}
					}
				}
			}
		}
		else
		{
			if (!bool_0 && (int_0 == field3194))
			{
				field3188 = true;
			}

			if ((bytes_0 != null) && (bytes_0.length > 2))
			{
				crc32.reset();
				crc32.update(bytes_0, 0, bytes_0.length - 2);
				int_1 = (int) crc32.getValue();
				final int int_2 = ((bytes_0[bytes_0.length - 2] & 0xFF) << 8) + (bytes_0[bytes_0.length - 1] & 0xFF);
				if ((int_1 == super.archiveCrcs[int_0]) && (int_2 == super.archiveRevisions[int_0]))
				{
					validArchives[int_0] = true;
					if (bool_0)
					{
						super.archives[int_0] = class159.byteArrayToObject(bytes_0, false);
					}

				}
				else
				{
					validArchives[int_0] = false;
					if (field3191 || bool_0)
					{
						MapLabel.requestNetFile(this, index, int_0, super.archiveCrcs[int_0], (byte) 2, bool_0);
					}

				}
			}
			else
			{
				validArchives[int_0] = false;
				if (field3191 || bool_0)
				{
					MapLabel.requestNetFile(this, index, int_0, super.archiveCrcs[int_0], (byte) 2, bool_0);
				}

			}
		}
	}

	void loadAllLocal()
	{
		validArchives = new boolean[super.archives.length];

		int int_0;
		for (int_0 = 0; int_0 < validArchives.length; int_0++)
		{
			validArchives[int_0] = false;
		}

		if (indexStore == null)
		{
			field3188 = true;
		}
		else
		{
			field3194 = -1;

			for (int_0 = 0; int_0 < validArchives.length; int_0++)
			{
				if (super.archiveNumberOfFiles[int_0] > 0)
				{
					final IndexFile indexfile_0 = indexStore;
					final FileSystem filesystem_0 = new FileSystem();
					filesystem_0.type = 1;
					filesystem_0.hash = int_0;
					filesystem_0.index = indexfile_0;
					filesystem_0.data = this;
					synchronized (IndexStoreActionHandler.IndexStoreActionHandler_requestQueue)
					{
						IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.addFront(filesystem_0);
					}

					PacketBuffer.method3848();
					field3194 = int_0;
				}
			}

			if (field3194 == -1)
			{
				field3188 = true;
			}

		}
	}

	public boolean method4725(final int int_0)
	{
		return validArchives[int_0];
	}

	public boolean method4734(final int int_0)
	{
		return getChilds(int_0) != null;
	}

	public int loadPercent()
	{
		int int_0 = 0;
		int int_1 = 0;

		int int_2;
		for (int_2 = 0; int_2 < super.archives.length; int_2++)
		{
			if (super.archiveNumberOfFiles[int_2] > 0)
			{
				int_0 += 100;
				int_1 += archiveLoadPercent(int_2);
			}
		}

		if (int_0 == 0)
		{
			return 100;
		}
		else
		{
			int_2 = (int_1 * 100) / int_0;
			return int_2;
		}
	}

}
