import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.DirectColorModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.util.Hashtable;

public final class MainBufferProvider extends BufferProvider
{

	Component field384;
	Image image;

	MainBufferProvider(final int int_0, final int int_1, final Component component_0)
	{
		super.width = int_0;
		super.height = int_1;
		super.pixels = new int[(int_1 * int_0) + 1];
		final DataBufferInt databufferint_0 = new DataBufferInt(super.pixels, super.pixels.length);
		final DirectColorModel directcolormodel_0 = new DirectColorModel(32, 16711680, 65280, 255);
		final WritableRaster writableraster_0 = Raster.createWritableRaster(
		        directcolormodel_0.createCompatibleSampleModel(super.width, super.height), databufferint_0,
                null);
		image = new BufferedImage(directcolormodel_0, writableraster_0, false, new Hashtable());
		replaceComponent(component_0);
		setRaster();
	}

	void replaceComponent(final Component component_0)
	{
		field384 = component_0;
	}

	@Override
	public void drawFull(final int int_0, final int int_1)
	{
		this.draw(field384.getGraphics(), int_0, int_1);
	}

	@Override
	public void draw(final int int_0, final int int_1, final int int_2, final int int_3)
	{
		drawSub(field384.getGraphics(), int_0, int_1, int_2, int_3);
	}

	void draw(final Graphics graphics_0, final int int_0, final int int_1)
	{
		try
		{
			graphics_0.drawImage(image, int_0, int_1, field384);
		}
		catch (final Exception exception_0)
		{
			field384.repaint();
		}

	}

	void drawSub(final Graphics graphics_0, final int int_0, final int int_1, final int int_2, final int int_3)
	{
		try
		{
			final Shape shape_0 = graphics_0.getClip();
			graphics_0.clipRect(int_0, int_1, int_2, int_3);
			graphics_0.drawImage(image, 0, 0, field384);
			graphics_0.setClip(shape_0);
		}
		catch (final Exception exception_0)
		{
			field384.repaint();
		}

	}

}
