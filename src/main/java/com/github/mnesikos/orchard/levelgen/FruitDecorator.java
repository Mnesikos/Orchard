package com.github.mnesikos.orchard.levelgen;

import com.github.mnesikos.orchard.Orchard;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashSet;
import java.util.Set;

public class FruitDecorator extends TreeDecorator {
    public static final DeferredRegister<TreeDecoratorType<?>> REGISTRAR = DeferredRegister.create(Registries.TREE_DECORATOR_TYPE, Orchard.MOD_ID);
    public static final DeferredHolder<TreeDecoratorType<?>, TreeDecoratorType<FruitDecorator>> FRUIT_DECORATOR = REGISTRAR.register("fruit", () -> new TreeDecoratorType<>(FruitDecorator.CODEC));
    public static final MapCodec<FruitDecorator> CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(
            BlockStateProvider.CODEC.fieldOf("block_provider").forGetter((decorator) -> decorator.blockProvider),
            IntProvider.codec(0, 16).fieldOf("fruit_count").forGetter((decorator) -> decorator.fruitCount)
    ).apply(instance, FruitDecorator::new));
    protected final BlockStateProvider blockProvider;
    protected final IntProvider fruitCount;

    public FruitDecorator(BlockStateProvider blockProvider, IntProvider fruitCount) {
        this.blockProvider = blockProvider;
        this.fruitCount = fruitCount;
    }

    @Override
    protected TreeDecoratorType<?> type() {
        return FruitDecorator.FRUIT_DECORATOR.get();
    }

    @Override
    public void place(Context context) {
        Set<BlockPos> set = new HashSet<>();
        RandomSource random = context.random();
        int fruits = random.nextInt(fruitCount.getMinValue(), fruitCount.getMaxValue());

        for (BlockPos blockPos : Util.shuffledCopy(context.leaves(), random)) {
            BlockPos blockPos1 = blockPos.relative(Direction.DOWN);
            if (fruits <= 0) break;
            if (!set.contains(blockPos1) && context.isAir(blockPos1)) {
                set.add(blockPos1.immutable());
                context.setBlock(blockPos1, blockProvider.getState(random, blockPos1));
                fruits--;
            }
        }
    }
}
