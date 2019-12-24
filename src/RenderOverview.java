import java.util.*;

public class RenderOverview {

    static final FontName fontNameVerdana11;
    static final FontName fontNameVerdana13;
    static final FontName fontNameVerdana15;
    IndexDataBase field3828;
    Font field3820;
    HashMap mapFonts;
    IndexedSprite[] field3822;
    HashMap worldMapDataByIdentifier;
    WorldMapData field3838;
    WorldMapData worldMapData;
    WorldMapData field3826;
    WorldMapManager worldMapManager;
    class320 field3850;
    int worldMapX;
    int worldMapY;
    int worldMapTargetX;
    int worldMapTargetY;
    float worldMapZoom;
    float worldMapZoomTarget;
    int worldMapDisplayWidth;
    int worldMapDisplayHeight;
    int worldMapDisplayX;
    int worldMapDisplayY;
    int field3857;
    int field3840;
    boolean field3841;
    HashSet field3842;
    int field3855;
    int field3819;
    int field3845;
    int field3846;
    int field3847;
    int field3817;
    long field3849;
    int field3864;
    int field3851;
    boolean field3852;
    HashSet field3853;
    HashSet field3843;
    HashSet field3844;
    HashSet field3856;
    boolean field3854;
    int field3861;
    final int[] field3859;
    List field3860;
    Iterator field3848;
    HashSet field3862;
    Coordinates field3863;
    public boolean field3839;
    SpritePixels field3865;
    int field3866;
    int field3811;
    int field3868;
    int field3869;

    static {
        fontNameVerdana11 = FontName.field3673;
        fontNameVerdana13 = FontName.field3670;
        fontNameVerdana15 = FontName.field3669;
    }

    public RenderOverview() {
        worldMapTargetX = -1;
        worldMapTargetY = -1;
        worldMapDisplayWidth = -1;
        worldMapDisplayHeight = -1;
        worldMapDisplayX = -1;
        worldMapDisplayY = -1;
        field3857 = 3;
        field3840 = 50;
        field3841 = false;
        field3842 = null;
        field3855 = -1;
        field3819 = -1;
        field3845 = -1;
        field3846 = -1;
        field3847 = -1;
        field3817 = -1;
        field3852 = true;
        field3853 = new HashSet();
        field3843 = new HashSet();
        field3844 = new HashSet();
        field3856 = new HashSet();
        field3854 = false;
        field3861 = 0;
        field3859 = new int[]{1008, 1009, 1010, 1011, 1012};
        field3862 = new HashSet();
        field3863 = null;
        field3839 = false;
        field3811 = -1;
        field3868 = -1;
        field3869 = -1;
    }

    public void method6000(final IndexDataBase indexdatabase_0, final Font font_0, final HashMap hashmap_0,
                           final IndexedSprite[] indexedsprites_0) {
        field3822 = indexedsprites_0;
        field3828 = indexdatabase_0;
        field3820 = font_0;
        mapFonts = new HashMap();
        mapFonts.put(Size.field70, hashmap_0.get(fontNameVerdana11));
        mapFonts.put(Size.field71, hashmap_0.get(fontNameVerdana13));
        mapFonts.put(Size.field72, hashmap_0.get(fontNameVerdana15));
        field3850 = new class320(indexdatabase_0);
        final int int_0 = field3828.getFile(MapCacheArchiveNames.DETAILS.name);
        final int[] ints_0 = field3828.getChilds(int_0);
        worldMapDataByIdentifier = new HashMap(ints_0.length);

        for (int int_1 = 0; int_1 < ints_0.length; int_1++) {
            final Buffer buffer_0 = new Buffer(field3828.getConfigData(int_0, ints_0[int_1]));
            final WorldMapData worldmapdata_0 = new WorldMapData();
            worldmapdata_0.loadMapData(buffer_0, ints_0[int_1]);
            worldMapDataByIdentifier.put(worldmapdata_0.getIdentifier(), worldmapdata_0);
            if (worldmapdata_0.method208()) {
                field3838 = worldmapdata_0;
            }
        }

        method6015(field3838);
        field3826 = null;
    }

    public int method6094() {
        return field3828.tryLoadRecordByNames(field3838.getIdentifier(), MapCacheArchiveNames.AREA.name) ? 100
                : field3828.archiveLoadPercentByName(field3838.getIdentifier());
    }

    public void method6013() {
        WorldComparator.method7();
    }

    public void method6003(final int int_0, final int int_1, final boolean bool_0, final int int_2, final int int_3,
                           final int int_4, final int int_5) { //nick
        if (field3850.method5987()) {
            moveTowardZoomTarget();
            moveTowardLocationTarget();
            if (bool_0) {
                final int int_6 = (int) Math.ceil(int_4 / worldMapZoom);
                final int int_7 = (int) Math.ceil(int_5 / worldMapZoom);
                final List list_0 = worldMapManager.method487(worldMapX - (int_6 / 2) - 1, worldMapY - (int_7 / 2) - 1,
                        (int_6 / 2) + worldMapX + 1, (int_7 / 2) + worldMapY + 1, int_2, int_3, int_4, int_5, int_0,
                        int_1);
                final HashSet hashset_0 = new HashSet();

                Iterator iterator_0;
                MapIcon mapicon_0;
                ScriptEvent scriptevent_0;
                MapIconReference mapiconreference_0;
                for (iterator_0 = list_0.iterator(); iterator_0.hasNext(); class68.method1696(scriptevent_0)) {
                    mapicon_0 = (MapIcon) iterator_0.next();
                    hashset_0.add(mapicon_0);
                    scriptevent_0 = new ScriptEvent();
                    mapiconreference_0 = new MapIconReference(mapicon_0.areaId, mapicon_0.field243, mapicon_0.field236);
                    scriptevent_0.method1024(
                            new Object[]{mapiconreference_0, Integer.valueOf(int_0), Integer.valueOf(int_1)});
                    if (field3862.contains(mapicon_0)) {
                        scriptevent_0.method1025(17);
                    } else {
                        scriptevent_0.method1025(15);
                    }
                }

                iterator_0 = field3862.iterator();

                while (iterator_0.hasNext()) {
                    mapicon_0 = (MapIcon) iterator_0.next();
                    if (!hashset_0.contains(mapicon_0)) {
                        scriptevent_0 = new ScriptEvent();
                        mapiconreference_0 = new MapIconReference(mapicon_0.areaId, mapicon_0.field243,
                                mapicon_0.field236);
                        scriptevent_0.method1024(
                                new Object[]{mapiconreference_0, Integer.valueOf(int_0), Integer.valueOf(int_1)});
                        scriptevent_0.method1025(16);
                        class68.method1696(scriptevent_0);
                    }
                }

                field3862 = hashset_0;
            }
        }
    }

    public void method6174(final int int_0, final int int_1, final boolean bool_0, final boolean bool_1) {
        final long long_0 = Buffer.safeCurrentTimeMillis();
        method6036(int_0, int_1, bool_1, long_0);
        if (!hasTargetPosition() && (bool_1 || bool_0)) {
            if (bool_1) {
                field3847 = int_0;
                field3817 = int_1;
                field3845 = worldMapX;
                field3846 = worldMapY;
            }

            if (field3845 != -1) {
                final int int_2 = int_0 - field3847;
                final int int_3 = int_1 - field3817;
                setWorldMapPosition(field3845 - (int) (int_2 / worldMapZoomTarget),
                        (int) (int_3 / worldMapZoomTarget) + field3846, false);
            }
        } else {
            method6009();
        }

        if (bool_1) {
            field3849 = long_0;
            field3864 = int_0;
            field3851 = int_1;
        }

    }

    void method6036(final int int_0, final int int_1, final boolean bool_0, final long long_0) {
        if (worldMapData != null) {
            final int int_2 = (int) (worldMapX + ((int_0 - worldMapDisplayX - ((method6142() * worldMapZoom) / 2.0F)) / worldMapZoom));
            final int int_3 = (int) (worldMapY - ((int_1 - worldMapDisplayY - ((method6038() * worldMapZoom) / 2.0F)) / worldMapZoom));
            field3863 = worldMapData.method205(int_2 + (worldMapData.getMinX() * 64), int_3 + (worldMapData.getMinY() * 64));
            if ((field3863 != null) && bool_0) {
                final boolean bool_1 = Game.rights >= 2;
                if (bool_1 && KeyFocusListener.keyPressed[82] && KeyFocusListener.keyPressed[81]) { //Shift+ctrl click
                    WorldMapDecoration.method197(field3863.worldX, field3863.worldY, field3863.plane, false);
                } else {
                    boolean bool_2 = true;
                    if (field3852) {
                        final int int_4 = int_0 - field3864;
                        final int int_5 = int_1 - field3851;
                        if (((long_0 - field3849) > 500L) || (int_4 < -25) || (int_4 > 25) || (int_5 < -25) || (int_5 > 25)) {
                            bool_2 = false;
                        }
                    }

                    if (bool_2) {
                        final PacketNode packetnode_0 = class26.method433(ClientPacket.field2190, Game.field626.field1218);
                        packetnode_0.packetBuffer.addInt1(field3863.bitpack());
                        Game.field626.method1980(packetnode_0);
                        field3849 = 0L;
                    }
                }
            }
        } else {
            field3863 = null;
        }

    }

    void moveTowardZoomTarget() {
        if (class21.field175 != null) {
            worldMapZoom = worldMapZoomTarget;
        } else {
            if (worldMapZoom < worldMapZoomTarget) {
                worldMapZoom = Math.min(worldMapZoomTarget, (worldMapZoom / 30.0F) + worldMapZoom);
            }

            if (worldMapZoom > worldMapZoomTarget) {
                worldMapZoom = Math.max(worldMapZoomTarget, worldMapZoom - (worldMapZoom / 30.0F));
            }

        }
    }

    void moveTowardLocationTarget() {
        if (hasTargetPosition()) {
            int int_0 = worldMapTargetX - worldMapX;
            int int_1 = worldMapTargetY - worldMapY;
            if (int_0 != 0) {
                int_0 /= Math.min(8, Math.abs(int_0));
            }

            if (int_1 != 0) {
                int_1 /= Math.min(8, Math.abs(int_1));
            }

            setWorldMapPosition(int_0 + worldMapX, int_1 + worldMapY, true);
            if ((worldMapTargetX == worldMapX) && (worldMapTargetY == worldMapY)) {
                worldMapTargetX = -1;
                worldMapTargetY = -1;
            }

        }
    }

    void setWorldMapPosition(final int int_0, final int int_1, final boolean bool_0) {
        worldMapX = int_0;
        worldMapY = int_1;
        Buffer.safeCurrentTimeMillis();
        if (bool_0) {
            method6009();
        }

    }

    void method6009() {
        field3817 = -1;
        field3847 = -1;
        field3846 = -1;
        field3845 = -1;
    }

    boolean hasTargetPosition() {
        return (worldMapTargetX != -1) && (worldMapTargetY != -1);
    }

    public WorldMapData getWorldMapDataContainingCoord(final int int_0, final int int_1, final int int_2) {
        final Iterator iterator_0 = worldMapDataByIdentifier.values().iterator();

        WorldMapData worldmapdata_0;
        do {
            if (!iterator_0.hasNext()) {
                return null;
            }

            worldmapdata_0 = (WorldMapData) iterator_0.next();
        }
        while (!worldmapdata_0.containsCoord(int_0, int_1, int_2));

        return worldmapdata_0;
    }

    public void method6011(final int int_0, final int int_1, final int int_2, final boolean bool_0) {
        WorldMapData worldmapdata_0 = getWorldMapDataContainingCoord(int_0, int_1, int_2);
        if (worldmapdata_0 == null) {
            if (!bool_0) {
                return;
            }

            worldmapdata_0 = field3838;
        }

        boolean bool_1 = false;
        if ((worldmapdata_0 != field3826) || bool_0) {
            field3826 = worldmapdata_0;
            method6015(worldmapdata_0);
            bool_1 = true;
        }

        if (bool_1 || bool_0) {
            method6058(int_0, int_1, int_2);
        }

    }

    public void method6012(final int int_0) {
        final WorldMapData worldmapdata_0 = getWorldMapDataByFileId(int_0);
        if (worldmapdata_0 != null) {
            method6015(worldmapdata_0);
        }

    }

    public int method6153() {
        return worldMapData == null ? -1 : worldMapData.getFileId();
    }

    public WorldMapData method6014() {
        return worldMapData;
    }

    void method6015(final WorldMapData worldmapdata_0) {
        if ((worldMapData == null) || (worldmapdata_0 != worldMapData)) {
            initializeWorldMap(worldmapdata_0);
            method6058(-1, -1, -1);
        }
    }

    void initializeWorldMap(final WorldMapData worldmapdata_0) {
        worldMapData = worldmapdata_0;
        worldMapManager = new WorldMapManager(field3822, mapFonts);
        field3850.method5995(worldMapData.getIdentifier());
    }

    public void method6073(final WorldMapData worldmapdata_0, final Coordinates coordinates_0,
                           final Coordinates coordinates_1, final boolean bool_0) {
        if (worldmapdata_0 != null) {
            if ((worldMapData == null) || (worldmapdata_0 != worldMapData)) {
                initializeWorldMap(worldmapdata_0);
            }

            if (!bool_0 && worldMapData.containsCoord(coordinates_0.plane, coordinates_0.worldX, coordinates_0.worldY)) {
                method6058(coordinates_0.plane, coordinates_0.worldX, coordinates_0.worldY);
            } else {
                method6058(coordinates_1.plane, coordinates_1.worldX, coordinates_1.worldY);
            }

        }
    }

    void method6058(final int int_0, final int int_1, final int int_2) {
        if (worldMapData != null) {
            int[] ints_0 = worldMapData.method213(int_0, int_1, int_2);
            if (ints_0 == null) {
                ints_0 = worldMapData.method213(worldMapData.method218(), worldMapData.method217(),
                        worldMapData.method219());
            }

            setWorldMapPosition(ints_0[0] - (worldMapData.getMinX() * 64), ints_0[1] - (worldMapData.getMinY() * 64),
                    true);
            worldMapTargetX = -1;
            worldMapTargetY = -1;
            worldMapZoom = worldMapZoomPercentToFloat(worldMapData.getInitialMapSurfaceZoom());
            worldMapZoomTarget = worldMapZoom;
            field3860 = null;
            field3848 = null;
            worldMapManager.method482();
        }
    }

    public void extractWorldmap(final int int_0, final int int_1, final int int_2, final int int_3, final int int_4) {
        final int[] ints_0 = new int[4];
        Rasterizer2D.copyDrawRegion(ints_0);
        Rasterizer2D.setDrawRegion(int_0, int_1, int_2 + int_0, int_1 + int_3);
        Rasterizer2D.Rasterizer2D_fillRectangle(int_0, int_1, int_2, int_3, -16777216);
        final int int_5 = field3850.method5988();
        if (int_5 < 100) {
            method6024(int_0, int_1, int_2, int_3, int_5);
        } else {
            if (!worldMapManager.getLoaded()) {
                worldMapManager.load(field3828, worldMapData.getIdentifier(), Game.isMembers);
                if (!worldMapManager.getLoaded()) {
                    return;
                }
            }

            if (field3842 != null) {
                ++field3819;
                if ((field3819 % field3840) == 0) {
                    field3819 = 0;
                    ++field3855;
                }

                if ((field3855 >= field3857) && !field3841) {
                    field3842 = null;
                }
            }

            final int int_6 = (int) Math.ceil(int_2 / worldMapZoom);
            final int int_7 = (int) Math.ceil(int_3 / worldMapZoom);
            worldMapManager.drawMapRegion(worldMapX - (int_6 / 2), worldMapY - (int_7 / 2), (int_6 / 2) + worldMapX,
                    (int_7 / 2) + worldMapY, int_0, int_1, int_2 + int_0, int_1 + int_3);
            boolean bool_0;
            if (!field3854) {
                bool_0 = false;
                if ((int_4 - field3861) > 100) {
                    field3861 = int_4;
                    bool_0 = true;
                }

                worldMapManager.drawMapIcons(worldMapX - (int_6 / 2), worldMapY - (int_7 / 2), (int_6 / 2) + worldMapX,
                        (int_7 / 2) + worldMapY, int_0, int_1, int_2 + int_0, int_1 + int_3, field3856, field3842,
                        field3819, field3840, bool_0);
            }

            method6182(int_0, int_1, int_2, int_3, int_6, int_7);
            bool_0 = Game.rights >= 2;
            if (bool_0 && field3839 && (field3863 != null)) {
                field3820.method5522("Coord: " + field3863, Rasterizer2D.topX + 10,
                        Rasterizer2D.topY + 20, 16776960, -1);
            }

            worldMapDisplayWidth = int_6;
            worldMapDisplayHeight = int_7;
            worldMapDisplayX = int_0;
            worldMapDisplayY = int_1;
            Rasterizer2D.setDrawRegion(ints_0);
        }
    }

    boolean method6020(final int int_0, final int int_1, final int int_2, final int int_3, final int int_4,
                       final int int_5) {
        return field3865 == null || ((field3865.width != int_0) || (field3865.height != int_1) || (worldMapManager.field276 != field3866 || (field3869 != Game.field650 || ((int_2 > 0) || (int_3 > 0) || (((int_2 + int_0) < int_4) || ((int_1 + int_3) < int_5))))));
    }

    void method6182(final int int_0, final int int_1, final int int_2, final int int_3, final int int_4,
                    final int int_5) {
        if (class21.field175 != null) {
            final int int_6 = 512 / (worldMapManager.field276 * 2);
            int int_7 = int_2 + 512;
            int int_8 = int_3 + 512;
            final float float_0 = 1.0F;
            int_7 = (int) (int_7 / float_0);
            int_8 = (int) (int_8 / float_0);
            final int int_9 = method6002() - (int_4 / 2) - int_6;
            final int int_10 = method6035() - (int_5 / 2) - int_6;
            int int_11 = int_0 - (((int_6 + int_9) - field3811) * worldMapManager.field276);
            int int_12 = int_1 - (worldMapManager.field276 * (int_6 - (int_10 - field3868)));
            if (method6020(int_7, int_8, int_11, int_12, int_2, int_3)) {
                if ((field3865 != null) && (field3865.width == int_7) && (field3865.height == int_8)) {
                    Arrays.fill(field3865.pixels, 0);
                } else {
                    field3865 = new SpritePixels(int_7, int_8);
                }

                field3811 = method6002() - (int_4 / 2) - int_6;
                field3868 = method6035() - (int_5 / 2) - int_6;
                field3866 = worldMapManager.field276;
                class21.field175.method4776(field3811, field3868, field3865, field3866 / float_0);
                field3869 = Game.field650;
                int_11 = int_0 - (((int_6 + int_9) - field3811) * worldMapManager.field276);
                int_12 = int_1 - (worldMapManager.field276 * (int_6 - (int_10 - field3868)));
            }

            Rasterizer2D.fillRectangle(int_0, int_1, int_2, int_3, 0, 128);
            if (float_0 == 1.0F) {
                field3865.method5861(int_11, int_12, 192);
            } else {
                field3865.method5904(int_11, int_12, (int) (int_7 * float_0), (int) (float_0 * int_8), 192);
            }
        }

    }

    public void extractData(final int int_0, final int int_1, final int int_2, final int int_3) {
        if (field3850.method5987()) {
            if (!worldMapManager.getLoaded()) {
                worldMapManager.load(field3828, worldMapData.getIdentifier(), Game.isMembers);
                if (!worldMapManager.getLoaded()) {
                    return;
                }
            }

            worldMapManager.method486(int_0, int_1, int_2, int_3, field3842, field3819, field3840);
        }
    }

    public void method6023(final int int_0) {
        worldMapZoomTarget = worldMapZoomPercentToFloat(int_0);
    }

    void method6024(final int int_0, final int int_1, final int int_2, final int int_3, final int int_4) {
        final byte byte_0 = 20;
        final int int_5 = (int_2 / 2) + int_0;
        final int int_6 = ((int_3 / 2) + int_1) - 18 - byte_0;
        Rasterizer2D.Rasterizer2D_fillRectangle(int_0, int_1, int_2, int_3, -16777216);
        Rasterizer2D.drawRectangle(int_5 - 152, int_6, 304, 34, -65536);
        Rasterizer2D.Rasterizer2D_fillRectangle(int_5 - 150, int_6 + 2, int_4 * 3, 30, -65536);
        field3820.drawTextCentered("Loading...", int_5, byte_0 + int_6, -1, -1);
    }

    float worldMapZoomPercentToFloat(final int int_0) {
        return int_0 == 25 ? 1.0F
                : (int_0 == 37 ? 1.5F : (int_0 == 50 ? 2.0F : (int_0 == 75 ? 3.0F : (int_0 == 100 ? 4.0F : 8.0F))));
    }

    public int method6026() {
        return worldMapZoomTarget == 1.0D ? 25
                : (worldMapZoomTarget == 1.5D ? 37
                : (worldMapZoomTarget == 2.0D ? 50
                : (worldMapZoomTarget == 3.0D ? 75 : (worldMapZoomTarget == 4.0D ? 100 : 200))));
    }

    public void method6027() {
        field3850.method5985();
    }

    public boolean method6096() {
        return field3850.method5987();
    }

    public WorldMapData getWorldMapDataByFileId(final int int_0) {
        final Iterator iterator_0 = worldMapDataByIdentifier.values().iterator();

        WorldMapData worldmapdata_0;
        do {
            if (!iterator_0.hasNext()) {
                return null;
            }

            worldmapdata_0 = (WorldMapData) iterator_0.next();
        }
        while (worldmapdata_0.getFileId() != int_0);

        return worldmapdata_0;
    }

    public void setWorldMapPositionTarget(final int int_0, final int int_1) {
        if ((worldMapData != null) && worldMapData.surfaceContainsPosition(int_0, int_1)) {
            worldMapTargetX = int_0 - (worldMapData.getMinX() * 64);
            worldMapTargetY = int_1 - (worldMapData.getMinY() * 64);
        }
    }

    public void method6031(final int int_0, final int int_1) {
        if (worldMapData != null) {
            setWorldMapPosition(int_0 - (worldMapData.getMinX() * 64), int_1 - (worldMapData.getMinY() * 64), true);
            worldMapTargetX = -1;
            worldMapTargetY = -1;
        }
    }

    public void method6046(final int int_0, final int int_1, final int int_2) {
        if (worldMapData != null) {
            final int[] ints_0 = worldMapData.method213(int_0, int_1, int_2);
            if (ints_0 != null) {
                setWorldMapPositionTarget(ints_0[0], ints_0[1]);
            }

        }
    }

    public void method6033(final int int_0, final int int_1, final int int_2) {
        if (worldMapData != null) {
            final int[] ints_0 = worldMapData.method213(int_0, int_1, int_2);
            if (ints_0 != null) {
                method6031(ints_0[0], ints_0[1]);
            }

        }
    }

    public int method6002() {
        return worldMapData == null ? -1 : worldMapX + (worldMapData.getMinX() * 64);
    }

    public int method6035() {
        return worldMapData == null ? -1 : worldMapY + (worldMapData.getMinY() * 64);
    }

    public Coordinates method6001() {
        return worldMapData == null ? null : worldMapData.method205(method6002(), method6035());
    }

    public int method6142() {
        return worldMapDisplayWidth;
    }

    public int method6038() {
        return worldMapDisplayHeight;
    }

    public void method6089(final int int_0) {
        if (int_0 >= 1) {
            field3857 = int_0;
        }

    }

    public void method6040() {
        field3857 = 3;
    }

    public void method6041(final int int_0) {
        if (int_0 >= 1) {
            field3840 = int_0;
        }

    }

    public void method6042() {
        field3840 = 50;
    }

    public void method6034(final boolean bool_0) {
        field3841 = bool_0;
    }

    public void method6106(final int int_0) {
        field3842 = new HashSet();
        field3842.add(Integer.valueOf(int_0));
        field3855 = 0;
        field3819 = 0;
    }

    public void method6152(final int int_0) {
        field3842 = new HashSet();
        field3855 = 0;
        field3819 = 0;

        for (int int_1 = 0; int_1 < Area.mapAreaType.length; int_1++) {
            if ((Area.mapAreaType[int_1] != null) && (Area.mapAreaType[int_1].field3240 == int_0)) {
                field3842.add(Integer.valueOf(Area.mapAreaType[int_1].id));
            }
        }

    }

    public void method6114() {
        field3842 = null;
    }

    public void method6047(final boolean bool_0) {
        field3854 = !bool_0;
    }

    public void method6048(final int int_0, final boolean bool_0) {
        if (!bool_0) {
            field3853.add(Integer.valueOf(int_0));
        } else {
            field3853.remove(Integer.valueOf(int_0));
        }

        method6053();
    }

    public void method6049(final int int_0, final boolean bool_0) {
        if (!bool_0) {
            field3843.add(Integer.valueOf(int_0));
        } else {
            field3843.remove(Integer.valueOf(int_0));
        }

        for (int int_1 = 0; int_1 < Area.mapAreaType.length; int_1++) {
            if ((Area.mapAreaType[int_1] != null) && (Area.mapAreaType[int_1].field3240 == int_0)) {
                final int int_2 = Area.mapAreaType[int_1].id;
                if (!bool_0) {
                    field3844.add(Integer.valueOf(int_2));
                } else {
                    field3844.remove(Integer.valueOf(int_2));
                }
            }
        }

        method6053();
    }

    public boolean method6050() {
        return !field3854;
    }

    public boolean method6051(final int int_0) {
        return !field3853.contains(Integer.valueOf(int_0));
    }

    public boolean method6052(final int int_0) {
        return !field3843.contains(Integer.valueOf(int_0));
    }

    void method6053() {
        field3856.clear();
        field3856.addAll(field3853);
        field3856.addAll(field3844);
    }

    public void method6158(final int int_0, final int int_1, final int int_2, final int int_3, final int int_4,
                           final int int_5) {
        if (field3850.method5987()) {
            final int int_6 = (int) Math.ceil(int_2 / worldMapZoom);
            final int int_7 = (int) Math.ceil(int_3 / worldMapZoom);
            final List list_0 = worldMapManager.method487(worldMapX - (int_6 / 2) - 1, worldMapY - (int_7 / 2) - 1,
                    (int_6 / 2) + worldMapX + 1, (int_7 / 2) + worldMapY + 1, int_0, int_1, int_2, int_3, int_4, int_5);
            if (!list_0.isEmpty()) {
                final Iterator iterator_0 = list_0.iterator();

                boolean bool_0;
                do {
                    if (!iterator_0.hasNext()) {
                        return;
                    }

                    final MapIcon mapicon_0 = (MapIcon) iterator_0.next();
                    final Area area_0 = Area.mapAreaType[mapicon_0.areaId];
                    bool_0 = false;

                    for (int int_8 = field3859.length - 1; int_8 >= 0; --int_8) {
                        if (area_0.field3244[int_8] != null) {
                            class50.addMenuEntry(area_0.field3244[int_8], area_0.field3255, field3859[int_8],
                                    mapicon_0.areaId, mapicon_0.field243.bitpack(), mapicon_0.field236.bitpack());
                            bool_0 = true;
                        }
                    }
                }
                while (!bool_0);

            }
        }
    }

    public Coordinates method6100(final int int_0, final Coordinates coordinates_0) {
        if (!field3850.method5987()) {
            return null;
        } else if (!worldMapManager.getLoaded()) {
            return null;
        } else if (!worldMapData.surfaceContainsPosition(coordinates_0.worldX, coordinates_0.worldY)) {
            return null;
        } else {
            final HashMap hashmap_0 = worldMapManager.method489();
            final List list_0 = (List) hashmap_0.get(Integer.valueOf(int_0));
            if ((list_0 != null) && !list_0.isEmpty()) {
                MapIcon mapicon_0 = null;
                int int_1 = -1;
                final Iterator iterator_0 = list_0.iterator();

                while (true) {
                    MapIcon mapicon_1;
                    int int_4;
                    do {
                        if (!iterator_0.hasNext()) {
                            return mapicon_0.field236;
                        }

                        mapicon_1 = (MapIcon) iterator_0.next();
                        final int int_2 = mapicon_1.field236.worldX - coordinates_0.worldX;
                        final int int_3 = mapicon_1.field236.worldY - coordinates_0.worldY;
                        int_4 = (int_2 * int_2) + (int_3 * int_3);
                        if (int_4 == 0) {
                            return mapicon_1.field236;
                        }
                    }
                    while ((int_4 >= int_1) && (mapicon_0 != null));

                    mapicon_0 = mapicon_1;
                    int_1 = int_4;
                }
            } else {
                return null;
            }
        }
    }

    public void onMapClicked(final int int_0, final int int_1, final Coordinates coordinates_0,
                             final Coordinates coordinates_1) {
        final ScriptEvent scriptevent_0 = new ScriptEvent();
        final MapIconReference mapiconreference_0 = new MapIconReference(int_1, coordinates_0, coordinates_1);
        scriptevent_0.method1024(new Object[]{mapiconreference_0});
        switch (int_0) {
            case 1008:
                scriptevent_0.method1025(10);
                break;
            case 1009:
                scriptevent_0.method1025(11);
                break;
            case 1010:
                scriptevent_0.method1025(12);
                break;
            case 1011:
                scriptevent_0.method1025(13);
                break;
            case 1012:
                scriptevent_0.method1025(14);
        }

        class68.method1696(scriptevent_0);
    }

    public MapIcon method6146() {
        if (!field3850.method5987()) {
            return null;
        } else if (!worldMapManager.getLoaded()) {
            return null;
        } else {
            final HashMap hashmap_0 = worldMapManager.method489();
            field3860 = new LinkedList();
            final Iterator iterator_0 = hashmap_0.values().iterator();

            while (iterator_0.hasNext()) {
                final List list_0 = (List) iterator_0.next();
                field3860.addAll(list_0);
            }

            field3848 = field3860.iterator();
            return method6186();
        }
    }

    public MapIcon method6186() {
        return field3848 == null ? null : (!field3848.hasNext() ? null : (MapIcon) field3848.next());
    }

}
