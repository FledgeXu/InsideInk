package com.otakusaikou.insideink.registry;

import com.otakusaikou.insideink.Utils;
import com.otakusaikou.insideink.group.DefaultGroup;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {
    public static final Item.Properties DEFAULT_PROPERTIES = new Item.Properties().group(DefaultGroup.INSTANCE);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Utils.MOD_ID);
    public static final RegistryObject<Item> metalSpiritStone = ITEMS.register("metal_spirit_stone", () -> new Item(DEFAULT_PROPERTIES));
    public static final RegistryObject<Item> woodenSpiritStone = ITEMS.register("wooden_spirit_stone", () -> new Item(DEFAULT_PROPERTIES));
    public static final RegistryObject<Item> waterSpiritStone = ITEMS.register("water_spirit_stone", () -> new Item(DEFAULT_PROPERTIES));
    public static final RegistryObject<Item> fireSpiritStone = ITEMS.register("fire_spirit_stone", () -> new Item(DEFAULT_PROPERTIES));
    public static final RegistryObject<Item> earthSpiritStone = ITEMS.register("earth_spirit_stone", () -> new Item(DEFAULT_PROPERTIES));
}
