package com.otakusaikou.insideink.block.blokcstate;

import com.google.common.collect.Lists;
import com.otakusaikou.insideink.spirit.SpiritType;
import net.minecraft.state.EnumProperty;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SpiritTypeProperty extends EnumProperty<SpiritType> {
    protected SpiritTypeProperty(String name, Collection<SpiritType> allowedValues) {
        super(name, SpiritType.class, allowedValues);
    }

    public static SpiritTypeProperty create(String name, Predicate<SpiritType> filter) {
        return create(name, Arrays.stream(SpiritType.values()).filter(filter).collect(Collectors.toList()));
    }

    public static SpiritTypeProperty create(String name, SpiritType... types) {
        return create(name, Lists.newArrayList(types));
    }

    public static SpiritTypeProperty create(String name, Collection<SpiritType> values) {
        return new SpiritTypeProperty(name, values);
    }
}
