package ga.brunnofdc.fdchomes.listeners;

import ga.brunnofdc.fdchomes.Main;
import ga.brunnofdc.fdchomes.menu.ListHomesMenu;
import ga.brunnofdc.fdchomes.objects.Home;
import ga.brunnofdc.fdchomes.objects.Profile;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import java.util.Map;
import java.util.Optional;

public class MenuInteractListener implements Listener {

    @EventHandler
    public void onClickInventory(final InventoryClickEvent event) {
        InventoryView view = event.getView();
        Player p = (Player) event.getWhoClicked();
        Profile profile = Main.profiles.get(p);
        ItemStack clickedItem = event.getCurrentItem();

        if(view.getTitle().equals(ListHomesMenu.getInventoryTitle())) {

            if(clickedItem != null) {
                ListHomesMenu menu = ListHomesMenu.getMenusByProfile().get(profile);
                Map<ItemStack, Home> homesByIcon = menu.getHomesByIcon();
                Optional<ItemStack> similarItem = homesByIcon.keySet()
                        .stream()
                        .filter(itemStack -> itemStack.isSimilar(clickedItem))
                        .findFirst();

                similarItem.ifPresent(item -> {
                    Home home = homesByIcon.get(item);
                    home.teleportPlayer(p);
                });
            }

            event.setCancelled(true);
        }

    }

}
