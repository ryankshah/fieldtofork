package com.ryankshah.fieldtofork.registry;

import com.ryankshah.fieldtofork.Constants;
import com.ryankshah.fieldtofork.block.churn.recipe.BaseChurnRecipe;
import com.ryankshah.fieldtofork.block.churn.recipe.ChurnRecipe;
import com.ryankshah.fieldtofork.block.silkworm_habitat.recipe.SilkwormHabitatRecipe;
import com.ryankshah.fieldtofork.registration.RegistrationProvider;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.*;

import java.util.function.Supplier;

public class RecipeRegistry
{
    public static void init() {}

    public static final RegistrationProvider<RecipeType<?>> RECIPE_TYPES = RegistrationProvider.get(Registries.RECIPE_TYPE, Constants.MOD_ID);
    public static final RegistrationProvider<RecipeSerializer<?>> RECIPE_SERIALIZERS = RegistrationProvider.get(Registries.RECIPE_SERIALIZER, Constants.MOD_ID);

    public static final Supplier<RecipeType<ChurnRecipe>> CHURN_RECIPE_TYPE = RECIPE_TYPES.register("churn", ChurnRecipeType::new);
    public static final Supplier<RecipeSerializer<ChurnRecipe>> CHURN_RECIPE_SERIALIZER = RECIPE_SERIALIZERS.register("churn", ChurnRecipe.Serializer::new);

    public static final Supplier<RecipeType<SilkwormHabitatRecipe>> SILKWORM_HABITAT = RECIPE_TYPES.register("silkworm_habitat", SilkwormHabitatRecipeType::new);
    public static final Supplier<RecipeSerializer<SilkwormHabitatRecipe>> SILKWORM_HABITAT_SERIALIZER = RECIPE_SERIALIZERS.register("silkworm_habitat", () -> new SimpleCookingSerializer<>(SilkwormHabitatRecipe::new, 200));

    static class ChurnRecipeType implements RecipeType<ChurnRecipe> {
        @Override
        public String toString() { return Constants.MOD_ID + ":churn"; }
    }

    static class SilkwormHabitatRecipeType implements RecipeType<SilkwormHabitatRecipe> {
        @Override
        public String toString() { return Constants.MOD_ID + ":silkworm_habitat"; }
    }
}