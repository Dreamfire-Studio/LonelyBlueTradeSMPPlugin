package com.dreamfirestudios.lonelybluetradesmpplugin.PulseConfig;

import com.dreamfirestudios.dreamConfig.Abstract.StaticEnumPulseConfig;
import com.dreamfirestudios.dreamCore.DreamfireJava.PulseAutoRegister;
import com.dreamfirestudios.lonelybluetradesmpplugin.LonelyBlueTradeSMPPlugin;
import com.dreamfirestudios.lonelybluetradesmpplugin.Enum.InventoryItems;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

@PulseAutoRegister
public class LonelyBlueTradeSMPPluginInventoryItems extends StaticEnumPulseConfig<LonelyBlueTradeSMPPluginInventoryItems, InventoryItems, ItemStack> {
    @Override
    public JavaPlugin mainClass() {return LonelyBlueTradeSMPPlugin.GetLonelyBlueTradeSMPPlugin();}
    @Override
    protected Class<InventoryItems> getKeyClass () {return InventoryItems.class;}
    @Override
    protected Class<ItemStack> getValueClass () {return ItemStack.class;}
    @Override
    protected ItemStack getDefaultValueFor (InventoryItems craftLegendsCoreInventoryItem) {return craftLegendsCoreInventoryItem.ReturnItemStack();}
}
