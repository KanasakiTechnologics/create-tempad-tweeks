package net.KanasakiTechnologics.CreateTempad.register;

import net.KanasakiTechnologics.CreateTempad.CreateTempad;
import net.KanasakiTechnologics.CreateTempad.fluid.ShimmerFluid;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class TempadFluid {
    public static DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(Registries.FLUID, CreateTempad.MOD_ID);

    public static final DeferredHolder<Fluid,Fluid> SHIMMER = FLUIDS.register("shimmer",
            () -> new ShimmerFluid.Source(getShimmerProperties()));
    public static final DeferredHolder<Fluid,Fluid> FLOWING_SHIMMER = FLUIDS.register("flowing_shimmer",
            () -> new ShimmerFluid.Flowing(getShimmerProperties()));
    private static BaseFlowingFluid.Properties getShimmerProperties(){
        return new BaseFlowingFluid.Properties(
                TempadFluidType.SHIMMER_TYPE,
                SHIMMER,
                FLOWING_SHIMMER
        )
                .bucket(TempadItems.SHIMMER_BUCKET)
                .block(TempadBlocks.SHIMMER)
                .tickRate(10)
                .levelDecreasePerBlock(2)
                .slopeFindDistance(2)
                .explosionResistance(0F);
    }

    public static void register(IEventBus eventBus)
    {
        FLUIDS.register(eventBus);
    }
}
