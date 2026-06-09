package com.SprintXXL.primitiveutilitytools.tools.stats;

import com.SprintXXL.primitivematerials.library.MaterialIDs;

import static com.SprintXXL.primitiveutilitytools.tools.stats.MaterialStatsRegistry.register;

public final class ModMaterialStats {

    private ModMaterialStats() {}

    // MAIN MATERIALS \\
    public static final MaterialStatsDefinition FLINT =
            new MaterialStatsDefinition(
                    MaterialIDs.FLINT,
                    new MainMaterialStats(32)
            );

    public static final MaterialStatsDefinition IRON =
            new MaterialStatsDefinition(
                    MaterialIDs.IRON,
                    new MainMaterialStats(64)
            );

    public static final MaterialStatsDefinition BRONZE =
            new MaterialStatsDefinition(
                    MaterialIDs.BRONZE,
                    new MainMaterialStats(128)
            );





    // SUPPORT MATERIALS \\
    public static final MaterialStatsDefinition WOOD =
            new MaterialStatsDefinition(
                    MaterialIDs.WOOD,
                    new SupportMaterialStats(1.0)
            );
    public static final MaterialStatsDefinition STONE =
            new MaterialStatsDefinition(
                    MaterialIDs.STONE,
                    new SupportMaterialStats(1.0)
            );
    public static final MaterialStatsDefinition OBSIDIAN =
            new MaterialStatsDefinition(
                    MaterialIDs.OBSIDIAN,
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
