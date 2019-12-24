public final class Occluder {

    static Widget[] field1814;
    static Widget field1819;
    int minTileX;
    int maxTIleX;
    int minTileZ;
    int maxTileZ;
    int type;
    int minX;
    int maxX;
    int minZ;
    int maxZ;
    int minY;
    int maxY;
    int testDirection;
    int field1815;
    int field1816;
    int minNormalX;
    int maxNormalX;
    int minNormalY;
    int maxNormalY;

    static boolean method3097(final Widget widget_0) {
        if (widget_0.tableActions == null) {
            return false;
        } else {
            for (int int_0 = 0; int_0 < widget_0.tableActions.length; int_0++) {
                final int int_1 = class137.method3119(widget_0, int_0);
                final int int_2 = widget_0.field2720[int_0];
                if (widget_0.tableActions[int_0] == 2) {
                    if (int_1 >= int_2) {
                        return false;
                    }
                } else if (widget_0.tableActions[int_0] == 3) {
                    if (int_1 <= int_2) {
                        return false;
                    }
                } else if (widget_0.tableActions[int_0] == 4) {
                    if (int_2 == int_1) {
                        return false;
                    }
                } else if (int_1 != int_2) {
                    return false;
                }
            }

            return true;
        }
    }

    static void method3096(final int int_0) {
        Game.field655 = int_0;
    }

}
