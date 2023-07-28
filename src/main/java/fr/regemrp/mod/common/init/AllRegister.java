package fr.regemrp.mod.common.init;

import fr.regemrp.mod.common.blocks.dynamx.BaseDynamxBlock;
import fr.regemrp.mod.common.utils.References;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

public class AllRegister {

    /* Item & Block Register */

    public static void register() {

    }

    public static void blockRegister() {

    }


    /* Dyanmx Register */

    public static BaseDynamxBlock test;

    public static void dynamxInit(){
        test = new BaseDynamxBlock(Material.ROCK, References.MODID, "test", new ResourceLocation("regemrp","models/test/photocopieuse.obj"), Main.mainTab);
    }

}
