package com.SprintXXL.primitiveutilitytools.client.render;

import com.SprintXXL.primitiveutilitytools.tools.tooltype.ToolType;

public class UtilityToolRenderData {

    public final ToolType toolType;
    public final int materialSlotCount;
    public final String mainMaterial;
    public final String supportMaterial;

    public UtilityToolRenderData(
            ToolType toolType,
            int materialSlotCount,
            String mainMaterial,
            String supportMaterial
    ) {
        this.toolType = toolType;
        this.materialSlotCount = materialSlotCount;
        this.mainMaterial = mainMaterial;
        this.supportMaterial = supportMaterial;
    }
}
