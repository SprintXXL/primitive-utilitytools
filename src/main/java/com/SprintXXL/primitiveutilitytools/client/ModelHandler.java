package com.SprintXXL.primitiveutilitytools.client;

import com.SprintXXL.primitiveutilitytools.tools.registry.ModItems;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ModelHandler {

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {

        ModelLoader.setCustomModelResourceLocation(
                ModItems.HAMMER,
                0,
                new ModelResourceLocation(ModItems.HAMMER.getRegistryName(), "inventory")
        );
    }
}
