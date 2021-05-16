package ink.imimi.BiliDanmuVoter;


import com.ggemo.va.bilidanmakuclient.BiliLiveDanmakuClient;
import com.ggemo.va.bilidanmakuclient.handler.CmdHandler;
import com.ggemo.va.bilidanmakuclient.handler.HandlerHolder;
import com.ggemo.va.bilidanmakuclient.handler.UserCountHandler;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;

import com.ggemo.va.bililivedanmakuoop.cmddata.DanmakuData;
import com.ggemo.va.bililivedanmakuoop.cmddata.GuardBuyData;
import com.ggemo.va.bililivedanmakuoop.cmddata.SendGiftData;
import com.ggemo.va.bililivedanmakuoop.cmddata.SuperChatData;
import com.ggemo.va.bililivedanmakuoop.handler.*;

public class BiliDanmuVoter extends JavaPlugin implements Listener {

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

    @Override
    public void onEnable() {
        getLogger().info("onEnable is called!");
        getServer().getPluginManager().registerEvents(this, this);
        //simplePrintTest();
        this.getCommand("vote").setExecutor(new CommandVote(this));
    }
    @Override
    public void onDisable() {
        getLogger().info("onDisable is called!");
    }



}


