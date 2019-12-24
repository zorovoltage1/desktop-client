public class MachineInfo extends Node
{

	int osType;
	boolean os64Bit;
	int osVersionType;
	int javaVendorType;
	int javaVersionMajor;
	int javaVersionMinor;
	int javaVersionPatch;
	boolean field3891;
	int maxMemoryMB;
	int field3902;
	int field3906;
	int field3904;
	String field3905;
	String field3914;
	String field3907;
	String field3908;
	int field3909;
	int field3910;
	int field3889;
	int field3912;
	String field3913;
	String field3894;
	int[] field3915;
	int field3916;

	public MachineInfo(final boolean bool_0)
	{
		field3915 = new int[3];
		if (ContextMenuRow.osNameLC.startsWith("win"))
		{
			osType = 1;
		}
		else if (ContextMenuRow.osNameLC.startsWith("mac"))
		{
			osType = 2;
		}
		else if (ContextMenuRow.osNameLC.startsWith("linux"))
		{
			osType = 3;
		}
		else
		{
			osType = 4;
		}

		String string_0;
		try
		{
			string_0 = System.getProperty("os.arch").toLowerCase();
		}
		catch (final Exception exception_0)
		{
			string_0 = "";
		}

		String string_2;
		try
		{
			string_2 = System.getProperty("os.version").toLowerCase();
		}
		catch (final Exception exception_1)
		{
			string_2 = "";
		}

		String string_1 = "Unknown";
		String string_3 = "1.1";

		try
		{
			string_1 = System.getProperty("java.vendor");
			string_3 = System.getProperty("java.version");
		}
		catch (final Exception exception_2)
		{
        }

        os64Bit = string_0.startsWith("amd64") || string_0.startsWith("x86_64");

		if (osType == 1)
		{
			if (string_2.indexOf("4.0") != -1)
			{
				osVersionType = 1;
			}
			else if (string_2.indexOf("4.1") != -1)
			{
				osVersionType = 2;
			}
			else if (string_2.indexOf("4.9") != -1)
			{
				osVersionType = 3;
			}
			else if (string_2.indexOf("5.0") != -1)
			{
				osVersionType = 4;
			}
			else if (string_2.indexOf("5.1") != -1)
			{
				osVersionType = 5;
			}
			else if (string_2.indexOf("5.2") != -1)
			{
				osVersionType = 8;
			}
			else if (string_2.indexOf("6.0") != -1)
			{
				osVersionType = 6;
			}
			else if (string_2.indexOf("6.1") != -1)
			{
				osVersionType = 7;
			}
			else if (string_2.indexOf("6.2") != -1)
			{
				osVersionType = 9;
			}
			else if (string_2.indexOf("6.3") != -1)
			{
				osVersionType = 10;
			}
			else if (string_2.indexOf("10.0") != -1)
			{
				osVersionType = 11;
			}
		}
		else if (osType == 2)
		{
			if (string_2.indexOf("10.4") != -1)
			{
				osVersionType = 20;
			}
			else if (string_2.indexOf("10.5") != -1)
			{
				osVersionType = 21;
			}
			else if (string_2.indexOf("10.6") != -1)
			{
				osVersionType = 22;
			}
			else if (string_2.indexOf("10.7") != -1)
			{
				osVersionType = 23;
			}
			else if (string_2.indexOf("10.8") != -1)
			{
				osVersionType = 24;
			}
			else if (string_2.indexOf("10.9") != -1)
			{
				osVersionType = 25;
			}
			else if (string_2.indexOf("10.10") != -1)
			{
				osVersionType = 26;
			}
			else if (string_2.indexOf("10.11") != -1)
			{
				osVersionType = 27;
			}
		}

		if (string_1.toLowerCase().indexOf("sun") != -1)
		{
			javaVendorType = 1;
		}
		else if (string_1.toLowerCase().indexOf("microsoft") != -1)
		{
			javaVendorType = 2;
		}
		else if (string_1.toLowerCase().indexOf("apple") != -1)
		{
			javaVendorType = 3;
		}
		else if (string_1.toLowerCase().indexOf("oracle") != -1)
		{
			javaVendorType = 5;
		}
		else
		{
			javaVendorType = 4;
		}

		int int_0 = 2;
		int int_1 = 0;

		char char_0;
		try
		{
			while (int_0 < string_3.length())
			{
				char_0 = string_3.charAt(int_0);
				if ((char_0 < 48) || (char_0 > 57))
				{
					break;
				}

				int_1 = (int_1 * 10) + (char_0 - 48);
				++int_0;
			}
		}
		catch (final Exception exception_3)
		{
        }

		javaVersionMajor = int_1;
		int_0 = string_3.indexOf(46, 2) + 1;
		int_1 = 0;

		try
		{
			while (int_0 < string_3.length())
			{
				char_0 = string_3.charAt(int_0);
				if ((char_0 < 48) || (char_0 > 57))
				{
					break;
				}

				int_1 = (int_1 * 10) + (char_0 - 48);
				++int_0;
			}
		}
		catch (final Exception exception_4)
		{
        }

		javaVersionMinor = int_1;
		int_0 = string_3.indexOf(95, 4) + 1;
		int_1 = 0;

		try
		{
			while (int_0 < string_3.length())
			{
				char_0 = string_3.charAt(int_0);
				if ((char_0 < 48) || (char_0 > 57))
				{
					break;
				}

				int_1 = (int_1 * 10) + (char_0 - 48);
				++int_0;
			}
		}
		catch (final Exception exception_5)
		{
        }

		javaVersionPatch = int_1;
		field3891 = false;
		maxMemoryMB = (int) (Runtime.getRuntime().maxMemory() / 1048576L) + 1;
		if (javaVersionMajor > 3)
		{
			field3902 = Runtime.getRuntime().availableProcessors();
		}
		else
		{
			field3902 = 0;
		}

		field3906 = 0;
		if (field3905 == null)
		{
			field3905 = "";
		}

		if (field3914 == null)
		{
			field3914 = "";
		}

		if (field3907 == null)
		{
			field3907 = "";
		}

		if (field3908 == null)
		{
			field3908 = "";
		}

		if (field3913 == null)
		{
			field3913 = "";
		}

		if (field3894 == null)
		{
			field3894 = "";
		}

		method6211();
	}

	void method6211()
	{
		if (field3905.length() > 40)
		{
			field3905 = field3905.substring(0, 40);
		}

		if (field3914.length() > 40)
		{
			field3914 = field3914.substring(0, 40);
		}

		if (field3907.length() > 10)
		{
			field3907 = field3907.substring(0, 10);
		}

		if (field3908.length() > 10)
		{
			field3908 = field3908.substring(0, 10);
		}

	}

	public void method6217(final Buffer buffer_0)
	{
		buffer_0.putByte(6);
		buffer_0.putByte(osType);
		buffer_0.putByte(os64Bit ? 1 : 0);
		buffer_0.putByte(osVersionType);
		buffer_0.putByte(javaVendorType);
		buffer_0.putByte(javaVersionMajor);
		buffer_0.putByte(javaVersionMinor);
		buffer_0.putByte(javaVersionPatch);
		buffer_0.putByte(field3891 ? 1 : 0);
		buffer_0.putShort(maxMemoryMB);
		buffer_0.putByte(field3902);
		buffer_0.put24bitInt(field3906);
		buffer_0.putShort(field3904);
		buffer_0.putJagString(field3905);
		buffer_0.putJagString(field3914);
		buffer_0.putJagString(field3907);
		buffer_0.putJagString(field3908);
		buffer_0.putByte(field3910);
		buffer_0.putShort(field3909);
		buffer_0.putJagString(field3913);
		buffer_0.putJagString(field3894);
		buffer_0.putByte(field3889);
		buffer_0.putByte(field3912);

		for (int int_0 = 0; int_0 < field3915.length; int_0++)
		{
			buffer_0.putInt(field3915[int_0]);
		}

		buffer_0.putInt(field3916);
	}

	public int method6215()
	{
		final byte byte_0 = 38;
		final String string_0 = field3905;
		final int int_0 = string_0.length() + 2;
		int int_6 = int_0 + byte_0;
		final String string_1 = field3914;
		final int int_1 = string_1.length() + 2;
		int_6 += int_1;
		final String string_2 = field3907;
		final int int_2 = string_2.length() + 2;
		int_6 += int_2;
		final String string_3 = field3908;
		final int int_3 = string_3.length() + 2;
		int_6 += int_3;
		final String string_4 = field3913;
		final int int_4 = string_4.length() + 2;
		int_6 += int_4;
		final String string_5 = field3894;
		final int int_5 = string_5.length() + 2;
		int_6 += int_5;
		return int_6;
	}

}
