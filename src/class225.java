public class class225 {

    static int[] varpsMasks;
    public static int[] serverVarps;
    public static int[] clientVarps;
    static int[] indexedSpriteOffsetYs;
    static Task field2556;

    static {
        varpsMasks = new int[32];
        int int_0 = 2;

        for (int int_1 = 0; int_1 < 32; int_1++) {
            varpsMasks[int_1] = int_0 - 1;
            int_0 += int_0;
        }

        serverVarps = new int[4000];
        clientVarps = new int[4000];
    }

}
