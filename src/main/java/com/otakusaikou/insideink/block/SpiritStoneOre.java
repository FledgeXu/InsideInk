package com.otakusaikou.insideink.block;

import com.otakusaikou.insideink.block.blokcstate.SpiritTypeProperty;
import com.otakusaikou.insideink.spirit.SpiritType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateContainer;

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
}
