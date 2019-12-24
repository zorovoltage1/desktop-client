import java.text.DecimalFormat;

public class SwitchGrading {

    private static final DecimalFormat onePlace = new DecimalFormat("0.0");

    public static int required;

    private int[] ids;

    private long start;

    private int updates = 0, switched = 0;

    public void check(Player player) {
        if(ids == null) {
            /**
             * Player just logged in, don't check for any switches.
             */
            ids = new int[12];
            for(int i = 0; i < 12; i++) {
                int style = player.composition.equipmentIds[i];
                int id = style >= 512 ? style - 512 : 0;
                ids[i] = id;
            }
        } else if(required > 0) {
            /**
             * If switch takes 5 seconds or longer, timeout.
             */
            long ms = Buffer.safeCurrentTimeMillis();
            if(start == 0 || (ms - start >= 5000L)) {
                start = ms;
                updates = 0;
                switched = 0;
            }
            /**
             * Keep track of this update & which items were updated.
             */
            updates++;
            for(int i = 0; i < 12; i++) {
                int style = player.composition.equipmentIds[i];
                int id = style >= 512 ? style - 512 : 0;
                if(ids[i] != id) {
                    ids[i] = id;
                    switched++;
                }
            }
            /**
             * If required amount of items were switched, grade!
             */
            if(switched >= required) {
                grade();
                start = 0;
                updates = 0;
                switched = 0;
            }
        }
    }

    private void grade() {
        double totalMs = updates * 600D;
        double bestSwitchMs = 600D / required;
        double averageSwitchMs = totalMs / required;
        class143.sendGameMessage(99, "", "<img=90> <col=DC143C>" + required + " Item Switch:</col>  " +
                toGrade(bestSwitchMs / averageSwitchMs) +
                "   " + onePlace.format(totalMs / 1000D) + " seconds" +
                " (" + (updates == 1 ? "1 tick" : (updates + " ticks")) + ")"
        );
    }

    private static String toGrade(double d) {
        int percent = (int) Math.max(0.0, Math.round(d * 100D));
        return percent + "% (" + toLetter(percent) + ")";
    }

    private static String toLetter(int percent) {
        if(percent <= 59)
            return "F";

        if(percent <= 62)
            return "D-";
        if(percent <= 66)
            return "D";
        if(percent <= 69)
            return "D+";

        if(percent <= 72)
            return "C-";
        if(percent <= 76)
            return "C";
        if(percent <= 79)
            return "C+";

        if(percent <= 82)
            return "B-";
        if(percent <= 86)
            return "B";
        if(percent <= 89)
            return "B+";

        if(percent <= 92)
            return "A-";
        if(percent <= 99)
            return "A";
        return "A+";
    }

}