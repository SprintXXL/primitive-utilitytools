package com.SprintXXL.primitiveutilitytools.tools.logic;

import com.SprintXXL.primitiveutilitytools.library.MaterialStats;
import com.SprintXXL.primitiveutilitytools.library.MaterialStatsRegistry;
import com.SprintXXL.primitiveutilitytools.tools.nbt.UtilityToolNBT;
import net.minecraft.item.ItemStack;

public final class UtilityToolCalculator {

    private UtilityToolCalculator() {}

    public static int getDurability(ItemStack stack) {

        String mainID = UtilityToolNBT.getMainMaterial(stack);
        String handleID = UtilityToolNBT.getHandleMaterial(stack);

        MaterialStats mainStats = MaterialStatsRegistry.getStats(mainID);
        MaterialStats handleStats = MaterialStatsRegistry.getStats(handleID);

        if (mainStats == null || handleStats == null) {
            return 1;
        }

        return (int) Math.round(
                mainStats.getDurability()
                * handleStats.getDurabilityMultiplier()
        );
    }
}
