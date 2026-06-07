package com.SprintXXL.primitiveutilitytools.client.render;

import com.SprintXXL.primitiveutilitytools.tools.nbt.UtilityToolNBT;
import net.minecraft.item.ItemStack;

public class UtilityToolRenderResolver {

    public static UtilityToolRenderData resolve(ItemStack stack) {

        return new UtilityToolRenderData(
                UtilityToolNBT.getToolType(stack),
                UtilityToolNBT.getMainMaterial(stack),
                UtilityToolNBT.getHandleMaterial(stack)
        );
    }
}
