package com.github.mnesikos.orchard.data;

import com.github.mnesikos.orchard.Orchard;
import com.github.mnesikos.orchard.block.OrchardBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class FruitsTags {
    public static class FruitsBlockTags extends BlockTagsProvider {
        public static final TagKey<Block> SPRING_CROPS = BlockTags.create(ResourceLocation.parse("sereneseasons:spring_crops"));
        public static final TagKey<Block> SUMMER_CROPS = BlockTags.create(ResourceLocation.parse("sereneseasons:summer_crops"));
        public static final TagKey<Block> AUTUMN_CROPS = BlockTags.create(ResourceLocation.parse("sereneseasons:autumn_crops"));
        public static final TagKey<Block> WINTER_CROPS = BlockTags.create(ResourceLocation.parse("sereneseasons:winter_crops"));
        public static final TagKey<Block> YEAR_ROUND_CROPS = BlockTags.create(ResourceLocation.parse("sereneseasons:year_round_crops"));

        public FruitsBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, lookupProvider, Orchard.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            tag(SPRING_CROPS).add(
                    OrchardBlocks.CHERRY_BUD.get(),
                    OrchardBlocks.LEMON_BUD.get(),
                    OrchardBlocks.LYCHEE_BUD.get(),
//                    OrchardBlocks.PASSIONFRUIT_BUD.get(),
                    OrchardBlocks.CHERRY_SAPLING.get(),
                    OrchardBlocks.LEMON_SAPLING.get(),
                    OrchardBlocks.LYCHEE_SAPLING.get()
//                    OrchardBlocks.PASSIONFRUIT_SAPLING.get()
            );
            tag(SUMMER_CROPS).add(
                    OrchardBlocks.LEMON_BUD.get(),
                    OrchardBlocks.ORANGE_BUD.get(),
                    OrchardBlocks.PEACH_BUD.get(),
                    OrchardBlocks.MANGO_BUD.get(),
//                    OrchardBlocks.BANANA_BUD.get(),
                    OrchardBlocks.LEMON_SAPLING.get(),
                    OrchardBlocks.ORANGE_SAPLING.get(),
                    OrchardBlocks.PEACH_SAPLING.get(),
                    OrchardBlocks.MANGO_SAPLING.get()
//                    OrchardBlocks.BANANA_SAPLING.get(),
            );
            tag(AUTUMN_CROPS).add(
                    OrchardBlocks.RED_APPLE_BUD.get(),
                    OrchardBlocks.PLUM_BUD.get(),
                    OrchardBlocks.HAZELNUT_BUD.get(),
                    OrchardBlocks.PAWPAW_BUD.get(),
                    OrchardBlocks.CINNAMON_BUD.get(),
                    OrchardBlocks.RED_APPLE_SAPLING.get(),
                    OrchardBlocks.PLUM_SAPLING.get(),
                    OrchardBlocks.HAZELNUT_SAPLING.get(),
                    OrchardBlocks.PAWPAW_SAPLING.get(),
                    OrchardBlocks.CINNAMON_SAPLING.get()
            );
            tag(WINTER_CROPS).add(
                    OrchardBlocks.CINNAMON_BUD.get(),
//                    OrchardBlocks.DRAGONFRUIT_BUD.get(),
                    OrchardBlocks.CINNAMON_SAPLING.get()
//                    OrchardBlocks.DRAGONFRUIT_SAPLING.get()
            );
            tag(YEAR_ROUND_CROPS).add(
                    OrchardBlocks.STARFRUIT_BUD.get(),
                    OrchardBlocks.STARFRUIT_SAPLING.get()
            );
        }
    }


    public static class FruitsItemTags extends ItemTagsProvider {
        public static final TagKey<Item> SPRING_CROPS = ItemTags.create(ResourceLocation.parse("sereneseasons:spring_crops"));
        public static final TagKey<Item> SUMMER_CROPS = ItemTags.create(ResourceLocation.parse("sereneseasons:summer_crops"));
        public static final TagKey<Item> AUTUMN_CROPS = ItemTags.create(ResourceLocation.parse("sereneseasons:autumn_crops"));
        public static final TagKey<Item> WINTER_CROPS = ItemTags.create(ResourceLocation.parse("sereneseasons:winter_crops"));
        public static final TagKey<Item> YEAR_ROUND_CROPS = ItemTags.create(ResourceLocation.parse("sereneseasons:year_round_crops"));

        public FruitsItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, BlockTagsProvider blockTags, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, lookupProvider, blockTags.contentsGetter(), Orchard.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            copy(FruitsBlockTags.SPRING_CROPS, SPRING_CROPS);
            copy(FruitsBlockTags.SUMMER_CROPS, SUMMER_CROPS);
            copy(FruitsBlockTags.AUTUMN_CROPS, AUTUMN_CROPS);
            copy(FruitsBlockTags.WINTER_CROPS, WINTER_CROPS);
            copy(FruitsBlockTags.YEAR_ROUND_CROPS, YEAR_ROUND_CROPS);
        }
    }
}
