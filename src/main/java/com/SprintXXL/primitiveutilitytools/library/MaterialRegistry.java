package com.SprintXXL.primitiveutilitytools.library;

import net.minecraft.item.ItemStack;

import java.util.*;

public final class MaterialRegistry {

    private MaterialRegistry() {}

    private static final Map<String, MaterialDefinition> MATERIALS =
            new HashMap<>();

    private static final List<MaterialDefinition> ALL_MATERIALS =
            new ArrayList<>();

    public static List<MaterialDefinition> getAllMaterials() {
        return Collections.unmodifiableList(ALL_MATERIALS);
    }

    public static MaterialDefinition getMaterial(String id) {
        return MATERIALS.get(id);
    }

    public static void register(MaterialDefinition material) {
        MATERIALS.put(material.getID(), material);
        ALL_MATERIALS.add(material);
    }

    public static MaterialDefinition getMaterialFromStack(ItemStack stack) {

        if (stack.isEmpty()) {
            return null;
        }

        for (MaterialDefinition material : MaterialRegistry.getAllMaterials()) {
            if (stack.getItem() == material.getRecipeItem()) {
                return material;
            }
        }

        return null;
    }

    public static final List<MaterialIngredient> ALL_INGREDIENTS =
            new ArrayList<>();

    public static void registerIngredient(MaterialIngredient ingredient) {
        ALL_INGREDIENTS.add(ingredient);
    }

    public static void init() {

        register(ModMaterials.IRON);

        registerIngredient(new MaterialIngredient(
                MaterialIDs.IRON,
                MaterialForm.INGOT,
                com.SprintXXL.primitivematerials.library.MaterialRegistry.getItem(MaterialForm.INGOT, ModMaterials.IRON)
        ))
    }

    private static String getMaterialRegistry() {
        return "com.SprintXXL.primitivematerials.library.MaterialRegistry";
    }
}
