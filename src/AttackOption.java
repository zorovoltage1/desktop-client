public enum AttackOption implements Enumerated
{

	AttackOption_dependsOnCombatLevels(0),
	AttackOption_alwaysRightClick(1),
	AttackOption_leftClickWhereAvailable(2),
	AttackOption_hidden(3);

	static int[] field1077;
	static IndexData indexInterfaces;
	final int id;

	AttackOption(final int int_1)
	{
		id = int_1;
	}

	@Override
	public int vmethod5815()
	{
		return id;
	}

}
