package com.SprintXXL.primitiveutilitytools.tools.recipes;

import com.SprintXXL.primitivematerials.library.MaterialDefinition;
import com.SprintXXL.primitivematerials.library.MaterialRegistry;
import com.SprintXXL.primitivematerials.library.util.MaterialForm;
import com.SprintXXL.primitiveutilitytools.tools.stats.MaterialStatsRegistry;
import com.SprintXXL.primitiveutilitytools.tools.nbt.UtilityToolNBT;
import com.SprintXXL.primitiveutilitytools.tools.registry.ModItems;
import com.SprintXXL.primitiveutilitytools.tools.tooltype.ToolType;
import com.SprintXXL.primitiveutilitytools.util.RecipeHelper;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class RecipeHammer extends IForgeRegistryEntry.Impl<IRecipe> implements IRecipe {

    private static final int[] MAIN_SLOTS = {0, 1, 2, 3, 4, 5};
    private static final int SUPPORT_SLOT = 7;

    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {

        if (!RecipeHelper.matchesCraftMatrix(inv)) {
            return false;
        }

        if (!areAllOtherSlotsEmpty(inv)) {
            return false;
        }

        ItemStack supportStack = getSupportStack(inv);
        ItemStack mainStack = inv.getStackInSlot(0); // First Main Slot

        if (supportStack.isEmpty() || mainStack.isEmpty()) {
            return false;
        }

        MaterialDefinition mainMaterial = getMainMaterial(inv);
        MaterialDefinition supportMaterial = getSupportMaterial(inv);

        if (mainMaterial == null || supportMaterial == null) {
            return false;
        }

        if (!MaterialStatsRegistry.hasStats(mainMaterial.getID()) || !MaterialStatsRegistry.hasStats(supportMaterial.getID())) {
            return false;
        }

        String expectedMaterial = mainMaterial.getID();

        for (int slot : MAIN_SLOTS) {

            ItemStack stack = inv.getStackInSlot(slot);

            if (stack.isEmpty()) {
                return false;
            }

            MaterialDefinition slotMaterial = MaterialRegistry.getMaterialFromStack(stack, MaterialForm.INGOT);

            if (slotMaterial == null) {
                return false;
            }

            if (!slotMaterial.getID().equals(expectedMaterial)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {

        MaterialDefinition mainMaterial = getMainMaterial(inv);
        MaterialDefinition supportMaterial = getSupportMaterial(inv);

        if (mainMaterial == null || supportMaterial == null) {
            return ItemStack.EMPTY;
        }

        ItemStack result = new ItemStack(ModItems.HAMMER);

        UtilityToolNBT.setToolType(result, ToolType.HAMMER);
        UtilityToolNBT.setMainMaterial(result, mainMaterial.getID());
        UtilityToolNBT.setSupportMaterial(result, supportMaterial.getID());

        return result;
    }

    @Override
    public boolean canFit(int width, int height) {
        return width >= 3 && height >= 3;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return new ItemStack(ModItems.HAMMER);
    }

    private static ItemStack getSupportStack(InventoryCrafting inv) {
        return inv.getStackInSlot(SUPPORT_SLOT);
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

    private MaterialDefinition getMainMaterial(InventoryCrafting inv) {

        ItemStack mainStack = inv.getStackInSlot(MAIN_SLOTS[0]);

        return MaterialRegistry.getMaterialFromStack(mainStack, MaterialForm.INGOT);
    }

    private MaterialDefinition getSupportMaterial(InventoryCrafting inv) {

        ItemStack supportStack = inv.getStackInSlot(SUPPORT_SLOT);

        return MaterialRegistry.getMaterialFromStack(supportStack, MaterialForm.ROD);
    }
}
