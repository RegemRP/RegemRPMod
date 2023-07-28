package fr.regemrp.mod.common.handler;

import fr.regemrp.mod.common.init.BlocksRegister;
import fr.regemrp.mod.common.init.ItemsRegister;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RegisterHandler {

    @SubscribeEvent
    public void onBlocksRegister(RegistryEvent.Register<Block> e) {
        BlocksRegister.INSTANCE.init();
        e.getRegistry().registerAll(BlocksRegister.INSTANCE.getBlocks().toArray(new Block[0]));
    }

    @SubscribeEvent
    public void onItemsRegister(RegistryEvent.Register<Item> e) {
        ItemsRegister.INSTANCE.init();
        e.getRegistry().registerAll(ItemsRegister.INSTANCE.getItems().toArray(new Item[0]));
    }

}
