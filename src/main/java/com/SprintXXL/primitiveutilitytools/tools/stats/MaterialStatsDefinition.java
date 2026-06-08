package com.SprintXXL.primitiveutilitytools.tools.stats;

public class MaterialStatsDefinition {

    private final String id;
    private final MaterialStats stats;

    public MaterialStatsDefinition(
            String id,
            MaterialStats stats
    ) {
        this.id = id;
        this.stats = stats;
    }

    public String getID() {
        return id;
    }

    public MaterialStats getStats() {
        return stats;
    }
}
