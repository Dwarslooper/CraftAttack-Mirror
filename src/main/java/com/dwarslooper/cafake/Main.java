package com.dwarslooper.cafake;

import com.dwarslooper.cafake.ping.MCPing;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(new ConnectionListener(), this);

        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, () -> {
            try {
                InfoReceiver.setCurrentData(MCPing.getPing("der-allerechte-craftattack-server-kein-fake-ehrlich-voll-krass-deine.mom"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, 0, 400);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
