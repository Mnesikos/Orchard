package com.github.mnesikos.orchard.data;

import com.github.mnesikos.orchard.Orchard;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class OrchardBlockModels extends BlockModelProvider {
    public OrchardBlockModels(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Orchard.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
    }
}
