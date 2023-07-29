package fr.regemrp.mod.common.items;

import fr.regemrp.mod.Main;
import fr.regemrp.mod.common.init.AllRegister;
import fr.regemrp.mod.common.utils.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

    public ItemBase(String name, CreativeTabs creativeTabs, int stackcount, int durability) {
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(creativeTabs);
        this.setMaxStackSize(stackcount);
        this.setMaxDamage(durability);
        AllRegister.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0);
    }
}
