import java.io.File;
import java.io.RandomAccessFile;

public final class GraphicsObject extends Renderable {

    static long field1013;
    int height;
    int id;
    int startCycle;
    int level;
    int x;
    int y;
    Sequence field1018;
    int field1019;
    int field1020;
    boolean finished;

    GraphicsObject(final int int_0, final int int_1, final int int_2, final int int_3, final int int_4, final int int_5,
                   final int int_6) {
        field1019 = 0;
        field1020 = 0;
        finished = false;
        id = int_0;
        level = int_1;
        x = int_2;
        y = int_3;
        height = int_4;
        startCycle = int_6 + int_5;
        final int int_7 = MouseRecorder.getSpotAnimType(id).animationId;
        if (int_7 != -1) {
            finished = false;
            field1018 = TotalQuantityComparator.getAnimation(int_7);
        } else {
            finished = true;
        }

    }

    void method1771(final int int_0) {
        if (!finished) {
            field1020 += int_0;

            while (field1020 > field1018.frameLengths[field1019]) {
                field1020 -= field1018.frameLengths[field1019];
                ++field1019;
                if (field1019 >= field1018.frameIDs.length) {
                    finished = true;
                    break;
                }
            }

        }
    }

    @Override
    protected Model getModel() {
        final Spotanim spotanim_0 = MouseRecorder.getSpotAnimType(id);
        Model model_0;
        if (!finished) {
            model_0 = spotanim_0.getModel(field1019);
        } else {
            model_0 = spotanim_0.getModel(-1);
        }

        return model_0;
    }

    static boolean method1766(final File file_0, final boolean bool_0) {
        try {
            final RandomAccessFile randomaccessfile_0 = new RandomAccessFile(file_0, "rw");
            final int int_0 = randomaccessfile_0.read();
            randomaccessfile_0.seek(0L);
            randomaccessfile_0.write(int_0);
            randomaccessfile_0.seek(0L);
            randomaccessfile_0.close();
            if (bool_0) {
                file_0.delete();
            }

            return true;
        } catch (final Exception exception_0) {
            return false;
        }
    }

    static int method1768(int int_0, final Script script_0, final boolean bool_0) {
        Widget widget_0;
        if (int_0 >= 2000) {
            int_0 -= 1000;
            widget_0 = Widget.getWidget(class69.intStack[--class69.intStackSize]);
        } else {
            widget_0 = bool_0 ? class276.field3561 : KitDefinition.field3301;
        }

        Player.method1114(widget_0);
        if ((int_0 != 1200) && (int_0 != 1205) && (int_0 != 1212)) {
            if (int_0 == 1201) {
                widget_0.modelType = 2;
                widget_0.modelId = class69.intStack[--class69.intStackSize];
                return 1;
            } else if (int_0 == 1202) {
                widget_0.modelType = 3;
                widget_0.modelId = class138.localPlayer.composition.method4483();
                return 1;
            } else {
                return 2;
            }
        } else {
            class69.intStackSize -= 2;
            int int_1 = class69.intStack[class69.intStackSize];
            int int_2 = class69.intStack[class69.intStackSize + 1];
            widget_0.itemId = int_1;
            widget_0.itemQuantity = int_2;

            // duel arena interface platinum/coins changed to blood money/bloody tokens

            if(WorldType.isPVP()) {
                //platinum tokens
                if(widget_0.interfaceHash == 31522838 && widget_0.itemId == 13204) {
                    int_1 = 13215;
                    widget_0.itemId = 13215;
                }
                if(widget_0.interfaceHash == 31522905 && widget_0.itemId == 13204) {
                    int_1 = 13215;
                    widget_0.itemId = 13215;
                }

                if(widget_0.interfaceHash == 31195216 && widget_0.itemId == 13204) {
                    int_1 = 13215;
                    widget_0.itemId = 13215;
                }

                if(widget_0.interfaceHash == 31195225 && widget_0.itemId == 13204) {
                    int_1 = 13215;
                    widget_0.itemId = 13215;
                }

                //gold
                if(widget_0.interfaceHash == 31522902 && widget_0.itemId == 995) {
                    int_1 = 13307;
                    widget_0.itemId = 13307;
                }

                if(widget_0.interfaceHash == 31522909 &&  widget_0.itemId == 995) {
                    int_1 = 13307;
                    widget_0.itemId = 13307;
                }
                if(widget_0.interfaceHash == 31195221 &&  widget_0.itemId == 995) {
                    int_1 = 13307;
                    widget_0.itemId = 13307;
                }
                if(widget_0.interfaceHash == 31195230 &&  widget_0.itemId == 995) {
                    int_1 = 13307;
                    widget_0.itemId = 13307;
                }
            }

            final ItemComposition itemcomposition_0 = TextureProvider.getItemDefinition(int_1);
            ShopInterface.updateItem(widget_0, itemcomposition_0);
            widget_0.rotationX = itemcomposition_0.xan2d;
            widget_0.rotationZ = itemcomposition_0.yan2d;
            widget_0.rotationY = itemcomposition_0.zan2d;
            widget_0.offsetX2d = itemcomposition_0.offsetX2d;
            widget_0.offsetY2d = itemcomposition_0.offsetY2d;
            widget_0.modelZoom = itemcomposition_0.zoom2d;
            if (int_0 == 1205) {
                widget_0.itemAmountSetting = 0;
            } else if ((int_0 == 1212) | (itemcomposition_0.isStackable == 1)) {
                widget_0.itemAmountSetting = 1;
            } else {
                widget_0.itemAmountSetting = 2;
            }

            if (widget_0.field2660 > 0) {
                widget_0.modelZoom = (widget_0.modelZoom * 32) / widget_0.field2660;
            } else if (widget_0.originalWidth > 0) {
                widget_0.modelZoom = (widget_0.modelZoom * 32) / widget_0.originalWidth;
            }

            return 1;
        }
    }

}
