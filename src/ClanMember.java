public class ClanMember extends ChatPlayer {

    class289 field3608;
    class289 field3609;

    ClanMember() {
        field3608 = class289.field3633;
        field3609 = class289.field3633;
    }

    void method5272() {
        field3608 = class289.field3633;
    }

    public boolean method5266() {
        if (field3608 == class289.field3633) {
            method5264();
        }

        return field3608 == class289.field3631;
    }

    void method5264() {
        field3608 = DState.friendManager.field970.isMember(super.name) ? class289.field3631 : class289.field3634;
    }

    void method5273() {
        field3609 = class289.field3633;
    }

    public boolean method5267() {
        if (field3609 == class289.field3633) {
            method5268();
        }

        return field3609 == class289.field3631;
    }

    void method5268() {
        field3609 = DState.friendManager.field975.isMember(super.name) ? class289.field3631 : class289.field3634;
    }

}
