package fr.regemrp.mod.common.blocks.dynamx;

import fr.dynamx.common.blocks.DynamXBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BaseDynamxBlock extends DynamXBlock {

    public BaseDynamxBlock(Material material, String modid, String blockName, ResourceLocation model, CreativeTabs creativeTabs) {
        super(material, modid, blockName, model);
        setCreativeTab(creativeTabs);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        return true;
    }
}