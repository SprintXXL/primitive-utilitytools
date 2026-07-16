package com.SprintXXL.primitiveutilitytools.tools.tooltype;

import com.SprintXXL.primitivematter.library.substances.definitions.ModSubstances;

import java.util.Set;

import static com.SprintXXL.primitiveutilitytools.tools.tooltype.ToolTypeRegistry.register;

public final class ModToolTypes {

    private ModToolTypes() {}

    public static final ToolTypeDefinition HAMMER =
            new ToolTypeDefinition(
                    ToolType.HAMMER,
                    2,
                    new ValidMaterials(
                            Set.of(
                                    ModSubstances.IRON,
                                    ModSubstances.BRONZE
                            ),
                            Set.of(
                                    ModSubstances.WOOD,
                                    ModSubstances.OBSIDIAN
                            )
                    )
            );

    public static final ToolTypeDefinition MORTAR =
            new ToolTypeDefinition(
                    ToolType.MORTAR,
                    2,
                    new ValidMaterials(
                            Set.of(
                                    ModSubstances.FLINT,
                                    ModSubstances.IRON,
                                    ModSubstances.BRONZE
                            ),
                            Set.of(
                                    ModSubstances.STONE,
                                    ModSubstances.OBSIDIAN
                            )
                    )
            );

    public static final ToolTypeDefinition SAW =
            new ToolTypeDefinition(
                    ToolType.SAW,
                    2,
                    new ValidMaterials(
                            Set.of(
                                    ModSubstances.IRON,
                                    ModSubstances.BRONZE
                            ),
                            Set.of(
                                    ModSubstances.OBSIDIAN
                            )
                    )
            );

    public static final ToolTypeDefinition SCREWDRIVER =
            new ToolTypeDefinition(
                    ToolType.SCREWDRIVER,
                    2,
                    new ValidMaterials(
                            Set.of(
                                    ModSubstances.IRON,
                                    ModSubstances.BRONZE
                            ),
                            Set.of(
                                    ModSubstances.OBSIDIAN
                            )
                    )
            );
    public static final ToolTypeDefinition KNIFE =
            new ToolTypeDefinition(
                    ToolType.KNIFE,
                    2,
                    new ValidMaterials(
                            Set.of(
                                    ModSubstances.FLINT,
                                    ModSubstances.IRON,
                                    ModSubstances.BRONZE
                            ),
                            Set.of(
                                    ModSubstances.WOOD,
                                    ModSubstances.OBSIDIAN
                            )
                    )
            );
    public static final ToolTypeDefinition FILE =
            new ToolTypeDefinition(
                    ToolType.FILE,
                    2,
                    new ValidMaterials(
                            Set.of(
                                    ModSubstances.IRON,
                                    ModSubstances.BRONZE
                            ),
                            Set.of(
                                    ModSubstances.OBSIDIAN
                            )
                    )
            );

    public static final ToolTypeDefinition CROWBAR =
            new ToolTypeDefinition(
                    ToolType.CROWBAR,
                    2,
                    new ValidMaterials(
                            Set.of(
                                    ModSubstances.IRON,
                                    ModSubstances.BRONZE
                            ),
                            Set.of(
                                    ModSubstances.OBSIDIAN
                            )
                    )
            );

    public static final ToolTypeDefinition WRENCH =
            new ToolTypeDefinition(
                    ToolType.WRENCH,
                    2,
                    new ValidMaterials(
                            Set.of(
                                    ModSubstances.IRON,
                                    ModSubstances.BRONZE
                            ),
                            Set.of(
                                    ModSubstances.OBSIDIAN
                            )
                    )
            );

    public static void registerToolTypes() {

        register(HAMMER);
        register(MORTAR);
        register(SAW);
        register(SCREWDRIVER);
        register(KNIFE);
        register(FILE);
        register(CROWBAR);
        register(WRENCH);
    }
}
