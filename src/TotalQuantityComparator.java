import java.util.Comparator;

final class TotalQuantityComparator implements Comparator
{

	int method24(final GrandExchangeEvent grandexchangeevent_0, final GrandExchangeEvent grandexchangeevent_1)
	{
		return grandexchangeevent_0.grandExchangeOffer.totalQuantity < grandexchangeevent_1.grandExchangeOffer.totalQuantity
		        ? -1
		        : (grandexchangeevent_1.grandExchangeOffer.totalQuantity == grandexchangeevent_0.grandExchangeOffer.totalQuantity
		                ? 0
		                : 1);
	}

	@Override
	public boolean equals(final Object object_0)
	{
		return super.equals(object_0);
	}

	@Override
	public int compare(final Object object_0, final Object object_1)
	{
		return method24((GrandExchangeEvent) object_0, (GrandExchangeEvent) object_1);
	}

	public static Sequence getAnimation(final int int_0)
	{
		Sequence sequence_0 = (Sequence) Sequence.sequences.get(int_0);
		if (sequence_0 != null)
		{
			return sequence_0;
		}
		else
		{
			final byte[] bytes_0 = Sequence.seq_ref.getConfigData(12, int_0);
			sequence_0 = new Sequence();
			if (bytes_0 != null)
			{
				sequence_0.decode(new Buffer(bytes_0));
			}

			sequence_0.post();
			Sequence.sequences.put(sequence_0, int_0);
			return sequence_0;
		}
	}

	public static int method32(final int int_0)
	{
		return class37.method662(class120.field1647[int_0]);
	}

	public static int method35(final CharSequence charsequence_0)
	{
		final int int_0 = charsequence_0.length();
		int int_1 = 0;

		for (int int_2 = 0; int_2 < int_0; int_2++)
		{
			int_1 = ((int_1 << 5) - int_1) + charsequence_0.charAt(int_2);
		}

		return int_1;
	}

	public static void method34()
	{
		ObjectComposition.objects.reset();
		ObjectComposition.field3391.reset();
		ObjectComposition.cachedModels.reset();
		ObjectComposition.field3374.reset();
	}

	static void method26(final Actor actor_0)
	{
		if (actor_0.field924 != 0)
		{
			if (actor_0.interacting != -1)
			{
				Object object_0 = null;
				if (actor_0.interacting < 32768)
				{
					object_0 = Game.cachedNPCs[actor_0.interacting];
				}
				else if (actor_0.interacting >= 32768)
				{
					object_0 = Game.cachedPlayers[actor_0.interacting - 32768];
				}

				if (object_0 != null)
				{
					final int int_0 = actor_0.x - ((Actor) object_0).x;
					final int int_1 = actor_0.y - ((Actor) object_0).y;
					if ((int_0 != 0) || (int_1 != 0))
					{
						actor_0.orientation = (int) (Math.atan2(int_0, int_1) * 325.949D) & 0x7FF;
					}
				}
				else if (actor_0.field898)
				{
					actor_0.interacting = -1;
					actor_0.field898 = false;
				}
			}

			if ((actor_0.field920 != -1) && ((actor_0.queueSize == 0) || (actor_0.field923 > 0)))
			{
				actor_0.orientation = actor_0.field920;
				actor_0.field920 = -1;
			}

			final int int_2 = (actor_0.orientation - actor_0.angle) & 0x7FF;
			if ((int_2 == 0) && actor_0.field898)
			{
				actor_0.interacting = -1;
				actor_0.field898 = false;
			}

			if (int_2 != 0)
			{
				++actor_0.field875;
				boolean bool_0;
				if (int_2 > 1024)
				{
					actor_0.angle -= actor_0.field924;
					bool_0 = true;
					if ((int_2 < actor_0.field924) || (int_2 > (2048 - actor_0.field924)))
					{
						actor_0.angle = actor_0.orientation;
						bool_0 = false;
					}

					if ((actor_0.idlePoseAnimation == actor_0.poseAnimation) && ((actor_0.field875 > 25) || bool_0))
					{
						if (actor_0.field877 != -1)
						{
							actor_0.poseAnimation = actor_0.field877;
						}
						else
						{
							actor_0.poseAnimation = actor_0.field899;
						}
					}
				}
				else
				{
					actor_0.angle += actor_0.field924;
					bool_0 = true;
					if ((int_2 < actor_0.field924) || (int_2 > (2048 - actor_0.field924)))
					{
						actor_0.angle = actor_0.orientation;
						bool_0 = false;
					}

					if ((actor_0.idlePoseAnimation == actor_0.poseAnimation) && ((actor_0.field875 > 25) || bool_0))
					{
						if (actor_0.field878 != -1)
						{
							actor_0.poseAnimation = actor_0.field878;
						}
						else
						{
							actor_0.poseAnimation = actor_0.field899;
						}
					}
				}

				actor_0.angle &= 0x7FF;
			}
			else
			{
				actor_0.field875 = 0;
			}

		}
	}

}
