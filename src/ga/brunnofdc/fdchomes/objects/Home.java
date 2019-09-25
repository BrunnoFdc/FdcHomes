package ga.brunnofdc.fdchomes.objects;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Home {

    private Profile owner;
    private String name;
    private Location location;

    public Home(Profile owner, String homeName, Location location) {
        this.owner = owner;
        this.name = homeName;
        this.location = location;
    }

    public Home(Profile owner, String homeName, String worldName, double x, double y, double z) {
        this.owner = owner;
        this.name = homeName;
        World world = Bukkit.getWorld(worldName);
        this.location = new Location(world, x, y, z);

    }

    public Profile getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void teleportPlayer(Player player) {
        player.teleport(this.location);
    }


}
