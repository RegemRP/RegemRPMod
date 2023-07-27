package fr.regemrp.mod.common.utils.commands;

import fr.nathanael2611.simpledatabasemanager.core.Database;
import fr.nathanael2611.simpledatabasemanager.core.StoredData;
import fr.regemrp.mod.Main;
import fr.regemrp.mod.common.utils.objects.Warp;
import jdk.nashorn.internal.runtime.regexp.joni.WarnCallback;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;

import java.util.ArrayList;
import java.util.List;

public class CommandWarp extends CommandBase {

    @Override
    public String getName() {
        return "warp";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "§c/warp <warp/add/delete/lists> (name)";
    }

    @Override
    public List<String> getAliases() {
        List<String> aliases = new ArrayList<String>();
        aliases.add("warps");
        aliases.add("w");
        return aliases;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        switch (args.length) {
            case 0:
                sender.sendMessage(new TextComponentString("§c/warp <warp name/add/remove/lists> (name)"));
                break;
            case 1:
                if(!(args[0].equalsIgnoreCase("add") || args[0].equalsIgnoreCase("remove")
                )) {
                    if (args[0].equalsIgnoreCase("list")) {
                        sender.sendMessage(new TextComponentString("§aListe des warps :"));
                        break;
                    } else {
                            sender.sendMessage(new TextComponentString("§aVous avez été téléporté vers le warp §6" + args[0] + "§a."));ak;
                        }
                    }
                } else {
                    sender.sendMessage(new TextComponentString("§c/warp <add/remove> (name)"));
                    break;
                }
            case 2:
                if(args[0].equalsIgnoreCase("add")) {
                    sender.sendMessage(new TextComponentString("§aVous avez ajouté le warp §6" + args[1] + "§a."));
                    break;
                } else if(args[0].equalsIgnoreCase("remove")) {
                    sender.sendMessage(new TextComponentString("§cVous avez supprimé le warp §6" + args[1] + "§c."));
                    break;
                } else {
                    sender.sendMessage(new TextComponentString("§c/warp <add/remove> (name)"));
                    break;
                }
            default:
                sender.sendMessage(new TextComponentString("§c/warp <warp name/add/remove/lists> (name)"));
                break;
        }
    }
}
