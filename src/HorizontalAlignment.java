public enum HorizontalAlignment implements Enumerated {

    field3484(1, 0), field3479(0, 1), field3481(2, 2);

    public final int value;
    final int field3483;

    HorizontalAlignment(final int int_1, final int int_2) {
        value = int_1;
        field3483 = int_2;
    }

    @Override
    public int vmethod5815() {
        return field3483;
    }

    public static NPCComposition getNpcDefinition(final int int_0) {
        NPCComposition npccomposition_0 = (NPCComposition) NPCComposition.npcs.get(int_0);
        if (npccomposition_0 != null) {
            return npccomposition_0;
        } else {
            final byte[] bytes_0 = NPCComposition.NpcDefinition_indexCache.getConfigData(9, int_0);
            npccomposition_0 = new NPCComposition();
            npccomposition_0.id = int_0;
            if (bytes_0 != null) {
                npccomposition_0.decode(new Buffer(bytes_0));
                npccomposition_0.postDecode();
            }

            npccomposition_0.post();
            NPCComposition.npcs.put(npccomposition_0, int_0);
            return npccomposition_0;
        }
    }

    public static void method5156(final String string_0, final boolean bool_0, final boolean bool_1) {
        MessageNode.method1053(string_0, bool_0, "openjs", bool_1);
    }

}
