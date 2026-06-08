package com.SprintXXL.primitiveutilitytools.client.render;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.lang3.tuple.Pair;

import javax.vecmath.Matrix4f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ModelUtilityTool implements IBakedModel {

    private static final String[] LAYERS = {
            "support",
            "main"
    };

    private final IBakedModel model;
    private final UtilityToolRenderData data;

    public ModelUtilityTool(IBakedModel model, UtilityToolRenderData data) {

        this.model = model;
        this.data = data;
    }

    @Override
    public boolean isGui3d() {
        return model.isGui3d();
    }

    @Override
    public boolean isBuiltInRenderer() {
        return model.isBuiltInRenderer();
    }

    @Override
    public boolean isAmbientOcclusion() {
        return model.isAmbientOcclusion();
    }

    @Override
    public TextureAtlasSprite getParticleTexture() {
        return model.getParticleTexture();
    }

    @Override
    public ItemOverrideList getOverrides() {
        return new ModelOverrideUtilityTool(model);
    }

    @Override
    public ItemCameraTransforms getItemCameraTransforms() {
        return model.getItemCameraTransforms();
    }

    @Override
    public Pair<? extends IBakedModel, Matrix4f> handlePerspective(ItemCameraTransforms.TransformType cameraTransformType) {
        Pair<? extends IBakedModel, Matrix4f> pair = model.handlePerspective(cameraTransformType);

        return Pair.of(this, pair.getRight());
    }

    @Override
    public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand) {

        if (data == null) {
            return model.getQuads(state, side, rand);
        }

        if (side != null) {
            return Collections.emptyList();
        }

        List<BakedQuad> quads = new ArrayList<>();

        if (data.materialSlotCount >= 2) {
            addLayer(quads, "support");
        }

        addLayer(quads, "main");

        return quads;
    }

    private void addLayer(List<BakedQuad> quads, String layerType) {

        ResourceLocation texture = UtilityToolTextureResolver.getUtilityToolTexture(data, layerType);

        TextureAtlasSprite sprite = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(texture.toString());

        quads.addAll(LayerQuadBuilder.buildLayer(sprite));
    }
}
