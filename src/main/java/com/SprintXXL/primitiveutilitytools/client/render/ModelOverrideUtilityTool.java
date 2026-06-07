package com.SprintXXL.primitiveutilitytools.client.render;

import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Collections;

public class ModelOverrideUtilityTool extends ItemOverrideList {

    private final IBakedModel model;

    public ModelOverrideUtilityTool(IBakedModel model) {
        super(Collections.emptyList());

        this.model = model;
    }

    @Override
    public IBakedModel handleItemState(IBakedModel model, ItemStack stack, World world, EntityLivingBase entity) {

        UtilityToolRenderData data = UtilityToolRenderResolver.resolve(stack);

        return new ModelUtilityTool(this.model, data);
    }
}
