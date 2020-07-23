package ga.brunnofdc.fdchomes.commands;

import ga.brunnofdc.fdchomes.Main;
import ga.brunnofdc.fdchomes.objects.Home;
import ga.brunnofdc.fdchomes.objects.Profile;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Commandhome implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {

            Player p = (Player)sender;
            Profile profile = Main.profiles.get(p);

            if(profile == null) {
                p.sendMessage("§4ERRO: §cSeu perfil não foi encontrado. Tente relogar!");
                return true;
            }

            if(args.length > 0) {
                String homeName = args[0];
                Optional<Home> homeOptional = profile.getHomes()
                        .stream()
                        .filter(filteredHome -> filteredHome.getName().equals(homeName))
                        .findFirst();
                if(homeOptional.isPresent()) {
                    homeOptional.get().teleportPlayer(p);
                    p.sendMessage("§aSUCESSO! §eVocê foi teleportado!");
                } else {
                    p.sendMessage("§4ERRO: §cEsta home não existe!");
                }

            } else {
                p.sendMessage("§4ERRO: §cUso correto: §e/home <nome>");
            }

        } else {
            sender.sendMessage("Esse comando só pode ser executado por jogadores!");
        }
        return false;
    }
}
