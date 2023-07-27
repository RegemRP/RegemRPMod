package fr.regemrp.mod;

import fr.dynamx.api.contentpack.DynamXAddon;
import fr.dynamx.api.obj.ObjModelPath;
import fr.dynamx.common.DynamXContext;
import fr.regemrp.mod.common.CommonProxy;
import fr.regemrp.mod.common.init.Network;
import fr.regemrp.mod.common.utils.References;
import fr.regemrp.mod.common.utils.discord.RPCInit;
import fr.regemrp.mod.common.utils.tabs.MainTab;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
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

import java.util.Objects;

@Mod(modid = References.MODID, name = References.NAME, version = References.VERSION)
@DynamXAddon(modid = References.MODID, name = References.NAME, version = References.VERSION)
public class Main
{

    public static Logger logger;

    @Mod.Instance(References.MODID)
    public static Main instance;
    public static SimpleNetworkWrapper network;

    @SidedProxy(clientSide = References.CLIENT_PROXY_CLASS, serverSide = References.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    /* Creative Tabs */

    public static MainTab mainTab = new MainTab("regemrp");

    /* FML InitializationEvent */

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit();
        logger = event.getModLog();
        Network.initNetwork();
        rpcInit();
    }

    @SideOnly(Side.CLIENT)
    public void rpcInit() {
        RPCInit.start();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init();
        PermissionAPI.registerNode("regemrp.command.gamemode", DefaultPermissionLevel.OP, "Allows players to use the gamemode command");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit();
    }

    @Mod.EventHandler
    public void onServerStarting(FMLServerStartingEvent event) {

    }

    /* Dynamx Init */

    @DynamXAddon.AddonEventSubscriber
    public static void init() {

    }

}
