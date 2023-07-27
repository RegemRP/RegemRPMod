package fr.regemrp.mod.common.init;

import fr.regemrp.mod.Main;
import fr.regemrp.mod.common.blocks.BaseBlock;
import fr.regemrp.mod.common.utils.References;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

public class AllRegister {

    public static BaseBlock test;

    public static void dynamxInit(){
        test = new BaseBlock(Material.ROCK, References.MODID, "test", new ResourceLocation("regemrp","models/test/photocopieuse.obj"), Main.mainTab);
    }

}
