package ink.imimi.BiliDanmuVoter;

import ink.imimi.BiliDanmuVoter.Events.DoubleHealthEvent;
import ink.imimi.BiliDanmuVoter.Events.RandomDropEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;

import java.util.ArrayList;
import java.util.List;

public class RandomEvent extends BukkitRunnable {

    private final JavaPlugin plugin;
    private final static List<Event> randomEventList=new ArrayList<Event>();
    private int counter;

    public RandomEvent(JavaPlugin plugin, int counter) {
        this.plugin = plugin;
        this.counter = counter;
        Double Duration1m = 1200D;
        Double Duration10s = 200D;

        Event doubleHealth = new DoubleHealthEvent("双倍血量", Duration10s, plugin);
        randomEventList.add(doubleHealth);
        Event randomDrop = new RandomDropEvent("随机掉落", Duration10s, plugin);
        randomEventList.add(randomDrop);
        Event testEvent1 = new DoubleHealthEvent("Test Event 1", Duration10s, plugin);
        Event testEvent2 = new RandomDropEvent("Test Event 2", Duration10s, plugin);
        randomEventList.add(testEvent1);
        randomEventList.add(testEvent2);
    }

    @Override
    public void run() {
        // What you want to schedule goes here
        if (counter > 0) {
            plugin.getServer().broadcastMessage("下一次投票时间: " + counter--);
        } else {
            plugin.getServer().broadcastMessage("投票开始");
            ScoreboardManager manager = Bukkit.getScoreboardManager();
            Scoreboard board = manager.getNewScoreboard();

            Objective objective = board.registerNewObjective("test1", "dummy", "下一个弹幕投票事件");
            objective.setDisplaySlot(DisplaySlot.SIDEBAR);
            //Score score = objective.getScore(player.getDisplayName());
            //score.setScore(42);

            Score option1 = objective.getScore(randomEventList.get(0).eventName);
            option1.setScore(0);
            Score option2 = objective.getScore(randomEventList.get(1).eventName);
            option2.setScore(0);

            for(Player player : Bukkit.getOnlinePlayers()) {
                player.setScoreboard(board);
            }
            List<Score> optionList = new ArrayList<Score>();
            optionList.add(option1);
            optionList.add(option2);

            DanmuClientThread mythread = new DanmuClientThread(Bukkit.getServer(),optionList);
            mythread.start();
            randomEventList.get(0).StartEvent();


        }
    }

}