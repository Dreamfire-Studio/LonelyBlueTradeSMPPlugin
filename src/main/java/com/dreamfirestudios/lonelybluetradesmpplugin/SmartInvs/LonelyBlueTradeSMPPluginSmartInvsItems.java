package com.dreamfirestudios.lonelybluetradesmpplugin.SmartInvs;

import com.dreamfirestudios.dreamCore.DreamfireSmartInvs.ClickableItem;
import com.dreamfirestudios.lonelybluetradesmpplugin.Enum.InventoryItems;
import com.dreamfirestudios.lonelybluetradesmpplugin.PulseConfig.LonelyBlueTradeSMPPluginInventoryItems;
import com.dreamfirestudios.lonelybluetradesmpplugin.PulseConfig.LonelyBlueTradeSMPPluginSerilizableItems;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

public class LonelyBlueTradeSMPPluginSmartInvsItems {
    public static void SerializedItem(Player player, String itemID, Function<ItemStack, ItemStack> testFunction, Consumer<ClickableItem> clickableItemConsumer, BiConsumer<Player, InventoryClickEvent> inventoryClickEventConsumer) {
        LonelyBlueTradeSMPPluginSerilizableItems.ReturnStaticAsync(LonelyBlueTradeSMPPluginSerilizableItems.class, craftLegendsCoreSerilizableItems -> {
            var itemStack = testFunction.apply(craftLegendsCoreSerilizableItems.GetItemStack(itemID).clone());
            clickableItemConsumer.accept(ClickableItem.of(itemStack, event -> inventoryClickEventConsumer.accept(player, event)));
        }, Throwable::printStackTrace);
    }

    public static void InventoryItemWithFeedback(Player player, InventoryItems inventoryItems, Function<ItemStack, ItemStack> testFunction, Consumer<ClickableItem> clickableItemConsumer, BiConsumer<Player, InventoryClickEvent> inventoryClickEventConsumer) {
        LonelyBlueTradeSMPPluginInventoryItems.ReturnStaticAsync(LonelyBlueTradeSMPPluginInventoryItems.class, craftLegendsCoreInventoryItems -> {
            var itemStack = testFunction.apply(craftLegendsCoreInventoryItems.GetValue(inventoryItems).clone());
            clickableItemConsumer.accept(ClickableItem.of(itemStack, event -> inventoryClickEventConsumer.accept(player, event)));
        }, Throwable::printStackTrace);
    }

    public static void InventoryItem(Player player, InventoryItems inventoryItems, Consumer<ClickableItem> clickableItemConsumer, BiConsumer<Player, InventoryClickEvent> inventoryClickEventConsumer) {
        LonelyBlueTradeSMPPluginInventoryItems.ReturnStaticAsync(LonelyBlueTradeSMPPluginInventoryItems.class, craftLegendsCoreInventoryItems -> {
            var itemStack = craftLegendsCoreInventoryItems.GetValue(inventoryItems).clone();
            clickableItemConsumer.accept(ClickableItem.of(itemStack, event -> inventoryClickEventConsumer.accept(player, event)));
        }, Throwable::printStackTrace);
    }

    public static void SystemEnabled(Player player, boolean isEnabled, Consumer<ClickableItem> clickableItemConsumer, BiConsumer<Player, InventoryClickEvent> inventoryClickEventConsumer){
        LonelyBlueTradeSMPPluginInventoryItems.ReturnStaticAsync(LonelyBlueTradeSMPPluginInventoryItems.class, craftLegendsCoreInventoryItems -> {
            var itemStack = craftLegendsCoreInventoryItems.GetValue(InventoryItems.SystemEnabled).clone();
            clickableItemConsumer.accept(ClickableItem.of(itemStack, event -> inventoryClickEventConsumer.accept(player, event)));
        }, Throwable::printStackTrace);
    }
}
