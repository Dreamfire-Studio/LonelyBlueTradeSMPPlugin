package com.dreamfirestudios.lonelybluetradesmpplugin.SmartInvs;

import com.dreamfirestudios.dreamCore.DreamfireSmartInvs.SmartInventory;
import com.dreamfirestudios.dreamCore.DreamfireSmartInvs.content.InventoryContents;
import com.dreamfirestudios.dreamCore.DreamfireSmartInvs.content.InventoryProvider;
import com.dreamfirestudios.lonelybluetradesmpplugin.API.LonelyBlueTradeSMPPluginAPI;
import com.dreamfirestudios.lonelybluetradesmpplugin.Enum.InventoryItems;
import com.dreamfirestudios.lonelybluetradesmpplugin.Enum.Permissions;
import com.dreamfirestudios.lonelybluetradesmpplugin.PulseConfig.LonelyBlueTradeSMPPluginConfig;
import com.dreamfirestudios.lonelybluetradesmpplugin.PulseConfig.LonelyBlueTradeSMPPluginPermissions;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class LonelyBlueTradeSMPPluginCoreMenu implements InventoryProvider {
    private final SmartInventory smartInventory;

    public LonelyBlueTradeSMPPluginCoreMenu(Player... players){
        smartInventory = SmartInventory.builder()
                .id("LonelyBlueTradeSMPPluginCoreMenu")
                .provider(this)
                .size(1, 9)
                .title(NamedTextColor.RED + "Admin Menu")
                .build();
        for(var player : players) smartInventory.open(player);
    }

    public CompletableFuture<Void> init(Player player, InventoryContents inventoryContents) {
        CompletableFuture<Void> future = new CompletableFuture<>();
        LonelyBlueTradeSMPPluginConfig.ReturnStaticAsync(LonelyBlueTradeSMPPluginConfig.class, craftLegendsCoreConfig -> {
            LonelyBlueTradeSMPPluginSmartInvsItems.InventoryItem(player, InventoryItems.BlankTile, clickableItem -> {
                inventoryContents.fillRow(0, clickableItem);
            }, this::BlankTileClick);

            LonelyBlueTradeSMPPluginSmartInvsItems.InventoryItemWithFeedback(player, InventoryItems.SystemEnabled,
                    itemStack -> {
                        var itemMeta = itemStack.getItemMeta();
                        var lore = craftLegendsCoreConfig.systemEnabled
                                ? List.of(Component.text(NamedTextColor.WHITE + "Currently: " + NamedTextColor.GREEN + "ENABLED"))
                                : List.of(Component.text(NamedTextColor.WHITE + "Currently: " + NamedTextColor.RED + "DISABLED"));
                        itemMeta.lore(lore);
                        itemStack.setItemMeta(itemMeta);
                        return itemStack;
                    },
                    clickableItem -> {
                        inventoryContents.set(0, 2, clickableItem);
                    }, this::SystemEnabledClick);

            LonelyBlueTradeSMPPluginSmartInvsItems.InventoryItem(player, InventoryItems.ReloadConfigs, clickableItem -> {
                inventoryContents.set(0, 4, clickableItem);
            }, this::ReloadConfigsClick);

            LonelyBlueTradeSMPPluginSmartInvsItems.InventoryItem(player, InventoryItems.ResetConfigs, clickableItem -> {
                inventoryContents.set(0, 6, clickableItem);
            }, this::ResetConfigsClick);

            future.complete(null);
        }, future::completeExceptionally);
        return future;
    }

    private void BlankTileClick(Player player, InventoryClickEvent inventoryClickEvent){
        inventoryClickEvent.setCancelled(false);
    }

    private void SystemEnabledClick(Player player, InventoryClickEvent inventoryClickEvent){
        LonelyBlueTradeSMPPluginPermissions.ReturnStaticAsync(LonelyBlueTradeSMPPluginPermissions.class, craftLegendsCorePermissions -> {
            if(!craftLegendsCorePermissions.DoesPlayerHavePermission(Permissions.EnableSystem, player, true)) return;
            LonelyBlueTradeSMPPluginAPI.LonelyBlueTradeSMPPluginEnableSystem(dreamCoreTestTemplateConfig -> {});
            smartInventory.open(player);
        }, Throwable::printStackTrace);
    }

    private void ReloadConfigsClick(Player player, InventoryClickEvent inventoryClickEvent) {
        LonelyBlueTradeSMPPluginPermissions.ReturnStaticAsync(LonelyBlueTradeSMPPluginPermissions.class, craftLegendsCorePermissions -> {
            if (!craftLegendsCorePermissions.DoesPlayerHavePermission(Permissions.ReloadConfigs, player, true)) return;
            LonelyBlueTradeSMPPluginAPI.LonelyBlueTradeSMPPluginReloadConfigs();
            smartInventory.open(player);
        }, Throwable::printStackTrace);
    }

    private void ResetConfigsClick(Player player, InventoryClickEvent inventoryClickEvent){
        LonelyBlueTradeSMPPluginPermissions.ReturnStaticAsync(LonelyBlueTradeSMPPluginPermissions.class, craftLegendsCorePermissions -> {
            if(!craftLegendsCorePermissions.DoesPlayerHavePermission(Permissions.ResetConfigs, player, true)) return;
            LonelyBlueTradeSMPPluginAPI.LonelyBlueTradeSMPPluginResetConfigs();
            smartInventory.open(player);
        }, Throwable::printStackTrace);
    }
}
