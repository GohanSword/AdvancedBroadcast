package Commands;

import fr.gohansword.advancedbroadcast.AdvancedBroadcast;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class CommandabInformation implements CommandExecutor {
    Plugin plugin = AdvancedBroadcast.getPlugin(AdvancedBroadcast.class);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(!(sender instanceof Player)) {
            if (args.length == 0) {
                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                        plugin.getConfig().getString("Prefix") + plugin.getConfig().getString("Missing-arg")));
                return false;
            }
            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
                    plugin.getConfig().getString("Information-Broadcast") + String.join(" ", args)));
            return false;

        }
        Player player = (Player) sender;
        if (player.hasPermission("advancedbroacast.alert")) {
            if (args.length == 0) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        plugin.getConfig().getString("Prefix") + plugin.getConfig().getString("Missing-arg")));
                return false;
            }
            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
                    plugin.getConfig().getString("Information-Broadcast") + String.join(" ", args)));
            return false;

        } else {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    plugin.getConfig().getString("Prefix") + plugin.getConfig().getString("NoPermission")));
            return false;
        }
    }
}
