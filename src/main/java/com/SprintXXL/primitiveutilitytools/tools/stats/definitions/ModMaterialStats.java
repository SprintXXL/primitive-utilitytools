package com.SprintXXL.primitiveutilitytools.tools.stats.definitions;

import com.SprintXXL.ascentmatter.library.substances.definitions.ModSubstances;
import com.SprintXXL.primitiveutilitytools.tools.stats.MaterialStats;
import com.SprintXXL.primitiveutilitytools.tools.stats.data.MainMaterialStats;
import com.SprintXXL.primitiveutilitytools.tools.stats.data.SupportMaterialStats;
import com.sprintxxl.ascenthub.definitions.DefinitionRegistrar;

public final class ModMaterialStats {

    private ModMaterialStats() {}

    public static void initMaterialStatsDefinitions(DefinitionRegistrar<MaterialStats> registrar) {

        registrar.register(FLINT);
        registrar.register(IRON);
        registrar.register(BRONZE);
        registrar.register(WOOD);
        registrar.register(STONE);
        registrar.register(OBSIDIAN);
    }

    // MAIN MATERIALS \\
    public static final MaterialStats FLINT =
            new MaterialStats(
                    ModSubstances.FLINT,
                    new MainMaterialStats(32)
            );

    public static final MaterialStats IRON =
            new MaterialStats(
                    ModSubstances.IRON,
                    new MainMaterialStats(64)
            );

    public static final MaterialStats BRONZE =
            new MaterialStats(
                    ModSubstances.BRONZE,
                    new MainMaterialStats(128)
            );

    // SUPPORT MATERIALS \\
    public static final MaterialStats WOOD =
            new MaterialStats(
                    ModSubstances.WOOD,
                    new SupportMaterialStats(1.0)
            );
    public static final MaterialStats STONE =
            new MaterialStats(
                    ModSubstances.STONE,
                    new SupportMaterialStats(1.0)
            );
    public static final MaterialStats OBSIDIAN =
            new MaterialStats(
                    ModSubstances.OBSIDIAN,
                    new SupportMaterialStats(3.0)
            );
}
