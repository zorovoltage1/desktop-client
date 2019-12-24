import netscape.javascript.JSObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public final class Game extends GameEngine implements class288 {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public static DiscordPresence DISCORD_PRESENCE = new DiscordPresence();
    static int widgetCount;
    static int field830;
    static long field791;
    static boolean[] field697;
    static boolean[] field723;
    static boolean[] field788;
    static boolean field772;
    static int cycleCntr;
    static boolean isResized;
    static int field647;
    public static int field650;
    static boolean field601;
    static boolean field813;
    static int field753;
    static int field749;
    static int field757;
    static HashTable widgetFlags;
    static Widget field752;
    static int gameDrawingMode;
    static int[] widgetPositionX;
    static int[] widgetBoundsWidth;
    static int field758;
    static int[] widgetPositionY;
    static int[] widgetBoundsHeight;
    static final class59 field849;
    static Deque field638;
    static int field696;
    static int field760;
    static int field815;
    static int field812;
    static int[] field850;
    static int[] field596;
    static int[] interfaceItemTriggers;
    static int field767;
    static boolean draggingWidget;
    static long[] field797;
    static int pendingVarbitCount;
    static int field651;
    static int field810;
    static int field842;
    static long field722;
    static boolean field822;
    static PlayerComposition customizedAppearance;
    static int mouseWheelRotation;
    static int queuedSoundEffectCount;
    static int[] unknownSoundValues2;
    static int field814;
    static int destinationX;
    static int field586;
    static Widget draggedOnWidget;
    static int destinationY;
    static int field798;
    static int[] queuedSoundEffectIDs;
    static int field811;
    static SoundEffect[] audioEffects;
    static int[] unknownSoundValues1;
    static int[] soundLocations;
    static int mapIconCount;
    static ArrayList field781;
    static boolean[] field823;
    static int field606;
    static int[] field824;
    static int[] field825;
    static int[] field826;
    static int[] field705;
    static SpritePixels[] mapIcons;
    static int[] mapIconTileX;
    static int[] mapIconTileY;
    static int field775;
    static int field799;
    static int Viewport_xOffset;
    static int Viewport_yOffset;
    static int viewportWidth;
    static int viewportHeight;
    static short minFov;
    static short maxFov;
    static int[] field773;
    static int[] field800;
    static Deque field778;
    static short field834;
    static short field835;
    static int chatCycle;
    static short field833;
    static Deque field779;
    static short minZoom;
    static short maxZoom;
    static short field832;
    static int field828;
    static int scale;
    static int[] pendingVarbitChanges;
    static int[] changedSkills;
    static int changedSkillsCount;
    static GrandExchangeOffer[] grandExchangeOffers;
    static int field793;
    static int field795;
    static int publicChatMode;
    static int field774;
    static String field796;
    static OwnWorldComparator field665;
    static int[] field731;
    static CollisionData[] collisionMaps;
    static boolean field580;
    public static int world;
    static int flags;
    static int socketType;
    public static boolean isMembers;
    static boolean lowMemory;
    static int languageId;
    static int field587;
    static boolean field588;
    static int gameState;
    static boolean field625;
    static int gameCycle;
    static long mouseLastLastPressedTimeMillis;
    static int field593;
    static int field594;
    static int field595;
    static boolean field847;
    static boolean displayFps;
    static int field598;
    static int hintArrowTargetType;
    static int hintArrowNpcTargetIdx;
    static int hintArrowPlayerTargetIdx;
    static int hintArrowX;
    static int hintArrowY;
    static int hintArrowOffsetZ;
    static int hintArrowOffsetX;
    static int hintArrowOffsetY;
    static AttackOption playerAttackOption;
    static AttackOption npcAttackOption;
    static int loadingStage;
    static Task socket;
    static class157 rssocket;
    static int js5State;
    static int field768;
    static IndexData indexScripts;
    static int field614;
    static int loginState;
    static int field616;
    static int field617;
    static int field618;
    static class146 field619;
    static byte[] field620;
    static NPC[] cachedNPCs;
    static int npcIndexesCount;
    static int[] npcIndices;
    static int pendingNpcFlagsCount;
    static int[] pendingNpcFlagsIndices;
    public static final NetWriter field626;
    static int field627;
    static boolean socketError;
    static boolean field629;
    static class280 field804;
    static HashMap fontsMap;
    static int baseY;
    static int field633;
    static int field634;
    static int field635;
    static int field636;
    static int field751;
    static boolean isDynamicRegion;
    static int[][][] instanceTemplateChunks;
    static final int[] field846;
    static int field700;
    static int field643;
    static int field584;
    static int field836;
    static int field646;
    static boolean field746;
    static int field660;
    static int cameraPitchTarget;
    static int mapAngle;
    static int field608;
    static int field652;
    static int field653;
    static int field654;
    static int field655;
    static int field644;
    static int field657;
    static int field613;
    static int field659;
    static int field750;
    static int field661;
    static int field853;
    static boolean field663;
    static int field664;
    static boolean field807;
    static int field738;
    static int overheadTextCount;
    static int field648;
    static int[] overheadTextsX;
    static int[] overheadTextsY;
    static int[] overheadTextsOffsetY;
    static int[] overheadTextsOffsetX;
    static int[] field673;
    static int[] field674;
    static int[] overheadTextsCyclesRemaining;
    static String[] overheadTexts;
    static int[][] field761;
    static int field687;
    static int screenX;
    static int screenY;
    static int lastLeftClickX;
    static int lastLeftClickY;
    static int field803;
    static int cursorState;
    static boolean field621;
    static int mouseCrosshair;
    static int pressedItemIndex;
    static int field688;
    static int field678;
    static int field821;
    static int field691;
    static boolean field689;
    static int itemPressedDuration;
    static int myPlayerIndex;
    static boolean field677;
    static Player[] cachedPlayers;
    static String lastSelectedItemName;
    static int localInteractingIndex;
    static int field698;
    static boolean field699;
    static int playerNameMask;
    static int field701;
    static int[] field702;
    static final int[] playerMenuTypes;
    static String[] playerOptions;
    static boolean[] playerOptionsPriorities;
    static int[] field706;
    static int field707;
    static Deque[][][] groundItemDeque;
    static Deque pendingSpawns;
    static Deque projectiles;
    static Deque graphicsObjectDeque;
    static int[] boostedSkillLevels;
    static int[] realSkillLevels;
    static int[] skillExperiences;
    static int field715;
    static boolean isMenuOpen;
    static int menuOptionCount;
    static int[] menuActionParams0;
    static int[] menuActionParams1;
    static int[] menuTypes;
    static int[] menuIdentifiers;
    static String[] menuOptions;
    static String[] menuTargets;
    static boolean[] menuBooleanArray;
    static boolean field725;
    static boolean field726;
    static boolean field727;
    static boolean field728;
    static int field729;
    static int field730;
    static int field623;
    static int field732;
    static int itemSelectionState;
    static boolean spellSelected;
    static int field736;
    static int field737;
    static String field612;
    static String field739;
    static int widgetRoot;
    static HashTable componentTable;
    static int field742;
    static int field743;
    static Widget field744;
    static int energy;
    static int weight;
    public static int rights;
    static int field748;
    static boolean field776;
    static Widget field784;
    static Widget draggedWidget;

    static {
        field580 = true;
        world = 1;
        flags = 0;
        socketType = 0;
        isMembers = false;
        lowMemory = false;
        languageId = 0;
        field587 = -1;
        field588 = false;
        gameState = 0;
        field625 = true;
        gameCycle = 0;
        mouseLastLastPressedTimeMillis = 1L;
        field593 = -1;
        field594 = -1;
        field595 = -1;
        field847 = true;
        displayFps = false;
        field598 = 0;
        hintArrowTargetType = 0;
        hintArrowNpcTargetIdx = 0;
        hintArrowPlayerTargetIdx = 0;
        hintArrowX = 0;
        hintArrowY = 0;
        hintArrowOffsetZ = 0;
        hintArrowOffsetX = 0;
        hintArrowOffsetY = 0;
        playerAttackOption = AttackOption.AttackOption_hidden;
        npcAttackOption = AttackOption.AttackOption_hidden;
        loadingStage = 0;
        js5State = 0;
        field768 = 0;
        field614 = 0;
        loginState = 0;
        field616 = 0;
        field617 = 0;
        field618 = 0;
        field619 = class146.field1907;
        field620 = null;
        cachedNPCs = new NPC[32768];
        npcIndexesCount = 0;
        npcIndices = new int[32768];
        pendingNpcFlagsCount = 0;
        pendingNpcFlagsIndices = new int[250];
        field626 = new NetWriter();
        field627 = 0;
        socketError = false;
        field629 = true;
        field804 = new class280();
        fontsMap = new HashMap();
        field633 = 0;
        field634 = 1;
        field635 = 0;
        field636 = 1;
        field751 = 0;
        collisionMaps = new CollisionData[4];
        isDynamicRegion = false;
        instanceTemplateChunks = new int[4][13][13];
        field846 = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
        field700 = 0;
        field643 = 2301979;
        field584 = 5063219;
        field836 = 3353893;
        field646 = 7759444;
        field746 = false;
        field660 = 0;
        cameraPitchTarget = 128;
        mapAngle = 0;
        field608 = 0;
        field652 = 0;
        field653 = 0;
        field654 = 0;
        field655 = 0;
        field644 = 50;
        field657 = 0;
        field613 = 0;
        field659 = 0;
        field750 = 12;
        field661 = 6;
        field853 = 0;
        field663 = false;
        field664 = 0;
        field807 = false;
        field738 = 0;
        overheadTextCount = 0;
        field648 = 50;
        overheadTextsX = new int[field648];
        overheadTextsY = new int[field648];
        overheadTextsOffsetY = new int[field648];
        overheadTextsOffsetX = new int[field648];
        field673 = new int[field648];
        field674 = new int[field648];
        overheadTextsCyclesRemaining = new int[field648];
        overheadTexts = new String[field648];
        field761 = new int[104][104];
        field687 = 0;
        screenX = -1;
        screenY = -1;
        lastLeftClickX = 0;
        lastLeftClickY = 0;
        field803 = 0;
        cursorState = 0;
        field621 = true;
        mouseCrosshair = 0;
        pressedItemIndex = 0;
        field688 = 0;
        field678 = 0;
        field821 = 0;
        field691 = 0;
        field689 = false;
        itemPressedDuration = 0;
        myPlayerIndex = 0;
        field677 = true;
        cachedPlayers = new Player[2048];
        localInteractingIndex = -1;
        field698 = 0;
        field699 = true;
        playerNameMask = 0;
        field701 = 0;
        field702 = new int[1000];
        playerMenuTypes = new int[]{44, 45, 46, 47, 48, 49, 50, 51};
        playerOptions = new String[8];
        playerOptionsPriorities = new boolean[8];
        field706 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
        field707 = -1;
        groundItemDeque = new Deque[4][104][104];
        pendingSpawns = new Deque();
        projectiles = new Deque();
        graphicsObjectDeque = new Deque();
        boostedSkillLevels = new int[25];
        realSkillLevels = new int[25];
        skillExperiences = new int[25];
        field715 = 0;
        isMenuOpen = false;
        menuOptionCount = 0;
        menuActionParams0 = new int[500];
        menuActionParams1 = new int[500];
        menuTypes = new int[500];
        menuIdentifiers = new int[500];
        menuOptions = new String[500];
        menuTargets = new String[500];
        menuBooleanArray = new boolean[500];
        field725 = false;
        field726 = false;
        field727 = false;
        field728 = true;
        field729 = -1;
        field730 = -1;
        field623 = 0;
        field732 = 50;
        itemSelectionState = 0;
        lastSelectedItemName = null;
        spellSelected = false;
        field736 = -1;
        field737 = -1;
        field612 = null;
        field739 = null;
        widgetRoot = -1;
        componentTable = new HashTable(8);
        field742 = 0;
        field743 = 0;
        field744 = null;
        energy = 0;
        weight = 0;
        rights = 0;
        field748 = -1;
        field776 = false;
        field784 = null;
        draggedWidget = null;
        field752 = null;
        field753 = 0;
        field749 = 0;
        draggedOnWidget = null;
        field601 = false;
        field757 = -1;
        field758 = -1;
        field772 = false;
        field696 = -1;
        field760 = -1;
        draggingWidget = false;
        cycleCntr = 1;
        pendingVarbitChanges = new int[32];
        pendingVarbitCount = 0;
        interfaceItemTriggers = new int[32];
        field767 = 0;
        changedSkills = new int[32];
        changedSkillsCount = 0;
        chatCycle = 0;
        field647 = 0;
        field828 = 0;
        field793 = 0;
        field774 = 0;
        field775 = 0;
        mouseWheelRotation = 0;
        field638 = new Deque();
        field778 = new Deque();
        field779 = new Deque();
        widgetFlags = new HashTable(512);
        widgetCount = 0;
        field830 = -2;
        field697 = new boolean[100];
        field788 = new boolean[100];
        field723 = new boolean[100];
        widgetPositionX = new int[100];
        widgetPositionY = new int[100];
        widgetBoundsWidth = new int[100];
        widgetBoundsHeight = new int[100];
        gameDrawingMode = 0;
        field791 = 0L;
        isResized = true;
        field731 = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
        publicChatMode = 0;
        field795 = 0;
        field796 = "";
        field797 = new long[100];
        field798 = 0;
        field799 = 0;
        field800 = new int[128];
        field773 = new int[128];
        field722 = -1L;
        field651 = -1;
        mapIconCount = 0;
        mapIconTileX = new int[1000];
        mapIconTileY = new int[1000];
        mapIcons = new SpritePixels[1000];
        destinationX = 0;
        destinationY = 0;
        field810 = 0;
        field811 = 255;
        field812 = -1;
        field813 = false;
        field814 = 127;
        field815 = 127;
        queuedSoundEffectCount = 0;
        queuedSoundEffectIDs = new int[50];
        unknownSoundValues1 = new int[50];
        unknownSoundValues2 = new int[50];
        soundLocations = new int[50];
        audioEffects = new SoundEffect[50];
        field822 = false;
        field823 = new boolean[5];
        field824 = new int[5];
        field825 = new int[5];
        field826 = new int[5];
        field705 = new int[5];
        minFov = 256;
        maxFov = 205;
        minZoom = 256;
        maxZoom = 320;
        field832 = 1;
        field833 = 32767;
        field834 = 1;
        field835 = 32767;
        Viewport_xOffset = 0;
        Viewport_yOffset = 0;
        viewportWidth = 0;
        viewportHeight = 0;
        scale = 0;
        customizedAppearance = new PlayerComposition();
        field842 = -1;
        field586 = -1;
        grandExchangeOffers = new GrandExchangeOffer[8];
        field665 = new OwnWorldComparator();
        field650 = -1;
        field781 = new ArrayList(10);
        field606 = 0;
        field849 = new class59();
        field850 = new int[50];
        field596 = new int[50];
    }

    public static ArrayList<Snow> snowFlakes = new ArrayList<Snow>();
    private static boolean loaded;
    static Random random = new Random();

    static void drawSnow() {
        if (Loader.CHRISTMAS) {
            if (!loaded) {
                for (int index = 0; index < 100; index++) {
                    snowFlakes.add(new Snow());
                }
                loaded = true;
            } else {
                for (Snow snow : snowFlakes) {
                    if (snow != null)
                        snow.draw();
                }
            }
        }
    }


    @Override
    protected void vmethod1144() {
        field791 = Buffer.safeCurrentTimeMillis() + 500L;
        method1145();
        if (widgetRoot != -1) {
            method1151(true);
        }

    }

    @Override
    protected void setUp() {
        ClientPacket.method3446(new int[]{20, 260, 10000}, new int[]{1000, 100, 500});
        class26.port1 = socketType == 0 ? 7306 : world + 40000;
        class68.port2 = socketType == 0 ? 7306 : world + 50000;
        class290.myWorldPort = class26.port1;
        PlayerComposition.colorsToFind = class228.field2582;
        PlayerComposition.colorsToReplace = class228.field2583;
        PlayerComposition.field2577 = class228.field2586;
        PlayerComposition.field2578 = class228.field2585;
        MapIcon.urlRequester = new UrlRequester();
        setUpKeyboard();
        setUpMouse();
        class33.mouseWheel = mouseWheel();
        class34.indexStore255 = new IndexFile(255, class155.dat2File, class155.idx255File, 500000);
        class10.preferences = Item.method1859();
        setUpClipboard();
        class313.method5714(this, class8.field55);
        if (socketType != 0) {
            displayFps = true;
        }

        class50.method991(class10.preferences.screenType);
        DState.friendManager = new FriendManager(MapIconReference.loginType);
    }

    @Override
    protected void packetHandler() {
        ++gameCycle;
        processJS5Connection();
        Script.method1955();

        int int_0;
        try {
            if (class217.field2460 == 1) {
                int_0 = class217.field2459.method4288();
                if ((int_0 > 0) && class217.field2459.method4203()) {
                    int_0 -= class6.field37;
                    if (int_0 < 0) {
                        int_0 = 0;
                    }

                    class217.field2459.method4236(int_0);
                } else {
                    class217.field2459.method4202();
                    class217.field2459.method4200();
                    if (class138.field1871 != null) {
                        class217.field2460 = 2;
                    } else {
                        class217.field2460 = 0;
                    }

                    class177.track = null;
                    Item.field1149 = null;
                }
            }
        } catch (final Exception exception_0) {
            exception_0.printStackTrace();
            class217.field2459.method4202();
            class217.field2460 = 0;
            class177.track = null;
            Item.field1149 = null;
            class138.field1871 = null;
        }

        class54.method1017();
        synchronized (KeyFocusListener.keyboard) {
            ++KeyFocusListener.keyboardIdleTicks;
            KeyFocusListener.field350 = KeyFocusListener.field352;
            KeyFocusListener.field349 = 0;
            int int_1;
            if (KeyFocusListener.field329 >= 0) {
                while (KeyFocusListener.field344 != KeyFocusListener.field329) {
                    int_1 = KeyFocusListener.field343[KeyFocusListener.field344];
                    KeyFocusListener.field344 = (KeyFocusListener.field344 + 1) & 0x7F;
                    if (int_1 < 0) {
                        KeyFocusListener.keyPressed[~int_1] = false;
                    } else {
                        if (!KeyFocusListener.keyPressed[int_1]
                                && (KeyFocusListener.field349 < (KeyFocusListener.field338.length - 1))) {
                            KeyFocusListener.field338[++KeyFocusListener.field349 - 1] = int_1;
                        }

                        KeyFocusListener.keyPressed[int_1] = true;
                    }
                }
            } else {
                for (int_1 = 0; int_1 < 112; int_1++) {
                    KeyFocusListener.keyPressed[int_1] = false;
                }

                KeyFocusListener.field329 = KeyFocusListener.field344;
            }

            if (KeyFocusListener.field349 > 0) {
                KeyFocusListener.keyboardIdleTicks = 0;
            }

            KeyFocusListener.field352 = KeyFocusListener.field351;
        }

        synchronized (MouseInput.mouse) {
            MouseInput.mouseCurrentButton = MouseInput.MouseHandler_currentButton;
            MouseInput.mouseLastX = MouseInput.mouseX;
            MouseInput.mouseLastY = MouseInput.mouseY * -1660309769;
            MouseInput.mouseLastButton = MouseInput.MouseHandler_lastButton;
            MouseInput.mouseLastPressedX = MouseInput.MouseHandler_lastPressedX;
            MouseInput.mouseLastPressedY = MouseInput.MouseHandler_lastPressedY;
            MouseInput.mouseLastPressedTimeMillis = MouseInput.MouseHandler_lastPressedTimeMillis;
            MouseInput.MouseHandler_lastButton = 0;
        }

        if (class33.mouseWheel != null) {
            int_0 = class33.mouseWheel.useRotation();
            mouseWheelRotation = int_0;
        }

        if (gameState == 0) {
            MapCacheArchiveNames.load();
            class43.timer.vmethod3330();

            for (int_0 = 0; int_0 < 32; int_0++) {
                GameEngine.field394[int_0] = 0L;
            }

            for (int_0 = 0; int_0 < 32; int_0++) {
                GameEngine.field404[int_0] = 0L;
            }

            class8.field48 = 0;
        } else if (gameState == 5) {
            AbstractByteBuffer.method3806(this);
            MapCacheArchiveNames.load();
            class43.timer.vmethod3330();

            for (int_0 = 0; int_0 < 32; int_0++) {
                GameEngine.field394[int_0] = 0L;
            }

            for (int_0 = 0; int_0 < 32; int_0++) {
                GameEngine.field404[int_0] = 0L;
            }

            class8.field48 = 0;
        } else if ((gameState != 10) && (gameState != 11)) {
            if (gameState == 20) {
                AbstractByteBuffer.method3806(this);
                method1142();
            } else if (gameState == 25) {
                class15.method148();
            }
        } else {
            AbstractByteBuffer.method3806(this);
        }

        if (gameState == 30) {
            method1143();
        } else if ((gameState == 40) || (gameState == 45)) {
            method1142();
        }

    }

    @Override
    protected void methodDraw(final boolean bool_0) {
        final boolean bool_1 = class148.method3196();
        if (bool_1 && field813 && (MapIcon.soundSystem0 != null)) {
            MapIcon.soundSystem0.tryFlush();
        }

        int int_0;
        if (((gameState == 10) || (gameState == 20) || (gameState == 30)) && (field791 != 0L)
                && (Buffer.safeCurrentTimeMillis() > field791)) {
            int_0 = isResized ? 2 : 1;
            class50.method991(int_0);
        }

        if (bool_0) {
            for (int_0 = 0; int_0 < 100; int_0++) {
                field697[int_0] = true;
            }
        }

        if (gameState == 0) {
            drawLoadingScreen(class78.loadingBarPercentage, class78.loadingText, bool_0);
        } else if (gameState == 5) {
            Sequence.drawLoginScreen(ClanMemberManager.fontBold12, class151.fontPlain11, Actor.font_p12full, bool_0);
        } else if ((gameState != 10) && (gameState != 11)) {
            if (gameState == 20) {
                Sequence.drawLoginScreen(ClanMemberManager.fontBold12, class151.fontPlain11, Actor.font_p12full,
                        bool_0);
            } else if (gameState == 25) {
                if (field751 == 1) {
                    if (field633 > field634) {
                        field634 = field633;
                    }

                    int_0 = ((field634 * 50) - (field633 * 50)) / field634;
                    class83.method1933("Loading - please wait." + "<br>" + " (" + int_0 + "%" + ")", false);
                } else if (field751 == 2) {
                    if (field635 > field636) {
                        field636 = field635;
                    }

                    int_0 = (((field636 * 50) - (field635 * 50)) / field636) + 50;
                    class83.method1933("Loading - please wait." + "<br>" + " (" + int_0 + "%" + ")", false);
                } else {
                    class83.method1933("Loading - please wait.", false);
                }
            } else if (gameState == 30) {
                method1146();
            } else if (gameState == 40) {
                class83.method1933("Connection lost" + "<br>" + "Please wait - attempting to reestablish", false);
            } else if (gameState == 45) {
                class83.method1933("Please wait...", false);
            }
        } else {
            Sequence.drawLoginScreen(ClanMemberManager.fontBold12, class151.fontPlain11, Actor.font_p12full, bool_0);
        }

        if ((gameState == 30) && (gameDrawingMode == 0) && !bool_0 && !isResized) {
            for (int_0 = 0; int_0 < widgetCount; int_0++) {
                if (field788[int_0]) {
                    GameSocket.rasterProvider.draw(widgetPositionX[int_0], widgetPositionY[int_0],
                            widgetBoundsWidth[int_0], widgetBoundsHeight[int_0]);
                    field788[int_0] = false;
                }
            }
        } else if (gameState > 0) {
            GameSocket.rasterProvider.drawFull(0, 0);

            for (int_0 = 0; int_0 < widgetCount; int_0++) {
                field788[int_0] = false;
            }
        }

    }

    @Override
    protected void vmethod1187() {
        if (MapLabel.varcs.changed()) {
            MapLabel.varcs.serialize();
        }

        if (class26.mouseRecorder != null) {
            class26.mouseRecorder.isRunning = false;
        }

        class26.mouseRecorder = null;
        field626.close();
        if (KeyFocusListener.keyboard != null) {
            synchronized (KeyFocusListener.keyboard) {
                KeyFocusListener.keyboard = null;
            }
        }

        class185.method3787();
        class33.mouseWheel = null;
        if (MapIcon.soundSystem0 != null) {
            MapIcon.soundSystem0.shutdown();
        }

        if (Actor.soundSystem1 != null) {
            Actor.soundSystem1.shutdown();
        }

        Permission.method4605();
        synchronized (IndexStoreActionHandler.IndexStoreActionHandler_lock) {
            if (IndexStoreActionHandler.field3179 != 0) {
                IndexStoreActionHandler.field3179 = 1;

                try {
                    IndexStoreActionHandler.IndexStoreActionHandler_lock.wait();
                } catch (final InterruptedException interruptedexception_0) {
                }
            }
        }

        if (MapIcon.urlRequester != null) {
            MapIcon.urlRequester.close();
            MapIcon.urlRequester = null;
        }

        try {
            class155.dat2File.close();

            for (int int_0 = 0; int_0 < class148.idxCount; int_0++) {
                class76.idxFiles[int_0].close();
            }

            class155.idx255File.close();
            class155.randomDat.close();
        } catch (final Exception exception_0) {
        }

    }

    @Override
    protected void vmethod1132() {
    }

    @Override
    public void init() {
        try {
            if (isValidHost()) {
                final Parameters[] parameterss_0 = class51.method996();

                for (int int_0 = 0; int_0 < parameterss_0.length; int_0++) {
                    final Parameters parameters_0 = parameterss_0[int_0];
                    final String string_0 = getParameter(parameters_0.key);
                    if (string_0 != null) {
                        switch (Integer.parseInt(parameters_0.key)) {
                            case 2:
                                if (field587 == -1) {
                                    field587 = Integer.parseInt(string_0);
                                }
                                break;
                            case 3:
                                socketType = Integer.parseInt(string_0);
                                break;
                            case 4:
                                flags = Integer.parseInt(string_0);
                                break;
                            case 5:
                                class26.field219 = string_0;
                                System.out.println("Connecting to GE: " + string_0);
                                break;
                            case 6:
                                field629 = Integer.parseInt(string_0) != 0;
                                break;
                            case 7:
                                if (string_0.equalsIgnoreCase("true")) {
                                }
                                break;
                            case 8:
                                languageId = Integer.parseInt(string_0);
                            case 9:
                            case 12:
                            default:
                                break;
                            case 10:
                                GameSocket.sessionToken = string_0;
                                break;
                            case 11:
                                Enum.field3346 = class179.method3517(Integer.parseInt(string_0));
                                break;
                            case 13:
                                world = Integer.parseInt(string_0);
                                break;
                            case 14:
                                isMembers = string_0.equalsIgnoreCase("true");
                                break;
                            case 15:
                                ItemLayer.field1455 = (JagexGame) class76.forOrdinal(class191.method3870(),
                                        Integer.parseInt(string_0));
                                if (ItemLayer.field1455 == JagexGame.field3145) {
                                    MapIconReference.loginType = JagexLoginType.field3880;
                                } else {
                                    MapIconReference.loginType = JagexLoginType.field3878;
                                }
                                break;
                            case 16:
                                FrameMap.field1709 = Integer.parseInt(string_0);
                        }
                    }
                }

                class177.method3513();
                class54.host = getCodeBase().getHost();
                final String string_1 = Enum.field3346.identifier;
                final byte byte_0 = 0;

                try {
                    class177.method3509(Loader.SERVER_NAME.toLowerCase(), string_1, byte_0, 17);
                } catch (final Exception e) {
                	e.printStackTrace();
                    UnitPriceComparator.processClientError(null, e);
                }

                Buffer.clientInstance = this;
                RunException.field1940 = field587;
                initialize(765, 503, 171);
            }
        } catch (final RuntimeException e) {
        	e.printStackTrace();
          //  throw AbstractSoundSystem.method2195(e, "client.init(" + ')');
        }
    }

    void processJS5Connection() {
        if (gameState != 1000) {
            final long long_0 = Buffer.safeCurrentTimeMillis();
            int int_0 = (int) (long_0 - class250.field3203);
            class250.field3203 = long_0;
            if (int_0 > 200) {
                int_0 = 200;
            }

            class250.field3197 += int_0;
            boolean bool_0;
            if ((class250.NetCache_pendingResponsesCount == 0) && (class250.NetCache_pendingPriorityResponsesCount == 0)
                    && (class250.NetCache_pendingWritesCount == 0)
                    && (class250.NetCache_pendingPriorityWritesCount == 0)) {
                bool_0 = true;
            } else if (class250.NetCache_socket == null) {
                bool_0 = false;
            } else {
                try {
                    label245:
                    {
                        if (class250.field3197 > 30000) {
                            throw new IOException();
                        }

                        FileRequest filerequest_0;
                        Buffer buffer_0;
                        while ((class250.NetCache_pendingPriorityResponsesCount < 200) && (class250.NetCache_pendingPriorityWritesCount > 0)) {
                            filerequest_0 = (FileRequest) class250.NetCache_pendingPriorityWrites.first();
                            buffer_0 = new Buffer(4);
                            buffer_0.putByte(1);
                            buffer_0.put24bitInt((int) filerequest_0.hash);
                            class250.NetCache_socket.vmethod3347(buffer_0.payload, 0, 4);
                            class250.NetCache_pendingPriorityResponses.put(filerequest_0, filerequest_0.hash);
                            --class250.NetCache_pendingPriorityWritesCount;
                            ++class250.NetCache_pendingPriorityResponsesCount;
                        }

                        while ((class250.NetCache_pendingResponsesCount < 200) && (class250.NetCache_pendingWritesCount > 0)) {
                            filerequest_0 = (FileRequest) class250.NetCache_pendingWritesQueue.peek();
                            buffer_0 = new Buffer(4);
                            buffer_0.putByte(0);
                            buffer_0.put24bitInt((int) filerequest_0.hash);
                            class250.NetCache_socket.vmethod3347(buffer_0.payload, 0, 4);
                            filerequest_0.unlinkDual();
                            class250.NetCache_pendingResponses.put(filerequest_0, filerequest_0.hash);
                            --class250.NetCache_pendingWritesCount;
                            ++class250.NetCache_pendingResponsesCount;
                        }

                        for (int int_1 = 0; int_1 < 100; int_1++) {
                            final int int_2 = class250.NetCache_socket.vmethod3349();
                            if (int_2 < 0) {
                                throw new IOException();
                            }

                            if (int_2 == 0) {
                                break;
                            }

                            class250.field3197 = 0;
                            byte byte_0 = 0;
                            if (class250.currentRequest == null) {
                                byte_0 = 8;
                            } else if (class250.field3210 == 0) {
                                byte_0 = 1;
                            }

                            int int_3;
                            int int_4;
                            int int_5;
                            int int_7;
                            if (byte_0 > 0) {
                                int_3 = byte_0 - class250.NetCache_responseHeaderBuffer.offset;
                                if (int_3 > int_2) {
                                    int_3 = int_2;
                                }

                                class250.NetCache_socket.vmethod3351(class250.NetCache_responseHeaderBuffer.payload, class250.NetCache_responseHeaderBuffer.offset, int_3);
                                if (class250.field3213 != 0) {
                                    for (int_4 = 0; int_4 < int_3; int_4++) {
                                        class250.NetCache_responseHeaderBuffer.payload[int_4 + class250.NetCache_responseHeaderBuffer.offset] ^= class250.field3213;
                                    }
                                }

                                class250.NetCache_responseHeaderBuffer.offset += int_3;
                                if (class250.NetCache_responseHeaderBuffer.offset < byte_0) {
                                    break;
                                }

                                if (class250.currentRequest == null) {
                                    class250.NetCache_responseHeaderBuffer.offset = 0;
                                    int_4 = class250.NetCache_responseHeaderBuffer.readUnsignedByte();
                                    int_5 = class250.NetCache_responseHeaderBuffer.readUnsignedShort();
                                    final int int_6 = class250.NetCache_responseHeaderBuffer.readUnsignedByte();
                                    int_7 = class250.NetCache_responseHeaderBuffer.readInt();
                                    final long long_1 = int_5 + (int_4 << 16);
                                    FileRequest filerequest_1 = (FileRequest) class250.NetCache_pendingPriorityResponses.get(long_1);
                                    class192.field2391 = true;
                                    if (filerequest_1 == null) {
                                        filerequest_1 = (FileRequest) class250.NetCache_pendingResponses.get(long_1);
                                        class192.field2391 = false;
                                    }

                                    if (filerequest_1 == null) {
                                        throw new IOException();
                                    }

                                    final int int_8 = int_6 == 0 ? 5 : 9;
                                    class250.currentRequest = filerequest_1;
                                    class301.NetCache_responseArchiveBuffer = new Buffer(int_8 + int_7 + class250.currentRequest.padding);
                                    class301.NetCache_responseArchiveBuffer.putByte(int_6);
                                    class301.NetCache_responseArchiveBuffer.putInt(int_7);
                                    class250.field3210 = 8;
                                    class250.NetCache_responseHeaderBuffer.offset = 0;
                                } else if (class250.field3210 == 0) {
                                    if (class250.NetCache_responseHeaderBuffer.payload[0] == -1) {
                                        class250.field3210 = 1;
                                        class250.NetCache_responseHeaderBuffer.offset = 0;
                                    } else {
                                        class250.currentRequest = null;
                                    }
                                }
                            } else {
                                int_3 = class301.NetCache_responseArchiveBuffer.payload.length - class250.currentRequest.padding;
                                int_4 = 512 - class250.field3210;
                                if (int_4 > (int_3 - class301.NetCache_responseArchiveBuffer.offset)) {
                                    int_4 = int_3 - class301.NetCache_responseArchiveBuffer.offset;
                                }

                                if (int_4 > int_2) {
                                    int_4 = int_2;
                                }

                                class250.NetCache_socket.vmethod3351(class301.NetCache_responseArchiveBuffer.payload, class301.NetCache_responseArchiveBuffer.offset, int_4);
                                if (class250.field3213 != 0) {
                                    for (int_5 = 0; int_5 < int_4; int_5++) {
                                        class301.NetCache_responseArchiveBuffer.payload[int_5 + class301.NetCache_responseArchiveBuffer.offset] ^= class250.field3213;
                                    }
                                }

                                class301.NetCache_responseArchiveBuffer.offset += int_4;
                                class250.field3210 += int_4;
                                if (int_3 == class301.NetCache_responseArchiveBuffer.offset) {
                                    if (class250.currentRequest.hash == 16711935L) {
                                        class185.NetCache_reference = class301.NetCache_responseArchiveBuffer;

                                        for (int_5 = 0; int_5 < 256; int_5++) {
                                            final IndexData indexdata_0 = class250.NetCache_indexCaches[int_5];
                                            if (indexdata_0 != null) {
                                                class185.NetCache_reference.offset = (int_5 * 8) + 5;
                                                int_7 = class185.NetCache_reference.readInt();
                                                final int int_9 = class185.NetCache_reference.readInt();
                                                indexdata_0.setInformation(int_7, int_9);
                                            }
                                        }
                                    } else {
                                        class250.NetCache_crc.reset();
                                        class250.NetCache_crc.update(class301.NetCache_responseArchiveBuffer.payload, 0, int_3);
                                        int_5 = (int) class250.NetCache_crc.getValue();
                                        if (int_5 != class250.currentRequest.crc) {
                                            try {
                                                class250.NetCache_socket.vmethod3346();
                                            } catch (final Exception exception_1) {
                                            }

                                            ++class250.field3214;
                                            class250.NetCache_socket = null;
                                            class250.field3213 = (byte) ((int) ((Math.random() * 255.0D) + 1.0D));
                                            bool_0 = false;
                                            break label245;
                                        }

                                        class250.field3214 = 0;
                                        class250.field3215 = 0;
                                        class250.currentRequest.index.write(
                                                (int) (class250.currentRequest.hash & 0xFFFFL),
                                                class301.NetCache_responseArchiveBuffer.payload,
                                                (class250.currentRequest.hash & 0xFF0000L) == 16711680L,
                                                class192.field2391);
                                    }

                                    class250.currentRequest.unlink();
                                    if (class192.field2391) {
                                        --class250.NetCache_pendingPriorityResponsesCount;
                                    } else {
                                        --class250.NetCache_pendingResponsesCount;
                                    }

                                    class250.field3210 = 0;
                                    class250.currentRequest = null;
                                    class301.NetCache_responseArchiveBuffer = null;
                                } else {
                                    if (class250.field3210 != 512) {
                                        break;
                                    }

                                    class250.field3210 = 0;
                                }
                            }
                        }

                        bool_0 = true;
                    }
                } catch (final IOException ioexception_0) {
                    try {
                        class250.NetCache_socket.vmethod3346();
                    } catch (final Exception exception_0) {
                    }

                    ++class250.field3215;
                    class250.NetCache_socket = null;
                    bool_0 = false;
                }
            }

            if (!bool_0) {
                method1140();
            }

        }
    }

    void method1140() {
        if (class250.field3214 >= 4) {
            this.error("js5crc");
            gameState = 1000;
        } else {
            if (class250.field3215 >= 4) {
                if (gameState <= 5) {
                    this.error("js5io");
                    gameState = 1000;
                    return;
                }

                field768 = 3000;
                class250.field3215 = 3;
            }

            if ((--field768 + 1) <= 0) {
                try {
                    if (js5State == 0) {
                        if (Loader.CONNECT_TO_OSRS)
                            socket = GameEngine.taskManager.createSocket(class54.host, class290.myWorldPort);
                        else
                            socket = GameEngine.taskManager.createSocket(Loader.FS_HOST, 7304);
                        ++js5State;
                    }

                    if (js5State == 1) {
                        if (socket.status == 2) {
                            this.error(-1);
                            return;
                        }

                        if (socket.status == 1) {
                            ++js5State;
                        }
                    }

                    if (js5State == 2) {
                        if (field629) {
                            rssocket = GameEngine.method911((Socket) socket.value, 40000, 5000);
                        } else {
                            rssocket = new class161((Socket) socket.value, GameEngine.taskManager, 5000);
                        }

                        final Buffer buffer_0 = new Buffer(5);
                        buffer_0.putByte(15);
                        buffer_0.putInt(Loader.CONNECT_TO_OSRS ? Loader.BUILD : Loader.BUILD << 16 | Loader.UPDATE_SERVER_SUB_BUILD);
                        //System.out.println(Loader.BUILD << 16 | Loader.UPDATE_SERVER_SUB_BUILD);
                        rssocket.vmethod3347(buffer_0.payload, 0, 5);
                        ++js5State;
                        class229.field2589 = Buffer.safeCurrentTimeMillis();
                    }

                    if (js5State == 3) {
                        if ((rssocket.vmethod3349() > 0) || (!field629 && (gameState <= 5))) {
                            final int int_0 = rssocket.vmethod3353();
                            if (int_0 != 0) {
                                this.error(int_0);
                                return;
                            }

                            ++js5State;
                        } else if ((Buffer.safeCurrentTimeMillis() - class229.field2589) > 30000L) {
                            this.error(-2);
                            return;
                        }
                    }

                    if (js5State == 4) {
                        MapIconReference.method633(rssocket, gameState > 20);
                        socket = null;
                        rssocket = null;
                        js5State = 0;
                        field614 = 0;
                    }
                } catch (final IOException ioexception_0) {
                    this.error(-3);
                }

            }
        }
    }

    void error(final int int_0) {
        socket = null;
        rssocket = null;
        js5State = 0;
        if (class290.myWorldPort == class26.port1) {
            class290.myWorldPort = class68.port2;
        } else {
            class290.myWorldPort = class26.port1;
        }

        ++field614;
        if ((field614 >= 2) && ((int_0 == 7) || (int_0 == 9))) {
            if (gameState <= 5) {
                this.error("js5connect_full");
                gameState = 1000;
            } else {
                field768 = 3000;
            }
        } else if ((field614 >= 2) && (int_0 == 6)) {
            this.error("js5connect_outofdate");
            gameState = 1000;
        } else if (field614 >= 4) {
            if (gameState <= 5) {
                this.error("js5connect");
                gameState = 1000;
            } else {
                field768 = 3000;
            }
        }

    }

    void method1142() {
        Object object_0 = field626.getSocket();
        final PacketBuffer packetbuffer_0 = field626.packetBuffer;

        try {
            if (loginState == 0) {
                if (object_0 != null) {
                    ((class157) object_0).vmethod3346();
                    object_0 = null;
                }

                class225.field2556 = null;
                socketError = false;
                field616 = 0;
                loginState = 1;
            }

            if (loginState == 1) {
                if (class225.field2556 == null) {
                    class225.field2556 = GameEngine.taskManager.createSocket(class54.host, Loader.CONNECT_TO_OSRS ? class290.myWorldPort : 7306); //TODO proper way to send port in case world port changes?
                }

                if (class225.field2556.status == 2) {
                    throw new IOException();
                }

                if (class225.field2556.status == 1) {
                    if (field629) {
                        object_0 = GameEngine.method911((Socket) class225.field2556.value, 40000, 5000);
                    } else {
                        object_0 = new class161((Socket) class225.field2556.value, GameEngine.taskManager, 5000);
                    }

                    field626.setSocket((class157) object_0);
                    class225.field2556 = null;
                    loginState = 2;
                }
            }

            if (loginState == 2) {
                field626.method1978();
                final PacketNode packetnode_0 = PendingSpawn.method1536();
                packetnode_0.packetBuffer.putByte(LoginPacket.field2237.id);
                field626.method1980(packetnode_0);
                field626.method1979();
                packetbuffer_0.offset = 0;
                loginState = 3;
            }

            boolean bool_0;
            int int_0;
            if (loginState == 3) {
                if (MapIcon.soundSystem0 != null) {
                    MapIcon.soundSystem0.method2145();
                }

                if (Actor.soundSystem1 != null) {
                    Actor.soundSystem1.method2145();
                }

                bool_0 = !field629 || ((class157) object_0).vmethod3350(1);

                if (bool_0) {
                    int_0 = ((class157) object_0).vmethod3353();
                    if (MapIcon.soundSystem0 != null) {
                        MapIcon.soundSystem0.method2145();
                    }

                    if (Actor.soundSystem1 != null) {
                        Actor.soundSystem1.method2145();
                    }

                    if (int_0 != 0) {
                        class33.method559(int_0);
                        return;
                    }

                    packetbuffer_0.offset = 0;
                    loginState = 4;
                }
            }

            int int_7;
            if (loginState == 4) {
                if (packetbuffer_0.offset < 8) {
                    int_7 = ((class157) object_0).vmethod3349();
                    if (int_7 > (8 - packetbuffer_0.offset)) {
                        int_7 = 8 - packetbuffer_0.offset;
                    }

                    if (int_7 > 0) {
                        ((class157) object_0).vmethod3351(packetbuffer_0.payload, packetbuffer_0.offset, int_7);
                        packetbuffer_0.offset += int_7;
                    }
                }

                if (packetbuffer_0.offset == 8) {
                    packetbuffer_0.offset = 0;
                    class221.field2535 = packetbuffer_0.readLong();
                    loginState = 5;
                }
            }

            int int_2;
            if (loginState == 5) {
                field626.packetBuffer.offset = 0;
                field626.method1978();
                final PacketBuffer packetbuffer_2 = new PacketBuffer(500);
                final int[] xtea = new int[]{(int) (Math.random() * 9.9999999E7D),
                        (int) (Math.random() * 9.9999999E7D), (int) (class221.field2535 >> 32),
                        (int) (class221.field2535 & 0xFFFFFFFFFFFFFFFFL)};
                packetbuffer_2.offset = 0;
                packetbuffer_2.putByte(1);
                packetbuffer_2.putByte(field619.vmethod5815());
                packetbuffer_2.putInt(xtea[0]);
                packetbuffer_2.putInt(xtea[1]);
                packetbuffer_2.putInt(xtea[2]);
                packetbuffer_2.putInt(xtea[3]);
                switch (field619.field1909) {
                    case 0: //3
                    case 1: //2
                        packetbuffer_2.put24bitInt(WorldMapType3.field104);
                        packetbuffer_2.offset += 5;
                        break;
                    case 2: //1
                        packetbuffer_2.offset += 8;
                        break;
                    case 3: //0
                        packetbuffer_2.putInt(((Integer) class10.preferences.preferences.get(Integer.valueOf(TotalQuantityComparator.method35(class78.username)))).intValue());
                        packetbuffer_2.offset += 4;
                }

                packetbuffer_2.putString(class78.password);
                packetbuffer_2.encryptRsa(class76.LOGIN_EXPONENT, class76.LOGIN_MODULUS);
                final PacketNode packetnode_1 = PendingSpawn.method1536();
                packetnode_1.packetBuffer.offset = 0;
                if (gameState == 40) {
                    packetnode_1.packetBuffer.putByte(LoginPacket.field2238.id);
                } else {
                    packetnode_1.packetBuffer.putByte(LoginPacket.field2235.id);
                }

                packetnode_1.packetBuffer.putShort(0);
                final int int_1 = packetnode_1.packetBuffer.offset;
                packetnode_1.packetBuffer.putInt(Loader.CONNECT_TO_OSRS ? Loader.BUILD : Loader.BUILD << 16 | Loader.WORLD_SERVER_SUB_BUILD);
                packetnode_1.packetBuffer.putBytes(packetbuffer_2.payload, 0, packetbuffer_2.offset);
                int_2 = packetnode_1.packetBuffer.offset;
                packetnode_1.packetBuffer.putString(class78.username);
                packetnode_1.packetBuffer.putByte(((isResized ? 1 : 0) << 1) | (lowMemory ? 1 : 0));
                packetnode_1.packetBuffer.putShort(Varcs.canvasWidth);
                packetnode_1.packetBuffer.putShort(BuildType.canvasHeight);
                final PacketBuffer packetbuffer_1 = packetnode_1.packetBuffer;
                if (field620 != null) {
                    packetbuffer_1.putBytes(field620, 0, field620.length);
                } else {
                    final byte[] bytes_0 = new byte[24];

                    try {
                        class155.randomDat.seek(0L);
                        class155.randomDat.read(bytes_0);

                        int int_3;
                        for (int_3 = 0; (int_3 < 24) && (bytes_0[int_3] == 0); int_3++) {
                        }

                        if (int_3 >= 24) {
                            throw new IOException();
                        }
                    } catch (final Exception exception_0) {
                        for (int int_4 = 0; int_4 < 24; int_4++) {
                            bytes_0[int_4] = -1;
                        }
                    }

                    packetbuffer_1.putBytes(bytes_0, 0, bytes_0.length);
                }

                packetnode_1.packetBuffer.putString(GameSocket.sessionToken);
                packetnode_1.packetBuffer.putInt(FrameMap.field1709);
                final Buffer buffer_0 = new Buffer(WorldMapType2.platformInfo.method6215());
                WorldMapType2.platformInfo.method6217(buffer_0);
                packetnode_1.packetBuffer.putBytes(buffer_0.payload, 0, buffer_0.payload.length);
                packetnode_1.packetBuffer.putByte(field587);
                packetnode_1.packetBuffer.putInt(0);
                packetnode_1.packetBuffer.putInt(AttackOption.indexInterfaces.crc);
                packetnode_1.packetBuffer.putInt(class37.indexSoundEffects.crc);
                packetnode_1.packetBuffer.putInt(SoundTask.configsIndex.crc);
                packetnode_1.packetBuffer.putInt(class224.indexCache3.crc);
                packetnode_1.packetBuffer.putInt(UrlRequester.indexCache4.crc);
                packetnode_1.packetBuffer.putInt(FileRequest.indexMaps.crc);
                packetnode_1.packetBuffer.putInt(Item.indexTrack1.crc);
                packetnode_1.packetBuffer.putInt(class21.indexModels.crc);
                packetnode_1.packetBuffer.putInt(GZipDecompressor.indexSprites.crc);
                packetnode_1.packetBuffer.putInt(ObjectComposition.indexTextures.crc);
                packetnode_1.packetBuffer.putInt(MapLabel.indexCache10.crc);
                packetnode_1.packetBuffer.putInt(OwnWorldComparator.indexTrack2.crc);
                packetnode_1.packetBuffer.putInt(indexScripts.crc);
                packetnode_1.packetBuffer.putInt(class50.indexCache13.crc);
                packetnode_1.packetBuffer.putInt(class59.vorbisIndex.crc);
                packetnode_1.packetBuffer.putInt(MapIconReference.indexCache15.crc);
                packetnode_1.packetBuffer.putInt(class24.indexWorldMap.crc);
                packetnode_1.packetBuffer.encryptXtea(xtea, int_2, packetnode_1.packetBuffer.offset);
                packetnode_1.packetBuffer.method3614(packetnode_1.packetBuffer.offset - int_1);
                field626.method1980(packetnode_1);
                field626.method1979();
                field626.field1218 = new ISAACCipher(xtea);

                for (int int_5 = 0; int_5 < 4; int_5++) {
                    xtea[int_5] += 50;
                }

                packetbuffer_0.seed(xtea);
                loginState = 6;
            }

            if ((loginState == 6) && (((class157) object_0).vmethod3349() > 0)) {
                int_7 = ((class157) object_0).vmethod3353();
                if ((int_7 == 21) && (gameState == 20)) {
                    loginState = 7;
                } else if (int_7 == 2) {
                    loginState = 9;
                } else if ((int_7 == 15) && (gameState == 40)) {
                    field626.packetLength = -1;
                    loginState = 13;
                } else if ((int_7 == 23) && (field617 < 1)) {
                    ++field617;
                    loginState = 0;
                } else {
                    if (int_7 != 29) {
                        class33.method559(int_7);
                        return;
                    }

                    loginState = 11;
                }
            }

            if ((loginState == 7) && (((class157) object_0).vmethod3349() > 0)) {
                field618 = (((class157) object_0).vmethod3353() + 3) * 60;
                loginState = 8;
            }

            if (loginState == 8) {
                field616 = 0;
                GrandExchangeEvent.method22("You have only just left another world.",
                        "Your profile will be transferred in:", (field618 / 60) + " seconds.");
                if (--field618 <= 0) {
                    loginState = 0;
                }

            } else {
                int int_6;
                if ((loginState == 9) && (((class157) object_0).vmethod3349() >= 13)) {
                    bool_0 = ((class157) object_0).vmethod3353() == 1;
                    ((class157) object_0).vmethod3351(packetbuffer_0.payload, 0, 4);
                    packetbuffer_0.offset = 0;
                    if (bool_0) {
                        int_0 = packetbuffer_0.readOpcode() << 24;
                        int_0 |= packetbuffer_0.readOpcode() << 16;
                        int_0 |= packetbuffer_0.readOpcode() << 8;
                        int_0 |= packetbuffer_0.readOpcode();
                        int_6 = TotalQuantityComparator.method35(class78.username);
                        if ((class10.preferences.preferences.size() >= 10)
                                && !class10.preferences.preferences.containsKey(Integer.valueOf(int_6))) {
                            final Iterator iterator_0 = class10.preferences.preferences.entrySet().iterator();
                            iterator_0.next();
                            iterator_0.remove();
                        }

                        class10.preferences.preferences.put(Integer.valueOf(int_6), Integer.valueOf(int_0));
                    }

                    if (class78.Login_isUsernameRemembered) {
                        class10.preferences.rememberedUsername = class78.username;
                    } else {
                        class10.preferences.rememberedUsername = null;
                    }

                    class54.method1018();
                    rights = ((class157) object_0).vmethod3353();
                    field776 = ((class157) object_0).vmethod3353() == 1;
                    localInteractingIndex = ((class157) object_0).vmethod3353();
                    localInteractingIndex <<= 8;
                    localInteractingIndex += ((class157) object_0).vmethod3353();
                    field698 = ((class157) object_0).vmethod3353();
                    ((class157) object_0).vmethod3351(packetbuffer_0.payload, 0, 1);
                    packetbuffer_0.offset = 0;
                    final ServerPacket[] serverpackets_0 = new ServerPacket[]{ServerPacket.NPC_DIALOGUE_HEAD,
                            ServerPacket.field2050, ServerPacket.field2051, ServerPacket.SCRIPT,
                            ServerPacket.field2053, ServerPacket.SYS_UPDATE, ServerPacket.field2055,
                            ServerPacket.ITEM_CONTAINER, ServerPacket.NPC_UPDATE_LARGE_VIEW, ServerPacket.PROJECTILE,
                            ServerPacket.SKILL_UPDATE, ServerPacket.CLOSE_INTERFACE, ServerPacket.ANIMATE_OBJECT,
                            ServerPacket.UPDATE_IGNORE_LIST, ServerPacket.MOVE_INTERFACE, ServerPacket.field2106,
                            ServerPacket.INTERFACE_ROOT, ServerPacket.PLAYER_MENU_OPTION, ServerPacket.field2128,
                            ServerPacket.field2105, ServerPacket.INTERFACE_HIDDEN, ServerPacket.SERVER_MESSAGE,
                            ServerPacket.ITEM_CONTAINER_UPDATE, ServerPacket.field2072, ServerPacket.CLAN_CHAT_MESSAGE,
                            ServerPacket.field2074, ServerPacket.RESET_MAP_FLAG, ServerPacket.field2058,
                            ServerPacket.DESTORY_ITEM_CONTAINER, ServerPacket.MUSIC, ServerPacket.ADD_PRIVATE_MESSAGE_RECEIVED,
                            ServerPacket.field2080, ServerPacket.GRAPHIC, ServerPacket.NPC_UPDATE,
                            ServerPacket.field2079, ServerPacket.INTERFACE_CONFIG, ServerPacket.LOAD_REGION,
                            ServerPacket.INTERFACE_TEXT, ServerPacket.field2087, ServerPacket.field2088,
                            ServerPacket.field2089, ServerPacket.SET_ALIGNMENT, ServerPacket.ADD_PRIVATE_MESSAGE_SENT,
                            ServerPacket.SEND_AREA_SOUND, ServerPacket.field2093, ServerPacket.REFRESH_GAMEFRAME,
                            ServerPacket.RUN_ENERGY, ServerPacket.field2096, ServerPacket.field2097,
                            ServerPacket.VARP_SMALL, ServerPacket.VARP_BIG, ServerPacket.RESET_CAMERA,
                            ServerPacket.field2101, ServerPacket.WEIGHT, ServerPacket.SEND_ITEM,
                            ServerPacket.field2104, ServerPacket.PLAYER_UPDATE, ServerPacket.RESET_VARPS,
                            ServerPacket.field2119, ServerPacket.field2108, ServerPacket.SEND_HINT_ICON,
                            ServerPacket.ADD_GROUND_ITEM, ServerPacket.REGION_COORDINATES, ServerPacket.field2112,
                            ServerPacket.field2113, ServerPacket.ANIMATE_INTERFACE, ServerPacket.field2115,
                            ServerPacket.field2073, ServerPacket.LOGOUT, ServerPacket.SHAKE_CAMERA,
                            ServerPacket.PLAYER_DIALOGUE_HEAD, ServerPacket.SEND_FRIENDS_LIST, ServerPacket.field2121,
                            ServerPacket.field2103, ServerPacket.field2120, ServerPacket.REMOVE_GROUND_ITEM,
                            ServerPacket.field2125, ServerPacket.field2130, ServerPacket.SOUND_EFFECT,
                            ServerPacket.OPEN_INTERFACE, ServerPacket.CLEAR_CHUNK, ServerPacket.LOAD_DYNAMIC_REGION,
                            ServerPacket.MAP_STATE, ServerPacket.field2132, ServerPacket.CLAN_CHAT_SETTINGS,
                            ServerPacket.OPEN_URL, ServerPacket.JOURNAL, ServerPacket.JOURNAL_ENTRY,
                            ServerPacket.WIDGET_TIMER, ServerPacket.SHOP_INTERFACE, ServerPacket.TELEPORT_INTERFACE,
                            ServerPacket.DROP_TABLE_INTERFACE, ServerPacket.ACCOUNT_MANAGEMENT_INTERFACE,
                            ServerPacket.LOYALTY_INTERFACE, ServerPacket.DISCORD_PRESENCE, ServerPacket.SKILL_INTERFACE};
                    int_2 = packetbuffer_0.method3841();
                    if ((int_2 < 0) || (int_2 >= serverpackets_0.length)) {
                        throw new IOException(int_2 + " " + packetbuffer_0.offset);
                    }

                    field626.serverPacket = serverpackets_0[int_2];
                    field626.packetLength = field626.serverPacket.packetLength;
                    ((class157) object_0).vmethod3351(packetbuffer_0.payload, 0, 2);
                    packetbuffer_0.offset = 0;
                    field626.packetLength = packetbuffer_0.readUnsignedShort();

                    try {
                        class41.method702(Buffer.clientInstance, "zap");
                    } catch (final Throwable throwable_0) {
                    }

                    loginState = 10;
                }

                if (loginState != 10) {
                    if ((loginState == 11) && (((class157) object_0).vmethod3349() >= 2)) {
                        packetbuffer_0.offset = 0;
                        ((class157) object_0).vmethod3351(packetbuffer_0.payload, 0, 2);
                        packetbuffer_0.offset = 0;
                        IndexData.field3192 = packetbuffer_0.readUnsignedShort();
                        loginState = 12;
                    }

                    if ((loginState == 12) && (((class157) object_0).vmethod3349() >= IndexData.field3192)) {
                        packetbuffer_0.offset = 0;
                        ((class157) object_0).vmethod3351(packetbuffer_0.payload, 0, IndexData.field3192);
                        packetbuffer_0.offset = 0;
                        final String string_0 = packetbuffer_0.readString();
                        final String string_1 = packetbuffer_0.readString();
                        final String string_2 = packetbuffer_0.readString();
                        GrandExchangeEvent.method22(string_0, string_1, string_2);
                        MouseInput.setGameState(10);
                    }

                    if (loginState == 13) {
                        if (field626.packetLength == -1) {
                            if (((class157) object_0).vmethod3349() < 2) {
                                return;
                            }

                            ((class157) object_0).vmethod3351(packetbuffer_0.payload, 0, 2);
                            packetbuffer_0.offset = 0;
                            field626.packetLength = packetbuffer_0.readUnsignedShort();
                        }

                        if (((class157) object_0).vmethod3349() >= field626.packetLength) {
                            ((class157) object_0).vmethod3351(packetbuffer_0.payload, 0, field626.packetLength);
                            packetbuffer_0.offset = 0;
                            int_7 = field626.packetLength;
                            field804.method5249();
                            WorldMapManager.method484();
                            class37.initializeGPI(packetbuffer_0);
                            if (int_7 != packetbuffer_0.offset) {
                                throw new RuntimeException();
                            }
                        }
                    } else {
                        ++field616;
                        if (field616 > 2000) {
                            if (field617 < 1) {
                                if (class26.port1 == class290.myWorldPort) {
                                    class290.myWorldPort = class68.port2;
                                } else {
                                    class290.myWorldPort = class26.port1;
                                }

                                ++field617;
                                loginState = 0;
                            } else {
                                class33.method559(-3);
                            }
                        }
                    }
                } else {
                    if (((class157) object_0).vmethod3349() >= field626.packetLength) {
                        packetbuffer_0.offset = 0;
                        ((class157) object_0).vmethod3351(packetbuffer_0.payload, 0, field626.packetLength);
                        field804.method5247();
                        mouseLastLastPressedTimeMillis = 1L;
                        field595 = -1;
                        class26.mouseRecorder.index = 0;
                        WorldMapType1.field146 = true;
                        field847 = true;
                        field722 = -1L;
                        Bounds.method5697();
                        field626.method1978();
                        field626.packetBuffer.offset = 0;
                        field626.serverPacket = null;
                        field626.field1215 = null;
                        field626.field1226 = null;
                        field626.field1227 = null;
                        field626.packetLength = 0;
                        field626.field1228 = 0;
                        field598 = 0;
                        field627 = 0;
                        hintArrowTargetType = 0;
                        menuOptionCount = 0;
                        isMenuOpen = false;
                        Item.method1866(0);
                        PacketNode.method3456();
                        itemSelectionState = 0;
                        spellSelected = false;
                        queuedSoundEffectCount = 0;
                        mapAngle = 0;
                        field655 = 0;
                        class21.field175 = null;
                        field810 = 0;
                        field651 = -1;
                        destinationX = 0;
                        destinationY = 0;
                        playerAttackOption = AttackOption.AttackOption_hidden;
                        npcAttackOption = AttackOption.AttackOption_hidden;
                        npcIndexesCount = 0;
                        TextureProvider.method2562();

                        for (int_7 = 0; int_7 < 2048; int_7++) {
                            cachedPlayers[int_7] = null;
                        }

                        for (int_7 = 0; int_7 < 32768; int_7++) {
                            cachedNPCs[int_7] = null;
                        }

                        field707 = -1;
                        projectiles.clear();
                        graphicsObjectDeque.clear();

                        for (int_7 = 0; int_7 < 4; int_7++) {
                            for (int_0 = 0; int_0 < 104; int_0++) {
                                for (int_6 = 0; int_6 < 104; int_6++) {
                                    groundItemDeque[int_7][int_0][int_6] = null;
                                }
                            }
                        }

                        pendingSpawns = new Deque();
                        DState.friendManager.method1628();

                        for (int_7 = 0; int_7 < VarPlayerType.field3232; int_7++) {
                            final VarPlayerType varplayertype_0 = Actor.method1549(int_7);
                            if (varplayertype_0 != null) {
                                class225.serverVarps[int_7] = 0;
                                class225.clientVarps[int_7] = 0;
                            }
                        }

                        MapLabel.varcs.reset();
                        field748 = -1;
                        if (widgetRoot != -1) {
                            Preferences.method1622(widgetRoot);
                        }

                        for (WidgetNode widgetnode_0 = (WidgetNode) componentTable
                                .first(); widgetnode_0 != null; widgetnode_0 = (WidgetNode) componentTable.next()) {
                            WorldMapData.closeWidget(widgetnode_0, true);
                        }

                        widgetRoot = -1;
                        componentTable = new HashTable(8);
                        field744 = null;
                        menuOptionCount = 0;
                        isMenuOpen = false;
                        customizedAppearance.method4462(null, new int[]{0, 0, 0, 0, 0}, false, -1);

                        for (int_7 = 0; int_7 < 8; int_7++) {
                            playerOptions[int_7] = null;
                            playerOptionsPriorities[int_7] = false;
                        }

                        ItemContainer.itemContainers = new HashTable(32);
                        field625 = true;

                        for (int_7 = 0; int_7 < 100; int_7++) {
                            field697[int_7] = true;
                        }

                        World.method1604();
                        WorldMapType3.clanMemberManager = null;

                        for (int_7 = 0; int_7 < 8; int_7++) {
                            grandExchangeOffers[int_7] = new GrandExchangeOffer();
                        }

                        WorldMapDecoration.grandExchangeEvents = null;
                        class37.initializeGPI(packetbuffer_0);
                        WorldMapType2.field224 = -1;
                        class51.xteaChanged(false, packetbuffer_0);
                        field626.serverPacket = null;
                    }

                }
            }
        } catch (final IOException ioexception_0) {
            if (field617 < 1) {
                if (class290.myWorldPort == class26.port1) {
                    class290.myWorldPort = class68.port2;
                } else {
                    class290.myWorldPort = class26.port1;
                }

                ++field617;
                loginState = 0;
            } else {
                class33.method559(-2);
            }
        }
    }

    void method1143() {
        if (field598 > 1) {
            --field598;
        }

        if (field627 > 0) {
            --field627;
        }

        if (socketError) {
            socketError = false;
            WorldMapManager.method516();
        } else {
            if (!isMenuOpen) {
                class59.method1077();
            }

            int int_0;
            for (int_0 = 0; (int_0 < 100) && method1147(field626); int_0++) {
            }

            if (gameState == 30) {
                while (true) {
                    final ClassInfo classinfo_0 = (ClassInfo) class313.classInfos.last();
                    boolean bool_0;
                    bool_0 = classinfo_0 != null;

                    int int_1;
                    PacketNode packetnode_2;
                    if (!bool_0) {
                        PacketNode packetnode_0;
                        int int_2;
                        if (field804.field3597) {
                            packetnode_0 = class26.method433(ClientPacket.field2201, field626.field1218);
                            packetnode_0.packetBuffer.putByte(0);
                            int_2 = packetnode_0.packetBuffer.offset;
                            field804.method5245(packetnode_0.packetBuffer);
                            packetnode_0.packetBuffer.method3545(packetnode_0.packetBuffer.offset - int_2);
                            field626.method1980(packetnode_0);
                            field804.method5248();
                        }

                        int int_3;
                        int int_4;
                        int int_5;
                        int int_6;
                        int int_7;
                        int int_8;
                        int int_9;
                        synchronized (class26.mouseRecorder.lock) {
                            if (!field580) {
                                class26.mouseRecorder.index = 0;
                            } else if ((MouseInput.mouseLastButton != 0) || (class26.mouseRecorder.index >= 40)) {
                                packetnode_2 = class26.method433(ClientPacket.field2228, field626.field1218);
                                packetnode_2.packetBuffer.putByte(0);
                                int_1 = packetnode_2.packetBuffer.offset;
                                int_3 = 0;

                                for (int_4 = 0; (int_4 < class26.mouseRecorder.index)
                                        && ((packetnode_2.packetBuffer.offset - int_1) < 240); int_4++) {
                                    ++int_3;
                                    int_5 = class26.mouseRecorder.ys[int_4];
                                    if (int_5 < 0) {
                                        int_5 = 0;
                                    } else if (int_5 > 502) {
                                        int_5 = 502;
                                    }

                                    int_6 = class26.mouseRecorder.xs[int_4];
                                    if (int_6 < 0) {
                                        int_6 = 0;
                                    } else if (int_6 > 764) {
                                        int_6 = 764;
                                    }

                                    int_7 = int_6 + (int_5 * 765);
                                    if ((class26.mouseRecorder.ys[int_4] == -1)
                                            && (class26.mouseRecorder.xs[int_4] == -1)) {
                                        int_6 = -1;
                                        int_5 = -1;
                                        int_7 = 524287;
                                    }

                                    if ((int_6 == field593) && (int_5 == field594)) {
                                        if (field595 < 2047) {
                                            ++field595;
                                        }
                                    } else {
                                        int_8 = int_6 - field593;
                                        field593 = int_6;
                                        int_9 = int_5 - field594;
                                        field594 = int_5;
                                        if ((field595 < 8) && (int_8 >= -32) && (int_8 <= 31) && (int_9 >= -32)
                                                && (int_9 <= 31)) {
                                            int_8 += 32;
                                            int_9 += 32;
                                            packetnode_2.packetBuffer.putShort(int_9 + (field595 << 12) + (int_8 << 6));
                                            field595 = 0;
                                        } else if (field595 < 8) {
                                            packetnode_2.packetBuffer.put24bitInt((field595 << 19) + int_7 + 8388608);
                                            field595 = 0;
                                        } else {
                                            packetnode_2.packetBuffer.putInt((field595 << 19) + int_7 + -1073741824);
                                            field595 = 0;
                                        }
                                    }
                                }

                                packetnode_2.packetBuffer.method3545(packetnode_2.packetBuffer.offset - int_1);
                                field626.method1980(packetnode_2);
                                if (int_3 >= class26.mouseRecorder.index) {
                                    class26.mouseRecorder.index = 0;
                                } else {
                                    class26.mouseRecorder.index -= int_3;

                                    for (int_4 = 0; int_4 < class26.mouseRecorder.index; int_4++) {
                                        class26.mouseRecorder.xs[int_4] = class26.mouseRecorder.xs[int_3 + int_4];
                                        class26.mouseRecorder.ys[int_4] = class26.mouseRecorder.ys[int_4 + int_3];
                                    }
                                }
                            }
                        }

                        PacketNode packetnode_1;
                        if ((MouseInput.mouseLastButton == 1)
                                || (!InvType.middleMouseMovesCamera && (MouseInput.mouseLastButton == 4))
                                || (MouseInput.mouseLastButton == 2)) {
                            long long_0 = (MouseInput.mouseLastPressedTimeMillis
                                    - (mouseLastLastPressedTimeMillis * -1L)) / 50L;
                            if (long_0 > 4095L) {
                                long_0 = 4095L;
                            }

                            mouseLastLastPressedTimeMillis = MouseInput.mouseLastPressedTimeMillis * -1L;
                            int_1 = MouseInput.mouseLastPressedY;
                            if (int_1 < 0) {
                                int_1 = 0;
                            } else if (int_1 > BuildType.canvasHeight) {
                                int_1 = BuildType.canvasHeight;
                            }

                            int_3 = MouseInput.mouseLastPressedX;
                            if (int_3 < 0) {
                                int_3 = 0;
                            } else if (int_3 > Varcs.canvasWidth) {
                                int_3 = Varcs.canvasWidth;
                            }

                            int_4 = (int) long_0;
                            packetnode_1 = class26.method433(ClientPacket.field2188, field626.field1218);
                            packetnode_1.packetBuffer
                                    .putShort((MouseInput.mouseLastButton == 2 ? 1 : 0) + (int_4 << 1));
                            packetnode_1.packetBuffer.putShort(int_3);
                            packetnode_1.packetBuffer.putShort(int_1);
                            field626.method1980(packetnode_1);
                        }

                        if (KeyFocusListener.field349 > 0) {
                            packetnode_0 = class26.method433(ClientPacket.field2218, field626.field1218);
                            packetnode_0.packetBuffer.putShort(0);
                            int_2 = packetnode_0.packetBuffer.offset;
                            final long long_1 = Buffer.safeCurrentTimeMillis();

                            for (int_4 = 0; int_4 < KeyFocusListener.field349; int_4++) {
                                long long_2 = long_1 - field722;
                                if (long_2 > 16777215L) {
                                    long_2 = 16777215L;
                                }

                                field722 = long_1;
                                packetnode_0.packetBuffer.putByte(KeyFocusListener.field338[int_4]);
                                packetnode_0.packetBuffer.method3731((int) long_2);
                            }

                            packetnode_0.packetBuffer.method3614(packetnode_0.packetBuffer.offset - int_2);
                            field626.method1980(packetnode_0);
                        }

                        if (field664 > 0) {
                            --field664;
                        }

                        if (KeyFocusListener.keyPressed[96] || KeyFocusListener.keyPressed[97]
                                || KeyFocusListener.keyPressed[98] || KeyFocusListener.keyPressed[99]) {
                            field807 = true;
                        }

                        if (field807 && (field664 <= 0)) {
                            field664 = 20;
                            field807 = false;
                            packetnode_0 = class26.method433(ClientPacket.field2183, field626.field1218);
                            packetnode_0.packetBuffer.addLEShort(cameraPitchTarget);
                            packetnode_0.packetBuffer.putShort(mapAngle);
                            field626.method1980(packetnode_0);
                        }

                        if (WorldMapType1.field146 && !field847) {
                            field847 = true;
                            packetnode_0 = class26.method433(ClientPacket.field2227, field626.field1218);
                            packetnode_0.packetBuffer.putByte(1);
                            field626.method1980(packetnode_0);
                        }

                        if (!WorldMapType1.field146 && field847) {
                            field847 = false;
                            packetnode_0 = class26.method433(ClientPacket.field2227, field626.field1218);
                            packetnode_0.packetBuffer.putByte(0);
                            field626.method1980(packetnode_0);
                        }

                        if (ItemContainer.renderOverview != null) {
                            ItemContainer.renderOverview.method6013();
                        }

                        if (class54.field489) {
                            if (WorldMapType3.clanMemberManager != null) {
                                WorldMapType3.clanMemberManager.method5337();
                            }

                            for (int_0 = 0; int_0 < class81.playerIndexesCount; int_0++) {
                                final Player player_1 = cachedPlayers[class81.playerIndices[int_0]];
                                player_1.method1086();
                            }

                            class54.field489 = false;
                        }

                        Varcs.method1894();
                        if (gameState != 30) {
                            return;
                        }

                        for (PendingSpawn pendingspawn_0 = (PendingSpawn) pendingSpawns
                                .getFront(); pendingspawn_0 != null; pendingspawn_0 = (PendingSpawn) pendingSpawns
                                .getNext()) {
                            if (pendingspawn_0.hitpoints > 0) {
                                --pendingspawn_0.hitpoints;
                            }

                            ObjectComposition objectcomposition_0;
                            boolean bool_1;
                            if (pendingspawn_0.hitpoints == 0) {
                                if (pendingspawn_0.field859 >= 0) {
                                    int_1 = pendingspawn_0.field859;
                                    int_3 = pendingspawn_0.field866;
                                    objectcomposition_0 = FileOnDisk.getObjectDefinition(int_1);
                                    if (int_3 == 11) {
                                        int_3 = 10;
                                    }

                                    if ((int_3 >= 5) && (int_3 <= 8)) {
                                        int_3 = 4;
                                    }

                                    bool_1 = objectcomposition_0.method5048(int_3);
                                    if (!bool_1) {
                                        continue;
                                    }
                                }

                                LoginPacket.method3449(pendingspawn_0.level, pendingspawn_0.type, pendingspawn_0.x,
                                        pendingspawn_0.y, pendingspawn_0.field859, pendingspawn_0.field865,
                                        pendingspawn_0.field866);
                                pendingspawn_0.unlink();
                            } else {
                                if (pendingspawn_0.delay > 0) {
                                    --pendingspawn_0.delay;
                                }

                                if ((pendingspawn_0.delay == 0) && (pendingspawn_0.x >= 1) && (pendingspawn_0.y >= 1)
                                        && (pendingspawn_0.x <= 102) && (pendingspawn_0.y <= 102)) {
                                    if (pendingspawn_0.id >= 0) {
                                        int_1 = pendingspawn_0.id;
                                        int_3 = pendingspawn_0.field864;
                                        objectcomposition_0 = FileOnDisk.getObjectDefinition(int_1);
                                        if (int_3 == 11) {
                                            int_3 = 10;
                                        }

                                        if ((int_3 >= 5) && (int_3 <= 8)) {
                                            int_3 = 4;
                                        }

                                        bool_1 = objectcomposition_0.method5048(int_3);
                                        if (!bool_1) {
                                            continue;
                                        }
                                    }

                                    LoginPacket.method3449(pendingspawn_0.level, pendingspawn_0.type, pendingspawn_0.x,
                                            pendingspawn_0.y, pendingspawn_0.id, pendingspawn_0.orientation,
                                            pendingspawn_0.field864);
                                    pendingspawn_0.delay = -1;
                                    if ((pendingspawn_0.field859 == pendingspawn_0.id)
                                            && (pendingspawn_0.field859 == -1)) {
                                        pendingspawn_0.unlink();
                                    } else if ((pendingspawn_0.field859 == pendingspawn_0.id)
                                            && (pendingspawn_0.orientation == pendingspawn_0.field865)
                                            && (pendingspawn_0.field866 == pendingspawn_0.field864)) {
                                        pendingspawn_0.unlink();
                                    }
                                }
                            }
                        }

                        ObjectComposition.method5085();
                        ++field626.field1228;
                        if (field626.field1228 > 750) {
                            WorldMapManager.method516();
                            return;
                        }

                        int_0 = class81.playerIndexesCount;
                        final int[] ints_0 = class81.playerIndices;

                        for (int_1 = 0; int_1 < int_0; int_1++) {
                            final Player player_0 = cachedPlayers[ints_0[int_1]];
                            if (player_0 != null) {
                                class59.method1080(player_0, 1);
                            }
                        }

                        for (int_0 = 0; int_0 < npcIndexesCount; int_0++) {
                            int_2 = npcIndices[int_0];
                            final NPC npc_0 = cachedNPCs[int_2];
                            if (npc_0 != null) {
                                class59.method1080(npc_0, npc_0.composition.size);
                            }
                        }

                        final int[] ints_1 = class81.playerIndices;

                        for (int_2 = 0; int_2 < class81.playerIndexesCount; int_2++) {
                            final Player player_2 = cachedPlayers[ints_1[int_2]];
                            if ((player_2 != null) && (player_2.overheadTextCyclesRemaining > 0)) {
                                --player_2.overheadTextCyclesRemaining;
                                if (player_2.overheadTextCyclesRemaining == 0) {
                                    player_2.overhead = null;
                                }
                            }
                        }

                        for (int_2 = 0; int_2 < npcIndexesCount; int_2++) {
                            int_1 = npcIndices[int_2];
                            final NPC npc_1 = cachedNPCs[int_1];
                            if ((npc_1 != null) && (npc_1.overheadTextCyclesRemaining > 0)) {
                                --npc_1.overheadTextCyclesRemaining;
                                if (npc_1.overheadTextCyclesRemaining == 0) {
                                    npc_1.overhead = null;
                                }
                            }
                        }

                        ++field700;
                        if (cursorState != 0) {
                            field803 += 20;
                            if (field803 >= 400) {
                                cursorState = 0;
                            }
                        }

                        if (class240.field3096 != null) {
                            ++mouseCrosshair;
                            if (mouseCrosshair >= 15) {
                                Player.method1114(class240.field3096);
                                class240.field3096 = null;
                            }
                        }

                        final Widget widget_1 = class143.field1897;
                        final Widget widget_0 = class141.field1888;
                        class143.field1897 = null;
                        class141.field1888 = null;
                        draggedOnWidget = null;
                        field772 = false;
                        field601 = false;
                        field799 = 0;

                        while (GrandExchangeEvents.method8() && (field799 < 128)) {
                            if ((rights >= 2) && KeyFocusListener.keyPressed[82]
                                    && (GameSocket.currentPressedKey == 66)) {
                                String string_0 = "";

                                MessageNode messagenode_0;
                                for (final Iterator iterator_0 = class83.messages.iterator(); iterator_0
                                        .hasNext(); string_0 = string_0 + messagenode_0.name + ':' + messagenode_0.value
                                        + '\n') {
                                    messagenode_0 = (MessageNode) iterator_0.next();
                                }

                                Buffer.clientInstance.method771(string_0);
                            } else if ((field655 != 1) || (KeyFocusListener.currentTypedKey <= 0)) {
                                field773[field799] = GameSocket.currentPressedKey;
                                field800[field799] = KeyFocusListener.currentTypedKey;
                                ++field799;
                            }
                        }

                        if (SoundTaskDataProvider.method696() && KeyFocusListener.keyPressed[82]
                                && KeyFocusListener.keyPressed[81] && (mouseWheelRotation != 0)) {
                            int_1 = class138.localPlayer.field567 - mouseWheelRotation;
                            if (int_1 < 0) {
                                int_1 = 0;
                            } else if (int_1 > 3) {
                                int_1 = 3;
                            }

                            if (int_1 != class138.localPlayer.field567) {
                                WorldMapDecoration.method197(class138.localPlayer.pathX[0] + PendingSpawn.baseX,
                                        class138.localPlayer.pathY[0] + baseY, int_1, false);
                            }

                            mouseWheelRotation = 0;
                        }

                        if (widgetRoot != -1) {
                            int_1 = widgetRoot;
                            int_3 = Varcs.canvasWidth;
                            int_4 = BuildType.canvasHeight;
                            if (CombatInfo2.loadWidget(int_1)) {
                                Size.method102(GameCanvas.widgets[int_1], -1, 0, 0, int_3, int_4, 0, 0);
                            }
                        }

                        ++cycleCntr;

                        while (true) {
                            Widget widget_2;
                            Widget widget_3;
                            ScriptEvent scriptevent_0;
                            do {
                                scriptevent_0 = (ScriptEvent) field778.popFront();
                                if (scriptevent_0 == null) {
                                    while (true) {
                                        do {
                                            scriptevent_0 = (ScriptEvent) field779.popFront();
                                            if (scriptevent_0 == null) {
                                                while (true) {
                                                    do {
                                                        scriptevent_0 = (ScriptEvent) field638.popFront();
                                                        if (scriptevent_0 == null) {
                                                            method1233();
                                                            class275.method5239();
                                                            if (draggedWidget != null) {
                                                                method1448();
                                                            }

                                                            PacketNode packetnode_3;
                                                            if (class276.field3559 != null) {
                                                                Player.method1114(class276.field3559);
                                                                ++itemPressedDuration;
                                                                if (MouseInput.mouseCurrentButton == 0) {
                                                                    if (field689) {
                                                                        if ((Occluder.field1819 == class276.field3559)
                                                                                && (field688 != field691)) {
                                                                            final Widget widget_4 = class276.field3559;
                                                                            byte byte_0 = 0;
                                                                            if ((field743 == 1)
                                                                                    && (widget_4.contentType == 206)) {
                                                                                byte_0 = 1;
                                                                            }

                                                                            if (widget_4.itemIds[field691] <= 0) {
                                                                                byte_0 = 0;
                                                                            }

                                                                            if (class140.method3150(class24
                                                                                    .getWidgetClickMask(widget_4))) {
                                                                                int_4 = field688;
                                                                                int_5 = field691;
                                                                                widget_4.itemIds[int_5] = widget_4.itemIds[int_4];
                                                                                widget_4.itemQuantities[int_5] = widget_4.itemQuantities[int_4];
                                                                                widget_4.itemIds[int_4] = -1;
                                                                                widget_4.itemQuantities[int_4] = 0;
                                                                            } else if (byte_0 == 1) {
                                                                                int_4 = field688;
                                                                                int_5 = field691;

                                                                                while (int_5 != int_4) {
                                                                                    if (int_4 > int_5) {
                                                                                        widget_4.method4507(int_4 - 1,
                                                                                                int_4);
                                                                                        --int_4;
                                                                                    } else if (int_4 < int_5) {
                                                                                        widget_4.method4507(int_4 + 1,
                                                                                                int_4);
                                                                                        ++int_4;
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                widget_4.method4507(field691, field688);
                                                                            }

                                                                            packetnode_3 = class26.method433(ClientPacket.MOVE_ITEM, field626.field1218);
                                                                            packetnode_3.packetBuffer.addByteS(byte_0);
                                                                            packetnode_3.packetBuffer.addLEShort(field688);
                                                                            packetnode_3.packetBuffer.addLEInt(class276.field3559.interfaceHash);
                                                                            packetnode_3.packetBuffer.addLEShort(field691);
                                                                            field626.method1980(packetnode_3);
                                                                        }
                                                                    } else if (method1149()) {
                                                                        openMenu(field678, field821);
                                                                    } else if (menuOptionCount > 0) {
                                                                        Player.method1120(field678, field821);
                                                                    }

                                                                    mouseCrosshair = 10;
                                                                    MouseInput.mouseLastButton = 0;
                                                                    class276.field3559 = null;
                                                                } else if ((itemPressedDuration >= RuinMisc.DRAG)
                                                                        && ((MouseInput.mouseLastX > (field678 + RuinMisc.DRAG))
                                                                        || (MouseInput.mouseLastX < (field678
                                                                        - RuinMisc.DRAG))
                                                                        || ((MouseInput.mouseLastY
                                                                        * 673804999) > (field821 + RuinMisc.DRAG))
                                                                        || ((MouseInput.mouseLastY
                                                                        * 673804999) < (field821 - RuinMisc.DRAG)))) {
                                                                    field689 = true;
                                                                }
                                                            }

                                                            if (Region.method2911()) {
                                                                int_1 = Region.selectedRegionTileX;
                                                                int_3 = Region.selectedRegionTileY;
                                                                packetnode_3 = class26.method433(ClientPacket.WALK, field626.field1218);
                                                                packetnode_3.packetBuffer.putByte(5);
                                                                packetnode_3.packetBuffer.putShort(int_1 + PendingSpawn.baseX);
                                                                packetnode_3.packetBuffer.addByteC(KeyFocusListener.keyPressed[82] ? (KeyFocusListener.keyPressed[81] ? 2 : 1) : 0);
                                                                packetnode_3.packetBuffer.addLEShort(int_3 + baseY);
                                                                field626.method1980(packetnode_3);
                                                                Region.method2972();
                                                                lastLeftClickX = MouseInput.mouseLastPressedX;
                                                                lastLeftClickY = MouseInput.mouseLastPressedY;
                                                                cursorState = 1;
                                                                field803 = 0;
                                                                destinationX = int_1;
                                                                destinationY = int_3;
                                                            }

                                                            if (widget_1 != class143.field1897) {
                                                                if (widget_1 != null) {
                                                                    Player.method1114(widget_1);
                                                                }

                                                                if (class143.field1897 != null) {
                                                                    Player.method1114(class143.field1897);
                                                                }
                                                            }

                                                            if ((widget_0 != class141.field1888)
                                                                    && (field623 == field732)) {
                                                                if (widget_0 != null) {
                                                                    Player.method1114(widget_0);
                                                                }

                                                                if (class141.field1888 != null) {
                                                                    Player.method1114(class141.field1888);
                                                                }
                                                            }

                                                            if (class141.field1888 != null) {
                                                                if (field623 < field732) {
                                                                    ++field623;
                                                                    if (field732 == field623) {
                                                                        Player.method1114(class141.field1888);
                                                                    }
                                                                }
                                                            } else if (field623 > 0) {
                                                                --field623;
                                                            }

                                                            DynamicObject.method1962();
                                                            if (field822) {
                                                                int_1 = (class24.field203 * 128) + 64;
                                                                int_3 = (MilliTimer.field1928 * 128) + 64;
                                                                int_4 = WorldMapType2.getTileHeight(int_1, int_3,
                                                                        class13.plane) - class224.field2555;
                                                                if (CacheFile.cameraX < int_1) {
                                                                    CacheFile.cameraX = (((int_1 - CacheFile.cameraX)
                                                                            * Script.field1197) / 1000)
                                                                            + CacheFile.cameraX + FileSystem.field3154;
                                                                    if (CacheFile.cameraX > int_1) {
                                                                        CacheFile.cameraX = int_1;
                                                                    }
                                                                }

                                                                if (CacheFile.cameraX > int_1) {
                                                                    CacheFile.cameraX -= ((Script.field1197
                                                                            * (CacheFile.cameraX - int_1)) / 1000)
                                                                            + FileSystem.field3154;
                                                                    if (CacheFile.cameraX < int_1) {
                                                                        CacheFile.cameraX = int_1;
                                                                    }
                                                                }

                                                                if (SceneTilePaint.cameraZ < int_4) {
                                                                    SceneTilePaint.cameraZ = (((int_4
                                                                            - SceneTilePaint.cameraZ)
                                                                            * Script.field1197) / 1000)
                                                                            + SceneTilePaint.cameraZ
                                                                            + FileSystem.field3154;
                                                                    if (SceneTilePaint.cameraZ > int_4) {
                                                                        SceneTilePaint.cameraZ = int_4;
                                                                    }
                                                                }

                                                                if (SceneTilePaint.cameraZ > int_4) {
                                                                    SceneTilePaint.cameraZ -= ((Script.field1197
                                                                            * (SceneTilePaint.cameraZ - int_4)) / 1000)
                                                                            + FileSystem.field3154;
                                                                    if (SceneTilePaint.cameraZ < int_4) {
                                                                        SceneTilePaint.cameraZ = int_4;
                                                                    }
                                                                }

                                                                if (Coordinates.cameraY < int_3) {
                                                                    Coordinates.cameraY = (((int_3
                                                                            - Coordinates.cameraY) * Script.field1197)
                                                                            / 1000) + Coordinates.cameraY
                                                                            + FileSystem.field3154;
                                                                    if (Coordinates.cameraY > int_3) {
                                                                        Coordinates.cameraY = int_3;
                                                                    }
                                                                }

                                                                if (Coordinates.cameraY > int_3) {
                                                                    Coordinates.cameraY -= ((Script.field1197
                                                                            * (Coordinates.cameraY - int_3)) / 1000)
                                                                            + FileSystem.field3154;
                                                                    if (Coordinates.cameraY < int_3) {
                                                                        Coordinates.cameraY = int_3;
                                                                    }
                                                                }

                                                                int_1 = (class50.field456 * 128) + 64;
                                                                int_3 = (class237.field3082 * 128) + 64;
                                                                int_4 = WorldMapType2.getTileHeight(int_1, int_3,
                                                                        class13.plane) - class11.field68;
                                                                int_5 = int_1 - CacheFile.cameraX;
                                                                int_6 = int_4 - SceneTilePaint.cameraZ;
                                                                int_7 = int_3 - Coordinates.cameraY;
                                                                int_8 = (int) Math
                                                                        .sqrt((int_7 * int_7) + (int_5 * int_5));
                                                                int_9 = (int) (Math.atan2(int_6, int_8) * 325.949D)
                                                                        & 0x7FF;
                                                                final int int_10 = (int) (Math.atan2(int_5, int_7)
                                                                        * -325.949D) & 0x7FF;
                                                                if (int_9 < 128) {
                                                                    int_9 = 128;
                                                                }

                                                                if (int_9 > 383) {
                                                                    int_9 = 383;
                                                                }

                                                                if (class7.cameraPitch < int_9) {
                                                                    class7.cameraPitch = (((int_9 - class7.cameraPitch)
                                                                            * DecorativeObject.field1834) / 1000)
                                                                            + class7.cameraPitch + NPC.field1033;
                                                                    if (class7.cameraPitch > int_9) {
                                                                        class7.cameraPitch = int_9;
                                                                    }
                                                                }

                                                                if (class7.cameraPitch > int_9) {
                                                                    class7.cameraPitch -= ((DecorativeObject.field1834
                                                                            * (class7.cameraPitch - int_9)) / 1000)
                                                                            + NPC.field1033;
                                                                    if (class7.cameraPitch < int_9) {
                                                                        class7.cameraPitch = int_9;
                                                                    }
                                                                }

                                                                int int_11 = int_10 - DynamicObject.cameraYaw;
                                                                if (int_11 > 1024) {
                                                                    int_11 -= 2048;
                                                                }

                                                                if (int_11 < -1024) {
                                                                    int_11 += 2048;
                                                                }

                                                                if (int_11 > 0) {
                                                                    DynamicObject.cameraYaw = ((int_11
                                                                            * DecorativeObject.field1834) / 1000)
                                                                            + DynamicObject.cameraYaw + NPC.field1033;
                                                                    DynamicObject.cameraYaw &= 0x7FF;
                                                                }

                                                                if (int_11 < 0) {
                                                                    DynamicObject.cameraYaw -= ((-int_11
                                                                            * DecorativeObject.field1834) / 1000)
                                                                            + NPC.field1033;
                                                                    DynamicObject.cameraYaw &= 0x7FF;
                                                                }

                                                                int int_12 = int_10 - DynamicObject.cameraYaw;
                                                                if (int_12 > 1024) {
                                                                    int_12 -= 2048;
                                                                }

                                                                if (int_12 < -1024) {
                                                                    int_12 += 2048;
                                                                }

                                                                if (((int_12 < 0) && (int_11 > 0))
                                                                        || ((int_12 > 0) && (int_11 < 0))) {
                                                                    DynamicObject.cameraYaw = int_10;
                                                                }
                                                            }

                                                            WidgetTimer.tick();
                                                            for (int_1 = 0; int_1 < 5; int_1++) {
                                                                ++field705[int_1];
                                                            }

                                                            MapLabel.varcs.process();
                                                            int_1 = class37.method652();
                                                            int_3 = KeyFocusListener.keyboardIdleTicks;
                                                            if ((int_1 > 15000) && (int_3 > 15000)) {
                                                                field627 = 250;
                                                                Item.method1866(14500);
                                                                packetnode_1 = class26.method433(ClientPacket.field2152,
                                                                        field626.field1218);
                                                                field626.method1980(packetnode_1);
                                                            }

                                                            DState.friendManager.method1627();
                                                            ++field626.field1224;
                                                            if (field626.field1224 > 50) {
                                                                packetnode_1 = class26.method433(ClientPacket.field2211,
                                                                        field626.field1218);
                                                                field626.method1980(packetnode_1);
                                                            }

                                                            try {
                                                                field626.method1979();
                                                            } catch (final IOException ioexception_0) {
                                                                WorldMapManager.method516();
                                                            }

                                                            return;
                                                        }

                                                        widget_3 = scriptevent_0.widget;
                                                        if (widget_3.index < 0) {
                                                            break;
                                                        }

                                                        widget_2 = Widget.getWidget(widget_3.parentHash);
                                                    }
                                                    while ((widget_2 == null) || (widget_2.children == null)
                                                            || (widget_3.index >= widget_2.children.length)
                                                            || (widget_3 != widget_2.children[widget_3.index]));

                                                    class68.method1696(scriptevent_0);
                                                }
                                            }

                                            widget_3 = scriptevent_0.widget;
                                            if (widget_3.index < 0) {
                                                break;
                                            }

                                            widget_2 = Widget.getWidget(widget_3.parentHash);
                                        }
                                        while ((widget_2 == null) || (widget_2.children == null)
                                                || (widget_3.index >= widget_2.children.length)
                                                || (widget_3 != widget_2.children[widget_3.index]));

                                        class68.method1696(scriptevent_0);
                                    }
                                }

                                widget_3 = scriptevent_0.widget;
                                if (widget_3.index < 0) {
                                    break;
                                }

                                widget_2 = Widget.getWidget(widget_3.parentHash);
                            }
                            while ((widget_2 == null) || (widget_2.children == null)
                                    || (widget_3.index >= widget_2.children.length)
                                    || (widget_3 != widget_2.children[widget_3.index]));

                            class68.method1696(scriptevent_0);
                        }
                    }

                    packetnode_2 = class26.method433(ClientPacket.field2145, field626.field1218);
                    packetnode_2.packetBuffer.putByte(0);
                    int_1 = packetnode_2.packetBuffer.offset;
                    SceneTilePaint.encodeClassVerifier(packetnode_2.packetBuffer);
                    packetnode_2.packetBuffer.method3545(packetnode_2.packetBuffer.offset - int_1);
                    field626.method1980(packetnode_2);
                }
            }
        }
    }

    void method1145() {
        int int_0 = Varcs.canvasWidth;
        int int_1 = BuildType.canvasHeight;
        if (super.field396 < int_0) {
            int_0 = super.field396;
        }

        if (super.field397 < int_1) {
            int_1 = super.field397;
        }

        if (class10.preferences != null) {
            try {
                final Game client_1 = Buffer.clientInstance;
                final int int_2 = isResized ? 2 : 1;
                class41.method700(client_1, "resize", new Object[]{Integer.valueOf(int_2)});
            } catch (final Throwable throwable_0) {
            }
        }

    }

    void method1146() {
        if (widgetRoot != -1) {
            class21.method270(widgetRoot);
        }

        int int_0;
        for (int_0 = 0; int_0 < widgetCount; int_0++) {
            if (field697[int_0]) {
                field788[int_0] = true;
            }

            field723[int_0] = field697[int_0];
            field697[int_0] = false;
        }

        field830 = gameCycle;
        field729 = -1;
        field730 = -1;
        Occluder.field1819 = null;
        if (widgetRoot != -1) {
            widgetCount = 0;
            class35.method630(widgetRoot, 0, 0, Varcs.canvasWidth, BuildType.canvasHeight, 0, 0, -1);
        }

        Rasterizer2D.noClip();
        if (!isMenuOpen) {
            if (field729 != -1) {
                class51.method997(field729, field730);
            }
        } else {
            class83.method1940();
        }

        if (gameDrawingMode == 3) {
            for (int_0 = 0; int_0 < widgetCount; int_0++) {
                if (field723[int_0]) {
                    Rasterizer2D.fillRectangle(widgetPositionX[int_0], widgetPositionY[int_0], widgetBoundsWidth[int_0],
                            widgetBoundsHeight[int_0], 16711935, 128);
                } else if (field788[int_0]) {
                    Rasterizer2D.fillRectangle(widgetPositionX[int_0], widgetPositionY[int_0], widgetBoundsWidth[int_0],
                            widgetBoundsHeight[int_0], 16711680, 128);
                }
            }
        }

        int_0 = class13.plane;
        final int int_1 = class138.localPlayer.x;
        final int int_2 = class138.localPlayer.y;
        final int int_3 = field700;

        for (class68 class68_0 = (class68) class68.field985
                .getFront(); class68_0 != null; class68_0 = (class68) class68.field985.getNext()) {
            if ((class68_0.field987 != -1) || (class68_0.field986 != null)) {
                int int_4 = 0;
                if (int_1 > class68_0.field984) {
                    int_4 += int_1 - class68_0.field984;
                } else if (int_1 < class68_0.field988) {
                    int_4 += class68_0.field988 - int_1;
                }

                if (int_2 > class68_0.field992) {
                    int_4 += int_2 - class68_0.field992;
                } else if (int_2 < class68_0.field983) {
                    int_4 += class68_0.field983 - int_2;
                }

                if (((int_4 - 64) <= class68_0.field991) && (field815 != 0) && (int_0 == class68_0.field981)) {
                    int_4 -= 64;
                    if (int_4 < 0) {
                        int_4 = 0;
                    }

                    final int int_5 = ((class68_0.field991 - int_4) * field815) / class68_0.field991;
                    if (class68_0.field993 == null) {
                        if (class68_0.field987 >= 0) {
                            final SoundEffect soundeffect_0 = SoundEffect.getTrack(UrlRequester.indexCache4,
                                    class68_0.field987, 0);
                            if (soundeffect_0 != null) {
                                final RawAudioNode rawaudionode_0 = soundeffect_0.method2069()
                                        .applyResampler(OwnWorldComparator.field577);
                                final class103 class103_0 = class103.method2287(rawaudionode_0, 100, int_5);
                                class103_0.method2258(-1);
                                MapIconReference.field310.method2032(class103_0);
                                class68_0.field993 = class103_0;
                            }
                        }
                    } else {
                        class68_0.field993.method2267(int_5);
                    }

                    if (class68_0.field980 == null) {
                        if ((class68_0.field986 != null) && ((class68_0.field990 -= int_3) <= 0)) {
                            final int int_6 = (int) (Math.random() * class68_0.field986.length);
                            final SoundEffect soundeffect_1 = SoundEffect.getTrack(UrlRequester.indexCache4,
                                    class68_0.field986[int_6], 0);
                            if (soundeffect_1 != null) {
                                final RawAudioNode rawaudionode_1 = soundeffect_1.method2069()
                                        .applyResampler(OwnWorldComparator.field577);
                                final class103 class103_1 = class103.method2287(rawaudionode_1, 100, int_5);
                                class103_1.method2258(0);
                                MapIconReference.field310.method2032(class103_1);
                                class68_0.field980 = class103_1;
                                class68_0.field990 = class68_0.field989
                                        + (int) (Math.random() * (class68_0.field982 - class68_0.field989));
                            }
                        }
                    } else {
                        class68_0.field980.method2267(int_5);
                        if (!class68_0.field980.linked()) {
                            class68_0.field980 = null;
                        }
                    }
                } else {
                    if (class68_0.field993 != null) {
                        MapIconReference.field310.method2009(class68_0.field993);
                        class68_0.field993 = null;
                    }

                    if (class68_0.field980 != null) {
                        MapIconReference.field310.method2009(class68_0.field980);
                        class68_0.field980 = null;
                    }
                }
            }
        }

        field700 = 0;
    }

    boolean method1147(final NetWriter netWriter) {
        class157 class157_0 = netWriter.getSocket();
        final PacketBuffer packetBuffer = netWriter.packetBuffer;
        if (class157_0 == null) {
            return false;
        } else {
            String string_0;
            int int_0;
            try {
                if (netWriter.serverPacket == null) {
                    if (netWriter.field1222) {
                        if (!class157_0.vmethod3350(1)) {
                            return false;
                        }

                        class157_0.vmethod3351(netWriter.packetBuffer.payload, 0, 1);
                        netWriter.field1228 = 0;
                        netWriter.field1222 = false;
                    }

                    packetBuffer.offset = 0;
                    if (packetBuffer.method3821()) {
                        if (!class157_0.vmethod3350(1)) {
                            return false;
                        }

                        class157_0.vmethod3351(netWriter.packetBuffer.payload, 1, 1);
                        netWriter.field1228 = 0;
                    }

                    netWriter.field1222 = true;
                    final ServerPacket[] serverPackets = new ServerPacket[]{ServerPacket.NPC_DIALOGUE_HEAD,
                            ServerPacket.field2050, ServerPacket.field2051, ServerPacket.SCRIPT,
                            ServerPacket.field2053, ServerPacket.SYS_UPDATE, ServerPacket.field2055,
                            ServerPacket.ITEM_CONTAINER, ServerPacket.NPC_UPDATE_LARGE_VIEW, ServerPacket.PROJECTILE,
                            ServerPacket.SKILL_UPDATE, ServerPacket.CLOSE_INTERFACE, ServerPacket.ANIMATE_OBJECT,
                            ServerPacket.UPDATE_IGNORE_LIST, ServerPacket.MOVE_INTERFACE, ServerPacket.field2106,
                            ServerPacket.INTERFACE_ROOT, ServerPacket.PLAYER_MENU_OPTION, ServerPacket.field2128,
                            ServerPacket.field2105, ServerPacket.INTERFACE_HIDDEN, ServerPacket.SERVER_MESSAGE,
                            ServerPacket.ITEM_CONTAINER_UPDATE, ServerPacket.field2072, ServerPacket.CLAN_CHAT_MESSAGE,
                            ServerPacket.field2074, ServerPacket.RESET_MAP_FLAG, ServerPacket.field2058,
                            ServerPacket.DESTORY_ITEM_CONTAINER, ServerPacket.MUSIC, ServerPacket.ADD_PRIVATE_MESSAGE_RECEIVED,
                            ServerPacket.field2080, ServerPacket.GRAPHIC, ServerPacket.NPC_UPDATE,
                            ServerPacket.field2079, ServerPacket.INTERFACE_CONFIG, ServerPacket.LOAD_REGION,
                            ServerPacket.INTERFACE_TEXT, ServerPacket.field2087, ServerPacket.field2088,
                            ServerPacket.field2089, ServerPacket.SET_ALIGNMENT, ServerPacket.ADD_PRIVATE_MESSAGE_SENT,
                            ServerPacket.SEND_AREA_SOUND, ServerPacket.field2093, ServerPacket.REFRESH_GAMEFRAME,
                            ServerPacket.RUN_ENERGY, ServerPacket.field2096, ServerPacket.field2097,
                            ServerPacket.VARP_SMALL, ServerPacket.VARP_BIG, ServerPacket.RESET_CAMERA,
                            ServerPacket.field2101, ServerPacket.WEIGHT, ServerPacket.SEND_ITEM,
                            ServerPacket.field2104, ServerPacket.PLAYER_UPDATE, ServerPacket.RESET_VARPS,
                            ServerPacket.field2119, ServerPacket.field2108, ServerPacket.SEND_HINT_ICON,
                            ServerPacket.ADD_GROUND_ITEM, ServerPacket.REGION_COORDINATES, ServerPacket.field2112,
                            ServerPacket.field2113, ServerPacket.ANIMATE_INTERFACE, ServerPacket.field2115,
                            ServerPacket.field2073, ServerPacket.LOGOUT, ServerPacket.SHAKE_CAMERA,
                            ServerPacket.PLAYER_DIALOGUE_HEAD, ServerPacket.SEND_FRIENDS_LIST, ServerPacket.field2121,
                            ServerPacket.field2103, ServerPacket.field2120, ServerPacket.REMOVE_GROUND_ITEM,
                            ServerPacket.field2125, ServerPacket.field2130, ServerPacket.SOUND_EFFECT,
                            ServerPacket.OPEN_INTERFACE, ServerPacket.CLEAR_CHUNK, ServerPacket.LOAD_DYNAMIC_REGION,
                            ServerPacket.MAP_STATE, ServerPacket.field2132, ServerPacket.CLAN_CHAT_SETTINGS,
                            ServerPacket.OPEN_URL, ServerPacket.JOURNAL, ServerPacket.JOURNAL_ENTRY,
                            ServerPacket.WIDGET_TIMER, ServerPacket.SHOP_INTERFACE, ServerPacket.TELEPORT_INTERFACE,
                            ServerPacket.DROP_TABLE_INTERFACE, ServerPacket.ACCOUNT_MANAGEMENT_INTERFACE,
                            ServerPacket.LOYALTY_INTERFACE, ServerPacket.DISCORD_PRESENCE, ServerPacket.SKILL_INTERFACE};
                    int_0 = packetBuffer.method3841();
                    if ((int_0 < 0) || (int_0 >= serverPackets.length)) {
                        throw new IOException(int_0 + " " + packetBuffer.offset);
                    }

                    netWriter.serverPacket = serverPackets[int_0];
                    netWriter.packetLength = netWriter.serverPacket.packetLength;
                }

                if (netWriter.packetLength == -1) {
                    if (!class157_0.vmethod3350(1)) {
                        return false;
                    }

                    netWriter.getSocket().vmethod3351(packetBuffer.payload, 0, 1);
                    netWriter.packetLength = packetBuffer.payload[0] & 0xFF;
                }

                if (netWriter.packetLength == -2) {
                    if (!class157_0.vmethod3350(2)) {
                        return false;
                    }

                    netWriter.getSocket().vmethod3351(packetBuffer.payload, 0, 2);
                    packetBuffer.offset = 0;
                    netWriter.packetLength = packetBuffer.readUnsignedShort();
                }

                if (!class157_0.vmethod3350(netWriter.packetLength)) {
                    return false;
                }

                packetBuffer.offset = 0;
                class157_0.vmethod3351(packetBuffer.payload, 0, netWriter.packetLength);
                netWriter.field1228 = 0;
                field804.method5244();
                netWriter.field1227 = netWriter.field1226;
                netWriter.field1226 = netWriter.field1215;
                netWriter.field1215 = netWriter.serverPacket;
                long long_0;
                long long_1;
                long long_2;
                int int_2;
                int int_3;
                String string_3;
                int int_5;
                String string_6;
                if (ServerPacket.ADD_PRIVATE_MESSAGE_RECEIVED == netWriter.serverPacket) {
                    string_6 = packetBuffer.readString();
                    long_0 = packetBuffer.readUnsignedShort();
                    long_1 = packetBuffer.read24BitInt();
                    final Permission permission_1 = (Permission) class76.forOrdinal(WorldMapData.method216(),
                            packetBuffer.readUnsignedByte());
                    long_2 = (long_0 << 32) + long_1;
                    boolean bool_0 = false;

                    for (int_2 = 0; int_2 < 100; int_2++) {
                        if (long_2 == field797[int_2]) {
                            bool_0 = true;
                            break;
                        }
                    }

                    if (DState.friendManager.isIgnored(new Name(string_6, MapIconReference.loginType))) {
                        bool_0 = true;
                    }

                    if (!bool_0 && (myPlayerIndex == 0)) {
                        field797[field798] = long_2;
                        field798 = (field798 + 1) % 100;

                        String string_4;
                        try {
                            int_3 = packetBuffer.getUSmart();
                            if (int_3 > 32767) {
                                int_3 = 32767;
                            }

                            final byte[] bytes_2 = new byte[int_3];
                            packetBuffer.offset += class300.huffman.decompress(packetBuffer.payload,
                                    packetBuffer.offset, bytes_2, 0, int_3);
                            string_3 = class78.getString(bytes_2, 0, int_3);
                            string_4 = string_3;
                        } catch (final Exception exception_2) {
                            string_4 = "Cabbage";
                        }

                        string_4 = FontTypeFace.appendTags(class51.method998(string_4));
                        byte byte_0;
                        if (permission_1.field3126) {
                            byte_0 = 7;
                        } else {
                            byte_0 = 3;
                        }

                        if (permission_1.field3128 != -1) {
                            int_5 = permission_1.field3128;
                            string_3 = "<img=" + int_5 + ">";
                            class143.sendGameMessage(byte_0, string_3 + string_6, string_4);
                        } else {
                            class143.sendGameMessage(byte_0, string_6, string_4);
                        }
                    }

                    netWriter.serverPacket = null;
                    return true;
                }

                boolean bool_1;
                if (ServerPacket.field2103 == netWriter.serverPacket) {
                    bool_1 = packetBuffer.method3555();
                    if (bool_1) {
                        if (class21.field175 == null) {
                            class21.field175 = new class251();
                        }
                    } else {
                        class21.field175 = null;
                    }

                    netWriter.serverPacket = null;
                    return true;
                }

                int int_6;
                int int_7;
                int int_8;
                int int_9;
                long long_3;
                if (ServerPacket.INTERFACE_CONFIG == netWriter.serverPacket) {
                    int_6 = packetBuffer.readUnsignedShortA(); //min
                    if (int_6 == 65535) {
                        int_6 = -1;
                    }

                    int_7 = packetBuffer.readInt2(); //hash
                    int_0 = packetBuffer.readInt1(); //mask
                    int_8 = packetBuffer.readUnsignedLEShortA(); //max
                    if (int_8 == 65535) {
                        int_8 = -1;
                    }

                    //System.out.println("sendAccessMask(" + (int_7 >> 16) + ", " + (int_7 & 0xffff) + ", " + int_6 + ", " + int_8 + ", " + int_0 + ");");

                    for (int_9 = int_6; int_9 <= int_8; int_9++) {
                        long_3 = ((long) int_7 << 32) + int_9;
                        final Node node_0 = widgetFlags.get(long_3);
                        if (node_0 != null) {
                            node_0.unlink();
                        }

                        widgetFlags.put(new IntegerNode(int_0), long_3);
                    }

                    netWriter.serverPacket = null;
                    return true;
                }


                /**
                 * Custom packet start
                 */

                if (ServerPacket.CLAN_CHAT_SETTINGS == netWriter.serverPacket) {
                    ClanSettingsInterface.update(packetBuffer.readString(), packetBuffer.readByte(), packetBuffer.readByte(), packetBuffer.readByte());
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.OPEN_URL == netWriter.serverPacket) {
                    String url = packetBuffer.readString();
                    boolean copy = packetBuffer.readByte() == 1;
                    HorizontalAlignment.method5156(url, true, false);
                    if(copy)
                        Buffer.clientInstance.method771(url);
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.JOURNAL == netWriter.serverPacket) {
                    int active = packetBuffer.readUnsignedByte();
                    List<Object[]> categories = new ArrayList<Object[]>();
                    while(packetBuffer.offset < netWriter.packetLength)
                        categories.add(new Object[]{packetBuffer.readString(), packetBuffer.getUSmart()});
                    JournalInterface.init(active, categories);
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.JOURNAL_ENTRY == netWriter.serverPacket) {
                    int childId = packetBuffer.getUSmart();
                    String text = packetBuffer.readString();
                    int colorIndex = packetBuffer.readUnsignedByte();
                    JournalInterface.update(childId, text, colorIndex);
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.WIDGET_TIMER == netWriter.serverPacket) {
                    try {
                        int spriteId = packetBuffer.readUnsignedByte();
                        int time = packetBuffer.readUnsignedShort();
                        String name = packetBuffer.readString();
                        String description = packetBuffer.readString();
                        WidgetTimer.add(new WidgetTimer(spriteId, time, name, description));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.SHOP_INTERFACE == netWriter.serverPacket) {
                    String name = packetBuffer.readString();
                    int size = packetBuffer.readShort();
                    int[][] items = new int[size][];
                    int[] itemRemaining = new int[size];
                    Item[] stock = new Item[size];
                    for (int i = 0; i < size; i++) {
                        int itemId = packetBuffer.readShort();
                        int itemCost = packetBuffer.readInt();
                        int remaining = packetBuffer.readInt();
                        itemRemaining[i] = remaining;
                        Item it = new Item(itemId, itemCost);
                        items[i] = new int[] {itemId, itemCost};
                        stock[i] = it;
                    }
                    ShopInterface.init(name, items, itemRemaining);
                    ShopInterface.updateMappedContainer(1124, stock);
                    netWriter.serverPacket = null;
                    return true;
                }

                if(ServerPacket.TELEPORT_INTERFACE == netWriter.serverPacket) {
                    String title = packetBuffer.readString();

                    int catIndex = packetBuffer.readUnsignedByte();
                    String[] cats = new String[packetBuffer.readUnsignedByte()];
                    for(int i = 0; i < cats.length; i++)
                        cats[i] = packetBuffer.readString();

                    int subIndex = packetBuffer.readUnsignedByte();
                    String[] subs = new String[packetBuffer.readUnsignedByte()];
                    for(int i = 0; i < subs.length; i++)
                        subs[i] = packetBuffer.readString();

                    List<String> options = new ArrayList<String>();
                    while(packetBuffer.offset < netWriter.packetLength)
                        options.add(packetBuffer.readString());

                    TeleportInterface.a(title, catIndex, cats, subIndex, subs, (String[])((List)options).toArray(new String[0]));
                    netWriter.serverPacket = null;
                    return true;
                }

                if(ServerPacket.DROP_TABLE_INTERFACE == netWriter.serverPacket) {
                    String name = packetBuffer.readString();
                    int petId = packetBuffer.readUnsignedShort();
                    int petAverage = packetBuffer.readUnsignedShort();
                    List<Integer[]> drops = new ArrayList<Integer[]>();
                    while(packetBuffer.offset < netWriter.packetLength) {
                        Integer[] drop = new Integer[5];
                        drop[0] = packetBuffer.readUnsignedShort();    //id
                        drop[1] = packetBuffer.readUnsignedByte();     //broadcast
                        drop[2] = packetBuffer.readInt();              //min amount
                        drop[3] = packetBuffer.readInt();              //max amount
                        drop[4] = packetBuffer.readUnsignedShort();    //average
                        drops.add(drop);
                    }
                    DropViewerInterface.init(name, petId, petAverage, drops);
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.ACCOUNT_MANAGEMENT_INTERFACE == netWriter.serverPacket) {
                    String donatorStatus = packetBuffer.readString();
                    String username = packetBuffer.readString();
                    byte unreadPMs = packetBuffer.readByte();
                    AccountManagementInterface.init(donatorStatus, username, unreadPMs);
                    netWriter.serverPacket = null;
                    return true;
                }

                if(ServerPacket.LOYALTY_INTERFACE == netWriter.serverPacket) {
                    int dayReward = packetBuffer.readByte();
                    int currentSpree = packetBuffer.readInt();
                    int highestSpree = packetBuffer.readInt();
                    int totalClaimedRewards = packetBuffer.readInt();
                    List<int[]> packs = new ArrayList<int[]>();
                    while(packetBuffer.offset < netWriter.packetLength) {
                        int[] pack = new int[2];
                        pack[0] = packetBuffer.readInt();
                        pack[1] = packetBuffer.readInt();
                        packs.add(pack);
                    }
                    LoyaltyInterface.init(dayReward, currentSpree, highestSpree, totalClaimedRewards, packs);
                    netWriter.serverPacket = null;
                    return true;
                }

                if(ServerPacket.DISCORD_PRESENCE == netWriter.serverPacket) {
                    String status = packetBuffer.readString();
                    if(!Game.DISCORD_PRESENCE.presenceIsNull()) {
                        Game.DISCORD_PRESENCE.updateDetails(status);
                        Game.DISCORD_PRESENCE.updatePresence();
                    }

                    netWriter.serverPacket = null;
                    return true;
                }

                if(ServerPacket.SKILL_INTERFACE == netWriter.serverPacket) {
                    String donatorStatus = packetBuffer.readString();
                    SkillInterface.init(donatorStatus);
                    netWriter.serverPacket = null;
                    return true;
                }

                /**
                 * Custom packet end
                 */

                Widget widget_1;
                int int_10;
                if (ServerPacket.ITEM_CONTAINER_UPDATE == netWriter.serverPacket) {
                    int_6 = packetBuffer.readInt();
                    int_7 = packetBuffer.readUnsignedShort();
                    if (int_6 < -70000) {
                        int_7 += 32768;
                    }

                    if (int_6 >= 0) {
                        widget_1 = Widget.getWidget(int_6);
                    } else {
                        widget_1 = null;
                    }

                    for (; packetBuffer.offset < netWriter.packetLength; class10.setItemTableSlot(int_7, int_8, int_9 - 1, int_10)) {
                        int_8 = packetBuffer.getUSmart();
                        int_9 = packetBuffer.readUnsignedShort();
                        int_10 = 0;
                        if (int_9 != 0) {
                            int_10 = packetBuffer.readUnsignedByte();
                            if (int_10 == 255) {
                                int_10 = packetBuffer.readInt();
                            }
                        }

                        if ((widget_1 != null) && (int_8 >= 0) && (int_8 < widget_1.itemIds.length)) {
                            widget_1.itemIds[int_8] = int_9;
                            widget_1.itemQuantities[int_8] = int_10;
                        }
                    }

                    if (widget_1 != null) {
                        Player.method1114(widget_1);
                    }

                    FontName.method5501();
                    interfaceItemTriggers[(++field767 - 1) & 0x1F] = int_7 & 0x7FFF;
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.field2108 == netWriter.serverPacket) {
                    Coordinates.mapY = packetBuffer.readUnsignedByte();
                    MouseRecorder.mapX = packetBuffer.readUnsignedByteA();

                    while (packetBuffer.offset < netWriter.packetLength) {
                        int_6 = packetBuffer.readUnsignedByte();
                        final class171[] class171s_0 = new class171[]{class171.ADD_GROUND_ITEM, class171.REMOVE_GROUND_ITEM,
                                class171.field2244, class171.field2243, class171.field2245, class171.PROJECTILE,
                                class171.GRAPHIC, class171.ANIMATE_OBJECT, class171.field2247, class171.SEND_AREA_SOUND};
                        final class171 class171_0 = class171s_0[int_6];
                        MapCacheArchiveNames.method479(class171_0);
                    }

                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.LOGOUT == netWriter.serverPacket) {
                    SoundTask.method2213();
                    netWriter.serverPacket = null;
                    return false;
                }

                if (ServerPacket.NPC_DIALOGUE_HEAD == netWriter.serverPacket) {
                    int_6 = packetBuffer.readInt1();
                    int_7 = packetBuffer.readUnsignedShortA();
                    widget_1 = Widget.getWidget(int_6);
                    if ((widget_1.modelType != 2) || (int_7 != widget_1.modelId)) {
                        widget_1.modelType = 2;
                        widget_1.modelId = int_7;
                        Player.method1114(widget_1);
                    }

                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.LOAD_REGION == netWriter.serverPacket) {
                    class51.xteaChanged(false, netWriter.packetBuffer);
                    netWriter.serverPacket = null;
                    return true;
                }

                boolean bool_4;
                if (ServerPacket.INTERFACE_HIDDEN == netWriter.serverPacket) {
                    int_6 = packetBuffer.readInt2();
                    bool_4 = packetBuffer.readUnsignedByteC() == 1;
                    widget_1 = Widget.getWidget(int_6);
                    if (bool_4 != widget_1.isHidden) {
                        widget_1.isHidden = bool_4;
                        Player.method1114(widget_1);
                    }

                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.SCRIPT == netWriter.serverPacket) {
                    string_6 = packetBuffer.readString();
                    final Object[] objects_0 = new Object[string_6.length() + 1];

                    for (int_0 = string_6.length() - 1; int_0 >= 0; --int_0) {
                        if (string_6.charAt(int_0) == 115) {
                            objects_0[int_0 + 1] = packetBuffer.readString();
                        } else {
                            objects_0[int_0 + 1] = new Integer(packetBuffer.readInt());
                        }
                    }
/*
                    String print = "sendClientScript(" + objects_0[0] + ", ";
                    print += ("\"" + string_6 + "\"") + ", ";
                    for(int a = 1; a < objects_0.length; a++) {
                        Object o = objects_0[a];
                        if(o == null)
                            o = "NULL";
                        else if(o instanceof String)
                            o = "\"" + o + "\"";
                        print += o + ", ";
                    }
                    System.out.println(print.substring(0, print.length() - 2) + ");");*/

                    objects_0[0] = new Integer(packetBuffer.readInt());
                    final ScriptEvent scriptevent_0 = new ScriptEvent();
                    scriptevent_0.objs = objects_0;
                    class68.method1696(scriptevent_0);
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.LOAD_DYNAMIC_REGION == netWriter.serverPacket) {
                    class51.xteaChanged(true, netWriter.packetBuffer);
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.field2121 == netWriter.serverPacket) {
                    for (int_6 = 0; int_6 < VarPlayerType.field3232; int_6++) {
                        final VarPlayerType varplayertype_0 = Actor.method1549(int_6);
                        if (varplayertype_0 != null) {
                            class225.serverVarps[int_6] = 0;
                            class225.clientVarps[int_6] = 0;
                        }
                    }

                    FontName.method5501();
                    pendingVarbitCount += 32;
                    netWriter.serverPacket = null;
                    return true;
                }

                long long_4;
                int int_12;
                if (ServerPacket.CLAN_CHAT_MESSAGE == netWriter.serverPacket) {
                    string_6 = packetBuffer.readString();
                    String clanName = packetBuffer.readString();
                    long_1 = packetBuffer.readUnsignedShort();
                    long_3 = packetBuffer.read24BitInt();
                    final Permission permission_0 = (Permission) class76.forOrdinal(WorldMapData.method216(), packetBuffer.readUnsignedByte());
                    long_4 = long_3 + (long_1 << 32);
                    boolean bool_3 = false;

                    for (int_3 = 0; int_3 < 100; int_3++) {
                        if (long_4 == field797[int_3]) {
                            bool_3 = true;
                            break;
                        }
                    }

                    if (permission_0.field3127
                            && DState.friendManager.isIgnored(new Name(string_6, MapIconReference.loginType))) {
                        bool_3 = true;
                    }

                    if (!bool_3 && (myPlayerIndex == 0)) {
                        field797[field798] = long_4;
                        field798 = (field798 + 1) % 100;

                        String string_2;
                        try {
                            int_12 = packetBuffer.getUSmart();
                            if (int_12 > 32767) {
                                int_12 = 32767;
                            }

                            final byte[] bytes_0 = new byte[int_12];
                            packetBuffer.offset += class300.huffman.decompress(packetBuffer.payload, packetBuffer.offset, bytes_0, 0, int_12);
                            final String string_5 = class78.getString(bytes_0, 0, int_12);
                            string_2 = string_5;
                        } catch (final Exception exception_3) {
                            string_2 = "Cabbage";
                        }

                        string_2 = FontTypeFace.appendTags(class51.method998(string_2));
                        if (permission_0.field3128 != -1) {
                            int_5 = permission_0.field3128;
                            string_3 = "<img=" + int_5 + ">";
                            class173.addChatMessage(9, string_3 + string_6, string_2, clanName);
                        } else {
                            class173.addChatMessage(9, string_6, string_2, clanName);
                        }
                    }

                    netWriter.serverPacket = null;
                    return true;
                }
                if (ServerPacket.MAP_STATE == netWriter.serverPacket) {
                    field810 = packetBuffer.readUnsignedByte();
                    netWriter.serverPacket = null;
                    return true;
                }

                String string_7;
                String string_8;
                if (ServerPacket.SERVER_MESSAGE == netWriter.serverPacket) {
                    int_6 = packetBuffer.getUSmart();
                    bool_4 = packetBuffer.readUnsignedByte() == 1;
                    string_7 = "";
                    boolean bool_2 = false;
                    if (bool_4) {
                        string_7 = packetBuffer.readString();
                        if (DState.friendManager.isIgnored(new Name(string_7, MapIconReference.loginType))) {
                            bool_2 = true;
                        }
                    }

                    string_8 = packetBuffer.readString();
                    if (!bool_2) {
                        class143.sendGameMessage(int_6, string_7, string_8);
                    }

                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.SOUND_EFFECT == netWriter.serverPacket) {
                    int_6 = packetBuffer.readUnsignedShort();
                    int_7 = packetBuffer.readUnsignedByte();
                    int_0 = packetBuffer.readUnsignedShort();
                    if ((field814 != 0) && (int_7 != 0) && (queuedSoundEffectCount < 50)) {
                        queuedSoundEffectIDs[queuedSoundEffectCount] = int_6;
                        unknownSoundValues1[queuedSoundEffectCount] = int_7;
                        unknownSoundValues2[queuedSoundEffectCount] = int_0;
                        audioEffects[queuedSoundEffectCount] = null;
                        soundLocations[queuedSoundEffectCount] = 0;
                        ++queuedSoundEffectCount;
                    }

                    netWriter.serverPacket = null;
                    return true;
                }

                int int_13;
                if (ServerPacket.field2097 == netWriter.serverPacket) {
                    field822 = true;
                    class50.field456 = packetBuffer.readUnsignedByte();
                    class237.field3082 = packetBuffer.readUnsignedByte();
                    class11.field68 = packetBuffer.readUnsignedShort();
                    NPC.field1033 = packetBuffer.readUnsignedByte();
                    DecorativeObject.field1834 = packetBuffer.readUnsignedByte();
                    if (DecorativeObject.field1834 >= 100) {
                        int_6 = (class50.field456 * 128) + 64;
                        int_7 = (class237.field3082 * 128) + 64;
                        int_0 = WorldMapType2.getTileHeight(int_6, int_7, class13.plane) - class11.field68;
                        int_8 = int_6 - CacheFile.cameraX;
                        int_9 = int_0 - SceneTilePaint.cameraZ;
                        int_10 = int_7 - Coordinates.cameraY;
                        int_13 = (int) Math.sqrt((int_10 * int_10) + (int_8 * int_8));
                        class7.cameraPitch = (int) (Math.atan2(int_9, int_13) * 325.949D) & 0x7FF;
                        DynamicObject.cameraYaw = (int) (Math.atan2(int_8, int_10) * -325.949D) & 0x7FF;
                        if (class7.cameraPitch < 128) {
                            class7.cameraPitch = 128;
                        }

                        if (class7.cameraPitch > 383) {
                            class7.cameraPitch = 383;
                        }
                    }

                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.REMOVE_GROUND_ITEM == netWriter.serverPacket) {
                    MapCacheArchiveNames.method479(class171.REMOVE_GROUND_ITEM);
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.PLAYER_UPDATE == netWriter.serverPacket) {
                    class216.method4179(packetBuffer, netWriter.packetLength);
                    SoundTask.method2215();
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.ANIMATE_OBJECT == netWriter.serverPacket) {
                    MapCacheArchiveNames.method479(class171.ANIMATE_OBJECT);
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.CLEAR_CHUNK == netWriter.serverPacket) {
                    MouseRecorder.mapX = packetBuffer.readUnsignedByteS();
                    Coordinates.mapY = packetBuffer.readUnsignedByteA();
                    if(MouseRecorder.mapX == 255 && Coordinates.mapY == 255) {
                        /**
                         * Custom!!
                         */
                        for(int localX = 0; localX < 104; localX++) {
                            for(int localY = 0; localY < 104; localY++) {
                                if (groundItemDeque[class13.plane][localX][localY] != null) {
                                    groundItemDeque[class13.plane][localX][localY] = null;
                                    InvType.groundItemSpawned(localX, localY);
                                }
                            }
                        }
                        for (PendingSpawn pendingspawn_0 = (PendingSpawn) pendingSpawns.getFront(); pendingspawn_0 != null; pendingspawn_0 = (PendingSpawn) pendingSpawns.getNext()) {
                            if (pendingspawn_0.level == class13.plane) {
                                pendingspawn_0.hitpoints = 0;
                            }
                        }
                    } else {
                        for (int_6 = MouseRecorder.mapX; int_6 < (MouseRecorder.mapX + 8); int_6++) {
                            for (int_7 = Coordinates.mapY; int_7 < (Coordinates.mapY + 8); int_7++) {
                                if (groundItemDeque[class13.plane][int_6][int_7] != null) {
                                    groundItemDeque[class13.plane][int_6][int_7] = null;
                                    InvType.groundItemSpawned(int_6, int_7);
                                }
                            }
                        }

                        for (PendingSpawn pendingspawn_0 = (PendingSpawn) pendingSpawns.getFront(); pendingspawn_0 != null; pendingspawn_0 = (PendingSpawn) pendingSpawns.getNext()) {
                            if ((pendingspawn_0.x >= MouseRecorder.mapX) && (pendingspawn_0.x < (MouseRecorder.mapX + 8)) && (pendingspawn_0.y >= Coordinates.mapY) && (pendingspawn_0.y < (Coordinates.mapY + 8)) && (pendingspawn_0.level == class13.plane)) {
                                pendingspawn_0.hitpoints = 0;
                            }
                        }
                    }

                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.ADD_GROUND_ITEM == netWriter.serverPacket) {
                    MapCacheArchiveNames.method479(class171.ADD_GROUND_ITEM);
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.SHAKE_CAMERA == netWriter.serverPacket) {
                    int_6 = packetBuffer.readUnsignedByte();
                    int_7 = packetBuffer.readUnsignedByte();
                    int_0 = packetBuffer.readUnsignedByte();
                    int_8 = packetBuffer.readUnsignedByte();
                    field823[int_6] = true;
                    field824[int_6] = int_7;
                    field825[int_6] = int_0;
                    field826[int_6] = int_8;
                    field705[int_6] = 0;
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.PLAYER_MENU_OPTION == netWriter.serverPacket) {
                    int_6 = packetBuffer.readUnsignedByteS();
                    int_7 = packetBuffer.readUnsignedByteC();
                    string_7 = packetBuffer.readString();
                    if ((int_7 >= 1) && (int_7 <= 8)) {
                        if (string_7.equalsIgnoreCase("null")) {
                            string_7 = null;
                        }

                        playerOptions[int_7 - 1] = string_7;
                        playerOptionsPriorities[int_7 - 1] = int_6 == 0;
                    }

                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.field2105 == netWriter.serverPacket) {
                    MapCacheArchiveNames.method479(class171.field2244);
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.SEND_AREA_SOUND == netWriter.serverPacket) {
                    MapCacheArchiveNames.method479(class171.SEND_AREA_SOUND);
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.RESET_MAP_FLAG == netWriter.serverPacket) {
                    destinationX = packetBuffer.readUnsignedByte();
                    if (destinationX == 255) {
                        destinationX = 0;
                    }

                    destinationY = packetBuffer.readUnsignedByte();
                    if (destinationY == 255) {
                        destinationY = 0;
                    }

                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.ITEM_CONTAINER == netWriter.serverPacket) {
                    int_6 = packetBuffer.readInt();
                    int_7 = packetBuffer.readUnsignedShort();
                    if (int_6 < -70000) {
                        int_7 += 32768;
                    }

                    if (int_6 >= 0) {
                        widget_1 = Widget.getWidget(int_6);
                    } else {
                        widget_1 = null;
                    }

                    if (widget_1 != null) {
                        for (int_8 = 0; int_8 < widget_1.itemIds.length; int_8++) {
                            widget_1.itemIds[int_8] = 0;
                            widget_1.itemQuantities[int_8] = 0;
                        }
                    }

                    VertexNormal.method2782(int_7);
                    int_8 = packetBuffer.readUnsignedShort();

                    for (int_9 = 0; int_9 < int_8; int_9++) {
                        int_10 = packetBuffer.readUnsignedByte();
                        if (int_10 == 255) {
                            int_10 = packetBuffer.readInt2();
                        }

                        int_13 = packetBuffer.readUnsignedShort();
                        if ((widget_1 != null) && (int_9 < widget_1.itemIds.length)) {
                            widget_1.itemIds[int_9] = int_13;
                            widget_1.itemQuantities[int_9] = int_10;
                        }

                        class10.setItemTableSlot(int_7, int_9, int_13 - 1, int_10);
                    }

                    if (widget_1 != null) {
                        Player.method1114(widget_1);
                    }

                    FontName.method5501();
                    interfaceItemTriggers[(++field767 - 1) & 0x1F] = int_7 & 0x7FFF;
                    netWriter.serverPacket = null;
                    return true;
                }

                Widget widget_4;
                if (ServerPacket.field2101 == netWriter.serverPacket) {
                    int_6 = packetBuffer.readInt1();
                    int_7 = packetBuffer.readUnsignedShort();
                    int_0 = packetBuffer.readUnsignedLEShortA();
                    int_8 = packetBuffer.readUnsignedLEShort();
                    widget_4 = Widget.getWidget(int_6);
                    if ((int_8 != widget_4.rotationX) || (int_7 != widget_4.rotationZ) || (int_0 != widget_4.modelZoom)) {
                        widget_4.rotationX = int_8;
                        widget_4.rotationZ = int_7;
                        widget_4.modelZoom = int_0;
                        Player.method1114(widget_4);
                    }

                    netWriter.serverPacket = null;
                    return true;
                }

                Widget widget_5;
                if (ServerPacket.SET_ALIGNMENT == netWriter.serverPacket) {
                    int_6 = packetBuffer.readShort();
                    int_7 = packetBuffer.readLEInt();
                    int_0 = packetBuffer.readLEShort();
                    widget_5 = Widget.getWidget(int_7);
                    if ((int_0 != widget_5.originalX) || (int_6 != widget_5.originalY) || (widget_5.dynamicX != 0)
                            || (widget_5.dynamicY != 0)) {
                        widget_5.originalX = int_0;
                        widget_5.originalY = int_6;
                        widget_5.dynamicX = 0;
                        widget_5.dynamicY = 0;
                        Player.method1114(widget_5);
                        widgetMethod0(widget_5);
                        if (widget_5.type == 0) {
                            GameSocket.method3388(GameCanvas.widgets[int_7 >> 16], widget_5, false);
                        }
                    }

                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.field2112 == netWriter.serverPacket) {
                    packetBuffer.offset += 28;
                    if (packetBuffer.checkCrc()) {
                        GZipDecompressor.method3487(packetBuffer, packetBuffer.offset - 28);
                    }

                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.SYS_UPDATE == netWriter.serverPacket) {
                    field598 = packetBuffer.readUnsignedLEShort() * 30;
                    field775 = cycleCntr;
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.SEND_ITEM == netWriter.serverPacket) {
                    int_6 = packetBuffer.readUnsignedShortA();
                    if (int_6 == 65535) {
                        int_6 = -1;
                    }

                    int_7 = packetBuffer.readInt();
                    int_0 = packetBuffer.readLEInt();
                    widget_5 = Widget.getWidget(int_7);
                    ItemComposition itemcomposition_0;
                    if (!widget_5.hasScript) {
                        if (int_6 == -1) {
                            widget_5.modelType = 0;
                            netWriter.serverPacket = null;
                            return true;
                        }

                        itemcomposition_0 = TextureProvider.getItemDefinition(int_6);
                        widget_5.modelType = 4;
                        widget_5.modelId = int_6;
                        widget_5.rotationX = itemcomposition_0.xan2d;
                        widget_5.rotationZ = itemcomposition_0.yan2d;
                        widget_5.modelZoom = (itemcomposition_0.zoom2d * 100) / int_0;
                        Player.method1114(widget_5);
                    } else {
                        widget_5.itemId = int_6;
                        widget_5.itemQuantity = int_0;
                        itemcomposition_0 = TextureProvider.getItemDefinition(int_6);
                        widget_5.rotationX = itemcomposition_0.xan2d;
                        widget_5.rotationZ = itemcomposition_0.yan2d;
                        widget_5.rotationY = itemcomposition_0.zan2d;
                        widget_5.offsetX2d = itemcomposition_0.offsetX2d;
                        widget_5.offsetY2d = itemcomposition_0.offsetY2d;
                        widget_5.modelZoom = itemcomposition_0.zoom2d;
                        if (itemcomposition_0.isStackable == 1) {
                            widget_5.itemAmountSetting = 1;
                        } else {
                            widget_5.itemAmountSetting = 2;
                        }

                        if (widget_5.field2660 > 0) {
                            widget_5.modelZoom = (widget_5.modelZoom * 32) / widget_5.field2660;
                        } else if (widget_5.originalWidth > 0) {
                            widget_5.modelZoom = (widget_5.modelZoom * 32) / widget_5.originalWidth;
                        }

                        Player.method1114(widget_5);
                    }

                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.field2058 == netWriter.serverPacket) {
                    class143.field1899 = PacketBuffer.method3847(packetBuffer.readUnsignedByte());
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.field2104 == netWriter.serverPacket) {
                    int_6 = packetBuffer.readUnsignedByte();
                    Occluder.method3096(int_6);
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.NPC_UPDATE_LARGE_VIEW == netWriter.serverPacket) {
                    FileSystem.updateNpcs(true, packetBuffer);
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.field2073 == netWriter.serverPacket) {
                    field822 = true;
                    class24.field203 = packetBuffer.readUnsignedByte();
                    MilliTimer.field1928 = packetBuffer.readUnsignedByte();
                    class224.field2555 = packetBuffer.readUnsignedShort();
                    FileSystem.field3154 = packetBuffer.readUnsignedByte();
                    Script.field1197 = packetBuffer.readUnsignedByte();
                    if (Script.field1197 >= 100) {
                        CacheFile.cameraX = (class24.field203 * 128) + 64;
                        Coordinates.cameraY = (MilliTimer.field1928 * 128) + 64;
                        SceneTilePaint.cameraZ = WorldMapType2.getTileHeight(CacheFile.cameraX, Coordinates.cameraY,
                                class13.plane) - class224.field2555;
                    }

                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.field2074 == netWriter.serverPacket) {
                    int_6 = packetBuffer.readInt();
                    if (int_6 != field853) {
                        field853 = int_6;
                        if (field655 == 1) {
                            field663 = true;
                        }
                    }

                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.SEND_HINT_ICON == netWriter.serverPacket) {
                    hintArrowTargetType = packetBuffer.readUnsignedByte();
                    if (hintArrowTargetType == 1) {
                        hintArrowNpcTargetIdx = packetBuffer.readUnsignedShort();
                    }

                    if ((hintArrowTargetType >= 2) && (hintArrowTargetType <= 6)) {
                        if (hintArrowTargetType == 2) {
                            hintArrowOffsetX = 64;
                            hintArrowOffsetY = 64;
                        }

                        if (hintArrowTargetType == 3) {
                            hintArrowOffsetX = 0;
                            hintArrowOffsetY = 64;
                        }

                        if (hintArrowTargetType == 4) {
                            hintArrowOffsetX = 128;
                            hintArrowOffsetY = 64;
                        }

                        if (hintArrowTargetType == 5) {
                            hintArrowOffsetX = 64;
                            hintArrowOffsetY = 0;
                        }

                        if (hintArrowTargetType == 6) {
                            hintArrowOffsetX = 64;
                            hintArrowOffsetY = 128;
                        }

                        hintArrowTargetType = 2;
                        hintArrowX = packetBuffer.readUnsignedShort();
                        hintArrowY = packetBuffer.readUnsignedShort();
                        hintArrowOffsetZ = packetBuffer.readUnsignedByte();
                    }

                    if (hintArrowTargetType == 10) {
                        hintArrowPlayerTargetIdx = packetBuffer.readUnsignedShort();
                    }

                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.field2055 == netWriter.serverPacket) {
                    WorldMapRectangle.method172(packetBuffer, netWriter.packetLength);
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.INTERFACE_TEXT == netWriter.serverPacket) {
                    int_6 = packetBuffer.readInt();
                    string_0 = packetBuffer.readString();
                    widget_1 = Widget.getWidget(int_6);
                    if (!string_0.equals(widget_1.text)) {
                        widget_1.text = string_0;
                        Player.method1114(widget_1);
                    }

                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.VARP_BIG == netWriter.serverPacket) {
                    int_6 = packetBuffer.readLEInt();
                    int_7 = packetBuffer.readUnsignedLEShort();
                    if (int_7 >= 20000) {
                        RuinMisc.handleCustomVarp(int_7, int_6);
                        netWriter.serverPacket = null;
                        return true;
                    }
                    class225.serverVarps[int_7] = int_6;
                    if (class225.clientVarps[int_7] != int_6) {
                        class225.clientVarps[int_7] = int_6;
                    }

                    class45.method749(int_7);
                    pendingVarbitChanges[(++pendingVarbitCount - 1) & 0x1F] = int_7;
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.INTERFACE_ROOT == netWriter.serverPacket) {
                    int_6 = packetBuffer.readUnsignedShort();
                    widgetRoot = int_6;
                    method1151(false);
                    class216.method4178(int_6);
                    UrlRequester.runWidgetOnLoadListener(widgetRoot);

                    for (int_7 = 0; int_7 < 100; int_7++) {
                        field697[int_7] = true;
                    }

                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.CLOSE_INTERFACE == netWriter.serverPacket) {
                    int_6 = packetBuffer.readInt();
                    final WidgetNode widgetnode_3 = (WidgetNode) componentTable.get(int_6);
                    if (widgetnode_3 != null) {
                        WorldMapData.closeWidget(widgetnode_3, true);
                    }

                    if (field744 != null) {
                        Player.method1114(field744);
                        field744 = null;
                    }

                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.field2106 == netWriter.serverPacket) {
                    if (WorldMapType3.clanMemberManager != null) {
                        WorldMapType3.clanMemberManager.method5489(packetBuffer);
                    }

                    GrandExchangeEvents.method13();
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.ANIMATE_INTERFACE == netWriter.serverPacket) {
                    int_6 = packetBuffer.readLEShort();
                    int_7 = packetBuffer.readInt2();
                    widget_1 = Widget.getWidget(int_7);
                    if ((int_6 != widget_1.field2595) || (int_6 == -1)) {
                        widget_1.field2595 = int_6;
                        widget_1.field2728 = 0;
                        widget_1.field2613 = 0;
                        Player.method1114(widget_1);
                    }

                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.field2072 == netWriter.serverPacket) {
                    for (int_6 = 0; int_6 < cachedPlayers.length; int_6++) {
                        if (cachedPlayers[int_6] != null) {
                            cachedPlayers[int_6].animation = -1;
                        }
                    }

                    for (int_6 = 0; int_6 < cachedNPCs.length; int_6++) {
                        if (cachedNPCs[int_6] != null) {
                            cachedNPCs[int_6].animation = -1;
                        }
                    }

                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.field2120 == netWriter.serverPacket) {
                    DState.friendManager.method1625();
                    field647 = cycleCntr;
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.SKILL_UPDATE == netWriter.serverPacket) {
                    FontName.method5501();
                    int_6 = packetBuffer.readInt1();
                    int_7 = packetBuffer.readUnsignedByteA();
                    int_0 = packetBuffer.readUnsignedByteC();
                    skillExperiences[int_7] = int_6;
                    boostedSkillLevels[int_7] = int_0;
                    realSkillLevels[int_7] = 1;

                    for (int_8 = 0; int_8 < 98; int_8++) {
                        if (int_6 >= class234.field2779[int_8]) {
                            realSkillLevels[int_7] = int_8 + 2;
                        }
                    }

                    changedSkills[(++changedSkillsCount - 1) & 0x1F] = int_7;
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.field2089 == netWriter.serverPacket) {
                    int_6 = packetBuffer.readInt();
                    int_7 = packetBuffer.readInt();
                    int_0 = class37.method661();
                    final PacketNode packetnode_0 = class26.method433(ClientPacket.field2176, field626.field1218);
                    packetnode_0.packetBuffer.addByteA(GameEngine.FPS);
                    packetnode_0.packetBuffer.addInt1(int_6);
                    packetnode_0.packetBuffer.addInt1(int_7);
                    packetnode_0.packetBuffer.addByteA(int_0);
                    field626.method1980(packetnode_0);
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.WEIGHT == netWriter.serverPacket) {
                    FontName.method5501();
                    weight = packetBuffer.readShort();
                    field775 = cycleCntr;
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.REFRESH_GAMEFRAME == netWriter.serverPacket) {
                    if (widgetRoot != -1) {
                        int_6 = widgetRoot;
                        if (CombatInfo2.loadWidget(int_6)) {
                            class83.method1923(GameCanvas.widgets[int_6], 0);
                        }
                    }

                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.SEND_FRIENDS_LIST == netWriter.serverPacket) {
                    DState.friendManager.method1679(packetBuffer, netWriter.packetLength);
                    field647 = cycleCntr;
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.field2119 == netWriter.serverPacket) {
                    MapCacheArchiveNames.method479(class171.field2247);
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.field2125 == netWriter.serverPacket) {
                    MapCacheArchiveNames.method479(class171.field2243);
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.field2113 == netWriter.serverPacket) {
                    if (netWriter.packetLength == 0) {
                        WorldMapType3.clanMemberManager = null;
                    } else {
                        if (WorldMapType3.clanMemberManager == null) {
                            WorldMapType3.clanMemberManager = new ClanMemberManager(MapIconReference.loginType,
                                    Buffer.clientInstance);
                        }

                        WorldMapType3.clanMemberManager.method5463(packetBuffer);
                    }

                    GrandExchangeEvents.method13();
                    netWriter.serverPacket = null;
                    return true;
                }

                String string_1;
                int int_11;
                if (ServerPacket.field2115 == netWriter.serverPacket) {
                    string_6 = packetBuffer.readString();
                    GameSocket.sessionToken = string_6;

                    try {
                        string_0 = Buffer.clientInstance.getParameter(Parameters.field3596.key);
                        string_7 = Buffer.clientInstance.getParameter(Parameters.field3581.key);
                        String string_9 = string_0 + "settings=" + string_6 + "; version=1; path=/; domain=" + string_7;
                        if (string_6.length() == 0) {
                            string_9 = string_9 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
                        } else {
                            string_8 = string_9 + "; Expires=";
                            long_2 = Buffer.safeCurrentTimeMillis() + 94608000000L;
                            class192.GMT_CALENDAR.setTime(new Date(long_2));
                            final int int_1 = class192.GMT_CALENDAR.get(7);
                            int_2 = class192.GMT_CALENDAR.get(5);
                            int_11 = class192.GMT_CALENDAR.get(2);
                            int_3 = class192.GMT_CALENDAR.get(1);
                            final int int_4 = class192.GMT_CALENDAR.get(11);
                            int_12 = class192.GMT_CALENDAR.get(12);
                            int_5 = class192.GMT_CALENDAR.get(13);
                            string_1 = class192.DAYS_ABBREVIATED[int_1 - 1] + ", " + (int_2 / 10) + (int_2 % 10) + "-"
                                    + class192.MONTHS_ABBREVIATED[0][int_11] + "-" + int_3 + " " + (int_4 / 10) + (int_4 % 10)
                                    + ":" + (int_12 / 10) + (int_12 % 10) + ":" + (int_5 / 10) + (int_5 % 10) + " GMT";
                            string_9 = string_8 + string_1 + "; Max-Age=" + 94608000L;
                        }

                        final Game client_1 = Buffer.clientInstance;
                        string_1 = "document.cookie=\"" + string_9 + "\"";
                        JSObject.getWindow(client_1).eval(string_1);
                    } catch (final Throwable throwable_0) {
                    }

                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.field2080 == netWriter.serverPacket) {
                    int_6 = packetBuffer.readUnsignedByte();
                    if (packetBuffer.readUnsignedByte() == 0) {
                        grandExchangeOffers[int_6] = new GrandExchangeOffer();
                        packetBuffer.offset += 18;
                    } else {
                        --packetBuffer.offset;
                        grandExchangeOffers[int_6] = new GrandExchangeOffer(packetBuffer, false);
                    }

                    field793 = cycleCntr;
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.field2050 == netWriter.serverPacket) {
                    MapCacheArchiveNames.method479(class171.field2245);
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.RUN_ENERGY == netWriter.serverPacket) {
                    FontName.method5501();
                    energy = packetBuffer.readUnsignedByte();
                    field775 = cycleCntr;
                    netWriter.serverPacket = null;
                    return true;
                }

                Widget widget_2;
                if (ServerPacket.field2088 == netWriter.serverPacket) {
                    int_6 = packetBuffer.readLEInt();
                    widget_2 = Widget.getWidget(int_6);

                    for (int_0 = 0; int_0 < widget_2.itemIds.length; int_0++) {
                        widget_2.itemIds[int_0] = -1;
                        widget_2.itemIds[int_0] = 0;
                    }

                    Player.method1114(widget_2);
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.REGION_COORDINATES == netWriter.serverPacket) {
                    Coordinates.mapY = packetBuffer.readUnsignedByteA();
                    MouseRecorder.mapX = packetBuffer.readUnsignedByteS();
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.MUSIC == netWriter.serverPacket) {
                    int_6 = packetBuffer.readUnsignedShortA();
                    if (int_6 == 65535) {
                        int_6 = -1;
                    }

                    if ((int_6 == -1) && !field813) {
                        class9.method88();
                    } else if ((int_6 != -1) && (int_6 != field812) && (field811 != 0) && !field813) {
                        World.method1602(2, Item.indexTrack1, int_6, 0, field811, false);
                    }

                    field812 = int_6;
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.field2051 == netWriter.serverPacket) {
                    int_6 = packetBuffer.method3591();
                    int_7 = packetBuffer.readUnsignedLEShort();
                    if (int_7 == 65535) {
                        int_7 = -1;
                    }

                    class50.method965(int_7, int_6);
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.RESET_CAMERA == netWriter.serverPacket) {
                    field822 = false;

                    for (int_6 = 0; int_6 < 5; int_6++) {
                        field823[int_6] = false;
                    }

                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.field2053 == netWriter.serverPacket) {
                    int_6 = packetBuffer.readInt1();
                    int_7 = packetBuffer.readUnsignedLEShortA();
                    int_0 = (int_7 >> 10) & 0x1F;
                    int_8 = (int_7 >> 5) & 0x1F;
                    int_9 = int_7 & 0x1F;
                    int_10 = (int_8 << 11) + (int_0 << 19) + (int_9 << 3);
                    final Widget widget_6 = Widget.getWidget(int_6);
                    if (int_10 != widget_6.textColor) {
                        widget_6.textColor = int_10;
                        Player.method1114(widget_6);
                    }

                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.PLAYER_DIALOGUE_HEAD == netWriter.serverPacket) {
                    int_6 = packetBuffer.readInt2();
                    widget_2 = Widget.getWidget(int_6);
                    widget_2.modelType = 3;
                    widget_2.modelId = class138.localPlayer.composition.method4483();
                    Player.method1114(widget_2);
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.NPC_UPDATE == netWriter.serverPacket) {
                    FileSystem.updateNpcs(false, packetBuffer);
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.PROJECTILE == netWriter.serverPacket) {
                    MapCacheArchiveNames.method479(class171.PROJECTILE);
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.GRAPHIC == netWriter.serverPacket) {
                    MapCacheArchiveNames.method479(class171.GRAPHIC);
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.field2093 == netWriter.serverPacket) {
                    field795 = packetBuffer.readUnsignedByteC();
                    publicChatMode = packetBuffer.readUnsignedByteC();
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.field2132 == netWriter.serverPacket) {
                    bool_1 = packetBuffer.readUnsignedByte() == 1;
                    if (bool_1) {
                        GraphicsObject.field1013 = Buffer.safeCurrentTimeMillis() - packetBuffer.readLong();
                        WorldMapDecoration.grandExchangeEvents = new GrandExchangeEvents(packetBuffer, true);
                    } else {
                        WorldMapDecoration.grandExchangeEvents = null;
                    }

                    field774 = cycleCntr;
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.VARP_SMALL == netWriter.serverPacket) {
                    final byte byte_1 = packetBuffer.readByteS();
                    int_7 = packetBuffer.readUnsignedLEShort();
                    if (int_7 >= 20000) {
                        RuinMisc.handleCustomVarp(int_7, byte_1);
                        netWriter.serverPacket = null;
                        return true;
                    }
                    class225.serverVarps[int_7] = byte_1;
                    if (class225.clientVarps[int_7] != byte_1) {
                        class225.clientVarps[int_7] = byte_1;
                    }

                    class45.method749(int_7);
                    pendingVarbitChanges[(++pendingVarbitCount - 1) & 0x1F] = int_7;
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.DESTORY_ITEM_CONTAINER == netWriter.serverPacket) {
                    int_6 = packetBuffer.readUnsignedShortA();
                    class177.method3507(int_6);
                    interfaceItemTriggers[(++field767 - 1) & 0x1F] = int_6 & 0x7FFF;
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.field2087 == netWriter.serverPacket) {
                    int_6 = packetBuffer.readUnsignedShort();
                    int_7 = packetBuffer.readLEInt();
                    int_0 = packetBuffer.readUnsignedLEShort();
                    widget_5 = Widget.getWidget(int_7);
                    widget_5.field2732 = int_0 + (int_6 << 16);
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.UPDATE_IGNORE_LIST == netWriter.serverPacket) {
                    DState.friendManager.field975.method5317(packetBuffer, netWriter.packetLength);
                    GameEngine.method910();
                    if (WorldMapType3.clanMemberManager != null) {
                        WorldMapType3.clanMemberManager.method5468();
                    }

                    field647 = cycleCntr;
                    netWriter.serverPacket = null;
                    return true;
                }

                WidgetNode widgetnode_0;
                if (ServerPacket.MOVE_INTERFACE == netWriter.serverPacket) {
                    int_6 = packetBuffer.readInt2();
                    int_7 = packetBuffer.readInt1();
                   // System.out.println("moveInterface(" + (int_7 >> 16) + ", " + (int_7 & 0xffff) + ", " + (int_6 >> 16) + ", " + (int_6 & 0xffff) + ");");
                    final WidgetNode widgetnode_4 = (WidgetNode) componentTable.get(int_6);
                    widgetnode_0 = (WidgetNode) componentTable.get(int_7);
                    if (widgetnode_0 != null) {
                        WorldMapData.closeWidget(widgetnode_0,
                                (widgetnode_4 == null) || (widgetnode_4.id != widgetnode_0.id));
                    }

                    if (widgetnode_4 != null) {
                        widgetnode_4.unlink();
                        componentTable.put(widgetnode_4, int_7);
                    }

                    widget_4 = Widget.getWidget(int_6);
                    if (widget_4 != null) {
                        Player.method1114(widget_4);
                    }

                    widget_4 = Widget.getWidget(int_7);
                    if (widget_4 != null) {
                        Player.method1114(widget_4);
                        GameSocket.method3388(GameCanvas.widgets[widget_4.interfaceHash >>> 16], widget_4, true);
                    }

                    if (widgetRoot != -1) {
                        int_10 = widgetRoot;
                        if (CombatInfo2.loadWidget(int_10)) {
                            class83.method1923(GameCanvas.widgets[int_10], 1);
                        }
                    }

                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.field2096 == netWriter.serverPacket) {
                    final World world_0 = new World();
                    world_0.address = packetBuffer.readString();
                    world_0.id = packetBuffer.readUnsignedShort();
                    int_7 = packetBuffer.readInt();
                    world_0.mask = int_7;
                    MouseInput.setGameState(45);
                    class157_0.vmethod3346();
                    class157_0 = null;
                    OwnWorldComparator.changeWorld(world_0);
                    netWriter.serverPacket = null;
                    return false;
                }

                if (ServerPacket.OPEN_INTERFACE == netWriter.serverPacket) {
                    int_6 = packetBuffer.readUnsignedByteS(); //type (1 = overlay)
                    int_7 = packetBuffer.readLEInt(); //parent hash
                    int_0 = packetBuffer.readUnsignedShortA(); //interfaceHash
                   // System.out.println("openInterface(" + int_0 + ", " + (int_7 >> 16) + ", " + (int_7 & 0xffff) + ", " + int_6 + ");");
                    widgetnode_0 = (WidgetNode) componentTable.get(int_7);
                    if (widgetnode_0 != null) {
                        WorldMapData.closeWidget(widgetnode_0, int_0 != widgetnode_0.id);
                    }

                    final WidgetNode widgetnode_5 = new WidgetNode();
                    widgetnode_5.id = int_0;
                    widgetnode_5.owner = int_6;
                    componentTable.put(widgetnode_5, int_7);
                    class216.method4178(int_0);
                    final Widget widget_3 = Widget.getWidget(int_7);
                    Player.method1114(widget_3);
                    if (field744 != null) {
                        Player.method1114(field744);
                        field744 = null;
                    }

                    LoginPacket.method3448();
                    GameSocket.method3388(GameCanvas.widgets[int_7 >> 16], widget_3, false);
                    UrlRequester.runWidgetOnLoadListener(int_0);
                    if (widgetRoot != -1) {
                        int_13 = widgetRoot;
                        if (CombatInfo2.loadWidget(int_13)) {
                            class83.method1923(GameCanvas.widgets[int_13], 1);
                        }
                    }

                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.field2128 == netWriter.serverPacket) {
                    int_6 = packetBuffer.readInt1();
                    int_7 = packetBuffer.readUnsignedShortA();
                    widget_1 = Widget.getWidget(int_6);
                    if ((widget_1 != null) && (widget_1.type == 0)) {
                        if (int_7 > (widget_1.scrollHeight - widget_1.height)) {
                            int_7 = widget_1.scrollHeight - widget_1.height;
                        }

                        if (int_7 < 0) {
                            int_7 = 0;
                        }

                        if (int_7 != widget_1.scrollY) {
                            widget_1.scrollY = int_7;
                            Player.method1114(widget_1);
                        }
                    }

                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.ADD_PRIVATE_MESSAGE_SENT == netWriter.serverPacket) {
                    string_6 = packetBuffer.readString();

                    try {
                        int_8 = packetBuffer.getUSmart();
                        if (int_8 > 32767) {
                            int_8 = 32767;
                        }

                        final byte[] bytes_1 = new byte[int_8];
                        packetBuffer.offset += class300.huffman.decompress(packetBuffer.payload,
                                packetBuffer.offset, bytes_1, 0, int_8);
                        string_1 = class78.getString(bytes_1, 0, int_8);
                        string_7 = string_1;
                    } catch (final Exception exception_1) {
                        string_7 = "Cabbage";
                    }

                    string_7 = FontTypeFace.appendTags(class51.method998(string_7));
                    class143.sendGameMessage(6, string_6, string_7);
                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.field2079 == netWriter.serverPacket) {
                    int_6 = packetBuffer.offset + netWriter.packetLength;
                    int_7 = packetBuffer.readUnsignedShort();
                    int_0 = packetBuffer.readUnsignedShort();
                    if (int_7 != widgetRoot) {
                        widgetRoot = int_7;
                        method1151(false);
                        class216.method4178(widgetRoot);
                        UrlRequester.runWidgetOnLoadListener(widgetRoot);

                        for (int_8 = 0; int_8 < 100; int_8++) {
                            field697[int_8] = true;
                        }
                    }

                    WidgetNode widgetnode_1;
                    for (; int_0-- > 0; widgetnode_1.field496 = true) {
                        int_8 = packetBuffer.readInt();
                        int_9 = packetBuffer.readUnsignedShort();
                        int_10 = packetBuffer.readUnsignedByte();
                        widgetnode_1 = (WidgetNode) componentTable.get(int_8);
                        if ((widgetnode_1 != null) && (int_9 != widgetnode_1.id)) {
                            WorldMapData.closeWidget(widgetnode_1, true);
                            widgetnode_1 = null;
                        }

                        if (widgetnode_1 == null) {
                            final WidgetNode widgetnode_2 = new WidgetNode();
                            widgetnode_2.id = int_9;
                            widgetnode_2.owner = int_10;
                            componentTable.put(widgetnode_2, int_8);
                            class216.method4178(int_9);
                            final Widget widget_0 = Widget.getWidget(int_8);
                            Player.method1114(widget_0);
                            if (field744 != null) {
                                Player.method1114(field744);
                                field744 = null;
                            }

                            LoginPacket.method3448();
                            GameSocket.method3388(GameCanvas.widgets[int_8 >> 16], widget_0, false);
                            UrlRequester.runWidgetOnLoadListener(int_9);
                            if (widgetRoot != -1) {
                                int_11 = widgetRoot;
                                if (CombatInfo2.loadWidget(int_11)) {
                                    class83.method1923(GameCanvas.widgets[int_11], 1);
                                }
                            }

                            widgetnode_1 = widgetnode_2;
                        }
                    }

                    for (widgetnode_0 = (WidgetNode) componentTable
                            .first(); widgetnode_0 != null; widgetnode_0 = (WidgetNode) componentTable.next()) {
                        if (widgetnode_0.field496) {
                            widgetnode_0.field496 = false;
                        } else {
                            WorldMapData.closeWidget(widgetnode_0, true);
                        }
                    }

                    widgetFlags = new HashTable(512);

                    while (packetBuffer.offset < int_6) {
                        int_8 = packetBuffer.readInt();
                        int_9 = packetBuffer.readUnsignedShort();
                        int_10 = packetBuffer.readUnsignedShort();
                        int_13 = packetBuffer.readInt();

                        for (int int_14 = int_9; int_14 <= int_10; int_14++) {
                            long_4 = ((long) int_8 << 32) + int_14;
                            widgetFlags.put(new IntegerNode(int_13), long_4);
                        }
                    }

                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.RESET_VARPS == netWriter.serverPacket) {
                    for (int_6 = 0; int_6 < class225.clientVarps.length; int_6++) {
                        if (class225.clientVarps[int_6] != class225.serverVarps[int_6]) {
                            class225.clientVarps[int_6] = class225.serverVarps[int_6];
                            class45.method749(int_6);
                            pendingVarbitChanges[(++pendingVarbitCount - 1) & 0x1F] = int_6;
                        }
                    }

                    netWriter.serverPacket = null;
                    return true;
                }

                if (ServerPacket.field2130 == netWriter.serverPacket) {
                    int_6 = packetBuffer.readInt1();
                    int_7 = packetBuffer.readUnsignedShort();
                    widget_1 = Widget.getWidget(int_6);
                    if ((widget_1.modelType != 1) || (int_7 != widget_1.modelId)) {
                        widget_1.modelType = 1;
                        widget_1.modelId = int_7;
                        Player.method1114(widget_1);
                    }

                    netWriter.serverPacket = null;
                    return true;
                }

                UnitPriceComparator.processClientError(
                        "" + (netWriter.serverPacket != null ? netWriter.serverPacket.packetId : -1) + ","
                                + (netWriter.field1226 != null ? netWriter.field1226.packetId : -1) + ","
                                + (netWriter.field1227 != null ? netWriter.field1227.packetId : -1) + ","
                                + netWriter.packetLength,
                        null);
                SoundTask.method2213();
            } catch (final IOException ioexception_0) {
                WorldMapManager.method516();
            } catch (final Exception exception_0) {
                string_0 = "" + (netWriter.serverPacket != null ? netWriter.serverPacket.packetId : -1) + ","
                        + (netWriter.field1226 != null ? netWriter.field1226.packetId : -1) + ","
                        + (netWriter.field1227 != null ? netWriter.field1227.packetId : -1) + ","
                        + netWriter.packetLength + "," + (class138.localPlayer.pathX[0] + PendingSpawn.baseX) + ","
                        + (class138.localPlayer.pathY[0] + baseY) + ",";

                for (int_0 = 0; (int_0 < netWriter.packetLength) && (int_0 < 50); int_0++) {
                    string_0 = string_0 + packetBuffer.payload[int_0] + ",";
                }

                UnitPriceComparator.processClientError(string_0, exception_0);
                SoundTask.method2213();
            }

            return true;
        }
    }

    void method1233() {
        GameObject.method3103();
        if (class276.field3559 == null) {
            if (draggedWidget == null) {
                int int_0 = MouseInput.mouseLastButton;
                int int_1;
                int int_3;
                int int_4;
                int int_5;
                if (isMenuOpen) {
                    int int_2;
                    if ((int_0 != 1) && (InvType.middleMouseMovesCamera || (int_0 != 4))) {
                        int_1 = MouseInput.mouseLastX;
                        int_2 = MouseInput.mouseLastY * 673804999;
                        if ((int_1 < (MouseInput.menuX - 10))
                                || (int_1 > (UrlRequester.field1856 + MouseInput.menuX + 10))
                                || (int_2 < (WorldComparator.menuY - 10))
                                || (int_2 > (class151.field1933 + WorldComparator.menuY + 10))) {
                            isMenuOpen = false;
                            MouseInput.method948(MouseInput.menuX, WorldComparator.menuY, UrlRequester.field1856,
                                    class151.field1933);
                        }
                    }

                    if ((int_0 == 1) || (!InvType.middleMouseMovesCamera && (int_0 == 4))) {
                        int_1 = MouseInput.menuX;
                        int_2 = WorldComparator.menuY;
                        int_3 = UrlRequester.field1856;
                        int_4 = MouseInput.mouseLastPressedX;
                        int_5 = MouseInput.mouseLastPressedY;
                        int int_6 = -1;

                        for (int int_7 = 0; int_7 < menuOptionCount; int_7++) {
                            final int int_8 = int_2 + ((menuOptionCount - 1 - int_7) * 15) + 31;
                            if ((int_4 > int_1) && (int_4 < (int_1 + int_3)) && (int_5 > (int_8 - 13))
                                    && (int_5 < (int_8 + 3))) {
                                int_6 = int_7;
                            }
                        }

                        if (int_6 != -1) {
                            ItemLayer.method2564(int_6);
                        }

                        isMenuOpen = false;
                        MouseInput.method948(MouseInput.menuX, WorldComparator.menuY, UrlRequester.field1856,
                                class151.field1933);
                    }
                } else {
                    int_1 = menuOptionCount - 1;
                    if (((int_0 == 1) || (!InvType.middleMouseMovesCamera && (int_0 == 4))) && (int_1 >= 0)) {
                        int_3 = menuTypes[int_1];
                        if ((int_3 == 39) || (int_3 == 40) || (int_3 == 41) || (int_3 == 42) || (int_3 == 43)
                                || (int_3 == 33) || (int_3 == 34) || (int_3 == 35) || (int_3 == 36) || (int_3 == 37)
                                || (int_3 == 38) || (int_3 == 1005)) {
                            int_4 = menuActionParams0[int_1];
                            int_5 = menuActionParams1[int_1];
                            final Widget widget_0 = Widget.getWidget(int_5);
                            if (class7.method83(class24.getWidgetClickMask(widget_0)) || class140.method3150(class24.getWidgetClickMask(widget_0))) {
                                if ((class276.field3559 != null) && !field689 && (menuOptionCount > 0) && !method1149()) {
                                    Player.method1120(field678, field821);
                                }


                                field689 = false;
                                itemPressedDuration = 0;
                                if (class276.field3559 != null) {
                                    Player.method1114(class276.field3559);
                                }

                                class276.field3559 = Widget.getWidget(int_5);
                                field688 = int_4;
                                field678 = MouseInput.mouseLastPressedX;
                                field821 = MouseInput.mouseLastPressedY;
                                if (int_1 >= 0) {
                                    class229.topContextMenuRow = new ContextMenuRow();
                                    class229.topContextMenuRow.param0 = menuActionParams0[int_1];
                                    class229.topContextMenuRow.param1 = menuActionParams1[int_1];
                                    class229.topContextMenuRow.type = menuTypes[int_1];
                                    class229.topContextMenuRow.identifier = menuIdentifiers[int_1];
                                    class229.topContextMenuRow.option = menuOptions[int_1];
                                }

                                Player.method1114(class276.field3559);
                                return;
                            }
                        }
                    }

                    if (((int_0 == 1) || (!InvType.middleMouseMovesCamera && (int_0 == 4))) && method1149()) {
                        int_0 = 2;
                    }

                    if (((int_0 == 1) || (!InvType.middleMouseMovesCamera && (int_0 == 4))) && (menuOptionCount > 0)) {
                        ItemLayer.method2564(int_1);
                    }

                    if ((int_0 == 2) && (menuOptionCount > 0)) {
                        openMenu(MouseInput.mouseLastPressedX, MouseInput.mouseLastPressedY);
                    }
                }

            }
        }
    }

    boolean method1149() {
        final int int_0 = menuOptionCount - 1;
        return (((field715 == 1) && (menuOptionCount > 2)) || class43.method713(int_0)) && !menuBooleanArray[int_0];
    }

    void openMenu(final int int_0, final int int_1) {
        class184.method3785(int_0, int_1);
        MapIcon.region.method2909(class13.plane, int_0, int_1, false);
        isMenuOpen = true;
    }

    void method1151(final boolean bool_0) {
        Script.method1946(widgetRoot, Varcs.canvasWidth, BuildType.canvasHeight, bool_0);
    }

    static void widgetMethod0(final Widget widget_0) {
        final Widget widget_1 = widget_0.parentHash == -1 ? null : Widget.getWidget(widget_0.parentHash);
        int int_0;
        int int_1;
        if (widget_1 == null) {
            int_0 = Varcs.canvasWidth;
            int_1 = BuildType.canvasHeight;
        } else {
            int_0 = widget_1.width;
            int_1 = widget_1.height;
        }

        CombatInfo1.method1563(widget_0, int_0, int_1, false);
        MapLabel.method281(widget_0, int_0, int_1);
    }

    void method1448() {
        Player.method1114(draggedWidget);
        ++class6.field39;
        if (field772 && field601) {
            int int_0 = MouseInput.mouseLastX;
            int int_1 = MouseInput.mouseLastY * 673804999;
            int_0 -= field753;
            int_1 -= field749;
            if (int_0 < field757) {
                int_0 = field757;
            }

            if ((int_0 + draggedWidget.width) > (field757 + field752.width)) {
                int_0 = (field757 + field752.width) - draggedWidget.width;
            }

            if (int_1 < field758) {
                int_1 = field758;
            }

            if ((int_1 + draggedWidget.height) > (field758 + field752.height)) {
                int_1 = (field758 + field752.height) - draggedWidget.height;
            }

            final int int_2 = int_0 - field696;
            final int int_3 = int_1 - field760;
            final int int_4 = draggedWidget.dragDeadZone;
            if ((class6.field39 > draggedWidget.dragDeadTime)
                    && ((int_2 > int_4) || (int_2 < -int_4) || (int_3 > int_4) || (int_3 < -int_4))) {
                draggingWidget = true;
            }

            final int int_5 = (int_0 - field757) + field752.scrollX;
            final int int_6 = (int_1 - field758) + field752.scrollY;
            ScriptEvent scriptevent_0;
            if ((draggedWidget.onDragListener != null) && draggingWidget) {
                scriptevent_0 = new ScriptEvent();
                scriptevent_0.widget = draggedWidget;
                scriptevent_0.field511 = int_5;
                scriptevent_0.field508 = int_6;
                scriptevent_0.objs = draggedWidget.onDragListener;
                class68.method1696(scriptevent_0);
            }

            if (MouseInput.mouseCurrentButton == 0) {
                if (draggingWidget) {
                    if (draggedWidget.onDragCompleteListener != null) {
                        scriptevent_0 = new ScriptEvent();
                        scriptevent_0.widget = draggedWidget;
                        scriptevent_0.field511 = int_5;
                        scriptevent_0.field508 = int_6;
                        scriptevent_0.field507 = draggedOnWidget;
                        scriptevent_0.objs = draggedWidget.onDragCompleteListener;
                        class68.method1696(scriptevent_0);
                    }

                    if (draggedOnWidget != null) {
                        Widget widget_0 = draggedWidget;
                        final int int_7 = ISAACCipher.method3865(class24.getWidgetClickMask(widget_0));
                        Widget widget_1;
                        if (int_7 == 0) {
                            widget_1 = null;
                        } else {
                            int int_8 = 0;

                            while (true) {
                                if (int_8 >= int_7) {
                                    widget_1 = widget_0;
                                    break;
                                }

                                widget_0 = Widget.getWidget(widget_0.parentHash);
                                if (widget_0 == null) {
                                    widget_1 = null;
                                    break;
                                }

                                ++int_8;
                            }
                        }

                        if (widget_1 != null) {
                            final PacketNode packetnode_0 = class26.method433(ClientPacket.TWO_INTERFACES_MOVE_ITEM, field626.field1218);
                            packetnode_0.packetBuffer.addShortA(draggedWidget.index);
                            packetnode_0.packetBuffer.addLEShortA(draggedWidget.itemId);
                            packetnode_0.packetBuffer.addInt1(draggedOnWidget.interfaceHash);
                            packetnode_0.packetBuffer.addLEShort(draggedOnWidget.itemId);
                            packetnode_0.packetBuffer.addInt2(draggedWidget.interfaceHash);
                            packetnode_0.packetBuffer.putShort(draggedOnWidget.index);
                            field626.method1980(packetnode_0);
                        }
                    }
                } else if (method1149()) {
                    openMenu(field696 + field753, field749 + field760);
                } else if (menuOptionCount > 0) {
                    Player.method1120(field753 + field696, field749 + field760);
                }

                draggedWidget = null;
            }

        } else {
            if (class6.field39 > 1) {
                draggedWidget = null;
            }

        }
    }

    @Override
    public Name vmethod5420() {
        return class138.localPlayer != null ? class138.localPlayer.name : null;
    }

    static long method1535() {
        try {
            final URL url_0 = new URL(class142.method3161("services", false) + "m=accountappeal/login.ws");
            final URLConnection urlconnection_0 = url_0.openConnection();
            urlconnection_0.setRequestProperty("connection", "close");
            urlconnection_0.setDoInput(true);
            urlconnection_0.setDoOutput(true);
            urlconnection_0.setConnectTimeout(5000);
            final OutputStreamWriter outputstreamwriter_0 = new OutputStreamWriter(urlconnection_0.getOutputStream());
            outputstreamwriter_0.write("data1=req");
            outputstreamwriter_0.flush();
            final InputStream inputstream_0 = urlconnection_0.getInputStream();
            final Buffer buffer_0 = new Buffer(new byte[1000]);

            do {
                final int int_0 = inputstream_0.read(buffer_0.payload, buffer_0.offset, 1000 - buffer_0.offset);
                if (int_0 == -1) {
                    buffer_0.offset = 0;
                    final long long_0 = buffer_0.readLong();
                    return long_0;
                }

                buffer_0.offset += int_0;
            }
            while (buffer_0.offset < 1000);

            return 0L;
        } catch (final Exception exception_0) {
            return 0L;
        }
    }

}
