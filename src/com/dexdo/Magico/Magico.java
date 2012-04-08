package com.dexdo.Magico;

import java.util.logging.Logger;

import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.dexdo.Magico.listeners.PlayerListener;

public class Magico extends JavaPlugin {
	
	private Logger log;
	
	public void onEnable() {
		log = this.getLogger();
		log.info("The Magico plugin has been enabled!");
		
		registerEvents();
		addRecipes();
	}
	
	private void addRecipes() {
		Server server = getServer();
		server.addRecipe(getWandRecipe());
		server.addRecipe(getCobblestoneToIronRecipe());
		server.addRecipe(getIronToGoldRecipe());
		server.addRecipe(getGoldToDiamondRecipe());
	}

	private Recipe getGoldToDiamondRecipe() {
		ShapedRecipe recipe = new ShapedRecipe(new ItemStack(Material.DIAMOND, 1));
		recipe.shape("GGG", "GRG", "GGG");
		recipe.setIngredient('G', Material.GOLD_INGOT);
		recipe.setIngredient('R', Material.REDSTONE);
		return recipe;
	}

	private Recipe getIronToGoldRecipe() {
		ShapedRecipe recipe = new ShapedRecipe(new ItemStack(Material.GOLD_INGOT, 1));
		recipe.shape("III", "IRI", "III");
		recipe.setIngredient('I', Material.IRON_INGOT);
		recipe.setIngredient('R', Material.REDSTONE);
		return recipe;
	}

	private Recipe getCobblestoneToIronRecipe() {
		ShapedRecipe recipe = new ShapedRecipe(new ItemStack(Material.IRON_INGOT, 1));
		recipe.shape("CCC", "CRC", "CCC");
		recipe.setIngredient('C', Material.COBBLESTONE);
		recipe.setIngredient('R', Material.REDSTONE);
		return recipe;
	}

	private Recipe getWandRecipe() {
		ShapedRecipe recipe = new ShapedRecipe(new ItemStack(Material.REDSTONE_TORCH_OFF, 1));
		recipe.shape(" D ", "DRD", " S ");
		recipe.setIngredient('D', Material.DIAMOND);
		recipe.setIngredient('R', Material.REDSTONE);
		recipe.setIngredient('S', Material.STICK);
		return recipe;
	}

	private void registerEvents() {
		PluginManager pm = getServer().getPluginManager();
		
		PlayerListener playerListener = new PlayerListener();
		pm.registerEvents(playerListener, this);
	}

	public void onDisable() {
		log.info("The Magico plugin has been disabled");
	}

}
