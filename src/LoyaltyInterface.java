import java.util.Arrays;
import java.util.List;

public class LoyaltyInterface {

    public static void init(int dayReward, int currentSpree, int highestSpree, int totalClaimedRewards, List<int[]> packs) {
        List<Integer> containerIds = Arrays.asList(25, 27, 29, 31, 33, 35, 37, 39, 41, 43);
        List<Integer> lockedContainerIds = Arrays.asList(15, 16, 17, 18, 19, 20, 21, 22, 23, 24);
        Widget parent = Widget.get(264, 1);
        int childId = parent.children.length;
        /**
         * Title
         */
        Widget title = parent.children[1];
        title.text = Loader.SERVER_NAME + " Loyalty Rewards";
        Player.method1114(title);

        /**
         * Reposition containers.
         */
        for(int containerId : containerIds) {
            Widget inter = Widget.get(264, containerId);
            inter.text = "";
            inter.onClickListener = null;
            inter.onMouseOverListener = null;
            inter.onMouseLeaveListener = null;
            inter.setAction(0, "Claim reward");
            inter.setAction(1, null);
            inter.setAction(2, null);
            inter.setAction(3, null);
            Player.method1114(title);
            Game.widgetMethod0(title);
        }

        /**
         * Hide old button content
         */
        for(int i = 45; i < 65; i ++) {
            Widget inter = Widget.get(264, i);
            inter.isHidden = true;
        }

        /**
         * Set unlocked days
         */
        for(int i = 0; i < dayReward; i ++) {
            Widget inter = Widget.get(264, lockedContainerIds.get(i));
            inter.isHidden = true;
        }

        /**
         * Hide statistics background
         */
        Widget inter = Widget.get(264, 4);
        inter.isHidden = true;

        /**
         * Fill containers
         */
        for(int i = 0; i < 10; i++) {
            Widget container = Widget.get(264, containerIds.get(i));
            int containerChild = 0;
            int[] pack = packs.get(i);
            int rewardId = pack[0];
            int rewardAmount = pack[1];
            Widget item = Widget.addChild(container.interfaceHash, 5, containerChild++);
            item.hasListener = true;
            item.originalX = 30;
            item.originalY = 24;
            item.originalWidth = 36;
            item.originalHeight = 32;
            item.shadow = 3355443;
            item.borderThickness = 1;
            item.fontVerticalAlignment = 1;
            item.fontHorizontalAlignment = 1;
            Widget.setItem(item, rewardId, (rewardAmount == 1) ? -1 : rewardAmount, 1);
            Player.method1114(item);
            Game.widgetMethod0(item);

            Widget day = Widget.addChild(container.interfaceHash, 4, containerChild++);
            day.hasListener = true;
            day.originalX = 0;
            day.originalY = -13;
            day.dynamicWidth = 1;
            day.originalHeight = 50;
            day.fontVerticalAlignment = 1;
            day.fontHorizontalAlignment = 1;
            day.fontId = 496;
            day.textShadowed = true;
            day.textColor = 0xF39C12;
            day.text = "Day " + (i + 1);
            Player.method1114(day);
            Game.widgetMethod0(day);

            Widget itemName = Widget.addChild(container.interfaceHash, 4, containerChild++);
            itemName.hasListener = true;
            itemName.dynamicWidth = 1;
            itemName.originalY = 39;
            itemName.originalHeight = 50;
            itemName.fontHorizontalAlignment = 1;
            itemName.fontVerticalAlignment = 1;
            itemName.fontId = 494;
            itemName.textShadowed = true;
            itemName.textColor = 0xD0D3D4;

            if(dayReward > (i + 1)) {
                Widget check = Widget.addChild(container.interfaceHash, 4, containerChild++);
                check.hasListener = true;
                check.originalX = 2;
                check.originalY = 65;
                check.originalWidth = 500;
                check.originalHeight = 20;
                check.fontId = 494;
                check.text = "<img=121>";
                check.textShadowed = true;
                check.textColor = 0xff9040;
                Player.method1114(check);
                Game.widgetMethod0(check);
            }

            ItemComposition def = TextureProvider.getItemDefinition(rewardId);
            boolean note = def.notedTemplate >= 0 && def.notedId >= 0;
            itemName.text = (note ? TextureProvider.getItemDefinition(def.notedId).name : def.name);
            Player.method1114(itemName);
            Game.widgetMethod0(itemName);
        }


        /**
         * Statistics
         */
        Widget statistics = Widget.addChild(parent.interfaceHash, 4, childId++);
        statistics.hasListener = true;
        statistics.originalX = 278;
        statistics.originalY = 216;
        statistics.originalWidth = 170;
        statistics.originalHeight = 10;
        statistics.fontId = 496;
        statistics.text = "Statistics";
        statistics.textShadowed = true;
        statistics.textColor = 0xF39C12;
        Player.method1114(statistics);
        Game.widgetMethod0(statistics);

        Widget spreeMsg = Widget.addChild(parent.interfaceHash, 4, childId++);
        spreeMsg.hasListener = true;
        spreeMsg.originalX = 230;
        spreeMsg.originalY = 233;
        spreeMsg.originalWidth = 170;
        spreeMsg.originalHeight = 20;
        spreeMsg.fontId = 494;
        spreeMsg.text = "Current Spree:";
        spreeMsg.textShadowed = true;
        spreeMsg.textColor = 0xff9040;
        Player.method1114(spreeMsg);
        Game.widgetMethod0(spreeMsg);

        Widget spreeMsg1 = Widget.addChild(parent.interfaceHash, 4, childId++);
        spreeMsg1.hasListener = true;
        spreeMsg1.originalX = 307;
        spreeMsg1.originalY = 233;
        spreeMsg1.originalWidth = 170;
        spreeMsg1.originalHeight = 20;
        spreeMsg1.fontId = 494;
        spreeMsg1.text = "" + currentSpree;
        spreeMsg1.textShadowed = true;
        spreeMsg1.textColor = 0xD0D3D4;
        Player.method1114(spreeMsg1);
        Game.widgetMethod0(spreeMsg1);

        Widget highestSpreeMsg = Widget.addChild(parent.interfaceHash, 4, childId++);
        highestSpreeMsg.hasListener = true;
        highestSpreeMsg.originalX = 230;
        highestSpreeMsg.originalY = 247;
        highestSpreeMsg.originalWidth = 170;
        highestSpreeMsg.originalHeight = 20;
        highestSpreeMsg.fontId = 494;
        highestSpreeMsg.text = "Highest Spree:";
        highestSpreeMsg.textShadowed = true;
        highestSpreeMsg.textColor = 0xff9040;
        Player.method1114(highestSpreeMsg);
        Game.widgetMethod0(highestSpreeMsg);

        Widget highestSpreeMsg1 = Widget.addChild(parent.interfaceHash, 4, childId++);
        highestSpreeMsg1.hasListener = true;
        highestSpreeMsg1.originalX = 307;
        highestSpreeMsg1.originalY = 247;
        highestSpreeMsg1.originalWidth = 170;
        highestSpreeMsg1.originalHeight = 20;
        highestSpreeMsg1.fontId = 494;
        highestSpreeMsg1.text = "" + highestSpree;
        highestSpreeMsg1.textShadowed = true;
        highestSpreeMsg1.textColor = 0xD0D3D4;
        Player.method1114(highestSpreeMsg1);
        Game.widgetMethod0(highestSpreeMsg1);

        Widget totalClaimed = Widget.addChild(parent.interfaceHash, 4, childId++);
        totalClaimed.hasListener = true;
        totalClaimed.originalX = 230;
        totalClaimed.originalY = 262;
        totalClaimed.originalWidth = 170;
        totalClaimed.originalHeight = 20;
        totalClaimed.fontId = 494;
        totalClaimed.text = "Total Claimed Rewards:";
        totalClaimed.textShadowed = true;
        totalClaimed.textColor = 0xff9040;
        Player.method1114(totalClaimed);
        Game.widgetMethod0(totalClaimed);

        Widget totalClaimed1 = Widget.addChild(parent.interfaceHash, 4, childId++);
        totalClaimed1.hasListener = true;
        totalClaimed1.originalX = 346;
        totalClaimed1.originalY = 262;
        totalClaimed1.originalWidth = 170;
        totalClaimed1.originalHeight = 20;
        totalClaimed1.fontId = 494;
        totalClaimed1.text  = "" + totalClaimedRewards;
        totalClaimed1.textShadowed = true;
        totalClaimed1.textColor = 0xD0D3D4;
        Player.method1114(totalClaimed1);
        Game.widgetMethod0(totalClaimed1);

        /**
         * Top thank you message
         */
        Widget thankYou = Widget.addChild(parent.interfaceHash, 4, childId++);
        thankYou.hasListener = true;
        thankYou.originalX = 63;
        thankYou.originalY = 36;
        thankYou.originalWidth = 500;
        thankYou.originalHeight = 20;
        thankYou.fontId = 494;
        thankYou.text = "Thanks for playing " + Loader.SERVER_NAME+"! Select your <col=4dff4d>loyalty reward</col> below!";
        thankYou.textShadowed = true;
        thankYou.textColor = 0xff9040;
        Player.method1114(thankYou);
        Game.widgetMethod0(thankYou);

        Widget heart = Widget.addChild(parent.interfaceHash, 4, childId++);
        heart.hasListener = true;
        heart.originalX = 49;
        heart.originalY = 38;
        heart.originalWidth = 500;
        heart.originalHeight = 20;
        heart.fontId = 494;
        heart.text = "<img=91>";
        heart.textShadowed = true;
        heart.textColor = 0xff9040;
        Player.method1114(heart);
        Game.widgetMethod0(heart);

    }

}
