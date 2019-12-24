import java.util.ArrayList;

public class AccountManagementInterface {

    public static void init(String donatorStatus, String username, byte unreadPMs) {
        Widget parent = Widget.get(109, 0);

        /**
         * Useful links text change
         */
        Widget usefulLinkOne = Widget.get(109, 31);
        usefulLinkOne.text = "Vote Now";

        Widget usefulLinkTwo = Widget.get(109, 34);
        usefulLinkTwo.text = "Hiscores";

        /**
         * Children (Any new children have to be added after this!)
         */
        Widget[] children = GameCanvas.widgets[109];
        int childCount = Widget.widgetIndex.fileCount(109);
        ArrayList<Widget> newChildren = new ArrayList<Widget>();
        for(int i = 0; i < childCount; i++)
            newChildren.add(children[i]);

        /**
         * Donator status text
         */
        Widget donatorStatusText = Widget.get(109, 2);
        donatorStatusText.isHidden = true;

        Widget newDonatorStatusText = new Widget();
        newDonatorStatusText.parentHash = donatorStatusText.parentHash;
        newDonatorStatusText.text = "Donator Status: " + donatorStatus;
        newDonatorStatusText.type = donatorStatusText.type;
        newDonatorStatusText.originalX = 95;
        newDonatorStatusText.originalY = donatorStatusText.originalY + 3;
        newDonatorStatusText.originalWidth = donatorStatusText.originalWidth;
        newDonatorStatusText.fontId = donatorStatusText.fontId;
        newDonatorStatusText.textColor = donatorStatusText.textColor;
        newDonatorStatusText.textShadowed = donatorStatusText.textShadowed;
        newDonatorStatusText.fontHorizontalAlignment = donatorStatusText.fontHorizontalAlignment;
        newChildren.add(newDonatorStatusText);

        /**
         * Unread private messages text
         */
        Widget unreadMessages = Widget.get(109, 14);
        unreadMessages.isHidden = true;

        Widget newUnreadMessages = new Widget();
        newUnreadMessages.parentHash = unreadMessages.parentHash;
        newUnreadMessages.text = "Inbox: " + unreadPMs + " message" + (unreadPMs == 1 ? "" : "s");
        newUnreadMessages.type = unreadMessages.type;
        newUnreadMessages.originalX = 95;
        newUnreadMessages.originalY = unreadMessages.originalY + 3;
        newUnreadMessages.originalWidth = unreadMessages.originalWidth;
        newUnreadMessages.fontId = unreadMessages.fontId;
        newUnreadMessages.textColor = unreadMessages.textColor;
        newUnreadMessages.textShadowed = unreadMessages.textShadowed;
        newUnreadMessages.fontHorizontalAlignment = unreadMessages.fontHorizontalAlignment;
        newChildren.add(newUnreadMessages);

        /**
         * Open store text
         */
        Widget openStore = Widget.get(109, 7);
        openStore.isHidden = true;

        Widget newOpenStore = new Widget();
        newOpenStore.parentHash = openStore.parentHash;
        newOpenStore.text = "Open Store";
        newOpenStore.type = openStore.type;
        newOpenStore.originalX = openStore.originalX + 67;
        newOpenStore.originalY = openStore.originalY + 10;
        newOpenStore.originalWidth = openStore.originalWidth;
        newOpenStore.fontId = openStore.fontId;
        newOpenStore.textColor = openStore.textColor;
        newOpenStore.textShadowed = openStore.textShadowed;
        newOpenStore.onMouseOverListener = openStore.onMouseOverListener;
        newOpenStore.fontHorizontalAlignment = openStore.fontHorizontalAlignment;
        newChildren.add(newOpenStore);

        /**
         * Buy credits
         */
        Widget buyCredits = Widget.get(109, 12);
        buyCredits.isHidden = true;

        Widget newBuyCredits = new Widget();
        newBuyCredits.parentHash = buyCredits.parentHash;
        newBuyCredits.text = "Buy Credits";
        newBuyCredits.type = buyCredits.type;
        newBuyCredits.originalX = buyCredits.originalX + 67;
        newBuyCredits.originalY = buyCredits.originalY + 10;
        newBuyCredits.originalWidth = buyCredits.originalWidth;
        newBuyCredits.onMouseOverListener = buyCredits.onMouseOverListener;
        newBuyCredits.fontId = buyCredits.fontId;
        newBuyCredits.textColor = buyCredits.textColor;
        newBuyCredits.textShadowed = buyCredits.textShadowed;
        newBuyCredits.fontHorizontalAlignment = buyCredits.fontHorizontalAlignment;
        newChildren.add(newBuyCredits);

        /**
         * Username status text
         */
        Widget usernameText = Widget.get(109, 21);
        usernameText.isHidden = true;

        Widget newUsernameText = new Widget();
        newUsernameText.parentHash = usernameText.parentHash;
        newUsernameText.text = "Name: " + username;
        newUsernameText.type = usernameText.type;
        newUsernameText.originalX = 95;
        newUsernameText.originalY = usernameText.originalY + 3;
        newUsernameText.originalWidth = usernameText.originalWidth;
        newUsernameText.fontId = usernameText.fontId;
        newUsernameText.textColor = usernameText.textColor;
        newUsernameText.textShadowed = usernameText.textShadowed;
        newUsernameText.fontHorizontalAlignment = usernameText.fontHorizontalAlignment;
        newChildren.add(newUsernameText);

        /**
         * Children (Any new children have to become before this!)
         */
        for(int i = childCount; i < newChildren.size(); i++) {
            Widget child = newChildren.get(i);
            child.interfaceHash = 109 << 16 | i;
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
        GameCanvas.widgets[109] = newChildren.toArray(new Widget[newChildren.size()]);


        /**
         * Refresh
         */
        Player.method1114(parent);
    }

}
