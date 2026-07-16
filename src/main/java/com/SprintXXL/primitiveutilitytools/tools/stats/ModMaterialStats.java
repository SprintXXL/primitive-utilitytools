package com.SprintXXL.primitiveutilitytools.tools.stats;

import com.SprintXXL.primitivematter.library.substances.definitions.ModSubstances;

import static com.SprintXXL.primitiveutilitytools.tools.stats.MaterialStatsRegistry.register;

public final class ModMaterialStats {

    private ModMaterialStats() {}

    // MAIN MATERIALS \\
    public static final MaterialStatsDefinition FLINT =
            new MaterialStatsDefinition(
                    ModSubstances.FLINT,
                    new MainMaterialStats(32)
            );

    public static final MaterialStatsDefinition IRON =
            new MaterialStatsDefinition(
                    ModSubstances.IRON,
                    new MainMaterialStats(64)
            );

    public static final MaterialStatsDefinition BRONZE =
            new MaterialStatsDefinition(
                    ModSubstances.BRONZE,
                    new MainMaterialStats(128)
            );





    // SUPPORT MATERIALS \\
    public static final MaterialStatsDefinition WOOD =
            new MaterialStatsDefinition(
                    ModSubstances.WOOD,
                    new SupportMaterialStats(1.0)
            );
    public static final MaterialStatsDefinition STONE =
            new MaterialStatsDefinition(
                    ModSubstances.STONE,
                    new SupportMaterialStats(1.0)
            );
    public static final MaterialStatsDefinition OBSIDIAN =
            new MaterialStatsDefinition(
                    ModSubstances.OBSIDIAN,
                    new SupportMaterialStats(3.0)
            );

    public static void registerMaterialStats() {

        register(FLINT);
        register(IRON);
        register(BRONZE);

        register(WOOD);
        register(STONE);
        register(OBSIDIAN);
    }
}
