package fr.regemrp.mod.common.blocks;

import fr.regemrp.mod.Main;
import fr.regemrp.mod.common.init.AllRegister;
import fr.regemrp.mod.common.utils.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

import java.util.Objects;

public class BlockBase extends Block implements IHasModel {

        public BlockBase(String name, Material material, CreativeTabs creativeTabs, float hardness, float resistance) {
            super(material);
            setUnlocalizedName(name);
            setRegistryName(name);
            setCreativeTab(creativeTabs);
            setHardness(hardness);
            setResistance(resistance);
            AllRegister.BLOCKS.add(this);
            AllRegister.ITEMS.add(new ItemBlock(this).setRegistryName(Objects.requireNonNull(this.getRegistryName())));
            }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0);
    }
}
