public class Friend extends ChatPlayer
{

	boolean field3648;
	boolean field3650;

	int method5452(final Friend friend_1)
	{
		return (super.world == Game.world) && (Game.world != friend_1.world) ? -1
		        : ((Game.world == friend_1.world) && (super.world != Game.world) ? 1
		                : ((super.world != 0) && (friend_1.world == 0) ? -1
		                        : ((friend_1.world != 0) && (super.world == 0) ? 1
		                                : (field3648 && !friend_1.field3648 ? -1
		                                        : (!field3648 && friend_1.field3648 ? 1
		                                                : (field3650 && !friend_1.field3650 ? -1
		                                                        : (!field3650 && friend_1.field3650 ? 1
		                                                                : (super.world != 0
		                                                                        ? super.field3627 - friend_1.field3627
		                                                                        : friend_1.field3627
		                                                                                - super.field3627))))))));
	}

	@Override
	public int vmethod5453(final Nameable nameable_0)
	{
		return method5452((Friend) nameable_0);
	}

	@Override
	public int compareTo(final Object object_0)
	{
		return method5452((Friend) object_0);
	}

}
