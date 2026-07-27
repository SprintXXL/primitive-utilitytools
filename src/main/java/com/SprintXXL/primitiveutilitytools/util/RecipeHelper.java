package com.SprintXXL.primitiveutilitytools.util;

import com.SprintXXL.ascentmatter.library.substances.Substance;
import com.SprintXXL.ascentmatter.library.substances.states.solid.forms.SolidForm;
import com.SprintXXL.primitiveutilitytools.tools.tooltype.ToolType;
import com.SprintXXL.primitiveutilitytools.tools.tooltype.registry.ToolTypeRegistry;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;

import static com.SprintXXL.ascentmatter.library.substances.registry.SubstanceRegistry.getSubstanceFromItem;

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

    public static Substance getMaterial(InventoryCrafting inv, int slot, SolidForm... forms) {

        ItemStack stack = inv.getStackInSlot(slot);

        for (SolidForm form : forms) {

            Substance substance = getSubstanceFromItem(stack, form);

            if (substance != null) {
                return substance;
            }
        }

        return null;
    }

    public static boolean isValidMaterials(ToolType toolType, Substance mainMaterial, Substance supportMaterial) {

        ToolType definition = ToolTypeRegistry.getToolType(toolType.getID());

        if (!definition.getValidMaterials().isValidMainMaterial(mainMaterial) ||
                !definition.getValidMaterials().isValidSupportMaterial(supportMaterial)) {
            return false;
        }

        return true;
    }
}
