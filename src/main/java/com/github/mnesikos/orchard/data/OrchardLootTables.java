package com.github.mnesikos.orchard.data;

import com.github.mnesikos.orchard.Orchard;
import com.github.mnesikos.orchard.block.FruitBlock;
import com.github.mnesikos.orchard.block.OrchardBlocks;
import com.github.mnesikos.orchard.item.OrchardItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class OrchardLootTables extends BlockLootSubProvider {
    public OrchardLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropFruit(OrchardBlocks.CHERRY_BUD.get(), OrchardItems.CHERRY.get());
        dropFruit(OrchardBlocks.CINNAMON_BUD.get(), OrchardItems.CINNAMON.get());
        dropFruit(OrchardBlocks.HAZELNUT_BUD.get(), OrchardItems.HAZELNUT.get());
        dropFruit(OrchardBlocks.LEMON_BUD.get(), OrchardItems.LEMON.get());
        dropFruit(OrchardBlocks.LYCHEE_BUD.get(), OrchardItems.LYCHEE.get());
        dropFruit(OrchardBlocks.MANGO_BUD.get(), OrchardItems.MANGO.get());
        dropFruit(OrchardBlocks.ORANGE_BUD.get(), OrchardItems.ORANGE.get());
        dropFruit(OrchardBlocks.PAWPAW_BUD.get(), OrchardItems.PAWPAW.get());
        dropFruit(OrchardBlocks.PEACH_BUD.get(), OrchardItems.PEACH.get());
        dropFruit(OrchardBlocks.PLUM_BUD.get(), OrchardItems.PLUM.get());
        dropFruit(OrchardBlocks.RED_APPLE_BUD.get(), Items.APPLE);
        dropFruit(OrchardBlocks.STARFRUIT_BUD.get(), OrchardItems.STARFRUIT.get());

        dropSelf(OrchardBlocks.CHERRY_SAPLING.get());
        dropSelf(OrchardBlocks.CINNAMON_SAPLING.get());
        dropSelf(OrchardBlocks.HAZELNUT_SAPLING.get());
        dropSelf(OrchardBlocks.LEMON_SAPLING.get());
        dropSelf(OrchardBlocks.LYCHEE_SAPLING.get());
        dropSelf(OrchardBlocks.MANGO_SAPLING.get());
        dropSelf(OrchardBlocks.ORANGE_SAPLING.get());
        dropSelf(OrchardBlocks.PAWPAW_SAPLING.get());
        dropSelf(OrchardBlocks.PEACH_SAPLING.get());
        dropSelf(OrchardBlocks.PLUM_SAPLING.get());
        dropSelf(OrchardBlocks.RED_APPLE_SAPLING.get());
        dropSelf(OrchardBlocks.STARFRUIT_SAPLING.get());

        dropSelf(OrchardBlocks.CHERRY_CRATE.get());
        dropSelf(OrchardBlocks.CINNAMON_CRATE.get());
        dropSelf(OrchardBlocks.HAZELNUT_CRATE.get());
        dropSelf(OrchardBlocks.LEMON_CRATE.get());
        dropSelf(OrchardBlocks.LYCHEE_CRATE.get());
        dropSelf(OrchardBlocks.MANGO_CRATE.get());
        dropSelf(OrchardBlocks.ORANGE_CRATE.get());
        dropSelf(OrchardBlocks.PAWPAW_CRATE.get());
        dropSelf(OrchardBlocks.PEACH_CRATE.get());
        dropSelf(OrchardBlocks.PLUM_CRATE.get());
        dropSelf(OrchardBlocks.RED_APPLE_CRATE.get());
        dropSelf(OrchardBlocks.STARFRUIT_CRATE.get());
    }

    protected void dropFruit(Block fruitBlock, Item fruitItem) {
        LootItemCondition.Builder maxFruitBlockAge = LootItemBlockStatePropertyCondition.hasBlockStateProperties(fruitBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(FruitBlock.AGE, 3));
        add(fruitBlock, applyExplosionDecay(fruitBlock, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .when(maxFruitBlockAge)
                        .add(LootItem.lootTableItem(fruitItem))
                ).withPool(LootPool.lootPool()
                        .when(HAS_SHEARS.or(HAS_SILK_TOUCH))
                        .add(LootItem.lootTableItem(fruitBlock.asItem()))
                )
        ));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ForgeRegistries.BLOCKS.getEntries().stream()
                .filter(e -> e.getKey().location().getNamespace().equals(Orchard.MOD_ID))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}
