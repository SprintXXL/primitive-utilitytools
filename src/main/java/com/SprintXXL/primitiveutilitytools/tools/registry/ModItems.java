package com.SprintXXL.primitiveutilitytools.tools.registry;

import com.SprintXXL.primitiveutilitytools.tools.items.wrappers.ItemHammer;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ModItems {

    public static final Item HAMMER = new ItemHammer();

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                HAMMER
        );
    }
}
