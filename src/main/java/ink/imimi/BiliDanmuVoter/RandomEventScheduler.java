package ink.imimi.BiliDanmuVoter;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitTask;

public class RandomEventScheduler implements Listener {

    private final BiliDanmuVoter plugin;

    public RandomEventScheduler(BiliDanmuVoter plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        // Create the task and schedule
        BukkitTask task = new RandomEvent(this.plugin, 5).runTaskTimer(this.plugin, 10, 20);
    }

}
