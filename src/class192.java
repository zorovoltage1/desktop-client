import java.util.Calendar;
import java.util.TimeZone;

public class class192
{

	public static final String[][] MONTHS_ABBREVIATED = new String[][] {
		{ "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" },
		{ "Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez" }
	};
	public static final String[] DAYS_ABBREVIATED = new String[] { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
	public static final Calendar LOCAL_CALENDAR = Calendar.getInstance();
	public static final Calendar GMT_CALENDAR = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
	public static boolean field2391;

	public static void method3871()
	{
		PlayerComposition.field2580.reset();
	}

}
