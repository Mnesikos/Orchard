package com.github.mnesikos.orchard.item;

import com.github.mnesikos.orchard.Orchard;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class OrchardItems {
    public static final DeferredRegister.Items REGISTRAR = DeferredRegister.createItems(Orchard.MOD_ID);
    public static final DeferredRegister.Items REGISTRAR_NO_TAB = DeferredRegister.createItems(Orchard.MOD_ID);

    public static final DeferredItem<Item> CHERRY = REGISTRAR.register("cherry", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.3F).build())));
    public static final DeferredItem<Item> CINNAMON = REGISTRAR.register("cinnamon", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> HAZELNUT = REGISTRAR.register("hazelnut", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> LEMON = REGISTRAR.register("lemon", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.1F).build())));
    public static final DeferredItem<Item> LYCHEE = REGISTRAR.register("lychee", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.1F).build())));
    public static final DeferredItem<Item> MANGO = REGISTRAR.register("mango", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.3F).build())));
    public static final DeferredItem<Item> ORANGE = REGISTRAR.register("orange", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.3F).build())));
    public static final DeferredItem<Item> PAWPAW = REGISTRAR.register("pawpaw", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.3F).build())));
    public static final DeferredItem<Item> PEACH = REGISTRAR.register("peach", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.3F).build())));
    public static final DeferredItem<Item> PLUM = REGISTRAR.register("plum", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.3F).build())));
    public static final DeferredItem<Item> STARFRUIT = REGISTRAR.register("starfruit", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.3F).build())));
}
