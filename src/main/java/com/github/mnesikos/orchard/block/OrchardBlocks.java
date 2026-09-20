package com.github.mnesikos.orchard.block;

import com.github.mnesikos.orchard.Orchard;
import com.github.mnesikos.orchard.block.grower.OrchardTreeGrower;
import com.github.mnesikos.orchard.item.OrchardItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class OrchardBlocks {
    public static final DeferredRegister.Blocks REGISTRAR = DeferredRegister.createBlocks(Orchard.MOD_ID);

    public static final DeferredBlock<Block> CHERRY_SAPLING = registerWithItem("cherry_sapling", () -> new SaplingBlock(OrchardTreeGrower.CHERRY, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> CINNAMON_SAPLING = registerWithItem("cinnamon_sapling", () -> new SaplingBlock(OrchardTreeGrower.CINNAMON, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> HAZELNUT_SAPLING = registerWithItem("hazelnut_sapling", () -> new SaplingBlock(OrchardTreeGrower.HAZELNUT, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> LEMON_SAPLING = registerWithItem("lemon_sapling", () -> new SaplingBlock(OrchardTreeGrower.LEMON, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> LYCHEE_SAPLING = registerWithItem("lychee_sapling", () -> new SaplingBlock(OrchardTreeGrower.LYCHEE, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> MANGO_SAPLING = registerWithItem("mango_sapling", () -> new SaplingBlock(OrchardTreeGrower.MANGO, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> ORANGE_SAPLING = registerWithItem("orange_sapling", () -> new SaplingBlock(OrchardTreeGrower.ORANGE, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> PAWPAW_SAPLING = registerWithItem("pawpaw_sapling", () -> new SaplingBlock(OrchardTreeGrower.PAWPAW, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> PEACH_SAPLING = registerWithItem("peach_sapling", () -> new SaplingBlock(OrchardTreeGrower.PEACH, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> PLUM_SAPLING = registerWithItem("plum_sapling", () -> new SaplingBlock(OrchardTreeGrower.PLUM, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> RED_APPLE_SAPLING = registerWithItem("red_apple_sapling", () -> new SaplingBlock(OrchardTreeGrower.RED_APPLE, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> STARFRUIT_SAPLING = registerWithItem("starfruit_sapling", () -> new SaplingBlock(OrchardTreeGrower.STARFRUIT, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));

    public static final DeferredBlock<FruitBlock> CHERRY_BUD = registerFruitNode("cherry_bud", OrchardItems.CHERRY);
    public static final DeferredBlock<FruitBlock> CINNAMON_BUD = registerFruitNode("cinnamon_bud", OrchardItems.CINNAMON);
    public static final DeferredBlock<FruitBlock> HAZELNUT_BUD = registerFruitNode("hazelnut_bud", OrchardItems.HAZELNUT);
    public static final DeferredBlock<FruitBlock> LEMON_BUD = registerFruitNode("lemon_bud", OrchardItems.LEMON);
    public static final DeferredBlock<FruitBlock> LYCHEE_BUD = registerFruitNode("lychee_bud", OrchardItems.LYCHEE);
    public static final DeferredBlock<FruitBlock> MANGO_BUD = registerFruitNode("mango_bud", OrchardItems.MANGO);
    public static final DeferredBlock<FruitBlock> ORANGE_BUD = registerFruitNode("orange_bud", OrchardItems.ORANGE);
    public static final DeferredBlock<FruitBlock> PAWPAW_BUD = registerFruitNode("pawpaw_bud", OrchardItems.PAWPAW);
    public static final DeferredBlock<FruitBlock> PEACH_BUD = registerFruitNode("peach_bud", OrchardItems.PEACH);
    public static final DeferredBlock<FruitBlock> PLUM_BUD = registerFruitNode("plum_bud", OrchardItems.PLUM);
    public static final DeferredBlock<FruitBlock> RED_APPLE_BUD = registerFruitNode("red_apple_bud", () -> Items.APPLE);
    public static final DeferredBlock<FruitBlock> STARFRUIT_BUD = registerFruitNode("starfruit_bud", OrchardItems.STARFRUIT);

    public static final DeferredBlock<Block> CHERRY_CRATE = registerWithItem("cherry_crate", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BANJO).strength(1.5F).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> CINNAMON_CRATE = registerWithItem("cinnamon_crate", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BANJO).strength(1.5F).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> HAZELNUT_CRATE = registerWithItem("hazelnut_crate", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BANJO).strength(1.5F).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> LEMON_CRATE = registerWithItem("lemon_crate", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BANJO).strength(1.5F).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> LYCHEE_CRATE = registerWithItem("lychee_crate", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BANJO).strength(1.5F).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> MANGO_CRATE = registerWithItem("mango_crate", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BANJO).strength(1.5F).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> ORANGE_CRATE = registerWithItem("orange_crate", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BANJO).strength(1.5F).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> PAWPAW_CRATE = registerWithItem("pawpaw_crate", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).instrument(NoteBlockInstrument.BANJO).strength(1.5F).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> PEACH_CRATE = registerWithItem("peach_crate", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).instrument(NoteBlockInstrument.BANJO).strength(1.5F).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> PLUM_CRATE = registerWithItem("plum_crate", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).instrument(NoteBlockInstrument.BANJO).strength(1.5F).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> RED_APPLE_CRATE = registerWithItem("red_apple_crate", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BANJO).strength(1.5F).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> STARFRUIT_CRATE = registerWithItem("starfruit_crate", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BANJO).strength(1.5F).sound(SoundType.WOOD)));

    private static <T extends Block> DeferredBlock<T> registerWithItem(String name, Supplier<T> block) {
        DeferredBlock<T> registryObject = REGISTRAR.register(name, block);
        OrchardItems.REGISTRAR.register(name, () -> new BlockItem(registryObject.get(), new Item.Properties()));
        return registryObject;
    }

    private static DeferredBlock<FruitBlock> registerFruitNode(String name, Supplier<? extends Item> fruit) {
        DeferredBlock<FruitBlock> registryObject = REGISTRAR.register(name, () -> new FruitBlock(fruit, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
        OrchardItems.REGISTRAR_NO_TAB.register(name + "_bud", () -> new BlockItem(registryObject.get(), new Item.Properties()));
        return registryObject;
    }
}
