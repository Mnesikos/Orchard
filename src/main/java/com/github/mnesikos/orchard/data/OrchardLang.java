package com.github.mnesikos.orchard.data;

import com.github.mnesikos.orchard.Orchard;
import com.github.mnesikos.orchard.block.OrchardBlocks;
import com.github.mnesikos.orchard.item.OrchardItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.data.LanguageProvider;

public class OrchardLang extends LanguageProvider {
    public OrchardLang(PackOutput output) {
        super(output, Orchard.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.orchard", "Orchard");

        add(OrchardItems.CHERRY.get(), "Cherry");
        add(OrchardBlocks.CHERRY_SAPLING.get(), "Cherry Sapling");
        add(OrchardBlocks.CHERRY_BUD.get(), "Cherry Bud");
        add(OrchardBlocks.CHERRY_CRATE.get(), "Cherry Crate");
        add(OrchardItems.CINNAMON.get(), "Cinnamon");
        add(OrchardBlocks.CINNAMON_SAPLING.get(), "Cinnamon Sapling");
        add(OrchardBlocks.CINNAMON_BUD.get(), "Cinnamon Bud");
        add(OrchardBlocks.CINNAMON_CRATE.get(), "Cinnamon Crate");
        add(OrchardItems.HAZELNUT.get(), "Hazelnut");
        add(OrchardBlocks.HAZELNUT_SAPLING.get(), "Hazelnut Sapling");
        add(OrchardBlocks.HAZELNUT_BUD.get(), "Hazelnut Bud");
        add(OrchardBlocks.HAZELNUT_CRATE.get(), "Hazelnut Crate");
        add(OrchardItems.LEMON.get(), "Lemon");
        add(OrchardBlocks.LEMON_SAPLING.get(), "Lemon Sapling");
        add(OrchardBlocks.LEMON_BUD.get(), "Lemon Bud");
        add(OrchardBlocks.LEMON_CRATE.get(), "Lemon Crate");
        add(OrchardItems.LYCHEE.get(), "Lychee");
        add(OrchardBlocks.LYCHEE_SAPLING.get(), "Lychee Sapling");
        add(OrchardBlocks.LYCHEE_BUD.get(), "Lychee Bud");
        add(OrchardBlocks.LYCHEE_CRATE.get(), "Lychee Crate");
        add(OrchardItems.MANGO.get(), "Mango");
        add(OrchardBlocks.MANGO_SAPLING.get(), "Mango Sapling");
        add(OrchardBlocks.MANGO_BUD.get(), "Mango Bud");
        add(OrchardBlocks.MANGO_CRATE.get(), "Mango Crate");
        add(OrchardItems.ORANGE.get(), "Orange");
        add(OrchardBlocks.ORANGE_SAPLING.get(), "Orange Sapling");
        add(OrchardBlocks.ORANGE_BUD.get(), "Orange Bud");
        add(OrchardBlocks.ORANGE_CRATE.get(), "Orange Crate");
        add(OrchardItems.PAWPAW.get(), "Pawpaw");
        add(OrchardBlocks.PAWPAW_SAPLING.get(), "Pawpaw Sapling");
        add(OrchardBlocks.PAWPAW_BUD.get(), "Pawpaw Bud");
        add(OrchardBlocks.PAWPAW_CRATE.get(), "Pawpaw Crate");
        add(OrchardItems.PEACH.get(), "Peach");
        add(OrchardBlocks.PEACH_SAPLING.get(), "Peach Sapling");
        add(OrchardBlocks.PEACH_BUD.get(), "Peach Bud");
        add(OrchardBlocks.PEACH_CRATE.get(), "Peach Crate");
        add(OrchardItems.PLUM.get(), "Plum");
        add(OrchardBlocks.PLUM_SAPLING.get(), "Plum Sapling");
        add(OrchardBlocks.PLUM_BUD.get(), "Plum Bud");
        add(OrchardBlocks.PLUM_CRATE.get(), "Plum Crate");
        add(Items.APPLE, "Red Apple");
        add(OrchardBlocks.RED_APPLE_SAPLING.get(), "Red Apple Sapling");
        add(OrchardBlocks.RED_APPLE_BUD.get(), "Red Apple Bud");
        add(OrchardBlocks.RED_APPLE_CRATE.get(), "Red Apple Crate");
        add(OrchardItems.STARFRUIT.get(), "Starfruit");
        add(OrchardBlocks.STARFRUIT_SAPLING.get(), "Starfruit Sapling");
        add(OrchardBlocks.STARFRUIT_BUD.get(), "Starfruit Bud");
        add(OrchardBlocks.STARFRUIT_CRATE.get(), "Starfruit Crate");
    }
}
