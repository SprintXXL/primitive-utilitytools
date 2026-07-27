package com.SprintXXL.primitiveutilitytools.tools.tooltype.definitions;

import com.SprintXXL.ascentmatter.library.substances.definitions.ModSubstances;
import com.SprintXXL.primitiveutilitytools.tools.tooltype.ToolType;
import com.SprintXXL.primitiveutilitytools.tools.tooltype.shared.ValidMaterials;
import com.sprintxxl.ascenthub.definitions.DefinitionRegistrar;

import java.util.Set;

public final class ModToolTypes {

    private ModToolTypes() {}

    public static void initToolTypeDefinitions(DefinitionRegistrar<ToolType> registrar) {

        registrar.register(HAMMER);
        registrar.register(MORTAR);
        registrar.register(SAW);
        registrar.register(SCREWDRIVER);
        registrar.register(KNIFE);
        registrar.register(FILE);
        registrar.register(CROWBAR);
        registrar.register(WRENCH);
    }

    public static final ToolType HAMMER =
            new ToolType(
                    ToolTypeIDs.HAMMER,
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

    public static final ToolType MORTAR =
            new ToolType(
                    ToolTypeIDs.MORTAR,
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

    public static final ToolType SAW =
            new ToolType(
                    ToolTypeIDs.SAW,
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

    public static final ToolType SCREWDRIVER =
            new ToolType(
                    ToolTypeIDs.SCREWDRIVER,
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
    public static final ToolType KNIFE =
            new ToolType(
                    ToolTypeIDs.KNIFE,
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
    public static final ToolType FILE =
            new ToolType(
                    ToolTypeIDs.FILE,
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

    public static final ToolType CROWBAR =
            new ToolType(
                    ToolTypeIDs.CROWBAR,
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

    public static final ToolType WRENCH =
            new ToolType(
                    ToolTypeIDs.WRENCH,
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
}
