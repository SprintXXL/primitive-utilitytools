package com.SprintXXL.primitiveutilitytools.tools.stats;

import com.SprintXXL.primitivematter.library.substances.Substance;

public class MaterialStatsDefinition {

    private final Substance id;
    private final MaterialStats stats;

    public MaterialStatsDefinition(
            Substance id,
            MaterialStats stats
    ) {
        this.id = id;
        this.stats = stats;
    }

    public Substance getID() {
        return id;
    }

    public MaterialStats getStats() {
        return stats;
    }
}
