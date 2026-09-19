package com.refinedmods.refinedstorage.neoforge.datagen;

import com.refinedmods.refinedstorage.neoforge.datagen.loot.LootTableProviderImpl;
import com.refinedmods.refinedstorage.neoforge.datagen.model.ModelProviders;
import com.refinedmods.refinedstorage.neoforge.datagen.recipe.MainRecipeProvider;
import com.refinedmods.refinedstorage.neoforge.datagen.tag.BlockTagsProvider;
import com.refinedmods.refinedstorage.neoforge.datagen.tag.ItemTagsProvider;

import java.util.List;
import java.util.Set;

import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.data.recipes.RecipeProvider;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import static com.refinedmods.refinedstorage.common.util.IdentifierUtil.MOD_ID;

@EventBusSubscriber(modid = MOD_ID)
public class DataGenerators {
    private DataGenerators() {
    }

    @SubscribeEvent
    public static void onGatherData(final GatherDataEvent.Client e) {
        final DataGenerator generator = e.getGenerator();
        final DataGenerator.PackGenerator pack = generator.getVanillaPack(true);

        // Recipes, recipe advancements, normal advancements and loot tables are reloadable registries in 26.3.
        e.createReloadableRegistryObjects(
            new RegistrySetBuilder()
                .add(RecipeProvider.asBootstrap(MainRecipeProvider::new))
                .add(Registries.ADVANCEMENT, new AdvancementProvider(List.of(
                    com.refinedmods.refinedstorage.neoforge.datagen.advancement.AdvancementProvider::new
                )))
                .add(Registries.LOOT_TABLE, new LootTableProviderImpl()),
            Set.of("minecraft", MOD_ID),
            "reloadable - " + MOD_ID
        );

        pack.addProvider(ModelProviders::new);
        final BlockTagsProvider blockTagsProvider = pack.addProvider(output ->
            new BlockTagsProvider(output, e.getReloadableLookupProvider()));
        pack.addProvider(output ->
            new ItemTagsProvider(output, e.getReloadableLookupProvider(), blockTagsProvider.contentsGetter()));
    }
}
