package com.jeff_media.betterlogstrip;

import com.jeff_media.jefflib.data.WoodType;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.StonecuttingRecipe;

import java.util.Locale;

/**
 * THIS IS MESSY. If someone wants to tidy it up - feel free to do so :D
 */
public class RecipeManager {

    private static final BetterLogStrip main = BetterLogStrip.getInstance();

    private static final String STRIPPED_LOG = "log-to-stripped-log";
    private static final String STRIPPED_WOOD = "wood-to-stripped-wood";
    private static final String CUTTER_STRIPPED_LOG = "cutter-log-to-stripped-log";
    private static final String CUTTER_STRIPPED_WOOD = "cutter-wood-to-stripped-wood";
    private static final String CUTTER_PLANKS1 = "cutter-log-to-stripped-planks1";
    private static final String CUTTER_PLANKS2 = "cutter-log-to-stripped-planks2";
    private static final String CUTTER_PLANKS3 = "cutter-log-to-stripped-planks3";
    private static final String CUTTER_PLANKS4 = "cutter-log-to-stripped-planks4";
    private static final String CUTTER_SLABS1 = "cutter-log-to-slabs1";
    private static final String CUTTER_SLABS2 = "cutter-log-to-slabs2";
    private static final String CUTTER_SLABS3 = "cutter-log-to-slabs3";
    private static final String CUTTER_SLABS4 = "cutter-log-to-slabs4";
    private static final String CUTTER_SLABS5 = "cutter-log-to-slabs5";
    private static final String CUTTER_STAIRS1 = "cutter-log-to-stairs1";
    private static final String CUTTER_STAIRS2 = "cutter-log-to-stairs2";
    private static final String CUTTER_STAIRS3 = "cutter-log-to-stairs3";
    private static final String CUTTER_STAIRS4 = "cutter-log-to-stairs4";
    private static final String CUTTER_STAIRS5 = "cutter-log-to-stairs5";
    private static final String CUTTER_FENCE1 = "cutter-log-to-fence1";
    private static final String CUTTER_FENCE2 = "cutter-log-to-fence2";
    private static final String CUTTER_FENCE3 = "cutter-log-to-fence3";
    private static final String CUTTER_FENCE4 = "cutter-log-to-fence4";
    private static final String CUTTER_FENCE5 = "cutter-log-to-fence5";
    private static final String CUTTER_FENCEGATE1 = "cutter-log-to-fencegate1";
    private static final String CUTTER_FENCEGATE2 = "cutter-log-to-fencegate2";
    private static final String CUTTER_FENCEGATE3 = "cutter-log-to-fencegate3";
    private static final String CUTTER_FENCEGATE4 = "cutter-log-to-fencegate4";
    private static final String CUTTER_FENCEGATE5 = "cutter-log-to-fencegate5";
    private static final String CUTTER_DOOR1 = "cutter-log-to-door1";
    private static final String CUTTER_DOOR2 = "cutter-log-to-door2";
    private static final String CUTTER_DOOR3 = "cutter-log-to-door3";
    private static final String CUTTER_DOOR4 = "cutter-log-to-door4";
    private static final String CUTTER_DOOR5 = "cutter-log-to-door5";
    private static final String CUTTER_TRAPDOOR1 = "cutter-log-to-trapdoor1";
    private static final String CUTTER_TRAPDOOR2 = "cutter-log-to-trapdoor2";
    private static final String CUTTER_TRAPDOOR3 = "cutter-log-to-trapdoor3";
    private static final String CUTTER_TRAPDOOR4 = "cutter-log-to-trapdoor4";
    private static final String CUTTER_TRAPDOOR5 = "cutter-log-to-trapdoor5";
    private static final String CUTTER_BUTTON1 = "cutter-log-to-button1";
    private static final String CUTTER_BUTTON2 = "cutter-log-to-button2";
    private static final String CUTTER_BUTTON3 = "cutter-log-to-button3";
    private static final String CUTTER_BUTTON4 = "cutter-log-to-button4";
    private static final String CUTTER_BUTTON5 = "cutter-log-to-button5";
    private static final String CUTTER_BOAT1 = "cutter-log-to-boat1";
    private static final String CUTTER_BOAT2 = "cutter-log-to-boat2";
    private static final String CUTTER_BOAT3 = "cutter-log-to-boat3";
    private static final String CUTTER_BOAT4 = "cutter-log-to-boat4";
    private static final String CUTTER_BOAT5 = "cutter-log-to-boat5";


    private static NamespacedKey getKey(String key, WoodType type) {
        NamespacedKey result = new NamespacedKey(main, key + "-" + type.name().toLowerCase(Locale.ROOT));
        //System.out.println(result);
        main.getRecipes().add(result);
        return result;
    }

    public static void registerRecipes() {
        //System.out.println(0);
        for(WoodType type : WoodType.values()) {
			try {
				if(type.getLog() == null) continue;
				if (main.getConfig().getBoolean("crafting.stripped-log", false)) {
					//System.out.println(1);
					ShapedRecipe recipe = new ShapedRecipe(getKey(STRIPPED_LOG, type), new ItemStack(type.getStrippedLog(), 2));
					recipe.shape("X", "X");
					recipe.setIngredient('X', type.getLog());
					Bukkit.addRecipe(recipe);
					//System.out.println("Registered recipe " + recipe);
				}
				if (main.getConfig().getBoolean("crafting.stripped-wood", false)) {
					//System.out.println(2);
					ShapedRecipe recipe = new ShapedRecipe(getKey(STRIPPED_WOOD, type), new ItemStack(type.getStrippedWood(), 2));
					recipe.shape("X", "X");
					recipe.setIngredient('X', type.getWood());
					Bukkit.addRecipe(recipe);
				}
				if (main.getConfig().getBoolean("stonecutter.stripped-log", false)) {
					//System.out.println(3);
					registerStonecuttingRecipe(getKey(CUTTER_STRIPPED_LOG, type), type.getLog(), type.getStrippedLog(), 1);
				}
				if (main.getConfig().getBoolean("stonecutter.stripped-wood", false)) {
					registerStonecuttingRecipe(getKey(CUTTER_STRIPPED_WOOD, type), type.getWood(), type.getStrippedWood(), 1);
				}
				if (main.getConfig().getBoolean("stonecutter.planks", false)) {
					registerStonecuttingRecipe(getKey(CUTTER_PLANKS1, type), type.getLog(), type.getPlanks(), 4);
					registerStonecuttingRecipe(getKey(CUTTER_PLANKS2, type), type.getWood(), type.getPlanks(), 4);
					registerStonecuttingRecipe(getKey(CUTTER_PLANKS3, type), type.getStrippedLog(), type.getPlanks(), 4);
					registerStonecuttingRecipe(getKey(CUTTER_PLANKS4, type), type.getStrippedWood(), type.getPlanks(), 4);
				}
				if (main.getConfig().getBoolean("stonecutter.slabs", false)) {
					registerStonecuttingRecipe(getKey(CUTTER_SLABS1, type), type.getLog(), type.getSlab(), 8);
					registerStonecuttingRecipe(getKey(CUTTER_SLABS2, type), type.getWood(), type.getSlab(), 8);
					registerStonecuttingRecipe(getKey(CUTTER_SLABS3, type), type.getStrippedLog(), type.getSlab(), 8);
					registerStonecuttingRecipe(getKey(CUTTER_SLABS4, type), type.getStrippedWood(), type.getSlab(), 8);
					registerStonecuttingRecipe(getKey(CUTTER_SLABS5, type), type.getPlanks(), type.getSlab(), 2);
				}
				if (main.getConfig().getBoolean("stonecutter.stairs", false)) {
					registerStonecuttingRecipe(getKey(CUTTER_STAIRS1, type), type.getLog(), type.getStairs(), 4);
					registerStonecuttingRecipe(getKey(CUTTER_STAIRS2, type), type.getWood(), type.getStairs(), 4);
					registerStonecuttingRecipe(getKey(CUTTER_STAIRS3, type), type.getStrippedLog(), type.getStairs(), 4);
					registerStonecuttingRecipe(getKey(CUTTER_STAIRS4, type), type.getStrippedWood(), type.getStairs(), 4);
					registerStonecuttingRecipe(getKey(CUTTER_STAIRS5, type), type.getPlanks(), type.getStairs(), 1);
				}
				if (main.getConfig().getBoolean("stonecutter.fence", false)) {
					registerStonecuttingRecipe(getKey(CUTTER_FENCE1, type), type.getLog(), type.getFence(), 4);
					registerStonecuttingRecipe(getKey(CUTTER_FENCE2, type), type.getWood(), type.getFence(), 4);
					registerStonecuttingRecipe(getKey(CUTTER_FENCE3, type), type.getStrippedLog(), type.getFence(), 4);
					registerStonecuttingRecipe(getKey(CUTTER_FENCE4, type), type.getStrippedWood(), type.getFence(), 4);
					registerStonecuttingRecipe(getKey(CUTTER_FENCE5, type), type.getPlanks(), type.getFence(), 1);
				}
				if (main.getConfig().getBoolean("stonecutter.fence-gate", false)) {
					registerStonecuttingRecipe(getKey(CUTTER_FENCEGATE1, type), type.getLog(), type.getFenceGate(), 4);
					registerStonecuttingRecipe(getKey(CUTTER_FENCEGATE2, type), type.getWood(), type.getFenceGate(), 4);
					registerStonecuttingRecipe(getKey(CUTTER_FENCEGATE3, type), type.getStrippedLog(), type.getFenceGate(), 4);
					registerStonecuttingRecipe(getKey(CUTTER_FENCEGATE4, type), type.getStrippedWood(), type.getFenceGate(), 4);
					registerStonecuttingRecipe(getKey(CUTTER_FENCEGATE5, type), type.getPlanks(), type.getFenceGate(), 1);
				}
				if (main.getConfig().getBoolean("stonecutter.door", false)) {
					registerStonecuttingRecipe(getKey(CUTTER_DOOR1, type), type.getLog(), type.getDoor(), 4);
					registerStonecuttingRecipe(getKey(CUTTER_DOOR2, type), type.getWood(), type.getDoor(), 4);
					registerStonecuttingRecipe(getKey(CUTTER_DOOR3, type), type.getStrippedLog(), type.getDoor(), 4);
					registerStonecuttingRecipe(getKey(CUTTER_DOOR4, type), type.getStrippedWood(), type.getDoor(), 4);
					registerStonecuttingRecipe(getKey(CUTTER_DOOR5, type), type.getPlanks(), type.getDoor(), 1);
				}
				if (main.getConfig().getBoolean("stonecutter.trapdoor", false)) {
					registerStonecuttingRecipe(getKey(CUTTER_TRAPDOOR1, type), type.getLog(), type.getTrapdoor(), 4);
					registerStonecuttingRecipe(getKey(CUTTER_TRAPDOOR2, type), type.getWood(), type.getTrapdoor(), 4);
					registerStonecuttingRecipe(getKey(CUTTER_TRAPDOOR3, type), type.getStrippedLog(), type.getTrapdoor(), 4);
					registerStonecuttingRecipe(getKey(CUTTER_TRAPDOOR4, type), type.getStrippedWood(), type.getTrapdoor(), 4);
					registerStonecuttingRecipe(getKey(CUTTER_TRAPDOOR5, type), type.getPlanks(), type.getTrapdoor(), 1);
				}
				if (main.getConfig().getBoolean("stonecutter.button", false)) {
					registerStonecuttingRecipe(getKey(CUTTER_BUTTON1, type), type.getLog(), type.getButton(), 4);
					registerStonecuttingRecipe(getKey(CUTTER_BUTTON2, type), type.getWood(), type.getButton(), 4);
					registerStonecuttingRecipe(getKey(CUTTER_BUTTON3, type), type.getStrippedLog(), type.getButton(), 4);
					registerStonecuttingRecipe(getKey(CUTTER_BUTTON4, type), type.getStrippedWood(), type.getButton(), 4);
					registerStonecuttingRecipe(getKey(CUTTER_BUTTON5, type), type.getPlanks(), type.getButton(), 1);
				}
				if (main.getConfig().getBoolean("stonecutter.boat", false)) {
					if (type.getBoat() != null) {
						registerStonecuttingRecipe(getKey(CUTTER_BOAT1, type), type.getLog(), type.getBoat(), 4);
						registerStonecuttingRecipe(getKey(CUTTER_BOAT2, type), type.getWood(), type.getBoat(), 4);
						registerStonecuttingRecipe(getKey(CUTTER_BOAT3, type), type.getStrippedLog(), type.getBoat(), 4);
						registerStonecuttingRecipe(getKey(CUTTER_BOAT4, type), type.getStrippedWood(), type.getBoat(), 4);
						registerStonecuttingRecipe(getKey(CUTTER_BOAT5, type), type.getPlanks(), type.getBoat(), 1);
					}
				}

			} catch (Exception ignored) {

			}
        }
    }

    private static void registerStonecuttingRecipe(NamespacedKey key, Material input, Material output, int amount) {
        StonecuttingRecipe recipe = new StonecuttingRecipe(key, new ItemStack(output, amount), input);
        Bukkit.addRecipe(recipe);
    }

}
