package Commands;

import fr.gohansword.advancedbroadcast.AdvancedBroadcast;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class CommandabReboot implements CommandExecutor {
    Plugin plugin = AdvancedBroadcast.getPlugin(AdvancedBroadcast.class);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if (player.hasPermission("advancedbroacast.reboot")) {
            if (args.length == 0) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        plugin.getConfig().getString("Prefix") + plugin.getConfig().getString("Missing-arg")));
                return false;
            }
            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
                    plugin.getConfig().getString("Reboot-Broadcast") + String.join(" ", args)));
            return false;

        } else {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    plugin.getConfig().getString("Prefix") + plugin.getConfig().getString("NoPermission")));
            return false;
        }
    }
}
