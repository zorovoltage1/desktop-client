public class class208
{

	class209 field2431;
	class209 field2430;

	public class208()
	{
		field2431 = new class209();
		field2431.field2432 = field2431;
		field2431.field2433 = field2431;
	}

	public void method4112(final class209 class209_0)
	{
		if (class209_0.field2433 != null)
		{
			class209_0.method4121();
		}

		class209_0.field2433 = field2431.field2433;
		class209_0.field2432 = field2431;
		class209_0.field2433.field2432 = class209_0;
		class209_0.field2432.field2433 = class209_0;
	}

	public class209 method4111()
	{
		final class209 class209_0 = field2431.field2432;
		if (class209_0 == field2431)
		{
			field2430 = null;
			return null;
		}
		else
		{
			field2430 = class209_0.field2432;
			return class209_0;
		}
	}

	public class209 method4114()
	{
		final class209 class209_0 = field2430;
		if (class209_0 == field2431)
		{
			field2430 = null;
			return null;
		}
		else
		{
			field2430 = class209_0.field2432;
			return class209_0;
		}
	}

}
