package com.SprintXXL.primitiveutilitytools.library;

import java.util.HashMap;
import java.util.Map;

public final class MaterialStatsRegistry {

    private MaterialStatsRegistry() {}

    private static final Map<String, MaterialStats> STATS =
    new HashMap<>();

    public static void register(String materialID, MaterialStats stats) {
        STATS.put(materialID, stats);
    }

    public static MaterialStats getStats(String materialID) {
        return STATS.get(materialID);
    }

    public static boolean hasStats(String materialID) {
        return STATS.containsKey(materialID);
    }

    public static void init() {

        ModMaterialStats.init();
    }
}
