package com.otakusaikou.insideink.group;

import com.otakusaikou.insideink.registry.ItemRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class DefaultGroup extends ItemGroup {
    public static final DefaultGroup INSTANCE = new DefaultGroup("insideink_group");

    public DefaultGroup(String label) {
        super(label);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ItemRegistry.fireSpiritStone.get());
    }

    @Override
    public void fill(NonNullList<ItemStack> items) {
        //TODO: Need to fix item order.
        super.fill(items);
    }
}
