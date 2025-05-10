package com.dreamfirestudios.lonelybluetradesmpplugin.ServerCommand;

import com.dreamfirestudios.dreamCommand.Interface.PCMethod;
import com.dreamfirestudios.dreamCommand.Interface.PCSignature;
import com.dreamfirestudios.dreamCommand.ServerCommand;
import com.dreamfirestudios.dreamCore.DreamfireJava.PulseAutoRegister;
import com.dreamfirestudios.lonelybluetradesmpplugin.API.LonelyBlueTradeSMPPluginAPI;
import com.dreamfirestudios.lonelybluetradesmpplugin.Enum.Messages;
import com.dreamfirestudios.lonelybluetradesmpplugin.PulseConfig.LonelyBlueTradeSMPPluginConfig;
import com.dreamfirestudios.lonelybluetradesmpplugin.PulseConfig.LonelyBlueTradeSMPPluginMessages;
import org.bukkit.command.CommandSender;

import java.util.LinkedHashMap;

@PulseAutoRegister
public class LonelyBlueTradeSMPPluginServerCommand extends ServerCommand {

    public LonelyBlueTradeSMPPluginServerCommand() {
        super("lonelybluetradesmppluginserver", false);
    }

    @Override
    public void NoMethodFound(CommandSender commandSender, String s, String[] strings) {}
    @Override
    public String helpMenuPrefix(CommandSender commandSender) {return "";}
    @Override
    public LinkedHashMap<String, String> helpMenuFormat(CommandSender commandSender, LinkedHashMap<String, String> linkedHashMap) {return new LinkedHashMap<>();}
    @Override
    public String helpMenuSuffix(CommandSender commandSender) {return "";}

    @PCMethod
    @PCSignature({})
    public void LonelyBlueTradeSMPPluginMethod(CommandSender commandSender){
        LonelyBlueTradeSMPPluginConfig.ReturnStaticAsync(LonelyBlueTradeSMPPluginConfig.class, craftLegendsCoreConfig -> {
            if(!craftLegendsCoreConfig.systemEnabled) return;
            LonelyBlueTradeSMPPluginMessages.ReturnStaticAsync(LonelyBlueTradeSMPPluginMessages.class, craftLegendsCoreMessages -> {
                craftLegendsCoreMessages.SendMessageToConsole(Messages.SystemIsntEnabled);
            }, Throwable::printStackTrace);
        }, Throwable::printStackTrace);
    }

    @PCMethod
    @PCSignature({"enable"})
    public void LonelyBlueTradeSMPPluginEnableMethod(CommandSender commandSender, boolean state){
        LonelyBlueTradeSMPPluginAPI.LonelyBlueTradeSMPPluginEnableSystem(dreamCoreTestTemplateConfig -> {}, state);
        LonelyBlueTradeSMPPluginMessages.ReturnStaticAsync(LonelyBlueTradeSMPPluginMessages.class, craftLegendsCoreMessages -> {
            craftLegendsCoreMessages.SendMessageToConsole(state ? Messages.ConsoleEnabledSystem : Messages.ConsoleDisableSystem);
        }, Throwable::printStackTrace);
    }

    @PCMethod
    @PCSignature({"configs", "reset"})
    public void LonelyBlueTradeSMPPluginConfigsResetMethod(CommandSender commandSender){
        LonelyBlueTradeSMPPluginConfig.ReturnStaticAsync(LonelyBlueTradeSMPPluginConfig.class, craftLegendsCoreConfig -> {
            if(!craftLegendsCoreConfig.systemEnabled) return;
            LonelyBlueTradeSMPPluginAPI.LonelyBlueTradeSMPPluginResetConfigs();
            LonelyBlueTradeSMPPluginMessages.ReturnStaticAsync(LonelyBlueTradeSMPPluginMessages.class, craftLegendsCoreMessages -> {
                craftLegendsCoreMessages.SendMessageToConsole(Messages.PlayerResetConfig);
            }, Throwable::printStackTrace);
        }, Throwable::printStackTrace);
    }

    @PCMethod
    @PCSignature({"configs", "reload"})
    public void LonelyBlueTradeSMPPluginConfigsReloadMethod(CommandSender commandSender){
        LonelyBlueTradeSMPPluginConfig.ReturnStaticAsync(LonelyBlueTradeSMPPluginConfig.class, craftLegendsCoreConfig -> {
            if(!craftLegendsCoreConfig.systemEnabled) return;
            LonelyBlueTradeSMPPluginAPI.LonelyBlueTradeSMPPluginResetConfigs();
            LonelyBlueTradeSMPPluginMessages.ReturnStaticAsync(LonelyBlueTradeSMPPluginMessages.class, craftLegendsCoreMessages -> {
                craftLegendsCoreMessages.SendMessageToConsole(Messages.PlayerReloadedConfig);
            }, Throwable::printStackTrace);
        }, Throwable::printStackTrace);
    }
}
