public class RawAudioNode extends AbstractIntegerNode0
{

	public int sampleRate;
	public byte[] audioBuffer;
	public int startPosition;
	int endPosition;
	public boolean field1281;

	RawAudioNode(final int int_0, final byte[] bytes_0, final int int_1, final int int_2)
	{
		sampleRate = int_0;
		audioBuffer = bytes_0;
		startPosition = int_1;
		endPosition = int_2;
	}

	RawAudioNode(final int int_0, final byte[] bytes_0, final int int_1, final int int_2, final boolean bool_0)
	{
		sampleRate = int_0;
		audioBuffer = bytes_0;
		startPosition = int_1;
		endPosition = int_2;
		field1281 = bool_0;
	}

	public RawAudioNode applyResampler(final Resampler resampler_0)
	{
		audioBuffer = resampler_0.resampleIfNecessary(audioBuffer);
		sampleRate = resampler_0.method2240(sampleRate);
		if (startPosition == endPosition)
		{
			startPosition = endPosition = resampler_0.method2241(startPosition);
		}
		else
		{
			startPosition = resampler_0.method2241(startPosition);
			endPosition = resampler_0.method2241(endPosition);
			if (startPosition == endPosition)
			{
				--startPosition;
			}
		}

		return this;
	}

}
