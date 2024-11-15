package br.com.gokan.mreward.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PlayerUtil {



     //Version 1.7.10 craftbukkit
    
    public static boolean isSpaceInventory(ItemStack item, Player player) {
        int maxStackSize = item.getMaxStackSize();
        int remainingItems = item.getAmount();

        for (ItemStack inventoryItem : player.getInventory().getContents()) {
            if (inventoryItem == null || inventoryItem.getType() == Material.AIR) {
                remainingItems -= maxStackSize;
            } else if (inventoryItem.isSimilar(item)) {
                int spaceInStack = maxStackSize - inventoryItem.getAmount();
                remainingItems -= spaceInStack;
            }
            if (remainingItems <= 0) {
                return true;
            }
        }
        return remainingItems <= 0;
    }

    public static boolean isSpaceInventory(Player player) {
        for (ItemStack inventoryItem : player.getInventory().getContents()) {
            if (inventoryItem == null || inventoryItem.getType() == Material.AIR) {
                return true;
            }
        }
        return false;
    }

}
