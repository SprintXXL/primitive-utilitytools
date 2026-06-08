package com.SprintXXL.primitiveutilitytools.tools.tooltype;

public class ToolTypeDefinition {

    private final ToolType toolType;
    private final int materialSlotCount;
    private final ValidMaterials validMaterials;

    public ToolTypeDefinition(
            ToolType toolType,
            int materialSlotCount,
            ValidMaterials validMaterials
    ) {
        this.toolType = toolType;
        this.materialSlotCount = materialSlotCount;
        this.validMaterials = validMaterials;
    }

    public ToolType getToolType() {
        return toolType;
    }

    public int getMaterialSlotCount() {
        return materialSlotCount;
    }

    public ValidMaterials getValidMaterials() {
        return validMaterials;
    }
}
