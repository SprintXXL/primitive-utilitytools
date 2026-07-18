package com.SprintXXL.primitiveutilitytools.client.render;

public class UtilityToolRenderData {

    public final String toolType;
    public final int materialSlotCount;
    public final String mainMaterial;
    public final String supportMaterial;

    public UtilityToolRenderData(
            String toolType,
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
