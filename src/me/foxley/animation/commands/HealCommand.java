package me.foxley.animation.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length > 0) {
            Player player = Bukkit.getPlayerExact(args[0]);
            if(player != null) {
                player.setHealth(player.getMaxHealth());
                player.sendMessage(ChatColor.GREEN + "Vous venez d'être soigné par " + ChatColor.DARK_GREEN + sender.getName());
            } else {
                sender.sendMessage(ChatColor.RED + "Ce joueur n'est pas connecté");
            }
        } else {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                player.setHealth(player.getMaxHealth());
                player.sendMessage(ChatColor.GREEN + "Vous venez de vous soigner");
            }
        }

        return true;
    }
}
