package com.otakusaikou.insideink.registry;

import com.otakusaikou.insideink.block.SpiritStoneOre;
import com.otakusaikou.insideink.render.bakedmodel.SpiritStoneOreBakedModel;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.BlockModelShapes;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BakedModelRegistry {
    @SubscribeEvent
    public static void registerBakedModel(ModelBakeEvent event) {
        for (RegistryObject<SpiritStoneOre> registryObject : BlockRegistry.spiritStoneOreList) {
            for (BlockState blockstate : registryObject.get().getStateContainer().getValidStates()) {
                ModelResourceLocation modelResourceLocation = BlockModelShapes.getModelLocation(blockstate);
                IBakedModel existingModel = event.getModelRegistry().get(modelResourceLocation);
                if (existingModel == null) {
                    throw new RuntimeException("Did not find Obsidian Hidden in registry");
                } else if (existingModel instanceof SpiritStoneOreBakedModel) {
                    throw new RuntimeException("Tried to replaceObsidian Hidden twice");
                } else {
                    SpiritStoneOreBakedModel obsidianHiddenBlockModel = new SpiritStoneOreBakedModel(existingModel, registryObject);
                    SpiritStoneOreBakedModel.putToMap(blockstate, existingModel);
                    event.getModelRegistry().put(modelResourceLocation, obsidianHiddenBlockModel);
                }
            }
        }

    }
}
