package com.SprintXXL.primitiveutilitytools.tools.items.wrappers;

import com.SprintXXL.primitiveutilitytools.tools.items.UtilityToolBase;
import com.SprintXXL.primitiveutilitytools.tools.tooltype.ToolType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class ItemWrench extends UtilityToolBase {

    public ItemWrench() {
        super("wrench", ToolType.WRENCH);
    }

    @Override
    public boolean doesSneakBypassUse(ItemStack stack, IBlockAccess world, BlockPos pos, EntityPlayer player) {
        return true;
    }
}
