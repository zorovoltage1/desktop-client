public abstract class Renderable extends CacheableNode
{

	public int modelHeight;

	protected Renderable()
	{
		modelHeight = 1000;
	}

	protected Model getModel()
	{
		return null;
	}

	void vmethod3063(final int int_0, final int int_1, final int int_2, final int int_3, final int int_4,
	        final int int_5, final int int_6, final int int_7, final long long_0)
	{
		final Model model_0 = getModel();
		if (model_0 != null)
		{
			modelHeight = model_0.modelHeight;
			model_0.vmethod3063(int_0, int_1, int_2, int_3, int_4, int_5, int_6, int_7, long_0);
		}

	}

}
