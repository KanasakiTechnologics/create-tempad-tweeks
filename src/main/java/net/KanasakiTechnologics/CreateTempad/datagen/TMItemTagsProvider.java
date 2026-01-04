package net.KanasakiTechnologics.CreateTempad.datagen;


import net.KanasakiTechnologics.CreateTempad.CreateTempad;
import net.KanasakiTechnologics.CreateTempad.register.TempadBlocks;
import net.KanasakiTechnologics.CreateTempad.register.TempadItems;
import net.KanasakiTechnologics.CreateTempad.register.TempadTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class TMItemTagsProvider extends ItemTagsProvider {
    public TMItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> ItemTags,@Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ItemTags, CreateTempad.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(TempadTags.ItemTags.STEEL_BLOCKS.tag)
                .add(TempadBlocks.STEEL_BLOCK.asItem());
        tag(TempadTags.ItemTags.STORAGE_BLOCKS.tag)
                .add(TempadBlocks.STEEL_BLOCK.asItem());

        tag(TempadTags.ItemTags.STEEL_DUSTS.tag)
                .add(TempadItems.STEEL_DUST.get());
        tag(TempadTags.ItemTags.IRON_DUSTS.tag)
                .add(TempadItems.IRON_DUST.get());
        tag(TempadTags.ItemTags.COAL_DUSTS.tag)
                .add(TempadItems.COAL_DUST.get());
        tag(TempadTags.ItemTags.AMETHYST_DUSTS.tag)
                .add(TempadItems.AMETHYST_DUST.get());
        tag(TempadTags.ItemTags.ENDER_DUSTS.tag)
                .add(TempadItems.ENDER_DUST.get());
        tag(TempadTags.ItemTags.DUSTS.tag)
                .add(TempadItems.AMETHYST_DUST.get())
                .add(TempadItems.ENDER_DUST.get())
                .add(TempadItems.STEEL_DUST.get())
                .add(TempadItems.IRON_DUST.get())
                .add(TempadItems.COAL_DUST.get());

        tag(TempadTags.ItemTags.STEEL_INGOTS.tag)
                .add(TempadItems.STEEL_INGOT.get());
        tag(TempadTags.ItemTags.TIME_INGOTS.tag)
                .addOptional(ResourceLocation.fromNamespaceAndPath("tempad", "time_steel"));
        tag(TempadTags.ItemTags.INGOTS.tag)
                .add(TempadItems.STEEL_INGOT.get())
                .addOptional(ResourceLocation.fromNamespaceAndPath("tempad", "time_steel"));
    }
}
