package com.SprintXXL.primitiveutilitytools.tools.stats;

import com.SprintXXL.ascentmatter.library.substances.Substance;
import com.SprintXXL.primitiveutilitytools.tools.stats.data.MaterialStatsData;
import com.sprintxxl.ascenthub.definitions.AscentDefinition;

public class MaterialStats implements AscentDefinition {

    private final Substance id;
    private final MaterialStatsData data;

    public MaterialStats(
            Substance id,
            MaterialStatsData data
    ) {
        this.id = id;
        this.data = data;
    }

    @Override
    public String getID() {
        return id.getID();
    }

    public Substance getSubstance() {
        return id;
    }

    public MaterialStatsData getData() {
        return data;
    }
}
