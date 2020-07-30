package com.otakusaikou.insideink.registry;

import com.otakusaikou.insideink.Utils;
import com.otakusaikou.insideink.block.SpiritStoneOre;
import com.otakusaikou.insideink.group.DefaultGroup;
import com.otakusaikou.insideink.item.SpiritStoneOreItem;
import com.otakusaikou.insideink.spirit.SpiritType;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class ItemRegistry {
    public static final Item.Properties DEFAULT_PROPERTIES = new Item.Properties().group(DefaultGroup.INSTANCE);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Utils.MOD_ID);
    public static final List<RegistryObject<SpiritStoneOreItem>> spiritStoneOreItem = new ArrayList<>();
    public static final RegistryObject<Item> metalSpiritStone = ITEMS.register("metal_spirit_stone", () -> new Item(DEFAULT_PROPERTIES));
    public static final RegistryObject<Item> woodenSpiritStone = ITEMS.register("wooden_spirit_stone", () -> new Item(DEFAULT_PROPERTIES));
    public static final RegistryObject<Item> waterSpiritStone = ITEMS.register("water_spirit_stone", () -> new Item(DEFAULT_PROPERTIES));
    public static final RegistryObject<Item> fireSpiritStone = ITEMS.register("fire_spirit_stone", () -> new Item(DEFAULT_PROPERTIES));
    public static final RegistryObject<Item> earthSpiritStone = ITEMS.register("earth_spirit_stone", () -> new Item(DEFAULT_PROPERTIES));

    public static final RegistryObject<SpiritStoneOreItem> metalSpiritStoneOreItem = registrySpiritStoneOreItem("metal", BlockRegistry.metalSpiritStoneOre, SpiritType.METAL);
    public static final RegistryObject<SpiritStoneOreItem> woodenSpiritStoneOreItem = registrySpiritStoneOreItem("wooden", BlockRegistry.woodenSpiritStoneOre, SpiritType.WOODEN);
    public static final RegistryObject<SpiritStoneOreItem> waterSpiritStoneOreItem = registrySpiritStoneOreItem("water", BlockRegistry.waterSpiritStoneOre, SpiritType.WATER);
    public static final RegistryObject<SpiritStoneOreItem> fireSpiritStoneOreItem = registrySpiritStoneOreItem("fire", BlockRegistry.fireSpiritStoneOre, SpiritType.FIRE);
    public static final RegistryObject<SpiritStoneOreItem> earthSpiritStoneOreItem = registrySpiritStoneOreItem("earth", BlockRegistry.earthSpiritStoneOre, SpiritType.EARTH);

    public static RegistryObject<SpiritStoneOreItem> registrySpiritStoneOreItem(String typeName, RegistryObject<SpiritStoneOre> block, SpiritType type) {
        RegistryObject<SpiritStoneOreItem> registryObject = ITEMS.register(typeName + "_spirit_stone_ore", () -> new SpiritStoneOreItem(block.get(), DEFAULT_PROPERTIES, type));
        spiritStoneOreItem.add(registryObject);
        return registryObject;
    }
}
