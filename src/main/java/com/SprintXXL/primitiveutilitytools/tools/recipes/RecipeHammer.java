package com.SprintXXL.primitiveutilitytools.tools.recipes;

import com.SprintXXL.primitiveutilitytools.library.MaterialDefinition;
import com.SprintXXL.primitiveutilitytools.library.MaterialRegistry;
import com.SprintXXL.primitiveutilitytools.util.RecipeHelper;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class RecipeHammer extends IForgeRegistryEntry.Impl<IRecipe> implements IRecipe {

    private static final int[] INGOT_SLOTS = {0, 1, 2, 3, 4, 5};
    private static final int HANDLE_SLOT = 7;

    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {

        if (!RecipeHelper.matchesCraftMatrix(inv)) {
            return false;
        }

        if (!areAllOtherSlotsEmpty(inv)) {
            return false;
        }

        ItemStack handleStack = getHandleStack(inv);
        ItemStack ingotStack = inv.getStackInSlot(0); // First Ingot Slot

        if (handleStack.isEmpty() || ingotStack.isEmpty()) {
            return false;
        }

        MaterialDefinition material = MaterialRegistry.getMaterialFromStack(ingotStack);

        if (material == null) {
            return false;
        }

        String expectedMaterial = material.getID();

        for (int slot : INGOT_SLOTS) {

            ItemStack stack = inv.getStackInSlot(slot);

            if (stack.isEmpty()) {
                return false;
            }

            MaterialDefinition slotMaterial = MaterialRegistry.getMaterialFromStack(stack);

            if (slotMaterial == null) {
                return false;
            }

            if (!slotMaterial.getID().equals(expectedMaterial)) {
                return false;
            }
        }


        return true;
    }

    private static ItemStack getHandleStack(InventoryCrafting inv) {
        return inv.getStackInSlot(HANDLE_SLOT);
    }

    private boolean areAllOtherSlotsEmpty(InventoryCrafting inv) {

        for(int i = 0; i < inv.getSizeInventory(); i++) {
            if (i == 6 || i == 8) {
                if (!inv.getStackInSlot(i).isEmpty()) {
                    return false;
                }
            }
        }

        return true;
    }
}
