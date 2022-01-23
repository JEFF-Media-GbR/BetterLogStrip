package com.jeff_media.betterlogstrip;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Iterator;

public class BetterLogStrip extends JavaPlugin {

    @Getter private static BetterLogStrip instance;
    @Getter private HashSet<NamespacedKey> recipes = new HashSet<>();

    {
        instance = this;
    }

    @Override
    public void onEnable() {
        reload();
        getCommand("betterlogstrip").setExecutor(new MainCommand());
        getServer().getPluginManager().registerEvents( new StripListener(),this);
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
    }

    private void removeOldRecipes() {
        NamespacedKey dummy = new NamespacedKey(this,"dummy");
        recipes.stream()
                .filter(recipe -> recipe.getNamespace().equals(dummy.getNamespace()))
                .forEach(Bukkit::removeRecipe);
    }

    public void reload() {
        saveDefaultConfig();
        reloadConfig();
        removeOldRecipes();
        recipes = new HashSet<>();
        RecipeManager.registerRecipes();
    }
}
