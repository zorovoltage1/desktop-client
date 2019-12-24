import java.nio.ByteBuffer;

public class DirectByteBuffer extends AbstractByteBuffer
{

	ByteBuffer buffer;

	@Override
	byte[] get()
	{
		final byte[] bytes_0 = new byte[buffer.capacity()];
		buffer.position(0);
		buffer.get(bytes_0);
		return bytes_0;
	}

	@Override
	void put(final byte[] bytes_0)
	{
		buffer = ByteBuffer.allocateDirect(bytes_0.length);
		buffer.position(0);
		buffer.put(bytes_0);
	}

}
