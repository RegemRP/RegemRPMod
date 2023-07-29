package fr.regemrp.mod.common.utils.commands;

import fr.regemrp.mod.Main;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CommandWarp extends CommandBase {

    @Override
    public String getName() {
        return "warp";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "§c/warp <warp/add/delete/list> (name)";
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
                sender.sendMessage(new TextComponentString("§c/warp <warp name/add/remove/list> (name)"));
                break;
            case 1:
                if(!(args[0].equalsIgnoreCase("add") || args[0].equalsIgnoreCase("remove")
                )) {
                    if (args[0].equalsIgnoreCase("list")) {
                        String message = "§6Liste des warps : §7";
                        String[] warps = Main.dbWarps.getAllEntryNames();
                        for (int i = 0; i < warps.length; i++) {
                            message = message + warps[i] + " §6- §7";
                        }
                        sender.sendMessage(new TextComponentString(message));
                        break;
                    } else {
                        if(!Main.dbWarps.contains(args[0])) {
                            sender.sendMessage(new TextComponentString("§cCe warp n'existe pas."));
                            break;
                        }
                        Objects.requireNonNull(sender.getCommandSenderEntity()).setLocationAndAngles(
                                Double.parseDouble(Main.dbWarps.getString(args[0]).split(";")[0]),
                                Double.parseDouble(Main.dbWarps.getString(args[0]).split(";")[1]),
                                Double.parseDouble(Main.dbWarps.getString(args[0]).split(";")[2]),
                                0, 0);
                        sender.sendMessage(new TextComponentString("§aVous avez été téléporté vers le warp §6" + args[0] + "§a."));
                        Main.logger.info(sender.getName() + " a été téléporté vers le warp " + args[0] + ".");
                        break;
                    }
                } else {
                    sender.sendMessage(new TextComponentString("§c/warp <add/remove> (name)"));
                    break;
                }
            case 2:
                if(args[0].equalsIgnoreCase("add")) {
                    sender.sendMessage(new TextComponentString("§aVous avez ajouté le warp §6" + args[1] + "§a."));
                    Main.dbWarps.setString(args[1], sender.getPosition().getX() + ";" + sender.getPosition().getY() + ";" + sender.getPosition().getZ());
                    Main.logger.info(sender.getName() + " a ajouté le warp " + args[1] + ".");
                    break;
                } else if(args[0].equalsIgnoreCase("remove")) {
                    if(!Main.dbWarps.contains(args[1])) {
                        sender.sendMessage(new TextComponentString("§cCe warp n'existe pas."));
                        break;
                    }
                    sender.sendMessage(new TextComponentString("§cVous avez supprimé le warp §6" + args[1] + "§c."));
                    Main.dbWarps.remove(args[1]);
                    Main.logger.info(sender.getName() + " a supprimé le warp " + args[1] + ".");
                    break;
                } else {
                    sender.sendMessage(new TextComponentString("§c/warp <add/remove> (name)"));
                    break;
                }
            default:
                sender.sendMessage(new TextComponentString("§c/warp <warp name/add/remove/list> (name)"));
                break;
        }
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos) {
        List<String> completions = new ArrayList<String>();

        switch (args.length) {
            case 1:
                completions.add("add");
                completions.add("remove");
                completions.add("list");
                String[] warps = Main.dbWarps.getAllEntryNames();
                for (int i = 0; i < warps.length; i++) {
                    completions.add(warps[i]);
                }
            case 2:
                if (args[0].equalsIgnoreCase("remove")) {
                    String[] warps2 = Main.dbWarps.getAllEntryNames();
                    for (int i = 0; i < warps2.length; i++) {
                        completions.add(warps2[i]);
                    }
                }
        }
        return completions;
    }
}
