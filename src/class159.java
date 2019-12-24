import java.io.IOException;
import java.net.Socket;

public class class159 extends class157
{

	Socket field1982;
	class151 field1980;
	GameSocket field1983;

	class159(final Socket socket_0, final int int_0, final int int_1) throws IOException
	{
		field1982 = socket_0;
		field1982.setSoTimeout(30000);
		field1982.setTcpNoDelay(true);
		field1982.setReceiveBufferSize(65536);
		field1982.setSendBufferSize(65536);
		field1980 = new class151(field1982.getInputStream(), int_0);
		field1983 = new GameSocket(field1982.getOutputStream(), int_1);
	}

	@Override
	public boolean vmethod3350(final int int_0) throws IOException
	{
		return field1980.method3219(int_0);
	}

	@Override
	public int vmethod3349() throws IOException
	{
		return field1980.method3217();
	}

	@Override
	public int vmethod3353() throws IOException
	{
		return field1980.method3218();
	}

	@Override
	public int vmethod3351(final byte[] bytes_0, final int int_0, final int int_1) throws IOException
	{
		return field1980.method3224(bytes_0, int_0, int_1);
	}

	@Override
	public void vmethod3347(final byte[] bytes_0, final int int_0, final int int_1) throws IOException
	{
		field1983.read(bytes_0, int_0, int_1);
	}

	@Override
	public void vmethod3346()
	{
		field1983.method3384();

		try
		{
			field1982.close();
		}
		catch (final IOException ioexception_0)
		{
        }

		field1980.method3215();
	}

	@Override
	protected void finalize()
	{
		vmethod3346();
	}

	public static Object byteArrayToObject(final byte[] bytes_0, final boolean bool_0)
	{
		if (bytes_0 == null)
		{
			return null;
		}
		else
		{
			if ((bytes_0.length > 136) && !AbstractByteBuffer.directBufferUnavailable)
			{
				try
				{
					final DirectByteBuffer directbytebuffer_0 = new DirectByteBuffer();
					directbytebuffer_0.put(bytes_0);
					return directbytebuffer_0;
				}
				catch (final Throwable throwable_0)
				{
					AbstractByteBuffer.directBufferUnavailable = true;
				}
			}

			return bytes_0;
		}
	}

}
