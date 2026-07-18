package com.SprintXXL.primitiveutilitytools.tools.registry;

import com.SprintXXL.primitiveutilitytools.tools.items.wrappers.*;
import com.SprintXXL.primitiveutilitytools.tools.tooltype.definitions.ToolTypeIDs;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ModItems {

    public static final Item HAMMER = new ItemHammer();
    public static final Item MORTAR = new ItemMortar();
    public static final Item SAW = new ItemSaw();
    public static final Item SCREWDRIVER = new ItemScrewdriver();
    public static final Item KNIFE = new ItemKnife();
    public static final Item FILE = new ItemFile();
    public static final Item CROWBAR = new ItemCrowbar();
    public static final Item WRENCH = new ItemWrench();

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                HAMMER,
                MORTAR,
                SAW,
                SCREWDRIVER,
                KNIFE,
                FILE,
                CROWBAR,
                WRENCH
        );
    }

    public static Item getToolItem(String id) {

        switch (id) {

            case ToolTypeIDs.HAMMER:
                return HAMMER;
            case ToolTypeIDs.MORTAR:
                return MORTAR;
            case ToolTypeIDs.SAW:
                return SAW;
            case ToolTypeIDs.SCREWDRIVER:
                return SCREWDRIVER;
            case ToolTypeIDs.KNIFE:
                return KNIFE;
            case ToolTypeIDs.FILE:
                return FILE;
            case ToolTypeIDs.CROWBAR:
                return CROWBAR;
            case ToolTypeIDs.WRENCH:
                return WRENCH;

            default:
                return null;
        }
    }
}
