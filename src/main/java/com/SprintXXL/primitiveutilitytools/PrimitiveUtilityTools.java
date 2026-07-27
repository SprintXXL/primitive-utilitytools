package com.SprintXXL.primitiveutilitytools;

import com.SprintXXL.primitiveutilitytools.tools.stats.registry.MaterialStatsRegistry;
import com.SprintXXL.primitiveutilitytools.tools.tooltype.registry.ToolTypeRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import static com.SprintXXL.primitiveutilitytools.Reference.*;
import static com.SprintXXL.primitiveutilitytools.ascent.UtilityToolsRecipes.initUtilityToolsRecipes;

@Mod(modid = MODID, name = NAME, version = VERSION)
public class PrimitiveUtilityTools {

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        MaterialStatsRegistry.initMaterialStatsRegistry();
        ToolTypeRegistry.initToolTypeRegistry();

        // ARRI \\
        initUtilityToolsRecipes();
    }
}
