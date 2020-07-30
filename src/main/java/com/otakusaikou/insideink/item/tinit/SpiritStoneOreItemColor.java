package com.otakusaikou.insideink.item.tinit;

import com.otakusaikou.insideink.item.SpiritStoneOreItem;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SpiritStoneOreItemColor implements IItemColor {
    @Override
    public int getColor(ItemStack stack, int tint) {
        Item item = stack.getItem();
        if (item instanceof SpiritStoneOreItem) {
            return ((SpiritStoneOreItem) item).getType().getColor().getRGB();
        }
        return 0;
    }
}
