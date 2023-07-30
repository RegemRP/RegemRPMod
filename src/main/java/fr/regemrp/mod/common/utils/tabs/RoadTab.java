package fr.regemrp.mod.common.utils.tabs;

import fr.regemrp.mod.common.init.AllRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RoadTab extends CreativeTabs {

    public RoadTab(String label) {
        super(label);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(AllRegister.ASPHALT);
    }

}
