package fr.regemrp.mod.common.init;

import fr.regemrp.mod.Main;
import fr.regemrp.mod.common.blocks.BlockBase;
import fr.regemrp.mod.common.blocks.dynamx.BaseDynamxBlock;
import fr.regemrp.mod.common.utils.References;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class AllRegister {

    public static List<Item> ITEMS = new ArrayList<Item>();
    public static List<Block> BLOCKS = new ArrayList<Block>();

    /* Item & Block Register */

    public static BlockBase ASPHALT = new BlockBase("asphalt", Material.ROCK, Main.mainTab, 1f, 1f);
    public static BlockBase ASPHALT_GRAY = new BlockBase("asphalt_gray", Material.ROCK, Main.mainTab, 1f, 1f);


    /* Dyanmx Register */

    public static BaseDynamxBlock test;

    public static void dynamxInit(){
        test = new BaseDynamxBlock(Material.ROCK, References.MODID, "test", new ResourceLocation("regemrp","models/test/photocopieuse.obj"), Main.mainTab);
    }

}
