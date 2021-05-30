package me.dreamvoid.template;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import org.bstats.bukkit.Metrics;

import java.io.File;

public class main extends JavaPlugin {

    @Override
    public void onLoad() { } // 加载插件

    @Override
    public void onEnable() { LoadConfig(); } // 启用插件

    @Override
    public void onDisable() { } // 禁用插件

    void LoadConfig() {
        // 加载配置文件
        configfile = new File(getDataFolder(), "config.yml");
        if(!(configfile.exists())){ saveDefaultConfig(); }
        YamlConfiguration config = YamlConfiguration.loadConfiguration(configfile);

        if(config.getBoolean("bStats", true)) { Metrics metrics = new Metrics(this, 1234); } //bStats统计
    }

    public static File configfile;
}
