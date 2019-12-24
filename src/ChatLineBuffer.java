public class ChatLineBuffer {

    public static int field1212;
    MessageNode[] lines;
    int length;

    ChatLineBuffer() {
        lines = new MessageNode[100];
    }

    MessageNode addMessage(final int int_0, final String string_0, final String string_1, final String string_2) {
        MessageNode messagenode_0 = lines[99];

        for (int int_1 = length; int_1 > 0; --int_1) {
            if (int_1 != 100) {
                lines[int_1] = lines[int_1 - 1];
            }
        }

        if (messagenode_0 == null) {
            messagenode_0 = new MessageNode(int_0, string_0, string_2, string_1);
        } else {
            messagenode_0.unlink();
            messagenode_0.unlinkDual();
            messagenode_0.setMessage(int_0, string_0, string_2, string_1);
        }

        lines[0] = messagenode_0;
        if (length < 100) {
            ++length;
        }

        return messagenode_0;
    }

    MessageNode getMessage(final int int_0) {
        return (int_0 >= 0) && (int_0 < length) ? lines[int_0] : null;
    }

    int size() {
        return length;
    }

    public static int method1970(final int int_0, final int int_1, int int_2, int int_3, int int_4, final int int_5) {
        if ((int_5 & 0x1) == 1) {
            final int int_6 = int_3;
            int_3 = int_4;
            int_4 = int_6;
        }

        int_2 &= 0x3;
        return int_2 == 0 ? int_1
                : (int_2 == 1 ? 7 - int_0 - (int_3 - 1) : (int_2 == 2 ? 7 - int_1 - (int_4 - 1) : int_0));
    }

}
