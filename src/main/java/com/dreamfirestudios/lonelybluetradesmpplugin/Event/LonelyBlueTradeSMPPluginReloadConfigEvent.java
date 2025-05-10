package com.dreamfirestudios.lonelybluetradesmpplugin.Event;

import com.dreamfirestudios.lonelybluetradesmpplugin.LonelyBlueTradeSMPPlugin;
import com.dreamfirestudios.lonelybluetradesmpplugin.PulseConfig.LonelyBlueTradeSMPPluginConfig;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@Getter
public class LonelyBlueTradeSMPPluginReloadConfigEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    public LonelyBlueTradeSMPPluginReloadConfigEvent(){
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
