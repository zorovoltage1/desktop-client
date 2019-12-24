public class class280 {

    long field3599;
    long field3598;
    public boolean field3597;
    long field3600;
    long field3601;
    long field3602;
    int field3604;
    int field3603;
    int field3605;
    int field3606;

    public class280() {
        field3599 = -1L;
        field3598 = -1L;
        field3597 = false;
        field3600 = 0L;
        field3601 = 0L;
        field3602 = 0L;
        field3604 = 0;
        field3603 = 0;
        field3605 = 0;
        field3606 = 0;
    }

    public void method5244() {
        field3599 = Buffer.safeCurrentTimeMillis();
    }

    public void method5262() {
        if (field3599 != -1L) {
            field3601 = Buffer.safeCurrentTimeMillis() - field3599;
            field3599 = -1L;
        }

    }

    public void method5246(final int int_0) {
        field3598 = Buffer.safeCurrentTimeMillis();
        field3604 = int_0;
    }

    public void method5247() {
        if (field3598 != -1L) {
            field3600 = Buffer.safeCurrentTimeMillis() - field3598;
            field3598 = -1L;
        }

        ++field3605;
        field3597 = true;
    }

    public void method5248() {
        field3597 = false;
        field3603 = 0;
    }

    public void method5249() {
        method5247();
    }

    public void method5245(final Buffer buffer_0) {
        long long_0 = field3601;
        long_0 /= 10L;
        if (long_0 < 0L) {
            long_0 = 0L;
        } else if (long_0 > 65535L) {
            long_0 = 65535L;
        }

        buffer_0.putShort((int) long_0);
        long long_1 = field3600;
        long_1 /= 10L;
        if (long_1 < 0L) {
            long_1 = 0L;
        } else if (long_1 > 65535L) {
            long_1 = 65535L;
        }

        buffer_0.putShort((int) long_1);
        long long_2 = field3602;
        long_2 /= 10L;
        if (long_2 < 0L) {
            long_2 = 0L;
        } else if (long_2 > 65535L) {
            long_2 = 65535L;
        }

        buffer_0.putShort((int) long_2);
        buffer_0.putShort(field3604);
        buffer_0.putShort(field3603);
        buffer_0.putShort(field3605);
        buffer_0.putShort(field3606);
    }

}
