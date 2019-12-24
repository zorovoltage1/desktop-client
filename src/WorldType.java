public enum WorldType {
    PVP,
    ECO;

    public static WorldType active;

    public static boolean isPVP() {
        return active == PVP;
    }

    public static boolean isEco() {
        return active == ECO;
    }

}
