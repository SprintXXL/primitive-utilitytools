package com.SprintXXL.primitiveutilitytools.tools.recipes;

import com.SprintXXL.primitivematter.library.substances.Substance;
import com.SprintXXL.primitivematter.library.substances.states.solid.forms.basic.BasicForm;
import com.SprintXXL.primitivematter.library.substances.states.solid.forms.industrial.IndustrialForm;
import com.SprintXXL.primitiveutilitytools.tools.nbt.UtilityToolNBT;
import com.SprintXXL.primitiveutilitytools.tools.registry.ModItems;
import com.SprintXXL.primitiveutilitytools.tools.tooltype.ToolType;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry;

import static com.SprintXXL.primitiveutilitytools.tools.stats.MaterialStatsRegistry.hasStats;
import static com.SprintXXL.primitiveutilitytools.util.RecipeHelper.*;

public class RecipeHammer extends IForgeRegistryEntry.Impl<IRecipe> implements IRecipe {

    private static final int[] MAIN_SLOTS = {0, 1, 2, 3, 4, 5};
    private static final int SUPPORT_SLOT = 7;

    private static final int[] EMPTY_SLOTS = {6, 8};

    private static final BasicForm MAIN_FORM = BasicForm.INGOT;
    private static final IndustrialForm SUPPORT_FORM = IndustrialForm.ROD;

    private static final Item OUTPUT = ModItems.HAMMER;
    private static final ToolType TOOL_TYPE = ToolType.HAMMER;

    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {

        if (!matchesCraftMatrix(inv)) {
            return false;
        }

        if (!areSlotsEmpty(inv, EMPTY_SLOTS)) {
            return false;
        }

        ItemStack supportStack = getSupportStack(inv);
        ItemStack mainStack = inv.getStackInSlot(MAIN_SLOTS[0]); // First Main Slot

        if (supportStack.isEmpty() || mainStack.isEmpty()) {
            return false;
        }

        Substance mainMaterial = getMaterial(inv, MAIN_SLOTS[0], MAIN_FORM);
        Substance supportMaterial = getMaterial(inv, SUPPORT_SLOT, SUPPORT_FORM);

        if (mainMaterial == null || supportMaterial == null) {
            return false;
        }

        if (!hasStats(mainMaterial.getID()) || !hasStats(supportMaterial.getID())) {
            return false;
        }

        if (!isValidMaterials(TOOL_TYPE, mainMaterial, supportMaterial)) {
            return false;
        }

        String expectedMaterial = mainMaterial.getID();

        for (int slot : MAIN_SLOTS) {

            Substance slotMaterial = getMaterial(inv, slot, MAIN_FORM);

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

        Substance mainMaterial = getMaterial(inv, MAIN_SLOTS[0], MAIN_FORM);
        Substance supportMaterial = getMaterial(inv, SUPPORT_SLOT, SUPPORT_FORM);

        if (mainMaterial == null || supportMaterial == null) {
            return ItemStack.EMPTY;
        }

        ItemStack result = new ItemStack(OUTPUT);

        UtilityToolNBT.setToolType(result, TOOL_TYPE);
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
        return new ItemStack(OUTPUT);
    }

    private static ItemStack getSupportStack(InventoryCrafting inv) {
        return inv.getStackInSlot(SUPPORT_SLOT);
    }
}
