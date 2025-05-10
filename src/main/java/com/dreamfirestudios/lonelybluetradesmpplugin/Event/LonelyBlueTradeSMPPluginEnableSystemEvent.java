package com.dreamfirestudios.lonelybluetradesmpplugin.Event;

import com.dreamfirestudios.lonelybluetradesmpplugin.LonelyBlueTradeSMPPlugin;
import com.dreamfirestudios.lonelybluetradesmpplugin.PulseConfig.LonelyBlueTradeSMPPluginConfig;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@Getter
public class LonelyBlueTradeSMPPluginEnableSystemEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    private final boolean oldState;
    private final boolean newState;

    public LonelyBlueTradeSMPPluginEnableSystemEvent(boolean oldState, boolean newState){
        this.oldState = oldState;
        this.newState = newState;
        LonelyBlueTradeSMPPluginConfig.ReturnStaticAsync(LonelyBlueTradeSMPPluginConfig.class, coreConfig -> {
            if(coreConfig.systemEnabled) return;
            Bukkit.getScheduler().runTask(LonelyBlueTradeSMPPlugin.GetLonelyBlueTradeSMPPlugin(), () -> {Bukkit.getPluginManager().callEvent(this);});
        }, Throwable::printStackTrace);
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
    public HandlerList getHandlers() {
        return handlers;
    }
}
