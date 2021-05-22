package ink.imimi.BiliDanmuVoter.Events;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class RandomDropEventHandler extends JavaPlugin implements Listener {

    @EventHandler
    public void onMobDeath(EntityDeathEvent event){
        getLogger().info("Entity died");
        //If the killer is a plyer
        if(event.getEntity().getKiller() instanceof Player){
            getLogger().info("Player killed something");
            //If the mob is a creeper
            if(event.getEntity().getType() == EntityType.CREEPER){
                //add a diamond!
                event.getDrops().add(new ItemStack(Material.DIAMOND, 1));
            }
        }
    }
}
