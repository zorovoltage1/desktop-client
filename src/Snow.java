import java.util.Random;

public class Snow {

    private int x;
    private int constantX;
    private int y;
    private byte radius;
    private int speed;
    private int fadeTicks;
    private boolean melt;
    private boolean clicked;
    Random random = new Random();

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getRadius() {
        return this.radius;
    }

    public void setFadeTicks() {
        this.fadeTicks = 480;
        this.melt = true;
        this.clicked = true;
    }

    Snow() {
        radius = (byte) (Math.random() * 5.0d);
        if (radius < 5)
            radius += 2;
        constantX = radius + (int) (Math.random() * (740 - radius));
        y = 0 - random.nextInt(1000);
        fadeTicks = 0;
        melt = false;
        clicked = false;
        speed = (int) (Math.random() * 1.5d);
        if (speed == 0)
            speed = 1;
    }

    void draw() {
        this.x = constantX + class78.loginWindowX  - 190;
        if (melt) {
            if (this.fadeTicks++ == 500) {
                melt();
            } else {
                if (this.clicked)
                    this.y += speed;
                Rasterizer2D.drawCircle(this.x, this.y, (int) this.radius, 0xFFFFFF, getAlpha());
            }
            return;
        }
        if (this.y + radius >= 503) {
            melt = true;
            Rasterizer2D.drawCircle(this.x, this.y, (int) this.radius, 0xFFFFFF, getAlpha());
        } else {
            this.y += speed;
            Rasterizer2D.drawCircle(this.x, this.y, (int) this.radius, 0xFFFFFF, 100);
        }
    }

    public void melt() {
        radius = (byte) (Math.random() * 5.0d);
        if (radius < 5)
            radius += 2;
        constantX = radius + (int) (Math.random() * (740 - radius));
        y = 0 - random.nextInt(250);
        fadeTicks = 0;
        x = 0;
        melt = false;
        clicked = false;
        speed = (int) (Math.random() * 1.5d);
        if (speed == 0)
            speed = 1;
    }

    private int getAlpha() {
        if (this.fadeTicks > 490)
            return 5;
        if (this.fadeTicks > 480)
            return 15;
        if (this.fadeTicks > 470)
            return 25;
        if (this.fadeTicks > 450)
            return 35;
        if (this.fadeTicks > 440)
            return 45;
        if (this.fadeTicks > 430)
            return 55;
        if (this.fadeTicks > 420)
            return 65;
        if (this.fadeTicks > 410)
            return 75;
        return 100;
    }
}