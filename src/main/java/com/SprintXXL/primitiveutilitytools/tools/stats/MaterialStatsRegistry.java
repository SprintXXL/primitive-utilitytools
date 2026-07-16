package com.SprintXXL.primitiveutilitytools.tools.stats;

import java.util.HashMap;
import java.util.Map;

public final class MaterialStatsRegistry {

    private MaterialStatsRegistry() {}

    private static final Map<String, MaterialStatsDefinition> STATS =
    new HashMap<>();

    public static void register(MaterialStatsDefinition stats) {
        STATS.put(stats.getID().getID(), stats);
    }

    public static MaterialStats getStats(String materialID) {

        MaterialStatsDefinition definition = STATS.get(materialID);

        if (definition == null) {
            throw new IllegalStateException(
                    "No material stats registered for: " + materialID
            );
        }

        return definition.getStats();
    }

    public static boolean hasStats(String materialID) {
        return STATS.containsKey(materialID);
    }

    public static void init() {

        ModMaterialStats.registerMaterialStats();
    }
}
