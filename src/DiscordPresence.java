import com.sun.jna.Native;

public class DiscordPresence {

    private DiscordRPC libr = null;
    private DiscordRichPresence presence = null;

    public DiscordRPC getLibrary() {
        return libr;
    }

    public void initiate() {
        try {
            libr = (DiscordRPC) Native.loadLibrary("discord-rpc", DiscordRPC.class);//DiscordRPC.INSTANCE;
        } catch (UnsatisfiedLinkError e) {
            libr = null;
            e.printStackTrace();
            System.err.println("Unable to load Discord RPC (on loadLibrary). Continuing without Rich Presence.");
            return;
        } catch (Exception e) {
            libr = null;
            e.printStackTrace();
            System.err.println("Unable to load Discord RPC (on loadLibrary). Continuing without Rich Presence.");
            return;
        }
        DiscordEventHandlers handlers = new DiscordEventHandlers();
        try {
            libr.Discord_Initialize("405303750874497025", handlers, true, "");
        } catch (Error e) {
            libr = null;
            e.printStackTrace();
            System.err.println("Unable to load Discord RPC (on initialize). Continuing without Rich Presence.");
            return;
        } catch (Exception e) {
            libr = null;
            e.printStackTrace();
            System.err.println("Unable to load Discord RPC (on initialize). Continuing without Rich Presence.");
            return;
        }
        presence = new DiscordRichPresence();
        presence.startTimestamp = System.currentTimeMillis() / 1000;
        presence.state = "Starting the game";
        presence.largeImageKey = "discord_bg_image";
        presence.details = "www.endlesspk.com";

        updatePresence();

        System.out.println("Discord RPC successfully loaded.");

    }

    public boolean presenceIsNull() {
        return presence == null;
    }

    public void updateDetails(String details) {
        presence.state = details;
    }

    public void updateState(String state) {
        presence.state = state;
    }

    public void updateSmallImageKey(String key) {
        presence.smallImageKey = key;
    }

    public void updatePresence() {
        libr.Discord_UpdatePresence(presence);
    }

    public void updateTimestamp(long timestamp) {
        presence.startTimestamp = timestamp;
    }

    public DiscordRichPresence getPresence() {
        return presence;
    }
}