package net.KanasakiTechnologics.CreateTempad.datagen.create;

import com.simibubi.create.AllItems;
import com.simibubi.create.api.data.recipe.SequencedAssemblyRecipeGen;
import com.simibubi.create.content.fluids.transfer.FillingRecipe;
import com.simibubi.create.content.kinetics.deployer.DeployerApplicationRecipe;
import net.KanasakiTechnologics.CreateTempad.CreateTempad;
import net.KanasakiTechnologics.CreateTempad.register.TempadBlocks;
import net.KanasakiTechnologics.CreateTempad.register.TempadFluid;
import net.KanasakiTechnologics.CreateTempad.register.TempadItems;
import net.KanasakiTechnologics.CreateTempad.register.TempadTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.FlowingFluid;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unused")
public final class TempadAssemblingProvider extends SequencedAssemblyRecipeGen {
    public TempadAssemblingProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateTempad.MOD_ID);
    }

    GeneratedRecipe
            INTEGRATED_CIRCUIT = create("integrated_circuit",b -> b.require(Ingredient.of(TempadTags.ItemTags.GOLD_PLATES.tag))
                    .transitionTo(TempadItems.INCOMPLETE_INTEGRATED_CIRCUIT)
                    .addOutput(TempadItems.INTEGRATED_CIRCUIT,160)
                    .addOutput(AllItems.GOLDEN_SHEET,5)
                    .addOutput(Items.REDSTONE,4)
                    .addOutput(Items.QUARTZ,4)
                    .addOutput(AllItems.BRASS_NUGGET,4)
                    .loops(4)
                    .addStep(DeployerApplicationRecipe::new, rb -> rb.require(Items.REDSTONE))
                    .addStep(DeployerApplicationRecipe::new,rb -> rb.require(Items.QUARTZ))
                    .addStep(DeployerApplicationRecipe::new,rb -> rb.require(TempadTags.ItemTags.BRASS_NUGGETS.tag))),

            BUDDING_TIME_CRYSTAL = create("budding_time_crystal",b -> b.require(TempadBlocks.BUDDING_BASE)
                    .transitionTo(TempadBlocks.BUDDING_BASE)
                    .addOutput(TempadBlocks.BUDDING_TIME_CRYSTAL,30)
                    .addOutput(TempadItems.TIME_CRYSTAL_SHARD,35)
                    .addOutput(Blocks.AMETHYST_BLOCK,35)
                    .loops(5)
                    .addStep(DeployerApplicationRecipe::new, rb -> rb.require(AllItems.EXP_NUGGET))
                    .addStep(FillingRecipe::new, rb -> rb.require((FlowingFluid) TempadFluid.SHIMMER.get(),250))
                    .addStep(DeployerApplicationRecipe::new,rb -> rb.require(TempadTags.ItemTags.AMETHYST_DUSTS.tag))
                    .addStep(FillingRecipe::new, rb -> rb.require((FlowingFluid) TempadFluid.SHIMMER.get(),250))
                    .addStep(DeployerApplicationRecipe::new,rb -> rb.require(TempadTags.ItemTags.ENDER_DUSTS.tag))),

            CHRONOS_MECHANISM = create("chronos_mechanism",b -> b.require(TempadItems.TIME_STEEL_SHEET)
                    .transitionTo(TempadItems.INCOMPLETE_CHRONOS_MECHANISM)
                    .addOutput(TempadItems.CHRONOS_MECHANISM,160)
                    .addOutput(TempadItems.TIME_CRYSTAL_SHARD,8)
                    .addOutput(Items.REDSTONE,4)
                    .addOutput(Items.QUARTZ,4)
                    .loops(5)
                    .addStep(DeployerApplicationRecipe::new, rb -> rb.require(AllItems.ELECTRON_TUBE))
                    .addStep(DeployerApplicationRecipe::new,rb -> rb.require(TempadItems.INTEGRATED_CIRCUIT))
                    .addStep(DeployerApplicationRecipe::new,rb -> rb.require(TempadItems.TIME_ELECTRON_TUBE)));
}
