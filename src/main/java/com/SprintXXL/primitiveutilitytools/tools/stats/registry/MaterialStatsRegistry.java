package com.SprintXXL.primitiveutilitytools.tools.stats.registry;

import com.SprintXXL.primitiveutilitytools.tools.stats.MaterialStats;
import com.SprintXXL.primitiveutilitytools.tools.stats.data.MaterialStatsData;

import java.util.HashMap;
import java.util.Map;

import static com.SprintXXL.primitiveutilitytools.tools.stats.definitions.ModMaterialStats.initMaterialStatsDefinitions;

public final class MaterialStatsRegistry {

    private MaterialStatsRegistry() {}

    private static final Map<String, MaterialStats> STATS =
    new HashMap<>();

    public static void register(MaterialStats stats) {
        STATS.put(stats.getID(), stats);
    }

    public static MaterialStatsData getData(String materialID) {

        MaterialStats definition = STATS.get(materialID);

        if (definition == null) {
            throw new IllegalStateException(
                    "No material stats registered for: " + materialID
            );
        }

        return definition.getData();
    }

    public static boolean hasStats(String materialID) {
        return STATS.containsKey(materialID);
    }

    public static void initMaterialStatsRegistry() {

        initMaterialStatsDefinitions(MaterialStatsRegistry::register);
    }
}
