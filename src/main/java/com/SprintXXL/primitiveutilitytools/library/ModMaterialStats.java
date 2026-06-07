package com.SprintXXL.primitiveutilitytools.library;

import com.SprintXXL.primitivematerials.library.MaterialIDs;

public final class ModMaterialStats {

    private ModMaterialStats() {}

    public static void init() {

        MaterialStatsRegistry.register(
                MaterialIDs.IRON,
                new MaterialStats(128, 1.1)
        );
        MaterialStatsRegistry.register(
                MaterialIDs.WOOD,
                new MaterialStats(0, 1.0)
        );
    }
}
