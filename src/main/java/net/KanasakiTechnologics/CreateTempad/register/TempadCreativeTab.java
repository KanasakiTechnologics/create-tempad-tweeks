package net.KanasakiTechnologics.CreateTempad.register;

import net.KanasakiTechnologics.CreateTempad.CreateTempad;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class TempadCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateTempad.MOD_ID);

    public static final Supplier<CreativeModeTab> TEMPAD = CREATIVE_MODE_TAB.register("tempad",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(TempadItems.CHRONOS_MECHANISM.get()))
                    .title(Component.translatable("creativetab.createmanacology.tempad"))
                    .displayItems(((itemDisplayParameters, output) -> {
                        output.accept(TempadItems.SHIMMER_BUCKET);
                        output.accept(TempadItems.INTEGRATED_CIRCUIT);
                        output.accept(TempadItems.CHRONOS_MECHANISM);
                        output.accept(TempadItems.TIME_CRYSTAL_SHARD);
                        output.accept(TempadBlocks.BUDDING_BASE);
                        output.accept(TempadBlocks.TIME_CRYSTAL_BLOCK);
                        output.accept(TempadBlocks.BUDDING_TIME_CRYSTAL);
                    })).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
