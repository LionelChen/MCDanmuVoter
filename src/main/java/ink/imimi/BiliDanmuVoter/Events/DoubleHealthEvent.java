package ink.imimi.BiliDanmuVoter.Events;

import ink.imimi.BiliDanmuVoter.Event;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public class DoubleHealthEvent extends Event {

    private final AttributeModifier IncHealthBy20 = new AttributeModifier("生命值+20", 20D, AttributeModifier.Operation.ADD_NUMBER);
    public DoubleHealthEvent(String eventName, Double duration, JavaPlugin ThisPlugin) {
        super(eventName,duration,ThisPlugin);
    }

    @Override
    public void StartEvent() {
        for(Player player : Bukkit.getOnlinePlayers()) {
            //player.setMaxHealth(40);
            AttributeInstance healthInstance = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
            healthInstance.addModifier(IncHealthBy20);
            System.out.println("Player Max health: "+player.getMaxHealth());
        }

        BukkitScheduler scheduler = ThisPlugin.getServer().getScheduler();
        scheduler.scheduleSyncDelayedTask(ThisPlugin, new Runnable() {
            public void run() {
                System.out.println("Event Ending");
                EndEvent();
            }
        }, 120L);
    }

    @Override
    public void EndEvent() {
        for(Player player : Bukkit.getOnlinePlayers()) {
            //player.setMaxHealth(20);
            AttributeInstance healthInstance = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
            healthInstance.removeModifier(IncHealthBy20);
            System.out.println("Player Max health: "+player.getMaxHealth());
        }
    }
}
