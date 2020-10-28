package fr.gohansword.advancedbroadcast;

import Commands.CommandabAlert;
import Commands.CommandabInformation;
import Commands.CommandabReboot;
import Commands.CommandabServer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class AdvancedBroadcast extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("abalert").setExecutor(new CommandabAlert());
        getCommand("abreboot").setExecutor(new CommandabReboot());
        getCommand("abserver").setExecutor(new CommandabServer());
        getCommand("abinformation").setExecutor(new CommandabInformation());
        this.saveDefaultConfig();
        String newLine = System.getProperty("line.separator");
        Bukkit.getConsoleSender().sendMessage("   §c________" + newLine + "                   §c| | -- | |" + newLine + "                   §c| |-AB-| |" + newLine + "                   §c| |-->-| |     §8§l[§b§lAdvanced§f§lBroadcast§8§l] §8>> §aLoaded successfully ! :)" + newLine + "                   §c| |-AB-| |" + newLine + "                   §c| | -- | |" + newLine + "                 §c§m--------------§r");

    }

    @Override
    public void onDisable() {
        String newLine = System.getProperty("line.separator");
        Bukkit.getConsoleSender().sendMessage("   §c________" + newLine + "                   §c| | -- | |" + newLine + "                   §c| |-AB-| |" + newLine + "                   §c| |-->-| |     §8§l[§b§lAdvanced§f§lBroadcast§8§l] §8>> §cUnloaded successfully ! :)" + newLine + "                   §c| |-AB-| |" + newLine + "                   §c| | -- | |" + newLine + "                 §c§m--------------§r");

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String newLine = System.getProperty("line.separator");
        String blankline = "&f";

        if (label.equalsIgnoreCase("advancedbroadcast")) {
            if (args.length == 0) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        this.getConfig().getString("Prefix") + this.getConfig().getString("Usage")));
            }
            if (args.length > 0) {
                if (args[0].equalsIgnoreCase("reload")) {
                    if (!sender.hasPermission("advancedbroadcast.admin")) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                                this.getConfig().getString("Prefix") + this.getConfig().getString("NoPermission")));
                        return true;
                    }else this.reloadConfig();
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            this.getConfig().getString("Prefix") + this.getConfig().getString("Reload")));
                    Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',
                            this.getConfig().getString("Prefix") + this.getConfig().getString("Reload")));
                } else if (args[0].equalsIgnoreCase("help")) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            this.getConfig().getString("Help") + newLine + blankline + newLine + this.getConfig().getString("CommandHelp") + newLine + this.getConfig().getString("CommandReload") + newLine + this.getConfig().getString("CommandAlert") + newLine + this.getConfig().getString("CommandReboot") + newLine + this.getConfig().getString("CommandServer") + newLine + this.getConfig().getString("CommandInformation") + newLine + blankline + newLine + this.getConfig().get("HelpEnd")));
                }
            }
        } return false;
    }
}
