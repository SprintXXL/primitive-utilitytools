package com.SprintXXL.primitiveutilitytools.tools.logic;

import com.SprintXXL.primitiveutilitytools.tools.stats.data.MainMaterialStats;
import com.SprintXXL.primitiveutilitytools.tools.stats.registry.MaterialStatsRegistry;
import com.SprintXXL.primitiveutilitytools.tools.stats.data.SupportMaterialStats;
import com.SprintXXL.primitiveutilitytools.tools.nbt.UtilityToolNBT;
import net.minecraft.item.ItemStack;

public final class UtilityToolCalculator {

    private UtilityToolCalculator() {}

    public static int getDurability(ItemStack stack) {

        String mainID = UtilityToolNBT.getMainMaterial(stack);
        String supportID = UtilityToolNBT.getSupportMaterial(stack);

        if (!MaterialStatsRegistry.hasStats(mainID)) {
            return 1;
        }

        if (!MaterialStatsRegistry.hasStats(supportID)) {
            return 1;
        }

        MainMaterialStats mainStats = (MainMaterialStats) MaterialStatsRegistry.getData(mainID);
        SupportMaterialStats supportStats = (SupportMaterialStats) MaterialStatsRegistry.getData(supportID);

        if (mainStats == null || supportStats == null) {
            return 1;
        }

        return (int) Math.round(
                mainStats.getDurability()
                * supportStats.getDurabilityMultiplier()
        );
    }
}
