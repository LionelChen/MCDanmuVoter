package ink.imimi.BiliDanmuVoter;

import org.bukkit.plugin.java.JavaPlugin;


public class BiliDanmuVoter extends JavaPlugin{


    @Override
    public void onEnable() {
        getLogger().info("onEnable is called!");
        //getServer().getPluginManager().registerEvents(this, this);
        //simplePrintTest();
        this.getCommand("vote").setExecutor(new CommandVote(this));
    }
    @Override
    public void onDisable() {
        getLogger().info("onDisable is called!");
    }



}


