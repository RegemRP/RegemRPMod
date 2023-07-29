package fr.regemrp.mod.common.handler;

import fr.regemrp.mod.common.init.AllRegister;
import fr.regemrp.mod.common.utils.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RegisterHandler {

    @SubscribeEvent
    public void onItemsRegister(RegistryEvent.Register<Item> e) {
        e.getRegistry().registerAll(AllRegister.ITEMS.toArray(new Item[0]));
    }


    @SubscribeEvent
    public void onBlocksRegister(RegistryEvent.Register<Block> e) {
        e.getRegistry().registerAll(AllRegister.BLOCKS.toArray(new Block[0]));
    }

    @SubscribeEvent
    public void OnModelRegister(ModelRegistryEvent event) {
        for (Item item : AllRegister.ITEMS) {
            if(item instanceof IHasModel) {
                ((IHasModel)item).registerModels();
            }
        }
        for (Block block : AllRegister.BLOCKS) {
            if(block instanceof IHasModel) {
                ((IHasModel)block).registerModels();
            }
        }
    }

}
