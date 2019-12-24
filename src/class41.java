import java.applet.Applet;

import netscape.javascript.JSObject;

public class class41
{

	public static Object method702(final Applet applet_0, final String string_0) {
		return JSObject.getWindow(applet_0).call(string_0, null);
	}

	public static Object method700(final Applet applet_0, final String string_0, final Object[] objects_0) {
		return JSObject.getWindow(applet_0).call(string_0, objects_0);
	}

}
