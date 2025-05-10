package com.dreamfirestudios.lonelybluetradesmpplugin.Enum;

import com.dreamfirestudios.lonelybluetradesmpplugin.LonelyBlueTradeSMPPlugin;

public enum Messages {
    ConsoleEnabledSystem(String.format("#7fff36%s has been enabled!", LonelyBlueTradeSMPPlugin.GetLonelyBlueTradeSMPPlugin().getName())),
    ConsoleDisableSystem(String.format("#7fff36%s has been disabled!", LonelyBlueTradeSMPPlugin.GetLonelyBlueTradeSMPPlugin().getName())),
    PlayerReloadedConfig(String.format("#7fff36%s configs have been reloaded!", LonelyBlueTradeSMPPlugin.GetLonelyBlueTradeSMPPlugin().getName())),
    PlayerSerlizedItem("#7fff36You have added a item to the serialized items: #ffffff%s"),
    PlayerResetConfig(String.format("#7fff36%s configs have been reset!", LonelyBlueTradeSMPPlugin.GetLonelyBlueTradeSMPPlugin().getName())),
    SystemIsntEnabled(String.format("#7fff36%s Isn't Enabled!", LonelyBlueTradeSMPPlugin.GetLonelyBlueTradeSMPPlugin().getName()));

    public final String message;
    Messages(String message){
        this.message = message;
    }
}
