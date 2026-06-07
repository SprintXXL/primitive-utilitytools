package com.SprintXXL.primitiveutilitytools.tools.registry;

import com.SprintXXL.primitiveutilitytools.tools.recipes.RecipeHammer;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static com.SprintXXL.primitiveutilitytools.Reference.MODID;

@Mod.EventBusSubscriber
public final class ModRecipes {

    private ModRecipes(){}

    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        event.getRegistry().registerAll(
                new RecipeHammer().setRegistryName(MODID, "hammer")
        );
    }
}
