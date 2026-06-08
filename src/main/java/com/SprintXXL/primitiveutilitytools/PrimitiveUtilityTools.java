package com.SprintXXL.primitiveutilitytools;

import com.SprintXXL.primitiveutilitytools.tools.stats.MaterialStatsRegistry;
import com.SprintXXL.primitiveutilitytools.tools.tooltype.ToolTypeRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import static com.SprintXXL.primitiveutilitytools.Reference.*;

@Mod(modid = MODID, name = NAME, version = VERSION)
public class PrimitiveUtilityTools {

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        MaterialStatsRegistry.init();
        ToolTypeRegistry.init();
    }
}
