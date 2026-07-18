package com.SprintXXL.primitiveutilitytools.ascent;

import com.SprintXXL.primitiveutilitytools.tools.stats.definitions.ModMaterialStats;
import com.SprintXXL.primitiveutilitytools.tools.tooltype.definitions.ModToolTypes;
import com.sprintxxl.ascenthub.definitions.AscentDefinition;
import com.sprintxxl.ascenthub.definitions.AscentDefinitionProvider;
import com.sprintxxl.ascenthub.definitions.DefinitionRegistrar;

import static com.SprintXXL.primitiveutilitytools.Reference.MODID;
import static com.sprintxxl.ascenthub.definitions.registry.DefinitionProviderRegistry.registerProvider;

public final class UtilityToolsDefinitionProvider implements AscentDefinitionProvider {

    private UtilityToolsDefinitionProvider() {}

    public static void initUtilityToolsDefinitionProvider() {
        registerProvider(MODID, new UtilityToolsDefinitionProvider());
    }

    public void registerDefinitions(DefinitionRegistrar<AscentDefinition> registrar) {

        ModToolTypes.initToolTypeDefinitions(registrar::register);
        ModMaterialStats.initMaterialStatsDefinitions(registrar::register);
    }
}
