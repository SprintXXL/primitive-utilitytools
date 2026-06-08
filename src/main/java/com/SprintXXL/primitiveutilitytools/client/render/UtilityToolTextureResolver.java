package com.SprintXXL.primitiveutilitytools.client.render;

import net.minecraft.util.ResourceLocation;

public class UtilityToolTextureResolver {

    public static ResourceLocation getUtilityToolTexture(UtilityToolRenderData data, String layerType) {

        return new ResourceLocation(
                "primitiveutilitytools",
                "generated/" + data.toolType.name().toLowerCase() + "_" + layerType + "_" + getMaterialID(data, layerType)
        );
    }

    private static String getMaterialID(UtilityToolRenderData data, String layerType) {

        if ("main".equals(layerType)) {
            return data.mainMaterial;
        }

        if ("support".equals(layerType)) {
            return data.supportMaterial;
        }

        return "unknown";
    }
}
