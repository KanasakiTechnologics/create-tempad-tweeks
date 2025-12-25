package net.KanasakiTechnologics.CreateTempad.datagen;

import com.simibubi.create.AllItems;
import earth.terrarium.tempad.common.items.TempadItem;
import net.KanasakiTechnologics.CreateTempad.register.TempadBlocks;
import net.KanasakiTechnologics.CreateTempad.register.TempadItems;
import net.KanasakiTechnologics.CreateTempad.register.TempadTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.BlastingRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class TMRecipeProvider extends RecipeProvider implements IConditionBuilder {
    List<ItemLike> STEEL = List.of(TempadItems.STEEL_DUST);

    public TMRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    @ParametersAreNonnullByDefault
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TempadBlocks.BUDDING_BASE,1)
                .pattern("EBE")
                .pattern("BAB")
                .pattern("EBE")
                .define('E',TempadItems.ENDER_DUST)
                .define('B', Items.BONE_MEAL)
                .define('A', Blocks.AMETHYST_BLOCK)
                .unlockedBy("has_amethyst", has(Blocks.AMETHYST_BLOCK)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TempadItems.STEEL_DUST,1)
                .pattern("ICC")
                .define('I',TempadTags.ItemTags.IRON_DUSTS.tag)
                .define('C', TempadTags.ItemTags.COAL_DUSTS.tag)
                .unlockedBy("has_iron", has(TempadTags.ItemTags.IRON_DUSTS.tag)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TempadBlocks.STEEL_BLOCK,1)
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S',TempadTags.ItemTags.STEEL_INGOTS.tag)
                .unlockedBy("has_steel", has(TempadTags.ItemTags.STEEL_INGOTS.tag)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TempadItems.STEEL_INGOT,9)
                .requires(TempadTags.ItemTags.STEEL_BLOCKS.tag)
                .unlockedBy("has_steel",has(TempadTags.ItemTags.STEEL_BLOCKS.tag))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TempadBlocks.TIME_CRYSTAL_BLOCK,1)
                .pattern("TT")
                .pattern("TT")
                .define('T',TempadItems.TIME_CRYSTAL_SHARD)
                .unlockedBy("has_time", has(TempadItems.TIME_CRYSTAL_SHARD)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TempadItems.TIME_CRYSTAL_SHARD,4)
                .requires(TempadBlocks.TIME_CRYSTAL_BLOCK)
                .unlockedBy("has_time",has(TempadBlocks.TIME_CRYSTAL_BLOCK))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TempadItems.TIME_ELECTRON_TUBE,1)
                .pattern("T")
                .pattern("B")
                .define('T',TempadItems.TIME_CRYSTAL_SHARD)
                .define('B',TempadTags.ItemTags.BRASS_PLATES.tag)
                .unlockedBy("has_time", has(TempadItems.TIME_CRYSTAL_SHARD)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.ENDER_PEARL,1)
                .pattern("EEE")
                .pattern("E E")
                .pattern("EEE")
                .define('E',TempadItems.ENDER_SHARD)
                .unlockedBy("has_ender", has(TempadItems.ENDER_SHARD)).save(recipeOutput);

        oreSmelting(recipeOutput,STEEL,RecipeCategory.MISC, TempadItems.STEEL_INGOT.get(),0.50f,50,"steel");
        oreBlasting(recipeOutput,STEEL,RecipeCategory.MISC,TempadItems.STEEL_INGOT.get(),0.50f,100,"steel");
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }
}
