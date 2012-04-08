package com.dexdo.Magico.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerListener implements Listener {
	
	@EventHandler(priority = EventPriority.LOW)
	public void playerInterac(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		
		if (player.getItemInHand().getTypeId() != Material.REDSTONE_TORCH_OFF.getId()) {
			return;
		}
		
		player.sendMessage(ChatColor.RED + "Magico");
		event.setCancelled(true);
	}

}
