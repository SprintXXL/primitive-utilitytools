package com.SprintXXL.primitiveutilitytools.tools.nbt;

import com.SprintXXL.primitiveutilitytools.tools.tooltype.ToolType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public final class UtilityToolNBT {

    private UtilityToolNBT() {}

    public static final String TOOL_NBT = "ToolNBT";
    public static final String TOOL_TYPE = "ToolType";
    public static final String MAIN_MATERIAL = "MainMaterial";
    public static final String SUPPORT_MATERIAL = "SupportMaterial";
    public static final String UNKNOWN = "unknown";

    public static NBTTagCompound getOrCreateSubCompound(ItemStack stack, String compoundKey) {
        return stack.getOrCreateSubCompound(compoundKey);
    }

    public static NBTTagCompound getSubCompound(ItemStack stack, String compoundKey) {

        if (stack.isEmpty()) {
            return null;
        }

        return stack.getSubCompound(compoundKey);
    }

    public static void setToolType(ItemStack stack, ToolType toolType) {

        NBTTagCompound tag = stack.getOrCreateSubCompound(TOOL_NBT);

        tag.setString(TOOL_TYPE, toolType.name());
    }

    public static ToolType getToolType(ItemStack stack) {

        if (!stack.hasTagCompound()) {
            return ToolType.UNKNOWN;
        }

        NBTTagCompound tag = stack.getSubCompound(TOOL_NBT);

        if (tag == null || !tag.hasKey(TOOL_TYPE)) {
            return ToolType.UNKNOWN;
        }

        try {
            return ToolType.valueOf(tag.getString(TOOL_TYPE));
        } catch (IllegalArgumentException e) {
            return ToolType.UNKNOWN;
        }
    }

    public static void setMainMaterial(ItemStack stack, String material) {
        getOrCreateSubCompound(stack, TOOL_NBT).setString(MAIN_MATERIAL, material);
    }

    public static String getMainMaterial(ItemStack stack) {

        NBTTagCompound nbt = getSubCompound(stack, TOOL_NBT);

        if (nbt == null) {
            return UNKNOWN;
        }

        String value = nbt.getString(MAIN_MATERIAL);

        if (value.isEmpty()) {
            return UNKNOWN;
        }

        return value;
    }

    public static void setSupportMaterial(ItemStack stack, String material) {
        getOrCreateSubCompound(stack, TOOL_NBT).setString(SUPPORT_MATERIAL, material);
    }

    public static String getSupportMaterial(ItemStack stack) {

        NBTTagCompound nbt = getSubCompound(stack, TOOL_NBT);

        if (nbt == null) {
            return UNKNOWN;
        }

        String value = nbt.getString(SUPPORT_MATERIAL);

        if (value.isEmpty()) {
            return UNKNOWN;
        }

        return value;
    }

}
