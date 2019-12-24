public class ItemContainer extends Node {

    static RenderOverview renderOverview;
    static HashTable itemContainers;
    static IndexedSprite field472;
    int[] itemIds;
    int[] stackSizes;

    static {
        itemContainers = new HashTable(32);
    }

    ItemContainer() {
        itemIds = new int[]{-1};
        stackSizes = new int[]{0};
    }

    static IndexData openCacheIndex(final int int_0, final boolean bool_0, final boolean bool_1, final boolean bool_2) {
        IndexFile indexfile_0 = null;
        if (class155.dat2File != null) {
            indexfile_0 = new IndexFile(int_0, class155.dat2File, class76.idxFiles[int_0], 1000000);
        }

        return new IndexData(indexfile_0, class34.indexStore255, int_0, bool_0, bool_1, bool_2);
    }

    static void method1012() {
        for (int int_0 = 0; int_0 < class81.playerIndexesCount; int_0++) {
            final Player player_0 = Game.cachedPlayers[class81.playerIndices[int_0]];
            player_0.method1084();
        }

        class37.method640();
        if (WorldMapType3.clanMemberManager != null) {
            WorldMapType3.clanMemberManager.method5467();
        }

    }

}
