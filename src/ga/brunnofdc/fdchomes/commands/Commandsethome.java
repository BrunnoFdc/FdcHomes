package ga.brunnofdc.fdchomes.commands;

import ga.brunnofdc.fdchomes.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Commandsethome implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {

            Player p = (Player)sender;
            if(args.length > 0) {
                String homeName = args[0];

                if(!Main.homes.containsKey(homeName)) {
                    Main.homes.put(homeName, p.getLocation());
                    p.sendMessage("§aSUCESSO! §eSua home §b" + homeName + "§e foi definida!");
                } else {
                    p.sendMessage("§4ERRO: §cEste nome já está em uso!");
                }

            } else {
                p.sendMessage("§4ERRO: §cUso correto: §e/sethome <nome>");
            }

        } else {
            sender.sendMessage("Esse comando só pode ser executado por jogadores!");
        }

        return false;
    }

}
