package com.SprintXXL.primitiveutilitytools.library;

import com.SprintXXL.primitivematerials.library.MaterialRegistry;
import com.SprintXXL.primitivematerials.library.util.MaterialForm;

public final class ModMaterials {

    private ModMaterials() {}

    public static final MaterialDefinition IRON =
            new MaterialDefinition(
                    MaterialIDs.IRON,
                    MaterialRegistry.getItem(MaterialForm.INGOT, com.SprintXXL.primitivematerials.library.ModMaterials.IRON),
                    new MaterialStats(
                            64,
                            1.0
                    )
            );
}
