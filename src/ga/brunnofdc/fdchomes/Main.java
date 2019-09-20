package ga.brunnofdc.fdchomes;

import ga.brunnofdc.fdchomes.commands.Home;
import ga.brunnofdc.fdchomes.commands.Sethome;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class Main extends JavaPlugin {

    //Salva "Nome da Home"->"Location"
    public static Map<String, Location> homes = new HashMap<>();
    private static JavaPlugin plugin;

    public void onEnable() {
        plugin = this;
        getCommand("sethome").setExecutor(new Sethome());
        getCommand("home").setExecutor(new Home());
    }

    public static JavaPlugin getInstance() {
        return plugin;
    }



}
