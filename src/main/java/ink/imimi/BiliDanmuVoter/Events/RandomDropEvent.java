package ink.imimi.BiliDanmuVoter.Events;

import ink.imimi.BiliDanmuVoter.Event;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

import static org.bukkit.Bukkit.getServer;

public class RandomDropEvent extends Event {
    private final Listener RDEL = new RandomDropEventHandler();

    public RandomDropEvent(String eventName, Double duration, JavaPlugin ThisPlugin) {
        super(eventName, duration, ThisPlugin);
    }

    @Override
    public void StartEvent() {
        getServer().getPluginManager().registerEvents(RDEL, ThisPlugin);
    }

    @Override
    public void EndEvent() {
        EntityDeathEvent.getHandlerList().unregister(RDEL);

    }
}
