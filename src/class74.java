public class class74
{

	static void method1800(final PendingSpawn pendingspawn_0)
	{
		long long_0 = 0L;
		int int_0 = -1;
		int int_1 = 0;
		int int_2 = 0;
		if (pendingspawn_0.type == 0)
		{
			long_0 = MapIcon.region.method2898(pendingspawn_0.level, pendingspawn_0.x, pendingspawn_0.y);
		}

		if (pendingspawn_0.type == 1)
		{
			long_0 = MapIcon.region.method2899(pendingspawn_0.level, pendingspawn_0.x, pendingspawn_0.y);
		}

		if (pendingspawn_0.type == 2)
		{
			long_0 = MapIcon.region.method2900(pendingspawn_0.level, pendingspawn_0.x, pendingspawn_0.y);
		}

		if (pendingspawn_0.type == 3)
		{
			long_0 = MapIcon.region.method2901(pendingspawn_0.level, pendingspawn_0.x, pendingspawn_0.y);
		}

		if (long_0 != 0L)
		{
			final int int_3 = MapIcon.region.method2902(pendingspawn_0.level, pendingspawn_0.x, pendingspawn_0.y,
			        long_0);
			int_0 = KeyFocusListener.method673(long_0);
			int_1 = int_3 & 0x1F;
			int_2 = (int_3 >> 6) & 0x3;
		}

		pendingspawn_0.field859 = int_0;
		pendingspawn_0.field866 = int_1;
		pendingspawn_0.field865 = int_2;
	}

}
