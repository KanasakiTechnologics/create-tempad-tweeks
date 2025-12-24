package net.KanasakiTechnologics.CreateTempad.datagen.create;

import com.simibubi.create.AllItems;
import com.simibubi.create.api.data.recipe.MixingRecipeGen;
import com.simibubi.create.content.processing.recipe.HeatCondition;
import net.KanasakiTechnologics.CreateTempad.CreateTempad;
import net.KanasakiTechnologics.CreateTempad.register.TempadBlocks;
import net.KanasakiTechnologics.CreateTempad.register.TempadFluid;
import net.KanasakiTechnologics.CreateTempad.register.TempadItems;
import net.KanasakiTechnologics.CreateTempad.register.TempadTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluids;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unused")
public final class TempadMixingProvider extends MixingRecipeGen {
    public TempadMixingProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateTempad.MOD_ID);
    }

    GeneratedRecipe
            SHIMMER = create("shimmer", b -> b
            .require(Fluids.WATER,500)
            .require(AllItems.EXP_NUGGET)
            .require(AllItems.EXP_NUGGET)
            .require(TempadTags.ItemTags.AMETHYST_DUSTS.tag)
            .require(TempadTags.ItemTags.ENDER_DUSTS.tag)
            .output(TempadFluid.SHIMMER.get(), 100)),

    ENDER_PEARL = create("ender_pearl", b -> b.requiresHeat(HeatCondition.HEATED)
            .require(TempadItems.ENDER_SHARD)
            .require(TempadItems.ENDER_SHARD)
            .require(TempadItems.ENDER_SHARD)
            .require(TempadItems.ENDER_SHARD)
            .require(TempadTags.ItemTags.AMETHYST_DUSTS.tag)
            .output(Items.ENDER_PEARL)),

    BUDDING_BASE = create("budding_base", b -> b.requiresHeat(HeatCondition.HEATED)
            .require(Fluids.WATER,1000)
            .require(AllItems.EXP_NUGGET)
            .require(AllItems.EXP_NUGGET)
            .require(Blocks.AMETHYST_BLOCK)
            .require(TempadTags.ItemTags.ENDER_DUSTS.tag)
            .require(TempadTags.ItemTags.ENDER_DUSTS.tag)
            .output(TempadBlocks.BUDDING_BASE)),

    STEEL_DUST = create("steel_dust", b -> b.requiresHeat(HeatCondition.HEATED)
            .require(TempadTags.ItemTags.IRON_DUSTS.tag)
            .require(TempadTags.ItemTags.COAL_DUSTS.tag)
            .output(TempadItems.STEEL_DUST,2));

}
