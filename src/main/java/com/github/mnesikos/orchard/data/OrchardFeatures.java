package com.github.mnesikos.orchard.data;

import com.github.mnesikos.orchard.Orchard;
import com.github.mnesikos.orchard.block.FruitBlock;
import com.github.mnesikos.orchard.block.OrchardBlocks;
import com.github.mnesikos.orchard.levelgen.FruitDecorator;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.PineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;

import java.util.List;
import java.util.OptionalInt;

public class OrchardFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> CHERRY = createKey("cherry");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CINNAMON = createKey("cinnamon");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HAZELNUT = createKey("hazelnut");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LEMON = createKey("lemon");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LYCHEE = createKey("lychee");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MANGO = createKey("mango");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE = createKey("orange");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PAWPAW = createKey("pawpaw");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PEACH = createKey("peach");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PLUM = createKey("plum");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_APPLE = createKey("red_apple");
    public static final ResourceKey<ConfiguredFeature<?, ?>> STARFRUIT = createKey("starfruit");

    private static TreeConfiguration.TreeConfigurationBuilder createFruitTree(Block logs, Block leaves, FruitBlock fruit, TrunkPlacer trunkPlacer, FoliagePlacer foliagePlacer, int limit, int lowerSize, int upperSize, OptionalInt minClippedHeight) {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(logs), trunkPlacer, BlockStateProvider.simple(leaves), foliagePlacer, new TwoLayersFeatureSize(limit, lowerSize, upperSize, minClippedHeight))
                .ignoreVines().decorators(List.of(new FruitDecorator(BlockStateProvider.simple(fruit), UniformInt.of(4, 6))));
    }

    //     Average dark oak log, small round dark oak leaves
    private static TreeConfiguration.TreeConfigurationBuilder createCherry() {
        return createFruitTree(
                Blocks.DARK_OAK_LOG, Blocks.DARK_OAK_LEAVES, OrchardBlocks.CHERRY_BUD.get(),
                new StraightTrunkPlacer(5, 2, 0),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                1, 0, 1, OptionalInt.empty()
        );
    }

    //     Average custom log, compact round mangrove leaves (or custom bamboo type, a little bushier at the top) TODO
    private static TreeConfiguration.TreeConfigurationBuilder createCinnamon() {
        return createFruitTree(
                Blocks.OAK_LOG, Blocks.MANGROVE_LEAVES, OrchardBlocks.CINNAMON_BUD.get(),
                new StraightTrunkPlacer(4, 2, 0),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                1, 0, 1, OptionalInt.empty()
        );
    }

    //     Short jungle log, small round oak leaves
    private static TreeConfiguration.TreeConfigurationBuilder createHazelnut() {
        return createFruitTree(
                Blocks.JUNGLE_LOG, Blocks.OAK_LEAVES, OrchardBlocks.HAZELNUT_BUD.get(),
                new StraightTrunkPlacer(5, 1, 0),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                1, 0, 1, OptionalInt.empty()
        );
    }

    //    Tall oak log, compact flat acacia leaves
    private static TreeConfiguration.TreeConfigurationBuilder createLemon() {
        return createFruitTree(
                Blocks.OAK_LOG, Blocks.ACACIA_LEAVES, OrchardBlocks.LEMON_BUD.get(),
                new StraightTrunkPlacer(5, 2, 1),
                new AcaciaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)),
                0, 0, 0, OptionalInt.of(4)
        );
    }

    //    Tall dark oak log, big round mangrove leaves
    private static TreeConfiguration.TreeConfigurationBuilder createLychee() {
        return createFruitTree(
                Blocks.DARK_OAK_LOG, Blocks.MANGROVE_LEAVES, OrchardBlocks.LYCHEE_BUD.get(),
                new StraightTrunkPlacer(6, 1, 1),
                new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), 3),
                1, 0, 1, OptionalInt.empty()
        );
    }

    //    Tall acacia log, wide flat acacia leaves
    private static TreeConfiguration.TreeConfigurationBuilder createMango() {
        return createFruitTree(
                Blocks.ACACIA_LOG, Blocks.ACACIA_LEAVES, OrchardBlocks.MANGO_BUD.get(),
                new StraightTrunkPlacer(5, 2, 1),
                new AcaciaFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0)),
                1, 0, 2, OptionalInt.of(4)
        );
    }

    //    Tall oak log, big round oak leaves
    private static TreeConfiguration.TreeConfigurationBuilder createOrange() {
        return createFruitTree(
                Blocks.OAK_LOG, Blocks.OAK_LEAVES, OrchardBlocks.ORANGE_BUD.get(),
                new StraightTrunkPlacer(6, 1, 1),
                new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), 3),
                0, 0, 0, OptionalInt.of(4)
        );
    }

    //    Short acacia log, pine shaped mangrove leaves
    private static TreeConfiguration.TreeConfigurationBuilder createPawpaw() {
        return createFruitTree(
                Blocks.ACACIA_LOG, Blocks.MANGROVE_LEAVES, OrchardBlocks.PAWPAW_BUD.get(),
                new StraightTrunkPlacer(5, 1, 0),
                new PineFoliagePlacer(ConstantInt.of(1), ConstantInt.of(1), ConstantInt.of(4)),
                1, 0, 1, OptionalInt.empty()
        );
    }

    //    Short dark oak log, small round dark oak leaves
    private static TreeConfiguration.TreeConfigurationBuilder createPeach() {
        return createFruitTree(
                Blocks.DARK_OAK_LOG, Blocks.DARK_OAK_LEAVES, OrchardBlocks.PEACH_BUD.get(),
                new StraightTrunkPlacer(5, 1, 0),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                1, 0, 1, OptionalInt.empty()
        );
    }

    //    Short oak log, big round oak leaves
    private static TreeConfiguration.TreeConfigurationBuilder createPlum() {
        return createFruitTree(
                Blocks.OAK_LOG, Blocks.OAK_LEAVES, OrchardBlocks.PLUM_BUD.get(),
                new StraightTrunkPlacer(5, 1, 0),
                new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), 3),
                1, 0, 1, OptionalInt.empty()
        );
    }

    //    Tall oak log, big round oak leaves
    private static TreeConfiguration.TreeConfigurationBuilder createRedApple() {
        return createFruitTree(
                Blocks.OAK_LOG, Blocks.OAK_LEAVES, OrchardBlocks.RED_APPLE_BUD.get(),
                new StraightTrunkPlacer(6, 1, 1),
                new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), 3),
                0, 0, 0, OptionalInt.of(4)
        );
    }

    //    Tall acacia log, wide flat birch leaves
    private static TreeConfiguration.TreeConfigurationBuilder createStarfruit() {
        return createFruitTree(
                Blocks.ACACIA_LOG, Blocks.BIRCH_LEAVES, OrchardBlocks.STARFRUIT_BUD.get(),
                new StraightTrunkPlacer(5, 2, 1),
                new AcaciaFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0)),
                1, 0, 1, OptionalInt.empty()
        );
    }

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        register(context, RED_APPLE, Feature.TREE, createRedApple().build());
        register(context, CHERRY, Feature.TREE, createCherry().build());
        register(context, LEMON, Feature.TREE, createLemon().build());
        register(context, ORANGE, Feature.TREE, createOrange().build());
        register(context, PEACH, Feature.TREE, createPeach().build());
        register(context, PLUM, Feature.TREE, createPlum().build());
        register(context, HAZELNUT, Feature.TREE, createHazelnut().build());
        register(context, PAWPAW, Feature.TREE, createPawpaw().build());
        register(context, CINNAMON, Feature.TREE, createCinnamon().build());
        register(context, MANGO, Feature.TREE, createMango().build());
        register(context, STARFRUIT, Feature.TREE, createStarfruit().build());
        register(context, LYCHEE, Feature.TREE, createLychee().build());
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Orchard.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuredFeature) {
        context.register(key, new ConfiguredFeature<>(feature, configuredFeature));
    }
}
