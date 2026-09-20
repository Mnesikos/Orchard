package com.github.mnesikos.orchard.data;

import com.github.mnesikos.orchard.Orchard;
import com.github.mnesikos.orchard.block.OrchardBlocks;
import com.github.mnesikos.orchard.item.OrchardItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.concurrent.CompletableFuture;

public class OrchardRecipes extends RecipeProvider {
    public OrchardRecipes(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(pOutput, lookupProvider);
    }

    @Override
    protected void buildRecipes(RecipeOutput consumer) {
        crateRecipes(consumer, OrchardItems.CHERRY.get(), OrchardBlocks.CHERRY_CRATE.get());
        crateRecipes(consumer, OrchardItems.CINNAMON.get(), OrchardBlocks.CINNAMON_CRATE.get());
        crateRecipes(consumer, OrchardItems.HAZELNUT.get(), OrchardBlocks.HAZELNUT_CRATE.get());
        crateRecipes(consumer, OrchardItems.LEMON.get(), OrchardBlocks.LEMON_CRATE.get());
        crateRecipes(consumer, OrchardItems.LYCHEE.get(), OrchardBlocks.LYCHEE_CRATE.get());
        crateRecipes(consumer, OrchardItems.MANGO.get(), OrchardBlocks.MANGO_CRATE.get());
        crateRecipes(consumer, OrchardItems.ORANGE.get(), OrchardBlocks.ORANGE_CRATE.get());
        crateRecipes(consumer, OrchardItems.PAWPAW.get(), OrchardBlocks.PAWPAW_CRATE.get());
        crateRecipes(consumer, OrchardItems.PEACH.get(), OrchardBlocks.PEACH_CRATE.get());
        crateRecipes(consumer, OrchardItems.PLUM.get(), OrchardBlocks.PLUM_CRATE.get());
        crateRecipes(consumer, Items.APPLE, OrchardBlocks.RED_APPLE_CRATE.get());
        crateRecipes(consumer, OrchardItems.STARFRUIT.get(), OrchardBlocks.STARFRUIT_CRATE.get());

        saplingsFromFruit(consumer, OrchardBlocks.CHERRY_SAPLING.get(), OrchardItems.CHERRY.get());
        saplingsFromFruit(consumer, OrchardBlocks.CINNAMON_SAPLING.get(), OrchardItems.CINNAMON.get());
        saplingsFromFruit(consumer, OrchardBlocks.HAZELNUT_SAPLING.get(), OrchardItems.HAZELNUT.get());
        saplingsFromFruit(consumer, OrchardBlocks.LEMON_SAPLING.get(), OrchardItems.LEMON.get());
        saplingsFromFruit(consumer, OrchardBlocks.LYCHEE_SAPLING.get(), OrchardItems.LYCHEE.get());
        saplingsFromFruit(consumer, OrchardBlocks.MANGO_SAPLING.get(), OrchardItems.MANGO.get());
        saplingsFromFruit(consumer, OrchardBlocks.ORANGE_SAPLING.get(), OrchardItems.ORANGE.get());
        saplingsFromFruit(consumer, OrchardBlocks.PAWPAW_SAPLING.get(), OrchardItems.PAWPAW.get());
        saplingsFromFruit(consumer, OrchardBlocks.PEACH_SAPLING.get(), OrchardItems.PEACH.get());
        saplingsFromFruit(consumer, OrchardBlocks.PLUM_SAPLING.get(), OrchardItems.PLUM.get());
        saplingsFromFruit(consumer, OrchardBlocks.RED_APPLE_SAPLING.get(), Items.APPLE);
        saplingsFromFruit(consumer, OrchardBlocks.STARFRUIT_SAPLING.get(), OrchardItems.STARFRUIT.get());
    }

    protected static void crateRecipes(RecipeOutput consumer, ItemLike unpacked, ItemLike packed) {
        nineBlockStorageRecipes(consumer, RecipeCategory.MISC, unpacked, RecipeCategory.BUILDING_BLOCKS, packed, getSimpleModdedRecipeName(packed), null, getSimpleModdedRecipeName(unpacked), null);
    }

    protected static void saplingsFromFruit(RecipeOutput consumer, ItemLike sapling, ItemLike fruit) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, sapling).requires(fruit, 4).unlockedBy(getHasName(fruit), has(fruit)).save(consumer);
    }

    protected static String getSimpleModdedRecipeName(ItemLike itemLike) {
        return Orchard.MOD_ID + ":" + getSimpleRecipeName(itemLike);
    }
}
