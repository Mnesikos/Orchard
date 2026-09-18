package com.github.mnesikos.orchard.block;

import com.github.mnesikos.orchard.Orchard;
import com.github.mnesikos.orchard.block.grower.*;
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
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class OrchardBlocks {
    public static final DeferredRegister<Block> REGISTRAR = DeferredRegister.create(ForgeRegistries.BLOCKS, Orchard.MOD_ID);

    public static final RegistryObject<Block> CHERRY_SAPLING = registerWithItem("cherry_sapling", () -> new SaplingBlock(new CherryTreeGrower(), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> CINNAMON_SAPLING = registerWithItem("cinnamon_sapling", () -> new SaplingBlock(new CinnamonTreeGrower(), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> HAZELNUT_SAPLING = registerWithItem("hazelnut_sapling", () -> new SaplingBlock(new HazelnutTreeGrower(), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> LEMON_SAPLING = registerWithItem("lemon_sapling", () -> new SaplingBlock(new LemonTreeGrower(), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> LYCHEE_SAPLING = registerWithItem("lychee_sapling", () -> new SaplingBlock(new LycheeTreeGrower(), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> MANGO_SAPLING = registerWithItem("mango_sapling", () -> new SaplingBlock(new MangoTreeGrower(), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ORANGE_SAPLING = registerWithItem("orange_sapling", () -> new SaplingBlock(new OrangeTreeGrower(), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> PAWPAW_SAPLING = registerWithItem("pawpaw_sapling", () -> new SaplingBlock(new PawpawTreeGrower(), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> PEACH_SAPLING = registerWithItem("peach_sapling", () -> new SaplingBlock(new PeachTreeGrower(), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> PLUM_SAPLING = registerWithItem("plum_sapling", () -> new SaplingBlock(new PlumTreeGrower(), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> RED_APPLE_SAPLING = registerWithItem("red_apple_sapling", () -> new SaplingBlock(new RedAppleTreeGrower(), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> STARFRUIT_SAPLING = registerWithItem("starfruit_sapling", () -> new SaplingBlock(new StarfruitTreeGrower(), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<FruitBlock> CHERRY_BUD = registerFruitNode("cherry_bud", OrchardItems.CHERRY);
    public static final RegistryObject<FruitBlock> CINNAMON_BUD = registerFruitNode("cinnamon_bud", OrchardItems.CINNAMON);
    public static final RegistryObject<FruitBlock> HAZELNUT_BUD = registerFruitNode("hazelnut_bud", OrchardItems.HAZELNUT);
    public static final RegistryObject<FruitBlock> LEMON_BUD = registerFruitNode("lemon_bud", OrchardItems.LEMON);
    public static final RegistryObject<FruitBlock> LYCHEE_BUD = registerFruitNode("lychee_bud", OrchardItems.LYCHEE);
    public static final RegistryObject<FruitBlock> MANGO_BUD = registerFruitNode("mango_bud", OrchardItems.MANGO);
    public static final RegistryObject<FruitBlock> ORANGE_BUD = registerFruitNode("orange_bud", OrchardItems.ORANGE);
    public static final RegistryObject<FruitBlock> PAWPAW_BUD = registerFruitNode("pawpaw_bud", OrchardItems.PAWPAW);
    public static final RegistryObject<FruitBlock> PEACH_BUD = registerFruitNode("peach_bud", OrchardItems.PEACH);
    public static final RegistryObject<FruitBlock> PLUM_BUD = registerFruitNode("plum_bud", OrchardItems.PLUM);
    public static final RegistryObject<FruitBlock> RED_APPLE_BUD = registerFruitNode("red_apple_bud", () -> Items.APPLE);
    public static final RegistryObject<FruitBlock> STARFRUIT_BUD = registerFruitNode("starfruit_bud", OrchardItems.STARFRUIT);

    public static final RegistryObject<Block> CHERRY_CRATE = registerWithItem("cherry_crate", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BANJO).strength(1.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CINNAMON_CRATE = registerWithItem("cinnamon_crate", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BANJO).strength(1.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> HAZELNUT_CRATE = registerWithItem("hazelnut_crate", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BANJO).strength(1.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> LEMON_CRATE = registerWithItem("lemon_crate", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BANJO).strength(1.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> LYCHEE_CRATE = registerWithItem("lychee_crate", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BANJO).strength(1.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> MANGO_CRATE = registerWithItem("mango_crate", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BANJO).strength(1.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> ORANGE_CRATE = registerWithItem("orange_crate", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BANJO).strength(1.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> PAWPAW_CRATE = registerWithItem("pawpaw_crate", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).instrument(NoteBlockInstrument.BANJO).strength(1.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> PEACH_CRATE = registerWithItem("peach_crate", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).instrument(NoteBlockInstrument.BANJO).strength(1.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> PLUM_CRATE = registerWithItem("plum_crate", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).instrument(NoteBlockInstrument.BANJO).strength(1.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> RED_APPLE_CRATE = registerWithItem("red_apple_crate", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BANJO).strength(1.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STARFRUIT_CRATE = registerWithItem("starfruit_crate", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BANJO).strength(1.5F).sound(SoundType.WOOD)));

    private static <T extends Block> RegistryObject<T> registerWithItem(String name, Supplier<T> block) {
        RegistryObject<T> registryObject = REGISTRAR.register(name, block);
        OrchardItems.REGISTRAR.register(name, () -> new BlockItem(registryObject.get(), new Item.Properties()));
        return registryObject;
    }

    private static RegistryObject<FruitBlock> registerFruitNode(String name, Supplier<? extends Item> fruit) {
        RegistryObject<FruitBlock> registryObject = REGISTRAR.register(name, () -> new FruitBlock(fruit, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
        OrchardItems.REGISTRAR_NO_TAB.register(name + "_bud", () -> new BlockItem(registryObject.get(), new Item.Properties()));
        return registryObject;
    }
}
