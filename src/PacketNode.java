public class PacketNode extends Node
{

	static PacketNode[] packetBufferNodes;
	static int field2258;
	static int[] indexedSpritePalette;
	ClientPacket clientPacket;
	int field2253;
	public PacketBuffer packetBuffer;
	public int field2255;

	static
	{
		packetBufferNodes = new PacketNode[300];
		field2258 = 0;
	}

	public void method3460()
	{
		if (field2258 < packetBufferNodes.length)
		{
			packetBufferNodes[++field2258 - 1] = this;
		}
	}

	public static String method3457(long long_0)
	{
		if ((long_0 > 0L) && (long_0 < 6582952005840035281L))
		{
			if ((long_0 % 37L) == 0L)
			{
				return null;
			}
			else
			{
				int int_0 = 0;

				for (long long_1 = long_0; long_1 != 0L; long_1 /= 37L)
				{
					++int_0;
				}

				StringBuilder stringbuilder_0;
				char char_0;
				for (stringbuilder_0 = new StringBuilder(int_0); long_0 != 0L; stringbuilder_0.append(char_0))
				{
					final long long_2 = long_0;
					long_0 /= 37L;
					char_0 = class303.field3720[(int) (long_2 - (long_0 * 37L))];
					if (char_0 == 95)
					{
						final int int_1 = stringbuilder_0.length() - 1;
						stringbuilder_0.setCharAt(int_1, Character.toUpperCase(stringbuilder_0.charAt(int_1)));
						char_0 = 160;
					}
				}

				stringbuilder_0.reverse();
				stringbuilder_0.setCharAt(0, Character.toUpperCase(stringbuilder_0.charAt(0)));
				return stringbuilder_0.toString();
			}
		}
		else
		{
			return null;
		}
	}

	static void method3458(final SpritePixels spritepixels_0, final int int_0, final int int_1, final int int_2)
	{
		WorldMapRegion.field188.method3998(spritepixels_0, class43.method716(int_0, int_1, int_2),
		        spritepixels_0.pixels.length * 4);
	}

	static void method3456()
	{
		class83.chatLineMap.clear();
		class83.messages.clear();
		class83.field1184.clear();
		class83.field1186 = 0;
	}

}
