package com.SprintXXL.primitiveutilitytools.util;

import net.minecraft.inventory.InventoryCrafting;

public final class RecipeHelper {

    private RecipeHelper() {}

    public static boolean matchesCraftMatrix(InventoryCrafting inv) {

        if (inv.getWidth() != 3 || inv.getHeight() != 3) {
            return false;
        }

        return true;
    }
}
