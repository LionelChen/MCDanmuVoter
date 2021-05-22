package ink.imimi.BiliDanmuVoter;

import org.bukkit.plugin.java.JavaPlugin;

public abstract class Event {
    public final String eventName;
    public JavaPlugin ThisPlugin;
    public Double duration;

    public Event(String eventName, Double duration, JavaPlugin ThisPlugin) {
        this.eventName = eventName;
        this.ThisPlugin = ThisPlugin;
        this.duration = duration;
    }

    public abstract void StartEvent();

    public abstract void EndEvent();

}
