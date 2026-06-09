package com.SprintXXL.primitiveutilitytools.tools.registry;

import com.SprintXXL.primitiveutilitytools.tools.recipes.*;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public final class ModRecipes {

    private ModRecipes(){}

    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        event.getRegistry().registerAll(
                new RecipeCrowbar().setRegistryName(ModItems.CROWBAR.getRegistryName()),
                new RecipeFile().setRegistryName(ModItems.FILE.getRegistryName()),
                new RecipeHammer().setRegistryName(ModItems.HAMMER.getRegistryName()),
                new RecipeKnife().setRegistryName(ModItems.KNIFE.getRegistryName()),
                new RecipeMortar().setRegistryName(ModItems.MORTAR.getRegistryName()),
                new RecipeSaw().setRegistryName(ModItems.SAW.getRegistryName()),
                new RecipeScrewdriver().setRegistryName(ModItems.SCREWDRIVER.getRegistryName()),
                new RecipeWrench().setRegistryName(ModItems.WRENCH.getRegistryName())
        );
    }
}
