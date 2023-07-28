package fr.regemrp.mod.common.init;

import com.google.common.collect.Lists;
import fr.regemrp.mod.common.utils.References;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;

public class BlocksRegister {

    public static final BlocksRegister INSTANCE = new BlocksRegister();
    private List<Block> blocks;

    public void init() {
        blocks = Lists.newArrayList();
        AllRegister.blockRegister();
    }

    public void addBlock(Block block) {
        blocks.add(block);
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    //==================================================FORGE===========================================================

    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event) {
        for (Block block : blocks) {
            registerBlocksModels(block);
        }
    }

    public static void registerBlocksModels(Block block) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
    }
}
