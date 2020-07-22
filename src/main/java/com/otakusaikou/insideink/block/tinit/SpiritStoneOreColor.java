package com.otakusaikou.insideink.block.tinit;

import com.otakusaikou.insideink.block.SpiritStoneOre;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ILightReader;

import javax.annotation.Nullable;

public class SpiritStoneOreColor implements IBlockColor {
    @Override
    public int getColor(BlockState blockState, @Nullable ILightReader lightReader, @Nullable BlockPos po, int tint) {
        return blockState.get(SpiritStoneOre.TYPE).getColor().getRGB();
    }
}
