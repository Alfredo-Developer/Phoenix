package me.blazingtide.phoenix.pagination.button;

import me.blazingtide.phoenix.button.Button;
import me.blazingtide.phoenix.pagination.PaginatedGUI;
import org.bukkit.entity.Player;

public class PaginatedButton extends Button {

    public PaginatedButton(Player player, PaginatedGUI gui, PaginationType type) {
        super(player, gui, type.getItem(), event -> {
            if (type == PaginationType.NEXT_PAGE) {
                if (gui.getMaxPage() < gui.getPage()) {
                    gui.setPage(gui.getMaxPage());
                    return;
                }
                gui.setPage(gui.getPage() + 1);
            } else {
                if (gui.getPage() > 1) {
                    gui.setPage(gui.getPage() - 1);
                }
            }
            gui.update();
        });
    }
}