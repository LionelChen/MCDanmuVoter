package ink.imimi.BiliDanmuVoter;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CommandVote implements CommandExecutor {

    private final BiliDanmuVoter plugin;

    public CommandVote(BiliDanmuVoter plugin){
        this.plugin = plugin;
    }
    // This method is called, when somebody uses our command
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            // Here we need to give items to our player
            ItemStack diamond = new ItemStack(Material.DIAMOND);

            // Create a new ItemStack (type: brick)
            //ItemStack bricks = new ItemStack(Material.BRICK);

            // Set the amount of the ItemStack
            //bricks.setAmount(20);

            // Give the player our items (comma-seperated list of all ItemStack)
            player.getInventory().addItem(diamond);

        }

        new RandomEventScheduler(plugin);
        // If the player (or console) uses our command correct, we can return true
        return true;
    }
}