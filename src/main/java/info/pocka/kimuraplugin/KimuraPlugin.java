package info.pocka.kimuraplugin;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/*
 * Copyright (c) 2015 popkirby
 *
 * This project is licensed under MIT License.
 * For full copyright and license information, please see the LICENSE.txt.
 *
 */

public class KimuraPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new KimuraFireworkOnDeath(), this);
    }

}
