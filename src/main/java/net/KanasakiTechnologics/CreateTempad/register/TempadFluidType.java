package net.KanasakiTechnologics.CreateTempad.register;

import net.KanasakiTechnologics.CreateTempad.CreateTempad;
import net.KanasakiTechnologics.CreateTempad.fluid.ShimmerFluidType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class TempadFluidType {
    public static final DeferredRegister<FluidType> FLUID_TYPE = DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, CreateTempad.MOD_ID);

    public static final DeferredHolder<FluidType,FluidType> SHIMMER_TYPE = FLUID_TYPE.register("shimmer_type",
            () -> new ShimmerFluidType(FluidType.Properties.create().lightLevel(10).viscosity(2000).density(2000).canDrown(false).supportsBoating(true)));

    public static void register(IEventBus eventBus)
    {
        FLUID_TYPE.register(eventBus);
    };
}
