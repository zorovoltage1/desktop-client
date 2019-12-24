import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SkillInterface {


    public static void init(String selectedSkill) {
        List<Integer> containerIds = Arrays.asList(3, 4, 5, 6);

        Widget parent = Widget.get(134, 0);

        Widget titleText = Widget.get(134, 2);
        titleText.text = "Select a skill you'd like to receive experience in!";


        Widget confirmText = Widget.get(134, 26);
        confirmText.text = selectedSkill.isEmpty() ? "<col=742b22>Select a skill to continue." : "<col=55a71a> Confirm " + selectedSkill;
        confirmText.textColor = titleText.textColor;
        confirmText.fontId = 496;

        /**
         * Reposition containers.
         */
        for(int containerId : containerIds) {
            Widget inter = Widget.get(134, containerId);
            inter.setAction(0, "Claim reward");
            Player.method1114(inter);
            Game.widgetMethod0(inter);
        }


        /**
         * Children (Any new children have to be added after this!)
         */
        Widget[] children = GameCanvas.widgets[134];
        int childCount = Widget.widgetIndex.fileCount(134);
        ArrayList<Widget> newChildren = new ArrayList<Widget>();
        for(int i = 0; i < childCount; i++)
            newChildren.add(children[i]);



        /**
         * Experience reward text
         */
        Widget newDonatorStatusText = new Widget();
        newDonatorStatusText.parentHash = titleText.parentHash;
        newDonatorStatusText.text = "Experience Reward: 25,000 - 50,000";
        newDonatorStatusText.type = titleText.type;
        newDonatorStatusText.originalX = 85;
        newDonatorStatusText.originalY = titleText.originalY + 27;
        newDonatorStatusText.originalWidth = titleText.originalWidth;
        newDonatorStatusText.fontId = 494;
        newDonatorStatusText.textColor = titleText.textColor;
        newDonatorStatusText.textShadowed = titleText.textShadowed;
        newDonatorStatusText.fontHorizontalAlignment = titleText.fontHorizontalAlignment;
        newChildren.add(newDonatorStatusText);

/*        *//**
         * Herblore icon
         *//*
        Widget selectedText = new Widget();
        selectedText.parentHash = titleText.parentHash;
        selectedText.text = "Selected: " + selectedSkill;
        selectedText.type = titleText.type;
        selectedText.originalX = 85;
        selectedText.originalY = titleText.originalY + 180;
        selectedText.originalWidth = titleText.originalWidth;
        selectedText.fontId = 496;
        selectedText.textColor = titleText.textColor;
        selectedText.textShadowed = titleText.textShadowed;
        selectedText.fontHorizontalAlignment = titleText.fontHorizontalAlignment;
        newChildren.add(selectedText);*/


        /**
         * Children (Any new children have to become before this!)
         */
        for(int i = childCount; i < newChildren.size(); i++) {
            Widget child = newChildren.get(i);
            child.interfaceHash = 134 << 16 | i;
            if(child.type == 5) {
                long var37 = ((long) child.interfaceHash << 32) + (long) -1; //-1 is min/max value
                final Node node_0 = Game.widgetFlags.get(var37);
                if (node_0 != null)
                    node_0.unlink();
                Game.widgetFlags.put(new IntegerNode(2), var37);
            }
            Player.method1114(child);
            Game.widgetMethod0(child);
        }
        GameCanvas.widgets[134] = newChildren.toArray(new Widget[newChildren.size()]);

        /**
         * Refresh
         */
        Player.method1114(parent);
        Game.widgetMethod0(parent);

    }

}
