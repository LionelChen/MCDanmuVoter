package ink.imimi.BiliDanmuVoter;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitTask;

public class RandomEventScheduler implements Listener {

    private final BiliDanmuVoter plugin;
    public BukkitTask votingTask;

    public RandomEventScheduler(BiliDanmuVoter plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);

        // Announce upcoming random event voting
        //BukkitTask task = new RandomEvent(this.plugin, 10).runTaskTimer(this.plugin, 10, 20);
        BukkitTask task = new RandomEvent(this.plugin,0).runTaskLater(this.plugin, 20);
        votingTask = task;
    }


}
