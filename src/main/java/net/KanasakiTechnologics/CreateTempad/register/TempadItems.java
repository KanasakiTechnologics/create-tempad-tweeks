package net.KanasakiTechnologics.CreateTempad.register;

import net.KanasakiTechnologics.CreateTempad.CreateTempad;
import net.KanasakiTechnologics.CreateTempad.block.TimeCrystalBlock;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class TempadItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CreateTempad.MOD_ID);

    //Time Shard
    public static final DeferredItem<Item> TIME_CRYSTAL_SHARD = ITEMS.register("time_shard",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CHRONOS_MECHANISM = ITEMS.register("chrono_mechanism",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){ITEMS.register(eventBus);}

}
