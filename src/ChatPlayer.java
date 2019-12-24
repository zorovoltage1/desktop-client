public class ChatPlayer extends Nameable
{

	public int world;
	public int field3627;
	public int rank;

	ChatPlayer()
	{
		world = -1;
	}

	void method5412(final int int_0, final int int_1)
	{
		world = int_0;
		field3627 = int_1;
	}

	public int method5414()
	{
		return world;
	}

	public boolean method5415()
	{
		return world > 0;
	}

}
