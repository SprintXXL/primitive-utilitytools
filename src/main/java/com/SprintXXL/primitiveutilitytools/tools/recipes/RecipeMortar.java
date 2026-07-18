package com.SprintXXL.primitiveutilitytools.tools.recipes;

import com.SprintXXL.primitivematter.library.substances.Substance;
import com.SprintXXL.primitivematter.library.substances.states.solid.forms.basic.BasicForm;
import com.SprintXXL.primitiveutilitytools.tools.nbt.UtilityToolNBT;
import com.SprintXXL.primitiveutilitytools.tools.registry.ModItems;
import com.SprintXXL.primitiveutilitytools.tools.tooltype.ToolType;
import com.SprintXXL.primitiveutilitytools.tools.tooltype.definitions.ModToolTypes;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry;

import static com.SprintXXL.primitiveutilitytools.tools.stats.registry.MaterialStatsRegistry.hasStats;
import static com.SprintXXL.primitiveutilitytools.util.RecipeHelper.*;

public class RecipeMortar extends IForgeRegistryEntry.Impl<IRecipe> implements IRecipe {

    private static final int[] MAIN_SLOTS = {1, 4};
    private static final int[] SUPPORT_SLOTS = {3, 5, 6, 7, 8};

    private static final int[] EMPTY_SLOTS = {0, 2};

    private static final BasicForm[] MAIN_FORMS = {BasicForm.INGOT, BasicForm.SUBSTANCE_ITEM};
    private static final BasicForm SUPPORT_FORM = BasicForm.SUBSTANCE_BLOCK;

    private static final Item OUTPUT = ModItems.MORTAR;
    private static final ToolType TOOL_TYPE = ModToolTypes.MORTAR;

    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {

        if (!matchesCraftMatrix(inv)) {
            return false;
        }

        if (!areSlotsEmpty(inv, EMPTY_SLOTS)) {
            return false;
        }

        ItemStack mainStack = inv.getStackInSlot(MAIN_SLOTS[0]);
        ItemStack supportStack = inv.getStackInSlot(SUPPORT_SLOTS[0]);

        if (mainStack.isEmpty() || supportStack.isEmpty()) {
            return false;
        }

        Substance mainMaterial = getMaterial(inv, MAIN_SLOTS[0], MAIN_FORMS);
        Substance supportMaterial = getMaterial(inv, SUPPORT_SLOTS[0], SUPPORT_FORM);

        if (mainMaterial == null || supportMaterial == null) {
            return false;
        }

        if (!hasStats(mainMaterial.getID()) || !hasStats(supportMaterial.getID())) {
            return false;
        }

        if (!isValidMaterials(TOOL_TYPE, mainMaterial, supportMaterial)) {
            return false;
        }

        String expectedMainMaterial = mainMaterial.getID();
        String expectedSupportMaterial = supportMaterial.getID();

        for (int slot : MAIN_SLOTS) {

            Substance slotMaterial = getMaterial(inv, slot, MAIN_FORMS);

            if (slotMaterial == null) {
                return false;
            }

            if (!slotMaterial.getID().equals(expectedMainMaterial)) {
                return false;
            }
        }

        for (int slot : SUPPORT_SLOTS) {

            Substance slotMaterial = getMaterial(inv, slot, SUPPORT_FORM);

            if (slotMaterial == null) {
                return false;
            }

            if (!slotMaterial.getID().equals(expectedSupportMaterial)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {

        Substance mainMaterial = getMaterial(inv, MAIN_SLOTS[0], MAIN_FORMS);
        Substance supportMaterial = getMaterial(inv, SUPPORT_SLOTS[0], SUPPORT_FORM);

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
}
