package com.github.mnesikos.orchard;

import com.github.mnesikos.orchard.block.OrchardBlocks;
import com.github.mnesikos.orchard.data.*;
import com.github.mnesikos.orchard.item.OrchardItems;
import com.github.mnesikos.orchard.levelgen.FruitDecorator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Mod(Orchard.MOD_ID)
public class Orchard {
    public static final String MOD_ID = "orchard";
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ORCHARD_TAB = CREATIVE_MODE_TABS.register(MOD_ID + ".tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + MOD_ID))
            .icon(() -> OrchardBlocks.RED_APPLE_SAPLING.get().asItem().getDefaultInstance())
            .displayItems((parameters, output) -> OrchardItems.REGISTRAR.getEntries().forEach(item -> output.accept(item.get())))
            .build());

    public Orchard(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::gatherData);

        OrchardBlocks.REGISTRAR.register(modEventBus);
        OrchardItems.REGISTRAR.register(modEventBus);
        OrchardItems.REGISTRAR_NO_TAB.register(modEventBus);
        FruitDecorator.REGISTRAR.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);

//        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void gatherData(final GatherDataEvent event) {
        DataGenerator dataGenerator = event.getGenerator();
        PackOutput packOutput = dataGenerator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

//        dataGenerator.addProvider(event.includeClient(), new OrchardBlockModels(packOutput, existingFileHelper));
        dataGenerator.addProvider(event.includeClient(), new OrchardBlockStates(packOutput, existingFileHelper));
        dataGenerator.addProvider(event.includeClient(), new OrchardItemModels(packOutput, existingFileHelper));
        dataGenerator.addProvider(event.includeClient(), new OrchardLang(packOutput));
//
//        FruitsTags.FruitsBlockTags blockTagsProvider = new FruitsTags.FruitsBlockTags(packOutput, event.getLookupProvider(), existingFileHelper);
//        dataGenerator.addProvider(event.includeServer(), blockTagsProvider);
//        dataGenerator.addProvider(event.includeServer(), new FruitsTags.FruitsItemTags(packOutput, event.getLookupProvider(), blockTagsProvider, existingFileHelper));
        dataGenerator.addProvider(event.includeServer(), new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(OrchardLootTables::new, LootContextParamSets.BLOCK)), event.getLookupProvider()));
        dataGenerator.addProvider(event.includeServer(), new OrchardRecipes(packOutput, event.getLookupProvider()));

        RegistrySetBuilder registrySetBuilder = new RegistrySetBuilder()
                .add(Registries.CONFIGURED_FEATURE, OrchardFeatures::bootstrap);
        DatapackBuiltinEntriesProvider datapackProvider = new DatapackBuiltinEntriesProvider(packOutput, event.getLookupProvider(), registrySetBuilder, Set.of(Orchard.MOD_ID));
        dataGenerator.addProvider(event.includeServer(), datapackProvider);
    }
}
