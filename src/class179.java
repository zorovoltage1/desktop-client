public class class179
{

	public static BuildType method3517(final int int_0)
	{
		final BuildType[] buildtypes_0 = new BuildType[] { BuildType.WIP, BuildType.LIVE, BuildType.RC,
		        BuildType.BUILD_LIVE };
		final BuildType[] buildtypes_1 = buildtypes_0;

		for (int int_1 = 0; int_1 < buildtypes_1.length; int_1++)
		{
			final BuildType buildtype_0 = buildtypes_1[int_1];
			if (int_0 == buildtype_0.field3133)
			{
				return buildtype_0;
			}
		}

		return null;
	}

}
