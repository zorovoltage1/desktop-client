import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine.Info;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class SourceDataSoundSystem extends AbstractSoundSystem
{

	AudioFormat audioFormat;
	SourceDataLine source;
	int size;
	byte[] bytes;

	@Override
	protected void vmethod2176()
	{
		audioFormat = new AudioFormat(AbstractSoundSystem.sampleRate, 16, AbstractSoundSystem.audioHighMemory ? 2 : 1,
		        true, false);
		bytes = new byte[256 << (AbstractSoundSystem.audioHighMemory ? 2 : 1)];
	}

	@Override
	protected void create(final int int_0) throws LineUnavailableException
	{
		try
		{
			final Info dataline$info_0 = new Info(SourceDataLine.class, audioFormat,
			        int_0 << (AbstractSoundSystem.audioHighMemory ? 2 : 1));
			source = (SourceDataLine) AudioSystem.getLine(dataline$info_0);
			source.open();
			source.start();
			size = int_0;
		}
		catch (final LineUnavailableException lineunavailableexception_0)
		{
			int int_1 = ((int_0 >>> 1) & 0x55555555) + (int_0 & 0x55555555);
			int_1 = ((int_1 >>> 2) & 0x33333333) + (int_1 & 0x33333333);
			int_1 = ((int_1 >>> 4) + int_1) & 0xF0F0F0F;
			int_1 += int_1 >>> 8;
			int_1 += int_1 >>> 16;
			final int int_2 = int_1 & 0xFF;
			if (int_2 != 1)
			{
				create(class146.nextPowerOfTwo(int_0));
			}
			else
			{
				source = null;
				throw lineunavailableexception_0;
			}
		}
	}

	@Override
	protected int size()
	{
		return size - (source.available() >> (AbstractSoundSystem.audioHighMemory ? 2 : 1));
	}

	@Override
	protected void write()
	{
		int int_0 = 256;
		if (AbstractSoundSystem.audioHighMemory)
		{
			int_0 <<= 1;
		}

		for (int int_1 = 0; int_1 < int_0; int_1++)
		{
			int int_2 = super.samples[int_1];
			if (((int_2 + 8388608) & 0xFF000000) != 0)
			{
				int_2 = 0x7FFFFF ^ (int_2 >> 31);
			}

			bytes[int_1 * 2] = (byte) (int_2 >> 8);
			bytes[(int_1 * 2) + 1] = (byte) (int_2 >> 16);
		}

		source.write(bytes, 0, int_0 << 1);
	}

	@Override
	protected void close()
	{
		if (source != null)
		{
			source.close();
			source = null;
		}

	}

	@Override
	protected void flush()
	{
		source.flush();
	}

}
