package com.SprintXXL.primitiveutilitytools;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import com.SprintXXL.primitiveutilitytools.library.MaterialRegistry;

import static com.SprintXXL.primitiveutilitytools.Reference.*;

@Mod(modid = MODID, name = NAME, version = VERSION)
public class PrimitiveUtilityTools {

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        MaterialRegistry.init();

    }
}
