package com.SprintXXL.primitiveutilitytools.tools.items;

import com.SprintXXL.primitiveutilitytools.tools.tooltype.ToolType;
import com.SprintXXL.primitiveutilitytools.tools.logic.UtilityToolCalculator;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

import static com.SprintXXL.primitiveutilitytools.Reference.MODID;

public class UtilityToolBase extends Item {

    private final ToolType toolType;

    public UtilityToolBase(String name, ToolType toolType) {

        setRegistryName(MODID, name);
        setTranslationKey(MODID + "." + name);
        setCreativeTab(CreativeTabs.TOOLS);
        setMaxStackSize(1);
        setMaxDamage(1);

        this.toolType = toolType;
    }

    public ToolType getToolType() {
        return toolType;
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        return UtilityToolCalculator.getDurability(stack);
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {

        int maxDurability = getMaxDamage(stack);
        int remainingDurability = maxDurability - stack.getItemDamage();

        tooltip.add("Durability: " + remainingDurability + " / " + maxDurability);
    }
}
