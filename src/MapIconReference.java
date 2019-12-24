import java.io.IOException;

public class MapIconReference
{

	static class88 field310;
	static JagexLoginType loginType;
	static IndexData indexCache15;
	static SpritePixels[] mapDots;
	public int areaId;
	public Coordinates field311;
	public Coordinates field308;

	public MapIconReference(final int int_0, final Coordinates coordinates_0, final Coordinates coordinates_1)
	{
		areaId = int_0;
		field311 = coordinates_0;
		field308 = coordinates_1;
	}

	public static void method633(final class157 class157_0, final boolean bool_0)
	{
		if (class250.NetCache_socket != null)
		{
			try
			{
				class250.NetCache_socket.vmethod3346();
			}
			catch (final Exception exception_0)
			{
			}

			class250.NetCache_socket = null;
		}

		class250.NetCache_socket = class157_0;
		class222.sendConInfo(bool_0);
		class250.NetCache_responseHeaderBuffer.offset = 0;
		class250.currentRequest = null;
		class301.NetCache_responseArchiveBuffer = null;
		class250.field3210 = 0;

		while (true)
		{
			FileRequest filerequest_0 = (FileRequest) class250.NetCache_pendingPriorityResponses.first();
			if (filerequest_0 == null)
			{
				while (true)
				{
					filerequest_0 = (FileRequest) class250.NetCache_pendingResponses.first();
					if (filerequest_0 == null)
					{
						if (class250.field3213 != 0)
						{
							try
							{
								final Buffer buffer_0 = new Buffer(4);
								buffer_0.putByte(4);
								buffer_0.putByte(class250.field3213);
								buffer_0.putShort(0);
								class250.NetCache_socket.vmethod3347(buffer_0.payload, 0, 4);
							}
							catch (final IOException ioexception_0)
							{
								try
								{
									class250.NetCache_socket.vmethod3346();
								}
								catch (final Exception exception_1)
								{
								}

								++class250.field3215;
								class250.NetCache_socket = null;
							}
						}

						class250.field3197 = 0;
						class250.field3203 = Buffer.safeCurrentTimeMillis();
						return;
					}

					class250.NetCache_pendingWritesQueue.setHead(filerequest_0);
					class250.NetCache_pendingWrites.put(filerequest_0, filerequest_0.hash);
					++class250.NetCache_pendingWritesCount;
					--class250.NetCache_pendingResponsesCount;
				}
			}

			class250.NetCache_pendingPriorityWrites.put(filerequest_0, filerequest_0.hash);
			++class250.NetCache_pendingPriorityWritesCount;
			--class250.NetCache_pendingPriorityResponsesCount;
		}
	}

	static void method632(final Widget widget_0, final int int_0, final int int_1)
	{
		if ((Game.field810 == 0) || (Game.field810 == 3))
		{
			if ((MouseInput.mouseLastButton == 1)
			        || (!InvType.middleMouseMovesCamera && (MouseInput.mouseLastButton == 4)))
			{
				final class224 class224_0 = widget_0.method4517(true);
				if (class224_0 == null)
				{
					return;
				}

				int int_2 = MouseInput.mouseLastPressedX - int_0;
				int int_3 = MouseInput.mouseLastPressedY - int_1;
				if (class224_0.method4423(int_2, int_3))
				{
					int_2 -= class224_0.field2553 / 2;
					int_3 -= class224_0.field2549 / 2;
					final int int_4 = Game.mapAngle & 0x7FF;
					final int int_5 = Graphics3D.SINE[int_4];
					final int int_6 = Graphics3D.COSINE[int_4];
					final int int_7 = ((int_3 * int_5) + (int_2 * int_6)) >> 11;
					final int int_8 = ((int_6 * int_3) - (int_2 * int_5)) >> 11;
					final int int_9 = (int_7 + class138.localPlayer.x) >> 7;
					final int int_10 = (class138.localPlayer.y - int_8) >> 7;
					final PacketNode packetNode = class26.method433(ClientPacket.MINIMAP_WALK, Game.field626.field1218);
					packetNode.packetBuffer.putByte(18);
					packetNode.packetBuffer.putShort(int_9 + PendingSpawn.baseX);
					packetNode.packetBuffer.addByteC(KeyFocusListener.keyPressed[82] ? (KeyFocusListener.keyPressed[81] ? 2 : 1) : 0);
					packetNode.packetBuffer.addLEShort(int_10 + Game.baseY);
					packetNode.packetBuffer.putByte(int_2);
					packetNode.packetBuffer.putByte(int_3);
					packetNode.packetBuffer.putShort(Game.mapAngle);
					packetNode.packetBuffer.putByte(57);
					packetNode.packetBuffer.putByte(0);
					packetNode.packetBuffer.putByte(0);
					packetNode.packetBuffer.putByte(89);
					packetNode.packetBuffer.putShort(class138.localPlayer.x);
					packetNode.packetBuffer.putShort(class138.localPlayer.y);
					packetNode.packetBuffer.putByte(63);
					Game.field626.method1980(packetNode);
					Game.destinationX = int_9;
					Game.destinationY = int_10;
				}
			}

		}
	}

}
