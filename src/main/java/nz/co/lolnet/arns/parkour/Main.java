package nz.co.lolnet.arns.parkour;

import java.util.HashMap;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Arns with helpof James137137
 */
public class Main extends JavaPlugin {

    public static ItemStack wand;
    public static HashMap<String, Location[]> playerWandLocations = new HashMap<>();

    @Override
    public void onEnable() {
        getLogger().info("Hello Console,How are you today? Parkour has been enabled!");
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new MyListener(this), this);
        wand = new ItemStack(Material.getMaterial(this.getConfig().getInt("WandItem")));

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
                } else if (args[0].equalsIgnoreCase("getwand")) {
                    HashMap<Integer, ItemStack> remainingItemsNotAdded = player.getInventory().addItem(Main.wand);
                    if (remainingItemsNotAdded.isEmpty()) {
                        player.sendMessage("You now have the wand of doom!");

                    } else {
                        player.sendMessage("Item dropped on ground, inventory it full.");
                        player.getWorld().dropItemNaturally(player.getLocation(), wand);
                    }
                    player.sendMessage("You can run the follwing commands:");
                    player.sendMessage("/parkour select - This will allow you to select the area the parkour is in!");
                    player.sendMessage("/parkour addWaypoint - This allows you to select a waypoint so when a player dies they will go back to that point!");
                } else if (args[0].equalsIgnoreCase("select")) {
                    player.sendMessage("Select 2 corners of the map and type /parkour done!");
                    String playerName = player.getName();
                    Location[] locations = new Location[2];
                    playerWandLocations.put(playerName, locations);
                } else if (args[0].equalsIgnoreCase("create")) {
                    String playerName = player.getName();
                    Location[] locations = playerWandLocations.get(playerName);
                    if (locations == null || locations.length == 0) {
                        player.sendMessage("You need to run /parkour select first");
                        return true;
                    }

                    if (locations[0] == null) {
                        player.sendMessage("First Corner hasn't been selected yet");
                        return true;
                    }

                    if (locations[1] == null) {
                        player.sendMessage("Secound Corner hasn't been selected yet");
                        return true;
                    }
                }

            }
            return true;
        }
        return false;
    }

}
