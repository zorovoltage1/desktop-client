public final class NPC extends Actor
{

	static SpritePixels minimapSprite;
	static int field1033;
	static int[] field1035;
	NPCComposition composition;

	void method1794(final int int_0, final byte byte_0)
	{
		int int_1 = super.pathX[0];
		int int_2 = super.pathY[0];
		if (int_0 == 0)
		{
			--int_1;
			++int_2;
		}

		if (int_0 == 1)
		{
			++int_2;
		}

		if (int_0 == 2)
		{
			++int_1;
			++int_2;
		}

		if (int_0 == 3)
		{
			--int_1;
		}

		if (int_0 == 4)
		{
			++int_1;
		}

		if (int_0 == 5)
		{
			--int_1;
			--int_2;
		}

		if (int_0 == 6)
		{
			--int_2;
		}

		if (int_0 == 7)
		{
			++int_1;
			--int_2;
		}

		if ((super.animation != -1) && (TotalQuantityComparator.getAnimation(super.animation).priority == 1))
		{
			super.animation = -1;
		}

		if (super.queueSize < 9)
		{
			++super.queueSize;
		}

		for (int int_3 = super.queueSize; int_3 > 0; --int_3)
		{
			super.pathX[int_3] = super.pathX[int_3 - 1];
			super.pathY[int_3] = super.pathY[int_3 - 1];
			super.pathTraversed[int_3] = super.pathTraversed[int_3 - 1];
		}

		super.pathX[0] = int_1;
		super.pathY[0] = int_2;
		super.pathTraversed[0] = byte_0;
	}

	void method1788(final int int_0, final int int_1, final boolean bool_0)
	{
		if ((super.animation != -1) && (TotalQuantityComparator.getAnimation(super.animation).priority == 1))
		{
			super.animation = -1;
		}

		if (!bool_0)
		{
			final int int_2 = int_0 - super.pathX[0];
			final int int_3 = int_1 - super.pathY[0];
			if ((int_2 >= -8) && (int_2 <= 8) && (int_3 >= -8) && (int_3 <= 8))
			{
				if (super.queueSize < 9)
				{
					++super.queueSize;
				}

				for (int int_4 = super.queueSize; int_4 > 0; --int_4)
				{
					super.pathX[int_4] = super.pathX[int_4 - 1];
					super.pathY[int_4] = super.pathY[int_4 - 1];
					super.pathTraversed[int_4] = super.pathTraversed[int_4 - 1];
				}

				super.pathX[0] = int_0;
				super.pathY[0] = int_1;
				super.pathTraversed[0] = 1;
				return;
			}
		}

		super.queueSize = 0;
		super.field930 = 0;
		super.field923 = 0;
		super.pathX[0] = int_0;
		super.pathY[0] = int_1;
		super.x = (super.field874 * 64) + (super.pathX[0] * 128);
		super.y = (super.field874 * 64) + (super.pathY[0] * 128);
	}

	@Override
	protected Model getModel()
	{
		if (composition == null)
		{
			return null;
		}
		else
		{
			final Sequence sequence_0 = (super.animation != -1) && (super.actionAnimationDisable == 0)
			        ? TotalQuantityComparator.getAnimation(super.animation)
			        : null;
			final Sequence sequence_1 = (super.poseAnimation != -1)
			        && ((super.poseAnimation != super.idlePoseAnimation) || (sequence_0 == null))
			                ? TotalQuantityComparator.getAnimation(super.poseAnimation)
			                : null;
			Model model_0 = composition.getModel(sequence_0, super.actionFrame, sequence_1, super.poseFrame);
			if (model_0 == null)
			{
				return null;
			}
			else
			{
				model_0.calculateBoundsCylinder();
				super.logicalHeight = model_0.modelHeight;
				if ((super.graphic != -1) && (super.spotAnimFrame != -1))
				{
					final Model model_1 = MouseRecorder.getSpotAnimType(super.graphic).getModel(super.spotAnimFrame);
					if (model_1 != null)
					{
						model_1.offsetBy(0, -super.field871, 0);
						final Model[] models_0 = new Model[] { model_0, model_1 };
						model_0 = new Model(models_0, 2);
					}
				}

				if (composition.size == 1)
				{
					model_0.field1603 = true;
				}

				return model_0;
			}
		}
	}

	@Override
	boolean hasConfig()
	{
		return composition != null;
	}

}
