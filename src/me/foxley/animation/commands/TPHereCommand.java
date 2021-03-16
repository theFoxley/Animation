package me.foxley.animation.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TPHereCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length > 0 && sender instanceof Player) {
            Player player = (Player) sender;
            Player target = Bukkit.getPlayerExact(args[0]);
            if(target != null) {
                target.teleport(player.getLocation());
                target.sendMessage(ChatColor.YELLOW + "Vous avez été téléporté à " + ChatColor.BLUE + player.getName());
            } else {
                player.sendMessage(ChatColor.RED + "Ce joueur n'est pas connecté");
            }
            return true;
        } else {
            return false;
        }
    }
}
