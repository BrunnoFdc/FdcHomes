package ga.brunnofdc.fdchomes;

import ga.brunnofdc.fdchomes.commands.Commandhome;
import ga.brunnofdc.fdchomes.commands.Commandsethome;
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
        getCommand("sethome").setExecutor(new Commandsethome());
        getCommand("home").setExecutor(new Commandhome());
    }

    public static JavaPlugin getInstance() {
        return plugin;
    }



}
