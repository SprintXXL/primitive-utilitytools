package com.SprintXXL.primitiveutilitytools.tools.stats;

public class MainMaterialStats implements MaterialStats {

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
