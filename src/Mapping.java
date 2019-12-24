public class Mapping
{

	int field1388;
	int mux;
	int[] submapFloors;
	int[] field1386;

	Mapping()
	{
		class92.getInt(16);
		field1388 = class92.getBit() != 0 ? class92.getInt(4) + 1 : 1;
		if (class92.getBit() != 0)
		{
			class92.getInt(8);
		}

		class92.getInt(2);
		if (field1388 > 1)
		{
			mux = class92.getInt(4);
		}

		submapFloors = new int[field1388];
		field1386 = new int[field1388];

		for (int int_0 = 0; int_0 < field1388; int_0++)
		{
			class92.getInt(8);
			submapFloors[int_0] = class92.getInt(8);
			field1386[int_0] = class92.getInt(8);
		}

	}

}
