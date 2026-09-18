package com.github.mnesikos.orchard.item;

import com.github.mnesikos.orchard.Orchard;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class OrchardItems {
    public static final DeferredRegister<Item> REGISTRAR = DeferredRegister.create(ForgeRegistries.ITEMS, Orchard.MOD_ID);
    public static final DeferredRegister<Item> REGISTRAR_NO_TAB = DeferredRegister.create(ForgeRegistries.ITEMS, Orchard.MOD_ID);

    public static final RegistryObject<Item> CHERRY = REGISTRAR.register("cherry", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0.3F).build())));
    public static final RegistryObject<Item> CINNAMON = REGISTRAR.register("cinnamon", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> HAZELNUT = REGISTRAR.register("hazelnut", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LEMON = REGISTRAR.register("lemon", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build())));
    public static final RegistryObject<Item> LYCHEE = REGISTRAR.register("lychee", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build())));
    public static final RegistryObject<Item> MANGO = REGISTRAR.register("mango", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0.3F).build())));
    public static final RegistryObject<Item> ORANGE = REGISTRAR.register("orange", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0.3F).build())));
    public static final RegistryObject<Item> PAWPAW = REGISTRAR.register("pawpaw", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0.3F).build())));
    public static final RegistryObject<Item> PEACH = REGISTRAR.register("peach", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationMod(0.3F).build())));
    public static final RegistryObject<Item> PLUM = REGISTRAR.register("plum", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0.3F).build())));
    public static final RegistryObject<Item> STARFRUIT = REGISTRAR.register("starfruit", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0.3F).build())));
}
