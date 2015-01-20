package me.raino.rpgm;

import org.bukkit.plugin.java.JavaPlugin;

public class RPGM extends JavaPlugin {

    private static RPGM instance;

    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public static RPGM get() {
        return instance;
    }
}
