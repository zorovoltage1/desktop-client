public class TextureProvider implements ITextureLoader {

    static SpritePixels[] mapMarkers;
    Texture[] textures;
    Deque deque;
    int maxSize;
    int size;
    double brightness;
    int width;
    IndexDataBase sprites;

    public TextureProvider(final IndexDataBase indexdatabase_0, final IndexDataBase indexdatabase_1, final int int_0,
                           final double double_0, final int int_1) {
        deque = new Deque();
        size = 0;
        brightness = 1.0D;
        width = 128;
        sprites = indexdatabase_1;
        maxSize = int_0;
        size = maxSize;
        brightness = double_0;
        width = int_1;
        final int[] ints_0 = indexdatabase_0.getChilds(0);
        final int int_2 = ints_0.length;
        textures = new Texture[indexdatabase_0.fileCount(0)];

        for (int int_3 = 0; int_3 < int_2; int_3++) {
            final Buffer buffer_0 = new Buffer(indexdatabase_0.getConfigData(0, ints_0[int_3]));
            textures[ints_0[int_3]] = new Texture(buffer_0);
        }

    }

    public int method2530() {
        int int_0 = 0;
        int int_1 = 0;
        final Texture[] textures_0 = textures;

        for (int int_2 = 0; int_2 < textures_0.length; int_2++) {
            final Texture texture_0 = textures_0[int_2];
            if ((texture_0 != null) && (texture_0.fileIds != null)) {
                int_0 += texture_0.fileIds.length;
                final int[] ints_0 = texture_0.fileIds;

                for (int int_3 = 0; int_3 < ints_0.length; int_3++) {
                    final int int_4 = ints_0[int_3];
                    if (sprites.method4627(int_4)) {
                        ++int_1;
                    }
                }
            }
        }

        if (int_0 == 0) {
            return 0;
        } else {
            return (int_1 * 100) / int_0;
        }
    }

    public void brightness(final double double_0) {
        brightness = double_0;
        reset();
    }

    @Override
    public int[] load(final int int_0) {
        final Texture texture_0 = textures[int_0];
        if (texture_0 != null) {
            if (texture_0.pixels != null) {
                deque.addTail(texture_0);
                texture_0.loaded = true;
                return texture_0.pixels;
            }

            final boolean bool_0 = texture_0.method2661(brightness, width, sprites);
            if (bool_0) {
                if (size == 0) {
                    final Texture texture_1 = (Texture) deque.popTail();
                    texture_1.resetPixels();
                } else {
                    --size;
                }

                deque.addTail(texture_0);
                texture_0.loaded = true;
                return texture_0.pixels;
            }
        }

        return null;
    }

    @Override
    public int getAverageTextureRGB(final int int_0) {
        return textures[int_0] != null ? textures[int_0].field1527 : 0;
    }

    @Override
    public boolean vmethod3081(final int int_0) {
        return textures[int_0].field1530;
    }

    @Override
    public boolean vmethod3082(final int int_0) {
        return width == 64;
    }

    public void reset() {
        for (int int_0 = 0; int_0 < textures.length; int_0++) {
            if (textures[int_0] != null) {
                textures[int_0].resetPixels();
            }
        }

        deque = new Deque();
        size = maxSize;
    }

    public void checkTextures(final int int_0) {
        for (int int_1 = 0; int_1 < textures.length; int_1++) {
            final Texture texture_0 = textures[int_1];
            if ((texture_0 != null) && (texture_0.field1537 != 0) && texture_0.loaded) {
                texture_0.method2657(int_0);
                texture_0.loaded = false;
            }
        }

    }

    public static ItemComposition getItemDefinition(final int int_0) {
        ItemComposition itemcomposition_0 = (ItemComposition) ItemComposition.items.get(int_0);
        if (itemcomposition_0 != null) {
            return itemcomposition_0;
        } else {
            final byte[] bytes_0 = ItemComposition.item_ref.getConfigData(10, int_0);
            itemcomposition_0 = new ItemComposition();
            itemcomposition_0.id = int_0;
            if (bytes_0 != null) {
                itemcomposition_0.loadBuffer(new Buffer(bytes_0));
                itemcomposition_0.postDecode();
                itemcomposition_0.populateBloodMoneyValue();
            }

            itemcomposition_0.post();
            if (itemcomposition_0.notedTemplate != -1) {
                itemcomposition_0.updateNote(getItemDefinition(itemcomposition_0.notedTemplate),
                        getItemDefinition(itemcomposition_0.note));
            }

            if (itemcomposition_0.notedId != -1) {
                itemcomposition_0.method5110(getItemDefinition(itemcomposition_0.notedId),
                        getItemDefinition(itemcomposition_0.unnotedId));
            }

            if (itemcomposition_0.placeholderTemplateId != -1) {
                itemcomposition_0.method5091(getItemDefinition(itemcomposition_0.placeholderTemplateId),
                        getItemDefinition(itemcomposition_0.placeholderId));
            }

            if (!ItemComposition.isMembersWorld && itemcomposition_0.isMembers) {
                itemcomposition_0.name = "Members object";
                itemcomposition_0.isTradable = false;
                itemcomposition_0.groundActions = null;
                itemcomposition_0.inventoryActions = null;
                itemcomposition_0.shiftClickIndex = -1;
                itemcomposition_0.team = 0;
                if (itemcomposition_0.params != null) {
                    boolean bool_0 = false;

                    for (Node node_0 = itemcomposition_0.params
                            .getHead(); node_0 != null; node_0 = itemcomposition_0.params.getTail()) {
                        final class264 class264_0 = class241.method4603((int) node_0.hash);
                        if (class264_0.field3332) {
                            node_0.unlink();
                        } else {
                            bool_0 = true;
                        }
                    }

                    if (!bool_0) {
                        itemcomposition_0.params = null;
                    }
                }
            }

            ItemComposition.items.put(itemcomposition_0, int_0);
            return itemcomposition_0;
        }
    }

    static void method2562() {
        class81.playerIndexesCount = 0;

        for (int int_0 = 0; int_0 < 2048; int_0++) {
            class81.field1157[int_0] = null;
            class81.field1153[int_0] = 1;
        }

    }

    static int method2531(final int int_0, final Script script_0, final boolean bool_0) {
        if (int_0 == 5630) {
            Game.field627 = 250;
            return 1;
        } else {
            return 2;
        }
    }

}
