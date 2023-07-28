package fr.regemrp.mod.common.items;

import fr.regemrp.mod.common.init.ItemsRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item {

    public ItemBase(String name, CreativeTabs creativeTabs, int stackcount, int durability) {
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(creativeTabs);
        this.setMaxStackSize(stackcount);
        this.setMaxDamage(durability);
        ItemsRegister.INSTANCE.getItems().add(this);
    }

}
