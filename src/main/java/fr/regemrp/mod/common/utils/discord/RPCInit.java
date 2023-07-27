package fr.regemrp.mod.common.utils.discord;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;
import net.minecraft.client.Minecraft;

public class RPCInit {

    public static final DiscordRPC client = DiscordRPC.INSTANCE;
    public static final DiscordRichPresence richpresence = new DiscordRichPresence();
    static Minecraft mc = Minecraft.getMinecraft();

    public static final String DISCORD_ID = "1021019591855571025";
    public static final String DRP_DETAILS = "Questions sans réponses ?";
    public static final String DRP_IMAGE_LARGE = "logo";
    public static final String DRP_IMAGE_LARGE_TEXT = "";
    public static final String DRP_IMAGE_SMALL = "head";

    public static void start() {
        DiscordEventHandlers event = new DiscordEventHandlers();
        client.Discord_Initialize(DISCORD_ID, event, true, "0");
        richpresence.startTimestamp = System.currentTimeMillis() / 1000;
        richpresence.details = DRP_DETAILS;
        richpresence.largeImageKey = DRP_IMAGE_LARGE;
        richpresence.largeImageText = DRP_IMAGE_LARGE_TEXT;
        richpresence.smallImageKey = DRP_IMAGE_SMALL;
        richpresence.partySize = 0;
        richpresence.partyMax = 0;
        richpresence.smallImageText = mc.getSession().getUsername();
        client.Discord_UpdatePresence(richpresence);

        new Thread("RPC-Callback-Handler") {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    client.Discord_UpdatePresence(richpresence);
                    client.Discord_RunCallbacks();
                    try {
                        if (mc.isSingleplayer()) {
                            richpresence.state = "Emporté par la solitude !";
                            richpresence.partySize = 0;
                            richpresence.partyMax = 0;
                            client.Discord_UpdatePresence(richpresence);
                        }
                        else if (mc.world !=null && mc.getConnection() != null) {
                            richpresence.state = "Le plaisir du partage !";
                            richpresence.partySize = mc.getCurrentServerData().playerList.length();
                            richpresence.partyMax = 50;
                            client.Discord_UpdatePresence(richpresence);
                        } else {
                            richpresence.state = "Découvre l'imumable !";
                            richpresence.partySize = 0;
                            richpresence.partyMax = 0;
                            client.Discord_UpdatePresence(richpresence);
                        }
                        Thread.sleep(2000);
                    } catch (InterruptedException ignored) {
                        client.Discord_Shutdown();
                    }
                }
            }
        }.start();
    }
}
