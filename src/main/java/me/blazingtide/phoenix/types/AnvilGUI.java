package me.blazingtide.phoenix.types;

import me.blazingtide.phoenix.GUI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

/**
 * The default GUI
 * <p>
 * It's similar to Bukkit.createInventory() without a inventory type.
 */
public abstract class AnvilGUI extends GUI {

    protected AnvilGUI(Player player, String title, int size) {
        super(player, title, size);
    }

    @Override
    public Inventory createInventory() {
        return Bukkit.createInventory(null, InventoryType.ANVIL, ChatColor.translateAlternateColorCodes('&', getTitle()));
    }
}
