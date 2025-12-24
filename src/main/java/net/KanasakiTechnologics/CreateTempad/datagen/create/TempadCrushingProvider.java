package net.KanasakiTechnologics.CreateTempad.datagen.create;

import com.simibubi.create.AllItems;
import com.simibubi.create.api.data.recipe.CrushingRecipeGen;
import net.KanasakiTechnologics.CreateTempad.CreateTempad;
import net.KanasakiTechnologics.CreateTempad.register.TempadItems;
import net.KanasakiTechnologics.CreateTempad.register.TempadTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unused")
public final class TempadCrushingProvider extends CrushingRecipeGen {
    public TempadCrushingProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, CreateTempad.MOD_ID);
    }

    GeneratedRecipe
            COAL_DUST = create("coal_dust", b -> b.duration(150)
                    .require(ItemTags.COALS)
                    .output(TempadItems.COAL_DUST)
                    .output(25f,TempadItems.COAL_DUST)
                    .output(25f, AllItems.EXP_NUGGET)),
            IRON_DUST = create("iron_dust", b -> b.duration(150)
                    .require(TempadTags.ItemTags.IRON_INGOTS.tag)
                    .output(TempadItems.IRON_DUST)
                    .output(25f,TempadItems.IRON_DUST)
                    .output(25f, AllItems.EXP_NUGGET)),
            AMETHYST_DUST = create("amethyst_dust", b -> b.duration(150)
                    .require(Items.AMETHYST_SHARD)
                    .output(TempadItems.AMETHYST_DUST)
                    .output(25f,TempadItems.AMETHYST_DUST)
                    .output(25f, AllItems.EXP_NUGGET)),
            ENDER_DUST = create("ender_dust", b -> b.duration(150)
                    .require(Items.ENDER_PEARL)
                    .output(TempadItems.ENDER_DUST)
                    .output(25f,TempadItems.ENDER_DUST)
                    .output(25f, AllItems.EXP_NUGGET));
}
