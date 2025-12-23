package net.KanasakiTechnologics.CreateTempad.register;

import net.KanasakiTechnologics.CreateTempad.CreateTempad;
import net.KanasakiTechnologics.CreateTempad.block.BuddingTimeCrystalBlock;
import net.KanasakiTechnologics.CreateTempad.block.TimeCrystalBlock;
import net.KanasakiTechnologics.CreateTempad.block.TimeCrystalClusterBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static net.KanasakiTechnologics.CreateTempad.register.TempadItems.ITEMS;

public class TempadBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(CreateTempad.MOD_ID);

    //Time Crystal
    public static final DeferredBlock<Block> BUDDING_BASE = registerBlock("budding_base",
            () -> new Block(BlockBehaviour.Properties.of().strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
    public static final DeferredBlock<Block> TIME_CRYSTAL_BLOCK = registerBlock("time_block",TimeCrystalBlock::new);
    public static final Supplier<ItemLike> TIME_CRYSTAL_BLOCK_ITEM = () -> TempadBlocks.TIME_CRYSTAL_BLOCK.asItem();
    public static final DeferredBlock<Block> TIME_CRYSTAL_CLUSTER = registerBlock("time_cluster",
            () -> new TimeCrystalClusterBlock(7.0F, 3.0F, BlockBehaviour.Properties.of().forceSolidOn().noOcclusion().sound(SoundType.AMETHYST_CLUSTER).strength(1.5F).lightLevel(p_152632_ -> 5).pushReaction(PushReaction.DESTROY)));
    public static final Supplier<ItemLike> TIME_CRYSTAL_CLUSTER_ITEM = () -> TempadBlocks.TIME_CRYSTAL_CLUSTER.asItem();
    public static final DeferredBlock<Block> BUDDING_TIME_CRYSTAL = registerBlock("budding_time", BuddingTimeCrystalBlock::new);

    public static final DeferredBlock<Block> SMALL_TIME_CRYSTAL_BUD = registerBlock("small_time_bud",
            () -> new TimeCrystalClusterBlock(3.0F, 4.0F, BlockBehaviour.Properties.ofLegacyCopy(TempadBlocks.TIME_CRYSTAL_CLUSTER.get()).mapColor(MapColor.COLOR_GREEN).lightLevel(p_187409_ -> 1)));
    public static final Supplier<ItemLike> SMALL_TIME_CRYSTAL_BUD_ITEM = () -> TempadBlocks.SMALL_TIME_CRYSTAL_BUD.asItem();
    public static final DeferredBlock<Block> MEDIUM_TIME_CRYSTAL_BUD = registerBlock("medium_time_bud",
            () -> new TimeCrystalClusterBlock(4.0F, 3.0F, BlockBehaviour.Properties.ofLegacyCopy(TempadBlocks.TIME_CRYSTAL_CLUSTER.get()).mapColor(MapColor.COLOR_GREEN).lightLevel(p_187409_ -> 2)));
    public static final Supplier<ItemLike> MEDIUM_TIME_CRYSTAL_BUD_ITEM = () -> TempadBlocks.MEDIUM_TIME_CRYSTAL_BUD.asItem();
    public static final DeferredBlock<Block> LARGE_TIME_CRYSTAL_BUD = registerBlock("large_time_bud",
            () -> new TimeCrystalClusterBlock(5.0F, 3.0F, BlockBehaviour.Properties.ofLegacyCopy(TempadBlocks.TIME_CRYSTAL_CLUSTER.get()).mapColor(MapColor.COLOR_GREEN).lightLevel(p_187409_ -> 4)));
    public static final Supplier<ItemLike> LARGE_TIME_CRYSTAL_BUD_ITEM = () -> TempadBlocks.LARGE_TIME_CRYSTAL_BUD.asItem();


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
