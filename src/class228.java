public class class228 {

    public static final short[] field2582;
    public static final short[][] field2583;
    public static final short[] field2586;
    public static final short[][] field2585;

    static {
        field2582 = new short[]{(short) 6798, (short) 8741, (short) 25238, (short) 4626, (short) 4550};
        field2583 = new short[][]{
                {(short) 6798, (short) 107, (short) 10283, (short) 16, (short) 4797, (short) 7744, (short) 5799,
                        (short) 4634, (short) -31839, (short) 22433, (short) 2983, (short) -11343, (short) 8,
                        (short) 5281, (short) 10438, (short) 3650, (short) -27322, (short) -21845, (short) 200,
                        (short) 571, (short) 908, (short) 21830, (short) 28946, (short) -15701, (short) -14010},
                {(short) 8741, (short) 12, (short) -1506, (short) -22374, (short) 7735, (short) 8404, (short) 1701,
                        (short) -27106, (short) 24094, (short) 10153, (short) -8915, (short) 4783, (short) 1341,
                        (short) 16578, (short) -30533, (short) 25239, (short) 8, (short) 5281, (short) 10438,
                        (short) 3650, (short) -27322, (short) -21845, (short) 200, (short) 571, (short) 908,
                        (short) 21830, (short) 28946, (short) -15701, (short) -14010},
                {(short) 25238, (short) 8742, (short) 12, (short) -1506, (short) -22374, (short) 7735, (short) 8404,
                        (short) 1701, (short) -27106, (short) 24094, (short) 10153, (short) -8915, (short) 4783,
                        (short) 1341, (short) 16578, (short) -30533, (short) 8, (short) 5281, (short) 10438,
                        (short) 3650, (short) -27322, (short) -21845, (short) 200, (short) 571, (short) 908,
                        (short) 21830, (short) 28946, (short) -15701, (short) -14010},
                {(short) 4626, (short) 11146, (short) 6439, (short) 12, (short) 4758, (short) 10270},
                {(short) 4550, (short) 4537, (short) 5681, (short) 5673, (short) 5790, (short) 6806, (short) 8076,
                        (short) 4574, (short) 17050, (short) 0, (short) 127, (short) -31821, (short) 28383, (short) -18000}};
        field2586 = new short[]{(short) -10304, (short) 9104, (short) -1, (short) -1, (short) -1};
        field2585 = new short[][]{
                {(short) 6554, (short) 115, (short) 10304, (short) 28, (short) 5702, (short) 7756, (short) 5681,
                        (short) 4510, (short) -31835, (short) 22437, (short) 2859, (short) -11339, (short) 16,
                        (short) 5157, (short) 10446, (short) 3658, (short) -27314, (short) -21965, (short) 472,
                        (short) 580, (short) 784, (short) 21966, (short) 28950, (short) -15697, (short) -14002},
                {(short) 9104, (short) 10275, (short) 7595, (short) 3610, (short) 7975, (short) 8526, (short) 918,
                        (short) -26734, (short) 24466, (short) 10145, (short) -6882, (short) 5027, (short) 1457,
                        (short) 16565, (short) -30545, (short) 25486, (short) 24, (short) 5392, (short) 10429,
                        (short) 3673, (short) -27335, (short) -21957, (short) 192, (short) 687, (short) 412,
                        (short) 21821, (short) 28835, (short) -15460, (short) -14019},
                new short[0], new short[0], new short[0]};
    }

    static int method4495(int int_0, final Script script_0, final boolean bool_0) {
        Widget widget_0;
        if (int_0 >= 2000) {
            int_0 -= 1000;
            widget_0 = Widget.getWidget(class69.intStack[--class69.intStackSize]);
        } else {
            widget_0 = bool_0 ? class276.field3561 : KitDefinition.field3301;
        }

        String string_0 = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
        int[] ints_0 = null;
        if ((string_0.length() > 0) && (string_0.charAt(string_0.length() - 1) == 89)) {
            int int_1 = class69.intStack[--class69.intStackSize];
            if (int_1 > 0) {
                for (ints_0 = new int[int_1]; int_1-- > 0; ints_0[int_1] = class69.intStack[--class69.intStackSize]) {
                }
            }

            string_0 = string_0.substring(0, string_0.length() - 1);
        }

        Object[] objects_0 = new Object[string_0.length() + 1];

        int int_2;
        for (int_2 = objects_0.length - 1; int_2 >= 1; --int_2) {
            if (string_0.charAt(int_2 - 1) == 115) {
                objects_0[int_2] = class69.scriptStringStack[--WidgetNode.scriptStringStackSize];
            } else {
                objects_0[int_2] = new Integer(class69.intStack[--class69.intStackSize]);
            }
        }

        int_2 = class69.intStack[--class69.intStackSize];
        if (int_2 != -1) {
            objects_0[0] = new Integer(int_2);
        } else {
            objects_0 = null;
        }

        if (int_0 == 1400) {
            widget_0.onClickListener = objects_0;
        } else if (int_0 == 1401) {
            widget_0.onHoldListener = objects_0;
        } else if (int_0 == 1402) {
            widget_0.onReleaseListener = objects_0;
        } else if (int_0 == 1403) {
            widget_0.onMouseOverListener = objects_0;
        } else if (int_0 == 1404) {
            widget_0.onMouseLeaveListener = objects_0;
        } else if (int_0 == 1405) {
            widget_0.onDragListener = objects_0;
        } else if (int_0 == 1406) {
            widget_0.onTargetLeaveListener = objects_0;
        } else if (int_0 == 1407) {
            widget_0.onVarTransmitListener = objects_0;
            widget_0.varTransmitTriggers = ints_0;
        } else if (int_0 == 1408) {
            widget_0.onTimerListener = objects_0;
        } else if (int_0 == 1409) {
            widget_0.onOpListener = objects_0;
        } else if (int_0 == 1410) {
            widget_0.onDragCompleteListener = objects_0;
        } else if (int_0 == 1411) {
            widget_0.onClickRepeatListener = objects_0;
        } else if (int_0 == 1412) {
            widget_0.onMouseRepeatListener = objects_0;
        } else if (int_0 == 1414) {
            widget_0.onInvTransmitListener = objects_0;
            widget_0.invTransmitTriggers = ints_0;
        } else if (int_0 == 1415) {
            widget_0.onStatTransmitListener = objects_0;
            widget_0.statTransmitTriggers = ints_0;
        } else if (int_0 == 1416) {
            widget_0.onTargetEnterListener = objects_0;
        } else if (int_0 == 1417) {
            widget_0.onScrollWheelListener = objects_0;
        } else if (int_0 == 1418) {
            widget_0.onChatTransmitListener = objects_0;
        } else if (int_0 == 1419) {
            widget_0.onKeyListener = objects_0;
        } else if (int_0 == 1420) {
            widget_0.onFriendTransmitListener = objects_0;
        } else if (int_0 == 1421) {
            widget_0.onClanTransmitListener = objects_0;
        } else if (int_0 == 1422) {
            widget_0.onMiscTransmitListener = objects_0;
        } else if (int_0 == 1423) {
            widget_0.onDialogAbortListener = objects_0;
        } else if (int_0 == 1424) {
            widget_0.onSubChangeListener = objects_0;
        } else if (int_0 == 1425) {
            widget_0.onStockTransmitListener = objects_0;
        } else if (int_0 == 1426) {
            widget_0.onCamFinishedListener = objects_0;
        } else {
            if (int_0 != 1427) {
                return 2;
            }

            widget_0.onResizeListener = objects_0;
        }

        widget_0.hasListener = true;
        return 1;
    }

    static boolean method4494(final int int_0, final int int_1, final int int_2, final int int_3, final int int_4,
                              final int int_5, final int int_6) {
        int int_7 = class120.Viewport_mouseY + int_6;
        if ((int_7 < int_0) && (int_7 < int_1) && (int_7 < int_2)) {
            return false;
        } else {
            int_7 = class120.Viewport_mouseY - int_6;
            if ((int_7 > int_0) && (int_7 > int_1) && (int_7 > int_2)) {
                return false;
            } else {
                int_7 = class120.Viewport_mouseX + int_6;
                if ((int_7 < int_3) && (int_7 < int_4) && (int_7 < int_5)) {
                    return false;
                } else {
                    int_7 = class120.Viewport_mouseX - int_6;
                    return (int_7 <= int_3) || (int_7 <= int_4) || (int_7 <= int_5);
                }
            }
        }
    }

}
