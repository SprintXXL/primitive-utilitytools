package com.SprintXXL.primitiveutilitytools.tools.stats;

public class SupportMaterialStats implements MaterialStats {

    private final double durabilityMultiplier;

    public SupportMaterialStats(
            double durabilityMultiplier
    ) {
        this.durabilityMultiplier = durabilityMultiplier;
    }

    public double getDurabilityMultiplier() {
        return durabilityMultiplier;
    }
}
