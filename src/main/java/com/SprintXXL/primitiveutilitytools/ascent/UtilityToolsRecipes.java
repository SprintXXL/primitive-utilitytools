package com.SprintXXL.primitiveutilitytools.ascent;

import com.SprintXXL.primitiveutilitytools.tools.recipes.*;
import com.sprintxxl.ascentresourcerecipeindex.recipes.AscentRecipeIDs;
import com.sprintxxl.ascentresourcerecipeindex.recipes.shared.Category;
import com.sprintxxl.ascentresourcerecipeindex.recipes.types.custom.CustomRecipe;

import static com.sprintxxl.ascentresourcerecipeindex.recipes.registry.AscentRecipeRegistry.register;

public final class UtilityToolsRecipes {

    private UtilityToolsRecipes() {}

    public static void initUtilityToolsRecipes() {

        register(ASSEMBLE_CROWBAR);
        register(ASSEMBLE_FILE);
        register(ASSEMBLE_HAMMER);
        register(ASSEMBLE_KNIFE);
        register(ASSEMBLE_MORTAR);
        register(ASSEMBLE_SAW);
        register(ASSEMBLE_SCREWDRIVER);
        register(ASSEMBLE_WRENCH);
    }

    public static final CustomRecipe ASSEMBLE_CROWBAR =
            new CustomRecipe(
                    AscentRecipeIDs.UtilityTools.ASSEMBLE_CROWBAR,
                    Category.ASSEMBLY,
                    RecipeCrowbar.class,
                    RecipeCrowbar::new
            );
    public static final CustomRecipe ASSEMBLE_FILE =
            new CustomRecipe(
                    AscentRecipeIDs.UtilityTools.ASSEMBLE_FILE,
                    Category.ASSEMBLY,
                    RecipeFile.class,
                    RecipeFile::new
            );
    public static final CustomRecipe ASSEMBLE_HAMMER =
            new CustomRecipe(
                    AscentRecipeIDs.UtilityTools.ASSEMBLE_HAMMER,
                    Category.ASSEMBLY,
                    RecipeHammer.class,
                    RecipeHammer::new
            );
    public static final CustomRecipe ASSEMBLE_KNIFE =
            new CustomRecipe(
                    AscentRecipeIDs.UtilityTools.ASSEMBLE_KNIFE,
                    Category.ASSEMBLY,
                    RecipeKnife.class,
                    RecipeKnife::new
            );
    public static final CustomRecipe ASSEMBLE_MORTAR =
            new CustomRecipe(
                    AscentRecipeIDs.UtilityTools.ASSEMBLE_MORTAR,
                    Category.ASSEMBLY,
                    RecipeMortar.class,
                    RecipeMortar::new
            );
    public static final CustomRecipe ASSEMBLE_SAW =
            new CustomRecipe(
                    AscentRecipeIDs.UtilityTools.ASSEMBLE_SAW,
                    Category.ASSEMBLY,
                    RecipeSaw.class,
                    RecipeSaw::new
            );
    public static final CustomRecipe ASSEMBLE_SCREWDRIVER =
            new CustomRecipe(
                    AscentRecipeIDs.UtilityTools.ASSEMBLE_SCREWDRIVER,
                    Category.ASSEMBLY,
                    RecipeScrewdriver.class,
                    RecipeScrewdriver::new
            );
    public static final CustomRecipe ASSEMBLE_WRENCH =
            new CustomRecipe(
                    AscentRecipeIDs.UtilityTools.ASSEMBLE_WRENCH,
                    Category.ASSEMBLY,
                    RecipeWrench.class,
                    RecipeWrench::new
            );
}
