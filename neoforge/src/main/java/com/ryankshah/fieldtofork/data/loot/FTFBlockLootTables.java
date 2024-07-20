package com.ryankshah.fieldtofork.data.loot;

import com.ryankshah.fieldtofork.Constants;
import com.ryankshah.fieldtofork.registry.BlockRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class FTFBlockLootTables extends BlockLootSubProvider
{
    public FTFBlockLootTables(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected void generate() {
//        LootItemCondition.Builder lootitemcondition$builder1 = LootItemBlockStatePropertyCondition.hasBlockStateProperties(BlockRegistry.PINEAPPLE_BLOCK.get())
//                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7));
//        add(BlockRegistry.PINEAPPLE_BLOCK.get(), createCropDrops(BlockRegistry.PINEAPPLE_BLOCK.get(), ItemRegistry.PINEAPPLE.get(), ItemRegistry.PINEAPPLE_SEEDS.get(), lootitemcondition$builder1)
//                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(0.125f, 1.0F)).add(LootItem.lootTableItem(ItemRegistry.GOLDEN_PINEAPPLE.get()))));
        //TODO: Add a chance to get golden pineapple

        dropSelf(BlockRegistry.PALM_LOG.get());
//        add(BlockRegistry.PALM_LEAVES.get(), this::createLeavesDrops);
        dropSelf(BlockRegistry.PALM_LEAVES.get());
        dropSelf(BlockRegistry.DENSE_PALM_LEAVES.get());
        dropSelf(BlockRegistry.PALM_TRAPDOOR.get());
        dropSelf(BlockRegistry.PALM_PLANKS.get());
        add(BlockRegistry.PALM_DOOR.get(), this::createDoorTable);
        add(BlockRegistry.PALM_SLAB.get(), this::createSlabItemTable);
        dropSelf(BlockRegistry.PALM_STAIRS.get());
        dropSelf(BlockRegistry.PALM_FENCE.get());
        dropSelf(BlockRegistry.PALM_FENCE_GATE.get());
        dropSelf(BlockRegistry.PALM_PRESSURE_PLATE.get());
        dropSelf(BlockRegistry.PALM_BUTTON.get());
        dropSelf(BlockRegistry.PALM_SIGN.get());
        dropOther(BlockRegistry.PALM_WALL_SIGN.get(), BlockRegistry.PALM_SIGN.get());
        dropSelf(BlockRegistry.PALM_HANGING_SIGN.get());
        dropOther(BlockRegistry.PALM_WALL_HANGING_SIGN.get(), BlockRegistry.PALM_HANGING_SIGN.get());

        dropSelf(BlockRegistry.BANANA_TREE_LOG.get());
        dropSelf(BlockRegistry.BANANA_TREE_PLANKS.get());

        dropSelf(BlockRegistry.DRAGONFRUIT_TREE_LOG.get());
        dropSelf(BlockRegistry.DRAGONFRUIT_TREE_PLANKS.get());

        dropSelf(BlockRegistry.LYCHEE_TREE_LOG.get());
        dropSelf(BlockRegistry.LYCHEE_TREE_PLANKS.get());

        dropSelf(BlockRegistry.MANGO_LOG.get());
        dropSelf(BlockRegistry.MANGO_PLANKS.get());

        dropSelf(BlockRegistry.ORANGE_LOG.get());
        dropSelf(BlockRegistry.ORANGE_PLANKS.get());

        dropSelf(BlockRegistry.PEAR_LOG.get());
        dropSelf(BlockRegistry.PEAR_PLANKS.get());

        dropSelf(BlockRegistry.POMEGRANATE_LOG.get());
        dropSelf(BlockRegistry.POMEGRANATE_PLANKS.get());
    }

    @Override
    public @NotNull Iterable<Block> getKnownBlocks() {
        return BuiltInRegistries.BLOCK.stream()
                .filter(block -> Optional.of(BuiltInRegistries.BLOCK.getKey(block))
                        .filter(key -> key.getNamespace().equals(Constants.MOD_ID))
                        .isPresent())
                .collect(Collectors.toSet());
    }
}