package net.KanasakiTechnologics.CreateTempad.datagen;

import net.KanasakiTechnologics.CreateTempad.CreateTempad;
import net.KanasakiTechnologics.CreateTempad.register.TempadBlocks;
import net.KanasakiTechnologics.CreateTempad.register.TempadTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class TMBlockTagsProvider extends BlockTagsProvider {
    public TMBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,  @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CreateTempad.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(TempadTags.BlockTags.STEEL_BLOCKS.tag)
                .add(TempadBlocks.STEEL_BLOCK.get());
        tag(TempadTags.BlockTags.TIME_BLOCKS.tag)
                .add(TempadBlocks.TIME_CRYSTAL_BLOCK.get());
        tag(TempadTags.BlockTags.STORAGE_BLOCKS.tag)
                .add(TempadBlocks.TIME_CRYSTAL_BLOCK.get())
                .add(TempadBlocks.STEEL_BLOCK.get());
    }
}
