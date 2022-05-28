package net.example.mcplugin.core;

import net.example.mcplugin.commands.CmdPing;
import net.example.mcplugin.listener.ConnectionListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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

        initializeCommands();
        initializeListener();

        Bukkit.getConsoleSender().sendMessage(String.format("%sPlugin enabled v%s", ChatColor.YELLOW, getVersion()));
    }

    @Override
    public void onDisable()
    {
        Bukkit.getConsoleSender().sendMessage(String.format("%sPlugin disabled v%s", ChatColor.YELLOW, getVersion()));
    }

    private void initializeCommands()
    {
        Objects.requireNonNull(this.getCommand("ping")).setExecutor(new CmdPing());
    }

    private void initializeListener()
    {
        PluginManager pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new ConnectionListener(), plugin);
    }

    public static Plugin getPlugin()
    {
        return plugin;
    }

    public String getVersion()
    {
        return getDescription().getVersion();
    }
}
