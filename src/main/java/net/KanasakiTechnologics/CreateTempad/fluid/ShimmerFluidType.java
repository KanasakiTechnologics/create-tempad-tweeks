package net.KanasakiTechnologics.CreateTempad.fluid;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.FluidType;

import java.util.function.Consumer;

@SuppressWarnings("removal")
public class ShimmerFluidType extends FluidType {
    private static final ResourceLocation STILL = ResourceLocation.fromNamespaceAndPath("createtempad","block/shimmer_still");
    private static final ResourceLocation FLOWING = ResourceLocation.fromNamespaceAndPath("createtempad","block/shimmer_flow");

    public ShimmerFluidType(Properties properties) {
        super(properties
                .lightLevel(10)
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
        );
    }

    @Override
    public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
        consumer.accept(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() {
                return STILL;
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return FLOWING;
            }
        });
    }
}
