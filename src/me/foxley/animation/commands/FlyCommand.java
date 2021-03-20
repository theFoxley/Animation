package me.foxley.animation.commands;

import com.mysql.jdbc.Buffer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length == 0 && sender instanceof Player) {
            Player player = (Player) sender;

            if(player.getAllowFlight()) {
                player.setAllowFlight(false);
                player.sendMessage(ChatColor.YELLOW + "Vous n'avez plus la permission de voler");
            } else {
                player.setAllowFlight(true);
                player.sendMessage(ChatColor.YELLOW + "Vous avez la permission de voler");
            }
        } else if(args.length > 0) {
            Player player = Bukkit.getPlayerExact(args[0]);
            if(player.getAllowFlight()) {
                player.setAllowFlight(false);
                player.sendMessage(ChatColor.YELLOW + "Vous n'avez plus la permission de voler");
                sender.sendMessage(ChatColor.YELLOW + "Le joueur n'a plus la permission de voler");
            } else {
                player.setAllowFlight(true);
                player.sendMessage(ChatColor.YELLOW + "Vous avez la permission de voler");
                sender.sendMessage(ChatColor.YELLOW + "Le joueur a la permission de voler");
            }
        }

        return true;
    }
}
