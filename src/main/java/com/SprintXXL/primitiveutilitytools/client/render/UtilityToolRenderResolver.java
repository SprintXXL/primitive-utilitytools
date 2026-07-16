package com.SprintXXL.primitiveutilitytools.client.render;

import com.SprintXXL.primitiveutilitytools.tools.items.UtilityToolBase;
import com.SprintXXL.primitiveutilitytools.tools.nbt.UtilityToolNBT;
import com.SprintXXL.primitiveutilitytools.tools.tooltype.ToolType;
import com.SprintXXL.primitiveutilitytools.tools.tooltype.ToolTypeDefinition;
import com.SprintXXL.primitiveutilitytools.tools.tooltype.ToolTypeRegistry;
import net.minecraft.item.ItemStack;

public class UtilityToolRenderResolver {

    public static UtilityToolRenderData resolve(ItemStack stack) {

        ToolType toolType = UtilityToolNBT.getToolType(stack);

        if (toolType == ToolType.UNKNOWN && stack.getItem() instanceof UtilityToolBase tool) {
            toolType = tool.getToolType();
        }

        ToolTypeDefinition definition = ToolTypeRegistry.getToolType(toolType);

        String mainMaterial = UtilityToolNBT.getMainMaterial(stack);
        String supportMaterial = UtilityToolNBT.getSupportMaterial(stack);

        int materialSlotCount = 1;

        if (definition != null) {

            materialSlotCount = definition.getMaterialSlotCount();

            if ("unknown".equals(mainMaterial)) {
                mainMaterial = definition.getValidMaterials()
                        .getMainMaterials()
                        .iterator()
                        .next()
                        .toString();
            }

            if (materialSlotCount >= 2 && "unknown".equals(supportMaterial)) {
                supportMaterial = definition.getValidMaterials()
                        .getSupportMaterials()
                        .iterator()
                        .next()
                        .toString();;
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
