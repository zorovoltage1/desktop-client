public abstract class Actor extends Renderable
{

	static AbstractSoundSystem soundSystem1;
	static Font font_p12full;
	static int field932;
	int x;
	int y;
	int angle;
	boolean field873;
	int field874;
	int field889;
	int idlePoseAnimation;
	int field877;
	int field878;
	int field899;
	int field880;
	int field870;
	int field882;
	int field883;
	String overhead;
	boolean field885;
	boolean field886;
	int overheadTextCyclesRemaining;
	int field888;
	int field927;
	byte field890;
	int[] hitsplatTypes;
	int[] hitsplatValues;
	int[] hitsplatCycles;
	int[] field894;
	int[] field921;
	CombatInfoList combatInfoList;
	int interacting;
	boolean field898;
	int field920;
	int poseAnimation;
	int poseFrame;
	int poseFrameCycle;
	int animation;
	int actionFrame;
	int actionFrameCycle;
	int actionAnimationDisable;
	int field907;
	int graphic;
	int spotAnimFrame;
	int spotAnimFrameCycle;
	int graphicsDelay;
	int field871;
	int field913;
	int field916;
	int field915;
	int field929;
	int field917;
	int field918;
	int field919;
	int npcCycle;
	int logicalHeight;
	int orientation;
	int field875;
	int field924;
	int queueSize;
	int[] pathX;
	int[] pathY;
	byte[] pathTraversed;
	int field923;
	int field930;

	Actor()
	{
		field873 = false;
		field874 = 1;
		idlePoseAnimation = -1;
		field877 = -1;
		field878 = -1;
		field899 = -1;
		field880 = -1;
		field870 = -1;
		field882 = -1;
		field883 = -1;
		overhead = null;
		field886 = false;
		overheadTextCyclesRemaining = 100;
		field888 = 0;
		field927 = 0;
		field890 = 0;
		hitsplatTypes = new int[4];
		hitsplatValues = new int[4];
		hitsplatCycles = new int[4];
		field894 = new int[4];
		field921 = new int[4];
		combatInfoList = new CombatInfoList();
		interacting = -1;
		field898 = false;
		field920 = -1;
		poseAnimation = -1;
		poseFrame = 0;
		poseFrameCycle = 0;
		animation = -1;
		actionFrame = 0;
		actionFrameCycle = 0;
		actionAnimationDisable = 0;
		field907 = 0;
		graphic = -1;
		spotAnimFrame = 0;
		spotAnimFrameCycle = 0;
		npcCycle = 0;
		logicalHeight = 200;
		field875 = 0;
		field924 = 32;
		queueSize = 0;
		pathX = new int[10];
		pathY = new int[10];
		pathTraversed = new byte[10];
		field923 = 0;
		field930 = 0;
	}

	boolean hasConfig()
	{
		return false;
	}

	void method1540()
	{
		queueSize = 0;
		field930 = 0;
	}

	void applyActorHitsplat(final int int_0, final int int_1, final int int_2, final int int_3, final int int_4,
	        final int int_5)
	{
		boolean bool_0 = true;
		boolean bool_1 = true;

		int int_6;
		for (int_6 = 0; int_6 < 4; int_6++)
		{
			if (hitsplatCycles[int_6] > int_4)
			{
				bool_0 = false;
			}
			else
			{
				bool_1 = false;
			}
		}

		int_6 = -1;
		int int_7 = -1;
		int int_8 = 0;
		if (int_0 >= 0)
		{
			final class267 class267_0 = WorldMapType3.method123(int_0);
			int_7 = class267_0.field3360;
			int_8 = class267_0.field3355;
		}

		int int_9;
		if (bool_1)
		{
			if (int_7 == -1)
			{
				return;
			}

			int_6 = 0;
			int_9 = 0;
			if (int_7 == 0)
			{
				int_9 = hitsplatCycles[0];
			}
			else if (int_7 == 1)
			{
				int_9 = hitsplatValues[0];
			}

			for (int int_10 = 1; int_10 < 4; int_10++)
			{
				if (int_7 == 0)
				{
					if (hitsplatCycles[int_10] < int_9)
					{
						int_6 = int_10;
						int_9 = hitsplatCycles[int_10];
					}
				}
				else if ((int_7 == 1) && (hitsplatValues[int_10] < int_9))
				{
					int_6 = int_10;
					int_9 = hitsplatValues[int_10];
				}
			}

			if ((int_7 == 1) && (int_9 >= int_1))
			{
				return;
			}
		}
		else
		{
			if (bool_0)
			{
				field890 = 0;
			}

			for (int_9 = 0; int_9 < 4; int_9++)
			{
				final byte byte_0 = field890;
				field890 = (byte) ((field890 + 1) % 4);
				if (hitsplatCycles[byte_0] <= int_4)
				{
					int_6 = byte_0;
					break;
				}
			}
		}

		if (int_6 >= 0)
		{
			hitsplatTypes[int_6] = int_0;
			hitsplatValues[int_6] = int_1;
			field894[int_6] = int_2;
			field921[int_6] = int_3;
			hitsplatCycles[int_6] = int_4 + int_8 + int_5;
		}
	}

	void setCombatInfo(final int int_0, final int int_1, final int int_2, final int int_3, final int int_4,
	        final int int_5)
	{
		CombatInfo2 combatinfo2_0 = (CombatInfo2) CombatInfo2.field3305.get(int_0);
		CombatInfo2 combatinfo2_1;
		if (combatinfo2_0 != null)
		{
			combatinfo2_1 = combatinfo2_0;
		}
		else
		{
			final byte[] bytes_0 = CombatInfo2.field3304.getConfigData(33, int_0);
			combatinfo2_0 = new CombatInfo2();
			if (bytes_0 != null)
			{
				combatinfo2_0.read(new Buffer(bytes_0));
			}

			CombatInfo2.field3305.put(combatinfo2_0, int_0);
			combatinfo2_1 = combatinfo2_0;
		}

		combatinfo2_0 = combatinfo2_1;
		CombatInfoListHolder combatinfolistholder_2 = null;
		CombatInfoListHolder combatinfolistholder_0 = null;
		int int_6 = combatinfo2_1.field3307;
		int int_7 = 0;

		CombatInfoListHolder combatinfolistholder_1;
		for (combatinfolistholder_1 = (CombatInfoListHolder) combatInfoList
		        .last(); combatinfolistholder_1 != null; combatinfolistholder_1 = (CombatInfoListHolder) combatInfoList
		                .previous())
		{
			++int_7;
			if (combatinfolistholder_1.combatInfo2.field3317 == combatinfo2_0.field3317)
			{
				combatinfolistholder_1.method1772(int_1 + int_3, int_4, int_5, int_2);
				return;
			}

			if (combatinfolistholder_1.combatInfo2.field3310 <= combatinfo2_0.field3310)
			{
				combatinfolistholder_2 = combatinfolistholder_1;
			}

			if (combatinfolistholder_1.combatInfo2.field3307 > int_6)
			{
				combatinfolistholder_0 = combatinfolistholder_1;
				int_6 = combatinfolistholder_1.combatInfo2.field3307;
			}
		}

		if ((combatinfolistholder_0 != null) || (int_7 < 4))
		{
			combatinfolistholder_1 = new CombatInfoListHolder(combatinfo2_0);
			if (combatinfolistholder_2 == null)
			{
				combatInfoList.addLast(combatinfolistholder_1);
			}
			else
			{
				CombatInfoList.method4036(combatinfolistholder_1, combatinfolistholder_2);
			}

			combatinfolistholder_1.method1772(int_1 + int_3, int_4, int_5, int_2);
			if (int_7 >= 4)
			{
				combatinfolistholder_0.unlink();
			}

		}
	}

	void method1557(final int int_0)
	{
		CombatInfo2 combatinfo2_0 = (CombatInfo2) CombatInfo2.field3305.get(int_0);
		CombatInfo2 combatinfo2_1;
		if (combatinfo2_0 != null)
		{
			combatinfo2_1 = combatinfo2_0;
		}
		else
		{
			final byte[] bytes_0 = CombatInfo2.field3304.getConfigData(33, int_0);
			combatinfo2_0 = new CombatInfo2();
			if (bytes_0 != null)
			{
				combatinfo2_0.read(new Buffer(bytes_0));
			}

			CombatInfo2.field3305.put(combatinfo2_0, int_0);
			combatinfo2_1 = combatinfo2_0;
		}

		combatinfo2_0 = combatinfo2_1;

		for (CombatInfoListHolder combatinfolistholder_0 = (CombatInfoListHolder) combatInfoList
		        .last(); combatinfolistholder_0 != null; combatinfolistholder_0 = (CombatInfoListHolder) combatInfoList
		                .previous())
		{
			if (combatinfo2_0 == combatinfolistholder_0.combatInfo2)
			{
				combatinfolistholder_0.unlink();
				return;
			}
		}

	}

	public static void method1539(final long long_0)
	{
		if (long_0 > 0L)
		{
			if ((long_0 % 10L) == 0L)
			{
				final long long_1 = long_0 - 1L;

				try
				{
					Thread.sleep(long_1);
				}
				catch (final InterruptedException interruptedexception_1)
				{
                }

				try
				{
					Thread.sleep(1L);
				}
				catch (final InterruptedException interruptedexception_2)
				{
                }
			}
			else
			{
				try
				{
					Thread.sleep(long_0);
				}
				catch (final InterruptedException interruptedexception_0)
				{
                }
			}

		}
	}

	public static VarPlayerType method1549(final int int_0)
	{
		VarPlayerType varplayertype_0 = (VarPlayerType) VarPlayerType.varplayers.get(int_0);
		if (varplayertype_0 != null)
		{
			return varplayertype_0;
		}
		else
		{
			final byte[] bytes_0 = WorldComparator.varplayer_ref.getConfigData(16, int_0);
			varplayertype_0 = new VarPlayerType();
			if (bytes_0 != null)
			{
				varplayertype_0.decode(new Buffer(bytes_0));
			}

			VarPlayerType.varplayers.put(varplayertype_0, int_0);
			return varplayertype_0;
		}
	}

	public static void method1554(final IndexDataBase indexdatabase_0, final int int_0, final int int_1,
	        final int int_2, final boolean bool_0)
	{
		class217.field2460 = 1;
		class138.field1871 = indexdatabase_0;
		class217.field2461 = int_0;
		class217.field2462 = int_1;
		class309.field3740 = int_2;
		class217.field2463 = bool_0;
		class6.field37 = 10000;
	}

}
