package com.SprintXXL.primitiveutilitytools.tools.nbt;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public final class UtilityToolNBT {

    private UtilityToolNBT() {}

    public static final String TOOL_NBT = "ToolNBT";
    public static final String TOOL_TYPE = "ToolType";
    public static final String MAIN_MATERIAL = "MainMaterial";
    public static final String HANDLE_MATERIAL = "HandleMaterial";
    public static final String UNKNOWN = "unknown";

    public static NBTTagCompound getOrCreateSubCompound(ItemStack stack, String TOOL_NBT) {
        return stack.getOrCreateSubCompound(TOOL_NBT);
    }

    public static NBTTagCompound getSubCompound(ItemStack stack, String TOOL_NBT) {

        if (stack.isEmpty()) {
            return null;
        }

        return stack.getSubCompound(TOOL_NBT);
    }

    public static void setToolType(ItemStack stack, String toolType) {
        getOrCreateSubCompound(stack, TOOL_NBT).setString(TOOL_TYPE, toolType);
    }

    public static String getToolType(ItemStack stack) {

        NBTTagCompound nbt = getSubCompound(stack, TOOL_NBT);

            if (nbt == null) {
                return UNKNOWN;
            }

            String value = nbt.getString(TOOL_TYPE);

            if (value.isEmpty()) {
                return UNKNOWN;
            }

            return value;
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

    public static void setHandleMaterial(ItemStack stack, String material) {
        getOrCreateSubCompound(stack, TOOL_NBT).setString(HANDLE_MATERIAL, material);
    }

    public static String getHandleMaterial(ItemStack stack) {

        NBTTagCompound nbt = getSubCompound(stack, TOOL_NBT);

        if (nbt == null) {
            return UNKNOWN;
        }

        String value = nbt.getString(HANDLE_MATERIAL);

        if (value.isEmpty()) {
            return UNKNOWN;
        }

        return value;
    }

}
