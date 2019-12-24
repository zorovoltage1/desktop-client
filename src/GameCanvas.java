import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;

public final class GameCanvas extends Canvas
{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public static int revision;
	public static Widget[][] widgets;
	Component component;

	GameCanvas(final Component component_0)
	{
		component = component_0;
	}

	@Override
	public void update(final Graphics graphics_0)
	{
		component.update(graphics_0);
	}

	@Override
	public void paint(final Graphics graphics_0)
	{
		component.paint(graphics_0);
	}

}
