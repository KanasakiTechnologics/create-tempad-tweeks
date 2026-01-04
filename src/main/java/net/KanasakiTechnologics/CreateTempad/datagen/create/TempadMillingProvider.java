package net.KanasakiTechnologics.CreateTempad.datagen.create;

import com.simibubi.create.AllItems;
import com.simibubi.create.api.data.recipe.MillingRecipeGen;
import com.simibubi.create.content.processing.recipe.HeatCondition;
import net.KanasakiTechnologics.CreateTempad.CreateTempad;
import net.KanasakiTechnologics.CreateTempad.register.TempadBlocks;
import net.KanasakiTechnologics.CreateTempad.register.TempadFluid;
import net.KanasakiTechnologics.CreateTempad.register.TempadItems;
import net.KanasakiTechnologics.CreateTempad.register.TempadTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unused")
public final class TempadMillingProvider extends MillingRecipeGen {
    public TempadMillingProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateTempad.MOD_ID);
    }

    GeneratedRecipe
            COAL_DUST = create("coal_dust", b -> b.duration(150)
                    .require(ItemTags.COALS)
                    .output(TempadItems.COAL_DUST)),
            IRON_DUST = create("iron_dust", b -> b.duration(150)
                    .require(TempadTags.ItemTags.IRON_INGOTS.tag)
                    .output(TempadItems.IRON_DUST));



}
