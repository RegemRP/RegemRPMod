package fr.regemrp.mod.common.init;

import com.google.common.collect.Lists;
import fr.regemrp.mod.common.utils.References;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;

public class ItemsRegister {

    public static final ItemsRegister INSTANCE = new ItemsRegister();
    private List<Item> items;

    public void init() {
        items = Lists.newArrayList();
        AllRegister.register();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    //==================================================FORGE===========================================================

    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event) {
        for (Item item : items) {
            registerItemsModels(item);
        }
    }

    public static void registerItemsModels(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(References.MODID, item.getUnlocalizedName().substring(5)), "inventory"));
    }
}
