package com.github.mnesikos.orchard.data;

import com.github.mnesikos.orchard.Orchard;
import com.github.mnesikos.orchard.block.FruitBlock;
import com.github.mnesikos.orchard.block.OrchardBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.ModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.function.Function;

public class OrchardBlockStates extends BlockStateProvider {
    public OrchardBlockStates(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Orchard.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        fruitBlock(OrchardBlocks.CHERRY_BUD.get());
        fruitBlock(OrchardBlocks.HAZELNUT_BUD.get());
        fruitBlock(OrchardBlocks.LEMON_BUD.get());
        fruitBlock(OrchardBlocks.MANGO_BUD.get());
        fruitBlock(OrchardBlocks.ORANGE_BUD.get());
        fruitBlock(OrchardBlocks.PAWPAW_BUD.get());
        fruitBlock(OrchardBlocks.PEACH_BUD.get());
        fruitBlock(OrchardBlocks.PLUM_BUD.get());
        fruitBlock(OrchardBlocks.RED_APPLE_BUD.get());

        saplingBlock(OrchardBlocks.CHERRY_SAPLING.get());
        saplingBlock(OrchardBlocks.CINNAMON_SAPLING.get());
        saplingBlock(OrchardBlocks.HAZELNUT_SAPLING.get());
        saplingBlock(OrchardBlocks.LEMON_SAPLING.get());
        saplingBlock(OrchardBlocks.LYCHEE_SAPLING.get());
        saplingBlock(OrchardBlocks.MANGO_SAPLING.get());
        saplingBlock(OrchardBlocks.ORANGE_SAPLING.get());
        saplingBlock(OrchardBlocks.PAWPAW_SAPLING.get());
        saplingBlock(OrchardBlocks.PEACH_SAPLING.get());
        saplingBlock(OrchardBlocks.PLUM_SAPLING.get());
        saplingBlock(OrchardBlocks.RED_APPLE_SAPLING.get());
        saplingBlock(OrchardBlocks.STARFRUIT_SAPLING.get());

        crateBlock(OrchardBlocks.CHERRY_CRATE.get());
        crateBlock(OrchardBlocks.CINNAMON_CRATE.get());
        crateBlock(OrchardBlocks.HAZELNUT_CRATE.get());
        crateBlock(OrchardBlocks.LEMON_CRATE.get());
        crateBlock(OrchardBlocks.LYCHEE_CRATE.get());
        crateBlock(OrchardBlocks.MANGO_CRATE.get());
        crateBlock(OrchardBlocks.ORANGE_CRATE.get());
        crateBlock(OrchardBlocks.PAWPAW_CRATE.get());
        crateBlock(OrchardBlocks.PEACH_CRATE.get());
        crateBlock(OrchardBlocks.PLUM_CRATE.get());
        crateBlock(OrchardBlocks.RED_APPLE_CRATE.get());
        crateBlock(OrchardBlocks.STARFRUIT_CRATE.get());
    }

    public void fruitBlock(FruitBlock block) {
        String name = BuiltInRegistries.BLOCK.getKey(block).getPath();
        itemModels().getBuilder(name + "_bud").parent(models().getExistingFile(ResourceLocation.fromNamespaceAndPath(Orchard.MOD_ID, name + "_3")));
        Function<BlockState, ModelFile> modelFunc = (state ->
                models().getExistingFile(ResourceLocation.fromNamespaceAndPath(Orchard.MOD_ID, name + "_" + state.getValue(FruitBlock.AGE)))
        );
        getVariantBuilder(block)
                .forAllStates(state -> ConfiguredModel.builder()
                        .modelFile(modelFunc.apply(state))
                        .nextModel().modelFile(modelFunc.apply(state)).rotationY(90)
                        .nextModel().modelFile(modelFunc.apply(state)).rotationY(180)
                        .nextModel().modelFile(modelFunc.apply(state)).rotationY(270)
                        .build()
                );
    }

    public void saplingBlock(Block block) {
        String name = BuiltInRegistries.BLOCK.getKey(block).getPath();
        ResourceLocation texture = modLoc(ModelProvider.BLOCK_FOLDER + "/" + name);
        itemModels().getBuilder(name).parent(new ModelFile.UncheckedModelFile("item/generated")).texture("layer0", texture);
        simpleBlock(block, models().cross(name, texture).renderType("cutout"));
    }

    public void crateBlock(Block block) {
        simpleBlockWithItem(block, models().cubeBottomTop(BuiltInRegistries.BLOCK.getKey(block).getPath(),
                ResourceLocation.fromNamespaceAndPath(Orchard.MOD_ID, ModelProvider.BLOCK_FOLDER + "/crate_side"),
                ResourceLocation.fromNamespaceAndPath(Orchard.MOD_ID, ModelProvider.BLOCK_FOLDER + "/crate_bottom"),
                blockTexture(block)
        ));
    }
}
