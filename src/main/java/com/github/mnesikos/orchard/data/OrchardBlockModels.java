package com.github.mnesikos.orchard.data;

import com.github.mnesikos.orchard.Orchard;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class OrchardBlockModels extends BlockModelProvider {
    public OrchardBlockModels(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Orchard.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
    }
}
