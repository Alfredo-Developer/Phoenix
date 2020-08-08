package me.blazingtide.phoenix;

import lombok.AllArgsConstructor;
import me.blazingtide.phoenix.button.Button;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;

import java.util.Map;
import java.util.UUID;

@AllArgsConstructor
public class PhoenixListener implements Listener {

    private final Map<UUID, GUI> guis;

    @EventHandler
    public void onOpen(InventoryOpenEvent event) {
        final HumanEntity player = event.getPlayer();

        //We can assume that the player's open GUI is the same GUI that we store in the Map.
        if (guis.containsKey(player.getUniqueId())) {
            guis.get(player.getUniqueId()).onOpen(event);
        }
    }

    @EventHandler
    public void onClose(InventoryCloseEvent event) {
        final HumanEntity player = event.getPlayer();

        //We can assume that the player's open GUI is the same GUI that we store in the Map.
        if (guis.containsKey(player.getUniqueId())) {
            guis.remove(player.getUniqueId()).onClose(event);
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        final HumanEntity player = event.getWhoClicked();

        if (guis.containsKey(player.getUniqueId())) {
            final GUI gui = guis.get(player.getUniqueId());

            gui.onClickRaw(event);

            if (player.getOpenInventory() == null || event.getClickedInventory() == null) {
                return;
            }

            if (event.getClickedInventory().equals(player.getOpenInventory().getTopInventory())) {
                Button button = gui.getButtons()[event.getRawSlot()];

                if (button != null) {
                    if (button.isAutoCancelEvent()) {
                        event.setCancelled(true);
                    }
                    button.getClickConsumer().accept(event);
                }
            } else if (event.getClickedInventory().equals(player.getOpenInventory().getBottomInventory()) && event.getCurrentItem() != null) {
                gui.onPlayerInventoryClick(event);
            }
        }
    }

}
