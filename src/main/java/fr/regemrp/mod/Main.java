package fr.regemrp.mod;

import fr.dynamx.api.contentpack.DynamXAddon;
import fr.nathanael2611.simpledatabasemanager.core.Database;
import fr.nathanael2611.simpledatabasemanager.core.Databases;
import fr.regemrp.mod.common.CommonProxy;
import fr.regemrp.mod.common.handler.RegisterHandler;
import fr.regemrp.mod.common.init.AllRegister;
import fr.regemrp.mod.common.init.Network;
import fr.regemrp.mod.common.utils.References;
import fr.regemrp.mod.common.utils.commands.CommandWarp;
import fr.regemrp.mod.common.utils.discord.RPCInit;
import fr.regemrp.mod.common.utils.tabs.MainTab;
import fr.regemrp.mod.common.utils.tabs.RoadTab;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.server.permission.DefaultPermissionLevel;
import net.minecraftforge.server.permission.PermissionAPI;
import org.apache.logging.log4j.Logger;

@Mod(modid = References.MODID, name = References.NAME, version = References.VERSION)
@DynamXAddon(modid = References.MODID, name = References.NAME, version = References.VERSION)
public class Main
{

    /*
    * TERMES ET CONDITIONS
0. TERMES UTILISÉS
MOD - Modification, plugin, un morceau de code qui modifie Minecraft, qui ajoute, change ou supprime des fonctions du jeu.
MOJANG - Mojang AB
AUTEUR - , Auteur(s) original(aux) du MOD. Sous les droits de copie accepté en achetant Minecraft ( https://www.minecraft.net/fr-fr/eula ) l’AUTEUR (Yan36s) a tout les droits sur son MOD, malgré qu’il utilise le code de MOJANG.
UTILISATEUR - Utilisateur du mod, qui accepte les conditions évoquées ci-dessous.

1. RISQUES
CE MOD EST LIVRÉ “COMME IL EST”, SANS GARANTIES. L’AUTEUR NE PREND AUCUNE RESPONSABILITÉ PAR RAPPORT AU DÉGÂTS CAUSÉS PAR CE MOD. CE MOD MODIFIE DES PARTIES DU JEU MINECRAFT, CERTAINES PARTIES POURRAIENT NE PLUS FONCTIONNER. TOUT DÉGÂTS CAUSÉS PAR CE MOD SONT SOUS LA RESPONSABILITÉ DE L’UTILISATEUR.

2. UTILISATION
L’utilisation de ce MOD, pour être installé, automatiquement ou manuellement est réservé au serveur REGEMPR.

3. REDISTRIBUTION
Ce mod ne doit être redistribué que par l’AUTEUR, et ne doit pas être redistribué par un tiers sans l’accord de l’AUTEUR. Ce MOD ne doit pas être redistribué sur un site autre que REGEMRP.

4. DERIVATIONS / MODIFICATIONS
Ce MOD est distribué gratuitement pour les utilisateurs de RegemRP, et toute décompilation a des fins quelconques ne sont pas autorisées sauf accord de l'auteur. Toutes versions modifiées de ce MOD demandent des permissions écrites de l’AUTEUR et peuvent êtres sujettes a certaines conditions.
    * */

    public static Logger logger;

    @Mod.Instance(References.MODID)
    public static Main instance;
    public static SimpleNetworkWrapper network;

    public static Database dbWarps;

    @SidedProxy(clientSide = References.CLIENT_PROXY_CLASS, serverSide = References.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    /* Dynamx Init */

    @DynamXAddon.AddonEventSubscriber
    public static void init()
    {
        AllRegister.dynamxInit();
    }

    /* Creative Tabs */

    public static MainTab mainTab = new MainTab("regemrp");
    public static RoadTab roadTab = new RoadTab("regemrp_road");

    /* FML InitializationEvent */

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit();
        logger = event.getModLog();
        Network.initNetwork();

        MinecraftForge.EVENT_BUS.register(new RegisterHandler());
        MinecraftForge.EVENT_BUS.register(this);

        if(event.getSide() == Side.CLIENT)
        rpcInit();

    }

    @SideOnly(Side.CLIENT)
    public void rpcInit() {
        RPCInit.start();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init();

//        SyncedDatabases.add("regemrp_warps");
//        dbWarps = Databases.getDatabase("regemrp_warps");

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit();
    }

    @Mod.EventHandler
    public void onServerStarting(FMLServerStartingEvent event) {
        event.registerServerCommand(new CommandWarp());
        dbWarps = Databases.getDatabase("regemrp_warps");
    }

}
