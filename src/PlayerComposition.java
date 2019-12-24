public class PlayerComposition
{

	public static short[] colorsToFind;
	public static short[][] colorsToReplace;
	public static short[] field2577;
	public static short[][] field2578;
	static final int[] field2579;
	static NodeCache field2580;
	int[] equipmentIds;
	int[] bodyPartColours;
	public boolean isFemale;
	public int transformedNpcId;
	long hash;
	long field2574;

	static
	{
		field2579 = new int[] { 8, 11, 4, 6, 9, 7, 10 };
		field2580 = new NodeCache(260);
	}

	public void method4462(int[] ints_0, final int[] ints_1, final boolean bool_0, final int int_0)
	{
		if (ints_0 == null)
		{
			ints_0 = new int[12];

			for (int int_1 = 0; int_1 < 7; int_1++)
			{
				for (int int_2 = 0; int_2 < KitDefinition.field3294; int_2++)
				{
					final KitDefinition kitdefinition_0 = GrandExchangeEvent.getKitDefinition(int_2);
					if ((kitdefinition_0 != null) && !kitdefinition_0.nonSelectable
					        && (((bool_0 ? 7 : 0) + int_1) == kitdefinition_0.bodyPartId))
					{
						ints_0[field2579[int_1]] = int_2 + 256;
						break;
					}
				}
			}
		}

		equipmentIds = ints_0;
		bodyPartColours = ints_1;
		isFemale = bool_0;
		transformedNpcId = int_0;
		setHash();
	}

	public void method4478(final int int_0, final boolean bool_0)
	{
		if ((int_0 != 1) || !isFemale)
		{
			int int_1 = equipmentIds[field2579[int_0]];
			if (int_1 != 0)
			{
				int_1 -= 256;

				KitDefinition kitdefinition_0;
				do
				{
					if (!bool_0)
					{
						--int_1;
						if (int_1 < 0)
						{
							int_1 = KitDefinition.field3294 - 1;
						}
					}
					else
					{
						++int_1;
						if (int_1 >= KitDefinition.field3294)
						{
							int_1 = 0;
						}
					}

					kitdefinition_0 = GrandExchangeEvent.getKitDefinition(int_1);
				}
				while ((kitdefinition_0 == null) || kitdefinition_0.nonSelectable
				        || ((int_0 + (isFemale ? 7 : 0)) != kitdefinition_0.bodyPartId));

				equipmentIds[field2579[int_0]] = int_1 + 256;
				setHash();
			}
		}
	}

	public void method4493(final int int_0, final boolean bool_0)
	{
		int int_1 = bodyPartColours[int_0];
		boolean bool_1;
		if (!bool_0)
		{
			do
			{
				--int_1;
				if (int_1 < 0)
				{
					int_1 = colorsToReplace[int_0].length - 1;
				}

                bool_1 = (int_0 != 4) || (int_1 < 8);
			}
			while (!bool_1);
		}
		else
		{
			do
			{
				++int_1;
				if (int_1 >= colorsToReplace[int_0].length)
				{
					int_1 = 0;
				}

                bool_1 = (int_0 != 4) || (int_1 < 8);
			}
			while (!bool_1);
		}

		bodyPartColours[int_0] = int_1;
		setHash();
	}

	public void method4465(final boolean bool_0)
	{
		if (isFemale != bool_0)
		{
			method4462(null, bodyPartColours, bool_0, -1);
		}
	}

	public void method4466(final Buffer buffer_0)
	{
		buffer_0.putByte(isFemale ? 1 : 0);

		int int_0;
		for (int_0 = 0; int_0 < 7; int_0++)
		{
			final int int_1 = equipmentIds[field2579[int_0]];
			if (int_1 == 0)
			{
				buffer_0.putByte(-1);
			}
			else
			{
				buffer_0.putByte(int_1 - 256);
			}
		}

		for (int_0 = 0; int_0 < 5; int_0++)
		{
			buffer_0.putByte(bodyPartColours[int_0]);
		}

	}

	void setHash()
	{
		final long long_0 = hash;
		final int int_0 = equipmentIds[5];
		final int int_1 = equipmentIds[9];
		equipmentIds[5] = int_1;
		equipmentIds[9] = int_0;
		hash = 0L;

		int int_2;
		for (int_2 = 0; int_2 < 12; int_2++)
		{
			hash <<= 4;
			if (equipmentIds[int_2] >= 256)
			{
				hash += equipmentIds[int_2] - 256;
			}
		}

		if (equipmentIds[0] >= 256)
		{
			hash += (equipmentIds[0] - 256) >> 4;
		}

		if (equipmentIds[1] >= 256)
		{
			hash += (equipmentIds[1] - 256) >> 8;
		}

		for (int_2 = 0; int_2 < 5; int_2++)
		{
			hash <<= 3;
			hash += bodyPartColours[int_2];
		}

		hash <<= 1;
		hash += isFemale ? 1 : 0;
		equipmentIds[5] = int_0;
		equipmentIds[9] = int_1;
		if ((long_0 != 0L) && (hash != long_0))
		{
			field2580.remove(long_0);
		}

	}

	public Model getModel(final Sequence sequence_0, final int int_0, final Sequence sequence_1, final int int_1)
	{
		if (transformedNpcId != -1)
		{
			return HorizontalAlignment.getNpcDefinition(transformedNpcId).getModel(sequence_0, int_0, sequence_1,
			        int_1);
		}
		else
		{
			long long_0 = hash;
			int[] ints_0 = equipmentIds;
			if ((sequence_0 != null) && ((sequence_0.leftHandItem >= 0) || (sequence_0.rightHandItem >= 0)))
			{
				ints_0 = new int[12];

				for (int int_2 = 0; int_2 < 12; int_2++)
				{
					ints_0[int_2] = equipmentIds[int_2];
				}

				if (sequence_0.leftHandItem >= 0)
				{
					long_0 += (sequence_0.leftHandItem - equipmentIds[5]) << 8;
					ints_0[5] = sequence_0.leftHandItem;
				}

				if (sequence_0.rightHandItem >= 0)
				{
					long_0 += (sequence_0.rightHandItem - equipmentIds[3]) << 16;
					ints_0[3] = sequence_0.rightHandItem;
				}
			}

			Model model_0 = (Model) field2580.get(long_0);
			if (model_0 == null)
			{
				boolean bool_0 = false;

				int int_4;
				for (int int_3 = 0; int_3 < 12; int_3++)
				{
					int_4 = ints_0[int_3];
					if ((int_4 >= 256) && (int_4 < 512) && !GrandExchangeEvent.getKitDefinition(int_4 - 256).ready())
					{
						bool_0 = true;
					}

					if ((int_4 >= 512) && !TextureProvider.getItemDefinition(int_4 - 512).readyWorn(isFemale))
					{
						bool_0 = true;
					}
				}

				if (bool_0)
				{
					if (field2574 != -1L)
					{
						model_0 = (Model) field2580.get(field2574);
					}

					if (model_0 == null)
					{
						return null;
					}
				}

				if (model_0 == null)
				{
					final ModelData[] modeldatas_0 = new ModelData[12];
					int_4 = 0;

					int int_6;
					for (int int_5 = 0; int_5 < 12; int_5++)
					{
						int_6 = ints_0[int_5];
						ModelData modeldata_0;
						if ((int_6 >= 256) && (int_6 < 512))
						{
							modeldata_0 = GrandExchangeEvent.getKitDefinition(int_6 - 256).getModelData();
							if (modeldata_0 != null)
							{
								modeldatas_0[int_4++] = modeldata_0;
							}
						}

						if (int_6 >= 512)
						{
							modeldata_0 = TextureProvider.getItemDefinition(int_6 - 512).getWornModelData(isFemale);
							if (modeldata_0 != null)
							{
								modeldatas_0[int_4++] = modeldata_0;
							}
						}
					}

					final ModelData modeldata_1 = new ModelData(modeldatas_0, int_4);

					for (int_6 = 0; int_6 < 5; int_6++)
					{
						if (bodyPartColours[int_6] < colorsToReplace[int_6].length)
						{
							modeldata_1.recolor(colorsToFind[int_6], colorsToReplace[int_6][bodyPartColours[int_6]]);
						}

						if (bodyPartColours[int_6] < field2578[int_6].length)
						{
							modeldata_1.recolor(field2577[int_6], field2578[int_6][bodyPartColours[int_6]]);
						}
					}

					model_0 = modeldata_1.light(64, 850, -30, -50, -30);
					field2580.put(model_0, long_0);
					field2574 = long_0;
				}
			}

			if ((sequence_0 == null) && (sequence_1 == null))
			{
				return model_0;
			}
			else
			{
				Model model_1;
				if ((sequence_0 != null) && (sequence_1 != null))
				{
					model_1 = sequence_0.applyTransformations(model_0, int_0, sequence_1, int_1);
				}
				else if (sequence_0 != null)
				{
					model_1 = sequence_0.transformActorModel(model_0, int_0);
				}
				else
				{
					model_1 = sequence_1.transformActorModel(model_0, int_1);
				}

				return model_1;
			}
		}
	}

	ModelData method4469()
	{
		if (transformedNpcId != -1)
		{
			return HorizontalAlignment.getNpcDefinition(transformedNpcId).method5158();
		}
		else
		{
			boolean bool_0 = false;

			int int_1;
			for (int int_0 = 0; int_0 < 12; int_0++)
			{
				int_1 = equipmentIds[int_0];
				if ((int_1 >= 256) && (int_1 < 512) && !GrandExchangeEvent.getKitDefinition(int_1 - 256).method4905())
				{
					bool_0 = true;
				}

				if ((int_1 >= 512) && !TextureProvider.getItemDefinition(int_1 - 512).method5097(isFemale))
				{
					bool_0 = true;
				}
			}

			if (bool_0)
			{
				return null;
			}
			else
			{
				final ModelData[] modeldatas_0 = new ModelData[12];
				int_1 = 0;

				int int_3;
				for (int int_2 = 0; int_2 < 12; int_2++)
				{
					int_3 = equipmentIds[int_2];
					ModelData modeldata_0;
					if ((int_3 >= 256) && (int_3 < 512))
					{
						modeldata_0 = GrandExchangeEvent.getKitDefinition(int_3 - 256).method4899();
						if (modeldata_0 != null)
						{
							modeldatas_0[int_1++] = modeldata_0;
						}
					}

					if (int_3 >= 512)
					{
						modeldata_0 = TextureProvider.getItemDefinition(int_3 - 512).method5098(isFemale);
						if (modeldata_0 != null)
						{
							modeldatas_0[int_1++] = modeldata_0;
						}
					}
				}

				final ModelData modeldata_1 = new ModelData(modeldatas_0, int_1);

				for (int_3 = 0; int_3 < 5; int_3++)
				{
					if (bodyPartColours[int_3] < colorsToReplace[int_3].length)
					{
						modeldata_1.recolor(colorsToFind[int_3], colorsToReplace[int_3][bodyPartColours[int_3]]);
					}

					if (bodyPartColours[int_3] < field2578[int_3].length)
					{
						modeldata_1.recolor(field2577[int_3], field2578[int_3][bodyPartColours[int_3]]);
					}
				}

				return modeldata_1;
			}
		}
	}

	public int method4483()
	{
		return transformedNpcId == -1
		        ? (equipmentIds[0] << 15) + equipmentIds[1] + (equipmentIds[11] << 5) + (equipmentIds[8] << 10)
		                + (bodyPartColours[0] << 25) + (bodyPartColours[4] << 20)
		        : 305419896 + HorizontalAlignment.getNpcDefinition(transformedNpcId).id;
	}

}
