package com.SprintXXL.primitiveutilitytools.tools.tooltype.registry;

import com.SprintXXL.primitiveutilitytools.tools.tooltype.ToolType;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static com.SprintXXL.primitiveutilitytools.tools.tooltype.definitions.ModToolTypes.initToolTypeDefinitions;

public final class ToolTypeRegistry {

    private ToolTypeRegistry() {}

    private static final Map<String, ToolType> TOOLTYPES = new HashMap<>();

    public static void register(ToolType toolType) {
        TOOLTYPES.put(toolType.getID(), toolType);
    }

    public static ToolType getToolType(String id) {
        return TOOLTYPES.get(id);
    }

    public static Collection<ToolType> getAllToolTypes() {
        return TOOLTYPES.values();
    }

    public static boolean contains(String id) {
        return TOOLTYPES.containsKey(id);
    }

    public static void initToolTypeRegistry() {

        initToolTypeDefinitions(ToolTypeRegistry::register);
    }
}
