package com.refinedmods.refinedstorage.neoforge.datagen.loot;

import java.util.List;
import java.util.Set;

import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

public class LootTableProviderImpl extends LootTableProvider {
    public LootTableProviderImpl() {
        super(Set.of(), List.of(new SubProviderEntry(
            BlockDropsProvider::new,
            LootContextParamSets.BLOCK
        )));
    }
}
