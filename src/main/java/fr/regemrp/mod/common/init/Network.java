package fr.regemrp.mod.common.init;

import net.minecraftforge.fml.common.network.NetworkRegistry;

public class Network {

    public static void initNetwork() {
        Main.network = NetworkRegistry.INSTANCE.newSimpleChannel("regemrp");
    }
}
