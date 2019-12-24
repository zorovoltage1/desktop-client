import java.applet.Applet;

public class RunException extends RuntimeException
{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public static Applet field1938;
	public static String field1939;
	public static int field1940;
	String field1941;
	Throwable parent;

	RunException(final Throwable throwable_0, final String string_0)
	{
		field1941 = string_0;
		parent = throwable_0;
	}

	public static boolean method3247(final int int_0)
	{
		return (int_0 >= WorldMapDecorationType.field2759.rsOrdinal)
		        && (int_0 <= WorldMapDecorationType.field2764.rsOrdinal);
	}

}
