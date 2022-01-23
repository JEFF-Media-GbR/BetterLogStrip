package com.jeff_media.betterlogstrip;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MainCommand implements CommandExecutor {

    private static final BetterLogStrip main = BetterLogStrip.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {

        if(!sender.hasPermission("betterlogstrip.reload")) {
            sender.sendMessage(command.getPermissionMessage());
            return true;
        }

        main.reload();
        sender.sendMessage("§aConfiguration has been reloaded.");

        return false;
    }
}
