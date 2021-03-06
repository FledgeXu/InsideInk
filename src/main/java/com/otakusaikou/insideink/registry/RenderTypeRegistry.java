package com.otakusaikou.insideink.registry;

import com.otakusaikou.insideink.block.SpiritStoneOre;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RenderTypeRegistry {
    @SubscribeEvent
    public static void onRenderTypeSetup(FMLClientSetupEvent event) {
        for (RegistryObject<SpiritStoneOre> spiritStoneOre : BlockRegistry.spiritStoneOreList) {
            RenderTypeLookup.setRenderLayer(spiritStoneOre.get(), RenderType.getTranslucent());
        }
    }
}