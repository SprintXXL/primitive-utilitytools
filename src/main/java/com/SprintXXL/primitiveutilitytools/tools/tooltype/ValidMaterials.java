package com.SprintXXL.primitiveutilitytools.tools.tooltype;

import com.SprintXXL.primitivematter.library.substances.Substance;

import java.util.Set;

public class ValidMaterials {

    private final Set<Substance> mainMaterials;
    private final Set<Substance> supportMaterials;

    public ValidMaterials(
            Set<Substance> mainMaterials,
            Set<Substance> supportMaterials
    ) {
        this.mainMaterials = mainMaterials;
        this.supportMaterials = supportMaterials;
    }

    public Set<Substance> getMainMaterials() {
        return mainMaterials;
    }

    public Set<Substance> getSupportMaterials() {
        return supportMaterials;
    }

    public boolean isValidMainMaterial(Substance material) {
        return mainMaterials.contains(material);
    }

    public boolean isValidSupportMaterial(Substance material) {
        return supportMaterials.contains(material);
    }
}
