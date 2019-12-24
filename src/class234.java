import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

public class class234
{

	public static final boolean[] field2780;
	public static int[] field2779;

	static
	{
		field2780 = new boolean[] { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
		        true, true, true, true, true, true, true, true, true, false, false };
		field2779 = new int[99];
		int int_0 = 0;

		for (int int_1 = 0; int_1 < 99; int_1++)
		{
			final int int_2 = int_1 + 1;
			final int int_3 = (int) (int_2 + (300.0D * Math.pow(2.0D, int_2 / 7.0D)));
			int_0 += int_3;
			field2779[int_1] = int_0 / 4;
		}

	}

	static void method4590()
	{
		class78.username = class78.username.trim();
		if (class78.username.length() == 0)
		{
			GrandExchangeEvent.method22("Please enter your username.", "If you created your account after November",
			        "2010, this will be the creation email address.");
		}
		else
		{
			final long long_0 = Game.method1535();
			byte byte_0;
			if (long_0 == 0L)
			{
				byte_0 = 5;
			}
			else
			{
				final String string_0 = class78.username;
				final Random random_0 = new Random();
				final Buffer buffer_0 = new Buffer(128);
				final Buffer buffer_1 = new Buffer(128);
				final int[] ints_0 = new int[] { random_0.nextInt(), random_0.nextInt(), (int) (long_0 >> 32),
				        (int) long_0 };
				buffer_0.putByte(10);

				int int_0;
				for (int_0 = 0; int_0 < 4; int_0++)
				{
					buffer_0.putInt(random_0.nextInt());
				}

				buffer_0.putInt(ints_0[0]);
				buffer_0.putInt(ints_0[1]);
				buffer_0.putLong(long_0);
				buffer_0.putLong(0L);

				for (int_0 = 0; int_0 < 4; int_0++)
				{
					buffer_0.putInt(random_0.nextInt());
				}

				buffer_0.encryptRsa(class73.field1039, class73.field1044);
				buffer_1.putByte(10);

				for (int_0 = 0; int_0 < 3; int_0++)
				{
					buffer_1.putInt(random_0.nextInt());
				}

				buffer_1.putLong(random_0.nextLong());
				buffer_1.method3584(random_0.nextLong());
				if (Game.field620 != null)
				{
					buffer_1.putBytes(Game.field620, 0, Game.field620.length);
				}
				else
				{
					final byte[] bytes_0 = new byte[24];

					try
					{
						class155.randomDat.seek(0L);
						class155.randomDat.read(bytes_0);

						int int_1;
						for (int_1 = 0; (int_1 < 24) && (bytes_0[int_1] == 0); int_1++)
						{
                        }

						if (int_1 >= 24)
						{
							throw new IOException();
						}
					}
					catch (final Exception exception_0)
					{
						for (int int_2 = 0; int_2 < 24; int_2++)
						{
							bytes_0[int_2] = -1;
						}
					}

					buffer_1.putBytes(bytes_0, 0, bytes_0.length);
				}

				buffer_1.putLong(random_0.nextLong());
				buffer_1.encryptRsa(class73.field1039, class73.field1044);
				int_0 = class316.getLength(string_0);
				if ((int_0 % 8) != 0)
				{
					int_0 += 8 - (int_0 % 8);
				}

				final Buffer buffer_3 = new Buffer(int_0);
				buffer_3.putString(string_0);
				buffer_3.offset = int_0;
				buffer_3.encryptXtea2(ints_0);
				Buffer buffer_2 = new Buffer(buffer_1.offset + buffer_0.offset + buffer_3.offset + 5);
				buffer_2.putByte(2);
				buffer_2.putByte(buffer_0.offset);
				buffer_2.putBytes(buffer_0.payload, 0, buffer_0.offset);
				buffer_2.putByte(buffer_1.offset);
				buffer_2.putBytes(buffer_1.payload, 0, buffer_1.offset);
				buffer_2.putShort(buffer_3.offset);
				buffer_2.putBytes(buffer_3.payload, 0, buffer_3.offset);
				final byte[] bytes_1 = buffer_2.payload;
				final int int_3 = bytes_1.length;
				final StringBuilder stringbuilder_0 = new StringBuilder();

				int int_6;
				for (int int_4 = 0; int_4 < (int_3 + 0); int_4 += 3)
				{
					final int int_5 = bytes_1[int_4] & 0xFF;
					stringbuilder_0.append(class304.field3722[int_5 >>> 2]);
					if (int_4 < (int_3 - 1))
					{
						int_6 = bytes_1[int_4 + 1] & 0xFF;
						stringbuilder_0.append(class304.field3722[((int_5 & 0x3) << 4) | (int_6 >>> 4)]);
						if (int_4 < (int_3 - 2))
						{
							final int int_7 = bytes_1[int_4 + 2] & 0xFF;
							stringbuilder_0.append(class304.field3722[((int_6 & 0xF) << 2) | (int_7 >>> 6)])
							        .append(class304.field3722[int_7 & 0x3F]);
						}
						else
						{
							stringbuilder_0.append(class304.field3722[(int_6 & 0xF) << 2]).append("=");
						}
					}
					else
					{
						stringbuilder_0.append(class304.field3722[(int_5 & 0x3) << 4]).append("==");
					}
				}

				String string_1 = stringbuilder_0.toString();
				string_1 = string_1;

				byte byte_1;
				try
				{
					final URL url_0 = new URL(class142.method3161("services", false) + "m=accountappeal/login.ws");
					final URLConnection urlconnection_0 = url_0.openConnection();
					urlconnection_0.setDoInput(true);
					urlconnection_0.setDoOutput(true);
					urlconnection_0.setConnectTimeout(5000);
					final OutputStreamWriter outputstreamwriter_0 = new OutputStreamWriter(
					        urlconnection_0.getOutputStream());
					outputstreamwriter_0.write("data2=" + class304.method5634(string_1) + "&dest="
					        + class304.method5634("passwordchoice.ws"));
					outputstreamwriter_0.flush();
					final InputStream inputstream_0 = urlconnection_0.getInputStream();
					buffer_2 = new Buffer(new byte[1000]);

					while (true)
					{
						int_6 = inputstream_0.read(buffer_2.payload, buffer_2.offset, 1000 - buffer_2.offset);
						if (int_6 == -1)
						{
							outputstreamwriter_0.close();
							inputstream_0.close();
							String string_2 = new String(buffer_2.payload);
							if (string_2.startsWith("OFFLINE"))
							{
								byte_1 = 4;
							}
							else if (string_2.startsWith("WRONG"))
							{
								byte_1 = 7;
							}
							else if (string_2.startsWith("RELOAD"))
							{
								byte_1 = 3;
							}
							else if (string_2.startsWith("Not permitted for social network accounts."))
							{
								byte_1 = 6;
							}
							else
							{
								buffer_2.decryptXtea(ints_0);

								while ((buffer_2.offset > 0) && (buffer_2.payload[buffer_2.offset - 1] == 0))
								{
									--buffer_2.offset;
								}

								string_2 = new String(buffer_2.payload, 0, buffer_2.offset);
								boolean bool_0;
								if (string_2 == null)
								{
									bool_0 = false;
								}
								else
								{
									label137:
									{
										try
										{
											new URL(string_2);
										}
										catch (final MalformedURLException malformedurlexception_0)
										{
											bool_0 = false;
											break label137;
										}

										bool_0 = true;
									}
								}

								if (bool_0)
								{
									HorizontalAlignment.method5156(string_2, true, false);
									byte_1 = 2;
								}
								else
								{
									byte_1 = 5;
								}
							}
							break;
						}

						buffer_2.offset += int_6;
						if (buffer_2.offset >= 1000)
						{
							byte_1 = 5;
							break;
						}
					}
				}
				catch (final Throwable throwable_0)
				{
					throwable_0.printStackTrace();
					byte_1 = 5;
				}

				byte_0 = byte_1;
			}

			switch (byte_0)
			{
				case 2:
					GrandExchangeEvent.method22(class237.field3049, class237.field3050, class237.field3072);
					class78.loginIndex = 6;
					break;
				case 3:
					GrandExchangeEvent.method22("", "Error connecting to server.", "");
					break;
				case 4:
					GrandExchangeEvent.method22("The part of the website you are trying",
					        "to connect to is offline at the moment.", "Please try again later.");
					break;
				case 5:
					GrandExchangeEvent.method22("Sorry, there was an error trying to",
					        "log you in to this part of the website.", "Please try again later.");
					break;
				case 6:
					GrandExchangeEvent.method22("", "Error connecting to server.", "");
					break;
				case 7:
					GrandExchangeEvent.method22("You must enter a valid login to proceed. For accounts",
					        "created after 24th November 2010, please use your",
					        "email address. Otherwise please use your username.");
			}

		}
	}

}
