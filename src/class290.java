public class class290 extends NameableContainer {

    static int myWorldPort;
    final JagexLoginType field3635;
    int field3637;
    public class208 field3639;

    public class290(final JagexLoginType jagexlogintype_0) {
        super(400);
        field3637 = 1;
        field3639 = new class208();
        field3635 = jagexlogintype_0;
    }

    @Override
    Nameable vmethod5461() {
        return new Friend();
    }

    @Override
    Nameable[] vmethod5462(final int int_0) {
        return new Friend[int_0];
    }

    public boolean method5423(final Name name_0, final boolean bool_0) {
        final Friend friend_0 = (Friend) method5330(name_0);
        return friend_0 != null && (!bool_0 || (friend_0.world != 0));
    }

    public void method5424(final Buffer buffer_0, final int int_0) {
        while (true) {
            if (buffer_0.offset < int_0) {
                final boolean bool_0 = buffer_0.readUnsignedByte() == 1;
                final Name name_0 = new Name(buffer_0.readString(), field3635);
                final Name name_1 = new Name(buffer_0.readString(), field3635);
                final int int_1 = buffer_0.readUnsignedShort();
                final int int_2 = buffer_0.readUnsignedByte();
                final int int_3 = buffer_0.readUnsignedByte();
                final boolean bool_1 = (int_3 & 0x2) != 0;
                final boolean bool_2 = (int_3 & 0x1) != 0;
                if (int_1 > 0) {
                    buffer_0.readString();
                    buffer_0.readUnsignedByte();
                    buffer_0.readInt();
                }

                buffer_0.readString();
                if ((name_0 != null) && name_0.isCleanNameValid()) {
                    Friend friend_0 = (Friend) method5331(name_0);
                    if (bool_0) {
                        final Friend friend_1 = (Friend) method5331(name_1);
                        if ((friend_1 != null) && (friend_1 != friend_0)) {
                            if (friend_0 != null) {
                                method5334(friend_1);
                            } else {
                                friend_0 = friend_1;
                            }
                        }
                    }

                    if (friend_0 != null) {
                        method5338(friend_0, name_0, name_1);
                        if (int_1 != friend_0.world) {
                            boolean bool_3 = true;

                            for (class294 class294_0 = (class294) field3639
                                    .method4111(); class294_0 != null; class294_0 = (class294) field3639.method4114()) {
                                if (class294_0.field3662.equals(name_0)) {
                                    if ((int_1 != 0) && (class294_0.field3664 == 0)) {
                                        class294_0.method4121();
                                        bool_3 = false;
                                    } else if ((int_1 == 0) && (class294_0.field3664 != 0)) {
                                        class294_0.method4121();
                                        bool_3 = false;
                                    }
                                }
                            }

                            if (bool_3) {
                                field3639.method4112(new class294(name_0, int_1));
                            }
                        }
                    } else {
                        if (getCount() >= 400) {
                            continue;
                        }

                        friend_0 = (Friend) method5335(name_0, name_1);
                    }

                    if (int_1 != friend_0.world) {
                        friend_0.field3627 = field3637++;
                        if ((friend_0.world == -1) && (int_1 == 0)) {
                            friend_0.field3627 = -(friend_0.field3627 * -1772374531) * -745943211;
                        }

                        friend_0.world = int_1;
                    }

                    friend_0.rank = int_2;
                    friend_0.field3648 = bool_1;
                    friend_0.field3650 = bool_2;
                    continue;
                }

                throw new IllegalStateException();
            }

            method5337();
            return;
        }
    }

}
