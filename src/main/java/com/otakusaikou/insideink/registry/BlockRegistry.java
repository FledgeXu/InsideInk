package com.otakusaikou.insideink.registry;

import com.otakusaikou.insideink.Utils;
import com.otakusaikou.insideink.block.SpiritStoneOre;
import com.otakusaikou.insideink.group.DefaultGroup;
import com.otakusaikou.insideink.spirit.SpiritType;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class BlockRegistry {
    private static final Block.Properties DEFAULT_PROPERTIES = Block.Properties.create(Material.ROCK);
    private static final Item.Properties DEFAULT_BLOCK_ITEM_PROPERTIES = new Item.Properties().group(DefaultGroup.INSTANCE);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Utils.MOD_ID);
    public static final List<RegistryObject<SpiritStoneOre>> spiritStoneOreList = new ArrayList<>();
    public static final RegistryObject<SpiritStoneOre> metalSpiritStoneOre = registerSpiritStoneOre("metal", SpiritType.METAL);
    public static final RegistryObject<SpiritStoneOre> woodenSpiritStoneOre = registerSpiritStoneOre("wooden", SpiritType.WOODEN);
    public static final RegistryObject<SpiritStoneOre> waterSpiritStoneOre = registerSpiritStoneOre("water", SpiritType.WATER);
    public static final RegistryObject<SpiritStoneOre> fireSpiritStoneOre = registerSpiritStoneOre("fire", SpiritType.FIRE);
    public static final RegistryObject<SpiritStoneOre> earthSpiritStoneOre = registerSpiritStoneOre("earth", SpiritType.EARTH);


    private static RegistryObject<SpiritStoneOre> registerSpiritStoneOre(String typeName, SpiritType type) {
        RegistryObject<SpiritStoneOre> registryObject = BLOCKS.register(typeName + "_spirit_stone_ore", () -> new SpiritStoneOre(DEFAULT_PROPERTIES.notSolid(), type));
        spiritStoneOreList.add(registryObject);
        return registryObject;
    }

    // Register Block which should have its BlockItem.
    private static <T extends Block> RegistryObject<T> registerWithItem(String name, final Supplier<T> sup) {
        RegistryObject<T> registryObject = BLOCKS.register(name, sup);
        ItemRegistry.ITEMS.register(name, () -> new BlockItem(registryObject.get(), DEFAULT_BLOCK_ITEM_PROPERTIES));
        return registryObject;
    }
}
