import java.net.URL;

public class UrlRequest
{

	static SpritePixels mapedge;
	final URL url;
	boolean isDone0;
	byte[] response0;

	UrlRequest(final URL url_0)
	{
		url = url_0;
	}

	public boolean isDone()
	{
		return isDone0;
	}

	public byte[] getResponse()
	{
		return response0;
	}

}
