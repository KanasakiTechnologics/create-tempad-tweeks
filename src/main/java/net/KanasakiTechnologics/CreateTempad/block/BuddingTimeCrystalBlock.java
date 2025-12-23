package net.KanasakiTechnologics.CreateTempad.block;

import net.KanasakiTechnologics.CreateTempad.register.TempadBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;

public class BuddingTimeCrystalBlock extends AmethystBlock {
    private static final Direction[] DIRECTIONS = Direction.values();

    public BuddingTimeCrystalBlock() {
        super(Properties.of().sound(SoundType.AMETHYST).randomTicks().strength(1.5F));
    }

    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (random.nextInt(5) == 0) {
            Direction direction = DIRECTIONS[random.nextInt(DIRECTIONS.length)];
            BlockPos blockpos = pos.relative(direction);
            BlockState blockstate = level.getBlockState(blockpos);
            Block block = null;
            if (canClusterGrowAtState(blockstate)) {
                block = TempadBlocks.SMALL_TIME_CRYSTAL_BUD.get();
            } else if (blockstate.is(TempadBlocks.SMALL_TIME_CRYSTAL_BUD) && blockstate.getValue(AmethystClusterBlock.FACING) == direction) {
                block = TempadBlocks.MEDIUM_TIME_CRYSTAL_BUD.get();
            } else if (blockstate.is(TempadBlocks.MEDIUM_TIME_CRYSTAL_BUD.get()) && blockstate.getValue(AmethystClusterBlock.FACING) == direction) {
                block = TempadBlocks.LARGE_TIME_CRYSTAL_BUD.get();
            } else if (blockstate.is(TempadBlocks.LARGE_TIME_CRYSTAL_BUD.get()) && blockstate.getValue(AmethystClusterBlock.FACING) == direction) {
                block = TempadBlocks.TIME_CRYSTAL_CLUSTER.get();
            }

            if (block != null) {
                BlockState blockstate1 = (BlockState)((BlockState)block.defaultBlockState().setValue(AmethystClusterBlock.FACING, direction)).setValue(AmethystClusterBlock.WATERLOGGED, blockstate.getFluidState().getType() == Fluids.WATER);
                level.setBlockAndUpdate(blockpos, blockstate1);
            }
        }

    }

    public static boolean canClusterGrowAtState(BlockState state) {
        return state.isAir() || state.is(Blocks.WATER) && state.getFluidState().getAmount() == 8;
    }
}
