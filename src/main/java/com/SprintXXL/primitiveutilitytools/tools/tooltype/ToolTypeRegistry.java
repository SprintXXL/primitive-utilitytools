package com.SprintXXL.primitiveutilitytools.tools.tooltype;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class ToolTypeRegistry {

    private ToolTypeRegistry() {}

    private static final Map<ToolType, ToolTypeDefinition> TOOLTYPES =
            new HashMap<>();

    public static void register(ToolTypeDefinition toolType) {
        TOOLTYPES.put(toolType.getToolType(), toolType);
    }

    public static ToolTypeDefinition getToolType(ToolType toolType) {
        return TOOLTYPES.get(toolType);
    }

    public static Collection<ToolTypeDefinition> getAllToolTypes() {
        return TOOLTYPES.values();
    }

    public static boolean contains(ToolType toolType) {
        return TOOLTYPES.containsKey(toolType);
    }

    public static void init() {

        ModToolTypes.registerToolTypes();
    }
}
