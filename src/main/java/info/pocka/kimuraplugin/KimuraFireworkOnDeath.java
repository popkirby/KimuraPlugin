package info.pocka.kimuraplugin;

/*
 * Copyright (c) 2015 popkirby
 *
 * This project is licensed under MIT License.
 * For full copyright and license information, please see the LICENSE.txt.
 *
 */

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.Random;

class KimuraFireworkOnDeath implements Listener {

    private Random rand;

    public KimuraFireworkOnDeath() {
        rand = new Random();
    }

    @EventHandler
    public void KimuraFirework(PlayerDeathEvent event) {
        Player player = event.getEntity();

        // check if player is Kimura or not
        if (!player.getPlayerListName().contains("schinchig")) return;

        // spawn Firework
        World world = player.getWorld();
        Firework firework = (Firework) world.spawnEntity(player.getLocation(), EntityType.FIREWORK);

        // set firework random meta infomations
        FireworkMeta meta = firework.getFireworkMeta();
        FireworkEffect.Builder builder = FireworkEffect.builder();

        builder.withColor(getRandomColors(1 + rand.nextInt(5)));
        builder.withFade(getRandomColors(1 + rand.nextInt(3)));
        builder.flicker(rand.nextBoolean());
        builder.trail(rand.nextBoolean());
        builder.with(FireworkEffect.Type.values()[rand.nextInt(5)]);

        meta.setPower(1 + rand.nextInt(4));

        meta.addEffect(builder.build());
        firework.setFireworkMeta(meta);
    }

    private Color[] getRandomColors(int length) {
        Color colors[] = new Color[length];

        for (int i = 0; i < length; i++) {
            colors[i] = Color.fromBGR(rand.nextInt(1 << 24));
        }

        return colors;
    }

}
