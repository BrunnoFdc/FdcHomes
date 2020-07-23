package ga.brunnofdc.fdchomes.listeners;

import ga.brunnofdc.fdchomes.Main;
import ga.brunnofdc.fdchomes.objects.Profile;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;

public class JoinQuitListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        Profile profile = new Profile(player.getUniqueId(), player.getName(), new ArrayList<>());

        Main.profiles.put(player, profile);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        Main.profiles.remove(player);
    }

}
