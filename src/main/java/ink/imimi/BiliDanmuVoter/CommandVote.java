package ink.imimi.BiliDanmuVoter;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.*;

public class CommandVote implements CommandExecutor {

    // This method is called, when somebody uses our command
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            // Here we need to give items to our player
            ItemStack diamond = new ItemStack(Material.DIAMOND);

            // Create a new ItemStack (type: brick)
            ItemStack bricks = new ItemStack(Material.BRICK);

            // Set the amount of the ItemStack
            bricks.setAmount(20);

            // Give the player our items (comma-seperated list of all ItemStack)
            player.getInventory().addItem(bricks, diamond);

            ScoreboardManager manager = Bukkit.getScoreboardManager();
            Scoreboard board = manager.getNewScoreboard();
            //BPlayerBoard board = Netherboard.instance().createBoard(player, "正在投票");
            //Team team = board.registerNewTeam("team1");
            //team.addEntry("下一个投票事件");

            Objective objective = board.registerNewObjective("test1", "dummy", "下一个弹幕投票事件");
            objective.setDisplaySlot(DisplaySlot.SIDEBAR);
            //Score score = objective.getScore(player.getDisplayName());
            //score.setScore(42);

            Score option1 = objective.getScore("生命值减半");
            option1.setScore(10);
            Score option2 = objective.getScore("随机掉落");
            option2.setScore(5);
            player.setScoreboard(board);
        }

        System.out.println("Player only command.");
        // If the player (or console) uses our command correct, we can return true
        return true;
    }
}