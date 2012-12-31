package code.husky;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class MineZ extends JavaPlugin implements Listener {

	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this,this);
	}

	@EventHandler
	public void EntitySpawn(EntityTargetEvent e) {
		Entity target = e.getTarget();
		Entity attacker = e.getEntity();
		if (attacker instanceof org.bukkit.craftbukkit.v1_4_6.entity.CraftZombie && target instanceof Player) {
			Player p = (Player) target;
			if (p.isSneaking()) {
				e.setCancelled(true);
			} else {
				e.setTarget(target);
			}
		}
	}

	@EventHandler
	public void toggleSneak(PlayerToggleSneakEvent e) {
		Player p = e.getPlayer();
		if (p.isSneaking()) {
			List<Entity> nearby = p.getNearbyEntities(20, 20, 20);
			org.bukkit.craftbukkit.v1_4_6.entity.CraftZombie z = null;
			for (Entity ent : nearby) {
				if (ent instanceof org.bukkit.craftbukkit.v1_4_6.entity.CraftZombie) {
					z = (org.bukkit.craftbukkit.v1_4_6.entity.CraftZombie) ent;
				}
			}
			if (z != null) {
				p.sendMessage(ChatColor.RED + "A zombie heard your footsteps!");
				z.setTarget(p);
			}
		}
	}

	@EventHandler
	public void AI(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (p.isSneaking()) {
			List<Entity> nearby = p.getNearbyEntities(20, 20, 20);
			org.bukkit.craftbukkit.v1_4_6.entity.CraftZombie z = null;
			for (Entity ent : nearby) {
				if (ent instanceof org.bukkit.craftbukkit.v1_4_6.entity.CraftZombie) {
					z = (org.bukkit.craftbukkit.v1_4_6.entity.CraftZombie) ent;
				}
			}
			if (z != null) {
				p.sendMessage(ChatColor.RED + "A zombie heard your footsteps!");
				z.setTarget(p);
			}
		} else {
			List<Entity> nearby = p.getNearbyEntities(35, 35, 35);
			org.bukkit.craftbukkit.v1_4_6.entity.CraftZombie z = null;
			for (Entity ent : nearby) {
				if (ent instanceof org.bukkit.craftbukkit.v1_4_6.entity.CraftZombie) {
					z = (org.bukkit.craftbukkit.v1_4_6.entity.CraftZombie) ent;
				}
			}
			if (z != null) {
				p.sendMessage(ChatColor.RED + "A zombie heard your footsteps!");
				z.setTarget(p);
			}
		}
	}

}
