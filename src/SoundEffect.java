public class SoundEffect
{

	AudioInstrument[] instruments;
	int start;
	int end;

	SoundEffect(final Buffer buffer_0)
	{
		instruments = new AudioInstrument[10];

		for (int int_0 = 0; int_0 < 10; int_0++)
		{
			final int int_1 = buffer_0.readUnsignedByte();
			if (int_1 != 0)
			{
				--buffer_0.offset;
				instruments[int_0] = new AudioInstrument();
				instruments[int_0].decode(buffer_0);
			}
		}

		start = buffer_0.readUnsignedShort();
		end = buffer_0.readUnsignedShort();
	}

	public RawAudioNode method2069()
	{
		final byte[] bytes_0 = mix();
		return new RawAudioNode(22050, bytes_0, (start * 22050) / 1000, (end * 22050) / 1000);
	}

	public int calculateDelay()
	{
		int int_0 = 9999999;

		int int_1;
		for (int_1 = 0; int_1 < 10; int_1++)
		{
			if ((instruments[int_1] != null) && ((instruments[int_1].offset / 20) < int_0))
			{
				int_0 = instruments[int_1].offset / 20;
			}
		}

		if ((start < end) && ((start / 20) < int_0))
		{
			int_0 = start / 20;
		}

		if ((int_0 != 9999999) && (int_0 != 0))
		{
			for (int_1 = 0; int_1 < 10; int_1++)
			{
				if (instruments[int_1] != null)
				{
					instruments[int_1].offset -= int_0 * 20;
				}
			}

			if (start < end)
			{
				start -= int_0 * 20;
				end -= int_0 * 20;
			}

			return int_0;
		}
		else
		{
			return 0;
		}
	}

	byte[] mix()
	{
		int int_0 = 0;

		int int_1;
		for (int_1 = 0; int_1 < 10; int_1++)
		{
			if ((instruments[int_1] != null) && ((instruments[int_1].duration + instruments[int_1].offset) > int_0))
			{
				int_0 = instruments[int_1].duration + instruments[int_1].offset;
			}
		}

		if (int_0 == 0)
		{
			return new byte[0];
		}
		else
		{
			int_1 = (int_0 * 22050) / 1000;
			final byte[] bytes_0 = new byte[int_1];

			for (int int_2 = 0; int_2 < 10; int_2++)
			{
				if (instruments[int_2] != null)
				{
					final int int_3 = (instruments[int_2].duration * 22050) / 1000;
					final int int_4 = (instruments[int_2].offset * 22050) / 1000;
					final int[] ints_0 = instruments[int_2].synthesize(int_3, instruments[int_2].duration);

					for (int int_5 = 0; int_5 < int_3; int_5++)
					{
						int int_6 = (ints_0[int_5] >> 8) + bytes_0[int_5 + int_4];
						if (((int_6 + 128) & 0xFFFFFF00) != 0)
						{
							int_6 = (int_6 >> 31) ^ 0x7F;
						}

						bytes_0[int_5 + int_4] = (byte) int_6;
					}
				}
			}

			return bytes_0;
		}
	}

	public static SoundEffect getTrack(final IndexDataBase indexdatabase_0, final int int_0, final int int_1)
	{
		final byte[] bytes_0 = indexdatabase_0.getConfigData(int_0, int_1);
		return bytes_0 == null ? null : new SoundEffect(new Buffer(bytes_0));
	}

}
