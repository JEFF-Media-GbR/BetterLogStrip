package com.jeff_media.betterlogstrip;

import com.jeff_media.jefflib.data.WoodType;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class StripListener implements Listener {

    private static final BetterLogStrip main = BetterLogStrip.getInstance();

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onStrip(PlayerInteractEvent event) {
        if(event.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        Block clickedBlock = event.getClickedBlock();
        WoodType type = WoodType.fromMaterial(clickedBlock.getType());
        if(type == null) return;
        if(type.getLog() != clickedBlock.getType() && type.getWood() != clickedBlock.getType()) return;
        if(!isAxe(event.getItem())) return;
        if(!main.getConfig().getBoolean("prevent-stripping",true)) return;
        event.setCancelled(true);
    }

    private static boolean isAxe(ItemStack item) {
        if(item==null) return false;
        if(item.getAmount()==0) return false;
        return item.getType().name().endsWith("_AXE");
    }
}
