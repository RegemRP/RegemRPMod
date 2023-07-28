package fr.regemrp.mod.common.blocks;

import fr.regemrp.mod.common.init.BlocksRegister;
import fr.regemrp.mod.common.init.ItemsRegister;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;

import java.util.Objects;

public class BlockBase extends Block {

        public BlockBase(String name, Material material, CreativeTabs creativeTabs, float hardness, float resistance) {
            super(material);
            this.setCreativeTab(creativeTabs);
            this.setHardness(hardness);
            this.setResistance(resistance);
            this.setUnlocalizedName(name);
            this.setRegistryName(name);
            BlocksRegister.INSTANCE.getBlocks().add(this);
            ItemsRegister.INSTANCE.getItems().add(new ItemBlock(this).setRegistryName(Objects.requireNonNull(this.getRegistryName())));
        }

}
