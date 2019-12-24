import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public final class MouseWheelHandler implements MouseWheel, MouseWheelListener
{

	int rotation;

	MouseWheelHandler()
	{
		rotation = 0;
	}

	void addTo(final Component component_0)
	{
		component_0.addMouseWheelListener(this);
	}

	void removeFrom(final Component component_0)
	{
		component_0.removeMouseWheelListener(this);
	}

	@Override
	public synchronized int useRotation()
	{
		final int int_0 = rotation;
		rotation = 0;
		return int_0;
	}

	@Override
	public synchronized void mouseWheelMoved(final MouseWheelEvent mousewheelevent_0)
	{
		rotation += mousewheelevent_0.getWheelRotation();
	}

}
