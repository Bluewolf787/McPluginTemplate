package de.bluewolf.mcplugin.core;

import de.bluewolf.mcplugin.commands.CmdPing;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Plugin extends JavaPlugin
{

    private static Plugin plugin;

    @Override
    public void onEnable()
    {
        plugin = this;

        // --| Command Registration |-- //
        Objects.requireNonNull(this.getCommand("ping")).setExecutor(new CmdPing());

        // --| Listener Registration |-- //
        PluginManager pluginManager = Bukkit.getPluginManager();

        Bukkit.getConsoleSender().sendMessage("§6Plugin enabled.");
    }

    @Override
    public void onDisable()
    {
        Bukkit.getConsoleSender().sendMessage("§6Plugin disabled.");
    }

    public static Plugin getPlugin()
    {
        return plugin;
    }

}
