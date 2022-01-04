package de.bluewolf.mcplugin.commands;

import de.bluewolf.mcplugin.config.PluginConfig;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdPing implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args)
    {
        Player player = (Player) commandSender;
        if (command.getName().equalsIgnoreCase("ping")) // Check for the command name
        {
            if (commandSender != null) // Check if sender is an actual player
            {
                if (args.length == 0) // Check if there is only 1 argument
                {
                    player.sendMessage(String.format("%s§aYour ping is: §b%d", PluginConfig.PLUGIN_PREFIX, player.getPing()));
                }
            }
        }

        return false;
    }

}
