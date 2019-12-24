public class Name implements Comparable
{

	String name;
	String cleanName;

	public Name(final String string_0, final JagexLoginType jagexlogintype_0)
	{
		name = string_0;
		String string_1;
		if (string_0 == null)
		{
			string_1 = null;
		}
		else
		{
			int int_0 = 0;

			int int_1;
			char char_0;
			boolean bool_0;
			for (int_1 = string_0.length(); int_0 < int_1; int_0++)
			{
				char_0 = string_0.charAt(int_0);
				bool_0 = (char_0 == 160) || (char_0 == 32) || (char_0 == 95) || (char_0 == 45);
				if (!bool_0)
				{
					break;
				}
			}

			while (int_1 > int_0)
			{
				char_0 = string_0.charAt(int_1 - 1);
				bool_0 = (char_0 == 160) || (char_0 == 32) || (char_0 == 95) || (char_0 == 45);
				if (!bool_0)
				{
					break;
				}

				--int_1;
			}

			final int int_4 = int_1 - int_0;
			if ((int_4 >= 1) && (int_4 <= class8.method84(jagexlogintype_0)))
			{
				final StringBuilder stringbuilder_0 = new StringBuilder(int_4);

				for (int int_2 = int_0; int_2 < int_1; int_2++)
				{
					final char char_1 = string_0.charAt(int_2);
					boolean bool_1;
					if (Character.isISOControl(char_1))
					{
						bool_1 = false;
					}
					else if (class161.method3362(char_1))
					{
						bool_1 = true;
					}
					else
					{
						char[] chars_0 = class302.field3719;
						int int_3 = 0;

						label79: while (true)
						{
							char char_3;
							if (int_3 >= chars_0.length)
							{
								chars_0 = class302.field3717;

								for (int_3 = 0; int_3 < chars_0.length; int_3++)
								{
									char_3 = chars_0[int_3];
									if (char_3 == char_1)
									{
										bool_1 = true;
										break label79;
									}
								}

								bool_1 = false;
								break;
							}

							char_3 = chars_0[int_3];
							if (char_3 == char_1)
							{
								bool_1 = true;
								break;
							}

							++int_3;
						}
					}

					if (bool_1)
					{
						final char char_2 = class250.method4770(char_1);
						if (char_2 != 0)
						{
							stringbuilder_0.append(char_2);
						}
					}
				}

				if (stringbuilder_0.length() == 0)
				{
					string_1 = null;
				}
				else
				{
					string_1 = stringbuilder_0.toString();
				}
			}
			else
			{
				string_1 = null;
			}
		}

		cleanName = string_1;
	}

	public String getName()
	{
		return name;
	}

	public boolean isCleanNameValid()
	{
		return cleanName != null;
	}

	public int compareCleanName(final Name name_1)
	{
		return cleanName == null ? (name_1.cleanName == null ? 0 : 1)
		        : (name_1.cleanName == null ? -1 : cleanName.compareTo(name_1.cleanName));
	}

	@Override
	public boolean equals(final Object object_0)
	{
		if (object_0 instanceof Name)
		{
			final Name name_1 = (Name) object_0;
			return cleanName == null ? name_1.cleanName == null
			        : (name_1.cleanName != null && (hashCode() == name_1.hashCode() && cleanName.equals(name_1.cleanName)));
		}
		else
		{
			return false;
		}
	}

	@Override
	public int hashCode()
	{
		return cleanName == null ? 0 : cleanName.hashCode();
	}

	@Override
	public String toString()
	{
		return getName();
	}

	@Override
	public int compareTo(final Object object_0)
	{
		return compareCleanName((Name) object_0);
	}

	static char method5450(final char char_0)
	{
		return (char_0 != 181) && (char_0 != 131) ? Character.toTitleCase(char_0) : char_0;
	}

}
