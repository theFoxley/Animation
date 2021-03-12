package me.foxley.animation;

import me.foxley.animation.commands.*;
import org.bukkit.plugin.java.JavaPlugin;

public class Animation extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("heal").setExecutor(new HealCommand());
        this.getCommand("tphere").setExecutor(new TPHereCommand());
    }

}
