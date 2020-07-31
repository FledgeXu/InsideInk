package com.otakusaikou.insideink.render.bakedmodel;

import com.otakusaikou.insideink.block.SpiritStoneOre;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.model.BakedQuad;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ILightReader;
import net.minecraftforge.client.model.data.IModelData;
import net.minecraftforge.client.model.data.ModelDataMap;
import net.minecraftforge.client.model.data.ModelProperty;
import net.minecraftforge.fml.RegistryObject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class SpiritStoneOreBakedModel implements IBakedModel {
    public ModelProperty<Direction> DIRECTION = new ModelProperty<>();
    public IBakedModel defaultBakedModel;
    public RegistryObject<SpiritStoneOre> registryObject;

    public static Map<BlockState, IBakedModel> stateIBakedModelMap = new HashMap<>();

    public static void putToMap(BlockState state, IBakedModel bakedModel) {
        stateIBakedModelMap.put(state, bakedModel);
    }

    public SpiritStoneOreBakedModel(IBakedModel bakedModel, RegistryObject<SpiritStoneOre> registry) {
        defaultBakedModel = bakedModel;
        registryObject = registry;
    }

    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, Random rand) {
        throw new AssertionError("IBakedModel::getQuads should never be called, only IForgeBakedModel::getQuads");
    }

    @Nonnull
    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, @Nonnull Random rand, @Nonnull IModelData extraData) {
        BlockRendererDispatcher blockRendererDispatcher = Minecraft.getInstance().getBlockRendererDispatcher();
        IBakedModel renderModel = blockRendererDispatcher.getModelForState(Blocks.AIR.getDefaultState());
        if (extraData.hasProperty(DIRECTION)) {
            Direction direction = extraData.getData(DIRECTION);
            if (direction != null) {
                renderModel = SpiritStoneOreBakedModel.stateIBakedModelMap.get(registryObject.get().getDefaultState().with(BlockStateProperties.FACING, direction));
            }
        }
        return renderModel.getQuads(state, side, rand, extraData);
    }

    @Nonnull
    @Override
    public IModelData getModelData(@Nonnull ILightReader world, @Nonnull BlockPos pos, @Nonnull BlockState state, @Nonnull IModelData tileData) {
        ModelDataMap modelDataMap = new ModelDataMap.Builder().withInitial(DIRECTION, null).build();
        for (Direction direction : Direction.values()) {
            if (world.getBlockState(pos.offset(direction, 1)).getBlock() == Blocks.STONE) {
                modelDataMap.setData(DIRECTION, direction);
                return modelDataMap;
            }
        }
        return modelDataMap;
    }

    @Override
    public boolean isAmbientOcclusion() {
        return defaultBakedModel.isAmbientOcclusion();
    }

    @Override
    public boolean isGui3d() {
        return defaultBakedModel.isGui3d();
    }

    @Override
    public boolean func_230044_c_() {
        return defaultBakedModel.func_230044_c_();
    }

    @Override
    public boolean isBuiltInRenderer() {
        return defaultBakedModel.isBuiltInRenderer();
    }

    @Override
    public TextureAtlasSprite getParticleTexture() {
        return defaultBakedModel.getParticleTexture();
    }

    @Override
    public ItemOverrideList getOverrides() {
        return defaultBakedModel.getOverrides();
    }
}
