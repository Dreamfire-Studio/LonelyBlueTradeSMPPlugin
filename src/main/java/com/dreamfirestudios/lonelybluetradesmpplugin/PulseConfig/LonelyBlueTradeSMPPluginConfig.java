package com.dreamfirestudios.lonelybluetradesmpplugin.PulseConfig;

import com.dreamfirestudios.dreamConfig.Abstract.StaticPulseConfig;
import com.dreamfirestudios.dreamConfig.Interface.StorageComment;
import com.dreamfirestudios.dreamCore.DreamfireJava.PulseAutoRegister;
import com.dreamfirestudios.lonelybluetradesmpplugin.LonelyBlueTradeSMPPlugin;
import com.dreamfirestudios.lonelybluetradesmpplugin.Event.LonelyBlueTradeSMPPluginEnableSystemEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.function.Consumer;

@PulseAutoRegister
public class LonelyBlueTradeSMPPluginConfig extends StaticPulseConfig<LonelyBlueTradeSMPPluginConfig> {
    @Override
    public JavaPlugin mainClass() {return LonelyBlueTradeSMPPlugin.GetLonelyBlueTradeSMPPlugin();}
    @StorageComment("WARNING: SYSTEM WONT RUN IF FALSE!")
    public boolean systemEnabled = true;
    @StorageComment("Display debugs in the console logs for changes in this config!")
    public boolean debugConfig = false;

    public void ToggleSystemEnabled(Consumer<LonelyBlueTradeSMPPluginConfig> onSuccess, boolean newState){
        new LonelyBlueTradeSMPPluginEnableSystemEvent(systemEnabled, newState);
        systemEnabled = newState;
        SaveConfig(onSuccess, Throwable::printStackTrace);
    }
}
