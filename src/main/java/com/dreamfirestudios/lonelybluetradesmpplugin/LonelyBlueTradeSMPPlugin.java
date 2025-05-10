package com.dreamfirestudios.lonelybluetradesmpplugin;

import com.dreamfirestudios.dreamCommand.DreamCommand;
import com.dreamfirestudios.dreamCore.DreamfireJava.DreamfireClassAPI;
import com.dreamfirestudios.lonelybluetradesmpplugin.API.LonelyBlueTradeSMPPluginAPI;
import com.dreamfirestudios.lonelybluetradesmpplugin.DreamfireVariableTest.LonelyBlueTradeSMPPluginInventoryItemsVariableTest;
import com.dreamfirestudios.lonelybluetradesmpplugin.DreamfireVariableTest.LonelyBlueTradeSMPPluginMessagesVariableTest;
import com.dreamfirestudios.lonelybluetradesmpplugin.DreamfireVariableTest.LonelyBlueTradeSMPPluginPermissionsVariableTest;
import org.bukkit.plugin.java.JavaPlugin;

public final class LonelyBlueTradeSMPPlugin extends JavaPlugin {
    private static LonelyBlueTradeSMPPlugin craftLegendsCore;
    public static LonelyBlueTradeSMPPlugin GetLonelyBlueTradeSMPPlugin(){return craftLegendsCore;}

    @Override
    public void onEnable() {
        craftLegendsCore = this;
        DreamfireClassAPI.RegisterPulseVariableTest(craftLegendsCore, new LonelyBlueTradeSMPPluginMessagesVariableTest());
        DreamfireClassAPI.RegisterPulseVariableTest(craftLegendsCore, new LonelyBlueTradeSMPPluginInventoryItemsVariableTest());
        DreamfireClassAPI.RegisterPulseVariableTest(craftLegendsCore, new LonelyBlueTradeSMPPluginPermissionsVariableTest());
        LonelyBlueTradeSMPPluginAPI.LonelyBlueTradeSMPPluginReloadConfigs();
        DreamfireClassAPI.RegisterClasses(this);
        DreamCommand.RegisterRaw(this);
    }
}
