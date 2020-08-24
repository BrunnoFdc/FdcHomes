package ga.brunnofdc.fdchomes;

import ga.brunnofdc.fdchomes.commands.Commandhome;
import ga.brunnofdc.fdchomes.commands.Commandhomes;
import ga.brunnofdc.fdchomes.commands.Commandsethome;
import ga.brunnofdc.fdchomes.listeners.JoinQuitListener;
import ga.brunnofdc.fdchomes.listeners.MenuInteractListener;
import ga.brunnofdc.fdchomes.objects.Profile;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class Main extends JavaPlugin {

    public static Map<Player, Profile> profiles = new HashMap<>();
    private static JavaPlugin plugin;

    public void onEnable() {
        plugin = this;
        getCommand("sethome").setExecutor(new Commandsethome());
        getCommand("home").setExecutor(new Commandhome());
        getCommand("homes").setExecutor(new Commandhomes());
        Bukkit.getPluginManager().registerEvents(new JoinQuitListener(), this);
        Bukkit.getPluginManager().registerEvents(new MenuInteractListener(), this);
    }

    public static JavaPlugin getInstance() {
        return plugin;
    }

}
