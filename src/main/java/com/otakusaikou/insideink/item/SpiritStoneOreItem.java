package com.otakusaikou.insideink.item;

import com.otakusaikou.insideink.spirit.SpiritType;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

public class SpiritStoneOreItem extends BlockItem {
    private final SpiritType type;

    public SpiritStoneOreItem(Block blockIn, Properties builder, SpiritType type) {
        super(blockIn, builder);
        this.type = type;
    }

    public SpiritType getType() {
        return type;
    }
}
