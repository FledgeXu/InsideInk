package com.otakusaikou.insideink.spirit;

import net.minecraft.util.IStringSerializable;

import java.awt.*;

public enum SpiritType implements IStringSerializable {
    METAL("metal", new Color(0xe6f542)),
    WOODEN("wooden", new Color(0x1E8739)),
    WATER("water", new Color(0x2D6BC7)),
    FIRE("fire", new Color(0xBF2E2E)),
    EARTH("earth", new Color(0x553708));
    private final String name;
    private Color color;

    SpiritType(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public Color getColor() {
        return color;
    }
}
