package com.SprintXXL.primitiveutilitytools.tools.recipes;

import com.SprintXXL.primitivematerials.library.MaterialDefinition;
import com.SprintXXL.primitivematerials.library.util.MaterialForm;
import com.SprintXXL.primitiveutilitytools.tools.nbt.UtilityToolNBT;
import com.SprintXXL.primitiveutilitytools.tools.registry.ModItems;
import com.SprintXXL.primitiveutilitytools.tools.tooltype.ToolType;
import com.SprintXXL.primitiveutilitytools.util.RecipeHelper;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry;

import static com.SprintXXL.primitiveutilitytools.tools.stats.MaterialStatsRegistry.hasStats;
import static com.SprintXXL.primitiveutilitytools.util.RecipeHelper.getMaterial;
import static com.SprintXXL.primitiveutilitytools.util.RecipeHelper.isValidMaterials;

public class RecipeKnife extends IForgeRegistryEntry.Impl<IRecipe> implements IRecipe {

    private static final int MAIN_SLOT = 4;
    private static final int SUPPORT_SLOT = 7;

    private static final int[] EMPTY_SLOTS = {0, 1, 2, 3, 5, 6, 8};

    private static final MaterialForm MAIN_FORM = MaterialForm.INGOT;
    private static final MaterialForm SUPPORT_FORM = MaterialForm.ROD;

    private static final Item OUTPUT = ModItems.KNIFE;
    private static final ToolType TOOL_TYPE = ToolType.KNIFE;

    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {

        if (!RecipeHelper.matchesCraftMatrix(inv)) {
            return false;
        }

        if (!RecipeHelper.areSlotsEmpty(inv, EMPTY_SLOTS)) {
            return false;
        }

        ItemStack mainStack = getMainStack(inv);
        ItemStack supportStack = getSupportStack(inv);

        if (mainStack.isEmpty() || supportStack.isEmpty()) {
            return false;
        }

        MaterialDefinition mainMaterial = getMaterial(inv, MAIN_SLOT, MAIN_FORM);
        MaterialDefinition supportMaterial = getMaterial(inv, SUPPORT_SLOT, SUPPORT_FORM);

        if (mainMaterial == null) {
            mainMaterial = getMaterial(inv, MAIN_SLOT, MaterialForm.ITEM);
        }

        if (mainMaterial == null || supportMaterial == null) {
            return false;
        }

        if (!hasStats(mainMaterial.getID()) || !hasStats(supportMaterial.getID())) {
            return false;
        }

        if (!isValidMaterials(TOOL_TYPE, mainMaterial, supportMaterial)) {
            return false;
        }

        return true;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {

        MaterialDefinition mainMaterial = getMaterial(inv, MAIN_SLOT, MAIN_FORM);
        MaterialDefinition supportMaterial = getMaterial(inv, SUPPORT_SLOT, SUPPORT_FORM);

        if (mainMaterial == null) {
            mainMaterial = getMaterial(inv, MAIN_SLOT, MaterialForm.ITEM);
        }

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

    private static ItemStack getMainStack(InventoryCrafting inv) {
        return inv.getStackInSlot(MAIN_SLOT);
    }

    private static ItemStack getSupportStack(InventoryCrafting inv) {
        return inv.getStackInSlot(SUPPORT_SLOT);
    }


}
