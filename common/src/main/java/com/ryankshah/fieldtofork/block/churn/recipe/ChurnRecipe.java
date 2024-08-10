package com.ryankshah.fieldtofork.block.churn.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.ryankshah.fieldtofork.registry.RecipeRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SmithingRecipeInput;
import net.minecraft.world.item.crafting.SmithingTransformRecipe;
import net.minecraft.world.level.Level;

import java.util.stream.Stream;

public class ChurnRecipe implements BaseChurnRecipe
{
    final Ingredient ingredient1;
    final Ingredient ingredient2;
    final ItemStack result;

    public ChurnRecipe(Ingredient pTemplate, Ingredient pBase, ItemStack pResult) {
        this.ingredient1 = pTemplate;
        this.ingredient2 = pBase;
        this.result = pResult;
    }

    public boolean matches(ChurnRecipeInput pInput, Level pLevel) {
        return this.ingredient1.test(pInput.input1()) && this.ingredient2.test(pInput.input2());
    }

    public ItemStack assemble(ChurnRecipeInput pInput, HolderLookup.Provider pRegistries) {
        return this.result.copy();
    }

    @Override
    public boolean isIngredient1(ItemStack stack) {
        return this.ingredient1.test(stack);
    }

    @Override
    public boolean isIngredient2(ItemStack stack) {
        return this.ingredient2.test(stack);
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider pRegistries) {
        return this.result;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeRegistry.CHURN_RECIPE_SERIALIZER.get();
    }

    @Override
    public boolean isIncomplete() {
        return Stream.of(this.ingredient1, this.ingredient2).anyMatch(this::hasNoItems);
    }

    public boolean hasNoItems(Ingredient ingredient) {
        ItemStack[] items = ingredient.getItems();
        if (items.length == 0) {
            return true;
        } else if (items.length != 1) {
            return false;
        } else {
            ItemStack item = items[0];
            boolean var10000;
            if (item.getItem() == Items.BARRIER) {
                Component var4 = item.getHoverName();
                if (var4 instanceof MutableComponent) {
                    MutableComponent hoverName = (MutableComponent)var4;
                    if (hoverName.getString().startsWith("Empty Tag: ")) {
                        var10000 = true;
                        return var10000;
                    }
                }
            }

            var10000 = false;
            return var10000;
        }
    }

    public static class Serializer implements RecipeSerializer<ChurnRecipe> {
        private static final MapCodec<ChurnRecipe> CODEC = RecordCodecBuilder.mapCodec(
                p_340782_ -> p_340782_.group(
                                Ingredient.CODEC.fieldOf("ingredient1").forGetter(p_301310_ -> p_301310_.ingredient1),
                                Ingredient.CODEC.fieldOf("ingredient2").forGetter(p_300938_ -> p_300938_.ingredient2),
                                ItemStack.STRICT_CODEC.fieldOf("result").forGetter(p_300935_ -> p_300935_.result)
                        )
                        .apply(p_340782_, ChurnRecipe::new)
        );
        public static final StreamCodec<RegistryFriendlyByteBuf, ChurnRecipe> STREAM_CODEC = StreamCodec.of(
                ChurnRecipe.Serializer::toNetwork, ChurnRecipe.Serializer::fromNetwork
        );

        @Override
        public MapCodec<ChurnRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, ChurnRecipe> streamCodec() {
            return STREAM_CODEC;
        }

        private static ChurnRecipe fromNetwork(RegistryFriendlyByteBuf p_320375_) {
            Ingredient ingredient1 = Ingredient.CONTENTS_STREAM_CODEC.decode(p_320375_);
            Ingredient ingredient2 = Ingredient.CONTENTS_STREAM_CODEC.decode(p_320375_);
            ItemStack itemstack = ItemStack.STREAM_CODEC.decode(p_320375_);
            return new ChurnRecipe(ingredient1, ingredient2, itemstack);
        }

        private static void toNetwork(RegistryFriendlyByteBuf p_320743_, ChurnRecipe p_319840_) {
            Ingredient.CONTENTS_STREAM_CODEC.encode(p_320743_, p_319840_.ingredient1);
            Ingredient.CONTENTS_STREAM_CODEC.encode(p_320743_, p_319840_.ingredient2);
            ItemStack.STREAM_CODEC.encode(p_320743_, p_319840_.result);
        }
    }
}
