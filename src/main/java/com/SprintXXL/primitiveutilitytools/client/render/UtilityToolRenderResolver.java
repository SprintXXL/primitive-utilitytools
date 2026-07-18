package com.SprintXXL.primitiveutilitytools.client.render;

import com.SprintXXL.primitiveutilitytools.tools.nbt.UtilityToolNBT;
import com.SprintXXL.primitiveutilitytools.tools.tooltype.ToolType;
import com.SprintXXL.primitiveutilitytools.tools.tooltype.registry.ToolTypeRegistry;
import net.minecraft.item.ItemStack;

public class UtilityToolRenderResolver {

    public static UtilityToolRenderData resolve(ItemStack stack) {

        String toolType = UtilityToolNBT.getToolType(stack);

        ToolType definition = ToolTypeRegistry.getToolType(toolType);

        String mainMaterial = UtilityToolNBT.getMainMaterial(stack);
        String supportMaterial = UtilityToolNBT.getSupportMaterial(stack);

        System.out.println(
                "Render toolType=" + toolType
                        + ", definition=" + definition
                        + ", main=" + mainMaterial
                        + ", support=" + supportMaterial
        );

        int materialSlotCount = 1;

        if (definition != null) {

            materialSlotCount = definition.getMaterialSlotCount();

            if ("unknown".equals(mainMaterial)) {
                mainMaterial = definition.getValidMaterials()
                        .getMainMaterials()
                        .iterator()
                        .next()
                        .getID();
            }

            if (materialSlotCount >= 2 && "unknown".equals(supportMaterial)) {
                supportMaterial = definition.getValidMaterials()
                        .getSupportMaterials()
                        .iterator()
                        .next()
                        .getID();;
            }
        }

        return new UtilityToolRenderData(
                toolType,
                materialSlotCount,
                mainMaterial,
                supportMaterial
        );
    }
}
