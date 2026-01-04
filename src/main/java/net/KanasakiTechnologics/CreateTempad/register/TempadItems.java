package net.KanasakiTechnologics.CreateTempad.register;

import net.KanasakiTechnologics.CreateTempad.CreateTempad;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

@SuppressWarnings("unused")
public class TempadItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CreateTempad.MOD_ID);


    //Ingots,Blocks,Dusts
    public static final DeferredItem<Item> IRON_DUST = ITEMS.register("iron_dust",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> COAL_DUST = ITEMS.register("coal_dust",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> STEEL_DUST = ITEMS.register("steel_dust",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> STEEL_INGOT = ITEMS.register("steel_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TIME_STEEL_SHEET = ITEMS.register("time_steel_sheet",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> AMETHYST_DUST = ITEMS.register("amethyst_dust",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ENDER_DUST = ITEMS.register("ender_pearl_dust",
            () -> new Item(new Item.Properties()));

    //Shimmer
    public static final DeferredItem<Item> SHIMMER_BUCKET = ITEMS.register("shimmer_bucket",
            () -> new BucketItem(TempadFluid.SHIMMER.get(),new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).durability(0)));

    //Time Shard
    public static final DeferredItem<Item> TIME_ELECTRON_TUBE = ITEMS.register("time_electron_tube",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CHRONOS_MECHANISM = ITEMS.register("chrono_mechanism",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> INCOMPLETE_CHRONOS_MECHANISM = ITEMS.register("incomplete_chrono_mechanism",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){ITEMS.register(eventBus);}

}
