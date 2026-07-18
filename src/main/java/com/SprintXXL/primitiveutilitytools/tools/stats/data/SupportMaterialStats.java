package com.SprintXXL.primitiveutilitytools.tools.stats.data;

public class SupportMaterialStats implements MaterialStatsData {

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
