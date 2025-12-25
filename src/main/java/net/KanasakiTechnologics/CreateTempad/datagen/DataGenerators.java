package net.KanasakiTechnologics.CreateTempad.datagen;

import net.KanasakiTechnologics.CreateTempad.CreateTempad;
import net.KanasakiTechnologics.CreateTempad.datagen.create.TempadAssemblingProvider;
import net.KanasakiTechnologics.CreateTempad.datagen.create.TempadCrushingProvider;
import net.KanasakiTechnologics.CreateTempad.datagen.create.TempadMillingProvider;
import net.KanasakiTechnologics.CreateTempad.datagen.create.TempadMixingProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import java.util.concurrent.CompletableFuture;

@SuppressWarnings("removal")
@EventBusSubscriber(modid = CreateTempad.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new TMRecipeProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new TempadMixingProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new TempadMillingProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new TempadCrushingProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new TempadAssemblingProvider(packOutput, lookupProvider));

        BlockTagsProvider blockTagsProvider= new TMBlockTagsProvider(packOutput,lookupProvider,existingFileHelper);
        generator.addProvider(event.includeServer(),blockTagsProvider);
        generator.addProvider(event.includeServer(), new TMFluidTagsProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new TMItemTagsProvider(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));
    }
}
