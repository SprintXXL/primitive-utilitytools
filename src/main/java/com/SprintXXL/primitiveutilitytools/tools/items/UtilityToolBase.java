package com.SprintXXL.primitiveutilitytools.tools.items;

import com.SprintXXL.ascentmatter.library.substances.Substance;
import com.SprintXXL.primitiveutilitytools.tools.logic.UtilityToolCalculator;
import com.SprintXXL.primitiveutilitytools.tools.nbt.UtilityToolNBT;
import com.SprintXXL.primitiveutilitytools.tools.tooltype.ToolType;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
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

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {

        if (!isInCreativeTab(tab)) {
            return;
        }

        ItemStack stack = new ItemStack(this);

        UtilityToolNBT.setToolType(stack, toolType);

        Substance mainMaterial = toolType
                .getValidMaterials()
                .getMainMaterials()
                .iterator()
                .next();

        UtilityToolNBT.setMainMaterial(stack, mainMaterial.getID());

        if (toolType.getMaterialSlotCount() >= 2) {

            Substance supportMaterial = toolType
                    .getValidMaterials()
                    .getSupportMaterials()
                    .iterator()
                    .next();

            UtilityToolNBT.setSupportMaterial(stack, supportMaterial.getID());
        }

        items.add(stack);
    }
}
