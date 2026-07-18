package com.SprintXXL.primitiveutilitytools.client.handler;

import com.SprintXXL.primitivematter.library.substances.Substance;
import com.SprintXXL.primitiveutilitytools.client.render.ModelUtilityTool;
import com.SprintXXL.primitiveutilitytools.tools.registry.ModItems;
import com.SprintXXL.primitiveutilitytools.tools.tooltype.ToolType;
import com.SprintXXL.primitiveutilitytools.tools.tooltype.registry.ToolTypeRegistry;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
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

        for (ToolType definition : ToolTypeRegistry.getAllToolTypes()) {

            Item item = ModItems.getToolItem(definition.getID());

            if (item == null) {
                continue;
            }

            ModelLoader.setCustomModelResourceLocation(
                    item,
                    0,
                    new ModelResourceLocation(item.getRegistryName(), "inventory")
            );
        }
    }

    @SubscribeEvent
    public static void onTextureStitch(TextureStitchEvent.Pre event) {

        for (ToolType toolType : ToolTypeRegistry.getAllToolTypes()) {

            String toolName = toolType.getID();

            for (Substance material : toolType.getValidMaterials().getMainMaterials()) {
                event.getMap().registerSprite(
                        new ResourceLocation(
                                MODID,
                                "generated/" + toolName + "_main_" + material.getID()
                        )
                );
            }

            if (toolType.getMaterialSlotCount() >= 2) {
                for (Substance material : toolType.getValidMaterials().getSupportMaterials()) {
                    event.getMap().registerSprite(
                            new ResourceLocation(
                                    MODID,
                                    "generated/" + toolName + "_support_" + material.getID()
                            )
                    );
                }
            }
        }
    }

    @SubscribeEvent
    public static void onModelBake(ModelBakeEvent event) {

        for (ToolType toolType : ToolTypeRegistry.getAllToolTypes()) {
            replaceUtilityToolModel(
                    event,
                    toolType.getID()
            );
        }
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
