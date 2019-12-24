public class class103 extends TaskDataNode
{

	int field1357;
	int field1364;
	int field1356;
	int field1366;
	int field1359;
	int field1360;
	int field1361;
	int field1362;
	int startPosition;
	int endPosition;
	boolean field1365;
	int field1355;
	int field1358;
	int field1368;
	int field1369;

	class103(final RawAudioNode rawaudionode_0, final int int_0, final int int_1, final int int_2)
	{
		super.data = rawaudionode_0;
		startPosition = rawaudionode_0.startPosition;
		endPosition = rawaudionode_0.endPosition;
		field1365 = rawaudionode_0.field1281;
		field1364 = int_0;
		field1356 = int_1;
		field1366 = int_2;
		field1357 = 0;
		method2324();
	}

	class103(final RawAudioNode rawaudionode_0, final int int_0, final int int_1)
	{
		super.data = rawaudionode_0;
		startPosition = rawaudionode_0.startPosition;
		endPosition = rawaudionode_0.endPosition;
		field1365 = rawaudionode_0.field1281;
		field1364 = int_0;
		field1356 = int_1;
		field1366 = 8192;
		field1357 = 0;
		method2324();
	}

	void method2324()
	{
		field1359 = field1356;
		field1360 = method2341(field1356, field1366);
		field1361 = method2251(field1356, field1366);
	}

	@Override
	protected TaskDataNode vmethod4382()
	{
		return null;
	}

	@Override
	protected TaskDataNode vmethod4389()
	{
		return null;
	}

	@Override
	protected int vmethod4395()
	{
		return (field1356 == 0) && (field1355 == 0) ? 0 : 1;
	}

	@Override
	public synchronized void vmethod4385(final int[] ints_0, final int int_0, int int_1)
	{
		if ((field1356 == 0) && (field1355 == 0))
		{
			vmethod4386(int_1);
		}
		else
		{
			final RawAudioNode rawaudionode_0 = (RawAudioNode) super.data;
			final int int_2 = startPosition << 8;
			final int int_3 = endPosition << 8;
			final int int_4 = rawaudionode_0.audioBuffer.length << 8;
			final int int_5 = int_3 - int_2;
			if (int_5 <= 0)
			{
				field1362 = 0;
			}

			int int_6 = int_0;
			int_1 += int_0;
			if (field1357 < 0)
			{
				if (field1364 <= 0)
				{
					method2266();
					unlink();
					return;
				}

				field1357 = 0;
			}

			if (field1357 >= int_4)
			{
				if (field1364 >= 0)
				{
					method2266();
					unlink();
					return;
				}

				field1357 = int_4 - 1;
			}

			if (field1362 < 0)
			{
				if (field1365)
				{
					if (field1364 < 0)
					{
						int_6 = method2280(ints_0, int_0, int_2, int_1, rawaudionode_0.audioBuffer[startPosition]);
						if (field1357 >= int_2)
						{
							return;
						}

						field1357 = (int_2 + int_2) - 1 - field1357;
						field1364 = -field1364;
					}

					while (true)
					{
						int_6 = method2402(ints_0, int_6, int_3, int_1, rawaudionode_0.audioBuffer[endPosition - 1]);
						if (field1357 < int_3)
						{
							return;
						}

						field1357 = (int_3 + int_3) - 1 - field1357;
						field1364 = -field1364;
						int_6 = method2280(ints_0, int_6, int_2, int_1, rawaudionode_0.audioBuffer[startPosition]);
						if (field1357 >= int_2)
						{
							return;
						}

						field1357 = (int_2 + int_2) - 1 - field1357;
						field1364 = -field1364;
					}
				}
				else if (field1364 < 0)
				{
					while (true)
					{
						int_6 = method2280(ints_0, int_6, int_2, int_1, rawaudionode_0.audioBuffer[endPosition - 1]);
						if (field1357 >= int_2)
						{
							return;
						}

						field1357 = int_3 - 1 - ((int_3 - 1 - field1357) % int_5);
					}
				}
				else
				{
					while (true)
					{
						int_6 = method2402(ints_0, int_6, int_3, int_1, rawaudionode_0.audioBuffer[startPosition]);
						if (field1357 < int_3)
						{
							return;
						}

						field1357 = int_2 + ((field1357 - int_2) % int_5);
					}
				}
			}
			else
			{
				if (field1362 > 0)
				{
					if (field1365)
					{
						label139:
						{
							if (field1364 < 0)
							{
								int_6 = method2280(ints_0, int_0, int_2, int_1,
								        rawaudionode_0.audioBuffer[startPosition]);
								if (field1357 >= int_2)
								{
									return;
								}

								field1357 = (int_2 + int_2) - 1 - field1357;
								field1364 = -field1364;
								if (--field1362 == 0)
								{
									break label139;
								}
							}

							do
							{
								int_6 = method2402(ints_0, int_6, int_3, int_1,
								        rawaudionode_0.audioBuffer[endPosition - 1]);
								if (field1357 < int_3)
								{
									return;
								}

								field1357 = (int_3 + int_3) - 1 - field1357;
								field1364 = -field1364;
								if (--field1362 == 0)
								{
									break;
								}

								int_6 = method2280(ints_0, int_6, int_2, int_1,
								        rawaudionode_0.audioBuffer[startPosition]);
								if (field1357 >= int_2)
								{
									return;
								}

								field1357 = (int_2 + int_2) - 1 - field1357;
								field1364 = -field1364;
							}
							while (--field1362 != 0);
						}
					}
					else
					{
						int int_7;
						if (field1364 < 0)
						{
							while (true)
							{
								int_6 = method2280(ints_0, int_6, int_2, int_1,
								        rawaudionode_0.audioBuffer[endPosition - 1]);
								if (field1357 >= int_2)
								{
									return;
								}

								int_7 = (int_3 - 1 - field1357) / int_5;
								if (int_7 >= field1362)
								{
									field1357 += int_5 * field1362;
									field1362 = 0;
									break;
								}

								field1357 += int_5 * int_7;
								field1362 -= int_7;
							}
						}
						else
						{
							while (true)
							{
								int_6 = method2402(ints_0, int_6, int_3, int_1,
								        rawaudionode_0.audioBuffer[startPosition]);
								if (field1357 < int_3)
								{
									return;
								}

								int_7 = (field1357 - int_2) / int_5;
								if (int_7 >= field1362)
								{
									field1357 -= int_5 * field1362;
									field1362 = 0;
									break;
								}

								field1357 -= int_5 * int_7;
								field1362 -= int_7;
							}
						}
					}
				}

				if (field1364 < 0)
				{
					method2280(ints_0, int_6, 0, int_1, 0);
					if (field1357 < 0)
					{
						field1357 = -1;
						method2266();
						unlink();
					}
				}
				else
				{
					method2402(ints_0, int_6, int_4, int_1, 0);
					if (field1357 >= int_4)
					{
						field1357 = int_4;
						method2266();
						unlink();
					}
				}

			}
		}
	}

	public synchronized void method2258(final int int_0)
	{
		field1362 = int_0;
	}

	@Override
	public synchronized void vmethod4386(int int_0)
	{
		if (field1355 > 0)
		{
			if (int_0 >= field1355)
			{
				if (field1356 == Integer.MIN_VALUE)
				{
					field1356 = 0;
					field1361 = 0;
					field1360 = 0;
					field1359 = 0;
					unlink();
					int_0 = field1355;
				}

				field1355 = 0;
				method2324();
			}
			else
			{
				field1359 += field1358 * int_0;
				field1360 += field1368 * int_0;
				field1361 += field1369 * int_0;
				field1355 -= int_0;
			}
		}

		final RawAudioNode rawaudionode_0 = (RawAudioNode) super.data;
		final int int_1 = startPosition << 8;
		final int int_2 = endPosition << 8;
		final int int_3 = rawaudionode_0.audioBuffer.length << 8;
		final int int_4 = int_2 - int_1;
		if (int_4 <= 0)
		{
			field1362 = 0;
		}

		if (field1357 < 0)
		{
			if (field1364 <= 0)
			{
				method2266();
				unlink();
				return;
			}

			field1357 = 0;
		}

		if (field1357 >= int_3)
		{
			if (field1364 >= 0)
			{
				method2266();
				unlink();
				return;
			}

			field1357 = int_3 - 1;
		}

		field1357 += field1364 * int_0;
		if (field1362 < 0)
		{
			if (!field1365)
			{
				if (field1364 < 0)
				{
					if (field1357 >= int_1)
					{
						return;
					}

					field1357 = int_2 - 1 - ((int_2 - 1 - field1357) % int_4);
				}
				else
				{
					if (field1357 < int_2)
					{
						return;
					}

					field1357 = int_1 + ((field1357 - int_1) % int_4);
				}

			}
			else
			{
				if (field1364 < 0)
				{
					if (field1357 >= int_1)
					{
						return;
					}

					field1357 = (int_1 + int_1) - 1 - field1357;
					field1364 = -field1364;
				}

				while (field1357 >= int_2)
				{
					field1357 = (int_2 + int_2) - 1 - field1357;
					field1364 = -field1364;
					if (field1357 >= int_1)
					{
						return;
					}

					field1357 = (int_1 + int_1) - 1 - field1357;
					field1364 = -field1364;
				}

			}
		}
		else
		{
			if (field1362 > 0)
			{
				if (field1365)
				{
					label123:
					{
						if (field1364 < 0)
						{
							if (field1357 >= int_1)
							{
								return;
							}

							field1357 = (int_1 + int_1) - 1 - field1357;
							field1364 = -field1364;
							if (--field1362 == 0)
							{
								break label123;
							}
						}

						do
						{
							if (field1357 < int_2)
							{
								return;
							}

							field1357 = (int_2 + int_2) - 1 - field1357;
							field1364 = -field1364;
							if (--field1362 == 0)
							{
								break;
							}

							if (field1357 >= int_1)
							{
								return;
							}

							field1357 = (int_1 + int_1) - 1 - field1357;
							field1364 = -field1364;
						}
						while (--field1362 != 0);
					}
				}
				else
				{
					label155:
					{
						int int_5;
						if (field1364 < 0)
						{
							if (field1357 >= int_1)
							{
								return;
							}

							int_5 = (int_2 - 1 - field1357) / int_4;
							if (int_5 >= field1362)
							{
								field1357 += int_4 * field1362;
								field1362 = 0;
								break label155;
							}

							field1357 += int_4 * int_5;
							field1362 -= int_5;
						}
						else
						{
							if (field1357 < int_2)
							{
								return;
							}

							int_5 = (field1357 - int_1) / int_4;
							if (int_5 >= field1362)
							{
								field1357 -= int_4 * field1362;
								field1362 = 0;
								break label155;
							}

							field1357 -= int_4 * int_5;
							field1362 -= int_5;
						}

						return;
					}
				}
			}

			if (field1364 < 0)
			{
				if (field1357 < 0)
				{
					field1357 = -1;
					method2266();
					unlink();
				}
			}
			else if (field1357 >= int_3)
			{
				field1357 = int_3;
				method2266();
				unlink();
			}

		}
	}

	public synchronized void method2267(final int int_0)
	{
		method2261(int_0 << 6, method2263());
	}

	synchronized void method2260(final int int_0)
	{
		method2261(int_0, method2263());
	}

	synchronized void method2261(final int int_0, final int int_1)
	{
		field1356 = int_0;
		field1366 = int_1;
		field1355 = 0;
		method2324();
	}

	public synchronized int method2262()
	{
		return field1356 == Integer.MIN_VALUE ? 0 : field1356;
	}

	public synchronized int method2263()
	{
		return field1366 < 0 ? -1 : field1366;
	}

	public synchronized void method2264(int int_0)
	{
		final int int_1 = ((RawAudioNode) super.data).audioBuffer.length << 8;
		if (int_0 < -1)
		{
			int_0 = -1;
		}

		if (int_0 > int_1)
		{
			int_0 = int_1;
		}

		field1357 = int_0;
	}

	public synchronized void method2307()
	{
		field1364 = (field1364 ^ (field1364 >> 31)) + (field1364 >>> 31);
		field1364 = -field1364;
	}

	void method2266()
	{
		if (field1355 != 0)
		{
			if (field1356 == Integer.MIN_VALUE)
			{
				field1356 = 0;
			}

			field1355 = 0;
			method2324();
		}

	}

	public synchronized void method2408(final int int_0, final int int_1)
	{
		method2268(int_0, int_1, method2263());
	}

	public synchronized void method2268(int int_0, final int int_1, final int int_2)
	{
		if (int_0 == 0)
		{
			method2261(int_1, int_2);
		}
		else
		{
			final int int_3 = method2341(int_1, int_2);
			final int int_4 = method2251(int_1, int_2);
			if ((int_3 == field1360) && (int_4 == field1361))
			{
				field1355 = 0;
			}
			else
			{
				int int_5 = int_1 - field1359;
				if ((field1359 - int_1) > int_5)
				{
					int_5 = field1359 - int_1;
				}

				if ((int_3 - field1360) > int_5)
				{
					int_5 = int_3 - field1360;
				}

				if ((field1360 - int_3) > int_5)
				{
					int_5 = field1360 - int_3;
				}

				if ((int_4 - field1361) > int_5)
				{
					int_5 = int_4 - field1361;
				}

				if ((field1361 - int_4) > int_5)
				{
					int_5 = field1361 - int_4;
				}

				if (int_0 > int_5)
				{
					int_0 = int_5;
				}

				field1355 = int_0;
				field1356 = int_1;
				field1366 = int_2;
				field1358 = (int_1 - field1359) / int_0;
				field1368 = (int_3 - field1360) / int_0;
				field1369 = (int_4 - field1361) / int_0;
			}
		}
	}

	public synchronized void method2269(int int_0)
	{
		if (int_0 == 0)
		{
			method2260(0);
			unlink();
		}
		else if ((field1360 == 0) && (field1361 == 0))
		{
			field1355 = 0;
			field1356 = 0;
			field1359 = 0;
			unlink();
		}
		else
		{
			int int_1 = -field1359;
			if (field1359 > int_1)
			{
				int_1 = field1359;
			}

			if (-field1360 > int_1)
			{
				int_1 = -field1360;
			}

			if (field1360 > int_1)
			{
				int_1 = field1360;
			}

			if (-field1361 > int_1)
			{
				int_1 = -field1361;
			}

			if (field1361 > int_1)
			{
				int_1 = field1361;
			}

			if (int_0 > int_1)
			{
				int_0 = int_1;
			}

			field1355 = int_0;
			field1356 = Integer.MIN_VALUE;
			field1358 = -field1359 / int_0;
			field1368 = -field1360 / int_0;
			field1369 = -field1361 / int_0;
		}
	}

	public synchronized void method2270(final int int_0)
	{
		if (field1364 < 0)
		{
			field1364 = -int_0;
		}
		else
		{
			field1364 = int_0;
		}

	}

	public synchronized int method2351()
	{
		return field1364 < 0 ? -field1364 : field1364;
	}

	public boolean method2272()
	{
		return (field1357 < 0) || (field1357 >= (((RawAudioNode) super.data).audioBuffer.length << 8));
	}

	public boolean method2273()
	{
		return field1355 != 0;
	}

	int method2402(final int[] ints_0, int int_0, final int int_1, final int int_2, final int int_3)
	{
		while (true)
		{
			if (field1355 > 0)
			{
				int int_4 = int_0 + field1355;
				if (int_4 > int_2)
				{
					int_4 = int_2;
				}

				field1355 += int_0;
				if ((field1364 == 256) && ((field1357 & 0xFF) == 0))
				{
					if (AbstractSoundSystem.audioHighMemory)
					{
						int_0 = method2288(0, ((RawAudioNode) super.data).audioBuffer, ints_0, field1357, int_0,
						        field1360, field1361, field1368, field1369, 0, int_4, int_1, this);
					}
					else
					{
						int_0 = method2417(((RawAudioNode) super.data).audioBuffer, ints_0, field1357, int_0, field1359,
						        field1358, 0, int_4, int_1, this);
					}
				}
				else if (AbstractSoundSystem.audioHighMemory)
				{
					int_0 = method2295(0, 0, ((RawAudioNode) super.data).audioBuffer, ints_0, field1357, int_0,
					        field1360, field1361, field1368, field1369, 0, int_4, int_1, this, field1364, int_3);
				}
				else
				{
					int_0 = method2294(0, 0, ((RawAudioNode) super.data).audioBuffer, ints_0, field1357, int_0,
					        field1359, field1358, 0, int_4, int_1, this, field1364, int_3);
				}

				field1355 -= int_0;
				if (field1355 != 0)
				{
					return int_0;
				}

				if (!method2281())
				{
					continue;
				}

				return int_2;
			}

			if ((field1364 == 256) && ((field1357 & 0xFF) == 0))
			{
				if (AbstractSoundSystem.audioHighMemory)
				{
					return method2283(0, ((RawAudioNode) super.data).audioBuffer, ints_0, field1357, int_0, field1360,
					        field1361, 0, int_2, int_1, this);
				}

				return method2275(((RawAudioNode) super.data).audioBuffer, ints_0, field1357, int_0, field1359, 0,
				        int_2, int_1, this);
			}

			if (AbstractSoundSystem.audioHighMemory)
			{
				return method2302(0, 0, ((RawAudioNode) super.data).audioBuffer, ints_0, field1357, int_0, field1360,
				        field1361, 0, int_2, int_1, this, field1364, int_3);
			}

			return method2286(0, 0, ((RawAudioNode) super.data).audioBuffer, ints_0, field1357, int_0, field1359, 0,
			        int_2, int_1, this, field1364, int_3);
		}
	}

	int method2280(final int[] ints_0, int int_0, final int int_1, final int int_2, final int int_3)
	{
		while (true)
		{
			if (field1355 > 0)
			{
				int int_4 = int_0 + field1355;
				if (int_4 > int_2)
				{
					int_4 = int_2;
				}

				field1355 += int_0;
				if ((field1364 == -256) && ((field1357 & 0xFF) == 0))
				{
					if (AbstractSoundSystem.audioHighMemory)
					{
						int_0 = method2293(0, ((RawAudioNode) super.data).audioBuffer, ints_0, field1357, int_0,
						        field1360, field1361, field1368, field1369, 0, int_4, int_1, this);
					}
					else
					{
						int_0 = method2328(((RawAudioNode) super.data).audioBuffer, ints_0, field1357, int_0, field1359,
						        field1358, 0, int_4, int_1, this);
					}
				}
				else if (AbstractSoundSystem.audioHighMemory)
				{
					int_0 = method2360(0, 0, ((RawAudioNode) super.data).audioBuffer, ints_0, field1357, int_0,
					        field1360, field1361, field1368, field1369, 0, int_4, int_1, this, field1364, int_3);
				}
				else
				{
					int_0 = method2271(0, 0, ((RawAudioNode) super.data).audioBuffer, ints_0, field1357, int_0,
					        field1359, field1358, 0, int_4, int_1, this, field1364, int_3);
				}

				field1355 -= int_0;
				if (field1355 != 0)
				{
					return int_0;
				}

				if (!method2281())
				{
					continue;
				}

				return int_2;
			}

			if ((field1364 == -256) && ((field1357 & 0xFF) == 0))
			{
				if (AbstractSoundSystem.audioHighMemory)
				{
					return method2274(0, ((RawAudioNode) super.data).audioBuffer, ints_0, field1357, int_0, field1360,
					        field1361, 0, int_2, int_1, this);
				}

				return method2374(((RawAudioNode) super.data).audioBuffer, ints_0, field1357, int_0, field1359, 0,
				        int_2, int_1, this);
			}

			if (AbstractSoundSystem.audioHighMemory)
			{
				return method2289(0, 0, ((RawAudioNode) super.data).audioBuffer, ints_0, field1357, int_0, field1360,
				        field1361, 0, int_2, int_1, this, field1364, int_3);
			}

			return method2362(0, 0, ((RawAudioNode) super.data).audioBuffer, ints_0, field1357, int_0, field1359, 0,
			        int_2, int_1, this, field1364, int_3);
		}
	}

	@Override
	int vmethod2435()
	{
		int int_0 = (field1359 * 3) >> 6;
		int_0 = (int_0 ^ (int_0 >> 31)) + (int_0 >>> 31);
		if (field1362 == 0)
		{
			int_0 -= (int_0 * field1357) / (((RawAudioNode) super.data).audioBuffer.length << 8);
		}
		else if (field1362 >= 0)
		{
			int_0 -= (int_0 * startPosition) / ((RawAudioNode) super.data).audioBuffer.length;
		}

		return int_0 > 255 ? 255 : int_0;
	}

	boolean method2281()
	{
		int int_0 = field1356;
		int int_1;
		int int_2;
		if (int_0 == Integer.MIN_VALUE)
		{
			int_1 = 0;
			int_2 = 0;
			int_0 = 0;
		}
		else
		{
			int_2 = method2341(int_0, field1366);
			int_1 = method2251(int_0, field1366);
		}

		if ((int_0 == field1359) && (int_2 == field1360) && (int_1 == field1361))
		{
			if (field1356 == Integer.MIN_VALUE)
			{
				field1356 = 0;
				field1361 = 0;
				field1360 = 0;
				field1359 = 0;
				unlink();
				return true;
			}
			else
			{
				method2324();
				return false;
			}
		}
		else
		{
			if (field1359 < int_0)
			{
				field1358 = 1;
				field1355 = int_0 - field1359;
			}
			else if (field1359 > int_0)
			{
				field1358 = -1;
				field1355 = field1359 - int_0;
			}
			else
			{
				field1358 = 0;
			}

			if (field1360 < int_2)
			{
				field1368 = 1;
				if ((field1355 == 0) || (field1355 > (int_2 - field1360)))
				{
					field1355 = int_2 - field1360;
				}
			}
			else if (field1360 > int_2)
			{
				field1368 = -1;
				if ((field1355 == 0) || (field1355 > (field1360 - int_2)))
				{
					field1355 = field1360 - int_2;
				}
			}
			else
			{
				field1368 = 0;
			}

			if (field1361 < int_1)
			{
				field1369 = 1;
				if ((field1355 == 0) || (field1355 > (int_1 - field1361)))
				{
					field1355 = int_1 - field1361;
				}
			}
			else if (field1361 > int_1)
			{
				field1369 = -1;
				if ((field1355 == 0) || (field1355 > (field1361 - int_1)))
				{
					field1355 = field1361 - int_1;
				}
			}
			else
			{
				field1369 = 0;
			}

			return false;
		}
	}

	static int method2341(final int int_0, final int int_1)
	{
		return int_1 < 0 ? int_0 : (int) ((int_0 * Math.sqrt((16384 - int_1) * 1.220703125E-4D)) + 0.5D);
	}

	static int method2251(final int int_0, final int int_1)
	{
		return int_1 < 0 ? -int_0 : (int) ((int_0 * Math.sqrt(int_1 * 1.220703125E-4D)) + 0.5D);
	}

	public static class103 method2287(final RawAudioNode rawaudionode_0, final int int_0, final int int_1)
	{
		return (rawaudionode_0.audioBuffer != null) && (rawaudionode_0.audioBuffer.length != 0)
		        ? new class103(rawaudionode_0,
		                (int) ((rawaudionode_0.sampleRate * 256L * int_0) / (AbstractSoundSystem.sampleRate * 100)),
		                int_1 << 6)
		        : null;
	}

	public static class103 method2256(final RawAudioNode rawaudionode_0, final int int_0, final int int_1,
	        final int int_2)
	{
		return (rawaudionode_0.audioBuffer != null) && (rawaudionode_0.audioBuffer.length != 0)
		        ? new class103(rawaudionode_0, int_0, int_1, int_2)
		        : null;
	}

	static int method2275(final byte[] bytes_0, final int[] ints_0, int int_0, int int_1, int int_2, int int_3,
	        final int int_4, int int_5, final class103 class103_0)
	{
		int_0 >>= 8;
		int_5 >>= 8;
		int_2 <<= 2;
		if ((int_3 = (int_1 + int_5) - int_0) > int_4)
		{
			int_3 = int_4;
		}

		int int_6;
		for (int_3 -= 3; int_1 < int_3; ints_0[int_6] += bytes_0[int_0++] * int_2)
		{
			int_6 = int_1++;
			ints_0[int_6] += bytes_0[int_0++] * int_2;
			int_6 = int_1++;
			ints_0[int_6] += bytes_0[int_0++] * int_2;
			int_6 = int_1++;
			ints_0[int_6] += bytes_0[int_0++] * int_2;
			int_6 = int_1++;
		}

		for (int_3 += 3; int_1 < int_3; ints_0[int_6] += bytes_0[int_0++] * int_2)
		{
			int_6 = int_1++;
		}

		class103_0.field1357 = int_0 << 8;
		return int_1;
	}

	static int method2283(final int int_0, final byte[] bytes_0, final int[] ints_0, int int_1, int int_2, int int_3,
	        int int_4, int int_5, final int int_6, int int_7, final class103 class103_0)
	{
		int_1 >>= 8;
		int_7 >>= 8;
		int_3 <<= 2;
		int_4 <<= 2;
		if ((int_5 = (int_2 + int_7) - int_1) > int_6)
		{
			int_5 = int_6;
		}

		int_2 <<= 1;
		int_5 <<= 1;

		int int_8;
		byte byte_0;
		for (int_5 -= 6; int_2 < int_5; ints_0[int_8] += byte_0 * int_4)
		{
			byte_0 = bytes_0[int_1++];
			int_8 = int_2++;
			ints_0[int_8] += byte_0 * int_3;
			int_8 = int_2++;
			ints_0[int_8] += byte_0 * int_4;
			byte_0 = bytes_0[int_1++];
			int_8 = int_2++;
			ints_0[int_8] += byte_0 * int_3;
			int_8 = int_2++;
			ints_0[int_8] += byte_0 * int_4;
			byte_0 = bytes_0[int_1++];
			int_8 = int_2++;
			ints_0[int_8] += byte_0 * int_3;
			int_8 = int_2++;
			ints_0[int_8] += byte_0 * int_4;
			byte_0 = bytes_0[int_1++];
			int_8 = int_2++;
			ints_0[int_8] += byte_0 * int_3;
			int_8 = int_2++;
		}

		for (int_5 += 6; int_2 < int_5; ints_0[int_8] += byte_0 * int_4)
		{
			byte_0 = bytes_0[int_1++];
			int_8 = int_2++;
			ints_0[int_8] += byte_0 * int_3;
			int_8 = int_2++;
		}

		class103_0.field1357 = int_1 << 8;
		return int_2 >> 1;
	}

	static int method2374(final byte[] bytes_0, final int[] ints_0, int int_0, int int_1, int int_2, int int_3,
	        final int int_4, int int_5, final class103 class103_0)
	{
		int_0 >>= 8;
		int_5 >>= 8;
		int_2 <<= 2;
		if ((int_3 = (int_1 + int_0) - (int_5 - 1)) > int_4)
		{
			int_3 = int_4;
		}

		int int_6;
		for (int_3 -= 3; int_1 < int_3; ints_0[int_6] += bytes_0[int_0--] * int_2)
		{
			int_6 = int_1++;
			ints_0[int_6] += bytes_0[int_0--] * int_2;
			int_6 = int_1++;
			ints_0[int_6] += bytes_0[int_0--] * int_2;
			int_6 = int_1++;
			ints_0[int_6] += bytes_0[int_0--] * int_2;
			int_6 = int_1++;
		}

		for (int_3 += 3; int_1 < int_3; ints_0[int_6] += bytes_0[int_0--] * int_2)
		{
			int_6 = int_1++;
		}

		class103_0.field1357 = int_0 << 8;
		return int_1;
	}

	static int method2274(final int int_0, final byte[] bytes_0, final int[] ints_0, int int_1, int int_2, int int_3,
	        int int_4, int int_5, final int int_6, int int_7, final class103 class103_0)
	{
		int_1 >>= 8;
		int_7 >>= 8;
		int_3 <<= 2;
		int_4 <<= 2;
		if ((int_5 = (int_1 + int_2) - (int_7 - 1)) > int_6)
		{
			int_5 = int_6;
		}

		int_2 <<= 1;
		int_5 <<= 1;

		int int_8;
		byte byte_0;
		for (int_5 -= 6; int_2 < int_5; ints_0[int_8] += byte_0 * int_4)
		{
			byte_0 = bytes_0[int_1--];
			int_8 = int_2++;
			ints_0[int_8] += byte_0 * int_3;
			int_8 = int_2++;
			ints_0[int_8] += byte_0 * int_4;
			byte_0 = bytes_0[int_1--];
			int_8 = int_2++;
			ints_0[int_8] += byte_0 * int_3;
			int_8 = int_2++;
			ints_0[int_8] += byte_0 * int_4;
			byte_0 = bytes_0[int_1--];
			int_8 = int_2++;
			ints_0[int_8] += byte_0 * int_3;
			int_8 = int_2++;
			ints_0[int_8] += byte_0 * int_4;
			byte_0 = bytes_0[int_1--];
			int_8 = int_2++;
			ints_0[int_8] += byte_0 * int_3;
			int_8 = int_2++;
		}

		for (int_5 += 6; int_2 < int_5; ints_0[int_8] += byte_0 * int_4)
		{
			byte_0 = bytes_0[int_1--];
			int_8 = int_2++;
			ints_0[int_8] += byte_0 * int_3;
			int_8 = int_2++;
		}

		class103_0.field1357 = int_1 << 8;
		return int_2 >> 1;
	}

	static int method2286(final int int_0, int int_1, final byte[] bytes_0, final int[] ints_0, int int_2, int int_3,
	        final int int_4, int int_5, final int int_6, final int int_7, final class103 class103_0, final int int_8,
	        final int int_9)
	{
		if ((int_8 == 0) || ((int_5 = int_3 + (((int_8 + (int_7 - int_2)) - 257) / int_8)) > int_6))
		{
			int_5 = int_6;
		}

		byte byte_0;
		int int_10;
		while (int_3 < int_5)
		{
			int_1 = int_2 >> 8;
			byte_0 = bytes_0[int_1];
			int_10 = int_3++;
			ints_0[int_10] += (((byte_0 << 8) + ((bytes_0[int_1 + 1] - byte_0) * (int_2 & 0xFF))) * int_4) >> 6;
			int_2 += int_8;
		}

		if ((int_8 == 0) || ((int_5 = int_3 + (((int_8 + (int_7 - int_2)) - 1) / int_8)) > int_6))
		{
			int_5 = int_6;
		}

		for (int_1 = int_9; int_3 < int_5; int_2 += int_8)
		{
			byte_0 = bytes_0[int_2 >> 8];
			int_10 = int_3++;
			ints_0[int_10] += (((byte_0 << 8) + ((int_1 - byte_0) * (int_2 & 0xFF))) * int_4) >> 6;
		}

		class103_0.field1357 = int_2;
		return int_3;
	}

	static int method2302(int int_0, int int_1, final byte[] bytes_0, final int[] ints_0, int int_2, int int_3,
	        final int int_4, final int int_5, int int_6, final int int_7, final int int_8, final class103 class103_0,
	        final int int_9, final int int_10)
	{
		if ((int_9 == 0) || ((int_6 = int_3 + ((((int_8 - int_2) + int_9) - 257) / int_9)) > int_7))
		{
			int_6 = int_7;
		}

		int_3 <<= 1;

		byte byte_0;
		int int_11;
		for (int_6 <<= 1; int_3 < int_6; int_2 += int_9)
		{
			int_1 = int_2 >> 8;
			byte_0 = bytes_0[int_1];
			int_0 = (byte_0 << 8) + ((int_2 & 0xFF) * (bytes_0[int_1 + 1] - byte_0));
			int_11 = int_3++;
			ints_0[int_11] += (int_0 * int_4) >> 6;
			int_11 = int_3++;
			ints_0[int_11] += (int_0 * int_5) >> 6;
		}

		if ((int_9 == 0) || ((int_6 = (int_3 >> 1) + ((((int_8 - int_2) + int_9) - 1) / int_9)) > int_7))
		{
			int_6 = int_7;
		}

		int_6 <<= 1;

		for (int_1 = int_10; int_3 < int_6; int_2 += int_9)
		{
			byte_0 = bytes_0[int_2 >> 8];
			int_0 = (byte_0 << 8) + ((int_1 - byte_0) * (int_2 & 0xFF));
			int_11 = int_3++;
			ints_0[int_11] += (int_0 * int_4) >> 6;
			int_11 = int_3++;
			ints_0[int_11] += (int_0 * int_5) >> 6;
		}

		class103_0.field1357 = int_2;
		return int_3 >> 1;
	}

	static int method2362(int int_0, int int_1, final byte[] bytes_0, final int[] ints_0, int int_2, int int_3,
	        final int int_4, int int_5, final int int_6, final int int_7, final class103 class103_0, final int int_8,
	        final int int_9)
	{
		if ((int_8 == 0) || ((int_5 = int_3 + ((int_8 + ((int_7 + 256) - int_2)) / int_8)) > int_6))
		{
			int_5 = int_6;
		}

		int int_10;
		while (int_3 < int_5)
		{
			int_1 = int_2 >> 8;
			final byte byte_0 = bytes_0[int_1 - 1];
			int_10 = int_3++;
			ints_0[int_10] += (((byte_0 << 8) + ((bytes_0[int_1] - byte_0) * (int_2 & 0xFF))) * int_4) >> 6;
			int_2 += int_8;
		}

		if ((int_8 == 0) || ((int_5 = int_3 + ((int_8 + (int_7 - int_2)) / int_8)) > int_6))
		{
			int_5 = int_6;
		}

		int_0 = int_9;

		for (int_1 = int_8; int_3 < int_5; int_2 += int_1)
		{
			int_10 = int_3++;
			ints_0[int_10] += (((int_0 << 8) + ((bytes_0[int_2 >> 8] - int_0) * (int_2 & 0xFF))) * int_4) >> 6;
		}

		class103_0.field1357 = int_2;
		return int_3;
	}

	static int method2289(int int_0, int int_1, final byte[] bytes_0, final int[] ints_0, int int_2, int int_3,
	        final int int_4, final int int_5, int int_6, final int int_7, final int int_8, final class103 class103_0,
	        final int int_9, final int int_10)
	{
		if ((int_9 == 0) || ((int_6 = int_3 + ((((int_8 + 256) - int_2) + int_9) / int_9)) > int_7))
		{
			int_6 = int_7;
		}

		int_3 <<= 1;

		int int_11;
		for (int_6 <<= 1; int_3 < int_6; int_2 += int_9)
		{
			int_1 = int_2 >> 8;
			final byte byte_0 = bytes_0[int_1 - 1];
			int_0 = ((bytes_0[int_1] - byte_0) * (int_2 & 0xFF)) + (byte_0 << 8);
			int_11 = int_3++;
			ints_0[int_11] += (int_0 * int_4) >> 6;
			int_11 = int_3++;
			ints_0[int_11] += (int_0 * int_5) >> 6;
		}

		if ((int_9 == 0) || ((int_6 = (int_3 >> 1) + (((int_8 - int_2) + int_9) / int_9)) > int_7))
		{
			int_6 = int_7;
		}

		int_6 <<= 1;

		for (int_1 = int_10; int_3 < int_6; int_2 += int_9)
		{
			int_0 = (int_1 << 8) + ((int_2 & 0xFF) * (bytes_0[int_2 >> 8] - int_1));
			int_11 = int_3++;
			ints_0[int_11] += (int_0 * int_4) >> 6;
			int_11 = int_3++;
			ints_0[int_11] += (int_0 * int_5) >> 6;
		}

		class103_0.field1357 = int_2;
		return int_3 >> 1;
	}

	static int method2417(final byte[] bytes_0, final int[] ints_0, int int_0, int int_1, int int_2, int int_3,
	        int int_4, final int int_5, int int_6, final class103 class103_0)
	{
		int_0 >>= 8;
		int_6 >>= 8;
		int_2 <<= 2;
		int_3 <<= 2;
		if ((int_4 = (int_1 + int_6) - int_0) > int_5)
		{
			int_4 = int_5;
		}

		class103_0.field1360 += class103_0.field1368 * (int_4 - int_1);
		class103_0.field1361 += class103_0.field1369 * (int_4 - int_1);

		int int_7;
		for (int_4 -= 3; int_1 < int_4; int_2 += int_3)
		{
			int_7 = int_1++;
			ints_0[int_7] += bytes_0[int_0++] * int_2;
			int_2 += int_3;
			int_7 = int_1++;
			ints_0[int_7] += bytes_0[int_0++] * int_2;
			int_2 += int_3;
			int_7 = int_1++;
			ints_0[int_7] += bytes_0[int_0++] * int_2;
			int_2 += int_3;
			int_7 = int_1++;
			ints_0[int_7] += bytes_0[int_0++] * int_2;
		}

		for (int_4 += 3; int_1 < int_4; int_2 += int_3)
		{
			int_7 = int_1++;
			ints_0[int_7] += bytes_0[int_0++] * int_2;
		}

		class103_0.field1359 = int_2 >> 2;
		class103_0.field1357 = int_0 << 8;
		return int_1;
	}

	static int method2288(final int int_0, final byte[] bytes_0, final int[] ints_0, int int_1, int int_2, int int_3,
	        int int_4, int int_5, int int_6, int int_7, final int int_8, int int_9, final class103 class103_0)
	{
		int_1 >>= 8;
		int_9 >>= 8;
		int_3 <<= 2;
		int_4 <<= 2;
		int_5 <<= 2;
		int_6 <<= 2;
		if ((int_7 = (int_9 + int_2) - int_1) > int_8)
		{
			int_7 = int_8;
		}

		class103_0.field1359 += class103_0.field1358 * (int_7 - int_2);
		int_2 <<= 1;
		int_7 <<= 1;

		byte byte_0;
		int int_10;
		for (int_7 -= 6; int_2 < int_7; int_4 += int_6)
		{
			byte_0 = bytes_0[int_1++];
			int_10 = int_2++;
			ints_0[int_10] += byte_0 * int_3;
			int_3 += int_5;
			int_10 = int_2++;
			ints_0[int_10] += byte_0 * int_4;
			int_4 += int_6;
			byte_0 = bytes_0[int_1++];
			int_10 = int_2++;
			ints_0[int_10] += byte_0 * int_3;
			int_3 += int_5;
			int_10 = int_2++;
			ints_0[int_10] += byte_0 * int_4;
			int_4 += int_6;
			byte_0 = bytes_0[int_1++];
			int_10 = int_2++;
			ints_0[int_10] += byte_0 * int_3;
			int_3 += int_5;
			int_10 = int_2++;
			ints_0[int_10] += byte_0 * int_4;
			int_4 += int_6;
			byte_0 = bytes_0[int_1++];
			int_10 = int_2++;
			ints_0[int_10] += byte_0 * int_3;
			int_3 += int_5;
			int_10 = int_2++;
			ints_0[int_10] += byte_0 * int_4;
		}

		for (int_7 += 6; int_2 < int_7; int_4 += int_6)
		{
			byte_0 = bytes_0[int_1++];
			int_10 = int_2++;
			ints_0[int_10] += byte_0 * int_3;
			int_3 += int_5;
			int_10 = int_2++;
			ints_0[int_10] += byte_0 * int_4;
		}

		class103_0.field1360 = int_3 >> 2;
		class103_0.field1361 = int_4 >> 2;
		class103_0.field1357 = int_1 << 8;
		return int_2 >> 1;
	}

	static int method2328(final byte[] bytes_0, final int[] ints_0, int int_0, int int_1, int int_2, int int_3,
	        int int_4, final int int_5, int int_6, final class103 class103_0)
	{
		int_0 >>= 8;
		int_6 >>= 8;
		int_2 <<= 2;
		int_3 <<= 2;
		if ((int_4 = (int_1 + int_0) - (int_6 - 1)) > int_5)
		{
			int_4 = int_5;
		}

		class103_0.field1360 += class103_0.field1368 * (int_4 - int_1);
		class103_0.field1361 += class103_0.field1369 * (int_4 - int_1);

		int int_7;
		for (int_4 -= 3; int_1 < int_4; int_2 += int_3)
		{
			int_7 = int_1++;
			ints_0[int_7] += bytes_0[int_0--] * int_2;
			int_2 += int_3;
			int_7 = int_1++;
			ints_0[int_7] += bytes_0[int_0--] * int_2;
			int_2 += int_3;
			int_7 = int_1++;
			ints_0[int_7] += bytes_0[int_0--] * int_2;
			int_2 += int_3;
			int_7 = int_1++;
			ints_0[int_7] += bytes_0[int_0--] * int_2;
		}

		for (int_4 += 3; int_1 < int_4; int_2 += int_3)
		{
			int_7 = int_1++;
			ints_0[int_7] += bytes_0[int_0--] * int_2;
		}

		class103_0.field1359 = int_2 >> 2;
		class103_0.field1357 = int_0 << 8;
		return int_1;
	}

	static int method2293(final int int_0, final byte[] bytes_0, final int[] ints_0, int int_1, int int_2, int int_3,
	        int int_4, int int_5, int int_6, int int_7, final int int_8, int int_9, final class103 class103_0)
	{
		int_1 >>= 8;
		int_9 >>= 8;
		int_3 <<= 2;
		int_4 <<= 2;
		int_5 <<= 2;
		int_6 <<= 2;
		if ((int_7 = (int_1 + int_2) - (int_9 - 1)) > int_8)
		{
			int_7 = int_8;
		}

		class103_0.field1359 += class103_0.field1358 * (int_7 - int_2);
		int_2 <<= 1;
		int_7 <<= 1;

		byte byte_0;
		int int_10;
		for (int_7 -= 6; int_2 < int_7; int_4 += int_6)
		{
			byte_0 = bytes_0[int_1--];
			int_10 = int_2++;
			ints_0[int_10] += byte_0 * int_3;
			int_3 += int_5;
			int_10 = int_2++;
			ints_0[int_10] += byte_0 * int_4;
			int_4 += int_6;
			byte_0 = bytes_0[int_1--];
			int_10 = int_2++;
			ints_0[int_10] += byte_0 * int_3;
			int_3 += int_5;
			int_10 = int_2++;
			ints_0[int_10] += byte_0 * int_4;
			int_4 += int_6;
			byte_0 = bytes_0[int_1--];
			int_10 = int_2++;
			ints_0[int_10] += byte_0 * int_3;
			int_3 += int_5;
			int_10 = int_2++;
			ints_0[int_10] += byte_0 * int_4;
			int_4 += int_6;
			byte_0 = bytes_0[int_1--];
			int_10 = int_2++;
			ints_0[int_10] += byte_0 * int_3;
			int_3 += int_5;
			int_10 = int_2++;
			ints_0[int_10] += byte_0 * int_4;
		}

		for (int_7 += 6; int_2 < int_7; int_4 += int_6)
		{
			byte_0 = bytes_0[int_1--];
			int_10 = int_2++;
			ints_0[int_10] += byte_0 * int_3;
			int_3 += int_5;
			int_10 = int_2++;
			ints_0[int_10] += byte_0 * int_4;
		}

		class103_0.field1360 = int_3 >> 2;
		class103_0.field1361 = int_4 >> 2;
		class103_0.field1357 = int_1 << 8;
		return int_2 >> 1;
	}

	static int method2294(final int int_0, int int_1, final byte[] bytes_0, final int[] ints_0, int int_2, int int_3,
	        int int_4, final int int_5, int int_6, final int int_7, final int int_8, final class103 class103_0,
	        final int int_9, final int int_10)
	{
		class103_0.field1360 -= class103_0.field1368 * int_3;
		class103_0.field1361 -= class103_0.field1369 * int_3;
		if ((int_9 == 0) || ((int_6 = int_3 + ((((int_8 - int_2) + int_9) - 257) / int_9)) > int_7))
		{
			int_6 = int_7;
		}

		byte byte_0;
		int int_11;
		while (int_3 < int_6)
		{
			int_1 = int_2 >> 8;
			byte_0 = bytes_0[int_1];
			int_11 = int_3++;
			ints_0[int_11] += (((byte_0 << 8) + ((bytes_0[int_1 + 1] - byte_0) * (int_2 & 0xFF))) * int_4) >> 6;
			int_4 += int_5;
			int_2 += int_9;
		}

		if ((int_9 == 0) || ((int_6 = int_3 + ((((int_8 - int_2) + int_9) - 1) / int_9)) > int_7))
		{
			int_6 = int_7;
		}

		for (int_1 = int_10; int_3 < int_6; int_2 += int_9)
		{
			byte_0 = bytes_0[int_2 >> 8];
			int_11 = int_3++;
			ints_0[int_11] += (((byte_0 << 8) + ((int_1 - byte_0) * (int_2 & 0xFF))) * int_4) >> 6;
			int_4 += int_5;
		}

		class103_0.field1360 += class103_0.field1368 * int_3;
		class103_0.field1361 += class103_0.field1369 * int_3;
		class103_0.field1359 = int_4;
		class103_0.field1357 = int_2;
		return int_3;
	}

	static int method2295(int int_0, int int_1, final byte[] bytes_0, final int[] ints_0, int int_2, int int_3,
	        int int_4, int int_5, final int int_6, final int int_7, int int_8, final int int_9, final int int_10,
	        final class103 class103_0, final int int_11, final int int_12)
	{
		class103_0.field1359 -= int_3 * class103_0.field1358;
		if ((int_11 == 0) || ((int_8 = int_3 + ((((int_10 - int_2) + int_11) - 257) / int_11)) > int_9))
		{
			int_8 = int_9;
		}

		int_3 <<= 1;

		byte byte_0;
		int int_13;
		for (int_8 <<= 1; int_3 < int_8; int_2 += int_11)
		{
			int_1 = int_2 >> 8;
			byte_0 = bytes_0[int_1];
			int_0 = (byte_0 << 8) + ((int_2 & 0xFF) * (bytes_0[int_1 + 1] - byte_0));
			int_13 = int_3++;
			ints_0[int_13] += (int_0 * int_4) >> 6;
			int_4 += int_6;
			int_13 = int_3++;
			ints_0[int_13] += (int_0 * int_5) >> 6;
			int_5 += int_7;
		}

		if ((int_11 == 0) || ((int_8 = (int_3 >> 1) + ((((int_10 - int_2) + int_11) - 1) / int_11)) > int_9))
		{
			int_8 = int_9;
		}

		int_8 <<= 1;

		for (int_1 = int_12; int_3 < int_8; int_2 += int_11)
		{
			byte_0 = bytes_0[int_2 >> 8];
			int_0 = (byte_0 << 8) + ((int_1 - byte_0) * (int_2 & 0xFF));
			int_13 = int_3++;
			ints_0[int_13] += (int_0 * int_4) >> 6;
			int_4 += int_6;
			int_13 = int_3++;
			ints_0[int_13] += (int_0 * int_5) >> 6;
			int_5 += int_7;
		}

		int_3 >>= 1;
		class103_0.field1359 += class103_0.field1358 * int_3;
		class103_0.field1360 = int_4;
		class103_0.field1361 = int_5;
		class103_0.field1357 = int_2;
		return int_3;
	}

	static int method2271(int int_0, int int_1, final byte[] bytes_0, final int[] ints_0, int int_2, int int_3,
	        int int_4, final int int_5, int int_6, final int int_7, final int int_8, final class103 class103_0,
	        final int int_9, final int int_10)
	{
		class103_0.field1360 -= class103_0.field1368 * int_3;
		class103_0.field1361 -= class103_0.field1369 * int_3;
		if ((int_9 == 0) || ((int_6 = int_3 + ((((int_8 + 256) - int_2) + int_9) / int_9)) > int_7))
		{
			int_6 = int_7;
		}

		int int_11;
		while (int_3 < int_6)
		{
			int_1 = int_2 >> 8;
			final byte byte_0 = bytes_0[int_1 - 1];
			int_11 = int_3++;
			ints_0[int_11] += (((byte_0 << 8) + ((bytes_0[int_1] - byte_0) * (int_2 & 0xFF))) * int_4) >> 6;
			int_4 += int_5;
			int_2 += int_9;
		}

		if ((int_9 == 0) || ((int_6 = int_3 + (((int_8 - int_2) + int_9) / int_9)) > int_7))
		{
			int_6 = int_7;
		}

		int_0 = int_10;

		for (int_1 = int_9; int_3 < int_6; int_2 += int_1)
		{
			int_11 = int_3++;
			ints_0[int_11] += (((int_0 << 8) + ((bytes_0[int_2 >> 8] - int_0) * (int_2 & 0xFF))) * int_4) >> 6;
			int_4 += int_5;
		}

		class103_0.field1360 += class103_0.field1368 * int_3;
		class103_0.field1361 += class103_0.field1369 * int_3;
		class103_0.field1359 = int_4;
		class103_0.field1357 = int_2;
		return int_3;
	}

	static int method2360(int int_0, int int_1, final byte[] bytes_0, final int[] ints_0, int int_2, int int_3,
	        int int_4, int int_5, final int int_6, final int int_7, int int_8, final int int_9, final int int_10,
	        final class103 class103_0, final int int_11, final int int_12)
	{
		class103_0.field1359 -= int_3 * class103_0.field1358;
		if ((int_11 == 0) || ((int_8 = int_3 + ((((int_10 + 256) - int_2) + int_11) / int_11)) > int_9))
		{
			int_8 = int_9;
		}

		int_3 <<= 1;

		int int_13;
		for (int_8 <<= 1; int_3 < int_8; int_2 += int_11)
		{
			int_1 = int_2 >> 8;
			final byte byte_0 = bytes_0[int_1 - 1];
			int_0 = ((bytes_0[int_1] - byte_0) * (int_2 & 0xFF)) + (byte_0 << 8);
			int_13 = int_3++;
			ints_0[int_13] += (int_0 * int_4) >> 6;
			int_4 += int_6;
			int_13 = int_3++;
			ints_0[int_13] += (int_0 * int_5) >> 6;
			int_5 += int_7;
		}

		if ((int_11 == 0) || ((int_8 = (int_3 >> 1) + (((int_10 - int_2) + int_11) / int_11)) > int_9))
		{
			int_8 = int_9;
		}

		int_8 <<= 1;

		for (int_1 = int_12; int_3 < int_8; int_2 += int_11)
		{
			int_0 = (int_1 << 8) + ((int_2 & 0xFF) * (bytes_0[int_2 >> 8] - int_1));
			int_13 = int_3++;
			ints_0[int_13] += (int_0 * int_4) >> 6;
			int_4 += int_6;
			int_13 = int_3++;
			ints_0[int_13] += (int_0 * int_5) >> 6;
			int_5 += int_7;
		}

		int_3 >>= 1;
		class103_0.field1359 += class103_0.field1358 * int_3;
		class103_0.field1360 = int_4;
		class103_0.field1361 = int_5;
		class103_0.field1357 = int_2;
		return int_3;
	}

}
