package net.KanasakiTechnologics.CreateTempad.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AmethystBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class TimeCrystalBlock extends AmethystBlock {

    public TimeCrystalBlock() {
        super(Properties.of().sound(SoundType.AMETHYST).requiresCorrectToolForDrops().strength(1.5F));
    }
}
