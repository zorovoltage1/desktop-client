public class class98
{

	static int field1335;
	IndexDataBase sfx_index;
	IndexDataBase vorbis_index;
	HashTable field1332;
	HashTable field1333;

	public class98(final IndexDataBase indexdatabase_0, final IndexDataBase indexdatabase_1)
	{
		field1332 = new HashTable(256);
		field1333 = new HashTable(256);
		sfx_index = indexdatabase_0;
		vorbis_index = indexdatabase_1;
	}

	RawAudioNode method2223(final int int_0, final int int_1, final int[] ints_0)
	{
		int int_2 = int_1 ^ (((int_0 << 4) & 0xFFFF) | (int_0 >>> 12));
		int_2 |= int_0 << 16;
		final long long_0 = int_2;
		RawAudioNode rawaudionode_0 = (RawAudioNode) field1333.get(long_0);
		if (rawaudionode_0 != null)
		{
			return rawaudionode_0;
		}
		else if ((ints_0 != null) && (ints_0[0] <= 0))
		{
			return null;
		}
		else
		{
			final SoundEffect soundeffect_0 = SoundEffect.getTrack(sfx_index, int_0, int_1);
			if (soundeffect_0 == null)
			{
				return null;
			}
			else
			{
				rawaudionode_0 = soundeffect_0.method2069();
				field1333.put(rawaudionode_0, long_0);
				if (ints_0 != null)
				{
					ints_0[0] -= rawaudionode_0.audioBuffer.length;
				}

				return rawaudionode_0;
			}
		}
	}

	RawAudioNode method2218(final int int_0, final int int_1, final int[] ints_0)
	{
		int int_2 = int_1 ^ (((int_0 << 4) & 0xFFFF) | (int_0 >>> 12));
		int_2 |= int_0 << 16;
		final long long_0 = int_2 ^ 0x100000000L;
		RawAudioNode rawaudionode_0 = (RawAudioNode) field1333.get(long_0);
		if (rawaudionode_0 != null)
		{
			return rawaudionode_0;
		}
		else if ((ints_0 != null) && (ints_0[0] <= 0))
		{
			return null;
		}
		else
		{
			class92 class92_0 = (class92) field1332.get(long_0);
			if (class92_0 == null)
			{
				class92_0 = class92.getInstrument(vorbis_index, int_0, int_1);
				if (class92_0 == null)
				{
					return null;
				}

				field1332.put(class92_0, long_0);
			}

			rawaudionode_0 = class92_0.method2083(ints_0);
			if (rawaudionode_0 == null)
			{
				return null;
			}
			else
			{
				class92_0.unlink();
				field1333.put(rawaudionode_0, long_0);
				return rawaudionode_0;
			}
		}
	}

	public RawAudioNode method2216(final int int_0, final int[] ints_0)
	{
		if (sfx_index.size() == 1)
		{
			return method2223(0, int_0, ints_0);
		}
		else if (sfx_index.fileCount(int_0) == 1)
		{
			return method2223(int_0, 0, ints_0);
		}
		else
		{
			throw new RuntimeException();
		}
	}

	public RawAudioNode method2220(final int int_0, final int[] ints_0)
	{
		if (vorbis_index.size() == 1)
		{
			return method2218(0, int_0, ints_0);
		}
		else if (vorbis_index.fileCount(int_0) == 1)
		{
			return method2218(int_0, 0, ints_0);
		}
		else
		{
			throw new RuntimeException();
		}
	}

}
