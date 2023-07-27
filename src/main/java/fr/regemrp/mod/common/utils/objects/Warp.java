package fr.regemrp.mod.common.utils.objects;

import net.minecraft.util.math.BlockPos;

import java.util.UUID;

public class Warp {

    private String name;
    private BlockPos pos;

    public Warp(String name, BlockPos pos) {
        this.name = name;
        this.pos = pos;
    }

    public String getName() {
        return name;
    }

    public BlockPos getPos() {
        return pos;
    }

    public String toString() {
        return name + ";" + pos.getX() + ";" + pos.getY() + ";" + pos.getZ();
    }

    public static Warp fromString(String s) {
        String[] split = s.split(";");
        int x = Integer.parseInt(split[1]);
        int y = Integer.parseInt(split[2]);
        int z = Integer.parseInt(split[3]);
        return new Warp(split[0], new BlockPos(x, y, z));
    }

}
