public class ClanMemberManager extends NameableContainer {

    static Font fontBold12;
    final JagexLoginType field3656;
    final class288 field3652;
    public String field3654;
    public String field3655;
    public byte field3651;
    public int field3657;
    int field3658;

    public ClanMemberManager(final JagexLoginType jagexlogintype_0, final class288 class288_0) {
        super(100);
        field3654 = null;
        field3655 = null;
        field3658 = 1;
        field3656 = jagexlogintype_0;
        field3652 = class288_0;
    }

    @Override
    Nameable vmethod5461() {
        return new ClanMember();
    }

    @Override
    Nameable[] vmethod5462(final int int_0) {
        return new ClanMember[int_0];
    }

    void method5477(final String string_0) {
        long long_0 = 0L;
        final int int_0 = string_0.length();

        for (int int_1 = 0; int_1 < int_0; int_1++) {
            long_0 *= 37L;
            final char char_0 = string_0.charAt(int_1);
            if ((char_0 >= 65) && (char_0 <= 90)) {
                long_0 += (char_0 + 1) - 65;
            } else if ((char_0 >= 97) && (char_0 <= 122)) {
                long_0 += (char_0 + 1) - 97;
            } else if ((char_0 >= 48) && (char_0 <= 57)) {
                long_0 += (char_0 + 27) - 48;
            }

            if (long_0 >= 177917621779460413L) {
                break;
            }
        }

        while (((long_0 % 37L) == 0L) && (long_0 != 0L)) {
            long_0 /= 37L;
        }

        String string_1 = PacketNode.method3457(long_0);
        if (string_1 == null) {
            string_1 = "";
        }

        field3654 = string_1;
    }

    void method5464(final String string_0) {
        long long_0 = 0L;
        final int int_0 = string_0.length();

        for (int int_1 = 0; int_1 < int_0; int_1++) {
            long_0 *= 37L;
            final char char_0 = string_0.charAt(int_1);
            if ((char_0 >= 65) && (char_0 <= 90)) {
                long_0 += (char_0 + 1) - 65;
            } else if ((char_0 >= 97) && (char_0 <= 122)) {
                long_0 += (char_0 + 1) - 97;
            } else if ((char_0 >= 48) && (char_0 <= 57)) {
                long_0 += (char_0 + 27) - 48;
            }

            if (long_0 >= 177917621779460413L) {
                break;
            }
        }

        while (((long_0 % 37L) == 0L) && (long_0 != 0L)) {
            long_0 /= 37L;
        }

        String string_1 = PacketNode.method3457(long_0);
        if (string_1 == null) {
            string_1 = "";
        }

        field3655 = string_1;
    }

    public void method5463(final Buffer buffer_0) {
        method5464(buffer_0.readString());
        String string_0 = buffer_0.readString();
        int int_0;

        method5477(string_0);
        field3651 = buffer_0.readByte();
        int_0 = buffer_0.readUnsignedByte();
        if (int_0 != 255) {
            method5326();

            for (int int_1 = 0; int_1 < int_0; int_1++) {
                final ClanMember clanmember_0 = (ClanMember) method5377(new Name(buffer_0.readString(), field3656));
                final int int_2 = buffer_0.readUnsignedShort();
                clanmember_0.method5412(int_2, field3658++);
                clanmember_0.rank = buffer_0.readByte();
                buffer_0.readString();
                method5482(clanmember_0);
            }

        }
    }

    public void method5489(final Buffer buffer_0) {
        final Name name_0 = new Name(buffer_0.readString(), field3656);
        final int int_0 = buffer_0.readUnsignedShort();
        final byte byte_0 = buffer_0.readByte();
        boolean bool_0 = false;
        if (byte_0 == -128) {
            bool_0 = true;
        }

        ClanMember clanmember_0;
        if (bool_0) {
            if (getCount() == 0) {
                return;
            }

            clanmember_0 = (ClanMember) method5331(name_0);
            if ((clanmember_0 != null) && (clanmember_0.method5414() == int_0)) {
                method5334(clanmember_0);
            }
        } else {
            buffer_0.readString();
            clanmember_0 = (ClanMember) method5331(name_0);
            if (clanmember_0 == null) {
                if (getCount() > super.field3620) {
                    return;
                }

                clanmember_0 = (ClanMember) method5377(name_0);
            }

            clanmember_0.method5412(int_0, field3658++);
            clanmember_0.rank = byte_0;
            method5482(clanmember_0);
        }

    }

    public void method5467() {
        for (int int_0 = 0; int_0 < getCount(); int_0++) {
            ((ClanMember) get(int_0)).method5272();
        }

    }

    public void method5468() {
        for (int int_0 = 0; int_0 < getCount(); int_0++) {
            ((ClanMember) get(int_0)).method5273();
        }

    }

    void method5482(final ClanMember clanmember_0) {
        if (clanmember_0.method5287().equals(field3652.vmethod5420())) {
            field3657 = clanmember_0.rank;
        }

    }

    public static boolean method5496(final char char_0) {
        if (((char_0 <= 0) || (char_0 >= 128)) && ((char_0 < 160) || (char_0 > 255))) {
            if (char_0 != 0) {
                final char[] chars_0 = class301.cp1252AsciiExtension;

                for (int int_0 = 0; int_0 < chars_0.length; int_0++) {
                    final char char_1 = chars_0[int_0];
                    if (char_0 == char_1) {
                        return true;
                    }
                }
            }

            return false;
        } else {
            return true;
        }
    }

}
