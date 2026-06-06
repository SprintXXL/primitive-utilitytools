package com.SprintXXL.primitiveutilitytools.tools.items;

import com.SprintXXL.primitiveutilitytools.tools.ToolType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import static com.SprintXXL.primitiveutilitytools.Reference.MODID;

public class UtilityToolBase extends Item {

    public UtilityToolBase(String name, ToolType toolType) {

        setRegistryName(MODID, name);
        setTranslationKey(MODID + "." + name);
        setCreativeTab(CreativeTabs.TOOLS);
        setMaxStackSize(1);
    }
}
