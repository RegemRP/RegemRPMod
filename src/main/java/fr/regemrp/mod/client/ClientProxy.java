package fr.regemrp.mod.client;

import fr.regemrp.mod.common.CommonProxy;
import fr.regemrp.mod.common.init.BlocksRegister;
import fr.regemrp.mod.common.init.ItemsRegister;
import fr.regemrp.mod.common.utils.References;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraftforge.common.MinecraftForge;
import org.apache.commons.compress.utils.IOUtils;
import org.lwjgl.opengl.Display;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit()
    {
        super.preInit();
        MinecraftForge.EVENT_BUS.register(BlocksRegister.INSTANCE);
        MinecraftForge.EVENT_BUS.register(ItemsRegister.INSTANCE);

        /* Personnalisation du jeu */

        Display.setTitle("RegemRP - " + References.VERSION);
        setWindowIcon();
    }

    private void setWindowIcon()
    {
        Util.EnumOS util$enumos = Util.getOSType();

        if (util$enumos != Util.EnumOS.OSX)
        {
            InputStream inputstream = null;
            InputStream inputstream1 = null;

            try
            {

                inputstream = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation(References.MODID, "icons/logo.png")).getInputStream();
                inputstream1 = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation(References.MODID,"icons/logo2.png")).getInputStream();

                if (inputstream != null && inputstream1 != null)
                {
                    Display.setIcon(new ByteBuffer[] {
                            this.readImageToBuffer(inputstream), this.readImageToBuffer(inputstream1)
                    });
                }
            }
            catch (IOException ioexception)
            {
                ioexception.printStackTrace();
                System.out.println("Erreur, impossible de charger l'icone.");
            }
            finally
            {
                IOUtils.closeQuietly(inputstream);
                IOUtils.closeQuietly(inputstream1);
            }
        }
    }

    private ByteBuffer readImageToBuffer(InputStream imageStream) throws IOException
    {
        BufferedImage bufferedimage = ImageIO.read(imageStream);
        int[] aint = bufferedimage.getRGB(0, 0, bufferedimage.getWidth(), bufferedimage.getHeight(), (int[])null, 0, bufferedimage.getWidth());
        ByteBuffer bytebuffer = ByteBuffer.allocate(4 * aint.length);

        for (int i : aint)
        {
            bytebuffer.putInt(i << 8 | i >> 24 & 255);
        }

        bytebuffer.flip();
        return bytebuffer;
    }

    @Override
    public void init()
    {
        super.init();
    }

    @Override
    public void postInit()
    {
        super.postInit();
    }
}
