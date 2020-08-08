package me.blazingtide.phoenix.button;

import lombok.Getter;
import lombok.Setter;
import me.blazingtide.phoenix.GUI;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.function.Consumer;

@Getter
public class Button {

    private final Player player;
    private final GUI gui;
    private final ItemStack item;
    private final Consumer<InventoryClickEvent> clickConsumer;

    @Setter
    private boolean autoCancelEvent = true;

    public Button(Player player, GUI gui, ItemStack item, Consumer<InventoryClickEvent> clickConsumer) {
        this.player = player;
        this.gui = gui;
        this.item = item;
        this.clickConsumer = clickConsumer;
    }

}
