package com.SprintXXL.primitiveutilitytools.library;

public class MaterialDefinition {

    private final String id;
    private final MaterialStats stats;

    public MaterialDefinition(
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
