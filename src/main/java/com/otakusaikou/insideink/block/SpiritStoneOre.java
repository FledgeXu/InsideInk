package com.otakusaikou.insideink.block;

import com.otakusaikou.insideink.block.blokcstate.SpiritTypeProperty;
import com.otakusaikou.insideink.spirit.SpiritType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class SpiritStoneOre extends Block {
    public static SpiritTypeProperty TYPE = SpiritTypeProperty.create("type", SpiritType.values());

    public SpiritStoneOre(Properties properties, SpiritType type) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(TYPE, type));
        this.setDefaultState(this.stateContainer.getBaseState().with(BlockStateProperties.FACING, Direction.DOWN));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(TYPE);
        builder.add(BlockStateProperties.FACING);
        super.fillStateContainer(builder);
    }

    public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
        return true;
    }

    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return .2F;
    }
}
