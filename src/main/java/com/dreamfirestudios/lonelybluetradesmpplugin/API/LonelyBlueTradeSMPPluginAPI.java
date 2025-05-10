package com.dreamfirestudios.lonelybluetradesmpplugin.API;

import com.dreamfirestudios.dreamConfig.DreamConfig;
import com.dreamfirestudios.lonelybluetradesmpplugin.LonelyBlueTradeSMPPlugin;
import com.dreamfirestudios.lonelybluetradesmpplugin.Event.LonelyBlueTradeSMPPluginReloadConfigEvent;
import com.dreamfirestudios.lonelybluetradesmpplugin.Event.LonelyBlueTradeSMPPluginResetConfigEvent;
import com.dreamfirestudios.lonelybluetradesmpplugin.PulseConfig.LonelyBlueTradeSMPPluginConfig;
import com.dreamfirestudios.lonelybluetradesmpplugin.PulseConfig.LonelyBlueTradeSMPPluginSerilizableItems;
import org.bukkit.inventory.ItemStack;

import java.util.function.Consumer;

public class LonelyBlueTradeSMPPluginAPI {
    public static void LonelyBlueTradeSMPPluginEnableSystem(Consumer<LonelyBlueTradeSMPPluginConfig> onSuccess, boolean state){
        LonelyBlueTradeSMPPluginConfig.ReturnStaticAsync(LonelyBlueTradeSMPPluginConfig.class, coreConfig -> {
            coreConfig.systemEnabled = state;
            coreConfig.SaveConfig(onSuccess, Throwable::printStackTrace);
        }, Throwable::printStackTrace);
    }

    public static void LonelyBlueTradeSMPPluginEnableSystem(Consumer<LonelyBlueTradeSMPPluginConfig> onSuccess){
        LonelyBlueTradeSMPPluginConfig.ReturnStaticAsync(LonelyBlueTradeSMPPluginConfig.class, coreConfig -> {
            coreConfig.systemEnabled = !coreConfig.systemEnabled;
            coreConfig.SaveConfig(onSuccess, Throwable::printStackTrace);
        }, Throwable::printStackTrace);
    }

    public static void LonelyBlueTradeSMPPluginSerializeItem(Consumer<LonelyBlueTradeSMPPluginSerilizableItems> onSuccess, String id, ItemStack itemStack){
        LonelyBlueTradeSMPPluginSerilizableItems.ReturnStaticAsync(LonelyBlueTradeSMPPluginSerilizableItems.class, coreConfig -> {
            coreConfig.AddItemStack(id, itemStack);
            coreConfig.SaveConfig(onSuccess, Throwable::printStackTrace);
        }, Throwable::printStackTrace);
    }

    public static void LonelyBlueTradeSMPPluginResetConfigs(){
        LonelyBlueTradeSMPPluginConfig.ReturnStaticAsync( LonelyBlueTradeSMPPluginConfig.class, coreConfig -> {
            if(!coreConfig.systemEnabled) return;
            DreamConfig.GetDreamfireConfig().RegisterStatic(LonelyBlueTradeSMPPlugin.GetLonelyBlueTradeSMPPlugin(), true);
            new LonelyBlueTradeSMPPluginResetConfigEvent();
        }, Throwable::printStackTrace);
    }

    public static void LonelyBlueTradeSMPPluginReloadConfigs(){
        LonelyBlueTradeSMPPluginConfig.ReturnStaticAsync(LonelyBlueTradeSMPPluginConfig.class, coreConfig -> {
            if(!coreConfig.systemEnabled) return;
            DreamConfig.GetDreamfireConfig().RegisterStatic(LonelyBlueTradeSMPPlugin.GetLonelyBlueTradeSMPPlugin(), true);
            new LonelyBlueTradeSMPPluginReloadConfigEvent();
        }, Throwable::printStackTrace);
    }
}
