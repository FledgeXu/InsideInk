package com.otakusaikou.insideink.registry;

import com.otakusaikou.insideink.block.SpiritStoneOre;
import com.otakusaikou.insideink.block.tinit.SpiritStoneOreColor;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ColorRegistry {
    @SubscribeEvent
    public static void blockColors(ColorHandlerEvent.Block event) {
        SpiritStoneOreColor spiritStoneOreColor = new SpiritStoneOreColor();
        for (RegistryObject<SpiritStoneOre> spiritStoneOre : BlockRegistry.spiritStoneOreList) {
            event.getBlockColors().register(spiritStoneOreColor, spiritStoneOre.get());
        }
    }
}
