package me.blazingtide.phoenix.pagination.button;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

@AllArgsConstructor
@Getter
public enum PaginationType {

    NEXT_PAGE(new ItemStack(Material.ARROW)),
    PREVIOUS_PAGE(new ItemStack(Material.ARROW));

    @Setter
    private ItemStack item;

}
