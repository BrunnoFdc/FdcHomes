package ga.brunnofdc.fdchomes.menu;

import ga.brunnofdc.fdchomes.objects.Home;
import ga.brunnofdc.fdchomes.objects.Profile;
import net.minecraft.server.v1_8_R3.Item;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.asList;

public class ListHomesMenu {

    private static final int LINES = 6;
    private static final String INVENTORY_TITLE = "§6Selecione uma home:";
    private static Map<Profile, ListHomesMenu> MENUS_BY_PROFILE = new HashMap<>();

    private final Profile profile;
    private final Map<ItemStack, Home> homesByIcon;

    public ListHomesMenu(Profile profile) {
        this.profile = profile;
        this.homesByIcon = new HashMap<>();

        MENUS_BY_PROFILE.put(profile, this);
    }

    public Inventory buildIventory() {
        Inventory inventory = Bukkit.createInventory(null, LINES * 9, INVENTORY_TITLE);

        profile.getHomes().forEach(home -> {
            ItemStack homeItem = new ItemStack(Material.BED);
            ItemMeta itemMeta = homeItem.getItemMeta();
            Location homeLocation = home.getLocation();

            itemMeta.setDisplayName("§cNome da home: §e" + home.getName());
            itemMeta.setLore(asList(
                    "",
                    "§aMundo: §d" + homeLocation.getWorld().getName(),
                    "§cCoordenadas: §d" + formatCoords(homeLocation),
                    "",
                    "§aClique para teleportar!"
            ));

            homeItem.setItemMeta(itemMeta);
            inventory.addItem(homeItem);
            homesByIcon.put(homeItem, home);
        });

        return inventory;
    }

    public Map<ItemStack, Home> getHomesByIcon() {
        return homesByIcon;
    }

    public static String getInventoryTitle() {
        return INVENTORY_TITLE;
    }

    public static Map<Profile, ListHomesMenu> getMenusByProfile() {
        return MENUS_BY_PROFILE;
    }

    private static String formatCoords(Location location) {
        return String.format("X: %d, Y: %d, Z: %d",
                location.getBlockX(),
                location.getBlockY(),
                location.getBlockZ());
    }

}
