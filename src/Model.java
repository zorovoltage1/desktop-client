public class Model extends Renderable
{

	static Model field1641;
	static byte[] field1578;
	static Model field1579;
	static byte[] field1580;
	static boolean[] field1616;
	static boolean[] field1626;
	static int[] modelViewportYs;
	static int[] modelViewportXs;
	static int[] field1590;
	static int[] yViewportBuffer;
	static int[] field1577;
	static int[] field1623;
	static int[] field1625;
	static int[][] field1592;
	static int[] field1638;
	static int[][] field1640;
	static int[] field1608;
	static int[] field1595;
	static int[] field1631;
	static int[] field1632;
	static int[] field1630;
	static int[] xViewportBuffer;
	static int animOffsetX;
	static int animOffsetY;
	static int animOffsetZ;
	static boolean useBoundingBoxes3D;
	static int[] Model_sine;
	static int[] Model_cosine;
	static int[] field1643;
	static int[] field1598;
	int verticesCount;
	int[] verticesX;
	int[] verticesY;
	int[] verticesZ;
	int indicesCount;
	int[] indices1;
	int[] indices2;
	int[] indices3;
	int[] field1615;
	int[] field1620;
	int[] field1591;
	byte[] field1645;
	byte[] field1593;
	byte[] field1617;
	short[] field1604;
	byte field1596;
	int field1597;
	int[] field1621;
	int[] field1599;
	int[] field1600;
	int[][] vertexGroups;
	int[][] field1602;
	public boolean field1603;
	int boundsType;
	int bottomY;
	int XYZMag;
	int diameter;
	int radius;
	int centerX;
	int centerY;
	int centerZ;
	int extremeX;
	int extremeY;
	int extremeZ;

	static
	{
		field1641 = new Model();
		field1578 = new byte[1];
		field1579 = new Model();
		field1580 = new byte[1];
		field1616 = new boolean[4700];
		field1626 = new boolean[4700];
		modelViewportYs = new int[4700];
		modelViewportXs = new int[4700];
		field1590 = new int[4700];
		yViewportBuffer = new int[4700];
		field1577 = new int[4700];
		field1623 = new int[4700];
		field1625 = new int[1600];
		field1592 = new int[1600][512];
		field1638 = new int[12];
		field1640 = new int[12][2000];
		field1608 = new int[2000];
		field1595 = new int[2000];
		field1631 = new int[12];
		field1632 = new int[10];
		field1630 = new int[10];
		xViewportBuffer = new int[10];
		useBoundingBoxes3D = true;
		Model_sine = Graphics3D.SINE;
		Model_cosine = Graphics3D.COSINE;
		field1643 = Graphics3D.colorPalette;
		field1598 = Graphics3D.field1691;
	}

	Model()
	{
		verticesCount = 0;
		indicesCount = 0;
		field1596 = 0;
		field1597 = 0;
		field1603 = false;
		extremeX = -1;
		extremeY = -1;
		extremeZ = -1;
	}

	public Model(final Model[] models_0, final int int_0)
	{
		verticesCount = 0;
		indicesCount = 0;
		field1596 = 0;
		field1597 = 0;
		field1603 = false;
		extremeX = -1;
		extremeY = -1;
		extremeZ = -1;
		boolean bool_0 = false;
		boolean bool_1 = false;
		boolean bool_2 = false;
		boolean bool_3 = false;
		verticesCount = 0;
		indicesCount = 0;
		field1597 = 0;
		field1596 = -1;

		int int_1;
		Model model_1;
		for (int_1 = 0; int_1 < int_0; int_1++)
		{
			model_1 = models_0[int_1];
			if (model_1 != null)
			{
				verticesCount += model_1.verticesCount;
				indicesCount += model_1.indicesCount;
				field1597 += model_1.field1597;
				if (model_1.field1645 != null)
				{
					bool_0 = true;
				}
				else
				{
					if (field1596 == -1)
					{
						field1596 = model_1.field1596;
					}

					if (field1596 != model_1.field1596)
					{
						bool_0 = true;
					}
				}

				bool_1 |= model_1.field1593 != null;
				bool_2 |= model_1.field1604 != null;
				bool_3 |= model_1.field1617 != null;
			}
		}

		verticesX = new int[verticesCount];
		verticesY = new int[verticesCount];
		verticesZ = new int[verticesCount];
		indices1 = new int[indicesCount];
		indices2 = new int[indicesCount];
		indices3 = new int[indicesCount];
		field1615 = new int[indicesCount];
		field1620 = new int[indicesCount];
		field1591 = new int[indicesCount];
		if (bool_0)
		{
			field1645 = new byte[indicesCount];
		}

		if (bool_1)
		{
			field1593 = new byte[indicesCount];
		}

		if (bool_2)
		{
			field1604 = new short[indicesCount];
		}

		if (bool_3)
		{
			field1617 = new byte[indicesCount];
		}

		if (field1597 > 0)
		{
			field1621 = new int[field1597];
			field1599 = new int[field1597];
			field1600 = new int[field1597];
		}

		verticesCount = 0;
		indicesCount = 0;
		field1597 = 0;

		for (int_1 = 0; int_1 < int_0; int_1++)
		{
			model_1 = models_0[int_1];
			if (model_1 != null)
			{
				int int_2;
				for (int_2 = 0; int_2 < model_1.indicesCount; int_2++)
				{
					indices1[indicesCount] = verticesCount + model_1.indices1[int_2];
					indices2[indicesCount] = verticesCount + model_1.indices2[int_2];
					indices3[indicesCount] = verticesCount + model_1.indices3[int_2];
					field1615[indicesCount] = model_1.field1615[int_2];
					field1620[indicesCount] = model_1.field1620[int_2];
					field1591[indicesCount] = model_1.field1591[int_2];
					if (bool_0)
					{
						if (model_1.field1645 != null)
						{
							field1645[indicesCount] = model_1.field1645[int_2];
						}
						else
						{
							field1645[indicesCount] = model_1.field1596;
						}
					}

					if (bool_1 && (model_1.field1593 != null))
					{
						field1593[indicesCount] = model_1.field1593[int_2];
					}

					if (bool_2)
					{
						if (model_1.field1604 != null)
						{
							field1604[indicesCount] = model_1.field1604[int_2];
						}
						else
						{
							field1604[indicesCount] = -1;
						}
					}

					if (bool_3)
					{
						if ((model_1.field1617 != null) && (model_1.field1617[int_2] != -1))
						{
							field1617[indicesCount] = (byte) (field1597 + model_1.field1617[int_2]);
						}
						else
						{
							field1617[indicesCount] = -1;
						}
					}

					++indicesCount;
				}

				for (int_2 = 0; int_2 < model_1.field1597; int_2++)
				{
					field1621[field1597] = verticesCount + model_1.field1621[int_2];
					field1599[field1597] = verticesCount + model_1.field1599[int_2];
					field1600[field1597] = verticesCount + model_1.field1600[int_2];
					++field1597;
				}

				for (int_2 = 0; int_2 < model_1.verticesCount; int_2++)
				{
					verticesX[verticesCount] = model_1.verticesX[int_2];
					verticesY[verticesCount] = model_1.verticesY[int_2];
					verticesZ[verticesCount] = model_1.verticesZ[int_2];
					++verticesCount;
				}
			}
		}

	}

	public Model method2665(final int[][] ints_0, final int int_0, final int int_1, final int int_2,
	        final boolean bool_0, final int int_3)
	{
		calculateBoundsCylinder();
		int int_4 = int_0 - XYZMag;
		int int_5 = int_0 + XYZMag;
		int int_6 = int_2 - XYZMag;
		int int_7 = int_2 + XYZMag;
		if ((int_4 >= 0) && (((int_5 + 128) >> 7) < ints_0.length) && (int_6 >= 0)
		        && (((int_7 + 128) >> 7) < ints_0[0].length))
		{
			int_4 >>= 7;
			int_5 = (int_5 + 127) >> 7;
			int_6 >>= 7;
			int_7 = (int_7 + 127) >> 7;
			if ((int_1 == ints_0[int_4][int_6]) && (int_1 == ints_0[int_5][int_6]) && (int_1 == ints_0[int_4][int_7])
			        && (int_1 == ints_0[int_5][int_7]))
			{
				return this;
			}
			else
			{
				Model model_1;
				if (bool_0)
				{
					model_1 = new Model();
					model_1.verticesCount = verticesCount;
					model_1.indicesCount = indicesCount;
					model_1.field1597 = field1597;
					model_1.verticesX = verticesX;
					model_1.verticesZ = verticesZ;
					model_1.indices1 = indices1;
					model_1.indices2 = indices2;
					model_1.indices3 = indices3;
					model_1.field1615 = field1615;
					model_1.field1620 = field1620;
					model_1.field1591 = field1591;
					model_1.field1645 = field1645;
					model_1.field1593 = field1593;
					model_1.field1617 = field1617;
					model_1.field1604 = field1604;
					model_1.field1596 = field1596;
					model_1.field1621 = field1621;
					model_1.field1599 = field1599;
					model_1.field1600 = field1600;
					model_1.vertexGroups = vertexGroups;
					model_1.field1602 = field1602;
					model_1.field1603 = field1603;
					model_1.verticesY = new int[model_1.verticesCount];
				}
				else
				{
					model_1 = this;
				}

				int int_8;
				int int_9;
				int int_10;
				int int_11;
				int int_12;
				int int_13;
				int int_14;
				int int_15;
				int int_16;
				int int_17;
				if (int_3 == 0)
				{
					for (int_8 = 0; int_8 < model_1.verticesCount; int_8++)
					{
						int_9 = int_0 + verticesX[int_8];
						int_10 = int_2 + verticesZ[int_8];
						int_11 = int_9 & 0x7F;
						int_12 = int_10 & 0x7F;
						int_13 = int_9 >> 7;
						int_14 = int_10 >> 7;
						int_15 = ((ints_0[int_13][int_14] * (128 - int_11))
						        + (ints_0[int_13 + 1][int_14] * int_11)) >> 7;
						int_16 = ((ints_0[int_13][int_14 + 1] * (128 - int_11))
						        + (int_11 * ints_0[int_13 + 1][int_14 + 1])) >> 7;
						int_17 = ((int_15 * (128 - int_12)) + (int_16 * int_12)) >> 7;
						model_1.verticesY[int_8] = (int_17 + verticesY[int_8]) - int_1;
					}
				}
				else
				{
					for (int_8 = 0; int_8 < model_1.verticesCount; int_8++)
					{
						int_9 = (-verticesY[int_8] << 16) / super.modelHeight;
						if (int_9 < int_3)
						{
							int_10 = int_0 + verticesX[int_8];
							int_11 = int_2 + verticesZ[int_8];
							int_12 = int_10 & 0x7F;
							int_13 = int_11 & 0x7F;
							int_14 = int_10 >> 7;
							int_15 = int_11 >> 7;
							int_16 = ((ints_0[int_14][int_15] * (128 - int_12))
							        + (ints_0[int_14 + 1][int_15] * int_12)) >> 7;
							int_17 = ((ints_0[int_14][int_15 + 1] * (128 - int_12))
							        + (int_12 * ints_0[int_14 + 1][int_15 + 1])) >> 7;
							final int int_18 = ((int_16 * (128 - int_13)) + (int_17 * int_13)) >> 7;
							model_1.verticesY[int_8] = (((int_3 - int_9) * (int_18 - int_1)) / int_3)
							        + verticesY[int_8];
						}
					}
				}

				model_1.resetBounds();
				return model_1;
			}
		}
		else
		{
			return this;
		}
	}

	public Model toSharedModel(final boolean bool_0)
	{
		if (!bool_0 && (field1578.length < indicesCount))
		{
			field1578 = new byte[indicesCount + 100];
		}

		return method2741(bool_0, field1641, field1578);
	}

	public Model toSharedSpotAnimModel(final boolean bool_0)
	{
		if (!bool_0 && (field1580.length < indicesCount))
		{
			field1580 = new byte[indicesCount + 100];
		}

		return method2741(bool_0, field1579, field1580);
	}

	Model method2741(final boolean bool_0, final Model model_1, final byte[] bytes_0)
	{
		model_1.verticesCount = verticesCount;
		model_1.indicesCount = indicesCount;
		model_1.field1597 = field1597;
		if ((model_1.verticesX == null) || (model_1.verticesX.length < verticesCount))
		{
			model_1.verticesX = new int[verticesCount + 100];
			model_1.verticesY = new int[verticesCount + 100];
			model_1.verticesZ = new int[verticesCount + 100];
		}

		int int_0;
		for (int_0 = 0; int_0 < verticesCount; int_0++)
		{
			model_1.verticesX[int_0] = verticesX[int_0];
			model_1.verticesY[int_0] = verticesY[int_0];
			model_1.verticesZ[int_0] = verticesZ[int_0];
		}

		if (bool_0)
		{
			model_1.field1593 = field1593;
		}
		else
		{
			model_1.field1593 = bytes_0;
			if (field1593 == null)
			{
				for (int_0 = 0; int_0 < indicesCount; int_0++)
				{
					model_1.field1593[int_0] = 0;
				}
			}
			else
			{
				for (int_0 = 0; int_0 < indicesCount; int_0++)
				{
					model_1.field1593[int_0] = field1593[int_0];
				}
			}
		}

		model_1.indices1 = indices1;
		model_1.indices2 = indices2;
		model_1.indices3 = indices3;
		model_1.field1615 = field1615;
		model_1.field1620 = field1620;
		model_1.field1591 = field1591;
		model_1.field1645 = field1645;
		model_1.field1617 = field1617;
		model_1.field1604 = field1604;
		model_1.field1596 = field1596;
		model_1.field1621 = field1621;
		model_1.field1599 = field1599;
		model_1.field1600 = field1600;
		model_1.vertexGroups = vertexGroups;
		model_1.field1602 = field1602;
		model_1.field1603 = field1603;
		model_1.resetBounds();
		return model_1;
	}

	void method2669(final int int_0)
	{
		if (extremeX == -1)
		{
			int int_1 = 0;
			int int_2 = 0;
			int int_3 = 0;
			int int_4 = 0;
			int int_5 = 0;
			int int_6 = 0;
			final int int_7 = Model_cosine[int_0];
			final int int_8 = Model_sine[int_0];

			for (int int_9 = 0; int_9 < verticesCount; int_9++)
			{
				final int int_10 = Graphics3D.method2803(verticesX[int_9], verticesZ[int_9], int_7, int_8);
				final int int_11 = verticesY[int_9];
				final int int_12 = Graphics3D.method2828(verticesX[int_9], verticesZ[int_9], int_7, int_8);
				if (int_10 < int_1)
				{
					int_1 = int_10;
				}

				if (int_10 > int_4)
				{
					int_4 = int_10;
				}

				if (int_11 < int_2)
				{
					int_2 = int_11;
				}

				if (int_11 > int_5)
				{
					int_5 = int_11;
				}

				if (int_12 < int_3)
				{
					int_3 = int_12;
				}

				if (int_12 > int_6)
				{
					int_6 = int_12;
				}
			}

			centerX = (int_4 + int_1) / 2;
			centerY = (int_5 + int_2) / 2;
			centerZ = (int_6 + int_3) / 2;
			extremeX = ((int_4 - int_1) + 1) / 2;
			extremeY = ((int_5 - int_2) + 1) / 2;
			extremeZ = ((int_6 - int_3) + 1) / 2;
			if (extremeX < 32)
			{
				extremeX = 32;
			}

			if (extremeZ < 32)
			{
				extremeZ = 32;
			}

			if (field1603)
			{
				extremeX += 8;
				extremeZ += 8;
			}

		}
	}

	public void calculateBoundsCylinder()
	{
		if (boundsType != 1)
		{
			boundsType = 1;
			super.modelHeight = 0;
			bottomY = 0;
			XYZMag = 0;

			for (int int_0 = 0; int_0 < verticesCount; int_0++)
			{
				final int int_1 = verticesX[int_0];
				final int int_2 = verticesY[int_0];
				final int int_3 = verticesZ[int_0];
				if (-int_2 > super.modelHeight)
				{
					super.modelHeight = -int_2;
				}

				if (int_2 > bottomY)
				{
					bottomY = int_2;
				}

				final int int_4 = (int_1 * int_1) + (int_3 * int_3);
				if (int_4 > XYZMag)
				{
					XYZMag = int_4;
				}
			}

			XYZMag = (int) (Math.sqrt(XYZMag) + 0.99D);
			radius = (int) (Math.sqrt((XYZMag * XYZMag) + (super.modelHeight * super.modelHeight)) + 0.99D);
			diameter = radius + (int) (Math.sqrt((XYZMag * XYZMag) + (bottomY * bottomY)) + 0.99D);
		}
	}

	void method2671()
	{
		if (boundsType != 2)
		{
			boundsType = 2;
			XYZMag = 0;

			for (int int_0 = 0; int_0 < verticesCount; int_0++)
			{
				final int int_1 = verticesX[int_0];
				final int int_2 = verticesY[int_0];
				final int int_3 = verticesZ[int_0];
				final int int_4 = (int_1 * int_1) + (int_3 * int_3) + (int_2 * int_2);
				if (int_4 > XYZMag)
				{
					XYZMag = int_4;
				}
			}

			XYZMag = (int) (Math.sqrt(XYZMag) + 0.99D);
			radius = XYZMag;
			diameter = XYZMag + XYZMag;
		}
	}

	public int method2672()
	{
		calculateBoundsCylinder();
		return XYZMag;
	}

	void resetBounds()
	{
		boundsType = 0;
		extremeX = -1;
	}

	public void method2724(final Frames frames_0, final int int_0)
	{
		if (vertexGroups != null)
		{
			if (int_0 != -1)
			{
				final Frame frame_0 = frames_0.skeletons[int_0];
				final FrameMap framemap_0 = frame_0.skin;
				animOffsetX = 0;
				animOffsetY = 0;
				animOffsetZ = 0;

				for (int int_1 = 0; int_1 < frame_0.transformCount; int_1++)
				{
					final int int_2 = frame_0.transformTypes[int_1];
					animate(framemap_0.types[int_2], framemap_0.list[int_2], frame_0.translator_x[int_1],
					        frame_0.translator_y[int_1], frame_0.translator_z[int_1]);
				}

				resetBounds();
			}
		}
	}

	public void method2745(final Frames frames_0, final int int_0, final Frames frames_1, final int int_1,
	        final int[] ints_0)
	{
		if (int_0 != -1)
		{
			if ((ints_0 != null) && (int_1 != -1))
			{
				final Frame frame_0 = frames_0.skeletons[int_0];
				final Frame frame_1 = frames_1.skeletons[int_1];
				final FrameMap framemap_0 = frame_0.skin;
				animOffsetX = 0;
				animOffsetY = 0;
				animOffsetZ = 0;
				byte byte_0 = 0;
				int int_5 = byte_0 + 1;
				int int_2 = ints_0[byte_0];

				int int_3;
				int int_4;
				for (int_3 = 0; int_3 < frame_0.transformCount; int_3++)
				{
					for (int_4 = frame_0.transformTypes[int_3]; int_4 > int_2; int_2 = ints_0[int_5++])
					{
                    }

					if ((int_4 != int_2) || (framemap_0.types[int_4] == 0))
					{
						animate(framemap_0.types[int_4], framemap_0.list[int_4], frame_0.translator_x[int_3],
						        frame_0.translator_y[int_3], frame_0.translator_z[int_3]);
					}
				}

				animOffsetX = 0;
				animOffsetY = 0;
				animOffsetZ = 0;
				byte_0 = 0;
				int_5 = byte_0 + 1;
				int_2 = ints_0[byte_0];

				for (int_3 = 0; int_3 < frame_1.transformCount; int_3++)
				{
					for (int_4 = frame_1.transformTypes[int_3]; int_4 > int_2; int_2 = ints_0[int_5++])
					{
                    }

					if ((int_4 == int_2) || (framemap_0.types[int_4] == 0))
					{
						animate(framemap_0.types[int_4], framemap_0.list[int_4], frame_1.translator_x[int_3],
						        frame_1.translator_y[int_3], frame_1.translator_z[int_3]);
					}
				}

				resetBounds();
			}
			else
			{
				method2724(frames_0, int_0);
			}
		}
	}

	void animate(final int int_0, final int[] ints_0, final int int_1, final int int_2, final int int_3)
	{
		final int int_4 = ints_0.length;
		int int_5;
		int int_6;
		int int_8;
		int int_9;
		if (int_0 == 0)
		{
			int_5 = 0;
			animOffsetX = 0;
			animOffsetY = 0;
			animOffsetZ = 0;

			for (int_6 = 0; int_6 < int_4; int_6++)
			{
				final int int_7 = ints_0[int_6];
				if (int_7 < vertexGroups.length)
				{
					final int[] ints_1 = vertexGroups[int_7];

					for (int_8 = 0; int_8 < ints_1.length; int_8++)
					{
						int_9 = ints_1[int_8];
						animOffsetX += verticesX[int_9];
						animOffsetY += verticesY[int_9];
						animOffsetZ += verticesZ[int_9];
						++int_5;
					}
				}
			}

			if (int_5 > 0)
			{
				animOffsetX = int_1 + (animOffsetX / int_5);
				animOffsetY = int_2 + (animOffsetY / int_5);
				animOffsetZ = int_3 + (animOffsetZ / int_5);
			}
			else
			{
				animOffsetX = int_1;
				animOffsetY = int_2;
				animOffsetZ = int_3;
			}

		}
		else
		{
			int[] ints_2;
			int int_10;
			if (int_0 == 1)
			{
				for (int_5 = 0; int_5 < int_4; int_5++)
				{
					int_6 = ints_0[int_5];
					if (int_6 < vertexGroups.length)
					{
						ints_2 = vertexGroups[int_6];

						for (int_10 = 0; int_10 < ints_2.length; int_10++)
						{
							int_8 = ints_2[int_10];
							verticesX[int_8] += int_1;
							verticesY[int_8] += int_2;
							verticesZ[int_8] += int_3;
						}
					}
				}

			}
			else if (int_0 == 2)
			{
				for (int_5 = 0; int_5 < int_4; int_5++)
				{
					int_6 = ints_0[int_5];
					if (int_6 < vertexGroups.length)
					{
						ints_2 = vertexGroups[int_6];

						for (int_10 = 0; int_10 < ints_2.length; int_10++)
						{
							int_8 = ints_2[int_10];
							verticesX[int_8] -= animOffsetX;
							verticesY[int_8] -= animOffsetY;
							verticesZ[int_8] -= animOffsetZ;
							int_9 = (int_1 & 0xFF) * 8;
							final int int_11 = (int_2 & 0xFF) * 8;
							final int int_12 = (int_3 & 0xFF) * 8;
							int int_13;
							int int_14;
							int int_15;
							if (int_12 != 0)
							{
								int_13 = Model_sine[int_12];
								int_14 = Model_cosine[int_12];
								int_15 = ((int_13 * verticesY[int_8]) + (int_14 * verticesX[int_8])) >> 16;
								verticesY[int_8] = ((int_14 * verticesY[int_8]) - (int_13 * verticesX[int_8])) >> 16;
								verticesX[int_8] = int_15;
							}

							if (int_9 != 0)
							{
								int_13 = Model_sine[int_9];
								int_14 = Model_cosine[int_9];
								int_15 = ((int_14 * verticesY[int_8]) - (int_13 * verticesZ[int_8])) >> 16;
								verticesZ[int_8] = ((int_13 * verticesY[int_8]) + (int_14 * verticesZ[int_8])) >> 16;
								verticesY[int_8] = int_15;
							}

							if (int_11 != 0)
							{
								int_13 = Model_sine[int_11];
								int_14 = Model_cosine[int_11];
								int_15 = ((int_13 * verticesZ[int_8]) + (int_14 * verticesX[int_8])) >> 16;
								verticesZ[int_8] = ((int_14 * verticesZ[int_8]) - (int_13 * verticesX[int_8])) >> 16;
								verticesX[int_8] = int_15;
							}

							verticesX[int_8] += animOffsetX;
							verticesY[int_8] += animOffsetY;
							verticesZ[int_8] += animOffsetZ;
						}
					}
				}

			}
			else if (int_0 == 3)
			{
				for (int_5 = 0; int_5 < int_4; int_5++)
				{
					int_6 = ints_0[int_5];
					if (int_6 < vertexGroups.length)
					{
						ints_2 = vertexGroups[int_6];

						for (int_10 = 0; int_10 < ints_2.length; int_10++)
						{
							int_8 = ints_2[int_10];
							verticesX[int_8] -= animOffsetX;
							verticesY[int_8] -= animOffsetY;
							verticesZ[int_8] -= animOffsetZ;
							verticesX[int_8] = (int_1 * verticesX[int_8]) / 128;
							verticesY[int_8] = (int_2 * verticesY[int_8]) / 128;
							verticesZ[int_8] = (int_3 * verticesZ[int_8]) / 128;
							verticesX[int_8] += animOffsetX;
							verticesY[int_8] += animOffsetY;
							verticesZ[int_8] += animOffsetZ;
						}
					}
				}

			}
			else if (int_0 == 5)
			{
				if ((field1602 != null) && (field1593 != null))
				{
					for (int_5 = 0; int_5 < int_4; int_5++)
					{
						int_6 = ints_0[int_5];
						if (int_6 < field1602.length)
						{
							ints_2 = field1602[int_6];

							for (int_10 = 0; int_10 < ints_2.length; int_10++)
							{
								int_8 = ints_2[int_10];
								int_9 = (field1593[int_8] & 0xFF) + (int_1 * 8);
								if (int_9 < 0)
								{
									int_9 = 0;
								}
								else if (int_9 > 255)
								{
									int_9 = 255;
								}

								field1593[int_8] = (byte) int_9;
							}
						}
					}
				}

			}
		}
	}

	public void rotateY90Ccw()
	{
		for (int int_0 = 0; int_0 < verticesCount; int_0++)
		{
			final int int_1 = verticesX[int_0];
			verticesX[int_0] = verticesZ[int_0];
			verticesZ[int_0] = -int_1;
		}

		resetBounds();
	}

	public void rotateY180Ccw()
	{
		for (int int_0 = 0; int_0 < verticesCount; int_0++)
		{
			verticesX[int_0] = -verticesX[int_0];
			verticesZ[int_0] = -verticesZ[int_0];
		}

		resetBounds();
	}

	public void rotateY270Ccw()
	{
		for (int int_0 = 0; int_0 < verticesCount; int_0++)
		{
			final int int_1 = verticesZ[int_0];
			verticesZ[int_0] = verticesX[int_0];
			verticesX[int_0] = -int_1;
		}

		resetBounds();
	}

	public void rotateZ(final int int_0)
	{
		final int int_1 = Model_sine[int_0];
		final int int_2 = Model_cosine[int_0];

		for (int int_3 = 0; int_3 < verticesCount; int_3++)
		{
			final int int_4 = ((int_2 * verticesY[int_3]) - (int_1 * verticesZ[int_3])) >> 16;
			verticesZ[int_3] = ((int_1 * verticesY[int_3]) + (int_2 * verticesZ[int_3])) >> 16;
			verticesY[int_3] = int_4;
		}

		resetBounds();
	}

	public void offsetBy(final int int_0, final int int_1, final int int_2)
	{
		for (int int_3 = 0; int_3 < verticesCount; int_3++)
		{
			verticesX[int_3] += int_0;
			verticesY[int_3] += int_1;
			verticesZ[int_3] += int_2;
		}

		resetBounds();
	}

	public void scale(final int int_0, final int int_1, final int int_2)
	{
		for (int int_3 = 0; int_3 < verticesCount; int_3++)
		{
			verticesX[int_3] = (verticesX[int_3] * int_0) / 128;
			verticesY[int_3] = (int_1 * verticesY[int_3]) / 128;
			verticesZ[int_3] = (int_2 * verticesZ[int_3]) / 128;
		}

		resetBounds();
	}

	public void method2682(final int int_0, final int int_1, final int int_2, final int int_3, final int int_4,
	        final int int_5, final int int_6)
	{
		field1625[0] = -1;
		if ((boundsType != 2) && (boundsType != 1))
		{
			method2671();
		}

		final int int_7 = Graphics3D.centerX;
		final int int_8 = Graphics3D.centerY;
		final int int_9 = Model_sine[int_0];
		final int int_10 = Model_cosine[int_0];
		final int int_11 = Model_sine[int_1];
		final int int_12 = Model_cosine[int_1];
		final int int_13 = Model_sine[int_2];
		final int int_14 = Model_cosine[int_2];
		final int int_15 = Model_sine[int_3];
		final int int_16 = Model_cosine[int_3];
		final int int_17 = ((int_15 * int_5) + (int_16 * int_6)) >> 16;

		for (int int_18 = 0; int_18 < verticesCount; int_18++)
		{
			int int_19 = verticesX[int_18];
			int int_20 = verticesY[int_18];
			int int_21 = verticesZ[int_18];
			int int_22;
			if (int_2 != 0)
			{
				int_22 = ((int_20 * int_13) + (int_19 * int_14)) >> 16;
				int_20 = ((int_20 * int_14) - (int_19 * int_13)) >> 16;
				int_19 = int_22;
			}

			if (int_0 != 0)
			{
				int_22 = ((int_20 * int_10) - (int_21 * int_9)) >> 16;
				int_21 = ((int_20 * int_9) + (int_21 * int_10)) >> 16;
				int_20 = int_22;
			}

			if (int_1 != 0)
			{
				int_22 = ((int_21 * int_11) + (int_19 * int_12)) >> 16;
				int_21 = ((int_21 * int_12) - (int_19 * int_11)) >> 16;
				int_19 = int_22;
			}

			int_19 += int_4;
			int_20 += int_5;
			int_21 += int_6;
			int_22 = ((int_20 * int_16) - (int_21 * int_15)) >> 16;
			int_21 = ((int_20 * int_15) + (int_21 * int_16)) >> 16;
			field1590[int_18] = int_21 - int_17;
			modelViewportYs[int_18] = ((int_19 * Graphics3D.Rasterizer3D_zoom) / int_21) + int_7;
			modelViewportXs[int_18] = ((int_22 * Graphics3D.Rasterizer3D_zoom) / int_21) + int_8;
			if (field1597 > 0)
			{
				yViewportBuffer[int_18] = int_19;
				field1577[int_18] = int_22;
				field1623[int_18] = int_21;
			}
		}

		try
		{
			method2685(false, false, false, 0L);
		}
		catch (final Exception exception_0)
		{
        }

	}

	public void method2710(final int int_0, final int int_1, final int int_2, final int int_3, final int int_4,
	        final int int_5, final int int_6, final int int_7)
	{
		field1625[0] = -1;
		if ((boundsType != 2) && (boundsType != 1))
		{
			method2671();
		}

		final int int_8 = Graphics3D.centerX;
		final int int_9 = Graphics3D.centerY;
		final int int_10 = Model_sine[int_0];
		final int int_11 = Model_cosine[int_0];
		final int int_12 = Model_sine[int_1];
		final int int_13 = Model_cosine[int_1];
		final int int_14 = Model_sine[int_2];
		final int int_15 = Model_cosine[int_2];
		final int int_16 = Model_sine[int_3];
		final int int_17 = Model_cosine[int_3];
		final int int_18 = ((int_16 * int_5) + (int_17 * int_6)) >> 16;

		for (int int_19 = 0; int_19 < verticesCount; int_19++)
		{
			int int_20 = verticesX[int_19];
			int int_21 = verticesY[int_19];
			int int_22 = verticesZ[int_19];
			int int_23;
			if (int_2 != 0)
			{
				int_23 = ((int_21 * int_14) + (int_20 * int_15)) >> 16;
				int_21 = ((int_21 * int_15) - (int_20 * int_14)) >> 16;
				int_20 = int_23;
			}

			if (int_0 != 0)
			{
				int_23 = ((int_21 * int_11) - (int_22 * int_10)) >> 16;
				int_22 = ((int_21 * int_10) + (int_22 * int_11)) >> 16;
				int_21 = int_23;
			}

			if (int_1 != 0)
			{
				int_23 = ((int_22 * int_12) + (int_20 * int_13)) >> 16;
				int_22 = ((int_22 * int_13) - (int_20 * int_12)) >> 16;
				int_20 = int_23;
			}

			int_20 += int_4;
			int_21 += int_5;
			int_22 += int_6;
			int_23 = ((int_21 * int_17) - (int_22 * int_16)) >> 16;
			int_22 = ((int_21 * int_16) + (int_22 * int_17)) >> 16;
			field1590[int_19] = int_22 - int_18;
			modelViewportYs[int_19] = int_8 + ((int_20 * Graphics3D.Rasterizer3D_zoom) / int_7);
			modelViewportXs[int_19] = int_9 + ((int_23 * Graphics3D.Rasterizer3D_zoom) / int_7);
			if (field1597 > 0)
			{
				yViewportBuffer[int_19] = int_20;
				field1577[int_19] = int_23;
				field1623[int_19] = int_22;
			}
		}

		try
		{
			method2685(false, false, false, 0L);
		}
		catch (final Exception exception_0)
		{
        }

	}

	void method2685(final boolean bool_0, boolean bool_1, final boolean bool_2, final long long_0)
	{
		if (diameter < 1600)
		{
			int int_0;
			for (int_0 = 0; int_0 < diameter; int_0++)
			{
				field1625[int_0] = 0;
			}

			int_0 = bool_2 ? 20 : 5;

			int int_1;
			int int_2;
			int int_3;
			int int_4;
			int int_5;
			int int_6;
			int int_7;
			int int_9;
			int int_10;
			int int_12;
			for (int_1 = 0; int_1 < indicesCount; int_1++)
			{
				if (field1591[int_1] != -2)
				{
					int_2 = indices1[int_1];
					int_4 = indices2[int_1];
					int_3 = indices3[int_1];
					int_5 = modelViewportYs[int_2];
					int_6 = modelViewportYs[int_4];
					int_7 = modelViewportYs[int_3];
					int int_8;
					if (!bool_0 || ((int_5 != -5000) && (int_6 != -5000) && (int_7 != -5000)))
					{
						if (bool_1 && class228.method4494(modelViewportXs[int_2], modelViewportXs[int_4],
						        modelViewportXs[int_3], int_5, int_6, int_7, int_0))
						{
							class120.field1647[++class120.Viewport_entityCountAtMouse - 1] = long_0;
							bool_1 = false;
						}

						if ((((int_5 - int_6) * (modelViewportXs[int_3] - modelViewportXs[int_4]))
						        - ((int_7 - int_6) * (modelViewportXs[int_2] - modelViewportXs[int_4]))) > 0)
						{
							field1626[int_1] = false;
                            field1616[int_1] = (int_5 < 0) || (int_6 < 0) || (int_7 < 0) || (int_5 > Graphics3D.rasterClipX)
                                    || (int_6 > Graphics3D.rasterClipX) || (int_7 > Graphics3D.rasterClipX);

							int_8 = ((field1590[int_2] + field1590[int_4] + field1590[int_3]) / 3) + radius;
							field1592[int_8][field1625[int_8]++] = int_1;
						}
					}
					else
					{
						int_8 = yViewportBuffer[int_2];
						int_9 = yViewportBuffer[int_4];
						int_10 = yViewportBuffer[int_3];
						int int_11 = field1577[int_2];
						int_12 = field1577[int_4];
						int int_13 = field1577[int_3];
						int int_14 = field1623[int_2];
						final int int_15 = field1623[int_4];
						int int_16 = field1623[int_3];
						int_8 -= int_9;
						int_10 -= int_9;
						int_11 -= int_12;
						int_13 -= int_12;
						int_14 -= int_15;
						int_16 -= int_15;
						final int int_17 = (int_11 * int_16) - (int_14 * int_13);
						final int int_18 = (int_14 * int_10) - (int_8 * int_16);
						final int int_19 = (int_8 * int_13) - (int_11 * int_10);
						if (((int_9 * int_17) + (int_12 * int_18) + (int_15 * int_19)) > 0)
						{
							field1626[int_1] = true;
							final int int_20 = ((field1590[int_2] + field1590[int_4] + field1590[int_3]) / 3) + radius;
							field1592[int_20][field1625[int_20]++] = int_1;
						}
					}
				}
			}

			int[] ints_0;
			if (field1645 == null)
			{
				for (int_1 = diameter - 1; int_1 >= 0; --int_1)
				{
					int_2 = field1625[int_1];
					if (int_2 > 0)
					{
						ints_0 = field1592[int_1];

						for (int_3 = 0; int_3 < int_2; int_3++)
						{
							method2686(ints_0[int_3]);
						}
					}
				}

			}
			else
			{
				for (int_1 = 0; int_1 < 12; int_1++)
				{
					field1638[int_1] = 0;
					field1631[int_1] = 0;
				}

				for (int_1 = diameter - 1; int_1 >= 0; --int_1)
				{
					int_2 = field1625[int_1];
					if (int_2 > 0)
					{
						ints_0 = field1592[int_1];

						for (int_3 = 0; int_3 < int_2; int_3++)
						{
							int_5 = ints_0[int_3];
							final byte byte_0 = field1645[int_5];
							int_7 = field1638[byte_0]++;
							field1640[byte_0][int_7] = int_5;
							if (byte_0 < 10)
							{
								field1631[byte_0] += int_1;
							}
							else if (byte_0 == 10)
							{
								field1608[int_7] = int_1;
							}
							else
							{
								field1595[int_7] = int_1;
							}
						}
					}
				}

				int_1 = 0;
				if ((field1638[1] > 0) || (field1638[2] > 0))
				{
					int_1 = (field1631[1] + field1631[2]) / (field1638[1] + field1638[2]);
				}

				int_2 = 0;
				if ((field1638[3] > 0) || (field1638[4] > 0))
				{
					int_2 = (field1631[3] + field1631[4]) / (field1638[3] + field1638[4]);
				}

				int_4 = 0;
				if ((field1638[6] > 0) || (field1638[8] > 0))
				{
					int_4 = (field1631[8] + field1631[6]) / (field1638[8] + field1638[6]);
				}

				int_5 = 0;
				int_6 = field1638[10];
				int[] ints_1 = field1640[10];
				int[] ints_2 = field1608;
				if (int_5 == int_6)
				{
					int_5 = 0;
					int_6 = field1638[11];
					ints_1 = field1640[11];
					ints_2 = field1595;
				}

				if (int_5 < int_6)
				{
					int_3 = ints_2[int_5];
				}
				else
				{
					int_3 = -1000;
				}

				for (int_9 = 0; int_9 < 10; int_9++)
				{
					while ((int_9 == 0) && (int_3 > int_1))
					{
						method2686(ints_1[int_5++]);
						if ((int_5 == int_6) && (ints_1 != field1640[11]))
						{
							int_5 = 0;
							int_6 = field1638[11];
							ints_1 = field1640[11];
							ints_2 = field1595;
						}

						if (int_5 < int_6)
						{
							int_3 = ints_2[int_5];
						}
						else
						{
							int_3 = -1000;
						}
					}

					while ((int_9 == 3) && (int_3 > int_2))
					{
						method2686(ints_1[int_5++]);
						if ((int_5 == int_6) && (ints_1 != field1640[11]))
						{
							int_5 = 0;
							int_6 = field1638[11];
							ints_1 = field1640[11];
							ints_2 = field1595;
						}

						if (int_5 < int_6)
						{
							int_3 = ints_2[int_5];
						}
						else
						{
							int_3 = -1000;
						}
					}

					while ((int_9 == 5) && (int_3 > int_4))
					{
						method2686(ints_1[int_5++]);
						if ((int_5 == int_6) && (ints_1 != field1640[11]))
						{
							int_5 = 0;
							int_6 = field1638[11];
							ints_1 = field1640[11];
							ints_2 = field1595;
						}

						if (int_5 < int_6)
						{
							int_3 = ints_2[int_5];
						}
						else
						{
							int_3 = -1000;
						}
					}

					int_10 = field1638[int_9];
					final int[] ints_3 = field1640[int_9];

					for (int_12 = 0; int_12 < int_10; int_12++)
					{
						method2686(ints_3[int_12]);
					}
				}

				while (int_3 != -1000)
				{
					method2686(ints_1[int_5++]);
					if ((int_5 == int_6) && (ints_1 != field1640[11]))
					{
						int_5 = 0;
						ints_1 = field1640[11];
						int_6 = field1638[11];
						ints_2 = field1595;
					}

					if (int_5 < int_6)
					{
						int_3 = ints_2[int_5];
					}
					else
					{
						int_3 = -1000;
					}
				}

			}
		}
	}

	void method2686(final int int_0)
	{
		if (field1626[int_0])
		{
			method2687(int_0);
		}
		else
		{
			final int int_1 = indices1[int_0];
			final int int_2 = indices2[int_0];
			final int int_3 = indices3[int_0];
			Graphics3D.rasterClipEnable = field1616[int_0];
			if (field1593 == null)
			{
				Graphics3D.rasterAlpha = 0;
			}
			else
			{
				Graphics3D.rasterAlpha = field1593[int_0] & 0xFF;
			}

			if ((field1604 != null) && (field1604[int_0] != -1))
			{
				int int_5;
				int int_6;
				int int_7;
				if ((field1617 != null) && (field1617[int_0] != -1))
				{
					final int int_4 = field1617[int_0] & 0xFF;
					int_5 = field1621[int_4];
					int_6 = field1599[int_4];
					int_7 = field1600[int_4];
				}
				else
				{
					int_5 = int_1;
					int_6 = int_2;
					int_7 = int_3;
				}

				if (field1591[int_0] == -1)
				{
					Graphics3D.rasterTextureAffine(modelViewportXs[int_1], modelViewportXs[int_2],
					        modelViewportXs[int_3], modelViewportYs[int_1], modelViewportYs[int_2],
					        modelViewportYs[int_3], field1615[int_0], field1615[int_0], field1615[int_0],
					        yViewportBuffer[int_5], yViewportBuffer[int_6], yViewportBuffer[int_7], field1577[int_5],
					        field1577[int_6], field1577[int_7], field1623[int_5], field1623[int_6], field1623[int_7],
					        field1604[int_0]);
				}
				else
				{
					Graphics3D.rasterTextureAffine(modelViewportXs[int_1], modelViewportXs[int_2],
					        modelViewportXs[int_3], modelViewportYs[int_1], modelViewportYs[int_2],
					        modelViewportYs[int_3], field1615[int_0], field1620[int_0], field1591[int_0],
					        yViewportBuffer[int_5], yViewportBuffer[int_6], yViewportBuffer[int_7], field1577[int_5],
					        field1577[int_6], field1577[int_7], field1623[int_5], field1623[int_6], field1623[int_7],
					        field1604[int_0]);
				}
			}
			else if (field1591[int_0] == -1)
			{
				Graphics3D.rasterFlat(modelViewportXs[int_1], modelViewportXs[int_2], modelViewportXs[int_3],
				        modelViewportYs[int_1], modelViewportYs[int_2], modelViewportYs[int_3],
				        field1643[field1615[int_0]]);
			}
			else
			{
				Graphics3D.rasterGouraud(modelViewportXs[int_1], modelViewportXs[int_2], modelViewportXs[int_3],
				        modelViewportYs[int_1], modelViewportYs[int_2], modelViewportYs[int_3], field1615[int_0],
				        field1620[int_0], field1591[int_0]);
			}

		}
	}

	void method2687(final int int_0)
	{
		final int int_1 = Graphics3D.centerX;
		final int int_2 = Graphics3D.centerY;
		int int_3 = 0;
		final int int_4 = indices1[int_0];
		final int int_5 = indices2[int_0];
		final int int_6 = indices3[int_0];
		final int int_7 = field1623[int_4];
		final int int_8 = field1623[int_5];
		final int int_9 = field1623[int_6];
		if (field1593 == null)
		{
			Graphics3D.rasterAlpha = 0;
		}
		else
		{
			Graphics3D.rasterAlpha = field1593[int_0] & 0xFF;
		}

		int int_10;
		int int_11;
		int int_12;
		int int_13;
		if (int_7 >= 50)
		{
			field1632[int_3] = modelViewportYs[int_4];
			field1630[int_3] = modelViewportXs[int_4];
			xViewportBuffer[int_3++] = field1615[int_0];
		}
		else
		{
			int_10 = yViewportBuffer[int_4];
			int_11 = field1577[int_4];
			int_12 = field1615[int_0];
			if (int_9 >= 50)
			{
				int_13 = field1598[int_9 - int_7] * (50 - int_7);
				field1632[int_3] = int_1 + ((Graphics3D.Rasterizer3D_zoom
				        * (int_10 + (((yViewportBuffer[int_6] - int_10) * int_13) >> 16))) / 50);
				field1630[int_3] = int_2
				        + ((Graphics3D.Rasterizer3D_zoom * (int_11 + (((field1577[int_6] - int_11) * int_13) >> 16)))
				                / 50);
				xViewportBuffer[int_3++] = int_12 + (((field1591[int_0] - int_12) * int_13) >> 16);
			}

			if (int_8 >= 50)
			{
				int_13 = field1598[int_8 - int_7] * (50 - int_7);
				field1632[int_3] = int_1 + ((Graphics3D.Rasterizer3D_zoom
				        * (int_10 + (((yViewportBuffer[int_5] - int_10) * int_13) >> 16))) / 50);
				field1630[int_3] = int_2
				        + ((Graphics3D.Rasterizer3D_zoom * (int_11 + (((field1577[int_5] - int_11) * int_13) >> 16)))
				                / 50);
				xViewportBuffer[int_3++] = int_12 + (((field1620[int_0] - int_12) * int_13) >> 16);
			}
		}

		if (int_8 >= 50)
		{
			field1632[int_3] = modelViewportYs[int_5];
			field1630[int_3] = modelViewportXs[int_5];
			xViewportBuffer[int_3++] = field1620[int_0];
		}
		else
		{
			int_10 = yViewportBuffer[int_5];
			int_11 = field1577[int_5];
			int_12 = field1620[int_0];
			if (int_7 >= 50)
			{
				int_13 = field1598[int_7 - int_8] * (50 - int_8);
				field1632[int_3] = int_1 + ((Graphics3D.Rasterizer3D_zoom
				        * (int_10 + (((yViewportBuffer[int_4] - int_10) * int_13) >> 16))) / 50);
				field1630[int_3] = int_2
				        + ((Graphics3D.Rasterizer3D_zoom * (int_11 + (((field1577[int_4] - int_11) * int_13) >> 16)))
				                / 50);
				xViewportBuffer[int_3++] = int_12 + (((field1615[int_0] - int_12) * int_13) >> 16);
			}

			if (int_9 >= 50)
			{
				int_13 = field1598[int_9 - int_8] * (50 - int_8);
				field1632[int_3] = int_1 + ((Graphics3D.Rasterizer3D_zoom
				        * (int_10 + (((yViewportBuffer[int_6] - int_10) * int_13) >> 16))) / 50);
				field1630[int_3] = int_2
				        + ((Graphics3D.Rasterizer3D_zoom * (int_11 + (((field1577[int_6] - int_11) * int_13) >> 16)))
				                / 50);
				xViewportBuffer[int_3++] = int_12 + (((field1591[int_0] - int_12) * int_13) >> 16);
			}
		}

		if (int_9 >= 50)
		{
			field1632[int_3] = modelViewportYs[int_6];
			field1630[int_3] = modelViewportXs[int_6];
			xViewportBuffer[int_3++] = field1591[int_0];
		}
		else
		{
			int_10 = yViewportBuffer[int_6];
			int_11 = field1577[int_6];
			int_12 = field1591[int_0];
			if (int_8 >= 50)
			{
				int_13 = field1598[int_8 - int_9] * (50 - int_9);
				field1632[int_3] = int_1 + ((Graphics3D.Rasterizer3D_zoom
				        * (int_10 + (((yViewportBuffer[int_5] - int_10) * int_13) >> 16))) / 50);
				field1630[int_3] = int_2
				        + ((Graphics3D.Rasterizer3D_zoom * (int_11 + (((field1577[int_5] - int_11) * int_13) >> 16)))
				                / 50);
				xViewportBuffer[int_3++] = int_12 + (((field1620[int_0] - int_12) * int_13) >> 16);
			}

			if (int_7 >= 50)
			{
				int_13 = field1598[int_7 - int_9] * (50 - int_9);
				field1632[int_3] = int_1 + ((Graphics3D.Rasterizer3D_zoom
				        * (int_10 + (((yViewportBuffer[int_4] - int_10) * int_13) >> 16))) / 50);
				field1630[int_3] = int_2
				        + ((Graphics3D.Rasterizer3D_zoom * (int_11 + (((field1577[int_4] - int_11) * int_13) >> 16)))
				                / 50);
				xViewportBuffer[int_3++] = int_12 + (((field1615[int_0] - int_12) * int_13) >> 16);
			}
		}

		int_10 = field1632[0];
		int_11 = field1632[1];
		int_12 = field1632[2];
		int_13 = field1630[0];
		final int int_14 = field1630[1];
		final int int_15 = field1630[2];
		Graphics3D.rasterClipEnable = false;
		int int_16;
		int int_17;
		int int_18;
		int int_19;
		if (int_3 == 3)
		{
			if ((int_10 < 0) || (int_11 < 0) || (int_12 < 0) || (int_10 > Graphics3D.rasterClipX)
			        || (int_11 > Graphics3D.rasterClipX) || (int_12 > Graphics3D.rasterClipX))
			{
				Graphics3D.rasterClipEnable = true;
			}

			if ((field1604 != null) && (field1604[int_0] != -1))
			{
				if ((field1617 != null) && (field1617[int_0] != -1))
				{
					int_17 = field1617[int_0] & 0xFF;
					int_16 = field1621[int_17];
					int_18 = field1599[int_17];
					int_19 = field1600[int_17];
				}
				else
				{
					int_16 = int_4;
					int_18 = int_5;
					int_19 = int_6;
				}

				if (field1591[int_0] == -1)
				{
					Graphics3D.rasterTextureAffine(int_13, int_14, int_15, int_10, int_11, int_12, field1615[int_0],
					        field1615[int_0], field1615[int_0], yViewportBuffer[int_16], yViewportBuffer[int_18],
					        yViewportBuffer[int_19], field1577[int_16], field1577[int_18], field1577[int_19],
					        field1623[int_16], field1623[int_18], field1623[int_19], field1604[int_0]);
				}
				else
				{
					Graphics3D.rasterTextureAffine(int_13, int_14, int_15, int_10, int_11, int_12, xViewportBuffer[0],
					        xViewportBuffer[1], xViewportBuffer[2], yViewportBuffer[int_16], yViewportBuffer[int_18],
					        yViewportBuffer[int_19], field1577[int_16], field1577[int_18], field1577[int_19],
					        field1623[int_16], field1623[int_18], field1623[int_19], field1604[int_0]);
				}
			}
			else if (field1591[int_0] == -1)
			{
				Graphics3D.rasterFlat(int_13, int_14, int_15, int_10, int_11, int_12, field1643[field1615[int_0]]);
			}
			else
			{
				Graphics3D.rasterGouraud(int_13, int_14, int_15, int_10, int_11, int_12, xViewportBuffer[0],
				        xViewportBuffer[1], xViewportBuffer[2]);
			}
		}

		if (int_3 == 4)
		{
			if ((int_10 < 0) || (int_11 < 0) || (int_12 < 0) || (int_10 > Graphics3D.rasterClipX)
			        || (int_11 > Graphics3D.rasterClipX) || (int_12 > Graphics3D.rasterClipX) || (field1632[3] < 0)
			        || (field1632[3] > Graphics3D.rasterClipX))
			{
				Graphics3D.rasterClipEnable = true;
			}

			if ((field1604 != null) && (field1604[int_0] != -1))
			{
				if ((field1617 != null) && (field1617[int_0] != -1))
				{
					int_17 = field1617[int_0] & 0xFF;
					int_16 = field1621[int_17];
					int_18 = field1599[int_17];
					int_19 = field1600[int_17];
				}
				else
				{
					int_16 = int_4;
					int_18 = int_5;
					int_19 = int_6;
				}

				final short short_0 = field1604[int_0];
				if (field1591[int_0] == -1)
				{
					Graphics3D.rasterTextureAffine(int_13, int_14, int_15, int_10, int_11, int_12, field1615[int_0],
					        field1615[int_0], field1615[int_0], yViewportBuffer[int_16], yViewportBuffer[int_18],
					        yViewportBuffer[int_19], field1577[int_16], field1577[int_18], field1577[int_19],
					        field1623[int_16], field1623[int_18], field1623[int_19], short_0);
					Graphics3D.rasterTextureAffine(int_13, int_15, field1630[3], int_10, int_12, field1632[3],
					        field1615[int_0], field1615[int_0], field1615[int_0], yViewportBuffer[int_16],
					        yViewportBuffer[int_18], yViewportBuffer[int_19], field1577[int_16], field1577[int_18],
					        field1577[int_19], field1623[int_16], field1623[int_18], field1623[int_19], short_0);
				}
				else
				{
					Graphics3D.rasterTextureAffine(int_13, int_14, int_15, int_10, int_11, int_12, xViewportBuffer[0],
					        xViewportBuffer[1], xViewportBuffer[2], yViewportBuffer[int_16], yViewportBuffer[int_18],
					        yViewportBuffer[int_19], field1577[int_16], field1577[int_18], field1577[int_19],
					        field1623[int_16], field1623[int_18], field1623[int_19], short_0);
					Graphics3D.rasterTextureAffine(int_13, int_15, field1630[3], int_10, int_12, field1632[3],
					        xViewportBuffer[0], xViewportBuffer[2], xViewportBuffer[3], yViewportBuffer[int_16],
					        yViewportBuffer[int_18], yViewportBuffer[int_19], field1577[int_16], field1577[int_18],
					        field1577[int_19], field1623[int_16], field1623[int_18], field1623[int_19], short_0);
				}
			}
			else if (field1591[int_0] == -1)
			{
				int_16 = field1643[field1615[int_0]];
				Graphics3D.rasterFlat(int_13, int_14, int_15, int_10, int_11, int_12, int_16);
				Graphics3D.rasterFlat(int_13, int_15, field1630[3], int_10, int_12, field1632[3], int_16);
			}
			else
			{
				Graphics3D.rasterGouraud(int_13, int_14, int_15, int_10, int_11, int_12, xViewportBuffer[0],
				        xViewportBuffer[1], xViewportBuffer[2]);
				Graphics3D.rasterGouraud(int_13, int_15, field1630[3], int_10, int_12, field1632[3], xViewportBuffer[0],
				        xViewportBuffer[2], xViewportBuffer[3]);
			}
		}

	}

	@Override
	void vmethod3063(final int int_0, final int int_1, final int int_2, final int int_3, final int int_4,
	        final int int_5, final int int_6, final int int_7, final long long_0)
	{
		field1625[0] = -1;
		if (boundsType != 1)
		{
			calculateBoundsCylinder();
		}

		method2669(int_0);
		final int int_8 = ((int_4 * int_7) - (int_3 * int_5)) >> 16;
		final int int_9 = ((int_1 * int_6) + (int_2 * int_8)) >> 16;
		final int int_10 = (int_2 * XYZMag) >> 16;
		final int int_11 = int_9 + int_10;
		if ((int_11 > 50) && (int_9 < 3500))
		{
			final int int_12 = ((int_7 * int_3) + (int_4 * int_5)) >> 16;
			int int_13 = (int_12 - XYZMag) * Graphics3D.Rasterizer3D_zoom;
			if ((int_13 / int_11) < Graphics3D.Rasterizer3D_clipMidX2)
			{
				int int_14 = (int_12 + XYZMag) * Graphics3D.Rasterizer3D_zoom;
				if ((int_14 / int_11) > Graphics3D.Rasterizer3D_clipNegativeMidX)
				{
					final int int_15 = ((int_2 * int_6) - (int_8 * int_1)) >> 16;
					final int int_16 = (int_1 * XYZMag) >> 16;
					int int_17 = (int_15 + int_16) * Graphics3D.Rasterizer3D_zoom;
					if ((int_17 / int_11) > Graphics3D.Rasterizer3D_clipNegativeMidY)
					{
						final int int_18 = ((int_2 * super.modelHeight) >> 16) + int_16;
						int int_19 = (int_15 - int_18) * Graphics3D.Rasterizer3D_zoom;
						if ((int_19 / int_11) < Graphics3D.Rasterizer3D_clipMidY2) {
							final int int_20 = int_10 + ((int_1 * super.modelHeight) >> 16);
							boolean bool_0 = false;
							boolean bool_1 = false;
							if ((int_9 - int_20) <= 50)
							{
								bool_1 = true;
							}

							final boolean bool_2 = bool_1 || (field1597 > 0);
							final int int_21 = class81.method1884();
							final int int_22 = class120.Viewport_mouseY;
							final boolean bool_3 = class165.method3437();
							boolean bool_4 = long_0 != 0L;
							boolean bool_5;
							if (bool_4)
							{
								bool_5 = (int) ((long_0 >>> 16) & 0x1L) == 1;
								bool_4 = !bool_5;
							}

							bool_5 = false;
							int int_23;
							int int_24;
							int int_25;
							int int_26;
							int int_27;
							int int_28;
							int int_32;
							int int_34;
							if (bool_4 && bool_3)
							{
								boolean bool_6 = false;
								if (useBoundingBoxes3D)
								{
									boolean bool_7;
									if (!class165.method3437())
									{
										bool_7 = false;
									}
									else
									{
										GrandExchangeOffer.method56();
										int_23 = centerX + int_5;
										int_24 = int_6 + centerY;
										int_25 = int_7 + centerZ;
										int_26 = extremeX;
										int_27 = extremeY;
										int_28 = extremeZ;
										final int int_29 = class120.field1657 - int_23;
										final int int_30 = class120.field1659 - int_24;
										final int int_31 = class177.field2283 - int_25;
										if (Math.abs(int_29) > (int_26 + class98.field1335))
										{
											bool_7 = false;
										}
										else if (Math.abs(int_30) > (int_27 + class120.field1655))
										{
											bool_7 = false;
										}
										else if (Math.abs(int_31) > (int_28 + ClassInfo.field3757))
										{
											bool_7 = false;
										}
										else if (Math.abs((int_31 * class120.field1651)
										        - (int_30 * class120.field1654)) > ((int_28 * class120.field1655)
										                + (int_27 * ClassInfo.field3757)))
										{
											bool_7 = false;
										}
										else if (Math.abs((int_29 * class120.field1654)
										        - (int_31 * class303.field3721)) > ((int_28 * class98.field1335)
										                + (int_26 * ClassInfo.field3757)))
										{
											bool_7 = false;
										}
										else bool_7 = Math.abs((int_30 * class303.field3721)
                                                    - (int_29 * class120.field1651)) <= ((int_26 * class120.field1655)
                                                    + (int_27 * class98.field1335));
									}

									bool_6 = bool_7;
								}
								else
								{
									int_34 = int_9 - int_10;
									if (int_34 <= 50)
									{
										int_34 = 50;
									}

									if (int_12 > 0)
									{
										int_13 /= int_11;
										int_14 /= int_34;
									}
									else
									{
										int_14 /= int_11;
										int_13 /= int_34;
									}

									if (int_15 > 0)
									{
										int_19 /= int_11;
										int_17 /= int_34;
									}
									else
									{
										int_17 /= int_11;
										int_19 /= int_34;
									}

									int_32 = int_21 - Graphics3D.centerX;
									int_23 = int_22 - Graphics3D.centerY;
									if ((int_32 > int_13) && (int_32 < int_14) && (int_23 > int_19)
									        && (int_23 < int_17))
									{
										bool_6 = true;
									}
								}

								if (bool_6)
								{
									if (field1603)
									{
										class120.field1647[++class120.Viewport_entityCountAtMouse - 1] = long_0;
									}
									else
									{
										bool_5 = true;
									}
								}
							}

							final int int_33 = Graphics3D.centerX;
							int_34 = Graphics3D.centerY;
							int_32 = 0;
							int_23 = 0;
							if (int_0 != 0)
							{
								int_32 = Model_sine[int_0];
								int_23 = Model_cosine[int_0];
							}

							for (int_24 = 0; int_24 < verticesCount; int_24++)
							{
								int_25 = verticesX[int_24];
								int_26 = verticesY[int_24];
								int_27 = verticesZ[int_24];
								if (int_0 != 0)
								{
									int_28 = ((int_27 * int_32) + (int_25 * int_23)) >> 16;
									int_27 = ((int_27 * int_23) - (int_25 * int_32)) >> 16;
									int_25 = int_28;
								}

								int_25 += int_5;
								int_26 += int_6;
								int_27 += int_7;
								int_28 = ((int_27 * int_3) + (int_4 * int_25)) >> 16;
								int_27 = ((int_4 * int_27) - (int_25 * int_3)) >> 16;
								int_25 = int_28;
								int_28 = ((int_2 * int_26) - (int_27 * int_1)) >> 16;
								int_27 = ((int_26 * int_1) + (int_2 * int_27)) >> 16;
								field1590[int_24] = int_27 - int_9;
								if (int_27 >= 50)
								{
									modelViewportYs[int_24] = ((int_25 * Graphics3D.Rasterizer3D_zoom) / int_27)
									        + int_33;
									modelViewportXs[int_24] = ((int_28 * Graphics3D.Rasterizer3D_zoom) / int_27)
									        + int_34;
								}
								else
								{
									modelViewportYs[int_24] = -5000;
									bool_0 = true;
								}

								if (bool_2)
								{
									yViewportBuffer[int_24] = int_25;
									field1577[int_24] = int_28;
									field1623[int_24] = int_27;
								}
							}

							try
							{
								method2685(bool_0, bool_5, field1603, long_0);
							}
							catch (final Exception exception_0)
							{
                            }

						}
					}
				}
			}
		}
	}

}
