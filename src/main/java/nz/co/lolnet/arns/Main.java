package nz.co.lolnet.arns;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Arns
 */
public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Hello Console,How are you today? Parkour has been enabled!");
    }

    public void onDisable() {
        getLogger().info("Bye Console! Parkour has been disabled :'( ");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("parkour") && sender instanceof Player) {

            Player player = (Player) sender;
            if (args.length >= 1) {
                if (args[0].equalsIgnoreCase("help")) {
                    player.sendMessage("Commands coming soon!");
                }

            }

        }

        return false;
    }

}
