public final class ISAACCipher {

    int valuesRemaining;
    int[] randResult;
    int[] mm;
    int field2387;
    int field2385;
    int field2382;

    public ISAACCipher(final int[] ints_0) {
        mm = new int[256];
        randResult = new int[256];

        for (int int_0 = 0; int_0 < ints_0.length; int_0++) {
            randResult[int_0] = ints_0[int_0];
        }

        method3861();
    }

    int nextInt() {
        if ((--valuesRemaining + 1) == 0) {
            generateMoreResults();
            valuesRemaining = 255;
        }

        return randResult[valuesRemaining];
    }

    int method3853() {
        if (valuesRemaining == 0) {
            generateMoreResults();
            valuesRemaining = 256;
        }

        return randResult[valuesRemaining - 1];
    }

    void generateMoreResults() {
        field2385 += ++field2382;

        for (int int_0 = 0; int_0 < 256; int_0++) {
            final int int_1 = mm[int_0];
            if ((int_0 & 0x2) == 0) {
                if ((int_0 & 0x1) == 0) {
                    field2387 ^= field2387 << 13;
                } else {
                    field2387 ^= field2387 >>> 6;
                }
            } else if ((int_0 & 0x1) == 0) {
                field2387 ^= field2387 << 2;
            } else {
                field2387 ^= field2387 >>> 16;
            }

            field2387 += mm[(128 + int_0) & 0xFF];
            int int_2;
            mm[int_0] = int_2 = mm[(int_1 & 0x3FC) >> 2] + field2385 + field2387;
            randResult[int_0] = field2385 = mm[((int_2 >> 8) & 0x3FC) >> 2] + int_1;
        }

    }

    void method3861() {
        int int_0 = -1640531527;
        int int_1 = -1640531527;
        int int_2 = -1640531527;
        int int_3 = -1640531527;
        int int_4 = -1640531527;
        int int_5 = -1640531527;
        int int_6 = -1640531527;
        int int_7 = -1640531527;

        int int_8;
        for (int_8 = 0; int_8 < 4; int_8++) {
            int_7 ^= int_6 << 11;
            int_4 += int_7;
            int_6 += int_5;
            int_6 ^= int_5 >>> 2;
            int_3 += int_6;
            int_5 += int_4;
            int_5 ^= int_4 << 8;
            int_2 += int_5;
            int_4 += int_3;
            int_4 ^= int_3 >>> 16;
            int_1 += int_4;
            int_3 += int_2;
            int_3 ^= int_2 << 10;
            int_0 += int_3;
            int_2 += int_1;
            int_2 ^= int_1 >>> 4;
            int_7 += int_2;
            int_1 += int_0;
            int_1 ^= int_0 << 8;
            int_6 += int_1;
            int_0 += int_7;
            int_0 ^= int_7 >>> 9;
            int_5 += int_0;
            int_7 += int_6;
        }

        for (int_8 = 0; int_8 < 256; int_8 += 8) {
            int_7 += randResult[int_8];
            int_6 += randResult[int_8 + 1];
            int_5 += randResult[int_8 + 2];
            int_4 += randResult[int_8 + 3];
            int_3 += randResult[int_8 + 4];
            int_2 += randResult[int_8 + 5];
            int_1 += randResult[int_8 + 6];
            int_0 += randResult[int_8 + 7];
            int_7 ^= int_6 << 11;
            int_4 += int_7;
            int_6 += int_5;
            int_6 ^= int_5 >>> 2;
            int_3 += int_6;
            int_5 += int_4;
            int_5 ^= int_4 << 8;
            int_2 += int_5;
            int_4 += int_3;
            int_4 ^= int_3 >>> 16;
            int_1 += int_4;
            int_3 += int_2;
            int_3 ^= int_2 << 10;
            int_0 += int_3;
            int_2 += int_1;
            int_2 ^= int_1 >>> 4;
            int_7 += int_2;
            int_1 += int_0;
            int_1 ^= int_0 << 8;
            int_6 += int_1;
            int_0 += int_7;
            int_0 ^= int_7 >>> 9;
            int_5 += int_0;
            int_7 += int_6;
            mm[int_8] = int_7;
            mm[int_8 + 1] = int_6;
            mm[int_8 + 2] = int_5;
            mm[int_8 + 3] = int_4;
            mm[int_8 + 4] = int_3;
            mm[int_8 + 5] = int_2;
            mm[int_8 + 6] = int_1;
            mm[int_8 + 7] = int_0;
        }

        for (int_8 = 0; int_8 < 256; int_8 += 8) {
            int_7 += mm[int_8];
            int_6 += mm[int_8 + 1];
            int_5 += mm[int_8 + 2];
            int_4 += mm[int_8 + 3];
            int_3 += mm[int_8 + 4];
            int_2 += mm[int_8 + 5];
            int_1 += mm[int_8 + 6];
            int_0 += mm[int_8 + 7];
            int_7 ^= int_6 << 11;
            int_4 += int_7;
            int_6 += int_5;
            int_6 ^= int_5 >>> 2;
            int_3 += int_6;
            int_5 += int_4;
            int_5 ^= int_4 << 8;
            int_2 += int_5;
            int_4 += int_3;
            int_4 ^= int_3 >>> 16;
            int_1 += int_4;
            int_3 += int_2;
            int_3 ^= int_2 << 10;
            int_0 += int_3;
            int_2 += int_1;
            int_2 ^= int_1 >>> 4;
            int_7 += int_2;
            int_1 += int_0;
            int_1 ^= int_0 << 8;
            int_6 += int_1;
            int_0 += int_7;
            int_0 ^= int_7 >>> 9;
            int_5 += int_0;
            int_7 += int_6;
            mm[int_8] = int_7;
            mm[int_8 + 1] = int_6;
            mm[int_8 + 2] = int_5;
            mm[int_8 + 3] = int_4;
            mm[int_8 + 4] = int_3;
            mm[int_8 + 5] = int_2;
            mm[int_8 + 6] = int_1;
            mm[int_8 + 7] = int_0;
        }

        generateMoreResults();
        valuesRemaining = 256;
    }

    public static int method3865(final int int_0) {
        return (int_0 >> 17) & 0x7;
    }

}
