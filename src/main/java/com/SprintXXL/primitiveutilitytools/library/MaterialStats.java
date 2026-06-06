package com.SprintXXL.primitiveutilitytools.library;

public class MaterialStats {

    private final int durability;
    private final double durabilityMultiplier;

    public MaterialStats(
            int durability,
            double durabilityMultiplier
    ) {
        this.durability = durability;
        this.durabilityMultiplier = durabilityMultiplier;
    }

    public int getDurability() {
        return durability;
    }

    public double getDurabilityMultiplier() {
        return durabilityMultiplier;
    }
}
