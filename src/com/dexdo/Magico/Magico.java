package com.dexdo.Magico;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.dexdo.Magico.listeners.PlayerListener;

public class Magico extends JavaPlugin {
	
	private Logger log;
	
	public void onEnable() {
		log = this.getLogger();
		log.info("The Magico plugin has been enabled!");
		
		registerEvents();
	}
	
	private void registerEvents() {
		PluginManager pm = getServer().getPluginManager();
		
		PlayerListener playerListener = new PlayerListener();
		pm.registerEvents(playerListener, this);
	}

	public void onDisable() {
		log.info("The Magico plugin has been disabled");
	}
	
	/*
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		return false;
	}
	*/

}
