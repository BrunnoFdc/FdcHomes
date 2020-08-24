package ga.brunnofdc.fdchomes.commands;

import ga.brunnofdc.fdchomes.Main;
import ga.brunnofdc.fdchomes.menu.ListHomesMenu;
import ga.brunnofdc.fdchomes.objects.Profile;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Commandhomes implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {

            Player p = (Player)sender;
            Profile profile = Main.profiles.get(p);

            if(profile == null) {
                p.sendMessage("§4ERRO: §cSeu perfil não foi encontrado. Tente relogar!");
                return true;
            }

            p.openInventory(new ListHomesMenu(profile).buildIventory());

        } else {
            sender.sendMessage("Esse comando só pode ser executado por jogadores!");
        }
        return false;
    }

}
