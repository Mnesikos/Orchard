package com.github.mnesikos.orchard.data;

import com.github.mnesikos.orchard.Orchard;
import com.github.mnesikos.orchard.item.OrchardItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class OrchardItemModels extends ItemModelProvider {
    public OrchardItemModels(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Orchard.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(OrchardItems.CHERRY.get());
        basicItem(OrchardItems.CINNAMON.get());
        basicItem(OrchardItems.HAZELNUT.get());
        basicItem(OrchardItems.LEMON.get());
        basicItem(OrchardItems.LYCHEE.get());
        basicItem(OrchardItems.MANGO.get());
        basicItem(OrchardItems.ORANGE.get());
        basicItem(OrchardItems.PAWPAW.get());
        basicItem(OrchardItems.PEACH.get());
        basicItem(OrchardItems.PLUM.get());
        basicItem(OrchardItems.STARFRUIT.get());
    }
}
