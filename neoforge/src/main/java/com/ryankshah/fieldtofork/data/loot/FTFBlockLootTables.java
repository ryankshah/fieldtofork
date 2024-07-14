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
        dropSelf(BlockRegistry.PALM_TRAPDOOR.get());
        dropSelf(BlockRegistry.PALM_PLANKS.get());
        dropSelf(BlockRegistry.PALM_DOOR.get());

        add(BlockRegistry.PALM_DOOR.get(), this::createDoorTable);
//        createDoorTable(BlockRegistry.PALM_DOOR.get());
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