package com.SprintXXL.primitiveutilitytools.tools.tooltype;

import com.SprintXXL.primitiveutilitytools.tools.tooltype.shared.ValidMaterials;
import com.sprintxxl.ascenthub.definitions.AscentDefinition;

public class ToolType implements AscentDefinition {

    private final String id;
    private final int materialSlotCount;
    private final ValidMaterials validMaterials;

    public ToolType(
            String id,
            int materialSlotCount,
            ValidMaterials validMaterials
    ) {
        this.id = id;
        this.materialSlotCount = materialSlotCount;
        this.validMaterials = validMaterials;
    }

    @Override
    public String getID() {
        return id;
    }

    public int getMaterialSlotCount() {
        return materialSlotCount;
    }

    public ValidMaterials getValidMaterials() {
        return validMaterials;
    }
}
