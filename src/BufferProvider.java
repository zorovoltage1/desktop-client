public abstract class BufferProvider
{

	public int[] pixels;
	public int width;
	public int height;

	public abstract void drawFull(int var1, int var2);

	public abstract void draw(int var1, int var2, int var3, int var4);

	public void setRaster()
	{
		Rasterizer2D.setRasterBuffer(pixels, width, height);
	}

}
