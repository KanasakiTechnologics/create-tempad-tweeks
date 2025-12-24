package net.KanasakiTechnologics.CreateTempad.datagen;

import net.KanasakiTechnologics.CreateTempad.CreateTempad;
import net.KanasakiTechnologics.CreateTempad.register.TempadFluid;
import net.KanasakiTechnologics.CreateTempad.register.TempadTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class TMFluidTagsProvider extends FluidTagsProvider {
    public TMFluidTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, provider, CreateTempad.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(TempadTags.FluidTags.SHIMMER.tag)
                .add(TempadFluid.SHIMMER.get())
                .add(TempadFluid.FLOWING_SHIMMER.get());
    }
}
