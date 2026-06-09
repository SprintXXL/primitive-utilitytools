package com.SprintXXL.primitiveutilitytools.util;

import com.SprintXXL.primitivematerials.library.MaterialDefinition;
import com.SprintXXL.primitivematerials.library.MaterialRegistry;
import com.SprintXXL.primitivematerials.library.util.MaterialForm;
import com.SprintXXL.primitiveutilitytools.tools.tooltype.ToolType;
import com.SprintXXL.primitiveutilitytools.tools.tooltype.ToolTypeDefinition;
import com.SprintXXL.primitiveutilitytools.tools.tooltype.ToolTypeRegistry;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;

public final class RecipeHelper {

    private RecipeHelper() {}

    public static boolean matchesCraftMatrix(InventoryCrafting inv) {
        return inv.getWidth() == 3 && inv.getHeight() == 3;
    }

    public static boolean areSlotsEmpty(InventoryCrafting inv, int... slots) {

        for (int slot : slots) {
            if (!inv.getStackInSlot(slot).isEmpty()) {
                return false;
            }
        }

        return true;
    }

    public static MaterialDefinition getMaterial(InventoryCrafting inv, int slot, MaterialForm... forms) {

        ItemStack stack = inv.getStackInSlot(slot);

        if (stack.isEmpty()) {
            return null;
        }

        for (MaterialForm form : forms) {

            MaterialDefinition material = MaterialRegistry.getMaterialFromStack(stack, form);

            if (material != null) {
                return material;
            }
        }

        return null;
    }

    public static boolean isValidMaterials(ToolType toolType, MaterialDefinition mainMaterial, MaterialDefinition supportMaterial) {

        ToolTypeDefinition definition = ToolTypeRegistry.getToolType(toolType);

        if (!definition.getValidMaterials().isValidMainMaterial(mainMaterial.getID()) ||
                !definition.getValidMaterials().isValidSupportMaterial(supportMaterial.getID())) {
            return false;
        }

        return true;
    }
}
