import java.util.LinkedList;
import java.util.List;

public class Enum extends CacheableNode {

    public static IndexDataBase EnumDefinition_indexCache;
    static NodeCache EnumDefinition_cached;
    static BuildType field3346;
    public char keyType;
    public char valType;
    public String defaultString;
    public int defaultInt;
    public int size;
    public int[] keys;
    public int[] intVals;
    public String[] stringVals;
    public int id;

    static {
        EnumDefinition_cached = new NodeCache(64);
    }

    Enum() {
        defaultString = "null";
        size = 0;
    }

    void decode(final Buffer buffer) {
        while (true) {
            final int code = buffer.readUnsignedByte();
            if (code == 0) {
                postDecode();
                return;
            }

            readNext(buffer, code);
        }
    }

    void postDecode() {
        if(WorldType.isPVP()) {
            //Item's inside the slayer reward shop..
            if(id == 840) {
                List<Integer> items = new LinkedList<Integer>();

                items.add(11866); // Slayer ring(8)
                items.add(12791); // Rune pouch
                items.add(11941); //Looting bag
                items.add(6570); //Fire cape
                items.add(21295); //Infernal cape
                items.add(12771); //Lava whip mix
                items.add(12769); //Frozen whip mix
                items.add(12759); //Dark bow paint
                items.add(12761); //Dark bow paint
                items.add(12763); //Dark bow paint
                items.add(12757); //Dark bow paint
                items.add(12954); //Dragon defender

                // Compress into array
                size = items.size();
                keys = new int[items.size()];
                intVals = new int[items.size()];

                for (int i = 0; i < items.size(); i++) {
                    keys[i] = i;
                    intVals[i] = items.get(i);
                }
            }

            //Price's inside the slayer reward shop..
            if (id == 842) {
                List<Integer> costs = new LinkedList<Integer>();
                costs.add(75); // Slayer ring(8)
                costs.add(300); // Rune pouch
                costs.add(100); //Looting bag
                costs.add(100); //Fire cape
                costs.add(3000); //Infernal cape
                costs.add(300); //Lava whip mix
                costs.add(300); //Frozen whip mix
                costs.add(300); //Dark bow paint
                costs.add(300); //Dark bow paint
                costs.add(300); //Dark bow paint
                costs.add(300); //Dark bow paint
                costs.add(100); //Dragon defender

                List<Integer> items = new LinkedList<Integer>();
                items.add(11866); // Slayer ring(8)
                items.add(12791); // Rune pouch
                items.add(11941); //Looting bag
                items.add(6570); //Fire cape
                items.add(21295); //Infernal cape
                items.add(12771); //Lava whip mix
                items.add(12769); //Frozen whip mix
                items.add(12759); //Dark bow paint
                items.add(12761); //Dark bow paint
                items.add(12763); //Dark bow paint
                items.add(12757); //Dark bow paint
                items.add(12954); //Dragon defender

                // Compress into array
                size = costs.size();
                keys = new int[costs.size()];
                intVals = new int[costs.size()];

                for (int i = 0; i < costs.size(); i++) {
                    keys[i] = items.get(i);
                    intVals[i] = costs.get(i);
                }
            }
        }
    }

    void readNext(final Buffer buffer_0, final int int_0) {
        if (int_0 == 1) {
            keyType = (char) buffer_0.readUnsignedByte();
        } else if (int_0 == 2) {
            valType = (char) buffer_0.readUnsignedByte();
        } else if (int_0 == 3) {
            defaultString = buffer_0.readString();
        } else if (int_0 == 4) {
            defaultInt = buffer_0.readInt();
        } else {
            int int_1;
            if (int_0 == 5) {
                size = buffer_0.readUnsignedShort();
                keys = new int[size];
                stringVals = new String[size];

                for (int_1 = 0; int_1 < size; int_1++) {
                    keys[int_1] = buffer_0.readInt();
                    stringVals[int_1] = buffer_0.readString();
                }
            } else if (int_0 == 6) {
                size = buffer_0.readUnsignedShort();
                keys = new int[size];
                intVals = new int[size];

                for (int_1 = 0; int_1 < size; int_1++) {
                    keys[int_1] = buffer_0.readInt();
                    intVals[int_1] = buffer_0.readInt();
                }
            }
        }

    }

    public int method4980() {
        return size;
    }

    public static double[] method4986(final double double_0, final double double_1, final int int_0) {
        final int int_1 = (int_0 * 2) + 1;
        final double[] doubles_0 = new double[int_1];
        int int_2 = -int_0;

        for (int int_3 = 0; int_2 <= int_0; int_3++) {
            final double double_2 = (int_2 - double_0) / double_1;
            final double double_3 = Math.exp((-double_2 * double_2) / 2.0D) / Math.sqrt(6.283185307179586D);
            final double double_4 = double_3 / double_1;
            doubles_0[int_3] = double_4;
            ++int_2;
        }

        return doubles_0;
    }

}
