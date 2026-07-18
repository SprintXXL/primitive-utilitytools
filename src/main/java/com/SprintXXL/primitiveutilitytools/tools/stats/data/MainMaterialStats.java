package com.SprintXXL.primitiveutilitytools.tools.stats.data;

public class MainMaterialStats implements MaterialStatsData {

    private final int durability;

    public MainMaterialStats(
            int durability
    ) {
        this.durability = durability;
    }

    public int getDurability() {
        return durability;
    }
}
