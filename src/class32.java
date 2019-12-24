public class class32 {

	int field282;
	int field287;
	int[][] field283;
	int[][] field281;
	int[][] field285;
	int[][] field286;

	class32(final int int_0, final int int_1) {
		field282 = int_0;
		field287 = int_1;
		field283 = new int[int_0][int_1];
		field281 = new int[int_0][int_1];
		field285 = new int[int_0][int_1];
		field286 = new int[int_0][int_1];
	}

	void method541(final int int_0, final int int_1, final int int_2,
			final FloorUnderlayDefinition floorunderlaydefinition_0) {
		if (floorunderlaydefinition_0 != null) {
			if (((int_2 + int_0) >= 0) && ((int_2 + int_1) >= 0)) {
				if (((int_0 - int_2) <= field282) && ((int_1 - int_2) <= field287)) {
					final int int_3 = Math.max(0, int_0 - int_2);
					final int int_4 = Math.min(field282, int_2 + int_0);
					final int int_5 = Math.max(0, int_1 - int_2);
					final int int_6 = Math.min(field287, int_2 + int_1);

					for (int int_7 = int_3; int_7 < int_4; int_7++) {
						for (int int_8 = int_5; int_8 < int_6; int_8++) {
							field283[int_7][int_8] += (floorunderlaydefinition_0.hue * 256)
									/ floorunderlaydefinition_0.hueMultiplier;
							field281[int_7][int_8] += floorunderlaydefinition_0.saturation;
							field285[int_7][int_8] += floorunderlaydefinition_0.lightness;
							++field286[int_7][int_8];
						}
					}

				}
			}
		}
	}

	int method547(final int int_0, final int int_1) {
		if ((int_0 >= 0) && (int_1 >= 0) && (int_0 < field282) && (int_1 < field287)) {
			if (field285[int_0][int_1] == 0) {
				return 0;
			} else {
				final int int_2 = field283[int_0][int_1] / field286[int_0][int_1];
				final int int_3 = field281[int_0][int_1] / field286[int_0][int_1];
				final int int_4 = field285[int_0][int_1] / field286[int_0][int_1];
				return class143.method3167(int_2 / 256.0D, int_3 / 256.0D, int_4 / 256.0D);
			}
		} else {
			return 0;
		}
	}

	static int method540(final int int_0, final Script script_0, final boolean bool_0) {
		int int_1;
		int int_2;
		if (int_0 == 100) {
			class69.intStackSize -= 3;
			int_1 = class69.intStack[class69.intStackSize];
			int_2 = class69.intStack[class69.intStackSize + 1];
			final int int_3 = class69.intStack[class69.intStackSize + 2];
			if (int_2 == 0) {
				throw new RuntimeException();
			} else {
				final Widget widget_2 = Widget.getWidget(int_1);
				if (widget_2.children == null) {
					widget_2.children = new Widget[int_3 + 1];
				}

				if (widget_2.children.length <= int_3) {
					final Widget[] widgets_0 = new Widget[int_3 + 1];

					for (int int_4 = 0; int_4 < widget_2.children.length; int_4++) {
						widgets_0[int_4] = widget_2.children[int_4];
					}

					widget_2.children = widgets_0;
				}

				if ((int_3 > 0) && (widget_2.children[int_3 - 1] == null)) {
					throw new RuntimeException("" + (int_3 - 1));
				} else {
					final Widget widget_4 = new Widget();
					widget_4.type = int_2;
					widget_4.parentHash = widget_4.interfaceHash = widget_2.interfaceHash;
					widget_4.index = int_3;
					widget_4.hasScript = true;
					widget_2.children[int_3] = widget_4;
					if (bool_0) {
						class276.field3561 = widget_4;
					} else {
						KitDefinition.field3301 = widget_4;
					}

					Player.method1114(widget_2);
					return 1;
				}
			}
		} else {
			Widget widget_0;
			if (int_0 == 101) {
				widget_0 = bool_0 ? class276.field3561 : KitDefinition.field3301;
				final Widget widget_1 = Widget.getWidget(widget_0.interfaceHash);
				widget_1.children[widget_0.index] = null;
				Player.method1114(widget_1);
				return 1;
			} else if (int_0 == 102) {
				widget_0 = Widget.getWidget(class69.intStack[--class69.intStackSize]);
				widget_0.children = null;
				Player.method1114(widget_0);
				return 1;
			} else if (int_0 != 200) {
				if (int_0 == 201) {
					widget_0 = Widget.getWidget(class69.intStack[--class69.intStackSize]);
					if (widget_0 != null) {
						class69.intStack[++class69.intStackSize - 1] = 1;
						if (bool_0) {
							class276.field3561 = widget_0;
						} else {
							KitDefinition.field3301 = widget_0;
						}
					} else {
						class69.intStack[++class69.intStackSize - 1] = 0;
					}

					return 1;
				} else {
					return 2;
				}
			} else {
				class69.intStackSize -= 2;
				int_1 = class69.intStack[class69.intStackSize];
				int_2 = class69.intStack[class69.intStackSize + 1];
				final Widget widget_3 = class146.getWidgetChild(int_1, int_2);
				if ((widget_3 != null) && (int_2 != -1)) {
					class69.intStack[++class69.intStackSize - 1] = 1;
					if (bool_0) {
						class276.field3561 = widget_3;
					} else {
						KitDefinition.field3301 = widget_3;
					}
				} else {
					class69.intStack[++class69.intStackSize - 1] = 0;
				}

				return 1;
			}
		}
	}

	static int getSmoothNoise(final int int_0, final int int_1, final int int_2) {
		final int int_3 = int_0 / int_2;
		final int int_4 = int_0 & (int_2 - 1);
		final int int_5 = int_1 / int_2;
		final int int_6 = int_1 & (int_2 - 1);
		final int int_7 = AbstractByteBuffer.getSmoothNoise2D(int_3, int_5);
		final int int_8 = AbstractByteBuffer.getSmoothNoise2D(int_3 + 1, int_5);
		final int int_9 = AbstractByteBuffer.getSmoothNoise2D(int_3, int_5 + 1);
		final int int_10 = AbstractByteBuffer.getSmoothNoise2D(int_3 + 1, int_5 + 1);
		final int int_11 = SceneTilePaint.method2870(int_7, int_8, int_4, int_2);
		final int int_12 = SceneTilePaint.method2870(int_9, int_10, int_4, int_2);
		return SceneTilePaint.method2870(int_11, int_12, int_6, int_2);
	}

	static void method548(final IndexData indexdata_0, final String string_0) {
		final class52 class52_0 = new class52(indexdata_0, string_0);
		Game.field781.add(class52_0);
	}

}
