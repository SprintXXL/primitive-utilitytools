package com.SprintXXL.primitiveutilitytools.tools.tooltype;

import java.util.Set;

public class ValidMaterials {

    private final Set<String> mainMaterials;
    private final Set<String> supportMaterials;

    public ValidMaterials(
            Set<String> mainMaterials,
            Set<String> supportMaterials
    ) {
        this.mainMaterials = mainMaterials;
        this.supportMaterials = supportMaterials;
    }

    public Set<String> getMainMaterials() {
        return mainMaterials;
    }

    public Set<String> getSupportMaterials() {
        return supportMaterials;
    }

    public boolean isValidMainMaterial(String material) {
        return mainMaterials.contains(material);
    }

    public boolean isValidSupportMaterial(String material) {
        return supportMaterials.contains(material);
    }
}
