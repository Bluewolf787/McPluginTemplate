package net.example.mcplugin.commands;

import net.example.mcplugin.config.PluginConfig;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.checkerframework.checker.nullness.qual.NonNull;

public class CmdPing implements CommandExecutor
{
    @Override
    public boolean onCommand(@NonNull CommandSender commandSender, @NonNull Command command, @NonNull String label, @NonNull String[] args)
    {
        Player player = (Player) commandSender;
        if (command.getName().equalsIgnoreCase("ping")) // Check for the command name
        {
            if (args.length == 0) // Check if there is only 1 argument
            {
                player.sendMessage(String.format("%s§aYour ping is: §b%d", PluginConfig.PLUGIN_PREFIX, player.getPing()));
            } else
                player.sendMessage(String.format("%s§fUse §6/ping §fto show your current ping.", PluginConfig.PLUGIN_PREFIX));
        }

        return false;
    }
}
