package com.SprintXXL.primitiveutilitytools.client.render;

import net.minecraft.util.ResourceLocation;

public class UtilityToolTextureResolver {

    public static ResourceLocation getUtilityToolTexture(UtilityToolRenderData data, String layerType) {

        return new ResourceLocation(
                "primitiveutilitytools",
                "generated/" + data.toolType + "_" + layerType + "_" + getMaterialID(data, layerType)
        );
    }

    private static String getMaterialID(UtilityToolRenderData data, String layerType) {

        if ("primary".equals(layerType)) {
            return data.primaryMaterial;
        }

        if ("secondary".equals(layerType)) {
            return data.secondaryMaterial;
        }

        return "unknown";
    }
}
