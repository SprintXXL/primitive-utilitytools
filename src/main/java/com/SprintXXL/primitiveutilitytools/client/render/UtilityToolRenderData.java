package com.SprintXXL.primitiveutilitytools.client.render;

public class UtilityToolRenderData {

    public final String toolType;
    public final String primaryMaterial;
    public final String secondaryMaterial;

    public UtilityToolRenderData(
            String toolType,
            String primaryMaterial,
            String secondaryMaterial
    ) {
        this.toolType = toolType;
        this.primaryMaterial = primaryMaterial;
        this.secondaryMaterial = secondaryMaterial;
    }
}
