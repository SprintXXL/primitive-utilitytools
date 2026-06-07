package com.SprintXXL.primitiveutilitytools.client.handler;

import com.SprintXXL.primitiveutilitytools.client.render.ModelUtilityTool;
import com.SprintXXL.primitiveutilitytools.tools.registry.ModItems;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static com.SprintXXL.primitiveutilitytools.Reference.MODID;

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

    @SubscribeEvent
    public static void onTextureStitch(TextureStitchEvent.Pre event) {

        event.getMap().registerSprite(new ResourceLocation(
                MODID,
                "generated/hammer_primary_iron"
        ));

        event.getMap().registerSprite(new ResourceLocation(
                MODID,
                "generated/hammer_secondary_wood"
        ));
    }

    @SubscribeEvent
    public static void onModelBake(ModelBakeEvent event) {

        replaceUtilityToolModel(event, "hammer");
    }

    private static void replaceUtilityToolModel(ModelBakeEvent event, String modelName) {

        ModelResourceLocation location = new ModelResourceLocation(MODID + ":" + modelName, "inventory");

        IBakedModel model = event.getModelRegistry().getObject(location);

        if (model != null) {
            event.getModelRegistry().putObject(
                    location,
                    new ModelUtilityTool(model, null)
            );
        }
    }
}
