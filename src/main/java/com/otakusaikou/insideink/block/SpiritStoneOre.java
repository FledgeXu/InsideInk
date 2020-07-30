package com.otakusaikou.insideink.block;

import com.otakusaikou.insideink.block.blokcstate.SpiritTypeProperty;
import com.otakusaikou.insideink.spirit.SpiritType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class SpiritStoneOre extends Block {
    public static SpiritTypeProperty TYPE = SpiritTypeProperty.create("type", SpiritType.values());

    public SpiritStoneOre(Properties properties, SpiritType type) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(TYPE, type));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(TYPE);
        super.fillStateContainer(builder);
    }

    public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
        return true;
    }

    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return .2F;
    }
}
