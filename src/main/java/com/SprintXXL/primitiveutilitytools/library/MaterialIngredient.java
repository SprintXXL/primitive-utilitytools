package com.SprintXXL.primitiveutilitytools.library;

import net.minecraft.item.Item;

public class MaterialIngredient {

    private final String materialID;
    private final MaterialForm form;
    private final Item item;

    public MaterialIngredient(
            String materialID,
            MaterialForm form,
            Item item
    ) {
        this.materialID = materialID;
        this.form = form;
        this.item = item;
    }

    public String getMaterialID() {
        return materialID;
    }

    public MaterialForm getForm() {
        return form;
    }

    public Item getItem() {
        return item;
    }
}
